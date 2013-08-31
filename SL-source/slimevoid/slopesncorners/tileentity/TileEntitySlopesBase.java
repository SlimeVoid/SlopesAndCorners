package slimevoid.slopesncorners.tileentity;

import net.minecraft.block.StepSound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.NBTLib;
import slimevoid.slopesncorners.core.lib.SlopesLib;
import slimevoidlib.tileentity.TileEntityBase;

public class TileEntitySlopesBase extends TileEntityBase {
	
	private short slopeIndex;
	
	public TileEntitySlopesBase() {
		super();
	}
	
	@Override
	public void onBlockPlaced(ItemStack itemstack, int side, EntityLivingBase entity) {
		super.onBlockPlaced(itemstack, side, entity);
		this.setSlopeIndex((short) SlopesLib.damageToCoverValue(itemstack.getItemDamage()));
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
		return null;
	}

	@Override
	public Icon getBlockTexture(int x, int y, int z, int metadata, int side) {
		return null;
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
