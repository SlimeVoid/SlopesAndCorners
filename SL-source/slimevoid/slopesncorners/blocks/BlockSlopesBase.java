package slimevoid.slopesncorners.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import slimevoid.slopesncorners.api.ISlopePlacement;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.items.ItemBlockSlope;
import slimevoidlib.blocks.BlockBase;

public class BlockSlopesBase extends BlockBase {

	protected BlockSlopesBase(int blockID, Material material, int maxTiles) {
		super(blockID, material, maxTiles);
	}

	@Override
	public CreativeTabs getCreativeTab() {
		return ConfigurationLib.slopesTab;
	}

	@Override
	public int getRenderType() {
		return ConfigurationLib.slopesRenderID;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i,
			int j, int k, int l) {
		return true;
	}

	public void registerPlacement(int md, ISlopePlacement isp) {
		((ItemBlockSlope) Item.itemsList[this.blockID]).registerPlacement(md, isp);
	}

}
