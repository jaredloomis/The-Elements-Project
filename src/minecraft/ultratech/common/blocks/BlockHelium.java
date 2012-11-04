package ultratech.common.blocks;
import java.util.Random;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import ultratech.api.BlockUTGas;

public class BlockHelium extends BlockUTGas
{
	public BlockHelium(int id, int index) 
	{
		super(id, index, Material.air);
	}
}
