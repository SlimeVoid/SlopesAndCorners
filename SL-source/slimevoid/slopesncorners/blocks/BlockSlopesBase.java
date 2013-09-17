package slimevoid.slopesncorners.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import slimevoid.slopesncorners.api.ISlopePlacement;
import slimevoid.slopesncorners.core.lib.BlockLib;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.items.ItemBlockSlope;
import slimevoidlib.blocks.BlockBase;

public class BlockSlopesBase extends BlockBase {
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(BlockLib.DEFAULT_ICON);
	}

	public BlockSlopesBase(int blockID, Material material, int maxTiles) {
		super(blockID, material, maxTiles);
	}

	@Override
	public CreativeTabs getCreativeTab() {
		return null;
	}
	
	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	    {
	    if (Item.itemsList[this.blockID] != null){
	      return ((ItemBlockSlope) Item.itemsList[this.blockID]).getCreativeTabs()[0];
	    }else{
	      return null;
	    }
	}

	@SideOnly(Side.CLIENT)
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

	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta) {
		return true;
	}
	
	@Override
	public Icon getIcon(int side, int meta){
		return this.blockIcon;
		
	}
}
