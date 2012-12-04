package ultratech.common.items;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import ultratech.client.BaseConfigure;
import universalelectricity.prefab.ItemElectric;

public class ItemCrankGenerator extends ItemElectric
{
	public ItemCrankGenerator(int id) 
	{
		super(id);
	}
	
	@Override
	 public boolean onItemUse(ItemStack stack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	 {
		 this.onReceive(1, 50, stack);
		 return true;
	 }

	@Override
	public double getMaxJoules(Object... data) 
	{
		return 2000;
	}

	@Override
	public double getVoltage() 
	{
		return 25;
	}
}
