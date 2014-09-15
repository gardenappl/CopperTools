package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.item.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class ToolSets
{
    public static void RegisterOreToolSet(Item.ToolMaterial mat, ItemArmor.ArmorMaterial matNameArmor, String matName, String ingot){
        //Workaround for the CopperToolsTab class because it needs an Item object to take the Copper Pickaxe texture from.
        //And I can't give it one with the way my code works now.
        if (matName.equals("copper")) {
            GameRegistry.registerItem(ModItems.copper_pickaxe, "copper_pickaxe");
        }else{
            Item pickaxe = new CopperToolsPickaxe(mat, matName + "_pickaxe");
            GameRegistry.registerItem(pickaxe, matName + "_pickaxe");
        }

        Item sword = new CopperToolsSword(mat, matName + "_sword");
        GameRegistry.registerItem(sword, matName + "_sword");

        Item shovel = new CopperToolsSpade(mat, matName + "_shovel");
        GameRegistry.registerItem(shovel, matName + "_shovel");

        Item axe = new CopperToolsAxe(mat, matName + "_axe");
        GameRegistry.registerItem(axe, matName + "_axe");

        Item hoe = new CopperToolsHoe(mat, matName + "_hoe");
        GameRegistry.registerItem(hoe, matName + "_hoe");
    }
}
