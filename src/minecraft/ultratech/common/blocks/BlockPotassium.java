package ultratech.common.blocks;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import ultratech.api.BlockUT;
import ultratech.client.BaseConfigure;
import ultratech.common.entities.EntityExplosiveReaction;

public class BlockPotassium extends BlockUT
{
	public BlockPotassium(int id, int index) 
	{
		super(id, index, Material.iron);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) 
	{
		EntityExplosiveReaction rc = new EntityExplosiveReaction(world, x, y, z, 5);
		super.react(world, x, y, z, BaseConfigure.potassiumID, rc);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID) 
	{
		EntityExplosiveReaction rc = new EntityExplosiveReaction(world, x, y, z, 5);
		super.react(world, x, y, z, BaseConfigure.potassiumID, rc);
	}
}
