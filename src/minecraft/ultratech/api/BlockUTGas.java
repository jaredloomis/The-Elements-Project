package ultratech.api;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.EntityFallingSand;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MapColor;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockUTGas extends BlockUT
{	
	public BlockUTGas(int id, int index, Material material) 
	{
		super(id, index, material);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return null;
	}
	
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }


	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{	
		updatePosition(world, x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID)
	{
		updatePosition(world, x, y, z);
	}
	
	
	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
	{
		return new ArrayList();
	}

	public void updatePosition(World world, int x, int y, int z)
	{
		if(world.getBlockId(x, y + 1, z) == 0)
		{
			world.setBlockWithNotify(x, y, z, 0);
			world.setBlockWithNotify(x, y + 1, z, this.blockID);
		}
		
		if(y > 250)
		{
			world.setBlockWithNotify(x, y, z, 0);
		}
	}
}
