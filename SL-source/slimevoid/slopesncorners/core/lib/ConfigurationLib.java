package slimevoid.slopesncorners.core.lib;

import java.io.File;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StringTranslate;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import slimevoid.slopesncorners.blocks.BlockSlopesBase;
import slimevoid.slopesncorners.blocks.lib.HalfSlopes;
import slimevoid.slopesncorners.blocks.lib.OblicSlopes;
import slimevoid.slopesncorners.blocks.lib.PointSlopes;
import slimevoid.slopesncorners.blocks.lib.SideSlopes;
import slimevoid.slopesncorners.blocks.lib.Slopes;
import slimevoid.slopesncorners.blocks.lib.TriPointCorners;
import slimevoid.slopesncorners.core.SlopesNCorners;
import slimevoid.slopesncorners.events.LivingSprintingEvent;
import slimevoid.slopesncorners.events.StepSoundEvent;
import slimevoid.slopesncorners.items.ItemBlockSlope;
import slimevoid.slopesncorners.tileentity.TileEntityHalfSlopes;
import slimevoid.slopesncorners.tileentity.TileEntityOblicSlopes;
import slimevoid.slopesncorners.tileentity.TileEntityPointSlopes;
import slimevoid.slopesncorners.tileentity.TileEntitySideSlopes;
import slimevoid.slopesncorners.tileentity.TileEntitySlopes;
import slimevoid.slopesncorners.tileentity.TileEntityTriPointCorner;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ConfigurationLib {
	private static Configuration	configuration;
	public static BlockSlopesBase	blockSlopes;
	public static int				blockSlopesID;
	private static String[]			baseBlockIdsNDmgs;
	@SideOnly(Side.CLIENT)
	public static int				slopesRenderID;

	// public static Material slopesMaterial;

	@SideOnly(Side.CLIENT)
	public static void ClientConfig(File configFile) {
		CommonConfig(configFile);
	}

	public static String[] getBaseBlockList(boolean getLatest) {
		if (getLatest) {
			configuration.load();

			baseBlockIdsNDmgs = configuration.get(	Configuration.CATEGORY_GENERAL,
													"BaseBlockList",
													new String[] {}).getStringList();

			configuration.save();
		}
		return baseBlockIdsNDmgs;
	}

	public static void setBaseBlockList(String[] materialList) {
		baseBlockIdsNDmgs = materialList;
		reInitSlopeMats();
	}

	public static void CommonConfig(File configFile) {
		slopesRenderID = RenderingRegistry.getNextAvailableRenderId();
		
		configuration = new Configuration(configFile);

		configuration.load();

		LanguageRegistry.instance().addStringLocalization(	"itemGroup.slopes",
															"en_US",
															"Slopes N' Corners");

		blockSlopesID = configuration.get(	Configuration.CATEGORY_GENERAL,
											"SlopesBlockID",
											1000,
											"One BlockID for all the slopes").getInt();

		baseBlockIdsNDmgs = configuration.get(	Configuration.CATEGORY_GENERAL,
												"BaseBlockList",
												new String[] {
														"155",
														"155_1-Chisled Quartz",
														"155_2-Pillar Quartz" },
												"Data to generate custom Blocks with the format BaseBlockID<_DMG-Friendly Prefix>. "
														+ "\nexample 35_14-Red Wool will create a slope, slanted corner, and oblic slope blocks"
														+ "\nwith the texture based on the blockid 35 with damage 14, Damage is optional if 0"
														+ "\ndisplay names will use the Friendly prefix given if non is specified then a name"
														+ "\nwill be assigned based on the firendly name of the base block recomended to give a"
														+ "\nFriendly Prefix").getStringList();

		configuration.save();
	}

	public static void registerBlocks() {
		// slopesMaterial = new Material(MapColor.waterColor);
		blockSlopes = new BlockSlopesBase(blockSlopesID, Material.rock, BlockLib.MAX_TILES);
		GameRegistry.registerBlock(	blockSlopes,
									ItemBlockSlope.class,
									"slope");
		initSlopeMats();
		initializeSlopes();
	}

	private static void initializeSlopes() {
		MaterialsLib.addMaterialHandler(Slopes.instance.getMaterialHandler());
		MaterialsLib.addMaterialHandler(OblicSlopes.instance.getMaterialHandler());
		MaterialsLib.addMaterialHandler(HalfSlopes.instance.getMaterialHandler());
		MaterialsLib.addMaterialHandler(SideSlopes.instance.getMaterialHandler());
		MaterialsLib.addMaterialHandler(TriPointCorners.instance.getMaterialHandler());
		MaterialsLib.addMaterialHandler(PointSlopes.instance.getMaterialHandler());
		GameRegistry.registerTileEntity(TileEntitySlopes.class,
										"slope");
		GameRegistry.registerTileEntity(TileEntitySideSlopes.class,
										"side");
		GameRegistry.registerTileEntity(TileEntityOblicSlopes.class,
										"oblic");
		GameRegistry.registerTileEntity(TileEntityTriPointCorner.class,
										"tri");
		GameRegistry.registerTileEntity(TileEntityHalfSlopes.class,
										"halfSlope");
		GameRegistry.registerTileEntity(TileEntityPointSlopes.class,
										"pointSlope");
		blockSlopes.addTileEntityMapping(	BlockLib.BLOCK_SLOPES_ID,
											TileEntitySlopes.class);
		blockSlopes.addTileEntityMapping(	BlockLib.BLOCK_SIDES_ID,
											TileEntitySideSlopes.class);
		blockSlopes.addTileEntityMapping(	BlockLib.BLOCK_OBLICS_ID,
											TileEntityOblicSlopes.class);
		blockSlopes.addTileEntityMapping(	BlockLib.BLOCK_TRIPOINT_ID,
											TileEntityTriPointCorner.class);
		blockSlopes.addTileEntityMapping(	BlockLib.BLOCK_HALF_SLOPE_ID,
											TileEntityHalfSlopes.class);
		blockSlopes.addTileEntityMapping(	BlockLib.BLOCK_POINT_SLOPE_ID,
											TileEntityPointSlopes.class);
		blockSlopes.registerPlacement(	BlockLib.BLOCK_SLOPES_ID,
										Slopes.instance.getPlacementHandler());
		blockSlopes.registerPlacement(	BlockLib.BLOCK_SIDES_ID,
										SideSlopes.instance.getPlacementHandler());
		blockSlopes.registerPlacement(	BlockLib.BLOCK_OBLICS_ID,
										OblicSlopes.instance.getPlacementHandler());
		blockSlopes.registerPlacement(	BlockLib.BLOCK_TRIPOINT_ID,
										TriPointCorners.instance.getPlacementHandler());
		blockSlopes.registerPlacement(	BlockLib.BLOCK_HALF_SLOPE_ID,
										HalfSlopes.instance.getPlacementHandler());
		blockSlopes.registerPlacement(	BlockLib.BLOCK_POINT_SLOPE_ID,
										PointSlopes.instance.getPlacementHandler());
		MinecraftForge.EVENT_BUS.register(new LivingSprintingEvent());
		MinecraftForge.EVENT_BUS.register(new StepSoundEvent());

	}

	public static void reInitSlopeMats() {
		initSlopeMats();
		try {
			//FMLCommonHandler.instance().updateResourcePackList();
			StringTranslate.getInstance().setLanguage(StringTranslate.getInstance().currentLanguage, true);
		} catch (Exception ex) {
		}
	}

	private static void initSlopeMats() {
		MaterialsLib.initMaterials();
		for (String custommats : baseBlockIdsNDmgs) {
			Integer blockId = Integer.parseInt(custommats.split("-")[0].split("_")[0]);
			Integer blockDMG = custommats.split("-")[0].split("_").length == 1 ? 0 : Integer.parseInt(custommats.split("-")[0].split("_")[1]);
			MaterialsLib.addMaterial(	blockId,
										blockDMG,
										custommats.split("-").length == 1 ? Item.itemsList[blockId].getItemDisplayName(new ItemStack(blockId, 1, blockDMG)) : custommats.split("-")[1]);

		}
	}
}
