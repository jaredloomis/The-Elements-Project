package ultratech.common;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
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
import ultratech.common.blocks.BlockCollider;
import ultratech.common.blocks.BlockCopper;
import ultratech.common.blocks.BlockFluorine;
import ultratech.common.blocks.BlockFluorite;
import ultratech.common.blocks.BlockGenerator;
import ultratech.common.blocks.BlockHelium;
import ultratech.common.blocks.BlockHydrogen;
import ultratech.common.blocks.BlockLithium;
import ultratech.common.blocks.BlockMagnesium;
import ultratech.common.blocks.BlockMatterBuilder;
import ultratech.common.blocks.BlockNeon;
import ultratech.common.blocks.BlockNitrogen;
import ultratech.common.blocks.BlockOxygen;
import ultratech.common.blocks.BlockReactor;
import ultratech.common.blocks.BlockSalt;
import ultratech.common.blocks.BlockSilicon;
import ultratech.common.blocks.BlockSodium;

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
	public static Block eleven;
	public static Block twelve;
	public static Block thirteen;
	public static Block twentyNine;
	
	public static Block generator;
	public static Block purifier;
	public static Block fluorite;
	public static Block beryl;
	public static Block borax;
	public static Block brine;
	public static Block salt;
	public static Block reactor;
	public static Block builder;
	public static Block collider;
	
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
		eleven = new BlockSodium(cg.sodiumID, 14).setResistance(1F).setBlockName("sodium").setCreativeTab(CreativeTabs.tabBlock);
		twelve = new BlockMagnesium(cg.magnesiumID, 1).setResistance(1F).setBlockName("magnesium").setCreativeTab(CreativeTabs.tabBlock);
		thirteen = new BlockSilicon(cg.siliconID, 1).setResistance(1F).setBlockName("silicon").setCreativeTab(CreativeTabs.tabRedstone);
		twentyNine = new BlockCopper(cg.copperID).setResistance(1F).setBlockName("copper").setCreativeTab(CreativeTabs.tabBlock);

		generator = new BlockGenerator(cg.generatorID, 10).setResistance(1F).setHardness(1F).setBlockName("generator").setCreativeTab(CreativeTabs.tabRedstone);
		purifier = new BlockAirPurifier(cg.purifierID, 11).setResistance(1F).setHardness(1F).setBlockName("purifier").setCreativeTab(CreativeTabs.tabRedstone);
		fluorite = new BlockFluorite(cg.fluoriteID, 12).setHardness(5F).setResistance(1F).setLightValue(0.5F).setBlockName("fluorite").setCreativeTab(CreativeTabs.tabBlock);
		beryl = new BlockBeryl(cg.berylID, 12).setHardness(5F).setResistance(1F).setBlockName("beryl").setCreativeTab(CreativeTabs.tabBlock);
		borax = new BlockBorax(cg.boraxID, 16).setHardness(5F).setResistance(1F).setBlockName("borax").setCreativeTab(CreativeTabs.tabBlock);
		brine = new BlockBrine(cg.brineID, 15).setHardness(5F).setResistance(1F).setBlockName("brine").setCreativeTab(CreativeTabs.tabBlock);
		salt = new BlockSalt(cg.saltID, 16).setHardness(5F).setResistance(1F).setBlockName("salt").setCreativeTab(CreativeTabs.tabBlock);
		reactor = new BlockReactor("reactor", cg.reactorID, 10).setHardness(5F).setResistance(1F).setBlockName("reactor").setCreativeTab(CreativeTabs.tabRedstone);
		builder = new BlockMatterBuilder(cg.builderID, 10).setHardness(5F).setResistance(1F).setBlockName("builder").setCreativeTab(CreativeTabs.tabRedstone);
		collider = new BlockCollider(cg.colliderID, 10).setHardness(5F).setResistance(1F).setBlockName("collider").setCreativeTab(CreativeTabs.tabRedstone);
		
		
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
		LanguageRegistry.addName(eleven, "Sodium");
		LanguageRegistry.addName(twelve, "Magnesium");
		LanguageRegistry.addName(thirteen, "Silicon");
		LanguageRegistry.addName(twentyNine, "Copper");

		LanguageRegistry.addName(generator, "Electrolyzer");
		LanguageRegistry.addName(purifier, "Air Purifier");
		LanguageRegistry.addName(fluorite, "Fluorite");
		LanguageRegistry.addName(beryl, "Beryl");
		LanguageRegistry.addName(borax, "Borax");
		LanguageRegistry.addName(brine, "Brine");
		LanguageRegistry.addName(salt, "Salt");
		LanguageRegistry.addName(reactor, "Reactor");
		LanguageRegistry.addName(builder, "Matter Builder");
		LanguageRegistry.addName(collider, "Atom Collider");
		
		
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
		GameRegistry.registerBlock(eleven);
		GameRegistry.registerBlock(twelve);
		GameRegistry.registerBlock(thirteen);
		GameRegistry.registerBlock(twentyNine);

		//GameRegistry.registerBlock(generator);
		//GameRegistry.registerBlock(purifier);
		GameRegistry.registerBlock(fluorite);
		GameRegistry.registerBlock(beryl);
		GameRegistry.registerBlock(borax);
		GameRegistry.registerBlock(brine);
		GameRegistry.registerBlock(salt);
		GameRegistry.registerBlock(reactor);
		GameRegistry.registerBlock(builder);
		GameRegistry.registerBlock(collider);
		
		GameRegistry.addShapelessRecipe(new ItemStack(nine), new ItemStack(fluorite));
		
		GameRegistry.addRecipe(new ItemStack(six), new Object[]
				{
			"CCC", "CCC", "CCC", 'C', Item.coal
				});
		
		GameRegistry.addRecipe(new ItemStack(reactor), new Object[]
				{
			"CCC", "CSC", "CCC", 'C', Item.ingotIron, 'S', three
				});
		
		GameRegistry.addSmelting(BaseConfigure.berylID, new ItemStack(four), 3);
		GameRegistry.addSmelting(BaseConfigure.boraxID, new ItemStack(five), 3);
		GameRegistry.addSmelting(BaseConfigure.brineID, new ItemStack(three), 3);
	}
}
