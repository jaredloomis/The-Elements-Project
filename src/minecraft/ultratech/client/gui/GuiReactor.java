package ultratech.client.gui;
import org.lwjgl.opengl.GL11;

import ultratech.client.BaseConfigure;
import ultratech.common.RegisterBlocks;
import net.minecraft.src.Block;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class GuiReactor extends GuiScreen
{
	public EntityPlayer thePlayer; 

	public GuiReactor(EntityPlayer player)
	{
		thePlayer = player;
	}

	@Override
	public void drawScreen(int i, int j, float f)
	{
		drawDefaultBackground();
		super.drawScreen(i, j, f);
	}

	@Override
	public void initGui()
	{
		int x1 = (width/2) - 200;
		int y1 = height - 220;
		int x2 = x1 + 160;
		int y2 = y1 + 30;

		controlList.clear();
		controlList.add(new GuiButton(1, x1, y1, 150, 20, "5 Salt -> 1 Sodium"));
		controlList.add(new GuiButton(2, x1, y2, 150, 20, "1 Water Bucket -> 1 Hydrogen"));
	}

	@Override
	public boolean doesGuiPauseGame(){return false;}

	@Override
	protected void actionPerformed(GuiButton button) 
	{
		int input = -1;
		Block output = null;
		int amount = 1;
		boolean keepGoing = true;

		if(button.id == 1)
		{
			input = BaseConfigure.saltID;
			output = RegisterBlocks.eleven;
			amount = 5;
		}
		
		if(button.id == 2)
		{
			input = Item.bucketWater.shiftedIndex;
			output = RegisterBlocks.one;
			amount = 1;
		}


		for(int i = 0; i <= amount; i++)
		{
			InventoryPlayer pi = thePlayer.inventory;

			if(keepGoing)
			{
				if(!pi.hasItem(input))
				{
					keepGoing = false;
				}

				if(i == amount)
				{
					for(int i2 = 0; i2 < amount; i2++)
						pi.consumeInventoryItem(input);
					
					pi.addItemStackToInventory(new ItemStack(output));
				}
			}
		}
	}
}
