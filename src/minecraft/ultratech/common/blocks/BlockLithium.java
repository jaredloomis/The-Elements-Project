package ultratech.common.blocks;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import ultratech.api.BlockUT;
import ultratech.client.BaseConfigure;

public class BlockLithium extends BlockUT
{
	public BlockLithium(int id, int index) 
	{
		super(id, index, Material.iron);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) 
	{
		super.react(world, x, y, z, BaseConfigure.lithiumID, null);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID) 
	{
		super.react(world, x, y, z, BaseConfigure.lithiumID, null);
	}
}
