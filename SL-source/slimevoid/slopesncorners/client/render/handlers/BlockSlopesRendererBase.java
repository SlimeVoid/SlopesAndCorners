package slimevoid.slopesncorners.client.render.handlers;

import slimevoid.slopesncorners.tileentity.TileEntitySlopesBase;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public abstract class BlockSlopesRendererBase implements ISimpleBlockRenderingHandler {

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
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
			TileEntitySlopesBase tile = (TileEntitySlopesBase)world.getBlockTileEntity(x, y, z);
			int iDir = tile.getRotation();
			int l = block.colorMultiplier(world, x, y, z);
			float f = (l >> 16 & 0xff) / 255F;
			float f1 = (l >> 8 & 0xff) / 255F;
			float f2 = (l & 0xff) / 255F;

			if (Minecraft.isAmbientOcclusionEnabled()) {
				return this.renderCustomBlockWithAmbientOcclusion(block, x, y, z, f,
						f1, f2, iDir,modelId, renderer, world);
			} else {
				return renderCustomBlockBlockWithColorMultiplier(block, x, y, z, f,
						f1, f2, iDir,modelId, renderer, world);
			}
	}

	protected abstract boolean renderCustomBlockBlockWithColorMultiplier(Block block, int x, int y, int z,
			float f, float f1, float f2, int iDir, int modelId, RenderBlocks renderer, IBlockAccess world);

	protected abstract boolean renderCustomBlockWithAmbientOcclusion(Block block, int x, int y, int z, 
			float f, float f1, float f2, int iDir, int modelId, RenderBlocks renderer, IBlockAccess world);	
	
	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return -1;
	}

}
