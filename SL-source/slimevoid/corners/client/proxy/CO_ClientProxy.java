package slimevoid.corners.client.proxy;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.client.registry.RenderingRegistry;
import slimevoid.corners.client.render.BlockCornersRenderer;
import slimevoid.corners.core.config.CornersConfig;
import slimevoid.corners.proxy.CO_CommonProxy;

public class CO_ClientProxy extends CO_CommonProxy {

	@Override
	public void registerRenderInformation() {
		BlockCornersRenderer.registerProps();
		RenderingRegistry.registerBlockHandler(CornersConfig.CornersRenderID, new BlockCornersRenderer());
	}
	
	@Override
	public String getMinecraftDir() {
		return Minecraft.getMinecraftDir().toString();
	}
}
