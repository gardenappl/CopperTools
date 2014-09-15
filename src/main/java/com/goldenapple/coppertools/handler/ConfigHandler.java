package com.goldenapple.coppertools.handler;

import com.goldenapple.coppertools.util.LogHelper;
import com.goldenapple.coppertools.util.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ConfigHandler {

    public static final int[] CopperToolMatDefault = {1, 131, 7, 2, 18};

    public static Configuration config;

    public static boolean loadSaber;

    public static boolean loadCopper;

    public static int durabliltyCopper;
    public static int levelCopper;
    public static float efficiencyCopper;
    public static float damageCopper;
    public static int enchantCopper;

    public static int durablilityCopperA;
    public static int protectionCopperHelmet;
    public static int protectionCopperChestplate;
    public static int protectionCopperLeggings;
    public static int protectionCopperBoots;
    public static int enchantCopperA;

    public static boolean loadPlatinum;

    public static int durabliltyPlatinum;
    public static int levelPlatinum;
    public static float efficiencyPlatinum;
    public static float damagePlatinum;
    public static int enchantPlatinum;

    public static int durablilityPlatinumA;
    public static int protectionPlatinumHelmet;
    public static int protectionPlatinumChestplate;
    public static int protectionPlatinumLeggings;
    public static int protectionPlatinumBoots;
    public static int enchantPlatinumA;

    public static boolean loadSteel;

    public static int durabliltySteel;
    public static int levelSteel;
    public static float efficiencySteel;
    public static float damageSteel;
    public static int enchantSteel;

    public static int durablilitySteelA;
    public static int protectionSteelHelmet;
    public static int protectionSteelChestplate;
    public static int protectionSteelLeggings;
    public static int protectionSteelBoots;
    public static int enchantSteelA;

    public static void init(File configFile)
    {
        if (config == null)
        {
            config = new Configuration(configFile);
            loadConfig();
        }else{
            loadConfig();
        }
    }

    private static void loadConfig()
    {
        loadSaber = config.getBoolean("loadSaber", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable the Wooden Saber");

        loadCopper = config.getBoolean("loadCopper", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable copper");

        levelCopper = config.getInt("levelCopper", "copper", CopperToolMatDefault[0], 0, 9000, "Mining level of copper tools (e.g. level 0 can mine coal, level 1 can mine iron)");
        durabliltyCopper = config.getInt("durabilityCopper", "copper", CopperToolMatDefault[1], 1, 9000, "Durability of copper tools");
        efficiencyCopper = config.getFloat("efficiencyCopper", "copper", CopperToolMatDefault[2], 0.1F, 9000, "Efficiency of copper tools");
        damageCopper = config.getFloat("damageCopper", "copper", CopperToolMatDefault[3], 0.0F, 9000, "Damage of copper tools");
        enchantCopper = config.getInt("enchantCopper", "copper", CopperToolMatDefault[4], 0, 9000, "Enchantibility of copper tools");

        durablilityCopperA = config.getInt("durabilityCopperA", "copper", 10, 1, 9000, "Durability of copper armor");
        protectionCopperHelmet = config.getInt("protectionCopperHelmet", "copper", 2, 0, 9000, "Protection of the Copper Helmet");
        protectionCopperChestplate = config.getInt("protectionCopperChestplate", "copper", 5, 0, 9000, "Protection of the Copper Chestplate");
        protectionCopperLeggings = config.getInt("protectionCopperLeggings", "copper", 4, 0, 9000, "Protection of the Copper Leggings");
        protectionCopperBoots = config.getInt("protectionCopperBoots", "copper", 2, 0, 9000, "Protection of the Copper Boots");
        enchantCopperA = config.getInt("enchantCopperA", "copper", 17, 0, 9000, "Enchantibility of copper armor");

        loadPlatinum = config.getBoolean("loadPlatinum", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable platinum");

        levelPlatinum = config.getInt("levelPlatinum", "platinum", 2, 0, 9000, "Mining level of platinum tools (e.g. level 0 can mine coal, level 1 can mine iron)");
        durabliltyPlatinum = config.getInt("durabilityPlatinum", "platinum", 200, 1, 9000, "Durability of platinum tools");
        efficiencyPlatinum = config.getFloat("efficiencyPlatinum", "platinum", 12, 0.1F, 9000, "Efficiency of platinum tools");
        damagePlatinum = config.getFloat("damagePlatinum", "platinum", 2, 0.0F, 9000, "Damage of platinum tools");
        enchantPlatinum = config.getInt("enchantPlatinum", "platinum", 22, 0, 9000, "Enchantibility of platinum tools");

        durablilityPlatinumA = config.getInt("durabilityPlatinumA", "platinum", 12, 1, 9000, "Durability of platinum armor");
        protectionPlatinumHelmet = config.getInt("protectionPlatinumHelmet", "platinum", 2, 0, 9000, "Protection of the Platinum Helmet");
        protectionPlatinumChestplate = config.getInt("protectionPlatinumChestplate", "platinum", 6, 0, 9000, "Protection of the Platinum Chestplate");
        protectionPlatinumLeggings = config.getInt("protectionPlatinumLeggings", "platinum", 5, 0, 9000, "Protection of the Platinum Leggings");
        protectionPlatinumBoots = config.getInt("protectionPlatinumBoots", "platinum", 2, 0, 9000, "Protection of the Platinum Boots");

        loadSteel = config.getBoolean("loadSteel", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable steel");

        levelSteel = config.getInt("levelSteel", "steel", 3, 0, 9000, "Mining level of steel tools (e.g. level 0 can mine coal, level 1 can mine iron)");
        durabliltySteel = config.getInt("durabilitySteel", "steel", 500, 1, 9000, "Durability of steel tools");
        efficiencySteel = config.getFloat("efficiencySteel", "steel", 7, 0.1F, 9000, "Efficiency of steel tools");
        damageSteel = config.getFloat("damageSteel", "steel", 3, 0.0F, 9000, "Damage of steel tools");
        enchantSteel = config.getInt("enchantSteel", "steel", 14, 0, 9000, "Enchantibility of steel tools");

        durablilitySteelA = config.getInt("durabilitySteelA", "steel", 30, 1, 9000, "Durability of steel armor");
        protectionSteelHelmet = config.getInt("protectionSteelHelmet", "steel", 3, 0, 9000, "Protection of the Steel Helmet");
        protectionSteelChestplate = config.getInt("protectionSteelChestplate", "steel", 7, 0, 9000, "Protection of the Steel Chestplate");
        protectionSteelLeggings = config.getInt("protectionSteelLeggings", "steel", 6, 0, 9000, "Protection of the Steel Leggings");
        protectionSteelBoots = config.getInt("protectionSteelBoots", "steel", 3, 0, 9000, "Protection of the Steel Boots");
        enchantSteelA = config.getInt("enchantSteelA", "steel", 9, 0, 9000, "Enchantibility of steel armor");

        if (config.hasChanged())
        {
            LogHelper.info("Config changed!");
            config.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfig();
        }
    }
}
