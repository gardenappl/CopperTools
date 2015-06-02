package com.goldenapple.coppertools.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.List;

public class MiscHelper {

    @SuppressWarnings("unchecked") //Stolen from Mantle :D    https://github.com/SlimeKnights/Mantle/blob/master/src/mantle/utils/RecipeRemover.java
    public static void deleteRecipes(Item item){
        if(item == null) return;

        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

        for (int i = 0; i < recipes.size(); i++){
            IRecipe tmpRecipe = recipes.get(i);
            ItemStack recipeResult = tmpRecipe.getRecipeOutput();
            if (recipeResult != null && recipeResult.getItem() == item){
                recipes.remove(i);
                LogHelper.info("Removing recipe for " + recipeResult.getUnlocalizedName());
            }
        }
    }
}
