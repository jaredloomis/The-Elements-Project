package ultratech.common;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import ultratech.client.BaseConfigure;
import ultratech.common.blocks.*;
import ultratech.common.tileentities.TileCollider;

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
	public static Block fourteen;
	public static Block fifteen;
	public static Block sixteen;
	public static Block seventeen;
	public static Block eighteen;
	public static Block nineteen;
	public static Block twenty;
	public static Block twentyOne;
	public static Block twentyTwo;
	public static Block twentyThree;
	public static Block twentyNine;
	
	public static Block fluorite;
	public static Block beryl;
	public static Block borax;
	public static Block brine;
	public static Block salt;
	public static Block reactor;
	public static Block builder;
	public static Block collider;
	public static Block elec;
	public static Block fission;
	public static Block brucite;
	public static Block alOre;
	public static Block battery;
	
	public static void init()
	{
		one = new BlockHydrogen(cg.hydrogenID, 0).setBlockName("hydrogen");
		two = new BlockHelium(cg.heliumID, 1).setBlockName("helium");
		three = new BlockLithium(cg.lithiumID, 2).setResistance(2F).setHardness(2F).setBlockName("lithium");
		four = new BlockBeryllium(cg.berylliumID, 3).setResistance(3F).setHardness(3F).setBlockName("beryllium");
		five = new BlockBoron(cg.boronID, 4).setResistance(3F).setHardness(3F).setBlockName("boron");
		six = new BlockCarbon(cg.carbonID, 5).setResistance(5000F).setHardness(30F).setBlockName("carbon");
		seven = new BlockNitrogen(cg.nitrogenID, 6).setResistance(0F).setBlockName("nitrogen");
		eight = new BlockOxygen(cg.oxygenID, 7).setResistance(0F).setBlockName("oxygen");
		nine = new BlockFluorine(cg.flourineID, 8).setResistance(1F).setBlockName("flourine");
		ten = new BlockNeon(cg.neonID, 9).setResistance(1F).setBlockName("neon");
		eleven = new BlockSodium(cg.sodiumID, 10).setResistance(1F).setBlockName("sodium");
		twelve = new BlockMagnesium(cg.magnesiumID, 11).setResistance(1F).setBlockName("magnesium");
		thirteen = new BlockAluminium(cg.aluminiumID, 12).setResistance(1F).setBlockName("aluminium");
		fourteen = new BlockSilicon(cg.siliconID, 13).setResistance(1F).setBlockName("silicon");
		fifteen = new BlockPhosphorus(cg.phosphorusID, 14).setResistance(1F).setBlockName("phosphorus");
		sixteen = new BlockSulfur(cg.sulfurID, 15).setResistance(1F).setBlockName("sulfur");
		seventeen = new BlockChlorine(cg.chlorineID, 16).setResistance(1F).setBlockName("chlorine");
		eighteen = new BlockArgon(cg.argonID, 17).setResistance(1F).setBlockName("argon");
		nineteen = new BlockPotassium(cg.potassiumID, 18).setResistance(1F).setBlockName("potassium");
		twenty = new BlockCalcium(cg.calciumID, 18).setResistance(1F).setBlockName("calcium");
		twentyOne = new BlockScandium(cg.scandiumID, 18).setResistance(1F).setBlockName("scandium");
		twentyTwo = new BlockTitanium(cg.titaniumID, 18).setResistance(1F).setBlockName("titanium");
		twentyThree = new BlockVanadium(cg.vanadiumID, 18).setResistance(1F).setBlockName("vanadium");
		twentyNine = new BlockCopper(cg.copperID).setResistance(1F).setBlockName("copper");

		fluorite = new BlockFluorite(cg.fluoriteID, 12).setHardness(5F).setResistance(1F).setLightValue(0.5F).setBlockName("fluorite");
		beryl = new BlockBeryl(cg.berylID, 12).setHardness(5F).setResistance(1F).setBlockName("beryl");
		borax = new BlockBorax(cg.boraxID, 16).setHardness(5F).setResistance(1F).setBlockName("borax");
		brine = new BlockBrine(cg.brineID, 15).setHardness(5F).setResistance(1F).setBlockName("brine");
		salt = new BlockSalt(cg.saltID, 16).setHardness(5F).setResistance(1F).setBlockName("salt");
		reactor = new BlockReactor(cg.reactorID, 10).setHardness(5F).setResistance(1F).setBlockName("reactor");
		builder = new BlockMatterBuilder(cg.builderID, 10).setHardness(5F).setResistance(1F).setBlockName("builder");
		collider = new BlockCollider(cg.colliderID, 10).setHardness(5F).setResistance(1F).setBlockName("collider");
		elec = new BlockElectrolyzer("electrolyzer", cg.elecID, 10).setHardness(5F).setResistance(1F).setBlockName("electrolyzer");
		fission = new BlockFission(cg.fissID, 10).setHardness(5F).setResistance(1F).setBlockName("fission");
		brucite = new BlockBrucite(cg.bruciteID, 10).setHardness(5F).setResistance(1F).setBlockName("brucite");
		alOre = new BlockBrucite(cg.alOreID, 10).setHardness(5F).setResistance(1F).setBlockName("aluminum ore");
		battery = new BlockBattery(cg.batteryID, 10).setHardness(5F).setResistance(1F).setBlockName("battery");
		
		
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
		LanguageRegistry.addName(thirteen, "Aluminium");
		LanguageRegistry.addName(fourteen, "Silicon");
		LanguageRegistry.addName(fifteen, "Phosphorus");
		LanguageRegistry.addName(sixteen, "Sulfur");
		LanguageRegistry.addName(seventeen, "Chlorine");
		LanguageRegistry.addName(eighteen, "Argon");
		LanguageRegistry.addName(nineteen, "Potassium");
		LanguageRegistry.addName(twenty, "Calcium");
		LanguageRegistry.addName(twentyOne, "Scandium");
		LanguageRegistry.addName(twentyTwo, "Titanium");
		LanguageRegistry.addName(twentyThree, "Vanadium");
		LanguageRegistry.addName(twentyNine, "Copper");

		LanguageRegistry.addName(fluorite, "Fluorite");
		LanguageRegistry.addName(beryl, "Beryl");
		LanguageRegistry.addName(borax, "Borax");
		LanguageRegistry.addName(brine, "Brine");
		LanguageRegistry.addName(salt, "Salt");
		LanguageRegistry.addName(reactor, "Reactor");
		LanguageRegistry.addName(builder, "Matter Builder");
		LanguageRegistry.addName(collider, "Atom Collider");
		LanguageRegistry.addName(elec, "Electrolyzer");
		LanguageRegistry.addName(fission, "Fission Reactor");
		LanguageRegistry.addName(brucite, "Brucite");
		LanguageRegistry.addName(alOre, "Aluminum Ore");
		LanguageRegistry.addName(battery, "Battery");
		
		
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
		GameRegistry.registerBlock(fourteen);
		GameRegistry.registerBlock(fifteen);
		GameRegistry.registerBlock(sixteen);
		GameRegistry.registerBlock(seventeen);
		GameRegistry.registerBlock(eighteen);
		GameRegistry.registerBlock(nineteen);
		GameRegistry.registerBlock(twenty);
		GameRegistry.registerBlock(twentyOne);
		GameRegistry.registerBlock(twentyTwo);
		GameRegistry.registerBlock(twentyThree);
		GameRegistry.registerBlock(twentyNine);

		GameRegistry.registerBlock(fluorite);
		GameRegistry.registerBlock(beryl);
		GameRegistry.registerBlock(borax);
		GameRegistry.registerBlock(brine);
		GameRegistry.registerBlock(salt);
		GameRegistry.registerBlock(reactor);
		GameRegistry.registerBlock(builder);
		GameRegistry.registerBlock(collider);
		GameRegistry.registerBlock(elec);
		GameRegistry.registerBlock(fission);
		GameRegistry.registerBlock(brucite);
		GameRegistry.registerBlock(alOre);
		GameRegistry.registerBlock(battery);
	}
}
