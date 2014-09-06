package com.goldenapple.coppertools.creativetab;

import com.goldenapple.coppertools.handler.ConfigHandler;
import com.goldenapple.coppertools.init.ModItems;
import com.goldenapple.coppertools.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CopperToolsTab {
    public static final CreativeTabs CopperToolsTab = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            if (ConfigHandler.loadCopper) {
                return ModItems.copperPick;
            }else{
                return Items.iron_pickaxe;
            }
        }
    };
}
