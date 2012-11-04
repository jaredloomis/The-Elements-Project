package ultratech.common.blocks;
import java.util.Arrays;
import java.util.LinkedList;
import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import ultratech.api.BlockUTGas;
import ultratech.client.BaseConfigure;
import ultratech.common.mod_Ultratech;
import ultratech.common.entities.EntityExplosiveReaction;

public class BlockFluorine extends BlockUTGas
{
	public BlockFluorine(int id, int index) 
	{
		super(id, index, Material.air);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) 
	{
		EntityExplosiveReaction rc = new EntityExplosiveReaction(world, x, y, z, 6);
		super.react(world, x, y, z, BaseConfigure.flourineID, rc);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID) 
	{
		EntityExplosiveReaction rc = new EntityExplosiveReaction(world, x, y, z, 6);
		super.react(world, x, y, z, BaseConfigure.flourineID, rc);
	}
}
