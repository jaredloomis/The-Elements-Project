package ultratech.client.gui;
import ultratech.common.tileentities.TileCollider;
import ultratech.common.tileentities.TileMatterBuilder;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.src.*;

public class GuiHandlerUT implements IGuiHandler
{
	// @param int id, this is the Gui Id
	// @param EntityPlayer, this is the player declaration
	// @param World, this is the world declaration
	// @param int x, y, z this is the players current x, y, z coords
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if(id == 0)
		{
			if(tile_entity instanceof TileMatterBuilder)
			{
				return new ContainerBuilder((TileMatterBuilder) tile_entity, player.inventory);
			}
		}
		
		if(id == 1)
		{
			if(tile_entity instanceof TileCollider)
			{
				return new ContainerSmasher((TileCollider) tile_entity, player.inventory);
			}
		}

		return null;
	}

	// @param int id, this is the Gui Id
	// @param EntityPlayer, this is the player declaration
	// @param World, this is the world declaration,
	// @param int x, y, z this is the players current x, y, z coords
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if(id == 0)
		{
			if(tile_entity instanceof TileMatterBuilder)
			{
				return new GuiBuilder(player.inventory, (TileMatterBuilder) tile_entity);
			}
		}

		if(id == 1)
		{
			if(tile_entity instanceof TileMatterBuilder)
			{
				return new GuiSmasher(player.inventory, (TileCollider) tile_entity);
			}
		}
		
		return null;
	}
}