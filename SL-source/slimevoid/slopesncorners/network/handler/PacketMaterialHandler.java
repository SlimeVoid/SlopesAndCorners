package slimevoid.slopesncorners.network.handler;

import slimevoid.slopesncorners.network.packet.PacketMaterialList;
import slimevoidlib.network.PacketUpdate;
import slimevoidlib.network.handlers.SubPacketHandler;

public class PacketMaterialHandler extends SubPacketHandler {

	@Override
	protected PacketUpdate createNewPacket() {
		return new PacketMaterialList();
	}

}