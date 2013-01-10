package slimevoid.interiorcorners.client.proxy;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.client.registry.RenderingRegistry;
import slimevoid.interiorcorners.client.render.BlockInteriorCornersRenderer;
import slimevoid.interiorcorners.core.config.InteriorCornersConfig;
import slimevoid.interiorcorners.proxy.IC_CommonProxy;

public class IC_ClientProxy extends IC_CommonProxy {

	@Override
	public void registerRenderInformation() {
		BlockInteriorCornersRenderer.registerProps();
		RenderingRegistry.registerBlockHandler(InteriorCornersConfig.IntCornersRenderID, new BlockInteriorCornersRenderer());
	}

	@Override
	public String getMinecraftDir() {
		return Minecraft.getMinecraftDir().toString();
	}
}
