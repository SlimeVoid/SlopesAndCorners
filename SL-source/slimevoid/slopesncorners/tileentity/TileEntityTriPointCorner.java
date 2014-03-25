package slimevoid.slopesncorners.tileentity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.ForgeDirection;
import com.slimevoid.library.blocks.BlockBase;

public class TileEntityTriPointCorner extends TileEntitySlopesBase {
	private boolean	raytracing;
	private int		raytraceheight;
	private boolean	raytraceFirstPhase;

	@Override
	public void setBlockBoundsBasedOnState(BlockBase blockbase) {
		if (raytracing) {
			this.setTriCornerBounds(blockbase,
									this.rotation,
									raytraceFirstPhase);
		} else blockbase.setBlockBounds(0.0F,
										0.0F,
										0.0F,
										1.0F,
										1.0F,
										1.0F);

	}

	@Override
	public MovingObjectPosition collisionRayTrace(BlockBase blockBase, Vec3 startVec, Vec3 endVec) {
		MovingObjectPosition amovingobjectposition = null;
		raytracing = true;

		raytraceFirstPhase = true;
		amovingobjectposition = blockBase.superCollisionRayTrace(	this.worldObj,
																	this.xCoord,
																	this.yCoord,
																	this.zCoord,
																	startVec,
																	endVec);

		if (amovingobjectposition == null) {
			raytraceFirstPhase = false;
			amovingobjectposition = blockBase.superCollisionRayTrace(	this.worldObj,
																		this.xCoord,
																		this.yCoord,
																		this.zCoord,
																		startVec,
																		endVec);

		}

		raytracing = false;
		// if anything gets hit use the full bounding box to determine intended
		// side
		if (amovingobjectposition != null) {
			amovingobjectposition = blockBase.superCollisionRayTrace(	this.worldObj,
																		this.xCoord,
																		this.yCoord,
																		this.zCoord,
																		startVec,
																		endVec);
		}
		return amovingobjectposition;
	}

	@Override
	public void addCollisionBoxesToList(BlockBase blockBase, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
		int iDir = this.rotation;
		setTriCornerBounds(	blockBase,
							iDir,
							true);
		blockBase.superAddCollisionBoxesToList(	this.worldObj,
												this.xCoord,
												this.yCoord,
												this.zCoord,
												par5AxisAlignedBB,
												par6List,
												par7Entity);
		setTriCornerBounds(	blockBase,
							iDir,
							false);
		blockBase.superAddCollisionBoxesToList(	this.worldObj,
												this.xCoord,
												this.yCoord,
												this.zCoord,
												par5AxisAlignedBB,
												par6List,
												par7Entity);
		blockBase.setBlockBounds(	0.0F,
									0.0F,
									0.0F,
									1.0F,
									1.0F,
									1.0F);
	}

	private void setTriCornerBounds(BlockBase blockbase, int iDir, boolean firstPhase) {
		if (iDir == 0) {
			if (firstPhase) blockbase.setBlockBounds(	0.0F,
														0.0F,
														0.0F,
														1.0F,
														0.5F,
														1.0F);
			else blockbase.setBlockBounds(	0.5F,
											0.5F,
											0.5F,
											1.0F,
											1.0F,
											1.0F);
		} else if (iDir == 1) {
			if (firstPhase) blockbase.setBlockBounds(	0.0F,
														0.0F,
														0.0F,
														1.0F,
														0.5F,
														1.0F);
			else blockbase.setBlockBounds(	0.0F,
											0.5F,
											0.0F,
											0.5F,
											1.0F,
											0.5F);
		} else if (iDir == 2) {
			if (firstPhase) blockbase.setBlockBounds(	0.0F,
														0.0F,
														0.0F,
														1.0F,
														0.5F,
														1.0F);
			else blockbase.setBlockBounds(	0.0F,
											0.5F,
											0.5F,
											0.5F,
											1.0F,
											1.0F);
		} else if (iDir == 3) {
			if (firstPhase) blockbase.setBlockBounds(	0.0F,
														0.0F,
														0.0F,
														1.0F,
														0.5F,
														1.0F);
			else blockbase.setBlockBounds(	0.5F,
											0.5F,
											0.0F,
											1.0F,
											1.0F,
											0.5F);
		} else if (iDir == 4) {
			if (firstPhase) blockbase.setBlockBounds(	0.0F,
														0.5F,
														0.0F,
														1.0F,
														1.0F,
														1.0F);
			else blockbase.setBlockBounds(	0.5F,
											0.0F,
											0.5F,
											1.0F,
											0.5F,
											1.0F);
		} else if (iDir == 5) {
			if (firstPhase) blockbase.setBlockBounds(	0.0F,
														0.5F,
														0.0F,
														1.0F,
														1.0F,
														1.0F);
			else blockbase.setBlockBounds(	0.0F,
											0.0F,
											0.0F,
											0.5F,
											0.5F,
											0.5F);
		} else if (iDir == 6) {
			if (firstPhase) blockbase.setBlockBounds(	0.0F,
														0.5F,
														0.0F,
														1.0F,
														1.0F,
														1.0F);
			else blockbase.setBlockBounds(	0.0F,
											0.0F,
											0.5F,
											0.5F,
											0.5F,
											1.0F);
		} else if (iDir == 7) {
			if (firstPhase) blockbase.setBlockBounds(	0.0F,
														0.5F,
														0.0F,
														1.0F,
														1.0F,
														1.0F);
			else blockbase.setBlockBounds(	0.5F,
											0.0F,
											0.0F,
											1.0F,
											0.5F,
											0.5F);
		}
	}

	@Override
	public boolean isBlockSolidOnSide(BlockBase blockBase, ForgeDirection side) {
		return false;
	}

	@Override
	public int getRotatedSide(int side) {

		switch (rotation % 4) {
		case 3:
			switch (side) {
			case 2: // north
				return 4; // to west
			case 3: // south
				return 5; // to east
			case 4: // west
				return 3; // to south
			case 5: // east
				return 2; // to north
			default:
				return side;
			}
		case 2:
			switch (side) {
			case 2:// north
				return 5; // to east
			case 3:// south
				return 4; // to west
			case 4:// west
				return 2; // to north
			case 5: // east
				return 3; // to south
			default:
				return side;
			}
		case 0:
			switch (side) {
			case 2:// north
				return 3; // to south
			case 3:// south
				return 2; // to north
			case 4:// west
				return 5; // to east
			case 5: // east
				return 4; // to west
			default:
				return side;
			}
		case 1:
			return side;
		default:
			return 0;
		}
	}
}
