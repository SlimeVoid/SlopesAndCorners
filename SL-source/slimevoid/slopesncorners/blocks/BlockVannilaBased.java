package slimevoid.slopesncorners.blocks;

import java.util.Random;

import slimevoid.slopesncorners.core.SlopeNCorners;
import slimevoid.slopesncorners.core.config.SlopesNCornersConfig;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockMycelium;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockVannilaBased extends Block
{
	protected final Block BaseBlock;
	protected final int BaseBlockDmg;
	protected final int RenderID;
	public BlockVannilaBased(int i,int renderID,Block baseBlock,int baseBlockDmg,CreativeTabs tab) {
		super(i, baseBlock.blockMaterial);
       
        this.setHardness(baseBlock.blockHardness);
        this.setResistance(baseBlock.blockResistance / 3.0F);
        this.setStepSound(baseBlock.stepSound);
        this.setCreativeTab(tab);
        
        BaseBlock = baseBlock;
        BaseBlockDmg = baseBlockDmg;
        RenderID = renderID;
		setLightOpacity(SlopesNCornersConfig.SlopesNCornersOpacity);
	}
	@Override
	public int getRenderType() {
		return RenderID;
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
    public int getBlockColor()
    {
	return BaseBlock.getBlockColor();
    }
	@SideOnly(Side.CLIENT)

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return this.BaseBlock.getRenderBlockPass();
    }
    @SideOnly(Side.CLIENT)

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
    
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
    	return BaseBlock.getIcon(par1, BaseBlockDmg);
    }
    
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        this.BaseBlock.randomDisplayTick(par1World, par2, par3, par4, par5Random);
    }
    @SideOnly(Side.CLIENT)

    /**
     * Goes straight to getLightBrightnessForSkyBlocks for Blocks, does some fancy computing for Fluids
     */
    public int getMixedBrightnessForBlock(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return this.BaseBlock.getMixedBrightnessForBlock(par1IBlockAccess, par2, par3, par4);
    }

    @SideOnly(Side.CLIENT)

    /**
     * How bright to render this block based on the light its receiving. Args: iBlockAccess, x, y, z
     */
    public float getBlockBrightness(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return this.BaseBlock.getBlockBrightness(par1IBlockAccess, par2, par3, par4);
    }
    public void registerIcons(IconRegister par1IconRegister)
    {}
}
