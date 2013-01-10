package slimevoid.interiorcorners.core;

import slimevoid.interiorcorners.core.config.InteriorCornersConfig;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

@Mod(
		modid="SlimevoidInteriorCorners",
		name="Slimevoid Interior Corner Blocks",
		version="2.0.0.1")
public class InteriorCornerBlocks {

	@PostInit
	public static void InteriorCornerBlocksPostInit(FMLPostInitializationEvent event) {
		InteriorCornersConfig.configuration();
	}
}
