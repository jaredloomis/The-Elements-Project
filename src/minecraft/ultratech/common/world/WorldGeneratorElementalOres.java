package ultratech.common.world;
import java.util.Random;
import ultratech.client.BaseConfigure;
import ultratech.common.mod_Ultratech;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorElementalOres implements IWorldGenerator 
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
		case -1: generateNether(world, random, chunkX*16, chunkZ*16);
		case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		}
	}


	private void generateSurface(World world, Random random, int blockX, int blockZ) 
	{
		for(int i = 0; i < 10; i++)
		{
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(60);
			int Zcoord = blockZ + random.nextInt(16);

			(new WorldGenMinable(BaseConfigure.fluoriteID, 5)).generate(world, random, Xcoord, Ycoord, Zcoord);
		}

		for(int i = 0; i < 18; i++)
		{
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(60);
			int Zcoord = blockZ + random.nextInt(16);

			(new WorldGenMinable(BaseConfigure.berylID, 5)).generate(world, random, Xcoord, Ycoord, Zcoord);
		}

		for(int i = 0; i < 18; i++)
		{
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(60);
			int Zcoord = blockZ + random.nextInt(16);

			(new WorldGenMinable(BaseConfigure.boraxID, 5)).generate(world, random, Xcoord, Ycoord, Zcoord);
		}

		for(int i = 0; i < 10; i++)
		{
			int Xcoord1 = blockX + random.nextInt(16);
			int Ycoord1 = random.nextInt(150);
			int Zcoord1 = blockZ + random.nextInt(16);
			
			(new WorldGenBrinePool()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
		}
		
		for(int i = 0; i < 18; i++)
		{
			int Xcoord1 = blockX + random.nextInt(16);
			int Ycoord1 = random.nextInt(150);
			int Zcoord1 = blockZ + random.nextInt(16);
			
			(new WorldGenMinable(BaseConfigure.saltID, 5)).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
		}
		
		for(int i = 0; i < 22; i++)
		{
			int Xcoord1 = blockX + random.nextInt(16);
			int Ycoord1 = random.nextInt(150);
			int Zcoord1 = blockZ + random.nextInt(16);
			
			(new WorldGenMinable(BaseConfigure.bruciteID, 5)).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
		}
		
		for(int i = 0; i < 22; i++)
		{
			int Xcoord1 = blockX + random.nextInt(16);
			int Ycoord1 = random.nextInt(150);
			int Zcoord1 = blockZ + random.nextInt(16);
			
			(new WorldGenMinable(BaseConfigure.alOreID, 5)).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
		}
	}

	private void generateNether(World world, Random random, int blockX, int blockZ) 
	{

	}

}
