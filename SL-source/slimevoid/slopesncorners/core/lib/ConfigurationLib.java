package slimevoid.slopesncorners.core.lib;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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
	public static BlockSlopesBase blockSlopes;
	public static int blockSlopesID;
	public static int slopesRenderID;

	public static void configuration(Configuration config) {
		slopesRenderID = RenderingRegistry.getNextAvailableRenderId();

		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			BlockSlopesRenderer renderHandler = new BlockSlopesRenderer();
			renderHandler.registerSlopeRenderer(0, new BlockSlopesNCornersRenderer());
			renderHandler.registerSlopeRenderer(1, new BlockSideSlopeRenderer());
			renderHandler.registerSlopeRenderer(2, new BlockOblicSlopesRenderer());
			renderHandler.registerSlopeRenderer(3, new BlockTriCornersRenderer());
			SlopesNCorners.registerRenderInformation(slopesRenderID, renderHandler);
		}

		LanguageRegistry.instance().addStringLocalization(
				"itemGroup.slopes", "en_US", "Slopes N' Corners");
		
		blockSlopesID = config
				.get(Configuration.CATEGORY_GENERAL,
						"SlopesBlockID",
						1000,
						"One BlockID for all the slopes")
				.getInt();
		
		String[] baseBlockIdsNDmgs = config
				.get(Configuration.CATEGORY_GENERAL,
						"BaseBlockList",
						new String[] {
							"155",
							"155_1-Chisled Quartz",
							"155_2-Pillar Quartz"
						},
						"Data to generate custom Blocks with the format BaseBlockID<_DMG-Friendly Prefix>. "
								+ "\nexample 35_14-Red Wool will create a slope, slanted corner, and oblic slope blocks"
								+ "\nwith the texture based on the blockid 35 with damage 14, Damage is optional if 0"
								+ "\ndisplay names will use the Friendly prefix given if non is specified then a name"
								+ "\nwill be assigned based on the firendly name of the base block")
				.getStringList();		
		
		config.save();
		blockSlopes = new BlockSlopesBase(blockSlopesID, Material.rock, BlockLib.MAX_TILES);
		GameRegistry.registerBlock(blockSlopes, ItemBlockSlope.class, "slope");
		int lengthMats = baseBlockIdsNDmgs.length + MaterialsLib.minimumlength;
		MaterialsLib.initMaterials(lengthMats);
		int currentmatindex = MaterialsLib.minimumlength;
		for(String custommats:baseBlockIdsNDmgs){
			Integer blockId= Integer.parseInt(custommats.split("-")[0].split("_")[0]);
			Integer blockDMG= custommats.split("-")[0].split("_").length == 1 ? 0:Integer.parseInt(custommats.split("-")[0].split("_")[1]);
			MaterialsLib.addMaterial(currentmatindex, 
					1, //placholder will be axed once we get everything else working
					Block.blocksList[blockId],
					blockDMG,
					custommats.split("-").length == 1 ? 
							Item.itemsList[blockId].getItemStackDisplayName(new ItemStack(blockId,1,blockDMG))
							: custommats.split("-")[1]);
			currentmatindex++;
		}
		
		initializeSlopes();
	}

	private static void initializeSlopes() {
		MaterialsLib.addMaterialHandler(new SlopeMaterialHandler());
		GameRegistry.registerTileEntity(TileEntitySlopes.class, "slope");
		GameRegistry.registerTileEntity(TileEntitySideSlopes.class, "side");
		GameRegistry.registerTileEntity(TileEntityOblicSlopes.class, "oblic");
		GameRegistry.registerTileEntity(TileEntityTriPointCorner.class, "tri");
		blockSlopes.addTileEntityMapping(BlockLib.BLOCK_SLOPES_ID, TileEntitySlopes.class);
		blockSlopes.addTileEntityMapping(BlockLib.BLOCK_SIDES_ID, TileEntitySideSlopes.class);
		blockSlopes.addTileEntityMapping(BlockLib.BLOCK_OBLICS_ID, TileEntityOblicSlopes.class);
		blockSlopes.addTileEntityMapping(BlockLib.BLOCK_TRIPOINT_ID, TileEntityTriPointCorner.class);
		blockSlopes.registerPlacement(BlockLib.BLOCK_SLOPES_ID, new SlopesPlacement());
		blockSlopes.registerPlacement(BlockLib.BLOCK_SIDES_ID, new SideSlopesPlacement());
		blockSlopes.registerPlacement(BlockLib.BLOCK_OBLICS_ID, new OblicSlopesPlacement());
		blockSlopes.registerPlacement(BlockLib.BLOCK_TRIPOINT_ID, new TriPointCornerPlacement());
		
	}	
}
