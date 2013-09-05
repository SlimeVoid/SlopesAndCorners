package slimevoid.slopesncorners.core.lib;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import slimevoid.slopesncorners.blocks.BlockSlopesBase;
import slimevoid.slopesncorners.blocks.lib.OblicSlopesPlacement;
import slimevoid.slopesncorners.blocks.lib.SideSlopesPlacement;
import slimevoid.slopesncorners.blocks.lib.SlopeMaterialHandler;
import slimevoid.slopesncorners.blocks.lib.SlopesPlacement;
import slimevoid.slopesncorners.blocks.lib.TriPointCornerPlacement;
import slimevoid.slopesncorners.client.render.BlockSlopesRenderer;
import slimevoid.slopesncorners.client.render.handlers.BlockOblicSlopesRenderer;
import slimevoid.slopesncorners.client.render.handlers.BlockSideSlopeRenderer;
import slimevoid.slopesncorners.client.render.handlers.BlockSlopesNCornersRenderer;
import slimevoid.slopesncorners.client.render.handlers.BlockTriCornersRenderer;
import slimevoid.slopesncorners.core.SlopesNCorners;
import slimevoid.slopesncorners.items.ItemBlockSlope;
import slimevoid.slopesncorners.tileentity.TileEntityOblicSlopes;
import slimevoid.slopesncorners.tileentity.TileEntitySideSlopes;
import slimevoid.slopesncorners.tileentity.TileEntitySlopes;
import slimevoid.slopesncorners.tileentity.TileEntityTriPointCorner;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

public class ConfigurationLib {
	private static int SlopesCurrentBlockID;
	public static int SlopesNCornersOpacity;

	public static int SideSlopesRenderID;
	public static int TriCornersRenderID;
	public static int OblicSlopesRenderID;
	public static int SlopesNCornersRenderID;
	public static CreativeTabs slopesTab;

	public static List<Block> BlockStairs = new ArrayList<Block>();
	public static List<Block> BlockSlopesNCorners = new ArrayList<Block>();
	public static List<Block> BlockSideSlopes = new ArrayList<Block>();
	public static List<Block> BlockTriCorners = new ArrayList<Block>();
	public static List<Block> BlockOblicCorners = new ArrayList<Block>();
	public static BlockSlopesBase blockSlopes;
	public static int blockSlopesID;
	public static int slopesRenderID;

	public static void configuration(Configuration config) {
		slopesRenderID = RenderingRegistry.getNextAvailableRenderId();
/*		SlopesNCornersRenderID = RenderingRegistry.getNextAvailableRenderId();
		SideSlopesRenderID = RenderingRegistry.getNextAvailableRenderId();
		TriCornersRenderID = RenderingRegistry.getNextAvailableRenderId();
		OblicSlopesRenderID = RenderingRegistry.getNextAvailableRenderId();*/

		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			BlockSlopesRenderer renderHandler = new BlockSlopesRenderer();
			renderHandler.registerSlopeRenderer(0, new BlockSlopesNCornersRenderer());
			renderHandler.registerSlopeRenderer(1, new BlockSideSlopeRenderer());
			renderHandler.registerSlopeRenderer(2, new BlockOblicSlopesRenderer());
			renderHandler.registerSlopeRenderer(3, new BlockTriCornersRenderer());
			//renderHandler.registerSlopeRenderer(4, new BlockOblicSlopesRenderer());
			SlopesNCorners.registerRenderInformation(slopesRenderID, renderHandler);
/*			SlopesNCorners.registerRenderInformation(
					SlopesNCornersRenderID,
					new BlockSlopesNCornersRenderer());
			SlopesNCorners.registerRenderInformation(
					SideSlopesRenderID,
					new BlockSideSlopeRenderer());
			SlopesNCorners.registerRenderInformation(
					OblicSlopesRenderID,
					new BlockOblicSlopesRenderRenderer());
			SlopesNCorners.registerRenderInformation(
					TriCornersRenderID,
					new BlockTriCornersRenderer());*/
		}

		slopesTab = new CreativeTabs("tabCustom") {
			public ItemStack getIconItemStack() {
				return new ItemStack(blockSlopes, 1, 0);
			}

		};
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup.tabCustom", "en_US", "Slopes N' Corners");
		SlopesNCornersOpacity = config
				.get(Configuration.CATEGORY_GENERAL, "Slopes_Opacity", 0,
						"The Opacity of none Stair Blocks effects lighting 0 = clear 255 = solid")
				.getInt();
		SlopesCurrentBlockID = config
				.get(Configuration.CATEGORY_GENERAL,
						"SlopesStartBlockID",
						2000,
						"The Blocks will be generated starting at this block ID. Will skip over any used block slots so don't "
								+ "\nneed a massive chunk of free IDs as long as there is enough empty spaces for all the blocks defined")
				.getInt();
		String[] baseBlockIdsNDmgs = config
				.get(Configuration.CATEGORY_GENERAL,
						"BaseBlockList",
						new String[] {
							"155-Quartz",
							"155_1-ChisledQuartz",
							"155_2-PillarQuartz_Pillar Quartz"
						},
						"Data to generate custom Blocks with the format BaseBlockID<_DMG>-unfriendly Prefix<_Friendly Prefix>. "
						+ "\nexample 35_14-RedWool_Red Wool will create a stair, slope, slanted corner, and oblic slope blocks"
						+ "\nwith the texture based on the blockid 35 with damage 14, display names will use the prefix given "
						+ "\nif no Friendly version is given then the unfriendly Prefix will be used with spaces added in front"
						+ "\nof each capital. DMG and Friendly names are optional")
				.getStringList();
		String[] baseBlocksWithStairs = config
				.get(Configuration.CATEGORY_GENERAL,
						"baseBlocksWithStairsList",
						new String[] {
							"4-67",
							"5-53",
							"5_1-134",
							"5_2-135",
							"5_3-136", 
							"24-128",
							"98-109",
							"112-114",
							"155-156"
						},
						"Blocks that already have a stair defined for them either by other Mods or Vannila "
						+ "\nexample 5:2;135:0 tells us that the Blockid 5 with damage 2 already has a stair block at blockid 135 damage 0"
						+ "\nNote DMG is optional if dmg is 0")
				.getStringList();
		blockSlopesID = 1000; 
		int lengthMats = baseBlockIdsNDmgs.length + MaterialsLib.minimumlength;
		MaterialsLib.initMaterials(lengthMats);
		int currentmatindex = MaterialsLib.minimumlength;
		for(String custommats:baseBlockIdsNDmgs){
			String blockIdNDmg = custommats.split("-")[0];
			
			MaterialsLib.addMaterial(currentmatindex, 
					1, //placholder will be axed once we get everything else working
					Block.blocksList[Integer.parseInt(blockIdNDmg.split("_")[0])],
					blockIdNDmg.split("_").length == 1 ? 0:Integer.parseInt(blockIdNDmg.split("_")[1]),
					custommats.split("-").length == 1 ? Block.blocksList[Integer.parseInt(blockIdNDmg.split("_")[0])].getUnlocalizedName() : custommats.split("-")[1].split("_")[0],
					custommats.split("-").length == 1 ? Block.blocksList[Integer.parseInt(blockIdNDmg.split("_")[0])].getLocalizedName() : custommats.split("-")[1].split("_").length == 1?custommats.split("-")[1].replaceAll(
							"(\\p{Ll})(\\p{Lu})",
							"$1 $2") :custommats.split("-")[1].split("_")[1]);
			currentmatindex++;
		}
		//initializeSlopesNCorners(baseBlockIdsNDmgs,
		//initializeStairs(baseBlockIdsNDmgs, baseBlocksWithStairs));
		//initializeSideSlopes(baseBlockIdsNDmgs);
		//initializeTriCorners(baseBlockIdsNDmgs);
		//initializeOblicSlopes(baseBlockIdsNDmgs);
		config.save();
		initializeSlopes();
	}

	private static void initializeSlopes() {
		MaterialsLib.addMaterialHandler(new SlopeMaterialHandler());
		GameRegistry.registerTileEntity(TileEntitySlopes.class, "slope");
		GameRegistry.registerTileEntity(TileEntitySideSlopes.class, "side");
		GameRegistry.registerTileEntity(TileEntityOblicSlopes.class, "oblic");
		GameRegistry.registerTileEntity(TileEntityTriPointCorner.class, "tri");
		blockSlopes = new BlockSlopesBase(blockSlopesID, Material.rock, BlockLib.MAX_TILES);
		GameRegistry.registerBlock(blockSlopes, ItemBlockSlope.class, "slope");
		blockSlopes.addTileEntityMapping(0, TileEntitySlopes.class);
		blockSlopes.addTileEntityMapping(1, TileEntitySideSlopes.class);
		blockSlopes.addTileEntityMapping(2, TileEntityOblicSlopes.class);
		blockSlopes.addTileEntityMapping(3, TileEntityTriPointCorner.class);
		//blockSlopes.addTileEntityMapping(4, TileEntityStairs.class);
		blockSlopes.registerPlacement(0, new SlopesPlacement());
		blockSlopes.registerPlacement(1, new SideSlopesPlacement());
		blockSlopes.registerPlacement(2, new OblicSlopesPlacement());
		blockSlopes.registerPlacement(3, new TriPointCornerPlacement());
		//blockSlopes.registerPlacement(4, new StairsPlacement());
		
	}	
}
