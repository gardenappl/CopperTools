package com.goldenapple.coppertools;

import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.init.ModItems;
import com.goldenapple.coppertools.init.Recipes;
import com.goldenapple.coppertools.reference.Reference;
import com.goldenapple.coppertools.util.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY)
public class CopperTools {
    @Mod.Instance(Reference.MOD_ID)
    public static CopperTools instance;

    public static boolean isThaumcraftLoaded;
    public static boolean isSteamPowerLoaded;
    public static boolean isBotaniaLoaded;
    public static boolean isBluePowerLoaded;
    public static boolean isTwilightLoaded;
    public static boolean isPneumaticLoaded;
    public static boolean isTELoaded;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        EquipMaterial.init();
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        CopperToolsCreativeTab.init();

        isThaumcraftLoaded = Loader.isModLoaded("Thaumcraft");
        isSteamPowerLoaded = Loader.isModLoaded("Steamcraft");
        isBotaniaLoaded = Loader.isModLoaded("Botania");
        isBluePowerLoaded = Loader.isModLoaded("bluepower");
        isTwilightLoaded = Loader.isModLoaded("TwilightForest");
        isPneumaticLoaded = Loader.isModLoaded("PneumaticCraft");
        isTELoaded = Loader.isModLoaded("ThermalFoundation");

        ModItems.init();

        LogHelper.info("Pre-init complete!");
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        Recipes.init();

        LogHelper.info("Init complete!");
    }
}
