package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.handler.ConfigHandler;
import com.goldenapple.coppertools.item.CopperToolsPickaxe;
import com.goldenapple.coppertools.item.CopperToolsSword;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
    public static final CopperToolsSword woodSaber = new CopperToolsSword(Item.ToolMaterial.STONE, "wooden_saber");
    public static final CopperToolsPickaxe copper_pickaxe = new CopperToolsPickaxe(ModToolMaterial.COPPER, "copper_pickaxe",  "ingotCopper");

    public static void init() {
        if (ConfigHandler.loadSaber) {
            GameRegistry.registerItem(woodSaber, "wooden_saber");
        }
        if (ConfigHandler.loadCopper) {
            ToolSets.RegisterOreToolSet(ModToolMaterial.COPPER, ModToolMaterial.COPPER_A, "copper", "ingotCopper");
        }
        if (ConfigHandler.loadPlatinum) {
            ToolSets.RegisterOreToolSet(ModToolMaterial.PLATINUM, ModToolMaterial.PLATINUM_A, "platinum", "ingotPlatinum");
        }
    }
}
