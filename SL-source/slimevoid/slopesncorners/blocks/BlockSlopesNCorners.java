package slimevoid.slopesncorners.blocks;

import java.util.List;

import slimevoid.slopesncorners.core.lib.ConfigurationLib;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockSlopesNCorners extends BlockVannilaBased {
	public BlockSlopesNCorners(int i, Block baseBlock) {
		this(i, baseBlock, 0);
	}

	public BlockSlopesNCorners(int i, Block baseBlock, int baseBlockDmg) {
		super(i, ConfigurationLib.SlopesNCornersRenderID, baseBlock,
				baseBlockDmg, ConfigurationLib.tabCustom);
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4) {
		// TODO: actually set the right block bounds
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);

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
			switch (iDir) {
			case 0:
				this.setBlockBounds(.0625F * i, 0.0F, 0.0F, 1.0f, .0625F * i,
						1.0F);
				break;
			case 1:
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0f - (.0625F * i),
						.0625F * i, 1.0F);
				break;
			case 2:
				this.setBlockBounds(0.0f, 0.0F, .0625F * i, 1.0f, .0625F * i,
						1.0F);
				break;
			case 3:
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, .0625F * i,
						1.0f - (.0625F * i));
				break;
			case 4:
				this.setBlockBounds(1.0F - (.0625F * i), (.0625F * i), 0.0F,
						1.0F, 1.0f, 1.0F);
				break;
			case 5:
				this.setBlockBounds(0.0F, .0625F * i, 0.0F, (.0625F * i), 1.0f,
						1.0F);
				break;
			case 6:
				this.setBlockBounds(0.0F, (.0625F * i), 1.0F - (.0625F * i),
						1.0F, 1.0f, 1.0F);
				break;
			case 7:
				this.setBlockBounds(0.0F, .0625F * i, 0.0F, 1.0F, 1.0f,
						(.0625F * i));
				break;
			}

			super.addCollisionBoxesToList(par1World, par2, par3, par4,
					par5AxisAlignedBB, par6List, par7Entity);
		}

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void addCornersCollisionBoxesToList(World par1World, int par2,
			int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List,
			Entity par7Entity, int iDir) {

		for (int i = 1; i <= 16; i++) {
			switch (iDir) {
			case 0:
				this.setBlockBounds(.0625F * i, 0.0F, .0625F * i, 1.0f,
						.0625F * i, 1.0F);
				break;
			case 1:
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0f - (.0625F * i),
						.0625F * i, 1.0f - (.0625F * i));
				break;
			case 2:
				this.setBlockBounds(0.0f, 0.0F, .0625F * i,
						1.0f - (.0625F * i), .0625F * i, 1.0F);
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
				this.setBlockBounds(1.0F - (.0625F * i), .0625F * i, 0.0F,
						1.0F, 1.0f, (.0625F * i));
				break;
			}

			super.addCollisionBoxesToList(par1World, par2, par3, par4,
					par5AxisAlignedBB, par6List, par7Entity);
		}

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void addIntCornersCollisionBoxesToList(World par1World, int par2,
			int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List,
			Entity par7Entity, int iDir) {

		for (int i = 1; i <= 16; i++) {
			switch (iDir) {
			case 0:
				this.setBlockBounds(.0625F * i, 0.0F, 0.0F, 1.0f, .0625F * i,
						1.0F);
				super.addCollisionBoxesToList(par1World, par2, par3, par4,
						par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(0.0f, 0.0F, .0625F * i, 1.0f, .0625F * i,
						1.0F);
				break;
			case 1:
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0f - (.0625F * i),
						.0625F * i, 1.0F);
				super.addCollisionBoxesToList(par1World, par2, par3, par4,
						par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, .0625F * i,
						1.0f - (.0625F * i));
				break;
			case 2:
				this.setBlockBounds(0.0f, 0.0F, .0625F * i, 1.0f, .0625F * i,
						1.0F);
				super.addCollisionBoxesToList(par1World, par2, par3, par4,
						par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0f - (.0625F * i),
						.0625F * i, 1.0F);
				break;
			case 3:
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, .0625F * i,
						1.0f - (.0625F * i));
				super.addCollisionBoxesToList(par1World, par2, par3, par4,
						par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(.0625F * i, 0.0F, 0.0F, 1.0f, .0625F * i,
						1.0F);
				break;
			case 4:
				this.setBlockBounds(1.0F - (.0625F * i), (.0625F * i), 0.0F,
						1.0F, 1.0f, 1.0F);
				super.addCollisionBoxesToList(par1World, par2, par3, par4,
						par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(0.0F, (.0625F * i), 1.0F - (.0625F * i),
						1.0F, 1.0f, 1.0F);
				break;
			case 5:
				this.setBlockBounds(0.0F, .0625F * i, 0.0F, (.0625F * i), 1.0f,
						1.0F);
				super.addCollisionBoxesToList(par1World, par2, par3, par4,
						par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(0.0F, .0625F * i, 0.0F, 1.0F, 1.0f,
						(.0625F * i));
				break;
			case 6:
				this.setBlockBounds(0.0F, (.0625F * i), 1.0F - (.0625F * i),
						1.0F, 1.0f, 1.0F);
				super.addCollisionBoxesToList(par1World, par2, par3, par4,
						par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(0.0F, .0625F * i, 0.0F, (.0625F * i), 1.0f,
						1.0F);
				break;
			case 7:
				this.setBlockBounds(0.0F, .0625F * i, 0.0F, 1.0F, 1.0f,
						(.0625F * i));
				super.addCollisionBoxesToList(par1World, par2, par3, par4,
						par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(1.0F - (.0625F * i), (.0625F * i), 0.0F,
						1.0F, 1.0f, 1.0F);
				break;
			}
			super.addCollisionBoxesToList(par1World, par2, par3, par4,
					par5AxisAlignedBB, par6List, par7Entity);
		}

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
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

/*@Override
public boolean onBlockActivated(World world, int i, int j, int k,
		EntityPlayer entityplayer, int l, float a, float b, float c) {
	if (this.BaseBlock instanceof BlockCloth) {

		ItemStack itemstack = entityplayer.inventory.getCurrentItem();
		if (itemstack != null
				&& itemstack.itemID == Item.dyePowder.itemID) {
			int lOldMeta = world.getBlockMetadata(i, j, k);

			if (itemstack.getItemDamage() == 0
					&& SlopesNCornersConfig.BlockBlackWoolSlopesNCorners != null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockBlackWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 1
					&& SlopesNCornersConfig.BlockRedWoolSlopesNCorners != null) {
				world.setBlock(i, j, k,
						SlopesNCornersConfig.BlockRedWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 2
					&& SlopesNCornersConfig.BlockGreenWoolSlopesNCorners != null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockGreenWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 3
					&& SlopesNCornersConfig.BlockBrownWoolSlopesNCorners != null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockBrownWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 4
					&& SlopesNCornersConfig.BlockBlueWoolSlopesNCorners != null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockBlueWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 5
					&& SlopesNCornersConfig.BlockPurpleWoolSlopesNCorners != null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockPurpleWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 6
					&& SlopesNCornersConfig.BlockCyanWoolSlopesNCorners != null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockCyanWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 7
					&& SlopesNCornersConfig.BlockSilverWoolSlopesNCorners != null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockSilverWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 8
					&& SlopesNCornersConfig.BlockGrayWoolSlopesNCorners != null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockGrayWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 9
					&& SlopesNCornersConfig.BlockPinkWoolSlopesNCorners != null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockPinkWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 10
					&& SlopesNCornersConfig.BlockLimeWoolSlopesNCorners != null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockLimeWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 11
					&& SlopesNCornersConfig.BlockYellowWoolSlopesNCorners != null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockYellowWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 12
					&& SlopesNCornersConfig.BlockLightBlueWoolSlopesNCorners != null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockLightBlueWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 13
					&& SlopesNCornersConfig.BlockMagentaWoolSlopesNCorners != null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockMagentaWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 14
					&& SlopesNCornersConfig.BlockOrangeWoolSlopesNCorners!= null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockOrangeWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			} else if (itemstack.getItemDamage() == 15
					&& SlopesNCornersConfig.BlockWhiteWoolSlopesNCorners!= null) {
				world.setBlock(
						i,
						j,
						k,
						SlopesNCornersConfig.BlockWhiteWoolSlopesNCorners.blockID,
						lOldMeta,3);
				return true;
			}
		}
	}
	return false;
}*/

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
