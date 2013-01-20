package slimevoid.slopes.blocks;

import java.util.List;

import slimevoid.slopes.core.config.SlopesConfig;

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

public class BlockSlopes extends Block {
	public BlockSlopes(int i, int j, Material material) {
		super(i, j, material);
		// setTickOnLoad(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
		setLightOpacity(SlopesConfig.SlopesOpacity);
	}
	
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 4));
		par3List.add(new ItemStack(par1, 1, 8));
		par3List.add(new ItemStack(par1, 1, 12));
	}

	@Override
	public int getRenderType() {
		return SlopesConfig.SlopesRenderID;
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

		if (oldmeta == 12) {
			l = MathHelper
					.floor_double(((entityliving.rotationYaw * 4F) / 360F)) & 3;

		} else {
			l = MathHelper
					.floor_double(((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		}

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
		int l = world.getBlockMetadata(i, j, k);
		if (l == 0) {
			setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 1) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 2) {
			setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 3) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.0F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 4) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 5) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 6) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 7) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 8) {
			setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 9) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 10) {
			setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 11) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.0F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 12) {
			setBlockBounds(0.5F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 13) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 0.5F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 14) {
			setBlockBounds(0.0F, 0.0F, 0.5F, 0.5F, 1.0F, 1.0F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 15) {
			setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
			super.addCollidingBlockToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		}
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public boolean onBlockActivated(World world, int i, int j, int k,
			EntityPlayer entityplayer, int l, float a, float b, float c) {
		int lCurrentID = world.getBlockId(i, j, k);
		if (lCurrentID == SlopesConfig.BlockBlackWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockRedWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockGreenWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockBrownWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockBlueWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockPurpleWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockCyanWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockSilverWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockGrayWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockPinkWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockLimeWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockYellowWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockLightBlueWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockMagentaWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockOrangeWoolSlopes.blockID
				|| lCurrentID == SlopesConfig.BlockWhiteWoolSlopes.blockID) {

			ItemStack itemstack = entityplayer.inventory.getCurrentItem();
			if (itemstack != null
					&& itemstack.itemID == Item.dyePowder.itemID) {
				int lOldMeta = world.getBlockMetadata(i, j, k);

				if (itemstack.getItemDamage() == 0
						&& SlopesConfig.BlockBlackWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockBlackWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 1
						&& SlopesConfig.BlockRedWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(i, j, k,
							SlopesConfig.BlockRedWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 2
						&& SlopesConfig.BlockGreenWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockGreenWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 3
						&& SlopesConfig.BlockBrownWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockBrownWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 4
						&& SlopesConfig.BlockBlueWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockBlueWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 5
						&& SlopesConfig.BlockPurpleWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockPurpleWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 6
						&& SlopesConfig.BlockCyanWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockCyanWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 7
						&& SlopesConfig.BlockSilverWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockSilverWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 8
						&& SlopesConfig.BlockGrayWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockGrayWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 9
						&& SlopesConfig.BlockPinkWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockPinkWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 10
						&& SlopesConfig.BlockLimeWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockLimeWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 11
						&& SlopesConfig.BlockYellowWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockYellowWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 12
						&& SlopesConfig.BlockLightBlueWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockLightBlueWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 13
						&& SlopesConfig.BlockMagentaWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockMagentaWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 14
						&& SlopesConfig.BlockOrangeWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockOrangeWoolSlopes.blockID,
							lOldMeta);
					return true;
				} else if (itemstack.getItemDamage() == 15
						&& SlopesConfig.BlockWhiteWoolSlopes.blockID != Block.stone.blockID) {
					world.setBlockAndMetadataWithNotify(
							i,
							j,
							k,
							SlopesConfig.BlockWhiteWoolSlopes.blockID,
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
