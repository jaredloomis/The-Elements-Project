package ultratech.common.blocks;
import java.util.ArrayList;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import ultratech.api.BlockUT;
import ultratech.client.BaseConfigure;
import ultratech.common.RegisterBlocks;
import ultratech.common.mod_Ultratech;

public class BlockFluorite extends BlockUT
{
	public BlockFluorite(int id, int index) 
	{
		super(id, index, Material.rock);
	}
	
	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
	{
		ItemStack idDropped = new ItemStack(RegisterBlocks.fluorite);
		ArrayList a = new ArrayList();
		a.add(idDropped);
		return a;
	}
}
