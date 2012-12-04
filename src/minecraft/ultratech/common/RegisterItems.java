package ultratech.common;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import ultratech.client.BaseConfigure;
import ultratech.common.items.ItemAluminiumOxide;
import ultratech.common.items.ItemCrankGenerator;
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
	public static Item crank;
	public static Item alOx;
	
	
	public static void init()
	{
		proton = new ItemProton(cg.protonID, 1).setItemName("proton");
		nuetron = new ItemNuetron(cg.nuetronID, 2).setItemName("nuetron");
		electron = new ItemElectron(cg.electronID, 0).setItemName("electron");
		crank = new ItemCrankGenerator(cg.crankID).setItemName("crankGen");
		alOx = new ItemAluminiumOxide(cg.alOxID).setItemName("alumoxide");
		
		LanguageRegistry.addName(proton, "Proton");
		LanguageRegistry.addName(nuetron, "Neutron");
		LanguageRegistry.addName(electron, "Electron");
		LanguageRegistry.addName(crank, "Crank Generator");
		LanguageRegistry.addName(alOx, "Aluminium Oxide");
	}
}
