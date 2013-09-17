package slimevoid.slopesncorners.client.proxy;

import java.io.File;

import slimevoid.slopesncorners.client.network.ClientPacketHandler;
import slimevoid.slopesncorners.client.render.BlockSlopesRenderer;
import slimevoid.slopesncorners.client.render.handlers.BlockHalfSlopesRenderer;
import slimevoid.slopesncorners.client.render.handlers.BlockOblicSlopesRenderer;
import slimevoid.slopesncorners.client.render.handlers.BlockPointSlopesRenderer;
import slimevoid.slopesncorners.client.render.handlers.BlockSideSlopeRenderer;
import slimevoid.slopesncorners.client.render.handlers.BlockSlopesNCornersRenderer;
import slimevoid.slopesncorners.client.render.handlers.BlockTriCornersRenderer;
import slimevoid.slopesncorners.core.lib.BlockLib;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.PacketLib;
import slimevoid.slopesncorners.proxy.CommonProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;

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
		renderHandler.registerSlopeRenderer(BlockLib.BLOCK_SLOPES_ID,
											new BlockSlopesNCornersRenderer());
		renderHandler.registerSlopeRenderer(BlockLib.BLOCK_SIDES_ID,
											new BlockSideSlopeRenderer());
		renderHandler.registerSlopeRenderer(BlockLib.BLOCK_OBLICS_ID,
											new BlockOblicSlopesRenderer());
		renderHandler.registerSlopeRenderer(BlockLib.BLOCK_TRIPOINT_ID,
											new BlockTriCornersRenderer());
		renderHandler.registerSlopeRenderer(BlockLib.BLOCK_HALF_SLOPE_ID,
											new BlockHalfSlopesRenderer());
		renderHandler.registerSlopeRenderer(BlockLib.BLOCK_POINT_SLOPE_ID,
											new BlockPointSlopesRenderer());
		RenderingRegistry
				.registerBlockHandler(	ConfigurationLib.slopesRenderID,
										renderHandler);
	}

	@Override
	public void registerConfigurationProperties(File configFile) {
		ConfigurationLib.ClientConfig(configFile);
	}

}
