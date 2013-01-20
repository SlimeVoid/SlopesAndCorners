package slimevoid.slopes.core.config;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;


import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.SidedProxy;

import slimevoid.lib.ICommonProxy;
import slimevoid.slopes.blocks.BlockSlopes;
import slimevoid.slopes.core.KrushProps;
import slimevoid.slopes.items.ItemSlopes;

public class SlopesConfig {
	@SidedProxy(
			clientSide="slimevoid.slopes.client.proxy.SL_ClientProxy",
			serverSide="slimevoid.slopes.proxy.SL_CommonProxy")
	public static ICommonProxy proxy;
	
	public static void prepareProps() {
		props.getInt("Slopes_Opacity", 0);
		props.getInt("BlockWoodSlopes", 3900);
		props.getInt("BlockCobblestoneSlopes", 3901);
		props.getInt("BlockGlassSlopes", 3902);
		props.getInt("BlockSandstoneSlopes", 3903);
		props.getInt("BlockDirtSlopes", 3904);
		props.getInt("BlockStoneSlopes", 3905);
		props.getInt("BlockSandSlopes", 3906);
		props.getInt("BlockSnowSlopes", 3907);
		props.getInt("BlockGrassSlopes", 3908);
		props.getInt("BlockBricksSlopes", 3909);
		props.getInt("BlockGravelSlopes", 3910);
		props.getInt("BlockGoldSlopes", 3911);
		props.getInt("BlockSteelSlopes", 3912);
		props.getInt("BlockObsidianSlopes", 3913);
		props.getInt("BlockDiamondSlopes", 3914);
		props.getInt("BlockWhiteWoolSlopes", 3915);
		props.getInt("BlockBlackWoolSlopes", 3916);
		props.getInt("BlockRedWoolSlopes", 3917);
		props.getInt("BlockGreenWoolSlopes", 3918);
		props.getInt("BlockBrownWoolSlopes", 3919);
		props.getInt("BlockBlueWoolSlopes", 3920);
		props.getInt("BlockPurpleWoolSlopes", 3921);
		props.getInt("BlockCyanWoolSlopes", 3922);
		props.getInt("BlockSilverWoolSlopes", 3923);
		props.getInt("BlockGrayWoolSlopes", 3924);
		props.getInt("BlockPinkWoolSlopes", 3925);
		props.getInt("BlockLimeWoolSlopes", 3926);
		props.getInt("BlockYellowWoolSlopes", 3927);
		props.getInt("BlockLightBlueWoolSlopes", 3928);
		props.getInt("BlockMagentaWoolSlopes", 3929);
		props.getInt("BlockOrangeWoolSlopes", 3930);
	}

	public static void configuration() {
		props = new KrushProps(new File(proxy.getMinecraftDir()
				+ "/config/Slopes.props").getPath());
		prepareProps();
		initialize();
		SlopesRenderID = RenderingRegistry.getNextAvailableRenderId();
		proxy.registerRenderInformation();

		if (props.getInt("BlockWoodSlopes") != 0) {

			ModLoader.addLocalization("WoodSlopesStairsUp.name",
					"Wooden Ceiling Stairs");
			ModLoader.addLocalization("WoodSlopesSlopeDown.name",
					"Wooden Sloped Floor");
			ModLoader.addLocalization("WoodSlopesSlopeUp.name",
					"Wooden Sloped Ceiling");
			ModLoader.addLocalization("WoodSlopesSlopeSide.name",
					"Wooden Corner");
			ModLoader
					.addRecipe(
							new ItemStack(BlockWoodSlopes, 3,
									BlockSlopes.func_21035_d(0)),
							new Object[] { "###", "## ", "#  ",
									Character.valueOf('#'), Block.planks });
			ModLoader
					.addRecipe(
							new ItemStack(BlockWoodSlopes, 5,
									BlockSlopes.func_21035_d(4)),
							new Object[] { "#  ", " # ", "###",
									Character.valueOf('#'), Block.planks });
			ModLoader
					.addRecipe(
							new ItemStack(BlockWoodSlopes, 5,
									BlockSlopes.func_21035_d(8)),
							new Object[] { "###", " # ", "#  ",
									Character.valueOf('#'), Block.planks });
			ModLoader
					.addRecipe(
							new ItemStack(BlockWoodSlopes, 4,
									BlockSlopes.func_21035_d(12)),
							new Object[] { " # ", " ##", " # ",
									Character.valueOf('#'), Block.planks });
			ModLoader.addRecipe(new ItemStack(Block.planks, 1), new Object[] {
					"#", Character.valueOf('#'), BlockWoodSlopes });
		}

		if (props.getInt("BlockCobblestoneSlopes") != 0) {

			ModLoader.addLocalization("CobblestoneSlopesStairsUp.name",
					"Cobblestone Ceiling Stairs");
			ModLoader.addLocalization("CobblestoneSlopesSlopeDown.name",
					"Cobblestone Sloped Floor");
			ModLoader.addLocalization("CobblestoneSlopesSlopeUp.name",
					"Cobblestone Sloped Ceiling");
			ModLoader.addLocalization("CobblestoneSlopesSlopeSide.name",
					"Cobblestone Corner");
			ModLoader.addRecipe(new ItemStack(BlockCobblestoneSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'),
					Block.cobblestone });
			ModLoader.addRecipe(new ItemStack(BlockCobblestoneSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'),
					Block.cobblestone });
			ModLoader.addRecipe(new ItemStack(BlockCobblestoneSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'),
					Block.cobblestone });
			ModLoader.addRecipe(new ItemStack(BlockCobblestoneSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'),
					Block.cobblestone });
			ModLoader.addRecipe(new ItemStack(Block.cobblestone, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockCobblestoneSlopes });
		}

		if (props.getInt("BlockGlassSlopes") != 0) {

			ModLoader.addLocalization("GlassSlopesStairsUp.name",
					"Glass Ceiling Stairs");
			ModLoader.addLocalization("GlassSlopesSlopeDown.name",
					"Glass Sloped Floor");
			ModLoader.addLocalization("GlassSlopesSlopeUp.name",
					"Glass Sloped Ceiling");
			ModLoader.addLocalization("GlassSlopesSlopeSide.name",
					"Glass Corner");
			ModLoader.addRecipe(new ItemStack(BlockGlassSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), Block.glass });
			ModLoader.addRecipe(new ItemStack(BlockGlassSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), Block.glass });
			ModLoader.addRecipe(new ItemStack(BlockGlassSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), Block.glass });
			ModLoader.addRecipe(new ItemStack(BlockGlassSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), Block.glass });
			ModLoader.addRecipe(new ItemStack(Block.glass, 1), new Object[] {
					"#", Character.valueOf('#'), BlockGlassSlopes });
		}

		if (props.getInt("BlockSandstoneSlopes") != 0) {

			ModLoader.addLocalization("SandstoneSlopesStairsUp.name",
					"Sandstone Ceiling Stairs");
			ModLoader.addLocalization("SandstoneSlopesSlopeDown.name",
					"Sandstone Sloped Floor");
			ModLoader.addLocalization("SandstoneSlopesSlopeUp.name",
					"Sandstone Sloped Ceiling");
			ModLoader.addLocalization("SandstoneSlopesSlopeSide.name",
					"Sandstone Corner");
			ModLoader.addRecipe(new ItemStack(BlockSandstoneSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'),
					Block.sandStone });
			ModLoader.addRecipe(new ItemStack(BlockSandstoneSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'),
					Block.sandStone });
			ModLoader.addRecipe(new ItemStack(BlockSandstoneSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'),
					Block.sandStone });
			ModLoader.addRecipe(new ItemStack(BlockSandstoneSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'),
					Block.sandStone });
			ModLoader.addRecipe(new ItemStack(Block.sandStone, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockSandstoneSlopes });
		}

		if (props.getInt("BlockDirtSlopes") != 0) {

			ModLoader.addLocalization("DirtSlopesStairsUp.name",
					"Dirt Ceiling Stairs");
			ModLoader.addLocalization("DirtSlopesSlopeDown.name",
					"Dirt Sloped Floor");
			ModLoader.addLocalization("DirtSlopesSlopeUp.name",
					"Dirt Sloped Ceiling");
			ModLoader.addLocalization("DirtSlopesSlopeSide.name",
					"Dirt Corner");
			ModLoader.addRecipe(new ItemStack(BlockDirtSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), Block.dirt });
			ModLoader.addRecipe(new ItemStack(BlockDirtSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), Block.dirt });
			ModLoader.addRecipe(new ItemStack(BlockDirtSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), Block.dirt });
			ModLoader.addRecipe(new ItemStack(BlockDirtSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), Block.dirt });
			ModLoader.addRecipe(new ItemStack(Block.dirt, 1), new Object[] {
					"#", Character.valueOf('#'), BlockDirtSlopes });
		}

		if (props.getInt("BlockStoneSlopes") != 0) {

			ModLoader.addLocalization("StoneSlopesStairsUp.name",
					"Stone Ceiling Stairs");
			ModLoader.addLocalization("StoneSlopesSlopeDown.name",
					"Stone Sloped Floor");
			ModLoader.addLocalization("StoneSlopesSlopeUp.name",
					"Stone Sloped Ceiling");
			ModLoader.addLocalization("StoneSlopesSlopeSide.name",
					"Stone Corner");
			ModLoader.addRecipe(new ItemStack(BlockStoneSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), Block.stone });
			ModLoader.addRecipe(new ItemStack(BlockStoneSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), Block.stone });
			ModLoader.addRecipe(new ItemStack(BlockStoneSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), Block.stone });
			ModLoader.addRecipe(new ItemStack(BlockStoneSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), Block.stone });
			ModLoader.addRecipe(new ItemStack(Block.stone, 1), new Object[] {
					"#", Character.valueOf('#'), BlockStoneSlopes });
		}

		if (props.getInt("BlockSandSlopes") != 0) {

			ModLoader.addLocalization("SandSlopesStairsUp.name",
					"Sand Ceiling Stairs");
			ModLoader.addLocalization("SandSlopesSlopeDown.name",
					"Sand Sloped Floor");
			ModLoader.addLocalization("SandSlopesSlopeUp.name",
					"Sand Sloped Ceiling");
			ModLoader.addLocalization("SandSlopesSlopeSide.name",
					"Sand Corner");
			ModLoader.addRecipe(new ItemStack(BlockSandSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), Block.sand });
			ModLoader.addRecipe(new ItemStack(BlockSandSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), Block.sand });
			ModLoader.addRecipe(new ItemStack(BlockSandSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), Block.sand });
			ModLoader.addRecipe(new ItemStack(BlockSandSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), Block.sand });
			ModLoader.addRecipe(new ItemStack(Block.sand, 1), new Object[] {
					"#", Character.valueOf('#'), BlockSandSlopes });
		}

		if (props.getInt("BlockSnowSlopes") != 0) {

			ModLoader.addLocalization("SnowSlopesStairsUp.name",
					"Snow Ceiling Stairs");
			ModLoader.addLocalization("SnowSlopesSlopeDown.name",
					"Snow Sloped Floor");
			ModLoader.addLocalization("SnowSlopesSlopeUp.name",
					"Snow Sloped Ceiling");
			ModLoader.addLocalization("SnowSlopesSlopeSide.name",
					"Snow Corner");
			ModLoader.addRecipe(new ItemStack(BlockSnowSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'),
					Block.blockSnow });
			ModLoader.addRecipe(new ItemStack(BlockSnowSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'),
					Block.blockSnow });
			ModLoader.addRecipe(new ItemStack(BlockSnowSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'),
					Block.blockSnow });
			ModLoader.addRecipe(new ItemStack(BlockSnowSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'),
					Block.blockSnow });
			ModLoader.addRecipe(new ItemStack(Block.blockSnow, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockSnowSlopes });
		}

		if (props.getInt("BlockGrassSlopes") != 0) {

			ModLoader.addLocalization("GrassSlopesStairsUp.name",
					"Grass Ceiling Stairs");
			ModLoader.addLocalization("GrassSlopesSlopeDown.name",
					"Grass Sloped Floor");
			ModLoader.addLocalization("GrassSlopesSlopeUp.name",
					"Grass Sloped Ceiling");
			ModLoader.addLocalization("GrassSlopesSlopeSide.name",
					"Grass Corner");
			ModLoader.addRecipe(new ItemStack(BlockGrassSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), Block.grass });
			ModLoader.addRecipe(new ItemStack(BlockGrassSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), Block.grass });
			ModLoader.addRecipe(new ItemStack(BlockGrassSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), Block.grass });
			ModLoader.addRecipe(new ItemStack(BlockGrassSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), Block.grass });
			ModLoader.addRecipe(new ItemStack(Block.grass, 1), new Object[] {
					"#", Character.valueOf('#'), BlockGrassSlopes });
		}

		if (props.getInt("BlockBricksSlopes") != 0) {

			ModLoader.addLocalization("BricksSlopesStairsUp.name",
					"Bricks Ceiling Stairs");
			ModLoader.addLocalization("BricksSlopesSlopeDown.name",
					"Bricks Sloped Floor");
			ModLoader.addLocalization("BricksSlopesSlopeUp.name",
					"Bricks Sloped Ceiling");
			ModLoader.addLocalization("BricksSlopesSlopeSide.name",
					"Bricks Corner");
			ModLoader.addRecipe(new ItemStack(BlockBricksSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), Block.brick });
			ModLoader.addRecipe(new ItemStack(BlockBricksSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), Block.brick });
			ModLoader.addRecipe(new ItemStack(BlockBricksSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), Block.brick });
			ModLoader.addRecipe(new ItemStack(BlockBricksSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), Block.brick });
			ModLoader.addRecipe(new ItemStack(Block.brick, 1), new Object[] {
					"#", Character.valueOf('#'), BlockBricksSlopes });
		}

		if (props.getInt("BlockGravelSlopes") != 0) {

			ModLoader.addLocalization("GravelSlopesStairsUp.name",
					"Gravel Ceiling Stairs");
			ModLoader.addLocalization("GravelSlopesSlopeDown.name",
					"Gravel Sloped Floor");
			ModLoader.addLocalization("GravelSlopesSlopeUp.name",
					"Gravel Sloped Ceiling");
			ModLoader.addLocalization("GravelSlopesSlopeSide.name",
					"Gravel Corner");
			ModLoader
					.addRecipe(
							new ItemStack(BlockGravelSlopes, 3,
									BlockSlopes.func_21035_d(0)),
							new Object[] { "###", "## ", "#  ",
									Character.valueOf('#'), Block.gravel });
			ModLoader
					.addRecipe(
							new ItemStack(BlockGravelSlopes, 5,
									BlockSlopes.func_21035_d(4)),
							new Object[] { "#  ", " # ", "###",
									Character.valueOf('#'), Block.gravel });
			ModLoader
					.addRecipe(
							new ItemStack(BlockGravelSlopes, 5,
									BlockSlopes.func_21035_d(8)),
							new Object[] { "###", " # ", "#  ",
									Character.valueOf('#'), Block.gravel });
			ModLoader
					.addRecipe(
							new ItemStack(BlockGravelSlopes, 4,
									BlockSlopes.func_21035_d(12)),
							new Object[] { " # ", " ##", " # ",
									Character.valueOf('#'), Block.gravel });
			ModLoader.addRecipe(new ItemStack(Block.gravel, 1), new Object[] {
					"#", Character.valueOf('#'), BlockGravelSlopes });
		}

		if (props.getInt("BlockGoldSlopes") != 0) {

			ModLoader.addLocalization("GoldSlopesStairsUp.name",
					"Golden Ceiling Stairs");
			ModLoader.addLocalization("GoldSlopesSlopeDown.name",
					"Golden Sloped Floor");
			ModLoader.addLocalization("GoldSlopesSlopeUp.name",
					"Golden Sloped Ceiling");
			ModLoader.addLocalization("GoldSlopesSlopeSide.name",
					"Golden Corner");
			ModLoader.addRecipe(new ItemStack(BlockGoldSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'),
					Block.blockGold });
			ModLoader.addRecipe(new ItemStack(BlockGoldSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'),
					Block.blockGold });
			ModLoader.addRecipe(new ItemStack(BlockGoldSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'),
					Block.blockGold });
			ModLoader.addRecipe(new ItemStack(BlockGoldSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'),
					Block.blockGold });
			ModLoader.addRecipe(new ItemStack(Block.blockGold, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockGoldSlopes });
		}

		if (props.getInt("BlockSteelSlopes") != 0) {

			ModLoader.addLocalization("SteelSlopesStairsUp.name",
					"Steel Ceiling Stairs");
			ModLoader.addLocalization("SteelSlopesSlopeDown.name",
					"Steel Sloped Floor");
			ModLoader.addLocalization("SteelSlopesSlopeUp.name",
					"Steel Sloped Ceiling");
			ModLoader.addLocalization("SteelSlopesSlopeSide.name",
					"Steel Corner");
			ModLoader.addRecipe(new ItemStack(BlockSteelSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'),
					Block.blockSteel });
			ModLoader.addRecipe(new ItemStack(BlockSteelSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'),
					Block.blockSteel });
			ModLoader.addRecipe(new ItemStack(BlockSteelSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'),
					Block.blockSteel });
			ModLoader.addRecipe(new ItemStack(BlockSteelSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'),
					Block.blockSteel });
			ModLoader.addRecipe(new ItemStack(Block.blockSteel, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockSteelSlopes });
		}

		if (props.getInt("BlockObsidianSlopes") != 0) {

			ModLoader.addLocalization("ObsidianSlopesStairsUp.name",
					"Obsidian Ceiling Stairs");
			ModLoader.addLocalization("ObsidianSlopesSlopeDown.name",
					"Obsidian Sloped Floor");
			ModLoader.addLocalization("ObsidianSlopesSlopeUp.name",
					"Obsidian Sloped Ceiling");
			ModLoader.addLocalization("ObsidianSlopesSlopeSide.name",
					"Obsidian Corner");
			ModLoader.addRecipe(new ItemStack(BlockObsidianSlopes, 3,
					BlockSlopes.func_21035_d(0)),
					new Object[] { "###", "## ", "#  ", Character.valueOf('#'),
							Block.obsidian });
			ModLoader.addRecipe(new ItemStack(BlockObsidianSlopes, 5,
					BlockSlopes.func_21035_d(4)),
					new Object[] { "#  ", " # ", "###", Character.valueOf('#'),
							Block.obsidian });
			ModLoader.addRecipe(new ItemStack(BlockObsidianSlopes, 5,
					BlockSlopes.func_21035_d(8)),
					new Object[] { "###", " # ", "#  ", Character.valueOf('#'),
							Block.obsidian });
			ModLoader.addRecipe(new ItemStack(BlockObsidianSlopes, 4,
					BlockSlopes.func_21035_d(12)),
					new Object[] { " # ", " ##", " # ", Character.valueOf('#'),
							Block.obsidian });
			ModLoader.addRecipe(new ItemStack(Block.obsidian, 1), new Object[] {
					"#", Character.valueOf('#'), BlockObsidianSlopes });
		}

		if (props.getInt("BlockDiamondSlopes") != 0) {

			ModLoader.addLocalization("DiamondSlopesStairsUp.name",
					"Diamond Ceiling Stairs");
			ModLoader.addLocalization("DiamondSlopesSlopeDown.name",
					"Diamond Sloped Floor");
			ModLoader.addLocalization("DiamondSlopesSlopeUp.name",
					"Diamond Sloped Ceiling");
			ModLoader.addLocalization("DiamondSlopesSlopeSide.name",
					"Diamond Corner");
			ModLoader.addRecipe(new ItemStack(BlockDiamondSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'),
					Block.blockDiamond });
			ModLoader.addRecipe(new ItemStack(BlockDiamondSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'),
					Block.blockDiamond });
			ModLoader.addRecipe(new ItemStack(BlockDiamondSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'),
					Block.blockDiamond });
			ModLoader.addRecipe(new ItemStack(BlockDiamondSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'),
					Block.blockDiamond });
			ModLoader.addRecipe(new ItemStack(Block.blockDiamond, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockDiamondSlopes });
		}

		if (props.getInt("BlockWhiteWoolSlopes") != 0) {

			ModLoader.addLocalization("WhiteWoolSlopesStairsUp.name",
					"White Ceiling Stairs");
			ModLoader.addLocalization("WhiteWoolSlopesSlopeDown.name",
					"White Sloped Floor");
			ModLoader.addLocalization("WhiteWoolSlopesSlopeUp.name",
					"White Sloped Ceiling");
			ModLoader.addLocalization("WhiteWoolSlopesSlopeSide.name",
					"White Corner");
			ModLoader.addRecipe(new ItemStack(BlockWhiteWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 0) });
			ModLoader.addRecipe(new ItemStack(BlockWhiteWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 0) });
			ModLoader.addRecipe(new ItemStack(BlockWhiteWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 0) });
			ModLoader.addRecipe(new ItemStack(BlockWhiteWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 0) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 0), new Object[] {
					"#", Character.valueOf('#'), BlockWhiteWoolSlopes });
		}

		if (props.getInt("BlockBlackWoolSlopes") != 0) {

			ModLoader.addLocalization("BlackWoolSlopesStairsUp.name",
					"Black Ceiling Stairs");
			ModLoader.addLocalization("BlackWoolSlopesSlopeDown.name",
					"Black Sloped Floor");
			ModLoader.addLocalization("BlackWoolSlopesSlopeUp.name",
					"Black Sloped Ceiling");
			ModLoader.addLocalization("BlackWoolSlopesSlopeSide.name",
					"Black Corner");
			ModLoader.addRecipe(new ItemStack(BlockBlackWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 15) });
			ModLoader.addRecipe(new ItemStack(BlockBlackWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 15) });
			ModLoader.addRecipe(new ItemStack(BlockBlackWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 15) });
			ModLoader.addRecipe(new ItemStack(BlockBlackWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 15) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 15),
					new Object[] { "#", Character.valueOf('#'),
							BlockBlackWoolSlopes });
		}

		if (props.getInt("BlockRedWoolSlopes") != 0) {

			ModLoader.addLocalization("RedWoolSlopesStairsUp.name",
					"Red Ceiling Stairs");
			ModLoader.addLocalization("RedWoolSlopesSlopeDown.name",
					"Red Sloped Floor");
			ModLoader.addLocalization("RedWoolSlopesSlopeUp.name",
					"Red Sloped Ceiling");
			ModLoader.addLocalization("RedWoolSlopesSlopeSide.name",
					"Red Corner");
			ModLoader.addRecipe(new ItemStack(BlockRedWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 14) });
			ModLoader.addRecipe(new ItemStack(BlockRedWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 14) });
			ModLoader.addRecipe(new ItemStack(BlockRedWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 14) });
			ModLoader.addRecipe(new ItemStack(BlockRedWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 14) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 14),
					new Object[] { "#", Character.valueOf('#'),
							BlockRedWoolSlopes });
		}

		if (props.getInt("BlockGreenWoolSlopes") != 0) {

			ModLoader.addLocalization("GreenWoolSlopesStairsUp.name",
					"Green Ceiling Stairs");
			ModLoader.addLocalization("GreenWoolSlopesSlopeDown.name",
					"Green Sloped Floor");
			ModLoader.addLocalization("GreenWoolSlopesSlopeUp.name",
					"Green Sloped Ceiling");
			ModLoader.addLocalization("GreenWoolSlopesSlopeSide.name",
					"Green Corner");
			ModLoader.addRecipe(new ItemStack(BlockGreenWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 13) });
			ModLoader.addRecipe(new ItemStack(BlockGreenWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 13) });
			ModLoader.addRecipe(new ItemStack(BlockGreenWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 13) });
			ModLoader.addRecipe(new ItemStack(BlockGreenWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 13) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 13),
					new Object[] { "#", Character.valueOf('#'),
							BlockGreenWoolSlopes });
		}

		if (props.getInt("BlockBrownWoolSlopes") != 0) {

			ModLoader.addLocalization("BrownWoolSlopesStairsUp.name",
					"Brown Ceiling Stairs");
			ModLoader.addLocalization("BrownWoolSlopesSlopeDown.name",
					"Brown Sloped Floor");
			ModLoader.addLocalization("BrownWoolSlopesSlopeUp.name",
					"Brown Sloped Ceiling");
			ModLoader.addLocalization("BrownWoolSlopesSlopeSide.name",
					"Brown Corner");
			ModLoader.addRecipe(new ItemStack(BlockBrownWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 12) });
			ModLoader.addRecipe(new ItemStack(BlockBrownWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 12) });
			ModLoader.addRecipe(new ItemStack(BlockBrownWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 12) });
			ModLoader.addRecipe(new ItemStack(BlockBrownWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 12) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 12),
					new Object[] { "#", Character.valueOf('#'),
							BlockBrownWoolSlopes });
		}

		if (props.getInt("BlockBlueWoolSlopes") != 0) {

			ModLoader.addLocalization("BlueWoolSlopesStairsUp.name",
					"Blue Ceiling Stairs");
			ModLoader.addLocalization("BlueWoolSlopesSlopeDown.name",
					"Blue Sloped Floor");
			ModLoader.addLocalization("BlueWoolSlopesSlopeUp.name",
					"Blue Sloped Ceiling");
			ModLoader.addLocalization("BlueWoolSlopesSlopeSide.name",
					"Blue Corner");
			ModLoader.addRecipe(new ItemStack(BlockBlueWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 11) });
			ModLoader.addRecipe(new ItemStack(BlockBlueWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 11) });
			ModLoader.addRecipe(new ItemStack(BlockBlueWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 11) });
			ModLoader.addRecipe(new ItemStack(BlockBlueWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 11) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 11),
					new Object[] { "#", Character.valueOf('#'),
							BlockBlueWoolSlopes });
		}

		if (props.getInt("BlockPurpleWoolSlopes") != 0) {

			ModLoader.addLocalization("PurpleWoolSlopesStairsUp.name",
					"Purple Ceiling Stairs");
			ModLoader.addLocalization("PurpleWoolSlopesSlopeDown.name",
					"Purple Sloped Floor");
			ModLoader.addLocalization("PurpleWoolSlopesSlopeUp.name",
					"Purple Sloped Ceiling");
			ModLoader.addLocalization("PurpleWoolSlopesSlopeSide.name",
					"Purple Corner");
			ModLoader.addRecipe(new ItemStack(BlockPurpleWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 10) });
			ModLoader.addRecipe(new ItemStack(BlockPurpleWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 10) });
			ModLoader.addRecipe(new ItemStack(BlockPurpleWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 10) });
			ModLoader.addRecipe(new ItemStack(BlockPurpleWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 10) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 10),
					new Object[] { "#", Character.valueOf('#'),
							BlockPurpleWoolSlopes });
		}

		if (props.getInt("BlockCyanWoolSlopes") != 0) {

			ModLoader.addLocalization("CyanWoolSlopesStairsUp.name",
					"Cyan Ceiling Stairs");
			ModLoader.addLocalization("CyanWoolSlopesSlopeDown.name",
					"Cyan Sloped Floor");
			ModLoader.addLocalization("CyanWoolSlopesSlopeUp.name",
					"Cyan Sloped Ceiling");
			ModLoader.addLocalization("CyanWoolSlopesSlopeSide.name",
					"Cyan Corner");
			ModLoader.addRecipe(new ItemStack(BlockCyanWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 9) });
			ModLoader.addRecipe(new ItemStack(BlockCyanWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 9) });
			ModLoader.addRecipe(new ItemStack(BlockCyanWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 9) });
			ModLoader.addRecipe(new ItemStack(BlockCyanWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 9) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 9), new Object[] {
					"#", Character.valueOf('#'), BlockCyanWoolSlopes });
		}

		if (props.getInt("BlockSilverWoolSlopes") != 0) {

			ModLoader.addLocalization("SilverWoolSlopesStairsUp.name",
					"Silver Ceiling Stairs");
			ModLoader.addLocalization("SilverWoolSlopesSlopeDown.name",
					"Silver Sloped Floor");
			ModLoader.addLocalization("SilverWoolSlopesSlopeUp.name",
					"Silver Sloped Ceiling");
			ModLoader.addLocalization("SilverWoolSlopesSlopeSide.name",
					"silver Corner");
			ModLoader.addRecipe(new ItemStack(BlockSilverWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 8) });
			ModLoader.addRecipe(new ItemStack(BlockSilverWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 8) });
			ModLoader.addRecipe(new ItemStack(BlockSilverWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 8) });
			ModLoader.addRecipe(new ItemStack(BlockSilverWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 8) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 8), new Object[] {
					"#", Character.valueOf('#'), BlockSilverWoolSlopes });
		}

		if (props.getInt("BlockGrayWoolSlopes") != 0) {

			ModLoader.addLocalization("GrayWoolSlopesStairsUp.name",
					"Gray Ceiling Stairs");
			ModLoader.addLocalization("GrayWoolSlopesSlopeDown.name",
					"Gray Sloped Floor");
			ModLoader.addLocalization("GrayWoolSlopesSlopeUp.name",
					"Gray Sloped Ceiling");
			ModLoader.addLocalization("GrayWoolSlopesSlopeSide.name",
					"Gray Corner");
			ModLoader.addRecipe(new ItemStack(BlockGrayWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 7) });
			ModLoader.addRecipe(new ItemStack(BlockGrayWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 7) });
			ModLoader.addRecipe(new ItemStack(BlockGrayWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 7) });
			ModLoader.addRecipe(new ItemStack(BlockGrayWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 7) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 7), new Object[] {
					"#", Character.valueOf('#'), BlockGrayWoolSlopes });
		}

		if (props.getInt("BlockPinkWoolSlopes") != 0) {

			ModLoader.addLocalization("PinkWoolSlopesStairsUp.name",
					"Pink Ceiling Stairs");
			ModLoader.addLocalization("PinkWoolSlopesSlopeDown.name",
					"Pink Sloped Floor");
			ModLoader.addLocalization("PinkWoolSlopesSlopeUp.name",
					"Pink Sloped Ceiling");
			ModLoader.addLocalization("PinkWoolSlopesSlopeSide.name",
					"Pink Corner");
			ModLoader.addRecipe(new ItemStack(BlockPinkWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 6) });
			ModLoader.addRecipe(new ItemStack(BlockPinkWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 6) });
			ModLoader.addRecipe(new ItemStack(BlockPinkWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 6) });
			ModLoader.addRecipe(new ItemStack(BlockPinkWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 6) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 6), new Object[] {
					"#", Character.valueOf('#'), BlockPinkWoolSlopes });
		}

		if (props.getInt("BlockLimeWoolSlopes") != 0) {

			ModLoader.addLocalization("LimeWoolSlopesStairsUp.name",
					"Lime Ceiling Stairs");
			ModLoader.addLocalization("LimeWoolSlopesSlopeDown.name",
					"Lime Sloped Floor");
			ModLoader.addLocalization("LimeWoolSlopesSlopeUp.name",
					"Lime Sloped Ceiling");
			ModLoader.addLocalization("LimeWoolSlopesSlopeSide.name",
					"Lime Corner");
			ModLoader.addRecipe(new ItemStack(BlockLimeWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 5) });
			ModLoader.addRecipe(new ItemStack(BlockLimeWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 5) });
			ModLoader.addRecipe(new ItemStack(BlockLimeWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 5) });
			ModLoader.addRecipe(new ItemStack(BlockLimeWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 5) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 5), new Object[] {
					"#", Character.valueOf('#'), BlockLimeWoolSlopes });
		}

		if (props.getInt("BlockYellowWoolSlopes") != 0) {

			ModLoader.addLocalization("YellowWoolSlopesStairsUp.name",
					"Yellow Ceiling Stairs");
			ModLoader.addLocalization("YellowWoolSlopesSlopeDown.name",
					"Yellow Sloped Floor");
			ModLoader.addLocalization("YellowWoolSlopesSlopeUp.name",
					"Yellow Sloped Ceiling");
			ModLoader.addLocalization("YellowWoolSlopesSlopeSide.name",
					"Yellow Corner");
			ModLoader.addRecipe(new ItemStack(BlockYellowWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 4) });
			ModLoader.addRecipe(new ItemStack(BlockYellowWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 4) });
			ModLoader.addRecipe(new ItemStack(BlockYellowWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 4) });
			ModLoader.addRecipe(new ItemStack(BlockYellowWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 4) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 4), new Object[] {
					"#", Character.valueOf('#'), BlockYellowWoolSlopes });
		}

		if (props.getInt("BlockLightBlueWoolSlopes") != 0) {

			ModLoader.addLocalization("LightBlueWoolSlopesStairsUp.name",
					"LightBlue Ceiling Stairs");
			ModLoader.addLocalization("LightBlueWoolSlopesSlopeDown.name",
					"LightBlue Sloped Floor");
			ModLoader.addLocalization("LightBlueWoolSlopesSlopeUp.name",
					"LightBlue Sloped Ceiling");
			ModLoader.addLocalization("LightBlueWoolSlopesSlopeSide.name",
					"LightBlue Corner");
			ModLoader.addRecipe(new ItemStack(BlockLightBlueWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 3) });
			ModLoader.addRecipe(new ItemStack(BlockLightBlueWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 3) });
			ModLoader.addRecipe(new ItemStack(BlockLightBlueWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 3) });
			ModLoader.addRecipe(new ItemStack(BlockLightBlueWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 3) });
			ModLoader
					.addRecipe(new ItemStack(Block.cloth, 1, 3), new Object[] {
							"#", Character.valueOf('#'),
							BlockLightBlueWoolSlopes });
		}

		if (props.getInt("BlockMagentaWoolSlopes") != 0) {

			ModLoader.addLocalization("MagentaWoolSlopesStairsUp.name",
					"Magenta Ceiling Stairs");
			ModLoader.addLocalization("MagentaWoolSlopesSlopeDown.name",
					"Magenta Sloped Floor");
			ModLoader.addLocalization("MagentaWoolSlopesSlopeUp.name",
					"Magenta Sloped Ceiling");
			ModLoader.addLocalization("MagentaWoolSlopesSlopeSide.name",
					"Magenta Corner");
			ModLoader.addRecipe(new ItemStack(BlockMagentaWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 2) });
			ModLoader.addRecipe(new ItemStack(BlockMagentaWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 2) });
			ModLoader.addRecipe(new ItemStack(BlockMagentaWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 2) });
			ModLoader.addRecipe(new ItemStack(BlockMagentaWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 2) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 2), new Object[] {
					"#", Character.valueOf('#'), BlockMagentaWoolSlopes });
		}

		if (props.getInt("BlockOrangeWoolSlopes") != 0) {

			ModLoader.addLocalization("OrangeWoolSlopesStairsUp.name",
					"Orange Ceiling Stairs");
			ModLoader.addLocalization("OrangeWoolSlopesSlopeDown.name",
					"Orange Sloped Floor");
			ModLoader.addLocalization("OrangeWoolSlopesSlopeUp.name",
					"Orange Sloped Ceiling");
			ModLoader.addLocalization("OrangeWoolSlopesSlopeSide.name",
					"Orange Corner");
			ModLoader.addRecipe(new ItemStack(BlockOrangeWoolSlopes, 3,
					BlockSlopes.func_21035_d(0)), new Object[] {
					"###", "## ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 1) });
			ModLoader.addRecipe(new ItemStack(BlockOrangeWoolSlopes, 5,
					BlockSlopes.func_21035_d(4)), new Object[] {
					"#  ", " # ", "###", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 1) });
			ModLoader.addRecipe(new ItemStack(BlockOrangeWoolSlopes, 5,
					BlockSlopes.func_21035_d(8)), new Object[] {
					"###", " # ", "#  ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 1) });
			ModLoader.addRecipe(new ItemStack(BlockOrangeWoolSlopes, 4,
					BlockSlopes.func_21035_d(12)), new Object[] {
					" # ", " ##", " # ", Character.valueOf('#'), new ItemStack(Block.cloth, 1, 1) });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 1), new Object[] {
					"#", Character.valueOf('#'), BlockOrangeWoolSlopes });
		}
	}

	public static KrushProps props;

	public static int SlopesRenderID;
	public static int SlopesOpacity;

	public static Block BlockWoodSlopes;
	public static Block BlockCobblestoneSlopes;
	public static Block BlockGlassSlopes;
	public static Block BlockSandstoneSlopes;
	public static Block BlockDirtSlopes;
	public static Block BlockStoneSlopes;
	public static Block BlockSandSlopes;
	public static Block BlockSnowSlopes;
	public static Block BlockGrassSlopes;
	public static Block BlockBricksSlopes;
	public static Block BlockGravelSlopes;
	public static Block BlockGoldSlopes;
	public static Block BlockSteelSlopes;
	public static Block BlockObsidianSlopes;
	public static Block BlockDiamondSlopes;
	public static Block BlockWhiteWoolSlopes;
	public static Block BlockBlackWoolSlopes;
	public static Block BlockRedWoolSlopes;
	public static Block BlockGreenWoolSlopes;
	public static Block BlockBrownWoolSlopes;
	public static Block BlockBlueWoolSlopes;
	public static Block BlockPurpleWoolSlopes;
	public static Block BlockCyanWoolSlopes;
	public static Block BlockSilverWoolSlopes;
	public static Block BlockGrayWoolSlopes;
	public static Block BlockPinkWoolSlopes;
	public static Block BlockLimeWoolSlopes;
	public static Block BlockYellowWoolSlopes;
	public static Block BlockLightBlueWoolSlopes;
	public static Block BlockMagentaWoolSlopes;
	public static Block BlockOrangeWoolSlopes;

	public static Item ItemWoodSlopes;
	public static Item ItemCobblestoneSlopes;
	public static Item ItemGlassSlopes;
	public static Item ItemSandstoneSlopes;
	public static Item ItemDirtSlopes;
	public static Item ItemStoneSlopes;
	public static Item ItemSandSlopes;
	public static Item ItemSnowSlopes;
	public static Item ItemGrassSlopes;
	public static Item ItemBricksSlopes;
	public static Item ItemGravelSlopes;
	public static Item ItemGoldSlopes;
	public static Item ItemSteelSlopes;
	public static Item ItemObsidianSlopes;
	public static Item ItemDiamondSlopes;
	public static Item ItemWhiteWoolSlopes;
	public static Item ItemBlackWoolSlopes;
	public static Item ItemRedWoolSlopes;
	public static Item ItemGreenWoolSlopes;
	public static Item ItemBrownWoolSlopes;
	public static Item ItemBlueWoolSlopes;
	public static Item ItemPurpleWoolSlopes;
	public static Item ItemCyanWoolSlopes;
	public static Item ItemSilverWoolSlopes;
	public static Item ItemGrayWoolSlopes;
	public static Item ItemPinkWoolSlopes;
	public static Item ItemLimeWoolSlopes;
	public static Item ItemYellowWoolSlopes;
	public static Item ItemLightBlueWoolSlopes;
	public static Item ItemMagentaWoolSlopes;
	public static Item ItemOrangeWoolSlopes;

	public static void initialize() {
		SlopesOpacity = props.getInt("Slopes_Opacity");

		if (props.getInt("BlockWoodSlopes") != 0) {
			BlockWoodSlopes = new BlockSlopes(
					props.getInt("BlockWoodSlopes"), 4, Material.wood)
					.setHardness(2.0F).setStepSound(Block.soundWoodFootstep)
					.setResistance(5F).setBlockName("BlockWoodSlopes");
			ItemWoodSlopes = new ItemSlopes(
					BlockWoodSlopes.blockID - 256, "Wood")
					.setItemName("ItemWoodSlopes");
		} else {
			BlockWoodSlopes = Block.stone;
		}
		if (props.getInt("BlockCobblestoneSlopes") != 0) {
			BlockCobblestoneSlopes = new BlockSlopes(
					props.getInt("BlockCobblestoneSlopes"), 16,
					Material.rock).setHardness(2.0F)
					.setStepSound(Block.soundStoneFootstep).setResistance(10F)
					.setBlockName("BlockCobblestoneSlopes");
			ItemCobblestoneSlopes = new ItemSlopes(
					BlockCobblestoneSlopes.blockID - 256, "Cobblestone")
					.setItemName("ItemCobblestoneSlopes");
		} else {
			BlockCobblestoneSlopes = Block.stone;
		}
		if (props.getInt("BlockGlassSlopes") != 0) {
			BlockGlassSlopes = new BlockSlopes(
					props.getInt("BlockGlassSlopes"), 49, Material.glass)
					.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
					.setBlockName("BlockGlassSlopes");
			ItemGlassSlopes = new ItemSlopes(
					BlockGlassSlopes.blockID - 256, "Glass")
					.setItemName("ItemGlassSlopes");
		} else {
			BlockGlassSlopes = Block.stone;
		}
		if (props.getInt("BlockSandstoneSlopes") != 0) {
			BlockSandstoneSlopes = new BlockSlopes(
					props.getInt("BlockSandstoneSlopes"), 192,
					Material.rock).setHardness(0.8F)
					.setStepSound(Block.soundStoneFootstep)
					.setBlockName("BlockSandstoneSlopes");
			ItemSandstoneSlopes = new ItemSlopes(
					BlockSandstoneSlopes.blockID - 256, "Sandstone")
					.setItemName("ItemSandstoneSlopes");
		} else {
			BlockSandstoneSlopes = Block.stone;
		}
		if (props.getInt("BlockDirtSlopes") != 0) {
			BlockDirtSlopes = new BlockSlopes(
					props.getInt("BlockDirtSlopes"), 2, Material.ground)
					.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
					.setBlockName("BlockDirtSlopes");
			ItemDirtSlopes = new ItemSlopes(
					BlockDirtSlopes.blockID - 256, "Dirt")
					.setItemName("ItemDirtSlopes");
		} else {
			BlockDirtSlopes = Block.stone;
		}
		if (props.getInt("BlockStoneSlopes") != 0) {
			BlockStoneSlopes = new BlockSlopes(
					props.getInt("BlockStoneSlopes"), 1, Material.rock)
					.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
					.setResistance(10F).setBlockName("BlockStoneSlopes");
			ItemStoneSlopes = new ItemSlopes(
					BlockStoneSlopes.blockID - 256, "Stone")
					.setItemName("ItemStoneSlopes");
		} else {
			BlockStoneSlopes = Block.stone;
		}
		if (props.getInt("BlockSandSlopes") != 0) {
			BlockSandSlopes = new BlockSlopes(
					props.getInt("BlockSandSlopes"), 18, Material.sand)
					.setHardness(0.5F).setStepSound(Block.soundSandFootstep)
					.setBlockName("BlockSandSlopes");
			ItemSandSlopes = new ItemSlopes(
					BlockSandSlopes.blockID - 256, "Sand")
					.setItemName("ItemSandSlopes");
		} else {
			BlockSandSlopes = Block.stone;
		}
		if (props.getInt("BlockSnowSlopes") != 0) {
			BlockSnowSlopes = new BlockSlopes(
					props.getInt("BlockSnowSlopes"), 66, Material.snow)
					.setHardness(0.1F).setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockSnowSlopes");
			ItemSnowSlopes = new ItemSlopes(
					BlockSnowSlopes.blockID - 256, "Snow")
					.setItemName("ItemSnowSlopes");
		} else {
			BlockSnowSlopes = Block.stone;
		}
		if (props.getInt("BlockGrassSlopes") != 0) {
			BlockGrassSlopes = new BlockSlopes(
					props.getInt("BlockGrassSlopes"), 3, Material.ground)
					.setHardness(0.6F).setStepSound(Block.soundGrassFootstep)
					.setBlockName("BlockGrassSlopes");
			ItemGrassSlopes = new ItemSlopes(
					BlockGrassSlopes.blockID - 256, "Grass")
					.setItemName("ItemGrassSlopes");
		} else {
			BlockGrassSlopes = Block.stone;
		}
		if (props.getInt("BlockBricksSlopes") != 0) {
			BlockBricksSlopes = new BlockSlopes(
					props.getInt("BlockBricksSlopes"), 7, Material.rock)
					.setHardness(2.0F).setStepSound(Block.soundStoneFootstep)
					.setResistance(10F).setBlockName("BlockBricksSlopes");
			ItemBricksSlopes = new ItemSlopes(
					BlockBricksSlopes.blockID - 256, "Bricks")
					.setItemName("ItemBricksSlopes");
		} else {
			BlockBricksSlopes = Block.stone;
		}
		if (props.getInt("BlockGravelSlopes") != 0) {
			BlockGravelSlopes = new BlockSlopes(
					props.getInt("BlockGravelSlopes"), 19, Material.sand)
					.setHardness(0.6F).setStepSound(Block.soundGravelFootstep)
					.setBlockName("BlockGravelSlopes");
			ItemGravelSlopes = new ItemSlopes(
					BlockGravelSlopes.blockID - 256, "Gravel")
					.setItemName("ItemGravelSlopes");
		} else {
			BlockGravelSlopes = Block.stone;
		}
		if (props.getInt("BlockGoldSlopes") != 0) {
			BlockGoldSlopes = new BlockSlopes(
					props.getInt("BlockGoldSlopes"), 23, Material.iron)
					.setHardness(3F).setStepSound(Block.soundMetalFootstep)
					.setResistance(10F).setBlockName("BlockGoldSlopes");
			ItemGoldSlopes = new ItemSlopes(
					BlockGoldSlopes.blockID - 256, "Gold")
					.setItemName("ItemGoldSlopes");
		} else {
			BlockGoldSlopes = Block.stone;
		}
		if (props.getInt("BlockSteelSlopes") != 0) {
			BlockSteelSlopes = new BlockSlopes(
					props.getInt("BlockSteelSlopes"), 22, Material.iron)
					.setHardness(5F).setStepSound(Block.soundMetalFootstep)
					.setResistance(10F).setBlockName("BlockSteelSlopes");
			ItemSteelSlopes = new ItemSlopes(
					BlockSteelSlopes.blockID - 256, "Steel")
					.setItemName("ItemSteelSlopes");
		} else {
			BlockSteelSlopes = Block.stone;
		}
		if (props.getInt("BlockObsidianSlopes") != 0) {
			BlockObsidianSlopes = new BlockSlopes(
					props.getInt("BlockObsidianSlopes"), 37, Material.rock)
					.setHardness(10F).setStepSound(Block.soundStoneFootstep)
					.setResistance(2000F)
					.setBlockName("BlockObsidianSlopes");
			ItemObsidianSlopes = new ItemSlopes(
					BlockObsidianSlopes.blockID - 256, "Obsidian")
					.setItemName("ItemObsidianSlopes");
		} else {
			BlockObsidianSlopes = Block.stone;
		}
		if (props.getInt("BlockDiamondSlopes") != 0) {
			BlockDiamondSlopes = new BlockSlopes(
					props.getInt("BlockDiamondSlopes"), 24, Material.iron)
					.setHardness(5F).setStepSound(Block.soundMetalFootstep)
					.setResistance(10F).setBlockName("BlockDiamondSlopes");
			ItemDiamondSlopes = new ItemSlopes(
					BlockDiamondSlopes.blockID - 256, "Diamond")
					.setItemName("ItemDiamondSlopes");
		} else {
			BlockDiamondSlopes = Block.stone;
		}
		if (props.getInt("BlockWhiteWoolSlopes") != 0) {
			BlockWhiteWoolSlopes = new BlockSlopes(
					props.getInt("BlockWhiteWoolSlopes"), 64,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockWhiteWoolSlopes");
			ItemWhiteWoolSlopes = new ItemSlopes(
					BlockWhiteWoolSlopes.blockID - 256, "WhiteWool")
					.setItemName("ItemWhiteWoolSlopes");
		} else {
			BlockWhiteWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockBlackWoolSlopes") != 0) {
			BlockBlackWoolSlopes = new BlockSlopes(
					props.getInt("BlockBlackWoolSlopes"), 113,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockBlackWoolSlopes");
			ItemBlackWoolSlopes = new ItemSlopes(
					BlockBlackWoolSlopes.blockID - 256, "BlackWool")
					.setItemName("ItemBlackWoolSlopes");
		} else {
			BlockBlackWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockRedWoolSlopes") != 0) {
			BlockRedWoolSlopes = new BlockSlopes(
					props.getInt("BlockRedWoolSlopes"), 129, Material.cloth)
					.setHardness(1.0F).setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockRedWoolSlopes");
			ItemRedWoolSlopes = new ItemSlopes(
					BlockRedWoolSlopes.blockID - 256, "RedWool")
					.setItemName("ItemRedWoolSlopes");
		} else {
			BlockRedWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockGreenWoolSlopes") != 0) {
			BlockGreenWoolSlopes = new BlockSlopes(
					props.getInt("BlockGreenWoolSlopes"), 145,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockGreenWoolSlopes");
			ItemGreenWoolSlopes = new ItemSlopes(
					BlockGreenWoolSlopes.blockID - 256, "GreenWool")
					.setItemName("ItemGreenWoolSlopes");
		} else {
			BlockGreenWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockBrownWoolSlopes") != 0) {
			BlockBrownWoolSlopes = new BlockSlopes(
					props.getInt("BlockBrownWoolSlopes"), 161,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockBrownWoolSlopes");
			ItemBrownWoolSlopes = new ItemSlopes(
					BlockBrownWoolSlopes.blockID - 256, "BrownWool")
					.setItemName("ItemBrownWoolSlopes");
		} else {
			BlockBrownWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockBlueWoolSlopes") != 0) {
			BlockBlueWoolSlopes = new BlockSlopes(
					props.getInt("BlockBlueWoolSlopes"), 177,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockBlueWoolSlopes");
			ItemBlueWoolSlopes = new ItemSlopes(
					BlockBlueWoolSlopes.blockID - 256, "BlueWool")
					.setItemName("ItemBlueWoolSlopes");
		} else {
			BlockBlueWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockPurpleWoolSlopes") != 0) {
			BlockPurpleWoolSlopes = new BlockSlopes(
					props.getInt("BlockPurpleWoolSlopes"), 193,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockPurpleWoolSlopes");
			ItemPurpleWoolSlopes = new ItemSlopes(
					BlockPurpleWoolSlopes.blockID - 256, "PurpleWool")
					.setItemName("ItemPurpleWoolSlopes");
		} else {
			BlockPurpleWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockCyanWoolSlopes") != 0) {
			BlockCyanWoolSlopes = new BlockSlopes(
					props.getInt("BlockCyanWoolSlopes"), 209,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockCyanWoolSlopes");
			ItemCyanWoolSlopes = new ItemSlopes(
					BlockCyanWoolSlopes.blockID - 256, "CyanWool")
					.setItemName("ItemCyanWoolSlopes");
		} else {
			BlockCyanWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockSilverWoolSlopes") != 0) {
			BlockSilverWoolSlopes = new BlockSlopes(
					props.getInt("BlockSilverWoolSlopes"), 225,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockSilverWoolSlopes");
			ItemSilverWoolSlopes = new ItemSlopes(
					BlockSilverWoolSlopes.blockID - 256, "SilverWool")
					.setItemName("ItemSilverWoolSlopes");
		} else {
			BlockSilverWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockGrayWoolSlopes") != 0) {
			BlockGrayWoolSlopes = new BlockSlopes(
					props.getInt("BlockGrayWoolSlopes"), 114,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockGrayWoolSlopes");
			ItemGrayWoolSlopes = new ItemSlopes(
					BlockGrayWoolSlopes.blockID - 256, "GrayWool")
					.setItemName("ItemGrayWoolSlopes");
		} else {
			BlockGrayWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockPinkWoolSlopes") != 0) {
			BlockPinkWoolSlopes = new BlockSlopes(
					props.getInt("BlockPinkWoolSlopes"), 130,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockPinkWoolSlopes");
			ItemPinkWoolSlopes = new ItemSlopes(
					BlockPinkWoolSlopes.blockID - 256, "PinkWool")
					.setItemName("ItemPinkWoolSlopes");
		} else {
			BlockPinkWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockLimeWoolSlopes") != 0) {
			BlockLimeWoolSlopes = new BlockSlopes(
					props.getInt("BlockLimeWoolSlopes"), 146,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockLimeWoolSlopes");
			ItemLimeWoolSlopes = new ItemSlopes(
					BlockLimeWoolSlopes.blockID - 256, "LimeWool")
					.setItemName("ItemLimeWoolSlopes");
		} else {
			BlockLimeWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockYellowWoolSlopes") != 0) {
			BlockYellowWoolSlopes = new BlockSlopes(
					props.getInt("BlockYellowWoolSlopes"), 162,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockYellowWoolSlopes");
			ItemYellowWoolSlopes = new ItemSlopes(
					BlockYellowWoolSlopes.blockID - 256, "YellowWool")
					.setItemName("ItemYellowWoolSlopes");
		} else {
			BlockYellowWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockLightBlueWoolSlopes") != 0) {
			BlockLightBlueWoolSlopes = new BlockSlopes(
					props.getInt("BlockLightBlueWoolSlopes"), 178,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockLightBlueWoolSlopes");
			ItemLightBlueWoolSlopes = new ItemSlopes(
					BlockLightBlueWoolSlopes.blockID - 256, "LightBlueWool")
					.setItemName("ItemLightBlueWoolSlopes");
		} else {
			BlockLightBlueWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockMagentaWoolSlopes") != 0) {
			BlockMagentaWoolSlopes = new BlockSlopes(
					props.getInt("BlockMagentaWoolSlopes"), 194,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockMagentaWoolSlopes");
			ItemMagentaWoolSlopes = new ItemSlopes(
					BlockMagentaWoolSlopes.blockID - 256, "MagentaWool")
					.setItemName("ItemMagentaWoolSlopes");
		} else {
			BlockMagentaWoolSlopes = Block.stone;
		}
		if (props.getInt("BlockOrangeWoolSlopes") != 0) {
			BlockOrangeWoolSlopes = new BlockSlopes(
					props.getInt("BlockOrangeWoolSlopes"), 210,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockOrangeWoolSlopes");
			ItemOrangeWoolSlopes = new ItemSlopes(
					BlockOrangeWoolSlopes.blockID - 256, "OrangeWool")
					.setItemName("ItemOrangeWoolSlopes");
		} else {
			BlockOrangeWoolSlopes = Block.stone;
		}

		props.save();
	}

}