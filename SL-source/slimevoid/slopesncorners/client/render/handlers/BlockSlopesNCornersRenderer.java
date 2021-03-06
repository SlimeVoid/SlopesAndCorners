package slimevoid.slopesncorners.client.render.handlers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import slimevoid.materialslib.lib.MaterialsLib;
import slimevoid.slopesncorners.blocks.BlockSlopesBase;
import slimevoid.slopesncorners.tileentity.TileEntitySlopes;
import com.slimevoid.library.util.helpers.BlockHelper;

public class BlockSlopesNCornersRenderer extends BlockSlopesRendererBase {

	@Override
	public void renderInventoryBlock(Block block, int i, int modelID, RenderBlocks renderblocks) {
		Tessellator tessellator = Tessellator.instance;
		i = MaterialsLib.damageToMaterialValue(i);
		block.setBlockBounds(	0.0F,
								0.0F,
								0.0F,
								1.0F,
								1.0F,
								1.0F);
		renderblocks.setRenderBoundsFromBlock(block);

		GL11.glTranslatef(	-0.5F,
							-0.5F,
							-0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(	0.0F,
								-1F,
								0.0F);
		renderSlopesBottomFace(	block,
								0.0D,
								0.0D,
								0.0D,
								MaterialsLib.getIconForSide(i,
															0),
								3,
								renderblocks,
								-1);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(	0.0F,
								1.0F,
								0.0F);
		renderSlopesTopFace(block,
							0.0D,
							0.0D,
							0.0D,
							MaterialsLib.getIconForSide(i,
														1),
							3,
							renderblocks,
							-1);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(	0.0F,
								0.0F,
								-1F);
		renderSlopesEastFace(	block,
								0.0D,
								0.0D,
								0.0D,
								MaterialsLib.getIconForSide(i,
															2),
								3,
								renderblocks,
								-1);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(	0.0F,
								0.0F,
								1.0F);
		renderSlopesWestFace(	block,
								0.0D,
								0.0D,
								0.0D,
								MaterialsLib.getIconForSide(i,
															3),
								3,
								renderblocks,
								-1);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(	-1F,
								0.0F,
								0.0F);
		renderSlopesNorthFace(	block,
								0.0D,
								0.0D,
								0.0D,
								MaterialsLib.getIconForSide(i,
															4),
								3,
								renderblocks,
								-1);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(	1.0F,
								0.0F,
								0.0F);
		renderSlopesSouthFace(	block,
								0.0D,
								0.0D,
								0.0D,
								MaterialsLib.getIconForSide(i,
															5),
								3,
								renderblocks,
								-1);
		tessellator.draw();
		GL11.glTranslatef(	0.5F,
							0.5F,
							0.5F);

		block.setBlockBounds(	0.0F,
								0.0F,
								0.0F,
								1.0F,
								1.0F,
								1.0F);
		renderblocks.setRenderBoundsFromBlock(block);
	}

	@Override
	protected boolean renderCustomBlockBlockWithColorMultiplier(Block block, int x, int y, int z, float f, float f1, float f2, int iDir, int model, RenderBlocks renderer, IBlockAccess world) {
		TileEntitySlopes tileentity = (TileEntitySlopes) BlockHelper.getTileEntity(	world,
																					x,
																					y,
																					z,
																					((BlockSlopesBase) block).getTileMapData(model));
		if (tileentity != null) {
			if (tileentity.GetCorneriDir() > -1) {
				return renderCornersBlockWithColorMultiplier(	block,
																x,
																y,
																z,
																f,
																f1,
																f2,
																tileentity.GetCorneriDir(),
																renderer,
																world);
			} else if (tileentity.GetIntCorneriDir() > -1) {
				return renderIntCornersBlockWithColorMultiplier(block,
																x,
																y,
																z,
																f,
																f1,
																f2,
																tileentity.GetIntCorneriDir(),
																renderer,
																world);
			} else {
				return renderSlopesBlockWithColorMultiplier(block,
															x,
															y,
															z,
															f,
															f1,
															f2,
															iDir,
															renderer,
															world);
			}
		}
		return false;
	}

	@Override
	protected boolean renderCustomBlockWithAmbientOcclusion(Block block, int x, int y, int z, float f, float f1, float f2, int iDir, int model, RenderBlocks renderer, IBlockAccess world) {
		TileEntitySlopes tileentity = (TileEntitySlopes) BlockHelper.getTileEntity(	world,
																					x,
																					y,
																					z,
																					((BlockSlopesBase) block).getTileMapData(model));
		if (tileentity != null) {
			if (tileentity.GetCorneriDir() > -1) {
				return renderCornersBlockWithAmbientOcclusion(	block,
																x,
																y,
																z,
																f,
																f1,
																f2,
																tileentity.GetCorneriDir(),
																renderer,
																world);
			} else if (tileentity.GetIntCorneriDir() > -1) {
				return renderIntCornersBlockWithAmbientOcclusion(	block,
																	x,
																	y,
																	z,
																	f,
																	f1,
																	f2,
																	tileentity.GetIntCorneriDir(),
																	renderer,
																	world);
			} else {
				return renderSlopesBlockWithAmbientOcclusion(	block,
																x,
																y,
																z,
																f,
																f1,
																f2,
																iDir,
																renderer,
																world);
			}
		}
		return false;
	}

	public boolean renderSlopesBlockWithAmbientOcclusion(Block block, int i, int j, int k, float f, float f1, float f2, int iDir, RenderBlocks renderblocks, IBlockAccess iblockaccess) {
		enableAO = true;
		boolean flag = false;
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = true;
		boolean flag4 = true;
		boolean flag5 = true;
		boolean flag6 = true;

		aoLightValueThis = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j,
																k);
		aoLightValueXNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																i - 1,
																j,
																k);
		aoLightValueYNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j - 1,
																k);
		aoLightValueZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j,
																k - 1);
		aoLightValueXPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																i + 1,
																j,
																k);
		aoLightValueYPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j + 1,
																k);
		aoLightValueZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j,
																k + 1);

		aoLightValueXPosYPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i + 1,
																	j + 1,
																	k);
		aoLightValueXPosYNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i + 1,
																	j - 1,
																	k);
		aoLightValueXPosZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i + 1,
																	j,
																	k + 1);
		aoLightValueXPosZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i + 1,
																	j,
																	k - 1);
		aoLightValueXNegYPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i - 1,
																	j + 1,
																	k);
		aoLightValueXNegYNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i - 1,
																	j - 1,
																	k);
		aoLightValueXNegZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i - 1,
																	j,
																	k - 1);
		aoLightValueXNegZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i - 1,
																	j,
																	k + 1);
		aoLightValueYPosZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i,
																	j + 1,
																	k + 1);
		aoLightValueYPosZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i,
																	j + 1,
																	k - 1);
		aoLightValueYNegZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i,
																	j - 1,
																	k + 1);
		aoLightValueYNegZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i,
																	j - 1,
																	k - 1);

		aoLightValueXPosYPosZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i + 1,
																		j + 1,
																		k + 1);
		aoLightValueXPosYNegZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i + 1,
																		j - 1,
																		k + 1);
		aoLightValueXPosYPosZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i + 1,
																		j + 1,
																		k - 1);
		aoLightValueXPosYNegZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i + 1,
																		j - 1,
																		k - 1);
		aoLightValueXNegYPosZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i - 1,
																		j + 1,
																		k + 1);
		aoLightValueXNegYNegZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i - 1,
																		j - 1,
																		k + 1);
		aoLightValueXNegYPosZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i - 1,
																		j + 1,
																		k - 1);
		aoLightValueXNegYNegZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i - 1,
																		j - 1,
																		k - 1);

		if (renderblocks.getBlockIcon(block).getIconName().equals("grass_top")) {
			flag1 = false;
		} else if (renderblocks.hasOverrideBlockTexture()) {
			flag1 = false;
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
		colorRedTopLeft_BottomFace = colorRedBottomLeft_BottomFace = colorRedBottomRight_BottomFace = colorRedTopRight_BottomFace = (flag1 ? f : 1.0F) * 0.5F;
		colorGreenTopLeft_BottomFace = colorGreenBottomLeft_BottomFace = colorGreenBottomRight_BottomFace = colorGreenTopRight_BottomFace = (flag1 ? f1 : 1.0F) * 0.5F;
		colorBlueTopLeft_BottomFace = colorBlueBottomLeft_BottomFace = colorBlueBottomRight_BottomFace = colorBlueTopRight_BottomFace = (flag1 ? f2 : 1.0F) * 0.5F;
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
		colorRedTopLeft_TopFace = colorRedBottomLeft_TopFace = colorRedBottomRight_TopFace = colorRedTopRight_TopFace = flag2 ? f : 1.0F;
		colorGreenTopLeft_TopFace = colorGreenBottomLeft_TopFace = colorGreenBottomRight_TopFace = colorGreenTopRight_TopFace = flag2 ? f1 : 1.0F;
		colorBlueTopLeft_TopFace = colorBlueBottomLeft_TopFace = colorBlueBottomRight_TopFace = colorBlueTopRight_TopFace = flag2 ? f2 : 1.0F;
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
		colorRedTopLeft_EastFace = colorRedBottomLeft_EastFace = colorRedBottomRight_EastFace = colorRedTopRight_EastFace = (flag3 ? f : 1.0F) * 0.8F;
		colorGreenTopLeft_EastFace = colorGreenBottomLeft_EastFace = colorGreenBottomRight_EastFace = colorGreenTopRight_EastFace = (flag3 ? f1 : 1.0F) * 0.8F;
		colorBlueTopLeft_EastFace = colorBlueBottomLeft_EastFace = colorBlueBottomRight_EastFace = colorBlueTopRight_EastFace = (flag3 ? f2 : 1.0F) * 0.8F;
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
		Icon l = block.getBlockTexture(	iblockaccess,
										i,
										j,
										k,
										2);

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
		colorRedTopLeft_WestFace = colorRedBottomLeft_WestFace = colorRedBottomRight_WestFace = colorRedTopRight_WestFace = (flag4 ? f : 1.0F) * 0.8F;
		colorGreenTopLeft_WestFace = colorGreenBottomLeft_WestFace = colorGreenBottomRight_WestFace = colorGreenTopRight_WestFace = (flag4 ? f1 : 1.0F) * 0.8F;
		colorBlueTopLeft_WestFace = colorBlueBottomLeft_WestFace = colorBlueBottomRight_WestFace = colorBlueTopRight_WestFace = (flag4 ? f2 : 1.0F) * 0.8F;
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
		Icon i1 = block.getBlockTexture(iblockaccess,
										i,
										j,
										k,
										3);

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
		colorRedTopLeft_NorthFace = colorRedBottomLeft_NorthFace = colorRedBottomRight_NorthFace = colorRedTopRight_NorthFace = (flag5 ? f : 1.0F) * 0.6F;
		colorGreenTopLeft_NorthFace = colorGreenBottomLeft_NorthFace = colorGreenBottomRight_NorthFace = colorGreenTopRight_NorthFace = (flag5 ? f1 : 1.0F) * 0.6F;
		colorBlueTopLeft_NorthFace = colorBlueBottomLeft_NorthFace = colorBlueBottomRight_NorthFace = colorBlueTopRight_NorthFace = (flag5 ? f2 : 1.0F) * 0.6F;
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
		Icon j1 = block.getBlockTexture(iblockaccess,
										i,
										j,
										k,
										4);

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
		colorRedTopLeft_SouthFace = colorRedBottomLeft_SouthFace = colorRedBottomRight_SouthFace = colorRedTopRight_SouthFace = (flag6 ? f : 1.0F) * 0.6F;
		colorGreenTopLeft_SouthFace = colorGreenBottomLeft_SouthFace = colorGreenBottomRight_SouthFace = colorGreenTopRight_SouthFace = (flag6 ? f1 : 1.0F) * 0.6F;
		colorBlueTopLeft_SouthFace = colorBlueBottomLeft_SouthFace = colorBlueBottomRight_SouthFace = colorBlueTopRight_SouthFace = (flag6 ? f2 : 1.0F) * 0.6F;
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
		Icon k1 = block.getBlockTexture(iblockaccess,
										i,
										j,
										k,
										5);

		// ///////////////////////////////////////SUPERSLOPES//////////////////////////////

		colorRedSlopes = f;
		colorGreenSlopes = f1;
		colorBlueSlopes = f2;

		// ///////////////////////////////////////

		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j - 1,
											k,
											0)) {
			renderSlopesBottomFace(	block,
									i,
									j,
									k,
									block.getBlockTexture(	iblockaccess,
															i,
															j,
															k,
															0),
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j + 1,
											k,
											1)) {
			renderSlopesTopFace(block,
								i,
								j,
								k,
								block.getBlockTexture(	iblockaccess,
														i,
														j,
														k,
														1),
								iDir,
								renderblocks,
								block.getMixedBrightnessForBlock(	iblockaccess,
																	i,
																	j,
																	k));
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j,
											k - 1,
											2)) {
			renderSlopesEastFace(	block,
									i,
									j,
									k,
									l,
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			if (renderblocks.fancyGrass && l.getIconName().equals("grass_side")
				&& !renderblocks.hasOverrideBlockTexture()) {
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
				renderSlopesEastFace(	block,
										i,
										j,
										k,
										BlockGrass.getIconSideOverlay(),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j,
											k + 1,
											3)) {
			renderSlopesWestFace(	block,
									i,
									j,
									k,
									i1,
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			if (renderblocks.fancyGrass
				&& i1.getIconName().equals("grass_side")
				&& !renderblocks.hasOverrideBlockTexture()) {
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
				renderSlopesWestFace(	block,
										i,
										j,
										k,
										BlockGrass.getIconSideOverlay(),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i - 1,
											j,
											k,
											4)) {
			renderSlopesNorthFace(	block,
									i,
									j,
									k,
									j1,
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			if (renderblocks.fancyGrass
				&& j1.getIconName().equals("grass_side")
				&& !renderblocks.hasOverrideBlockTexture()) {
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
				renderSlopesNorthFace(	block,
										i,
										j,
										k,
										BlockGrass.getIconSideOverlay(),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i + 1,
											j,
											k,
											5)) {
			renderSlopesSouthFace(	block,
									i,
									j,
									k,
									k1,
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			if (renderblocks.fancyGrass
				&& k1.getIconName().equals("grass_side")
				&& !renderblocks.hasOverrideBlockTexture()) {
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
				renderSlopesSouthFace(	block,
										i,
										j,
										k,
										BlockGrass.getIconSideOverlay(),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			}
			flag = true;
		}

		enableAO = false;
		return flag;
	}

	public boolean renderSlopesBlockWithColorMultiplier(Block block, int i, int j, int k, float f, float f1, float f2, int iDir, RenderBlocks renderblocks, IBlockAccess iblockaccess) {
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
		float f19 = block.getAmbientOcclusionLightValue(iblockaccess,
														i,
														j,
														k);

		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j - 1,
											k,
											0)) {
			if (iDir / 4 != 2) {
				float f20 = block.getAmbientOcclusionLightValue(iblockaccess,
																i,
																j - 1,
																k);
				tessellator.setColorOpaque_F(	f10 * f20,
												f13 * f20,
												f16 * f20);
				renderSlopesBottomFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																0),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
				flag = true;
			}
		}

		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j + 1,
											k,
											1)) {

			float f21 = block.getAmbientOcclusionLightValue(iblockaccess,
															i,
															j + 1,
															k);
			if (block.getBlockBoundsMaxY() != 1.0D
				&& !block.blockMaterial.isLiquid()) {
				f21 = f19;
			}
			tessellator.setColorOpaque_F(	f7 * f21,
											f8 * f21,
											f9 * f21);
			renderSlopesTopFace(block,
								i,
								j,
								k,
								block.getBlockTexture(	iblockaccess,
														i,
														j,
														k,
														1),
								iDir,
								renderblocks,
								block.getMixedBrightnessForBlock(	iblockaccess,
																	i,
																	j,
																	k));
			flag = true;

		}

		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j,
											k - 1,
											2) || iDir == 6 || iDir == 10
			|| iDir == 12) {
			if (iDir == 6) {
				float f22 = f19;
				tessellator.setColorOpaque_F(	f11 * f22,
												f14 * f22,
												f17 * f22);
				renderSlopesEastFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																1),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			} else if (iDir == 10) {
				float f22 = f19;
				tessellator.setColorOpaque_F(	f11 * f22,
												f14 * f22,
												f17 * f22);
				renderSlopesEastFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																0),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			} else if (iDir == 12) {
				float f22 = f19;
				tessellator.setColorOpaque_F(	f11 * f22,
												f14 * f22,
												f17 * f22);
				renderSlopesEastFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																2),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			} else {
				float f22 = block.getAmbientOcclusionLightValue(iblockaccess,
																i,
																j,
																k - 1);
				tessellator.setColorOpaque_F(	f11 * f22,
												f14 * f22,
												f17 * f22);
				renderSlopesEastFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																2),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j,
											k + 1,
											3) || iDir == 7 || iDir == 11
			|| iDir == 13) {
			if (iDir == 7) {
				float f23 = f19;
				tessellator.setColorOpaque_F(	f11 * f23,
												f14 * f23,
												f17 * f23);
				renderSlopesWestFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																1),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			} else if (iDir == 11) {
				float f23 = f19;
				tessellator.setColorOpaque_F(	f11 * f23,
												f14 * f23,
												f17 * f23);
				renderSlopesWestFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																0),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			} else if (iDir == 13) {
				float f23 = f19;
				tessellator.setColorOpaque_F(	f11 * f23,
												f14 * f23,
												f17 * f23);
				renderSlopesWestFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																3),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			} else {
				float f23 = block.getAmbientOcclusionLightValue(iblockaccess,
																i,
																j,
																k + 1);
				tessellator.setColorOpaque_F(	f11 * f23,
												f14 * f23,
												f17 * f23);
				renderSlopesWestFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																3),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i - 1,
											j,
											k,
											4) || iDir == 4 || iDir == 8
			|| iDir == 15) {
			if (iDir == 4) {
				float f24 = f19;
				tessellator.setColorOpaque_F(	f12 * f24,
												f15 * f24,
												f18 * f24);
				renderSlopesNorthFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																1),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			} else if (iDir == 8) {
				float f24 = f19;
				tessellator.setColorOpaque_F(	f12 * f24,
												f15 * f24,
												f18 * f24);
				renderSlopesNorthFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																0),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			} else if (iDir == 15) {
				float f24 = f19;
				tessellator.setColorOpaque_F(	f12 * f24,
												f15 * f24,
												f18 * f24);
				renderSlopesNorthFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																4),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			} else {
				float f24 = block.getAmbientOcclusionLightValue(iblockaccess,
																i - 1,
																j,
																k);
				tessellator.setColorOpaque_F(	f12 * f24,
												f15 * f24,
												f18 * f24);
				renderSlopesNorthFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																4),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i + 1,
											j,
											k,
											5) || iDir == 5 || iDir == 9
			|| iDir == 14) {
			if (iDir == 5) {
				float f25 = f19;
				tessellator.setColorOpaque_F(	f12 * f25,
												f15 * f25,
												f18 * f25);
				renderSlopesSouthFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																1),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			} else if (iDir == 9) {
				float f25 = f19;
				tessellator.setColorOpaque_F(	f12 * f25,
												f15 * f25,
												f18 * f25);
				renderSlopesSouthFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																0),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			} else if (iDir == 14) {
				float f25 = f19;
				tessellator.setColorOpaque_F(	f12 * f25,
												f15 * f25,
												f18 * f25);
				renderSlopesSouthFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																5),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			} else {
				float f25 = block.getAmbientOcclusionLightValue(iblockaccess,
																i + 1,
																j,
																k);
				tessellator.setColorOpaque_F(	f12 * f25,
												f15 * f25,
												f18 * f25);
				renderSlopesSouthFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																5),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			}
			flag = true;
		}
		return flag;
	}

	public boolean renderCornersBlockWithAmbientOcclusion(Block block, int i, int j, int k, float f, float f1, float f2, int iDir, RenderBlocks renderblocks, IBlockAccess iblockaccess) {
		enableAO = true;
		boolean flag = false;
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = true;
		boolean flag4 = true;
		boolean flag5 = true;
		boolean flag6 = true;

		aoLightValueThis = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j,
																k);
		aoLightValueXNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																i - 1,
																j,
																k);
		aoLightValueYNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j - 1,
																k);
		aoLightValueZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j,
																k - 1);
		aoLightValueXPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																i + 1,
																j,
																k);
		aoLightValueYPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j + 1,
																k);
		aoLightValueZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j,
																k + 1);

		aoLightValueXPosYPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i + 1,
																	j + 1,
																	k);
		aoLightValueXPosYNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i + 1,
																	j - 1,
																	k);
		aoLightValueXPosZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i + 1,
																	j,
																	k + 1);
		aoLightValueXPosZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i + 1,
																	j,
																	k - 1);
		aoLightValueXNegYPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i - 1,
																	j + 1,
																	k);
		aoLightValueXNegYNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i - 1,
																	j - 1,
																	k);
		aoLightValueXNegZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i - 1,
																	j,
																	k - 1);
		aoLightValueXNegZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i - 1,
																	j,
																	k + 1);
		aoLightValueYPosZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i,
																	j + 1,
																	k + 1);
		aoLightValueYPosZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i,
																	j + 1,
																	k - 1);
		aoLightValueYNegZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i,
																	j - 1,
																	k + 1);
		aoLightValueYNegZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i,
																	j - 1,
																	k - 1);

		aoLightValueXPosYPosZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i + 1,
																		j + 1,
																		k + 1);
		aoLightValueXPosYNegZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i + 1,
																		j - 1,
																		k + 1);
		aoLightValueXPosYPosZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i + 1,
																		j + 1,
																		k - 1);
		aoLightValueXPosYNegZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i + 1,
																		j - 1,
																		k - 1);
		aoLightValueXNegYPosZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i - 1,
																		j + 1,
																		k + 1);
		aoLightValueXNegYNegZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i - 1,
																		j - 1,
																		k + 1);
		aoLightValueXNegYPosZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i - 1,
																		j + 1,
																		k - 1);
		aoLightValueXNegYNegZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i - 1,
																		j - 1,
																		k - 1);

		if (block.getBlockTexture(	iblockaccess,
									i,
									j,
									k,
									0) == Block.dirt.getBlockTextureFromSide(0)) {
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
		colorRedTopLeft_BottomFace = colorRedBottomLeft_BottomFace = colorRedBottomRight_BottomFace = colorRedTopRight_BottomFace = (flag1 ? f : 1.0F) * 0.5F;
		colorGreenTopLeft_BottomFace = colorGreenBottomLeft_BottomFace = colorGreenBottomRight_BottomFace = colorGreenTopRight_BottomFace = (flag1 ? f1 : 1.0F) * 0.5F;
		colorBlueTopLeft_BottomFace = colorBlueBottomLeft_BottomFace = colorBlueBottomRight_BottomFace = colorBlueTopRight_BottomFace = (flag1 ? f2 : 1.0F) * 0.5F;
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
		colorRedTopLeft_TopFace = colorRedBottomLeft_TopFace = colorRedBottomRight_TopFace = colorRedTopRight_TopFace = flag2 ? f : 1.0F;
		colorGreenTopLeft_TopFace = colorGreenBottomLeft_TopFace = colorGreenBottomRight_TopFace = colorGreenTopRight_TopFace = flag2 ? f1 : 1.0F;
		colorBlueTopLeft_TopFace = colorBlueBottomLeft_TopFace = colorBlueBottomRight_TopFace = colorBlueTopRight_TopFace = flag2 ? f2 : 1.0F;
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
		colorRedTopLeft_EastFace = colorRedBottomLeft_EastFace = colorRedBottomRight_EastFace = colorRedTopRight_EastFace = (flag3 ? f : 1.0F) * 0.8F;
		colorGreenTopLeft_EastFace = colorGreenBottomLeft_EastFace = colorGreenBottomRight_EastFace = colorGreenTopRight_EastFace = (flag3 ? f1 : 1.0F) * 0.8F;
		colorBlueTopLeft_EastFace = colorBlueBottomLeft_EastFace = colorBlueBottomRight_EastFace = colorBlueTopRight_EastFace = (flag3 ? f2 : 1.0F) * 0.8F;
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
		Icon l = block.getBlockTexture(	iblockaccess,
										i,
										j,
										k,
										2);

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
		colorRedTopLeft_WestFace = colorRedBottomLeft_WestFace = colorRedBottomRight_WestFace = colorRedTopRight_WestFace = (flag4 ? f : 1.0F) * 0.8F;
		colorGreenTopLeft_WestFace = colorGreenBottomLeft_WestFace = colorGreenBottomRight_WestFace = colorGreenTopRight_WestFace = (flag4 ? f1 : 1.0F) * 0.8F;
		colorBlueTopLeft_WestFace = colorBlueBottomLeft_WestFace = colorBlueBottomRight_WestFace = colorBlueTopRight_WestFace = (flag4 ? f2 : 1.0F) * 0.8F;
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
		Icon i1 = block.getBlockTexture(iblockaccess,
										i,
										j,
										k,
										3);

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
		colorRedTopLeft_NorthFace = colorRedBottomLeft_NorthFace = colorRedBottomRight_NorthFace = colorRedTopRight_NorthFace = (flag5 ? f : 1.0F) * 0.6F;
		colorGreenTopLeft_NorthFace = colorGreenBottomLeft_NorthFace = colorGreenBottomRight_NorthFace = colorGreenTopRight_NorthFace = (flag5 ? f1 : 1.0F) * 0.6F;
		colorBlueTopLeft_NorthFace = colorBlueBottomLeft_NorthFace = colorBlueBottomRight_NorthFace = colorBlueTopRight_NorthFace = (flag5 ? f2 : 1.0F) * 0.6F;
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
		Icon j1 = block.getBlockTexture(iblockaccess,
										i,
										j,
										k,
										4);

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
		colorRedTopLeft_SouthFace = colorRedBottomLeft_SouthFace = colorRedBottomRight_SouthFace = colorRedTopRight_SouthFace = (flag6 ? f : 1.0F) * 0.6F;
		colorGreenTopLeft_SouthFace = colorGreenBottomLeft_SouthFace = colorGreenBottomRight_SouthFace = colorGreenTopRight_SouthFace = (flag6 ? f1 : 1.0F) * 0.6F;
		colorBlueTopLeft_SouthFace = colorBlueBottomLeft_SouthFace = colorBlueBottomRight_SouthFace = colorBlueTopRight_SouthFace = (flag6 ? f2 : 1.0F) * 0.6F;
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
		Icon k1 = block.getBlockTexture(iblockaccess,
										i,
										j,
										k,
										5);

		// ///////////////////////////////////////SUPERSLOPES//////////////////////////////

		colorRedSlopes = f;
		colorGreenSlopes = f1;
		colorBlueSlopes = f2;

		// ///////////////////////////////////////

		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j - 1,
											k,
											0)) {
			renderCornersBottomFace(block,
									i,
									j,
									k,
									block.getBlockTexture(	iblockaccess,
															i,
															j,
															k,
															0),
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j + 1,
											k,
											1)) {
			renderCornersTopFace(	block,
									i,
									j,
									k,
									block.getBlockTexture(	iblockaccess,
															i,
															j,
															k,
															1),
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j,
											k - 1,
											2)) {
			renderCornersEastFace(	block,
									i,
									j,
									k,
									l,
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			if (renderblocks.fancyGrass && l.getIconName().equals("grass_side")
				&& !renderblocks.hasOverrideBlockTexture()) {
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
				renderCornersEastFace(	block,
										i,
										j,
										k,
										BlockGrass.getIconSideOverlay(),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j,
											k + 1,
											3)) {
			renderCornersWestFace(	block,
									i,
									j,
									k,
									i1,
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			if (renderblocks.fancyGrass
				&& i1.getIconName().equals("grass_side")
				&& !renderblocks.hasOverrideBlockTexture()) {
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
				renderCornersWestFace(	block,
										i,
										j,
										k,
										BlockGrass.getIconSideOverlay(),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i - 1,
											j,
											k,
											4)) {
			renderCornersNorthFace(	block,
									i,
									j,
									k,
									j1,
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			if (renderblocks.fancyGrass
				&& j1.getIconName().equals("grass_side")
				&& !renderblocks.hasOverrideBlockTexture()) {
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
				renderCornersNorthFace(	block,
										i,
										j,
										k,
										BlockGrass.getIconSideOverlay(),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i + 1,
											j,
											k,
											5)) {
			renderCornersSouthFace(	block,
									i,
									j,
									k,
									k1,
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			if (renderblocks.fancyGrass
				&& k1.getIconName().equals("grass_side")
				&& !renderblocks.hasOverrideBlockTexture()) {
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
				renderCornersSouthFace(	block,
										i,
										j,
										k,
										BlockGrass.getIconSideOverlay(),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			}
			flag = true;
		}

		enableAO = false;
		return flag;
	}

	public boolean renderCornersBlockWithColorMultiplier(Block block, int i, int j, int k, float f, float f1, float f2, int iDir, RenderBlocks renderblocks, IBlockAccess iblockaccess) {
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
		float f19 = block.getAmbientOcclusionLightValue(iblockaccess,
														i,
														j,
														k);

		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j - 1,
											k,
											0)) {
			if (iDir / 4 != 1 && iDir / 4 != 3) {
				float f20 = block.getAmbientOcclusionLightValue(iblockaccess,
																i,
																j - 1,
																k);
				tessellator.setColorOpaque_F(	f10 * f20,
												f13 * f20,
												f16 * f20);
				renderCornersBottomFace(block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																0),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
				flag = true;
			}
		}

		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j + 1,
											k,
											1)) {

			float f21 = block.getAmbientOcclusionLightValue(iblockaccess,
															i,
															j + 1,
															k);
			if (block.getBlockBoundsMaxY() != 1.0D
				&& !block.blockMaterial.isLiquid()) {
				f21 = f19;
			}
			tessellator.setColorOpaque_F(	f7 * f21,
											f8 * f21,
											f9 * f21);
			renderCornersTopFace(	block,
									i,
									j,
									k,
									block.getBlockTexture(	iblockaccess,
															i,
															j,
															k,
															1),
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			flag = true;

		}

		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j,
											k - 1,
											2) || iDir % 2 == 0) {
			float f22 = block.getAmbientOcclusionLightValue(iblockaccess,
															i,
															j,
															k - 1);
			if (iDir % 2 == 0) {
				f22 = f19;
			}
			tessellator.setColorOpaque_F(	f11 * f22,
											f14 * f22,
											f17 * f22);
			renderCornersEastFace(	block,
									i,
									j,
									k,
									block.getBlockTexture(	iblockaccess,
															i,
															j,
															k,
															2),
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));

			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j,
											k + 1,
											3) || iDir % 2 == 1) {
			float f23 = block.getAmbientOcclusionLightValue(iblockaccess,
															i,
															j,
															k + 1);
			if (iDir % 2 == 1) {
				f23 = f19;
			}
			tessellator.setColorOpaque_F(	f11 * f23,
											f14 * f23,
											f17 * f23);
			renderCornersWestFace(	block,
									i,
									j,
									k,
									block.getBlockTexture(	iblockaccess,
															i,
															j,
															k,
															3),
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i - 1,
											j,
											k,
											4) || iDir == 0 || iDir == 3
			|| iDir == 4 || iDir == 7 || iDir == 11 || iDir == 15) {
			float f24 = block.getAmbientOcclusionLightValue(iblockaccess,
															i - 1,
															j,
															k);
			if (iDir == 0 || iDir == 3 || iDir == 4 || iDir == 7 || iDir == 11
				|| iDir == 15) {
				f24 = f19;
			}
			tessellator.setColorOpaque_F(	f12 * f24,
											f15 * f24,
											f18 * f24);
			renderCornersNorthFace(	block,
									i,
									j,
									k,
									block.getBlockTexture(	iblockaccess,
															i,
															j,
															k,
															4),
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i + 1,
											j,
											k,
											5) || iDir == 1 || iDir == 2
			|| iDir == 5 || iDir == 6 || iDir == 10 || iDir == 14) {
			float f25 = block.getAmbientOcclusionLightValue(iblockaccess,
															i + 1,
															j,
															k);
			if (iDir == 1 || iDir == 2 || iDir == 5 || iDir == 6 || iDir == 10
				|| iDir == 14) {
				f25 = f19;
			}
			tessellator.setColorOpaque_F(	f12 * f25,
											f15 * f25,
											f18 * f25);
			renderCornersSouthFace(	block,
									i,
									j,
									k,
									block.getBlockTexture(	iblockaccess,
															i,
															j,
															k,
															5),
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			flag = true;
		}
		return flag;
	}

	public boolean renderIntCornersBlockWithAmbientOcclusion(Block block, int i, int j, int k, float f, float f1, float f2, int iDir, RenderBlocks renderblocks, IBlockAccess iblockaccess) {
		enableAO = true;
		boolean flag = false;
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = true;
		boolean flag4 = true;
		boolean flag5 = true;
		boolean flag6 = true;

		aoLightValueThis = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j,
																k);
		aoLightValueXNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																i - 1,
																j,
																k);
		aoLightValueYNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j - 1,
																k);
		aoLightValueZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j,
																k - 1);
		aoLightValueXPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																i + 1,
																j,
																k);
		aoLightValueYPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j + 1,
																k);
		aoLightValueZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																i,
																j,
																k + 1);

		aoLightValueXPosYPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i + 1,
																	j + 1,
																	k);
		aoLightValueXPosYNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i + 1,
																	j - 1,
																	k);
		aoLightValueXPosZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i + 1,
																	j,
																	k + 1);
		aoLightValueXPosZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i + 1,
																	j,
																	k - 1);
		aoLightValueXNegYPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i - 1,
																	j + 1,
																	k);
		aoLightValueXNegYNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i - 1,
																	j - 1,
																	k);
		aoLightValueXNegZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i - 1,
																	j,
																	k - 1);
		aoLightValueXNegZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i - 1,
																	j,
																	k + 1);
		aoLightValueYPosZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i,
																	j + 1,
																	k + 1);
		aoLightValueYPosZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i,
																	j + 1,
																	k - 1);
		aoLightValueYNegZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i,
																	j - 1,
																	k + 1);
		aoLightValueYNegZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																	i,
																	j - 1,
																	k - 1);

		aoLightValueXPosYPosZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i + 1,
																		j + 1,
																		k + 1);
		aoLightValueXPosYNegZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i + 1,
																		j - 1,
																		k + 1);
		aoLightValueXPosYPosZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i + 1,
																		j + 1,
																		k - 1);
		aoLightValueXPosYNegZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i + 1,
																		j - 1,
																		k - 1);
		aoLightValueXNegYPosZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i - 1,
																		j + 1,
																		k + 1);
		aoLightValueXNegYNegZPos = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i - 1,
																		j - 1,
																		k + 1);
		aoLightValueXNegYPosZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i - 1,
																		j + 1,
																		k - 1);
		aoLightValueXNegYNegZNeg = block.getAmbientOcclusionLightValue(	iblockaccess,
																		i - 1,
																		j - 1,
																		k - 1);

		if (block.getBlockTexture(	iblockaccess,
									i,
									j,
									k,
									0) == Block.dirt.getBlockTextureFromSide(0)) {
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
		colorRedTopLeft_BottomFace = colorRedBottomLeft_BottomFace = colorRedBottomRight_BottomFace = colorRedTopRight_BottomFace = (flag1 ? f : 1.0F) * 0.5F;
		colorGreenTopLeft_BottomFace = colorGreenBottomLeft_BottomFace = colorGreenBottomRight_BottomFace = colorGreenTopRight_BottomFace = (flag1 ? f1 : 1.0F) * 0.5F;
		colorBlueTopLeft_BottomFace = colorBlueBottomLeft_BottomFace = colorBlueBottomRight_BottomFace = colorBlueTopRight_BottomFace = (flag1 ? f2 : 1.0F) * 0.5F;
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
		colorRedTopLeft_TopFace = colorRedBottomLeft_TopFace = colorRedBottomRight_TopFace = colorRedTopRight_TopFace = flag2 ? f : 1.0F;
		colorGreenTopLeft_TopFace = colorGreenBottomLeft_TopFace = colorGreenBottomRight_TopFace = colorGreenTopRight_TopFace = flag2 ? f1 : 1.0F;
		colorBlueTopLeft_TopFace = colorBlueBottomLeft_TopFace = colorBlueBottomRight_TopFace = colorBlueTopRight_TopFace = flag2 ? f2 : 1.0F;
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
		colorRedTopLeft_EastFace = colorRedBottomLeft_EastFace = colorRedBottomRight_EastFace = colorRedTopRight_EastFace = (flag3 ? f : 1.0F) * 0.8F;
		colorGreenTopLeft_EastFace = colorGreenBottomLeft_EastFace = colorGreenBottomRight_EastFace = colorGreenTopRight_EastFace = (flag3 ? f1 : 1.0F) * 0.8F;
		colorBlueTopLeft_EastFace = colorBlueBottomLeft_EastFace = colorBlueBottomRight_EastFace = colorBlueTopRight_EastFace = (flag3 ? f2 : 1.0F) * 0.8F;
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
		Icon l = block.getBlockTexture(	iblockaccess,
										i,
										j,
										k,
										2);

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
		colorRedTopLeft_WestFace = colorRedBottomLeft_WestFace = colorRedBottomRight_WestFace = colorRedTopRight_WestFace = (flag4 ? f : 1.0F) * 0.8F;
		colorGreenTopLeft_WestFace = colorGreenBottomLeft_WestFace = colorGreenBottomRight_WestFace = colorGreenTopRight_WestFace = (flag4 ? f1 : 1.0F) * 0.8F;
		colorBlueTopLeft_WestFace = colorBlueBottomLeft_WestFace = colorBlueBottomRight_WestFace = colorBlueTopRight_WestFace = (flag4 ? f2 : 1.0F) * 0.8F;
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
		Icon i1 = block.getBlockTexture(iblockaccess,
										i,
										j,
										k,
										3);

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
		colorRedTopLeft_NorthFace = colorRedBottomLeft_NorthFace = colorRedBottomRight_NorthFace = colorRedTopRight_NorthFace = (flag5 ? f : 1.0F) * 0.6F;
		colorGreenTopLeft_NorthFace = colorGreenBottomLeft_NorthFace = colorGreenBottomRight_NorthFace = colorGreenTopRight_NorthFace = (flag5 ? f1 : 1.0F) * 0.6F;
		colorBlueTopLeft_NorthFace = colorBlueBottomLeft_NorthFace = colorBlueBottomRight_NorthFace = colorBlueTopRight_NorthFace = (flag5 ? f2 : 1.0F) * 0.6F;
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
		Icon j1 = block.getBlockTexture(iblockaccess,
										i,
										j,
										k,
										4);

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
		colorRedTopLeft_SouthFace = colorRedBottomLeft_SouthFace = colorRedBottomRight_SouthFace = colorRedTopRight_SouthFace = (flag6 ? f : 1.0F) * 0.6F;
		colorGreenTopLeft_SouthFace = colorGreenBottomLeft_SouthFace = colorGreenBottomRight_SouthFace = colorGreenTopRight_SouthFace = (flag6 ? f1 : 1.0F) * 0.6F;
		colorBlueTopLeft_SouthFace = colorBlueBottomLeft_SouthFace = colorBlueBottomRight_SouthFace = colorBlueTopRight_SouthFace = (flag6 ? f2 : 1.0F) * 0.6F;
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
		Icon k1 = block.getBlockTexture(iblockaccess,
										i,
										j,
										k,
										5);

		// ///////////////////////////////////////SUPERSLOPES//////////////////////////////

		colorRedSlopes = f;
		colorGreenSlopes = f1;
		colorBlueSlopes = f2;

		// ///////////////////////////////////////

		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j - 1,
											k,
											0)) {
			renderIntCornersBottomFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																0),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j + 1,
											k,
											1)) {
			renderIntCornersTopFace(block,
									i,
									j,
									k,
									block.getBlockTexture(	iblockaccess,
															i,
															j,
															k,
															1),
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j,
											k - 1,
											2)) {
			renderIntCornersEastFace(	block,
										i,
										j,
										k,
										l,
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			if (renderblocks.fancyGrass && l.getIconName().equals("grass_side")
				&& !renderblocks.hasOverrideBlockTexture()) {
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
				renderIntCornersEastFace(	block,
											i,
											j,
											k,
											BlockGrass.getIconSideOverlay(),
											iDir,
											renderblocks,
											block.getMixedBrightnessForBlock(	iblockaccess,
																				i,
																				j,
																				k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j,
											k + 1,
											3)) {
			renderIntCornersWestFace(	block,
										i,
										j,
										k,
										i1,
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			if (renderblocks.fancyGrass
				&& i1.getIconName().equals("grass_side")
				&& !renderblocks.hasOverrideBlockTexture()) {
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
				renderIntCornersWestFace(	block,
											i,
											j,
											k,
											BlockGrass.getIconSideOverlay(),
											iDir,
											renderblocks,
											block.getMixedBrightnessForBlock(	iblockaccess,
																				i,
																				j,
																				k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i - 1,
											j,
											k,
											4)) {
			renderIntCornersNorthFace(	block,
										i,
										j,
										k,
										j1,
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			if (renderblocks.fancyGrass
				&& j1.getIconName().equals("grass_side")
				&& !renderblocks.hasOverrideBlockTexture()) {
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
				renderIntCornersNorthFace(	block,
											i,
											j,
											k,
											BlockGrass.getIconSideOverlay(),
											iDir,
											renderblocks,
											block.getMixedBrightnessForBlock(	iblockaccess,
																				i,
																				j,
																				k));
			}
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i + 1,
											j,
											k,
											5)) {
			renderIntCornersSouthFace(	block,
										i,
										j,
										k,
										k1,
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			if (renderblocks.fancyGrass
				&& k1.getIconName().equals("grass_side")
				&& !renderblocks.hasOverrideBlockTexture()) {
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
				renderIntCornersSouthFace(	block,
											i,
											j,
											k,
											BlockGrass.getIconSideOverlay(),
											iDir,
											renderblocks,
											block.getMixedBrightnessForBlock(	iblockaccess,
																				i,
																				j,
																				k));
			}
			flag = true;
		}

		enableAO = false;
		return flag;
	}

	public boolean renderIntCornersBlockWithColorMultiplier(Block block, int i, int j, int k, float f, float f1, float f2, int iDir, RenderBlocks renderblocks, IBlockAccess iblockaccess) {
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
		float f19 = block.getAmbientOcclusionLightValue(iblockaccess,
														i,
														j,
														k);

		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j - 1,
											k,
											0) || iDir / 4 == 1
			|| iDir / 4 == 3) {
			float f20 = block.getAmbientOcclusionLightValue(iblockaccess,
															i,
															j - 1,
															k);
			if (iDir / 4 == 1 || iDir / 4 == 3) {
				f20 = f19;
			}
			tessellator.setColorOpaque_F(	f10 * f20,
											f13 * f20,
											f16 * f20);
			renderIntCornersBottomFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																0),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			flag = true;
		}

		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j + 1,
											k,
											1) || iDir / 4 == 0
			|| iDir / 4 == 2) {
			float f21 = block.getAmbientOcclusionLightValue(iblockaccess,
															i,
															j + 1,
															k);
			if ((block.getBlockBoundsMaxY() != 1.0D && !block.blockMaterial.isLiquid())
				|| iDir / 4 == 0 || iDir / 4 == 2) {
				f21 = f19;
			}
			tessellator.setColorOpaque_F(	f7 * f21,
											f8 * f21,
											f9 * f21);
			renderIntCornersTopFace(block,
									i,
									j,
									k,
									block.getBlockTexture(	iblockaccess,
															i,
															j,
															k,
															1),
									iDir,
									renderblocks,
									block.getMixedBrightnessForBlock(	iblockaccess,
																		i,
																		j,
																		k));
			flag = true;
		}

		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j,
											k - 1,
											2) || iDir % 2 == 0) {
			float f22 = block.getAmbientOcclusionLightValue(iblockaccess,
															i,
															j,
															k - 1);
			if (iDir % 2 == 0) {
				f22 = f19;
			}
			tessellator.setColorOpaque_F(	f11 * f22,
											f14 * f22,
											f17 * f22);
			renderIntCornersEastFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																2),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));

			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i,
											j,
											k + 1,
											3) || iDir % 2 == 1) {
			float f23 = block.getAmbientOcclusionLightValue(iblockaccess,
															i,
															j,
															k + 1);
			if (iDir % 2 == 1) {
				f23 = f19;
			}
			tessellator.setColorOpaque_F(	f11 * f23,
											f14 * f23,
											f17 * f23);
			renderIntCornersWestFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																3),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i - 1,
											j,
											k,
											4) || iDir == 0 || iDir == 3
			|| iDir == 4 || iDir == 7 || iDir == 11 || iDir == 15) {
			float f24 = block.getAmbientOcclusionLightValue(iblockaccess,
															i - 1,
															j,
															k);
			if (iDir == 0 || iDir == 3 || iDir == 4 || iDir == 7 || iDir == 11
				|| iDir == 15) {
				f24 = f19;
			}
			tessellator.setColorOpaque_F(	f12 * f24,
											f15 * f24,
											f18 * f24);
			renderIntCornersNorthFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																4),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			flag = true;
		}
		if (renderblocks.renderAllFaces
			|| block.shouldSideBeRendered(	iblockaccess,
											i + 1,
											j,
											k,
											5) || iDir == 1 || iDir == 2
			|| iDir == 5 || iDir == 6 || iDir == 10 || iDir == 14) {
			float f25 = block.getAmbientOcclusionLightValue(iblockaccess,
															i + 1,
															j,
															k);
			if (iDir == 1 || iDir == 2 || iDir == 5 || iDir == 6 || iDir == 10
				|| iDir == 14) {
				f25 = f19;
			}
			tessellator.setColorOpaque_F(	f12 * f25,
											f15 * f25,
											f18 * f25);
			renderIntCornersSouthFace(	block,
										i,
										j,
										k,
										block.getBlockTexture(	iblockaccess,
																i,
																j,
																k,
																5),
										iDir,
										renderblocks,
										block.getMixedBrightnessForBlock(	iblockaccess,
																			i,
																			j,
																			k));
			flag = true;
		}
		return flag;
	}

	public void renderSlopesBottomFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		if (lBrightness >= 0) {
			tessellator.setBrightness(lBrightness);
		}
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
		double d5 = (double) i.getInterpolatedV(renderblocks.renderMinZ * 16.0D);
		double d6 = (double) i.getInterpolatedV(renderblocks.renderMaxZ * 16.0D);
		if (block.getBlockBoundsMinX() < 0.0D
			|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 = i.getMinU();
			d4 = i.getMaxU();
		}
		if (block.getBlockBoundsMinZ() < 0.0D
			|| block.getBlockBoundsMaxZ() > 1.0D) {
			d5 = i.getMinV();
			d6 = i.getMaxV();
		}
		double d7 = d + block.getBlockBoundsMinX();
		double d8 = d + block.getBlockBoundsMaxX();
		double d9 = d1 + block.getBlockBoundsMinY();
		double d10 = d2 + block.getBlockBoundsMinZ();
		double d11 = d2 + block.getBlockBoundsMaxZ();
		if (enableAO) {
			if (iDir / 4 == 0) {
				// Standard
				tessellator.setColorOpaque_F(	colorRedTopLeft_BottomFace,
												colorGreenTopLeft_BottomFace,
												colorBlueTopLeft_BottomFace);
				tessellator.addVertexWithUV(d7,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_BottomFace,
												colorGreenBottomLeft_BottomFace,
												colorBlueBottomLeft_BottomFace);
				tessellator.addVertexWithUV(d7,
											d9,
											d10,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_BottomFace,
												colorGreenBottomRight_BottomFace,
												colorBlueBottomRight_BottomFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d10,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_BottomFace,
												colorGreenTopRight_BottomFace,
												colorBlueTopRight_BottomFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
			}
		} else {
			if (iDir / 4 == 0) {
				// Standard
				tessellator.addVertexWithUV(d7,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d7,
											d9,
											d10,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d10,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
			}
		}
	}

	public void renderSlopesTopFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		if (lBrightness >= 0) {
			tessellator.setBrightness(lBrightness);
		}
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
		double d5 = (double) i.getInterpolatedV(renderblocks.renderMinZ * 16.0D);
		double d6 = (double) i.getInterpolatedV(renderblocks.renderMaxZ * 16.0D);
		if (renderblocks.renderMinX < 0.0D || renderblocks.renderMaxX > 1.0D) {
			d3 = i.getMinU();
			d4 = i.getMaxU();
		}
		if (renderblocks.renderMinZ < 0.0D || renderblocks.renderMaxZ > 1.0D) {
			d5 = i.getMinV();
			d6 = i.getMaxV();
		}
		double d7 = d + renderblocks.renderMinX;
		double d8 = d + renderblocks.renderMaxX;
		double d9 = d1 + renderblocks.renderMaxY;
		double d10 = d2 + renderblocks.renderMinZ;
		double d11 = d2 + renderblocks.renderMaxZ;

		if (enableAO) {
			if (iDir / 4 == 1) {
				// Standard
				tessellator.setColorOpaque_F(	colorRedTopLeft_TopFace,
												colorGreenTopLeft_TopFace,
												colorBlueTopLeft_TopFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_TopFace,
												colorGreenBottomLeft_TopFace,
												colorBlueBottomLeft_TopFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d10,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_TopFace,
												colorGreenBottomRight_TopFace,
												colorBlueBottomRight_TopFace);
				tessellator.addVertexWithUV(d7,
											d9,
											d10,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_TopFace,
												colorGreenTopRight_TopFace,
												colorBlueTopRight_TopFace);
				tessellator.addVertexWithUV(d7,
											d9,
											d11,
											d3,
											d6);
			}
		} else {
			if (iDir / 4 == 1) {
				// Standard
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d10,
											d4,
											d5);
				tessellator.addVertexWithUV(d7,
											d9,
											d10,
											d3,
											d5);
				tessellator.addVertexWithUV(d7,
											d9,
											d11,
											d3,
											d6);
			}
		}
	}

	public void renderSlopesEastFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		if (lBrightness >= 0) {
			tessellator.setBrightness(lBrightness);
		}
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinZ * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxZ * 16.0D);
		double d5 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
		double d6 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
		if (renderblocks.flipTexture) {
			double d7 = d3;
			d3 = d4;
			d4 = d7;
		}
		if (block.getBlockBoundsMinX() < 0.0D
			|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 = 0.0F;
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
			if (iDir == 3 || iDir == 7) {
				// Standard
				tessellator.setColorOpaque_F(	colorRedTopLeft_EastFace,
												colorGreenTopLeft_EastFace,
												colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_EastFace,
												colorGreenBottomLeft_EastFace,
												colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_EastFace,
												colorGreenBottomRight_EastFace,
												colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_EastFace,
												colorGreenTopRight_EastFace,
												colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 0) {
				// Triangle Down pointing north
				tessellator.setColorOpaque_F(	colorRedTopRight_EastFace,
												colorGreenTopRight_EastFace,
												colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_EastFace,
												colorGreenBottomLeft_EastFace,
												colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_EastFace,
												colorGreenBottomRight_EastFace,
												colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_EastFace,
												colorGreenTopRight_EastFace,
												colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 1) {
				// Triangle Down pointing south
				tessellator.setColorOpaque_F(	colorRedTopLeft_EastFace,
												colorGreenTopLeft_EastFace,
												colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_EastFace,
												colorGreenBottomRight_EastFace,
												colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_EastFace,
												colorGreenBottomRight_EastFace,
												colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_EastFace,
												colorGreenTopRight_EastFace,
												colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 2) {
				// Slope facing Up - East
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d11,
											d13,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d11,
											d13,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorTop + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorTop + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorTop + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorTop + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorTop + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorTop + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 4) {
				// Triangle Up pointing north
				tessellator.setColorOpaque_F(	colorRedTopLeft_EastFace,
												colorGreenTopLeft_EastFace,
												colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_EastFace,
												colorGreenBottomLeft_EastFace,
												colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_EastFace,
												colorGreenBottomRight_EastFace,
												colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopLeft_EastFace,
												colorGreenTopLeft_EastFace,
												colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 5) {
				// Triangle Up pointing south
				tessellator.setColorOpaque_F(	colorRedTopLeft_EastFace,
												colorGreenTopLeft_EastFace,
												colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_EastFace,
												colorGreenBottomLeft_EastFace,
												colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_EastFace,
												colorGreenBottomLeft_EastFace,
												colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_EastFace,
												colorGreenTopRight_EastFace,
												colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 6) {
				// Slope facing Down - East
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorBottom + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d10,
											d13,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d13,
											d4,
											d6);
			}
		} else {
			if (iDir == 3 || iDir == 7) {
				// Standard
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 0) {
				// Triangle Down pointing north
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 1) {
				// Triangle Down pointing south
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 2) {
				// Slope Down
				tessellator.addVertexWithUV(d8,
											d11,
											d13,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d13,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 4) {
				// Triangle Up pointing north
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 5) {
				// Triangle Up pointing south
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 6) {
				// Slope Up
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d13,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d13,
											d4,
											d6);
			}
		}
	}

	public void renderSlopesWestFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		if (lBrightness >= 0) {
			tessellator.setBrightness(lBrightness);
		}
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinZ * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxZ * 16.0D);
		double d5 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
		double d6 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
		if (renderblocks.flipTexture) {
			double d7 = d3;
			d3 = d4;
			d4 = d7;
		}
		if (block.getBlockBoundsMinX() < 0.0D
			|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 = i.getMinU();
			d4 = i.getMaxU();
		}
		if (block.getBlockBoundsMinY() < 0.0D
			|| block.getBlockBoundsMaxY() > 1.0D) {
			d5 = i.getMinU();
			d6 = i.getMaxV();
		}
		double d8 = d + block.getBlockBoundsMinX();
		double d9 = d + block.getBlockBoundsMaxX();
		double d10 = d1 + block.getBlockBoundsMinY();
		double d11 = d1 + block.getBlockBoundsMaxY();
		double d12 = d2 + block.getBlockBoundsMaxZ();
		double d13 = d2 + block.getBlockBoundsMinZ();

		if (enableAO) {
			if (iDir == 2 || iDir == 6) {
				// Standard
				tessellator.setColorOpaque_F(	colorRedTopLeft_WestFace,
												colorGreenTopLeft_WestFace,
												colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_WestFace,
												colorGreenBottomLeft_WestFace,
												colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_WestFace,
												colorGreenBottomRight_WestFace,
												colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_WestFace,
												colorGreenTopRight_WestFace,
												colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 0) {
				// Triangle Down pointing north
				tessellator.setColorOpaque_F(	colorRedBottomLeft_WestFace,
												colorGreenBottomLeft_WestFace,
												colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_WestFace,
												colorGreenBottomLeft_WestFace,
												colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_WestFace,
												colorGreenBottomRight_WestFace,
												colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_WestFace,
												colorGreenTopRight_WestFace,
												colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 1) {
				// Triangle Down pointing south
				tessellator.setColorOpaque_F(	colorRedTopLeft_WestFace,
												colorGreenTopLeft_WestFace,
												colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_WestFace,
												colorGreenBottomLeft_WestFace,
												colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_WestFace,
												colorGreenBottomRight_WestFace,
												colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_WestFace,
												colorGreenBottomRight_WestFace,
												colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 3) {
				// Slope Facing Up - West
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d11,
											d13,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorTop + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorTop + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorTop + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorTop + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorTop + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorTop + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d11,
											d13,
											d4,
											d5);
			} else if (iDir == 4) {
				// Triangle Up pointing north
				tessellator.setColorOpaque_F(	colorRedTopLeft_WestFace,
												colorGreenTopLeft_WestFace,
												colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopLeft_WestFace,
												colorGreenTopLeft_WestFace,
												colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_WestFace,
												colorGreenBottomRight_WestFace,
												colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_WestFace,
												colorGreenTopRight_WestFace,
												colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 5) {
				// Triangle Up pointing south
				tessellator.setColorOpaque_F(	colorRedTopLeft_WestFace,
												colorGreenTopLeft_WestFace,
												colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_WestFace,
												colorGreenBottomLeft_WestFace,
												colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_WestFace,
												colorGreenTopRight_WestFace,
												colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_WestFace,
												colorGreenTopRight_WestFace,
												colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 7) {
				// Slope Facing Down - West
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorBottom + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorBottom + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorBottom + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d13,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d10,
											d13,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorBottom + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorBottom + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorBottom + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			}
		} else {
			if (iDir == 2 || iDir == 6) {
				// Standard
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 0) {
				// Triangle Down pointing north
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 1) {
				// Triangle Down pointing south
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 3) {
				// Slope Down
				tessellator.addVertexWithUV(d8,
											d11,
											d13,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d13,
											d4,
											d5);
			} else if (iDir == 4) {
				// Triangle Up pointing north
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 5) {
				// Triangle Up pointing south
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 7) {
				// Slope Up
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d13,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d13,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			}
		}
	}

	public void renderSlopesNorthFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		if (lBrightness >= 0) {
			tessellator.setBrightness(lBrightness);
		}
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
		double d5 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
		double d6 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
		if (renderblocks.flipTexture) {
			double d7 = d3;
			d3 = d4;
			d4 = d7;
		}
		if (block.getBlockBoundsMinZ() < 0.0D
			|| block.getBlockBoundsMaxZ() > 1.0D) {
			d3 = i.getMinU();
			d4 = i.getMaxU();
		}
		if (block.getBlockBoundsMinY() < 0.0D
			|| block.getBlockBoundsMaxY() > 1.0D) {
			d5 = i.getMinV();
			d6 = i.getMaxV();
		}
		double d8 = d + block.getBlockBoundsMinX();
		double d9 = d1 + block.getBlockBoundsMinY();
		double d10 = d1 + block.getBlockBoundsMaxY();
		double d11 = d2 + block.getBlockBoundsMinZ();
		double d12 = d2 + block.getBlockBoundsMaxZ();
		double d13 = d + block.getBlockBoundsMaxX();

		if (enableAO) {
			if (iDir == 1 || iDir == 5) {
				// Standard
				tessellator.setColorOpaque_F(	colorRedTopLeft_NorthFace,
												colorGreenTopLeft_NorthFace,
												colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_NorthFace,
												colorGreenBottomLeft_NorthFace,
												colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_NorthFace,
												colorGreenBottomRight_NorthFace,
												colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_NorthFace,
												colorGreenTopRight_NorthFace,
												colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 0) {
				// Slope facing Up - North
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorTop + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorTop + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorTop + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorTop + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorTop + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorTop + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 2) {
				// Triangle Down pointing east
				tessellator.setColorOpaque_F(	colorRedTopLeft_NorthFace,
												colorGreenTopLeft_NorthFace,
												colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_NorthFace,
												colorGreenBottomRight_NorthFace,
												colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_NorthFace,
												colorGreenBottomRight_NorthFace,
												colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_NorthFace,
												colorGreenTopRight_NorthFace,
												colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);

			} else if (iDir == 3) {
				// Triangle Down pointing west
				tessellator.setColorOpaque_F(	colorRedTopRight_NorthFace,
												colorGreenTopRight_NorthFace,
												colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_NorthFace,
												colorGreenBottomLeft_NorthFace,
												colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_NorthFace,
												colorGreenBottomRight_NorthFace,
												colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_NorthFace,
												colorGreenTopRight_NorthFace,
												colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 4) {
				// Slope facing Down - North
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorBottom + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorBottom + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorBottom + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 6) {
				// Triangle Up pointing east
				tessellator.setColorOpaque_F(	colorRedTopLeft_NorthFace,
												colorGreenTopLeft_NorthFace,
												colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_NorthFace,
												colorGreenBottomLeft_NorthFace,
												colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_NorthFace,
												colorGreenBottomLeft_NorthFace,
												colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_NorthFace,
												colorGreenTopRight_NorthFace,
												colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 7) {
				// Triangle Up pointing west
				tessellator.setColorOpaque_F(	colorRedTopLeft_NorthFace,
												colorGreenTopLeft_NorthFace,
												colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_NorthFace,
												colorGreenBottomLeft_NorthFace,
												colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_NorthFace,
												colorGreenBottomRight_NorthFace,
												colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopLeft_NorthFace,
												colorGreenTopLeft_NorthFace,
												colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
			}
		} else {
			if (iDir == 1 || iDir == 5) {
				// Standard
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 0) {
				// Slope Down
				tessellator.addVertexWithUV(d13,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d13,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 2) {
				// Triangle Down pointing east
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);

			} else if (iDir == 3) {
				// Triangle Down pointing west
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 4) {
				// Slope Up
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d13,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d13,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 6) {
				// Triangle Up pointing east
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 7) {
				// Triangle Up pointing west
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
			}
		}
	}

	public void renderSlopesSouthFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		if (lBrightness >= 0) {
			tessellator.setBrightness(lBrightness);
		}
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
		double d5 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
		double d6 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
		if (renderblocks.flipTexture) {
			double d7 = d3;
			d3 = d4;
			d4 = d7;
		}
		if (block.getBlockBoundsMinZ() < 0.0D
			|| block.getBlockBoundsMaxZ() > 1.0D) {
			d3 = i.getMinU();
			d4 = i.getMaxU();
		}
		if (block.getBlockBoundsMinY() < 0.0D
			|| block.getBlockBoundsMaxY() > 1.0D) {
			d5 = i.getMinV();
			d6 = i.getMaxV();
		}
		double d8 = d + block.getBlockBoundsMaxX();
		double d9 = d1 + block.getBlockBoundsMinY();
		double d10 = d1 + block.getBlockBoundsMaxY();
		double d11 = d2 + block.getBlockBoundsMinZ();
		double d12 = d2 + block.getBlockBoundsMaxZ();
		double d13 = d + block.getBlockBoundsMinX();

		if (enableAO) {
			if (iDir == 0 || iDir == 4) {
				// Standard
				tessellator.setColorOpaque_F(	colorRedTopLeft_SouthFace,
												colorGreenTopLeft_SouthFace,
												colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_SouthFace,
												colorGreenBottomLeft_SouthFace,
												colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_SouthFace,
												colorGreenBottomRight_SouthFace,
												colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_SouthFace,
												colorGreenTopRight_SouthFace,
												colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 1) {
				// Slope facing Up - South
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorTop + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorTop + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorTop + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorTop + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorTop + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorTop + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 2) {
				// Triangle Down pointing east
				tessellator.setColorOpaque_F(	colorRedTopLeft_SouthFace,
												colorGreenTopLeft_SouthFace,
												colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_SouthFace,
												colorGreenBottomLeft_SouthFace,
												colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_SouthFace,
												colorGreenBottomLeft_SouthFace,
												colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_SouthFace,
												colorGreenTopRight_SouthFace,
												colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 3) {
				// Triangle Down pointing west
				tessellator.setColorOpaque_F(	colorRedTopLeft_SouthFace,
												colorGreenTopLeft_SouthFace,
												colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_SouthFace,
												colorGreenBottomLeft_SouthFace,
												colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_SouthFace,
												colorGreenBottomRight_SouthFace,
												colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopLeft_SouthFace,
												colorGreenTopLeft_SouthFace,
												colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
			} else if (iDir == 5) {
				// Slope facing Down - South
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorBottom + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorBottom + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorBottom + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorBottom + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorBottom + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorBottom + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 6) {
				// Triangle Up pointing east
				tessellator.setColorOpaque_F(	colorRedTopLeft_SouthFace,
												colorGreenTopLeft_SouthFace,
												colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_SouthFace,
												colorGreenBottomRight_SouthFace,
												colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_SouthFace,
												colorGreenBottomRight_SouthFace,
												colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_SouthFace,
												colorGreenTopRight_SouthFace,
												colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 7) {
				// Triangle Up pointing west
				tessellator.setColorOpaque_F(	colorRedTopRight_SouthFace,
												colorGreenTopRight_SouthFace,
												colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_SouthFace,
												colorGreenBottomLeft_SouthFace,
												colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_SouthFace,
												colorGreenBottomRight_SouthFace,
												colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_SouthFace,
												colorGreenTopRight_SouthFace,
												colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			}
		} else {
			if (iDir == 0 || iDir == 4) {
				// Standard
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 1) {
				// Slope Down
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d13,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d13,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 2) {
				// Triangle Down pointing east
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 3) {
				// Triangle Down pointing west
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
			} else if (iDir == 4) {
				// Slope Up
				tessellator.addVertexWithUV(d13,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d13,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 5) {
				// Triangle Up pointing east
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 6) {
				// Triangle Up pointing west
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 7) {
				// Side Slope
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d13,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d13,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			}
		}
	}

	public void renderCornersBottomFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
		double d5 = (double) i.getInterpolatedV(renderblocks.renderMinZ * 16.0D);
		double d6 = (double) i.getInterpolatedV(renderblocks.renderMaxZ * 16.0D);
		if (block.getBlockBoundsMinX() < 0.0D
			|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 = i.getMinU();
			d4 = i.getMaxU();
		}
		if (block.getBlockBoundsMinZ() < 0.0D
			|| block.getBlockBoundsMaxZ() > 1.0D) {
			d5 = i.getMinV();
			d6 = i.getMaxV();
		}
		double d7 = d + block.getBlockBoundsMinX();
		double d8 = d + block.getBlockBoundsMaxX();
		double d9 = d1 + block.getBlockBoundsMinY();
		double d10 = d2 + block.getBlockBoundsMinZ();
		double d11 = d2 + block.getBlockBoundsMaxZ();

		if (enableAO) {
			if (iDir < 4) {
				// Standard
				tessellator.setColorOpaque_F(	colorRedTopLeft_BottomFace,
												colorGreenTopLeft_BottomFace,
												colorBlueTopLeft_BottomFace);
				tessellator.addVertexWithUV(d7,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_BottomFace,
												colorGreenBottomLeft_BottomFace,
												colorBlueBottomLeft_BottomFace);
				tessellator.addVertexWithUV(d7,
											d9,
											d10,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_BottomFace,
												colorGreenBottomRight_BottomFace,
												colorBlueBottomRight_BottomFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d10,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_BottomFace,
												colorGreenTopRight_BottomFace,
												colorBlueTopRight_BottomFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
			}
		} else {
			if (iDir / 4 == 0) {
				// Standard
				tessellator.addVertexWithUV(d7,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d7,
											d9,
											d10,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d10,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
			}
		}
	}

	public void renderCornersTopFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}
		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
		double d5 = (double) i.getInterpolatedV(renderblocks.renderMinZ * 16.0D);
		double d6 = (double) i.getInterpolatedV(renderblocks.renderMaxZ * 16.0D);
		if (block.getBlockBoundsMinX() < 0.0D
			|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 = i.getMinU();
			d4 = i.getMaxU();
		}
		if (block.getBlockBoundsMinZ() < 0.0D
			|| block.getBlockBoundsMaxZ() > 1.0D) {
			d5 = i.getMinV();
			d6 = i.getMaxV();
		}
		double d7 = d + block.getBlockBoundsMinX();
		double d8 = d + block.getBlockBoundsMaxX();
		double d9 = d1 + block.getBlockBoundsMaxY();
		double d10 = d2 + block.getBlockBoundsMinZ();
		double d11 = d2 + block.getBlockBoundsMaxZ();

		if (enableAO) {
			if (iDir / 4 == 1) {
				// Standard
				tessellator.setColorOpaque_F(	colorRedTopLeft_TopFace,
												colorGreenTopLeft_TopFace,
												colorBlueTopLeft_TopFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_TopFace,
												colorGreenBottomLeft_TopFace,
												colorBlueBottomLeft_TopFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d10,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_TopFace,
												colorGreenBottomRight_TopFace,
												colorBlueBottomRight_TopFace);
				tessellator.addVertexWithUV(d7,
											d9,
											d10,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_TopFace,
												colorGreenTopRight_TopFace,
												colorBlueTopRight_TopFace);
				tessellator.addVertexWithUV(d7,
											d9,
											d11,
											d3,
											d6);
			}
		} else {
			if (iDir / 4 == 1) {
				// Standard
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d10,
											d4,
											d5);
				tessellator.addVertexWithUV(d7,
											d9,
											d10,
											d3,
											d5);
				tessellator.addVertexWithUV(d7,
											d9,
											d11,
											d3,
											d6);
			}
		}
	}

	public void renderCornersEastFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinZ * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxZ * 16.0D);
		double d5 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
		double d6 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);

		if (renderblocks.flipTexture) {
			double d7 = d3;
			d3 = d4;
			d4 = d7;
		}
		if (block.getBlockBoundsMinX() < 0.0D
			|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 = 0.0F;
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
			if (iDir == 0) {
				// Slope facing Up - East
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d11,
											d13,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d11,
											d13,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorTop + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorTop + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorTop + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorTop + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorTop + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorTop + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 1) {
				// Triangle Down pointing south
				tessellator.setColorOpaque_F(	colorRedTopLeft_EastFace,
												colorGreenTopLeft_EastFace,
												colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_EastFace,
												colorGreenBottomRight_EastFace,
												colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_EastFace,
												colorGreenBottomRight_EastFace,
												colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_EastFace,
												colorGreenTopRight_EastFace,
												colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 2) {
				// Slope facing Up - East
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d11,
											d13,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d11,
											d13,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorTop + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorTop + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorTop + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorTop + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorTop + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorTop + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 3) {
				// Triangle Down pointing north
				tessellator.setColorOpaque_F(	colorRedTopRight_EastFace,
												colorGreenTopRight_EastFace,
												colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_EastFace,
												colorGreenBottomLeft_EastFace,
												colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_EastFace,
												colorGreenBottomRight_EastFace,
												colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_EastFace,
												colorGreenTopRight_EastFace,
												colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 4) {
				// Slope facing Down - East
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorBottom + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d10,
											d13,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d10,
											d13,
											d3,
											d6);
			} else if (iDir == 5) {
				// Triangle Up pointing south
				tessellator.setColorOpaque_F(	colorRedTopLeft_EastFace,
												colorGreenTopLeft_EastFace,
												colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_EastFace,
												colorGreenBottomLeft_EastFace,
												colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_EastFace,
												colorGreenBottomLeft_EastFace,
												colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_EastFace,
												colorGreenTopRight_EastFace,
												colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 6) {
				// Slope facing Down - East
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZNeg + aoLightValueXPosZNeg)
														* (factorBottom + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d13,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorEast)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorEast)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d13,
											d4,
											d6);
			} else if (iDir == 7) {
				// Triangle Up pointing north
				tessellator.setColorOpaque_F(	colorRedTopLeft_EastFace,
												colorGreenTopLeft_EastFace,
												colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_EastFace,
												colorGreenBottomLeft_EastFace,
												colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_EastFace,
												colorGreenBottomRight_EastFace,
												colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopLeft_EastFace,
												colorGreenTopLeft_EastFace,
												colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
			}
		} else {
			if (iDir == 0) {
				// Pointing 0, X = 1, Z = 1, Sloped
				tessellator.addVertexWithUV(d9,
											d11,
											d13,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d13,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 1) {
				// Pointing 1, X = 0, Z = 0
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 2) {
				// Pointing 2, X = 0, Z = 1, Sloped
				tessellator.addVertexWithUV(d8,
											d11,
											d13,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d11,
											d13,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 3) {
				// Pointing 3, X = 1, Z = 0
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 4) {
				// Pointing 0, X = 1, Z = 1, Sloped
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d13,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d13,
											d3,
											d6);
			} else if (iDir == 5) {
				// Pointing 1, X = 0, Z = 0
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 6) {
				// Pointing 2, X = 0, Z = 1, Sloped
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d13,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d13,
											d4,
											d6);
			} else if (iDir == 7) {
				// Pointing 3, X = 1, Z = 0
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
			}
		}
	}

	public void renderCornersWestFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinZ * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxZ * 16.0D);
		double d5 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
		double d6 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
		if (renderblocks.flipTexture) {
			double d7 = d3;
			d3 = d4;
			d4 = d7;
		}
		if (block.getBlockBoundsMinX() < 0.0D
			|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 = 0.0F;
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
		double d12 = d2 + block.getBlockBoundsMaxZ();
		double d13 = d2 + block.getBlockBoundsMinZ();

		if (enableAO) {
			if (iDir == 0) {
				// Triangle Down pointing north
				tessellator.setColorOpaque_F(	colorRedBottomLeft_WestFace,
												colorGreenBottomLeft_WestFace,
												colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_WestFace,
												colorGreenBottomLeft_WestFace,
												colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_WestFace,
												colorGreenBottomRight_WestFace,
												colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_WestFace,
												colorGreenTopRight_WestFace,
												colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 1) {
				// Slope facing Up - West
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d11,
											d13,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorTop + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorTop + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorTop + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorTop + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorTop + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorTop + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueXNegYPos)
														* (factorTop + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d11,
											d13,
											d3,
											d5);
			} else if (iDir == 2) {
				// Triangle Down pointing south
				tessellator.setColorOpaque_F(	colorRedTopLeft_WestFace,
												colorGreenTopLeft_WestFace,
												colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_WestFace,
												colorGreenBottomLeft_WestFace,
												colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_WestFace,
												colorGreenBottomRight_WestFace,
												colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_WestFace,
												colorGreenBottomRight_WestFace,
												colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
			} else if (iDir == 3) {
				// Slope facing Up - West
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d11,
											d13,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorTop + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorTop + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorTop + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorTop + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorTop + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorTop + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueXPosYPos)
														* (factorTop + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d11,
											d13,
											d4,
											d5);
			} else if (iDir == 4) {
				// Triangle Up pointing north
				tessellator.setColorOpaque_F(	colorRedTopLeft_WestFace,
												colorGreenTopLeft_WestFace,
												colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopLeft_WestFace,
												colorGreenTopLeft_WestFace,
												colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_WestFace,
												colorGreenBottomRight_WestFace,
												colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_WestFace,
												colorGreenTopRight_WestFace,
												colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 5) {
				// Slope facing Down - West
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorBottom + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorBottom + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorBottom + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d13,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueXNegYNeg)
														* (factorBottom + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d13,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorBottom + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorBottom + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorBottom + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 6) {
				// Triangle Up pointing south
				tessellator.setColorOpaque_F(	colorRedTopLeft_WestFace,
												colorGreenTopLeft_WestFace,
												colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_WestFace,
												colorGreenBottomLeft_WestFace,
												colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_WestFace,
												colorGreenTopRight_WestFace,
												colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_WestFace,
												colorGreenTopRight_WestFace,
												colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 7) {
				// Slope facing Down - West
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorBottom + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorBottom + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZPos + aoLightValueXNegZPos)
														* (factorBottom + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d10,
											d13,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueXPosYNeg)
														* (factorBottom + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d10,
											d13,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorBottom + factorWest)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorBottom + factorWest)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueZPos + aoLightValueXPosZPos)
														* (factorBottom + factorWest)
														/ 4F);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			}
		} else {
			if (iDir == 0) {
				// Pointing 0, X = 1, Z = 1
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 1) {
				// Pointing 1, X = 0, Z = 0, Sloped
				tessellator.addVertexWithUV(d8,
											d11,
											d13,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d11,
											d13,
											d3,
											d5);
			} else if (iDir == 2) {
				// Pointing 2, X = 0, Z = 1
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
			} else if (iDir == 3) {
				// Pointing 3, X = 1, Z = 0, Sloped
				tessellator.addVertexWithUV(d9,
											d11,
											d13,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d13,
											d4,
											d5);
			} else if (iDir == 4) {
				// Pointing 0, X = 1, Z = 1
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 5) {
				// Pointing 1, X = 0, Z = 0, Sloped
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d13,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d13,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 6) {
				// Pointing 2, X = 0, Z = 1
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 7) {
				// Pointing 3, X = 1, Z = 0, Sloped
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d13,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d13,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			}
		}
	}

	public void renderCornersNorthFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
		double d5 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
		double d6 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
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
			if (iDir == 0) {
				// Slope facing Up - North
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorTop + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorTop + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorTop + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorTop + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorTop + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorTop + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 1) {
				// Triangle Down pointing west
				tessellator.setColorOpaque_F(	colorRedTopRight_NorthFace,
												colorGreenTopRight_NorthFace,
												colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_NorthFace,
												colorGreenBottomLeft_NorthFace,
												colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_NorthFace,
												colorGreenBottomRight_NorthFace,
												colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_NorthFace,
												colorGreenTopRight_NorthFace,
												colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 2) {
				// Triangle Down pointing east
				tessellator.setColorOpaque_F(	colorRedTopLeft_NorthFace,
												colorGreenTopLeft_NorthFace,
												colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_NorthFace,
												colorGreenBottomRight_NorthFace,
												colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_NorthFace,
												colorGreenBottomRight_NorthFace,
												colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_NorthFace,
												colorGreenTopRight_NorthFace,
												colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 3) {
				// Slope facing Up - North
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorTop + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorTop + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorTop + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorTop + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorTop + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorTop + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 4) {
				// Slope facing Down - North
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorBottom + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorBottom + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorBottom + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d9,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 5) {
				// Triangle Up pointing west
				tessellator.setColorOpaque_F(	colorRedTopLeft_NorthFace,
												colorGreenTopLeft_NorthFace,
												colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_NorthFace,
												colorGreenBottomLeft_NorthFace,
												colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_NorthFace,
												colorGreenBottomRight_NorthFace,
												colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopLeft_NorthFace,
												colorGreenTopLeft_NorthFace,
												colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
			} else if (iDir == 6) {
				// Triangle Up pointing east
				tessellator.setColorOpaque_F(	colorRedTopLeft_NorthFace,
												colorGreenTopLeft_NorthFace,
												colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_NorthFace,
												colorGreenBottomLeft_NorthFace,
												colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_NorthFace,
												colorGreenBottomLeft_NorthFace,
												colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_NorthFace,
												colorGreenTopRight_NorthFace,
												colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 7) {
				// Slope facing Down - North
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorBottom + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorBottom + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXNeg + aoLightValueXNegZPos)
														* (factorBottom + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXNeg + aoLightValueXNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorNorth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d9,
											d11,
											d3,
											d6);
			}
		} else {
			if (iDir == 0) {
				// Pointing 0, X = 1, Z = 1, Sloped
				tessellator.addVertexWithUV(d13,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d13,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 1) {
				// Pointing 1, X = 0, Z = 0
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 2) {
				// Pointing 2, X = 0, Z = 1
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 3) {
				// Pointing 3, X = 1, Z = 0, Sloped
				tessellator.addVertexWithUV(d13,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d13,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 4) {
				// Pointing 0, X = 1, Z = 1, Sloped
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d13,
											d9,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d13,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 5) {
				// Pointing 1, X = 0, Z = 0
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
			} else if (iDir == 6) {
				// Pointing 2, X = 0, Z = 1
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			} else if (iDir == 7) {
				// Pointing 3, X = 1, Z = 0, Sloped
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d13,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d13,
											d9,
											d11,
											d3,
											d6);
			}
		}
	}

	public void renderCornersSouthFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
		double d5 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
		double d6 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
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
		double d8 = d + block.getBlockBoundsMaxX();
		double d9 = d1 + block.getBlockBoundsMinY();
		double d10 = d1 + block.getBlockBoundsMaxY();
		double d11 = d2 + block.getBlockBoundsMinZ();
		double d12 = d2 + block.getBlockBoundsMaxZ();
		double d13 = d + block.getBlockBoundsMinX();

		if (enableAO) {
			if (iDir == 0) {
				// Triangle Down pointing east
				tessellator.setColorOpaque_F(	colorRedTopLeft_SouthFace,
												colorGreenTopLeft_SouthFace,
												colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_SouthFace,
												colorGreenBottomLeft_SouthFace,
												colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_SouthFace,
												colorGreenBottomLeft_SouthFace,
												colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_SouthFace,
												colorGreenTopRight_SouthFace,
												colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 1) {
				// Slope facing Up - South
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorTop + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorTop + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorTop + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorTop + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorTop + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorTop + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueYPosZNeg)
														* (factorTop + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d10,
											d11,
											d4,
											d5);
			} else if (iDir == 2) {
				// Slope facing Up - South
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorTop + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorTop + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorTop + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorTop + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorTop + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorTop + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d10,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYPos + aoLightValueYPosZPos)
														* (factorTop + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 3) {
				// Triangle Down pointing west
				tessellator.setColorOpaque_F(	colorRedTopLeft_SouthFace,
												colorGreenTopLeft_SouthFace,
												colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_SouthFace,
												colorGreenBottomLeft_SouthFace,
												colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_SouthFace,
												colorGreenBottomRight_SouthFace,
												colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopLeft_SouthFace,
												colorGreenTopLeft_SouthFace,
												colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
			} else if (iDir == 4) {
				// Triangle Up pointing east
				tessellator.setColorOpaque_F(	colorRedTopLeft_SouthFace,
												colorGreenTopLeft_SouthFace,
												colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_SouthFace,
												colorGreenBottomRight_SouthFace,
												colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_SouthFace,
												colorGreenBottomRight_SouthFace,
												colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_SouthFace,
												colorGreenTopRight_SouthFace,
												colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 5) {
				// Slope facing Down - South
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueYNegZNeg)
														* (factorBottom + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorBottom + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorBottom + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorBottom + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorBottom + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorBottom + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorBottom + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 6) {
				// Slope facing Down - South
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueYNeg + aoLightValueYNegZPos)
														* (factorBottom + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d13,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorBottom + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorBottom + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXPos + aoLightValueXPosZNeg)
														* (factorBottom + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorBottom + factorSouth)
														/ 4F,
												colorGreenSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorBottom + factorSouth)
														/ 4F,
												colorBlueSlopes
														* (aoLightValueXPos + aoLightValueXPosZPos)
														* (factorBottom + factorSouth)
														/ 4F);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 7) {
				// Triangle Up pointing west
				tessellator.setColorOpaque_F(	colorRedTopRight_SouthFace,
												colorGreenTopRight_SouthFace,
												colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_SouthFace,
												colorGreenBottomLeft_SouthFace,
												colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_SouthFace,
												colorGreenBottomRight_SouthFace,
												colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_SouthFace,
												colorGreenTopRight_SouthFace,
												colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			}
		} else {
			if (iDir == 0) {
				// Pointing 0, X = 1, Z = 1
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 1) {
				// Pointing 1, X = 0, Z = 0, Sloped
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d13,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d13,
											d10,
											d11,
											d4,
											d5);
			} else if (iDir == 2) {
				// Pointing 2, X = 0, Z = 1, Sloped
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d13,
											d10,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d13,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 3) {
				// Pointing 3, X = 1, Z = 0
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
			} else if (iDir == 4) {
				// Pointing 0, X = 1, Z = 1
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 5) {
				// Pointing 1, X = 0, Z = 0, Sloped
				tessellator.addVertexWithUV(d13,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d13,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 6) {
				// Pointing 2, X = 0, Z = 1, Sloped
				tessellator.addVertexWithUV(d13,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d13,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			} else if (iDir == 7) {
				// Pointing 3, X = 1, Z = 0
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			}
		}
	}

	public void renderIntCornersBottomFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
		double d5 = (double) i.getInterpolatedV(renderblocks.renderMinZ * 16.0D);
		double d6 = (double) i.getInterpolatedV(renderblocks.renderMaxZ * 16.0D);
		if (block.getBlockBoundsMinX() < 0.0D
			|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 = 0.0F;
			d4 = 15.99F;
		}
		if (block.getBlockBoundsMinZ() < 0.0D
			|| block.getBlockBoundsMaxZ() > 1.0D) {
			d5 = 0.0F;
			d6 = 15.99F;
		}
		double d7 = d + block.getBlockBoundsMinX();
		double d8 = d + block.getBlockBoundsMaxX();
		double d9 = d1 + block.getBlockBoundsMinY();
		double d10 = d2 + block.getBlockBoundsMinZ();
		double d11 = d2 + block.getBlockBoundsMaxZ();

		if (enableAO) {
			if (iDir / 4 == 0) {
				// Standard
				tessellator.setColorOpaque_F(	colorRedTopLeft_BottomFace,
												colorGreenTopLeft_BottomFace,
												colorBlueTopLeft_BottomFace);
				tessellator.addVertexWithUV(d7,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_BottomFace,
												colorGreenBottomLeft_BottomFace,
												colorBlueBottomLeft_BottomFace);
				tessellator.addVertexWithUV(d7,
											d9,
											d10,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_BottomFace,
												colorGreenBottomRight_BottomFace,
												colorBlueBottomRight_BottomFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d10,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_BottomFace,
												colorGreenTopRight_BottomFace,
												colorBlueTopRight_BottomFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
			}
		} else {
			if (iDir / 4 == 0) {
				// Standard
				tessellator.addVertexWithUV(d7,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d7,
											d9,
											d10,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d10,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
			}
		}
	}

	public void renderIntCornersTopFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
		double d5 = (double) i.getInterpolatedV(renderblocks.renderMinZ * 16.0D);
		double d6 = (double) i.getInterpolatedV(renderblocks.renderMaxZ * 16.0D);
		if (block.getBlockBoundsMinX() < 0.0D
			|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 = 0.0F;
			d4 = 15.99F;
		}
		if (block.getBlockBoundsMinZ() < 0.0D
			|| block.getBlockBoundsMaxZ() > 1.0D) {
			d5 = 0.0F;
			d6 = 15.99F;
		}
		double d7 = d + block.getBlockBoundsMinX();
		double d8 = d + block.getBlockBoundsMaxX();
		double d9 = d1 + block.getBlockBoundsMaxY();
		double d10 = d2 + block.getBlockBoundsMinZ();
		double d11 = d2 + block.getBlockBoundsMaxZ();

		if (enableAO) {
			if (iDir / 4 == 1) {
				// Standard
				tessellator.setColorOpaque_F(	colorRedTopLeft_TopFace,
												colorGreenTopLeft_TopFace,
												colorBlueTopLeft_TopFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_TopFace,
												colorGreenBottomLeft_TopFace,
												colorBlueBottomLeft_TopFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d10,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_TopFace,
												colorGreenBottomRight_TopFace,
												colorBlueBottomRight_TopFace);
				tessellator.addVertexWithUV(d7,
											d9,
											d10,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_TopFace,
												colorGreenTopRight_TopFace,
												colorBlueTopRight_TopFace);
				tessellator.addVertexWithUV(d7,
											d9,
											d11,
											d3,
											d6);
			}
		} else {
			if (iDir / 4 == 1) {
				// Standard
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d10,
											d4,
											d5);
				tessellator.addVertexWithUV(d7,
											d9,
											d10,
											d3,
											d5);
				tessellator.addVertexWithUV(d7,
											d9,
											d11,
											d3,
											d6);
			}
		}
	}

	public void renderIntCornersEastFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinZ * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxZ * 16.0D);
		double d5 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
		double d6 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
		if (renderblocks.flipTexture) {
			double d7 = d3;
			d3 = d4;
			d4 = d7;
		}
		if (block.getBlockBoundsMinX() < 0.0D
			|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 = 0.0F;
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
			if (iDir == 2) {
				// Triangle Down pointing south
				tessellator.setColorOpaque_F(	colorRedTopLeft_EastFace,
												colorGreenTopLeft_EastFace,
												colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_EastFace,
												colorGreenBottomRight_EastFace,
												colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_EastFace,
												colorGreenBottomRight_EastFace,
												colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_EastFace,
												colorGreenTopRight_EastFace,
												colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
				if (iDir == 2) {
					// Slope facing Up - East
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueZNeg + aoLightValueXPosZNeg)
															* (factorTop + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueZNeg + aoLightValueXPosZNeg)
															* (factorTop + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueZNeg + aoLightValueXPosZNeg)
															* (factorTop + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d10,
												d12,
												d4,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d11,
												d13,
												d3,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d11,
												d13,
												d3,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d11,
												d13,
												d4,
												d5);
				}
			} else if (iDir == 0) {
				// Triangle Down pointing north
				tessellator.setColorOpaque_F(	colorRedTopRight_EastFace,
												colorGreenTopRight_EastFace,
												colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_EastFace,
												colorGreenBottomLeft_EastFace,
												colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_EastFace,
												colorGreenBottomRight_EastFace,
												colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_EastFace,
												colorGreenTopRight_EastFace,
												colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);

				if (iDir == 0) {
					// Slope facing Up - East
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d11,
												d13,
												d4,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d11,
												d13,
												d4,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueZNeg + aoLightValueXNegZNeg)
															* (factorTop + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueZNeg + aoLightValueXNegZNeg)
															* (factorTop + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueZNeg + aoLightValueXNegZNeg)
															* (factorTop + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d10,
												d12,
												d3,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d11,
												d13,
												d3,
												d5);
				}
			} else if (iDir == 6) {
				// Triangle Up pointing south
				tessellator.setColorOpaque_F(	colorRedTopLeft_EastFace,
												colorGreenTopLeft_EastFace,
												colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_EastFace,
												colorGreenBottomLeft_EastFace,
												colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_EastFace,
												colorGreenBottomLeft_EastFace,
												colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_EastFace,
												colorGreenTopRight_EastFace,
												colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
				if (iDir == 6) {
					// Slope facing Down - East
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d10,
												d13,
												d3,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d10,
												d13,
												d3,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueZNeg + aoLightValueXPosZNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueZNeg + aoLightValueXPosZNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueZNeg + aoLightValueXPosZNeg)
															* (factorBottom + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d11,
												d12,
												d4,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d10,
												d13,
												d4,
												d6);
				}
			} else if (iDir == 4) {
				// Triangle Up pointing north
				tessellator.setColorOpaque_F(	colorRedTopLeft_EastFace,
												colorGreenTopLeft_EastFace,
												colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_EastFace,
												colorGreenBottomLeft_EastFace,
												colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_EastFace,
												colorGreenBottomRight_EastFace,
												colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopLeft_EastFace,
												colorGreenTopLeft_EastFace,
												colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);

				if (iDir == 4) {
					// Slope facing Down - East
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueZNeg + aoLightValueXNegZNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueZNeg + aoLightValueXNegZNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueZNeg + aoLightValueXNegZNeg)
															* (factorBottom + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d11,
												d12,
												d3,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d10,
												d13,
												d4,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d10,
												d13,
												d4,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorEast)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorEast)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d10,
												d13,
												d3,
												d6);
				}
			} else {
				// Standard
				tessellator.setColorOpaque_F(	colorRedTopLeft_EastFace,
												colorGreenTopLeft_EastFace,
												colorBlueTopLeft_EastFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_EastFace,
												colorGreenBottomLeft_EastFace,
												colorBlueBottomLeft_EastFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_EastFace,
												colorGreenBottomRight_EastFace,
												colorBlueBottomRight_EastFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_EastFace,
												colorGreenTopRight_EastFace,
												colorBlueTopRight_EastFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			}
		} else {
			if (iDir == 2) {
				// Pointing 1, X = 0, Z = 0
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
				if (iDir == 2) {
					// Slope pointing South-West
					tessellator.addVertexWithUV(d9,
												d10,
												d12,
												d4,
												d6);
					tessellator.addVertexWithUV(d8,
												d11,
												d13,
												d3,
												d5);
					tessellator.addVertexWithUV(d8,
												d11,
												d13,
												d3,
												d5);
					tessellator.addVertexWithUV(d9,
												d11,
												d13,
												d4,
												d5);
				}
			} else if (iDir == 0) {
				// Pointing 3, X = 1, Z = 0
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);

				if (iDir == 0) {
					// Slope pointing North-West
					tessellator.addVertexWithUV(d9,
												d11,
												d13,
												d4,
												d5);
					tessellator.addVertexWithUV(d9,
												d11,
												d13,
												d4,
												d5);
					tessellator.addVertexWithUV(d8,
												d10,
												d12,
												d3,
												d6);
					tessellator.addVertexWithUV(d8,
												d11,
												d13,
												d3,
												d5);
				}
			} else if (iDir == 6) {
				// Up Pointing 1, X = 0, Z = 0
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
				if (iDir == 6) {
					// Slope facing East
					tessellator.addVertexWithUV(d8,
												d10,
												d13,
												d3,
												d6);
					tessellator.addVertexWithUV(d8,
												d10,
												d13,
												d3,
												d6);
					tessellator.addVertexWithUV(d9,
												d11,
												d12,
												d4,
												d5);
					tessellator.addVertexWithUV(d9,
												d10,
												d13,
												d4,
												d6);
				}
			} else if (iDir == 4) {
				// Up Pointing 3, X = 1, Z = 0
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				if (iDir == 4) {
					// Slope facing East
					tessellator.addVertexWithUV(d8,
												d11,
												d12,
												d3,
												d5);
					tessellator.addVertexWithUV(d9,
												d10,
												d13,
												d4,
												d6);
					tessellator.addVertexWithUV(d9,
												d10,
												d13,
												d4,
												d6);
					tessellator.addVertexWithUV(d8,
												d10,
												d13,
												d3,
												d6);
				}
			} else {
				// Standard
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d6);
			}
		}
	}

	public void renderIntCornersWestFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinZ * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxZ * 16.0D);
		double d5 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
		double d6 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
		if (renderblocks.flipTexture) {
			double d7 = d3;
			d3 = d4;
			d4 = d7;
		}
		if (block.getBlockBoundsMinX() < 0.0D
			|| block.getBlockBoundsMaxX() > 1.0D) {
			d3 = 0.0F;
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
		double d12 = d2 + block.getBlockBoundsMaxZ();
		double d13 = d2 + block.getBlockBoundsMinZ();

		if (enableAO) {
			if (iDir == 3) {
				// Triangle Down pointing north
				tessellator.setColorOpaque_F(	colorRedBottomLeft_WestFace,
												colorGreenBottomLeft_WestFace,
												colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_WestFace,
												colorGreenBottomLeft_WestFace,
												colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_WestFace,
												colorGreenBottomRight_WestFace,
												colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_WestFace,
												colorGreenTopRight_WestFace,
												colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
				if (iDir == 3) {
					// Slope Facing Up - West
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d11,
												d13,
												d4,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d11,
												d13,
												d3,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueZPos + aoLightValueXNegZPos)
															* (factorTop + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueZPos + aoLightValueXNegZPos)
															* (factorTop + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueZPos + aoLightValueXNegZPos)
															* (factorTop + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d10,
												d12,
												d3,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d11,
												d13,
												d4,
												d5);
				}
			} else if (iDir == 1) {
				// Triangle Down pointing south
				tessellator.setColorOpaque_F(	colorRedTopLeft_WestFace,
												colorGreenTopLeft_WestFace,
												colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_WestFace,
												colorGreenBottomLeft_WestFace,
												colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_WestFace,
												colorGreenBottomRight_WestFace,
												colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_WestFace,
												colorGreenBottomRight_WestFace,
												colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				if (iDir == 1) {
					// Slope Facing Up - West
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueZPos + aoLightValueXPosZPos)
															* (factorTop + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueZPos + aoLightValueXPosZPos)
															* (factorTop + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueZPos + aoLightValueXPosZPos)
															* (factorTop + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d10,
												d12,
												d4,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueXPosYPos)
															* (factorTop + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d11,
												d13,
												d4,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d11,
												d13,
												d3,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueXNegYPos)
															* (factorTop + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d11,
												d13,
												d3,
												d5);
				}
			} else if (iDir == 7) {
				// Triangle Up pointing north
				tessellator.setColorOpaque_F(	colorRedTopLeft_WestFace,
												colorGreenTopLeft_WestFace,
												colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopLeft_WestFace,
												colorGreenTopLeft_WestFace,
												colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_WestFace,
												colorGreenBottomRight_WestFace,
												colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_WestFace,
												colorGreenTopRight_WestFace,
												colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
				if (iDir == 7) {
					// Slope Facing Down - West
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueZPos + aoLightValueXNegZPos)
															* (factorBottom + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueZPos + aoLightValueXNegZPos)
															* (factorBottom + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueZPos + aoLightValueXNegZPos)
															* (factorBottom + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d11,
												d12,
												d3,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d10,
												d13,
												d3,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d10,
												d13,
												d4,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d10,
												d13,
												d4,
												d6);
				}
			} else if (iDir == 5) {
				// Triangle Up pointing south
				tessellator.setColorOpaque_F(	colorRedTopLeft_WestFace,
												colorGreenTopLeft_WestFace,
												colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_WestFace,
												colorGreenBottomLeft_WestFace,
												colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_WestFace,
												colorGreenTopRight_WestFace,
												colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_WestFace,
												colorGreenTopRight_WestFace,
												colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);

				if (iDir == 5) {
					// Slope Facing Down - West
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d10,
												d13,
												d3,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueXPosYNeg)
															* (factorBottom + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d10,
												d13,
												d4,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueZPos + aoLightValueXPosZPos)
															* (factorBottom + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueZPos + aoLightValueXPosZPos)
															* (factorBottom + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueZPos + aoLightValueXPosZPos)
															* (factorBottom + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d9,
												d11,
												d12,
												d4,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorWest)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorWest)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueXNegYNeg)
															* (factorBottom + factorWest)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d10,
												d13,
												d3,
												d6);
				}
			} else {
				// Standard
				tessellator.setColorOpaque_F(	colorRedTopLeft_WestFace,
												colorGreenTopLeft_WestFace,
												colorBlueTopLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_WestFace,
												colorGreenBottomLeft_WestFace,
												colorBlueBottomLeft_WestFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_WestFace,
												colorGreenBottomRight_WestFace,
												colorBlueBottomRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_WestFace,
												colorGreenTopRight_WestFace,
												colorBlueTopRight_WestFace);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			}
		} else {
			if (iDir == 3) {
				// Pointing 0, X = 1, Z = 1
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
				if (iDir == 3) {
					// Slope pointing North-East
					tessellator.addVertexWithUV(d9,
												d11,
												d13,
												d4,
												d5);
					tessellator.addVertexWithUV(d8,
												d11,
												d13,
												d3,
												d5);
					tessellator.addVertexWithUV(d8,
												d10,
												d12,
												d3,
												d6);
					tessellator.addVertexWithUV(d9,
												d11,
												d13,
												d4,
												d5);
				}
			} else if (iDir == 1) {
				// Pointing 2, X = 0, Z = 1
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				if (iDir == 1) {
					// Slope pointing South-East
					tessellator.addVertexWithUV(d9,
												d10,
												d12,
												d4,
												d6);
					tessellator.addVertexWithUV(d9,
												d11,
												d13,
												d4,
												d5);
					tessellator.addVertexWithUV(d8,
												d11,
												d13,
												d3,
												d5);
					tessellator.addVertexWithUV(d8,
												d11,
												d13,
												d3,
												d5);
				}
			} else if (iDir == 7) {
				// Up Pointing 0, X = 1, Z = 1
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			} else if (iDir == 5) {
				// Up Pointing 2, X = 0, Z = 1
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
				if (iDir == 5) {
					// Slope facing West
					tessellator.addVertexWithUV(d8,
												d10,
												d13,
												d3,
												d6);
					tessellator.addVertexWithUV(d9,
												d10,
												d13,
												d4,
												d6);
					tessellator.addVertexWithUV(d9,
												d11,
												d12,
												d4,
												d5);
					tessellator.addVertexWithUV(d8,
												d10,
												d13,
												d3,
												d6);
				}
			} else {
				// Standard
				tessellator.addVertexWithUV(d8,
											d11,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d9,
											d10,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d9,
											d11,
											d12,
											d4,
											d5);
			}
		}
	}

	public void renderIntCornersNorthFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
		double d5 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
		double d6 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
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
			if (iDir == 3) {
				// Triangle Down pointing west
				tessellator.setColorOpaque_F(	colorRedTopRight_NorthFace,
												colorGreenTopRight_NorthFace,
												colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_NorthFace,
												colorGreenBottomLeft_NorthFace,
												colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_NorthFace,
												colorGreenBottomRight_NorthFace,
												colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_NorthFace,
												colorGreenTopRight_NorthFace,
												colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);

				if (iDir == 3) {
					// Slope facing Up - North
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d10,
												d11,
												d4,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d10,
												d11,
												d4,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueXNeg + aoLightValueXNegZPos)
															* (factorTop + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueXNeg + aoLightValueXNegZPos)
															* (factorTop + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueXNeg + aoLightValueXNegZPos)
															* (factorTop + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d9,
												d12,
												d3,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d10,
												d12,
												d3,
												d5);
				}
			} else if (iDir == 0) {
				// Triangle Down pointing east
				tessellator.setColorOpaque_F(	colorRedTopLeft_NorthFace,
												colorGreenTopLeft_NorthFace,
												colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_NorthFace,
												colorGreenBottomRight_NorthFace,
												colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_NorthFace,
												colorGreenBottomRight_NorthFace,
												colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_NorthFace,
												colorGreenTopRight_NorthFace,
												colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
				if (iDir == 0) {
					// Slope facing Up - North
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d10,
												d12,
												d4,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d10,
												d11,
												d3,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueXNeg + aoLightValueXNegZNeg)
															* (factorTop + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueXNeg + aoLightValueXNegZNeg)
															* (factorTop + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueXNeg + aoLightValueXNegZNeg)
															* (factorTop + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d9,
												d11,
												d3,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d10,
												d12,
												d4,
												d5);
				}
			} else if (iDir == 7) {
				// Triangle Up pointing west
				tessellator.setColorOpaque_F(	colorRedTopLeft_NorthFace,
												colorGreenTopLeft_NorthFace,
												colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_NorthFace,
												colorGreenBottomLeft_NorthFace,
												colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_NorthFace,
												colorGreenBottomRight_NorthFace,
												colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopLeft_NorthFace,
												colorGreenTopLeft_NorthFace,
												colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);

				if (iDir == 7) {
					// Slope facing Down - North
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueXNeg + aoLightValueXNegZPos)
															* (factorBottom + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueXNeg + aoLightValueXNegZPos)
															* (factorBottom + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueXNeg + aoLightValueXNegZPos)
															* (factorBottom + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d10,
												d12,
												d3,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d9,
												d11,
												d4,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d9,
												d11,
												d4,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d9,
												d12,
												d3,
												d6);
				}
			} else if (iDir == 4) {
				// Triangle Up pointing east
				tessellator.setColorOpaque_F(	colorRedTopLeft_NorthFace,
												colorGreenTopLeft_NorthFace,
												colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_NorthFace,
												colorGreenBottomLeft_NorthFace,
												colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_NorthFace,
												colorGreenBottomLeft_NorthFace,
												colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_NorthFace,
												colorGreenTopRight_NorthFace,
												colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
				if (iDir == 4) {
					// Slope facing Down - North
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueXNeg + aoLightValueXNegZNeg)
															* (factorBottom + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueXNeg + aoLightValueXNegZNeg)
															* (factorBottom + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueXNeg + aoLightValueXNegZNeg)
															* (factorBottom + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d10,
												d11,
												d3,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d9,
												d11,
												d3,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d9,
												d12,
												d4,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorNorth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorNorth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorNorth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d9,
												d12,
												d4,
												d6);
				}
			} else {
				// Standard
				tessellator.setColorOpaque_F(	colorRedTopLeft_NorthFace,
												colorGreenTopLeft_NorthFace,
												colorBlueTopLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_NorthFace,
												colorGreenBottomLeft_NorthFace,
												colorBlueBottomLeft_NorthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_NorthFace,
												colorGreenBottomRight_NorthFace,
												colorBlueBottomRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_NorthFace,
												colorGreenTopRight_NorthFace,
												colorBlueTopRight_NorthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			}
		} else {
			if (iDir == 3) {
				// Pointing 1, X = 0, Z = 0
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);

				if (iDir == 3) {
					// Slope pointing South-West
					tessellator.addVertexWithUV(d13,
												d10,
												d11,
												d4,
												d5);
					tessellator.addVertexWithUV(d13,
												d10,
												d11,
												d4,
												d5);
					tessellator.addVertexWithUV(d8,
												d9,
												d12,
												d3,
												d6);
					tessellator.addVertexWithUV(d13,
												d10,
												d12,
												d3,
												d5);
				}
			} else if (iDir == 0) {
				// Pointing 2, X = 0, Z = 1
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
				if (iDir == 0) {
					// Slope pointing South-East
					tessellator.addVertexWithUV(d13,
												d10,
												d12,
												d4,
												d5);
					tessellator.addVertexWithUV(d13,
												d10,
												d11,
												d3,
												d5);
					tessellator.addVertexWithUV(d8,
												d9,
												d11,
												d3,
												d6);
					tessellator.addVertexWithUV(d13,
												d10,
												d12,
												d4,
												d5);
				}
			} else if (iDir == 7) {
				// up Pointing 1, X = 0, Z = 0
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);

				if (iDir == 7) {
					// Slope facing North
					tessellator.addVertexWithUV(d8,
												d10,
												d12,
												d3,
												d5);
					tessellator.addVertexWithUV(d13,
												d9,
												d11,
												d4,
												d6);
					tessellator.addVertexWithUV(d13,
												d9,
												d11,
												d4,
												d6);
					tessellator.addVertexWithUV(d13,
												d9,
												d12,
												d3,
												d6);
				}
			} else if (iDir == 4) {
				// up Pointing 2, X = 0, Z = 1
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
				if (iDir == 4) {
					// Slope facing North
					tessellator.addVertexWithUV(d8,
												d10,
												d11,
												d3,
												d5);
					tessellator.addVertexWithUV(d13,
												d9,
												d11,
												d3,
												d6);
					tessellator.addVertexWithUV(d13,
												d9,
												d12,
												d4,
												d6);
					tessellator.addVertexWithUV(d13,
												d9,
												d12,
												d4,
												d6);
				}
			} else {
				// Standard
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d4,
											d6);
			}
		}
	}

	public void renderIntCornersSouthFace(Block block, double d, double d1, double d2, Icon i, int iDir, RenderBlocks renderblocks, int lBrightness) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(lBrightness);
		if (renderblocks.hasOverrideBlockTexture()) {
			i = renderblocks.overrideBlockTexture;
		}

		double d3 = (double) i.getInterpolatedU(renderblocks.renderMinX * 16.0D);
		double d4 = (double) i.getInterpolatedU(renderblocks.renderMaxX * 16.0D);
		double d5 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMaxY * 16.0D);
		double d6 = (double) i.getInterpolatedV(16.0D - renderblocks.renderMinY * 16.0D);
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
		double d8 = d + block.getBlockBoundsMaxX();
		double d9 = d1 + block.getBlockBoundsMinY();
		double d10 = d1 + block.getBlockBoundsMaxY();
		double d11 = d2 + block.getBlockBoundsMinZ();
		double d12 = d2 + block.getBlockBoundsMaxZ();
		double d13 = d + block.getBlockBoundsMinX();

		if (enableAO) {
			if (iDir == 2) {
				// Triangle Down pointing east
				tessellator.setColorOpaque_F(	colorRedTopLeft_SouthFace,
												colorGreenTopLeft_SouthFace,
												colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_SouthFace,
												colorGreenBottomLeft_SouthFace,
												colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_SouthFace,
												colorGreenBottomLeft_SouthFace,
												colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedTopRight_SouthFace,
												colorGreenTopRight_SouthFace,
												colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
				if (iDir == 2) {
					// Slope facing Up - South
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueXPos + aoLightValueXPosZNeg)
															* (factorTop + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueXPos + aoLightValueXPosZNeg)
															* (factorTop + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueXPos + aoLightValueXPosZNeg)
															* (factorTop + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d9,
												d11,
												d4,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d10,
												d11,
												d4,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d10,
												d12,
												d3,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d10,
												d12,
												d3,
												d5);
				}
			} else if (iDir == 1) {
				// Triangle Down pointing west
				tessellator.setColorOpaque_F(	colorRedTopLeft_SouthFace,
												colorGreenTopLeft_SouthFace,
												colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_SouthFace,
												colorGreenBottomLeft_SouthFace,
												colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_SouthFace,
												colorGreenBottomRight_SouthFace,
												colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopLeft_SouthFace,
												colorGreenTopLeft_SouthFace,
												colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				if (iDir == 1) {
					// Slope facing Up - South
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueXPos + aoLightValueXPosZPos)
															* (factorTop + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueXPos + aoLightValueXPosZPos)
															* (factorTop + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueXPos + aoLightValueXPosZPos)
															* (factorTop + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d9,
												d12,
												d4,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d10,
												d11,
												d3,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueYPosZNeg)
															* (factorTop + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d10,
												d11,
												d3,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYPos + aoLightValueYPosZPos)
															* (factorTop + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d10,
												d12,
												d4,
												d5);
				}
			} else if (iDir == 6) {
				// Triangle Up pointing east
				tessellator.setColorOpaque_F(	colorRedTopLeft_SouthFace,
												colorGreenTopLeft_SouthFace,
												colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_SouthFace,
												colorGreenBottomRight_SouthFace,
												colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomRight_SouthFace,
												colorGreenBottomRight_SouthFace,
												colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_SouthFace,
												colorGreenTopRight_SouthFace,
												colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
				if (iDir == 6) {
					// Slope facing Down - South
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d9,
												d12,
												d3,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d9,
												d11,
												d4,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueXPos + aoLightValueXPosZNeg)
															* (factorBottom + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueXPos + aoLightValueXPosZNeg)
															* (factorBottom + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueXPos + aoLightValueXPosZNeg)
															* (factorBottom + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d10,
												d11,
												d4,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d9,
												d12,
												d3,
												d6);
				}
			} else if (iDir == 5) {
				// Triangle Up pointing west
				tessellator.setColorOpaque_F(	colorRedTopRight_SouthFace,
												colorGreenTopRight_SouthFace,
												colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_SouthFace,
												colorGreenBottomLeft_SouthFace,
												colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_SouthFace,
												colorGreenBottomRight_SouthFace,
												colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_SouthFace,
												colorGreenTopRight_SouthFace,
												colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
				if (iDir == 5) {
					// Slope facing Down - South
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d9,
												d11,
												d3,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueYNegZNeg)
															* (factorBottom + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d9,
												d11,
												d3,
												d6);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueXPos + aoLightValueXPosZPos)
															* (factorBottom + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueXPos + aoLightValueXPosZPos)
															* (factorBottom + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueXPos + aoLightValueXPosZPos)
															* (factorBottom + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d8,
												d10,
												d12,
												d4,
												d5);
					tessellator.setColorOpaque_F(	colorRedSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorSouth)
															/ 4F,
													colorGreenSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorSouth)
															/ 4F,
													colorBlueSlopes
															* (aoLightValueYNeg + aoLightValueYNegZPos)
															* (factorBottom + factorSouth)
															/ 4F);
					tessellator.addVertexWithUV(d13,
												d9,
												d12,
												d4,
												d6);
				}
			} else {
				// Standard
				tessellator.setColorOpaque_F(	colorRedTopLeft_SouthFace,
												colorGreenTopLeft_SouthFace,
												colorBlueTopLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomLeft_SouthFace,
												colorGreenBottomLeft_SouthFace,
												colorBlueBottomLeft_SouthFace);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.setColorOpaque_F(	colorRedBottomRight_SouthFace,
												colorGreenBottomRight_SouthFace,
												colorBlueBottomRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.setColorOpaque_F(	colorRedTopRight_SouthFace,
												colorGreenTopRight_SouthFace,
												colorBlueTopRight_SouthFace);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			}
		} else {
			if (iDir == 2) {
				// Pointing 0, X = 1, Z = 1
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
				if (iDir == 2) {
					// Slope pointing North-East
					tessellator.addVertexWithUV(d8,
												d9,
												d11,
												d4,
												d6);
					tessellator.addVertexWithUV(d13,
												d10,
												d11,
												d4,
												d5);
					tessellator.addVertexWithUV(d13,
												d10,
												d12,
												d3,
												d5);
					tessellator.addVertexWithUV(d13,
												d10,
												d12,
												d3,
												d5);
				}
			} else if (iDir == 1) {
				// Pointing 3, X = 1, Z = 0
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				if (iDir == 1) {
					// Slope pointing North-West
					tessellator.addVertexWithUV(d8,
												d9,
												d12,
												d4,
												d6);
					tessellator.addVertexWithUV(d13,
												d10,
												d11,
												d3,
												d5);
					tessellator.addVertexWithUV(d13,
												d10,
												d11,
												d3,
												d5);
					tessellator.addVertexWithUV(d13,
												d10,
												d12,
												d4,
												d5);
				}
			} else if (iDir == 6) {
				// Pointing 0, X = 1, Z = 1
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
				if (iDir == 6) {
					// Slope facing South
					tessellator.addVertexWithUV(d13,
												d9,
												d12,
												d3,
												d6);
					tessellator.addVertexWithUV(d13,
												d9,
												d11,
												d4,
												d6);
					tessellator.addVertexWithUV(d8,
												d10,
												d11,
												d4,
												d5);
					tessellator.addVertexWithUV(d13,
												d9,
												d12,
												d3,
												d6);
				}
			} else if (iDir == 5) {
				// Pointing 3, X = 1, Z = 0
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
				if (iDir == 5) {
					// Slope facing South
					tessellator.addVertexWithUV(d13,
												d9,
												d11,
												d3,
												d6);
					tessellator.addVertexWithUV(d13,
												d9,
												d11,
												d3,
												d6);
					tessellator.addVertexWithUV(d8,
												d10,
												d12,
												d4,
												d5);
					tessellator.addVertexWithUV(d13,
												d9,
												d12,
												d4,
												d6);
				}
			} else {
				// Standard
				tessellator.addVertexWithUV(d8,
											d9,
											d12,
											d3,
											d6);
				tessellator.addVertexWithUV(d8,
											d9,
											d11,
											d4,
											d6);
				tessellator.addVertexWithUV(d8,
											d10,
											d11,
											d4,
											d5);
				tessellator.addVertexWithUV(d8,
											d10,
											d12,
											d3,
											d5);
			}
		}
	}

}
