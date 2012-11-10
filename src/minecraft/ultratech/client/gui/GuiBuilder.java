package ultratech.client.gui;
import org.lwjgl.opengl.GL11;

import ultratech.common.tileentities.TileMatterBuilder;
import net.minecraft.src.*;

public class GuiBuilder extends GuiContainer
{
	public GuiBuilder(InventoryPlayer player_inventory, TileMatterBuilder tile_entity)
	{
		super(new ContainerBuilder(tile_entity, player_inventory));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		fontRenderer.drawString("Matter Builder", 6, 6, 0xffffff);
		// This draws the caption for the players inventory this is not needed as the above but is sometimes nice
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 + 2, 0xffffff);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		int picture = mc.renderEngine.getTexture("/ultratech/client/gui/MatterBuilderGui.png");
		
		//required
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		
		this.mc.renderEngine.bindTexture(picture);
		
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}