package ultratech.client.gui;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;
import org.lwjgl.opengl.GL11;

import ultratech.common.tileentities.TileCollider;
import ultratech.common.tileentities.TileMatterBuilder;

public class GuiSmasher extends GuiContainer
{
	public GuiSmasher(InventoryPlayer player_inventory, TileCollider tile_entity)
	{
		super(new ContainerSmasher(tile_entity, player_inventory));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		fontRenderer.drawString("Atom Collider", 6, 6, 0xffffff);
		// This draws the caption for the players inventory this is not needed as the above but is sometimes nice
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 + 2, 0xffffff);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		int picture = mc.renderEngine.getTexture("/ultratech/client/gui/AtomSmasherGui.png");

		//required
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

		this.mc.renderEngine.bindTexture(picture);

		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}
