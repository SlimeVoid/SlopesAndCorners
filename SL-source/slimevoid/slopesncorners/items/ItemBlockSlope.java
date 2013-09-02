package slimevoid.slopesncorners.items;

import java.util.List;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import slimevoid.slopesncorners.api.ISlope;
import slimevoid.slopesncorners.api.ISlopePlacement;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;
import slimevoid.slopesncorners.core.lib.MaterialsLib;
import slimevoidlib.util.helpers.BlockHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemBlockSlope extends ItemBlock {
	
	private ISlopePlacement placers[];

	public ItemBlockSlope(int itemId) {
		super(itemId);
		placers = new ISlopePlacement[256];
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	private boolean useSlope(ItemStack ist, EntityPlayer player, World world, int i, int j, int k, int l) {
		if (world.canPlaceEntityOnSide(ist.itemID, i, j, k, false, l, player, ist)) {
			world.setBlock(i, j, k, ConfigurationLib.blockSlopes.blockID, 0, 0);
		}
		TileEntity te = world.getBlockTileEntity(i, j, k);
		if (te == null || !(te instanceof ISlope)) {
			return false;
		}
		ISlope icv = (ISlope) te;
		if (icv.tryAddSlope(MaterialsLib.damageToCoverValue(ist.getItemDamage()))) {
			ist.stackSize--;
			BlockHelper.playBlockPlaceNoise(
					world, i, j, k,
					MaterialsLib.getBlock(ist.getItemDamage() & 0xff).blockID);
			BlockHelper.updateIndirectNeighbors(
					world, i, j, k,
					ConfigurationLib.blockSlopes.blockID);
			world.markBlockForUpdate(i, j, k);
			return true;
		} else {
			return false;
		}
    }

	@Override
	public boolean onItemUseFirst(ItemStack ist, EntityPlayer player, World world, int i, int j, int k, int l, float xp, float yp, float zp) {
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT
				&& world.isRemote) {
			return false;
		}
		if (!player.isUsingItem()) {
			return false;
		} else {
			return itemUseShared(ist, player, world, i, j, k, l);
		}
	}

	private boolean itemUseShared(ItemStack ist, EntityPlayer player, World world, int i, int j, int k, int l) {
		int hb = ist.getItemDamage();
		int lb = hb & 0xff;
		hb >>= 8;
		if (hb == 0 || hb >= 16 && hb <= 45) {
			return useSlope(ist, player, world, i, j, k, l);
		}
		if (placers[hb] == null) {
			return false;
		} else {
			return placers[hb].onPlaceSlope(ist, player, world, i, j, k, l);
		}
	}

	private String getSlopeName(int hb) {
		switch (hb) {
		case 0: // '\0'
			return "side";

		case 16: // '\020'
			return "oblic";

		case 17: // '\021'
			return "slant";

		case 18: // '\022'
			return "stairs";

		case 19: // '\023'
			return "slope";
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
				return (new StringBuilder()).append("tile.").append(stub)
						.append(".").append(name).toString();
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

	public void registerPlacement(int md, ISlopePlacement isp) {
		this.placers[md] = isp;
	}

	public void a(int id, CreativeTabs tab, List list) {
		if (tab == ConfigurationLib.slopesTab) {
			for (int i = 0; i < 255; i++) {
				if (placers[i] != null) {
					placers[i].addCreativeItems(i, tab, list);
				}
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
