package ultratech.common.blocks;
import java.util.Random;

import ultratech.common.mod_Ultratech;
import ultratech.common.tileentities.TileMatterBuilder;
import net.minecraft.src.*;

public class BlockMatterBuilder extends BlockContainer
{
	public BlockMatterBuilder(int blockId, int index)
	{
		super(blockId, index, Material.rock);
		setBlockName("matterbuilder");
		setCreativeTab(mod_Ultratech.tabElements);
	}
	
	@Override
	public int getBlockTextureFromSide(int par1)
	{
		if(par1 == 0)
		{
			return 27;
		}
		if(par1 == 1)
		{
			return 28;
		}
		if(par1 == 2 || par1 == 3)
		{
			return 29;
		}
		if(par1 == 4 || par1 == 5)
		{
			return 30;
		}
		
		return 0;
	}

	// @param World, the world instance,
	// @param int x, y, z, the blocks x, y, and z coords
	// @param EntityPlayer, the player
	// @param int i, this is not really used in this along with the rest (float f, float g, and float t)
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if(tile_entity == null || player.isSneaking())
		{
			return false;
		}
		// opens the UI if the later is not met, the method player.openGui() has 6 params
		// @param TutorialMod.instance, is just the instance of the TutorialMod
		// @param 0, this is the UI id, this can be changed in the GUI handler, and will open a different UI if chosen to do so
		// @param x, y, z, the players current player x, y, z coords
		player.openGui(mod_Ultratech.instance, 0, world, x, y, z);
		// Returns true to force an update
		return true;
	}

	// Required method from BlockContainer has 6 params
	// @param World, just the standard world instance
	// @param int x, y, z, just the blocks x, y, and z coords
	// @param i, and j, this is not neaded here so Im not going to cover them
	@Override
	public void breakBlock(World world, int x, int y, int z, int i, int j){
		// Calls a method that will created below, this method can be made up here but it can be sometimes more readable if you do it this way
		dropItems(world, x, y, z);
		// Supering the breakBlock() method, this is so it pregforms the action
		super.breakBlock(world, x, y, z, i, j);
	}

	// Just a method to drop the items when the block is broken, it has 4 params
	// @param World, just the standared world instance,
	// @param int x, y, z, the blocks x, y, z coords
	// Although this method can be required if chosen to I will not be going into it because its not what this tutorial is about,
	// And its also a long method, if you want to make this method, you are allowed to copy the code and use it or do whatever you wish to do with it
	private void dropItems(World world, int x, int y, int z){
		Random rand = new Random();

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if(!(tile_entity instanceof IInventory)){
			return;
		}

		IInventory inventory = (IInventory) tile_entity;

		for(int i = 0; i < inventory.getSizeInventory(); i++){
			ItemStack item = inventory.getStackInSlot(i);

			if(item != null && item.stackSize > 0){
				float rx = rand.nextFloat() * 0.6F + 0.1F;
				float ry = rand.nextFloat() * 0.6F + 0.1F;
				float rz = rand.nextFloat() * 0.6F + 0.1F;

				EntityItem entity_item = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

				if(item.hasTagCompound()){
					entity_item.item.setTagCompound((NBTTagCompound) item.getTagCompound().copy());
				}

				float factor = 0.5F;

				entity_item.motionX = rand.nextGaussian() * factor;
				entity_item.motionY = rand.nextGaussian() * factor + 0.2F;
				entity_item.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entity_item);
				item.stackSize = 0;
			}
		}
	}

	// A required method from BlockContainer
	// Just creates a new TileEntity on the placement of the block
	// Has 1 param
	// @param World, also just the standard world instance
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileMatterBuilder();
	}
	
	@Override
	public String getTextureFile()
	{
		return "/ultratech/common/texturess/ultratechBlocks.png";
	}
}
