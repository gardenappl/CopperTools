package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.CopperToolsMod;
import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {
    public static void init(){
        if (ConfigHandler.loadSaber){
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.woodSaber),
                "i",
                "i",
                "s", 'i', "logWood", 's', "stickWood"));
        }

        if(ConfigHandler.loadObsidianRod) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.obsidianRod, 4),
                 "o",
                 "o", 'o', "obsidian"));
        }

        if(ConfigHandler.loadCopper) registerRecipes("copper", "ingotCopper", false);
        if(ConfigHandler.loadPlatinum) registerRecipes("platinum", "ingotPlatinum", ConfigHandler.platinumRequiresObsidian);
        if(ConfigHandler.loadCompressed) registerRecipes("compressed", new ItemStack(GameRegistry.findItem("PneumaticCraft", "ingotIronCompressed")), false);
        if(ConfigHandler.loadLead) registerRecipes("lead", "ingotLead", false);
        if(ConfigHandler.loadEnderium) registerRecipes("enderium", "ingotEnderium", true);
        if(ConfigHandler.loadSilver) registerRecipes("silver", "ingotSilver", false);
        if(ConfigHandler.loadGemArmor){
            registerArmorRecipes("sapphire", "gemSapphire");
            registerArmorRecipes("ruby", "gemRuby");
            registerArmorRecipes("peridot", "gemPeridot");
            registerArmorRecipes("amethyst", "gemAmethyst");
        }
        if(ConfigHandler.loadBrassSickle) registerSickleRecipes("brass", "ingotBrass", false);
        if(ConfigHandler.loadGildedSickle && CopperToolsMod.isSteamPowerLoaded) registerSickleRecipes("gilded", new ItemStack(GameRegistry.findItem("Steamcraft", "ingot"), 1, 3), false);
    }

    //For tools that use the Ore Dictionary in their recipes
    private static void registerRecipes(String matName, String material, boolean useObsidian){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_pickaxe")),
                "iii",
                " s ",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_sword")),
                "i",
                "i",
                "s", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_axe")),
                "ii",
                "is",
                " s", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_axe")),
                "ii",
                "si",
                "s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_shovel")),
                "i",
                "s",
                "s", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_hoe")),
                "ii",
                "s ",
                "s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_hoe")),
                "ii",
                " s",
                " s", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));

        if(ConfigHandler.loadSickles) {
            registerSickleRecipes(matName, material, useObsidian);
        }

        registerArmorRecipes(matName, material);
    }

    //And again, but this time for specific ItemStacks as materials
    private static void registerRecipes(String matName, ItemStack material, boolean useObsidian){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_pickaxe")),
                "iii",
                " s ",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_sword")),
                "i",
                "i",
                "s", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_axe")),
                "ii",
                "is",
                " s", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_axe")),
                "ii",
                "si",
                "s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_shovel")),
                "i",
                "s",
                "s", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_hoe")),
                "ii",
                "s ",
                "s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_hoe")),
                "ii",
                " s",
                " s", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));

        if(ConfigHandler.loadSickles){
            registerSickleRecipes(matName, material, useObsidian);
        }

        registerArmorRecipes(matName, material);
    }

    private static void registerArmorRecipes(String matName, String material){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_helmet")),
                "iii",
                "i i", 'i', material));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_chestplate")),
                "i i",
                "iii",
                "iii", 'i', material));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_leggings")),
                "iii",
                "i i",
                "i i", 'i', material));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_boots")),
                "i i",
                "i i", 'i', material));
    }

    private static void registerArmorRecipes(String matName, ItemStack material){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_helmet")),
                "iii",
                "i i", 'i', material));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_chestplate")),
                "i i",
                "iii",
                "iii", 'i', material));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_leggings")),
                "iii",
                "i i",
                "i i", 'i', material));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_boots")),
                "i i",
                "i i", 'i', material));
    }

    private static void registerSickleRecipes(String matName, String material, boolean useObsidian) {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_sickle")),
                " i ",
                "  i",
                "si ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_sickle")),
                " i ",
                "i  ",
                " is", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));
    }

    private static void registerSickleRecipes(String matName, ItemStack material, boolean useObsidian){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_sickle")),
                " i ",
                "  i",
                "si ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_sickle")),
                " i ",
                "i  ",
                " is", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));
    }
}
