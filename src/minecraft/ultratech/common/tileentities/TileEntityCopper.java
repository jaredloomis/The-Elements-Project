package ultratech.common.tileentities;
import net.minecraft.src.ModLoader;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraftforge.common.ForgeDirection;
import universalelectricity.electricity.ElectricityManager;
import universalelectricity.electricity.ElectricityTransferData;
import universalelectricity.implement.IConductor;
import universalelectricity.implement.IElectricityReceiver;
import universalelectricity.implement.IRedstoneProvider;
import universalelectricity.implement.IRedstoneReceptor;
import universalelectricity.prefab.TileEntityAdvanced;
import universalelectricity.prefab.TileEntityConductor;

public class TileEntityCopper extends TileEntityConductor
{
	@Override
	public double getResistance() 
	{
		return 200;
	}

	@Override
	public double getMaxAmps() 
	{
		return 1000;
	}

	@Override
	public void onOverCharge() 
	{	
		World w = ModLoader.getMinecraftInstance().theWorld;
		w.setBlockWithNotify(this.xCoord, this.yCoord, this.zCoord, 0);
	}
}
