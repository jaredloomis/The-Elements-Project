package ultratech.client.gui;
import net.minecraft.src.Container;
import net.minecraft.src.GuiContainer;

public class GuiFreezerTwo extends GuiContainer
{
	public GuiFreezerTwo(Container container) 
	{
		super(container);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		super.drawBackground(var2);
	}

}
