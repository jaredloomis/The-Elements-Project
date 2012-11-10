package ultratech.common;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import ultratech.client.BaseConfigure;
import ultratech.common.blocks.BlockAirPurifier;
import ultratech.common.blocks.BlockBeryl;
import ultratech.common.blocks.BlockBeryllium;
import ultratech.common.blocks.BlockBorax;
import ultratech.common.blocks.BlockBoron;
import ultratech.common.blocks.BlockBrine;
import ultratech.common.blocks.BlockCarbon;
import ultratech.common.blocks.BlockCopper;
import ultratech.common.blocks.BlockFluorine;
import ultratech.common.blocks.BlockFluorite;
import ultratech.common.blocks.BlockGenerator;
import ultratech.common.blocks.BlockHelium;
import ultratech.common.blocks.BlockHydrogen;
import ultratech.common.blocks.BlockLithium;
import ultratech.common.blocks.BlockMatterBuilder;
import ultratech.common.blocks.BlockNeon;
import ultratech.common.blocks.BlockNitrogen;
import ultratech.common.blocks.BlockOxygen;
import ultratech.common.blocks.BlockReactor;
import ultratech.common.blocks.BlockSalt;
import ultratech.common.blocks.BlockSodium;
import ultratech.common.items.ItemElectron;
import ultratech.common.items.ItemNuetron;
import ultratech.common.items.ItemProton;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RegisterItems
{
	public static BaseConfigure cg;
	
	public static Item proton;
	public static Item nuetron;
	public static Item electron;
	
	
	public static void init()
	{
		proton = new ItemProton(cg.protonID, 1).setItemName("proton").setCreativeTab(CreativeTabs.tabMaterials);
		nuetron = new ItemNuetron(cg.nuetronID, 2).setItemName("nuetron").setCreativeTab(CreativeTabs.tabMaterials);
		electron = new ItemElectron(cg.electronID, 0).setItemName("electron").setCreativeTab(CreativeTabs.tabMaterials);
		
		LanguageRegistry.addName(proton, "Proton");
		LanguageRegistry.addName(nuetron, "Neutron");
		LanguageRegistry.addName(electron, "Electron");
	}
}
