package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.handler.ConfigHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {
    public static void init(){
        if (ConfigHandler.loadSaber) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.woodSaber), " i ", " i ", " s ", 'i', "logWood", 's', "stickWood"));
        }

        if (ConfigHandler.loadCopper) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.copperPick), "iii", " s ", " s ", 'i', "ingotCopper", 's', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.copperSword), " i ", " i ", " s ", 'i', "ingotCopper", 's', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.copperShovel), " i ", " s ", " s ", 'i', "ingotCopper", 's', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.copperAxe), "ii ", "is ", " s ", 'i', "ingotCopper", 's', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.copperAxe), " ii", " si", " s ", 'i', "ingotCopper", 's', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.copperHoe), "ii ", " s ", " s ", 'i', "ingotCopper", 's', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.copperHoe), " ii", " s ", " s ", 'i', "ingotCopper", 's', "stickWood"));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.copperHelmet), "iii", "i i", "   ", 'i', "ingotCopper"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.copperChestplate), "i i", "iii", "iii", 'i', "ingotCopper"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.copperLeggings), "iii", "i i", "i i", 'i', "ingotCopper"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.copperBoots), "   ", "i i", "i i", 'i', "ingotCopper"));
        }

        if (ConfigHandler.loadPlatinum) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.platinumPick), "iii", " s ", " s ", 'i', "ingotPlatinum", 's', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.platinumSword), " i ", " i ", " s ", 'i', "ingotPlatinum", 's', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.platinumShovel), " i ", " s ", " s ", 'i', "ingotPlatinum", 's', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.platinumAxe), "ii ", "is ", " s ", 'i', "ingotPlatinum", 's', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.platinumAxe), " ii", " si", " s ", 'i', "ingotPlatinum", 's', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.platinumHoe), "ii ", " s ", " s ", 'i', "ingotPlatinum", 's', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.platinumHoe), " ii", " s ", " s ", 'i', "ingotPlatinum", 's', "stickWood"));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.platinumHelmet), "iii", "i i", "   ", 'i', "ingotPlatinum"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.platinumChestplate), "i i", "iii", "iii", 'i', "ingotPlatinum"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.platinumLeggings), "iii", "i i", "i i", 'i', "ingotPlatinum"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.platinumBoots), "   ", "i i", "i i", 'i', "ingotPlatinum"));
        }
    }
}
