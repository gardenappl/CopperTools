package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.CopperToolsMod;
import com.goldenapple.coppertools.Reference.Names;
import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.config.ModArmorMaterial;
import com.goldenapple.coppertools.config.ModToolMaterial;
import com.goldenapple.coppertools.item.*;
import com.goldenapple.coppertools.item.special.GildedIronSickle;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {
    public static final CopperToolsSword woodSaber = new CopperToolsSword(Item.ToolMaterial.STONE, Names.woodSaber, "logWood", false);
    public static final CopperToolsItem obsidianRod = new CopperToolsItem(Names.obsidianRod);

    public static final CopperToolsSickle woodSickle = new CopperToolsSickle(Item.ToolMaterial.WOOD, Names.woodSickle, "plankWood", false);
    public static final CopperToolsSickle stoneSickle = new CopperToolsSickle(Item.ToolMaterial.STONE, Names.stoneSickle, "cobblestone", false);
    public static final CopperToolsSickle ironSickle = new CopperToolsSickle(Item.ToolMaterial.IRON, Names.ironSickle, "ingotIron", false);
    public static final CopperToolsSickle diamondSickle = new CopperToolsSickle(Item.ToolMaterial.EMERALD, Names.diamondSickle, "gemDiamond", false);
    public static final CopperToolsSickle goldSickle = new CopperToolsSickle(Item.ToolMaterial.GOLD, Names.goldSickle, "ingotGold", false);
    public static final CopperToolsSickle brassSickle = new CopperToolsSickle(ModToolMaterial.BRASS, Names.brassSickle, "ingotBrass", false);
    public static final CopperToolsSickle gildedSickle = new GildedIronSickle();

    public static void init() {
        if(ConfigHandler.loadObsidianRod) {
            GameRegistry.registerItem(obsidianRod, Names.obsidianRod);
            OreDictionary.registerOre("rodObsidian", obsidianRod);
        }
        if(ConfigHandler.loadSaber) {
            GameRegistry.registerItem(woodSaber, Names.woodSaber);
        }
        if (ConfigHandler.loadCopper){
             registerOreToolSet(ModToolMaterial.COPPER, ModArmorMaterial.COPPER, "copper", "ingotCopper", false);
        }
        if(ConfigHandler.loadPlatinum){
            registerOreToolSet(ModToolMaterial.PLATINUM, ModArmorMaterial.PLATINUM, "platinum", "ingotPlatinum", ConfigHandler.platinumRequiresObsidian);
        }
        if(ConfigHandler.loadLead){
            registerOreToolSet(ModToolMaterial.LEAD, ModArmorMaterial.LEAD, "lead", "ingotLead", false);
        }
        if(ConfigHandler.loadCompressed && CopperToolsMod.isPneumaticLoaded) {
            registerToolSet(ModToolMaterial.COMPRESSED, ModArmorMaterial.COMPRESSED, "compressed", new ItemStack(GameRegistry.findItem("PneumaticCraft", "ingotIronCompressed")), false);
        }
        if(ConfigHandler.loadEnderium){
            registerOreToolSet(ModToolMaterial.ENDERIUM, ModArmorMaterial.ENDERIUM, "enderium", "ingotEnderium", true);
        }
        if(ConfigHandler.loadSilver){
            registerOreToolSet(ModToolMaterial.SILVER, ModArmorMaterial.SILVER, "silver", "ingotSilver", false);
        }
        if(ConfigHandler.loadVanillaSickles){
            GameRegistry.registerItem(woodSickle, Names.woodSickle);
            GameRegistry.registerItem(stoneSickle, Names.stoneSickle);
            GameRegistry.registerItem(ironSickle, Names.ironSickle);
            GameRegistry.registerItem(diamondSickle, Names.diamondSickle);
            GameRegistry.registerItem(goldSickle, Names.goldSickle);
        }
        if(ConfigHandler.loadBrassSickle){
            GameRegistry.registerItem(brassSickle, Names.brassSickle);
        }
        if(ConfigHandler.loadGildedSickle && CopperToolsMod.isSteamPowerLoaded){
            GameRegistry.registerItem(gildedSickle, Names.gildedSickle);
        }
        if(ConfigHandler.loadGemArmor){
            registerArmorOnly(ModArmorMaterial.GEM, "ruby", "gemRuby");
            registerArmorOnly(ModArmorMaterial.GEM, "peridot", "gemPeridot");
            registerArmorOnly(ModArmorMaterial.GEM, "sapphire", "gemSapphire");
            registerArmorOnly(ModArmorMaterial.GEM, "amethyst", "gemAmethyst");
        }
    }

    public static void registerOreToolSet(Item.ToolMaterial mat, ItemArmor.ArmorMaterial matArmor, String matName, String material, boolean useObsidian){
        Item pickaxe = new CopperToolsPickaxe(mat, matName + "_pickaxe", material, useObsidian);
        GameRegistry.registerItem(pickaxe, matName + "_pickaxe");

        Item sword = new CopperToolsSword(mat, matName + "_sword", material, useObsidian);
        GameRegistry.registerItem(sword, matName + "_sword");

        Item shovel = new CopperToolsSpade(mat, matName + "_shovel", material, useObsidian);
        GameRegistry.registerItem(shovel, matName + "_shovel");

        Item axe = new CopperToolsAxe(mat, matName + "_axe", material, useObsidian);
        GameRegistry.registerItem(axe, matName + "_axe");

        Item hoe = new CopperToolsHoe(mat, matName + "_hoe", material, useObsidian);
        GameRegistry.registerItem(hoe, matName + "_hoe");

        if(ConfigHandler.loadSickles) {
            Item sickle = new CopperToolsSickle(mat, matName + "_sickle", material, useObsidian);
            GameRegistry.registerItem(sickle, matName + "_sickle");
        }

        Item helmet = new CopperToolsArmor(matArmor, matName + "_helmet", material, 0);
        GameRegistry.registerItem(helmet, matName + "_helmet");

        Item chestplate = new CopperToolsArmor(matArmor, matName + "_chestplate", material, 1);
        GameRegistry.registerItem(chestplate, matName + "_chestplate");

        Item leggings = new CopperToolsArmor(matArmor, matName + "_leggings", material, 2);
        GameRegistry.registerItem(leggings, matName + "_leggings");

        Item boots = new CopperToolsArmor(matArmor, matName + "_boots", material, 3);
        GameRegistry.registerItem(boots, matName + "_boots");
    }

    public static void registerToolSet(Item.ToolMaterial mat, ItemArmor.ArmorMaterial matArmor, String matName, ItemStack ingot, boolean useObsidian) {
        Item pickaxe = new CopperToolsPickaxe(mat, matName + "_pickaxe", ingot, useObsidian);
        GameRegistry.registerItem(pickaxe, matName + "_pickaxe");

        Item sword = new CopperToolsSword(mat, matName + "_sword", ingot, useObsidian);
        GameRegistry.registerItem(sword, matName + "_sword");

        Item shovel = new CopperToolsSpade(mat, matName + "_shovel", ingot, useObsidian);
        GameRegistry.registerItem(shovel, matName + "_shovel");

        Item axe = new CopperToolsAxe(mat, matName + "_axe", ingot, useObsidian);
        GameRegistry.registerItem(axe, matName + "_axe");

        Item hoe = new CopperToolsHoe(mat, matName + "_hoe", ingot, useObsidian);
        GameRegistry.registerItem(hoe, matName + "_hoe");

        if(ConfigHandler.loadSickles) {
            Item sickle = new CopperToolsSickle(mat, matName + "_sickle", ingot, useObsidian);
            GameRegistry.registerItem(sickle, matName + "_sickle");
        }

        Item helmet = new CopperToolsArmor(matArmor, matName + "_helmet", ingot, 0);
        GameRegistry.registerItem(helmet, matName + "_helmet");

        Item chestplate = new CopperToolsArmor(matArmor, matName + "_chestplate", ingot, 1);
        GameRegistry.registerItem(chestplate, matName + "_chestplate");

        Item leggings = new CopperToolsArmor(matArmor, matName + "_leggings", ingot, 2);
        GameRegistry.registerItem(leggings, matName + "_leggings");

        Item boots = new CopperToolsArmor(matArmor, matName + "_boots", ingot, 3);
        GameRegistry.registerItem(boots, matName + "_boots");
    }

    public static void registerArmorOnly(ItemArmor.ArmorMaterial mat, String matName, String ingot){
        Item helmet = new CopperToolsArmor(mat, matName + "_helmet", ingot, 0);
        GameRegistry.registerItem(helmet, matName + "_helmet");

        Item chestplate = new CopperToolsArmor(mat, matName + "_chestplate", ingot, 1);
        GameRegistry.registerItem(chestplate, matName + "_chestplate");

        Item leggings = new CopperToolsArmor(mat, matName + "_leggings", ingot, 2);
        GameRegistry.registerItem(leggings, matName + "_leggings");

        Item boots = new CopperToolsArmor(mat, matName + "_boots", ingot, 3);
        GameRegistry.registerItem(boots, matName + "_boots");
    }
}
