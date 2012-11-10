package ultratech.common;
import ultratech.api.BlockUT;
import ultratech.api.matter.AtomLibrary;
import ultratech.client.BaseConfigure;
import ultratech.client.ClientPacketHandler;
import ultratech.client.gui.GuiHandlerUT;
import ultratech.common.blocks.*;
import ultratech.common.tileentities.TileMatterBuilder;
import ultratech.common.world.WorldGeneratorElementalOres;
import universalelectricity.core.UniversalElectricity;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.client.*;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.*;


@Mod(modid = "Ultratech", name = "Ultratech Mod", version = "1.1.3")
@NetworkMod(clientSideRequired=true, serverSideRequired=false,
clientPacketHandlerSpec =
@SidedPacketHandler(channels = {"UltratechMod" }, packetHandler = ClientPacketHandler.class),
serverPacketHandlerSpec =
@SidedPacketHandler(channels = {"UltratechMod" }, packetHandler = ServerPacketHandler.class))
public class mod_Ultratech
{	
	@SidedProxy(clientSide = "ultratech.client.ClientProxyUT", serverSide = "ultratech.common.ClientProxyCommon")
	public static CommonProxyUT proxy;

	@Instance("Ultratech")
	public static mod_Ultratech instance;
	
	private GuiHandlerUT guiHandler = new GuiHandlerUT();

	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		UniversalElectricity.register(instance, 1, 0, 260, false);

		BaseConfigure.init(event);
		RegisterReactions.init();
		AtomLibrary.init();
	}

	@Init
	public void load(FMLInitializationEvent event)
	{	
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		
		proxy.registerRenderers();
		RegisterBlocks.init();
		RegisterItems.init();
		RegisterAtoms.init();
		worldGeneration();
		tileRegister();
		
	}

	public void worldGeneration()
	{
		GameRegistry.registerWorldGenerator(new WorldGeneratorElementalOres());
	}
	
	public void tileRegister()
	{
		GameRegistry.registerTileEntity(TileMatterBuilder.class, "matterbuilder");
	}
}

