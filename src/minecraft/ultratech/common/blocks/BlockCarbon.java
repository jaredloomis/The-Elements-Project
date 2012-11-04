package ultratech.common.blocks;
import ultratech.api.BlockUT;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;

public class BlockCarbon extends BlockUT
{
	public BlockCarbon(int id, int index) 
	{
		super(id, index, Material.rock);
		setBurnProperties(this.blockID, 100, 30);
	}
}
