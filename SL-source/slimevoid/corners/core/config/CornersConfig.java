package slimevoid.corners.core.config;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.client.registry.RenderingRegistry;
import slimevoid.corners.blocks.BlockCorners;
import slimevoid.corners.core.CornerBlocks;
import slimevoid.corners.items.ItemCorners;
import slimevoid.slopes.core.KrushProps;

public class CornersConfig {
	
	public static void prepareProps() {
		props.getInt("Slopes_Opacity", 0);
		props.getInt("BlockWoodCorners", 3931);
		props.getInt("BlockCobblestoneCorners", 3932);
		props.getInt("BlockGlassCorners", 3933);
		props.getInt("BlockSandstoneCorners", 3934);
		props.getInt("BlockDirtCorners", 3935);
		props.getInt("BlockStoneCorners", 3936);
		props.getInt("BlockSandCorners", 3937);
		props.getInt("BlockSnowCorners", 3938);
		props.getInt("BlockGrassCorners", 3939);
		props.getInt("BlockBricksCorners", 3940);
		props.getInt("BlockGravelCorners", 3941);
		props.getInt("BlockGoldCorners", 3942);
		props.getInt("BlockSteelCorners", 3943);
		props.getInt("BlockObsidianCorners", 3944);
		props.getInt("BlockDiamondCorners", 3945);
		props.getInt("BlockWhiteWoolCorners", 3946);
		props.getInt("BlockBlackWoolCorners", 3947);
		props.getInt("BlockRedWoolCorners", 3948);
		props.getInt("BlockGreenWoolCorners", 3949);
		props.getInt("BlockBrownWoolCorners", 3950);
		props.getInt("BlockBlueWoolCorners", 3951);
		props.getInt("BlockPurpleWoolCorners", 3952);
		props.getInt("BlockCyanWoolCorners", 3953);
		props.getInt("BlockSilverWoolCorners", 3954);
		props.getInt("BlockGrayWoolCorners", 3955);
		props.getInt("BlockPinkWoolCorners", 3956);
		props.getInt("BlockLimeWoolCorners", 3957);
		props.getInt("BlockYellowWoolCorners", 3958);
		props.getInt("BlockLightBlueWoolCorners", 3959);
		props.getInt("BlockMagentaWoolCorners", 3960);
		props.getInt("BlockOrangeWoolCorners", 3961);
	}

	public static void configuration() {
		props = new KrushProps(new File(CornerBlocks.proxy.getMinecraftDir()
				+ "/config/Slopes.props").getPath());
		prepareProps();
		initialize();
		CornersRenderID = RenderingRegistry.getNextAvailableRenderId();
		CornerBlocks.proxy.registerRenderInformation();

		ModLoader.addLocalization("WoodSlopesQuadriCornerDown.name",
				"Wooden Sloped Angle");
		ModLoader.addLocalization("WoodSlopesQuadriCornerUp.name",
				"Wooden Ceiling Angle");
		ModLoader.addLocalization("WoodSlopesTriCornerDown.name",
				"Wooden Slanted Corner");
		ModLoader.addLocalization("WoodSlopesTriCornerUp.name",
				"Wooden Slanted Corner");

		ModLoader.addLocalization("CobblestoneSlopesQuadriCornerDown.name",
				"Cobblestone Sloped Angle");
		ModLoader.addLocalization("CobblestoneSlopesQuadriCornerUp.name",
				"Cobblestone Ceiling Angle");
		ModLoader.addLocalization("CobblestoneSlopesTriCornerDown.name",
				"Cobblestone Slanted Corner");
		ModLoader.addLocalization("CobblestoneSlopesTriCornerUp.name",
				"Cobblestone Slanted Corner");

		ModLoader.addLocalization("GlassSlopesQuadriCornerDown.name",
				"Glass Sloped Angle");
		ModLoader.addLocalization("GlassSlopesQuadriCornerUp.name",
				"Glass Ceiling Angle");
		ModLoader.addLocalization("GlassSlopesTriCornerDown.name",
				"Glass Slanted Corner");
		ModLoader.addLocalization("GlassSlopesTriCornerUp.name",
				"Glass Slanted Corner");

		ModLoader.addLocalization("SandstoneSlopesQuadriCornerDown.name",
				"Sandstone Sloped Angle");
		ModLoader.addLocalization("SandstoneSlopesQuadriCornerUp.name",
				"Sandstone Ceiling Angle");
		ModLoader.addLocalization("SandstoneSlopesTriCornerDown.name",
				"Sandstone Slanted Corner");
		ModLoader.addLocalization("SandstoneSlopesTriCornerUp.name",
				"Sandstone Slanted Corner");

		ModLoader.addLocalization("DirtSlopesQuadriCornerDown.name",
				"Dirt Sloped Angle");
		ModLoader.addLocalization("DirtSlopesQuadriCornerUp.name",
				"Dirt Ceiling Angle");
		ModLoader.addLocalization("DirtSlopesTriCornerDown.name",
				"Dirt Slanted Corner");
		ModLoader.addLocalization("DirtSlopesTriCornerUp.name",
				"Dirt Slanted Corner");

		ModLoader.addLocalization("StoneSlopesQuadriCornerDown.name",
				"Stone Sloped Angle");
		ModLoader.addLocalization("StoneSlopesQuadriCornerUp.name",
				"Stone Ceiling Angle");
		ModLoader.addLocalization("StoneSlopesTriCornerDown.name",
				"Stone Slanted Corner");
		ModLoader.addLocalization("StoneSlopesTriCornerUp.name",
				"Stone Slanted Corner");

		ModLoader.addLocalization("SandSlopesQuadriCornerDown.name",
				"Sand Sloped Angle");
		ModLoader.addLocalization("SandSlopesQuadriCornerUp.name",
				"Sand Ceiling Angle");
		ModLoader.addLocalization("SandSlopesTriCornerDown.name",
				"Sand Slanted Corner");
		ModLoader.addLocalization("SandSlopesTriCornerUp.name",
				"Sand Slanted Corner");

		ModLoader.addLocalization("SnowSlopesQuadriCornerDown.name",
				"Snow Sloped Angle");
		ModLoader.addLocalization("SnowSlopesQuadriCornerUp.name",
				"Snow Ceiling Angle");
		ModLoader.addLocalization("SnowSlopesTriCornerDown.name",
				"Snow Slanted Corner");
		ModLoader.addLocalization("SnowSlopesTriCornerUp.name",
				"Snow Slanted Corner");

		ModLoader.addLocalization("GrassSlopesQuadriCornerDown.name",
				"Grass Sloped Angle");
		ModLoader.addLocalization("GrassSlopesQuadriCornerUp.name",
				"Grass Ceiling Angle");
		ModLoader.addLocalization("GrassSlopesTriCornerDown.name",
				"Grass Slanted Corner");
		ModLoader.addLocalization("GrassSlopesTriCornerUp.name",
				"Grass Slanted Corner");

		ModLoader.addLocalization("BricksSlopesQuadriCornerDown.name",
				"Bricks Sloped Angle");
		ModLoader.addLocalization("BricksSlopesQuadriCornerUp.name",
				"Bricks Ceiling Angle");
		ModLoader.addLocalization("BricksSlopesTriCornerDown.name",
				"Bricks Slanted Corner");
		ModLoader.addLocalization("BricksSlopesTriCornerUp.name",
				"Bricks Slanted Corner");

		ModLoader.addLocalization("GravelSlopesQuadriCornerDown.name",
				"Gravel Sloped Angle");
		ModLoader.addLocalization("GravelSlopesQuadriCornerUp.name",
				"Gravel Ceiling Angle");
		ModLoader.addLocalization("GravelSlopesTriCornerDown.name",
				"Gravel Slanted Corner");
		ModLoader.addLocalization("GravelSlopesTriCornerUp.name",
				"Gravel Slanted Corner");

		ModLoader.addLocalization("GoldSlopesQuadriCornerDown.name",
				"Golden Sloped Angle");
		ModLoader.addLocalization("GoldSlopesQuadriCornerUp.name",
				"Golden Ceiling Angle");
		ModLoader.addLocalization("GoldSlopesTriCornerDown.name",
				"Golden Slanted Corner");
		ModLoader.addLocalization("GoldSlopesTriCornerUp.name",
				"Golden Slanted Corner");

		ModLoader.addLocalization("SteelSlopesQuadriCornerDown.name",
				"Steel Sloped Angle");
		ModLoader.addLocalization("SteelSlopesQuadriCornerUp.name",
				"Steel Ceiling Angle");
		ModLoader.addLocalization("SteelSlopesTriCornerDown.name",
				"Steel Slanted Corner");
		ModLoader.addLocalization("SteelSlopesTriCornerUp.name",
				"Steel Slanted Corner");

		ModLoader.addLocalization("ObsidianSlopesQuadriCornerDown.name",
				"Obsidian Sloped Angle");
		ModLoader.addLocalization("ObsidianSlopesQuadriCornerUp.name",
				"Obsidian Ceiling Angle");
		ModLoader.addLocalization("ObsidianSlopesTriCornerDown.name",
				"Obsidian Slanted Corner");
		ModLoader.addLocalization("ObsidianSlopesTriCornerUp.name",
				"Obsidian Slanted Corner");

		ModLoader.addLocalization("DiamondSlopesQuadriCornerDown.name",
				"Diamond Sloped Angle");
		ModLoader.addLocalization("DiamondSlopesQuadriCornerUp.name",
				"Diamond Ceiling Angle");
		ModLoader.addLocalization("DiamondSlopesTriCornerDown.name",
				"Diamond Slanted Corner");
		ModLoader.addLocalization("DiamondSlopesTriCornerUp.name",
				"Diamond Slanted Corner");

		ModLoader.addLocalization("WhiteWoolSlopesQuadriCornerDown.name",
				"White Sloped Angle");
		ModLoader.addLocalization("WhiteWoolSlopesQuadriCornerUp.name",
				"White Ceiling Angle");
		ModLoader.addLocalization("WhiteWoolSlopesTriCornerDown.name",
				"White Slanted Corner");
		ModLoader.addLocalization("WhiteWoolSlopesTriCornerUp.name",
				"White Slanted Corner");

		ModLoader.addLocalization("BlackWoolSlopesQuadriCornerDown.name",
				"Black Sloped Angle");
		ModLoader.addLocalization("BlackWoolSlopesQuadriCornerUp.name",
				"Black Ceiling Angle");
		ModLoader.addLocalization("BlackWoolSlopesTriCornerDown.name",
				"Black Slanted Corner");
		ModLoader.addLocalization("BlackWoolSlopesTriCornerUp.name",
				"Black Slanted Corner");

		ModLoader.addLocalization("RedWoolSlopesQuadriCornerDown.name",
				"Red Sloped Angle");
		ModLoader.addLocalization("RedWoolSlopesQuadriCornerUp.name",
				"Red Ceiling Angle");
		ModLoader.addLocalization("RedWoolSlopesTriCornerDown.name",
				"Red Slanted Corner");
		ModLoader.addLocalization("RedWoolSlopesTriCornerUp.name",
				"Red Slanted Corner");

		ModLoader.addLocalization("GreenWoolSlopesQuadriCornerDown.name",
				"Green Sloped Angle");
		ModLoader.addLocalization("GreenWoolSlopesQuadriCornerUp.name",
				"Green Ceiling Angle");
		ModLoader.addLocalization("GreenWoolSlopesTriCornerDown.name",
				"Green Slanted Corner");
		ModLoader.addLocalization("GreenWoolSlopesTriCornerUp.name",
				"Green Slanted Corner");

		ModLoader.addLocalization("BrownWoolSlopesQuadriCornerDown.name",
				"Brown Sloped Angle");
		ModLoader.addLocalization("BrownWoolSlopesQuadriCornerUp.name",
				"Brown Ceiling Angle");
		ModLoader.addLocalization("BrownWoolSlopesTriCornerDown.name",
				"Brown Slanted Corner");
		ModLoader.addLocalization("BrownWoolSlopesTriCornerUp.name",
				"Brown Slanted Corner");

		ModLoader.addLocalization("BlueWoolSlopesQuadriCornerDown.name",
				"Blue Sloped Angle");
		ModLoader.addLocalization("BlueWoolSlopesQuadriCornerUp.name",
				"Blue Ceiling Angle");
		ModLoader.addLocalization("BlueWoolSlopesTriCornerDown.name",
				"Blue Slanted Corner");
		ModLoader.addLocalization("BlueWoolSlopesTriCornerUp.name",
				"Blue Slanted Corner");

		ModLoader.addLocalization("PurpleWoolSlopesQuadriCornerDown.name",
				"Purple Sloped Angle");
		ModLoader.addLocalization("PurpleWoolSlopesQuadriCornerUp.name",
				"Purple Ceiling Angle");
		ModLoader.addLocalization("PurpleWoolSlopesTriCornerDown.name",
				"Purple Slanted Corner");
		ModLoader.addLocalization("PurpleWoolSlopesTriCornerUp.name",
				"Purple Slanted Corner");

		ModLoader.addLocalization("CyanWoolSlopesQuadriCornerDown.name",
				"Cyan Sloped Angle");
		ModLoader.addLocalization("CyanWoolSlopesQuadriCornerUp.name",
				"Cyan Ceiling Angle");
		ModLoader.addLocalization("CyanWoolSlopesTriCornerDown.name",
				"Cyan Slanted Corner");
		ModLoader.addLocalization("CyanWoolSlopesTriCornerUp.name",
				"Cyan Slanted Corner");

		ModLoader.addLocalization("SilverWoolSlopesQuadriCornerDown.name",
				"Silver Sloped Angle");
		ModLoader.addLocalization("SilverWoolSlopesQuadriCornerUp.name",
				"Silver Ceiling Angle");
		ModLoader.addLocalization("SilverWoolSlopesTriCornerDown.name",
				"Silver Slanted Corner");
		ModLoader.addLocalization("SilverWoolSlopesTriCornerUp.name",
				"Silver Slanted Corner");

		ModLoader.addLocalization("GrayWoolSlopesQuadriCornerDown.name",
				"Gray Sloped Angle");
		ModLoader.addLocalization("GrayWoolSlopesQuadriCornerUp.name",
				"Gray Ceiling Angle");
		ModLoader.addLocalization("GrayWoolSlopesTriCornerDown.name",
				"Gray Slanted Corner");
		ModLoader.addLocalization("GrayWoolSlopesTriCornerUp.name",
				"Gray Slanted Corner");

		ModLoader.addLocalization("PinkWoolSlopesQuadriCornerDown.name",
				"Pink Sloped Angle");
		ModLoader.addLocalization("PinkWoolSlopesQuadriCornerUp.name",
				"Pink Ceiling Angle");
		ModLoader.addLocalization("PinkWoolSlopesTriCornerDown.name",
				"Pink Slanted Corner");
		ModLoader.addLocalization("PinkWoolSlopesTriCornerUp.name",
				"Pink Slanted Corner");

		ModLoader.addLocalization("LimeWoolSlopesQuadriCornerDown.name",
				"Lime Sloped Angle");
		ModLoader.addLocalization("LimeWoolSlopesQuadriCornerUp.name",
				"Lime Ceiling Angle");
		ModLoader.addLocalization("LimeWoolSlopesTriCornerDown.name",
				"Lime Slanted Corner");
		ModLoader.addLocalization("LimeWoolSlopesTriCornerUp.name",
				"Lime Slanted Corner");

		ModLoader.addLocalization("YellowWoolSlopesQuadriCornerDown.name",
				"Yellow Sloped Angle");
		ModLoader.addLocalization("YellowWoolSlopesQuadriCornerUp.name",
				"Yellow Ceiling Angle");
		ModLoader.addLocalization("YellowWoolSlopesTriCornerDown.name",
				"Yellow Slanted Corner");
		ModLoader.addLocalization("YellowWoolSlopesTriCornerUp.name",
				"Yellow Slanted Corner");

		ModLoader.addLocalization(
				"LightBlueWoolSlopesQuadriCornerDown.name",
				"LightBlue Sloped Angle");
		ModLoader.addLocalization("LightBlueWoolSlopesQuadriCornerUp.name",
				"LightBlue Ceiling Angle");
		ModLoader.addLocalization("LightBlueWoolSlopesTriCornerDown.name",
				"LightBlue Slanted Corner");
		ModLoader.addLocalization("LightBlueWoolSlopesTriCornerUp.name",
				"LightBlue Slanted Corner");

		ModLoader.addLocalization("MagentaWoolSlopesQuadriCornerDown.name",
				"Magenta Sloped Angle");
		ModLoader.addLocalization("MagentaWoolSlopesQuadriCornerUp.name",
				"Magenta Ceiling Angle");
		ModLoader.addLocalization("MagentaWoolSlopesTriCornerDown.name",
				"Magenta Slanted Corner");
		ModLoader.addLocalization("MagentaWoolSlopesTriCornerUp.name",
				"Magenta Slanted Corner");

		ModLoader.addLocalization("OrangeWoolSlopesQuadriCornerDown.name",
				"Orange Sloped Angle");
		ModLoader.addLocalization("OrangeWoolSlopesQuadriCornerUp.name",
				"Orange Ceiling Angle");
		ModLoader.addLocalization("OrangeWoolSlopesTriCornerDown.name",
				"Orange Slanted Corner");
		ModLoader.addLocalization("OrangeWoolSlopesTriCornerUp.name",
				"Orange Slanted Corner");

		if (props.getInt("BlockWoodCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockWoodCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.planks });
			ModLoader.addRecipe(new ItemStack(BlockWoodCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.planks });
			ModLoader
					.addRecipe(
							new ItemStack(BlockWoodCorners, 4,
									BlockCorners.func_21035_d(8)),
							new Object[] { " # ", " # ", "###",
									Character.valueOf('#'), Block.planks });
			ModLoader
					.addRecipe(
							new ItemStack(BlockWoodCorners, 4,
									BlockCorners.func_21035_d(12)),
							new Object[] { "###", " # ", " # ",
									Character.valueOf('#'), Block.planks });
			ModLoader.addRecipe(new ItemStack(Block.planks, 1), new Object[] {
					"#", Character.valueOf('#'), BlockWoodCorners });
		}

		if (props.getInt("BlockCobblestoneCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockCobblestoneCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.cobblestone });
			ModLoader.addRecipe(new ItemStack(BlockCobblestoneCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.cobblestone });
			ModLoader.addRecipe(new ItemStack(BlockCobblestoneCorners, 4,
					BlockCorners.func_21035_d(8)), new Object[] {
					" # ", " # ", "###", Character.valueOf('#'),
					Block.cobblestone });
			ModLoader.addRecipe(new ItemStack(BlockCobblestoneCorners, 4,
					BlockCorners.func_21035_d(12)), new Object[] {
					"###", " # ", " # ", Character.valueOf('#'),
					Block.cobblestone });
			ModLoader.addRecipe(new ItemStack(Block.cobblestone, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockCobblestoneCorners });
		}

		if (props.getInt("BlockGlassCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockGlassCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.glass });
			ModLoader.addRecipe(new ItemStack(BlockGlassCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.glass });
			ModLoader.addRecipe(new ItemStack(BlockGlassCorners, 4,
					BlockCorners.func_21035_d(8)), new Object[] {
					" # ", " # ", "###", Character.valueOf('#'), Block.glass });
			ModLoader.addRecipe(new ItemStack(BlockGlassCorners, 4,
					BlockCorners.func_21035_d(12)), new Object[] {
					"###", " # ", " # ", Character.valueOf('#'), Block.glass });
			ModLoader.addRecipe(new ItemStack(Block.glass, 1), new Object[] {
					"#", Character.valueOf('#'), BlockGlassCorners });
		}

		if (props.getInt("BlockSandstoneCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockSandstoneCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.sandStone });
			ModLoader.addRecipe(new ItemStack(BlockSandstoneCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.sandStone });
			ModLoader.addRecipe(new ItemStack(BlockSandstoneCorners, 4,
					BlockCorners.func_21035_d(8)), new Object[] {
					" # ", " # ", "###", Character.valueOf('#'),
					Block.sandStone });
			ModLoader.addRecipe(new ItemStack(BlockSandstoneCorners, 4,
					BlockCorners.func_21035_d(12)), new Object[] {
					"###", " # ", " # ", Character.valueOf('#'),
					Block.sandStone });
			ModLoader.addRecipe(new ItemStack(Block.sandStone, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockSandstoneCorners });
		}

		if (props.getInt("BlockDirtCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockDirtCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.dirt });
			ModLoader.addRecipe(new ItemStack(BlockDirtCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.dirt });
			ModLoader.addRecipe(new ItemStack(BlockDirtCorners, 4,
					BlockCorners.func_21035_d(8)), new Object[] {
					" # ", " # ", "###", Character.valueOf('#'), Block.dirt });
			ModLoader.addRecipe(new ItemStack(BlockDirtCorners, 4,
					BlockCorners.func_21035_d(12)), new Object[] {
					"###", " # ", " # ", Character.valueOf('#'), Block.dirt });
			ModLoader.addRecipe(new ItemStack(Block.dirt, 1), new Object[] {
					"#", Character.valueOf('#'), BlockDirtCorners });
		}

		if (props.getInt("BlockStoneCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockStoneCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.stone });
			ModLoader.addRecipe(new ItemStack(BlockStoneCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.stone });
			ModLoader.addRecipe(new ItemStack(BlockStoneCorners, 4,
					BlockCorners.func_21035_d(8)), new Object[] {
					" # ", " # ", "###", Character.valueOf('#'), Block.stone });
			ModLoader.addRecipe(new ItemStack(BlockStoneCorners, 4,
					BlockCorners.func_21035_d(12)), new Object[] {
					"###", " # ", " # ", Character.valueOf('#'), Block.stone });
			ModLoader.addRecipe(new ItemStack(Block.stone, 1), new Object[] {
					"#", Character.valueOf('#'), BlockStoneCorners });
		}

		if (props.getInt("BlockSandCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockSandCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.sand });
			ModLoader.addRecipe(new ItemStack(BlockSandCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.sand });
			ModLoader.addRecipe(new ItemStack(BlockSandCorners, 4,
					BlockCorners.func_21035_d(8)), new Object[] {
					" # ", " # ", "###", Character.valueOf('#'), Block.sand });
			ModLoader.addRecipe(new ItemStack(BlockSandCorners, 4,
					BlockCorners.func_21035_d(12)), new Object[] {
					"###", " # ", " # ", Character.valueOf('#'), Block.sand });
			ModLoader.addRecipe(new ItemStack(Block.sand, 1), new Object[] {
					"#", Character.valueOf('#'), BlockSandCorners });
		}

		if (props.getInt("BlockSnowCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockSnowCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.blockSnow });
			ModLoader.addRecipe(new ItemStack(BlockSnowCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.blockSnow });
			ModLoader.addRecipe(new ItemStack(BlockSnowCorners, 4,
					BlockCorners.func_21035_d(8)), new Object[] {
					" # ", " # ", "###", Character.valueOf('#'),
					Block.blockSnow });
			ModLoader.addRecipe(new ItemStack(BlockSnowCorners, 4,
					BlockCorners.func_21035_d(12)), new Object[] {
					"###", " # ", " # ", Character.valueOf('#'),
					Block.blockSnow });
			ModLoader.addRecipe(new ItemStack(Block.blockSnow, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockSnowCorners });
		}

		if (props.getInt("BlockGrassCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockGrassCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.grass });
			ModLoader.addRecipe(new ItemStack(BlockGrassCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.grass });
			ModLoader.addRecipe(new ItemStack(BlockGrassCorners, 4,
					BlockCorners.func_21035_d(8)), new Object[] {
					" # ", " # ", "###", Character.valueOf('#'), Block.grass });
			ModLoader.addRecipe(new ItemStack(BlockGrassCorners, 4,
					BlockCorners.func_21035_d(12)), new Object[] {
					"###", " # ", " # ", Character.valueOf('#'), Block.grass });
			ModLoader.addRecipe(new ItemStack(Block.grass, 1), new Object[] {
					"#", Character.valueOf('#'), BlockGrassCorners });
		}

		if (props.getInt("BlockBricksCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockBricksCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.brick });
			ModLoader.addRecipe(new ItemStack(BlockBricksCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.brick });
			ModLoader.addRecipe(new ItemStack(BlockBricksCorners, 4,
					BlockCorners.func_21035_d(8)), new Object[] {
					" # ", " # ", "###", Character.valueOf('#'), Block.brick });
			ModLoader.addRecipe(new ItemStack(BlockBricksCorners, 4,
					BlockCorners.func_21035_d(12)), new Object[] {
					"###", " # ", " # ", Character.valueOf('#'), Block.brick });
			ModLoader.addRecipe(new ItemStack(Block.brick, 1), new Object[] {
					"#", Character.valueOf('#'), BlockBricksCorners });
		}

		if (props.getInt("BlockGravelCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockGravelCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.gravel });
			ModLoader.addRecipe(new ItemStack(BlockGravelCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.gravel });
			ModLoader
					.addRecipe(
							new ItemStack(BlockGravelCorners, 4,
									BlockCorners.func_21035_d(8)),
							new Object[] { " # ", " # ", "###",
									Character.valueOf('#'), Block.gravel });
			ModLoader
					.addRecipe(
							new ItemStack(BlockGravelCorners, 4,
									BlockCorners.func_21035_d(12)),
							new Object[] { "###", " # ", " # ",
									Character.valueOf('#'), Block.gravel });
			ModLoader.addRecipe(new ItemStack(Block.gravel, 1), new Object[] {
					"#", Character.valueOf('#'), BlockGravelCorners });
		}

		if (props.getInt("BlockGoldCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockGoldCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.blockGold });
			ModLoader.addRecipe(new ItemStack(BlockGoldCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.blockGold });
			ModLoader.addRecipe(new ItemStack(BlockGoldCorners, 4,
					BlockCorners.func_21035_d(8)), new Object[] {
					" # ", " # ", "###", Character.valueOf('#'),
					Block.blockGold });
			ModLoader.addRecipe(new ItemStack(BlockGoldCorners, 4,
					BlockCorners.func_21035_d(12)), new Object[] {
					"###", " # ", " # ", Character.valueOf('#'),
					Block.blockGold });
			ModLoader.addRecipe(new ItemStack(Block.blockGold, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockGoldCorners });
		}

		if (props.getInt("BlockSteelCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockSteelCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.blockSteel });
			ModLoader.addRecipe(new ItemStack(BlockSteelCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.blockSteel });
			ModLoader.addRecipe(new ItemStack(BlockSteelCorners, 4,
					BlockCorners.func_21035_d(8)), new Object[] {
					" # ", " # ", "###", Character.valueOf('#'),
					Block.blockSteel });
			ModLoader.addRecipe(new ItemStack(BlockSteelCorners, 4,
					BlockCorners.func_21035_d(12)), new Object[] {
					"###", " # ", " # ", Character.valueOf('#'),
					Block.blockSteel });
			ModLoader.addRecipe(new ItemStack(Block.blockSteel, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockSteelCorners });
		}

		if (props.getInt("BlockObsidianCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockObsidianCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.obsidian });
			ModLoader.addRecipe(new ItemStack(BlockObsidianCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.obsidian });
			ModLoader.addRecipe(new ItemStack(BlockObsidianCorners, 4,
					BlockCorners.func_21035_d(8)),
					new Object[] { " # ", " # ", "###", Character.valueOf('#'),
							Block.obsidian });
			ModLoader.addRecipe(new ItemStack(BlockObsidianCorners, 4,
					BlockCorners.func_21035_d(12)),
					new Object[] { "###", " # ", " # ", Character.valueOf('#'),
							Block.obsidian });
			ModLoader.addRecipe(new ItemStack(Block.obsidian, 1), new Object[] {
					"#", Character.valueOf('#'), BlockObsidianCorners });
		}

		if (props.getInt("BlockDiamondCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockDiamondCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.blockDiamond });
			ModLoader.addRecipe(new ItemStack(BlockDiamondCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.blockDiamond });
			ModLoader.addRecipe(new ItemStack(BlockDiamondCorners, 4,
					BlockCorners.func_21035_d(8)), new Object[] {
					" # ", " # ", "###", Character.valueOf('#'),
					Block.blockDiamond });
			ModLoader.addRecipe(new ItemStack(BlockDiamondCorners, 4,
					BlockCorners.func_21035_d(12)), new Object[] {
					"###", " # ", " # ", Character.valueOf('#'),
					Block.blockDiamond });
			ModLoader.addRecipe(new ItemStack(Block.blockDiamond, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockDiamondCorners });
		}

		if (props.getInt("BlockWhiteWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockWhiteWoolCorners, 4,
					BlockCorners.func_21035_d(0)), new Object[] {
					" # ", "###", Character.valueOf('#'), Block.cloth });
			ModLoader.addRecipe(new ItemStack(BlockWhiteWoolCorners, 4,
					BlockCorners.func_21035_d(4)), new Object[] {
					"###", " # ", Character.valueOf('#'), Block.cloth });
			ModLoader.addRecipe(new ItemStack(BlockWhiteWoolCorners, 4,
					BlockCorners.func_21035_d(8)), new Object[] {
					" # ", " # ", "###", Character.valueOf('#'), Block.cloth });
			ModLoader.addRecipe(new ItemStack(BlockWhiteWoolCorners, 4,
					BlockCorners.func_21035_d(12)), new Object[] {
					"###", " # ", " # ", Character.valueOf('#'), Block.cloth });
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 0), new Object[] {
					"#", Character.valueOf('#'), BlockWhiteWoolCorners });
		}

		if (props.getInt("BlockBlackWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 15),
					new Object[] { "#", Character.valueOf('#'),
							BlockBlackWoolCorners });
		}

		if (props.getInt("BlockRedWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 14),
					new Object[] { "#", Character.valueOf('#'),
							BlockRedWoolCorners });
		}

		if (props.getInt("BlockGreenWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 13),
					new Object[] { "#", Character.valueOf('#'),
							BlockGreenWoolCorners });
		}

		if (props.getInt("BlockBrownWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 12),
					new Object[] { "#", Character.valueOf('#'),
							BlockBrownWoolCorners });
		}

		if (props.getInt("BlockBlueWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 11),
					new Object[] { "#", Character.valueOf('#'),
							BlockBlueWoolCorners });
		}

		if (props.getInt("BlockPurpleWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 10),
					new Object[] { "#", Character.valueOf('#'),
							BlockPurpleWoolCorners });
		}

		if (props.getInt("BlockCyanWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 9), new Object[] {
					"#", Character.valueOf('#'), BlockCyanWoolCorners });
		}

		if (props.getInt("BlockSilverWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 8), new Object[] {
					"#", Character.valueOf('#'), BlockSilverWoolCorners });
		}

		if (props.getInt("BlockGrayWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 7), new Object[] {
					"#", Character.valueOf('#'), BlockGrayWoolCorners });
		}

		if (props.getInt("BlockPinkWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 6), new Object[] {
					"#", Character.valueOf('#'), BlockPinkWoolCorners });
		}

		if (props.getInt("BlockLimeWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 5), new Object[] {
					"#", Character.valueOf('#'), BlockLimeWoolCorners });
		}

		if (props.getInt("BlockYellowWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 4), new Object[] {
					"#", Character.valueOf('#'), BlockYellowWoolCorners });
		}

		if (props.getInt("BlockLightBlueWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 3),
					new Object[] { "#", Character.valueOf('#'),
							BlockLightBlueWoolCorners });
		}

		if (props.getInt("BlockMagentaWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 2), new Object[] {
					"#", Character.valueOf('#'), BlockMagentaWoolCorners });
		}

		if (props.getInt("BlockOrangeWoolCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 1), new Object[] {
					"#", Character.valueOf('#'), BlockOrangeWoolCorners });
		}
	}

	public static KrushProps props;

	public static int CornersRenderID;
	public static int SlopesOpacity;

	public static Block BlockWoodCorners;
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

	public static Item ItemWoodCorners;
	public static Item ItemCobblestoneCorners;
	public static Item ItemGlassCorners;
	public static Item ItemSandstoneCorners;
	public static Item ItemDirtCorners;
	public static Item ItemStoneCorners;
	public static Item ItemSandCorners;
	public static Item ItemSnowCorners;
	public static Item ItemGrassCorners;
	public static Item ItemBricksCorners;
	public static Item ItemGravelCorners;
	public static Item ItemGoldCorners;
	public static Item ItemSteelCorners;
	public static Item ItemObsidianCorners;
	public static Item ItemDiamondCorners;
	public static Item ItemWhiteWoolCorners;
	public static Item ItemBlackWoolCorners;
	public static Item ItemRedWoolCorners;
	public static Item ItemGreenWoolCorners;
	public static Item ItemBrownWoolCorners;
	public static Item ItemBlueWoolCorners;
	public static Item ItemPurpleWoolCorners;
	public static Item ItemCyanWoolCorners;
	public static Item ItemSilverWoolCorners;
	public static Item ItemGrayWoolCorners;
	public static Item ItemPinkWoolCorners;
	public static Item ItemLimeWoolCorners;
	public static Item ItemYellowWoolCorners;
	public static Item ItemLightBlueWoolCorners;
	public static Item ItemMagentaWoolCorners;
	public static Item ItemOrangeWoolCorners;

	public static void initialize() {
		SlopesOpacity = props.getInt("Slopes_Opacity");

		if (props.getInt("BlockWoodCorners") != 0) {
			BlockWoodCorners = new BlockCorners(
					props.getInt("BlockWoodCorners"), 4, Material.wood)
					.setHardness(2.0F).setStepSound(Block.soundWoodFootstep)
					.setResistance(5F).setBlockName("BlockWoodCorners");
			ItemWoodCorners = new ItemCorners(
					BlockWoodCorners.blockID - 256, "Wood")
					.setItemName("ItemWoodCorners");
		} else {
			BlockWoodCorners = Block.stone;
		}
		if (props.getInt("BlockCobblestoneCorners") != 0) {
			BlockCobblestoneCorners = new BlockCorners(
					props.getInt("BlockCobblestoneCorners"), 16,
					Material.rock).setHardness(2.0F)
					.setStepSound(Block.soundStoneFootstep).setResistance(10F)
					.setBlockName("BlockCobblestoneCorners");
			ItemCobblestoneCorners = new ItemCorners(
					BlockCobblestoneCorners.blockID - 256, "Cobblestone")
					.setItemName("ItemCobblestoneCorners");
		} else {
			BlockCobblestoneCorners = Block.stone;
		}
		if (props.getInt("BlockGlassCorners") != 0) {
			BlockGlassCorners = new BlockCorners(
					props.getInt("BlockGlassCorners"), 49, Material.glass)
					.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
					.setBlockName("BlockGlassCorners");
			ItemGlassCorners = new ItemCorners(
					BlockGlassCorners.blockID - 256, "Glass")
					.setItemName("ItemGlassCorners");
		} else {
			BlockGlassCorners = Block.stone;
		}
		if (props.getInt("BlockSandstoneCorners") != 0) {
			BlockSandstoneCorners = new BlockCorners(
					props.getInt("BlockSandstoneCorners"), 192,
					Material.rock).setHardness(0.8F)
					.setStepSound(Block.soundStoneFootstep)
					.setBlockName("BlockSandstoneCorners");
			ItemSandstoneCorners = new ItemCorners(
					BlockSandstoneCorners.blockID - 256, "Sandstone")
					.setItemName("ItemSandstoneCorners");
		} else {
			BlockSandstoneCorners = Block.stone;
		}
		if (props.getInt("BlockDirtCorners") != 0) {
			BlockDirtCorners = new BlockCorners(
					props.getInt("BlockDirtCorners"), 2, Material.ground)
					.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
					.setBlockName("BlockDirtCorners");
			ItemDirtCorners = new ItemCorners(
					BlockDirtCorners.blockID - 256, "Dirt")
					.setItemName("ItemDirtCorners");
		} else {
			BlockDirtCorners = Block.stone;
		}
		if (props.getInt("BlockStoneCorners") != 0) {
			BlockStoneCorners = new BlockCorners(
					props.getInt("BlockStoneCorners"), 1, Material.rock)
					.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
					.setResistance(10F).setBlockName("BlockStoneCorners");
			ItemStoneCorners = new ItemCorners(
					BlockStoneCorners.blockID - 256, "Stone")
					.setItemName("ItemStoneCorners");
		} else {
			BlockStoneCorners = Block.stone;
		}
		if (props.getInt("BlockSandCorners") != 0) {
			BlockSandCorners = new BlockCorners(
					props.getInt("BlockSandCorners"), 18, Material.sand)
					.setHardness(0.5F).setStepSound(Block.soundSandFootstep)
					.setBlockName("BlockSandCorners");
			ItemSandCorners = new ItemCorners(
					BlockSandCorners.blockID - 256, "Sand")
					.setItemName("ItemSandCorners");
		} else {
			BlockSandCorners = Block.stone;
		}
		if (props.getInt("BlockSnowCorners") != 0) {
			BlockSnowCorners = new BlockCorners(
					props.getInt("BlockSnowCorners"), 66, Material.snow)
					.setHardness(0.1F).setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockSnowCorners");
			ItemSnowCorners = new ItemCorners(
					BlockSnowCorners.blockID - 256, "Snow")
					.setItemName("ItemSnowCorners");
		} else {
			BlockSnowCorners = Block.stone;
		}
		if (props.getInt("BlockGrassCorners") != 0) {
			BlockGrassCorners = new BlockCorners(
					props.getInt("BlockGrassCorners"), 3, Material.ground)
					.setHardness(0.6F).setStepSound(Block.soundGrassFootstep)
					.setBlockName("BlockGrassCorners");
			ItemGrassCorners = new ItemCorners(
					BlockGrassCorners.blockID - 256, "Grass")
					.setItemName("ItemGrassCorners");
		} else {
			BlockGrassCorners = Block.stone;
		}
		if (props.getInt("BlockBricksCorners") != 0) {
			BlockBricksCorners = new BlockCorners(
					props.getInt("BlockBricksCorners"), 7, Material.rock)
					.setHardness(2.0F).setStepSound(Block.soundStoneFootstep)
					.setResistance(10F).setBlockName("BlockBricksCorners");
			ItemBricksCorners = new ItemCorners(
					BlockBricksCorners.blockID - 256, "Bricks")
					.setItemName("ItemBricksCorners");
		} else {
			BlockBricksCorners = Block.stone;
		}
		if (props.getInt("BlockGravelCorners") != 0) {
			BlockGravelCorners = new BlockCorners(
					props.getInt("BlockGravelCorners"), 19, Material.sand)
					.setHardness(0.6F).setStepSound(Block.soundGravelFootstep)
					.setBlockName("BlockGravelCorners");
			ItemGravelCorners = new ItemCorners(
					BlockGravelCorners.blockID - 256, "Gravel")
					.setItemName("ItemGravelCorners");
		} else {
			BlockGravelCorners = Block.stone;
		}
		if (props.getInt("BlockGoldCorners") != 0) {
			BlockGoldCorners = new BlockCorners(
					props.getInt("BlockGoldCorners"), 23, Material.iron)
					.setHardness(3F).setStepSound(Block.soundMetalFootstep)
					.setResistance(10F).setBlockName("BlockGoldCorners");
			ItemGoldCorners = new ItemCorners(
					BlockGoldCorners.blockID - 256, "Gold")
					.setItemName("ItemGoldCorners");
		} else {
			BlockGoldCorners = Block.stone;
		}
		if (props.getInt("BlockSteelCorners") != 0) {
			BlockSteelCorners = new BlockCorners(
					props.getInt("BlockSteelCorners"), 22, Material.iron)
					.setHardness(5F).setStepSound(Block.soundMetalFootstep)
					.setResistance(10F).setBlockName("BlockSteelCorners");
			ItemSteelCorners = new ItemCorners(
					BlockSteelCorners.blockID - 256, "Steel")
					.setItemName("ItemSteelCorners");
		} else {
			BlockSteelCorners = Block.stone;
		}
		if (props.getInt("BlockObsidianCorners") != 0) {
			BlockObsidianCorners = new BlockCorners(
					props.getInt("BlockObsidianCorners"), 37, Material.rock)
					.setHardness(10F).setStepSound(Block.soundStoneFootstep)
					.setResistance(2000F)
					.setBlockName("BlockObsidianCorners");
			ItemObsidianCorners = new ItemCorners(
					BlockObsidianCorners.blockID - 256, "Obsidian")
					.setItemName("ItemObsidianCorners");
		} else {
			BlockObsidianCorners = Block.stone;
		}
		if (props.getInt("BlockDiamondCorners") != 0) {
			BlockDiamondCorners = new BlockCorners(
					props.getInt("BlockDiamondCorners"), 24, Material.iron)
					.setHardness(5F).setStepSound(Block.soundMetalFootstep)
					.setResistance(10F).setBlockName("BlockDiamondCorners");
			ItemDiamondCorners = new ItemCorners(
					BlockDiamondCorners.blockID - 256, "Diamond")
					.setItemName("ItemDiamondCorners");
		} else {
			BlockDiamondCorners = Block.stone;
		}
		if (props.getInt("BlockWhiteWoolCorners") != 0) {
			BlockWhiteWoolCorners = new BlockCorners(
					props.getInt("BlockWhiteWoolCorners"), 64,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockWhiteWoolCorners");
			ItemWhiteWoolCorners = new ItemCorners(
					BlockWhiteWoolCorners.blockID - 256, "WhiteWool")
					.setItemName("ItemWhiteWoolCorners");
		} else {
			BlockWhiteWoolCorners = Block.stone;
		}
		if (props.getInt("BlockBlackWoolCorners") != 0) {
			BlockBlackWoolCorners = new BlockCorners(
					props.getInt("BlockBlackWoolCorners"), 113,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockBlackWoolCorners");
			ItemBlackWoolCorners = new ItemCorners(
					BlockBlackWoolCorners.blockID - 256, "BlackWool")
					.setItemName("ItemBlackWoolCorners");
		} else {
			BlockBlackWoolCorners = Block.stone;
		}
		if (props.getInt("BlockRedWoolCorners") != 0) {
			BlockRedWoolCorners = new BlockCorners(
					props.getInt("BlockRedWoolCorners"), 129,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockRedWoolCorners");
			ItemRedWoolCorners = new ItemCorners(
					BlockRedWoolCorners.blockID - 256, "RedWool")
					.setItemName("ItemRedWoolCorners");
		} else {
			BlockRedWoolCorners = Block.stone;
		}
		if (props.getInt("BlockGreenWoolCorners") != 0) {
			BlockGreenWoolCorners = new BlockCorners(
					props.getInt("BlockGreenWoolCorners"), 145,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockGreenWoolCorners");
			ItemGreenWoolCorners = new ItemCorners(
					BlockGreenWoolCorners.blockID - 256, "GreenWool")
					.setItemName("ItemGreenWoolCorners");
		} else {
			BlockGreenWoolCorners = Block.stone;
		}
		if (props.getInt("BlockBrownWoolCorners") != 0) {
			BlockBrownWoolCorners = new BlockCorners(
					props.getInt("BlockBrownWoolCorners"), 161,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockBrownWoolCorners");
			ItemBrownWoolCorners = new ItemCorners(
					BlockBrownWoolCorners.blockID - 256, "BrownWool")
					.setItemName("ItemBrownWoolCorners");
		} else {
			BlockBrownWoolCorners = Block.stone;
		}
		if (props.getInt("BlockBlueWoolCorners") != 0) {
			BlockBlueWoolCorners = new BlockCorners(
					props.getInt("BlockBlueWoolCorners"), 177,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockBlueWoolCorners");
			ItemBlueWoolCorners = new ItemCorners(
					BlockBlueWoolCorners.blockID - 256, "BlueWool")
					.setItemName("ItemBlueWoolCorners");
		} else {
			BlockBlueWoolCorners = Block.stone;
		}
		if (props.getInt("BlockPurpleWoolCorners") != 0) {
			BlockPurpleWoolCorners = new BlockCorners(
					props.getInt("BlockPurpleWoolCorners"), 193,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockPurpleWoolCorners");
			ItemPurpleWoolCorners = new ItemCorners(
					BlockPurpleWoolCorners.blockID - 256, "PurpleWool")
					.setItemName("ItemPurpleWoolCorners");
		} else {
			BlockPurpleWoolCorners = Block.stone;
		}
		if (props.getInt("BlockCyanWoolCorners") != 0) {
			BlockCyanWoolCorners = new BlockCorners(
					props.getInt("BlockCyanWoolCorners"), 209,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockCyanWoolCorners");
			ItemCyanWoolCorners = new ItemCorners(
					BlockCyanWoolCorners.blockID - 256, "CyanWool")
					.setItemName("ItemCyanWoolCorners");
		} else {
			BlockCyanWoolCorners = Block.stone;
		}
		if (props.getInt("BlockSilverWoolCorners") != 0) {
			BlockSilverWoolCorners = new BlockCorners(
					props.getInt("BlockSilverWoolCorners"), 225,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockSilverWoolCorners");
			ItemSilverWoolCorners = new ItemCorners(
					BlockSilverWoolCorners.blockID - 256, "SilverWool")
					.setItemName("ItemSilverWoolCorners");
		} else {
			BlockSilverWoolCorners = Block.stone;
		}
		if (props.getInt("BlockGrayWoolCorners") != 0) {
			BlockGrayWoolCorners = new BlockCorners(
					props.getInt("BlockGrayWoolCorners"), 114,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockGrayWoolCorners");
			ItemGrayWoolCorners = new ItemCorners(
					BlockGrayWoolCorners.blockID - 256, "GrayWool")
					.setItemName("ItemGrayWoolCorners");
		} else {
			BlockGrayWoolCorners = Block.stone;
		}
		if (props.getInt("BlockPinkWoolCorners") != 0) {
			BlockPinkWoolCorners = new BlockCorners(
					props.getInt("BlockPinkWoolCorners"), 130,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockPinkWoolCorners");
			ItemPinkWoolCorners = new ItemCorners(
					BlockPinkWoolCorners.blockID - 256, "PinkWool")
					.setItemName("ItemPinkWoolCorners");
		} else {
			BlockPinkWoolCorners = Block.stone;
		}
		if (props.getInt("BlockLimeWoolCorners") != 0) {
			BlockLimeWoolCorners = new BlockCorners(
					props.getInt("BlockLimeWoolCorners"), 146,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockLimeWoolCorners");
			ItemLimeWoolCorners = new ItemCorners(
					BlockLimeWoolCorners.blockID - 256, "LimeWool")
					.setItemName("ItemLimeWoolCorners");
		} else {
			BlockLimeWoolCorners = Block.stone;
		}
		if (props.getInt("BlockYellowWoolCorners") != 0) {
			BlockYellowWoolCorners = new BlockCorners(
					props.getInt("BlockYellowWoolCorners"), 162,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockYellowWoolCorners");
			ItemYellowWoolCorners = new ItemCorners(
					BlockYellowWoolCorners.blockID - 256, "YellowWool")
					.setItemName("ItemYellowWoolCorners");
		} else {
			BlockYellowWoolCorners = Block.stone;
		}
		if (props.getInt("BlockLightBlueWoolCorners") != 0) {
			BlockLightBlueWoolCorners = new BlockCorners(
					props.getInt("BlockLightBlueWoolCorners"), 178,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockLightBlueWoolCorners");
			ItemLightBlueWoolCorners = new ItemCorners(
					BlockLightBlueWoolCorners.blockID - 256,
					"LightBlueWool")
					.setItemName("ItemLightBlueWoolCorners");
		} else {
			BlockLightBlueWoolCorners = Block.stone;
		}
		if (props.getInt("BlockMagentaWoolCorners") != 0) {
			BlockMagentaWoolCorners = new BlockCorners(
					props.getInt("BlockMagentaWoolCorners"), 194,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockMagentaWoolCorners");
			ItemMagentaWoolCorners = new ItemCorners(
					BlockMagentaWoolCorners.blockID - 256, "MagentaWool")
					.setItemName("ItemMagentaWoolCorners");
		} else {
			BlockMagentaWoolCorners = Block.stone;
		}
		if (props.getInt("BlockOrangeWoolCorners") != 0) {
			BlockOrangeWoolCorners = new BlockCorners(
					props.getInt("BlockOrangeWoolCorners"), 210,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockOrangeWoolCorners");
			ItemOrangeWoolCorners = new ItemCorners(
					BlockOrangeWoolCorners.blockID - 256, "OrangeWool")
					.setItemName("ItemOrangeWoolCorners");
		} else {
			BlockOrangeWoolCorners = Block.stone;
		}

		props.save();
	}
}