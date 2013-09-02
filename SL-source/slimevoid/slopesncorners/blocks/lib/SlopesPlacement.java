package slimevoid.slopesncorners.blocks.lib;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimevoid.slopesncorners.api.ISlopePlacement;

public class SlopesPlacement implements ISlopePlacement {

	@Override
	public boolean onPlaceSlope(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int i) {
		// TODO :: Auto-generated method stub
		return false;
	}

	@Override
	public String getSlopeName(int i, int j) {
		// TODO :: Auto-generated method stub
		return null;
	}

	@Override
	public void addCreativeItems(int i, CreativeTabs tabs, List tabslist) {
		// TODO :: Auto-generated method stub

	}

}
