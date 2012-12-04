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
		
		ReactionHandler.addBlockReaction(1, BaseConfigure.lithiumID, Block.grass.blockID, Block.gravel.blockID);
		ReactionHandler.addReactantToExistingReaction(1, BaseConfigure.chlorineID);
		ReactionHandler.addReactantToExistingReaction(1, BaseConfigure.flourineID);
		ReactionHandler.addReactantToExistingReaction(1, 1);
		ReactionHandler.addReactantToExistingReaction(1, 2);
		ReactionHandler.addReactantToExistingReaction(1, 3);
		ReactionHandler.addReactantToExistingReaction(1, 4);
		ReactionHandler.addReactantToExistingReaction(1, 5);
		ReactionHandler.addReactantToExistingReaction(1, 6);
		ReactionHandler.addReactantToExistingReaction(1, 8);
		ReactionHandler.addReactantToExistingReaction(1, 9);
		ReactionHandler.addReactantToExistingReaction(1, 10);
		ReactionHandler.addReactantToExistingReaction(1, 11);
		ReactionHandler.addReactantToExistingReaction(1, 12);
		ReactionHandler.addReactantToExistingReaction(1, 13);
		ReactionHandler.addReactantToExistingReaction(1, 14);
		ReactionHandler.addReactantToExistingReaction(1, 15);
		ReactionHandler.addReactantToExistingReaction(1, 16);
		
		ReactionHandler.addBlockReaction(3, BaseConfigure.flourineID, Block.grass.blockID, Block.gravel.blockID);
		ReactionHandler.addReactantToExistingReaction(3, 1);
		ReactionHandler.addReactantToExistingReaction(3, 2);
		ReactionHandler.addReactantToExistingReaction(3, 3);
		ReactionHandler.addReactantToExistingReaction(3, 4);
		ReactionHandler.addReactantToExistingReaction(3, 5);
		ReactionHandler.addReactantToExistingReaction(3, 6);
		ReactionHandler.addReactantToExistingReaction(3, 8);
		ReactionHandler.addReactantToExistingReaction(3, 9);
		ReactionHandler.addReactantToExistingReaction(3, 10);
		ReactionHandler.addReactantToExistingReaction(3, 11);
		ReactionHandler.addReactantToExistingReaction(3, 12);
		ReactionHandler.addReactantToExistingReaction(3, 13);
		ReactionHandler.addReactantToExistingReaction(3, 14);
		ReactionHandler.addReactantToExistingReaction(3, 15);
		ReactionHandler.addReactantToExistingReaction(3, 16);
		
		ReactionHandler.addBlockReaction(4, BaseConfigure.sodiumID, Block.grass.blockID, Block.gravel.blockID);
		ReactionHandler.addReactantToExistingReaction(4, 1);
		ReactionHandler.addReactantToExistingReaction(4, 2);
		ReactionHandler.addReactantToExistingReaction(4, 3);
		ReactionHandler.addReactantToExistingReaction(4, 4);
		ReactionHandler.addReactantToExistingReaction(4, 5);
		ReactionHandler.addReactantToExistingReaction(4, 6);
		ReactionHandler.addReactantToExistingReaction(4, 8);
		ReactionHandler.addReactantToExistingReaction(4, 9);
		ReactionHandler.addReactantToExistingReaction(4, 10);
		ReactionHandler.addReactantToExistingReaction(4, 11);
		ReactionHandler.addReactantToExistingReaction(4, 12);
		ReactionHandler.addReactantToExistingReaction(4, 13);
		ReactionHandler.addReactantToExistingReaction(4, 14);
		ReactionHandler.addReactantToExistingReaction(4, 15);
		ReactionHandler.addReactantToExistingReaction(4, 16);
		
		ReactionHandler.addBlockReaction(5, BaseConfigure.phosphorusID, Block.grass.blockID, Block.gravel.blockID);
		ReactionHandler.addReactantToExistingReaction(5, 1);
		ReactionHandler.addReactantToExistingReaction(5, 2);
		ReactionHandler.addReactantToExistingReaction(5, 3);
		ReactionHandler.addReactantToExistingReaction(5, 4);
		ReactionHandler.addReactantToExistingReaction(5, 5);
		ReactionHandler.addReactantToExistingReaction(5, 6);
		ReactionHandler.addReactantToExistingReaction(5, 8);
		ReactionHandler.addReactantToExistingReaction(5, 9);
		ReactionHandler.addReactantToExistingReaction(5, 10);
		ReactionHandler.addReactantToExistingReaction(5, 11);
		ReactionHandler.addReactantToExistingReaction(5, 12);
		ReactionHandler.addReactantToExistingReaction(5, 13);
		ReactionHandler.addReactantToExistingReaction(5, 14);
		ReactionHandler.addReactantToExistingReaction(5, 15);
		ReactionHandler.addReactantToExistingReaction(5, 16);
		
		ReactionHandler.addBlockReaction(6, BaseConfigure.sulfurID, Block.grass.blockID, Block.gravel.blockID);
		ReactionHandler.addReactantToExistingReaction(6, 1);
		ReactionHandler.addReactantToExistingReaction(6, 2);
		ReactionHandler.addReactantToExistingReaction(6, 3);
		ReactionHandler.addReactantToExistingReaction(6, 4);
		ReactionHandler.addReactantToExistingReaction(6, 5);
		ReactionHandler.addReactantToExistingReaction(6, 6);
		ReactionHandler.addReactantToExistingReaction(6, 8);
		ReactionHandler.addReactantToExistingReaction(6, 9);
		ReactionHandler.addReactantToExistingReaction(6, 10);
		ReactionHandler.addReactantToExistingReaction(6, 11);
		ReactionHandler.addReactantToExistingReaction(6, 12);
		ReactionHandler.addReactantToExistingReaction(6, 13);
		ReactionHandler.addReactantToExistingReaction(6, 14);
		ReactionHandler.addReactantToExistingReaction(6, 15);
		ReactionHandler.addReactantToExistingReaction(6, 16);
		
		ReactionHandler.addBlockReaction(7, BaseConfigure.potassiumID, Block.grass.blockID, Block.gravel.blockID);
		ReactionHandler.addReactantToExistingReaction(7, 1);
		ReactionHandler.addReactantToExistingReaction(7, 2);
		ReactionHandler.addReactantToExistingReaction(7, 3);
		ReactionHandler.addReactantToExistingReaction(7, 4);
		ReactionHandler.addReactantToExistingReaction(7, 5);
		ReactionHandler.addReactantToExistingReaction(7, 6);
		ReactionHandler.addReactantToExistingReaction(7, 8);
		ReactionHandler.addReactantToExistingReaction(7, 9);
		ReactionHandler.addReactantToExistingReaction(7, 10);
		ReactionHandler.addReactantToExistingReaction(7, 11);
		ReactionHandler.addReactantToExistingReaction(7, 12);
		ReactionHandler.addReactantToExistingReaction(7, 13);
		ReactionHandler.addReactantToExistingReaction(7, 14);
		ReactionHandler.addReactantToExistingReaction(7, 15);
		ReactionHandler.addReactantToExistingReaction(7, 16);
		
		ReactionHandler.addBlockReaction(8, BaseConfigure.calciumID, Block.grass.blockID, Block.gravel.blockID);
		ReactionHandler.addReactantToExistingReaction(8, 1);
		ReactionHandler.addReactantToExistingReaction(8, 2);
		ReactionHandler.addReactantToExistingReaction(8, 3);
		ReactionHandler.addReactantToExistingReaction(8, 4);
		ReactionHandler.addReactantToExistingReaction(8, 5);
		ReactionHandler.addReactantToExistingReaction(8, 6);
		ReactionHandler.addReactantToExistingReaction(8, 8);
		ReactionHandler.addReactantToExistingReaction(8, 9);
		ReactionHandler.addReactantToExistingReaction(8, 10);
		ReactionHandler.addReactantToExistingReaction(8, 11);
		ReactionHandler.addReactantToExistingReaction(8, 12);
		ReactionHandler.addReactantToExistingReaction(8, 13);
		ReactionHandler.addReactantToExistingReaction(8, 14);
		ReactionHandler.addReactantToExistingReaction(8, 15);
		ReactionHandler.addReactantToExistingReaction(8, 16);
	}
}
