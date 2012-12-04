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
	public static int magnesiumID;
	public static int siliconID;
	public static int aluminiumID;
	public static int phosphorusID;
	public static int sulfurID;
	public static int chlorineID;
	public static int argonID;
	public static int potassiumID;
	public static int calciumID;
	public static int scandiumID;
	public static int titaniumID;
	public static int vanadiumID;
	public static int copperID;

	public static int fluoriteID;
	public static int berylID;
	public static int boraxID;
	public static int brineID;
	public static int saltID;
	public static int reactorID;
	public static int builderID;
	public static int colliderID;
	public static int elecID;
	public static int fissID;
	public static int bruciteID;
	public static int alOreID;
	public static int batteryID;
	
	public static int protonID;
	public static int nuetronID;
	public static int electronID;
	public static int crankID;
	public static int alOxID;
	
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
		magnesiumID = config.getBlock("Magnesium", 2712).getInt();
		siliconID = config.getBlock("Silicon", 2713).getInt();
		aluminiumID = config.getBlock("Aluminium", 2714).getInt();
		phosphorusID = config.getBlock("Phosphorus", 2715).getInt();
		sulfurID = config.getBlock("Sulfur", 2716).getInt();
		chlorineID = config.getBlock("Chlorine", 2717).getInt();
		argonID = config.getBlock("Argon", 2718).getInt();
		potassiumID = config.getBlock("Potassium", 2719).getInt();
		calciumID = config.getBlock("Calcium", 2720).getInt();
		scandiumID = config.getBlock("Scandium", 2721).getInt();
		titaniumID = config.getBlock("Titanium", 2722).getInt();
		vanadiumID = config.getBlock("Vanadium", 2723).getInt();
		copperID = config.getBlock("Copper", 2729).getInt();

		fluoriteID = config.getBlock("Fluorite", 2698).getInt();
		berylID = config.getBlock("Beryl", 2696).getInt();
		boraxID = config.getBlock("Borax", 2695).getInt();
		brineID = config.getBlock("Brine", 2694).getInt();
		saltID = config.getBlock("Salt", 2693).getInt();
		reactorID = config.getBlock("Reactor", 2692).getInt();
		builderID = config.getBlock("MatterBuilder", 2691).getInt();
		colliderID = config.getBlock("Collider", 2690).getInt();
		elecID = config.getBlock("Electrolyzer", 2689).getInt();
		fissID = config.getBlock("Fission Reactor", 2688).getInt();
		bruciteID = config.getBlock("Brucite", 2687).getInt();
		alOreID = config.getBlock("Aluminum Ore", 2686).getInt();
		batteryID = config.getBlock("Batter", 2685).getInt();
		
		protonID = config.getItem("Proton", 2550).getInt();
		nuetronID = config.getItem("Nuetron", 2551).getInt();
		electronID = config.getItem("Electron", 2552).getInt();
		crankID = config.getItem("Crank Generator", 2553).getInt();
		alOxID = config.getItem("Aluminium Oxide", 2552).getInt();
		
		//configFlag = config.get(Configuration.CATEGORY_GENERAL, "SomeConfigFlag", false).getBoolean(false);
		config.save();
	}
}
