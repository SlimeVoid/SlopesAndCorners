package slimevoid.slopesncorners.blocks;

import java.util.List;

import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockSideSlopes extends BlockVannilaBased {
	private boolean raytracing;
	private int raytraceheight;

	public BlockSideSlopes(int i, Block baseBlock) {
		this(i, baseBlock, 0);
	}

	public BlockSideSlopes(int i, Block baseBlock, int baseBlockDmg) {
		super(i, ConfigurationLib.SideSlopesRenderID, baseBlock,
				baseBlockDmg, ConfigurationLib.tabCustom);
		// TODO Auto-generated constructor stub
	}

	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4) {
		// TODO:: actually set the right block bounds
		if(raytracing){
			
				setSideSlopeBounds(raytraceheight, par1IBlockAccess.getBlockMetadata(par2, par3, par4));
			
		}else{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

	}
	 public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 startVec, Vec3 endVec) {
    	 MovingObjectPosition amovingobjectposition = null;
    	 raytracing = true;
    	 for (int i = 1; i <= 16; i++) {
    		 raytraceheight = i;	 
    		 MovingObjectPosition tempmovingobjectposition = super.collisionRayTrace(world, x, y, z, startVec, endVec);
    		 if (tempmovingobjectposition != null)
    			 if (amovingobjectposition == null || startVec.squareDistanceTo(tempmovingobjectposition.hitVec) < startVec.squareDistanceTo(amovingobjectposition.hitVec))
    				 amovingobjectposition =tempmovingobjectposition;
    	 }
    	 raytracing = false;
    	 return amovingobjectposition;
	 }
	 
	@Override
	public int onBlockPlaced(World world, int x, int y, int z,
			int side, float hitX, float hitY, float hitZ, int meta) {
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
			setSideSlopeBounds(iDir,i);
			super.addCollisionBoxesToList(par1World, par2, par3, par4,
					par5AxisAlignedBB, par6List, par7Entity);
		}
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	private void setSideSlopeBounds(int i,int iDir){
		switch (iDir) {
		case 0:
			this.setBlockBounds(1.0F - (.0625F * i), 0.0F, (.0625F * i),
					1.0F, 1.0f, 1.0F);
			break;
		case 1:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F - (.0625F * i),
					1.0f, (.0625F * i));
			break;
		case 2:
			this.setBlockBounds(0.0F, 0.0F, .0625F * i, .0625F * i, 1.0f,
					1.0F);
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

   /* @Override
	public boolean onBlockActivated(World world, int i, int j, int k,
			EntityPlayer entityplayer, int l, float a, float b, float c) {
		if (this.BaseBlock instanceof BlockCloth) {

			ItemStack itemstack = entityplayer.inventory.getCurrentItem();
			if (itemstack != null
					&& itemstack.itemID == Item.dyePowder.itemID) {
				int lOldMeta = world.getBlockMetadata(i, j, k);

				if (itemstack.getItemDamage() == 0
						&& SlopesNCornersConfig.BlockBlackWoolSideSlopes != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockBlackWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 1
						&& SlopesNCornersConfig.BlockRedWoolSideSlopes != null) {
					world.setBlock(i, j, k,
							SlopesNCornersConfig.BlockRedWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 2
						&& SlopesNCornersConfig.BlockGreenWoolSideSlopes != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockGreenWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 3
						&& SlopesNCornersConfig.BlockBrownWoolSideSlopes != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockBrownWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 4
						&& SlopesNCornersConfig.BlockBlueWoolSideSlopes != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockBlueWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 5
						&& SlopesNCornersConfig.BlockPurpleWoolSideSlopes != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockPurpleWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 6
						&& SlopesNCornersConfig.BlockCyanWoolSideSlopes != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockCyanWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 7
						&& SlopesNCornersConfig.BlockSilverWoolSideSlopes != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockSilverWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 8
						&& SlopesNCornersConfig.BlockGrayWoolSideSlopes != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockGrayWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 9
						&& SlopesNCornersConfig.BlockPinkWoolSideSlopes != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockPinkWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 10
						&& SlopesNCornersConfig.BlockLimeWoolSideSlopes != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockLimeWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 11
						&& SlopesNCornersConfig.BlockYellowWoolSideSlopes != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockYellowWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 12
						&& SlopesNCornersConfig.BlockLightBlueWoolSideSlopes != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockLightBlueWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 13
						&& SlopesNCornersConfig.BlockMagentaWoolSideSlopes != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockMagentaWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 14
						&& SlopesNCornersConfig.BlockOrangeWoolSideSlopes!= null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockOrangeWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 15
						&& SlopesNCornersConfig.BlockWhiteWoolSideSlopes!= null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockWhiteWoolSideSlopes.blockID,
							lOldMeta,3);
					return true;
				}
			}
		}
		return false;
	}*/
}
