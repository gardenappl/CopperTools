package com.goldenapple.coppertools.handler;

import com.goldenapple.coppertools.CopperToolsMod;
import com.goldenapple.coppertools.util.LogHelper;
import com.goldenapple.coppertools.util.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class GeneralConfigHandler {
    public static Configuration config;
    public static final String folder = CopperToolsMod.root + "/coppertools/";

    public static boolean loadSaber;
    public static boolean loadCopper;
    public static boolean loadPlatinum;

    public static void init(){
        if (config == null) {
            config = new Configuration(new File(folder + "general.cfg"));
            loadConfig();
        }
    }
    public static void loadConfig(){
        loadSaber = config.getBoolean("loadSaber", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable the Wooden Saber");
        loadCopper = config.getBoolean("loadCopper", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable copper tools & armor");
        loadPlatinum = config.getBoolean("loadPlatinum", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable platinum tools & armor");
        if (config.hasChanged())
        {
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
