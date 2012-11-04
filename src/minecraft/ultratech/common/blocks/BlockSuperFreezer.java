package ultratech.common.blocks;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import ultratech.client.gui.GuiFreezer;
import ultratech.client.gui.GuiFreezerTwo;
import ultratech.common.tileentities.TileSuperFreezer;
import universalelectricity.core.UniversalElectricity;
import universalelectricity.prefab.BlockMachine;

public class BlockSuperFreezer extends BlockMachine
{
	public BlockSuperFreezer(String name, int id) 
	{
		super(name, id, UniversalElectricity.machine);
		blockIndexInTexture = 10;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1)
	{
		return new TileSuperFreezer();
	}

	
	@Override
	public String getTextureFile()
	{
		return "/ultratech/common/texturess/ultratechBlocks.png";
	}
	
	public boolean onMachineActivated(World world, int x, int y, int z, EntityPlayer player)
	{	
		ModLoader.openGUI(player, new GuiFreezer(player));
		return true;
	}
}
