package slimevoid.slopesncorners.client.render.handlers;

import org.lwjgl.opengl.GL11;

import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class BlockTriCornersRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		renderInvBlock(renderer, block, metadata, modelID);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		return renderWorldBlock(renderer, world, x, y, z, block, modelId);
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return ConfigurationLib.TriCornersRenderID;
	}

	public void renderInvBlock(RenderBlocks renderblocks, Block block, int i,
			int j) {
		Tessellator tessellator = Tessellator.instance;
		if (j == ConfigurationLib.slopesRenderID) {
			i = MaterialsLib.damageToMaterialValue(i);
			block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);

			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, -1F, 0.0F);
			renderCornersBottomFace(block, 0.0D, 0.0D, 0.0D,
					MaterialsLib.getIconForSide(i, 0), 2 ,
					renderblocks, 240);
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, 1.0F, 0.0F);
			renderCornersTopFace(block, 0.0D, 0.0D, 0.0D,
					MaterialsLib.getIconForSide(i, 1), 2 ,
					renderblocks, 240);
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, 0.0F, -1F);
			renderCornersEastFace(block, 0.0D, 0.0D, 0.0D,
					block.getIcon(2, i), 2 ,
					renderblocks, 240);
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, 0.0F, 1.0F);
			renderCornersWestFace(block, 0.0D, 0.0D, 0.0D,
					MaterialsLib.getIconForSide(i, 3), 2 ,
					renderblocks, 240);
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(-1F, 0.0F, 0.0F);
			renderCornersNorthFace(block, 0.0D, 0.0D, 0.0D,
					MaterialsLib.getIconForSide(i, 4), 2 ,
					renderblocks, 240);
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			renderCornersSouthFace(block, 0.0D, 0.0D, 0.0D,
					MaterialsLib.getIconForSide(i, 5), 2 ,
					renderblocks, 240);
			tessellator.draw();
			GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		}
		block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public boolean renderWorldBlock(RenderBlocks renderblocks,
			IBlockAccess iblockaccess, int i, int j, int k, Block block, int l) {
		if (l == ConfigurationLib.TriCornersRenderID) {
			return renderBlockCorners(block, i, j, k, renderblocks,
					iblockaccess);
		}

		return false;
	}

	public boolean renderBlockCorners(Block block, int i, int j, int k,
			RenderBlocks renderblocks, IBlockAccess iblockaccess) {
		int iDir = iblockaccess.getBlockMetadata(i, j, k);
		int l = block.colorMultiplier(iblockaccess, i, j, k);
		float f = (l >> 16 & 0xff) / 255F;
		float f1 = (l >> 8 & 0xff) / 255F;
		float f2 = (l & 0xff) / 255F;

		if (Minecraft.isAmbientOcclusionEnabled()) {
			return renderCornersBlockWithAmbientOcclusion(block, i, j, k, f,
					f1, f2, iDir, renderblocks, iblockaccess);
		} else {
			return renderCornersBlockWithColorMultiplier(block, i, j, k, f, f1,
					f2, iDir, renderblocks, iblockaccess);
		}
	}

	public boolean renderCornersBlockWithAmbientOcclusion(Block block, int i,
			int j, int k, float f, float f1, float f2, int iDir,
			RenderBlocks renderblocks, IBlockAccess iblockaccess) {
		enableAO = true;
		boolean flag = false;
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = true;
		boolean flag4 = true;
		boolean flag5 = true;
		boolean flag6 = true;

		aoLightValueThis = block.getAmbientOcclusionLightValue(iblockaccess, i,
				j, k);
		aoLightValueXNeg = block.getAmbientOcclusionLightValue(iblockaccess,
				i - 1, j, k);
		aoLightValueYNeg = block.getAmbientOcclusionLightValue(iblockaccess, i,
				j - 1, k);
		aoLightValueZNeg = block.getAmbientOcclusionLightValue(iblockaccess, i,
				j, k - 1);
		aoLightValueXPos = block.getAmbientOcclusionLightValue(iblockaccess,
				i + 1, j, k);
		aoLightValueYPos = block.getAmbientOcclusionLightValue(iblockaccess, i,
				j + 1, k);
		aoLightValueZPos = block.getAmbientOcclusionLightValue(iblockaccess, i,
				j, k + 1);

		aoLightValueXPosYPos = block.getAmbientOcclusionLightValue(
				iblockaccess, i + 1, j + 1, k);
		aoLightValueXPosYNeg = block.getAmbientOcclusionLightValue(
				iblockaccess, i + 1, j - 1, k);
		aoLightValueXPosZPos = block.getAmbientOcclusionLightValue(
				iblockaccess, i + 1, j, k + 1);
		aoLightValueXPosZNeg = block.getAmbientOcclusionLightValue(
				iblockaccess, i + 1, j, k - 1);
		aoLightValueXNegYPos = block.getAmbientOcclusionLightValue(
				iblockaccess, i - 1, j + 1, k);
		aoLightValueXNegYNeg = block.getAmbientOcclusionLightValue(
				iblockaccess, i - 1, j - 1, k);
		aoLightValueXNegZNeg = block.getAmbientOcclusionLightValue(
				iblockaccess, i - 1, j, k - 1);
		aoLightValueXNegZPos = block.getAmbientOcclusionLightValue(
				iblockaccess, i - 1, j, k + 1);
		aoLightValueYPosZPos = block.getAmbientOcclusionLightValue(
				iblockaccess, i, j + 1, k + 1);
		aoLightValueYPosZNeg = block.getAmbientOcclusionLightValue(
				iblockaccess, i, j + 1, k - 1);
		aoLightValueYNegZPos = block.getAmbientOcclusionLightValue(
				iblockaccess, i, j - 1, k + 1);
		aoLightValueYNegZNeg = block.getAmbientOcclusionLightValue(
				iblockaccess, i, j - 1, k - 1);

		aoLightValueXPosYPosZPos = block.getAmbientOcclusionLightValue(
				iblockaccess, i + 1, j + 1, k + 1);
		aoLightValueXPosYNegZPos = block.getAmbientOcclusionLightValue(
				iblockaccess, i + 1, j - 1, k + 1);
		aoLightValueXPosYPosZNeg = block.getAmbientOcclusionLightValue(
				iblockaccess, i + 1, j + 1, k - 1);
		aoLightValueXPosYNegZNeg = block.getAmbientOcclusionLightValue(
				iblockaccess, i + 1, j - 1, k - 1);
		aoLightValueXNegYPosZPos = block.getAmbientOcclusionLightValue(
				iblockaccess, i - 1, j + 1, k + 1);
		aoLightValueXNegYNegZPos = block.getAmbientOcclusionLightValue(
				iblockaccess, i - 1, j - 1, k + 1);
		aoLightValueXNegYPosZNeg = block.getAmbientOcclusionLightValue(
				iblockaccess, i - 1, j + 1, k - 1);
		aoLightValueXNegYNegZNeg = block.getAmbientOcclusionLightValue(
				iblockaccess, i - 1, j - 1, k - 1);

		if (block.getBlockTexture(iblockaccess, i, j, k, iDir) == Block.dirt.getBlockTextureFromSide(0)) {
			flag1 = flag3 = flag4 = flag5 = flag6 = false;
		}

		// /////////////////////////////////
		float f7;
		float f13;
		float f19;
		float f25;
		if (field_22352_G > 0) {
			f7 = (aoLightValueXNegYNegZPos + aoLightValueXNegYNeg
					+ aoLightValueYNegZPos + aoLightValueYNeg) / 4F;
			f25 = (aoLightValueYNegZPos + aoLightValueYNeg
					+ aoLightValueXPosYNegZPos + aoLightValueXPosYNeg) / 4F;
			f19 = (aoLightValueYNeg + aoLightValueYNegZNeg
					+ aoLightValueXPosYNeg + aoLightValueXPosYNegZNeg) / 4F;
			f13 = (aoLightValueXNegYNeg + aoLightValueXNegYNegZNeg
					+ aoLightValueYNeg + aoLightValueYNegZNeg) / 4F;
		} else {
			f7 = f13 = f19 = f25 = aoLightValueYNeg;
		}
		colorRedTopLeft_BottomFace = colorRedBottomLeft_BottomFace = colorRedBottomRight_BottomFace = colorRedTopRight_BottomFace = (flag1 ? f
				: 1.0F) * 0.5F;
		colorGreenTopLeft_BottomFace = colorGreenBottomLeft_BottomFace = colorGreenBottomRight_BottomFace = colorGreenTopRight_BottomFace = (flag1 ? f1
				: 1.0F) * 0.5F;
		colorBlueTopLeft_BottomFace = colorBlueBottomLeft_BottomFace = colorBlueBottomRight_BottomFace = colorBlueTopRight_BottomFace = (flag1 ? f2
				: 1.0F) * 0.5F;
		colorRedTopLeft_BottomFace *= f7;
		colorGreenTopLeft_BottomFace *= f7;
		colorBlueTopLeft_BottomFace *= f7;
		colorRedBottomLeft_BottomFace *= f13;
		colorGreenBottomLeft_BottomFace *= f13;
		colorBlueBottomLeft_BottomFace *= f13;
		colorRedBottomRight_BottomFace *= f19;
		colorGreenBottomRight_BottomFace *= f19;
		colorBlueBottomRight_BottomFace *= f19;
		colorRedTopRight_BottomFace *= f25;
		colorGreenTopRight_BottomFace *= f25;
		colorBlueTopRight_BottomFace *= f25;

		// /////////////////////////////////
		float f8;
		float f14;
		float f20;
		float f26;
		if (field_22352_G > 0) {
			f26 = (aoLightValueXNegYPosZPos + aoLightValueXNegYPos
					+ aoLightValueYPosZPos + aoLightValueYPos) / 4F;
			f8 = (aoLightValueYPosZPos + aoLightValueYPos
					+ aoLightValueXPosYPosZPos + aoLightValueXPosYPos) / 4F;
			f14 = (aoLightValueYPos + aoLightValueYPosZNeg
					+ aoLightValueXPosYPos + aoLightValueXPosYPosZNeg) / 4F;
			f20 = (aoLightValueXNegYPos + aoLightValueXNegYPosZNeg
					+ aoLightValueYPos + aoLightValueYPosZNeg) / 4F;
		} else {
			f8 = f14 = f20 = f26 = aoLightValueYPos;
		}
		colorRedTopLeft_TopFace = colorRedBottomLeft_TopFace = colorRedBottomRight_TopFace = colorRedTopRight_TopFace = flag2 ? f
				: 1.0F;
		colorGreenTopLeft_TopFace = colorGreenBottomLeft_TopFace = colorGreenBottomRight_TopFace = colorGreenTopRight_TopFace = flag2 ? f1
				: 1.0F;
		colorBlueTopLeft_TopFace = colorBlueBottomLeft_TopFace = colorBlueBottomRight_TopFace = colorBlueTopRight_TopFace = flag2 ? f2
				: 1.0F;
		colorRedTopLeft_TopFace *= f8;
		colorGreenTopLeft_TopFace *= f8;
		colorBlueTopLeft_TopFace *= f8;
		colorRedBottomLeft_TopFace *= f14;
		colorGreenBottomLeft_TopFace *= f14;
		colorBlueBottomLeft_TopFace *= f14;
		colorRedBottomRight_TopFace *= f20;
		colorGreenBottomRight_TopFace *= f20;
		colorBlueBottomRight_TopFace *= f20;
		colorRedTopRight_TopFace *= f26;
		colorGreenTopRight_TopFace *= f26;
		colorBlueTopRight_TopFace *= f26;

		// /////////////////////////////////
		float f9;
		float f15;
		float f21;
		float f27;
		if (field_22352_G > 0) {
			f9 = (aoLightValueXNegZNeg + aoLightValueXNegYPosZNeg
					+ aoLightValueZNeg + aoLightValueYPosZNeg) / 4F;
			f15 = (aoLightValueZNeg + aoLightValueYPosZNeg
					+ aoLightValueXPosZNeg + aoLightValueXPosYPosZNeg) / 4F;
			f21 = (aoLightValueYNegZNeg + aoLightValueZNeg
					+ aoLightValueXPosYNegZNeg + aoLightValueXPosZNeg) / 4F;
			f27 = (aoLightValueXNegYNegZNeg + aoLightValueXNegZNeg
					+ aoLightValueYNegZNeg + aoLightValueZNeg) / 4F;
		} else {
			f9 = f15 = f21 = f27 = aoLightValueZNeg;
		}
		colorRedTopLeft_EastFace = colorRedBottomLeft_EastFace = colorRedBottomRight_EastFace = colorRedTopRight_EastFace = (flag3 ? f
				: 1.0F) * 0.8F;
		colorGreenTopLeft_EastFace = colorGreenBottomLeft_EastFace = colorGreenBottomRight_EastFace = colorGreenTopRight_EastFace = (flag3 ? f1
				: 1.0F) * 0.8F;
		colorBlueTopLeft_EastFace = colorBlueBottomLeft_EastFace = colorBlueBottomRight_EastFace = colorBlueTopRight_EastFace = (flag3 ? f2
				: 1.0F) * 0.8F;
		colorRedTopLeft_EastFace *= f9;
		colorGreenTopLeft_EastFace *= f9;
		colorBlueTopLeft_EastFace *= f9;
		colorRedBottomLeft_EastFace *= f15;
		colorGreenBottomLeft_EastFace *= f15;
		colorBlueBottomLeft_EastFace *= f15;
		colorRedBottomRight_EastFace *= f21;
		colorGreenBottomRight_EastFace *= f21;
		colorBlueBottomRight_EastFace *= f21;
		colorRedTopRight_EastFace *= f27;
		colorGreenTopRight_EastFace *= f27;
		colorBlueTopRight_EastFace *= f27;
		Icon l = block.getBlockTexture(iblockaccess, i, j, k, 2);

		// /////////////////////////////////
		float f10;
		float f16;
		float f22;
		float f28;
		if (field_22352_G > 0) {
			f10 = (aoLightValueXNegZPos + aoLightValueXNegYPosZPos
					+ aoLightValueZPos + aoLightValueYPosZPos) / 4F;
			f28 = (aoLightValueZPos + aoLightValueYPosZPos
					+ aoLightValueXPosZPos + aoLightValueXPosYPosZPos) / 4F;
			f22 = (aoLightValueYNegZPos + aoLightValueZPos
					+ aoLightValueXPosYNegZPos + aoLightValueXPosZPos) / 4F;
			f16 = (aoLightValueXNegYNegZPos + aoLightValueXNegZPos
					+ aoLightValueYNegZPos + aoLightValueZPos) / 4F;
		} else {
			f10 = f16 = f22 = f28 = aoLightValueZPos;
		}
		colorRedTopLeft_WestFace = colorRedBottomLeft_WestFace = colorRedBottomRight_WestFace = colorRedTopRight_WestFace = (flag4 ? f
				: 1.0F) * 0.8F;
		colorGreenTopLeft_WestFace = colorGreenBottomLeft_WestFace = colorGreenBottomRight_WestFace = colorGreenTopRight_WestFace = (flag4 ? f1
				: 1.0F) * 0.8F;
		colorBlueTopLeft_WestFace = colorBlueBottomLeft_WestFace = colorBlueBottomRight_WestFace = colorBlueTopRight_WestFace = (flag4 ? f2
				: 1.0F) * 0.8F;
		colorRedTopLeft_WestFace *= f10;
		colorGreenTopLeft_WestFace *= f10;
		colorBlueTopLeft_WestFace *= f10;
		colorRedBottomLeft_WestFace *= f16;
		colorGreenBottomLeft_WestFace *= f16;
		colorBlueBottomLeft_WestFace *= f16;
		colorRedBottomRight_WestFace *= f22;
		colorGreenBottomRight_WestFace *= f22;
		colorBlueBottomRight_WestFace *= f22;
		colorRedTopRight_WestFace *= f28;
		colorGreenTopRight_WestFace *= f28;
		colorBlueTopRight_WestFace *= f28;
		Icon i1 = block.getBlockTexture(iblockaccess, i, j, k, 3);

		// /////////////////////////////////
		float f11;
		float f17;
		float f23;
		float f29;
		if (field_22352_G > 0) {
			f29 = (aoLightValueXNegYNeg + aoLightValueXNegYNegZPos
					+ aoLightValueXNeg + aoLightValueXNegZPos) / 4F;
			f11 = (aoLightValueXNeg + aoLightValueXNegZPos
					+ aoLightValueXNegYPos + aoLightValueXNegYPosZPos) / 4F;
			f17 = (aoLightValueXNegZNeg + aoLightValueXNeg
					+ aoLightValueXNegYPosZNeg + aoLightValueXNegYPos) / 4F;
			f23 = (aoLightValueXNegYNegZNeg + aoLightValueXNegYNeg
					+ aoLightValueXNegZNeg + aoLightValueXNeg) / 4F;
		} else {
			f11 = f17 = f23 = f29 = aoLightValueXNeg;
		}
		colorRedTopLeft_NorthFace = colorRedBottomLeft_NorthFace = colorRedBottomRight_NorthFace = colorRedTopRight_NorthFace = (flag5 ? f
				: 1.0F) * 0.6F;
		colorGreenTopLeft_NorthFace = colorGreenBottomLeft_NorthFace = colorGreenBottomRight_NorthFace = colorGreenTopRight_NorthFace = (flag5 ? f1
				: 1.0F) * 0.6F;
		colorBlueTopLeft_NorthFace = colorBlueBottomLeft_NorthFace = colorBlueBottomRight_NorthFace = colorBlueTopRight_NorthFace = (flag5 ? f2
				: 1.0F) * 0.6F;
		colorRedTopLeft_NorthFace *= f11;
		colorGreenTopLeft_NorthFace *= f11;
		colorBlueTopLeft_NorthFace *= f11;
		colorRedBottomLeft_NorthFace *= f17;
		colorGreenBottomLeft_NorthFace *= f17;
		colorBlueBottomLeft_NorthFace *= f17;
		colorRedBottomRight_NorthFace *= f23;
		colorGreenBottomRight_NorthFace *= f23;
		colorBlueBottomRight_NorthFace *= f23;
		colorRedTopRight_NorthFace *= f29;
		colorGreenTopRight_NorthFace *= f29;
		colorBlueTopRight_NorthFace *= f29;
		Icon j1 = block.getBlockTexture(iblockaccess, i, j, k, 4);

		// /////////////////////////////////
		float f12;
		float f18;
		float f24;
		float f30;
		if (field_22352_G > 0) {
			f12 = (aoLightValueXPosYNeg + aoLightValueXPosYNegZPos
					+ aoLightValueXPos + aoLightValueXPosZPos) / 4F;
			f30 = (aoLightValueXPos + aoLightValueXPosZPos
					+ aoLightValueXPosYPos + aoLightValueXPosYPosZPos) / 4F;
			f24 = (aoLightValueXPosZNeg + aoLightValueXPos
					+ aoLightValueXPosYPosZNeg + aoLightValueXPosYPos) / 4F;
			f18 = (aoLightValueXPosYNegZNeg + aoLightValueXPosYNeg
					+ aoLightValueXPosZNeg + aoLightValueXPos) / 4F;
		} else {
			f12 = f18 = f24 = f30 = aoLightValueXPos;
		}
		colorRedTopLeft_SouthFace = colorRedBottomLeft_SouthFace = colorRedBottomRight_SouthFace = colorRedTopRight_SouthFace = (flag6 ? f
				: 1.0F) * 0.6F;
		colorGreenTopLeft_SouthFace = colorGreenBottomLeft_SouthFace = colorGreenBottomRight_SouthFace = colorGreenTopRight_SouthFace = (flag6 ? f1
				: 1.0F) * 0.6F;
		colorBlueTopLeft_SouthFace = colorBlueBottomLeft_SouthFace = colorBlueBottomRight_SouthFace = colorBlueTopRight_SouthFace = (flag6 ? f2
				: 1.0F) * 0.6F;
		colorRedTopLeft_SouthFace *= f12;
		colorGreenTopLeft_SouthFace *= f12;
		colorBlueTopLeft_SouthFace *= f12;
		colorRedBottomLeft_SouthFace *= f18;
		colorGreenBottomLeft_SouthFace *= f18;
		colorBlueBottomLeft_SouthFace *= f18;
		colorRedBottomRight_SouthFace *= f24;
		colorGreenBottomRight_SouthFace *= f24;
		colorBlueBottomRight_SouthFace *= f24;
		colorRedTopRight_SouthFace *= f30;
		colorGreenTopRight_SouthFace *= f30;
		colorBlueTopRight_SouthFace *= f30;
		Icon k1 = block.getBlockTexture(iblockaccess, i, j, k, 5);

		// ///////////////////////////////////////SUPERSLOPES//////////////////////////////

		colorRedSlopes = f;
		colorGreenSlopes = f1;
		colorBlueSlopes = f2;

		// ///////////////////////////////////////

		if (renderblocks.renderAllFaces
				|| block.shouldSideBeRendered(iblockaccess, i, j - 1, k, 0)) {
			renderCornersBottomFace(block, i, j, k,
					block.getBlockTexture(iblockaccess, i, j, k, 0), iDir,
					renderblocks,
					block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
			flag = true;
		}
		if (renderblocks.renderAllFaces
				|| block.shouldSideBeRendered(iblockaccess, i, j + 1, k, 1)) {
			renderCornersTopFace(block, i, j, k,
					block.getBlockTexture(iblockaccess, i, j, k, 1), iDir,
					renderblocks,
					block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
			flag = true;
		}
		if (renderblocks.renderAllFaces
				|| block.shouldSideBeRendered(iblockaccess, i, j, k - 1, 2)) {
			renderCornersEastFace(block, i, j, k, l, iDir, renderblocks,
					block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
			if (renderblocks.fancyGrass && l.getIconName().equals("grass_side") && !renderblocks.hasOverrideBlockTexture()) {
				colorRedTopLeft_EastFace *= f;
				colorRedBottomLeft_EastFace *= f;
				colorRedBottomRight_EastFace *= f;
				colorRedTopRight_EastFace *= f;
				colorGreenTopLeft_EastFace *= f1;
				colorGreenBottomLeft_EastFace *= f1;
				colorGreenBottomRight_EastFace *= f1;
				colorGreenTopRight_EastFace *= f1;
				colorBlueTopLeft_EastFace *= f2;
				colorBlueBottomLeft_EastFace *= f2;
				colorBlueBottomRight_EastFace *= f2;
				colorBlueTopRight_EastFace *= f2;
				renderCornersEastFace(block, i, j, k, BlockGrass.getIconSideOverlay(), iDir, renderblocks,
						block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
				|| block.shouldSideBeRendered(iblockaccess, i, j, k + 1, 3)) {
			renderCornersWestFace(block, i, j, k, i1, iDir, renderblocks,
					block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
			if (renderblocks.fancyGrass && i1.getIconName().equals("grass_side") && !renderblocks.hasOverrideBlockTexture()) {
				colorRedTopLeft_WestFace *= f;
				colorRedBottomLeft_WestFace *= f;
				colorRedBottomRight_WestFace *= f;
				colorRedTopRight_WestFace *= f;
				colorGreenTopLeft_WestFace *= f1;
				colorGreenBottomLeft_WestFace *= f1;
				colorGreenBottomRight_WestFace *= f1;
				colorGreenTopRight_WestFace *= f1;
				colorBlueTopLeft_WestFace *= f2;
				colorBlueBottomLeft_WestFace *= f2;
				colorBlueBottomRight_WestFace *= f2;
				colorBlueTopRight_WestFace *= f2;
				renderCornersWestFace(block, i, j, k, BlockGrass.getIconSideOverlay(), iDir, renderblocks,
						block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
				|| block.shouldSideBeRendered(iblockaccess, i - 1, j, k, 4)) {
			renderCornersNorthFace(block, i, j, k, j1, iDir, renderblocks,
					block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
			if (renderblocks.fancyGrass && j1.getIconName().equals("grass_side") && !renderblocks.hasOverrideBlockTexture()) {
				colorRedTopLeft_NorthFace *= f;
				colorRedBottomLeft_NorthFace *= f;
				colorRedBottomRight_NorthFace *= f;
				colorRedTopRight_NorthFace *= f;
				colorGreenTopLeft_NorthFace *= f1;
				colorGreenBottomLeft_NorthFace *= f1;
				colorGreenBottomRight_NorthFace *= f1;
				colorGreenTopRight_NorthFace *= f1;
				colorBlueTopLeft_NorthFace *= f2;
				colorBlueBottomLeft_NorthFace *= f2;
				colorBlueBottomRight_NorthFace *= f2;
				colorBlueTopRight_NorthFace *= f2;
				renderCornersNorthFace(block, i, j, k, BlockGrass.getIconSideOverlay(), iDir, renderblocks,
						block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
				|| block.shouldSideBeRendered(iblockaccess, i + 1, j, k, 5)) {
			renderCornersSouthFace(block, i, j, k, k1, iDir, renderblocks,
					block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
			if (renderblocks.fancyGrass && k1.getIconName().equals("grass_side") && !renderblocks.hasOverrideBlockTexture()) {
				colorRedTopLeft_SouthFace *= f;
				colorRedBottomLeft_SouthFace *= f;
				colorRedBottomRight_SouthFace *= f;
				colorRedTopRight_SouthFace *= f;
				colorGreenTopLeft_SouthFace *= f1;
				colorGreenBottomLeft_SouthFace *= f1;
				colorGreenBottomRight_SouthFace *= f1;
				colorGreenTopRight_SouthFace *= f1;
				colorBlueTopLeft_SouthFace *= f2;
				colorBlueBottomLeft_SouthFace *= f2;
				colorBlueBottomRight_SouthFace *= f2;
				colorBlueTopRight_SouthFace *= f2;
				renderCornersSouthFace(block, i, j, k, BlockGrass.getIconSideOverlay(), iDir, renderblocks,
						block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
			}
			flag = true;
		}

		enableAO = false;
		return flag;
	}

	public boolean renderCornersBlockWithColorMultiplier(Block block, int i,
			int j, int k, float f, float f1, float f2, int iDir,
			RenderBlocks renderblocks, IBlockAccess iblockaccess) {
		Tessellator tessellator = Tessellator.instance;
		boolean flag = false;
		float f3 = 0.5F;
		float f4 = 1.0F;
		float f5 = 0.8F;
		float f6 = 0.6F;
		float f7 = f4 * f;
		float f8 = f4 * f1;
		float f9 = f4 * f2;
		if (block == Block.grass) {
			f = f1 = f2 = 1.0F;
		}
		float f10 = f3 * f;
		float f11 = f5 * f;
		float f12 = f6 * f;
		float f13 = f3 * f1;
		float f14 = f5 * f1;
		float f15 = f6 * f1;
		float f16 = f3 * f2;
		float f17 = f5 * f2;
		float f18 = f6 * f2;
		float f19 = block.getAmbientOcclusionLightValue(iblockaccess, i, j, k);

		if (renderblocks.renderAllFaces
				|| block.shouldSideBeRendered(iblockaccess, i, j - 1, k, 0)) {
			if (iDir / 4 != 1 && iDir / 4 != 3) {
				float f20 = block.getAmbientOcclusionLightValue(iblockaccess,
						i, j - 1, k);
				tessellator.setColorOpaque_F(f10 * f20, f13 * f20, f16 * f20);
				renderCornersBottomFace(block, i, j, k,
						block.getBlockTexture(iblockaccess, i, j, k, 0), iDir,
						renderblocks,
						block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
				flag = true;
			}
		}

		if (renderblocks.renderAllFaces
				|| block.shouldSideBeRendered(iblockaccess, i, j + 1, k, 1)) {
			if (iDir / 4 != 0 && iDir / 4 != 2) {
				float f21 = block.getAmbientOcclusionLightValue(iblockaccess,
						i, j + 1, k);
				if (block.getBlockBoundsMaxY() != 1.0D
						&& !block.blockMaterial.isLiquid()) {
					f21 = f19;
				}
				tessellator.setColorOpaque_F(f7 * f21, f8 * f21, f9 * f21);
				renderCornersTopFace(block, i, j, k,
						block.getBlockTexture(iblockaccess, i, j, k, 1), iDir,
						renderblocks,
						block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
				flag = true;
			}
		}

		if (renderblocks.renderAllFaces
				|| block.shouldSideBeRendered(iblockaccess, i, j, k - 1, 2)
				|| iDir % 2 == 0) {
			float f22 = block.getAmbientOcclusionLightValue(iblockaccess, i, j,
					k - 1);
			if (iDir % 2 == 0) {
				f22 = f19;
			}
			tessellator.setColorOpaque_F(f11 * f22, f14 * f22, f17 * f22);
			renderCornersEastFace(block, i, j, k,
					block.getBlockTexture(iblockaccess, i, j, k, 2), iDir,
					renderblocks,
					block.getMixedBrightnessForBlock(iblockaccess, i, j, k));

			flag = true;
		}
		if (renderblocks.renderAllFaces
				|| block.shouldSideBeRendered(iblockaccess, i, j, k + 1, 3)
				|| iDir % 2 == 1) {
			float f23 = block.getAmbientOcclusionLightValue(iblockaccess, i, j,
					k + 1);
			if (iDir % 2 == 1) {
				f23 = f19;
			}
			tessellator.setColorOpaque_F(f11 * f23, f14 * f23, f17 * f23);
			renderCornersWestFace(block, i, j, k,
					block.getBlockTexture(iblockaccess, i, j, k, 3), iDir,
					renderblocks,
					block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
			flag = true;
		}
		if (renderblocks.renderAllFaces
				|| block.shouldSideBeRendered(iblockaccess, i - 1, j, k, 4)
				|| iDir == 0 || iDir == 3 || iDir == 4 || iDir == 7
				|| iDir == 11 || iDir == 15) {
			float f24 = block.getAmbientOcclusionLightValue(iblockaccess,
					i - 1, j, k);
			if (iDir == 0 || iDir == 3 || iDir == 4 || iDir == 7 || iDir == 11
					|| iDir == 15) {
				f24 = f19;
			}
			tessellator.setColorOpaque_F(f12 * f24, f15 * f24, f18 * f24);
			renderCornersNorthFace(block, i, j, k,
					block.getBlockTexture(iblockaccess, i, j, k, 4), iDir,
					renderblocks,
					block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
			flag = true;
		}
		if (renderblocks.renderAllFaces
				|| block.shouldSideBeRendered(iblockaccess, i + 1, j, k, 5)
				|| iDir == 1 || iDir == 2 || iDir == 5 || iDir == 6
				|| iDir == 10 || iDir == 14) {
			float f25 = block.getAmbientOcclusionLightValue(iblockaccess,
					i + 1, j, k);
			if (iDir == 1 || iDir == 2 || iDir == 5 || iDir == 6 || iDir == 10
					|| iDir == 14) {
				f25 = f19;
			}
			tessellator.setColorOpaque_F(f12 * f25, f15 * f25, f18 * f25);
			renderCornersSouthFace(block, i, j, k,
					block.getBlockTexture(iblockaccess, i, j, k, 5), iDir,
					renderblocks,
					block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
			flag = true;
		}
		return flag;
	}

	public void renderCornersBottomFace(Block block, double d, double d1,
			double d2, Icon i, int iDir, RenderBlocks renderblocks,
			int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture())
        {
            i = renderblocks.overrideBlockTexture;
        }

        double d3 = (double)i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
        double d4 = (double)i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
        double d5 = (double)i.getInterpolatedV(renderblocks.renderMinZ * 16.0D);
        double d6 = (double)i.getInterpolatedV(renderblocks.renderMaxZ * 16.0D);
		if (block.getBlockBoundsMinX() < 0.0D
				|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 = (0 + 0.0F);
			d4 = (0 + 15.99F) ;
		}
		if (block.getBlockBoundsMinZ() < 0.0D
				|| block.getBlockBoundsMaxZ() > 1.0D) {
			d5 =  0.0F;
			d6 = 15.99F;
		}
		double d7 = d + block.getBlockBoundsMinX();
		double d8 = d + block.getBlockBoundsMaxX();
		double d9 = d1 + block.getBlockBoundsMinY();
		double d10 = d2 + block.getBlockBoundsMinZ();
		double d11 = d2 + block.getBlockBoundsMaxZ();

		if (enableAO) {
			if (iDir == 0) {
				// Pointing South-West
				tessellator.setColorOpaque_F(colorRedTopLeft_BottomFace,
						colorGreenTopLeft_BottomFace,
						colorBlueTopLeft_BottomFace);
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
				tessellator.setColorOpaque_F(colorRedBottomRight_BottomFace,
						colorGreenBottomRight_BottomFace,
						colorBlueBottomRight_BottomFace);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.setColorOpaque_F(colorRedBottomRight_BottomFace,
						colorGreenBottomRight_BottomFace,
						colorBlueBottomRight_BottomFace);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.setColorOpaque_F(colorRedTopRight_BottomFace,
						colorGreenTopRight_BottomFace,
						colorBlueTopRight_BottomFace);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
			} else if (iDir == 1) {
				// Pointing North-East
				tessellator.setColorOpaque_F(colorRedTopLeft_BottomFace,
						colorGreenTopLeft_BottomFace,
						colorBlueTopLeft_BottomFace);
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
				tessellator.setColorOpaque_F(colorRedBottomLeft_BottomFace,
						colorGreenBottomLeft_BottomFace,
						colorBlueBottomLeft_BottomFace);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.setColorOpaque_F(colorRedBottomRight_BottomFace,
						colorGreenBottomRight_BottomFace,
						colorBlueBottomRight_BottomFace);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.setColorOpaque_F(colorRedTopLeft_BottomFace,
						colorGreenTopLeft_BottomFace,
						colorBlueTopLeft_BottomFace);
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
			} else if (iDir == 2) {
				// Pointing North-West
				tessellator.setColorOpaque_F(colorRedTopLeft_BottomFace,
						colorGreenTopLeft_BottomFace,
						colorBlueTopLeft_BottomFace);
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
				tessellator.setColorOpaque_F(colorRedBottomLeft_BottomFace,
						colorGreenBottomLeft_BottomFace,
						colorBlueBottomLeft_BottomFace);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.setColorOpaque_F(colorRedTopRight_BottomFace,
						colorGreenTopRight_BottomFace,
						colorBlueTopRight_BottomFace);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.setColorOpaque_F(colorRedTopRight_BottomFace,
						colorGreenTopRight_BottomFace,
						colorBlueTopRight_BottomFace);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
			} else if (iDir == 3) {
				// Pointing South-East
				tessellator.setColorOpaque_F(colorRedBottomLeft_BottomFace,
						colorGreenBottomLeft_BottomFace,
						colorBlueBottomLeft_BottomFace);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.setColorOpaque_F(colorRedBottomLeft_BottomFace,
						colorGreenBottomLeft_BottomFace,
						colorBlueBottomLeft_BottomFace);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.setColorOpaque_F(colorRedBottomRight_BottomFace,
						colorGreenBottomRight_BottomFace,
						colorBlueBottomRight_BottomFace);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.setColorOpaque_F(colorRedTopRight_BottomFace,
						colorGreenTopRight_BottomFace,
						colorBlueTopRight_BottomFace);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
			}
		} else {
			if (iDir == 0) {
				// Pointing South-West
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
			} else if (iDir == 1) {
				// Pointing North-East
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
			} else if (iDir == 2) {
				// Pointing North-West
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
			} else if (iDir == 3) {
				// Pointing South-East
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
			}
		}
	}

	public void renderCornersTopFace(Block block, double d, double d1,
			double d2, Icon i, int iDir, RenderBlocks renderblocks,
			int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture())
        {
            i = renderblocks.overrideBlockTexture;
        }
        double d3 = (double)i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
        double d4 = (double)i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
        double d5 = (double)i.getInterpolatedV(renderblocks.renderMinZ * 16.0D);
        double d6 = (double)i.getInterpolatedV(renderblocks.renderMaxZ * 16.0D);
		if (block.getBlockBoundsMinX() < 0.0D
				|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 = i.getMinU();
			d4 = i.getMaxU();
		}
		if (block.getBlockBoundsMinZ() < 0.0D
				|| block.getBlockBoundsMaxZ() > 1.0D) {
			d5 = i.getMinV() ;
			d6 = i.getMaxV();
		}
		double d7 = d + block.getBlockBoundsMinX();
		double d8 = d + block.getBlockBoundsMaxX();
		double d9 = d1 + block.getBlockBoundsMaxY();
		double d10 = d2 + block.getBlockBoundsMinZ();
		double d11 = d2 + block.getBlockBoundsMaxZ();

		if (enableAO) {
			if (iDir == 4) {
				// Pointing South-West
				tessellator.setColorOpaque_F(colorRedTopLeft_TopFace,
						colorGreenTopLeft_TopFace, colorBlueTopLeft_TopFace);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.setColorOpaque_F(colorRedBottomLeft_TopFace,
						colorGreenBottomLeft_TopFace,
						colorBlueBottomLeft_TopFace);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.setColorOpaque_F(colorRedTopRight_TopFace,
						colorGreenTopRight_TopFace, colorBlueTopRight_TopFace);
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
				tessellator.setColorOpaque_F(colorRedTopRight_TopFace,
						colorGreenTopRight_TopFace, colorBlueTopRight_TopFace);
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
			} else if (iDir == 5) {
				// Pointing North-East
				tessellator.setColorOpaque_F(colorRedBottomLeft_TopFace,
						colorGreenBottomLeft_TopFace,
						colorBlueBottomLeft_TopFace);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.setColorOpaque_F(colorRedBottomLeft_TopFace,
						colorGreenBottomLeft_TopFace,
						colorBlueBottomLeft_TopFace);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.setColorOpaque_F(colorRedBottomRight_TopFace,
						colorGreenBottomRight_TopFace,
						colorBlueBottomRight_TopFace);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.setColorOpaque_F(colorRedTopRight_TopFace,
						colorGreenTopRight_TopFace, colorBlueTopRight_TopFace);
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
			} else if (iDir == 6) {
				// Pointing North-West
				tessellator.setColorOpaque_F(colorRedTopLeft_TopFace,
						colorGreenTopLeft_TopFace, colorBlueTopLeft_TopFace);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.setColorOpaque_F(colorRedBottomRight_TopFace,
						colorGreenBottomRight_TopFace,
						colorBlueBottomRight_TopFace);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.setColorOpaque_F(colorRedBottomRight_TopFace,
						colorGreenBottomRight_TopFace,
						colorBlueBottomRight_TopFace);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.setColorOpaque_F(colorRedTopRight_TopFace,
						colorGreenTopRight_TopFace, colorBlueTopRight_TopFace);
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
			} else if (iDir == 7) {
				// Pointing South-East
				tessellator.setColorOpaque_F(colorRedTopLeft_TopFace,
						colorGreenTopLeft_TopFace, colorBlueTopLeft_TopFace);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.setColorOpaque_F(colorRedBottomLeft_TopFace,
						colorGreenBottomLeft_TopFace,
						colorBlueBottomLeft_TopFace);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.setColorOpaque_F(colorRedBottomRight_TopFace,
						colorGreenBottomRight_TopFace,
						colorBlueBottomRight_TopFace);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.setColorOpaque_F(colorRedTopLeft_TopFace,
						colorGreenTopLeft_TopFace, colorBlueTopLeft_TopFace);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
			}
		} else {
			if (iDir == 4) {
				// Pointing South-West
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
			} else if (iDir == 5) {
				// Pointing North-East
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
			} else if (iDir == 6) {
				// Pointing North-West
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
			} else if (iDir == 7) {
				// Pointing South-East
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
				tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
			}
		}
	}

	public void renderCornersEastFace(Block block, double d, double d1,
			double d2, Icon i, int iDir, RenderBlocks renderblocks,
			int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		 if (renderblocks.hasOverrideBlockTexture())
	        {
	            i = renderblocks.overrideBlockTexture;
	        }

	        double d3 = (double)i.getInterpolatedU(renderblocks.renderMinZ * 16.0D);
	        double d4 = (double)i.getInterpolatedU(renderblocks.renderMaxZ * 16.0D);
	        double d5 = (double)i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
	        double d6 = (double)i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
		
		if (renderblocks.flipTexture) {
			double d7 = d3;
			d3 = d4;
			d4 = d7;
		}
		if (block.getBlockBoundsMinX() < 0.0D
				|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 =  0.0F;
			d4 = 15.99F;
		}
		if (block.getBlockBoundsMinY() < 0.0D
				|| block.getBlockBoundsMaxY() > 1.0D) {
			d5 = 0.0F;
			d6 = 15.99F;
		}
		double d8 = d + block.getBlockBoundsMinX();
		double d9 = d + block.getBlockBoundsMaxX();
		double d10 = d1 + block.getBlockBoundsMinY();
		double d11 = d1 + block.getBlockBoundsMaxY();
		double d12 = d2 + block.getBlockBoundsMinZ();
		double d13 = d2 + block.getBlockBoundsMaxZ();

		if (enableAO) {
			if (iDir == 1) {
				// Triangle Down pointing south
				tessellator.setColorOpaque_F(colorRedTopLeft_EastFace,
						colorGreenTopLeft_EastFace, colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8, d11, d12, d4, d5);
				tessellator.setColorOpaque_F(colorRedBottomRight_EastFace,
						colorGreenBottomRight_EastFace,
						colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9, d10, d12, d3, d6);
				tessellator.setColorOpaque_F(colorRedBottomRight_EastFace,
						colorGreenBottomRight_EastFace,
						colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9, d10, d12, d3, d6);
				tessellator
						.setColorOpaque_F(colorRedTopRight_EastFace,
								colorGreenTopRight_EastFace,
								colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8, d10, d12, d4, d6);
			} else if (iDir == 3) {
				// Triangle Down pointing north
				tessellator
						.setColorOpaque_F(colorRedTopRight_EastFace,
								colorGreenTopRight_EastFace,
								colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8, d10, d12, d4, d6);
				tessellator.setColorOpaque_F(colorRedBottomLeft_EastFace,
						colorGreenBottomLeft_EastFace,
						colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9, d11, d12, d3, d5);
				tessellator.setColorOpaque_F(colorRedBottomRight_EastFace,
						colorGreenBottomRight_EastFace,
						colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9, d10, d12, d3, d6);
				tessellator
						.setColorOpaque_F(colorRedTopRight_EastFace,
								colorGreenTopRight_EastFace,
								colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8, d10, d12, d4, d6);
			}else if (iDir == 5 ) {
				// Triangle Up pointing south
				tessellator.setColorOpaque_F(colorRedTopLeft_EastFace,
						colorGreenTopLeft_EastFace, colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8, d11, d12, d4, d5);
				tessellator.setColorOpaque_F(colorRedBottomLeft_EastFace,
						colorGreenBottomLeft_EastFace,
						colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9, d11, d12, d3, d5);
				tessellator.setColorOpaque_F(colorRedBottomLeft_EastFace,
						colorGreenBottomLeft_EastFace,
						colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9, d11, d12, d3, d5);
				tessellator
						.setColorOpaque_F(colorRedTopRight_EastFace,
								colorGreenTopRight_EastFace,
								colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8, d10, d12, d4, d6);
			}else if (iDir == 7) {
				// Triangle Up pointing north
				tessellator.setColorOpaque_F(colorRedTopLeft_EastFace,
						colorGreenTopLeft_EastFace, colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8, d11, d12, d4, d5);
				tessellator.setColorOpaque_F(colorRedBottomLeft_EastFace,
						colorGreenBottomLeft_EastFace,
						colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9, d11, d12, d3, d5);
				tessellator.setColorOpaque_F(colorRedBottomRight_EastFace,
						colorGreenBottomRight_EastFace,
						colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9, d10, d12, d3, d6);
				tessellator.setColorOpaque_F(colorRedTopLeft_EastFace,
						colorGreenTopLeft_EastFace, colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8, d11, d12, d4, d5);
			} else if (iDir == 0) {
				// Slope facing Up - East - North
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYPos
						* (factorTop + factorNorth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueYPos
								* (factorTop + factorNorth + factorEast) / 3F,
						colorBlueSlopes * aoLightValueYPos
								* (factorTop + factorNorth + factorEast) / 3F);
				tessellator.addVertexWithUV(d9, d11, d13, (d3 + d4) / 2.0F, d5);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYPos
						* (factorTop + factorNorth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueYPos
								* (factorTop + factorNorth + factorEast) / 3F,
						colorBlueSlopes * aoLightValueYPos
								* (factorTop + factorNorth + factorEast) / 3F);
				tessellator.addVertexWithUV(d9, d11, d13, (d3 + d4) / 2.0F, d5);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueZNeg
						* (factorTop + factorNorth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueZNeg
								* (factorTop + factorNorth + factorEast) / 3F,
						colorBlueSlopes * aoLightValueZNeg
								* (factorTop + factorNorth + factorEast) / 3F);
				tessellator.addVertexWithUV(d9, d10, d12, d3, d6);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueXNeg
						* (factorTop + factorNorth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueXNeg
								* (factorTop + factorNorth + factorEast) / 3F,
						colorBlueSlopes * aoLightValueXNeg
								* (factorTop + factorNorth + factorEast) / 3F);
				tessellator.addVertexWithUV(d8, d10, d13, d4, d6);
			} else if (iDir == 4) {
				// Slope facing Down - East - North
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueXNeg
						* (factorBottom + factorNorth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueXNeg
								* (factorBottom + factorNorth + factorEast)
								/ 3F, colorBlueSlopes * aoLightValueXNeg
								* (factorBottom + factorNorth + factorEast)
								/ 3F);
				tessellator.addVertexWithUV(d8, d11, d13, d4, d5);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueZNeg
						* (factorBottom + factorNorth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueZNeg
								* (factorBottom + factorNorth + factorEast)
								/ 3F, colorBlueSlopes * aoLightValueZNeg
								* (factorBottom + factorNorth + factorEast)
								/ 3F);
				tessellator.addVertexWithUV(d9, d11, d12, d3, d5);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYNeg
						* (factorBottom + factorNorth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueYNeg
								* (factorBottom + factorNorth + factorEast)
								/ 3F, colorBlueSlopes * aoLightValueYNeg
								* (factorBottom + factorNorth + factorEast)
								/ 3F);
				tessellator.addVertexWithUV(d9, d10, d13, (d3 + d4) / 2.0F, d6);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYNeg
						* (factorBottom + factorNorth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueYNeg
								* (factorBottom + factorNorth + factorEast)
								/ 3F, colorBlueSlopes * aoLightValueYNeg
								* (factorBottom + factorNorth + factorEast)
								/ 3F);
				tessellator.addVertexWithUV(d9, d10, d13, (d3 + d4) / 2.0F, d6);
			}
		} else {
			if (iDir == 1) {
				// Pointing 1, X = 0, Z = 0
				tessellator.addVertexWithUV(d8, d11, d12, d4, d5);
				tessellator.addVertexWithUV(d8, d11, d12, d4, d5);
				tessellator.addVertexWithUV(d9, d10, d12, d3, d6);
				tessellator.addVertexWithUV(d8, d10, d12, d4, d6);
			} else if (iDir == 3) {
				// Pointing 3, X = 1, Z = 0
				tessellator.addVertexWithUV(d9, d11, d12, d3, d5);
				tessellator.addVertexWithUV(d9, d11, d12, d3, d5);
				tessellator.addVertexWithUV(d9, d10, d12, d3, d6);
				tessellator.addVertexWithUV(d8, d10, d12, d4, d6);
			} else if (iDir == 5) {
				// Pointing 1, X = 0, Z = 0
				tessellator.addVertexWithUV(d8, d11, d12, d4, d5);
				tessellator.addVertexWithUV(d9, d11, d12, d3, d5);
				tessellator.addVertexWithUV(d8, d10, d12, d4, d6);
				tessellator.addVertexWithUV(d8, d10, d12, d4, d6);
			} else if (iDir == 7) {
				// Pointing 3, X = 1, Z = 0
				tessellator.addVertexWithUV(d8, d11, d12, d4, d5);
				tessellator.addVertexWithUV(d9, d11, d12, d3, d5);
				tessellator.addVertexWithUV(d9, d10, d12, d3, d6);
				tessellator.addVertexWithUV(d9, d10, d12, d3, d6);
			} else if (iDir == 0) {
				// Pointing 0, X = 1, Z = 1, Sloped
				tessellator.addVertexWithUV(d9, d11, d13, (d3 + d4) / 2.0F, d5);
				tessellator.addVertexWithUV(d9, d11, d13, (d3 + d4) / 2.0F, d5);
				tessellator.addVertexWithUV(d9, d10, d12, d3, d6);
				tessellator.addVertexWithUV(d8, d10, d13, d4, d6);
			} else if (iDir == 4) {
				// Pointing 0, X = 1, Z = 1, Sloped
				tessellator.addVertexWithUV(d8, d11, d13, d4, d5);
				tessellator.addVertexWithUV(d9, d11, d12, d3, d5);
				tessellator.addVertexWithUV(d9, d10, d13, (d3 + d4) / 2.0F, d6);
				tessellator.addVertexWithUV(d9, d10, d13, (d3 + d4) / 2.0F, d6);
			}
		}
	}

	public void renderCornersWestFace(Block block, double d, double d1,
			double d2, Icon i, int iDir, RenderBlocks renderblocks,
			int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture())
        {
            i = renderblocks.overrideBlockTexture;
        }

        double d3 = (double)i.getInterpolatedU(renderblocks.renderMinZ * 16.0D);
        double d4 = (double)i.getInterpolatedU(renderblocks.renderMaxZ * 16.0D);
        double d5 = (double)i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
        double d6 = (double)i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
		if (renderblocks.flipTexture) {
			double d7 = d3;
			d3 = d4;
			d4 = d7;
		}
		if (block.getBlockBoundsMinX() < 0.0D
				|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 =  0.0F;
			d4 =  15.99F;
		}
		if (block.getBlockBoundsMinY() < 0.0D
				|| block.getBlockBoundsMaxY() > 1.0D) {
			d5 =  0.0F;
			d6 =  15.99F;
		}
		double d8 = d + block.getBlockBoundsMinX();
		double d9 = d + block.getBlockBoundsMaxX();
		double d10 = d1 + block.getBlockBoundsMinY();
		double d11 = d1 + block.getBlockBoundsMaxY();
		double d12 = d2 + block.getBlockBoundsMaxZ();
		double d13 = d2 + block.getBlockBoundsMinZ();

		if (enableAO) {
			if (iDir == 0) {
				// Triangle Down pointing north
				tessellator.setColorOpaque_F(colorRedBottomLeft_WestFace,
						colorGreenBottomLeft_WestFace,
						colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d6);
				tessellator.setColorOpaque_F(colorRedBottomLeft_WestFace,
						colorGreenBottomLeft_WestFace,
						colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d6);
				tessellator.setColorOpaque_F(colorRedBottomRight_WestFace,
						colorGreenBottomRight_WestFace,
						colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9, d10, d12, d4, d6);
				tessellator
						.setColorOpaque_F(colorRedTopRight_WestFace,
								colorGreenTopRight_WestFace,
								colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9, d11, d12, d4, d5);
			} else if (iDir == 2) {
				// Triangle Down pointing south
				tessellator.setColorOpaque_F(colorRedTopLeft_WestFace,
						colorGreenTopLeft_WestFace, colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8, d11, d12, d3, d5);
				tessellator.setColorOpaque_F(colorRedBottomLeft_WestFace,
						colorGreenBottomLeft_WestFace,
						colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d6);
				tessellator.setColorOpaque_F(colorRedBottomRight_WestFace,
						colorGreenBottomRight_WestFace,
						colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9, d10, d12, d4, d6);
				tessellator.setColorOpaque_F(colorRedBottomRight_WestFace,
						colorGreenBottomRight_WestFace,
						colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9, d10, d12, d4, d6);
			}else if (iDir == 4) {
				// Triangle Up pointing north
				tessellator.setColorOpaque_F(colorRedTopLeft_WestFace,
						colorGreenTopLeft_WestFace, colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8, d11, d12, d3, d5);
				tessellator.setColorOpaque_F(colorRedTopLeft_WestFace,
						colorGreenTopLeft_WestFace, colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8, d11, d12, d3, d5);
				tessellator.setColorOpaque_F(colorRedBottomRight_WestFace,
						colorGreenBottomRight_WestFace,
						colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9, d10, d12, d4, d6);
				tessellator
						.setColorOpaque_F(colorRedTopRight_WestFace,
								colorGreenTopRight_WestFace,
								colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9, d11, d12, d4, d5);
			}else if (iDir == 6) {
				// Triangle Up pointing south
				tessellator.setColorOpaque_F(colorRedTopLeft_WestFace,
						colorGreenTopLeft_WestFace, colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8, d11, d12, d3, d5);
				tessellator.setColorOpaque_F(colorRedBottomLeft_WestFace,
						colorGreenBottomLeft_WestFace,
						colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d6);
				tessellator
						.setColorOpaque_F(colorRedTopRight_WestFace,
								colorGreenTopRight_WestFace,
								colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9, d11, d12, d4, d5);
				tessellator
						.setColorOpaque_F(colorRedTopRight_WestFace,
								colorGreenTopRight_WestFace,
								colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9, d11, d12, d4, d5);
			}  else if (iDir == 1) {
				// Slope facing Up - West - South
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYPos
						* (factorTop + factorWest + factorSouth) / 3F,
						colorGreenSlopes * aoLightValueYPos
								* (factorTop + factorWest + factorSouth) / 3F,
						colorBlueSlopes * aoLightValueYPos
								* (factorTop + factorWest + factorSouth) / 3F);
				tessellator.addVertexWithUV(d8, d11, d13, (d3 + d4) / 2.0F, d5);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueZPos
						* (factorTop + factorWest + factorSouth) / 3F,
						colorGreenSlopes * aoLightValueZPos
								* (factorTop + factorWest + factorSouth) / 3F,
						colorBlueSlopes * aoLightValueZPos
								* (factorTop + factorWest + factorSouth) / 3F);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d6);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueXPos
						* (factorTop + factorWest + factorSouth) / 3F,
						colorGreenSlopes * aoLightValueXPos
								* (factorTop + factorWest + factorSouth) / 3F,
						colorBlueSlopes * aoLightValueXPos
								* (factorTop + factorWest + factorSouth) / 3F);
				tessellator.addVertexWithUV(d9, d10, d13, d4, d6);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYPos
						* (factorTop + factorWest + factorSouth) / 3F,
						colorGreenSlopes * aoLightValueYPos
								* (factorTop + factorWest + factorSouth) / 3F,
						colorBlueSlopes * aoLightValueYPos
								* (factorTop + factorWest + factorSouth) / 3F);
				tessellator.addVertexWithUV(d8, d11, d13, (d3 + d4) / 2.0F, d5);
			} else if (iDir == 5) {
				// Slope facing Down - West - South
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueZPos
						* (factorBottom + factorWest + factorSouth) / 3F,
						colorGreenSlopes * aoLightValueZPos
								* (factorBottom + factorWest + factorSouth)
								/ 3F, colorBlueSlopes * aoLightValueZPos
								* (factorBottom + factorWest + factorSouth)
								/ 3F);
				tessellator.addVertexWithUV(d8, d11, d12, d3, d5);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYNeg
						* (factorBottom + factorWest + factorSouth) / 3F,
						colorGreenSlopes * aoLightValueYNeg
								* (factorBottom + factorWest + factorSouth)
								/ 3F, colorBlueSlopes * aoLightValueYNeg
								* (factorBottom + factorWest + factorSouth)
								/ 3F);
				tessellator.addVertexWithUV(d8, d10, d13, (d3 + d4) / 2.0F, d6);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYNeg
						* (factorBottom + factorWest + factorSouth) / 3F,
						colorGreenSlopes * aoLightValueYNeg
								* (factorBottom + factorWest + factorSouth)
								/ 3F, colorBlueSlopes * aoLightValueYNeg
								* (factorBottom + factorWest + factorSouth)
								/ 3F);
				tessellator.addVertexWithUV(d8, d10, d13, (d3 + d4) / 2.0F, d6);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueXPos
						* (factorBottom + factorWest + factorSouth) / 3F,
						colorGreenSlopes * aoLightValueXPos
								* (factorBottom + factorWest + factorSouth)
								/ 3F, colorBlueSlopes * aoLightValueXPos
								* (factorBottom + factorWest + factorSouth)
								/ 3F);
				tessellator.addVertexWithUV(d9, d11, d13, d4, d5);
			}
		} else {
			if (iDir == 0) {
				// Pointing 0, X = 1, Z = 1
				tessellator.addVertexWithUV(d9, d11, d12, d4, d5);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d6);
				tessellator.addVertexWithUV(d9, d10, d12, d4, d6);
				tessellator.addVertexWithUV(d9, d11, d12, d4, d5);
			}  else if (iDir == 2) {
				// Pointing 2, X = 0, Z = 1
				tessellator.addVertexWithUV(d8, d11, d12, d3, d5);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d6);
				tessellator.addVertexWithUV(d9, d10, d12, d4, d6);
				tessellator.addVertexWithUV(d8, d11, d12, d3, d5);
			} else if (iDir == 4 ) {
				// Pointing 0, X = 1, Z = 1
				tessellator.addVertexWithUV(d8, d11, d12, d3, d5);
				tessellator.addVertexWithUV(d9, d10, d12, d4, d6);
				tessellator.addVertexWithUV(d9, d10, d12, d4, d6);
				tessellator.addVertexWithUV(d9, d11, d12, d4, d5);
			}  else if (iDir == 6 ) {
				// Pointing 2, X = 0, Z = 1
				tessellator.addVertexWithUV(d8, d11, d12, d3, d5);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d6);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d6);
				tessellator.addVertexWithUV(d9, d11, d12, d4, d5);
			}  else if (iDir == 1) {
				// Pointing 1, X = 0, Z = 0, Sloped
				tessellator.addVertexWithUV(d8, d11, d13, (d3 + d4) / 2.0F, d5);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d6);
				tessellator.addVertexWithUV(d9, d10, d13, d4, d6);
				tessellator.addVertexWithUV(d8, d11, d13, (d3 + d4) / 2.0F, d5);
			} else if (iDir == 5) {
				// Pointing 1, X = 0, Z = 0, Sloped
				tessellator.addVertexWithUV(d8, d11, d12, d3, d5);
				tessellator.addVertexWithUV(d8, d10, d13, (d3 + d4) / 2.0F, d6);
				tessellator.addVertexWithUV(d8, d10, d13, (d3 + d4) / 2.0F, d6);
				tessellator.addVertexWithUV(d9, d11, d13, d4, d5);
			}
		}
	}

	public void renderCornersNorthFace(Block block, double d, double d1,
			double d2, Icon i, int iDir, RenderBlocks renderblocks,
			int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture())
        {
            i = renderblocks.overrideBlockTexture;
        }

        double d3 = (double)i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
        double d4 = (double)i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
        double d5 = (double)i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
        double d6 = (double)i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
		if (renderblocks.flipTexture) {
			double d7 = d3;
			d3 = d4;
			d4 = d7;
		}
		if (block.getBlockBoundsMinZ() < 0.0D
				|| block.getBlockBoundsMaxZ() > 1.0D) {
			d3 = 0.0F;
			d4 = 15.99F;
		}
		if (block.getBlockBoundsMinY() < 0.0D
				|| block.getBlockBoundsMaxY() > 1.0D) {
			d5 = 0.0F;
			d6 = 15.99F;
		}
		double d8 = d + block.getBlockBoundsMinX();
		double d9 = d1 + block.getBlockBoundsMinY();
		double d10 = d1 + block.getBlockBoundsMaxY();
		double d11 = d2 + block.getBlockBoundsMinZ();
		double d12 = d2 + block.getBlockBoundsMaxZ();
		double d13 = d + block.getBlockBoundsMaxX();

		if (enableAO) {
			if (iDir == 1) {
				// Triangle Down pointing west
				tessellator.setColorOpaque_F(colorRedTopRight_NorthFace,
						colorGreenTopRight_NorthFace,
						colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8, d9, d12, d4, d6);
				tessellator.setColorOpaque_F(colorRedBottomLeft_NorthFace,
						colorGreenBottomLeft_NorthFace,
						colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8, d10, d11, d3, d5);
				tessellator.setColorOpaque_F(colorRedBottomRight_NorthFace,
						colorGreenBottomRight_NorthFace,
						colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8, d9, d11, d3, d6);
				tessellator.setColorOpaque_F(colorRedTopRight_NorthFace,
						colorGreenTopRight_NorthFace,
						colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8, d9, d12, d4, d6);
			} else if (iDir == 2) {
				// Triangle Down pointing east
				tessellator
						.setColorOpaque_F(colorRedTopLeft_NorthFace,
								colorGreenTopLeft_NorthFace,
								colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8, d10, d12, d4, d5);
				tessellator.setColorOpaque_F(colorRedBottomRight_NorthFace,
						colorGreenBottomRight_NorthFace,
						colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8, d9, d11, d3, d6);
				tessellator.setColorOpaque_F(colorRedBottomRight_NorthFace,
						colorGreenBottomRight_NorthFace,
						colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8, d9, d11, d3, d6);
				tessellator.setColorOpaque_F(colorRedTopRight_NorthFace,
						colorGreenTopRight_NorthFace,
						colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8, d9, d12, d4, d6);
			} else if (iDir == 5) {
				// Triangle Up pointing west
				tessellator
						.setColorOpaque_F(colorRedTopLeft_NorthFace,
								colorGreenTopLeft_NorthFace,
								colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8, d10, d12, d4, d5);
				tessellator.setColorOpaque_F(colorRedBottomLeft_NorthFace,
						colorGreenBottomLeft_NorthFace,
						colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8, d10, d11, d3, d5);
				tessellator.setColorOpaque_F(colorRedBottomRight_NorthFace,
						colorGreenBottomRight_NorthFace,
						colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8, d9, d11, d3, d6);
				tessellator
						.setColorOpaque_F(colorRedTopLeft_NorthFace,
								colorGreenTopLeft_NorthFace,
								colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8, d10, d12, d4, d5);
			} else if (iDir == 6) {
				// Triangle Up pointing east
				tessellator
						.setColorOpaque_F(colorRedTopLeft_NorthFace,
								colorGreenTopLeft_NorthFace,
								colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8, d10, d12, d4, d5);
				tessellator.setColorOpaque_F(colorRedBottomLeft_NorthFace,
						colorGreenBottomLeft_NorthFace,
						colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8, d10, d11, d3, d5);
				tessellator.setColorOpaque_F(colorRedBottomLeft_NorthFace,
						colorGreenBottomLeft_NorthFace,
						colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8, d10, d11, d3, d5);
				tessellator.setColorOpaque_F(colorRedTopRight_NorthFace,
						colorGreenTopRight_NorthFace,
						colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8, d9, d12, d4, d6);
			} else if (iDir == 3) {
				// Slope facing Up - North - West
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYPos
						* (factorTop + factorWest + factorNorth) / 3F,
						colorGreenSlopes * aoLightValueYPos
								* (factorTop + factorWest + factorNorth) / 3F,
						colorBlueSlopes * aoLightValueYPos
								* (factorTop + factorWest + factorNorth) / 3F);
				tessellator
						.addVertexWithUV(d13, d10, d11, (d3 + d4) / 2.0F, d5);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYPos
						* (factorTop + factorWest + factorNorth) / 3F,
						colorGreenSlopes * aoLightValueYPos
								* (factorTop + factorWest + factorNorth) / 3F,
						colorBlueSlopes * aoLightValueYPos
								* (factorTop + factorWest + factorNorth) / 3F);
				tessellator
						.addVertexWithUV(d13, d10, d11, (d3 + d4) / 2.0F, d5);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueXNeg
						* (factorTop + factorWest + factorNorth) / 3F,
						colorGreenSlopes * aoLightValueXNeg
								* (factorTop + factorWest + factorNorth) / 3F,
						colorBlueSlopes * aoLightValueXNeg
								* (factorTop + factorWest + factorNorth) / 3F);
				tessellator.addVertexWithUV(d8, d9, d11, d3, d6);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueZPos
						* (factorTop + factorWest + factorNorth) / 3F,
						colorGreenSlopes * aoLightValueZPos
								* (factorTop + factorWest + factorNorth) / 3F,
						colorBlueSlopes * aoLightValueZPos
								* (factorTop + factorWest + factorNorth) / 3F);
				tessellator.addVertexWithUV(d13, d9, d12, d4, d6);
			} else if (iDir == 7) {
				// Slope facing Down - North - West
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueZPos
						* (factorBottom + factorWest + factorNorth) / 3F,
						colorGreenSlopes * aoLightValueZPos
								* (factorBottom + factorWest + factorNorth)
								/ 3F, colorBlueSlopes * aoLightValueZPos
								* (factorBottom + factorWest + factorNorth)
								/ 3F);
				tessellator.addVertexWithUV(d13, d10, d12, d4, d5);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueXNeg
						* (factorBottom + factorWest + factorNorth) / 3F,
						colorGreenSlopes * aoLightValueXNeg
								* (factorBottom + factorWest + factorNorth)
								/ 3F, colorBlueSlopes * aoLightValueXNeg
								* (factorBottom + factorWest + factorNorth)
								/ 3F);
				tessellator.addVertexWithUV(d8, d10, d11, d3, d5);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYNeg
						* (factorBottom + factorWest + factorNorth) / 3F,
						colorGreenSlopes * aoLightValueYNeg
								* (factorBottom + factorWest + factorNorth)
								/ 3F, colorBlueSlopes * aoLightValueYNeg
								* (factorBottom + factorWest + factorNorth)
								/ 3F);
				tessellator.addVertexWithUV(d13, d9, d11, (d3 + d4) / 2.0F, d6);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYNeg
						* (factorBottom + factorWest + factorNorth) / 3F,
						colorGreenSlopes * aoLightValueYNeg
								* (factorBottom + factorWest + factorNorth)
								/ 3F, colorBlueSlopes * aoLightValueYNeg
								* (factorBottom + factorWest + factorNorth)
								/ 3F);
				tessellator.addVertexWithUV(d13, d9, d11, (d3 + d4) / 2.0F, d6);
			}
		} else {
			if (iDir == 1) {
				// Pointing 1, X = 0, Z = 0
				tessellator.addVertexWithUV(d8, d10, d11, d3, d5);
				tessellator.addVertexWithUV(d8, d10, d11, d3, d5);
				tessellator.addVertexWithUV(d8, d9, d11, d3, d6);
				tessellator.addVertexWithUV(d8, d9, d12, d4, d6);
			} else if (iDir == 2) {
				// Pointing 2, X = 0, Z = 1
				tessellator.addVertexWithUV(d8, d10, d12, d4, d5);
				tessellator.addVertexWithUV(d8, d10, d12, d4, d5);
				tessellator.addVertexWithUV(d8, d9, d11, d3, d6);
				tessellator.addVertexWithUV(d8, d9, d12, d4, d6);
			}else if (iDir == 5) {
				// Pointing 1, X = 0, Z = 0
				tessellator.addVertexWithUV(d8, d10, d12, d4, d5);
				tessellator.addVertexWithUV(d8, d10, d11, d3, d5);
				tessellator.addVertexWithUV(d8, d9, d11, d3, d6);
				tessellator.addVertexWithUV(d8, d9, d11, d3, d6);
			} else if (iDir == 6) {
				// Pointing 2, X = 0, Z = 1
				tessellator.addVertexWithUV(d8, d10, d12, d4, d5);
				tessellator.addVertexWithUV(d8, d10, d11, d3, d5);
				tessellator.addVertexWithUV(d8, d9, d12, d4, d6);
				tessellator.addVertexWithUV(d8, d9, d12, d4, d6);
			} else if (iDir == 3) {
				// Pointing 3, X = 1, Z = 0, Sloped
				tessellator
						.addVertexWithUV(d13, d10, d11, (d3 + d4) / 2.0F, d5);
				tessellator
						.addVertexWithUV(d13, d10, d11, (d3 + d4) / 2.0F, d5);
				tessellator.addVertexWithUV(d8, d9, d11, d3, d6);
				tessellator.addVertexWithUV(d13, d9, d12, d4, d6);
			} else if (iDir == 7) {
				// Pointing 3, X = 1, Z = 0, Sloped
				tessellator.addVertexWithUV(d13, d10, d12, d4, d5);
				tessellator.addVertexWithUV(d8, d10, d11, d3, d5);
				tessellator.addVertexWithUV(d13, d9, d11, (d3 + d4) / 2.0F, d6);
				tessellator.addVertexWithUV(d13, d9, d11, (d3 + d4) / 2.0F, d6);
			}
		}
	}

	public void renderCornersSouthFace(Block block, double d, double d1,
			double d2, Icon i, int iDir, RenderBlocks renderblocks,
			int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture())
        {
            i = renderblocks.overrideBlockTexture;
        }

        double d3 = (double)i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
        double d4 = (double)i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
        double d5 = (double)i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
        double d6 = (double)i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
		if (renderblocks.flipTexture) {
			double d7 = d3;
			d3 = d4;
			d4 = d7;
		}
		if (block.getBlockBoundsMinZ() < 0.0D
				|| block.getBlockBoundsMaxZ() > 1.0D) {
			d3 = 0.0F;
			d4 =  15.99F;
		}
		if (block.getBlockBoundsMinY() < 0.0D
				|| block.getBlockBoundsMaxY() > 1.0D) {
			d5 = 0.0F;
			d6 = 15.99F;
		}
		double d8 = d + block.getBlockBoundsMaxX();
		double d9 = d1 + block.getBlockBoundsMinY();
		double d10 = d1 + block.getBlockBoundsMaxY();
		double d11 = d2 + block.getBlockBoundsMinZ();
		double d12 = d2 + block.getBlockBoundsMaxZ();
		double d13 = d + block.getBlockBoundsMinX();

		if (enableAO) {
			if (iDir == 0) {
				// Triangle Down pointing east
				tessellator
						.setColorOpaque_F(colorRedTopLeft_SouthFace,
								colorGreenTopLeft_SouthFace,
								colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8, d9, d12, d3, d6);
				tessellator.setColorOpaque_F(colorRedBottomLeft_SouthFace,
						colorGreenBottomLeft_SouthFace,
						colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.setColorOpaque_F(colorRedBottomLeft_SouthFace,
						colorGreenBottomLeft_SouthFace,
						colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.setColorOpaque_F(colorRedTopRight_SouthFace,
						colorGreenTopRight_SouthFace,
						colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d5);
			} else if (iDir == 3) {
				// Triangle Down pointing west
				tessellator
						.setColorOpaque_F(colorRedTopLeft_SouthFace,
								colorGreenTopLeft_SouthFace,
								colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8, d9, d12, d3, d6);
				tessellator.setColorOpaque_F(colorRedBottomLeft_SouthFace,
						colorGreenBottomLeft_SouthFace,
						colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.setColorOpaque_F(colorRedBottomRight_SouthFace,
						colorGreenBottomRight_SouthFace,
						colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8, d10, d11, d4, d5);
				tessellator
						.setColorOpaque_F(colorRedTopLeft_SouthFace,
								colorGreenTopLeft_SouthFace,
								colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8, d9, d12, d3, d6);
			} else if (iDir == 4) {
				// Triangle Up pointing east
				tessellator
						.setColorOpaque_F(colorRedTopLeft_SouthFace,
								colorGreenTopLeft_SouthFace,
								colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8, d9, d12, d3, d6);
				tessellator.setColorOpaque_F(colorRedBottomRight_SouthFace,
						colorGreenBottomRight_SouthFace,
						colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8, d10, d11, d4, d5);
				tessellator.setColorOpaque_F(colorRedBottomRight_SouthFace,
						colorGreenBottomRight_SouthFace,
						colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8, d10, d11, d4, d5);
				tessellator.setColorOpaque_F(colorRedTopRight_SouthFace,
						colorGreenTopRight_SouthFace,
						colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d5);
			}  else if (iDir == 7) {
				// Triangle Up pointing west
				tessellator.setColorOpaque_F(colorRedTopRight_SouthFace,
						colorGreenTopRight_SouthFace,
						colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d5);
				tessellator.setColorOpaque_F(colorRedBottomLeft_SouthFace,
						colorGreenBottomLeft_SouthFace,
						colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.setColorOpaque_F(colorRedBottomRight_SouthFace,
						colorGreenBottomRight_SouthFace,
						colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8, d10, d11, d4, d5);
				tessellator.setColorOpaque_F(colorRedTopRight_SouthFace,
						colorGreenTopRight_SouthFace,
						colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d5);
			} else if (iDir == 2) {
				// Slope facing Up - South - East
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueXPos
						* (factorTop + factorSouth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueXPos
								* (factorTop + factorSouth + factorEast) / 3F,
						colorBlueSlopes * aoLightValueXPos
								* (factorTop + factorSouth + factorEast) / 3F);
				tessellator.addVertexWithUV(d8, d9, d12, d3, d6);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueZNeg
						* (factorTop + factorSouth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueZNeg
								* (factorTop + factorSouth + factorEast) / 3F,
						colorBlueSlopes * aoLightValueZNeg
								* (factorTop + factorSouth + factorEast) / 3F);
				tessellator.addVertexWithUV(d13, d9, d11, d4, d6);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYPos
						* (factorTop + factorSouth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueYPos
								* (factorTop + factorSouth + factorEast) / 3F,
						colorBlueSlopes * aoLightValueYPos
								* (factorTop + factorSouth + factorEast) / 3F);
				tessellator
						.addVertexWithUV(d13, d10, d12, (d3 + d4) / 2.0F, d5);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYPos
						* (factorTop + factorSouth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueYPos
								* (factorTop + factorSouth + factorEast) / 3F,
						colorBlueSlopes * aoLightValueYPos
								* (factorTop + factorSouth + factorEast) / 3F);
				tessellator
						.addVertexWithUV(d13, d10, d12, (d3 + d4) / 2.0F, d5);
			} else if (iDir == 6) {
				// Slope facing Down - South - East
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYNeg
						* (factorBottom + factorSouth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueYNeg
								* (factorBottom + factorSouth + factorEast)
								/ 3F, colorBlueSlopes * aoLightValueYNeg
								* (factorBottom + factorSouth + factorEast)
								/ 3F);
				tessellator.addVertexWithUV(d13, d9, d12, (d3 + d4) / 2.0F, d6);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueYNeg
						* (factorBottom + factorSouth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueYNeg
								* (factorBottom + factorSouth + factorEast)
								/ 3F, colorBlueSlopes * aoLightValueYNeg
								* (factorBottom + factorSouth + factorEast)
								/ 3F);
				tessellator.addVertexWithUV(d13, d9, d12, (d3 + d4) / 2.0F, d6);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueZNeg
						* (factorBottom + factorSouth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueZNeg
								* (factorBottom + factorSouth + factorEast)
								/ 3F, colorBlueSlopes * aoLightValueZNeg
								* (factorBottom + factorSouth + factorEast)
								/ 3F);
				tessellator.addVertexWithUV(d13, d10, d11, d4, d5);
				tessellator.setColorOpaque_F(colorRedSlopes * aoLightValueXPos
						* (factorBottom + factorSouth + factorEast) / 3F,
						colorGreenSlopes * aoLightValueXPos
								* (factorBottom + factorSouth + factorEast)
								/ 3F, colorBlueSlopes * aoLightValueXPos
								* (factorBottom + factorSouth + factorEast)
								/ 3F);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d5);
			}
		} else {
			if (iDir == 0) {
				// Pointing 0, X = 1, Z = 1
				tessellator.addVertexWithUV(d8, d9, d12, d3, d6);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d5);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d5);
			} else if (iDir == 3) {
				// Pointing 3, X = 1, Z = 0
				tessellator.addVertexWithUV(d8, d9, d12, d3, d6);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.addVertexWithUV(d8, d10, d11, d4, d5);
				tessellator.addVertexWithUV(d8, d10, d11, d4, d5);
			} else if (iDir == 4) {
				// Pointing 0, X = 1, Z = 1
				tessellator.addVertexWithUV(d8, d9, d12, d3, d6);
				tessellator.addVertexWithUV(d8, d9, d12, d3, d6);
				tessellator.addVertexWithUV(d8, d10, d11, d4, d5);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d5);
			} else if (iDir == 7) {
				// Pointing 3, X = 1, Z = 0
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
				tessellator.addVertexWithUV(d8, d10, d11, d4, d5);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d5);
			} else if (iDir == 2) {
				// Pointing 2, X = 0, Z = 1, Sloped
				tessellator.addVertexWithUV(d8, d9, d12, d3, d6);
				tessellator.addVertexWithUV(d13, d9, d11, d4, d6);
				tessellator
						.addVertexWithUV(d13, d10, d12, (d3 + d4) / 2.0F, d5);
				tessellator
						.addVertexWithUV(d13, d10, d12, (d3 + d4) / 2.0F, d5);
			} else if (iDir == 6) {
				// Pointing 2, X = 0, Z = 1, Sloped
				tessellator.addVertexWithUV(d13, d9, d12, (d3 + d4) / 2.0F, d6);
				tessellator.addVertexWithUV(d13, d9, d12, (d3 + d4) / 2.0F, d6);
				tessellator.addVertexWithUV(d13, d10, d11, d4, d5);
				tessellator.addVertexWithUV(d8, d10, d12, d3, d5);
			}
		}
	}

	public static boolean field_27406_a = true;
	public static boolean field_27511_cfgGrassFix = true;
	public static boolean enableAO =false;
	public static float aoLightValueThis =0.0f;
	public static float aoLightValueXNeg=0.0f;
	public static float aoLightValueYNeg=0.0f;
	public static float aoLightValueZNeg=0.0f;
	public static float aoLightValueXPos=0.0f;
	public static float aoLightValueYPos=0.0f;
	public static float aoLightValueZPos=0.0f;
	public static float aoLightValueXNegYNegZNeg=0.0f;
	public static float aoLightValueXNegYNeg=0.0f;
	public static float aoLightValueXNegYNegZPos=0.0f;
	public static float aoLightValueYNegZNeg=0.0f;
	public static float aoLightValueYNegZPos=0.0f;
	public static float aoLightValueXPosYNegZNeg=0.0f;
	public static float aoLightValueXPosYNeg=0.0f;
	public static float aoLightValueXPosYNegZPos=0.0f;
	public static float aoLightValueXNegYPosZNeg= 0.0f;
	public static float aoLightValueXNegYPos= 0.0f;
	public static float aoLightValueXNegYPosZPos= 0.0f;
	public static float aoLightValueYPosZNeg= 0.0f;
	public static float aoLightValueXPosYPosZNeg= 0.0f;
	public static float aoLightValueXPosYPos= 0.0f;
	public static float aoLightValueYPosZPos= 0.0f;
	public static float aoLightValueXPosYPosZPos= 0.0f;
	public static float aoLightValueXNegZNeg= 0.0f;
	public static float aoLightValueXPosZNeg= 0.0f;
	public static float aoLightValueXNegZPos= 0.0f;
	public static float aoLightValueXPosZPos= 0.0f;
	public static int field_22352_G = 1;
	public static boolean isBlockYPosZNeg =false;
	public static boolean isBlockXPosYPos=false;
	public static boolean isBlockXNegYPos=false;
	public static boolean isBlockYPosZPos=false;
	public static boolean isBlockXNegZNeg=false;
	public static boolean isBlockXPosZPos=false;
	public static boolean isBlockXNegZPos=false;
	public static boolean isBlockXPosZNeg=false;
	public static boolean isBlockYNegZNeg=false;
	public static boolean isBlockXPosYNeg=false;
	public static boolean isBlockXNegYNeg=false;
	public static boolean isBlockYNegZPos=false;
	public static int field_27510_blockX;
	public static int field_27509_blockY;
	public static int field_27508_blockZ;

	public static float factorTop = 1.0F;
	public static float factorBottom = 0.5F;
	public static float factorEast = 0.8F;
	public static float factorWest = 0.8F;
	public static float factorNorth = 0.6F;
	public static float factorSouth = 0.6F;

	public static float colorRedTopLeft_TopFace=0.0f;
	public static float colorRedBottomLeft_TopFace=0.0f;
	public static float colorRedBottomRight_TopFace=0.0f;
	public static float colorRedTopRight_TopFace=0.0f;
	public static float colorGreenTopLeft_TopFace=0.0f;
	public static float colorGreenBottomLeft_TopFace=0.0f;
	public static float colorGreenBottomRight_TopFace=0.0f;
	public static float colorGreenTopRight_TopFace=0.0f;
	public static float colorBlueTopLeft_TopFace=0.0f;
	public static float colorBlueBottomLeft_TopFace=0.0f;
	public static float colorBlueBottomRight_TopFace=0.0f;
	public static float colorBlueTopRight_TopFace=0.0f;

	public static float colorRedTopLeft_BottomFace=0.0f;
	public static float colorRedBottomLeft_BottomFace=0.0f;
	public static float colorRedBottomRight_BottomFace=0.0f;
	public static float colorRedTopRight_BottomFace=0.0f;
	public static float colorGreenTopLeft_BottomFace=0.0f;
	public static float colorGreenBottomLeft_BottomFace=0.0f;
	public static float colorGreenBottomRight_BottomFace=0.0f;
	public static float colorGreenTopRight_BottomFace=0.0f;
	public static float colorBlueTopLeft_BottomFace=0.0f;
	public static float colorBlueBottomLeft_BottomFace=0.0f;
	public static float colorBlueBottomRight_BottomFace=0.0f;
	public static float colorBlueTopRight_BottomFace=0.0f;

	public static float colorRedTopLeft_EastFace=0.0f;
	public static float colorRedBottomLeft_EastFace=0.0f;
	public static float colorRedBottomRight_EastFace=0.0f;
	public static float colorRedTopRight_EastFace=0.0f;
	public static float colorGreenTopLeft_EastFace=0.0f;
	public static float colorGreenBottomLeft_EastFace=0.0f;
	public static float colorGreenBottomRight_EastFace=0.0f;
	public static float colorGreenTopRight_EastFace=0.0f;
	public static float colorBlueTopLeft_EastFace=0.0f;
	public static float colorBlueBottomLeft_EastFace=0.0f;
	public static float colorBlueBottomRight_EastFace=0.0f;
	public static float colorBlueTopRight_EastFace=0.0f;

	public static float colorRedTopLeft_WestFace=0.0f;
	public static float colorRedBottomLeft_WestFace=0.0f;
	public static float colorRedBottomRight_WestFace=0.0f;
	public static float colorRedTopRight_WestFace=0.0f;
	public static float colorGreenTopLeft_WestFace=0.0f;
	public static float colorGreenBottomLeft_WestFace=0.0f;
	public static float colorGreenBottomRight_WestFace=0.0f;
	public static float colorGreenTopRight_WestFace=0.0f;
	public static float colorBlueTopLeft_WestFace=0.0f;
	public static float colorBlueBottomLeft_WestFace=0.0f;
	public static float colorBlueBottomRight_WestFace=0.0f;
	public static float colorBlueTopRight_WestFace=0.0f;

	public static float colorRedTopLeft_NorthFace=0.0f;
	public static float colorRedBottomLeft_NorthFace=0.0f;
	public static float colorRedBottomRight_NorthFace=0.0f;
	public static float colorRedTopRight_NorthFace=0.0f;
	public static float colorGreenTopLeft_NorthFace=0.0f;
	public static float colorGreenBottomLeft_NorthFace=0.0f;
	public static float colorGreenBottomRight_NorthFace=0.0f;
	public static float colorGreenTopRight_NorthFace=0.0f;
	public static float colorBlueTopLeft_NorthFace=0.0f;
	public static float colorBlueBottomLeft_NorthFace=0.0f;
	public static float colorBlueBottomRight_NorthFace=0.0f;
	public static float colorBlueTopRight_NorthFace=0.0f;

	public static float colorRedTopLeft_SouthFace=0.0f;
	public static float colorRedBottomLeft_SouthFace=0.0f;
	public static float colorRedBottomRight_SouthFace=0.0f;
	public static float colorRedTopRight_SouthFace=0.0f;
	public static float colorGreenTopLeft_SouthFace=0.0f;
	public static float colorGreenBottomLeft_SouthFace=0.0f;
	public static float colorGreenBottomRight_SouthFace=0.0f;
	public static float colorGreenTopRight_SouthFace=0.0f;
	public static float colorBlueTopLeft_SouthFace=0.0f;
	public static float colorBlueBottomLeft_SouthFace=0.0f;
	public static float colorBlueBottomRight_SouthFace=0.0f;
	public static float colorBlueTopRight_SouthFace=0.0f;

	public static float colorRedSlopes= 0.0f;
	public static float colorGreenSlopes= 0.0f;
	public static float colorBlueSlopes= 0.0f;
	

}
