package ultratech.common.blocks;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import ultratech.api.BlockUTGas;

public class BlockNeon extends BlockUTGas
{
	public BlockNeon(int id, int index) 
	{
		super(id, index, Material.air);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);

		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID)
	{
		super.updatePosition(world, x, y, z);
	}
}
