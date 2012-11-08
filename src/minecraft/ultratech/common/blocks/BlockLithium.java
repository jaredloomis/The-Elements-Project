package ultratech.common.blocks;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import ultratech.api.BlockUT;
import ultratech.client.BaseConfigure;
import ultratech.common.entities.EntityExplosiveReaction;

public class BlockLithium extends BlockUT
{
	public BlockLithium(int id, int index) 
	{
		super(id, index, Material.iron);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) 
	{
		EntityExplosiveReaction rc = new EntityExplosiveReaction(world, x, y, z, 3);
		super.react(world, x, y, z, BaseConfigure.lithiumID, rc);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID) 
	{
		EntityExplosiveReaction rc = new EntityExplosiveReaction(world, x, y, z, 3);
		super.react(world, x, y, z, BaseConfigure.lithiumID, rc);
	}
}
