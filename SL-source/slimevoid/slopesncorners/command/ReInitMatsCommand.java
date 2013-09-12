package slimevoid.slopesncorners.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib;

public class ReInitMatsCommand extends CommandBase {

	@Override
	public String getCommandName() {
		return "reloadslopes";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/reloadslopes";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		ConfigurationLib.reInitSlopeMats();;
	}

}
