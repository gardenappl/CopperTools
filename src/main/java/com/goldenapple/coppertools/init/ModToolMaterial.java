package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.handler.ConfigHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ModToolMaterial {
    public static Item.ToolMaterial COPPER = EnumHelper.addToolMaterial("COPPER", ConfigHandler.levelCopper, ConfigHandler.durabliltyCopper, ConfigHandler.efficiencyCopper, ConfigHandler.damageCopper, ConfigHandler.enchantCopper);
    public static Item.ToolMaterial PLATINUM = EnumHelper.addToolMaterial("PLATINUM", ConfigHandler.levelPlatinum, ConfigHandler.durabliltyPlatinum, ConfigHandler.efficiencyPlatinum, ConfigHandler.damagePlatinum, ConfigHandler.enchantPlatinum);
    public static Item.ToolMaterial STEEL = EnumHelper.addToolMaterial("STEEL", ConfigHandler.levelSteel, ConfigHandler.durabliltySteel, ConfigHandler.efficiencySteel, ConfigHandler.damageSteel, ConfigHandler.enchantSteel);


    public static ItemArmor.ArmorMaterial COPPER_A = EnumHelper.addArmorMaterial("COPPER", ConfigHandler.durablilityCopperA,  new int[] {ConfigHandler.protectionCopperHelmet, ConfigHandler.protectionCopperChestplate, ConfigHandler.protectionCopperLeggings, ConfigHandler.protectionCopperBoots}, ConfigHandler.enchantCopperA);
    public static ItemArmor.ArmorMaterial PLATINUM_A = EnumHelper.addArmorMaterial("PLATINUM", ConfigHandler.durablilityPlatinumA,  new int[] {ConfigHandler.protectionPlatinumHelmet, ConfigHandler.protectionPlatinumChestplate, ConfigHandler.protectionPlatinumLeggings, ConfigHandler.protectionPlatinumBoots}, ConfigHandler.enchantPlatinumA);
    public static ItemArmor.ArmorMaterial STEEL_A = EnumHelper.addArmorMaterial("STEEL", ConfigHandler.durablilitySteelA,  new int[] {ConfigHandler.protectionSteelHelmet, ConfigHandler.protectionSteelChestplate, ConfigHandler.protectionSteelLeggings, ConfigHandler.protectionSteelBoots}, ConfigHandler.enchantSteelA);

}
