package slimevoid.slopesncorners.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import slimevoid.slopesncorners.api.ISlope;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.NBTLib;
import slimevoid.slopesncorners.core.lib.SlopesLib;
import slimevoidlib.tileentity.TileEntityBase;

public class TileEntitySlopesBase extends TileEntityBase implements ISlope {
	
	private short slopeIndex;
	
	public TileEntitySlopesBase() {
		super();
	}

	@Override
	public boolean tryAddSlope(int slopeIndex) {
		this.setSlopeIndex((short) slopeIndex);
		return true;
	}
	
	@Override
	public void onBlockPlaced(ItemStack itemstack, int side, EntityLivingBase entity) {
		super.onBlockPlaced(itemstack, side, entity);
	}
	
	public void setSlopeIndex(short slopeIndex) {
		this.slopeIndex = slopeIndex;
	}
	
	public short getSlopeIndex() {
		return this.slopeIndex;
	}
	
	@Override
	public int getLightValue() {
		return 0;
	}

	@Override
	public int getRotatedSide(int side) {
		return 0;
	}

	@Override
	public int getBlockID() {
		return ConfigurationLib.blockSlopes.blockID;
	}

	@Override
	public StepSound getStepSound() {
		Block block = SlopesLib.getBlock(SlopesLib.damageToCoverValue(this.getSlopeIndex()));
		return block != null ? block.stepSound : null;
	}

	@Override
	public Icon getBlockTexture(int x, int y, int z, int metadata, int side) {
		return SlopesLib.getIconForSide(SlopesLib.damageToCoverValue(this.getSlopeIndex()), side);
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
