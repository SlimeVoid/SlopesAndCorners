package slimevoid.slopesncorners.blocks.lib;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimevoid.slopesncorners.api.ISlopePlacement;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;

public class SlopesPlacement implements ISlopePlacement {

	@Override
	public boolean onPlaceSlope(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int i) {
		// TODO :: Auto-generated method stub
		System.out.println("Placing Slope");
		return false;
	}

	@Override
	public String getSlopeName(int i, int j) {
		// TODO :: Auto-generated method stub
		return null;
	}

	@Override
	public void addCreativeItems(int i, CreativeTabs tab, List itemList) {
		System.out.println("Adding Tabs To " + tab + "[" + i + "]");
		if (tab != ConfigurationLib.slopesTab) {
			return;
		}
		int defaultDamage = 0;
		switch (i) {
		case 0:
			itemList.add(new ItemStack(ConfigurationLib.blockSlopes, 1, defaultDamage));
			defaultDamage+=4095;
			break;
		case 1:
			itemList.add(new ItemStack(ConfigurationLib.blockSlopes, 1, defaultDamage));
			defaultDamage+=4095;
			break;
		case 2:
			itemList.add(new ItemStack(ConfigurationLib.blockSlopes, 1, defaultDamage));
			defaultDamage+=4095;
			break;
		case 3:
			itemList.add(new ItemStack(ConfigurationLib.blockSlopes, 1, defaultDamage));
			defaultDamage+=4095;
			break;
		case 4:
			itemList.add(new ItemStack(ConfigurationLib.blockSlopes, 1, defaultDamage));
			defaultDamage+=4095;
			break;
		}

	}
}
