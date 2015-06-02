package com.goldenapple.coppertools.config;

import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

import java.io.File;

public class ConfigHandler {
    public static Configuration config;

    public static final String CATEGORY_SICKLES = "sickles";

    public static boolean loadSaber;
    public static boolean loadObsidianRod;

    public static int creativeTabs;
    public static boolean changePneumaticHelmetRecipe;

    public static boolean loadSickles;
    public static boolean loadVanillaSickles;
    public static boolean loadThaumiumSickle;
    public static boolean loadVoidSickle;
    public static boolean loadBrassSickle;
    public static boolean loadGildedSickle;
    public static boolean loadManasteelSickle;
    public static boolean loadElementiumSickle;
    public static boolean loadSteeleafSickle;
    public static boolean loadIronwoodSickle;

    public static void init(File file){
        if (config == null){
            config = new Configuration(file);
        }
        load();
    }

    private static void load(){
        /* EquipMaterial.wood.load = config.getBoolean("loadCopper", CATEGORY_SETS, true, "Set this to false to disable copper tools & armor");
        EquipMaterial.platinum.load = config.getBoolean("loadPlatinum", CATEGORY_SETS, true, "Set this to false to disable platinum tools & armor");
        EquipMaterial.compressed.load = config.getBoolean("loadCompressed", CATEGORY_SETS, true, "Set this to false to disable tools & armor out of compressed iron");
        EquipMaterial.lead.load = config.getBoolean("loadLead", CATEGORY_SETS, true, "Set this to false to disable lead tools & armor");
        EquipMaterial.silver.load = config.getBoolean("loadSilver", CATEGORY_SETS, true, "Set this to false to disable silver tools & armor");
        EquipMaterial.enderium.load = config.getBoolean("loadEnderium", CATEGORY_SETS, true, "Set this to false to disable enderium tools & armor");
        EquipMaterial.emerald.load = config.getBoolean("loadEmerald", CATEGORY_SETS, true, "Set this to false to disable emerald tools & armor");
        EquipMaterial.gem.load = config.getBoolean("loadGemArmor", CATEGORY_SETS, true, "Set this to false to disable gem armor");
        EquipMaterial.holiday.load = config.getBoolean("loadHoliday", CATEGORY_SETS, true, "Set this to false if you hate Christmas, you soulless bastard! >:("); */

        loadSaber = config.getBoolean("Enable Wood Saber", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable the Wooden Saber");
        loadObsidianRod = config.getBoolean("Enable Obsidian Rod", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable the Obsidian Rod");
        EquipMaterial.platinum.useObsidian = config.getBoolean("Platinum Requires Obsidian", Configuration.CATEGORY_GENERAL, true, "Set this to false to allow crafting platinum tools with regular sticks");
        EquipMaterial.emerald.useObsidian = config.getBoolean("Emerald Requires Obsidian", Configuration.CATEGORY_GENERAL, true, "Set this to false to allow crafting emerald tools with regular sticks");
        creativeTabs = config.getInt("Creative Tabs", Configuration.CATEGORY_GENERAL, 2, 0, 2, "Set this to 0 to disable Creative Tabs, items will be registered in Vanilla tabs. Set this to 1 to have one giant tab. Set this to 2 to have separate Tools & Combat tabs");
        changePneumaticHelmetRecipe = config.getBoolean("Change Pneumatic Helmet recipe", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable the Pneumatic Helmet recipe override (it won't require a Compressed Iron Helmet)");

        loadSickles = config.getBoolean("Enable Sickles", CATEGORY_SICKLES, true, "Set this to false to disable sickles (will override all other options)");
        loadVanillaSickles = config.getBoolean("Enable Vanilla Sickles", CATEGORY_SICKLES, false, "Set this to true to enable sickles made out of vanilla materials (e.g. wood or iron)");
        loadThaumiumSickle = config.getBoolean("Enable Thaumium Sickle", CATEGORY_SICKLES, true, "Set this to false to disable the Thaumium Sickle for Thuamcraft");
        loadVoidSickle = config.getBoolean("Enable Voidmetal Sickle", CATEGORY_SICKLES, true, "Set this to false to disable the Voidmetal Sickle for Thaumcraft");
        loadBrassSickle = config.getBoolean("Enable Brass Sickle", CATEGORY_SICKLES, true, "Set this to false to disable the Brass Sickle for Flaxbeard's Steam Power");
        loadGildedSickle = config.getBoolean("Enable Gilded Iron Sickle", CATEGORY_SICKLES, true, "Set this to false to disable the Gilded Iron Sickle for Flaxbeard's Steam Power");
        loadManasteelSickle = config.getBoolean("Enable Manastel Sickle", CATEGORY_SICKLES, true, "Set this to false to disable the Manasteel Sickle for Botania");
        loadElementiumSickle = config.getBoolean("Enable Elementium Sickle", CATEGORY_SICKLES, true, "Set this to false to disable the Elementium Sickle for Botania");
        loadIronwoodSickle = config.getBoolean("Enable Ironwood Sickle", CATEGORY_SICKLES, true, "Set this to false to disable the Ironwood Sickle for Twilight Forest");
        loadSteeleafSickle = config.getBoolean("Enable Steeleaf Sickle", CATEGORY_SICKLES, true, "Set this to false to disable the Steeleaf Sickle for Twilight Forest");

        for(EquipMaterial material : EquipMaterial.registry){
            loadProperty(material);
        }
        /* ModToolMaterial.COPPER = loadProperty(CATEGORY_COPPER, ModToolMaterial.Default.COPPER);
        ModArmorMaterial.COPPER = loadProperty(CATEGORY_COPPER, ModArmorMaterial.Default.COPPER);

        ModToolMaterial.PLATINUM = loadProperty(CATEGORY_PLATINUM, ModToolMaterial.Default.PLATINUM);
        ModArmorMaterial.PLATINUM = loadProperty(CATEGORY_PLATINUM, ModArmorMaterial.Default.PLATINUM);

        ModToolMaterial.COMPRESSED = loadProperty(CATEGORY_COMPRESSED, ModToolMaterial.Default.COMPRESSED);
        ModArmorMaterial.COMPRESSED = loadProperty(CATEGORY_COMPRESSED, ModArmorMaterial.Default.COMPRESSED);

        ModToolMaterial.LEAD = loadProperty(CATEGORY_LEAD, ModToolMaterial.Default.LEAD);
        ModArmorMaterial.LEAD = loadProperty(CATEGORY_LEAD, ModArmorMaterial.Default.LEAD);

        ModToolMaterial.ENDERIUM = loadProperty(CATEGORY_ENDERIUM, ModToolMaterial.Default.ENDERIUM);
        ModArmorMaterial.ENDERIUM = loadProperty(CATEGORY_ENDERIUM, ModArmorMaterial.Default.ENDERIUM);

        ModToolMaterial.SILVER = loadProperty(CATEGORY_SILVER, ModToolMaterial.Default.SILVER);
        ModArmorMaterial.SILVER = loadProperty(CATEGORY_SILVER, ModArmorMaterial.Default.SILVER);

        ModToolMaterial.HOLIDAY = loadProperty(CATEGORY_HOLIDAY, ModToolMaterial.Default.HOLIDAY);
        ModArmorMaterial.HOLIDAY = loadProperty(CATEGORY_HOLIDAY, ModArmorMaterial.Default.HOLIDAY);

        ModToolMaterial.EMERALD = loadProperty(CATEGORY_EMERALD, ModToolMaterial.Default.EMERALD);
        ModArmorMaterial.EMERALD = loadProperty(CATEGORY_EMERALD, ModArmorMaterial.Default.EMERALD); */

        if (config.hasChanged()){
            config.save();
        }
    }

    private static void loadProperty(EquipMaterial material){
        material.enabled = config.getBoolean("Enable", material.name, material.enabled, "Set this to false to disable this equipment");
        if(material.toolMat == null && material.toolMatDefault != null){
            loadToolProperty(material);
        }
        if(material.armorMat == null && material.armorMatDefault != null){
            loadArmorProperty(material);
        }
    }

    private static void loadToolProperty(EquipMaterial material){
        int harvestLevel = config.getInt("Harvest Level", material.name, material.toolMatDefault.getHarvestLevel(), 0, 9000, "Harvest level of these tools (0 = wood pick, 3 = diamond pick");
        int durability = config.getInt("Tool Durability", material.name, material.toolMatDefault.getDurability(), 0, 9000, "Durability of these tools");
        float efficiency = config.getFloat("Efficiency", material.name, material.toolMatDefault.getEfficiency(), 0, 9000, "Efficiency of these tools");
        float damage = config.getFloat("Damage", material.name, material.toolMatDefault.getDamage(), 0, 9000, "Damage that these tools do to mobs");
        int enchant = config.getInt("Enchant", material.name, material.toolMatDefault.getEnchant(), 0, 9000, "Enchantability of these tools");
        material.toolMat = EnumHelper.addToolMaterial(material.name.toUpperCase(), harvestLevel, durability, efficiency, damage, enchant);
    }

    private static void loadArmorProperty(EquipMaterial material){
        int[] protection = new int[4];
        int[] protectionDefault = material.armorMatDefault.getProtection();
        int durability = config.getInt("Armor Durability", material.name, material.armorMatDefault.getDurability(), 0, 9000, "Durability level of this armor");
        protection[0]  = config.getInt("Helmet Protection", material.name, protectionDefault[0], 0, 9000, "Protection of this helmet");
        protection[1] = config.getInt("Chest Protection", material.name, protectionDefault[1], 0, 9000, "Protection of this chestplate");
        protection[2] = config.getInt("Legs Protection", material.name, protectionDefault[2], 0, 9000, "Protection of these leggings");
        protection[3] = config.getInt("Boots Protection", material.name, protectionDefault[3], 0, 9000, "Protection of these boots");
        int enchant = config.getInt("Enchantability", material.name, material.armorMatDefault.getEnchant(), 0, 9000, "Enchantability of this armor");
        material.armorMat = EnumHelper.addArmorMaterial(material.name.toUpperCase(), durability, protection, enchant);
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            load();
        }
    }
}
