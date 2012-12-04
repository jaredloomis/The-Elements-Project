package ultratech.api;
import ultratech.common.mod_Ultratech;
import net.minecraft.src.Item;

public class ItemUT extends Item
{
	public ItemUT(int par1) 
	{
		super(par1);
		setCreativeTab(mod_Ultratech.tabElements);
	}
	
	@Override
	public String getTextureFile()
	{
		return "/ultratech/common/texturess/ultratechItems.png";
	}
}
