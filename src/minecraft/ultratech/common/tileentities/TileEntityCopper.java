package ultratech.common.tileentities;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraftforge.common.ForgeDirection;
import ultratech.common.electricity.UENetworks;
import universalelectricity.prefab.tile.TileEntityConductor;

public class TileEntityCopper extends TileEntityConductor
{
	@Override
	public double getResistance() 
	{
		return 0;
	}

	@Override
	public double getMaxAmps() 
	{
		return 200;
	}

	@Override
	public void onOverCharge()
	{
	}
}
