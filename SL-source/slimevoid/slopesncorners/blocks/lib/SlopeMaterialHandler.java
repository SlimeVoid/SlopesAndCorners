package slimevoid.slopesncorners.blocks.lib;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import slimevoid.slopesncorners.core.lib.BlockLib;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib.IMaterialHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SlopeMaterialHandler implements IMaterialHandler {

	@Override
	public void addMaterialReference(int i) {
		String name = MaterialsLib.getName(i);
		String desc = MaterialsLib.getDesc(i);
		LanguageRegistry.instance()
				.addStringLocalization(	(new StringBuilder()).append(name)
												.append(".side")
												.append(".name").toString(),
										(new StringBuilder()).append(desc)
												.append(" Side Slope")
												.toString());
		LanguageRegistry.instance()
				.addStringLocalization(	(new StringBuilder()).append(name)
												.append(".oblic")
												.append(".name").toString(),
										(new StringBuilder()).append(desc)
												.append(" Oblic").toString());
		LanguageRegistry.instance()
				.addStringLocalization(	(new StringBuilder()).append(name)
												.append(".slant")
												.append(".name").toString(),
										(new StringBuilder()).append(desc)
												.append(" Slanted Corner")
												.toString());
		LanguageRegistry.instance()
				.addStringLocalization(	(new StringBuilder()).append(name)
												.append(".slope")
												.append(".name").toString(),
										(new StringBuilder()).append(desc)
												.append(" Slope").toString());
		LanguageRegistry.instance()
				.addStringLocalization(	(new StringBuilder()).append(name)
												.append(".halfSlope")
												.append(".name").toString(),
										(new StringBuilder()).append(desc)
												.append(" Half Slope")
												.toString());
		LanguageRegistry.instance()
				.addStringLocalization(	(new StringBuilder()).append(name)
												.append(".pointSlope")
												.append(".name").toString(),
										(new StringBuilder()).append(desc)
												.append(" Point Slope")
												.toString());
		ItemStack baseItem = MaterialsLib.getItemStack(i);
		System.out.println(baseItem);
		if (baseItem != null) {
			ItemStack slopeStack = new ItemStack(
					ConfigurationLib.blockSlopes,
					3,
					(BlockLib.BLOCK_SLOPES_ID << 12) + i);
			// use copy since we are going to change the stack size later
			GameRegistry.addShapedRecipe(slopeStack.copy(), new Object[] {
					"  B",
					" BB",
					"B B",
					Character.valueOf('B'),
					baseItem });
			slopeStack.stackSize = 1;
			ItemStack stack = new ItemStack(
					ConfigurationLib.blockSlopes,
					1,
					(BlockLib.BLOCK_SIDES_ID << 12) + i);
			GameRegistry.addShapelessRecipe(stack, slopeStack);
			GameRegistry.addShapelessRecipe(slopeStack, stack);
			stack = new ItemStack(
					ConfigurationLib.blockSlopes,
					4,
					(BlockLib.BLOCK_HALF_SLOPE_ID << 12) + i);
			GameRegistry.addShapedRecipe(stack, new Object[] {
					" B",
					"B ",
					Character.valueOf('B'),
					slopeStack });
			stack = new ItemStack(
					ConfigurationLib.blockSlopes,
					6,
					(BlockLib.BLOCK_POINT_SLOPE_ID << 12) + i);
			GameRegistry.addShapedRecipe(stack, new Object[] {
					" B ",
					"B B",
					Character.valueOf('B'),
					slopeStack });
			stack = new ItemStack(
					ConfigurationLib.blockSlopes,
					3,
					(BlockLib.BLOCK_OBLICS_ID << 12) + i);
			GameRegistry.addShapedRecipe(stack, new Object[] {
					"  B",
					"BBB",
					"B  ",
					Character.valueOf('B'),
					baseItem });
			stack = new ItemStack(
					ConfigurationLib.blockSlopes,
					6,
					(BlockLib.BLOCK_TRIPOINT_ID << 12) + i);
			GameRegistry.addShapedRecipe(stack, new Object[] {
					" B ",
					" B ",
					"BBB",
					Character.valueOf('B'),
					baseItem });
		}

		// GameRegistry.addShapedRecipe(new
		// ItemStack(ConfigurationLib.blockSlopesID, 3,
		// (BlockLib.BLOCK_SLOPES_ID << 12) + i ), "  B","BBB","B B", 'B',
		// baseItem);

	}

}
