package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.creativetab.CopperToolsTab;
import com.goldenapple.coppertools.item.CopperToolsPickaxe;
import com.goldenapple.coppertools.item.ItemCopperPick;
import cpw.mods.fml.common.registry.GameRegistry;


public class ModItems
{
    public static final CopperToolsPickaxe copperPick = new ItemCopperPick();

    public static void init()
    {
        GameRegistry.registerItem(copperPick, "copper_pickaxe");
    }
}
