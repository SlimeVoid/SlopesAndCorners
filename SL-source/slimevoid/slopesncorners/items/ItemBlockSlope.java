package slimevoid.slopesncorners.items;

import java.util.List;

import slimevoid.slopesncorners.api.ISlopePlacement;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockSlope extends ItemBlock {
	
	private ISlopePlacement placers[];

	public ItemBlockSlope(int itemId) {
		super(itemId);
		placers = new ISlopePlacement[1];
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

/*	@Override
	public boolean onItemUseFirst(ItemStack ist, EntityPlayer player, World world, int i, int j, int k, int l, float xp, float yp, float zp) {
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT
				&& world.isRemote) {
			return false;
		}
		return itemUseShared(ist, player, world, i, j, k, l);
	}*/
	
	@Override
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
		super.placeBlockAt(stack, player, world, x, y, z, side, hitX, hitY, hitZ, metadata);
		int hb = stack.getItemDamage();
		//int lb = hb & 0xff;
		hb >>= 8;
		if (placers[hb] == null) {
			System.out.println("No Placer Registered!!!");
			return super.placeBlockAt(stack, player, world, x, y, z, side, hitX, hitY, hitZ, metadata);
		} else {
			return placers[hb].placeSlopeAt(stack, player, world, x, y, z, side, hitX, hitY, hitZ, metadata);
		}
	}
	

	private boolean itemUseShared(ItemStack ist, EntityPlayer player, World world, int i, int j, int k, int l) {
		int hb = ist.getItemDamage();
		int lb = hb & 0xff;
		hb >>= 8;
		if (placers[hb] == null) {
			System.out.println("No Placer Registered!!!");
			return false;
		} else {
			return placers[hb].onPlaceSlope(ist, player, world, i, j, k, l);
		}
	}

	private String getSlopeName(int hb) {
		switch (hb) {
		case 0: // '\0'
			return "slope";

		case 16: // '\020'
			return "oblic";

		case 17: // '\021'
			return "slant";

		case 18: // '\022'
			return "stairs";

		case 19: // '\023'
			return "side";
		default:
			return null;
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack ist) {
		int hb = ist.getItemDamage();
		int lb = hb & 0xff;
		hb >>= 8;
		String stub = getSlopeName(hb);
		String name;
		if (stub != null) {
			name = MaterialsLib.getName(lb);
			if (name == null) {
				throw new IndexOutOfBoundsException();
			} else {
				return (new StringBuilder()).append(name).append(".").append(stub)
						.toString();
			}
		}
		if (placers[hb] == null) {
			throw new IndexOutOfBoundsException();
		}
		name = placers[hb].getSlopeName(hb, lb);
		if (name == null) {
			throw new IndexOutOfBoundsException();
		} else {
			return name;
		}
	}
	
	@Override
    public int getMetadata(int damage)
    {
        return damage >> 8;
    }

	public void registerPlacement(int md, ISlopePlacement isp) {
		this.placers[md] = isp;
	}

	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		if (tab == ConfigurationLib.slopesTab) {
			int placerindex = 0;
			for(ISlopePlacement placer:placers){
				if (placer == null) continue;				
				for (int i = 0; i < MaterialsLib.getSize(); i++) {						
						placer.addCreativeItems(placerindex, tab, list, i);
					}
				placerindex++;
			}
		}
		/*else if (tab == tabs) {
			for (int i = 0; i < 255; i++) {
				String stub = SlopesLib.getName(i);
				if (stub != null)
					list.add(new ur(block, 1, i));
			}

			for (int i = 1; i < 255; i++) {
				String stub = getSlopeName(i);
				if (stub != null)
					list.add(new ur(block, 1, i << 8));
			}

			for (int i = 1; i < 255; i++) {
				String stub = getSlopeName(i);
				if (stub != null)
					list.add(new ur(block, 1, i << 8 | 2));
			}

			for (int i = 1; i < 255; i++) {
				String stub = getSlopeName(i);
				if (stub != null)
					list.add(new ur(block, 1, i << 8 | 0x17));
			}

			for (int i = 1; i < 255; i++) {
				String stub = getSlopeName(i);
				if (stub != null)
					list.add(new ur(block, 1, i << 8 | 0x1a));
			}
		}*/
	}

	@Override
	public CreativeTabs[] getCreativeTabs() {
		return new CreativeTabs[] {ConfigurationLib.slopesTab};
	}
}
