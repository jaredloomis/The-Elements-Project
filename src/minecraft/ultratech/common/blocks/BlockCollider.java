package ultratech.common.blocks;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import ultratech.api.BlockMachineUT;
import ultratech.common.mod_Ultratech;
import ultratech.common.tileentities.TileCollider;

public class BlockCollider extends BlockMachineUT
{
	public BlockCollider(int blockId, int index) 
	{
		super("collider", blockId, index, 1);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileCollider();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if(tile_entity == null || player.isSneaking())
		{
			return false;
		}

		player.openGui(mod_Ultratech.instance, 1, world, x, y, z);
		
		return true;
	}

}