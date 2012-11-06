package ultratech.common.blocks;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import ultratech.api.BlockUT;
import ultratech.client.BaseConfigure;
import ultratech.common.mod_Ultratech;

public class BlockAirPurifier extends BlockUT
{
	public BlockAirPurifier(int id, int index) 
	{
		super(id, index, Material.air);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{	
		if(world.getBlockId(x+1, y, z) == 0)
		{
			world.setBlockWithNotify(x+1, y, z, BaseConfigure.oxygenID);
		}
		
		if(world.getBlockId(x-1, y, z) == 0)
		{
			world.setBlockWithNotify(x-1, y, z, BaseConfigure.oxygenID);
		}
		
		if(world.getBlockId(x, y+1, z) == 0)
		{
			world.setBlockWithNotify(x, y+1, z, BaseConfigure.oxygenID);
		}
		
		if(world.getBlockId(x, y-1, z) == 0)
		{
			world.setBlockWithNotify(x, y-1, z, BaseConfigure.oxygenID);
		}
		
		if(world.getBlockId(x, y, z+1) == 0)
		{
			world.setBlockWithNotify(x, y, z+1, BaseConfigure.oxygenID);
		}
		
		if(world.getBlockId(x, y, z-1) == 0)
		{
			world.setBlockWithNotify(x+1, y, z-1, BaseConfigure.oxygenID);
		}
		
		return true;
	}
}
