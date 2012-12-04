package ultratech.client.gui;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;
import org.lwjgl.opengl.GL11;
import ultratech.common.tileentities.TileCollider;
import ultratech.common.tileentities.TileElectrolyzer;

public class GuiElectrolyzer extends GuiContainer
{
	private TileElectrolyzer collider;
	
	public GuiElectrolyzer(InventoryPlayer player_inventory, TileElectrolyzer tile_entity)
	{
		super(new ContainerElectrolyzer(tile_entity, player_inventory));
		collider = tile_entity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		fontRenderer.drawString("Electrolyzer", 6, 6, 0xffffff);
		
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 + 2, 0xffffff);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		int picture = mc.renderEngine.getTexture("/ultratech/client/gui/AtomSmasherGui.png");
		
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

		this.mc.renderEngine.bindTexture(picture);

		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		
		int progress = collider.getElectrolyzedTime();

		this.drawTexturedModalRect(x + 56, y + 36 + 12 - progress, 176, 12 - progress, 14, progress + 2);
		
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}
