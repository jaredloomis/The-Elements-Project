package ultratech.client;

//Theses are all the imports you need
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.src.INetworkManager;
import net.minecraft.src.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

//Create a class and implement IPacketHandler
//This just handles the data packets in the server
public class ClientPacketHandler implements IPacketHandler
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) 
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));

	}
}