package slimevoid.slopesncorners.core;

import java.io.File;

import net.minecraftforge.common.Configuration;
import slimevoid.slopesncorners.core.config.SlopesNCornersConfig;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
@Mod(
		modid="SlimevoidSlopeNCorners",
		name="Slimevoid Slopes and Corners",
		version="2.0.2.0",
		dependencies="after:*")
public class SlopeNCorners
{
	private static Configuration config;
	@PreInit
    public void preInit(FMLPreInitializationEvent event) {
            // you will be able to find the config file in .minecraft/config/ and it will be named Dummy.cfg
            // here our Configuration has been instantiated, and saved under the name "config"
            config = new Configuration(event.getSuggestedConfigurationFile());
            // loading the configuration from its file
            config.load();
            // saving the configuration to its file
            config.save();
    }
	@PostInit
	public void SlopesPostInit(FMLPostInitializationEvent event) {
		
         // loading the configuration from its file
         config.load();
         SlopesNCornersConfig.configuration(config);
	}
	
	public static void registerRenderInformation(int RenderID, ISimpleBlockRenderingHandler render) {
		
		RenderingRegistry.registerBlockHandler(RenderID, render);
	}
}
