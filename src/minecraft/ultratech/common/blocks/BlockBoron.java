package ultratech.common.blocks;
import net.minecraft.src.Material;
import ultratech.api.BlockUT;
import ultratech.common.mod_Ultratech;

public class BlockBoron extends BlockUT
{
	public BlockBoron(int id, int index) 
	{
		super(id, index, Material.iron);
		setBurnProperties(this.blockID, 5, 5);
	}
}
