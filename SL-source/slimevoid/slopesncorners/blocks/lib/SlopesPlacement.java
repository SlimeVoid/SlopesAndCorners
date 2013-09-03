package slimevoid.slopesncorners.blocks.lib;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import slimevoid.slopesncorners.api.ISlopePlacement;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib;
import slimevoid.slopesncorners.tileentity.TileEntitySlopes;
import slimevoidlib.tileentity.TileEntityBase;
import slimevoidlib.util.helpers.BlockHelper;

public class SlopesPlacement implements ISlopePlacement {

	@Override
	public boolean onPlaceSlope(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int i) {
		// TODO :: Auto-generated method stub
		BlockHelper.playBlockPlaceNoise(
				world, x, y, z,
				MaterialsLib.getBlock(itemstack.getItemDamage() & 0xff).blockID);
		TileEntitySlopes tileentity = (TileEntitySlopes) BlockHelper.getTileEntity(world, x, y, z, TileEntitySlopes.class);
		if (tileentity != null) {
			tileentity.setSlopeIndex((short) MaterialsLib.damageToMaterialValue(itemstack.getItemDamage() & 0xff));
			System.out.println(tileentity.getSlopeIndex());
		}
		BlockHelper.updateIndirectNeighbors(
				world, x, y, z,
				ConfigurationLib.blockSlopes.blockID);
		world.markBlockForUpdate(x, y, z);
		return false;
	}

	@Override
	public boolean placeSlopeAt(ItemStack stack, EntityPlayer player,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ, int metadata) {
		return false;
	}

	@Override
	public String getSlopeName(int i, int j) {
		// TODO :: Auto-generated method stub
		return null;
	}

	@Override
	public void addCreativeItems(int i, CreativeTabs tab, List itemList, int matIndex) {
		System.out.println("Adding Tabs To " + tab + "[" + i + "]["+ matIndex +"]");
		if (tab != ConfigurationLib.slopesTab) {
			return;
		}
		int defaultDamage = (4095 * i) + matIndex;
		switch (i) {
		case 0:
			itemList.add(new ItemStack(ConfigurationLib.blockSlopes, 1, defaultDamage));
			//defaultDamage+=4095;
			break;
		case 1:
			itemList.add(new ItemStack(ConfigurationLib.blockSlopes, 1, defaultDamage));
			//defaultDamage+=4095;
			break;
		case 2:
			itemList.add(new ItemStack(ConfigurationLib.blockSlopes, 1, defaultDamage));
			//defaultDamage+=4095;
			break;
		case 3:
			itemList.add(new ItemStack(ConfigurationLib.blockSlopes, 1, defaultDamage));
			//defaultDamage+=4095;
			break;
		case 4:
			itemList.add(new ItemStack(ConfigurationLib.blockSlopes, 1, defaultDamage));
			//defaultDamage+=4095;
			break;
		}

	}
}
