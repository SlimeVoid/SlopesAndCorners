package slimevoid.slopesncorners.core.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import slimevoid.slopesncorners.blocks.BlockTriPointCorner;
import slimevoid.slopesncorners.blocks.BlockOblicSlopes;
import slimevoid.slopesncorners.blocks.BlockSideSlopes;
import slimevoid.slopesncorners.blocks.BlockSlopesNCorners;
import slimevoid.slopesncorners.blocks.BlockStairsPublic;
import slimevoid.slopesncorners.client.render.BlockOblicSlopesRenderRenderer;
import slimevoid.slopesncorners.client.render.BlockSideSlopeRenderer;
import slimevoid.slopesncorners.client.render.BlockSlopesNCornersRenderer;
import slimevoid.slopesncorners.client.render.BlockTriCornersRenderer;
import slimevoid.slopesncorners.core.SlopeNCorners;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

public class SlopesNCornersConfig
{
	public static int SlopesNCornersOpacity;
	
	public static int	SideSlopesRenderID;
	public static int	TriCornersRenderID;
	public static int	OblicSlopesRenderID;
	public static int SlopesNCornersRenderID;
	public static CreativeTabs tabCustom;
	
	public static Block BlockGlassStairs;
	public static Block BlockDirtStairs;
	public static Block BlockSandStairs;
	public static Block BlockblockSnowStairs;
	public static Block BlockGrassStairs;
	public static Block BlockGravelStairs;
	public static Block BlockGoldStairs;
	public static Block BlockSteelStairs;
	public static Block BlockObsidianStairs;
	public static Block BlockDiamondStairs;
	public static Block BlockWhiteWoolStairs;
	public static Block BlockBlackWoolStairs;
	public static Block BlockRedWoolStairs;
	public static Block BlockGreenWoolStairs;
	public static Block BlockBrownWoolStairs;
	public static Block BlockBlueWoolStairs;
	public static Block BlockPurpleWoolStairs;
	public static Block BlockCyanWoolStairs;
	public static Block BlockSilverWoolStairs;
	public static Block BlockGrayWoolStairs;
	public static Block BlockPinkWoolStairs;
	public static Block BlockLimeWoolStairs;
	public static Block BlockYellowWoolStairs;
	public static Block BlockLightBlueWoolStairs;
	public static Block BlockMagentaWoolStairs;
	public static Block BlockOrangeWoolStairs;	
	
	public static Block BlockPlankOakSlopesNCorners;
	public static Block BlockPlankSpruceSlopesNCorners;
	public static Block BlockPlankJungleSlopesNCorners;
	public static Block BlockPlankBirchSlopesNCorners;
	public static Block BlockCobblestoneSlopesNCorners;
	public static Block BlockGlassSlopesNCorners;
	public static Block BlockSandstoneSlopesNCorners;
	public static Block BlockDirtSlopesNCorners;
	public static Block BlockStoneSlopesNCorners;
	public static Block BlockSandSlopesNCorners;
	public static Block BlockblockSnowSlopesNCorners;
	public static Block BlockGrassSlopesNCorners;
	public static Block BlockBricksSlopesNCorners;
	public static Block BlockGravelSlopesNCorners;
	public static Block BlockGoldSlopesNCorners;
	public static Block BlockSteelSlopesNCorners;
	public static Block BlockObsidianSlopesNCorners;
	public static Block BlockDiamondSlopesNCorners;
	public static Block BlockWhiteWoolSlopesNCorners;
	public static Block BlockBlackWoolSlopesNCorners;
	public static Block BlockRedWoolSlopesNCorners;
	public static Block BlockGreenWoolSlopesNCorners;
	public static Block BlockBrownWoolSlopesNCorners;
	public static Block BlockBlueWoolSlopesNCorners;
	public static Block BlockPurpleWoolSlopesNCorners;
	public static Block BlockCyanWoolSlopesNCorners;
	public static Block BlockSilverWoolSlopesNCorners;
	public static Block BlockGrayWoolSlopesNCorners;
	public static Block BlockPinkWoolSlopesNCorners;
	public static Block BlockLimeWoolSlopesNCorners;
	public static Block BlockYellowWoolSlopesNCorners;
	public static Block BlockLightBlueWoolSlopesNCorners;
	public static Block BlockMagentaWoolSlopesNCorners;
	public static Block BlockOrangeWoolSlopesNCorners;	
	public static Block	BlockNetherBrickSlopesNCorners;
	public static Block	BlockNetherQuartzSlopesNCorners;
	
	public static Block BlockPlankOakSideSlopes;
	public static Block BlockPlankSpruceSideSlopes;
	public static Block BlockPlankJungleSideSlopes;
	public static Block BlockPlankBirchSideSlopes;
	public static Block BlockCobblestoneSideSlopes;
	public static Block BlockGlassSideSlopes;
	public static Block BlockSandstoneSideSlopes;
	public static Block BlockDirtSideSlopes;
	public static Block BlockStoneSideSlopes;
	public static Block BlockSandSideSlopes;
	public static Block BlockblockSnowSideSlopes;
	public static Block BlockGrassSideSlopes;
	public static Block BlockBricksSideSlopes;
	public static Block BlockGravelSideSlopes;
	public static Block BlockGoldSideSlopes;
	public static Block BlockSteelSideSlopes;
	public static Block BlockObsidianSideSlopes;
	public static Block BlockDiamondSideSlopes;
	public static Block BlockWhiteWoolSideSlopes;
	public static Block BlockBlackWoolSideSlopes;
	public static Block BlockRedWoolSideSlopes;
	public static Block BlockGreenWoolSideSlopes;
	public static Block BlockBrownWoolSideSlopes;
	public static Block BlockBlueWoolSideSlopes;
	public static Block BlockPurpleWoolSideSlopes;
	public static Block BlockCyanWoolSideSlopes;
	public static Block BlockSilverWoolSideSlopes;
	public static Block BlockGrayWoolSideSlopes;
	public static Block BlockPinkWoolSideSlopes;
	public static Block BlockLimeWoolSideSlopes;
	public static Block BlockYellowWoolSideSlopes;
	public static Block BlockLightBlueWoolSideSlopes;
	public static Block BlockMagentaWoolSideSlopes;
	public static Block BlockOrangeWoolSideSlopes;
	public static Block BlockNetherBrickSideSlopes;
	public static Block BlockNetherQuartzSideSlopes;
	
	public static Block BlockPlankOakIntCorners;
	public static Block BlockPlankSpruceIntCorners;
	public static Block BlockPlankJungleIntCorners;
	public static Block BlockPlankBirchIntCorners;
	public static Block BlockCobblestoneIntCorners;
	public static Block BlockGlassIntCorners;
	public static Block BlockSandstoneIntCorners;
	public static Block BlockDirtIntCorners;
	public static Block BlockStoneIntCorners;
	public static Block BlockSandIntCorners;
	public static Block BlockblockSnowIntCorners;
	public static Block BlockGrassIntCorners;
	public static Block BlockBricksIntCorners;
	public static Block BlockGravelIntCorners;
	public static Block BlockGoldIntCorners;
	public static Block BlockSteelIntCorners;
	public static Block BlockObsidianIntCorners;
	public static Block BlockDiamondIntCorners;
	public static Block BlockWhiteWoolIntCorners;
	public static Block BlockBlackWoolIntCorners;
	public static Block BlockRedWoolIntCorners;
	public static Block BlockGreenWoolIntCorners;
	public static Block BlockBrownWoolIntCorners;
	public static Block BlockBlueWoolIntCorners;
	public static Block BlockPurpleWoolIntCorners;
	public static Block BlockCyanWoolIntCorners;
	public static Block BlockSilverWoolIntCorners;
	public static Block BlockGrayWoolIntCorners;
	public static Block BlockPinkWoolIntCorners;
	public static Block BlockLimeWoolIntCorners;
	public static Block BlockYellowWoolIntCorners;
	public static Block BlockLightBlueWoolIntCorners;
	public static Block BlockMagentaWoolIntCorners;
	public static Block BlockOrangeWoolIntCorners;
	public static Block BlockNetherBrickIntCorners;
	public static Block BlockNetherQuartzIntCorners;

	public static Block BlockPlankOakCorners;
	public static Block BlockPlankBirchCorners;
	public static Block BlockPlankSpruceCorners;
	public static Block BlockPlankJungleCorners;
	public static Block BlockCobblestoneCorners;
	public static Block BlockGlassCorners;
	public static Block BlockSandstoneCorners;
	public static Block BlockDirtCorners;
	public static Block BlockStoneCorners;
	public static Block BlockSandCorners;
	public static Block BlockSnowCorners;
	public static Block BlockGrassCorners;
	public static Block BlockBricksCorners;
	public static Block BlockGravelCorners;
	public static Block BlockGoldCorners;
	public static Block BlockSteelCorners;
	public static Block BlockObsidianCorners;
	public static Block BlockDiamondCorners;
	public static Block BlockWhiteWoolCorners;
	public static Block BlockBlackWoolCorners;
	public static Block BlockRedWoolCorners;
	public static Block BlockGreenWoolCorners;
	public static Block BlockBrownWoolCorners;
	public static Block BlockBlueWoolCorners;
	public static Block BlockPurpleWoolCorners;
	public static Block BlockCyanWoolCorners;
	public static Block BlockSilverWoolCorners;
	public static Block BlockGrayWoolCorners;
	public static Block BlockPinkWoolCorners;
	public static Block BlockLimeWoolCorners;
	public static Block BlockYellowWoolCorners;
	public static Block BlockLightBlueWoolCorners;
	public static Block BlockMagentaWoolCorners;
	public static Block BlockOrangeWoolCorners;
	public static Block	BlockNetherBricksCorners;
	public static Block	BlockNetherQuartzCorners;

	private static Block	BlockStoneBrickSlopesNCorners;

	private static Block	BlockStoneStairs;

	private static Block	BlockStoneBrickSideSlopes;

	private static Block	BlockStoneBrickCorners;

	private static Block	BlockStoneBrickIntCorners;	
	
	public static void configuration(Configuration config,Configuration portalscfg) {
		SlopesNCornersRenderID = RenderingRegistry.getNextAvailableRenderId();
		SideSlopesRenderID =  RenderingRegistry.getNextAvailableRenderId();
		TriCornersRenderID =RenderingRegistry.getNextAvailableRenderId();
		OblicSlopesRenderID =RenderingRegistry.getNextAvailableRenderId();
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT){
			SlopeNCorners.registerRenderInformation(SlopesNCornersRenderID, new BlockSlopesNCornersRenderer());
			SlopeNCorners.registerRenderInformation(SideSlopesRenderID, new BlockSideSlopeRenderer());
			SlopeNCorners.registerRenderInformation(OblicSlopesRenderID, new BlockOblicSlopesRenderRenderer());
			SlopeNCorners.registerRenderInformation(TriCornersRenderID, new BlockTriCornersRenderer());
		}
		SlopesNCornersOpacity = config.get(Configuration.CATEGORY_GENERAL, "Slopes_Opacity",0).getInt();
		tabCustom = new CreativeTabs("tabCustom") {
            public ItemStack getIconItemStack() {
                    return new ItemStack(BlockPlankOakSlopesNCorners, 1);
            }
            
    };
    LanguageRegistry.instance().addStringLocalization("itemGroup.tabCustom", "en_US", "Slopes N' Corners");
		initializeStairs(config,portalscfg);		
		initializeSlopesNCorners(config);
		initializeSideSlopes(config);
		initializeTriCorners(config);
		initializeOblicSlopes(config);
	}
	
	private static void initializeStairs(Configuration config,Configuration portalscfg){
		if (config.getBlock("BlockGlassStairs", 3900).getInt() != 0) {
			BlockGlassStairs = new BlockStairsPublic(
					config.getBlock("BlockGlassStairs", 3900).getInt(),Block.glass)
			.setUnlocalizedName("BlockGlassStairs");
			GameRegistry.registerBlock(BlockGlassStairs,"BlockGlassStairs");
			LanguageRegistry.addName(BlockGlassStairs, "Glass Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGlassStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.glass)});
			
		}
		if (config.getBlock("BlockDirtStairs", 3901).getInt() != 0) {
			BlockDirtStairs = new BlockStairsPublic(
					config.getBlock("BlockDirtStairs", 3901).getInt(),Block.dirt)
			.setUnlocalizedName("BlockDirtStairs");
			GameRegistry.registerBlock(BlockDirtStairs,"BlockDirtStairs");
			LanguageRegistry.addName(BlockDirtStairs, "Dirt Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockDirtStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.dirt)});
		}
		if (config.getBlock("BlockStoneStairs", 4070).getInt() != 0) {
			BlockStoneStairs = new BlockStairsPublic(
					config.getBlock("BlockStoneStairs", 4070).getInt(),Block.stone)
			.setUnlocalizedName("BlockStoneStairs");
			GameRegistry.registerBlock(BlockStoneStairs,"BlockStoneStairs");
			LanguageRegistry.addName(BlockStoneStairs, "Stone Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockStoneStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.stone)});
			GameRegistry.addSmelting(Block.stairsCobblestone.blockID, new ItemStack(BlockStoneStairs), 0.1F);
		}
		if (config.getBlock("BlockSandStairs", 3902).getInt() != 0) {
			BlockSandStairs = new BlockStairsPublic(
					config.getBlock("BlockSandStairs", 3902).getInt(),Block.sand)
			.setUnlocalizedName("BlockSandStairs");
			GameRegistry.registerBlock(BlockSandStairs,"BlockSandStairs");
			LanguageRegistry.addName(BlockSandStairs, "Sand Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockSandStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.sand)});
		}
		if (config.getBlock("BlockblockSnowStairs", 3903).getInt() != 0) {
			BlockblockSnowStairs = new BlockStairsPublic(
					config.getBlock("BlockblockSnowStairs", 3903).getInt(),Block.blockSnow)
			.setUnlocalizedName("BlockblockSnowStairs");
			GameRegistry.registerBlock(BlockblockSnowStairs,"BlockblockSnowStairs");
			LanguageRegistry.addName(BlockblockSnowStairs, "Snow Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockblockSnowStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.blockSnow)});
		}
		if (config.getBlock("BlockGrassStairs", 3904).getInt() != 0) {
			BlockGrassStairs = new BlockStairsPublic(
					config.getBlock("BlockGrassStairs", 3904).getInt(),Block.grass)
			.setUnlocalizedName("BlockGrassStairs");
			GameRegistry.registerBlock(BlockGrassStairs,"BlockGrassStairs");
			LanguageRegistry.addName(BlockGrassStairs, "Grass Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGrassStairs,4),new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.grass)});
		}
		if (config.getBlock("BlockGravelStairs", 3905).getInt() != 0) {
			BlockGravelStairs = new BlockStairsPublic(
					config.getBlock("BlockGravelStairs", 3905).getInt(),Block.gravel)
			.setUnlocalizedName("BlockGravelStairs");
			GameRegistry.registerBlock(BlockGravelStairs,"BlockGravelStairs");
			LanguageRegistry.addName(BlockGravelStairs, "Gravel Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGravelStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.gravel)});
		}
		if (config.getBlock("BlockGoldStairs", 3906).getInt() != 0) {
			BlockGoldStairs = new BlockStairsPublic(
					config.getBlock("BlockGoldStairs", 3906).getInt(),Block.blockGold)
			.setUnlocalizedName("BlockGoldStairs");
			GameRegistry.registerBlock(BlockGoldStairs,"BlockGoldStairs");
			LanguageRegistry.addName(BlockGoldStairs, "Gold Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGoldStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.blockGold)});
		}
		if (config.getBlock("BlockSteelStairs", 3907).getInt() != 0) {
			BlockSteelStairs = new BlockStairsPublic(
					config.getBlock("BlockSteelStairs", 3907).getInt(),Block.blockIron)
			.setUnlocalizedName("BlockSteelStairs");
			GameRegistry.registerBlock(BlockSteelStairs,"BlockSteelStairs");
			LanguageRegistry.addName(BlockSteelStairs, "Iron Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockSteelStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.blockIron)});
		}
		if (portalscfg.get(Configuration.CATEGORY_BLOCK,"ObsidianStairsID", 0).getInt() !=0){
			BlockObsidianStairs = Block.blocksList[portalscfg.getBlock("ObsidianStairsID", 0).getInt()];
		}else if (config.getBlock("BlockObsidianStairs", 3908).getInt() != 0) {
			BlockObsidianStairs = new BlockStairsPublic(
					config.getBlock("BlockObsidianStairs", 3908).getInt(),Block.obsidian)
			.setUnlocalizedName("BlockObsidianStairs");
			GameRegistry.registerBlock(BlockObsidianStairs,"BlockObsidianStairs");
			LanguageRegistry.addName(BlockObsidianStairs, "Obsidian Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockObsidianStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.obsidian)});
		}
		if (config.getBlock("BlockDiamondStairs", 3909).getInt() != 0) {
			BlockDiamondStairs = new BlockStairsPublic(
					config.getBlock("BlockDiamondStairs", 3909).getInt(),Block.blockDiamond)
			.setUnlocalizedName("BlockDiamondStairs");
			GameRegistry.registerBlock(BlockDiamondStairs,"BlockDiamondStairs");
			LanguageRegistry.addName(BlockDiamondStairs, "Diamond Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockDiamondStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.blockDiamond)});
		}
		if (config.getBlock("BlockWhiteWoolStairs", 3910).getInt() != 0) {
			BlockWhiteWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockWhiteWoolStairs", 3910).getInt(),Block.cloth)
			.setUnlocalizedName("BlockWhiteWoolStairs");
			GameRegistry.registerBlock(BlockWhiteWoolStairs,"BlockWhiteWoolStairs");
			LanguageRegistry.addName(BlockWhiteWoolStairs, "Wool Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockWhiteWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth)});
		}
		if (config.getBlock("BlockBlackWoolStairs", 3911).getInt() != 0) {
			BlockBlackWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockBlackWoolStairs", 3911).getInt(),Block.cloth, 15)
			.setUnlocalizedName("BlockBlackWoolStairs");
			GameRegistry.registerBlock(BlockBlackWoolStairs,"BlockBlackWoolStairs");
			LanguageRegistry.addName(BlockBlackWoolStairs, "Black Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockBlackWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,15)});
		}
		if (config.getBlock("BlockRedWoolStairs", 3912).getInt() != 0) {
			BlockRedWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockRedWoolStairs", 3912).getInt(),Block.cloth, 14)
			.setUnlocalizedName("BlockRedWoolStairs");
			GameRegistry.registerBlock(BlockRedWoolStairs,"BlockRedWoolStairs");
			LanguageRegistry.addName(BlockRedWoolStairs, "Red Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockRedWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,14)});
		}
		if (config.getBlock("BlockGreenWoolStairs", 3913).getInt() != 0) {
			BlockGreenWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockGreenWoolStairs", 3913).getInt(),Block.cloth,13)
			.setUnlocalizedName("BlockGreenWoolStairs");
			GameRegistry.registerBlock(BlockGreenWoolStairs,"BlockGreenWoolStairs");
			LanguageRegistry.addName(BlockGreenWoolStairs, "Green Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGreenWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,13)});
		}
		if (config.getBlock("BlockBrownWoolStairs", 3914).getInt() != 0) {
			BlockBrownWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockBrownWoolStairs", 3914).getInt(),Block.cloth,12)
			.setUnlocalizedName("BlockBrownWoolStairs");
			GameRegistry.registerBlock(BlockBrownWoolStairs,"BlockBrownWoolStairs");
			LanguageRegistry.addName(BlockBrownWoolStairs, "Brown Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockBrownWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,12)});
		}
		if (config.getBlock("BlockBlueWoolStairs", 3915).getInt() != 0) {
			BlockBlueWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockBlueWoolStairs", 3915).getInt(),Block.cloth,11)
			.setUnlocalizedName("BlockBlueWoolStairs");
			GameRegistry.registerBlock(BlockBlueWoolStairs,"BlockBlueWoolStairs");
			LanguageRegistry.addName(BlockBlueWoolStairs, "Blue Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockBlueWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,11)});
		}
		if (config.getBlock("BlockPurpleWoolStairs", 3916).getInt() != 0) {
			BlockPurpleWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockPurpleWoolStairs", 3916).getInt(),Block.cloth,10)
			.setUnlocalizedName("BlockPurpleWoolStairs");
			GameRegistry.registerBlock(BlockPurpleWoolStairs,"BlockPurpleWoolStairs");
			LanguageRegistry.addName(BlockPurpleWoolStairs, "Purple Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockPurpleWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,10)});
		}
		if (config.getBlock("BlockCyanWoolStairs", 3917).getInt() != 0) {
			BlockCyanWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockCyanWoolStairs", 3917).getInt(),Block.cloth,9)
			.setUnlocalizedName("BlockCyanWoolStairs");
			GameRegistry.registerBlock(BlockCyanWoolStairs,"BlockCyanWoolStairs");
			LanguageRegistry.addName(BlockCyanWoolStairs, "Cyan Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockCyanWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,9)});
		}
		if (config.getBlock("BlockSilverWoolStairs", 3918).getInt() != 0) {
			BlockSilverWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockSilverWoolStairs", 3918).getInt(),Block.cloth,8)
			.setUnlocalizedName("BlockSilverWoolStairs");
			GameRegistry.registerBlock(BlockSilverWoolStairs,"BlockSilverWoolStairs");
			LanguageRegistry.addName(BlockSilverWoolStairs, "Silver Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockSilverWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,8)});
		}
		if (config.getBlock("BlockGrayWoolStairs", 3919).getInt() != 0) {
			BlockGrayWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockGrayWoolStairs", 3919).getInt(),Block.cloth,7)
			.setUnlocalizedName("BlockGrayWoolStairs");
			GameRegistry.registerBlock(BlockGrayWoolStairs,"BlockGrayWoolStairs");
			LanguageRegistry.addName(BlockGrayWoolStairs, "Gray Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGrayWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,7)});
		}
		if (config.getBlock("BlockPinkWoolStairs", 3920).getInt() != 0) {
			BlockPinkWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockPinkWoolStairs", 3920).getInt(),Block.cloth,6)
			.setUnlocalizedName("BlockPinkWoolStairs");
			GameRegistry.registerBlock(BlockPinkWoolStairs,"BlockPinkWoolStairs");
			LanguageRegistry.addName(BlockPinkWoolStairs, "Pink Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockPinkWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,6)});
		}
		if (config.getBlock("BlockLimeWoolStairs", 3921).getInt() != 0) {
			BlockLimeWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockLimeWoolStairs", 3921).getInt(),Block.cloth,5)
			.setUnlocalizedName("BlockLimeWoolStairs");
			GameRegistry.registerBlock(BlockLimeWoolStairs,"BlockLimeWoolStairs");
			LanguageRegistry.addName(BlockLimeWoolStairs, "Lime Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockLimeWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,5)});
		}
		if (config.getBlock("BlockYellowWoolStairs", 3922).getInt() != 0) {
			BlockYellowWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockYellowWoolStairs", 3922).getInt(),Block.cloth,4)
			.setUnlocalizedName("BlockYellowWoolStairs");
			GameRegistry.registerBlock(BlockYellowWoolStairs,"BlockYellowWoolStairs");
			LanguageRegistry.addName(BlockYellowWoolStairs, "Yellow Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockYellowWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,4)});
		}
		if (config.getBlock("BlockLightBlueWoolStairs", 3923).getInt() != 0) {
			BlockLightBlueWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockLightBlueWoolStairs", 3923).getInt(),Block.cloth,3)
			.setUnlocalizedName("BlockLightBlueWoolStairs");
			GameRegistry.registerBlock(BlockLightBlueWoolStairs,"BlockLightBlueWoolStairs");
			LanguageRegistry.addName(BlockLightBlueWoolStairs, "Light Blue Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockLightBlueWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,3)});
		}
		if (config.getBlock("BlockMagentaWoolStairs", 3924).getInt() != 0) {
			BlockMagentaWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockMagentaWoolStairs", 3924).getInt(),Block.cloth,2)
			.setUnlocalizedName("BlockMagentaWoolStairs");
			GameRegistry.registerBlock(BlockMagentaWoolStairs,"BlockMagentaWoolStairs");
			LanguageRegistry.addName(BlockMagentaWoolStairs, "Magenta Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockMagentaWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,2)});
		}
		if (config.getBlock("BlockOrangeWoolStairs", 3925).getInt() != 0) {
			BlockOrangeWoolStairs = new BlockStairsPublic(
					config.getBlock("BlockOrangeWoolStairs", 3925).getInt(),Block.cloth,1)
			.setUnlocalizedName("BlockOrangeWoolStairs");
			GameRegistry.registerBlock(BlockOrangeWoolStairs,"BlockOrangeWoolStairs");
			LanguageRegistry.addName(BlockOrangeWoolStairs, "Orange Stairs");
			GameRegistry.addShapedRecipe(new ItemStack(BlockOrangeWoolStairs,4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.cloth,1,1)});
		}
		config.save();
	}
	
	private static void initializeSlopesNCorners(Configuration config) {
		
		if (config.getBlock("BlockPlankSpruceSlopes", 3926).getInt() != 0) {
			BlockPlankSpruceSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockPlankSpruceSlopes", 3926).getInt(),
					Block.planks, 1).setUnlocalizedName("BlockPlankSpruceSlopes");
			GameRegistry.registerBlock(BlockPlankSpruceSlopesNCorners,"BlockPlankSpruceSlopes");
			LanguageRegistry.addName(BlockPlankSpruceSlopesNCorners, "Spruce Wood Slope");
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPlankSpruceSlopesNCorners), new ItemStack(Block.stairsWoodSpruce));
		} 
		if (config.getBlock("BlockPlankBirchSlopes", 3927).getInt() != 0) {
			BlockPlankBirchSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockPlankBirchSlopes", 3927).getInt(),
					Block.planks, 2).setUnlocalizedName("BlockPlankBirchSlopes");
			GameRegistry.registerBlock(BlockPlankBirchSlopesNCorners,"BlockPlankBirchSlopes");
			LanguageRegistry.addName(BlockPlankBirchSlopesNCorners, "Birch Wood Slope");
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPlankBirchSlopesNCorners), new ItemStack(Block.stairsWoodBirch));
		} 
		if (config.getBlock("BlockPlankJungleSlopes", 3928).getInt() != 0) {
			BlockPlankJungleSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockPlankJungleSlopes", 3928).getInt(),
					Block.planks, 3).setUnlocalizedName("BlockPlankJungleSlopes");
			GameRegistry.registerBlock(BlockPlankJungleSlopesNCorners,"BlockPlankJungleSlopes");
			LanguageRegistry.addName(BlockPlankJungleSlopesNCorners, "Jungle Wood Slope");
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPlankJungleSlopesNCorners), new ItemStack(Block.stairsWoodJungle));
		} 
		if (config.getBlock("BlockPlankOakSlopes", 3929).getInt() != 0) {
			BlockPlankOakSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockPlankOakSlopes", 3929).getInt(),
					Block.planks).setUnlocalizedName("BlockPlankOakSlopes");
			GameRegistry.registerBlock(BlockPlankOakSlopesNCorners,"BlockPlankOakSlopes");
			LanguageRegistry.addName(BlockPlankOakSlopesNCorners, "Oak Wood Slope");
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPlankOakSlopesNCorners), new ItemStack(Block.stairsWoodOak));
		} 
		if (config.getBlock("BlockCobblestoneSlopes", 3930).getInt() != 0) {
			BlockCobblestoneSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockCobblestoneSlopes", 3930).getInt(),
					Block.cobblestone,
					 0).setUnlocalizedName("BlockCobblestoneSlopes");
			GameRegistry.registerBlock(BlockCobblestoneSlopesNCorners,"BlockCobblestoneSlopes");
			LanguageRegistry.addName(BlockCobblestoneSlopesNCorners, "CobbleStone Slope");
			GameRegistry.addShapelessRecipe(new ItemStack(BlockCobblestoneSlopesNCorners), new ItemStack(Block.stairsCobblestone));
		} 
		if (config.getBlock("BlockGlassSlopes", 3931).getInt() != 0) {
			BlockGlassSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockGlassSlopes", 3931).getInt(),
					  Block.glass).setUnlocalizedName("BlockGlassSlopes");
			GameRegistry.registerBlock(BlockGlassSlopesNCorners,"BlockGlassSlopes");
			LanguageRegistry.addName(BlockGlassSlopesNCorners, "Glass Slope");
			if(BlockGlassStairs != null)GameRegistry.addShapelessRecipe(new ItemStack(BlockGlassSlopesNCorners), new ItemStack(BlockGlassStairs));
		} 
		
		if (config.getBlock("BlockSandstoneSlopes", 3932).getInt() != 0) {
			BlockSandstoneSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockSandstoneSlopes", 3932).getInt(),
					  Block.sandStone).setUnlocalizedName("BlockSandstoneSlopes");
			GameRegistry.registerBlock(BlockSandstoneSlopesNCorners,"BlockSandstoneSlopes");
			LanguageRegistry.addName(BlockSandstoneSlopesNCorners, "Sandstone Slope");
			GameRegistry.addShapelessRecipe(new ItemStack(BlockSandstoneSlopesNCorners), new ItemStack(Block.stairsSandStone));
		} 
		if (config.getBlock("BlockDirtSlopes", 3933).getInt() != 0) {
			BlockDirtSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockDirtSlopes", 3933).getInt(),
					  Block.dirt).setUnlocalizedName("BlockDirtSlopes");
			GameRegistry.registerBlock(BlockDirtSlopesNCorners,"BlockDirtSlopes");
			LanguageRegistry.addName(BlockDirtSlopesNCorners, "Dirt Slope");
			if(BlockDirtStairs != null)GameRegistry.addShapelessRecipe(new ItemStack(BlockDirtSlopesNCorners), new ItemStack(BlockDirtStairs));
		} 
		
		if (config.getBlock("BlockStoneSlopes", 3934).getInt() != 0) {
			BlockStoneSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockStoneSlopes", 3934).getInt(),
					  Block.stone).setUnlocalizedName("BlockStoneSlopes");
			GameRegistry.registerBlock(BlockStoneSlopesNCorners,"BlockStoneSlopes");
			LanguageRegistry.addName(BlockStoneSlopesNCorners, "Stone Slope");
			GameRegistry.addShapelessRecipe(new ItemStack(BlockStoneSlopesNCorners), new ItemStack(BlockStoneStairs));
			if (BlockCobblestoneSlopesNCorners != null)	GameRegistry.addSmelting(BlockCobblestoneSlopesNCorners.blockID, new ItemStack(BlockStoneSlopesNCorners), 0.1F);
		} 
		if (config.getBlock("BlockStoneBrickSlopes", 4071).getInt() != 0) {
			BlockStoneBrickSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockStoneBrickSlopes", 4071).getInt(),
					  Block.stoneBrick).setUnlocalizedName("BlockStoneBrickSlopes");
			GameRegistry.registerBlock(BlockStoneBrickSlopesNCorners,"BlockStoneBrickSlopes");
			LanguageRegistry.addName(BlockStoneBrickSlopesNCorners, "Stone Brick Slope");
			GameRegistry.addShapelessRecipe(new ItemStack(BlockStoneBrickSlopesNCorners), new ItemStack(Block.stairsStoneBrick));
		} 
		if (config.getBlock("BlockSandSlopes", 3935).getInt() != 0) {
			BlockSandSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockSandSlopes", 3935).getInt(),
					  Block.sand).setUnlocalizedName("BlockSandSlopes");
			GameRegistry.registerBlock(BlockSandSlopesNCorners,"BlockSandSlopes");
			LanguageRegistry.addName(BlockSandSlopesNCorners, "Sand Slope");
			if(BlockSandStairs != null)GameRegistry.addShapelessRecipe(new ItemStack(BlockSandSlopesNCorners), new ItemStack(BlockSandStairs));
		}
		if (config.getBlock("BlockblockSnowSlopes", 3936).getInt() != 0) {
			BlockblockSnowSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockblockSnowSlopes", 3936).getInt(),
					  Block.blockSnow).setUnlocalizedName("BlockblockSnowSlopes");
			GameRegistry.registerBlock(BlockblockSnowSlopesNCorners,"BlockblockSnowSlopes");
			LanguageRegistry.addName(BlockblockSnowSlopesNCorners, "Snow Slope");
			if(BlockblockSnowStairs != null)GameRegistry.addShapelessRecipe(new ItemStack(BlockblockSnowSlopesNCorners), new ItemStack(BlockblockSnowStairs));
		} 
		if (config.getBlock("BlockGrassSlopes", 3937).getInt() != 0) {
			BlockGrassSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockGrassSlopes", 3937).getInt(),
					  Block.grass).setUnlocalizedName("BlockGrassSlopes");
			GameRegistry.registerBlock(BlockGrassSlopesNCorners,"BlockGrassSlopes");
			LanguageRegistry.addName(BlockGrassSlopesNCorners, "Grass Slope");
			if(BlockGrassStairs != null)GameRegistry.addShapelessRecipe(new ItemStack(BlockGrassSlopesNCorners), new ItemStack(BlockGrassStairs));
		} 
		if (config.getBlock("BlockBricksSlopes", 3938).getInt() != 0) {
			BlockBricksSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockBricksSlopes", 3938).getInt(),
					  Block.brick).setResistance(10F).setUnlocalizedName("BlockBricksSlopes");
			GameRegistry.registerBlock(BlockBricksSlopesNCorners,"BlockBricksSlopes");
			LanguageRegistry.addName(BlockBricksSlopesNCorners, "Brick Slope");
			GameRegistry.addShapelessRecipe(new ItemStack(BlockBricksSlopesNCorners), new ItemStack(Block.stairsBrick));
		} 
		if (config.getBlock("BlockGravelSlopes", 3939).getInt() != 0) {
			BlockGravelSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockGravelSlopes", 3939).getInt(),
					  Block.gravel).setUnlocalizedName("BlockGravelSlopes");
			GameRegistry.registerBlock(BlockGravelSlopesNCorners,"BlockGravelSlopes");
			LanguageRegistry.addName(BlockGravelSlopesNCorners, "Gravel Slope");
			if(BlockGravelStairs != null)GameRegistry.addShapelessRecipe(new ItemStack(BlockGravelSlopesNCorners), new ItemStack(BlockGravelStairs));
		} 
		if (config.getBlock("BlockGoldSlopes", 3940).getInt() != 0) {
			BlockGoldSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockGoldSlopes", 3940).getInt(),
					  Block.blockGold).setUnlocalizedName("BlockGoldSlopes");
			GameRegistry.registerBlock(BlockGoldSlopesNCorners,"BlockGoldSlopes");
			LanguageRegistry.addName(BlockGoldSlopesNCorners, "Gold Slope");
			if(BlockGoldStairs != null)GameRegistry.addShapelessRecipe(new ItemStack(BlockGoldSlopesNCorners), new ItemStack(BlockGoldStairs));
		} 
		if (config.getBlock("BlockSteelSlopes", 3941).getInt() != 0) {
			BlockSteelSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockSteelSlopes", 3941).getInt(),
					  Block.blockIron).setUnlocalizedName("BlockSteelSlopes");
			GameRegistry.registerBlock(BlockSteelSlopesNCorners,"BlockSteelSlopes");
			LanguageRegistry.addName(BlockSteelSlopesNCorners, "Iron Slope");
			if(BlockSteelStairs != null)GameRegistry.addShapelessRecipe(new ItemStack(BlockSteelSlopesNCorners), new ItemStack(BlockSteelStairs));	
		} 
		if (config.getBlock("BlockObsidianSlopes", 3942).getInt() != 0) {
			BlockObsidianSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockObsidianSlopes", 3942).getInt(),
					  Block.obsidian).setUnlocalizedName("BlockObsidianSlopes");
			GameRegistry.registerBlock(BlockObsidianSlopesNCorners,"BlockObsidianSlopes");
			LanguageRegistry.addName(BlockObsidianSlopesNCorners, "Obsidian Slope");
			if(BlockObsidianStairs != null)GameRegistry.addShapelessRecipe(new ItemStack(BlockObsidianSlopesNCorners), new ItemStack(BlockObsidianStairs));
		} 
		if (config.getBlock("BlockDiamondSlopes", 3943).getInt() != 0) {
			BlockDiamondSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockDiamondSlopes", 3943).getInt(),
					  Block.blockDiamond).setUnlocalizedName("BlockDiamondSlopes");
			GameRegistry.registerBlock(BlockDiamondSlopesNCorners,"BlockDiamondSlopes");
			LanguageRegistry.addName(BlockDiamondSlopesNCorners, "Diamond Slope");
			if(BlockDiamondStairs != null)GameRegistry.addShapelessRecipe(new ItemStack(BlockDiamondSlopesNCorners), new ItemStack(BlockDiamondStairs));
		} 
		if (config.getBlock("BlockWhiteWoolSlopes", 3944).getInt() != 0) {
			BlockWhiteWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockWhiteWoolSlopes", 3944).getInt(),
					  Block.cloth).setUnlocalizedName("BlockWhiteWoolSlopes");
			GameRegistry.registerBlock(BlockWhiteWoolSlopesNCorners,"BlockWhiteWoolSlopes");
			LanguageRegistry.addName(BlockWhiteWoolSlopesNCorners, "Wool Slope");
			if (BlockWhiteWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockWhiteWoolSlopesNCorners), new ItemStack(BlockWhiteWoolStairs));
		} 
		if (config.getBlock("BlockBlackWoolSlopes", 3945).getInt() != 0) {
			BlockBlackWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockBlackWoolSlopes", 3945).getInt(),
					  Block.cloth,15).setUnlocalizedName("BlockBlackWoolSlopes");
			GameRegistry.registerBlock(BlockBlackWoolSlopesNCorners,"BlockBlackWoolSlopes");
			LanguageRegistry.addName(BlockBlackWoolSlopesNCorners, "Black Slope");
			if (BlockBlackWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockBlackWoolSlopesNCorners), new ItemStack(BlockBlackWoolStairs));
		}
		if (config.getBlock("BlockRedWoolSlopes", 3946).getInt() != 0) {
			BlockRedWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockRedWoolSlopes", 3946).getInt(),
					  Block.cloth, 14).setUnlocalizedName("BlockRedWoolSlopes");
			GameRegistry.registerBlock(BlockRedWoolSlopesNCorners,"BlockRedWoolSlopes");
			LanguageRegistry.addName(BlockRedWoolSlopesNCorners, "Red Slope");
			if (BlockRedWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockRedWoolSlopesNCorners), new ItemStack(BlockRedWoolStairs));
		} 
		if (config.getBlock("BlockGreenWoolSlopes", 3947).getInt()!= 0) {
			BlockGreenWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockGreenWoolSlopes", 3947).getInt(),
					  Block.cloth, 13).setUnlocalizedName("BlockGreenWoolSlopes");
			GameRegistry.registerBlock(BlockGreenWoolSlopesNCorners,"BlockGreenWoolSlopes");
			LanguageRegistry.addName(BlockGreenWoolSlopesNCorners, "Green Slope");
			if (BlockGreenWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockGreenWoolSlopesNCorners), new ItemStack(BlockGreenWoolStairs));
		} 
		if (config.getBlock("BlockBrownWoolSlopes", 3948).getInt() != 0) {
			BlockBrownWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockBrownWoolSlopes", 3948).getInt(),
					  Block.cloth, 12).setUnlocalizedName("BlockBrownWoolSlopes");
			GameRegistry.registerBlock(BlockBrownWoolSlopesNCorners,"BlockBrownWoolSlopes");
			LanguageRegistry.addName(BlockBrownWoolSlopesNCorners, "Brown Slope");
			if (BlockBrownWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockBrownWoolSlopesNCorners), new ItemStack(BlockBrownWoolStairs));
		} 
		if (config.getBlock("BlockBlueWoolSlopes", 3949).getInt() != 0) {
			BlockBlueWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockBlueWoolSlopes", 3949).getInt(),
					  Block.cloth, 11).setUnlocalizedName("BlockBlueWoolSlopes");
			GameRegistry.registerBlock(BlockBlueWoolSlopesNCorners,"BlockBlueWoolSlopes");
			LanguageRegistry.addName(BlockBlueWoolSlopesNCorners, "Blue Slope");
			if (BlockBlueWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockBlueWoolSlopesNCorners), new ItemStack(BlockBlueWoolStairs));
		} 
		if (config.getBlock("BlockPurpleWoolSlopes", 3950).getInt() != 0) {
			BlockPurpleWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockPurpleWoolSlopes", 3950).getInt(),
					  Block.cloth, 10).setUnlocalizedName("BlockPurpleWoolSlopes");
			GameRegistry.registerBlock(BlockPurpleWoolSlopesNCorners,"BlockPurpleWoolSlopes");
			LanguageRegistry.addName(BlockPurpleWoolSlopesNCorners, "Purple Slope");
			if (BlockPurpleWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockPurpleWoolSlopesNCorners), new ItemStack(BlockPurpleWoolStairs));
		} 
		if (config.getBlock("BlockCyanWoolSlopes", 3951).getInt() != 0) {
			BlockCyanWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockCyanWoolSlopes", 3951).getInt(),
					  Block.cloth, 9).setUnlocalizedName("BlockCyanWoolSlopes");
			GameRegistry.registerBlock(BlockCyanWoolSlopesNCorners,"BlockCyanWoolSlopes");
			LanguageRegistry.addName(BlockCyanWoolSlopesNCorners, "Cyan Slope");
			if (BlockCyanWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockCyanWoolSlopesNCorners), new ItemStack(BlockCyanWoolStairs));
		} 
		if (config.getBlock("BlockSilverWoolSlopes", 3952).getInt() != 0) {
			BlockSilverWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockSilverWoolSlopes", 3952).getInt(),
					  Block.cloth).setUnlocalizedName("BlockSilverWoolSlopes");
			GameRegistry.registerBlock(BlockSilverWoolSlopesNCorners,"BlockSilverWoolSlopes");
			LanguageRegistry.addName(BlockSilverWoolSlopesNCorners, "Silver Slope");			
			if (BlockSilverWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockSilverWoolSlopesNCorners), new ItemStack(BlockSilverWoolStairs));
		} 
		if (config.getBlock("BlockGrayWoolSlopes", 3953).getInt() != 0) {
			BlockGrayWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockGrayWoolSlopes", 3953).getInt(),
					  Block.cloth, 7).setUnlocalizedName("BlockGrayWoolSlopes");
			GameRegistry.registerBlock(BlockGrayWoolSlopesNCorners,"BlockGrayWoolSlopes");
			LanguageRegistry.addName(BlockGrayWoolSlopesNCorners, "Gray Slope");
			if (BlockGrayWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockGrayWoolSlopesNCorners), new ItemStack(BlockGrayWoolStairs));
		} 
		if (config.getBlock("BlockPinkWoolSlopes", 3954).getInt() != 0) {
			BlockPinkWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockPinkWoolSlopes", 3954).getInt(),
					   Block.cloth, 6).setUnlocalizedName("BlockPinkWoolSlopes");
			GameRegistry.registerBlock(BlockPinkWoolSlopesNCorners,"BlockPinkWoolSlopes");
			LanguageRegistry.addName(BlockPinkWoolSlopesNCorners, "Pink Slope");
			if (BlockPinkWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockPinkWoolSlopesNCorners), new ItemStack(BlockPinkWoolStairs));
		} 
		if (config.getBlock("BlockLimeWoolSlopes", 3955).getInt() != 0) {
			BlockLimeWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockLimeWoolSlopes", 3955).getInt(),
					   Block.cloth, 5).setUnlocalizedName("BlockLimeWoolSlopes");
			GameRegistry.registerBlock(BlockLimeWoolSlopesNCorners,"BlockLimeWoolSlopes");
			LanguageRegistry.addName(BlockLimeWoolSlopesNCorners, "Lime Slope");
			if (BlockLimeWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockLimeWoolSlopesNCorners), new ItemStack(BlockLimeWoolStairs));
		} 
		if (config.getBlock("BlockYellowWoolSlopes", 3956).getInt() != 0) {
			BlockYellowWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockYellowWoolSlopes", 3956).getInt(),
					  Block.cloth, 4).setUnlocalizedName("BlockYellowWoolSlopes");
			GameRegistry.registerBlock(BlockYellowWoolSlopesNCorners,"BlockYellowWoolSlopes");
			LanguageRegistry.addName(BlockYellowWoolSlopesNCorners, "Yellow Slope");
			if (BlockYellowWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockYellowWoolSlopesNCorners), new ItemStack(BlockYellowWoolStairs));
		} 
		if (config.getBlock("BlockLightBlueWoolSlopes", 3957).getInt() != 0) {
			BlockLightBlueWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockLightBlueWoolSlopes", 3957).getInt(),
					   Block.cloth, 3).setUnlocalizedName("BlockLightBlueWoolSlopes");
			GameRegistry.registerBlock(BlockLightBlueWoolSlopesNCorners,"BlockLightBlueWoolSlopes");
			LanguageRegistry.addName(BlockLightBlueWoolSlopesNCorners, "Light Blue Slope");
			if (BlockLightBlueWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockLightBlueWoolSlopesNCorners), new ItemStack(BlockLightBlueWoolStairs));
		} 
		if (config.getBlock("BlockMagentaWoolSlopes", 3958).getInt() != 0) {
			BlockMagentaWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockMagentaWoolSlopes", 3958).getInt(),
					   Block.cloth, 2).setUnlocalizedName("BlockMagentaWoolSlopes");
			GameRegistry.registerBlock(BlockMagentaWoolSlopesNCorners,"BlockMagentaWoolSlopes");
			LanguageRegistry.addName(BlockMagentaWoolSlopesNCorners, "Magenta Slope");
			if (BlockOrangeWoolStairs !=null)GameRegistry.addShapelessRecipe(new ItemStack(BlockMagentaWoolSlopesNCorners), new ItemStack(BlockMagentaWoolStairs));
		}
		if (config.getBlock("BlockOrangeWoolSlopes", 3959).getInt() != 0) {
			BlockOrangeWoolSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockOrangeWoolSlopes", 3959).getInt(),
					   Block.cloth, 1).setUnlocalizedName("BlockOrangeWoolSlopes");
			GameRegistry.registerBlock(BlockOrangeWoolSlopesNCorners,"BlockOrangeWoolSlopes");
			LanguageRegistry.addName(BlockOrangeWoolSlopesNCorners, "Orange Slope");
			if (BlockOrangeWoolStairs !=null) GameRegistry.addShapelessRecipe(new ItemStack(BlockOrangeWoolSlopesNCorners), new ItemStack(BlockOrangeWoolStairs));
		}
		if (config.getBlock("BlockNetherBrickSlopes", 3960).getInt() != 0) {
			BlockNetherBrickSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockNetherBrickSlopes", 3960).getInt(),
					   Block.netherBrick).setUnlocalizedName("BlockNetherBrickSlopes");
			GameRegistry.registerBlock(BlockNetherBrickSlopesNCorners,"BlockNetherBrickSlopes");
			LanguageRegistry.addName(BlockNetherBrickSlopesNCorners, "Nether Brick Slope");
			GameRegistry.addShapelessRecipe(new ItemStack(BlockNetherBrickSlopesNCorners), new ItemStack(Block.stairsNetherBrick));
		}
		if (config.getBlock("BlockNetherQuartzSlopes", 3961).getInt() != 0) {
			BlockNetherQuartzSlopesNCorners = new BlockSlopesNCorners(
					config.getBlock("BlockNetherQuartzSlopes", 3961).getInt(),
					   Block.blockNetherQuartz).setUnlocalizedName("BlockQuartzSlopes");
			GameRegistry.registerBlock(BlockNetherQuartzSlopesNCorners,"BlockNetherQuartzSlopes");
			LanguageRegistry.addName(BlockNetherQuartzSlopesNCorners, "Quartz Slope");
			GameRegistry.addShapelessRecipe(new ItemStack(BlockNetherQuartzSlopesNCorners), new ItemStack(Block.stairsNetherQuartz));
		}
		config.save();
	}	
	
	private static void initializeSideSlopes(Configuration config)
	{
	if (config.getBlock("BlockPlankSpruceSideSlopes", 3962).getInt() != 0) {
		BlockPlankSpruceSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockPlankSpruceSideSlopes", 3959).getInt(),
				Block.planks, 1).setUnlocalizedName("BlockPlankSpruceSideSlopes");
		GameRegistry.registerBlock(BlockPlankSpruceSideSlopes,"BlockPlankSpruceSideSlopes");
		LanguageRegistry.addName(BlockPlankSpruceSideSlopes, "Spruce Wood Side Slope");
		if (BlockPlankSpruceSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPlankSpruceSlopesNCorners), new ItemStack(BlockPlankSpruceSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPlankSpruceSideSlopes), new ItemStack(BlockPlankSpruceSlopesNCorners));
		}
			
	} 
	if (config.getBlock("BlockPlankBirchSideSlopes", 3963).getInt() != 0) {
		BlockPlankBirchSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockPlankBirchSideSlopes", 3963).getInt(),
				Block.planks, 2).setUnlocalizedName("BlockPlankBirchSideSlopes");
		GameRegistry.registerBlock(BlockPlankBirchSideSlopes,"BlockPlankBirchSideSlopes");
		LanguageRegistry.addName(BlockPlankBirchSideSlopes, "Birch Wood Side Slope");
		if (BlockPlankBirchSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPlankBirchSlopesNCorners), new ItemStack(BlockPlankBirchSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPlankBirchSideSlopes), new ItemStack(BlockPlankBirchSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockPlankJungleSideSlopes", 3964).getInt() != 0) {
		BlockPlankJungleSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockPlankJungleSideSlopes", 3964).getInt(),
				Block.planks, 3).setUnlocalizedName("BlockPlankJungleSideSlopes");
		GameRegistry.registerBlock(BlockPlankJungleSideSlopes,"BlockPlankJungleSideSlopes");
		LanguageRegistry.addName(BlockPlankJungleSideSlopes, "Jungle Wood Side Slope");
		if (BlockPlankJungleSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPlankJungleSlopesNCorners), new ItemStack(BlockPlankJungleSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPlankJungleSideSlopes), new ItemStack(BlockPlankJungleSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockPlankOakSideSlopes", 3965).getInt() != 0) {
		BlockPlankOakSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockPlankOakSideSlopes", 3965).getInt(),
				Block.planks).setUnlocalizedName("BlockPlankOakSideSlopes");
		GameRegistry.registerBlock(BlockPlankOakSideSlopes,"BlockPlankOakSideSlopes");
		LanguageRegistry.addName(BlockPlankOakSideSlopes, "Oak Wood Side Slope");
		if (BlockPlankOakSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPlankOakSlopesNCorners), new ItemStack(BlockPlankOakSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPlankOakSideSlopes), new ItemStack(BlockPlankOakSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockCobblestoneSideSlopes", 3966).getInt() != 0) {
		BlockCobblestoneSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockCobblestoneSideSlopes", 3966).getInt(),
				Block.cobblestone).setUnlocalizedName("BlockCobblestoneSideSlopes");
		GameRegistry.registerBlock(BlockCobblestoneSideSlopes,"BlockCobblestoneSideSlopes");
		LanguageRegistry.addName(BlockCobblestoneSideSlopes, "CobbleStone Side Slope");
		if (BlockCobblestoneSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockCobblestoneSlopesNCorners), new ItemStack(BlockCobblestoneSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockCobblestoneSideSlopes), new ItemStack(BlockCobblestoneSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockGlassSideSlopes", 3967).getInt() != 0) {
		BlockGlassSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockGlassSideSlopes", 3967).getInt(),
				Block.glass).setUnlocalizedName("BlockGlassSideSlopes");
		GameRegistry.registerBlock(BlockGlassSideSlopes,"BlockGlassSideSlopes");
		LanguageRegistry.addName(BlockGlassSideSlopes, "Glass Side Slope");
		if (BlockGlassSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockGlassSlopesNCorners), new ItemStack(BlockGlassSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockGlassSideSlopes), new ItemStack(BlockGlassSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockSandstoneSideSlopes", 3968).getInt() != 0) {
		BlockSandstoneSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockSandstoneSideSlopes", 3968).getInt(),
				Block.sandStone).setUnlocalizedName("BlockSandstoneSideSlopes");
		GameRegistry.registerBlock(BlockSandstoneSideSlopes,"BlockSandstoneSideSlopes");
		LanguageRegistry.addName(BlockSandstoneSideSlopes, "Sandstone Side Slope");
		if (BlockSandstoneSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockSandstoneSlopesNCorners), new ItemStack(BlockSandstoneSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockSandstoneSideSlopes), new ItemStack(BlockSandstoneSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockDirtSideSlopes", 3969).getInt() != 0) {
		BlockDirtSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockDirtSideSlopes", 3969).getInt(),
				Block.dirt).setUnlocalizedName("BlockDirtSideSlopes");
		GameRegistry.registerBlock(BlockDirtSideSlopes,"BlockDirtSideSlopes");
		LanguageRegistry.addName(BlockDirtSideSlopes, "Dirt Side Slope");
		if (BlockDirtSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockDirtSlopesNCorners), new ItemStack(BlockDirtSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockDirtSideSlopes), new ItemStack(BlockDirtSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockStoneSideSlopes", 3970).getInt() != 0) {
		BlockStoneSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockStoneSideSlopes", 3970).getInt(),
				Block.stone).setUnlocalizedName("BlockStoneSideSlopes");
		GameRegistry.registerBlock(BlockStoneSideSlopes,"BlockStoneSideSlopes");
		LanguageRegistry.addName(BlockStoneSideSlopes, "Stone Side Slope");
		if (BlockStoneSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockStoneSlopesNCorners), new ItemStack(BlockStoneSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockStoneSideSlopes), new ItemStack(BlockStoneSlopesNCorners));
		}
		if (BlockCobblestoneSideSlopes != null)	GameRegistry.addSmelting(BlockCobblestoneSideSlopes.blockID, new ItemStack(BlockStoneSideSlopes), 0.1F);
	} 
	if (config.getBlock("BlockStoneBrickSideSlopes", 4072).getInt() != 0) {
		BlockStoneBrickSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockStoneBrickSideSlopes", 4072).getInt(),
				Block.stoneBrick).setUnlocalizedName("BlockStoneBrickSideSlopes");
		GameRegistry.registerBlock(BlockStoneBrickSideSlopes,"BlockStoneBrickSideSlopes");
		LanguageRegistry.addName(BlockStoneBrickSideSlopes, "Stone Brick Side Slope");
		if (BlockStoneBrickSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockStoneBrickSlopesNCorners), new ItemStack(BlockStoneBrickSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockStoneBrickSideSlopes), new ItemStack(BlockStoneBrickSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockSandSideSlopes", 3971).getInt() != 0) {
		BlockSandSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockSandSideSlopes", 3971).getInt(),
				Block.sand).setUnlocalizedName("BlockSandSideSlopes");
		GameRegistry.registerBlock(BlockSandSideSlopes,"BlockSandSideSlopes");
		LanguageRegistry.addName(BlockSandSideSlopes, "Sand Side Slope");
		if (BlockSandSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockSandSlopesNCorners), new ItemStack(BlockSandSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockSandSideSlopes), new ItemStack(BlockSandSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockblockSnowSideSlopes", 3972).getInt() != 0) {
		BlockblockSnowSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockblockSnowSideSlopes", 3972).getInt(),
				Block.snow).setUnlocalizedName("BlockblockSnowSideSlopes");
		GameRegistry.registerBlock(BlockblockSnowSideSlopes,"BlockblockSnowSideSlopes");
		LanguageRegistry.addName(BlockblockSnowSideSlopes, "Snow Side Slope");
		if (BlockblockSnowSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockblockSnowSlopesNCorners), new ItemStack(BlockblockSnowSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockblockSnowSideSlopes), new ItemStack(BlockblockSnowSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockGrassSideSlopes", 3973).getInt() != 0) {
		BlockGrassSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockGrassSideSlopes", 3973).getInt(),
				Block.grass).setUnlocalizedName("BlockGrassSideSlopes");
		GameRegistry.registerBlock(BlockGrassSideSlopes,"BlockGrassSideSlopes");
		LanguageRegistry.addName(BlockGrassSideSlopes, "Grass Side Slope");
		if (BlockGrassSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockGrassSlopesNCorners), new ItemStack(BlockGrassSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockGrassSideSlopes), new ItemStack(BlockGrassSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockBricksSideSlopes", 3974).getInt() != 0) {
		BlockBricksSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockBricksSideSlopes", 3974).getInt(),
				Block.brick).setUnlocalizedName("BlockBricksSideSlopes");
		GameRegistry.registerBlock(BlockBricksSideSlopes,"BlockBricksSideSlopes");
		LanguageRegistry.addName(BlockBricksSideSlopes, "Brick Side Slope");
		if (BlockBricksSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockBricksSlopesNCorners), new ItemStack(BlockBricksSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockBricksSideSlopes), new ItemStack(BlockBricksSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockGravelSideSlopes", 3975).getInt() != 0) {
		BlockGravelSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockGravelSideSlopes", 3975).getInt(),
				Block.gravel).setUnlocalizedName("BlockGravelSideSlopes");
		GameRegistry.registerBlock(BlockGravelSideSlopes,"BlockGravelSideSlopes");
		LanguageRegistry.addName(BlockGravelSideSlopes, "Gravel Side Slope");
		if (BlockGravelSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockGravelSlopesNCorners), new ItemStack(BlockGravelSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockGravelSideSlopes), new ItemStack(BlockGravelSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockGoldSideSlopes", 3976).getInt() != 0) {
		BlockGoldSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockGoldSideSlopes", 3976).getInt(),
				Block.blockGold).setUnlocalizedName("BlockGoldSideSlopes");
		GameRegistry.registerBlock(BlockGoldSideSlopes,"BlockGoldSideSlopes");
		LanguageRegistry.addName(BlockGoldSideSlopes, "Gold Side Slope");
		if (BlockGoldSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockGoldSlopesNCorners), new ItemStack(BlockGoldSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockGoldSideSlopes), new ItemStack(BlockGoldSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockSteelSideSlopes", 3977).getInt() != 0) {
		BlockSteelSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockSteelSideSlopes", 3977).getInt(),
				Block.blockIron).setUnlocalizedName("BlockSteelSideSlopes");
		GameRegistry.registerBlock(BlockSteelSideSlopes,"BlockSteelSideSlopes");
		LanguageRegistry.addName(BlockSteelSideSlopes, "Iron Side Slope");
		if (BlockSteelSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockSteelSlopesNCorners), new ItemStack(BlockSteelSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockSteelSideSlopes), new ItemStack(BlockSteelSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockObsidianSideSlopes", 3978).getInt() != 0) {
		BlockObsidianSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockObsidianSideSlopes", 3978).getInt(),
				Block.obsidian).setUnlocalizedName("BlockObsidianSideSlopes");
		GameRegistry.registerBlock(BlockObsidianSideSlopes,"BlockObsidianSideSlopes");
		LanguageRegistry.addName(BlockObsidianSideSlopes, "Obsidian Side Slope");
		if (BlockObsidianSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockObsidianSlopesNCorners), new ItemStack(BlockObsidianSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockObsidianSideSlopes), new ItemStack(BlockObsidianSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockDiamondSideSlopes", 3979).getInt() != 0) {
		BlockDiamondSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockDiamondSideSlopes", 3979).getInt(),
				Block.blockDiamond).setUnlocalizedName("BlockDiamondSideSlopes");
		GameRegistry.registerBlock(BlockDiamondSideSlopes,"BlockDiamondSideSlopes");
		LanguageRegistry.addName(BlockDiamondSideSlopes, "Diamond Side Slope");
		if (BlockDiamondSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockDiamondSlopesNCorners), new ItemStack(BlockDiamondSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockDiamondSideSlopes), new ItemStack(BlockDiamondSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockWhiteWoolSideSlopes", 3980).getInt() != 0) {
		BlockWhiteWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockWhiteWoolSideSlopes", 3980).getInt(),
				Block.cloth).setUnlocalizedName("BlockWhiteWoolSideSlopes");
		GameRegistry.registerBlock(BlockWhiteWoolSideSlopes,"BlockWhiteWoolSideSlopes");
		LanguageRegistry.addName(BlockWhiteWoolSideSlopes, "Wool Side Slope");
		if (BlockWhiteWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockWhiteWoolSlopesNCorners), new ItemStack(BlockWhiteWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockWhiteWoolSideSlopes), new ItemStack(BlockWhiteWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockBlackWoolSideSlopes", 3981).getInt() != 0) {
		BlockBlackWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockBlackWoolSideSlopes", 3981).getInt(),
				Block.cloth,15).setUnlocalizedName("BlockBlackWoolSideSlopes");
		GameRegistry.registerBlock(BlockBlackWoolSideSlopes,"BlockBlackWoolSideSlopes");
		LanguageRegistry.addName(BlockBlackWoolSideSlopes, "Black Side Slope");
		if (BlockBlackWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockBlackWoolSlopesNCorners), new ItemStack(BlockBlackWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockBlackWoolSideSlopes), new ItemStack(BlockBlackWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockRedWoolSideSlopes", 3982).getInt() != 0) {
		BlockRedWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockRedWoolSideSlopes", 3982).getInt(),
				Block.cloth,14).setUnlocalizedName("BlockRedWoolSideSlopes");
		GameRegistry.registerBlock(BlockRedWoolSideSlopes,"BlockRedWoolSideSlopes");
		LanguageRegistry.addName(BlockRedWoolSideSlopes, "Red Side Slope");
		if (BlockRedWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockRedWoolSlopesNCorners), new ItemStack(BlockRedWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockRedWoolSideSlopes), new ItemStack(BlockRedWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockGreenWoolSideSlopes", 3983).getInt() != 0) {
		BlockGreenWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockGreenWoolSideSlopes", 3983).getInt(),
				Block.cloth,13).setUnlocalizedName("BlockGreenWoolSideSlopes");
		GameRegistry.registerBlock(BlockGreenWoolSideSlopes,"BlockGreenWoolSideSlopes");
		LanguageRegistry.addName(BlockGreenWoolSideSlopes, "Green Side Slope");
		if (BlockGreenWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockGreenWoolSlopesNCorners), new ItemStack(BlockGreenWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockGreenWoolSideSlopes), new ItemStack(BlockGreenWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockBrownWoolSideSlopes", 3984).getInt() != 0) {
		BlockBrownWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockBrownWoolSideSlopes", 3984).getInt(),
				Block.cloth,12).setUnlocalizedName("BlockBrownWoolSideSlopes");
		GameRegistry.registerBlock(BlockBrownWoolSideSlopes,"BlockBrownWoolSideSlopes");
		LanguageRegistry.addName(BlockBrownWoolSideSlopes, "Brown Side Slope");
		if (BlockBrownWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockBrownWoolSlopesNCorners), new ItemStack(BlockBrownWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockBrownWoolSideSlopes), new ItemStack(BlockBrownWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockBlueWoolSideSlopes", 3985).getInt() != 0) {
		BlockBlueWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockBlueWoolSideSlopes", 3985).getInt(),
				Block.cloth,11).setUnlocalizedName("BlockBlueWoolSideSlopes");
		GameRegistry.registerBlock(BlockBlueWoolSideSlopes,"BlockBlueWoolSideSlopes");
		LanguageRegistry.addName(BlockBlueWoolSideSlopes, "Blue Side Slope");
		if (BlockBlueWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockBlueWoolSlopesNCorners), new ItemStack(BlockBlueWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockBlueWoolSideSlopes), new ItemStack(BlockBlueWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockPurpleWoolSideSlopes", 3986).getInt() != 0) {
		BlockPurpleWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockPurpleWoolSideSlopes", 3986).getInt(),
				Block.cloth,10).setUnlocalizedName("BlockPurpleWoolSideSlopes");
		GameRegistry.registerBlock(BlockPurpleWoolSideSlopes,"BlockPurpleWoolSideSlopes");
		LanguageRegistry.addName(BlockPurpleWoolSideSlopes, "Purple Side Slope");
		if (BlockPurpleWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPurpleWoolSlopesNCorners), new ItemStack(BlockPurpleWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPurpleWoolSideSlopes), new ItemStack(BlockPurpleWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockCyanWoolSideSlopes", 3987).getInt() != 0) {
		BlockCyanWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockCyanWoolSideSlopes", 3987).getInt(),
				Block.cloth,9).setUnlocalizedName("BlockCyanWoolSideSlopes");
		GameRegistry.registerBlock(BlockCyanWoolSideSlopes,"BlockCyanWoolSideSlopes");
		LanguageRegistry.addName(BlockCyanWoolSideSlopes, "Cyan Side Slope");
		if (BlockCyanWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockCyanWoolSlopesNCorners), new ItemStack(BlockCyanWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockCyanWoolSideSlopes), new ItemStack(BlockCyanWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockSilverWoolSideSlopes", 3988).getInt() != 0) {
		BlockSilverWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockSilverWoolSideSlopes", 3988).getInt(),
				Block.cloth,8).setUnlocalizedName("BlockSilverWoolSideSlopes");
		GameRegistry.registerBlock(BlockSilverWoolSideSlopes,"BlockSilverWoolSideSlopes");
		LanguageRegistry.addName(BlockSilverWoolSideSlopes, "Silver Side Slope");
		if (BlockSilverWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockSilverWoolSlopesNCorners), new ItemStack(BlockSilverWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockSilverWoolSideSlopes), new ItemStack(BlockSilverWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockGrayWoolSideSlopes", 3989).getInt() != 0) {
		BlockGrayWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockGrayWoolSideSlopes", 3989).getInt(),
				Block.cloth,7).setUnlocalizedName("BlockGrayWoolSideSlopes");
		GameRegistry.registerBlock(BlockGrayWoolSideSlopes,"BlockGrayWoolSideSlopes");
		LanguageRegistry.addName(BlockGrayWoolSideSlopes, "Gray Side Slope");
		if (BlockGrayWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockGrayWoolSlopesNCorners), new ItemStack(BlockGrayWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockGrayWoolSideSlopes), new ItemStack(BlockGrayWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockPinkWoolSideSlopes", 3990).getInt() != 0) {
		BlockPinkWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockPinkWoolSideSlopes", 3990).getInt(),
				Block.cloth,6).setUnlocalizedName("BlockPinkWoolSideSlopes");
		GameRegistry.registerBlock(BlockPinkWoolSideSlopes,"BlockPinkWoolSideSlopes");
		LanguageRegistry.addName(BlockPinkWoolSideSlopes, "Pink Side Slope");
		if (BlockPinkWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPinkWoolSlopesNCorners), new ItemStack(BlockPinkWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockPinkWoolSideSlopes), new ItemStack(BlockPinkWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockLimeWoolSideSlopes", 3991).getInt() != 0) {
		BlockLimeWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockLimeWoolSideSlopes", 3991).getInt(),
				Block.cloth,5).setUnlocalizedName("BlockLimeWoolSideSlopes");
		GameRegistry.registerBlock(BlockLimeWoolSideSlopes,"BlockLimeWoolSideSlopes");
		LanguageRegistry.addName(BlockLimeWoolSideSlopes, "Lime Side Slope");
		if (BlockLimeWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockLimeWoolSlopesNCorners), new ItemStack(BlockLimeWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockLimeWoolSideSlopes), new ItemStack(BlockLimeWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockYellowWoolSideSlopes", 3992).getInt() != 0) {
		BlockYellowWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockYellowWoolSideSlopes", 3992).getInt(),
				Block.cloth,4).setUnlocalizedName("BlockYellowWoolSideSlopes");
		GameRegistry.registerBlock(BlockYellowWoolSideSlopes,"BlockYellowWoolSideSlopes");
		LanguageRegistry.addName(BlockYellowWoolSideSlopes, "Yellow Side Slope");
		if (BlockYellowWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockYellowWoolSlopesNCorners), new ItemStack(BlockYellowWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockYellowWoolSideSlopes), new ItemStack(BlockYellowWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockLightBlueWoolSideSlopes", 3993).getInt() != 0) {
		BlockLightBlueWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockLightBlueWoolSideSlopes", 3993).getInt(),
				Block.cloth,3).setUnlocalizedName("BlockLightBlueWoolSideSlopes");
		GameRegistry.registerBlock(BlockLightBlueWoolSideSlopes,"BlockLightBlueWoolSideSlopes");
		LanguageRegistry.addName(BlockLightBlueWoolSideSlopes, "Light Blue Side Slope");
		if (BlockLightBlueWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockLightBlueWoolSlopesNCorners), new ItemStack(BlockLightBlueWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockLightBlueWoolSideSlopes), new ItemStack(BlockLightBlueWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockMagentaWoolSideSlopes", 3994).getInt() != 0) {
		BlockMagentaWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockMagentaWoolSideSlopes", 3994).getInt(),
				Block.cloth,2).setUnlocalizedName("BlockMagentaWoolSideSlopes");
		GameRegistry.registerBlock(BlockMagentaWoolSideSlopes,"BlockMagentaWoolSideSlopes");
		LanguageRegistry.addName(BlockMagentaWoolSideSlopes, "Magenta Side Slope");
		if (BlockMagentaWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockMagentaWoolSlopesNCorners), new ItemStack(BlockMagentaWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockMagentaWoolSideSlopes), new ItemStack(BlockMagentaWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockOrangeWoolSideSlopes", 3995).getInt() != 0) {
		BlockOrangeWoolSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockOrangeWoolSideSlopes", 3995).getInt(),
				Block.cloth,1).setUnlocalizedName("BlockOrangeWoolSideSlopes");
		GameRegistry.registerBlock(BlockOrangeWoolSideSlopes,"BlockOrangeWoolSideSlopes");
		LanguageRegistry.addName(BlockOrangeWoolSideSlopes, "Orange Side Slope");
		if (BlockOrangeWoolSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockOrangeWoolSlopesNCorners), new ItemStack(BlockOrangeWoolSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockOrangeWoolSideSlopes), new ItemStack(BlockOrangeWoolSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockNetherBrickSideSlopes", 3996).getInt() != 0) {
		BlockNetherBrickSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockNetherBrickSideSlopes", 3996).getInt(),
				Block.netherBrick).setUnlocalizedName("BlockNetherBrickSideSlopes");
		GameRegistry.registerBlock(BlockNetherBrickSideSlopes,"BlockNetherBrickSideSlopes");
		LanguageRegistry.addName(BlockNetherBrickSideSlopes, "Nether Brick Side Slope");
		if (BlockNetherBrickSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockNetherBrickSlopesNCorners), new ItemStack(BlockNetherBrickSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockNetherBrickSideSlopes), new ItemStack(BlockNetherBrickSlopesNCorners));
		}
	} 
	if (config.getBlock("BlockNetherQuartzSideSlopes", 3997).getInt() != 0) {
		BlockNetherQuartzSideSlopes = new BlockSideSlopes(
				config.getBlock("BlockNetherQuartzSideSlopes", 3997).getInt(),
				Block.blockNetherQuartz).setUnlocalizedName("BlockNetherQuartzSideSlopes");
		GameRegistry.registerBlock(BlockNetherQuartzSideSlopes,"BlockNetherQuartzSideSlopes");
		LanguageRegistry.addName(BlockNetherQuartzSideSlopes, "Quartz Side Slope");
		if (BlockNetherQuartzSlopesNCorners != null){
			GameRegistry.addShapelessRecipe(new ItemStack(BlockNetherQuartzSlopesNCorners), new ItemStack(BlockNetherQuartzSideSlopes));
			GameRegistry.addShapelessRecipe(new ItemStack(BlockNetherQuartzSideSlopes), new ItemStack(BlockNetherQuartzSlopesNCorners));
		}
	} 
	config.save();
}

	private static void initializeTriCorners(Configuration config)
	{
		if (config.getBlock("BlockPlanksBirchCorners",3998).getInt() != 0) {
			BlockPlankBirchCorners = new BlockTriPointCorner(
					config.getBlock("BlockPlanksBirchCorners",3998).getInt(),
					Block.planks,2).setUnlocalizedName("BlockPlanksBirchCorners");
			GameRegistry.registerBlock(BlockPlankBirchCorners,"BlockPlanksBirchCorners");
			LanguageRegistry.addName(BlockPlankBirchCorners, "Birch Wood Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockPlankBirchCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.planks,1,2)});
		} 
		if (config.getBlock("BlockPlanksSpruceCorners",3999).getInt() != 0) {
			BlockPlankSpruceCorners = new BlockTriPointCorner(
					config.getBlock("BlockPlanksSpruceCorners",3999).getInt(),
					Block.planks,1).setUnlocalizedName("BlockPlanksSpruceCorners");
			GameRegistry.registerBlock(BlockPlankSpruceCorners,"BlockPlanksSpruceCorners");
			LanguageRegistry.addName(BlockPlankSpruceCorners, "Spruce Wood Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockPlankSpruceCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.planks,1,1)});
		} 
		if (config.getBlock("BlockPlanksJungleCorners",4000).getInt() != 0) {
			BlockPlankJungleCorners = new BlockTriPointCorner(
					config.getBlock("BlockPlanksJungleCorners",4000).getInt(),
					Block.planks,3).setUnlocalizedName("BlockPlanksJungleCorners");			
			GameRegistry.registerBlock(BlockPlankJungleCorners,"BlockPlanksJungleCorners");
			LanguageRegistry.addName(BlockPlankJungleCorners, "Jungle Wood Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockPlankJungleCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.planks,1,3)});
		} 
		if (config.getBlock("BlockPlanksOakCorners",4001).getInt() != 0) {
			BlockPlankOakCorners = new BlockTriPointCorner(
					config.getBlock("BlockPlanksOakCorners",4001).getInt(),
					Block.planks).setUnlocalizedName("BlockPlanksOakCorners");
			GameRegistry.registerBlock(BlockPlankOakCorners,"BlockPlanksOakCorners");
			LanguageRegistry.addName(BlockPlankOakCorners, "Oak Wood Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockPlankOakCorners,8),new Object[]{" A "," A ","AAA",'A',new ItemStack(Block.planks)});
		} 
		if (config.getBlock("BlockCobblestoneCorners",4002).getInt() != 0) {
			BlockCobblestoneCorners = new BlockTriPointCorner(
					config.getBlock("BlockCobblestoneCorners",4002).getInt(),
					Block.cobblestone).setUnlocalizedName("BlockCobblestoneCorners");
			GameRegistry.registerBlock(BlockCobblestoneCorners,"BlockCobblestoneCorners");
			LanguageRegistry.addName(BlockCobblestoneCorners, "Stone Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockCobblestoneCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cobblestone)});
		} 
		if (config.getBlock("BlockGlassCorners",4003).getInt() != 0) {
			BlockGlassCorners = new BlockTriPointCorner(
					config.getBlock("BlockGlassCorners",4003).getInt(),
					Block.glass).setUnlocalizedName("BlockGlassCorners");
			GameRegistry.registerBlock(BlockGlassCorners,"BlockGlassCorners");
			LanguageRegistry.addName(BlockGlassCorners, "Glass Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGlassCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.glass)});
		} 
		if (config.getBlock("BlockSandstoneCorners",4004).getInt() != 0) {
			BlockSandstoneCorners = new BlockTriPointCorner(
					config.getBlock("BlockSandstoneCorners",4004).getInt(),
					Block.sandStone).setUnlocalizedName("BlockSandstoneCorners");
			GameRegistry.registerBlock(BlockSandstoneCorners,"BlockSandstoneCorners");
			LanguageRegistry.addName(BlockSandstoneCorners, "Sandstone Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockSandstoneCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.sandStone)});
		}
		if (config.getBlock("BlockDirtCorners",4005).getInt() != 0) {
			BlockDirtCorners = new BlockTriPointCorner(
					config.getBlock("BlockDirtCorners",4005).getInt(),
					Block.dirt).setUnlocalizedName("BlockDirtCorners");
			GameRegistry.registerBlock(BlockDirtCorners,"BlockDirtCorners");
			LanguageRegistry.addName(BlockDirtCorners, "Dirt Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockDirtCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.dirt)});
		} 
		if (config.getBlock("BlockStoneCorners",4006).getInt() != 0) {
			BlockStoneCorners = new BlockTriPointCorner(
					config.getBlock("BlockStoneCorners",4006).getInt(),
					Block.stone).setUnlocalizedName("BlockStoneCorners");
			GameRegistry.registerBlock(BlockStoneCorners,"BlockStoneCorners");
			LanguageRegistry.addName(BlockStoneCorners, "Stone Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockStoneCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.stone)});
if (BlockCobblestoneCorners!=null)GameRegistry.addSmelting(BlockCobblestoneCorners.blockID, new ItemStack(BlockStoneCorners), 0.1F);
		} 
		if (config.getBlock("BlockStoneBrickCorners",4073).getInt() != 0) {
			BlockStoneBrickCorners = new BlockTriPointCorner(
					config.getBlock("BlockStoneBrickCorners",4073).getInt(),
					Block.stoneBrick).setUnlocalizedName("BlockStoneBrickCorners");
			GameRegistry.registerBlock(BlockStoneBrickCorners,"BlockStoneBrickCorners");
			LanguageRegistry.addName(BlockStoneBrickCorners, "Stone Brick Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockStoneBrickCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.stoneBrick)});
		} 
		if (config.getBlock("BlockSandCorners",4007).getInt() != 0) {
			BlockSandCorners = new BlockTriPointCorner(
					config.getBlock("BlockSandCorners",4007).getInt(),
					Block.sand).setUnlocalizedName("BlockSandCorners");
			GameRegistry.registerBlock(BlockSandCorners,"BlockSandCorners");
			LanguageRegistry.addName(BlockSandCorners, "Sand Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockSandCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.sand)});
		}
		if (config.getBlock("BlockSnowCorners",4008).getInt() != 0) {
			BlockSnowCorners = new BlockTriPointCorner(
					config.getBlock("BlockSnowCorners",4008).getInt(),
					Block.blockSnow).setUnlocalizedName("BlockSnowCorners");
			GameRegistry.registerBlock(BlockSnowCorners,"BlockSnowCorners");
			LanguageRegistry.addName(BlockSnowCorners, "Snow Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockSnowCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.blockSnow)});
		} 
		if (config.getBlock("BlockGrassCorners",4009).getInt() != 0) {
			BlockGrassCorners = new BlockTriPointCorner(
					config.getBlock("BlockGrassCorners",4009).getInt(),
					Block.grass).setUnlocalizedName("BlockGrassCorners");
			GameRegistry.registerBlock(BlockGrassCorners,"BlockGrassCorners");
			LanguageRegistry.addName(BlockGrassCorners, "Grass Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGrassCorners,8),new Object[]{" A "," A ","AAA",'A',new ItemStack(Block.grass)});
		}
		if (config.getBlock("BlockBricksCorners",4010).getInt() != 0) {
			BlockBricksCorners = new BlockTriPointCorner(
					config.getBlock("BlockBricksCorners",4008).getInt(),
					Block.brick).setUnlocalizedName("BlockBricksCorners");
			GameRegistry.registerBlock(BlockBricksCorners,"BlockBricksCorners");
			LanguageRegistry.addName(BlockBricksCorners, "Brick Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockBricksCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.brick)});
		} 
		if (config.getBlock("BlockGravelCorners",4011).getInt() != 0) {
			BlockGravelCorners = new BlockTriPointCorner(
					config.getBlock("BlockGravelCorners",4011).getInt(),
					Block.gravel).setUnlocalizedName("BlockGravelCorners");
			GameRegistry.registerBlock(BlockGravelCorners,"BlockGravelCorners");
			LanguageRegistry.addName(BlockGravelCorners, "Gravel Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGravelCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.gravel)});
		} 
		if (config.getBlock("BlockGoldCorners",4012).getInt() != 0) {
			BlockGoldCorners = new BlockTriPointCorner(
					config.getBlock("BlockGoldCorners",4012).getInt(),
					Block.blockGold).setUnlocalizedName("BlockGoldCorners");
			GameRegistry.registerBlock(BlockGoldCorners,"BlockGoldCorners");
			LanguageRegistry.addName(BlockGoldCorners, "Gold Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGoldCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.blockGold)});
		} 
		if (config.getBlock("BlockSteelCorners",4013).getInt() != 0) {
			BlockSteelCorners = new BlockTriPointCorner(
					config.getBlock("BlockSteelCorners",4013).getInt(),
					Block.blockIron).setUnlocalizedName("BlockSteelCorners");
			GameRegistry.registerBlock(BlockSteelCorners,"BlockSteelCorners");
			LanguageRegistry.addName(BlockSteelCorners, "Iron Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockSteelCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.blockIron)});
		} 
		if (config.getBlock("BlockObsidianCorners",4014).getInt() != 0) {
			BlockObsidianCorners = new BlockTriPointCorner(
					config.getBlock("BlockObsidianCorners",4014).getInt(),
					Block.obsidian).setUnlocalizedName("BlockObsidianCorners");
			GameRegistry.registerBlock(BlockObsidianCorners,"BlockObsidianCorners");
			LanguageRegistry.addName(BlockObsidianCorners, "Obsidian Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockObsidianCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.obsidian)});	
		} 
		if (config.getBlock("BlockDiamondCorners",4015).getInt() != 0) {
			BlockDiamondCorners = new BlockTriPointCorner(
					config.getBlock("BlockDiamondCorners",4015).getInt(),
					Block.blockDiamond).setUnlocalizedName("BlockDiamondCorners");
			GameRegistry.registerBlock(BlockDiamondCorners,"BlockDiamondCorners");
			LanguageRegistry.addName(BlockDiamondCorners, "Diamond Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockDiamondCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.blockDiamond)});
		} 
		if (config.getBlock("BlockWhiteWoolCorners",4016).getInt() != 0) {
			BlockWhiteWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockWhiteWoolCorners",4016).getInt(),
					Block.cloth).setUnlocalizedName("BlockWhiteWoolCorners");
			GameRegistry.registerBlock(BlockWhiteWoolCorners,"BlockWhiteWoolCorners");
			LanguageRegistry.addName(BlockWhiteWoolCorners, "Wool Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockWhiteWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth)});
		} 
		if (config.getBlock("BlockBlackWoolCorners",4017).getInt()!= 0) {
			BlockBlackWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockBlackWoolCorners",4017).getInt(),
					Block.cloth,15).setUnlocalizedName("BlockBlackWoolCorners");
			GameRegistry.registerBlock(BlockBlackWoolCorners,"BlockBlackWoolCorners");
			LanguageRegistry.addName(BlockBlackWoolCorners, "Black Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockBlackWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,15)});
		} 
		if (config.getBlock("BlockRedWoolCorners",4018).getInt() != 0) {
			BlockRedWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockRedWoolCorners",4018).getInt(),
					Block.cloth,14).setUnlocalizedName("BlockRedWoolCorners");
			GameRegistry.registerBlock(BlockRedWoolCorners,"BlockRedWoolCorners");
			LanguageRegistry.addName(BlockRedWoolCorners, "Red Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockRedWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,14)});
		}
		if (config.getBlock("BlockGreenWoolCorners",4019).getInt() != 0) {
			BlockGreenWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockGreenWoolCorners",4019).getInt(),
					Block.cloth,13).setUnlocalizedName("BlockGreenWoolCorners");
			GameRegistry.registerBlock(BlockGreenWoolCorners,"BlockGreenWoolCorners");
			LanguageRegistry.addName(BlockGreenWoolCorners, "Green Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGreenWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,13)});
		} 
		if (config.getBlock("BlockBrownWoolCorners",4020).getInt() != 0) {
			BlockBrownWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockBrownWoolCorners",4020).getInt(),
					Block.cloth, 12).setUnlocalizedName("BlockBrownWoolCorners");
			GameRegistry.registerBlock(BlockBrownWoolCorners,"BlockBrownWoolCorners");
			LanguageRegistry.addName(BlockBrownWoolCorners, "Brown Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockBrownWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,12)});
		} 
		if (config.getBlock("BlockBlueWoolCorners",4021).getInt() != 0) {
			BlockBlueWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockBlueWoolCorners",4021).getInt(),
					Block.cloth, 11).setUnlocalizedName("BlockBlueWoolCorners");
			GameRegistry.registerBlock(BlockBlueWoolCorners,"BlockBlueWoolCorners");
			LanguageRegistry.addName(BlockBlueWoolCorners, "Blue Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockBlueWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,11)});
		} 
		if (config.getBlock("BlockPurpleWoolCorners",4022).getInt() != 0) {
			BlockPurpleWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockPurpleWoolCorners",4022).getInt(),
					Block.cloth, 10).setUnlocalizedName("BlockPurpleWoolCorners");
			GameRegistry.registerBlock(BlockPurpleWoolCorners,"BlockPurpleWoolCorners");
			LanguageRegistry.addName(BlockPurpleWoolCorners, "Purple Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockPurpleWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,10)});
		} 
		if (config.getBlock("BlockCyanWoolCorners",4023).getInt() != 0) {
			BlockCyanWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockCyanWoolCorners",4023).getInt(),
					Block.cloth, 9).setUnlocalizedName("BlockCyanWoolCorners");
			GameRegistry.registerBlock(BlockCyanWoolCorners,"BlockCyanWoolCorners");
			LanguageRegistry.addName(BlockCyanWoolCorners, "Cyan Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockCyanWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,9)});
		} 
		if (config.getBlock("BlockSilverWoolCorners",4024).getInt()!= 0) {
			BlockSilverWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockSilverWoolCorners",4024).getInt(),
					Block.cloth, 8).setUnlocalizedName("BlockSilverWoolCorners");
			GameRegistry.registerBlock(BlockSilverWoolCorners,"BlockSilverWoolCorners");
			LanguageRegistry.addName(BlockSilverWoolCorners, "Silver Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockSilverWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,8)});
		} 
		if (config.getBlock("BlockGrayWoolCorners",4025).getInt() != 0) {
			BlockGrayWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockGrayWoolCorners",4025).getInt(),
					Block.cloth, 7).setUnlocalizedName("BlockGrayWoolCorners");
			GameRegistry.registerBlock(BlockGrayWoolCorners,"BlockGrayWoolCorners");
			LanguageRegistry.addName(BlockGrayWoolCorners, "Gray Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGrayWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,7)});
		} 
		if (config.getBlock("BlockPinkWoolCorners",4026).getInt() != 0) {
			BlockPinkWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockPinkWoolCorners",4026).getInt(),
					Block.cloth, 6).setUnlocalizedName("BlockPinkWoolCorners");
			GameRegistry.registerBlock(BlockPinkWoolCorners,"BlockPinkWoolCorners");
			LanguageRegistry.addName(BlockPinkWoolCorners, "Pink Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockPinkWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,6)});
		} 
		if (config.getBlock("BlockLimeWoolCorners",4027).getInt() != 0) {
			BlockLimeWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockLimeWoolCorners",4027).getInt(),
					Block.cloth, 5).setUnlocalizedName("BlockLimeWoolCorners");
			GameRegistry.registerBlock(BlockLimeWoolCorners,"BlockLimeWoolCorners");
			LanguageRegistry.addName(BlockLimeWoolCorners, "Lime Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockLimeWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,5)});
		}
		if (config.getBlock("BlockYellowWoolCorners",4028).getInt() != 0) {
			BlockYellowWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockYellowWoolCorners",4028).getInt(),
					Block.cloth, 4).setUnlocalizedName("BlockYellowWoolCorners");
			GameRegistry.registerBlock(BlockYellowWoolCorners,"BlockYellowWoolCorners");
			LanguageRegistry.addName(BlockYellowWoolCorners, "Yellow Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockYellowWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,4)});
		}
		if (config.getBlock("BlockLightBlueWoolCorners",4029).getInt() != 0) {
			BlockLightBlueWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockLightBlueWoolCorners",4029).getInt(),
					Block.cloth, 3).setUnlocalizedName("BlockLightBlueWoolCorners");
			GameRegistry.registerBlock(BlockLightBlueWoolCorners,"BlockLightBlueWoolCorners");
			LanguageRegistry.addName(BlockLightBlueWoolCorners, "Light Blue Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockLightBlueWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,3)});
		}
		if (config.getBlock("BlockMagentaWoolCorners",4030).getInt() != 0) {
			BlockMagentaWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockMagentaWoolCorners",4030).getInt(),
					Block.cloth, 2).setUnlocalizedName("BlockMagentaWoolCorners");
			GameRegistry.registerBlock(BlockMagentaWoolCorners,"BlockMagentaWoolCorners");
			LanguageRegistry.addName(BlockMagentaWoolCorners, "Magenta Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockMagentaWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,2)});
		} 
		if (config.getBlock("BlockOrangeWoolCorners",4031).getInt() != 0) {
			BlockOrangeWoolCorners = new BlockTriPointCorner(
					config.getBlock("BlockOrangeWoolCorners",4031).getInt(),
					Block.cloth, 1).setUnlocalizedName("BlockOrangeWoolCorners");
			GameRegistry.registerBlock(BlockOrangeWoolCorners,"BlockOrangeWoolCorners");
			LanguageRegistry.addName(BlockOrangeWoolCorners, "Orange Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockOrangeWoolCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.cloth,1,1)});
		}
		if (config.getBlock("NetherBricksCorners",4032).getInt() != 0) {
			BlockNetherBricksCorners = new BlockTriPointCorner(
					config.getBlock("NetherBricksCorners",4032).getInt(),
					Block.netherBrick).setUnlocalizedName("NetherBricksCorners");
			GameRegistry.registerBlock(BlockNetherBricksCorners,"NetherBricksCorners");
			LanguageRegistry.addName(BlockNetherBricksCorners, "Nether Brick Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockNetherBricksCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.netherBrick)});
		}
		if (config.getBlock("NetherQuartzCorners",4033).getInt() != 0) {
			BlockNetherQuartzCorners = new BlockTriPointCorner(
					config.getBlock("NetherQuartzCorners",4033).getInt(),
					Block.blockNetherQuartz).setUnlocalizedName("NetherQuartzCorners");
			GameRegistry.registerBlock(BlockNetherQuartzCorners,"NetherQuartzCorners");
			LanguageRegistry.addName(BlockNetherQuartzCorners, "Quartz Slanted Corner");
			GameRegistry.addShapedRecipe(new ItemStack(BlockNetherQuartzCorners,8),new Object[]{" A "," A ","AAA",'A', new ItemStack(Block.blockNetherQuartz)});
		}
		config.save();
		
	}

	private static void initializeOblicSlopes(Configuration config)
	{
		if (config.getBlock("BlockPlankBirchIntCorners", 4034).getInt() != 0) {
			BlockPlankBirchIntCorners = new BlockOblicSlopes(
			config.getBlock("BlockPlankBirchIntCorners", 4034).getInt(),
			Block.planks,2).setUnlocalizedName("BlockPlankBirchIntCorners");
			GameRegistry.registerBlock(BlockPlankBirchIntCorners,"BlockPlankBirchIntCorners");
			LanguageRegistry.addName(BlockPlankBirchIntCorners, "Birch Wood Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockPlankBirchIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.planks,1,2)});
		} 
		if (config.getBlock("BlockPlankSpruceIntCorners", 4035).getInt() != 0) {
			BlockPlankSpruceIntCorners = new BlockOblicSlopes(
			config.getBlock("BlockPlankSpruceIntCorners", 4035).getInt(),
			Block.planks,1).setUnlocalizedName("BlockPlankSpruceIntCorners");
			GameRegistry.registerBlock(BlockPlankSpruceIntCorners,"BlockPlankSpruceIntCorners");
			LanguageRegistry.addName(BlockPlankSpruceIntCorners, "Spruce Wood Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockPlankSpruceIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.planks,1,1)});
		} 
		if (config.getBlock("BlockPlankJungleIntCorners", 4036).getInt() != 0) {
			BlockPlankJungleIntCorners = new BlockOblicSlopes(
			config.getBlock("BlockPlankJungleIntCorners", 4036).getInt(),
			Block.planks,3).setUnlocalizedName("BlockPlankJungleIntCorners");
			GameRegistry.registerBlock(BlockPlankJungleIntCorners,"BlockPlankJungleIntCorners");
			LanguageRegistry.addName(BlockPlankJungleIntCorners, "Jungle Wood Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockPlankJungleIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.planks,1,3)});
		} 
		if (config.getBlock("BlockPlankOakIntCorners", 4037).getInt() != 0) {
			BlockPlankOakIntCorners = new BlockOblicSlopes(
			config.getBlock("BlockPlankOakIntCorners", 4037).getInt(),
			Block.planks).setUnlocalizedName("BlockPlankOakIntCorners");
			GameRegistry.registerBlock(BlockPlankOakIntCorners,"BlockPlankOakIntCorners");
			LanguageRegistry.addName(BlockPlankOakIntCorners, "Oak Wood Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockPlankOakIntCorners,4),new Object[]{"  A","AAA",'A',new ItemStack(Block.planks)});
		} 
		if (config.getBlock("BlockCobblestoneIntCorners", 4038).getInt() != 0) {
			BlockCobblestoneIntCorners = new BlockOblicSlopes(
			config.getBlock("BlockCobblestoneIntCorners", 4038).getInt(),
			Block.cobblestone).setUnlocalizedName("BlockCobblestoneIntCorners");
			GameRegistry.registerBlock(BlockCobblestoneIntCorners,"BlockCobblestoneIntCorners");
			LanguageRegistry.addName(BlockCobblestoneIntCorners, "Stone Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockCobblestoneIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cobblestone)});
		} 
		if (config.getBlock("BlockGlassIntCorners", 4039).getInt() != 0) {
			BlockGlassIntCorners = new BlockOblicSlopes(
			config.getBlock("BlockGlassIntCorners", 4039).getInt(),
			Block.glass).setUnlocalizedName("BlockGlassIntCorners");
			GameRegistry.registerBlock(BlockGlassIntCorners,"BlockGlassIntCorners");
			LanguageRegistry.addName(BlockGlassIntCorners, "Glass Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGlassIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.glass)});
		} 
		if (config.getBlock("BlockSandstoneIntCorners", 4040).getInt() != 0) {
			BlockSandstoneIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockSandstoneIntCorners", 4040).getInt(),
					 Block.sandStone).setUnlocalizedName("BlockSandstoneIntCorners");
			GameRegistry.registerBlock(BlockSandstoneIntCorners,"BlockSandstoneIntCorners");
			LanguageRegistry.addName(BlockSandstoneIntCorners, "Sandstone Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockSandstoneIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.sandStone)});
		} 
		if (config.getBlock("BlockDirtIntCorners", 4041).getInt() != 0) {
			BlockDirtIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockDirtIntCorners", 4041).getInt(),
					Block.dirt).setUnlocalizedName("BlockDirtIntCorners");
			GameRegistry.registerBlock(BlockDirtIntCorners,"BlockDirtIntCorners");
			LanguageRegistry.addName(BlockDirtIntCorners, "Dirt Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockDirtIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.dirt)});
		} 
		if (config.getBlock("BlockStoneIntCorners", 4042).getInt() != 0) {
			BlockStoneIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockStoneIntCorners", 4042).getInt(),
					Block.stone).setUnlocalizedName("BlockStoneIntCorners");
			GameRegistry.registerBlock(BlockStoneIntCorners,"BlockStoneIntCorners");
			LanguageRegistry.addName(BlockStoneIntCorners, "Stone Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockStoneIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.stone)});
			if (BlockCobblestoneIntCorners!=null)GameRegistry.addSmelting(BlockCobblestoneIntCorners.blockID, new ItemStack(BlockStoneIntCorners), 0.1F);
		} 
		if (config.getBlock("BlockStoneBrickIntCorners", 4074).getInt() != 0) {
			BlockStoneBrickIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockStoneBrickIntCorners", 4074).getInt(),
					Block.stoneBrick).setUnlocalizedName("BlockStoneBrickIntCorners");
			GameRegistry.registerBlock(BlockStoneBrickIntCorners,"BlockStoneBrickIntCorners");
			LanguageRegistry.addName(BlockStoneBrickIntCorners, "Stone Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockStoneBrickIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.stoneBrick)});
			
		} 
		if (config.getBlock("BlockSandIntCorners", 4043).getInt() != 0) {
			BlockSandIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockSandIntCorners", 4043).getInt(),
					Block.sand).setUnlocalizedName("BlockSandIntCorners");
			GameRegistry.registerBlock(BlockSandIntCorners,"BlockSandIntCorners");
			LanguageRegistry.addName(BlockSandIntCorners, "Sand Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockSandIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.sand)});
		} 
		if (config.getBlock("BlockblockSnowIntCorners", 4044).getInt() != 0) {
			BlockblockSnowIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockblockSnowIntCorners", 4044).getInt(),
					Block.blockSnow).setUnlocalizedName("BlockblockSnowIntCorners");
			GameRegistry.registerBlock(BlockblockSnowIntCorners,"BlockblockSnowIntCorners");
			LanguageRegistry.addName(BlockblockSnowIntCorners, "Snow Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockblockSnowIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.blockSnow)});
		} 
		if (config.getBlock("BlockGrassIntCorners", 4045).getInt() != 0) {
			BlockGrassIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockGrassIntCorners", 4045).getInt(), 
					Block.grass).setUnlocalizedName("BlockGrassIntCorners");
			GameRegistry.registerBlock(BlockGrassIntCorners,"BlockGrassIntCorners");
			LanguageRegistry.addName(BlockGrassIntCorners, "Grass Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGrassIntCorners,4),new Object[]{"  A","AAA",'A',new ItemStack(Block.grass)});
		}
		if (config.getBlock("BlockBricksIntCorners", 4046).getInt() != 0) {
			BlockBricksIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockBricksIntCorners", 4046).getInt(),
					Block.brick).setUnlocalizedName("BlockBricksIntCorners");
			GameRegistry.registerBlock(BlockBricksIntCorners,"BlockBricksIntCorners");
			LanguageRegistry.addName(BlockBricksIntCorners, "Brick Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockBricksIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.brick)});
		}
		if (config.getBlock("BlockGravelIntCorners", 4047).getInt() != 0) {
			BlockGravelIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockGravelIntCorners", 4047).getInt(),
					Block.gravel).setUnlocalizedName("BlockGravelIntCorners");
			GameRegistry.registerBlock(BlockGravelIntCorners,"BlockGravelIntCorners");
			LanguageRegistry.addName(BlockGravelIntCorners, "Gravel Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGravelIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.gravel)});
		}
		if (config.getBlock("BlockGoldIntCorners", 4048).getInt() != 0) {
			BlockGoldIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockGoldIntCorners", 4048).getInt(),
					Block.blockGold).setResistance(10F).setUnlocalizedName("BlockGoldIntCorners");
			GameRegistry.registerBlock(BlockGoldIntCorners,"BlockGoldIntCorners");
			LanguageRegistry.addName(BlockGoldIntCorners, "Gold Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGoldIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.blockGold)});
		} 
		if (config.getBlock("BlockSteelIntCorners", 4049).getInt() != 0) {
			BlockSteelIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockSteelIntCorners", 4049).getInt(),
					Block.blockIron).setUnlocalizedName("BlockSteelIntCorners");
			GameRegistry.registerBlock(BlockSteelIntCorners,"BlockSteelIntCorners");
			LanguageRegistry.addName(BlockSteelIntCorners, "Iron Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockSteelIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.blockIron)});
		}
		if (config.getBlock("BlockObsidianIntCorners", 4050).getInt() != 0) {
			BlockObsidianIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockObsidianIntCorners", 4050).getInt(),
					Block.obsidian).setUnlocalizedName("BlockObsidianIntCorners");
			GameRegistry.registerBlock(BlockObsidianIntCorners,"BlockObsidianIntCorners");
			LanguageRegistry.addName(BlockObsidianIntCorners, "Obsidian Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockObsidianIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.obsidian)});
		}
		if (config.getBlock("BlockDiamondIntCorners", 4051).getInt() != 0) {
			BlockDiamondIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockDiamondIntCorners", 4051).getInt(),
					Block.blockDiamond).setUnlocalizedName("BlockDiamondIntCorners");
			GameRegistry.registerBlock(BlockDiamondIntCorners,"BlockDiamondIntCorners");
			LanguageRegistry.addName(BlockDiamondIntCorners, "Diamond Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockDiamondIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.blockDiamond)});
		} 
		if (config.getBlock("BlockWhiteWoolIntCorners", 4052).getInt() != 0) {
			BlockWhiteWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockWhiteWoolIntCorners", 4052).getInt(),
					Block.cloth).setUnlocalizedName("BlockWhiteWoolIntCorners");
			GameRegistry.registerBlock(BlockWhiteWoolIntCorners,"BlockWhiteWoolIntCorners");
			LanguageRegistry.addName(BlockWhiteWoolIntCorners, "Wool Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockWhiteWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth)});
		}
		if (config.getBlock("BlockBlackWoolIntCorners", 4053).getInt() != 0) {
			BlockBlackWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockBlackWoolIntCorners", 4053).getInt(),
					 Block.cloth,15).setUnlocalizedName("BlockBlackWoolIntCorners");
			GameRegistry.registerBlock(BlockBlackWoolIntCorners,"BlockBlackWoolIntCorners");
			LanguageRegistry.addName(BlockBlackWoolIntCorners, "Black Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockBlackWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,15)});
		} 
		if (config.getBlock("BlockRedWoolIntCorners", 4054).getInt() != 0) {
			BlockRedWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockRedWoolIntCorners", 4054).getInt(), 
					Block.cloth,14).setUnlocalizedName("BlockRedWoolIntCorners");
			GameRegistry.registerBlock(BlockRedWoolIntCorners,"BlockRedWoolIntCorners");
			LanguageRegistry.addName(BlockRedWoolIntCorners, "Red Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockRedWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,14)});
		} 
		if (config.getBlock("BlockGreenWoolIntCorners", 4055).getInt() != 0) {
			BlockGreenWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockGreenWoolIntCorners", 4055).getInt(),
					 Block.cloth,13).setUnlocalizedName("BlockGreenWoolIntCorners");
			GameRegistry.registerBlock(BlockGreenWoolIntCorners,"BlockGreenWoolIntCorners");
			LanguageRegistry.addName(BlockGreenWoolIntCorners, "Green Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGreenWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,13)});
		} 
		if (config.getBlock("BlockBrownWoolIntCorners", 4056).getInt() != 0) {
			BlockBrownWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockBrownWoolIntCorners", 4056).getInt(),
					 Block.cloth,12).setUnlocalizedName("BlockBrownWoolIntCorners");
			GameRegistry.registerBlock(BlockBrownWoolIntCorners,"BlockBrownWoolIntCorners");
			LanguageRegistry.addName(BlockBrownWoolIntCorners, "Brown Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockBrownWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,12)});
		}
		if (config.getBlock("BlockBlueWoolIntCorners", 4057).getInt() != 0) {
			BlockBlueWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockBlueWoolIntCorners", 4057).getInt(), 
					Block.cloth,11).setUnlocalizedName("BlockBlueWoolIntCorners");
			GameRegistry.registerBlock(BlockBlueWoolIntCorners,"BlockBlueWoolIntCorners");
			LanguageRegistry.addName(BlockBlueWoolIntCorners, "Blue Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockBlueWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,11)});
		} 
		if (config.getBlock("BlockPurpleWoolIntCorners", 4058).getInt() != 0) {
			BlockPurpleWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockPurpleWoolIntCorners", 4058).getInt(),
					Block.cloth,10).setUnlocalizedName("BlockPurpleWoolIntCorners");
			GameRegistry.registerBlock(BlockPurpleWoolIntCorners,"BlockPurpleWoolIntCorners");
			LanguageRegistry.addName(BlockPurpleWoolIntCorners, "Purple Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockPurpleWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,10)});
		} 
		if (config.getBlock("BlockCyanWoolIntCorners", 4059).getInt() != 0) {
			BlockCyanWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockCyanWoolIntCorners", 4059).getInt(),
					Block.cloth,9).setUnlocalizedName("BlockCyanWoolIntCorners");
			GameRegistry.registerBlock(BlockCyanWoolIntCorners,"BlockCyanWoolIntCorners");
			LanguageRegistry.addName(BlockCyanWoolIntCorners, "Cyan Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockCyanWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,9)});
		} 
		if (config.getBlock("BlockSilverWoolIntCorners", 4060).getInt() != 0) {
			BlockSilverWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockSilverWoolIntCorners", 4060).getInt(),
					Block.cloth,8).setUnlocalizedName("BlockSilverWoolIntCorners");
			GameRegistry.registerBlock(BlockSilverWoolIntCorners,"BlockSilverWoolIntCorners");
			LanguageRegistry.addName(BlockSilverWoolIntCorners, "Silver Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockSilverWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,8)});
		} 
		if (config.getBlock("BlockGrayWoolIntCorners",4061).getInt() != 0) {
			BlockGrayWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockGrayWoolIntCorners", 4061).getInt(),
					Block.cloth,7).setUnlocalizedName("BlockGrayWoolIntCorners");
			GameRegistry.registerBlock(BlockGrayWoolIntCorners,"BlockGrayWoolIntCorners");
			LanguageRegistry.addName(BlockGrayWoolIntCorners, "Gray Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockGrayWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,7)});
		} 
		if (config.getBlock("BlockPinkWoolIntCorners",4062).getInt() != 0) {
			BlockPinkWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockPinkWoolIntCorners", 4062).getInt(),
					Block.cloth,6).setUnlocalizedName("BlockPinkWoolIntCorners");
			GameRegistry.registerBlock(BlockPinkWoolIntCorners,"BlockPinkWoolIntCorners");
			LanguageRegistry.addName(BlockPinkWoolIntCorners, "Pink Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockPinkWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,6)});
		} 
		if (config.getBlock("BlockLimeWoolIntCorners",4063).getInt() != 0) {
			BlockLimeWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockLimeWoolIntCorners", 4063).getInt(),
					Block.cloth,5).setUnlocalizedName("BlockLimeWoolIntCorners");
			GameRegistry.registerBlock(BlockLimeWoolIntCorners,"BlockLimeWoolIntCorners");
			LanguageRegistry.addName(BlockLimeWoolIntCorners, "Lime Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockLimeWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,5)});
		} 
		if (config.getBlock("BlockYellowWoolIntCorners",4064).getInt() != 0) {
			BlockYellowWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockYellowWoolIntCorners", 4064).getInt(),
					Block.cloth,4).setUnlocalizedName("BlockYellowWoolIntCorners");
			GameRegistry.registerBlock(BlockYellowWoolIntCorners,"BlockYellowWoolIntCorners");
			LanguageRegistry.addName(BlockYellowWoolIntCorners, "Yellow Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockYellowWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,4)});
		} 
		if (config.getBlock("BlockLightBlueWoolIntCorners",4065).getInt() != 0) {
			BlockLightBlueWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockLightBlueWoolIntCorners", 4065).getInt(),
					Block.cloth,3).setUnlocalizedName("BlockLightBlueWoolIntCorners");
			GameRegistry.registerBlock(BlockLightBlueWoolIntCorners,"BlockLightBlueWoolIntCorners");
			LanguageRegistry.addName(BlockLightBlueWoolIntCorners, "Ligth Blue Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockLightBlueWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,3)});
		} 
		if (config.getBlock("BlockMagentaWoolIntCorners",4066).getInt() != 0) {
			BlockMagentaWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockMagentaWoolIntCorners", 4066).getInt(),
					Block.cloth,2).setUnlocalizedName("BlockMagentaWoolIntCorners");
			GameRegistry.registerBlock(BlockMagentaWoolIntCorners,"BlockMagentaWoolIntCorners");
			LanguageRegistry.addName(BlockMagentaWoolIntCorners, "Magenta Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockMagentaWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,2)});
		} 
		if (config.getBlock("BlockOrangeWoolIntCorners",4067).getInt() != 0) {
			BlockOrangeWoolIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockOrangeWoolIntCorners", 4067).getInt(),
					Block.cloth,1).setUnlocalizedName("BlockOrangeWoolIntCorners");
			GameRegistry.registerBlock(BlockOrangeWoolIntCorners,"BlockOrangeWoolIntCorners");
			LanguageRegistry.addName(BlockOrangeWoolIntCorners, "Orange Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockOrangeWoolIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.cloth,1,1)});
		} 
		if (config.getBlock("BlockNetherBrickIntCorners",4068).getInt() != 0) {
			BlockNetherBrickIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockNetherBrickIntCorners", 4068).getInt(),
					Block.netherBrick).setUnlocalizedName("BlockNetherBrickIntCorners");
			GameRegistry.registerBlock(BlockNetherBrickIntCorners,"BlockNetherBrickIntCorners");
			LanguageRegistry.addName(BlockNetherBrickIntCorners, "Nether Brick Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockNetherBrickIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.netherBrick)});
		} 
		if (config.getBlock("BlockNetherQuartzIntCorners",4069).getInt() != 0) {
			BlockNetherQuartzIntCorners = new BlockOblicSlopes(
					config.getBlock("BlockNetherQuartzIntCorners", 4069).getInt(),
					Block.blockNetherQuartz).setUnlocalizedName("BlockNetherQuartzIntCorners");
			GameRegistry.registerBlock(BlockNetherQuartzIntCorners,"BlockNetherQuartzIntCorners");
			LanguageRegistry.addName(BlockNetherQuartzIntCorners, "Quartz Oblic Slope");
			GameRegistry.addShapedRecipe(new ItemStack(BlockNetherQuartzIntCorners,4),new Object[]{"  A","AAA",'A', new ItemStack(Block.blockNetherQuartz)});
		} 
		config.save();
	
		
	}
}
