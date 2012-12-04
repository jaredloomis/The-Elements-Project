package ultratech.common;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import ultratech.api.matter.MachineRecipeHandler;
import ultratech.client.BaseConfigure;

public class RegisterRecipes 
{
	public static void init()
	{
		MachineRecipeHandler.addElectrolyzerRecipe(0, new ItemStack(Item.bucketWater.shiftedIndex, 1, 0), new ItemStack(BaseConfigure.hydrogenID, 1, 0), new ItemStack(BaseConfigure.oxygenID, 1, 0));
		MachineRecipeHandler.addElectrolyzerRecipe(1, new ItemStack(BaseConfigure.saltID, 1, 0), new ItemStack(BaseConfigure.sodiumID, 1, 0), new ItemStack(BaseConfigure.chlorineID, 1, 0));
		MachineRecipeHandler.addElectrolyzerRecipe(2, new ItemStack(BaseConfigure.brineID, 1, 0), new ItemStack(BaseConfigure.lithiumID, 1, 0), null);
		MachineRecipeHandler.addElectrolyzerRecipe(3, new ItemStack(BaseConfigure.fluoriteID, 1, 0), new ItemStack(BaseConfigure.flourineID, 1, 0), null);
		MachineRecipeHandler.addElectrolyzerRecipe(4, new ItemStack(BaseConfigure.bruciteID, 1, 0), new ItemStack(BaseConfigure.magnesiumID, 1, 0), null);
		MachineRecipeHandler.addElectrolyzerRecipe(5, new ItemStack(RegisterItems.alOx.shiftedIndex, 1, 0), new ItemStack(BaseConfigure.aluminiumID, 1, 0), null);
		MachineRecipeHandler.addElectrolyzerRecipe(6, new ItemStack(Block.sand.blockID, 1, 0), new ItemStack(BaseConfigure.siliconID, 1, 0), null);
		
		craftingRecipes();
	}
	
	public static void craftingRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(RegisterBlocks.nine), new ItemStack(RegisterBlocks.fluorite));

		GameRegistry.addRecipe(new ItemStack(RegisterBlocks.six), new Object[]
				{
			"CCC", "CCC", "CCC", 'C', Item.coal
				});

		GameRegistry.addRecipe(new ItemStack(RegisterBlocks.reactor), new Object[]
				{
			"CCC", "CSC", "CCC", 'C', Item.ingotIron, 'S', RegisterBlocks.three
				});
		
		GameRegistry.addRecipe(new ItemStack(RegisterBlocks.elec), new Object[]
				{
			"IRI", " R ", "IRI", 'I', Item.ingotIron, 'R', Item.redstone
				});
		
		GameRegistry.addRecipe(new ItemStack(RegisterBlocks.builder), new Object[]
				{
			"BCB", "PBP", "BBB", 'B', RegisterBlocks.four, 'C', Block.workbench, 'P', RegisterItems.proton, 'N', RegisterItems.nuetron, 'E', RegisterItems.electron
				});
		
		GameRegistry.addRecipe(new ItemStack(RegisterItems.crank), new Object[]
				{
			" S ", "CLC", "RCR", 'R', Item.redstone, 'C', RegisterBlocks.twentyNine, 'L', RegisterBlocks.three, 'S', Block.lever
				});


		GameRegistry.addSmelting(BaseConfigure.berylID, new ItemStack(RegisterBlocks.four), 3);
		GameRegistry.addSmelting(BaseConfigure.boraxID, new ItemStack(RegisterBlocks.five), 3);
		GameRegistry.addSmelting(BaseConfigure.alOreID, new ItemStack(RegisterItems.alOx), 3);
		GameRegistry.addSmelting(Block.sand.blockID, new ItemStack(RegisterBlocks.fourteen), 3);
	}
}
