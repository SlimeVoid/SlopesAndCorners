package slimevoid.slopesncorners.core.lib;

import slimevoid.slopesncorners.client.network.ClientPacketHandler;
import slimevoid.slopesncorners.network.handler.PacketMaterialHandler;
import slimevoid.slopesncorners.network.packet.PacketMaterialList;
import slimevoid.slopesncorners.network.packet.executor.PacketMaterialListExecutor;
import slimevoidlib.network.PacketIds;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.NetHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PacketLib {

	public static void sendMaterialList(Player player, NetHandler netHandler, INetworkManager manager) {
		PacketMaterialList packet = new PacketMaterialList(ConfigurationLib.getBaseBlockList(false));
		packet.setCommand(CommandLib.SEND_MATERIALS);
		PacketDispatcher.sendPacketToPlayer(packet.getPacket(), player);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerClientPacketHandlers() {
		PacketMaterialHandler materialHandler = new PacketMaterialHandler();
		materialHandler.registerPacketHandler(
				CommandLib.SEND_MATERIALS,
				new PacketMaterialListExecutor());
		
		ClientPacketHandler.registerPacketHandler(
				PacketIds.LOGIN,
				materialHandler);
	}

	public static void registerPacketHandlers() {
	}

}
