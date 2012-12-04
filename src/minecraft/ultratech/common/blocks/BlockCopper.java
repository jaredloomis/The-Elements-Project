package ultratech.common.blocks;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import ultratech.api.BlockConductorUT;
import ultratech.common.tileentities.TileEntityCopper;

public class BlockCopper extends BlockConductorUT
{
	public BlockCopper(int id) 
	{
		super(id, Material.iron);
		blockIndexInTexture = 13;
	}

	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
		return new TileEntityCopper();
	}
}
