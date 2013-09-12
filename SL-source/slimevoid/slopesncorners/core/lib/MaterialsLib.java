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

	public static final int minimumlength = 50;
	private static ItemStack materials[] = new ItemStack[0];
	private static String names[] = new String[0];
	private static String descs[] = new String[0];
	private static int hardness[] = new int[0];
	private static ArrayList<IMaterialHandler> materialHandlers = new ArrayList<IMaterialHandler>();
	private static HashMap<List<Integer>, Integer> materialIndex = new HashMap<List<Integer>, Integer>();
	public static int brickIndex = 5;

	public static int getSize() {
		return materials.length;
	}

	public static void initMaterials(int newLength) {
		if (newLength < minimumlength) {
			newLength = minimumlength;
		}
		hardness = new int[newLength];
		descs = new String[newLength];
		names = new String[newLength];
		materials = new ItemStack[newLength];
		addMaterial(0, 1, Block.cobblestone, "Cobblestone");
		addMaterial(1, 1, Block.stone, "Stone");
		addMaterial(2, 0, Block.planks, "Oak Plank");
		addMaterial(3, 1, Block.sandStone, "Sandstone");
		addMaterial(4, 1, Block.cobblestoneMossy, "Moss Stone");
		addMaterial(5, 1, Block.brick, "Brick");
		addMaterial(6, 2, Block.obsidian, "Obsidian");
		addMaterial(7, 1, Block.glass, "Glass");
		addMaterial(8, 0, Block.dirt, "Dirt");
		addMaterial(9, 0, Block.blockClay, "Clay");
		addMaterial(10, 0, Block.bookShelf, "Bookshelf");
		addMaterial(11, 0, Block.netherrack, "Netherrack");
		addMaterial(12, 0, Block.wood, 0, "Oak Wood");
		addMaterial(13, 0, Block.wood, 1, "Spruce Wood");
		addMaterial(14, 0, Block.wood, 2, "Birch Wood");
		addMaterial(15, 0, Block.slowSand, "Soul Sand");
		addMaterial(16, 1, Block.stoneSingleSlab, "Polished Stone");
		addMaterial(17, 1, Block.blockIron, "Iron");
		addMaterial(18, 1, Block.blockGold, "Gold");
		addMaterial(19, 2, Block.blockDiamond, "Diamond");
		addMaterial(20, 1, Block.blockLapis, "Lapis Lazuli");
		addMaterial(21, 0, Block.blockSnow, "Snow");
		addMaterial(22, 0, Block.pumpkin, "Pumpkin");
		addMaterial(23, 1, Block.stoneBrick, 0, "stonebrick", "Stone Brick");
		addMaterial(24, 1, Block.stoneBrick, 1, "stonebrick1", "Mossy Stone Brick");
		addMaterial(25, 1, Block.stoneBrick, 2, "stonebrick2", "Cracked Stone Brick");
		addMaterial(26, 1, Block.netherBrick, "Nether Brick");
		addMaterial(27, 1, Block.stoneBrick, 3, "Chisled Stone Brick");
		addMaterial(28, 0, Block.planks, 1, "Spruce Plank");
		addMaterial(29, 0, Block.planks, 2, "Birch Plank");
		addMaterial(30, 0, Block.planks, 3, "Jungle Plank");
		addMaterial(31, 1, Block.sandStone, 1, "Chisled Sandstone");
		for (int i = 0; i < 16; i++) {
			addMaterial(32 + i, 0, Block.cloth, i, (new StringBuilder())
					.append("wool.").append(ItemDye.dyeColors[15-i]).toString(),
					(new StringBuilder()).append(ItemDye.dyeColorNames[15-i])
							.append(" Wool").toString());
		}
		addMaterial(48, 1, Block.sandStone, 2, "sandstone2", "Smooth Sandstone");
		addMaterial(49, 0, Block.wood, 3, "wood3", "Jungle Wood");

	}

	public static interface IMaterialHandler {

		public abstract void addMaterialReference(int i);
	}

	public static void addMaterialHandler(IMaterialHandler handler) {
		for (int i = 0; i < materials.length; i++) {
			if (materials[i] != null) {
				handler.addMaterialReference(i);
			}
		}

		materialHandlers.add(handler);
	}

	public static Integer getMaterial(ItemStack ist) {
		return (Integer) materialIndex.get(Arrays.asList(new Integer[] {
				Integer.valueOf(ist.itemID),
				Integer.valueOf(ist.getItemDamage()) }));
	}

	private static void addMaterial(int n, int hard, Block bl, String desc) {
		addMaterial(n, hard, bl, bl.getUnlocalizedName(), desc);
	}

	static void addMaterial(int n, int hard, Block bl, int md, String desc) {
		addMaterial(n, hard, bl, md, bl.getUnlocalizedName(), desc);
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
		// System.out.println("Name: " + name);
		if (name.endsWith(".name")) {
			name = name.substring(0, name.length() - 6);
		}
		if (md > 0) {
			// add damage to name for better localization
			name += "." + md;
		}
		materials[materialID] = ist;
		names[materialID] = name;
		descs[materialID] = desc;
		hardness[materialID] = hard;
		materialIndex.put(
				Arrays.asList(new Integer[] { Integer.valueOf(bl.blockID),
						Integer.valueOf(md) }), Integer.valueOf(materialID));
		IMaterialHandler imh;
		for (Iterator i$ = materialHandlers.iterator(); i$.hasNext(); imh
				.addMaterialReference(materialID)) {
			imh = (IMaterialHandler) i$.next();
		}
	}

	private static int damageToCoverData(int dmg) {
		// 524288, 262144, 131072, 65536
		// 32768, 16384, 8192, 4096
		// 2048, 1024, 512, 256
		// 128, 64, 32, 16
		// 8, 4, 2, 1
		int hd = dmg >> 12; // (Skips the first 8 bits)
		// System.out.println("Damage to hd: " + hd);
		int cn = dmg & 0xfff; // 0xfff = 4095 (Retrieves the first 12 bits)
		// System.out.println("Damage to cn: " + cn);
		switch (hd) {
		case 0: // '\0'
			cn |= 0x10000; // 0001 0000 0000 xxxx xxxx
			break;

		case 16: // '\020'
			cn |= 0x20100; // 0010 0000 0001 xxxx xxxx
			break;

		case 17: // '\021'
			cn |= 0x40200; // 0100 0000 0010 xxxx xxxx
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
		n = n % materials.length;		
		ItemStack ist = getItemStack(n);
		if (ist ==null){
			return Block.stone.getIcon(side,0);
		}
		return Block.blocksList[ist.itemID].getIcon(side, ist.getItemDamage());		
		
	}

	public static int damageToMaterialValue(int dmg) {
		return damageToCoverData(dmg) & 0xffff; // = 65535
	}

	public static ItemStack getItemStack(int n) {
		n = n % materials.length;	
			return materials[n];		
	}

	public static Block getBlock(int n) {
		n = n % materials.length;	
			ItemStack ist = materials[n];
			return Block.blocksList[ist.itemID];		
	}

	public static int getBlockDmg(int n) {
		n = n % materials.length;	
			ItemStack ist = materials[n];
			return ist.getItemDamage();		
	}

	public static String getName(int n) {
		n = n % materials.length;	
			return names[n];		
	}

	public static String getDesc(int n) {
		n = n % materials.length;	
			return descs[n];		
	}

	public static int getHardness(int n) {
		n = n % materials.length;	
			return hardness[n];		
	}


}
