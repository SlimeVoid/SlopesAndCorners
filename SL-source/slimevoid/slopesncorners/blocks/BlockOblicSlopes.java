package slimevoid.slopesncorners.blocks;

import java.util.List;

import slimevoid.slopesncorners.core.config.SlopesNCornersConfig;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCloth;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockOblicSlopes extends BlockVannilaBased
{
	public BlockOblicSlopes(int i, Block baseBlock){
		this(i,baseBlock,0);
	}
	public BlockOblicSlopes(int i, Block baseBlock, int baseBlockDmg)
	{
		super(i, SlopesNCornersConfig.OblicSlopesRenderID, baseBlock, baseBlockDmg,SlopesNCornersConfig.tabCustom);
		// TODO Auto-generated constructor stub
	}
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        //TODO: actually set the right block bounds
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        
    }
	 /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int i1 = par1World.getBlockMetadata(par2, par3, par4) & 4;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2 | i1, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1 | i1, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3 | i1, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 0 | i1, 2);
        }
    }
    @Override
    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        return par5 != 0 && (par5 == 1 || (double)par7 <= 0.5D) ? par9 : par9 | 4;
    }	
    @Override
	public void addCollisionBoxesToList(World world, int i, int j, int k,
			AxisAlignedBB axisalignedbb, List arraylist, Entity entity) {
		int l = world.getBlockMetadata(i, j, k) % 8;
		if (l == 0) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.5F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 1) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 0.5F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 2) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.0F, 0.5F, 0.5F, 0.5F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 3) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 4) {
			setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.5F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 5) {
			setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 6) {
			setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.0F, 0.0F, 0.5F, 0.5F, 0.5F, 1.0F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		} else if (l == 7) {
			setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
			setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
			super.addCollisionBoxesToList(world, i, j, k, axisalignedbb,
					arraylist, entity);
		}
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
    public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side){
    	boolean result = false;
    	if (side == side.UP && world.getBlockMetadata(x, y, z) /4 == 1)
    		return true;
    	if (side == side.DOWN && world.getBlockMetadata(x, y, z) /4 == 0)
    		return true;
    	switch (world.getBlockMetadata(x, y, z)){
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
    @Override
   	public boolean onBlockActivated(World world, int i, int j, int k,
   			EntityPlayer entityplayer, int l, float a, float b, float c) {
   		if (this.BaseBlock instanceof BlockCloth) {

   			ItemStack itemstack = entityplayer.inventory.getCurrentItem();
   			if (itemstack != null
   					&& itemstack.itemID == Item.dyePowder.itemID) {
   				int lOldMeta = world.getBlockMetadata(i, j, k);

   				if (itemstack.getItemDamage() == 0
   						&& SlopesNCornersConfig.BlockBlackWoolIntCorners != null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockBlackWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 1
   						&& SlopesNCornersConfig.BlockRedWoolIntCorners != null) {
   					world.setBlock(i, j, k,
   							SlopesNCornersConfig.BlockRedWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 2
   						&& SlopesNCornersConfig.BlockGreenWoolIntCorners != null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockGreenWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 3
   						&& SlopesNCornersConfig.BlockBrownWoolIntCorners != null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockBrownWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 4
   						&& SlopesNCornersConfig.BlockBlueWoolIntCorners != null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockBlueWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 5
   						&& SlopesNCornersConfig.BlockPurpleWoolIntCorners != null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockPurpleWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 6
   						&& SlopesNCornersConfig.BlockCyanWoolIntCorners != null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockCyanWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 7
   						&& SlopesNCornersConfig.BlockSilverWoolIntCorners != null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockSilverWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 8
   						&& SlopesNCornersConfig.BlockGrayWoolIntCorners != null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockGrayWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 9
   						&& SlopesNCornersConfig.BlockPinkWoolIntCorners != null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockPinkWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 10
   						&& SlopesNCornersConfig.BlockLimeWoolIntCorners != null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockLimeWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 11
   						&& SlopesNCornersConfig.BlockYellowWoolIntCorners != null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockYellowWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 12
   						&& SlopesNCornersConfig.BlockLightBlueWoolIntCorners != null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockLightBlueWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 13
   						&& SlopesNCornersConfig.BlockMagentaWoolIntCorners != null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockMagentaWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 14
   						&& SlopesNCornersConfig.BlockOrangeWoolIntCorners!= null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockOrangeWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				} else if (itemstack.getItemDamage() == 15
   						&& SlopesNCornersConfig.BlockWhiteWoolIntCorners!= null) {
   					world.setBlock(
   							i,
   							j,
   							k,
   							SlopesNCornersConfig.BlockWhiteWoolIntCorners.blockID,
   							lOldMeta,3);
   					return true;
   				}
   			}
   		}
   		return false;
   	}
}
