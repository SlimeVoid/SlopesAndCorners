package slimevoid.slopesncorners.client.render;

import java.util.HashMap;

import slimevoid.slopesncorners.blocks.BlockSlopesBase;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.tileentity.TileEntitySlopesBase;
import com.slimevoid.library.util.helpers.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class BlockSlopesRenderer implements ISimpleBlockRenderingHandler {

	private HashMap<Integer, ISimpleBlockRenderingHandler>	slopeRenderers	= new HashMap<Integer, ISimpleBlockRenderingHandler>();

	public void registerSlopeRenderer(int metadata, ISimpleBlockRenderingHandler renderer) {
		if (!slopeRenderers.containsKey(metadata)) {
			slopeRenderers.put(	metadata,
								renderer);
		}
	}

	public ISimpleBlockRenderingHandler getSlopeRenderer(int metadata) {
		if (slopeRenderers.containsKey(metadata)) {
			return slopeRenderers.get(metadata);
		}
		return null;
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		if (modelID == ConfigurationLib.slopesRenderID) {
			if (block instanceof BlockSlopesBase) {
				int renderIndex = metadata >> 12;
				ISimpleBlockRenderingHandler handler = getSlopeRenderer(renderIndex);
				if (handler != null) {
					handler.renderInventoryBlock(	block,
													metadata,
													modelID,
													renderer);
				}
			}
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		if (modelId == ConfigurationLib.slopesRenderID) {
			if (block instanceof BlockSlopesBase) {
				int metadata = world.getBlockMetadata(	x,
														y,
														z);
				TileEntitySlopesBase tileentity = (TileEntitySlopesBase) BlockHelper.getTileEntity(	world,
																									x,
																									y,
																									z,
																									((BlockSlopesBase) block).getTileMapData(metadata));
				if (tileentity != null) {
					ISimpleBlockRenderingHandler handler = getSlopeRenderer(metadata);
					if (handler != null) {
						handler.renderWorldBlock(	world,
													x,
													y,
													z,
													block,
													metadata,
													renderer);
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return ConfigurationLib.slopesRenderID;
	}

}
