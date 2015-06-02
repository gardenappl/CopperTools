package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.CopperTools;
import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.reference.Names;
import com.goldenapple.coppertools.reference.Reference;
import com.goldenapple.coppertools.util.MiscHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {
    public static void init(){
        if (ConfigHandler.loadSaber){
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, Names.WOOD_KATANA)),
                "i",
                "i",
                "s", 'i', "logWood", 's', "stickWood"));
        }

        if(ConfigHandler.loadObsidianRod) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.obsidianRod, 4),
                 "o",
                 "o", 'o', "obsidian"));
        }

        if(ConfigHandler.loadObsidianRod) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.obsidianRod, 4),
                    "o",
                    "o", 'o', Blocks.obsidian));
        }

        registerRecipes(EquipMaterial.copper);
        registerRecipes(EquipMaterial.platinum);
        registerRecipes(EquipMaterial.lead);
        registerRecipes(EquipMaterial.silver);
        registerRecipes(EquipMaterial.emerald);

        if(CopperTools.isPneumaticLoaded) registerRecipes(EquipMaterial.compressed);
        if(CopperTools.isTELoaded) registerRecipes(EquipMaterial.enderium);
        if(CopperTools.isBluePowerLoaded){
            registerRecipes(EquipMaterial.ruby);
            registerRecipes(EquipMaterial.sapphire);
            registerRecipes(EquipMaterial.amethyst);
        }

        if(ConfigHandler.loadSickles) {
            if(ConfigHandler.loadVanillaSickles){
                registerSickleRecipes("wood", "plankWood", false);
                registerSickleRecipes("stone", "cobblestone", false);
                registerSickleRecipes("iron", "ingotIron", false);
                registerSickleRecipes("diamond", "gemDiamond", false);
                registerSickleRecipes("gold", "ingotGold", false);
            }
            if(ConfigHandler.loadBrassSickle) registerSickleRecipes("brass", "ingotBrass", false);
            if(ConfigHandler.loadGildedSickle && CopperTools.isSteamPowerLoaded) registerSickleRecipes("gilded", new ItemStack(GameRegistry.findItem("Steamcraft", "steamcraftIngot"), 1, 3), false);
            if(ConfigHandler.loadThaumiumSickle && CopperTools.isThaumcraftLoaded) registerSickleRecipes("thaumium", "ingotThaumium", false);
            if(ConfigHandler.loadVoidSickle && CopperTools.isThaumcraftLoaded) registerSickleRecipes("void", "ingotVoid", false);
            if(ConfigHandler.loadManasteelSickle && CopperTools.isBotaniaLoaded) GameRegistry.addRecipe(new ShapedOreRecipe(GameRegistry.findItem(Reference.MOD_ID, "manasteel_sickle"),
                    " i ",
                    "  i",
                    "si ", 'i', "ingotManasteel", 's', "livingwoodTwig").setMirrored(true));
            if(ConfigHandler.loadElementiumSickle && CopperTools.isBotaniaLoaded) GameRegistry.addRecipe(new ShapedOreRecipe(GameRegistry.findItem(Reference.MOD_ID, "elementium_sickle"),
                    " i ",
                    "  i",
                    "si ", 'i', "ingotElvenElementium", 's', "dreamwoodTwig").setMirrored(true));

            ItemStack ironwoodSickle = new ItemStack(GameRegistry.findItem(Reference.MOD_ID, "ironwood_sickle"));
            ironwoodSickle.addEnchantment(Enchantment.unbreaking, 1);
            if(ConfigHandler.loadIronwoodSickle && CopperTools.isTwilightLoaded) GameRegistry.addRecipe(new ShapedOreRecipe(ironwoodSickle,
                    " i ",
                    "  i",
                    "si ", 'i', "ironwood", 's', "stickWood").setMirrored(true));

            ItemStack steeleafSickle = new ItemStack(GameRegistry.findItem(Reference.MOD_ID, "steeleaf_sickle"));
            steeleafSickle.addEnchantment(Enchantment.unbreaking, 2);
            if(ConfigHandler.loadSteeleafSickle && CopperTools.isTwilightLoaded) GameRegistry.addRecipe(new ShapedOreRecipe(steeleafSickle,
                    " i ",
                    "  i",
                    "si ", 'i', "steeleaf", 's', "stickWood").setMirrored(true));
        }
    }

    public static void postInit(){
        if(ConfigHandler.changePneumaticHelmetRecipe && EquipMaterial.compressed.enabled){
            ItemStack airCanister = new ItemStack(GameRegistry.findItem("PneumaticCraft", "airCanister"));
            ItemStack PCB = new ItemStack(GameRegistry.findItem("PneumaticCraft", "printedCircuitBoard"));
            ItemStack helmet = new ItemStack(GameRegistry.findItem(Reference.MOD_ID, "compressed_helmet"));
            airCanister.setItemDamage(30000);

            MiscHelper.deleteRecipes(GameRegistry.findItem("PneumaticCraft", "pneumaticHelmet"));
            GameRegistry.addRecipe(new ShapedOreRecipe(GameRegistry.findItem("PneumaticCraft", "pneumaticHelmet"),
                    "cbc",
                    "chc", 'c', airCanister, 'b', PCB, 'h', helmet));
        }
    }

    private static void registerRecipes(EquipMaterial material){
        if(material.enabled) {
            if (material.repairMat instanceof ItemStack) {
                registerToolRecipes(material.name, (ItemStack) material.repairMat, material.useObsidian);
                if (ConfigHandler.loadSickles) {
                    registerSickleRecipes(material.name, (ItemStack) material.repairMat, material.useObsidian);
                }
                registerArmorRecipes(material.name, (ItemStack) material.repairMat);
            } else if (material.repairMat instanceof String) {
                registerToolRecipes(material.name, (String) material.repairMat, material.useObsidian);
                if (ConfigHandler.loadSickles) {
                    registerSickleRecipes(material.name, (String) material.repairMat, material.useObsidian);
                }
                registerArmorRecipes(material.name, (String) material.repairMat);
            }
        }
    }

    private static void registerToolRecipes(String matName, String material, boolean useObsidian){
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
                " s", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood").setMirrored(true));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_shovel")),
                "i",
                "s",
                "s", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_hoe")),
                "ii",
                " s",
                " s", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood").setMirrored(true));
    }

    private static void registerToolRecipes(String matName, ItemStack material, boolean useObsidian){
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
                " s", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood").setMirrored(true));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_shovel")),
                "i",
                "s",
                "s", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_hoe")),
                "ii",
                " s",
                " s", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood").setMirrored(true));
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
                "si ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood").setMirrored(true));
    }

    private static void registerSickleRecipes(String matName, ItemStack material, boolean useObsidian) {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_sickle")),
                " i ",
                "  i",
                "si ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood").setMirrored(true));
    }
}
