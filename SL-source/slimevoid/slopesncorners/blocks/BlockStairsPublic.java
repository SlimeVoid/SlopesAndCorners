package slimevoid.slopesncorners.blocks;

import slimevoid.slopesncorners.core.config.SlopesNCornersConfig;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockStairs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStairsPublic extends BlockStairs
{
private Block BaseBlock;
public BlockStairsPublic(int i, Block baseBlock){
	this(i,baseBlock,0);
}
	public BlockStairsPublic(int par1, Block par2Block, int par3)
	{
		super(par1, par2Block, par3);
		this.setLightOpacity(par2Block.lightOpacity[0]);
		BaseBlock = par2Block;
		this.setCreativeTab(SlopesNCornersConfig.tabCustom);
		// TODO Fix gray grass
	}@SideOnly(Side.CLIENT)

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    public int getRenderColor(int par1)
    {
    	return BaseBlock.getRenderColor(par1);
    }
	@SideOnly(Side.CLIENT)
	/**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
    	return BaseBlock.colorMultiplier(par1IBlockAccess, par2, par3, par4);
    }
	@Override
	public boolean onBlockActivated(World world, int i, int j, int k,
			EntityPlayer entityplayer, int l, float a, float b, float c) {
		if (this.BaseBlock instanceof BlockColored) {

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
	}
}
