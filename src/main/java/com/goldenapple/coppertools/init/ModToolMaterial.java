package com.goldenapple.coppertools.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ModToolMaterial {
    public static Item.ToolMaterial COPPER = EnumHelper.addToolMaterial("COPPER", 1, 131, 7F, 1, 18);

    public static ItemArmor.ArmorMaterial COPPER_A = EnumHelper.addArmorMaterial("COPPER", 10,  new int[] {2, 5, 4, 2}, 17);
}
