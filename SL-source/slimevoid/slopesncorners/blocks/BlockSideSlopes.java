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

public class BlockSideSlopes extends BlockVannilaBased {
	private boolean raytracing;
	private int raytraceheight;

	public BlockSideSlopes(int i, Block baseBlock) {
		this(i, baseBlock, 0);
	}

	public BlockSideSlopes(int i, Block baseBlock, int baseBlockDmg) {
		super(i, ConfigurationLib.SideSlopesRenderID, baseBlock, baseBlockDmg,
				ConfigurationLib.tabCustom);
		// TODO Auto-generated constructor stub
	}

	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4) {
		// TODO:: actually set the right block bounds
		if (raytracing) {

			setSideSlopeBounds(raytraceheight,
					par1IBlockAccess.getBlockMetadata(par2, par3, par4));

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
	public int onBlockPlaced(World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ, int meta) {
		return meta;
	}

	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i,
			int j, int k, int l) {
		return true;

	}

	public void addCollisionBoxesToList(World par1World, int par2, int par3,
			int par4, AxisAlignedBB par5AxisAlignedBB, List par6List,
			Entity par7Entity) {
		int iDir = par1World.getBlockMetadata(par2, par3, par4);
		for (int i = 1; i <= 16; i++) {
			setSideSlopeBounds(iDir, i);
			super.addCollisionBoxesToList(par1World, par2, par3, par4,
					par5AxisAlignedBB, par6List, par7Entity);
		}
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	private void setSideSlopeBounds(int i, int iDir) {
		switch (iDir) {
		case 0:
			this.setBlockBounds(1.0F - (.0625F * i), 0.0F, (.0625F * i), 1.0F,
					1.0f, 1.0F);
			break;
		case 1:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F - (.0625F * i), 1.0f,
					(.0625F * i));
			break;
		case 2:
			this.setBlockBounds(0.0F, 0.0F, .0625F * i, .0625F * i, 1.0f, 1.0F);
			break;
		case 3:
			this.setBlockBounds((.0625F * i), 0.0F, 0.0F, 1.0F, 1.0f,
					(.0625F * i));
			break;

		}
	}

	public boolean isBlockSolidOnSide(World world, int x, int y, int z,
			ForgeDirection side) {
		boolean result = false;
		switch (world.getBlockMetadata(x, y, z)) {
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
