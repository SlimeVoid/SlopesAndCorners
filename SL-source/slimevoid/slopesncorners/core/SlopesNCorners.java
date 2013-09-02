package slimevoid.slopesncorners.core;

import net.minecraftforge.common.Configuration;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.CoreLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(
		modid = CoreLib.MOD_ID,
		name = CoreLib.MOD_NAME,
		version = CoreLib.MOD_VERSION,
		dependencies = CoreLib.MOD_DEPENDENCIES
	)
@NetworkMod(
		clientSideRequired = true,
		serverSideRequired = false
	)

public class SlopesNCorners {

	private static Configuration config;

	@EventHandler
	public void slopesPreInit(FMLPreInitializationEvent event) {
		/**
			You will be able to find the config file in .minecraft/config/ and it
			will be named Dummy.cfg
			here our Configuration has been instantiated, and saved under the name "config"
		**/
		config = new Configuration(event.getSuggestedConfigurationFile());
		// loading the configuration from its file
		config.load();
		// saving the configuration to its file
		config.save();
	}

	@EventHandler
	public void slopesInit(FMLInitializationEvent event){
		MaterialsLib.initMaterials();
	}
	
	@EventHandler
	public void slopesPostInit(FMLPostInitializationEvent event) {

		// loading the configuration from its file
		config.load();
		
		ConfigurationLib.configuration(config);
	}

	public static void registerRenderInformation(int RenderID,
			ISimpleBlockRenderingHandler render) {

		RenderingRegistry.registerBlockHandler(RenderID, render);
	}
}
