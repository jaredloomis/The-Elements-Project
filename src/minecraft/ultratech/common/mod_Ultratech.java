package ultratech.common;
import ultratech.api.BlockUT;
import ultratech.client.BaseConfigure;
import ultratech.common.blocks.*;
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

@Mod(modid = "Ultratech", name = "Ultratech Mod", version = "1.1.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class mod_Ultratech
{	
	@SidedProxy(clientSide = "ultratech.client.ClientProxyUT", serverSide = "ultratech.common.ClientProxyCommon")
	public static CommonProxyUT proxy;

	@Instance("Ultratech")
	public static mod_Ultratech instance;

	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		UniversalElectricity.register(instance, 1, 0, 260, false);

		BaseConfigure.init(event);
		RegisterReactions.init();
	}

	@Init
	public void load(FMLInitializationEvent event)
	{	
		proxy.registerRenderers();
		RegisterBlocks.init();
		worldGeneration();
	}

	public void worldGeneration()
	{
		GameRegistry.registerWorldGenerator(new WorldGeneratorElementalOres());
	}
}

