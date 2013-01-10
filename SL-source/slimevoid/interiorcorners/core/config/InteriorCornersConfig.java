package slimevoid.interiorcorners.core.config;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.SidedProxy;

import slimevoid.interiorcorners.blocks.BlockInteriorCorners;
import slimevoid.interiorcorners.items.ItemInteriorCorners;
import slimevoid.lib.ICommonProxy;
import slimevoid.slopes.core.KrushProps;

public class InteriorCornersConfig {
	@SidedProxy(
			clientSide="slimevoid.interiorcorners.client.proxy.IC_ClientProxy",
			serverSide="slimevoid.interiorcorners.proxy.IC_CommonProxy")
	public static ICommonProxy proxy;
	
	public static void prepareProps() {
		props.getInt("Slopes_Opacity", 0);
		props.getInt("BlockWoodIntCorners", 3962);
		props.getInt("BlockCobblestoneIntCorners", 3963);
		props.getInt("BlockGlassIntCorners", 3964);
		props.getInt("BlockSandstoneIntCorners", 3965);
		props.getInt("BlockDirtIntCorners", 3966);
		props.getInt("BlockStoneIntCorners", 3967);
		props.getInt("BlockSandIntCorners", 3968);
		props.getInt("BlockSnowIntCorners", 3969);
		props.getInt("BlockGrassIntCorners", 3970);
		props.getInt("BlockBricksIntCorners", 3971);
		props.getInt("BlockGravelIntCorners", 3972);
		props.getInt("BlockGoldIntCorners", 3973);
		props.getInt("BlockSteelIntCorners", 3974);
		props.getInt("BlockObsidianIntCorners", 3975);
		props.getInt("BlockDiamondIntCorners", 3976);
		props.getInt("BlockWhiteWoolIntCorners", 3977);
		props.getInt("BlockBlackWoolIntCorners", 3978);
		props.getInt("BlockRedWoolIntCorners", 3979);
		props.getInt("BlockGreenWoolIntCorners", 3980);
		props.getInt("BlockBrownWoolIntCorners", 3981);
		props.getInt("BlockBlueWoolIntCorners", 3982);
		props.getInt("BlockPurpleWoolIntCorners", 3983);
		props.getInt("BlockCyanWoolIntCorners", 3984);
		props.getInt("BlockSilverWoolIntCorners", 3985);
		props.getInt("BlockGrayWoolIntCorners", 3986);
		props.getInt("BlockPinkWoolIntCorners", 3987);
		props.getInt("BlockLimeWoolIntCorners", 3988);
		props.getInt("BlockYellowWoolIntCorners", 3989);
		props.getInt("BlockLightBlueWoolIntCorners", 3990);
		props.getInt("BlockMagentaWoolIntCorners", 3991);
		props.getInt("BlockOrangeWoolIntCorners", 3992);
	}

	public static void configuration() {
		props = new KrushProps(new File(proxy.getMinecraftDir()
				+ "/config/Slopes.props").getPath());
		prepareProps();
		initialize();
		IntCornersRenderID = RenderingRegistry.getNextAvailableRenderId();
		proxy.registerRenderInformation();

		ModLoader.addLocalization("WoodSlopesTruncCornerDown.name",
				"Wooden Oblic Slopes");
		ModLoader.addLocalization("WoodSlopesTruncCornerUp.name",
				"Wooden Oblic Upslope");
		ModLoader.addLocalization("WoodSlopesInvCornerDown.name",
				"Wooden Interior Corner");
		ModLoader.addLocalization("WoodSlopesInvCornerUp.name",
				"Wooden Interior Upcorner");

		ModLoader.addLocalization("CobblestoneSlopesTruncCornerDown.name",
				"Cobblestone Oblic Slopes");
		ModLoader.addLocalization("CobblestoneSlopesTruncCornerUp.name",
				"Cobblestone Oblic Upslope");
		ModLoader.addLocalization("CobblestoneSlopesInvCornerDown.name",
				"Cobblestone Interior Corner");
		ModLoader.addLocalization("CobblestoneSlopesInvCornerUp.name",
				"Cobblestone Interior Upcorner");

		ModLoader.addLocalization("GlassSlopesTruncCornerDown.name",
				"Glass Oblic Slopes");
		ModLoader.addLocalization("GlassSlopesTruncCornerUp.name",
				"Glass Oblic Upslope");
		ModLoader.addLocalization("GlassSlopesInvCornerDown.name",
				"Glass Interior Corner");
		ModLoader.addLocalization("GlassSlopesInvCornerUp.name",
				"Glass Interior Upcorner");

		ModLoader.addLocalization("SandstoneSlopesTruncCornerDown.name",
				"Sandstone Oblic Slopes");
		ModLoader.addLocalization("SandstoneSlopesTruncCornerUp.name",
				"Sandstone Oblic Upslope");
		ModLoader.addLocalization("SandstoneSlopesInvCornerDown.name",
				"Sandstone Interior Corner");
		ModLoader.addLocalization("SandstoneSlopesInvCornerUp.name",
				"Sandstone Interior Upcorner");

		ModLoader.addLocalization("DirtSlopesTruncCornerDown.name",
				"Dirt Oblic Slopes");
		ModLoader.addLocalization("DirtSlopesTruncCornerUp.name",
				"Dirt Oblic Upslope");
		ModLoader.addLocalization("DirtSlopesInvCornerDown.name",
				"Dirt Interior Corner");
		ModLoader.addLocalization("DirtSlopesInvCornerUp.name",
				"Dirt Interior Upcorner");

		ModLoader.addLocalization("StoneSlopesTruncCornerDown.name",
				"Stone Oblic Slopes");
		ModLoader.addLocalization("StoneSlopesTruncCornerUp.name",
				"Stone Oblic Upslope");
		ModLoader.addLocalization("StoneSlopesInvCornerDown.name",
				"Stone Interior Corner");
		ModLoader.addLocalization("StoneSlopesInvCornerUp.name",
				"Stone Interior Upcorner");

		ModLoader.addLocalization("SandSlopesTruncCornerDown.name",
				"Sand Oblic Slopes");
		ModLoader.addLocalization("SandSlopesTruncCornerUp.name",
				"Sand Oblic Upslope");
		ModLoader.addLocalization("SandSlopesInvCornerDown.name",
				"Sand Interior Corner");
		ModLoader.addLocalization("SandSlopesInvCornerUp.name",
				"Sand Interior Upcorner");

		ModLoader.addLocalization("SnowSlopesTruncCornerDown.name",
				"Snow Oblic Slopes");
		ModLoader.addLocalization("SnowSlopesTruncCornerUp.name",
				"Snow Oblic Upslope");
		ModLoader.addLocalization("SnowSlopesInvCornerDown.name",
				"Snow Interior Corner");
		ModLoader.addLocalization("SnowSlopesInvCornerUp.name",
				"Snow Interior Upcorner");

		ModLoader.addLocalization("GrassSlopesTruncCornerDown.name",
				"Grass Oblic Slopes");
		ModLoader.addLocalization("GrassSlopesTruncCornerUp.name",
				"Grass Oblic Upslope");
		ModLoader.addLocalization("GrassSlopesInvCornerDown.name",
				"Grass Interior Corner");
		ModLoader.addLocalization("GrassSlopesInvCornerUp.name",
				"Grass Interior Upcorner");

		ModLoader.addLocalization("BricksSlopesTruncCornerDown.name",
				"Bricks Oblic Slopes");
		ModLoader.addLocalization("BricksSlopesTruncCornerUp.name",
				"Bricks Oblic Upslope");
		ModLoader.addLocalization("BricksSlopesInvCornerDown.name",
				"Bricks Interior Corner");
		ModLoader.addLocalization("BricksSlopesInvCornerUp.name",
				"Bricks Interior Upcorner");

		ModLoader.addLocalization("GravelSlopesTruncCornerDown.name",
				"Gravel Oblic Slopes");
		ModLoader.addLocalization("GravelSlopesTruncCornerUp.name",
				"Gravel Oblic Upslope");
		ModLoader.addLocalization("GravelSlopesInvCornerDown.name",
				"Gravel Interior Corner");
		ModLoader.addLocalization("GravelSlopesInvCornerUp.name",
				"Gravel Interior Upcorner");

		ModLoader.addLocalization("GoldSlopesTruncCornerDown.name",
				"Golden Oblic Slopes");
		ModLoader.addLocalization("GoldSlopesTruncCornerUp.name",
				"Golden Oblic Upslope");
		ModLoader.addLocalization("GoldSlopesInvCornerDown.name",
				"Golden Interior Corner");
		ModLoader.addLocalization("GoldSlopesInvCornerUp.name",
				"Golden Interior Upcorner");

		ModLoader.addLocalization("SteelSlopesTruncCornerDown.name",
				"Steel Oblic Slopes");
		ModLoader.addLocalization("SteelSlopesTruncCornerUp.name",
				"Steel Oblic Upslope");
		ModLoader.addLocalization("SteelSlopesInvCornerDown.name",
				"Steel Interior Corner");
		ModLoader.addLocalization("SteelSlopesInvCornerUp.name",
				"Steel Interior Upcorner");

		ModLoader.addLocalization("ObsidianSlopesTruncCornerDown.name",
				"Obsidian Oblic Slopes");
		ModLoader.addLocalization("ObsidianSlopesTruncCornerUp.name",
				"Obsidian Oblic Upslope");
		ModLoader.addLocalization("ObsidianSlopesInvCornerDown.name",
				"Obsidian Interior Corner");
		ModLoader.addLocalization("ObsidianSlopesInvCornerUp.name",
				"Obsidian Interior Upcorner");

		ModLoader.addLocalization("DiamondSlopesTruncCornerDown.name",
				"Diamond Oblic Slopes");
		ModLoader.addLocalization("DiamondSlopesTruncCornerUp.name",
				"Diamond Oblic Upslope");
		ModLoader.addLocalization("DiamondSlopesInvCornerDown.name",
				"Diamond Interior Corner");
		ModLoader.addLocalization("DiamondSlopesInvCornerUp.name",
				"Diamond Interior Upcorner");

		ModLoader.addLocalization("WhiteWoolSlopesTruncCornerDown.name",
				"White Oblic Slopes");
		ModLoader.addLocalization("WhiteWoolSlopesTruncCornerUp.name",
				"White Oblic Upslope");
		ModLoader.addLocalization("WhiteWoolSlopesInvCornerDown.name",
				"White Interior Corner");
		ModLoader.addLocalization("WhiteWoolSlopesInvCornerUp.name",
				"White Interior Upcorner");

		ModLoader.addLocalization("BlackWoolSlopesTruncCornerDown.name",
				"Black Oblic Slopes");
		ModLoader.addLocalization("BlackWoolSlopesTruncCornerUp.name",
				"Black Oblic Upslope");
		ModLoader.addLocalization("BlackWoolSlopesInvCornerDown.name",
				"Black Interior Corner");
		ModLoader.addLocalization("BlackWoolSlopesInvCornerUp.name",
				"Black Interior Upcorner");

		ModLoader.addLocalization("RedWoolSlopesTruncCornerDown.name",
				"Red Oblic Slopes");
		ModLoader.addLocalization("RedWoolSlopesTruncCornerUp.name",
				"Red Oblic Upslope");
		ModLoader.addLocalization("RedWoolSlopesInvCornerDown.name",
				"Red Interior Corner");
		ModLoader.addLocalization("RedWoolSlopesInvCornerUp.name",
				"Red Interior Upcorner");

		ModLoader.addLocalization("GreenWoolSlopesTruncCornerDown.name",
				"Green Oblic Slopes");
		ModLoader.addLocalization("GreenWoolSlopesTruncCornerUp.name",
				"Green Oblic Upslope");
		ModLoader.addLocalization("GreenWoolSlopesInvCornerDown.name",
				"Green Interior Corner");
		ModLoader.addLocalization("GreenWoolSlopesInvCornerUp.name",
				"Green Interior Upcorner");

		ModLoader.addLocalization("BrownWoolSlopesTruncCornerDown.name",
				"Brown Oblic Slopes");
		ModLoader.addLocalization("BrownWoolSlopesTruncCornerUp.name",
				"Brown Oblic Upslope");
		ModLoader.addLocalization("BrownWoolSlopesInvCornerDown.name",
				"Brown Interior Corner");
		ModLoader.addLocalization("BrownWoolSlopesInvCornerUp.name",
				"Brown Interior Upcorner");

		ModLoader.addLocalization("BlueWoolSlopesTruncCornerDown.name",
				"Blue Oblic Slopes");
		ModLoader.addLocalization("BlueWoolSlopesTruncCornerUp.name",
				"Blue Oblic Upslope");
		ModLoader.addLocalization("BlueWoolSlopesInvCornerDown.name",
				"Blue Interior Corner");
		ModLoader.addLocalization("BlueWoolSlopesInvCornerUp.name",
				"Blue Interior Upcorner");

		ModLoader.addLocalization("PurpleWoolSlopesTruncCornerDown.name",
				"Purple Oblic Slopes");
		ModLoader.addLocalization("PurpleWoolSlopesTruncCornerUp.name",
				"Purple Oblic Upslope");
		ModLoader.addLocalization("PurpleWoolSlopesInvCornerDown.name",
				"Purple Interior Corner");
		ModLoader.addLocalization("PurpleWoolSlopesInvCornerUp.name",
				"Purple Interior Upcorner");

		ModLoader.addLocalization("CyanWoolSlopesTruncCornerDown.name",
				"Cyan Oblic Slopes");
		ModLoader.addLocalization("CyanWoolSlopesTruncCornerUp.name",
				"Cyan Oblic Upslope");
		ModLoader.addLocalization("CyanWoolSlopesInvCornerDown.name",
				"Cyan Interior Corner");
		ModLoader.addLocalization("CyanWoolSlopesInvCornerUp.name",
				"Cyan Interior Upcorner");

		ModLoader.addLocalization("SilverWoolSlopesTruncCornerDown.name",
				"Silver Oblic Slopes");
		ModLoader.addLocalization("SilverWoolSlopesTruncCornerUp.name",
				"Silver Oblic Upslope");
		ModLoader.addLocalization("SilverWoolSlopesInvCornerDown.name",
				"Silver Interior Corner");
		ModLoader.addLocalization("SilverWoolSlopesInvCornerUp.name",
				"Silver Interior Upcorner");

		ModLoader.addLocalization("GrayWoolSlopesTruncCornerDown.name",
				"Gray Oblic Slopes");
		ModLoader.addLocalization("GrayWoolSlopesTruncCornerUp.name",
				"Gray Oblic Upslope");
		ModLoader.addLocalization("GrayWoolSlopesInvCornerDown.name",
				"Gray Interior Corner");
		ModLoader.addLocalization("GrayWoolSlopesInvCornerUp.name",
				"Gray Interior Upcorner");

		ModLoader.addLocalization("PinkWoolSlopesTruncCornerDown.name",
				"Pink Oblic Slopes");
		ModLoader.addLocalization("PinkWoolSlopesTruncCornerUp.name",
				"Pink Oblic Upslope");
		ModLoader.addLocalization("PinkWoolSlopesInvCornerDown.name",
				"Pink Interior Corner");
		ModLoader.addLocalization("PinkWoolSlopesInvCornerUp.name",
				"Pink Interior Upcorner");

		ModLoader.addLocalization("LimeWoolSlopesTruncCornerDown.name",
				"Lime Oblic Slopes");
		ModLoader.addLocalization("LimeWoolSlopesTruncCornerUp.name",
				"Lime Oblic Upslope");
		ModLoader.addLocalization("LimeWoolSlopesInvCornerDown.name",
				"Lime Interior Corner");
		ModLoader.addLocalization("LimeWoolSlopesInvCornerUp.name",
				"Lime Interior Upcorner");

		ModLoader.addLocalization("YellowWoolSlopesTruncCornerDown.name",
				"Yellow Oblic Slopes");
		ModLoader.addLocalization("YellowWoolSlopesTruncCornerUp.name",
				"Yellow Oblic Upslope");
		ModLoader.addLocalization("YellowWoolSlopesInvCornerDown.name",
				"Yellow Interior Corner");
		ModLoader.addLocalization("YellowWoolSlopesInvCornerUp.name",
				"Yellow Interior Upcorner");

		ModLoader.addLocalization(
				"LightBlueWoolSlopesTruncCornerDown.name",
				"LightBlue Oblic Slopes");
		ModLoader.addLocalization("LightBlueWoolSlopesTruncCornerUp.name",
				"LightBlue Oblic Upslope");
		ModLoader.addLocalization("LightBlueWoolSlopesInvCornerDown.name",
				"LightBlue Interior Corner");
		ModLoader.addLocalization("LightBlueWoolSlopesInvCornerUp.name",
				"LightBlue Interior Upcorner");

		ModLoader.addLocalization("MagentaWoolSlopesTruncCornerDown.name",
				"Magenta Oblic Slopes");
		ModLoader.addLocalization("MagentaWoolSlopesTruncCornerUp.name",
				"Magenta Oblic Upslope");
		ModLoader.addLocalization("MagentaWoolSlopesInvCornerDown.name",
				"Magenta Interior Corner");
		ModLoader.addLocalization("MagentaWoolSlopesInvCornerUp.name",
				"Magenta Interior Upcorner");

		ModLoader.addLocalization("OrangeWoolSlopesTruncCornerDown.name",
				"Orange Oblic Slopes");
		ModLoader.addLocalization("OrangeWoolSlopesTruncCornerUp.name",
				"Orange Oblic Upslope");
		ModLoader.addLocalization("OrangeWoolSlopesInvCornerDown.name",
				"Orange Interior Corner");
		ModLoader.addLocalization("OrangeWoolSlopesInvCornerUp.name",
				"Orange Interior Upcorner");

		if (props.getInt("BlockWoodIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockWoodIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.planks });
			ModLoader.addRecipe(new ItemStack(BlockWoodIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.planks });
			ModLoader.addRecipe(new ItemStack(BlockWoodIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.planks });
			ModLoader.addRecipe(new ItemStack(BlockWoodIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.planks });
			ModLoader.addRecipe(new ItemStack(Block.planks, 1), new Object[] {
					"#", Character.valueOf('#'), BlockWoodIntCorners });
		}

		if (props.getInt("BlockCobblestoneIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockCobblestoneIntCorners,
					4, BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.cobblestone });
			ModLoader.addRecipe(new ItemStack(BlockCobblestoneIntCorners,
					4, BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.cobblestone });
			ModLoader.addRecipe(new ItemStack(BlockCobblestoneIntCorners,
					4, BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.cobblestone });
			ModLoader.addRecipe(new ItemStack(BlockCobblestoneIntCorners,
					4, BlockInteriorCorners.func_21035_d(12)),
					new Object[] { "# #", "## ", Character.valueOf('#'),
							Block.cobblestone });
			ModLoader.addRecipe(new ItemStack(Block.cobblestone, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockCobblestoneIntCorners });
		}

		if (props.getInt("BlockGlassIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockGlassIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.glass });
			ModLoader.addRecipe(new ItemStack(BlockGlassIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.glass });
			ModLoader.addRecipe(new ItemStack(BlockGlassIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.glass });
			ModLoader.addRecipe(new ItemStack(BlockGlassIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.glass });
			ModLoader.addRecipe(new ItemStack(Block.glass, 1), new Object[] {
					"#", Character.valueOf('#'), BlockGlassIntCorners });
		}

		if (props.getInt("BlockSandstoneIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockSandstoneIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.sandStone });
			ModLoader.addRecipe(new ItemStack(BlockSandstoneIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.sandStone });
			ModLoader.addRecipe(new ItemStack(BlockSandstoneIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.sandStone });
			ModLoader.addRecipe(new ItemStack(BlockSandstoneIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.sandStone });
			ModLoader.addRecipe(new ItemStack(Block.sandStone, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockSandstoneIntCorners });
		}

		if (props.getInt("BlockDirtIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockDirtIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.dirt });
			ModLoader.addRecipe(new ItemStack(BlockDirtIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.dirt });
			ModLoader.addRecipe(new ItemStack(BlockDirtIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.dirt });
			ModLoader.addRecipe(new ItemStack(BlockDirtIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.dirt });
			ModLoader.addRecipe(new ItemStack(Block.dirt, 1), new Object[] {
					"#", Character.valueOf('#'), BlockDirtIntCorners });
		}

		if (props.getInt("BlockStoneIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockStoneIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.stone });
			ModLoader.addRecipe(new ItemStack(BlockStoneIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.stone });
			ModLoader.addRecipe(new ItemStack(BlockStoneIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.stone });
			ModLoader.addRecipe(new ItemStack(BlockStoneIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.stone });
			ModLoader.addRecipe(new ItemStack(Block.stone, 1), new Object[] {
					"#", Character.valueOf('#'), BlockStoneIntCorners });
		}

		if (props.getInt("BlockSandIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockSandIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.sand });
			ModLoader.addRecipe(new ItemStack(BlockSandIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.sand });
			ModLoader.addRecipe(new ItemStack(BlockSandIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.sand });
			ModLoader.addRecipe(new ItemStack(BlockSandIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.sand });
			ModLoader.addRecipe(new ItemStack(Block.sand, 1), new Object[] {
					"#", Character.valueOf('#'), BlockSandIntCorners });
		}

		if (props.getInt("BlockSnowIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockSnowIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.blockSnow });
			ModLoader.addRecipe(new ItemStack(BlockSnowIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.blockSnow });
			ModLoader.addRecipe(new ItemStack(BlockSnowIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.blockSnow });
			ModLoader.addRecipe(new ItemStack(BlockSnowIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.blockSnow });
			ModLoader.addRecipe(new ItemStack(Block.blockSnow, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockSnowIntCorners });
		}

		if (props.getInt("BlockGrassIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockGrassIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.grass });
			ModLoader.addRecipe(new ItemStack(BlockGrassIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.grass });
			ModLoader.addRecipe(new ItemStack(BlockGrassIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.grass });
			ModLoader.addRecipe(new ItemStack(BlockGrassIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.grass });
			ModLoader.addRecipe(new ItemStack(Block.grass, 1), new Object[] {
					"#", Character.valueOf('#'), BlockGrassIntCorners });
		}

		if (props.getInt("BlockBricksIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockBricksIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.brick });
			ModLoader.addRecipe(new ItemStack(BlockBricksIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.brick });
			ModLoader.addRecipe(new ItemStack(BlockBricksIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.brick });
			ModLoader.addRecipe(new ItemStack(BlockBricksIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.brick });
			ModLoader.addRecipe(new ItemStack(Block.brick, 1), new Object[] {
					"#", Character.valueOf('#'), BlockBricksIntCorners });
		}

		if (props.getInt("BlockGravelIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockGravelIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.gravel });
			ModLoader.addRecipe(new ItemStack(BlockGravelIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.gravel });
			ModLoader.addRecipe(new ItemStack(BlockGravelIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.gravel });
			ModLoader.addRecipe(new ItemStack(BlockGravelIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.gravel });
			ModLoader.addRecipe(new ItemStack(Block.gravel, 1), new Object[] {
					"#", Character.valueOf('#'), BlockGravelIntCorners });
		}

		if (props.getInt("BlockGoldIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockGoldIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.blockGold });
			ModLoader.addRecipe(new ItemStack(BlockGoldIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.blockGold });
			ModLoader.addRecipe(new ItemStack(BlockGoldIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.blockGold });
			ModLoader.addRecipe(new ItemStack(BlockGoldIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.blockGold });
			ModLoader.addRecipe(new ItemStack(Block.blockGold, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockGoldIntCorners });
		}

		if (props.getInt("BlockSteelIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockSteelIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.blockSteel });
			ModLoader.addRecipe(new ItemStack(BlockSteelIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.blockSteel });
			ModLoader.addRecipe(new ItemStack(BlockSteelIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.blockSteel });
			ModLoader.addRecipe(new ItemStack(BlockSteelIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.blockSteel });
			ModLoader.addRecipe(new ItemStack(Block.blockSteel, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockSteelIntCorners });
		}

		if (props.getInt("BlockObsidianIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockObsidianIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.obsidian });
			ModLoader.addRecipe(new ItemStack(BlockObsidianIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.obsidian });
			ModLoader.addRecipe(new ItemStack(BlockObsidianIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.obsidian });
			ModLoader.addRecipe(new ItemStack(BlockObsidianIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.obsidian });
			ModLoader.addRecipe(new ItemStack(Block.obsidian, 1), new Object[] {
					"#", Character.valueOf('#'), BlockObsidianIntCorners });
		}

		if (props.getInt("BlockDiamondIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockDiamondIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.blockDiamond });
			ModLoader.addRecipe(new ItemStack(BlockDiamondIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.blockDiamond });
			ModLoader.addRecipe(new ItemStack(BlockDiamondIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.blockDiamond });
			ModLoader.addRecipe(new ItemStack(BlockDiamondIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.blockDiamond });
			ModLoader.addRecipe(new ItemStack(Block.blockDiamond, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockDiamondIntCorners });
		}

		if (props.getInt("BlockWhiteWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(BlockWhiteWoolIntCorners, 4,
					BlockInteriorCorners.func_21035_d(0)), new Object[] {
					"  #", "###", Character.valueOf('#'), Block.cloth });
			ModLoader.addRecipe(new ItemStack(BlockWhiteWoolIntCorners, 4,
					BlockInteriorCorners.func_21035_d(4)), new Object[] {
					"###", "  #", Character.valueOf('#'), Block.cloth });
			ModLoader.addRecipe(new ItemStack(BlockWhiteWoolIntCorners, 4,
					BlockInteriorCorners.func_21035_d(8)), new Object[] {
					"## ", "# #", Character.valueOf('#'), Block.cloth });
			ModLoader.addRecipe(new ItemStack(BlockWhiteWoolIntCorners, 4,
					BlockInteriorCorners.func_21035_d(12)), new Object[] {
					"# #", "## ", Character.valueOf('#'), Block.cloth });
			ModLoader
					.addRecipe(new ItemStack(Block.cloth, 1, 0), new Object[] {
							"#", Character.valueOf('#'),
							BlockWhiteWoolIntCorners });
		}

		if (props.getInt("BlockBlackWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 15),
					new Object[] { "#", Character.valueOf('#'),
							BlockBlackWoolIntCorners });
		}

		if (props.getInt("BlockRedWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 14),
					new Object[] { "#", Character.valueOf('#'),
							BlockRedWoolIntCorners });
		}

		if (props.getInt("BlockGreenWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 13),
					new Object[] { "#", Character.valueOf('#'),
							BlockGreenWoolIntCorners });
		}

		if (props.getInt("BlockBrownWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 12),
					new Object[] { "#", Character.valueOf('#'),
							BlockBrownWoolIntCorners });
		}

		if (props.getInt("BlockBlueWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 11),
					new Object[] { "#", Character.valueOf('#'),
							BlockBlueWoolIntCorners });
		}

		if (props.getInt("BlockPurpleWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 10),
					new Object[] { "#", Character.valueOf('#'),
							BlockPurpleWoolIntCorners });
		}

		if (props.getInt("BlockCyanWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 9), new Object[] {
					"#", Character.valueOf('#'), BlockCyanWoolIntCorners });
		}

		if (props.getInt("BlockSilverWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 8),
					new Object[] { "#", Character.valueOf('#'),
							BlockSilverWoolIntCorners });
		}

		if (props.getInt("BlockGrayWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 7), new Object[] {
					"#", Character.valueOf('#'), BlockGrayWoolIntCorners });
		}

		if (props.getInt("BlockPinkWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 6), new Object[] {
					"#", Character.valueOf('#'), BlockPinkWoolIntCorners });
		}

		if (props.getInt("BlockLimeWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 5), new Object[] {
					"#", Character.valueOf('#'), BlockLimeWoolIntCorners });
		}

		if (props.getInt("BlockYellowWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 4),
					new Object[] { "#", Character.valueOf('#'),
							BlockYellowWoolIntCorners });
		}

		if (props.getInt("BlockLightBlueWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 3), new Object[] {
					"#", Character.valueOf('#'),
					BlockLightBlueWoolIntCorners });
		}

		if (props.getInt("BlockMagentaWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 2),
					new Object[] { "#", Character.valueOf('#'),
							BlockMagentaWoolIntCorners });
		}

		if (props.getInt("BlockOrangeWoolIntCorners") != 0) {
			ModLoader.addRecipe(new ItemStack(Block.cloth, 1, 1),
					new Object[] { "#", Character.valueOf('#'),
							BlockOrangeWoolIntCorners });
		}
	}

	public static KrushProps props;

	public static int IntCornersRenderID;
	public static int SlopesOpacity;

	public static Block BlockWoodIntCorners;
	public static Block BlockCobblestoneIntCorners;
	public static Block BlockGlassIntCorners;
	public static Block BlockSandstoneIntCorners;
	public static Block BlockDirtIntCorners;
	public static Block BlockStoneIntCorners;
	public static Block BlockSandIntCorners;
	public static Block BlockSnowIntCorners;
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

	public static Item ItemWoodIntCorners;
	public static Item ItemCobblestoneIntCorners;
	public static Item ItemGlassIntCorners;
	public static Item ItemSandstoneIntCorners;
	public static Item ItemDirtIntCorners;
	public static Item ItemStoneIntCorners;
	public static Item ItemSandIntCorners;
	public static Item ItemSnowIntCorners;
	public static Item ItemGrassIntCorners;
	public static Item ItemBricksIntCorners;
	public static Item ItemGravelIntCorners;
	public static Item ItemGoldIntCorners;
	public static Item ItemSteelIntCorners;
	public static Item ItemObsidianIntCorners;
	public static Item ItemDiamondIntCorners;
	public static Item ItemWhiteWoolIntCorners;
	public static Item ItemBlackWoolIntCorners;
	public static Item ItemRedWoolIntCorners;
	public static Item ItemGreenWoolIntCorners;
	public static Item ItemBrownWoolIntCorners;
	public static Item ItemBlueWoolIntCorners;
	public static Item ItemPurpleWoolIntCorners;
	public static Item ItemCyanWoolIntCorners;
	public static Item ItemSilverWoolIntCorners;
	public static Item ItemGrayWoolIntCorners;
	public static Item ItemPinkWoolIntCorners;
	public static Item ItemLimeWoolIntCorners;
	public static Item ItemYellowWoolIntCorners;
	public static Item ItemLightBlueWoolIntCorners;
	public static Item ItemMagentaWoolIntCorners;
	public static Item ItemOrangeWoolIntCorners;

	public static void initialize() {
		SlopesOpacity = props.getInt("Slopes_Opacity");

		if (props.getInt("BlockWoodIntCorners") != 0) {
			BlockWoodIntCorners = new BlockInteriorCorners(
					props.getInt("BlockWoodIntCorners"), 4, Material.wood)
					.setHardness(2.0F).setStepSound(Block.soundWoodFootstep)
					.setResistance(5F).setBlockName("BlockWoodIntCorners");
			ItemWoodIntCorners = new ItemInteriorCorners(
					BlockWoodIntCorners.blockID - 256, "Wood")
					.setItemName("ItemWoodIntCorners");
		} else {
			BlockWoodIntCorners = Block.stone;
		}
		if (props.getInt("BlockCobblestoneIntCorners") != 0) {
			BlockCobblestoneIntCorners = new BlockInteriorCorners(
					props.getInt("BlockCobblestoneIntCorners"), 16,
					Material.rock).setHardness(2.0F)
					.setStepSound(Block.soundStoneFootstep).setResistance(10F)
					.setBlockName("BlockCobblestoneIntCorners");
			ItemCobblestoneIntCorners = new ItemInteriorCorners(
					BlockCobblestoneIntCorners.blockID - 256, "Cobblestone")
					.setItemName("ItemCobblestoneIntCorners");
		} else {
			BlockCobblestoneIntCorners = Block.stone;
		}
		if (props.getInt("BlockGlassIntCorners") != 0) {
			BlockGlassIntCorners = new BlockInteriorCorners(
					props.getInt("BlockGlassIntCorners"), 49,
					Material.glass).setHardness(0.3F)
					.setStepSound(Block.soundGlassFootstep)
					.setBlockName("BlockGlassIntCorners");
			ItemGlassIntCorners = new ItemInteriorCorners(
					BlockGlassIntCorners.blockID - 256, "Glass")
					.setItemName("ItemGlassIntCorners");
		} else {
			BlockGlassIntCorners = Block.stone;
		}
		if (props.getInt("BlockSandstoneIntCorners") != 0) {
			BlockSandstoneIntCorners = new BlockInteriorCorners(
					props.getInt("BlockSandstoneIntCorners"), 192,
					Material.rock).setHardness(0.8F)
					.setStepSound(Block.soundStoneFootstep)
					.setBlockName("BlockSandstoneIntCorners");
			ItemSandstoneIntCorners = new ItemInteriorCorners(
					BlockSandstoneIntCorners.blockID - 256, "Sandstone")
					.setItemName("ItemSandstoneIntCorners");
		} else {
			BlockSandstoneIntCorners = Block.stone;
		}
		if (props.getInt("BlockDirtIntCorners") != 0) {
			BlockDirtIntCorners = new BlockInteriorCorners(
					props.getInt("BlockDirtIntCorners"), 2, Material.ground)
					.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
					.setBlockName("BlockDirtIntCorners");
			ItemDirtIntCorners = new ItemInteriorCorners(
					BlockDirtIntCorners.blockID - 256, "Dirt")
					.setItemName("ItemDirtIntCorners");
		} else {
			BlockDirtIntCorners = Block.stone;
		}
		if (props.getInt("BlockStoneIntCorners") != 0) {
			BlockStoneIntCorners = new BlockInteriorCorners(
					props.getInt("BlockStoneIntCorners"), 1, Material.rock)
					.setHardness(1.5F).setStepSound(Block.soundStoneFootstep)
					.setResistance(10F)
					.setBlockName("BlockStoneIntCorners");
			ItemStoneIntCorners = new ItemInteriorCorners(
					BlockStoneIntCorners.blockID - 256, "Stone")
					.setItemName("ItemStoneIntCorners");
		} else {
			BlockStoneIntCorners = Block.stone;
		}
		if (props.getInt("BlockSandIntCorners") != 0) {
			BlockSandIntCorners = new BlockInteriorCorners(
					props.getInt("BlockSandIntCorners"), 18, Material.sand)
					.setHardness(0.5F).setStepSound(Block.soundSandFootstep)
					.setBlockName("BlockSandIntCorners");
			ItemSandIntCorners = new ItemInteriorCorners(
					BlockSandIntCorners.blockID - 256, "Sand")
					.setItemName("ItemSandIntCorners");
		} else {
			BlockSandIntCorners = Block.stone;
		}
		if (props.getInt("BlockSnowIntCorners") != 0) {
			BlockSnowIntCorners = new BlockInteriorCorners(
					props.getInt("BlockSnowIntCorners"), 66, Material.snow)
					.setHardness(0.1F).setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockSnowIntCorners");
			ItemSnowIntCorners = new ItemInteriorCorners(
					BlockSnowIntCorners.blockID - 256, "Snow")
					.setItemName("ItemSnowIntCorners");
		} else {
			BlockSnowIntCorners = Block.stone;
		}
		if (props.getInt("BlockGrassIntCorners") != 0) {
			BlockGrassIntCorners = new BlockInteriorCorners(
					props.getInt("BlockGrassIntCorners"), 3,
					Material.ground).setHardness(0.6F)
					.setStepSound(Block.soundGrassFootstep)
					.setBlockName("BlockGrassIntCorners");
			ItemGrassIntCorners = new ItemInteriorCorners(
					BlockGrassIntCorners.blockID - 256, "Grass")
					.setItemName("ItemGrassIntCorners");
		} else {
			BlockGrassIntCorners = Block.stone;
		}
		if (props.getInt("BlockBricksIntCorners") != 0) {
			BlockBricksIntCorners = new BlockInteriorCorners(
					props.getInt("BlockBricksIntCorners"), 7, Material.rock)
					.setHardness(2.0F).setStepSound(Block.soundStoneFootstep)
					.setResistance(10F)
					.setBlockName("BlockBricksIntCorners");
			ItemBricksIntCorners = new ItemInteriorCorners(
					BlockBricksIntCorners.blockID - 256, "Bricks")
					.setItemName("ItemBricksIntCorners");
		} else {
			BlockBricksIntCorners = Block.stone;
		}
		if (props.getInt("BlockGravelIntCorners") != 0) {
			BlockGravelIntCorners = new BlockInteriorCorners(
					props.getInt("BlockGravelIntCorners"), 19,
					Material.sand).setHardness(0.6F)
					.setStepSound(Block.soundGravelFootstep)
					.setBlockName("BlockGravelIntCorners");
			ItemGravelIntCorners = new ItemInteriorCorners(
					BlockGravelIntCorners.blockID - 256, "Gravel")
					.setItemName("ItemGravelIntCorners");
		} else {
			BlockGravelIntCorners = Block.stone;
		}
		if (props.getInt("BlockGoldIntCorners") != 0) {
			BlockGoldIntCorners = new BlockInteriorCorners(
					props.getInt("BlockGoldIntCorners"), 23, Material.iron)
					.setHardness(3F).setStepSound(Block.soundMetalFootstep)
					.setResistance(10F).setBlockName("BlockGoldIntCorners");
			ItemGoldIntCorners = new ItemInteriorCorners(
					BlockGoldIntCorners.blockID - 256, "Gold")
					.setItemName("ItemGoldIntCorners");
		} else {
			BlockGoldIntCorners = Block.stone;
		}
		if (props.getInt("BlockSteelIntCorners") != 0) {
			BlockSteelIntCorners = new BlockInteriorCorners(
					props.getInt("BlockSteelIntCorners"), 22, Material.iron)
					.setHardness(5F).setStepSound(Block.soundMetalFootstep)
					.setResistance(10F)
					.setBlockName("BlockSteelIntCorners");
			ItemSteelIntCorners = new ItemInteriorCorners(
					BlockSteelIntCorners.blockID - 256, "Steel")
					.setItemName("ItemSteelIntCorners");
		} else {
			BlockSteelIntCorners = Block.stone;
		}
		if (props.getInt("BlockObsidianIntCorners") != 0) {
			BlockObsidianIntCorners = new BlockInteriorCorners(
					props.getInt("BlockObsidianIntCorners"), 37,
					Material.rock).setHardness(10F)
					.setStepSound(Block.soundStoneFootstep)
					.setResistance(2000F)
					.setBlockName("BlockObsidianIntCorners");
			ItemObsidianIntCorners = new ItemInteriorCorners(
					BlockObsidianIntCorners.blockID - 256, "Obsidian")
					.setItemName("ItemObsidianIntCorners");
		} else {
			BlockObsidianIntCorners = Block.stone;
		}
		if (props.getInt("BlockDiamondIntCorners") != 0) {
			BlockDiamondIntCorners = new BlockInteriorCorners(
					props.getInt("BlockDiamondIntCorners"), 24,
					Material.iron).setHardness(5F)
					.setStepSound(Block.soundMetalFootstep).setResistance(10F)
					.setBlockName("BlockDiamondIntCorners");
			ItemDiamondIntCorners = new ItemInteriorCorners(
					BlockDiamondIntCorners.blockID - 256, "Diamond")
					.setItemName("ItemDiamondIntCorners");
		} else {
			BlockDiamondIntCorners = Block.stone;
		}
		if (props.getInt("BlockWhiteWoolIntCorners") != 0) {
			BlockWhiteWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockWhiteWoolIntCorners", 212), 64,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockWhiteWoolIntCorners");
			ItemWhiteWoolIntCorners = new ItemInteriorCorners(
					BlockWhiteWoolIntCorners.blockID - 256, "WhiteWool")
					.setItemName("ItemWhiteWoolIntCorners");
		} else {
			BlockWhiteWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockBlackWoolIntCorners") != 0) {
			BlockBlackWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockBlackWoolIntCorners", 213), 113,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockBlackWoolIntCorners");
			ItemBlackWoolIntCorners = new ItemInteriorCorners(
					BlockBlackWoolIntCorners.blockID - 256, "BlackWool")
					.setItemName("ItemBlackWoolIntCorners");
		} else {
			BlockBlackWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockRedWoolIntCorners") != 0) {
			BlockRedWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockRedWoolIntCorners", 214), 129,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockRedWoolIntCorners");
			ItemRedWoolIntCorners = new ItemInteriorCorners(
					BlockRedWoolIntCorners.blockID - 256, "RedWool")
					.setItemName("ItemRedWoolIntCorners");
		} else {
			BlockRedWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockGreenWoolIntCorners") != 0) {
			BlockGreenWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockGreenWoolIntCorners", 215), 145,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockGreenWoolIntCorners");
			ItemGreenWoolIntCorners = new ItemInteriorCorners(
					BlockGreenWoolIntCorners.blockID - 256, "GreenWool")
					.setItemName("ItemGreenWoolIntCorners");
		} else {
			BlockGreenWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockBrownWoolIntCorners") != 0) {
			BlockBrownWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockBrownWoolIntCorners", 216), 161,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockBrownWoolIntCorners");
			ItemBrownWoolIntCorners = new ItemInteriorCorners(
					BlockBrownWoolIntCorners.blockID - 256, "BrownWool")
					.setItemName("ItemBrownWoolIntCorners");
		} else {
			BlockBrownWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockBlueWoolIntCorners") != 0) {
			BlockBlueWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockBlueWoolIntCorners", 217), 177,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockBlueWoolIntCorners");
			ItemBlueWoolIntCorners = new ItemInteriorCorners(
					BlockBlueWoolIntCorners.blockID - 256, "BlueWool")
					.setItemName("ItemBlueWoolIntCorners");
		} else {
			BlockBlueWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockPurpleWoolIntCorners") != 0) {
			BlockPurpleWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockPurpleWoolIntCorners", 218), 193,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockPurpleWoolIntCorners");
			ItemPurpleWoolIntCorners = new ItemInteriorCorners(
					BlockPurpleWoolIntCorners.blockID - 256, "PurpleWool")
					.setItemName("ItemPurpleWoolIntCorners");
		} else {
			BlockPurpleWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockCyanWoolIntCorners") != 0) {
			BlockCyanWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockCyanWoolIntCorners", 219), 209,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockCyanWoolIntCorners");
			ItemCyanWoolIntCorners = new ItemInteriorCorners(
					BlockCyanWoolIntCorners.blockID - 256, "CyanWool")
					.setItemName("ItemCyanWoolIntCorners");
		} else {
			BlockCyanWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockSilverWoolIntCorners") != 0) {
			BlockSilverWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockSilverWoolIntCorners", 220), 225,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockSilverWoolIntCorners");
			ItemSilverWoolIntCorners = new ItemInteriorCorners(
					BlockSilverWoolIntCorners.blockID - 256, "SilverWool")
					.setItemName("ItemSilverWoolIntCorners");
		} else {
			BlockSilverWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockGrayWoolIntCorners") != 0) {
			BlockGrayWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockGrayWoolIntCorners", 221), 114,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockGrayWoolIntCorners");
			ItemGrayWoolIntCorners = new ItemInteriorCorners(
					BlockGrayWoolIntCorners.blockID - 256, "GrayWool")
					.setItemName("ItemGrayWoolIntCorners");
		} else {
			BlockGrayWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockPinkWoolIntCorners") != 0) {
			BlockPinkWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockPinkWoolIntCorners", 222), 130,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockPinkWoolIntCorners");
			ItemPinkWoolIntCorners = new ItemInteriorCorners(
					BlockPinkWoolIntCorners.blockID - 256, "PinkWool")
					.setItemName("ItemPinkWoolIntCorners");
		} else {
			BlockPinkWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockLimeWoolIntCorners") != 0) {
			BlockLimeWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockLimeWoolIntCorners", 223), 146,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockLimeWoolIntCorners");
			ItemLimeWoolIntCorners = new ItemInteriorCorners(
					BlockLimeWoolIntCorners.blockID - 256, "LimeWool")
					.setItemName("ItemLimeWoolIntCorners");
		} else {
			BlockLimeWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockYellowWoolIntCorners") != 0) {
			BlockYellowWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockYellowWoolIntCorners", 224), 162,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockYellowWoolIntCorners");
			ItemYellowWoolIntCorners = new ItemInteriorCorners(
					BlockYellowWoolIntCorners.blockID - 256, "YellowWool")
					.setItemName("ItemYellowWoolIntCorners");
		} else {
			BlockYellowWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockLightBlueWoolIntCorners") != 0) {
			BlockLightBlueWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockLightBlueWoolIntCorners", 225), 178,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockLightBlueWoolIntCorners");
			ItemLightBlueWoolIntCorners = new ItemInteriorCorners(
					BlockLightBlueWoolIntCorners.blockID - 256,
					"LightBlueWool")
					.setItemName("ItemLightBlueWoolIntCorners");
		} else {
			BlockLightBlueWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockMagentaWoolIntCorners") != 0) {
			BlockMagentaWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockMagentaWoolIntCorners", 226), 194,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockMagentaWoolIntCorners");
			ItemMagentaWoolIntCorners = new ItemInteriorCorners(
					BlockMagentaWoolIntCorners.blockID - 256, "MagentaWool")
					.setItemName("ItemMagentaWoolIntCorners");
		} else {
			BlockMagentaWoolIntCorners = Block.stone;
		}
		if (props.getInt("BlockOrangeWoolIntCorners") != 0) {
			BlockOrangeWoolIntCorners = new BlockInteriorCorners(
					props.getInt("BlockOrangeWoolIntCorners", 227), 210,
					Material.cloth).setHardness(1.0F)
					.setStepSound(Block.soundClothFootstep)
					.setBlockName("BlockOrangeWoolIntCorners");
			ItemOrangeWoolIntCorners = new ItemInteriorCorners(
					BlockOrangeWoolIntCorners.blockID - 256, "OrangeWool")
					.setItemName("ItemOrangeWoolIntCorners");
		} else {
			BlockOrangeWoolIntCorners = Block.stone;
		}

		props.save();
	}
}