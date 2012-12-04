package ultratech.common;
import ultratech.common.tileentities.TileBattery;
import ultratech.common.tileentities.TileCollider;
import ultratech.common.tileentities.TileElectrolyzer;
import ultratech.common.tileentities.TileFission;
import ultratech.common.tileentities.TileMatterBuilder;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterTiles 
{
	public static void init()
	{
		GameRegistry.registerTileEntity(TileMatterBuilder.class, "builder");
		GameRegistry.registerTileEntity(TileCollider.class, "collider");
		GameRegistry.registerTileEntity(TileElectrolyzer.class, "electrolyzer");
		GameRegistry.registerTileEntity(TileFission.class, "fission");
		GameRegistry.registerTileEntity(TileBattery.class, "battery");
	}
}
