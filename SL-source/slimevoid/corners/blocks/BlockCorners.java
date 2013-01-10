package slimevoid.corners.blocks;

import java.util.List;

import slimevoid.corners.core.config.CornersConfig;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCorners extends Block {
	public BlockCorners(int i, int j, Material material) {
		super(i, j, material);
		// setTickOnLoad(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
		setLightOpacity(CornersConfig.SlopesOpacity);
	}
	
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 4));
		par3List.add(new ItemStack(par1, 1, 8));
		par3List.add(new ItemStack(par1, 1, 12));
	}

	@Override
	public int getRenderType() {
		return CornersConfig.CornersRenderID;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i,
			int j, int k, int l) {
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k,
			EntityLiving entityliving) {
		int oldmeta = world.getBlockMetadata(i, j, k);
		int l;

		l = MathHelper.floor_double(((entityliving.rotationYaw * 4F) / 360F)) & 3;

		if (l == 0) {
			world.setBlockMetadataWithNotify(i, j, k, 2 + oldmeta);
		}
		if (l == 1) {
			world.setBlockMetadataWithNotify(i, j, k, 1 + oldmeta);
		}
		if (l == 2) {
			world.setBlockMetadataWithNotify(i, j, k, 3 + oldmeta);
		}
		if (l == 3) {
			world.setBlockMetadataWithNotify(i, j, k, 0 + oldmeta);
		}
	}

	@Override
	public int damageDropped(int i) {
		if (i == 0 || i == 1 || i == 2 || i == 3) {
			return 0;
		}
		if (i == 4 || i == 5 || i == 6 || i == 7) {
			return 4;
		}
		if (i == 8 || i == 9 || i == 10 || i == 11) {
			return 8;
		}
		if (i == 12 || i == 13 || i == 14 || i == 15) {
			return 12;
		} else {
			return i;
		}
	}

	@Override
	public void addCollidingBlockToList(World world, int i, int j, int k,
			AxisAlignedBB axisalignedbb, List arraylist, Entity entity) {
		int l = world.getBlockMetadata(i, j, k) % 8;
		if (l == 0) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.5F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 1) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 0.5F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 2) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.0F, 0.5F, 0.5F, 0.5F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 3) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 4) {
			setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.5F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 5) {
			setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 6) {
			setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.0F, 0.0F, 0.5F, 0.5F, 0.5F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 7) {
			setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		}
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public boolean onBlockActivated(World world, int i, int j, int k,
			EntityPlayer entityplayer, int l, float a, float b, float c) {
		int lCurrentID = world.getBlockId(i, j, k);
		if (lCurrentID == CornersConfig.BlockBlackWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockRedWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockGreenWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockBrownWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockBlueWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockPurpleWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockCyanWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockSilverWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockGrayWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockPinkWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockLimeWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockYellowWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockLightBlueWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockMagentaWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockOrangeWoolCorners.blockID
				|| lCurrentID == CornersConfig.BlockWhiteWoolCorners.blockID) {

			ItemStack itemstack = entityplayer.inventory.getCurrentItem();
			if (itemstack != null
					&& itemstack.itemID == Item.dyePowder.itemID) {
				int lOldMeta = world.getBlockMetadata(i, j, k);

				if (itemstack.getItemDamage() == 0
						&& CornersConfig.BlockBlackWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockBlackWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 1
						&& CornersConfig.BlockRedWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockRedWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 2
						&& CornersConfig.BlockGreenWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockGreenWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 3
						&& CornersConfig.BlockBrownWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockBrownWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 4
						&& CornersConfig.BlockBlueWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockBlueWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 5
						&& CornersConfig.BlockPurpleWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockPurpleWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 6
						&& CornersConfig.BlockCyanWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockCyanWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 7
						&& CornersConfig.BlockSilverWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockSilverWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 8
						&& CornersConfig.BlockGrayWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockGrayWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 9
						&& CornersConfig.BlockPinkWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockPinkWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 10
						&& CornersConfig.BlockLimeWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockLimeWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 11
						&& CornersConfig.BlockYellowWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockYellowWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 12
						&& CornersConfig.BlockLightBlueWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockLightBlueWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 13
						&& CornersConfig.BlockMagentaWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockMagentaWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 14
						&& CornersConfig.BlockOrangeWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockOrangeWoolCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 15
						&& CornersConfig.BlockWhiteWoolCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							CornersConfig.BlockWhiteWoolCorners.blockID,
							lOldMeta);
					return true;
				}
			}
		}
		return false;
	}

	public static int func_21034_c(int i) {
		return i;
	}

	public static int func_21035_d(int i) {
		return i;
	}
}
