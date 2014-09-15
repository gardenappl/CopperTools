package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.handler.ConfigHandler;
import com.goldenapple.coppertools.item.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;


public class ModItems
{
    public static final CopperToolsSword woodSaber = new CopperToolsSword(Item.ToolMaterial.STONE, "wooden_saber");

    public static final CopperToolsPickaxe copperPick = new CopperToolsPickaxe(ModToolMaterial.COPPER, "copper_pickaxe");
    public static final CopperToolsSword copperSword = new CopperToolsSword(ModToolMaterial.COPPER, "copper_sword");
    public static final CopperToolsSpade copperShovel = new CopperToolsSpade(ModToolMaterial.COPPER, "copper_shovel");
    public static final CopperToolsAxe copperAxe = new CopperToolsAxe(ModToolMaterial.COPPER, "copper_axe");
    public static final CopperToolsHoe copperHoe = new CopperToolsHoe(ModToolMaterial.COPPER, "copper_hoe");
    public static final CopperToolsArmor copperHelmet = new CopperToolsArmor(ModToolMaterial.COPPER_A, "copper_helmet", 0);
    public static final CopperToolsArmor copperChestplate = new CopperToolsArmor(ModToolMaterial.COPPER_A, "copper_chestplate", 1);
    public static final CopperToolsArmor copperLeggings = new CopperToolsArmor(ModToolMaterial.COPPER_A, "copper_leggings", 2);
    public static final CopperToolsArmor copperBoots = new CopperToolsArmor(ModToolMaterial.COPPER_A, "copper_boots", 3);

    public static final CopperToolsPickaxe platinumPick = new CopperToolsPickaxe(ModToolMaterial.PLATINUM, "platinum_pickaxe");
    public static final CopperToolsSword platinumSword = new CopperToolsSword(ModToolMaterial.PLATINUM, "platinum_sword");
    public static final CopperToolsSpade platinumShovel = new CopperToolsSpade(ModToolMaterial.PLATINUM, "platinum_shovel");
    public static final CopperToolsAxe platinumAxe = new CopperToolsAxe(ModToolMaterial.PLATINUM, "platinum_axe");
    public static final CopperToolsHoe platinumHoe = new CopperToolsHoe(ModToolMaterial.PLATINUM, "platinum_hoe");
    public static final CopperToolsArmor platinumHelmet = new CopperToolsArmor(ModToolMaterial.PLATINUM_A, "platinum_helmet", 0);
    public static final CopperToolsArmor platinumChestplate = new CopperToolsArmor(ModToolMaterial.PLATINUM_A, "platinum_chestplate", 1);
    public static final CopperToolsArmor platinumLeggings = new CopperToolsArmor(ModToolMaterial.PLATINUM_A, "platinum_leggings", 2);
    public static final CopperToolsArmor platinumBoots = new CopperToolsArmor(ModToolMaterial.PLATINUM_A, "platinum_boots", 3);

    public static final CopperToolsPickaxe steelPick = new CopperToolsPickaxe(ModToolMaterial.STEEL, "steel_pickaxe");
    public static final CopperToolsSword steelSword = new CopperToolsSword(ModToolMaterial.STEEL, "steel_sword");
    public static final CopperToolsSpade steelShovel = new CopperToolsSpade(ModToolMaterial.STEEL, "steel_shovel");
    public static final CopperToolsAxe steelAxe = new CopperToolsAxe(ModToolMaterial.STEEL, "steel_axe");
    public static final CopperToolsHoe steelHoe = new CopperToolsHoe(ModToolMaterial.STEEL, "steel_hoe");
    public static final CopperToolsArmor steelHelmet = new CopperToolsArmor(ModToolMaterial.STEEL_A, "steel_helmet", 0);
    public static final CopperToolsArmor steelChestplate = new CopperToolsArmor(ModToolMaterial.STEEL_A, "steel_chestplate", 1);
    public static final CopperToolsArmor steelLeggings = new CopperToolsArmor(ModToolMaterial.STEEL_A, "steel_leggings", 2);
    public static final CopperToolsArmor steelBoots = new CopperToolsArmor(ModToolMaterial.STEEL_A, "steel_boots", 3);

    public static void init()
    {
        if (ConfigHandler.loadSaber) {
            GameRegistry.registerItem(woodSaber, "wooden_saber");
        }

        if (ConfigHandler.loadCopper) {
            GameRegistry.registerItem(copperPick, "copper_pickaxe");
            GameRegistry.registerItem(copperSword, "copper_sword");
            GameRegistry.registerItem(copperShovel, "copper_shovel");
            GameRegistry.registerItem(copperAxe, "copper_axe");
            GameRegistry.registerItem(copperHoe, "copper_hoe");
            GameRegistry.registerItem(copperHelmet, "copper_helmet");
            GameRegistry.registerItem(copperChestplate, "copper_chestplate");
            GameRegistry.registerItem(copperLeggings, "copper_leggings");
            GameRegistry.registerItem(copperBoots, "copper_boots");
        }

        if (ConfigHandler.loadPlatinum) {
            GameRegistry.registerItem(platinumPick, "platinum_pickaxe");
            GameRegistry.registerItem(platinumSword, "platinum_sword");
            GameRegistry.registerItem(platinumShovel, "platinum_shovel");
            GameRegistry.registerItem(platinumAxe, "platinum_axe");
            GameRegistry.registerItem(platinumHoe, "platinum_hoe");
            GameRegistry.registerItem(platinumHelmet, "platinum_helmet");
            GameRegistry.registerItem(platinumChestplate, "platinum_chestplate");
            GameRegistry.registerItem(platinumLeggings, "platinum_leggings");
            GameRegistry.registerItem(platinumBoots, "platinum_boots");
        }

        if (ConfigHandler.loadSteel) {
            GameRegistry.registerItem(steelPick, "steel_pickaxe");
            GameRegistry.registerItem(steelSword, "steel_sword");
            GameRegistry.registerItem(steelShovel, "steel_shovel");
            GameRegistry.registerItem(steelAxe, "steel_axe");
            GameRegistry.registerItem(steelHoe, "steel_hoe");
            GameRegistry.registerItem(steelHelmet, "steel_helmet");
            GameRegistry.registerItem(steelChestplate, "steel_chestplate");
            GameRegistry.registerItem(steelLeggings, "steel_leggings");
            GameRegistry.registerItem(steelBoots, "steel_boots");
        }
    }
}
