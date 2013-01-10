package slimevoid.corners.core;

import slimevoid.corners.core.config.CornersConfig;
import slimevoid.lib.ICommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

@Mod(
		modid="SlimevoidCorners",
		name="Slimevoid Corner Blocks",
		version="2.0.0.1")
public class CornerBlocks {
	@SidedProxy(
			clientSide="slimevoid.corners.client.proxy.CO_ClientProxy",
			serverSide="slimevoid.corners.proxy.CO_CommonProxy")
	public static ICommonProxy proxy;
	
	@PostInit
	public void CornerBlocksPostInit(FMLPostInitializationEvent event) {
		CornersConfig.configuration();
	}

}
