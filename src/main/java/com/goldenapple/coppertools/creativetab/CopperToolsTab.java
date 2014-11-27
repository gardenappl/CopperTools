package com.goldenapple.coppertools.creativetab;

import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.util.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CopperToolsTab {
    public static final CreativeTabs CopperToolsTab = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            if (ConfigHandler.loadCopper){
                return GameRegistry.findItem(Reference.MOD_ID, "copper_pickaxe");
            }else {
                return Items.iron_pickaxe;
            }
        }
    };
}
