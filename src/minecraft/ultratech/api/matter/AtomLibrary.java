package ultratech.api.matter;
import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;

public class AtomLibrary 
{
	public static int[][] formulas;
	public static Block[] products;

	public static void init()
	{
		formulas = new int[3][118];
		products = new Block[118];
	}

	public static int[] getAmountAtRow(int y)
	{
		int[] fullForm = new int[4];

		fullForm[0] = formulas[0][y];
		fullForm[1] = formulas[1][y];
		fullForm[2] = formulas[2][y];

		return fullForm;
	}

	public static Block getProductAtRow(int y)
	{
		return products[y];
	}

	public static void registerAtom(Block product, int protons, int nuetrons, int electrons)
	{
		for(int y = 0; y < 118; y++)
		{
			if(products[y] == null)
			{
				if(formulas[0][y] == 0)
				{
					products[y] = product;

					formulas[0][y] = protons;
					formulas[1][y] = nuetrons;
					formulas[2][y] = electrons;
					break;
				}
			}
		}
	}

	public static void visualize(int rows)
	{
		for(int y = 0; y < rows; y++)
		{
			System.out.print(y + " -- " + "[" + products[y] + "]" + " --- ");
			
			for(int x = 0; x < 3; x++)
			{	
				System.out.print("[" + formulas[x][y] + "]");
			}
			System.out.println();
		}
	}


	public static void createAtom()
	{
	}
}
