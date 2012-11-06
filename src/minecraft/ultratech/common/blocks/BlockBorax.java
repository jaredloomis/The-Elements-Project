package ultratech.common.blocks;
import net.minecraft.src.Material;
import ultratech.api.BlockUT;

public class BlockBorax extends BlockUT
{
	public BlockBorax(int id, int index) 
	{
		super(id, index, Material.rock);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
}
