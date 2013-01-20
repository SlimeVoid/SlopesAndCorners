package slimevoid.slopes.core;

import slimevoid.slopes.core.config.SlopesConfig;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

@Mod(
		modid="SlimevoidSlopes",
		name="Slimevoid Slopes",
		version="2.0.0.1")
public class Slopes {
	
	@PostInit
	public void SlopesPostInit(FMLPostInitializationEvent event) {
		SlopesConfig.configuration();
	}
}
