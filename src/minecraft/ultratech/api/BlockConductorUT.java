package ultratech.api;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import ultratech.common.mod_Ultratech;
import universalelectricity.prefab.BlockConductor;

public abstract class BlockConductorUT extends BlockConductor
{
	public BlockConductorUT(int id, Material material) 
	{
		super(id, material);
		setCreativeTab(mod_Ultratech.tabElements);
	}

	@Override
	public String getTextureFile()
	{
		return "/ultratech/common/texturess/ultratechBlocks.png";
	}
}
