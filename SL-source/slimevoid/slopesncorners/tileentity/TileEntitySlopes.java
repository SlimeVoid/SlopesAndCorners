package slimevoid.slopesncorners.tileentity;

import java.util.List;

import slimevoidlib.blocks.BlockBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class TileEntitySlopes extends TileEntitySlopesBase {

	private boolean raytracing;
	private int raytraceheight;
	private boolean raytraceFirstPhase;
	
	@Override
	public void onBlockPlaced(ItemStack itemstack, int side, EntityLivingBase entityliving) {
		super.onBlockPlaced(itemstack, side, entityliving);
		int state = this.getBlockMetadata() & 4;
		if (this.rotation == 0) {
			worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 2 | state, 2);
		}

		if (this.rotation == 1) {
			worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 1 | state, 2);
		}

		if (this.rotation == 2) {
			worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 3 | state, 2);
		}

		if (this.rotation == 3) {
			worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 0 | state, 2);
		}
	}

	@Override
	public boolean isBlockSolidOnSide(BlockBase blockBase, ForgeDirection side) {
		boolean result = false;
		if (side == side.UP && this.getBlockMetadata() / 4 == 1)
			return true;
		if (side == side.DOWN && this.getBlockMetadata() / 4 == 0)
			return true;
		if (GetCorneriDir() > -1)
			return false;
		if (GetIntCorneriDir() > -1) {
			switch (GetIntCorneriDir()) {
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
				result = side == side.SOUTH || side == side.WEST;
				break;
			case 3:
			case 7:
				result = side == side.NORTH || side == side.EAST;
				break;

			}
			return result;
		}
		switch (this.getBlockMetadata()) {
		case 0:
		case 4:
			result = side == side.EAST;
			break;
		case 1:
		case 5:
			result = side == side.WEST;
			break;
		case 2:
		case 6:
			result = side == side.SOUTH;
			break;
		case 3:
		case 7:
			result = side == side.NORTH;
			break;

		}
		return result;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(BlockBase blockbase) {
		if (raytracing) {
			if (GetIntCorneriDir() > -1) {
				setIntCornersBounds(blockbase, raytraceheight, GetIntCorneriDir(), raytraceFirstPhase);
			} else if (GetCorneriDir() > -1) {
				setCornersBounds(blockbase, raytraceheight, GetCorneriDir());
			} else {
				setSlopesBounds(blockbase, raytraceheight, this.getBlockMetadata());
			}
		} else {
			blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	@Override
	public MovingObjectPosition collisionRayTrace(BlockBase blockbase, Vec3 startVec, Vec3 endVec) {
		World world = this.worldObj;
		int x = this.xCoord,
			y = this.yCoord,
			z = this.zCoord;
		MovingObjectPosition amovingobjectposition = null;
		raytracing = true;
		for (int i = 1; i <= 16 && amovingobjectposition == null; i++) {
			raytraceheight = i;
			raytraceFirstPhase = true;
			// setBlockBoundsBasedOnState(world,x,y,z);
			amovingobjectposition = blockbase.superCollisionRayTrace(world, x, y, z, startVec, endVec);

			if (amovingobjectposition != null && this.GetIntCorneriDir() > -1) {
				raytraceFirstPhase = false;
				amovingobjectposition = blockbase.superCollisionRayTrace(world, x, y, z, startVec, endVec);

			}
		}
		raytracing = false;
		// if anything gets hit use the full bounding box to determine intended
		// side
		if (amovingobjectposition != null) {
			amovingobjectposition = blockbase.superCollisionRayTrace(world, x, y, z, startVec, endVec);
		}

		return amovingobjectposition;
	}
	
	@Override
	public void addCollisionBoxesToList(BlockBase blockbase, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
		if (GetIntCorneriDir() > -1) {
			addIntCornersCollisionBoxesToList(blockbase, par5AxisAlignedBB, par6List, par7Entity,
					GetIntCorneriDir());
		} else if (GetCorneriDir() > -1) {
			addCornersCollisionBoxesToList(blockbase, par5AxisAlignedBB, par6List, par7Entity,
					GetCorneriDir());
		} else {
			addSlopesCollisionBoxesToList(blockbase, par5AxisAlignedBB, par6List, par7Entity);
		}

		blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void addSlopesCollisionBoxesToList(BlockBase blockbase, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
		int iDir = this.getBlockMetadata();
		for (int i = 1; i <= 16; i++) {
			setSlopesBounds(blockbase, i, iDir);
			blockbase.superAddCollisionBoxesToList(this.worldObj, this.xCoord, this.yCoord, this.zCoord, par5AxisAlignedBB, par6List, par7Entity);
		}

		//blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void addCornersCollisionBoxesToList(BlockBase blockbase, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity, int iDir) {
		for (int i = 1; i <= 16; i++) {
			setCornersBounds(blockbase, i, iDir);
			blockbase.superAddCollisionBoxesToList(this.worldObj, this.xCoord, this.yCoord, this.zCoord, par5AxisAlignedBB, par6List, par7Entity);
		}
		//blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void addIntCornersCollisionBoxesToList(BlockBase blockbase, AxisAlignedBB par5AxisAlignedBB, List par6List,
			Entity par7Entity, int iDir) {
		for (int i = 1; i <= 16; i++) {
			setIntCornersBounds(blockbase, i, iDir, true);
			blockbase.superAddCollisionBoxesToList(this.worldObj, this.xCoord, this.yCoord, this.zCoord, par5AxisAlignedBB, par6List, par7Entity);
			setIntCornersBounds(blockbase, i, iDir, false);
			blockbase.superAddCollisionBoxesToList(this.worldObj, this.xCoord, this.yCoord, this.zCoord, par5AxisAlignedBB, par6List, par7Entity);
		}

		//blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	/**
	 * called to see if this block should be treated as an interercorner and
	 * returns the iDir of that corner
	 */
	public int GetIntCorneriDir() {
		World iblockaccess = this.worldObj;
		int x = this.xCoord,
			y = this.yCoord,
			z = this.zCoord;
		int iDir = this.getBlockMetadata();
		int result = -1;
		switch (iDir) {
		case 0:
			if (iblockaccess.getBlockTileEntity(x - 1, y, z) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 3)
					result = 3;
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 2)
					result = 0;
			}
			break;
		case 1:
			if (iblockaccess.getBlockTileEntity(x + 1, y, z) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 3)
					result = 1;
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 2)
					result = 2;
			}
			break;
		case 2:
			if (iblockaccess.getBlockTileEntity(x, y, z - 1) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 1)
					result = 2;
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 0)
					result = 0;
			}
			break;
		case 3:
			if (iblockaccess.getBlockTileEntity(x, y, z + 1) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x, y, z + 1) == 1)
					result = 1;
				if (iblockaccess.getBlockMetadata(x, y, z + 1) == 0)
					result = 3;
			}
			break;
		case 4:
			if (iblockaccess.getBlockTileEntity(x - 1, y, z) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 7)
					result = 7;
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 6)
					result = 4;
			}
			break;
		case 5:
			if (iblockaccess.getBlockTileEntity(x + 1, y, z) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 7)
					result = 5;
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 6)
					result = 6;
			}
			break;
		case 6:
			if (iblockaccess.getBlockTileEntity(x, y, z - 1) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 5)
					result = 6;
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 4)
					result = 4;
			}
			break;
		case 7:
			if (iblockaccess.getBlockTileEntity(x, y, z + 1) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x, y, z + 1) == 5)
					result = 5;
				if (iblockaccess.getBlockMetadata(x, y, z + 1) == 4)
					result = 7;
			}
			break;
		}
		return result; // == -1? -1:result + 8;
	}

	/**
	 * called to see if this block should be treated as a corner and returns the
	 * iDir
	 */
	public int GetCorneriDir() {
		World iblockaccess = this.worldObj;
		int x = this.xCoord,
			y = this.yCoord,
			z = this.zCoord;
		int iDir = this.getBlockMetadata();
		int result = -1;
		switch (iDir) {
		case 0:
			if (iblockaccess.getBlockTileEntity(x + 1, y, z) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 3)
					result = 3;
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 2)
					result = 0;
			}
			break;
		case 1:
			if (iblockaccess.getBlockTileEntity(x - 1, y, z) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 3)
					result = 1;
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 2)
					result = 2;
			}
			break;
		case 2:
			if (iblockaccess.getBlockTileEntity(x, y, z + 1) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x, y, z + 1) == 1)
					result = 2;
				if (iblockaccess.getBlockMetadata(x, y, z + 1) == 0)
					result = 0;
			}
			break;
		case 3:
			if (iblockaccess.getBlockTileEntity(x, y, z - 1) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 1)
					result = 1;
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 0)
					result = 3;
			}
			break;
		case 4:
			if (iblockaccess.getBlockTileEntity(x + 1, y, z) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 7)
					result = 7;
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 6)
					result = 4;
			}
			break;
		case 5:
			if (iblockaccess.getBlockTileEntity(x - 1, y, z) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 7)
					result = 5;
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 6)
					result = 6;
			}
			break;
		case 6:
			if (iblockaccess.getBlockTileEntity(x, y, z + 1) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x, y, z + 1) == 5)
					result = 6;
				if (iblockaccess.getBlockMetadata(x, y, z + 1) == 4)
					result = 4;
			}
			break;
		case 7:
			if (iblockaccess.getBlockTileEntity(x, y, z - 1) instanceof TileEntitySlopes) {
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 5)
					result = 5;
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 4)
					result = 7;
			}
			break;
		}
		return result;
	}
	
	private void setIntCornersBounds(BlockBase blockbase, int i, int iDir, boolean firstPhase) {
		switch (iDir) {
		case 0:
			if (firstPhase)
				blockbase.setBlockBounds(.0625F * i, 0.0F, 0.0F, 1.0f, .0625F * i,
						1.0F);
			else
				blockbase.setBlockBounds(0.0f, 0.0F, .0625F * i, 1.0f, .0625F * i,
						1.0F);
			break;
		case 1:
			if (firstPhase)
				blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0f - (.0625F * i),
						.0625F * i, 1.0F);
			else
				blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, .0625F * i,
						1.0f - (.0625F * i));
			break;
		case 2:
			if (firstPhase)
				blockbase.setBlockBounds(0.0f, 0.0F, .0625F * i, 1.0f, .0625F * i,
						1.0F);
			else
				blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0f - (.0625F * i),
						.0625F * i, 1.0F);
			break;
		case 3:
			if (firstPhase)
				blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, .0625F * i,
						1.0f - (.0625F * i));
			else
				blockbase.setBlockBounds(.0625F * i, 0.0F, 0.0F, 1.0f, .0625F * i,
						1.0F);
			break;
		case 4:
			if (firstPhase)
				blockbase.setBlockBounds(1.0F - (.0625F * i), (.0625F * i), 0.0F,
						1.0F, 1.0f, 1.0F);
			else
				blockbase.setBlockBounds(0.0F, (.0625F * i), 1.0F - (.0625F * i),
						1.0F, 1.0f, 1.0F);
			break;
		case 5:
			if (firstPhase)
				blockbase.setBlockBounds(0.0F, .0625F * i, 0.0F, (.0625F * i), 1.0f,
						1.0F);
			else
				blockbase.setBlockBounds(0.0F, .0625F * i, 0.0F, 1.0F, 1.0f,
						(.0625F * i));
			break;
		case 6:
			if (firstPhase)
				blockbase.setBlockBounds(0.0F, (.0625F * i), 1.0F - (.0625F * i),
						1.0F, 1.0f, 1.0F);
			else
				blockbase.setBlockBounds(0.0F, .0625F * i, 0.0F, (.0625F * i), 1.0f,
						1.0F);
			break;
		case 7:
			if (firstPhase)
				blockbase.setBlockBounds(0.0F, .0625F * i, 0.0F, 1.0F, 1.0f,
						(.0625F * i));
			else
				blockbase.setBlockBounds(1.0F - (.0625F * i), (.0625F * i), 0.0F,
						1.0F, 1.0f, 1.0F);
			break;
		}
	}

	private void setCornersBounds(BlockBase blockbase, int i, int iDir) {
		switch (iDir) {
		case 0:
			blockbase.setBlockBounds(.0625F * i, 0.0F, .0625F * i, 1.0f, .0625F * i,
					1.0F);
			break;
		case 1:
			blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0f - (.0625F * i),
					.0625F * i, 1.0f - (.0625F * i));
			break;
		case 2:
			blockbase.setBlockBounds(0.0f, 0.0F, .0625F * i, 1.0f - (.0625F * i),
					.0625F * i, 1.0F);
			break;
		case 3:
			blockbase.setBlockBounds((.0625F * i), 0.0F, 0.0F, 1.0F, .0625F * i,
					1.0f - (.0625F * i));
			break;
		case 4:
			blockbase.setBlockBounds(1.0F - (.0625F * i), (.0625F * i),
					1.0F - (.0625F * i), 1.0F, 1.0f, 1.0F);
			break;
		case 5:
			blockbase.setBlockBounds(0.0F, .0625F * i, 0.0F, (.0625F * i), 1.0f,
					(.0625F * i));
			break;
		case 6:
			blockbase.setBlockBounds(0.0F, (.0625F * i), 1.0F - (.0625F * i),
					(.0625F * i), 1.0f, 1.0F);
			break;
		case 7:
			blockbase.setBlockBounds(1.0F - (.0625F * i), .0625F * i, 0.0F, 1.0F,
					1.0f, (.0625F * i));
			break;
		}
	}

	private void setSlopesBounds(BlockBase blockbase, int i, int iDir) {
		switch (iDir) {
		case 0:
			blockbase.setBlockBounds(.0625F * i, 0.0F, 0.0F, 1.0f, .0625F * i, 1.0F);
			break;
		case 1:
			blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0f - (.0625F * i),
					.0625F * i, 1.0F);
			break;
		case 2:
			blockbase.setBlockBounds(0.0f, 0.0F, .0625F * i, 1.0f, .0625F * i, 1.0F);
			break;
		case 3:
			blockbase.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, .0625F * i,
					1.0f - (.0625F * i));
			break;
		case 4:
			blockbase.setBlockBounds(1.0F - (.0625F * i), (.0625F * i), 0.0F, 1.0F,
					1.0f, 1.0F);
			break;
		case 5:
			blockbase.setBlockBounds(0.0F, .0625F * i, 0.0F, (.0625F * i), 1.0f,
					1.0F);
			break;
		case 6:
			blockbase.setBlockBounds(0.0F, (.0625F * i), 1.0F - (.0625F * i), 1.0F,
					1.0f, 1.0F);
			break;
		case 7:
			blockbase.setBlockBounds(0.0F, .0625F * i, 0.0F, 1.0F, 1.0f,
					(.0625F * i));
			break;
		}

	}
}
