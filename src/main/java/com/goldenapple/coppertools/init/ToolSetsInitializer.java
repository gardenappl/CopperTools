package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.item.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ToolSetsInitializer
{
    public static void RegisterOreToolSet(Item.ToolMaterial mat, ItemArmor.ArmorMaterial matArmor, String matName, String material, boolean useObsidian){
        Item pickaxe = new CopperToolsPickaxe(mat, matName + "_pickaxe", material).setUseObsidian(useObsidian);
        GameRegistry.registerItem(pickaxe, matName + "_pickaxe");

        Item sword = new CopperToolsSword(mat, matName + "_sword", material).setUseObsidian(useObsidian);
        GameRegistry.registerItem(sword, matName + "_sword");

        Item shovel = new CopperToolsSpade(mat, matName + "_shovel", material).setUseObsidian(useObsidian);
        GameRegistry.registerItem(shovel, matName + "_shovel");

        Item axe = new CopperToolsAxe(mat, matName + "_axe", material).setUseObsidian(useObsidian);
        GameRegistry.registerItem(axe, matName + "_axe");

        Item hoe = new CopperToolsHoe(mat, matName + "_hoe", material).setUseObsidian(useObsidian);
        GameRegistry.registerItem(hoe, matName + "_hoe");

        Item helmet = new CopperToolsArmor(matArmor, matName + "_helmet", material, 0);
        GameRegistry.registerItem(helmet, matName + "_helmet");

        Item chestplate = new CopperToolsArmor(matArmor, matName + "_chestplate", material, 1);
        GameRegistry.registerItem(chestplate, matName + "_chestplate");

        Item leggings = new CopperToolsArmor(matArmor, matName + "_leggings", material, 2);
        GameRegistry.registerItem(leggings, matName + "_leggings");

        Item boots = new CopperToolsArmor(matArmor, matName + "_boots", material, 3);
        GameRegistry.registerItem(boots, matName + "_boots");
    }
    public static void RegisterToolSet(Item.ToolMaterial mat, ItemArmor.ArmorMaterial matArmor, String matName, ItemStack ingot, boolean useObsidian) {
        Item pickaxe = new CopperToolsPickaxe(mat, matName + "_pickaxe", ingot).setUseObsidian(useObsidian);
        GameRegistry.registerItem(pickaxe, matName + "_pickaxe");

        Item sword = new CopperToolsSword(mat, matName + "_sword", ingot).setUseObsidian(useObsidian);
        GameRegistry.registerItem(sword, matName + "_sword");

        Item shovel = new CopperToolsSpade(mat, matName + "_shovel", ingot).setUseObsidian(useObsidian);
        GameRegistry.registerItem(shovel, matName + "_shovel");

        Item axe = new CopperToolsAxe(mat, matName + "_axe", ingot).setUseObsidian(useObsidian);
        GameRegistry.registerItem(axe, matName + "_axe");

        Item hoe = new CopperToolsHoe(mat, matName + "_hoe", ingot).setUseObsidian(useObsidian);
        GameRegistry.registerItem(hoe, matName + "_hoe");

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
