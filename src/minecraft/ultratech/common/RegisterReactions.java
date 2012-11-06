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
		ReactionHandler.addReactantToExistingReaction(3, 1);
		ReactionHandler.addReactantToExistingReaction(3, 2);
		ReactionHandler.addReactantToExistingReaction(3, 3);
		ReactionHandler.addReactantToExistingReaction(3, 4);
		ReactionHandler.addReactantToExistingReaction(3, 5);
		ReactionHandler.addReactantToExistingReaction(3, 6);
		ReactionHandler.addReactantToExistingReaction(3, 7);
		ReactionHandler.addReactantToExistingReaction(3, 8);
		ReactionHandler.addReactantToExistingReaction(3, 9);
		ReactionHandler.addReactantToExistingReaction(3, 10);
		ReactionHandler.addReactantToExistingReaction(3, 11);
		ReactionHandler.addReactantToExistingReaction(3, 12);
		ReactionHandler.addReactantToExistingReaction(3, 13);
		ReactionHandler.addReactantToExistingReaction(3, 14);
		ReactionHandler.addReactantToExistingReaction(3, 15);
		ReactionHandler.addReactantToExistingReaction(3, 16);
		
		ReactionHandler.addBlockReaction(4,  BaseConfigure.generatorID, Block.waterStill.blockID, BaseConfigure.oxygenID);
	}
}
