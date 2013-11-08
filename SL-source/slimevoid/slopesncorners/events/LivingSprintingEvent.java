package slimevoid.slopesncorners.events;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import slimevoid.slopesncorners.blocks.BlockSlopesBase;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib;
import slimevoid.slopesncorners.tileentity.TileEntitySlopesBase;
import slimevoidlib.util.helpers.SlimevoidHelper;

public class LivingSprintingEvent {

	private static Random	rand	= new Random();

	@ForgeSubscribe
	public void onLivingUpdate(LivingUpdateEvent event) {
		EntityLivingBase entity = event.entityLiving;
		if (entity.isSprinting() && !entity.isInWater()) {
			int x = MathHelper.floor_double(entity.posX);
			int y = MathHelper.floor_double(entity.posY - 0.20000000298023224D
											- (double) entity.yOffset);
			int z = MathHelper.floor_double(entity.posZ);
			int id = entity.worldObj.getBlockId(x,
												y,
												z);
			if (id > 0 && id == ConfigurationLib.blockSlopes.blockID) {
				TileEntitySlopesBase slope = (TileEntitySlopesBase) SlimevoidHelper.getBlockTileEntity(	entity.worldObj,
																										x,
																										y,
																										z);
				if (slope != null) {
					ItemStack blockStack = MaterialsLib.getItemStack(slope.getMaterial());
					Block block = Block.blocksList[blockStack.itemID];
					((BlockSlopesBase) Block.blocksList[id]).setIcon(Block.blocksList[id].getBlockTexture(	entity.worldObj,
																											x,
																											y,
																											z,
																											0));
				}
			}
		}
	}

}
