package com.goldenapple.coppertools.creativetab;

import com.goldenapple.coppertools.reference.Reference;
import com.goldenapple.coppertools.config.ConfigHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CopperToolsCombatTab {
    public static final CreativeTabs CopperToolsCombatTab = new CreativeTabs(Reference.MOD_ID.toLowerCase() + "_combat") {
    @Override
    public Item getTabIconItem() {
        if (ConfigHandler.loadSilver){
            return GameRegistry.findItem(Reference.MOD_ID, "silver_chestplate");
        }else {
            return Items.chainmail_chestplate;
        }
    }
};
}
