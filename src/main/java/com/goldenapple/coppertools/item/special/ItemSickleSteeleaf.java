package com.goldenapple.coppertools.item.special;

import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.item.ItemSickleCommon;
import com.goldenapple.coppertools.util.EnchantHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemSickleSteeleaf extends ItemSickleCommon {
    public static EquipMaterial material = new EquipMaterial("steeleaf", "steeleaf", EquipMaterial.STEELEAF_MATERIAL, null, null, null, false, false, true);

    public ItemSickleSteeleaf(){
        super(material);
        this.setHasSubtypes(true);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        list.add(EnchantHelper.enchant(new ItemStack(item), Enchantment.unbreaking, 2));
    }
}
