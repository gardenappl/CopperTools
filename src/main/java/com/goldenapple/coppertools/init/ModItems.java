package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.config.ModArmorMaterial;
import com.goldenapple.coppertools.config.ModToolMaterial;
import com.goldenapple.coppertools.item.*;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {
    public static final CopperToolsSword woodSaber = new CopperToolsSword(Item.ToolMaterial.STONE, "wooden_saber", "logWood", false);
    public static final CopperToolsItem obsidianRod = new CopperToolsItem("obsidian_rod");

    public static void init() {
        if (ConfigHandler.loadObsidianRod) {
            GameRegistry.registerItem(obsidianRod, "obsidian_rod");

            OreDictionary.registerOre("rodObsidian", obsidianRod);
        }

        if (ConfigHandler.loadSaber) {
            GameRegistry.registerItem(woodSaber, "wooden_saber");
        }
        if (ConfigHandler.loadCopper) {
            RegisterOreToolSet(ModToolMaterial.COPPER, ModArmorMaterial.COPPER, "copper", "ingotCopper", false);
        }
        if (ConfigHandler.loadPlatinum) {
            RegisterOreToolSet(ModToolMaterial.PLATINUM, ModArmorMaterial.PLATINUM, "platinum", "ingotPlatinum", ConfigHandler.platinumRequiresObsidian);
        }
        if (ConfigHandler.loadLead){
            RegisterOreToolSet(ModToolMaterial.LEAD, ModArmorMaterial.LEAD, "lead", "ingotLead", false);
        }
        if (ConfigHandler.loadCompressed && Loader.isModLoaded("PneumaticCraft")) {
            RegisterToolSet(ModToolMaterial.COMPRESSED, ModArmorMaterial.COMPRESSED, "compressed", GameRegistry.findItem("PneumaticCraft", "ingotIronCompressed"), false);
        }
    }

    public static void RegisterOreToolSet(Item.ToolMaterial mat, ItemArmor.ArmorMaterial matArmor, String matName, String material, boolean useObsidian){
        Item pickaxe = new CopperToolsPickaxe(mat, matName + "_pickaxe", material, useObsidian);
        GameRegistry.registerItem(pickaxe, matName + "_pickaxe");

        Item sword = new CopperToolsSword(mat, matName + "_sword", material, useObsidian);
        GameRegistry.registerItem(sword, matName + "_sword");

        Item shovel = new CopperToolsSpade(mat, matName + "_shovel", material, useObsidian);
        GameRegistry.registerItem(shovel, matName + "_shovel");

        Item axe = new CopperToolsAxe(mat, matName + "_axe", material, useObsidian);
        GameRegistry.registerItem(axe, matName + "_axe");

        Item hoe = new CopperToolsHoe(mat, matName + "_hoe", material, useObsidian);
        GameRegistry.registerItem(hoe, matName + "_hoe");

        Item sickle = new CopperToolsSickle(mat, matName + "_sickle", material, useObsidian);
        GameRegistry.registerItem(sickle, matName + "_sickle");

        Item helmet = new CopperToolsArmor(matArmor, matName + "_helmet", material, 0);
        GameRegistry.registerItem(helmet, matName + "_helmet");

        Item chestplate = new CopperToolsArmor(matArmor, matName + "_chestplate", material, 1);
        GameRegistry.registerItem(chestplate, matName + "_chestplate");

        Item leggings = new CopperToolsArmor(matArmor, matName + "_leggings", material, 2);
        GameRegistry.registerItem(leggings, matName + "_leggings");

        Item boots = new CopperToolsArmor(matArmor, matName + "_boots", material, 3);
        GameRegistry.registerItem(boots, matName + "_boots");
    }

    public static void RegisterToolSet(Item.ToolMaterial mat, ItemArmor.ArmorMaterial matArmor, String matName,  Item ingot, boolean useObsidian) {
        Item pickaxe = new CopperToolsPickaxe(mat, matName + "_pickaxe", ingot, useObsidian);
        GameRegistry.registerItem(pickaxe, matName + "_pickaxe");

        Item sword = new CopperToolsSword(mat, matName + "_sword", ingot, useObsidian);
        GameRegistry.registerItem(sword, matName + "_sword");

        Item shovel = new CopperToolsSpade(mat, matName + "_shovel", ingot, useObsidian);
        GameRegistry.registerItem(shovel, matName + "_shovel");

        Item axe = new CopperToolsAxe(mat, matName + "_axe", ingot, useObsidian);
        GameRegistry.registerItem(axe, matName + "_axe");

        Item hoe = new CopperToolsHoe(mat, matName + "_hoe", ingot, useObsidian);
        GameRegistry.registerItem(hoe, matName + "_hoe");

        Item sickle = new CopperToolsSickle(mat, matName + "_sickle", ingot, useObsidian);
        GameRegistry.registerItem(sickle, matName + "_sickle");

        Item helmet = new CopperToolsArmor(matArmor, matName + "_helmet", ingot, 0);
        GameRegistry.registerItem(helmet, matName + "_helmet");

        Item chestplate = new CopperToolsArmor(matArmor, matName + "_chestplate", ingot, 1);
        GameRegistry.registerItem(chestplate, matName + "_chestplate");

        Item leggings = new CopperToolsArmor(matArmor, matName + "_leggings", ingot, 2);
        GameRegistry.registerItem(leggings, matName + "_leggings");

        Item boots = new CopperToolsArmor(matArmor, matName + "_boots", ingot, 3);
        GameRegistry.registerItem(boots, matName + "_boots");
    }
}
