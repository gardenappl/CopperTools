package com.goldenapple.coppertools.handler;

import com.goldenapple.coppertools.util.LogHelper;
import com.goldenapple.coppertools.util.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ConfigHandler {

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

        levelCopper = config.getInt("levelCopper", "copper", 1, 0, 9000, "Mining level of copper tools (e.g. level 0 can mine coal, level 1 can mine iron)");
        durabliltyCopper = config.getInt("durabilityCopper", "copper", 131, 1, 9000, "Durability of copper tools");
        efficiencyCopper = config.getFloat("efficiencyCopper", "copper", 7, 0.1F, 9000, "Efficiency of copper tools");
        damageCopper = config.getFloat("damageCopper", "copper", 2, 0.0F, 9000, "Damage of copper tools");
        enchantCopper = config.getInt("enchantCopper", "copper", 18, 0, 9000, "Enchantibility of copper tools");

        durablilityCopperA = config.getInt("durabilityCopperA", "copper", 10, 1, 9000, "Durability of copper armor");
        protectionCopperHelmet = config.getInt("protectionCopperHelmet", "copper", 2, 0, 9000, "Protection of the Copper Helmet");
        protectionCopperChestplate = config.getInt("protectionCopperChestplate", "copper", 5, 0, 9000, "Protection of the Copper Chestplate");
        protectionCopperLeggings = config.getInt("protectionCopperLeggings", "copper", 4, 0, 9000, "Protection of the Copper Leggings");
        protectionCopperBoots = config.getInt("protectionCopperBoots", "copper", 2, 0, 9000, "Protection of Copper Boots");
        enchantCopperA = config.getInt("enchantCopperA", "copper", 17, 0, 9000, "Enchantibility of copper armor");

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
