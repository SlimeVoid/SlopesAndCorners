package slimevoid.slopesncorners.events;

import net.minecraft.block.StepSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import slimevoid.slopesncorners.core.lib.CoreLib;
import slimevoid.slopesncorners.tileentity.TileEntitySlopesBase;
import com.slimevoid.library.util.helpers.BlockHelper;

public class StepSoundEvent {

	@ForgeSubscribe
	public void StepSoundInterrupt(PlaySoundAtEntityEvent event) {
		if (event != null && event.name != null
			&& event.name.startsWith("step.slimevoid." + CoreLib.MOD_RESOURCES)) {
			TileEntity tileentity = BlockHelper.getTileEntityAtBase(event.entity);
			if (tileentity != null
				&& tileentity instanceof TileEntitySlopesBase) {
				StepSound stepsound = ((TileEntitySlopesBase) tileentity).getStepSound();
				if (stepsound != null) {
					event.name = stepsound.getStepSound();
				}
			}
		}
	}

}
