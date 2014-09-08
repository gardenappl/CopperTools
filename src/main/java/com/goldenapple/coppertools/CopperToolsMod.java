package com.goldenapple.coppertools;

import com.goldenapple.coppertools.handler.ConfigHandler;
import com.goldenapple.coppertools.init.ModItems;
import com.goldenapple.coppertools.init.Recipes;
import com.goldenapple.coppertools.util.LogHelper;
import com.goldenapple.coppertools.util.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid= Reference.MOD_ID,name=Reference.MOD_NAME,version=Reference.VERSION)
public class CopperToolsMod {

    @Mod.Instance(Reference.MOD_ID)
    public static CopperToolsMod instance;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        ConfigHandler.init(event.getSuggestedConfigurationFile());

        FMLCommonHandler.instance().bus().register(new ConfigHandler());

        ModItems.init();
        LogHelper.info("Pre-init complete!");
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        Recipes.init();
        LogHelper.info("Init complete!");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){
        LogHelper.info("Post-init complete!");
    }
}
