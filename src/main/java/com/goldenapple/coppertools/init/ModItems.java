package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.CopperTools;
import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.item.*;
import com.goldenapple.coppertools.item.special.*;
import com.goldenapple.coppertools.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {
    public static final ItemCommon obsidianRod = new ItemCommon(Names.OBSIDIAN_ROD);

    public static final ItemSickleCommon woodSickle = new ItemSickleCommon(EquipMaterial.wood);
    public static final ItemSickleCommon stoneSickle = new ItemSickleCommon(EquipMaterial.stone);
    public static final ItemSickleCommon ironSickle = new ItemSickleCommon(EquipMaterial.iron);
    public static final ItemSickleCommon diamondSickle = new ItemSickleCommon(EquipMaterial.diamond);
    public static final ItemSickleCommon goldSickle = new ItemSickleCommon(EquipMaterial.gold);
    public static final ItemSickleCommon brassSickle = new ItemSickleCommon(EquipMaterial.brass);
    public static final ItemSickleCommon ironwoodSickle = new ItemSickleCommon(EquipMaterial.ironwood);
    public static final ItemSickleCommon steeleafSickle = new ItemSickleCommon(EquipMaterial.steeleaf);

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
            if(ConfigHandler.loadIronwoodSickle && CopperTools.isTwilightLoaded){
                GameRegistry.registerItem(ironwoodSickle, Names.IRONWOOD_SICKLE);
            }
            if(ConfigHandler.loadSteeleafSickle && CopperTools.isTwilightLoaded){
                GameRegistry.registerItem(steeleafSickle, Names.STEELEAF_SICKLE);
            }
        }
    }

    private static void registerSet(EquipMaterial material){
        if(material.load) {
            if(material.loadTools) registerToolSet(material);
            if(material.loadArmor) registerArmorSet(material);
            if(material.loadSickle){
                Item sickle = new ItemSickleCommon(material);
                GameRegistry.registerItem(sickle, material.name + "_sickle");
            }
        }
    }

    private static void registerToolSet(EquipMaterial material){
        Item pickaxe = new ItemPickaxeCommon(material);
        GameRegistry.registerItem(pickaxe, material.name + "_pickaxe");

        Item sword = new ItemSwordCommon(material);
        GameRegistry.registerItem(sword, material.name + "_sword");

        Item shovel = new ItemSpadeCommon(material);
        GameRegistry.registerItem(shovel, material.name + "_shovel");

        Item axe = new ItemAxeCommon(material);
        GameRegistry.registerItem(axe, material.name + "_axe");

        Item hoe = new ItemHoeCommon(material);
        GameRegistry.registerItem(hoe, material.name + "_hoe");
    }

    private static void registerArmorSet(EquipMaterial material){
        Item helmet = new ItemArmorCommon(material, "helmet", 0);
        GameRegistry.registerItem(helmet, material.name + "_helmet");

        Item chestplate = new ItemArmorCommon(material, "chestplate", 1);
        GameRegistry.registerItem(chestplate, material.name + "_chestplate");

        Item leggings = new ItemArmorCommon(material, "leggings", 2);
        GameRegistry.registerItem(leggings, material.name + "_leggings");

        Item boots = new ItemArmorCommon(material, "boots", 3);
        GameRegistry.registerItem(boots, material.name + "_boots");
    }
}
