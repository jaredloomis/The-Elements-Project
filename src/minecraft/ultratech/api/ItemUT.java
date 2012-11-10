package ultratech.api;
import net.minecraft.src.Item;

public class ItemUT extends Item
{
	public ItemUT(int par1) 
	{
		super(par1);
	}
	
	@Override
	public String getTextureFile()
	{
		return "/ultratech/common/texturess/ultratechItems.png";
	}
}
