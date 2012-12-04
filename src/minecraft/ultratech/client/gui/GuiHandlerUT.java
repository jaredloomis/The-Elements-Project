package ultratech.client.gui;
import ultratech.common.tileentities.TileBattery;
import ultratech.common.tileentities.TileCollider;
import ultratech.common.tileentities.TileElectrolyzer;
import ultratech.common.tileentities.TileFission;
import ultratech.common.tileentities.TileMatterBuilder;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.src.*;

public class GuiHandlerUT implements IGuiHandler
{
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
		
		if(id == 2)
		{
			if(tile_entity instanceof TileElectrolyzer)
			{
				return new ContainerElectrolyzer((TileElectrolyzer) tile_entity, player.inventory);
			}
		}
		
		if(id == 3)
		{
			if(tile_entity instanceof TileFission)
			{
				return new ContainerFission((TileFission) tile_entity, player.inventory);
			}
		}
		
		if(id == 4)
		{
			if(tile_entity instanceof TileBattery)
			{
				return new ContainerBattery((TileBattery) tile_entity, player.inventory);
			}
		}

		return null;
	}

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
			if(tile_entity instanceof TileCollider)
			{
				return new GuiSmasher(player.inventory, (TileCollider) tile_entity);
			}
		}
		
		if(id == 2)
		{
			if(tile_entity instanceof TileElectrolyzer)
			{
				return new GuiElectrolyzer(player.inventory, (TileElectrolyzer) tile_entity);
			}
		}
		
		if(id == 3)
		{
			if(tile_entity instanceof TileFission)
			{
				return new GuiFission(player.inventory, (TileFission) tile_entity);
			}
		}
		
		if(id == 4)
		{
			if(tile_entity instanceof TileBattery)
			{
				return new GuiBattery(player.inventory, (TileBattery) tile_entity);
			}
		}
		
		return null;
	}
}