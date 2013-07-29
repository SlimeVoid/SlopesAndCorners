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

public class BlockSideSlopes extends BlockVannilaBased
{
	public BlockSideSlopes(int i, Block baseBlock){
		this(i,baseBlock,0);
	}
	public BlockSideSlopes(int i, Block baseBlock, int baseBlockDmg)
	{
		super(i, SlopesNCornersConfig.SideSlopesRenderID, baseBlock, baseBlockDmg,SlopesNCornersConfig.tabCustom);
		// TODO Auto-generated constructor stub
	}
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i,
			int j, int k, int l) {
	return true;
	
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
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
    {
    	int iDir = par1World.getBlockMetadata(par2, par3, par4);
    	for (int i =1; i<=16; i++){
    		switch(iDir){
    			case 0:
    				this.setBlockBounds(1.0F-(.0625F * i), 0.0F, (.0625F * i),1.0F, 1.0f, 1.0F);
    				break;
    			case 1:
    				this.setBlockBounds(0.0F, 0.0F, 0.0F,1.0F -(.0625F * i), 1.0f, (.0625F * i));
    				break;
    			case 2:
    				this.setBlockBounds(0.0F, 0.0F, .0625F * i,.0625F * i, 1.0f, 1.0F);
    				break;
    			case 3:
    				this.setBlockBounds((.0625F * i), 0.0F, 0.0F,1.0F, 1.0f, (.0625F * i));
    				break;
    				
    		}
    		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
    	}
    	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
    public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side){
    	boolean result = false;
    	switch (world.getBlockMetadata(x, y, z)){
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
