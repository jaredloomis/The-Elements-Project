package ultratech.common.world;
import java.util.Random;
import ultratech.client.BaseConfigure;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenBrinePool extends WorldGenerator
{
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) 
	{
		boolean canGen = false;

		if(world.getBlockId(x, y, z) == Block.grass.blockID || world.getBlockId(x, y, z) == Block.dirt.blockID || world.getBlockId(x, y, z) == Block.sand.blockID)
		{
			if(world.getBlockId(x, y+1, z) == 0 && world.getBlockId(x+1, y+1, z) == 0 && world.getBlockId(x+2, y+1, z) == 0 && world.getBlockId(x+3, y+1, z) == 0)
			{
				if(world.getBlockId(x+4, y+1, z) == 0 && world.getBlockId(x+5, y+1, z) == 0 && world.getBlockId(x+6, y+1, z) == 0 && world.getBlockId(x+7, y+1, z) == 0)
				{
						canGen = true;
				}
			}
		}

		if(canGen)
		{
			for(int x1 = 0; x1 < 8; x1++)
			{
				for(int z1 = 0; z1 < 10; z1++)
				{
					world.setBlock(x + x1, y, z + z1, BaseConfigure.brineID);
				}
			}

			for(int x1 = 0; x1 < 4; x1++)
			{
				for(int z1 = 0; z1 < 6; z1++)
				{
					world.setBlock(x + x1 + 2, y, z + z1 + 2, Block.waterStill.blockID);
					world.setBlock(x + x1 + 2, y - 1, z + z1 + 2, BaseConfigure.brineID);
				}
			}

			for(int x1 = 0; x1 < 1; x1++)
			{
				for(int z1 = 0; z1 < 2; z1++)
				{
					world.setBlock(x + x1 + 4, y - 1, z + z1 + 3, Block.waterStill.blockID);
					world.setBlock(x + x1 + 4, y - 2, z + z1 + 3, BaseConfigure.brineID);
				}
			}

			return true;
		}
		
		return false;
	}
}
