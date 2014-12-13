package com.goldenapple.coppertools.config;

import com.goldenapple.coppertools.util.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

import java.io.File;

public class ConfigHandler {
    private static String path;
    public static Configuration configGeneral;
    public static Configuration configCopper;
    public static Configuration configPlatinum;
    public static Configuration configCompressed;
    public static Configuration configLead;

    //General
    public static boolean loadSaber;
    public static boolean loadCopper;
    public static boolean loadPlatinum;
    public static boolean loadCompressed;
    public static boolean loadLead;
    public static boolean loadObsidianRod;

    public static boolean platinumRequiresObsidian;
    public static boolean dumpAllOres;

    public static void init(String path){
        if (configGeneral == null){
            configGeneral = new Configuration(new File(path + "general.cfg"));
        }
        loadGeneral();

        if (configCopper == null){
            configCopper = new Configuration(new File(path + "config.cfg"));
        }
        ModToolMaterial.COPPER = loadProperty(configCopper, "copper", ModToolMaterialDefault.COPPER);
        ModArmorMaterial.COPPER = loadProperty(configCopper, "copper", ModArmorMaterialDefault.COPPER);
        if(configCopper.hasChanged()){
            configCopper.save();
        }

        if (configPlatinum == null){
            configPlatinum = new Configuration(new File(path + "platinum.cfg"));
        }
        ModToolMaterial.PLATINUM = loadProperty(configPlatinum, "platinum", ModToolMaterialDefault.PLATINUM);
        ModArmorMaterial.PLATINUM = loadProperty(configPlatinum, "platinum", ModArmorMaterialDefault.PLATINUM);
        if(configPlatinum.hasChanged()){
            configPlatinum.save();
        }

        if (configCompressed == null){
            configCompressed = new Configuration(new File(path + "compressed.cfg"));
        }
        ModToolMaterial.COMPRESSED = loadProperty(configCompressed, "compressed", ModToolMaterialDefault.COMPRESSED);
        ModArmorMaterial.COMPRESSED = loadProperty(configCompressed, "compressed", ModArmorMaterialDefault.COMPRESSED);
        if(configCompressed.hasChanged()){
            configCompressed.save();
        }

        if (configLead == null){
            configLead = new Configuration(new File(path + "lead.cfg"));
        }
        ModToolMaterial.LEAD = loadProperty(configLead, "lead", ModToolMaterialDefault.LEAD);
        ModArmorMaterial.LEAD = loadProperty(configLead, "lead", ModArmorMaterialDefault.LEAD);
        if(configLead.hasChanged()){
            configLead.save();
        }
    }

    private static void loadGeneral(){
        loadSaber = configGeneral.getBoolean("loadSaber", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable the Wooden Saber");
        loadObsidianRod = configGeneral.getBoolean("loadObsidianRod", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable the Obsidian Rod");
        loadCopper = configGeneral.getBoolean("loadCopper", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable copper tools & armor");
        loadPlatinum = configGeneral.getBoolean("loadPlatinum", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable platinum tools & armor");
        loadCompressed = configGeneral.getBoolean("loadCompressed", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable tools & armor out of compressed iron");
        loadLead = configGeneral.getBoolean("loadLead", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable lead tools & armor");
        platinumRequiresObsidian = configGeneral.getBoolean("platinumRequiresObsidian", Configuration.CATEGORY_GENERAL, true, "Set this to false to allow crafting platinum tools with regular sticks");

        dumpAllOres = configGeneral.getBoolean("dumpAllOres", Configuration.CATEGORY_GENERAL, false, "Set this to true to log every single OreDictionary ore");
        if (configGeneral.hasChanged()){
            configGeneral.save();
        }
    }

    private static Item.ToolMaterial loadProperty(Configuration config, String name, ModToolMaterialDefault toolMatDefault){
        int harvestLevel = config.getInt(name + "Level", "tools", toolMatDefault.getHarvestLevel(), 0, 9000, "Mining level of " + name + " tools");
        int durability = config.getInt(name + "Durability", "tools", toolMatDefault.getDurability(), 0, 9000, "Durability of " + name + " tools");
        float efficiency = config.getFloat(name + "Efficiency", "tools", toolMatDefault.getEfficiecny(), 0, 9000, "Efficiency of " + name + " tools");
        float damage = config.getFloat(name + "Damage", "tools", toolMatDefault.getDamage(), 0, 9000, "Damage of " + name + " tools");
        int enchant = config.getInt(name + "Enchant", "tools", toolMatDefault.getEnchant(), 0, 9000, "Enchantability of " + name + " tools");
        return EnumHelper.addToolMaterial(name.toUpperCase(), harvestLevel, durability, efficiency, damage, enchant);
    }

    private static ItemArmor.ArmorMaterial loadProperty(Configuration config, String name, ModArmorMaterialDefault armorMatDefault){
        int durability = config.getInt(name + "Durability", "armor", armorMatDefault.getDurability(), 0, 9000, "Durability level of " + name + " armor");
        int[] protection = new int[4];
        int[] protectionDefault = armorMatDefault.getProtection();
        protection[0]  = config.getInt(name + "HelmetProtection", "armor", protectionDefault[0], 0, 9000, "Protection of the " + name + " helmet");
        protection[1] = config.getInt(name + "ChestProtection", "armor", protectionDefault[1], 0, 9000, "Protection of the " + name + " chestplate");
        protection[2] = config.getInt(name + "LegsProtection", "armor", protectionDefault[2], 0, 9000, "Protection of the " + name + " leggings");
        protection[3] = config.getInt(name + "BootsProtection", "armor", protectionDefault[3], 0, 9000, "Protection of the " + name + " boots");
        int enchant = config.getInt(name + "Enchant", "armor", armorMatDefault.getEnchant(), 0, 9000, "Enchantability of " + name + " armor");
        return EnumHelper.addArmorMaterial(name.toUpperCase(), durability, protection, enchant);
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            init(path);
        }
    }
}
