package slimevoid.slopesncorners.blocks.lib;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import slimevoid.materialslib.api.IMaterialHandler;
import slimevoid.materialslib.api.IPlacementHandler;
import slimevoid.materialslib.lib.MaterialsLib;
import slimevoid.slopesncorners.core.lib.BlockLib;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.tileentity.TileEntitySlopesBase;
import com.slimevoid.library.util.helpers.BlockHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PointSlopes {

	public static PointSlopes	instance	= new PointSlopes();

	public class MaterialHandler implements IMaterialHandler {

		@Override
		public void addMaterialReference(int i) {
			String name = MaterialsLib.getName(i);
			String desc = MaterialsLib.getDesc(i);

			LanguageRegistry.instance().addStringLocalization(	(new StringBuilder()).append(name).append(".pointSlope").append(".name").toString(),
																(new StringBuilder()).append(desc).append(" Point Slope").toString());
			ItemStack baseItem = MaterialsLib.getItemStack(i);
			if (baseItem != null) {
				ItemStack slopeStack = new ItemStack(ConfigurationLib.blockSlopes, 1, (BlockLib.BLOCK_SLOPES_ID << 12)
																						+ i);
				ItemStack stack = new ItemStack(ConfigurationLib.blockSlopes, 6, (BlockLib.BLOCK_POINT_SLOPE_ID << 12)
																					+ i);
				GameRegistry.addShapedRecipe(	stack.copy(),
												new Object[] {
														" B ",
														"B B",
														Character.valueOf('B'),
														slopeStack });
				stack.stackSize = 1;
				GameRegistry.addShapelessRecipe(baseItem,
												stack,
												stack,
												stack,
												stack,
												stack,
												stack);
			}
		}
	}

	public class PlacementHandler implements IPlacementHandler {

		@Override
		public boolean onPlaceBlock(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int i) {
			BlockHelper.playBlockPlaceNoise(world,
											x,
											y,
											z,
											MaterialsLib.getBlock(itemstack.getItemDamage() & 0xfff).blockID);
			BlockHelper.updateIndirectNeighbors(world,
												x,
												y,
												z,
												ConfigurationLib.blockSlopes.blockID);
			world.markBlockForUpdate(	x,
										y,
										z);
			return false;
		}

		@Override
		public boolean placeBlockAt(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
			TileEntitySlopesBase tileentity = (TileEntitySlopesBase) BlockHelper.getTileEntity(	world,
																								x,
																								y,
																								z,
																								ConfigurationLib.blockSlopes.getTileMapData(metadata));
			if (tileentity == null) {
				return false;
			}
			// do all rotation calculations here
			tileentity.setSlopeIndex((short) MaterialsLib.damageToMaterialValue(itemstack.getItemDamage()));
			tileentity.setRotation(MathHelper.floor_double((double) (entityplayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3);
			int state = side != 0 && (side == 1 || (double) hitY <= 0.5D) ? 0 : 0 | 4;

			if (tileentity.getRotation() == 0) {
				tileentity.setRotation(2 | state);
			} else if (tileentity.getRotation() == 1) {
				tileentity.setRotation(1 | state);
			} else if (tileentity.getRotation() == 2) {
				tileentity.setRotation(3 | state);
			} else if (tileentity.getRotation() == 3) {
				tileentity.setRotation(0 | state);
			}
			// System.out.println("Rotation: " + this.rotation);
			tileentity.onInventoryChanged();
			// tileentity.onBlockPlacedBy(itemstack, entityplayer);
			return true;
		}

		@Override
		public void addCreativeItems(int baseDMG, CreativeTabs tab, List itemList, int matIndex) {
			// System.out.println("Adding Tabs To " + tab + "[" + i + "]["+
			// matIndex
			// +"]");

			itemList.add(new ItemStack(ConfigurationLib.blockSlopes, 1, baseDMG
																		+ matIndex));
		}

		@Override
		public String getUnlocalizedName() {
			return "pointSlope";
		}

		@Override
		public String getLocalizedName() {
			return "Point Slopes";
		}
	}

	public IMaterialHandler getMaterialHandler() {
		return new MaterialHandler();
	}

	public IPlacementHandler getPlacementHandler() {
		return new PlacementHandler();
	}
}
