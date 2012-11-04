package ultratech.common;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.Block;
import ultratech.api.reaction.ReactionHandler;
import ultratech.client.BaseConfigure;

public class RegisterReactions 
{
	public static void init()
	{
		ReactionHandler reactions = new ReactionHandler();

		ReactionHandler.addBlockReaction(0, BaseConfigure.oxygenID, BaseConfigure.hydrogenID, Block.waterStill.blockID);
		ReactionHandler.addBlockReaction(1,  BaseConfigure.lithiumID, Block.grass.blockID, Block.gravel.blockID);
		ReactionHandler.addBlockReaction(2,  BaseConfigure.purifierID, 0, BaseConfigure.oxygenID);				//cannot react with 0
		ReactionHandler.addBlockReaction(3,  BaseConfigure.flourineID, Block.grass.blockID, Block.gravel.blockID);
		ReactionHandler.addBlockReaction(4,  BaseConfigure.generatorID, Block.waterStill.blockID, BaseConfigure.oxygenID);
		ReactionHandler.addBlockReaction(5,  BaseConfigure.lithiumID, Block.dirt.blockID, Block.gravel.blockID);
	}
}
