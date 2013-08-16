package slimevoid.slopesncorners.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;

public class BlockOblicSlopes extends BlockVannilaBased {
	private boolean raytracing;
	private boolean raytraceFirstPhase;

	public BlockOblicSlopes(int i, Block baseBlock) {
		this(i, baseBlock, 0);
	}

	public BlockOblicSlopes(int i, Block baseBlock, int baseBlockDmg) {
		super(i, ConfigurationLib.OblicSlopesRenderID, baseBlock, baseBlockDmg,
				ConfigurationLib.tabCustom);
		// TODO Auto-generated constructor stub
	}

	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4) {
		// TODO: actually set the right block bounds
		if (raytracing) {
			this.setOblicBounds(
					par1IBlockAccess.getBlockMetadata(par2, par3, par4) % 8,
					raytraceFirstPhase);
		} else
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);

	}

	public MovingObjectPosition collisionRayTrace(World world, int x, int y,
			int z, Vec3 startVec, Vec3 endVec) {
		MovingObjectPosition amovingobjectposition = null;
		raytracing = true;

		raytraceFirstPhase = true;
		amovingobjectposition = super.collisionRayTrace(world, x, y, z,
				startVec, endVec);

		if (amovingobjectposition == null) {
			raytraceFirstPhase = false;
			amovingobjectposition = super.collisionRayTrace(world, x, y, z,
					startVec, endVec);

		}

		raytracing = false;
		// if anything gets hit use the full bounding box to determine intended
		// side
		if (amovingobjectposition != null) {
			amovingobjectposition = super.collisionRayTrace(world, x, y, z,
					startVec, endVec);
		}
		return amovingobjectposition;
	}

	@Override
	public void addCollisionBoxesToList(World world, int i, int j, int k,
			AxisAlignedBB axisalignedbb, List arraylist, Entity entity) {
		int iDir = world.getBlockMetadata(i, j, k) % 8;
		setOblicBounds(iDir, true);
		super.addCollisionBoxesToList(world, i, j, k, axisalignedbb, arraylist,
				entity);
		setOblicBounds(iDir, false);
		super.addCollisionBoxesToList(world, i, j, k, axisalignedbb, arraylist,
				entity);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	private void setOblicBounds(int iDir, boolean firstPhase) {
		if (iDir == 0) {
			if (firstPhase)
				setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			else
				setBlockBounds(0.5F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);

		} else if (iDir == 1) {
			if (firstPhase)
				setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			else
				setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 0.5F);

		} else if (iDir == 2) {
			if (firstPhase)
				setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			else
				setBlockBounds(0.0F, 0.5F, 0.5F, 0.5F, 1.0F, 1.0F);

		} else if (iDir == 3) {
			if (firstPhase)
				setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			else
				setBlockBounds(0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
		} else if (iDir == 4) {
			if (firstPhase)
				setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			else
				setBlockBounds(0.5F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
		} else if (iDir == 5) {
			if (firstPhase)
				setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			else
				setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F);
		} else if (iDir == 6) {
			if (firstPhase)
				setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			else
				setBlockBounds(0.0F, 0.0F, 0.5F, 0.5F, 0.5F, 1.0F);
		} else if (iDir == 7) {
			if (firstPhase)
				setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			else
				setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
		}
	}

	public boolean isBlockSolidOnSide(World world, int x, int y, int z,
			ForgeDirection side) {
		boolean result = false;
		if (side == side.UP && world.getBlockMetadata(x, y, z) / 4 == 1)
			return true;
		if (side == side.DOWN && world.getBlockMetadata(x, y, z) / 4 == 0)
			return true;
		switch (world.getBlockMetadata(x, y, z)) {
		case 0:
		case 4:
			result = side == side.EAST || side == side.SOUTH;
			break;
		case 1:
		case 5:
			result = side == side.WEST || side == side.NORTH;
			break;
		case 2:
		case 6:
			result = side == side.WEST || side == side.SOUTH;
			break;
		case 3:
		case 7:
			result = side == side.EAST || side == side.NORTH;
			break;
		}

		return result;
	}

	/*
	 * @Override public boolean onBlockActivated(World world, int i, int j, int
	 * k, EntityPlayer entityplayer, int l, float a, float b, float c) { if
	 * (this.BaseBlock instanceof BlockCloth) {
	 * 
	 * ItemStack itemstack = entityplayer.inventory.getCurrentItem(); if
	 * (itemstack != null && itemstack.itemID == Item.dyePowder.itemID) { int
	 * lOldMeta = world.getBlockMetadata(i, j, k);
	 * 
	 * if (itemstack.getItemDamage() == 0 &&
	 * SlopesNCornersConfig.BlockBlackWoolIntCorners != null) { world.setBlock(
	 * i, j, k, SlopesNCornersConfig.BlockBlackWoolIntCorners.blockID,
	 * lOldMeta,3); return true; } else if (itemstack.getItemDamage() == 1 &&
	 * SlopesNCornersConfig.BlockRedWoolIntCorners != null) { world.setBlock(i,
	 * j, k, SlopesNCornersConfig.BlockRedWoolIntCorners.blockID, lOldMeta,3);
	 * return true; } else if (itemstack.getItemDamage() == 2 &&
	 * SlopesNCornersConfig.BlockGreenWoolIntCorners != null) { world.setBlock(
	 * i, j, k, SlopesNCornersConfig.BlockGreenWoolIntCorners.blockID,
	 * lOldMeta,3); return true; } else if (itemstack.getItemDamage() == 3 &&
	 * SlopesNCornersConfig.BlockBrownWoolIntCorners != null) { world.setBlock(
	 * i, j, k, SlopesNCornersConfig.BlockBrownWoolIntCorners.blockID,
	 * lOldMeta,3); return true; } else if (itemstack.getItemDamage() == 4 &&
	 * SlopesNCornersConfig.BlockBlueWoolIntCorners != null) { world.setBlock(
	 * i, j, k, SlopesNCornersConfig.BlockBlueWoolIntCorners.blockID,
	 * lOldMeta,3); return true; } else if (itemstack.getItemDamage() == 5 &&
	 * SlopesNCornersConfig.BlockPurpleWoolIntCorners != null) { world.setBlock(
	 * i, j, k, SlopesNCornersConfig.BlockPurpleWoolIntCorners.blockID,
	 * lOldMeta,3); return true; } else if (itemstack.getItemDamage() == 6 &&
	 * SlopesNCornersConfig.BlockCyanWoolIntCorners != null) { world.setBlock(
	 * i, j, k, SlopesNCornersConfig.BlockCyanWoolIntCorners.blockID,
	 * lOldMeta,3); return true; } else if (itemstack.getItemDamage() == 7 &&
	 * SlopesNCornersConfig.BlockSilverWoolIntCorners != null) { world.setBlock(
	 * i, j, k, SlopesNCornersConfig.BlockSilverWoolIntCorners.blockID,
	 * lOldMeta,3); return true; } else if (itemstack.getItemDamage() == 8 &&
	 * SlopesNCornersConfig.BlockGrayWoolIntCorners != null) { world.setBlock(
	 * i, j, k, SlopesNCornersConfig.BlockGrayWoolIntCorners.blockID,
	 * lOldMeta,3); return true; } else if (itemstack.getItemDamage() == 9 &&
	 * SlopesNCornersConfig.BlockPinkWoolIntCorners != null) { world.setBlock(
	 * i, j, k, SlopesNCornersConfig.BlockPinkWoolIntCorners.blockID,
	 * lOldMeta,3); return true; } else if (itemstack.getItemDamage() == 10 &&
	 * SlopesNCornersConfig.BlockLimeWoolIntCorners != null) { world.setBlock(
	 * i, j, k, SlopesNCornersConfig.BlockLimeWoolIntCorners.blockID,
	 * lOldMeta,3); return true; } else if (itemstack.getItemDamage() == 11 &&
	 * SlopesNCornersConfig.BlockYellowWoolIntCorners != null) { world.setBlock(
	 * i, j, k, SlopesNCornersConfig.BlockYellowWoolIntCorners.blockID,
	 * lOldMeta,3); return true; } else if (itemstack.getItemDamage() == 12 &&
	 * SlopesNCornersConfig.BlockLightBlueWoolIntCorners != null) {
	 * world.setBlock( i, j, k,
	 * SlopesNCornersConfig.BlockLightBlueWoolIntCorners.blockID, lOldMeta,3);
	 * return true; } else if (itemstack.getItemDamage() == 13 &&
	 * SlopesNCornersConfig.BlockMagentaWoolIntCorners != null) {
	 * world.setBlock( i, j, k,
	 * SlopesNCornersConfig.BlockMagentaWoolIntCorners.blockID, lOldMeta,3);
	 * return true; } else if (itemstack.getItemDamage() == 14 &&
	 * SlopesNCornersConfig.BlockOrangeWoolIntCorners!= null) { world.setBlock(
	 * i, j, k, SlopesNCornersConfig.BlockOrangeWoolIntCorners.blockID,
	 * lOldMeta,3); return true; } else if (itemstack.getItemDamage() == 15 &&
	 * SlopesNCornersConfig.BlockWhiteWoolIntCorners!= null) { world.setBlock(
	 * i, j, k, SlopesNCornersConfig.BlockWhiteWoolIntCorners.blockID,
	 * lOldMeta,3); return true; } } } return false; }
	 */
}
