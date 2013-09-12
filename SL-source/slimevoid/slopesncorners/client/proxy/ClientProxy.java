package slimevoid.slopesncorners.client.proxy;

import java.io.File;

import cpw.mods.fml.client.registry.RenderingRegistry;

import slimevoid.slopesncorners.client.network.ClientPacketHandler;
import slimevoid.slopesncorners.client.render.BlockSlopesRenderer;
import slimevoid.slopesncorners.client.render.handlers.BlockOblicSlopesRenderer;
import slimevoid.slopesncorners.client.render.handlers.BlockSideSlopeRenderer;
import slimevoid.slopesncorners.client.render.handlers.BlockSlopesNCornersRenderer;
import slimevoid.slopesncorners.client.render.handlers.BlockTriCornersRenderer;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.PacketLib;
import slimevoid.slopesncorners.proxy.CommonProxy;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit() {		
		super.preInit();
		ClientPacketHandler.init();
		PacketLib.registerClientPacketHandlers();
	}
	
	@Override
	public void registerRenderInformation() {
		BlockSlopesRenderer renderHandler = new BlockSlopesRenderer();
		renderHandler.registerSlopeRenderer(0, new BlockSlopesNCornersRenderer());
		renderHandler.registerSlopeRenderer(1, new BlockSideSlopeRenderer());
		renderHandler.registerSlopeRenderer(2, new BlockOblicSlopesRenderer());
		renderHandler.registerSlopeRenderer(3, new BlockTriCornersRenderer());
		RenderingRegistry.registerBlockHandler(ConfigurationLib.slopesRenderID, renderHandler);
	}
	
	@Override
	public void registerConfigurationProperties(File configFile) {
		ConfigurationLib.ClientConfig(configFile);
	}

}
