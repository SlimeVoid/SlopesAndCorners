package slimevoid.slopesncorners.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import slimevoid.slopesncorners.api.ISlopePlacement;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.items.ItemBlockSlope;
import slimevoidlib.blocks.BlockBase;

public class BlockSlopesBase extends BlockBase {

	public BlockSlopesBase(int blockID, Material material, int maxTiles) {
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
	
	//@Override
	//public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int damage) {
	//	return side != 0 && (side == 1 || (double)hitY <= 0.5D) ? 0 : 0 | 4;
	//}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i,
			int j, int k, int l) {
		return true;
	}	
	
	public void registerPlacement(int md, ISlopePlacement isp) {
		((ItemBlockSlope) Item.itemsList[this.blockID]).registerPlacement(md, isp);
	}

}
