package ultratech.common.tileentities;
import ultratech.api.TileMachineUT;
import ultratech.api.matter.AtomLibrary;
import universalelectricity.core.electricity.ElectricityManager;
import universalelectricity.core.implement.IConductor;
import universalelectricity.core.implement.IElectricityProducer;
import universalelectricity.core.vector.Vector3;
import universalelectricity.prefab.implement.IRedstoneProvider;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileFission extends TileEntity implements IInventory, IElectricityProducer
{
	private ItemStack[] inventory;
	IConductor connectedElectricUnit;
	int generateWatts = 120;
	int fissionCounter;
	int fissionTime;

	public TileFission()
	{
		fissionTime = 200;
		fissionCounter = 0;
		inventory = new ItemStack[10];
	}

	@Override
	public void updateEntity()
	{	
		/*Loops through Elements to see if it can Blow it up*/
		for(int y = 0; y < 29; y++)
		{
			if(this.getStackInSlot(0) != null && AtomLibrary.getProductAtRow(y) != null)
			{	
				if(this.getStackInSlot(0).itemID == AtomLibrary.getProductAtRow(y).blockID)
				{	
					fissionCounter++;

					/*Finds Tile Entity to Produce Electricity to*/
					TileEntity tileEntity = Vector3.getConnectorFromSide(this.worldObj, new Vector3(this.xCoord, this.yCoord, this.zCoord), ForgeDirection.getOrientation(this.getBlockMetadata()));

					if (tileEntity instanceof IConductor)
					{	
						if (ElectricityManager.instance.getElectricityRequired(((IConductor) tileEntity).getNetwork()) > 0)
						{
							if(fissionCounter >= fissionTime)
							{
								fissionCounter = 0;

								this.decrStackSize(0, 1);
							}

							this.connectedElectricUnit = (IConductor) tileEntity;
						}
					}
					else
					{
						this.connectedElectricUnit = null;
					}

					/*Produces Electricity to selected Entity*/
					ElectricityManager.instance.produceElectricity(this, this.connectedElectricUnit, (this.generateWatts / this.getVoltage()) / 20, this.getVoltage());
				}
			}
		}
	}

	@Override
	public void onDisable(int duration) 
	{
	}


	@Override
	public boolean isDisabled() 
	{
		return false;
	}


	@Override
	public double getVoltage() 
	{
		return 120;
	}


	@Override
	public boolean canConnect(ForgeDirection side) 
	{
		return true;
	}

	/*
	 * 
	 * Mostly Get Methods
	 * or utilities
	 * 
	 * */
	@Override
	public int getSizeInventory()
	{
		return inventory.length;
	}
	@Override
	public ItemStack getStackInSlot(int slotIndex)
	{
		return inventory[slotIndex];
	}
	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		inventory[slot] = stack;
		if(stack != null && stack.stackSize > getInventoryStackLimit())
		{
			stack.stackSize = getInventoryStackLimit();
		}
	}
	@Override
	public ItemStack decrStackSize(int slotIndex, int amount)
	{
		ItemStack stack = getStackInSlot(slotIndex);

		if(stack != null)
		{
			if(stack.stackSize <= amount)
			{
				setInventorySlotContents(slotIndex, null);
			} 
			else
			{
				stack = stack.splitStack(amount);
				if(stack.stackSize == 0)
				{
					setInventorySlotContents(slotIndex, null);
				}
			}
		}

		return stack;
	}
	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex)
	{
		ItemStack stack = getStackInSlot(slotIndex);

		if(stack != null)
		{
			setInventorySlotContents(slotIndex, null);
		}

		return stack;
	}

	/*
	 * 
	 * Standard, Necessary Methods
	 * 
	 * */
	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}
	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}
	@Override
	public void openChest() {}
	@Override
	public void closeChest() {}
	@Override
	public String getInvName()
	{
		return "Fission";
	}
	@Override
	public void onInventoryChanged()
	{
		super.onInventoryChanged();
	}
	@Override
	public void readFromNBT(NBTTagCompound tagCompound){
		super.readFromNBT(tagCompound);

		NBTTagList tagList = tagCompound.getTagList("Inventory");

		for(int i = 0; i < tagList.tagCount(); i++){
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);

			byte slot = tag.getByte("Slot");

			if(slot >= 0 && slot < inventory.length){
				inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}
	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);

		NBTTagList itemList = new NBTTagList();

		for(int i = 0; i < inventory.length; i++)
		{
			ItemStack stack = inventory[i];

			if(stack != null)
			{
				NBTTagCompound tag = new NBTTagCompound();

				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}

		tagCompound.setTag("Inventory", itemList);
	}
}
