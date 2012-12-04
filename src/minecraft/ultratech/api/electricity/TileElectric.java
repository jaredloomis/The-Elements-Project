package ultratech.api.electricity;
import net.minecraft.src.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileElectric extends TileEntity implements IElectricityReciever
{
	public TileElectric()
	{
		super();
	}

	@Override
	public void updateEntity()
	{
		super.updateEntity();
	}

	@Override
	public float getWattRequest() 
	{
		return 120;
	}

	/**
	 *Returns the watts or total power of the Entity
	 **/
	public float getWatts()
	{
		return this.getAmps() * this.getVolts();
	}

	@Override
	public float getAmps() 
	{
		return 0;
	}

	@Override
	public float getVolts() 
	{
		return 0;
	}
}
