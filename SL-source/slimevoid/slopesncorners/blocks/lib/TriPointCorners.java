package slimevoid.slopesncorners.blocks.lib;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import slimevoid.slopesncorners.api.ISlopePlacement;
import slimevoid.slopesncorners.core.lib.BlockLib;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib.IMaterialHandler;
import slimevoid.slopesncorners.tileentity.TileEntityTriPointCorner;
import slimevoidlib.util.helpers.BlockHelper;

public class TriPointCorners {
	
	public static TriPointCorners	instance	= new TriPointCorners();

	public class MaterialHandler implements IMaterialHandler {

		@Override
		public void addMaterialReference(int i) {
			String name = MaterialsLib.getName(i);
			String desc = MaterialsLib.getDesc(i);
			LanguageRegistry
					.instance()
					.addStringLocalization(	(new StringBuilder()).append(name)
													.append(".slant")
													.append(".name").toString(),
											(new StringBuilder()).append(desc)
													.append(" Slanted Corner")
													.toString());
			ItemStack baseItem = MaterialsLib.getItemStack(i);
			if (baseItem != null) {
				ItemStack stack = new ItemStack(
						ConfigurationLib.blockSlopes,
						6,
						(BlockLib.BLOCK_TRIPOINT_ID << 12) + i);
				GameRegistry.addShapedRecipe(stack, new Object[] {
						" B ",
						" B ",
						"BBB",
						Character.valueOf('B'),
						baseItem });
			}
		}
	}
	
	public class PlacementHandler implements ISlopePlacement {

		@Override
		public boolean onPlaceSlope(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int i) {
			BlockHelper.playBlockPlaceNoise(world, x, y, z, MaterialsLib
					.getBlock(itemstack.getItemDamage() & 0xfff).blockID);
			TileEntityTriPointCorner tileentity = (TileEntityTriPointCorner) BlockHelper
					.getTileEntity(world, x, y, z, TileEntityTriPointCorner.class);
			if (tileentity != null) {
				tileentity.setSlopeIndex((short) MaterialsLib
						.damageToMaterialValue(itemstack.getItemDamage() & 0xfff));
				// tileentity.setDropDamage(itemstack.getItemDamage());
				// System.out.println(tileentity.getSlopeIndex());
			}
			BlockHelper
					.updateIndirectNeighbors(	world,
												x,
												y,
												z,
												ConfigurationLib.blockSlopes.blockID);
			world.markBlockForUpdate(x, y, z);
			return false;
		}

		@Override
		public boolean placeSlopeAt(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
			TileEntityTriPointCorner tileentity = (TileEntityTriPointCorner) BlockHelper
					.getTileEntity(world, x, y, z, ConfigurationLib.blockSlopes
							.getTileMapData(metadata));
			if (tileentity == null) {
				return false;
			}
			// do all rotation calculations here
			tileentity.setSlopeIndex((short) MaterialsLib
					.damageToMaterialValue(itemstack.getItemDamage() & 0xfff));
			// tileentity.setDropDamage(itemstack.getItemDamage());
			// System.out.println("Rotation: " + this.rotation);
			tileentity
					.setRotation(MathHelper
							.floor_double((double) (entityplayer.rotationYaw * 4.0F / 360.0F)) & 3);
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
		public String getSlopeName(int i, int j) {
			return null;
		}

		@Override
		public void addCreativeItems(int baseDMG, CreativeTabs tab, List itemList, int matIndex) {

			itemList.add(new ItemStack(
					ConfigurationLib.blockSlopes,
					1,
					baseDMG + matIndex));

		}

		@Override
		public String getName() {
			return "slant";
		}

		@Override
		public String getTabDisplayName() {
			return "Slanted Corners";
		}

	}

	public IMaterialHandler getMaterialHandler() {
		return new MaterialHandler();
	}

	public ISlopePlacement getPlacementHandler() {
		return new PlacementHandler();
	}
}
