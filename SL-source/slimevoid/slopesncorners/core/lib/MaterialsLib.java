package slimevoid.slopesncorners.core.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class MaterialsLib {

	public static final float selectBoxWidth = 0.25F;
	private static ItemStack materials[] = new ItemStack[256];
	private static String names[] = new String[256];
	private static String descs[] = new String[256];
	private static int hardness[] = new int[256];
	private static ArrayList<IMaterialHandler> materialHandlers = new ArrayList<IMaterialHandler>();
	private static boolean transparency[] = new boolean[256];
	public static Icon materialIcons[][] = new Icon[256][];
	private static float miningHardness[] = new float[256];
	private static HashMap<List<Integer>, Integer> materialIndex = new HashMap<List<Integer>, Integer>();

	public static void initMaterials() {
		addMaterial(0, 1, Block.cobblestone, "cobble", "Cobblestone");
		addMaterial(1, 1, Block.stone, "stone", "Stone");
		addMaterial(2, 0, Block.planks, "planks", "Wooden Plank");
		addMaterial(3, 1, Block.sandStone, "sandstone", "Sandstone");
		addMaterial(4, 1, Block.cobblestoneMossy, "moss", "Moss Stone");
		addMaterial(5, 1, Block.brick, "brick", "Brick");
		addMaterial(6, 2, Block.obsidian, "obsidian", "Obsidian");
		addMaterial(7, 1, true, Block.glass, "glass", "Glass");
		addMaterial(8, 0, Block.dirt, "dirt", "Dirt");
		addMaterial(9, 0, Block.blockClay, "clay", "Clay");
		addMaterial(10, 0, Block.bookShelf, "books", "Bookshelf");
		addMaterial(11, 0, Block.netherrack, "netherrack", "Netherrack");
		addMaterial(12, 0, Block.wood, 0, "wood", "Oak Wood");
		addMaterial(13, 0, Block.wood, 1, "wood1", "Spruce Wood");
		addMaterial(14, 0, Block.wood, 2, "wood2", "Birch Wood");
		addMaterial(15, 0, Block.slowSand, "soul", "Soul Sand");
		addMaterial(16, 1, Block.stoneSingleSlab, "slab", "Polished Stone");
		addMaterial(17, 1, Block.blockIron, "iron", "Iron");
		addMaterial(18, 1, Block.blockGold, "gold", "Gold");
		addMaterial(19, 2, Block.blockDiamond, "diamond", "Diamond");
		addMaterial(20, 1, Block.blockLapis, "lapis", "Lapis Lazuli");
		addMaterial(21, 0, Block.blockSnow, "snow", "Snow");
		addMaterial(22, 0, Block.pumpkin, "pumpkin", "Pumpkin");
		addMaterial(23, 1, Block.stoneBrick, 0, "stonebrick", "Stone Brick");
		addMaterial(24, 1, Block.stoneBrick, 1, "stonebrick1", "Stone Brick");
		addMaterial(25, 1, Block.stoneBrick, 2, "stonebrick2", "Stone Brick");
		addMaterial(26, 1, Block.netherBrick, "netherbrick", "Nether Brick");
		addMaterial(27, 1, Block.stoneBrick, 3, "stonebrick3", "Stone Brick");
		addMaterial(28, 0, Block.planks, 1, "planks1", "Wooden Plank");
		addMaterial(29, 0, Block.planks, 2, "planks2", "Wooden Plank");
		addMaterial(30, 0, Block.planks, 3, "planks3", "Wooden Plank");
		addMaterial(31, 1, Block.sandStone, 1, "sandstone1", "Sandstone");
		addMaterial(64, 1, Block.sandStone, 2, "sandstone2", "Sandstone");
		addMaterial(65, 0, Block.wood, 3, "wood3", "Jungle Wood");
		for (int i = 0; i < 16; i++)
			addMaterial(32 + i, 0, Block.cloth, i, (new StringBuilder())
					.append("wool.").append(ItemDye.dyeColors[i]).toString(),
					(new StringBuilder()).append(ItemDye.dyeColorNames[i])
							.append(" Wool").toString());

	}

	public static interface IMaterialHandler {

		public abstract void addMaterialReference(int i);
	}

	public static void addMaterialHandler(IMaterialHandler handler) {
		for (int i = 0; i < 256; i++) {
			if (materials[i] != null) {
				handler.addMaterialReference(i);
			}
		}

		materialHandlers.add(handler);
	}

	public static Integer getMaterial(ItemStack ist) {
		return (Integer) materialIndex.get(
				Arrays.asList(new Integer[] {
					Integer.valueOf(ist.itemID),
					Integer.valueOf(ist.getItemDamage())
				}));
	}

	public static void addMaterial(int n, int hard, Block bl, String name, String desc) {
		addMaterial(n, hard, false, bl, 0, name, desc);
	}

	public static void addMaterial(int n, int hard, Block bl, int md, String name, String desc) {
		addMaterial(n, hard, false, bl, md, name, desc);
	}

	public static void addMaterial(int n, int hard, boolean tpar, Block bl, String name, String desc) {
		addMaterial(n, hard, tpar, bl, 0, name, desc);
	}

	public static void addMaterial(int materialID, int hard, boolean tpar, Block bl, int md, String name, String desc) {
		ItemStack ist = new ItemStack(bl, 1, md);
		materialIcons[materialID] = new Icon[6];
		for (int i = 0; i < 6; i++) {
			materialIcons[materialID][i] = bl.getIcon(i, md);
		}

		miningHardness[materialID] = bl.getBlockHardness(null, 0, 0, 0);
		materials[materialID] = ist;
		names[materialID] = name;
		descs[materialID] = desc;
		hardness[materialID] = hard;
		transparency[materialID] = tpar;
		materialIndex.put(
				Arrays.asList(
						new Integer[] {
							Integer.valueOf(bl.blockID),
							Integer.valueOf(md)
						}),
					Integer.valueOf(materialID));
		IMaterialHandler imh;
		for (Iterator i$ = materialHandlers.iterator(); i$.hasNext();
			imh.addMaterialReference(materialID)) {
			imh = (IMaterialHandler) i$.next();
		}
	}

	private static int damageToCoverData(int dmg) {
		//	524288,	262144,	131072,	65536
		//	32768,	16384,	8192,	4096
		//	2048,	1024,	512,	256
		//	128, 	64, 	32, 	16
		//	8, 		4, 		2, 		1
		int hd = dmg >> 8; // (Skips the first 8 bits)
		int cn = dmg & 0xff; // 0xff = 255 (Retrieves the first 8 bits)
		switch (hd) {
		case 0: // '\0'
			cn |= 0x10000; //  0001 0000 0000 xxxx xxxx
			break;

		case 16: // '\020'
			cn |= 0x20100; //  0010 0000 0001 xxxx xxxx
			break;

		case 17: // '\021'
			cn |= 0x40200; //  0100 0000 0010 xxxx xxxx
			break;

		case 24: // '\030'
			cn |= 0x110300;
			break;

		case 25: // '\031'
			cn |= 0x120400;
			break;

		case 26: // '\032'
			cn |= 0x140500;
			break;

		case 27: // '\033'
			cn |= 0x30600;
			break;

		case 28: // '\034'
			cn |= 0x50700;
			break;

		case 29: // '\035'
			cn |= 0x60800;
			break;

		case 30: // '\036'
			cn |= 0x70900;
			break;

		case 31: // '\037'
			cn |= 0x130a00;
			break;

		case 32: // ' '
			cn |= 0x150b00;
			break;

		case 33: // '!'
			cn |= 0x160c00;
			break;

		case 34: // '"'
			cn |= 0x170d00;
			break;

		case 18: // '\022'
			cn |= 0x2010000;
			break;

		case 19: // '\023'
			cn |= 0x2020100;
			break;

		case 20: // '\024'
			cn |= 0x2040200;
			break;

		case 35: // '#'
			cn |= 0x2030300;
			break;

		case 36: // '$'
			cn |= 0x2050400;
			break;

		case 37: // '%'
			cn |= 0x2060500;
			break;

		case 38: // '&'
			cn |= 0x2070600;
			break;

		case 21: // '\025'
			cn |= 0x1010000;
			break;

		case 22: // '\026'
			cn |= 0x1020100;
			break;

		case 23: // '\027'
			cn |= 0x1040200;
			break;

		case 39: // '\''
			cn |= 0x1030300;
			break;

		case 40: // '('
			cn |= 0x1050400;
			break;

		case 41: // ')'
			cn |= 0x1060500;
			break;

		case 42: // '*'
			cn |= 0x1070600;
			break;

		case 43: // '+'
			cn |= 0x3020000;
			break;

		case 44: // ','
			cn |= 0x3040100;
			break;

		case 45: // '-'
			cn |= 0x3060200;
			break;
		}
		return cn;
	}
	
	public static Icon getIconForSide(int n, int side) {
		return materialIcons[n][side];
	}

	public static int damageToCoverValue(int dmg) {
		return damageToCoverData(dmg) & 0xffff; // = 65535
	}

	public static ItemStack getItemStack(int n) {
		return materials[n];
	}

    public static Block getBlock(int n)
    {
        ItemStack ist = materials[n];
        return Block.blocksList[ist.itemID];
    }

    public static String getName(int n)
    {
        return names[n];
    }

    public static String getDesc(int n)
    {
        return descs[n];
    }

    public static int getHardness(int n)
    {
        return hardness[n];
    }

    public static float getMiningHardness(int n)
    {
        return miningHardness[n];
    }

    public static boolean isTransparent(int n)
    {
        return transparency[n];
    }



}