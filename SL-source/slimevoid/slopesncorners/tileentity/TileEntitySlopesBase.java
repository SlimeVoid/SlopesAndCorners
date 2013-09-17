package slimevoid.slopesncorners.tileentity;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import slimevoid.slopesncorners.client.render.entities.SlopesEntityDiggingFX;
import slimevoid.slopesncorners.core.lib.BlockLib;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib;
import slimevoid.slopesncorners.core.lib.NBTLib;
import slimevoidlib.blocks.BlockBase;
import slimevoidlib.tileentity.TileEntityBase;
import slimevoidlib.util.helpers.ItemHelper;
import cpw.mods.fml.client.FMLClientHandler;

public class TileEntitySlopesBase extends TileEntityBase {

	private short	slopeIndex;

	public TileEntitySlopesBase() {
		super();
	}

	public void setSlopeIndex(short slopeIndex) {
		this.slopeIndex = slopeIndex;
	}

	public int getMaterial() {
		return MaterialsLib.damageToMaterialValue(this.getSlopeIndex());
	}

	public short getSlopeIndex() {
		return this.slopeIndex;
	}

	@Override
	public int getExtendedBlockID() {
		return BlockLib.getBlockDamage(this.worldObj
				.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord), this
				.getSlopeIndex());
	}

	@Override
	public int getLightValue() {
		Block block = MaterialsLib.getBlock(this.getMaterial());
		return block != null ? Block.lightValue[block.blockID] : 0;
	}

	@Override
	public int getRotatedSide(int side) {

		switch (rotation % 4) {
		case 0:
			switch (side) {
			case 2: // north
				return 4; // to west
			case 3: // south
				return 5; // to east
			case 4: // west
				return 3; // to south
			case 5: // east
				return 2; // to north
			default:
				return side;
			}
		case 1:
			switch (side) {
			case 2:// north
				return 5; // to east
			case 3:// south
				return 4; // to west
			case 4:// west
				return 2; // to north
			case 5: // east
				return 3; // to south
			default:
				return side;
			}
		case 2:
			switch (side) {
			case 2:// north
				return 3; // to south
			case 3:// south
				return 2; // to north
			case 4:// west
				return 5; // to east
			case 5: // east
				return 4; // to west
			default:
				return side;
			}
		case 3:
			return side;
		default:
			return 0;
		}
	}

	@Override
	public int getBlockID() {
		return ConfigurationLib.blockSlopes.blockID;
	}

	@Override
	public boolean removeBlockByPlayer(EntityPlayer player, BlockBase blockBase) {
		if (this.worldObj.isRemote) {
			return true;
		}
		ItemStack blockStack = MaterialsLib.getItemStack(this.getMaterial());
		int metadata = blockStack.getItemDamage();
		Block block = Block.blocksList[blockStack.itemID];
		if (block == null) {
			return false;
		}
		if (ForgeHooks.canHarvestBlock(block, player, metadata) && !player.capabilities.isCreativeMode) {
			ArrayList blockDropped = blockBase
					.getBlockDropped(	this.worldObj,
										this.xCoord,
										this.yCoord,
										this.zCoord,
										this.getBlockMetadata(),
										EnchantmentHelper
												.getFortuneModifier(player));
			ItemStack itemstack;
			for (Iterator stack = blockDropped.iterator(); stack.hasNext(); ItemHelper
					.dropItem(	this.worldObj,
								this.xCoord,
								this.yCoord,
								this.zCoord,
								itemstack))
				itemstack = (ItemStack) stack.next();

		}
		return this.worldObj.setBlockToAir(	this.xCoord,
											this.yCoord,
											this.zCoord);
	}

	@Override
	public float getBlockHardness(BlockBase blockBase) {
		Block block = MaterialsLib.getBlock(this.getMaterial());
		return block.getBlockHardness(	this.worldObj,
										this.xCoord,
										this.yCoord,
										this.zCoord);
	}

	@Override
	public float getPlayerRelativeBlockHardness(EntityPlayer entityplayer, BlockBase blockBase) {
		ItemStack blockStack = MaterialsLib.getItemStack(this.getMaterial());
		int metadata = blockStack.getItemDamage();
		Block block = Block.blocksList[blockStack.itemID];
		float hardness = this.getBlockHardness(blockBase);
		if (!ForgeHooks.canHarvestBlock(block, entityplayer, metadata)) {
			float speed = ForgeEventFactory.getBreakSpeed(	entityplayer,
															block,
															metadata,
															1.0F);
			return (speed < 0 ? 0 : speed) / hardness / 100F;
		} else {
			return entityplayer.getCurrentPlayerStrVsBlock(	block,
															true,
															metadata) / hardness / 30F;
		}
	}

	@Override
	public float getExplosionResistance(Entity entity, double explosionX, double explosionY, double explosionZ, BlockBase blockBase) {
		return MaterialsLib.getBlock(this.getMaterial())
				.getExplosionResistance(entity,
										this.worldObj,
										this.xCoord,
										this.yCoord,
										this.zCoord,
										explosionX,
										explosionY,
										explosionZ);
	}

	@Override
	public StepSound getStepSound() {
		Block block = MaterialsLib.getBlock(this.getMaterial());
		return block != null ? block.stepSound : null;
	}

	@Override
	public Icon getBlockTexture(int x, int y, int z, int metadata, int side) {
		return MaterialsLib.getIconForSide(MaterialsLib
				.damageToMaterialValue(this.getSlopeIndex()), this
				.getRotatedSide(side));
	}

	@Override
	public boolean addBlockDestroyEffects(BlockBase blockBase, int meta, EffectRenderer effectRenderer) {
		Block block = MaterialsLib.getBlock(this.getMaterial());
		FMLClientHandler.instance().getClient().sndManager
				.playSound(	block.stepSound.getBreakSound(),
							(float) this.xCoord + 0.5F,
							(float) this.yCoord + 0.5F,
							(float) this.zCoord + 0.5F,
							(block.stepSound.getVolume() + 1.0F) / 2.0F,
							block.stepSound.getPitch() * 0.8F);
		return SlopesEntityDiggingFX.doBlockDestroyEffects(	this.worldObj,
															this.xCoord,
															this.yCoord,
															this.zCoord,
															meta,
															effectRenderer,
															blockBase);
	}

	@Override
	public boolean addBlockHitEffects(BlockBase blockBase, MovingObjectPosition target, EffectRenderer effectRenderer) {
		return SlopesEntityDiggingFX.doBlockHitEffects(	this.worldObj,
														target,
														effectRenderer,
														blockBase);
	}

	@Override
	public int colorMultiplier(BlockBase blockBase) {
		return MaterialsLib.getBlock(this.getMaterial())
				.colorMultiplier(	this.worldObj,
									this.xCoord,
									this.yCoord,
									this.zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbttagcompound) {
		super.readFromNBT(nbttagcompound);
		this.slopeIndex = nbttagcompound.getShort(NBTLib.TILE_SLOPE_BLOCKID);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		nbttagcompound.setShort(NBTLib.TILE_SLOPE_BLOCKID, this.slopeIndex);
	}
}
