package com.goldenapple.coppertools;

import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.handler.ChristmasEventHandler;
import com.goldenapple.coppertools.init.ModItems;
import com.goldenapple.coppertools.init.Recipes;
import com.goldenapple.coppertools.util.LogHelper;
import com.goldenapple.coppertools.reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class CopperTools {
    @Mod.Instance(Reference.MOD_ID)
    public static CopperTools instance;

    public static boolean isThaumcraftLoaded;
    public static boolean isSteamPowerLoaded;
    public static boolean isBotaniaLoaded;
    public static boolean isProjRedLoaded;
    public static boolean isBluePowerLoaded;
    public static boolean isTwilightLoaded;
    public static boolean isPneumaticLoaded;
    public static boolean isTELoaded;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        ConfigHandler.init(event.getModConfigurationDirectory() + "/coppertools/");
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        CopperToolsCreativeTab.init();

        isThaumcraftLoaded = Loader.isModLoaded("Thaumcraft");
        isSteamPowerLoaded = Loader.isModLoaded("Steamcraft");
        isBotaniaLoaded = Loader.isModLoaded("Botania");
        isProjRedLoaded = Loader.isModLoaded("ProjRed|Exploration");
        isBluePowerLoaded = Loader.isModLoaded("bluepower");
        isTwilightLoaded = Loader.isModLoaded("TwilightForest");
        isPneumaticLoaded = Loader.isModLoaded("PneumaticCraft");
        isTELoaded = Loader.isModLoaded("ThermalFoundation");

        if(ChristmasEventHandler.isChristmas()) LogHelper.info("It's the holiday season! Now go kill some zombies to get Santa's Armor! In the name of Christmas!");

        ModItems.init();

        LogHelper.info("Pre-init complete!");
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        Recipes.init();

        MinecraftForge.EVENT_BUS.register(new ChristmasEventHandler());

        LogHelper.info("Init complete!");
    }
}
