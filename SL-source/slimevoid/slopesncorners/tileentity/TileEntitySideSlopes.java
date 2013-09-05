package slimevoid.slopesncorners.tileentity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.ForgeDirection;
import slimevoidlib.blocks.BlockBase;

public class TileEntitySideSlopes extends TileEntitySlopesBase {
	private boolean raytracing;
	private int raytraceheight;
	private boolean raytraceFirstPhase;
	
	@Override
	public void setBlockBoundsBasedOnState(BlockBase blockbase) {
		// TODO:: actually set the right block bounds
		if (raytracing) {

			setSideSlopeBounds(blockbase, raytraceheight,this.getRotation());

		} else {
			blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

	}

	@Override
	public MovingObjectPosition collisionRayTrace(BlockBase blockBase, Vec3 startVec, Vec3 endVec) {
		MovingObjectPosition amovingobjectposition = null;
		raytracing = true;
		for (int i = 1; i <= 16 && amovingobjectposition == null; i++) {
			raytraceheight = i;
			amovingobjectposition = blockBase.superCollisionRayTrace(this.worldObj, this.xCoord, this.yCoord, this.zCoord,
					startVec, endVec);
		}
		raytracing = false;
		// if anything gets hit use the full bounding box to determine intended
		// side
		if (amovingobjectposition != null) {
			amovingobjectposition = blockBase.superCollisionRayTrace(this.worldObj, this.xCoord, this.yCoord, this.zCoord,
					startVec, endVec);
		}
		return amovingobjectposition;
	}

	@Override
	public void addCollisionBoxesToList(BlockBase blockBase, AxisAlignedBB par5AxisAlignedBB, List par6List,
			Entity par7Entity) {
		int iDir = this.getRotation();
		for (int i = 1; i <= 16; i++) {
			setSideSlopeBounds(blockBase, i, iDir);
			blockBase.superAddCollisionBoxesToList(this.worldObj, this.xCoord, this.yCoord, this.zCoord,
					par5AxisAlignedBB, par6List, par7Entity);
		}
		blockBase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	
	private void setSideSlopeBounds(BlockBase blockbase, int i, int iDir) {
		switch (iDir) {
		case 0:
			blockbase.setBlockBounds(1.0F - (.0625F * i), 0.0F, (.0625F * i), 1.0F,
					1.0f, 1.0F);
			break;
		case 1:
			blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F - (.0625F * i), 1.0f,
					(.0625F * i));
			break;
		case 2:
			blockbase.setBlockBounds(0.0F, 0.0F, .0625F * i, .0625F * i, 1.0f, 1.0F);
			break;
		case 3:
			blockbase.setBlockBounds((.0625F * i), 0.0F, 0.0F, 1.0F, 1.0f,
					(.0625F * i));
			break;

		}
	}

	@Override
	public boolean isBlockSolidOnSide(BlockBase blockBase, ForgeDirection side) {
		boolean result = false;
		switch (this.getRotation()) {
		case 0:
			result = side == side.EAST || side == side.SOUTH;
			break;
		case 1:
			result = side == side.WEST || side == side.NORTH;
			break;
		case 2:
			result = side == side.WEST || side == side.SOUTH;
			break;
		case 3:
			result = side == side.EAST || side == side.NORTH;
			break;
		}

		return result;
	}
}
