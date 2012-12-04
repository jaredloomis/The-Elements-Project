package ultratech.common.blocks;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraftforge.common.ForgeDirection;
import ultratech.api.BlockMachineUT;
import ultratech.common.mod_Ultratech;
import ultratech.common.tileentities.TileBattery;
import universalelectricity.core.UniversalElectricity;
import universalelectricity.core.implement.IElectricityReceiver;
import universalelectricity.core.implement.IJouleStorage;
import universalelectricity.prefab.BlockMachine;

public class BlockBattery extends BlockMachineUT
{
	public BlockBattery(int id, int index) 
	{
		super(id, index);
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1)
	{
		return new TileBattery();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if(tile_entity == null || player.isSneaking())
		{
			return false;
		}

		player.openGui(mod_Ultratech.instance, 4, world, x, y, z);

		return true;
	}
}
