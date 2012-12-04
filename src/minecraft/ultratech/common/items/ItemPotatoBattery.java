package ultratech.common.items;

import ultratech.common.mod_Ultratech;
import universalelectricity.prefab.ItemElectric;

public class ItemPotatoBattery extends ItemElectric
{
	public ItemPotatoBattery(int par1, int par2)
	{
		super(par1);
		this.iconIndex = par2;
		this.setItemName("Battery");
		this.setCreativeTab(mod_Ultratech.tabElements);
	}

	@Override
	public double getMaxJoules(Object... data)
	{
		return 20000;
	}

	@Override
	public boolean canProduceElectricity()
	{
		return true;
	}

	@Override
	public String getTextureFile()
	{
		return "";
	}

	@Override
	public double getVoltage()
	{
		return 25;
	}
}
