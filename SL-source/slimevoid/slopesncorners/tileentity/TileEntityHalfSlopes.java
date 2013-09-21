package slimevoid.slopesncorners.tileentity;

import java.util.List;

import slimevoidlib.blocks.BlockBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityHalfSlopes extends TileEntitySlopesBase {

	private boolean	raytracing;
	private int		raytraceheight;

	@Override
	public boolean isBlockSolidOnSide(BlockBase blockBase, ForgeDirection side) {
		if (side == side.UP && this.getRotation() / 4 == 1) return true;
		if (side == side.DOWN && this.getRotation() / 4 == 0) return true;

		return false;
	}

	@Override
	public void setBlockBoundsBasedOnState(BlockBase blockbase) {
		if (raytracing) {
			setSlopesBounds(blockbase,
							raytraceheight,
							this.rotation);
		} else {
			blockbase.setBlockBounds(	0.0F,
										0.0F,
										0.0F,
										1.0F,
										1.0F,
										1.0F);
		}
	}

	@Override
	public MovingObjectPosition collisionRayTrace(BlockBase blockbase, Vec3 startVec, Vec3 endVec) {
		World world = this.worldObj;
		int x = this.xCoord, y = this.yCoord, z = this.zCoord;
		MovingObjectPosition amovingobjectposition = null;
		raytracing = true;
		for (int i = 1; i <= 16 && amovingobjectposition == null; i++) {
			raytraceheight = i;
			// setBlockBoundsBasedOnState(world,x,y,z);
			amovingobjectposition = blockbase.superCollisionRayTrace(	world,
																		x,
																		y,
																		z,
																		startVec,
																		endVec);

		}
		raytracing = false;
		// if anything gets hit use the full bounding box to determine intended
		// side
		if (amovingobjectposition != null) {
			amovingobjectposition = blockbase.superCollisionRayTrace(	world,
																		x,
																		y,
																		z,
																		startVec,
																		endVec);
		}

		return amovingobjectposition;
	}

	@Override
	public void addCollisionBoxesToList(BlockBase blockbase, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {

		addSlopesCollisionBoxesToList(	blockbase,
										par5AxisAlignedBB,
										par6List,
										par7Entity);

		blockbase.setBlockBounds(	0.0F,
									0.0F,
									0.0F,
									1.0F,
									1.0F,
									1.0F);
	}

	public void addSlopesCollisionBoxesToList(BlockBase blockbase, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
		int iDir = this.rotation;
		for (int i = 1; i <= 16; i++) {
			setSlopesBounds(blockbase,
							i,
							iDir);
			blockbase.superAddCollisionBoxesToList(	this.worldObj,
													this.xCoord,
													this.yCoord,
													this.zCoord,
													par5AxisAlignedBB,
													par6List,
													par7Entity);
		}

		// blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	private void setSlopesBounds(BlockBase blockbase, int i, int iDir) {
		if ((i >= 6 && iDir < 4) || (i < 6 && iDir >= 4)) {
			blockbase.setBlockBounds(	0,
										0,
										0,
										0,
										0,
										0);
			return;
		}

		switch (iDir) {
		case 0:
		case 1:
			blockbase.setBlockBounds(	.0625F * i,
										0.0F,
										0.0F,
										1.0f - (.0625F * i),
										.0625F * i,
										1.0F);
			break;
		case 2:
		case 3:
			blockbase.setBlockBounds(	0.0f,
										0.0F,
										.0625F * i,
										1.0f,
										.0625F * i,
										1.0f - (.0625F * i));
			break;
		case 4:
		case 5:
			blockbase.setBlockBounds(	1.0F - (.0625F * i),
										(.0625F * i),
										0.0F,
										(.0625F * i),
										1.0f,
										1.0F);
			break;
		case 6:
		case 7:
			blockbase.setBlockBounds(	0.0F,
										(.0625F * i),
										1.0F - (.0625F * i),
										1.0F,
										1.0f,
										(.0625F * i));
			break;
		}
	}
}
