package ultratech.common.blocks;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import ultratech.api.BlockUT;
import ultratech.client.gui.GuiReactor;
import universalelectricity.core.UniversalElectricity;
import universalelectricity.prefab.BlockMachine;

public class BlockReactor extends BlockMachine
{
	public BlockReactor(String name, int id, int icon) 
	{
		super(name, id, UniversalElectricity.machine);
		blockIndexInTexture = icon;
	}
	
	@Override
	public boolean onMachineActivated(World world, int x, int y, int z, EntityPlayer player)
	{
		ModLoader.openGUI(player, new GuiReactor(player));
		return true;
	}
	
	
	@Override
	public String getTextureFile()
	{
		return "/ultratech/common/texturess/ultratechBlocks.png";
	}
}
