package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.creativetab.CopperToolsTab;
import com.goldenapple.coppertools.item.CopperToolsPickaxe;
import cpw.mods.fml.common.registry.GameRegistry;


public class ModItems
{
    public static final CopperToolsPickaxe copperPick = new CopperToolsPickaxe(ModToolMaterial.COPPER, "copper_pickaxe");

    public static void init()
    {
        GameRegistry.registerItem(copperPick, "copper_pickaxe");
    }
}
