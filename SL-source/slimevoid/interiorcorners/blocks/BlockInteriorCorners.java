package slimevoid.interiorcorners.blocks;

import java.util.List;

import slimevoid.interiorcorners.core.config.InteriorCornersConfig;

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

public class BlockInteriorCorners extends Block {
	public BlockInteriorCorners(int i, int j, Material material) {
		super(i, j, material);
		// setTickOnLoad(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
		setLightOpacity(InteriorCornersConfig.SlopesOpacity);
	}
	
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 4));
		par3List.add(new ItemStack(par1, 1, 8));
		par3List.add(new ItemStack(par1, 1, 12));
	}

	@Override
	public int getRenderType() {
		return InteriorCornersConfig.IntCornersRenderID;
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
		if (lCurrentID == InteriorCornersConfig.BlockBlackWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockRedWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockGreenWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockBrownWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockBlueWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockPurpleWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockCyanWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockSilverWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockGrayWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockPinkWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockLimeWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockYellowWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockLightBlueWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockMagentaWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockOrangeWoolIntCorners.blockID
				|| lCurrentID == InteriorCornersConfig.BlockWhiteWoolIntCorners.blockID) {

			ItemStack itemstack = entityplayer.inventory.getCurrentItem();
			if (itemstack != null
					&& itemstack.itemID == Item.dyePowder.itemID) {
				int lOldMeta = world.getBlockMetadata(i, j, k);

				if (itemstack.getItemDamage() == 0
						&& InteriorCornersConfig.BlockBlackWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockBlackWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 1
						&& InteriorCornersConfig.BlockRedWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockRedWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 2
						&& InteriorCornersConfig.BlockGreenWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockGreenWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 3
						&& InteriorCornersConfig.BlockBrownWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockBrownWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 4
						&& InteriorCornersConfig.BlockBlueWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockBlueWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 5
						&& InteriorCornersConfig.BlockPurpleWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockPurpleWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 6
						&& InteriorCornersConfig.BlockCyanWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockCyanWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 7
						&& InteriorCornersConfig.BlockSilverWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockSilverWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 8
						&& InteriorCornersConfig.BlockGrayWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockGrayWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 9
						&& InteriorCornersConfig.BlockPinkWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockPinkWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 10
						&& InteriorCornersConfig.BlockLimeWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockLimeWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 11
						&& InteriorCornersConfig.BlockYellowWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockYellowWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 12
						&& InteriorCornersConfig.BlockLightBlueWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockLightBlueWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 13
						&& InteriorCornersConfig.BlockMagentaWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockMagentaWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 14
						&& InteriorCornersConfig.BlockOrangeWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockOrangeWoolIntCorners.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 15
						&& InteriorCornersConfig.BlockWhiteWoolIntCorners.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							InteriorCornersConfig.BlockWhiteWoolIntCorners.blockID,
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
