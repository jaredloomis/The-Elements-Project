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
		ReactionHandler.addReactantToExistingReaction(1, Block.dirt.blockID);
		ReactionHandler.addReactantToExistingReaction(1, Block.stone.blockID);
		ReactionHandler.addReactantToExistingReaction(1, Block.sand.blockID);
		ReactionHandler.addReactantToExistingReaction(1, Block.sandStone.blockID);
		ReactionHandler.addBlockReaction(3,  BaseConfigure.flourineID, Block.grass.blockID, Block.gravel.blockID);
		ReactionHandler.addBlockReaction(4,  BaseConfigure.generatorID, Block.waterStill.blockID, BaseConfigure.oxygenID);
	}
}
