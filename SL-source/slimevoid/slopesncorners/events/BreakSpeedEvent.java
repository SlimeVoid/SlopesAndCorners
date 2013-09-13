package slimevoid.slopesncorners.events;

import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class BreakSpeedEvent {
	
	@ForgeSubscribe
	public void breakSpeedHandler(PlayerEvent.BreakSpeed event){
		if (event.block.blockID == ConfigurationLib.blockSlopesID){
			//need block x, y, z
		}
	}

}
