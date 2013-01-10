package slimevoid.slopes.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSlopes extends ItemBlock {
	public ItemSlopes(int i, String pItemMatName) {
		super(i);
		itemMatName = pItemMatName;
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return (new StringBuilder()).append("").append(itemMatName)
				.append("Slopes")
				.append(ator_Materials[itemstack.getItemDamage()])
				.toString();
	}

	public static final String ator_Materials[] = { "StairsUp", "StairsUp",
			"StairsUp", "StairsUp", "SlopeDown", "SlopeDown", "SlopeDown",
			"SlopeDown", "SlopeUp", "SlopeUp", "SlopeUp", "SlopeUp",
			"SlopeSide", "SlopeSide", "SlopeSide", "SlopeSide" };

	private String itemMatName;
}
