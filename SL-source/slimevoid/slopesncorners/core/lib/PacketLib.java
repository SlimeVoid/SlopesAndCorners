package slimevoid.slopesncorners.core.lib;

import slimevoid.slopesncorners.network.packet.PacketMaterialList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.NetHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketLib {

	public static void sendMaterialList(Player player, NetHandler netHandler, INetworkManager manager) {
		PacketMaterialList packet = new PacketMaterialList(ConfigurationLib.getBaseBlockList(false));
		PacketDispatcher.sendPacketToPlayer(packet.getPacket(), player);
	}

}
