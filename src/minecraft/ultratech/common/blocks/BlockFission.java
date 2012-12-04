package ultratech.common.blocks;
import ultratech.api.BlockMachineUT;
import ultratech.common.mod_Ultratech;
import ultratech.common.tileentities.TileFission;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockFission extends BlockMachineUT
{
	public BlockFission(int blockId, int index) 
	{
		super(blockId, index);
	}

	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
		return new TileFission();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if(tile_entity == null || player.isSneaking())
		{
			return false;
		}

		player.openGui(mod_Ultratech.instance, 3, world, x, y, z);
		
		return true;
	}
}
