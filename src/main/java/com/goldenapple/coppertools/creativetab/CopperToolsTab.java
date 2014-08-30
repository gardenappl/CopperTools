package com.goldenapple.coppertools.creativetab;

import com.goldenapple.coppertools.init.ModItems;
import com.goldenapple.coppertools.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CopperToolsTab {
    public static final CreativeTabs CopperToolsTab = new CreativeTabs(Reference.MOD_ID_LOW) {
        @Override
        public Item getTabIconItem() {
            return ModItems.copperPick;
        }
    };
}
