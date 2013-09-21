package slimevoid.slopesncorners.core;

import slimevoid.materialslib.lib.ReInitMatsCommand;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.CoreLib;
import slimevoidlib.ICommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(
		modid = CoreLib.MOD_ID,
		name = CoreLib.MOD_NAME,
		version = CoreLib.MOD_VERSION,
		dependencies = CoreLib.MOD_DEPENDENCIES)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class SlopesNCorners {
	@SidedProxy(
			clientSide = CoreLib.CLIENT_PROXY,
			serverSide = CoreLib.COMMON_PROXY)
	public static ICommonProxy	proxy;

	@PreInit
	public void slopesPreInit(FMLPreInitializationEvent event) {

		proxy.preInit();

		proxy.registerConfigurationProperties(event.getSuggestedConfigurationFile());
	}

	@PostInit
	public void slopesPostInit(FMLPostInitializationEvent event) {
		ConfigurationLib.registerBlocks();
		proxy.registerRenderInformation();
	}

}
