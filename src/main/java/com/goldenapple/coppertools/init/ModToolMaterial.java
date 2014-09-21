package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.CopperToolsMod;
import com.goldenapple.coppertools.handler.PropertiesConfigHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ModToolMaterial {
    //Tool materials
    public static Item.ToolMaterial COPPER = EnumHelper.addToolMaterial("COPPER", PropertiesConfigHandler.levelCopper, PropertiesConfigHandler.durabliltyCopper, PropertiesConfigHandler.efficiencyCopper, PropertiesConfigHandler.damageCopper, PropertiesConfigHandler.enchantCopper);
    public static Item.ToolMaterial PLATINUM = EnumHelper.addToolMaterial("PLATINUM", PropertiesConfigHandler.levelPlatinum, PropertiesConfigHandler.durabliltyPlatinum, PropertiesConfigHandler.efficiencyPlatinum, PropertiesConfigHandler.damagePlatinum, PropertiesConfigHandler.enchantPlatinum);
    //Compressed iron temporairly has stats of platinum.
    public static Item.ToolMaterial COMPRESSED = EnumHelper.addToolMaterial("PLATINUM", PropertiesConfigHandler.levelPlatinum, PropertiesConfigHandler.durabliltyPlatinum, PropertiesConfigHandler.efficiencyPlatinum, PropertiesConfigHandler.damagePlatinum, PropertiesConfigHandler.enchantPlatinum);

    //Armor materials
    public static ItemArmor.ArmorMaterial COPPER_A = EnumHelper.addArmorMaterial("COPPER", PropertiesConfigHandler.durablilityCopperA,  new int[] {PropertiesConfigHandler.protectionCopperHelmet, PropertiesConfigHandler.protectionCopperChestplate, PropertiesConfigHandler.protectionCopperLeggings, PropertiesConfigHandler.protectionCopperBoots}, PropertiesConfigHandler.enchantCopperA);
    public static ItemArmor.ArmorMaterial PLATINUM_A = EnumHelper.addArmorMaterial("PLATINUM", PropertiesConfigHandler.durablilityPlatinumA,  new int[] {PropertiesConfigHandler.protectionPlatinumHelmet, PropertiesConfigHandler.protectionPlatinumChestplate, PropertiesConfigHandler.protectionPlatinumLeggings, PropertiesConfigHandler.protectionPlatinumBoots}, PropertiesConfigHandler.enchantPlatinumA);
    public static ItemArmor.ArmorMaterial COMPRESSED_A = EnumHelper.addArmorMaterial("PLATINUM", PropertiesConfigHandler.durablilityPlatinumA,  new int[] {PropertiesConfigHandler.protectionPlatinumHelmet, PropertiesConfigHandler.protectionPlatinumChestplate, PropertiesConfigHandler.protectionPlatinumLeggings, PropertiesConfigHandler.protectionPlatinumBoots}, PropertiesConfigHandler.enchantPlatinumA);

}
