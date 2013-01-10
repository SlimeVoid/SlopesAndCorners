package slimevoid.corners.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCorners extends ItemBlock {
	public ItemCorners(int i, String pItemMatName) {
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

	public static final String ator_Materials[] = { "QuadriCornerDown",
			"QuadriCornerDown", "QuadriCornerDown", "QuadriCornerDown",
			"QuadriCornerUp", "QuadriCornerUp", "QuadriCornerUp",
			"QuadriCornerUp", "TriCornerDown", "TriCornerDown",
			"TriCornerDown", "TriCornerDown", "TriCornerUp", "TriCornerUp",
			"TriCornerUp", "TriCornerUp" };

	private String itemMatName;
}
