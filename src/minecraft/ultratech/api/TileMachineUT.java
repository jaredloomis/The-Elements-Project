package ultratech.api;
import java.util.ArrayList;
import java.util.List;
import ultratech.api.matter.AtomLibrary;
import ultratech.client.BaseConfigure;
import ultratech.common.RegisterItems;

import net.minecraft.src.*;
import net.minecraftforge.common.ForgeDirection;

public class TileMachineUT extends TileEntity implements IInventory
{
	private ItemStack[] inventory;

	public TileMachineUT()
	{
		inventory = new ItemStack[10];
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
	public String getInvName()
	{
		return "TileEntityUT";
	}

	@Override
	public void onInventoryChanged()
	{
		super.onInventoryChanged();
	}
}