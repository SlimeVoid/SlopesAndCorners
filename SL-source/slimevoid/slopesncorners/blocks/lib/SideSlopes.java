package slimevoid.slopesncorners.blocks.lib;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import slimevoid.slopesncorners.core.lib.BlockLib;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.tileentity.TileEntitySideSlopes;
import slimevoidlib.materials.api.IMaterialHandler;
import slimevoidlib.materials.api.IPlacementHandler;
import slimevoidlib.materials.lib.MaterialsLib;
import slimevoidlib.util.helpers.BlockHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SideSlopes {
	
	public static SideSlopes instance = new SideSlopes();

	public class MaterialHandler implements IMaterialHandler {

		@Override
		public void addMaterialReference(int i) {
			String name = MaterialsLib.getName(i);
			String desc = MaterialsLib.getDesc(i);
			
			LanguageRegistry.instance()
					.addStringLocalization(	(new StringBuilder()).append(name)
													.append(".side")
													.append(".name").toString(),
											(new StringBuilder()).append(desc)
													.append(" Side Slope")
													.toString());
			ItemStack baseItem = MaterialsLib.getItemStack(i);
			if (baseItem != null) {
				ItemStack slopeStack = new ItemStack(
						ConfigurationLib.blockSlopes,
						1,
						(BlockLib.BLOCK_SLOPES_ID << 12) + i);
				slopeStack.stackSize = 1;
				ItemStack stack = new ItemStack(
						ConfigurationLib.blockSlopes,
						1,
						(BlockLib.BLOCK_SIDES_ID << 12) + i);
				GameRegistry.addShapelessRecipe(stack, slopeStack);
				GameRegistry.addShapelessRecipe(slopeStack, stack);
				GameRegistry.addShapelessRecipe(baseItem, stack, stack);
				GameRegistry.addShapelessRecipe(baseItem, slopeStack, stack);
			}
		}
	}
	
	public class PlacementHandler implements IPlacementHandler {

		@Override
		public boolean onPlaceSlope(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int i) {
			BlockHelper.playBlockPlaceNoise(world, x, y, z, MaterialsLib
					.getBlock(itemstack.getItemDamage() & 0xfff).blockID);
			TileEntitySideSlopes tileentity = (TileEntitySideSlopes) BlockHelper
					.getTileEntity(world, x, y, z, TileEntitySideSlopes.class);
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
			TileEntitySideSlopes tileentity = (TileEntitySideSlopes) BlockHelper
					.getTileEntity(world, x, y, z, ConfigurationLib.blockSlopes
							.getTileMapData(metadata));
			if (tileentity == null) {
				return false;
			}
			// do all rotation calculations here
			tileentity.setSlopeIndex((short) MaterialsLib
					.damageToMaterialValue(itemstack.getItemDamage() & 0xffff));
			// tileentity.setDropDamage(itemstack.getItemDamage());
			// System.out.println("Rotation: " + this.rotation);
			tileentity
					.setRotation(MathHelper
							.floor_double((double) (entityplayer.rotationYaw * 4.0F / 360.0F)) & 3);

			if (tileentity.getRotation() == 0) {
				tileentity.setRotation(2);
			} else if (tileentity.getRotation() == 1) {
				tileentity.setRotation(1);
			} else if (tileentity.getRotation() == 2) {
				tileentity.setRotation(3);
			} else if (tileentity.getRotation() == 3) {
				tileentity.setRotation(0);
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
			return "side";
		}

		@Override
		public String getTabDisplayName() {
			return "Side Slopes";
		}
	}

	public IMaterialHandler getMaterialHandler() {
		return new MaterialHandler();
	}

	public IPlacementHandler getPlacementHandler() {
		return new PlacementHandler();
	}
}
