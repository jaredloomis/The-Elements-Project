package ultratech.common.electricity;
import ultratech.common.tileentities.TileEntityCopper;
import universalelectricity.core.electricity.ElectricityNetwork;

public class UENetworks 
{
	public static ElectricityNetwork one;
	
	public static void init()
	{
		one = new ElectricityNetwork(new TileEntityCopper());
	}
}
