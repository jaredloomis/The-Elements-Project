package ultratech.common.blocks;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import ultratech.api.BlockUT;
import universalelectricity.prefab.BlockConductor;
import universalelectricity.prefab.BlockMachine;

public class BlockSilicon extends BlockUT
{
	public BlockSilicon(int id, int index) 
	{
		super(id, index, Material.rock);
	}
}
