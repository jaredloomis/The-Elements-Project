package ultratech.client;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

public class BaseConfigure 
{
	public static int hydrogenID;
	public static int heliumID;
	public static int lithiumID;
	public static int berylliumID;
	public static int boronID;
	public static int carbonID;
	public static int nitrogenID;
	public static int oxygenID;
	public static int flourineID;
	public static int neonID;
	public static int sodiumID;
	public static int copperID;

	public static int generatorID;
	public static int purifierID;
	public static int fluoriteID;
	public static int freezerID;
	public static int berylID;
	public static int boraxID;
	public static int brineID;
	public static int saltID;
	public static int reactorID;
	public static int builderID;
	public static int colliderID;
	
	public static int protonID;
	public static int nuetronID;
	public static int electronID;
	
	public static void init(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		hydrogenID = config.getBlock("Hydrogen", 2701).getInt();
		heliumID = config.getBlock("Helium", 2702).getInt();
		lithiumID = config.getBlock("Lithium", 2703).getInt();
		berylliumID = config.getBlock("Beryllium", 2704).getInt();
		boronID = config.getBlock("Boron", 2705).getInt();
		carbonID = config.getBlock("Carbon", 2706).getInt();
		nitrogenID = config.getBlock("Nitrogen", 2707).getInt();
		oxygenID = config.getBlock("Oxygen", 2708).getInt();
		flourineID = config.getBlock("Flourine", 2709).getInt();
		neonID = config.getBlock("Neon", 2710).getInt();
		sodiumID = config.getBlock("Sodium", 2711).getInt();
		copperID = config.getBlock("Copper", 2729).getInt();

		generatorID = config.getBlock("Generator", 2700).getInt();
		purifierID = config.getBlock("purifier", 2699).getInt();
		fluoriteID = config.getBlock("Fluorite", 2698).getInt();
		freezerID = config.getBlock("Freezer", 2697).getInt();
		berylID = config.getBlock("Beryl", 2696).getInt();
		boraxID = config.getBlock("Borax", 2695).getInt();
		brineID = config.getBlock("Brine", 2694).getInt();
		saltID = config.getBlock("Salt", 2693).getInt();
		reactorID = config.getBlock("Reactor", 2692).getInt();
		builderID = config.getBlock("MatterBuilder", 2691).getInt();
		colliderID = config.getBlock("Collider", 2690).getInt();
		
		protonID = config.getItem("Proton", 2550).getInt();
		nuetronID = config.getItem("Nuetron", 2551).getInt();
		electronID = config.getItem("Electron", 2552).getInt();
		
		//configFlag = config.get(Configuration.CATEGORY_GENERAL, "SomeConfigFlag", false).getBoolean(false);
		config.save();
	}
}
