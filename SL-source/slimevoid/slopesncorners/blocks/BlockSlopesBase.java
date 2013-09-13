package slimevoid.slopesncorners.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import slimevoid.slopesncorners.api.ISlopePlacement;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.items.ItemBlockSlope;
import slimevoid.slopesncorners.tileentity.TileEntitySlopesBase;
import slimevoidlib.blocks.BlockBase;
import slimevoidlib.tileentity.TileEntityBase;
import slimevoidlib.util.helpers.BlockHelper;

public class BlockSlopesBase extends BlockBase {

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
		return Block.glass.getIcon(0, 0);
		
	}
	
	@Override
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ){
		int metadata = world.getBlockMetadata(x, y, z);
		TileEntitySlopesBase tileentitybase = (TileEntitySlopesBase) BlockHelper.getTileEntity(world, x, y, z, this.getTileMapData(metadata));
		if (tileentitybase != null) {
			return tileentitybase.getExplosionResistance(this, par1Entity, explosionX, explosionY , explosionZ);
		} else {
			return super.getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY , explosionZ);
		}
	}
	
	public final float superGetExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ){
		return super.getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY , explosionZ);
	}

}
