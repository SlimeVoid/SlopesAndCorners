package slimevoid.interiorcorners.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemInteriorCorners extends ItemBlock {
	public ItemInteriorCorners(int i, String pItemMatName) {
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

	public static final String ator_Materials[] = { "TruncCornerDown",
			"TruncCornerDown", "TruncCornerDown", "TruncCornerDown",
			"TruncCornerUp", "TruncCornerUp", "TruncCornerUp", "TruncCornerUp",
			"InvCornerDown", "InvCornerDown", "InvCornerDown", "InvCornerDown",
			"InvCornerUp", "InvCornerUp", "InvCornerUp", "InvCornerUp" };

	private String itemMatName;
}
