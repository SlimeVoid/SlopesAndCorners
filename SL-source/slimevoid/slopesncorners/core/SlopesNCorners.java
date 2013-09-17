package slimevoid.slopesncorners.core;

import slimevoid.slopesncorners.client.network.ClientPacketHandler;
import slimevoid.slopesncorners.command.ReInitMatsCommand;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.CoreLib;
import slimevoid.slopesncorners.network.CommonPacketHandler;
import slimevoid.slopesncorners.proxy.CommonProxy;
import slimevoidlib.ICommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;

@Mod(
		modid = CoreLib.MOD_ID,
		name = CoreLib.MOD_NAME,
		version = CoreLib.MOD_VERSION,
		dependencies = CoreLib.MOD_DEPENDENCIES)
@NetworkMod(
		clientSideRequired = true,
		serverSideRequired = false,
		clientPacketHandlerSpec = @SidedPacketHandler(
				channels = { CoreLib.MOD_CHANNEL },
				packetHandler = ClientPacketHandler.class),
		serverPacketHandlerSpec = @SidedPacketHandler(
				channels = { CoreLib.MOD_CHANNEL },
				packetHandler = CommonPacketHandler.class),
		connectionHandler = CommonProxy.class)
public class SlopesNCorners {
	@SidedProxy(
			clientSide = CoreLib.CLIENT_PROXY,
			serverSide = CoreLib.COMMON_PROXY)
	public static ICommonProxy	proxy;

	@EventHandler
	public void slopesPreInit(FMLPreInitializationEvent event) {

		proxy.preInit();

		proxy.registerConfigurationProperties(event
				.getSuggestedConfigurationFile());
	}

	@EventHandler
	public void slopesPostInit(FMLPostInitializationEvent event) {
		ConfigurationLib.registerBlocks();
		proxy.registerRenderInformation();
	}

	@EventHandler
	public void registerCommand(FMLServerStartingEvent event) {
		event.registerServerCommand(new ReInitMatsCommand());
	}

}
