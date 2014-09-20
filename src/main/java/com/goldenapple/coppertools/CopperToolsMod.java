package com.goldenapple.coppertools;

import com.goldenapple.coppertools.handler.GeneralConfigHandler;
import com.goldenapple.coppertools.handler.PropertiesConfigHandler;
import com.goldenapple.coppertools.init.ModItems;
import com.goldenapple.coppertools.init.Recipes;
import com.goldenapple.coppertools.util.LogHelper;
import com.goldenapple.coppertools.util.OreHelper;
import com.goldenapple.coppertools.util.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(modid= Reference.MOD_ID,name=Reference.MOD_NAME,version=Reference.VERSION)
public class CopperToolsMod {

    @Mod.Instance(Reference.MOD_ID)
    public static CopperToolsMod instance;

    public static File root;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        root = event.getModConfigurationDirectory();
        PropertiesConfigHandler.init();
        GeneralConfigHandler.init();

        FMLCommonHandler.instance().bus().register(new PropertiesConfigHandler());
        FMLCommonHandler.instance().bus().register(new GeneralConfigHandler());

        ModItems.init();
        LogHelper.info("Pre-init complete!");
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        Recipes.init();
        OreHelper.dumpAllOres();
        LogHelper.info("Init complete!");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){
        LogHelper.info("Post-init complete!");
    }
}
