package ultratech.api.matter;
import net.minecraft.src.ItemStack;

public class MachineRecipeHandler 
{
	public static ItemStack[][] electrolyzer;
	
	public static void init()
	{
		electrolyzer = new ItemStack[4][30];
	}
	
	public static void addElectrolyzerRecipe(int y, ItemStack input, ItemStack output, ItemStack outputTwo)
	{
		electrolyzer[0][y] = input;
		electrolyzer[1][y] = output;
		electrolyzer[2][y] = outputTwo;
	}
	
	public static ItemStack getElectrolyzerItemStack(int x, int y)
	{
		return electrolyzer[x][y];
	}
	
	public static ItemStack[][] getElectrolyzerArray()
	{
		return electrolyzer;
	}
	
	public static void visualize()
	{
		for(int y = 0; y < 30; y++)
		{
			for(int x = 0; x < 3; x++)
			{
				//System.out.print("[" + electrolyzer[x][y] + "]");
			}
			System.out.println();
		}
	}
}
