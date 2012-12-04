package ultratech.common;
import ultratech.client.BaseConfigure;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.CreativeTabs;

public final class TabUT extends CreativeTabs
{
        public TabUT(int par1, String par2Str)
        {
                super(par1, par2Str);
        }
        
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
        {
                return RegisterBlocks.eleven.blockIndexInTexture;
        }
   
        public String getTranslatedTabLabel()
        {
        	return "Periodic Elements";
        }
}