package ultratech.common.blocks;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import ultratech.api.BlockUTGas;
import ultratech.client.BaseConfigure;

public class BlockOxygen extends BlockUTGas
{
	public BlockOxygen(int id, int index) 
	{
		super(id, index, Material.air);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID) 
	{
		super.updatePosition(world, x, y, z);
		//super.reactBetter(world, x, y, z, BaseConfigure.oxygenID, null);
		super.react(world, x, y, z, BaseConfigure.oxygenID, null);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) 
	{
		super.updatePosition(world, x, y, z);
		//super.reactBetter(world, x, y, z, BaseConfigure.oxygenID, null);
		super.react(world, x, y, z, BaseConfigure.oxygenID, null);
	}
}
