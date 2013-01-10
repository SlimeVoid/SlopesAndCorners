package slimevoid.slopes.client.proxy;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.client.registry.RenderingRegistry;
import slimevoid.slopes.client.render.BlockSlopesRenderer;
import slimevoid.slopes.core.config.SlopesConfig;
import slimevoid.slopes.proxy.SL_CommonProxy;

public class SL_ClientProxy extends SL_CommonProxy {

	@Override
	public void registerRenderInformation() {
		BlockSlopesRenderer.registerProps();
		RenderingRegistry.registerBlockHandler(SlopesConfig.SlopesRenderID, new BlockSlopesRenderer());
	}

	@Override
	public String getMinecraftDir() {
		return Minecraft.getMinecraftDir().toString();
	}
}
