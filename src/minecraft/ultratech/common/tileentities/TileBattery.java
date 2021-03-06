package ultratech.common.tileentities;
import java.util.List;

import com.google.common.io.ByteArrayDataInput;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Direction;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.INetworkManager;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.Packet;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraft.src.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;
import ultratech.api.electricity.IElectricityReciever;
import universalelectricity.core.UniversalElectricity;
import universalelectricity.core.electricity.ElectricInfo;
import universalelectricity.core.electricity.ElectricityManager;
import universalelectricity.core.electricity.ElectricityNetwork;
import universalelectricity.core.implement.IConductor;
import universalelectricity.core.implement.IElectricityProducer;
import universalelectricity.core.implement.IElectricityReceiver;
import universalelectricity.core.implement.IItemElectric;
import universalelectricity.core.implement.IJouleStorage;
import universalelectricity.core.vector.Vector3;
import universalelectricity.prefab.implement.IRedstoneProvider;
import universalelectricity.prefab.network.IPacketReceiver;
import universalelectricity.prefab.network.PacketManager;
import universalelectricity.prefab.tile.TileEntityElectricityReceiver;

public class TileBattery extends TileEntityElectricityReceiver implements IJouleStorage, IPacketReceiver, IRedstoneProvider, IInventory, ISidedInventory
{
	private double joules = 0;
	private ItemStack[] containingItems = new ItemStack[5];
	private boolean isFull = false;
	private int playersUsing = 0;

	public TileBattery()
	{
		super();
	}

	@Override
	public boolean canConnect(ForgeDirection side)
	{
		return true;
	}

	@Override
	public void initiate()
	{
	}

	@Override
	public void updateEntity()
	{
		super.updateEntity();

		if (!this.isDisabled())
		{
			if (!this.worldObj.isRemote)
			{
				ForgeDirection inputDirection = ForgeDirection.getOrientation(this.getBlockMetadata()).getOpposite();
				TileEntity inputTile = Vector3.getTileEntityFromSide(this.worldObj, Vector3.get(this), inputDirection);

				if (inputTile != null)
				{
					if (inputTile instanceof IConductor)
					{
						if (this.joules >= this.getMaxJoules())
						{
							//this.joules = this.getMaxJoules();
						}
						else
						{
							//((IConductor) inputTile).getNetwork().startRequesting(this, this.getMaxJoules() - this.getJoules(), this.getVoltage());
							//((IConductor)inputTile).getNetwork();
							///*this.setJoules(this.joules + */IConductor a = ((IConductor) inputTile);
						}
					}
				}
			}


			/**
			 * Receive Electricity
			 */

			// Power redstone if the battery box is full
			boolean isFullThisCheck = false;

			if (this.joules >= this.getMaxJoules())
			{
				isFullThisCheck = true;
			}

			if (this.isFull != isFullThisCheck)
			{
				this.isFull = isFullThisCheck;
				this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID);
			}

			/**
			 * Output Electricity
			 */

			if (this.joules > 0)
			{
				ForgeDirection outputDirection = ForgeDirection.getOrientation(this.getBlockMetadata());
				TileEntity tileEntity = Vector3.getTileEntityFromSide(this.worldObj, Vector3.get(this), outputDirection);

				if (tileEntity != null)
				{
					TileEntity connector = Vector3.getConnectorFromSide(this.worldObj, Vector3.get(this), outputDirection);

					if (connector instanceof IConductor)
					{
						double joulesNeeded = (ElectricityManager.instance.getElectricityRequired(((IConductor) connector).getNetwork()));
						double transferAmps = Math.max(Math.min(Math.min(ElectricInfo.getAmps(joulesNeeded, this.getVoltage()), ElectricInfo.getAmps(this.joules/20, this.getVoltage())), 80), 0);

						if (!this.worldObj.isRemote && transferAmps > 0)
						{
							ElectricityManager.instance.produceElectricity(this, (IConductor)connector, transferAmps, this.getVoltage());
						}

						this.setJoules(this.joules - ElectricInfo.getJoules(transferAmps, this.getVoltage()));
					}
				}
				/*
				 * else { Vector3 outputPosition = Vector3.get(this);
				 * outputPosition.modifyPositionFromSide(outputDirection);
				 * 
				 * List<Entity> entities = outputPosition.getEntitiesWithin(worldObj, Entity.class);
				 * 
				 * for (Entity entity : entities) { if (entity instanceof IElectricityReceiver) {
				 * IElectricityReceiver electricEntity = ((IElectricityReceiver) entity); double
				 * joulesNeeded = electricEntity.wattRequest(); double transferAmps =
				 * Math.max(Math.min(Math.min(ElectricInfo.getAmps(joulesNeeded, this.getVoltage()),
				 * ElectricInfo.getAmps(this.joules, this.getVoltage())), 80), 0);
				 * ElectricityManager.instance.produceElectricity(this, entity, transferAmps,
				 * this.getVoltage(), outputDirection); this.setJoules(this.joules -
				 * ElectricInfo.getJoules(transferAmps, this.getVoltage())); break; } } }
				 */
			}
		}

		this.setJoules(this.joules - 0.00005);

		if (!this.worldObj.isRemote)
		{
			if (this.ticks % 3 == 0 && this.playersUsing > 0)
			{
				PacketManager.sendPacketToClients(getDescriptionPacket(), this.worldObj, Vector3.get(this), 12);
			}
		}
	}

	@Override
	public Packet getDescriptionPacket()
	{
		return PacketManager.getPacket("Hello", this);
	}

	@Override
	public void handlePacketData(INetworkManager network, int type, Packet250CustomPayload packet, EntityPlayer player, ByteArrayDataInput dataStream)
	{
		try
		{
			this.joules = dataStream.readDouble();
			this.disabledTicks = dataStream.readInt();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void openChest()
	{
		this.playersUsing++;
	}

	@Override
	public void closeChest()
	{
		this.playersUsing--;
	}

	/**
	 * Reads a tile entity from NBT.
	 */
	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readFromNBT(par1NBTTagCompound);
		this.joules = par1NBTTagCompound.getDouble("electricityStored");

		NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
		this.containingItems = new ItemStack[this.getSizeInventory()];

		for (int var3 = 0; var3 < var2.tagCount(); ++var3)
		{
			NBTTagCompound var4 = (NBTTagCompound) var2.tagAt(var3);
			byte var5 = var4.getByte("Slot");

			if (var5 >= 0 && var5 < this.containingItems.length)
			{
				this.containingItems[var5] = ItemStack.loadItemStackFromNBT(var4);
			}
		}
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setDouble("electricityStored", this.joules);
		NBTTagList var2 = new NBTTagList();

		for (int var3 = 0; var3 < this.containingItems.length; ++var3)
		{
			if (this.containingItems[var3] != null)
			{
				NBTTagCompound var4 = new NBTTagCompound();
				var4.setByte("Slot", (byte) var3);
				this.containingItems[var3].writeToNBT(var4);
				var2.appendTag(var4);
			}
		}

		par1NBTTagCompound.setTag("Items", var2);
	}

	@Override
	public int getStartInventorySide(ForgeDirection side)
	{
		if (side == side.DOWN) { return 1; }

		if (side == side.UP) { return 1; }

		return 0;
	}

	@Override
	public int getSizeInventorySide(ForgeDirection side)
	{
		return 1;
	}

	@Override
	public int getSizeInventory()
	{
		return this.containingItems.length;
	}

	@Override
	public ItemStack getStackInSlot(int par1)
	{
		return this.containingItems[par1];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2)
	{
		if (this.containingItems[par1] != null)
		{
			ItemStack var3;

			if (this.containingItems[par1].stackSize <= par2)
			{
				var3 = this.containingItems[par1];
				this.containingItems[par1] = null;
				return var3;
			}
			else
			{
				var3 = this.containingItems[par1].splitStack(par2);

				if (this.containingItems[par1].stackSize == 0)
				{
					this.containingItems[par1] = null;
				}

				return var3;
			}
		}
		else
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1)
	{
		if (this.containingItems[par1] != null)
		{
			ItemStack var2 = this.containingItems[par1];
			this.containingItems[par1] = null;
			return var2;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
	{
		this.containingItems[par1] = par2ItemStack;

		if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
		{
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName()
	{
		return "Battery";
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
	{
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public boolean isPoweringTo(ForgeDirection side)
	{
		return this.isFull;
	}

	@Override
	public boolean isIndirectlyPoweringTo(ForgeDirection side)
	{
		return isPoweringTo(side);
	}

	@Override
	public double getJoules(Object... data)
	{
		return this.joules;
	}

	@Override
	public void setJoules(double joules, Object... data)
	{
		this.joules = Math.max(Math.min(joules, this.getMaxJoules()), 0);
	}

	@Override
	public double getMaxJoules(Object... data)
	{
		return 3000000;
	}

	@Override
	public void onReceive(TileEntity sender, double amps, double voltage, ForgeDirection side) 
	{
		this.joules += amps*voltage*1.8;
	}

	@Override
	public double wattRequest() 
	{
		return 120;
	}

	@Override
	public boolean canReceiveFromSide(ForgeDirection side) 
	{
		if(side == ForgeDirection.getOrientation(this.getBlockMetadata()).getOpposite())
		{
			return true;
		}
		return false;
	}

}