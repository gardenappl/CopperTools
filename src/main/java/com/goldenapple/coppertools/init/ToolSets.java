package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.item.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ToolSets
{
    public static void RegisterOreToolSet(Item.ToolMaterial mat, ItemArmor.ArmorMaterial matArmor, String matName, String ingot, boolean useObsidian){
        Item pickaxe = new CopperToolsPickaxe(mat, matName + "_pickaxe", ingot).setUseObsidian(useObsidian);
        GameRegistry.registerItem(pickaxe, matName + "_pickaxe");
        if(useObsidian) {
            GameRegistry.addRecipe(new ShapedOreRecipe(pickaxe, "iii", " s ", " s ", 'i', ingot, 's', "rodObsidian"));
        }else{
            GameRegistry.addRecipe(new ShapedOreRecipe(pickaxe, "iii", " s ", " s ", 'i', ingot, 's', "stickWood"));
        }

        Item sword = new CopperToolsSword(mat, matName + "_sword", ingot).setUseObsidian(useObsidian);
        GameRegistry.registerItem(sword, matName + "_sword");
        if(useObsidian) {
            GameRegistry.addRecipe(new ShapedOreRecipe(sword, " i ", " i ", " s ", 'i', ingot, 's', "rodObsidian"));
        }else{
            GameRegistry.addRecipe(new ShapedOreRecipe(sword, " i ", " i ", " s ", 'i', ingot, 's', "stickWood"));
        }

        Item shovel = new CopperToolsSpade(mat, matName + "_shovel", ingot).setUseObsidian(useObsidian);
        GameRegistry.registerItem(shovel, matName + "_shovel");
        if(useObsidian) {
            GameRegistry.addRecipe(new ShapedOreRecipe(shovel, " i ", " s ", " s ", 'i', ingot, 's', "rodObsidian"));
        }else{
            GameRegistry.addRecipe(new ShapedOreRecipe(shovel, " i ", " s ", " s ", 'i', ingot, 's', "stickWood"));
        }

        Item axe = new CopperToolsAxe(mat, matName + "_axe", ingot).setUseObsidian(useObsidian);
        GameRegistry.registerItem(axe, matName + "_axe");
        if(useObsidian) {
            GameRegistry.addRecipe(new ShapedOreRecipe(axe, " i ", "is ", " s ", 'i', ingot, 's', "rodObsidian"));
            GameRegistry.addRecipe(new ShapedOreRecipe(axe, " ii", " si", " s ", 'i', ingot, 's', "rodObsidian"));
        }else{
            GameRegistry.addRecipe(new ShapedOreRecipe(axe, " i ", "is ", " s ", 'i', ingot, 's', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(axe, " ii", " si", " s ", 'i', ingot, 's', "stickWood"));
        }

        Item hoe = new CopperToolsHoe(mat, matName + "_hoe", ingot).setUseObsidian(useObsidian);
        GameRegistry.registerItem(hoe, matName + "_hoe");
        if(useObsidian) {
            GameRegistry.addRecipe(new ShapedOreRecipe(hoe, " ii", " s ", " s ", 'i', ingot, 's', "rodObsidian"));
            GameRegistry.addRecipe(new ShapedOreRecipe(hoe, "ii ", " s ", " s ", 'i', ingot, 's', "rodObsidian"));
        }else{
            GameRegistry.addRecipe(new ShapedOreRecipe(hoe, " ii", " s ", " s ", 'i', ingot, 's', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(hoe, "ii ", " s ", " s ", 'i', ingot, 's', "stickWood"));
        }

        Item helmet = new CopperToolsArmor(matArmor, matName + "_helmet", ingot, 0);
        GameRegistry.registerItem(helmet, matName + "_helmet");
        GameRegistry.addRecipe(new ShapedOreRecipe(helmet, "iii", "i i", "   ", 'i', ingot));

        Item chestplate = new CopperToolsArmor(matArmor, matName + "_chestplate", ingot, 1);
        GameRegistry.registerItem(chestplate, matName + "_chestplate");
        GameRegistry.addRecipe(new ShapedOreRecipe(chestplate, "i i", "iii", "iii", 'i', ingot));

        Item leggings = new CopperToolsArmor(matArmor, matName + "_leggings", ingot, 2);
        GameRegistry.registerItem(leggings, matName + "_leggings");
        GameRegistry.addRecipe(new ShapedOreRecipe(leggings, "iii", "i i", "i i", 'i', ingot));

        Item boots = new CopperToolsArmor(matArmor, matName + "_boots", ingot, 3);
        GameRegistry.registerItem(boots, matName + "_boots");
        GameRegistry.addRecipe(new ShapedOreRecipe(boots, "   ", "i i", "i i", 'i', ingot));
    }
}
