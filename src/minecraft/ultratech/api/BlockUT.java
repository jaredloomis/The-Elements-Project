package ultratech.api;
import java.util.ArrayList;
import java.util.List;
import ultratech.api.reaction.ReactionHandler;
import ultratech.common.RegisterBlocks;
import ultratech.common.mod_Ultratech;
import net.minecraft.src.Block;
import net.minecraft.src.BlockBreakable;
import net.minecraft.src.Entity;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockUT extends Block
{
	public BlockUT(int id, int index, Material material) 
	{
		super(id, index, material);
		setCreativeTab(mod_Ultratech.tabElements);
	}

	@Override
	public String getTextureFile()
	{
		return "/ultratech/common/texturess/ultratechBlocks.png";
	}

	public void react(World world, int x, int y, int z, int blockID, Entity explosive)
	{
		List<Integer> reactsWith = (List<Integer>)ReactionHandler.getReactants(blockID);
		int producedBlock;
		
		//UN COMMENT FOR DEBUGGING
		//ReactionHandler.visualizeArray();
		//System.out.println("placed block: " + blockID);

		for(int i = 0; i < reactsWith.size(); i++)
		{
			//DB
			//System.out.println(reactsWith.get(i));

			if(reactsWith.get(i) != -1)
			{
				if(world.getBlockId(x + 1, y, z) == reactsWith.get(i))
				{
					producedBlock = ReactionHandler.getProduct(ReactionHandler.getRowWithTwoReactants(reactsWith.get(i), blockID));
					world.setBlockWithNotify(x, y, z, producedBlock);
					world.setBlockWithNotify(x + 1, y, z, producedBlock);

					if(explosive != null)
					{
						world.spawnEntityInWorld(explosive);
					}
				}

				if(world.getBlockId(x - 1, y, z) == reactsWith.get(i))
				{
					producedBlock = ReactionHandler.getProduct(ReactionHandler.getRowWithTwoReactants(reactsWith.get(i), blockID));
					world.setBlockWithNotify(x, y, z, producedBlock);
					world.setBlockWithNotify(x - 1, y, z, producedBlock);

					if(explosive != null)
					{
						world.spawnEntityInWorld(explosive);
					}
				}

				if(world.getBlockId(x, y + 1, z) == reactsWith.get(i))
				{
					producedBlock = ReactionHandler.getProduct(ReactionHandler.getRowWithTwoReactants(reactsWith.get(i), blockID));
					world.setBlockWithNotify(x, y, z, producedBlock);
					world.setBlockWithNotify(x, y + 1, z, producedBlock);

					if(explosive != null)
					{
						world.spawnEntityInWorld(explosive);
					}
				}

				if(world.getBlockId(x, y - 1, z) == reactsWith.get(i))
				{
					producedBlock = ReactionHandler.getProduct(ReactionHandler.getRowWithTwoReactants(reactsWith.get(i), blockID));
					world.setBlockWithNotify(x, y, z, producedBlock);
					world.setBlockWithNotify(x, y - 1, z, producedBlock);

					if(explosive != null)
					{
						world.spawnEntityInWorld(explosive);
					}
				}

				if(world.getBlockId(x, y, z + 1) == reactsWith.get(i))
				{
					producedBlock = ReactionHandler.getProduct(ReactionHandler.getRowWithTwoReactants(reactsWith.get(i), blockID));
					world.setBlockWithNotify(x, y, z, producedBlock);
					world.setBlockWithNotify(x, y, z + 1, producedBlock);

					if(explosive != null)
					{
						world.spawnEntityInWorld(explosive);
					}
				}
				
				if(world.getBlockId(x, y, z - 1) == reactsWith.get(i))
				{
					producedBlock = ReactionHandler.getProduct(ReactionHandler.getRowWithTwoReactants(reactsWith.get(i), blockID));
					world.setBlockWithNotify(x, y, z, producedBlock);
					world.setBlockWithNotify(x, y, z - 1, producedBlock);

					if(explosive != null)
					{
						world.spawnEntityInWorld(explosive);
					}
				}
			}
		}
	}
}
