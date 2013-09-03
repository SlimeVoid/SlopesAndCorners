package slimevoid.slopesncorners.api;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ISlopePlacement {

	public abstract boolean onPlaceSlope(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int i);

	public abstract String getSlopeName(int i, int j);

	public abstract void addCreativeItems(int i, CreativeTabs tabs, List tabslist, int matIndex);

	public abstract boolean placeSlopeAt(ItemStack stack, EntityPlayer player,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ, int metadata);

}
