package ultratech.common.tileentities;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import ultratech.api.TileMachineUT;
import ultratech.api.matter.AtomLibrary;
import ultratech.common.RegisterItems;
import universalelectricity.core.implement.IElectricityProducer;
import universalelectricity.prefab.tile.TileEntityElectricityReceiver;

public class TileCollider extends TileEntityElectricityReceiver implements IInventory
{	
	private ItemStack[] inventory;
	public boolean canChangeinv;
	public boolean isPowered;

	public TileCollider()
	{
		inventory = new ItemStack[8];
		canChangeinv = true;
		isPowered = false;
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
		return "TileEntityCollider";
	}
	
	
	@Override
	public void updateEntity()
	{
		if(isPowered)
		{
			AtomLibrary al = new AtomLibrary();
			boolean go;

			for(int y = 0; y < 118; y++)
			{	
				if(this.getStackInSlot(0) != null)
				{
					if(this.getStackInSlot(0).getItem().shiftedIndex == al.getProductAtRow(y).blockID)
					{
						if(this.getStackInSlot(1) == null && this.getStackInSlot(2) == null && this.getStackInSlot(3) == null)
						{
							this.setInventorySlotContents(1, new ItemStack(RegisterItems.proton, al.getAmountAtRow(y)[0]));
							this.setInventorySlotContents(2, new ItemStack(RegisterItems.nuetron, al.getAmountAtRow(y)[1]));
							this.setInventorySlotContents(3, new ItemStack(RegisterItems.electron, al.getAmountAtRow(y)[2]));

							this.decrStackSize(0, 1);
							go = true;
							break;
						}
					}
				}

				if(this.getStackInSlot(1) != null || this.getStackInSlot(2) != null || this.getStackInSlot(3) != null)
				{
					break;
				}


				this.setInventorySlotContents(1, null);
				this.setInventorySlotContents(2, null);
				this.setInventorySlotContents(3, null);
			}
			
			isPowered = false;
			super.updateEntity();
		}
	}

	@Override
	public void onReceive(TileEntity sender, double amps, double voltage, ForgeDirection side) 
	{
		if(voltage > wattRequest())
		{
			isPowered = true;
		}
		else
		{
			isPowered = false;
		}
	}

	@Override
	public double wattRequest() 
	{
		return 110;
	}

	@Override
	public boolean canReceiveFromSide(ForgeDirection side) 
	{
		return true;
	}
}
