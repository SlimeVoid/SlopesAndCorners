package slimevoid.slopesncorners.blocks.lib;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import slimevoid.slopesncorners.api.ISlopePlacement;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib;
import slimevoid.slopesncorners.tileentity.TileEntitySideSlopes;
import slimevoidlib.util.helpers.BlockHelper;

public class SideSlopesPlacement implements ISlopePlacement {
	
	@Override
	public boolean onPlaceSlope(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int i) {
		BlockHelper.playBlockPlaceNoise(
				world, x, y, z,
				MaterialsLib.getBlock(itemstack.getItemDamage() & 0xfff).blockID);
		TileEntitySideSlopes tileentity = (TileEntitySideSlopes) BlockHelper.getTileEntity(world, x, y, z, TileEntitySideSlopes.class);
		if (tileentity != null) {
			tileentity.setSlopeIndex((short) MaterialsLib.damageToMaterialValue(itemstack.getItemDamage() & 0xfff));
			//tileentity.setDropDamage(itemstack.getItemDamage());
			//System.out.println(tileentity.getSlopeIndex());
		}
		BlockHelper.updateIndirectNeighbors(
				world, x, y, z,
				ConfigurationLib.blockSlopes.blockID);
		world.markBlockForUpdate(x, y, z);
		return false;
	}

	@Override
	public boolean placeSlopeAt(ItemStack itemstack, EntityPlayer entityplayer,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ, int metadata) {
		TileEntitySideSlopes tileentity = (TileEntitySideSlopes) BlockHelper.getTileEntity(world, x, y, z, ConfigurationLib.blockSlopes.getTileMapData(metadata));
		if (tileentity == null) {
			return false;
		}
		//do all rotation calculations here
		tileentity.setSlopeIndex((short) MaterialsLib.damageToMaterialValue(itemstack.getItemDamage() & 0xffff));
		//tileentity.setDropDamage(itemstack.getItemDamage());
		//System.out.println("Rotation: " + this.rotation);
		tileentity.setRotation(MathHelper.floor_double((double) (entityplayer.rotationYaw * 4.0F / 360.0F)) & 3);
		
		if (tileentity.getRotation() == 0) {
			tileentity.setRotation(2);
		}else if (tileentity.getRotation() == 1) {
			tileentity.setRotation(1);
		}else if (tileentity.getRotation() == 2) {
			tileentity.setRotation(3);
		}else if (tileentity.getRotation() == 3) {
			tileentity.setRotation(0);
		}
		//System.out.println("Rotation: " + this.rotation);
		tileentity.onInventoryChanged();
		//tileentity.onBlockPlacedBy(itemstack, entityplayer);
		return true;
	}

	@Override
	public String getSlopeName(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCreativeItems(int baseDMG, CreativeTabs tab, List itemList,
			int matIndex) {
		
		itemList.add(new ItemStack(ConfigurationLib.blockSlopes, 1, baseDMG + matIndex));
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "side";
	}

	@Override
	public String getTabDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}


}
