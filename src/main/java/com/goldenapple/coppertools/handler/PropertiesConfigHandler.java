package com.goldenapple.coppertools.handler;

import com.goldenapple.coppertools.CopperToolsMod;
import com.goldenapple.coppertools.util.LogHelper;
import com.goldenapple.coppertools.util.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class PropertiesConfigHandler {

    public static final int[] CopperToolMatDefault = {1, 131, 7, 2, 18};
    public static final int[] CopperArmorMatDefault = {10, 2, 5, 4, 2, 17};
    public static final int[] PlatinumToolMatDefault = {2, 200, 12, 2, 22};
    public static final int[] PlatinumArmorMatDefault = {12, 2, 6, 5, 2};

    public static Configuration config;

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

    public static final String folder = CopperToolsMod.root + "/coppertools/";

    public static void init()
    {
        if (config == null) {
            config = new Configuration(new File(folder + "properties.cfg"));
            loadConfig();
        }
    }

    private static void loadConfig()
    {
        levelCopper = config.getInt("levelCopper", "copper", CopperToolMatDefault[0], 0, 9000, "Mining level of copper tools (e.g. level 0 can mine coal, level 1 can mine iron)");
        durabliltyCopper = config.getInt("durabilityCopper", "copper", CopperToolMatDefault[1], 1, 9000, "Durability of copper tools");
        efficiencyCopper = config.getFloat("efficiencyCopper", "copper", CopperToolMatDefault[2], 0.1F, 9000, "Efficiency of copper tools");
        damageCopper = config.getFloat("damageCopper", "copper", CopperToolMatDefault[3], 0.0F, 9000, "Damage of copper tools");
        enchantCopper = config.getInt("enchantCopper", "copper", CopperToolMatDefault[4], 0, 9000, "Enchantibility of copper tools");

        durablilityCopperA = config.getInt("durabilityCopperA", "copper", CopperArmorMatDefault[0], 1, 9000, "Durability of copper armor");
        protectionCopperHelmet = config.getInt("protectionCopperHelmet", "copper", CopperArmorMatDefault[1], 0, 9000, "Protection of the Copper Helmet");
        protectionCopperChestplate = config.getInt("protectionCopperChestplate", "copper", CopperArmorMatDefault[2], 0, 9000, "Protection of the Copper Chestplate");
        protectionCopperLeggings = config.getInt("protectionCopperLeggings", "copper", CopperArmorMatDefault[3], 0, 9000, "Protection of the Copper Leggings");
        protectionCopperBoots = config.getInt("protectionCopperBoots", "copper", CopperArmorMatDefault[4], 0, 9000, "Protection of the Copper Boots");
        enchantCopperA = config.getInt("enchantCopperA", "copper", CopperArmorMatDefault[5], 0, 9000, "Enchantibility of copper armor");

        levelPlatinum = config.getInt("levelPlatinum", "platinum", PlatinumToolMatDefault[0], 0, 9000, "Mining level of platinum tools (e.g. level 0 can mine coal, level 1 can mine iron)");
        durabliltyPlatinum = config.getInt("durabilityPlatinum", "platinum", PlatinumToolMatDefault[1], 1, 9000, "Durability of platinum tools");
        efficiencyPlatinum = config.getFloat("efficiencyPlatinum", "platinum", PlatinumToolMatDefault[2], 0.1F, 9000, "Efficiency of platinum tools");
        damagePlatinum = config.getFloat("damagePlatinum", "platinum", PlatinumToolMatDefault[3], 0.0F, 9000, "Damage of platinum tools");
        enchantPlatinum = config.getInt("enchantPlatinum", "platinum", PlatinumToolMatDefault[4], 0, 9000, "Enchantibility of platinum tools");

        durablilityPlatinumA = config.getInt("durabilityPlatinumA", "platinum", PlatinumArmorMatDefault[0], 1, 9000, "Durability of platinum armor");
        protectionPlatinumHelmet = config.getInt("protectionPlatinumHelmet", "platinum", PlatinumArmorMatDefault[1], 0, 9000, "Protection of the Platinum Helmet");
        protectionPlatinumChestplate = config.getInt("protectionPlatinumChestplate", "platinum", PlatinumArmorMatDefault[2], 0, 9000, "Protection of the Platinum Chestplate");
        protectionPlatinumLeggings = config.getInt("protectionPlatinumLeggings", "platinum", PlatinumArmorMatDefault[3], 0, 9000, "Protection of the Platinum Leggings");
        protectionPlatinumBoots = config.getInt("protectionPlatinumBoots", "platinum", PlatinumArmorMatDefault[4], 0, 9000, "Protection of the Platinum Boots");

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
