package slimevoid.slopesncorners.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;

public class BlockTriPointCorner extends BlockVannilaBased {
	private boolean raytracing;
	private boolean raytraceFirstPhase;

	public BlockTriPointCorner(int i, Block baseBlock) {
		this(i, baseBlock, 0);
	}

	public BlockTriPointCorner(int i, Block baseBlock, int baseBlockDmg) {
		super(i, ConfigurationLib.TriCornersRenderID, baseBlock, baseBlockDmg,
				ConfigurationLib.tabCustom);
		// TODO Auto-generated constructor stub
	}

	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4) {
		// TODO: actually set the right block bounds
		if (raytracing) {
			this.setTriPointBounds(
					par1IBlockAccess.getBlockMetadata(par2, par3, par4) % 8,
					raytraceFirstPhase);
		} else
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);

	}

	@Override
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
		setTriPointBounds(iDir, true);
		super.addCollisionBoxesToList(world, i, j, k, axisalignedbb, arraylist,
				entity);
		setTriPointBounds(iDir, false);
		super.addCollisionBoxesToList(world, i, j, k, axisalignedbb, arraylist,
				entity);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	private void setTriPointBounds(int iDir, boolean firstPhase) {
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

}
