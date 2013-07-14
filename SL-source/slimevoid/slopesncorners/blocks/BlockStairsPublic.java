package slimevoid.slopesncorners.blocks;

import java.util.Random;

import slimevoid.slopesncorners.core.config.SlopesNCornersConfig;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCloth;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockIce;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockWeb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStairsPublic extends BlockStairs
{
private Block baseBlock;
public BlockStairsPublic(int i, Block baseBlock){
	this(i,baseBlock,0);
}
	public BlockStairsPublic(int par1, Block par2Block, int par3)
	{
		super(par1, par2Block, par3);
		this.setLightOpacity(par2Block.lightOpacity[0]);
		baseBlock = par2Block;
        this.slipperiness = par2Block.slipperiness;
		this.setCreativeTab(SlopesNCornersConfig.tabCustom);
		// TODO Fix gray grass
	}@SideOnly(Side.CLIENT)

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    public int getRenderColor(int par1)
    {
    	return baseBlock.getRenderColor(par1);
    }
	@SideOnly(Side.CLIENT)
	/**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
    	return baseBlock.colorMultiplier(par1IBlockAccess, par2, par3, par4);
    }
	/**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
    	if (baseBlock instanceof BlockIce) baseBlock.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
    	else super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
    }
	 /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
    	return baseBlock.quantityDropped(par1Random);
    }
    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest()
    {
    	return true;
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
						&& SlopesNCornersConfig.BlockBlackWoolStairs != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockBlackWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 1
						&& SlopesNCornersConfig.BlockRedWoolStairs != null) {
					world.setBlock(i, j, k,
							SlopesNCornersConfig.BlockRedWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 2
						&& SlopesNCornersConfig.BlockGreenWoolStairs != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockGreenWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 3
						&& SlopesNCornersConfig.BlockBrownWoolStairs != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockBrownWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 4
						&& SlopesNCornersConfig.BlockBlueWoolStairs != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockBlueWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 5
						&& SlopesNCornersConfig.BlockPurpleWoolStairs != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockPurpleWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 6
						&& SlopesNCornersConfig.BlockCyanWoolStairs != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockCyanWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 7
						&& SlopesNCornersConfig.BlockSilverWoolStairs != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockSilverWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 8
						&& SlopesNCornersConfig.BlockGrayWoolStairs != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockGrayWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 9
						&& SlopesNCornersConfig.BlockPinkWoolStairs != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockPinkWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 10
						&& SlopesNCornersConfig.BlockLimeWoolStairs != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockLimeWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 11
						&& SlopesNCornersConfig.BlockYellowWoolStairs != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockYellowWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 12
						&& SlopesNCornersConfig.BlockLightBlueWoolStairs != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockLightBlueWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 13
						&& SlopesNCornersConfig.BlockMagentaWoolStairs != null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockMagentaWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 14
						&& SlopesNCornersConfig.BlockOrangeWoolStairs!= null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockOrangeWoolStairs.blockID,
							lOldMeta,3);
					return true;
				} else if (itemstack.getItemDamage() == 15
						&& SlopesNCornersConfig.BlockWhiteWoolStairs!= null) {
					world.setBlock(
							i,
							j,
							k,
							SlopesNCornersConfig.BlockWhiteWoolStairs.blockID,
							lOldMeta,3);
					return true;
				}
			}
		}
		return false;
	}*/
}
