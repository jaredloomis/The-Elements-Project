package ultratech.common;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import ultratech.client.BaseConfigure;
import ultratech.common.blocks.BlockAirPurifier;
import ultratech.common.blocks.BlockBeryllium;
import ultratech.common.blocks.BlockBoron;
import ultratech.common.blocks.BlockCarbon;
import ultratech.common.blocks.BlockCopper;
import ultratech.common.blocks.BlockFluorine;
import ultratech.common.blocks.BlockFluorite;
import ultratech.common.blocks.BlockGenerator;
import ultratech.common.blocks.BlockHelium;
import ultratech.common.blocks.BlockHydrogen;
import ultratech.common.blocks.BlockLithium;
import ultratech.common.blocks.BlockNeon;
import ultratech.common.blocks.BlockNitrogen;
import ultratech.common.blocks.BlockOxygen;
import ultratech.common.blocks.BlockSuperFreezer;

public class RegisterBlocks 
{
	static BaseConfigure cg = new BaseConfigure();
	public static Block one;
	public static Block two;
	public static Block three;
	public static Block four;
	public static Block five;
	public static Block six;
	public static Block seven;
	public static Block eight;
	public static Block nine;
	public static Block ten;
	public static Block twentyNine;
	
	public static Block generator;
	public static Block purifier;
	public static Block fluorite;
	public static Block freezer;
	
	public static void init()
	{
		one = new BlockHydrogen(cg.hydrogenID, 6).setBlockName("hydrogen").setCreativeTab(CreativeTabs.tabBlock);
		two = new BlockHelium(cg.heliumID, 7).setBlockName("helium").setCreativeTab(CreativeTabs.tabBlock);
		three = new BlockLithium(cg.lithiumID, 1).setResistance(2F).setHardness(2F).setBlockName("lithium").setCreativeTab(CreativeTabs.tabBlock);
		four = new BlockBeryllium(cg.berylliumID, 2).setResistance(3F).setHardness(3F).setBlockName("beryllium").setCreativeTab(CreativeTabs.tabBlock);
		five = new BlockBoron(cg.boronID, 3).setResistance(3F).setHardness(3F).setBlockName("boron").setCreativeTab(CreativeTabs.tabBlock);
		six = new BlockCarbon(cg.carbonID, 4).setResistance(5000F).setHardness(30F).setBlockName("carbon").setCreativeTab(CreativeTabs.tabBlock);
		seven = new BlockNitrogen(cg.nitrogenID, 8).setResistance(0F).setBlockName("nitrogen").setCreativeTab(CreativeTabs.tabBlock);
		eight = new BlockOxygen(cg.oxygenID, 9).setResistance(0F).setBlockName("oxygen").setCreativeTab(CreativeTabs.tabBlock);
		nine = new BlockFluorine(cg.flourineID, 5).setResistance(1F).setBlockName("flourine").setCreativeTab(CreativeTabs.tabBlock);
		ten = new BlockNeon(cg.neonID, 8).setResistance(1F).setBlockName("neon").setCreativeTab(CreativeTabs.tabBlock);
		twentyNine = new BlockCopper(cg.copperID).setResistance(1F).setBlockName("copper").setCreativeTab(CreativeTabs.tabBlock);

		generator = new BlockGenerator(cg.generatorID, 10).setResistance(1F).setHardness(1F).setBlockName("generator").setCreativeTab(CreativeTabs.tabRedstone);
		purifier = new BlockAirPurifier(cg.purifierID, 11).setResistance(1F).setHardness(1F).setBlockName("purifier").setCreativeTab(CreativeTabs.tabRedstone);
		fluorite = new BlockFluorite(cg.fluoriteID, 12).setHardness(5F).setResistance(1F).setLightValue(0.5F).setBlockName("fluorite").setCreativeTab(CreativeTabs.tabBlock);
		freezer = new BlockSuperFreezer("freezer", cg.freezerID).setHardness(5F).setResistance(1F).setBlockName("freezer").setCreativeTab(CreativeTabs.tabRedstone);
		
		LanguageRegistry.addName(one, "Hydrogen");
		LanguageRegistry.addName(two, "Helium");
		LanguageRegistry.addName(three, "Lithium");
		LanguageRegistry.addName(four, "Beryllium");
		LanguageRegistry.addName(five, "Boron");
		LanguageRegistry.addName(six, "Carbon");
		LanguageRegistry.addName(seven, "Nitrogen");
		LanguageRegistry.addName(eight, "Oxygen");
		LanguageRegistry.addName(nine, "Fluorine");
		LanguageRegistry.addName(ten, "Neon");
		LanguageRegistry.addName(twentyNine, "Copper");

		LanguageRegistry.addName(generator, "Electrolyzer");
		LanguageRegistry.addName(purifier, "Air Purifier");
		LanguageRegistry.addName(fluorite, "Fluorite");
		LanguageRegistry.addName(fluorite, "Fluorite");
		LanguageRegistry.addName(freezer, "Super Freezer");
		
		
		GameRegistry.registerBlock(one);
		GameRegistry.registerBlock(two);
		GameRegistry.registerBlock(three);
		GameRegistry.registerBlock(four);
		GameRegistry.registerBlock(five);
		GameRegistry.registerBlock(six);
		GameRegistry.registerBlock(seven);
		GameRegistry.registerBlock(eight);
		GameRegistry.registerBlock(nine);
		GameRegistry.registerBlock(ten);
		GameRegistry.registerBlock(twentyNine);

		GameRegistry.registerBlock(generator);
		GameRegistry.registerBlock(purifier);
		GameRegistry.registerBlock(fluorite);
		GameRegistry.registerBlock(freezer);
		
		
		GameRegistry.addRecipe(new ItemStack(nine), new Object[]
				{
					"L  ", "   ", "   ", 'L', fluorite
				});
	}
}
