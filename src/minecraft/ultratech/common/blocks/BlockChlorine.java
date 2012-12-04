package ultratech.common.blocks;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import ultratech.api.BlockUTGas;
import ultratech.client.BaseConfigure;
import ultratech.common.entities.EntityExplosiveReaction;

public class BlockChlorine extends BlockUTGas
{
	public BlockChlorine(int id, int index) 
	{
		super(id, index, Material.air);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) 
	{
		super.react(world, x, y, z, BaseConfigure.chlorineID, null);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID) 
	{
		super.react(world, x, y, z, BaseConfigure.chlorineID, null);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
	{
		entity.attackEntityFrom(DamageSource.cactus, 1);
	}
}
