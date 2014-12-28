package com.goldenapple.coppertools.config;

import com.goldenapple.coppertools.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

import java.io.File;

public class ConfigHandler {
    private static String configPath;

    private static Configuration configGeneral;
    private static Configuration configCopper;
    private static Configuration configPlatinum;
    private static Configuration configCompressed;
    private static Configuration configLead;
    private static Configuration configEnderium;
    private static Configuration configSilver;
    private static Configuration configHoliday;

    private static final String CATEGORY_SICKLES = "sickles";
    private static final String CATEGORY_SETS = "sets";

    public static boolean loadCopper;
    public static boolean loadPlatinum;
    public static boolean loadCompressed;
    public static boolean loadLead;
    public static boolean loadEnderium;
    public static boolean loadSilver;

    public static boolean loadHoliday;
    public static boolean loadSaber;
    public static boolean loadObsidianRod;
    public static boolean loadGemArmor;

    public static boolean holidaySpiritLivesForever;
    public static boolean platinumRequiresObsidian;
    public static boolean dumpAllOres;
    public static int chanceOfGoodChristmas;

    public static boolean loadSickles;
    public static boolean loadVanillaSickles;
    public static boolean loadThaumiumSickle;
    public static boolean loadBrassSickle;
    public static boolean loadGildedSickle;

    public static void init(String path){
        configPath = path;

        if (configGeneral == null){
            configGeneral = new Configuration(new File(path + "general.cfg"));
        }
        loadGeneral();

        if (configCopper == null){
            configCopper = new Configuration(new File(path + "copper.cfg"));
        }
        ModToolMaterial.COPPER = loadProperty(configCopper, "copper", ModToolMaterial.Default.COPPER);
        ModArmorMaterial.COPPER = loadProperty(configCopper, "copper", ModArmorMaterial.Default.COPPER);
        if(configCopper.hasChanged()){
            configCopper.save();
        }

        if (configPlatinum == null){
            configPlatinum = new Configuration(new File(path + "platinum.cfg"));
        }
        ModToolMaterial.PLATINUM = loadProperty(configPlatinum, "platinum", ModToolMaterial.Default.PLATINUM);
        ModArmorMaterial.PLATINUM = loadProperty(configPlatinum, "platinum", ModArmorMaterial.Default.PLATINUM);
        if(configPlatinum.hasChanged()){
            configPlatinum.save();
        }

        if (configCompressed == null){
            configCompressed = new Configuration(new File(path + "compressed.cfg"));
        }
        ModToolMaterial.COMPRESSED = loadProperty(configCompressed, "compressed", ModToolMaterial.Default.COMPRESSED);
        ModArmorMaterial.COMPRESSED = loadProperty(configCompressed, "compressed", ModArmorMaterial.Default.COMPRESSED);
        if(configCompressed.hasChanged()){
            configCompressed.save();
        }

        if (configLead == null){
            configLead = new Configuration(new File(path + "lead.cfg"));
        }
        ModToolMaterial.LEAD = loadProperty(configLead, "lead", ModToolMaterial.Default.LEAD);
        ModArmorMaterial.LEAD = loadProperty(configLead, "lead", ModArmorMaterial.Default.LEAD);
        if(configLead.hasChanged()){
            configLead.save();
        }

        if (configEnderium == null){
            configEnderium = new Configuration(new File(path + "enderium.cfg"));
        }
        ModToolMaterial.ENDERIUM = loadProperty(configEnderium, "enderium", ModToolMaterial.Default.ENDERIUM);
        ModArmorMaterial.ENDERIUM = loadProperty(configEnderium, "enderium", ModArmorMaterial.Default.ENDERIUM);
        if(configEnderium.hasChanged()){
            configEnderium.save();
        }

        if (configSilver == null){
            configSilver = new Configuration(new File(path + "silver.cfg"));
        }
        ModToolMaterial.SILVER = loadProperty(configSilver, "silver", ModToolMaterial.Default.SILVER);
        ModArmorMaterial.SILVER = loadProperty(configSilver, "silver", ModArmorMaterial.Default.SILVER);
        if(configSilver.hasChanged()){
            configSilver.save();
        }

        if(configHoliday == null){
            configHoliday = new Configuration(new File(path + "holiday.cfg"));
        }
        ModToolMaterial.HOLIDAY = loadProperty(configHoliday, "holiday", ModToolMaterial.Default.HOLIDAY);
        ModArmorMaterial.HOLIDAY = loadProperty(configHoliday, "holiday", ModArmorMaterial.Default.HOLIDAY);
        if(configHoliday.hasChanged()){
            configHoliday.save();
        }
    }

    private static void loadGeneral(){
        if(configGeneral == null){
            configGeneral = new Configuration(new File(configPath + "general.cfg"));
        }

        loadCopper = configGeneral.getBoolean("loadCopper", CATEGORY_SETS, true, "Set this to false to disable copper tools & armor");
        loadPlatinum = configGeneral.getBoolean("loadPlatinum", CATEGORY_SETS, true, "Set this to false to disable platinum tools & armor");
        loadCompressed = configGeneral.getBoolean("loadCompressed", CATEGORY_SETS, true, "Set this to false to disable tools & armor out of compressed iron");
        loadLead = configGeneral.getBoolean("loadLead", CATEGORY_SETS, true, "Set this to false to disable lead tools & armor");
        loadSilver = configGeneral.getBoolean("loadSilver", CATEGORY_SETS, true, "Set this to false to disable silver tools & armor");
        loadEnderium = configGeneral.getBoolean("loadEnderium", CATEGORY_SETS, true, "Set this to false to disable enderium tools & armor");
        loadGemArmor = configGeneral.getBoolean("loadGemArmor", CATEGORY_SETS, true, "Set this to false to disable gem armor");

        chanceOfGoodChristmas = configGeneral.getInt("chanceOfGoodChristmas", Configuration.CATEGORY_GENERAL, 50, 1, 9000, "1 in X chance that a hostile mob will drop a piece of Christmas equipment");
        loadHoliday = configGeneral.getBoolean("loadHoliday", Configuration.CATEGORY_GENERAL, true, "Set this to false if you hate Christmas, you bastard! >:(");
        loadSaber = configGeneral.getBoolean("loadSaber", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable the Wooden Saber");
        loadObsidianRod = configGeneral.getBoolean("loadObsidianRod", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable the Obsidian Rod");
        holidaySpiritLivesForever = configGeneral.getBoolean("holidaySpiritLivesForever", Configuration.CATEGORY_GENERAL, false, "Set this to true if you love Christmas so much that you want to celebrate it forever!");
        platinumRequiresObsidian = configGeneral.getBoolean("platinumRequiresObsidian", Configuration.CATEGORY_GENERAL, true, "Set this to false to allow crafting platinum tools with regular sticks");
        dumpAllOres = configGeneral.getBoolean("dumpAllOres", Configuration.CATEGORY_GENERAL, false, "Set this to true to log every single OreDictionary ore");

        loadSickles = configGeneral.getBoolean("loadSickles", CATEGORY_SICKLES, true, "Set this to false to disable sickles (will override all other options)");
        loadVanillaSickles = configGeneral.getBoolean("loadVanillaSickles", CATEGORY_SICKLES, false, "Set this to true to enable sickles made out of vanilla materials (e.g. wood or iron)");
        loadThaumiumSickle = configGeneral.getBoolean("loadThaumiumSickle", CATEGORY_SICKLES, true, "Set this to false to disable the Thaumium Sickle");
        loadBrassSickle = configGeneral.getBoolean("loadBrassSickle", CATEGORY_SICKLES, true, "Set this to false to disable the Brass Sickle");
        loadGildedSickle = configGeneral.getBoolean("loadGildedSickle", CATEGORY_SICKLES, true, "Set this to false to disable the Gilded Iron Sickle");

        if (configGeneral.hasChanged()){
            configGeneral.save();
        }
    }

    private static Item.ToolMaterial loadProperty(Configuration config, String name, ModToolMaterial.Default toolMatDefault){
        int harvestLevel = config.getInt(name + "Level", "tools", toolMatDefault.getHarvestLevel(), 0, 9000, "Mining level of " + name + " tools");
        int durability = config.getInt(name + "Durability", "tools", toolMatDefault.getDurability(), 0, 9000, "Durability of " + name + " tools");
        float efficiency = config.getFloat(name + "Efficiency", "tools", toolMatDefault.getEfficiency(), 0, 9000, "Efficiency of " + name + " tools");
        float damage = config.getFloat(name + "Damage", "tools", toolMatDefault.getDamage(), 0, 9000, "Damage of " + name + " tools");
        int enchant = config.getInt(name + "Enchant", "tools", toolMatDefault.getEnchant(), 0, 9000, "Enchantability of " + name + " tools");
        return EnumHelper.addToolMaterial(name.toUpperCase(), harvestLevel, durability, efficiency, damage, enchant);
    }

    private static ItemArmor.ArmorMaterial loadProperty(Configuration config, String name, ModArmorMaterial.Default armorMatDefault){
        int durability = config.getInt(name + "Durability", "armor", armorMatDefault.getDurability(), 0, 9000, "Durability level of " + name + " armor");
        int[] protection = new int[4];
        int[] protectionDefault = armorMatDefault.getProtection();
        protection[0]  = config.getInt(name + "HelmetProtection", "armor", protectionDefault[0], 0, 9000, "Protection of the " + name + " helmet");
        protection[1] = config.getInt(name + "ChestProtection", "armor", protectionDefault[1], 0, 9000, "Protection of the " + name + " chestplate");
        protection[2] = config.getInt(name + "LegsProtection", "armor", protectionDefault[2], 0, 9000, "Protection of " + name + " leggings");
        protection[3] = config.getInt(name + "BootsProtection", "armor", protectionDefault[3], 0, 9000, "Protection of " + name + " boots");
        int enchant = config.getInt(name + "Enchant", "armor", armorMatDefault.getEnchant(), 0, 9000, "Enchantability of " + name + " armor");
        return EnumHelper.addArmorMaterial(name.toUpperCase(), durability, protection, enchant);
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            init(configPath);
        }
    }
}
