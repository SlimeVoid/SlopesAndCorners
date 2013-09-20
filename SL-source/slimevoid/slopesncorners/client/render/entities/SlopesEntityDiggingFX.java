package slimevoid.slopesncorners.client.render.entities;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.block.Block;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import slimevoid.slopesncorners.tileentity.TileEntitySlopesBase;
import slimevoidlib.materials.lib.MaterialsLib;

public class SlopesEntityDiggingFX extends EntityDiggingFX {

	public SlopesEntityDiggingFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, Block par14Block, int par15) {
		// getIcon is flipped so par15 and par1World.rand.nextInt(6) need to be swapped so par1World.rand.nextInt(6) comes first
		super(par1World, par2, par4, par6, par8, par10, par12, par14Block, par1World.rand.nextInt(6), par15, FMLClientHandler.instance().getClient().renderEngine);
	}

	public static boolean doBlockDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer, Block block) {
		TileEntitySlopesBase tile = (TileEntitySlopesBase) world.getBlockTileEntity(x,
																					y,
																					z);
		Block baseblock = MaterialsLib.getBlock(tile.getMaterial());
		if (baseblock != null) {
			byte b0 = 4;
			for (int j1 = 0; j1 < b0; ++j1) {
				for (int k1 = 0; k1 < b0; ++k1) {
					for (int l1 = 0; l1 < b0; ++l1) {
						double d0 = (double) x + ((double) j1 + 0.5D)
									/ (double) b0;
						double d1 = (double) y + ((double) k1 + 0.5D)
									/ (double) b0;
						double d2 = (double) z + ((double) l1 + 0.5D)
									/ (double) b0;
						SlopesEntityDiggingFX particle = new SlopesEntityDiggingFX(world, d0, d1, d2, d0
																										- (double) x
																										- 0.5D, d1
																												- (double) y
																												- 0.5D, d2
																														- (double) z
																														- 0.5D, baseblock, MaterialsLib.getBlockDmg(tile.getMaterial()));
						effectRenderer.addEffect(particle.func_70596_a(	x,
																		y,
																		z));
						// .applyColourMultiplier(x, y, z));
					}
				}

			}
			return true;
		}
		return false;
	}

	public static boolean doBlockHitEffects(World world, MovingObjectPosition target, EffectRenderer effectRenderer, Block block) {
		TileEntitySlopesBase tile = (TileEntitySlopesBase) world.getBlockTileEntity(target.blockX,
																					target.blockY,
																					target.blockZ);
		Block baseblock = MaterialsLib.getBlock(tile.getMaterial());
		if (baseblock != null) {
			float f = 0.1F;
			double d0 = (double) target.blockX
						+ world.rand.nextDouble()
						* (baseblock.getBlockBoundsMaxX()
							- baseblock.getBlockBoundsMinX() - (double) (f * 2.0F))
						+ (double) f + baseblock.getBlockBoundsMinX();
			double d1 = (double) target.blockY
						+ world.rand.nextDouble()
						* (baseblock.getBlockBoundsMaxY()
							- baseblock.getBlockBoundsMinY() - (double) (f * 2.0F))
						+ (double) f + baseblock.getBlockBoundsMinY();
			double d2 = (double) target.blockZ
						+ world.rand.nextDouble()
						* (baseblock.getBlockBoundsMaxZ()
							- baseblock.getBlockBoundsMinZ() - (double) (f * 2.0F))
						+ (double) f + baseblock.getBlockBoundsMinZ();

			SlopesEntityDiggingFX particle = new SlopesEntityDiggingFX(world, d0, d1, d2, 0.0D, 0.0D, 0.0D, baseblock, MaterialsLib.getBlockDmg(tile.getMaterial()));
			effectRenderer.addEffect(particle.func_70596_a(	target.blockX,
															target.blockY,
															target.blockZ)
			/*
			 * .applyColourMultiplier( target.blockX, target.blockY,
			 * target.blockZ)
			 */
			.multiplyVelocity(0.2F).multipleParticleScaleBy(0.6F));

			return true;
		}
		return false;
	}
}