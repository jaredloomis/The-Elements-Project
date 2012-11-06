package ultratech.api.reaction;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.Block;

public class ReactionHandler 
{
	public static int[][] arrayOfArray = new int[30][30];

	public static void addBlockReaction(int y, int in1, int in2, int product)
	{
		arrayOfArray[0][y] = product;
		arrayOfArray[1][y] = in1;
		arrayOfArray[2][y] = in2;

		cleanUpAir();
	}

	public static void addReactantToExistingReaction(int y, int reactant)
	{
		boolean isDone = false;

		for(int x = 0; x < arrayOfArray.length; x++)
		{
			if(!isDone)
			{
				if(arrayOfArray[x][y] == -1)
				{
					arrayOfArray[x][y] = reactant;
					isDone = true;
				}
			}
		}
	}

	public static int getBlockAt(int x, int y)
	{
		return arrayOfArray[x][y];
	}

	public static void visualizeArray()
	{
		for(int y = 0; y < 30; y++)
		{
			for(int x = 0; x < 30; x++)
			{
				System.out.print("[");
				try
				{
					System.out.print(arrayOfArray[x][y]);
				}
				catch(Exception ex){}
				System.out.print("]");
			}
			System.out.println();
		}
	}

	public static void cleanUpAir()
	{
		for(int x = 0; x < 30; x++)
		{
			for(int y = 0; y < 30; y++)
			{
				if(arrayOfArray[x][y] == 0)
				{
					arrayOfArray[x][y] = -1;
				}
			}
		}
	}

	public static int getReactant(int blockID)
	{
		for(int x = 0; x < 30; x++)
		{
			for(int y = 0; y < 30; y++)
			{
				if(arrayOfArray[x][y] == blockID)
				{
					if(x == 0)
					{
						return -2;
					}
					else if(x == 1)
					{
						return arrayOfArray[2][y];
					}
					else if(x == 2)
					{
						return arrayOfArray[1][y];
					}
				}
			}
		}

		return -2;
	}

	public static List getReactants(int blockID)
	{
		int loopNumber = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for(int x = 0; x < 30; x++)
		{
			for(int y = 0; y < 30; y++)
			{
				if(arrayOfArray[x][y] == blockID)
				{	
					if(x != 0)
					{
						for(int x2 = 0; x2 < 30; x2++)
						{
							if(arrayOfArray[x2][y] != 0 && arrayOfArray[x2][y] != -1 && arrayOfArray[x2][y] != blockID && x2 != 0)
							{
								list.add(arrayOfArray[x2][y]);
							}
						}
					}
				}
			}
		}

		return list;
	}

	public static int[] getReactantsCopy(int blockID)
	{
		int loopNumber = 0;
		int[] retArray = new int[30];
		retArray[0] = -2;

		/*Loop through Array*/
		for(int x = 0; x < 30; x++)
		{
			for(int y = 0; y < 30; y++)
			{
				//if it found the block
				if(arrayOfArray[x][y] == blockID)
				{	
					//if it is not a product
					if(x != 0)
					{
						int rowNumber = y;

						//loop through row

						//1. need it to find all numbers in row, place those numbers into retArray

						//2. make all 0s equal -1, make the product block equal -1, and make its self equal -1,

						//3. find the first available -1 in retArray and in that -1 spot, put the next available number of the arrayOfArray

						for(int x2 = 0; x2 < 30; x2++)
						{
							//1
							retArray[x2] = arrayOfArray[x2][y];

							//2
							if(retArray[x2] == 0 || x2 == 0 || retArray[x2] == arrayOfArray[x][y])
							{
								retArray[x2] = -1;
							}

							//3
							for(int x3 = 0; x3 < 30; x3++)
							{
								if(retArray[x3] == -1)
								{
									retArray[x3] = arrayOfArray[x][y];
								}
							}
						}
					}
				}
			}
		}

		return retArray;
	}

	public static int[] getReactantsCopyTwo(int blockID)
	{
		int loopNumber = 0;
		int[] retArray = new int[30];
		retArray[0] = -2;

		/*Loop through Array*/
		for(int x = 0; x < 30; x++)
		{
			for(int y = 0; y < 30; y++)
			{
				//if it found the block
				if(arrayOfArray[x][y] == blockID)
				{	
					//if it is not a product
					if(x != 0)
					{
						//loops through the line that it found the block in
						for(int ix = 0; ix < (arrayOfArray.length)-2; ix++)
						{	
							//if the slot is an open slot
							if(retArray[ix] == -1 || retArray[ix] == 0)
							{
								retArray[ix] = arrayOfArray[ix][y];
							}
						}
					}
					//end if
				}
				loopNumber++;

				//sets all 0s and the block's own id in array to -1
				if(retArray[x] == 0 || retArray[x] == blockID)
				{
					retArray[x] = -1;
				}
			}
		}

		return retArray;
	}

	public static int getProduct(int y)
	{
		return arrayOfArray[0][y];
	}


	public static int getRow(int blockID)
	{
		for(int x = 0; x < 30; x++)
		{
			for(int y = 0; y < 30; y++)
			{
				if(arrayOfArray[x][y] == blockID)
				{
					return y;
				}
			}
		}

		return -1;
	}

	public static int getRowWithTwoReactants(int blockOne, int blockTwo)
	{
		for(int x = 0; x < 30; x++)
		{
			for(int y = 0; y < 30; y++)
			{
				if(arrayOfArray[x][y] == blockOne)
				{
					for(int x2 = 0; x2 < 30; x2++)
					{
						if(arrayOfArray[x2][y] == blockTwo)
						{
							if(x2 != 0)
								return y;
						}
					}
				}
			}
		}
		return -1;
	}
}
