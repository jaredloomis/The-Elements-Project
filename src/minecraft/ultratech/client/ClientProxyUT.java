package ultratech.client;
import net.minecraftforge.client.MinecraftForgeClient;
import ultratech.common.CommonProxyUT;

public class ClientProxyUT extends CommonProxyUT
{
	public void registerRenderers() 
	{
		MinecraftForgeClient.preloadTexture("/ultratech/common/texturess/ultratechBlocks.png");
		MinecraftForgeClient.preloadTexture("/ultratech/common/texturess/ultratechItems.png");
	}
}
