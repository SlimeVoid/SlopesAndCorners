package slimevoid.interiorcorners.proxy;

import slimevoid.lib.ICommonProxy;
import slimevoid.lib.IPacketHandling;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.Player;

public class IC_CommonProxy implements ICommonProxy {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}

	@Override
	public void preInit() {
	}

	@Override
	public void registerTickHandler() {
	}

	@Override
	public void registerRenderInformation() {
	}

	@Override
	public String getMinecraftDir() {
		return ".";
	}

	@Override
	public int getBlockTextureFromSideAndMetadata(int side, int meta) {
		return 0;
	}

	@Override
	public int getBlockTextureFromMetadata(int meta) {
		return 0;
	}

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
	}

	@Override
	public IPacketHandling getPacketHandler() {
		return null;
	}

	@Override
	public void registerTileEntitySpecialRenderer(
			Class<? extends TileEntity> clazz) {
	}

	@Override
	public void displayTileEntityGui(EntityPlayer entityplayer,
			TileEntity tileentity) {
	}

	@Override
	public World getWorld() {
		return null;
	}

	@Override
	public World getWorld(NetHandler handler) {
		return null;
	}

	@Override
	public EntityPlayer getPlayer() {
		return null;
	}

	@Override
	public void login(NetHandler handler, INetworkManager manager,
			Packet1Login login) {
	}

}
