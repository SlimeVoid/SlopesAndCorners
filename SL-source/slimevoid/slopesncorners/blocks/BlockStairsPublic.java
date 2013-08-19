package slimevoid.slopesncorners.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockIce;
import net.minecraft.block.BlockStairs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStairsPublic extends BlockStairs {
	private Block baseBlock;

	public BlockStairsPublic(int i, Block baseBlock) {
		this(i, baseBlock, 0);
	}

	public BlockStairsPublic(int par1, Block par2Block, int par3) {
		super(par1, par2Block, par3);
		this.setLightOpacity(par2Block.lightOpacity[0]);
		baseBlock = par2Block;
		this.slipperiness = par2Block.slipperiness;
		this.setCreativeTab(ConfigurationLib.tabCustom);
		// TODO Fix gray grass
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns the color this block should be rendered. Used by leaves.
	 */
	public int getRenderColor(int par1) {
		return baseBlock.getRenderColor(par1);
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
	 * when first determining what to render.
	 */
	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2,
			int par3, int par4) {
		return baseBlock.colorMultiplier(par1IBlockAccess, par2, par3, par4);
	}

	/**
	 * Called when the player destroys a block with an item that can harvest it.
	 * (i, j, k) are the coordinates of the block and l is the block's
	 * subtype/damage.
	 */
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer,
			int par3, int par4, int par5, int par6) {
		if (baseBlock instanceof BlockIce)
			baseBlock.harvestBlock(par1World, par2EntityPlayer, par3, par4,
					par5, par6);
		else
			super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5,
					par6);
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random) {
		return baseBlock.quantityDropped(par1Random);
	}

	/**
	 * Return true if a player with Silk Touch can harvest this block directly,
	 * and not its normal drops.
	 */
	protected boolean canSilkHarvest() {
		return true;
	}

}
