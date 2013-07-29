package slimevoid.slopesncorners.item.crafting;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.*;
import net.minecraft.world.World;

public class NBTRecipe implements IRecipe {
	/** Is the ItemStack that you get when craft the recipe. */
    private final ItemStack recipeOutput;

    /** Is a List of ItemStack that composes the recipe. */
    public final List recipeItems;
    

    private boolean field_92101_f = false;
    public NBTRecipe(ItemStack par1ItemStack, List par2List)
    {
        this.recipeOutput = par1ItemStack;
        this.recipeItems = par2List;
    }
	@Override
	public boolean matches(InventoryCrafting inventorycrafting, World world) {
		ArrayList arraylist = new ArrayList(this.recipeItems);

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                ItemStack itemstack = inventorycrafting.getStackInRowAndColumn(j, i);

                if (itemstack != null)
                {
                    boolean flag = false;
                    Iterator iterator = arraylist.iterator();

                    while (iterator.hasNext())
                    {
                        ItemStack itemstack1 = (ItemStack)iterator.next();

                        if (itemstack.itemID == itemstack1.itemID && (itemstack1.getItemDamage() == 32767 || itemstack.getItemDamage() == itemstack1.getItemDamage()))
                        {
                            if (itemstack1.getTagCompound() != null){
                            	if (itemstack.getTagCompound() != null && NBTTagsMatch(itemstack1.getTagCompound(),itemstack.getTagCompound())){
                        			flag = true;
                        			arraylist.remove(itemstack1);
                        			break;
                            	}
                            }else{
                            	//vanilla
                            	flag = true;
                    			arraylist.remove(itemstack1);
                    			break;
                            }
                        }
                    }

                    if (!flag)
                    {
                        return false;
                    }
                }
            }
        }

        return arraylist.isEmpty();
	}

	private boolean NBTTagsMatch(NBTTagCompound tagCompound,
			NBTTagCompound tagCompound2) {
		
		
			Iterator iterator = tagCompound.getTags().iterator();
			while (iterator.hasNext())
            {
				NBTBase childCompound = (NBTBase)iterator.next();
				
				if (!(childCompound instanceof NBTTagCompound && tagCompound2.hasKey(childCompound.getName()))){
					if (childCompound instanceof NBTTagByte){
						return (((NBTTagByte)childCompound).data ==((NBTTagByte)(tagCompound2.getTag(childCompound.getName()))).data);
					}else if(childCompound instanceof NBTTagByteArray){
						return (((NBTTagByteArray)childCompound).byteArray.equals(((NBTTagByteArray)(tagCompound2.getTag(childCompound.getName()))).byteArray));
					}else if(childCompound instanceof NBTTagDouble){
						return (((NBTTagDouble)childCompound).data == ((NBTTagDouble)(tagCompound2.getTag(childCompound.getName()))).data);
					}else if(childCompound instanceof NBTTagFloat){
						return (((NBTTagFloat)childCompound).data == ((NBTTagFloat)(tagCompound2.getTag(childCompound.getName()))).data);
					}else if(childCompound instanceof NBTTagInt){
						return (((NBTTagInt)childCompound).data == ((NBTTagInt)(tagCompound2.getTag(childCompound.getName()))).data);
					}else if(childCompound instanceof NBTTagIntArray){
						return (((NBTTagIntArray)childCompound).intArray.equals(((NBTTagIntArray)(tagCompound2.getTag(childCompound.getName()))).intArray));
					}else if(childCompound instanceof NBTTagLong){
						return (((NBTTagLong)childCompound).data ==((NBTTagLong)(tagCompound2.getTag(childCompound.getName()))).data);
					}else if(childCompound instanceof NBTTagShort){
						return (((NBTTagShort)childCompound).data == ((NBTTagShort)(tagCompound2.getTag(childCompound.getName()))).data);
					}else if(childCompound instanceof NBTTagString){
						return (((NBTTagString)childCompound).data.equals(((NBTTagString)(tagCompound2.getTag(childCompound.getName()))).data));
					}else{
						return false;
					}
				}else if (!tagCompound2.hasKey(childCompound.getName())|| !NBTTagsMatch((NBTTagCompound)childCompound,(NBTTagCompound) (tagCompound2).getTag(childCompound.getName()))){
					
					return false;
				}
            }

			return true;
		
			
	}
	
			
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventorycrafting) {
		return this.recipeOutput.copy();
	}

	@Override
	public int getRecipeSize() {
		return this.recipeItems.size();
	}

	@Override
	public ItemStack getRecipeOutput() {
		return this.recipeOutput;
	}

}
