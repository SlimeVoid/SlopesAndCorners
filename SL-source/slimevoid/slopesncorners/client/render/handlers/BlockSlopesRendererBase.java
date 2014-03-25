package slimevoid.slopesncorners.client.render.handlers;

import slimevoid.slopesncorners.tileentity.TileEntitySlopesBase;
import com.slimevoid.library.blocks.BlockBase;
import com.slimevoid.library.util.helpers.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public abstract class BlockSlopesRendererBase implements
		ISimpleBlockRenderingHandler {

	public boolean	field_27406_a						= true;
	public boolean	field_27511_cfgGrassFix				= true;
	public boolean	enableAO							= false;
	public float	aoLightValueThis					= 0.0f;
	public float	aoLightValueXNeg					= 0.0f;
	public float	aoLightValueYNeg					= 0.0f;
	public float	aoLightValueZNeg					= 0.0f;
	public float	aoLightValueXPos					= 0.0f;
	public float	aoLightValueYPos					= 0.0f;
	public float	aoLightValueZPos					= 0.0f;
	public float	aoLightValueXNegYNegZNeg			= 0.0f;
	public float	aoLightValueXNegYNeg				= 0.0f;
	public float	aoLightValueXNegYNegZPos			= 0.0f;
	public float	aoLightValueYNegZNeg				= 0.0f;
	public float	aoLightValueYNegZPos				= 0.0f;
	public float	aoLightValueXPosYNegZNeg			= 0.0f;
	public float	aoLightValueXPosYNeg				= 0.0f;
	public float	aoLightValueXPosYNegZPos			= 0.0f;
	public float	aoLightValueXNegYPosZNeg			= 0.0f;
	public float	aoLightValueXNegYPos				= 0.0f;
	public float	aoLightValueXNegYPosZPos			= 0.0f;
	public float	aoLightValueYPosZNeg				= 0.0f;
	public float	aoLightValueXPosYPosZNeg			= 0.0f;
	public float	aoLightValueXPosYPos				= 0.0f;
	public float	aoLightValueYPosZPos				= 0.0f;
	public float	aoLightValueXPosYPosZPos			= 0.0f;
	public float	aoLightValueXNegZNeg				= 0.0f;
	public float	aoLightValueXPosZNeg				= 0.0f;
	public float	aoLightValueXNegZPos				= 0.0f;
	public float	aoLightValueXPosZPos				= 0.0f;
	public int		field_22352_G						= 1;
	public boolean	isBlockYPosZNeg						= false;
	public boolean	isBlockXPosYPos						= false;
	public boolean	isBlockXNegYPos						= false;
	public boolean	isBlockYPosZPos						= false;
	public boolean	isBlockXNegZNeg						= false;
	public boolean	isBlockXPosZPos						= false;
	public boolean	isBlockXNegZPos						= false;
	public boolean	isBlockXPosZNeg						= false;
	public boolean	isBlockYNegZNeg						= false;
	public boolean	isBlockXPosYNeg						= false;
	public boolean	isBlockXNegYNeg						= false;
	public boolean	isBlockYNegZPos						= false;
	public int		field_27510_blockX;
	public int		field_27509_blockY;
	public int		field_27508_blockZ;

	public float	factorTop							= 1.0F;
	public float	factorBottom						= 0.5F;
	public float	factorEast							= 0.8F;
	public float	factorWest							= 0.8F;
	public float	factorNorth							= 0.6F;
	public float	factorSouth							= 0.6F;

	public float	colorRedTopLeft_TopFace				= 0.0f;
	public float	colorRedBottomLeft_TopFace			= 0.0f;
	public float	colorRedBottomRight_TopFace			= 0.0f;
	public float	colorRedTopRight_TopFace			= 0.0f;
	public float	colorGreenTopLeft_TopFace			= 0.0f;
	public float	colorGreenBottomLeft_TopFace		= 0.0f;
	public float	colorGreenBottomRight_TopFace		= 0.0f;
	public float	colorGreenTopRight_TopFace			= 0.0f;
	public float	colorBlueTopLeft_TopFace			= 0.0f;
	public float	colorBlueBottomLeft_TopFace			= 0.0f;
	public float	colorBlueBottomRight_TopFace		= 0.0f;
	public float	colorBlueTopRight_TopFace			= 0.0f;

	public float	colorRedTopLeft_BottomFace			= 0.0f;
	public float	colorRedBottomLeft_BottomFace		= 0.0f;
	public float	colorRedBottomRight_BottomFace		= 0.0f;
	public float	colorRedTopRight_BottomFace			= 0.0f;
	public float	colorGreenTopLeft_BottomFace		= 0.0f;
	public float	colorGreenBottomLeft_BottomFace		= 0.0f;
	public float	colorGreenBottomRight_BottomFace	= 0.0f;
	public float	colorGreenTopRight_BottomFace		= 0.0f;
	public float	colorBlueTopLeft_BottomFace			= 0.0f;
	public float	colorBlueBottomLeft_BottomFace		= 0.0f;
	public float	colorBlueBottomRight_BottomFace		= 0.0f;
	public float	colorBlueTopRight_BottomFace		= 0.0f;

	public float	colorRedTopLeft_EastFace			= 0.0f;
	public float	colorRedBottomLeft_EastFace			= 0.0f;
	public float	colorRedBottomRight_EastFace		= 0.0f;
	public float	colorRedTopRight_EastFace			= 0.0f;
	public float	colorGreenTopLeft_EastFace			= 0.0f;
	public float	colorGreenBottomLeft_EastFace		= 0.0f;
	public float	colorGreenBottomRight_EastFace		= 0.0f;
	public float	colorGreenTopRight_EastFace			= 0.0f;
	public float	colorBlueTopLeft_EastFace			= 0.0f;
	public float	colorBlueBottomLeft_EastFace		= 0.0f;
	public float	colorBlueBottomRight_EastFace		= 0.0f;
	public float	colorBlueTopRight_EastFace			= 0.0f;

	public float	colorRedTopLeft_WestFace			= 0.0f;
	public float	colorRedBottomLeft_WestFace			= 0.0f;
	public float	colorRedBottomRight_WestFace		= 0.0f;
	public float	colorRedTopRight_WestFace			= 0.0f;
	public float	colorGreenTopLeft_WestFace			= 0.0f;
	public float	colorGreenBottomLeft_WestFace		= 0.0f;
	public float	colorGreenBottomRight_WestFace		= 0.0f;
	public float	colorGreenTopRight_WestFace			= 0.0f;
	public float	colorBlueTopLeft_WestFace			= 0.0f;
	public float	colorBlueBottomLeft_WestFace		= 0.0f;
	public float	colorBlueBottomRight_WestFace		= 0.0f;
	public float	colorBlueTopRight_WestFace			= 0.0f;

	public float	colorRedTopLeft_NorthFace			= 0.0f;
	public float	colorRedBottomLeft_NorthFace		= 0.0f;
	public float	colorRedBottomRight_NorthFace		= 0.0f;
	public float	colorRedTopRight_NorthFace			= 0.0f;
	public float	colorGreenTopLeft_NorthFace			= 0.0f;
	public float	colorGreenBottomLeft_NorthFace		= 0.0f;
	public float	colorGreenBottomRight_NorthFace		= 0.0f;
	public float	colorGreenTopRight_NorthFace		= 0.0f;
	public float	colorBlueTopLeft_NorthFace			= 0.0f;
	public float	colorBlueBottomLeft_NorthFace		= 0.0f;
	public float	colorBlueBottomRight_NorthFace		= 0.0f;
	public float	colorBlueTopRight_NorthFace			= 0.0f;

	public float	colorRedTopLeft_SouthFace			= 0.0f;
	public float	colorRedBottomLeft_SouthFace		= 0.0f;
	public float	colorRedBottomRight_SouthFace		= 0.0f;
	public float	colorRedTopRight_SouthFace			= 0.0f;
	public float	colorGreenTopLeft_SouthFace			= 0.0f;
	public float	colorGreenBottomLeft_SouthFace		= 0.0f;
	public float	colorGreenBottomRight_SouthFace		= 0.0f;
	public float	colorGreenTopRight_SouthFace		= 0.0f;
	public float	colorBlueTopLeft_SouthFace			= 0.0f;
	public float	colorBlueBottomLeft_SouthFace		= 0.0f;
	public float	colorBlueBottomRight_SouthFace		= 0.0f;
	public float	colorBlueTopRight_SouthFace			= 0.0f;

	public float	colorRedSlopes						= 0.0f;
	public float	colorGreenSlopes					= 0.0f;
	public float	colorBlueSlopes						= 0.0f;

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int metadata, RenderBlocks renderer) {
		TileEntitySlopesBase tile = (TileEntitySlopesBase) BlockHelper.getTileEntity(	world,
																						x,
																						y,
																						z,
																						((BlockBase) block).getTileMapData(metadata));
		int iDir = tile.getRotation();
		int l = block.colorMultiplier(	world,
										x,
										y,
										z);
		float f = (l >> 16 & 0xff) / 255F;
		float f1 = (l >> 8 & 0xff) / 255F;
		float f2 = (l & 0xff) / 255F;

		if (Minecraft.isAmbientOcclusionEnabled()) {
			return this.renderCustomBlockWithAmbientOcclusion(	block,
																x,
																y,
																z,
																f,
																f1,
																f2,
																iDir,
																metadata,
																renderer,
																world);
		} else {
			return renderCustomBlockBlockWithColorMultiplier(	block,
																x,
																y,
																z,
																f,
																f1,
																f2,
																iDir,
																metadata,
																renderer,
																world);
		}
	}

	protected abstract boolean renderCustomBlockBlockWithColorMultiplier(Block block, int x, int y, int z, float f, float f1, float f2, int iDir, int modelId, RenderBlocks renderer, IBlockAccess world);

	protected abstract boolean renderCustomBlockWithAmbientOcclusion(Block block, int x, int y, int z, float f, float f1, float f2, int iDir, int modelId, RenderBlocks renderer, IBlockAccess world);

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return -1;
	}

}
