package com.goldenapple.coppertools;

import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.init.ModItems;
import com.goldenapple.coppertools.init.Recipes;
import com.goldenapple.coppertools.util.LogHelper;
import com.goldenapple.coppertools.util.OreHelper;
import com.goldenapple.coppertools.Reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid= Reference.MOD_ID,name=Reference.MOD_NAME,version=Reference.VERSION)
public class CopperToolsMod {
    @Mod.Instance(Reference.MOD_ID)
    public static CopperToolsMod instance;

    public static boolean isThaumcraftLoaded;
    public static boolean isSteamPowerLoaded;
    public static boolean isBotaniaLoaded;
    public static boolean isProjRedLoaded;
    public static boolean isBluePowerLoaded;
    public static boolean isTwilightLoaded;
    public static boolean isPneumaticLoaded;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        ConfigHandler.init(event.getModConfigurationDirectory() + "/coppertools/");
        FMLCommonHandler.instance().bus().register(new ConfigHandler());

        isThaumcraftLoaded = Loader.isModLoaded("Thaumcraft");
        isSteamPowerLoaded = Loader.isModLoaded("Steamcraft");
        isBotaniaLoaded = Loader.isModLoaded("Botania");
        isProjRedLoaded = Loader.isModLoaded("ProjRed|Exploration");
        isBluePowerLoaded = Loader.isModLoaded("bluepower");
        isTwilightLoaded = Loader.isModLoaded("TwilightForest");
        isPneumaticLoaded = Loader.isModLoaded("PneumaticCraft");

        ModItems.init();

        LogHelper.info("Pre-init complete!");
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        Recipes.init();

        if (ConfigHandler.dumpAllOres) {
            OreHelper.dumpAllOres();
        }

        LogHelper.info("Init complete!");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){
        LogHelper.info("Post-init complete!");
    }
}
