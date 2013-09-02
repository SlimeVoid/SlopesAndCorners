package slimevoid.slopesncorners.blocks.lib;

import cpw.mods.fml.common.registry.LanguageRegistry;
import slimevoid.slopesncorners.core.lib.MaterialsLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib.IMaterialHandler;

public class SlopeMaterialHandler implements IMaterialHandler {

	@Override
	public void addMaterialReference(int i) {
		String name = MaterialsLib.getName(i);
		String desc = MaterialsLib.getDesc(i);
		LanguageRegistry.instance().addStringLocalization(
				(new StringBuilder())
					.append("tile.side.").append(name).append(".name").toString(),
				(new StringBuilder())
					.append(desc).append(" Side Slope").toString());
		LanguageRegistry.instance().addStringLocalization(
				(new StringBuilder())
					.append("tile.oblic.").append(name).append(".name").toString(),
				(new StringBuilder())
					.append(desc).append(" Oblic").toString());
		LanguageRegistry.instance().addStringLocalization(
				(new StringBuilder())
					.append("tile.slant.").append(name).append(".name").toString(),
				(new StringBuilder())
					.append(desc).append(" Slanted Corner").toString());
		LanguageRegistry.instance().addStringLocalization(
				(new StringBuilder())
					.append("tile.stairs.").append(name).append(".name").toString(),
				(new StringBuilder())
					.append(desc).append(" Stairs").toString());
		LanguageRegistry.instance().addStringLocalization(
				(new StringBuilder())
					.append("tile.slope.").append(name).append(".name").toString(),
				(new StringBuilder())
					.append(desc).append(" Slope").toString());
		
		// TODO :: Slope Recipes
	}
	
	public static void registerSlopes() {
		// TODO :: Slope registration here
	}

}
