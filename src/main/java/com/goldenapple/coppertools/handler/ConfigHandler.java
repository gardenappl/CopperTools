package com.goldenapple.coppertools.handler;

import com.goldenapple.coppertools.util.LogHelper;
import com.goldenapple.coppertools.util.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ConfigHandler {

    public static Configuration config;

    public static boolean loadCopper;
    public static boolean loadSaber;

    public static void init(File configFile)
    {
        if (config == null)
        {
            config = new Configuration(configFile);
            loadConfig();
        }
    }

    private static void loadConfig()
    {
        loadCopper = config.getBoolean("loadCopper", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable copper");
        loadSaber = config.getBoolean("loadSaber", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable the Wooden Saber");

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
