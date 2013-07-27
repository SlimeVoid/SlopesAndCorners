package slimevoid.slopesncorners.core.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.Configuration;
import slimevoid.slopesncorners.blocks.BlockTriPointCorner;
import slimevoid.slopesncorners.blocks.BlockOblicSlopes;
import slimevoid.slopesncorners.blocks.BlockSideSlopes;
import slimevoid.slopesncorners.blocks.BlockSlopesNCorners;
import slimevoid.slopesncorners.blocks.BlockStairsPublic;
import slimevoid.slopesncorners.client.render.BlockOblicSlopesRenderRenderer;
import slimevoid.slopesncorners.client.render.BlockSideSlopeRenderer;
import slimevoid.slopesncorners.client.render.BlockSlopesNCornersRenderer;
import slimevoid.slopesncorners.client.render.BlockTriCornersRenderer;
import slimevoid.slopesncorners.core.SlopeNCorners;
import slimevoid.slopesncorners.item.crafting.NBTRecipe;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

public class SlopesNCornersConfig
{
	private static int SlopesCurrentBlockID;
	public static int SlopesNCornersOpacity;
	
	public static int	SideSlopesRenderID;
	public static int	TriCornersRenderID;
	public static int	OblicSlopesRenderID;
	public static int SlopesNCornersRenderID;
	public static CreativeTabs tabCustom;
	
	public static List<Block> BlockStairs = new ArrayList<Block>();	
	public static List<Block> BlockSlopesNCorners= new ArrayList<Block>();	
	public static List<Block> BlockSideSlopes= new ArrayList<Block>();		
	public static List<Block> BlockTriCorners= new ArrayList<Block>();	
	public static List<Block> BlockOblicCorners= new ArrayList<Block>();	
	
	public static void configuration(Configuration config) {
		SlopesNCornersRenderID = RenderingRegistry.getNextAvailableRenderId();
		SideSlopesRenderID =  RenderingRegistry.getNextAvailableRenderId();
		TriCornersRenderID =RenderingRegistry.getNextAvailableRenderId();
		OblicSlopesRenderID =RenderingRegistry.getNextAvailableRenderId();
		
		
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT){
			SlopeNCorners.registerRenderInformation(SlopesNCornersRenderID, new BlockSlopesNCornersRenderer());
			SlopeNCorners.registerRenderInformation(SideSlopesRenderID, new BlockSideSlopeRenderer());
			SlopeNCorners.registerRenderInformation(OblicSlopesRenderID, new BlockOblicSlopesRenderRenderer());
			SlopeNCorners.registerRenderInformation(TriCornersRenderID, new BlockTriCornersRenderer());
		}
		
		tabCustom = new CreativeTabs("tabCustom") {
            public ItemStack getIconItemStack() {
                    return new ItemStack(BlockSlopesNCorners.get(0), 1);
            }
            
    };
    LanguageRegistry.instance().addStringLocalization("itemGroup.tabCustom", "en_US", "Slopes N' Corners");
    SlopesNCornersOpacity = config.get(Configuration.CATEGORY_GENERAL, "Slopes_Opacity",0, "The Opacity of none Stair Blocks effects lighting 0 = clear 255 = solid").getInt();
    SlopesCurrentBlockID = config.get(Configuration.CATEGORY_GENERAL, "SlopesStartBlockID",2000, "The Blocks will be generated starting at this block ID. Will skip over any used block slots so don't " +
    																							 "\nneed a massive chunk of free IDs as long as there is enough empty spaces for all the blocks defined").getInt();
    String[] baseBlockIdsNDmgs  = config.get(Configuration.CATEGORY_GENERAL, "BaseBlockList",new String[]{"1-Stone","2-Grass","3-Dirt","4-Cobblestone","5-OakPlank","5_1-SprucePlank","5_2-BirchPlank","5_3-JunglePlank","12-Sand","13-Gravel","17-OakWood","17_1-SpruceWood","17_2-BirchWood","17_3-JungleWood"
    		,"20-Glass","22-LapisLazuli","24-Sandstone","24_1-ChisledSandstone","24_2-SmoothSandstone","35-Wool","35_1-OrangeWool","35_2-MagentaWool","35_3-LightBlueWool","35_4-YellowWool","35_5-LimeWool","35_6-PinkWool","35_7-GrayWool","35_8-LightGrayWool","35_9-CyanWool","35_10-PurpleWool"
    		,"35_11-BlueWool","35_12-BrownWool","35_13-GreenWool","35_14-RedWool","35_15-BlackWool","41-Gold","42-Iron","45-Brick","48-MossStone","49-Obsidian","57-Diamond","79-Ice","80-Snow","98-StoneBrick","98_1-MossyStone","112-NetherBrick","133-Emerald","155-Quartz","155_1-ChisledQuartz","155_2-PillarQuartz_Pillar Quartz"},
    		"Data to generate custom Blocks with the format BaseBlockID<_DMG>-unfriendly Prefix<_Friendly Prefix>. " +
    		"\nexample 35_14-RedWool_Red Wool will create a stair, slope, slanted corner, and oblic slope blocks" +
    		"\nwith the texture based on the blockid 35 with damage 14, display names will use the prefix given " +
    		"\nif no Friendly version is given then the unfriendly Prefix will be used with spaces added in front" +
    		"\nof each capital. DMG and Friendly names are optional").getStringList();
    String[] baseBlocksWithStairs  = config.get(Configuration.CATEGORY_GENERAL, "baseBlocksWithStairsList",new String[]{"4-67","5-53","5_1-134","5_2-135","5_3-136","24-128","98-109","112-114","155-156"},
    		"Blocks that already have a stair defined for them either by other Mods or Vannila " +
    		"\nexample 5:2;135:0 tells us that the Blockid 5 with damage 2 already has a stair block at blockid 135 damage 0" +
    		"\nNote DMG is optional if dmg is 0").getStringList();

    	initializeSlopesNCorners(baseBlockIdsNDmgs,initializeStairs(baseBlockIdsNDmgs,baseBlocksWithStairs));
		initializeSideSlopes(baseBlockIdsNDmgs);
		initializeTriCorners(baseBlockIdsNDmgs);
		initializeOblicSlopes(baseBlockIdsNDmgs);
			config.save();
			//Proof of concept recipe
			/*ItemStack NBTItem = new ItemStack(Item.axeDiamond);
			NBTItem.setTagCompound(new NBTTagCompound());
			NBTItem.getTagCompound().setCompoundTag("display", new NBTTagCompound());
			NBTItem.getTagCompound().getCompoundTag("display").setString("Name", "Test");
			addNBTShapelessRecipe(new ItemStack(Block.dirt),NBTItem);*/
	}
	
	private static String[] initializeStairs(String[] baseBlockIdsNDmgs, String[] baseBlocksWithStairs){
		String[] result = new String[baseBlockIdsNDmgs.length];
		String[] excludedIdsNDmgs = new String[baseBlocksWithStairs.length];
		int index = 0;
		for (String i : baseBlocksWithStairs) { 
			excludedIdsNDmgs[index] = i.split("-")[0];
		    index++;
		}
		index =0;
		for(String info: baseBlockIdsNDmgs){
			
				String blockIdNDmg = info.split("-")[0];
				while (Block.blocksList[SlopesCurrentBlockID] != null){
					SlopesCurrentBlockID++;
				}
			if (!Arrays.asList(excludedIdsNDmgs).contains(blockIdNDmg)){
				String blockBaseName = info.split("-")[1];
				BlockStairs.add(new BlockStairsPublic(SlopesCurrentBlockID,Block.blocksList[Integer.parseInt(blockIdNDmg.split("_")[0])],blockIdNDmg.split("_").length == 1?0:Integer.parseInt(blockIdNDmg.split("_")[1]))
				.setUnlocalizedName(String.format("Block%sStairs",blockBaseName.split("_")[0])));
				GameRegistry.registerBlock(BlockStairs.get(BlockStairs.size()-1),String.format("Block%sStairs",blockBaseName.split("_")[0]));
				LanguageRegistry.addName(BlockStairs.get(BlockStairs.size()-1), String.format("%s Stairs",blockBaseName.split("_").length==1?blockBaseName.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2"):blockBaseName.split("_")[1]));
				GameRegistry.addShapedRecipe(new ItemStack(BlockStairs.get(BlockStairs.size()-1),4), new Object[]{"A  ","AA ","AAA",'A',new ItemStack(Block.blocksList[Integer.parseInt(blockIdNDmg.split("_")[0])],1,blockIdNDmg.split("_").length == 1?0:Integer.parseInt(blockIdNDmg.split("_")[1]))});
				result[index] = String.valueOf(BlockStairs.get(BlockStairs.size()-1).blockID);
				
				SlopesCurrentBlockID++;
			}else{
				result[index] = baseBlocksWithStairs[Arrays.asList(excludedIdsNDmgs).indexOf(blockIdNDmg)].substring(baseBlocksWithStairs[Arrays.asList(excludedIdsNDmgs).indexOf(blockIdNDmg)].indexOf('-')+1);
			}
			index++;
		}
		return result;
	}
	
	private static void initializeSlopesNCorners(String[] baseBlockIdsNDmgs, String[] StairBlockIdsNDmgs) {
		for(String info: baseBlockIdsNDmgs){
			String blockIdNDmg = info.split("-")[0];
			String blockBaseName = info.split("-")[1];
			while (Block.blocksList[SlopesCurrentBlockID] != null){
				SlopesCurrentBlockID++;
			}
			BlockSlopesNCorners.add(new BlockSlopesNCorners(SlopesCurrentBlockID,Block.blocksList[Integer.parseInt(blockIdNDmg.split("_")[0])],blockIdNDmg.split("_").length == 1?0:Integer.parseInt(blockIdNDmg.split("_")[1]))
				.setUnlocalizedName(String.format("Block%sSlope",blockBaseName.split("_")[0])));
				GameRegistry.registerBlock(BlockSlopesNCorners.get(BlockSlopesNCorners.size()-1),String.format("Block%sSlope",blockBaseName.split("_")[0]));
				LanguageRegistry.addName(BlockSlopesNCorners.get(BlockSlopesNCorners.size()-1), String.format("%s Slope",blockBaseName.split("_").length==1?blockBaseName.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2"):blockBaseName.split("_")[1]));
				
				String removedNBTTagData = StairBlockIdsNDmgs[BlockSlopesNCorners.size()-1].split("-")[0];
				ItemStack itemStairBlock = new ItemStack(Block.blocksList[Integer.parseInt(removedNBTTagData.split("_")[0])],1,removedNBTTagData.split("_").length == 1?0:Integer.parseInt(removedNBTTagData.split("_")[1]));
				if (StairBlockIdsNDmgs[BlockSlopesNCorners.size()-1].split("-").length > 1){
					for(String NBTDef:StairBlockIdsNDmgs[BlockSlopesNCorners.size()-1].split("-")){
						if (!NBTDef.equals(removedNBTTagData)){
							if (itemStairBlock.getTagCompound() == null){
								itemStairBlock.setTagCompound(new NBTTagCompound());
							}
							String fullTagName = NBTDef.split("_")[0];
							String tagType = NBTDef.split("_")[1].toLowerCase();
							String tagValue = NBTDef.split("_")[2];
							NBTTagCompound currentTag = itemStairBlock.getTagCompound();
							for (String tagName:fullTagName.split("/.")){
								if (fullTagName.split("/.")[fullTagName.split("/.").length-1].equals(tagName)){
									setNBTTag(currentTag,tagType,tagName,tagValue);
								}else{
									currentTag.setCompoundTag(tagName, new NBTTagCompound());
									currentTag = currentTag.getCompoundTag(tagName);
									
								}
							}
						}
					}
				}
				addNBTShapelessRecipe(new ItemStack(BlockSlopesNCorners.get(BlockSlopesNCorners.size()-1)), itemStairBlock);
				
				SlopesCurrentBlockID++;
			
		}
		
	}	
	private static void setNBTTag(NBTTagCompound tagCompound ,String tagType,String tagName,String tagValue){
		
		if (tagType.equals("short")){
			tagCompound.setShort(tagName, Short.parseShort(tagValue));
		}else if(tagType.equals("boolean")){
			tagCompound.setBoolean(tagName, Boolean.parseBoolean(tagValue));
		}else if(tagType.equals("double")){
			tagCompound.setDouble(tagName, Double.parseDouble(tagValue));
		}else if(tagType.equals("float")){
			tagCompound.setFloat(tagName, Float.parseFloat(tagValue));
		}else if(tagType.equals("integer")){
			tagCompound.setInteger(tagName, Integer.parseInt(tagValue));
		}else if(tagType.equals("long")){
			tagCompound.setLong(tagName, Long.parseLong(tagValue));
		}else if(tagType.equals("string")){
			tagCompound.setString(tagName, tagValue);
		}
	}
	private static void initializeSideSlopes(String[] baseBlockIdsNDmgs)
	{
		for(String info: baseBlockIdsNDmgs){
			String blockIdNDmg = info.split("-")[0];
			String blockBaseName = info.split("-")[1];
			while (Block.blocksList[SlopesCurrentBlockID] != null){
				SlopesCurrentBlockID++;
			}
			BlockSideSlopes.add(new BlockSideSlopes(SlopesCurrentBlockID,Block.blocksList[Integer.parseInt(blockIdNDmg.split("_")[0])],blockIdNDmg.split("_").length == 1?0:Integer.parseInt(blockIdNDmg.split("_")[1]))
				.setUnlocalizedName(String.format("Block%sSideSlope",blockBaseName.split("_")[0])));
				GameRegistry.registerBlock(BlockSideSlopes.get(BlockSideSlopes.size()-1),String.format("Block%sSideSlope",blockBaseName.split("_")[0]));
				LanguageRegistry.addName(BlockSideSlopes.get(BlockSideSlopes.size()-1), String.format("%s Side Slope",blockBaseName.split("_").length==1?blockBaseName.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2"):blockBaseName.split("_")[1]));
				
				GameRegistry.addShapelessRecipe(new ItemStack(BlockSlopesNCorners.get(BlockSideSlopes.size()-1)), BlockSideSlopes.get(BlockSideSlopes.size()-1));
				GameRegistry.addShapelessRecipe(new ItemStack(BlockSideSlopes.get(BlockSideSlopes.size()-1)), new ItemStack(BlockSlopesNCorners.get(BlockSideSlopes.size()-1)));
				SlopesCurrentBlockID++;
			
		}
	
}

	private static void initializeTriCorners(String[] baseBlockIdsNDmgs)
	{
		for(String info: baseBlockIdsNDmgs){
			String blockIdNDmg = info.split("-")[0];
			String blockBaseName = info.split("-")[1];
			while (Block.blocksList[SlopesCurrentBlockID] != null){
				SlopesCurrentBlockID++;
			}
			BlockTriCorners.add(new BlockTriPointCorner(SlopesCurrentBlockID,Block.blocksList[Integer.parseInt(blockIdNDmg.split("_")[0])],blockIdNDmg.split("_").length == 1?0:Integer.parseInt(blockIdNDmg.split("_")[1]))
				.setUnlocalizedName(String.format("Block%sSlantedCorner",blockBaseName.split("_")[0])));
				GameRegistry.registerBlock(BlockTriCorners.get(BlockTriCorners.size()-1),String.format("Block%sSlantedCorner",blockBaseName.split("_")[0]));
				LanguageRegistry.addName(BlockTriCorners.get(BlockTriCorners.size()-1), String.format("%s Slanted Corner",blockBaseName.split("_").length==1?blockBaseName.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2"):blockBaseName.split("_")[1]));
				
				GameRegistry.addShapedRecipe(new ItemStack(BlockTriCorners.get(BlockTriCorners.size()-1),8), new Object[]{" A "," A ","AAA",'A',new ItemStack(Block.blocksList[Integer.parseInt(blockIdNDmg.split("_")[0])],1,blockIdNDmg.split("_").length == 1?0:Integer.parseInt(blockIdNDmg.split("_")[1]))});
				SlopesCurrentBlockID++;
			
		}
	}

	private static void initializeOblicSlopes(String[] baseBlockIdsNDmgs)
	{
		for(String info: baseBlockIdsNDmgs){
			String blockIdNDmg = info.split("-")[0];
			String blockBaseName = info.split("-")[1];
			while (Block.blocksList[SlopesCurrentBlockID] != null){
				SlopesCurrentBlockID++;
			}
			BlockOblicCorners.add(new BlockOblicSlopes(SlopesCurrentBlockID,Block.blocksList[Integer.parseInt(blockIdNDmg.split("_")[0])],blockIdNDmg.split("_").length == 1?0:Integer.parseInt(blockIdNDmg.split("_")[1]))
				.setUnlocalizedName(String.format("Block%sOblicSlope",blockBaseName.split("_")[0])));
				GameRegistry.registerBlock(BlockOblicCorners.get(BlockOblicCorners.size()-1),String.format("Block%sOblicSlope",blockBaseName.split("_")[0]));
				LanguageRegistry.addName(BlockOblicCorners.get(BlockOblicCorners.size()-1), String.format("%s Oblic Slope",blockBaseName.split("_").length==1?blockBaseName.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2"):blockBaseName.split("_")[1]));
				
				GameRegistry.addShapedRecipe(new ItemStack(BlockOblicCorners.get(BlockOblicCorners.size()-1),4), new Object[]{"  A","AAA",'A',new ItemStack(Block.blocksList[Integer.parseInt(blockIdNDmg.split("_")[0])],1,blockIdNDmg.split("_").length == 1?0:Integer.parseInt(blockIdNDmg.split("_")[1]))});
				SlopesCurrentBlockID++;
			
		}
		
	}
	
	public static void addNBTShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }
        CraftingManager.getInstance().getRecipeList().add(new NBTRecipe(par1ItemStack, arraylist));
    }
}
