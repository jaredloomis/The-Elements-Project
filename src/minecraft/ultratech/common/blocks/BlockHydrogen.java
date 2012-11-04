package ultratech.common.blocks;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import ultratech.api.BlockUTGas;
import ultratech.client.BaseConfigure;
import ultratech.common.mod_Ultratech;

public class BlockHydrogen extends BlockUTGas
{	
	public BlockHydrogen(int id, int index) 
	{
		super(id, index, Material.air);
		setBurnProperties(this.blockID, 100, 20);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID) 
	{
		super.updatePosition(world, x, y, z);
		//super.reactBetter(world, x, y, z, BaseConfigure.hydrogenID, null);
		super.react(world, x, y, z, BaseConfigure.hydrogenID, null);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) 
	{
		super.updatePosition(world, x, y, z);
		//super.reactBetter(world, x, y, z, BaseConfigure.hydrogenID, null);
		super.react(world, x, y, z, BaseConfigure.hydrogenID, null);
	}
}
