package com.goldenapple.coppertools.handler;

import com.goldenapple.coppertools.CopperToolsMod;
import com.goldenapple.coppertools.util.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {
    public static Configuration configGeneral;
    public static Configuration configCopper;
    public static Configuration configPlatinum;
    public static Configuration configCompressed;
    public static Configuration configLead;

    public static final String folder = CopperToolsMod.root + "/coppertools/";

    //General
    public static boolean loadSaber;
    public static boolean loadCopper;
    public static boolean loadPlatinum;
    public static boolean loadCompressed;
    public static boolean loadLead;
    public static boolean loadObsidianRod;

    public static boolean platinumRequiresObsidian;

    //Tool Properties
        //Tools: {Harvest level, durability, efficiency, damage, enchantibility}
    public static final int[] CopperToolMatDefault = {1, 131, 7, 2, 18};
    public static final int[] PlatinumToolMatDefault = {2, 200, 12, 2, 22};
    public static final int[] CompressedToolMatDefault = {2, 200, 12, 2, 22};
    public static final int[] LeadToolMatDefault = {2, 200, 12, 2, 22};

    public static int[] CopperToolMat = {0, 0, 0, 0, 0}; //I have no idea of what I'm doing
    public static int[] PlatinumToolMat = {0, 0, 0, 0, 0};
    public static int[] CompressedToolMat = {0, 0, 0, 0, 0};
    public static int[] LeadToolMat = {0, 0, 0, 0, 0};

        //Armor: {durability, protection (helmet, chest, legs, boots), enchantibility}
    public static final int[] CopperArmorMatDefault = {10, 2, 5, 4, 2, 17};
    public static final int[] PlatinumArmorMatDefault = {12, 2, 6, 5, 2, 25};
    public static final int[] CompressedArmorMatDefault = {12, 2, 6, 5, 2, 9};
    public static final int[] LeadArmorMatDefault = {12, 2, 6, 5, 2, 9};

    public static int[] CopperArmorMat = {0, 0, 0, 0, 0, 0};
    public static int[] PlatinumArmorMat = {0, 0, 0, 0, 0, 0};
    public static int[] CompressedArmorMat = {0, 0, 0, 0, 0, 0};
    public static int[] LeadArmorMat = {0, 0, 0, 0, 0, 0};

    public static boolean dumpAllOres;

    public static void init(){
        if (configGeneral == null){
            configGeneral = new Configuration(new File(folder + "general.cfg"));
            loadConfig(configGeneral);
        }
        if (configCopper == null){
            configCopper = new Configuration(new File(folder + "config.cfg"));
            loadConfig(configCopper);
        }
        if (configPlatinum == null){
            configPlatinum = new Configuration(new File(folder + "platinum.cfg"));
            loadConfig(configPlatinum);
        }
        if (configCompressed == null){
            configCompressed = new Configuration(new File(folder + "compressed.cfg"));
            loadConfig(configCompressed);
        }
        if (configLead == null){
            configLead = new Configuration(new File(folder + "lead.cfg"));
            loadConfig(configLead);
        }
    }

    private static void loadConfig(Configuration config){
        if(config == configGeneral){
            loadSaber = configGeneral.getBoolean("loadSaber", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable the Wooden Saber");
            loadObsidianRod = configGeneral.getBoolean("loadObsidianRod", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable the Obsidian Rod");
            loadCopper = configGeneral.getBoolean("loadCopper", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable copper tools & armor");
            loadPlatinum = configGeneral.getBoolean("loadPlatinum", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable platinum tools & armor");
            loadCompressed = configGeneral.getBoolean("loadCompressed", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable tools & armor out of compressed iron");
            loadLead = configGeneral.getBoolean("loadLead", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable lead tools & armor");
            platinumRequiresObsidian = configGeneral.getBoolean("platinumRequiresObsidian", Configuration.CATEGORY_GENERAL, true, "Set this to false to allow crafting platinum tools with regular sticks");

            dumpAllOres = configGeneral.getBoolean("dumpAllOres", Configuration.CATEGORY_GENERAL, false, "Set this to true to log every single OreDictionary ore");
        }

        if (config == configCopper) {
            loadMaterialProperty("copper", config, CopperToolMat, CopperToolMatDefault, CopperArmorMat, CopperArmorMatDefault);
        }else if(config == configPlatinum) {
            loadMaterialProperty("platinum", config, PlatinumToolMat, PlatinumToolMatDefault, PlatinumArmorMat, PlatinumArmorMatDefault);
        }else if (config == configCompressed) {
            loadMaterialProperty("compressed", config, CompressedToolMat, CompressedToolMatDefault, CompressedArmorMat, CompressedArmorMatDefault);
        }else if (config == configLead) {
            loadMaterialProperty("lead", config, LeadToolMat, LeadToolMatDefault, LeadArmorMat, LeadArmorMatDefault);
        }
        if (config.hasChanged()){
            config.save();
        }
    }

    private static void loadMaterialProperty(String name, Configuration config, int[] props, int[] propsDefault, int[] propsA, int[] propsADefault){
        props[0] = config.getInt(name + "Level", name, propsDefault[0], 0, 9000, "Mining level of " + name + " tools");
        props[1] = config.getInt(name + "Durability", name, propsDefault[1], 1, 9000, "Durability of " + name + " tools");
        props[2] = config.getInt(name + "Efficiency", name, propsDefault[2], 0, 9000, "Efficiency of " + name + " tools");
        props[3] = config.getInt(name + "Damage", name, propsDefault[3], 0, 9000, "Damage of " + name + " tools");
        props[4] = config.getInt(name + "Enchant", name, propsDefault[4], 0, 9000, "Enchantability of " + name + " tools");

        propsA[0] = config.getInt(name + "ArmorDurability", name, propsADefault[0], 1, 9000, "Durability level of " + name + " armor");
        propsA[1] = config.getInt(name + "HelmetProtection", name, propsADefault[1], 0, 9000, "Protection of the " + name + " helmet");
        propsA[2] = config.getInt(name + "ChestProtection", name, propsADefault[2], 0, 9000, "Protection of the " + name + " chestplate");
        propsA[3] = config.getInt(name + "LegsProtection", name, propsADefault[3], 0, 9000, "Protection of the " + name + " leggings");
        propsA[4] = config.getInt(name + "BootsProtection", name, propsADefault[4], 0, 9000, "Protection of the " + name + " boots");
        propsA[5] = config.getInt(name + "ArmorEnchant", name, propsADefault[5], 0, 9000, "Enchantability of " + name + " armor");
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            loadConfig(configGeneral);
            loadConfig(configCopper);
            loadConfig(configPlatinum);
            loadConfig(configCompressed);
            loadConfig(configLead);
        }
    }
}
