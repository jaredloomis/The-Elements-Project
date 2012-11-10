package ultratech.common.tileentities;
import java.util.ArrayList;
import java.util.List;

import buildcraft.api.power.IPowerProvider;
import buildcraft.api.power.IPowerReceptor;

import ultratech.api.matter.AtomLibrary;
import ultratech.client.BaseConfigure;
import ultratech.common.RegisterItems;
import universalelectricity.implement.IElectricityReceiver;

import net.minecraft.src.*;
import net.minecraftforge.common.ForgeDirection;

public class TileMatterBuilder extends TileEntity implements IInventory
{
	private ItemStack[] inventory;

	public boolean canChangeinv;

	public TileMatterBuilder()
	{
		inventory = new ItemStack[10];
		canChangeinv = true;
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
		//This checks to make sure the stack is not nothing, and then makes sure the stack is not going over the limit
		//Of the stack
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
			//Then it checks to make sure that it has something that is equal or lesser than the amount you want to add
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

	//This returns the stack in the slot you chose
	//It has 1 param
	//@param int slotIndex this is the slot number you choose to get
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

	//Basically this makes sure the player is not to far away to activate the block and, makes sure its the Entity you are
	//Selecting
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
		return "TileEntityMatterBuilder";
	}

	@Override
	public void onInventoryChanged()
	{
		super.onInventoryChanged();

		boolean go = true;
		AtomLibrary al = new AtomLibrary();
		//al.visualize(10);

		if(this.getStackInSlot(0) != null && this.getStackInSlot(1) != null && this.getStackInSlot(2) != null)
		{
			/*Checks if the things in slots are protons, neutrons, and electrons*/
			if(this.getStackInSlot(0).getItem() == RegisterItems.proton)
			{
				if(this.getStackInSlot(1).getItem() == RegisterItems.nuetron)
				{
					if(this.getStackInSlot(2).getItem() == RegisterItems.electron)
					{
						/*Loops through formulas to see if it should make an element*/
						for(int y = 0; y < 118; y++)
						{
							if(this.getStackInSlot(0).stackSize == al.getAmountAtRow(y)[0] && this.getStackInSlot(1).stackSize == al.getAmountAtRow(y)[1] && this.getStackInSlot(2).stackSize == al.getAmountAtRow(y)[2])
							{
								if(this.getStackInSlot(3) == null)
								{
									if(go)
									{
										this.setInventorySlotContents(3, new ItemStack(al.getProductAtRow(y)));

										this.setInventorySlotContents(0, null);
										this.setInventorySlotContents(1, null);
										this.setInventorySlotContents(2, null);
										
										go = false;
										break;
									}
								}
							}

							this.setInventorySlotContents(3, null);
						}
					}
				}
			}
		}
	}
}
