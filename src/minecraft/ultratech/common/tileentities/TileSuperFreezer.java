package ultratech.common.tileentities;

import net.minecraft.src.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import universalelectricity.prefab.TileEntityElectricityReceiver;

public class TileSuperFreezer extends TileEntityElectricityReceiver
{
	@Override
	public void onReceive(TileEntity sender, double amps, double voltage, ForgeDirection side) 
	{
		
	}

	@Override
	public double wattRequest() 
	{
		return 100;
	}

	@Override
	public boolean canReceiveFromSide(ForgeDirection side) 
	{
		return true;
	}

}
