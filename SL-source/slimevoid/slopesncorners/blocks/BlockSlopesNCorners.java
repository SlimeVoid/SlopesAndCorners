package slimevoid.slopesncorners.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;

public class BlockSlopesNCorners extends BlockVannilaBased {
	private boolean raytracing;
	private int raytraceheight;
	private boolean raytraceFirstPhase;

	public BlockSlopesNCorners(int i, Block baseBlock) {
		this(i, baseBlock, 0);
	}

	public BlockSlopesNCorners(int i, Block baseBlock, int baseBlockDmg) {
		super(i, ConfigurationLib.SlopesNCornersRenderID, baseBlock,
				baseBlockDmg, ConfigurationLib.tabCustom);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase entityliving, ItemStack itemstack) {
		int l = MathHelper
				.floor_double((double) (entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		int i1 = world.getBlockMetadata(x, y, z) & 4;

		if (l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2 | i1, 2);
		}

		if (l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 1 | i1, 2);
		}

		if (l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3 | i1, 2);
		}

		if (l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 0 | i1, 2);
		}
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y,
	 * z
	 */
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4) {
		// TODO:: actually set the right block bounds
		if (raytracing) {

			if (GetIntCorneriDir(par1IBlockAccess, par2, par3, par4) > -1) {
				setIntCornersBounds(raytraceheight,
						GetIntCorneriDir(par1IBlockAccess, par2, par3, par4),
						raytraceFirstPhase);
			} else if (GetCorneriDir(par1IBlockAccess, par2, par3, par4) > -1) {
				setCornersBounds(raytraceheight,
						GetCorneriDir(par1IBlockAccess, par2, par3, par4));
			} else {
				setSlopesBounds(raytraceheight,
						par1IBlockAccess.getBlockMetadata(par2, par3, par4));
			}
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

	}

	public MovingObjectPosition collisionRayTrace(World world, int x, int y,
			int z, Vec3 startVec, Vec3 endVec) {
		MovingObjectPosition amovingobjectposition = null;
		raytracing = true;
		for (int i = 1; i <= 16 && amovingobjectposition == null; i++) {
			raytraceheight = i;
			raytraceFirstPhase = true;
			// setBlockBoundsBasedOnState(world,x,y,z);
			amovingobjectposition = super.collisionRayTrace(world, x, y, z,
					startVec, endVec);

			if (amovingobjectposition != null
					&& GetIntCorneriDir(world, x, y, z) > -1) {
				raytraceFirstPhase = false;
				amovingobjectposition = super.collisionRayTrace(world, x, y, z,
						startVec, endVec);

			}
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

	/**
	 * Adds all intersecting collision boxes to a list. (Be sure to only add
	 * boxes to the list if they intersect the mask.) Parameters: World, X, Y,
	 * Z, mask, list, colliding entity
	 */
	public void addCollisionBoxesToList(World par1World, int par2, int par3,
			int par4, AxisAlignedBB par5AxisAlignedBB, List par6List,
			Entity par7Entity) {
		if (GetIntCorneriDir(par1World, par2, par3, par4) > -1) {
			addIntCornersCollisionBoxesToList(par1World, par2, par3, par4,
					par5AxisAlignedBB, par6List, par7Entity,
					GetIntCorneriDir(par1World, par2, par3, par4));
		} else if (GetCorneriDir(par1World, par2, par3, par4) > -1) {
			addCornersCollisionBoxesToList(par1World, par2, par3, par4,
					par5AxisAlignedBB, par6List, par7Entity,
					GetCorneriDir(par1World, par2, par3, par4));
		} else {
			addSlopesCollisionBoxesToList(par1World, par2, par3, par4,
					par5AxisAlignedBB, par6List, par7Entity);
		}

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void addSlopesCollisionBoxesToList(World par1World, int par2,
			int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List,
			Entity par7Entity) {
		int iDir = par1World.getBlockMetadata(par2, par3, par4);
		for (int i = 1; i <= 16; i++) {
			setSlopesBounds(i, iDir);
			super.addCollisionBoxesToList(par1World, par2, par3, par4,
					par5AxisAlignedBB, par6List, par7Entity);
		}

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	private void setSlopesBounds(int i, int iDir) {
		switch (iDir) {
		case 0:
			this.setBlockBounds(.0625F * i, 0.0F, 0.0F, 1.0f, .0625F * i, 1.0F);
			break;
		case 1:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0f - (.0625F * i),
					.0625F * i, 1.0F);
			break;
		case 2:
			this.setBlockBounds(0.0f, 0.0F, .0625F * i, 1.0f, .0625F * i, 1.0F);
			break;
		case 3:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, .0625F * i,
					1.0f - (.0625F * i));
			break;
		case 4:
			this.setBlockBounds(1.0F - (.0625F * i), (.0625F * i), 0.0F, 1.0F,
					1.0f, 1.0F);
			break;
		case 5:
			this.setBlockBounds(0.0F, .0625F * i, 0.0F, (.0625F * i), 1.0f,
					1.0F);
			break;
		case 6:
			this.setBlockBounds(0.0F, (.0625F * i), 1.0F - (.0625F * i), 1.0F,
					1.0f, 1.0F);
			break;
		case 7:
			this.setBlockBounds(0.0F, .0625F * i, 0.0F, 1.0F, 1.0f,
					(.0625F * i));
			break;
		}

	}

	public void addCornersCollisionBoxesToList(World par1World, int par2,
			int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List,
			Entity par7Entity, int iDir) {

		for (int i = 1; i <= 16; i++) {
			setCornersBounds(i, iDir);
			super.addCollisionBoxesToList(par1World, par2, par3, par4,
					par5AxisAlignedBB, par6List, par7Entity);
		}
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	private void setCornersBounds(int i, int iDir) {
		switch (iDir) {
		case 0:
			this.setBlockBounds(.0625F * i, 0.0F, .0625F * i, 1.0f, .0625F * i,
					1.0F);
			break;
		case 1:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0f - (.0625F * i),
					.0625F * i, 1.0f - (.0625F * i));
			break;
		case 2:
			this.setBlockBounds(0.0f, 0.0F, .0625F * i, 1.0f - (.0625F * i),
					.0625F * i, 1.0F);
			break;
		case 3:
			this.setBlockBounds((.0625F * i), 0.0F, 0.0F, 1.0F, .0625F * i,
					1.0f - (.0625F * i));
			break;
		case 4:
			this.setBlockBounds(1.0F - (.0625F * i), (.0625F * i),
					1.0F - (.0625F * i), 1.0F, 1.0f, 1.0F);
			break;
		case 5:
			this.setBlockBounds(0.0F, .0625F * i, 0.0F, (.0625F * i), 1.0f,
					(.0625F * i));
			break;
		case 6:
			this.setBlockBounds(0.0F, (.0625F * i), 1.0F - (.0625F * i),
					(.0625F * i), 1.0f, 1.0F);
			break;
		case 7:
			this.setBlockBounds(1.0F - (.0625F * i), .0625F * i, 0.0F, 1.0F,
					1.0f, (.0625F * i));
			break;
		}
	}

	public void addIntCornersCollisionBoxesToList(World par1World, int par2,
			int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List,
			Entity par7Entity, int iDir) {

		for (int i = 1; i <= 16; i++) {
			setIntCornersBounds(i, iDir, true);
			super.addCollisionBoxesToList(par1World, par2, par3, par4,
					par5AxisAlignedBB, par6List, par7Entity);
			setIntCornersBounds(i, iDir, false);
			super.addCollisionBoxesToList(par1World, par2, par3, par4,
					par5AxisAlignedBB, par6List, par7Entity);
		}

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	private void setIntCornersBounds(int i, int iDir, boolean firstPhase) {
		switch (iDir) {
		case 0:
			if (firstPhase)
				this.setBlockBounds(.0625F * i, 0.0F, 0.0F, 1.0f, .0625F * i,
						1.0F);
			else
				this.setBlockBounds(0.0f, 0.0F, .0625F * i, 1.0f, .0625F * i,
						1.0F);
			break;
		case 1:
			if (firstPhase)
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0f - (.0625F * i),
						.0625F * i, 1.0F);
			else
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, .0625F * i,
						1.0f - (.0625F * i));
			break;
		case 2:
			if (firstPhase)
				this.setBlockBounds(0.0f, 0.0F, .0625F * i, 1.0f, .0625F * i,
						1.0F);
			else
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0f - (.0625F * i),
						.0625F * i, 1.0F);
			break;
		case 3:
			if (firstPhase)
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, .0625F * i,
						1.0f - (.0625F * i));
			else
				this.setBlockBounds(.0625F * i, 0.0F, 0.0F, 1.0f, .0625F * i,
						1.0F);
			break;
		case 4:
			if (firstPhase)
				this.setBlockBounds(1.0F - (.0625F * i), (.0625F * i), 0.0F,
						1.0F, 1.0f, 1.0F);
			else
				this.setBlockBounds(0.0F, (.0625F * i), 1.0F - (.0625F * i),
						1.0F, 1.0f, 1.0F);
			break;
		case 5:
			if (firstPhase)
				this.setBlockBounds(0.0F, .0625F * i, 0.0F, (.0625F * i), 1.0f,
						1.0F);
			else
				this.setBlockBounds(0.0F, .0625F * i, 0.0F, 1.0F, 1.0f,
						(.0625F * i));
			break;
		case 6:
			if (firstPhase)
				this.setBlockBounds(0.0F, (.0625F * i), 1.0F - (.0625F * i),
						1.0F, 1.0f, 1.0F);
			else
				this.setBlockBounds(0.0F, .0625F * i, 0.0F, (.0625F * i), 1.0f,
						1.0F);
			break;
		case 7:
			if (firstPhase)
				this.setBlockBounds(0.0F, .0625F * i, 0.0F, 1.0F, 1.0f,
						(.0625F * i));
			else
				this.setBlockBounds(1.0F - (.0625F * i), (.0625F * i), 0.0F,
						1.0F, 1.0f, 1.0F);
			break;
		}
	}

	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i,
			int j, int k, int l) {
		return true;

	}

	public boolean isBlockSolidOnSide(World world, int x, int y, int z,
			ForgeDirection side) {
		boolean result = false;
		if (side == side.UP && world.getBlockMetadata(x, y, z) / 4 == 1)
			return true;
		if (side == side.DOWN && world.getBlockMetadata(x, y, z) / 4 == 0)
			return true;
		if (GetCorneriDir(world, x, y, z) > -1)
			return false;
		if (GetIntCorneriDir(world, x, y, z) > -1) {
			switch (GetIntCorneriDir(world, x, y, z)) {
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
		switch (world.getBlockMetadata(x, y, z)) {
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

	/**
	 * called to see if this block should be treated as an interercorner and
	 * returns the iDir of that corner
	 */
	public int GetIntCorneriDir(IBlockAccess iblockaccess, int x, int y, int z) {
		int iDir = iblockaccess.getBlockMetadata(x, y, z);
		int result = -1;
		switch (iDir) {
		case 0:
			if (Block.blocksList[iblockaccess.getBlockId(x - 1, y, z)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 3)
					result = 3;
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 2)
					result = 0;
			}
			break;
		case 1:
			if (Block.blocksList[iblockaccess.getBlockId(x + 1, y, z)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 3)
					result = 1;
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 2)
					result = 2;
			}
			break;
		case 2:
			if (Block.blocksList[iblockaccess.getBlockId(x, y, z - 1)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 1)
					result = 2;
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 0)
					result = 0;
			}
			break;
		case 3:
			if (Block.blocksList[iblockaccess.getBlockId(x, y, z + 1)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x, y, z + 1) == 1)
					result = 1;
				if (iblockaccess.getBlockMetadata(x, y, z + 1) == 0)
					result = 3;
			}
			break;
		case 4:
			if (Block.blocksList[iblockaccess.getBlockId(x - 1, y, z)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 7)
					result = 7;
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 6)
					result = 4;
			}
			break;
		case 5:
			if (Block.blocksList[iblockaccess.getBlockId(x + 1, y, z)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 7)
					result = 5;
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 6)
					result = 6;
			}
			break;
		case 6:
			if (Block.blocksList[iblockaccess.getBlockId(x, y, z - 1)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 5)
					result = 6;
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 4)
					result = 4;
			}
			break;
		case 7:
			if (Block.blocksList[iblockaccess.getBlockId(x, y, z + 1)] instanceof BlockSlopesNCorners) {
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
	public int GetCorneriDir(IBlockAccess iblockaccess, int x, int y, int z) {
		int iDir = iblockaccess.getBlockMetadata(x, y, z);
		int result = -1;
		switch (iDir) {
		case 0:
			if (Block.blocksList[iblockaccess.getBlockId(x + 1, y, z)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 3)
					result = 3;
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 2)
					result = 0;
			}
			break;
		case 1:
			if (Block.blocksList[iblockaccess.getBlockId(x - 1, y, z)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 3)
					result = 1;
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 2)
					result = 2;
			}
			break;
		case 2:
			if (Block.blocksList[iblockaccess.getBlockId(x, y, z + 1)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x, y, z + 1) == 1)
					result = 2;
				if (iblockaccess.getBlockMetadata(x, y, z + 1) == 0)
					result = 0;
			}
			break;
		case 3:
			if (Block.blocksList[iblockaccess.getBlockId(x, y, z - 1)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 1)
					result = 1;
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 0)
					result = 3;
			}
			break;
		case 4:
			if (Block.blocksList[iblockaccess.getBlockId(x + 1, y, z)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 7)
					result = 7;
				if (iblockaccess.getBlockMetadata(x + 1, y, z) == 6)
					result = 4;
			}
			break;
		case 5:
			if (Block.blocksList[iblockaccess.getBlockId(x - 1, y, z)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 7)
					result = 5;
				if (iblockaccess.getBlockMetadata(x - 1, y, z) == 6)
					result = 6;
			}
			break;
		case 6:
			if (Block.blocksList[iblockaccess.getBlockId(x, y, z + 1)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x, y, z + 1) == 5)
					result = 6;
				if (iblockaccess.getBlockMetadata(x, y, z + 1) == 4)
					result = 4;
			}
			break;
		case 7:
			if (Block.blocksList[iblockaccess.getBlockId(x, y, z - 1)] instanceof BlockSlopesNCorners) {
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 5)
					result = 5;
				if (iblockaccess.getBlockMetadata(x, y, z - 1) == 4)
					result = 7;
			}
			break;
		}
		return result;
	}

}
