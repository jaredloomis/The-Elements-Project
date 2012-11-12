package ultratech.common.blocks;
import net.minecraft.src.Material;
import ultratech.api.BlockUT;
import ultratech.client.BaseConfigure;

public class BlockMagnesium extends BlockUT
{
	public BlockMagnesium(int id, int index) 
	{
		super(id, index, Material.iron);
		setBurnProperties(BaseConfigure.magnesiumID, 100, 20);
	}
}
