package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.CopperTools;
import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.item.*;
import com.goldenapple.coppertools.item.special.*;
import com.goldenapple.coppertools.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {
    public static final ItemCommon obsidianRod = new ItemCommon(Names.OBSIDIAN_ROD);

    public static final ItemSickleCommon woodSickle = new ItemSickleCommon(Item.ToolMaterial.WOOD, Names.WOOD_SICKLE, "plankWood", false);
    public static final ItemSickleCommon stoneSickle = new ItemSickleCommon(Item.ToolMaterial.STONE, Names.STONE_SICKLE, "cobblestone", false);
    public static final ItemSickleCommon ironSickle = new ItemSickleCommon(Item.ToolMaterial.IRON, Names.IRON_SICKLE, "ingotIron", false);
    public static final ItemSickleCommon diamondSickle = new ItemSickleCommon(Item.ToolMaterial.EMERALD, Names.DIAMOND_SICKLE, "gemDiamond", false);
    public static final ItemSickleCommon goldSickle = new ItemSickleCommon(Item.ToolMaterial.GOLD, Names.GOLD_SICKLE, "ingotGold", false);
    public static final ItemSickleCommon brassSickle = new ItemSickleCommon(EquipMaterial.BRASS_MATERIAL, Names.BRASS_SICKLE, "ingotBrass", false);

    public static void init() {
        if(ConfigHandler.loadObsidianRod) {
            GameRegistry.registerItem(obsidianRod, Names.OBSIDIAN_ROD);
            OreDictionary.registerOre("rodObsidian", obsidianRod);
        }
        if(ConfigHandler.loadSaber) {
            GameRegistry.registerItem(new ItemSwordWooden(), Names.WOOD_KATANA);
        }

        for(EquipMaterial material : EquipMaterial.registry){
            registerSet(material);
        }

        if(ConfigHandler.loadSickles) {
            if (ConfigHandler.loadVanillaSickles) {
                GameRegistry.registerItem(woodSickle, Names.WOOD_SICKLE);
                GameRegistry.registerItem(stoneSickle, Names.STONE_SICKLE);
                GameRegistry.registerItem(ironSickle, Names.IRON_SICKLE);
                GameRegistry.registerItem(diamondSickle, Names.DIAMOND_SICKLE);
                GameRegistry.registerItem(goldSickle, Names.GOLD_SICKLE);
            }
            if (ConfigHandler.loadBrassSickle) {
                GameRegistry.registerItem(brassSickle, Names.BRASS_SICKLE);
            }
            if (ConfigHandler.loadGildedSickle && CopperTools.isSteamPowerLoaded) {
                GameRegistry.registerItem(new ItemSickleGildedIron(), Names.GILDED_SICKLE);
            }
            if(ConfigHandler.loadThaumiumSickle && CopperTools.isThaumcraftLoaded){
                GameRegistry.registerItem(new ItemSickleThaumium(), Names.THAUMIUM_SICKLE);
            }
            if(ConfigHandler.loadVoidSickle && CopperTools.isThaumcraftLoaded){
                GameRegistry.registerItem(new ItemSickleVoid(), Names.VOID_SICKLE);
            }
            if(ConfigHandler.loadManasteelSickle && CopperTools.isBotaniaLoaded){
                GameRegistry.registerItem(new ItemSickleManasteel(), Names.MANASTEEL_SICKLE);
            }
            if(ConfigHandler.loadElementiumSickle && CopperTools.isBotaniaLoaded){
                GameRegistry.registerItem(new ItemSickleElementium(), Names.ELEMENTIUM_SICKLE);
            }
        }
    }

    private static void registerSet(EquipMaterial material){
        if(material.load) {
            if(material.loadTools) registerToolSet(material);
            if(material.loadArmor) registerArmorSet(material);
            if(material.loadSickle){
                if(material.repairMat instanceof ItemStack) {
                    Item sickle = new ItemSickleCommon(material.toolMat, material.name + "_sickle", (ItemStack)material.repairMat, material.useObsidian);
                    GameRegistry.registerItem(sickle, material.name + "_sickle");
                }
                if(material.repairMat instanceof String) {
                    Item sickle = new ItemSickleCommon(material.toolMat, material.name + "_sickle", (String)material.repairMat, material.useObsidian);
                    GameRegistry.registerItem(sickle, material.name + "_sickle");
                }
            }
        }
    }

    private static void registerToolSet(EquipMaterial material){
        Item.ToolMaterial mat = material.toolMat;
        if(material.repairMat instanceof ItemStack) {
            ItemStack matRepair = (ItemStack) material.repairMat;

            Item pickaxe = new ItemPickaxeCommon(mat, material.name + "_pickaxe", matRepair, false);
            GameRegistry.registerItem(pickaxe, material.name + "_pickaxe");

            Item sword = new ItemSwordCommon(mat, material.name + "_sword", matRepair, false);
            GameRegistry.registerItem(sword, material.name + "_sword");

            Item shovel = new ItemSpadeCommon(mat, material.name + "_shovel", matRepair, false);
            GameRegistry.registerItem(shovel, material.name + "_shovel");

            Item axe = new ItemAxeCommon(mat, material.name + "_axe", matRepair, false);
            GameRegistry.registerItem(axe, material.name + "_axe");

            Item hoe = new ItemHoeCommon(mat, material.name + "_hoe", matRepair, false);
            GameRegistry.registerItem(hoe, material.name + "_hoe");
        }else if(material.repairMat instanceof String){
            String matRepair = (String) material.repairMat;

            Item pickaxe = new ItemPickaxeCommon(mat, material.name + "_pickaxe", matRepair, false);
            GameRegistry.registerItem(pickaxe, material.name + "_pickaxe");

            Item sword = new ItemSwordCommon(mat, material.name + "_sword", matRepair, false);
            GameRegistry.registerItem(sword, material.name + "_sword");

            Item shovel = new ItemSpadeCommon(mat, material.name + "_shovel", matRepair, false);
            GameRegistry.registerItem(shovel, material.name + "_shovel");

            Item axe = new ItemAxeCommon(mat, material.name + "_axe", matRepair, false);
            GameRegistry.registerItem(axe, material.name + "_axe");

            Item hoe = new ItemHoeCommon(mat, material.name + "_hoe", matRepair, false);
            GameRegistry.registerItem(hoe, material.name + "_hoe");
        }
    }

    private static void registerArmorSet(EquipMaterial material){
        ItemArmor.ArmorMaterial mat = material.armorMat;
        if(material.repairMat instanceof ItemStack) {
            ItemStack matRepair = (ItemStack) material.repairMat;
            Item helmet = new ItemArmorCommon(mat, material.name + "_helmet", matRepair, 0);
            GameRegistry.registerItem(helmet, material.name + "_helmet");

            Item chestplate = new ItemArmorCommon(mat, material.name + "_chestplate", matRepair, 1);
            GameRegistry.registerItem(chestplate, material.name + "_chestplate");

            Item leggings = new ItemArmorCommon(mat, material.name + "_leggings", matRepair, 2);
            GameRegistry.registerItem(leggings, material.name + "_leggings");

            Item boots = new ItemArmorCommon(mat, material.name + "_boots", matRepair, 3);
            GameRegistry.registerItem(boots, material.name + "_boots");
        }else if(material.repairMat instanceof String) {
            String matRepair = (String) material.repairMat;
            Item helmet = new ItemArmorCommon(mat, material.name + "_helmet", matRepair, 0);
            GameRegistry.registerItem(helmet, material.name + "_helmet");

            Item chestplate = new ItemArmorCommon(mat, material.name + "_chestplate", matRepair, 1);
            GameRegistry.registerItem(chestplate, material.name + "_chestplate");

            Item leggings = new ItemArmorCommon(mat, material.name + "_leggings", matRepair, 2);
            GameRegistry.registerItem(leggings, material.name + "_leggings");

            Item boots = new ItemArmorCommon(mat, material.name + "_boots", matRepair, 3);
            GameRegistry.registerItem(boots, material.name + "_boots");
        }
    }
}
