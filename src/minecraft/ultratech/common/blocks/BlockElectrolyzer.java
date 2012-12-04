package ultratech.common.blocks;

import java.util.Random;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

import net.minecraft.src.Block;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import ultratech.api.BlockMachineUT;
import ultratech.common.mod_Ultratech;
import ultratech.common.tileentities.TileElectrolyzer;

public class BlockElectrolyzer extends BlockMachineUT
{
	public BlockElectrolyzer(String name, int blockId, int index) 
	{
		super(blockId, index);
		setCreativeTab(mod_Ultratech.tabElements);
	}

	@Override
	public int getBlockTextureFromSide(int par1)
	{	
		if(par1 == 0)
		{
			return 23;
		}
		if(par1 == 1)
		{
			return 22;
		}
		if(par1 == 2 || par1 == 3)
		{
			return 21;
		}
		if(par1 == 4 || par1 == 5)
		{
			return 20;
		}
		
		return 0;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, int i, int j)
	{
		dropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, i, j);
	}

	private void dropItems(World world, int x, int y, int z)
	{
		Random rand = new Random();

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if(!(tile_entity instanceof IInventory))
		{
			return;
		}

		IInventory inventory = (IInventory) tile_entity;

		for(int i = 0; i < inventory.getSizeInventory(); i++)
		{
			ItemStack item = inventory.getStackInSlot(i);

			if(item != null && item.stackSize > 0)
			{
				float rx = rand.nextFloat() * 0.6F + 0.1F;
				float ry = rand.nextFloat() * 0.6F + 0.1F;
				float rz = rand.nextFloat() * 0.6F + 0.1F;

				EntityItem entity_item = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

				if(item.hasTagCompound())
				{
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

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if(tile_entity == null || player.isSneaking())
		{
			return false;
		}

		player.openGui(mod_Ultratech.instance, 2, world, x, y, z);

		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
		return new TileElectrolyzer();
	}
}