package ultratech.common.tileentities;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFurnace;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.Slot;
import net.minecraft.src.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import ultratech.api.TileMachineUT;
import ultratech.api.matter.MachineRecipeHandler;
import universalelectricity.prefab.tile.TileEntityElectricityReceiver;

public class TileElectrolyzer extends TileEntityElectricityReceiver implements IInventory
{
	public boolean isPowered;
	public int elecTime = 0;
	public int maxTime = 100;
	public int curElecTime;
	private ItemStack[] inventory;

	public TileElectrolyzer()
	{
		elecTime = 0;
		curElecTime = 0;
		inventory = new ItemStack[10];
		isPowered = false;
	}

	@Override
	public void onInventoryChanged()
	{
		super.onInventoryChanged();
	}

	@Override
	public void updateEntity()
	{
		if(isPowered)
		{
			for(int y = 0; y < 30; y++)
			{
				if(MachineRecipeHandler.getElectrolyzerItemStack(0, y) != null && this.getStackInSlot(0) != null)
				{
					if(this.getStackInSlot(0).getItem() == MachineRecipeHandler.getElectrolyzerItemStack(0, y).getItem())
					{	
						elecTime++;

						if(elecTime > 80)
						{
							elecTime = 0;

							if(this.getStackInSlot(1) == null && this.getStackInSlot(2) == null && this.getStackInSlot(3) == null)
							{
								this.decrStackSize(0, 1);

								if(MachineRecipeHandler.getElectrolyzerItemStack(1, y) != null)
								{
									this.setInventorySlotContents(1, MachineRecipeHandler.getElectrolyzerItemStack(1, y));
								}

								if(MachineRecipeHandler.getElectrolyzerItemStack(2, y) != null)
								{
									this.setInventorySlotContents(2, MachineRecipeHandler.getElectrolyzerItemStack(2, y));
								}

								if(MachineRecipeHandler.getElectrolyzerItemStack(3, y) != null)
								{
									this.setInventorySlotContents(3, MachineRecipeHandler.getElectrolyzerItemStack(3, y));
								}

							}
							else
							{
								boolean took = false;

								/*Slot 1*/
								if(this.getStackInSlot(1) != null)
								{
									if(this.getStackInSlot(1) == MachineRecipeHandler.getElectrolyzerItemStack(1, y))
									{
										this.inventory[1].stackSize++;
										took = true;
									}
								}
								else
								{
									this.setInventorySlotContents(1, MachineRecipeHandler.getElectrolyzerItemStack(1, y));
								}

								/*Slot 2*/
								if(this.getStackInSlot(2) != null)
								{
									if(this.getStackInSlot(2) == MachineRecipeHandler.getElectrolyzerItemStack(2, y))
									{
										this.inventory[2].stackSize++;
										took = true;
									}
								}
								else
								{
									this.setInventorySlotContents(2, MachineRecipeHandler.getElectrolyzerItemStack(2, y));
								}

								/*Slot 3*/
								if(this.getStackInSlot(3) != null)
								{
									if(this.getStackInSlot(3) == MachineRecipeHandler.getElectrolyzerItemStack(3, y))
									{
										this.inventory[3].stackSize++;
										took = true;
									}
								}
								else
								{
									this.setInventorySlotContents(3, MachineRecipeHandler.getElectrolyzerItemStack(3, y));
								}

								if(took)
								{
									this.inventory[0].stackSize--;
									took = false;
								}
							}
						}
					}
				}
			}

			isPowered = false;
		}
	}

	public int getElectrolyzedTime()
	{
		return elecTime;
	}


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

	@Override
	public String getInvName()
	{
		return "TileElectrolyzerUT";
	}


	@Override
	public void onReceive(TileEntity sender, double amps, double voltage, ForgeDirection side) 
	{
		//System.out.println("Voltage: " + voltage);

		if(voltage > wattRequest())
		{
			//System.out.println("TRUE");
			isPowered = true;
		}
		else
		{
			//System.out.println("FALSE");
			isPowered = false;
		}
	}

	@Override
	public double wattRequest() 
	{
		if(this.getStackInSlot(0) != null)
		{
			return 110;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public boolean canReceiveFromSide(ForgeDirection side) 
	{
		return true;
	}
}
