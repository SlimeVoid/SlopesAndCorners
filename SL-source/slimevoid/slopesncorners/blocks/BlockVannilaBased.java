package slimevoid.slopesncorners.blocks;

import java.util.Random;

import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockIce;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockVannilaBased extends Block {
	protected final Block baseBlock;
	protected final int baseBlockDmg;
	protected final int renderID;
	protected final int states;
	protected final float[] blockHardnesses;
	protected final float[] blockResistancees;

	public BlockVannilaBased(int i, int renderID, Block baseBlock,
			int baseBlockDmg, CreativeTabs tab) {
		super(i, baseBlock.blockMaterial);

		this.setHardness(baseBlock.blockHardness);
		this.setResistance(baseBlock.blockResistance / 3.0F);
		this.setStepSound(baseBlock.stepSound);
		this.setCreativeTab(tab);
		this.slipperiness = baseBlock.slipperiness;
		this.baseBlock = baseBlock;
		this.baseBlockDmg = baseBlockDmg;
		this.renderID = renderID;
		states = 16;
		blockHardnesses = new float[1];
		blockHardnesses[0] = baseBlock.blockHardness;
		blockResistancees = new float[1];
		blockResistancees[0] = baseBlock.blockResistance;
		setLightOpacity(ConfigurationLib.SlopesNCornersOpacity);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase entityliving, ItemStack itemstack) {
		int l = MathHelper.floor_double((double) (entityliving.rotationYaw * 4.0F / 360.0F)/** + 0.5D **/) & 3;
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

	@Override
	public int onBlockPlaced(World world, int x, int y, int z,
			int side, float hitX, float hitY, float hitZ, int meta) {
		return side != 0 && (side == 1 || (double) hitY <= 0.5D) ? meta : meta | 4;
	}
	
	@Override
	public int getRenderType() {
		return renderID;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i,
			int j, int k, int l) {
		return true;

	}

	@SideOnly(Side.CLIENT)
	public int getBlockColor() {
		return baseBlock.getBlockColor();
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	public int getRenderBlockPass() {
		return this.baseBlock.getRenderBlockPass();
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

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return baseBlock.getIcon(par1, baseBlockDmg);
	}

	/**
	 * A randomly called display update to be able to add particles or other
	 * items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3,
			int par4, Random par5Random) {
		this.baseBlock.randomDisplayTick(par1World, par2, par3, par4,
				par5Random);
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Goes straight to getLightBrightnessForSkyBlocks for Blocks, does some fancy computing for Fluids
	 */
	public int getMixedBrightnessForBlock(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4) {
		return this.baseBlock.getMixedBrightnessForBlock(par1IBlockAccess,
				par2, par3, par4);
	}

	@SideOnly(Side.CLIENT)
	/**
	 * How bright to render this block based on the light its receiving. Args: iBlockAccess, x, y, z
	 */
	public float getBlockBrightness(IBlockAccess par1IBlockAccess, int par2,
			int par3, int par4) {
		return this.baseBlock.getBlockBrightness(par1IBlockAccess, par2, par3,
				par4);
	}

	public float getBlockHardness(World par1World, int par2, int par3, int par4) {
		return this.blockHardnesses[par1World
				.getBlockMetadata(par2, par3, par4) / states];
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

	public void registerIcons(IconRegister par1IconRegister) {
	}
}
