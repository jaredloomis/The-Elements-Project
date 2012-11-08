package ultratech.common.blocks;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import ultratech.api.BlockUT;
import ultratech.client.BaseConfigure;
import ultratech.common.entities.EntityExplosiveReaction;

public class BlockSodium extends BlockUT
{
	public BlockSodium(int id, int index) 
	{
		super(id, index, Material.rock);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) 
	{
		EntityExplosiveReaction rc = new EntityExplosiveReaction(world, x, y, z, 4);
		super.react(world, x, y, z, BaseConfigure.sodiumID, rc);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID) 
	{
		EntityExplosiveReaction rc = new EntityExplosiveReaction(world, x, y, z, 4);
		super.react(world, x, y, z, BaseConfigure.sodiumID, rc);
	}
}
