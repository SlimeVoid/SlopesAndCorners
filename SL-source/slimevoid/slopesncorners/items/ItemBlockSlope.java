package slimevoid.slopesncorners.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimevoid.materialslib.api.IPlacementHandler;
import slimevoid.materialslib.lib.MaterialsLib;
import slimevoid.slopesncorners.core.lib.BlockLib;
import slimevoid.slopesncorners.core.lib.ConfigurationLib;

import com.slimevoid.library.items.ItemBlockBase;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemBlockSlope extends ItemBlockBase {

	private IPlacementHandler	placers[];
	private CreativeTabs[]		tabs;

	public ItemBlockSlope(int itemId) {
		super(itemId);
		placers = new IPlacementHandler[BlockLib.MAX_TILES];
		tabs = new CreativeTabs[BlockLib.MAX_TILES];
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
		super.placeBlockAt(	stack,
							player,
							world,
							x,
							y,
							z,
							side,
							hitX,
							hitY,
							hitZ,
							metadata);
		int hb = stack.getItemDamage();
		// int lb = hb & 0xff;
		hb >>= 12;
		if (placers[hb] == null) {
			System.out.println("No Placer Registered!!!");
			return super.placeBlockAt(	stack,
										player,
										world,
										x,
										y,
										z,
										side,
										hitX,
										hitY,
										hitZ,
										metadata);
		} else {
			placers[hb].onPlaceBlock(	stack,
										player,
										world,
										x,
										y,
										z,
										side);
			return placers[hb].placeBlockAt(stack,
											player,
											world,
											x,
											y,
											z,
											side,
											hitX,
											hitY,
											hitZ,
											metadata);
		}
	}

	private boolean itemUseShared(ItemStack ist, EntityPlayer player, World world, int i, int j, int k, int l) {
		int hb = ist.getItemDamage();
		int lb = hb & 0xfff;
		hb >>= 12;
		if (placers[hb] == null) {
			System.out.println("No Placer Registered!!!");
			return false;
		} else {
			return placers[hb].onPlaceBlock(ist,
											player,
											world,
											i,
											j,
											k,
											l);
		}
	}

	private String getSlopeName(int hb) {
		return placers[hb].getUnlocalizedName();
	}

	@Override
	public String getUnlocalizedName(ItemStack ist) {
		int hb = ist.getItemDamage();
		int lb = hb & 0xfff;
		hb >>= 12;
		String stub = getSlopeName(hb);
		String name;
		name = MaterialsLib.getName(lb);
		if (name == null) {
			throw new IndexOutOfBoundsException();
		} else {
			return (new StringBuilder()).append(name).append(".").append(stub).toString();
		}
	}

	private int gethbindex(int hb) {
		switch (hb) {
		case 0: // '\0'
			return 0;

		case 16: // '\020'
			return 1;

		case 17: // '\021'
			return 2;

		case 18: // '\022'
			return 3;

		case 19: // '\023'
			return 4;
		default:
			return -1;
		}
	}

	@Override
	public int getMetadata(int damage) {
		return damage >> 12;
	}

	public void registerPlacement(final int md, IPlacementHandler isp) {
		this.placers[md] = isp;
		this.tabs[md] = new CreativeTabs(isp.getUnlocalizedName()) {
			public ItemStack getIconItemStack() {
				return new ItemStack(ConfigurationLib.blockSlopes, 1, (md * 4096)
																		+ MaterialsLib.brickIndex);
			}
		};
		LanguageRegistry.instance().addStringLocalization(	"itemGroup."
																	+ isp.getUnlocalizedName(),
															"en_US",
															isp.getLocalizedName());

	}

	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < placers.length; i++) {
			if (placers[i] == null || (tab != null && !tabs[i].equals(tab))) continue;
			for (int mi = 0; mi < MaterialsLib.getSize(); mi++) {
				placers[i].addCreativeItems(i * 4096,
											tab,
											list,
											mi);
			}
		}
	}

	@Override
	public CreativeTabs[] getCreativeTabs() {
		return tabs;
	}
}
