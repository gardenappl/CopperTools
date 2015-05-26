package com.goldenapple.coppertools;

import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CopperToolsCreativeTab {
    public static CreativeTabs tabTools;
    public static CreativeTabs tabCombat;

    public static void init() {
        if (ConfigHandler.creativeTabs >= 1) {
            tabTools = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {

                @Override
                public Item getTabIconItem() {
                    if (EquipMaterial.copper.load) {
                        return GameRegistry.findItem(Reference.MOD_ID, "copper_pickaxe");
                    } else {
                        return Items.iron_pickaxe;
                    }
                }
            };
        }
        if (ConfigHandler.creativeTabs == 2) {
            tabCombat = new CreativeTabs(Reference.MOD_ID.toLowerCase() + "_combat") {

                @Override
                public Item getTabIconItem() {
                    if (EquipMaterial.silver.load){
                        return GameRegistry.findItem(Reference.MOD_ID, "silver_sword");
                    }else {
                        return Items.chainmail_chestplate;
                    }
                }
            };
        }
    }
}
