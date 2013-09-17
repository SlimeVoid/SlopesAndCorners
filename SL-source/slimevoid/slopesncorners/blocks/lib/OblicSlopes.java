package slimevoid.slopesncorners.blocks.lib;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import slimevoid.slopesncorners.api.ISlopePlacement;
import slimevoid.slopesncorners.core.lib.BlockLib;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib.IMaterialHandler;
import slimevoid.slopesncorners.tileentity.TileEntityOblicSlopes;
import slimevoidlib.util.helpers.BlockHelper;

public class OblicSlopes {

	public static OblicSlopes	instance	= new OblicSlopes();

	public class MaterialHandler implements IMaterialHandler {

		@Override
		public void addMaterialReference(int i) {
			String name = MaterialsLib.getName(i);
			String desc = MaterialsLib.getDesc(i);

			LanguageRegistry
					.instance()
					.addStringLocalization(	(new StringBuilder()).append(name)
													.append(".oblic")
													.append(".name").toString(),
											(new StringBuilder()).append(desc)
													.append(" Oblic")
													.toString());
			ItemStack baseItem = MaterialsLib.getItemStack(i);
			ItemStack stack = new ItemStack(
					ConfigurationLib.blockSlopes,
					3,
					(BlockLib.BLOCK_OBLICS_ID << 12) + i);
			GameRegistry.addShapedRecipe(stack.copy(), new Object[] {
					"  B",
					"BBB",
					"B  ",
					Character.valueOf('B'),
					baseItem });
			stack.stackSize = 1;
			GameRegistry.addShapelessRecipe(baseItem, stack, new ItemStack(
					ConfigurationLib.blockSlopes,
					1,
					(BlockLib.BLOCK_TRIPOINT_ID << 12) + i));
		}
	}

	public class PlacementHandler implements ISlopePlacement {

		@Override
		public boolean onPlaceSlope(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int i) {
			BlockHelper.playBlockPlaceNoise(world, x, y, z, MaterialsLib
					.getBlock(itemstack.getItemDamage() & 0xfff).blockID);
			TileEntityOblicSlopes tileentity = (TileEntityOblicSlopes) BlockHelper
					.getTileEntity(world, x, y, z, TileEntityOblicSlopes.class);
			if (tileentity != null) {
				tileentity
						.setSlopeIndex((short) MaterialsLib
								.damageToMaterialValue(itemstack
										.getItemDamage() & 0xfff));
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
			TileEntityOblicSlopes tileentity = (TileEntityOblicSlopes) BlockHelper
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
			return "oblic";
		}

		@Override
		public String getTabDisplayName() {
			return "Oblic Slopes";
		}
	}

	public IMaterialHandler getMaterialHandler() {
		return new MaterialHandler();
	}

	public ISlopePlacement getPlacementHandler() {
		return new PlacementHandler();
	}
}
