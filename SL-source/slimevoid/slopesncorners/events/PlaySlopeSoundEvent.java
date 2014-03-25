package slimevoid.slopesncorners.events;

import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.event.ForgeSubscribe;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.CoreLib;
import slimevoid.slopesncorners.tileentity.TileEntitySlopesBase;
import com.slimevoid.library.util.helpers.SlimevoidHelper;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class PlaySlopeSoundEvent {

	@ForgeSubscribe
	public void SlopeSoundEvent(PlaySoundEvent event) {
		if (event.name.startsWith("place.slimevoid." + CoreLib.MOD_RESOURCES)
			|| event.name.startsWith("dig.slimevoid." + CoreLib.MOD_RESOURCES)
			|| event.name.startsWith("step.slimevoid." + CoreLib.MOD_RESOURCES)) {
			if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
				World world = FMLClientHandler.instance().getClient().theWorld;
				int x = MathHelper.floor_float(event.x), y = MathHelper.floor_float(event.y), z = MathHelper.floor_float(event.z);
				int blockId = world.getBlockId(	x,
												y,
												z);
				if (blockId > 0 && blockId == ConfigurationLib.blockSlopesID) {
					TileEntitySlopesBase tileentity = (TileEntitySlopesBase) SlimevoidHelper.getBlockTileEntity(world,
																												x,
																												y,
																												z);
					if (tileentity != null) {
						SoundPoolEntry sound = event.manager.soundPoolSounds.getRandomSoundFromSoundPool(event.name.startsWith("dig.") ? tileentity.getStepSound().getBreakSound() : event.name.startsWith("place.") ? tileentity.getStepSound().getPlaceSound() : tileentity.getStepSound().getStepSound());
						event.result = sound;
					}
				}
			}
		}
	}

}
