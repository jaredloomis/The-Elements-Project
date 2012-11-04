package ultratech.client.gui;
import ultratech.client.BaseConfigure;
import ultratech.common.RegisterBlocks;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;

public class GuiFreezer extends GuiScreen
{
	public EntityPlayer thePlayer;

	public GuiFreezer(EntityPlayer player)
	{
		thePlayer = player;
	}

	@Override
	public void initGui()
	{
		controlList.clear();
		controlList.add(new GuiButton(1, (width/2), (height/2), 150, 20, "Cool Nitrogen to a Liquid"));
	}

	@Override
	public boolean doesGuiPauseGame(){return false;}

	@Override
	protected void actionPerformed(GuiButton button) 
	{
		if(button.id == 1)
		{
			InventoryPlayer pi = thePlayer.inventory;

			if(pi.hasItem(BaseConfigure.nitrogenID))
			{
				pi.consumeInventoryItem(BaseConfigure.nitrogenID);
				
				if(pi.hasItem(BaseConfigure.nitrogenID))
				{
					pi.addItemStackToInventory(new ItemStack(RegisterBlocks.eight));
				}
				else
				{
					pi.addItemStackToInventory(new ItemStack(RegisterBlocks.seven));
				}
			}
		}
	}
}
