package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.handler.ConfigHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ModToolMaterial {
    public static Item.ToolMaterial COPPER = EnumHelper.addToolMaterial("COPPER", ConfigHandler.levelCopper, ConfigHandler.durabliltyCopper, ConfigHandler.efficiencyCopper, ConfigHandler.damageCopper, ConfigHandler.enchantCopper);

    public static ItemArmor.ArmorMaterial COPPER_A = EnumHelper.addArmorMaterial("COPPER", ConfigHandler.durablilityCopperA,  new int[] {ConfigHandler.protectionCopperHelmet, ConfigHandler.protectionCopperChestplate, ConfigHandler.protectionCopperLeggings, ConfigHandler.protectionCopperBoots}, ConfigHandler.enchantCopperA);
}
