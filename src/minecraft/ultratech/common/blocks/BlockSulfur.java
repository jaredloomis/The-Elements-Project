package ultratech.common.blocks;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import ultratech.api.BlockUT;
import ultratech.client.BaseConfigure;
import ultratech.common.entities.EntityExplosiveReaction;

public class BlockSulfur extends BlockUT
{
	public BlockSulfur(int id, int index) 
	{
		super(id, index, Material.iron);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) 
	{
		super.react(world, x, y, z, BaseConfigure.sulfurID, null);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID) 
	{
		super.react(world, x, y, z, BaseConfigure.sulfurID, null);
	}
}
