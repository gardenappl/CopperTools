package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.CopperTools;
import com.goldenapple.coppertools.handler.ChristmasEventHandler;
import com.goldenapple.coppertools.item.special.ItemSickleGildedIron;
import com.goldenapple.coppertools.item.special.ItemSickleThaumium;
import com.goldenapple.coppertools.item.special.ItemSickleVoid;
import com.goldenapple.coppertools.item.special.ItemSwordWooden;
import com.goldenapple.coppertools.reference.Names;
import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.config.ModArmorMaterial;
import com.goldenapple.coppertools.config.ModToolMaterial;
import com.goldenapple.coppertools.item.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {
    public static final ItemCommon obsidianRod = new ItemCommon(Names.obsidianRod);

    public static final ItemSickleCommon woodSickle = new ItemSickleCommon(Item.ToolMaterial.WOOD, Names.woodSickle, "plankWood", false);
    public static final ItemSickleCommon stoneSickle = new ItemSickleCommon(Item.ToolMaterial.STONE, Names.stoneSickle, "cobblestone", false);
    public static final ItemSickleCommon ironSickle = new ItemSickleCommon(Item.ToolMaterial.IRON, Names.ironSickle, "ingotIron", false);
    public static final ItemSickleCommon diamondSickle = new ItemSickleCommon(Item.ToolMaterial.EMERALD, Names.diamondSickle, "gemDiamond", false);
    public static final ItemSickleCommon goldSickle = new ItemSickleCommon(Item.ToolMaterial.GOLD, Names.goldSickle, "ingotGold", false);
    public static final ItemSickleCommon brassSickle = new ItemSickleCommon(ModToolMaterial.BRASS, Names.brassSickle, "ingotBrass", false);

    public static void init() {
        if(ConfigHandler.loadObsidianRod) {
            GameRegistry.registerItem(obsidianRod, Names.obsidianRod);
            OreDictionary.registerOre("rodObsidian", obsidianRod);
        }
        if(ConfigHandler.loadSaber) {
            GameRegistry.registerItem(new ItemSwordWooden(), Names.woodKatana);
        }
        if (ConfigHandler.loadCopper){
            registerSet(ModToolMaterial.COPPER, ModArmorMaterial.COPPER, "copper", "ingotCopper", false);
        }
        if(ConfigHandler.loadPlatinum){
            registerSet(ModToolMaterial.PLATINUM, ModArmorMaterial.PLATINUM, "platinum", "ingotPlatinum", ConfigHandler.platinumRequiresObsidian);
        }
        if(ConfigHandler.loadLead){
            registerSet(ModToolMaterial.LEAD, ModArmorMaterial.LEAD, "lead", "ingotLead", false);
        }
        if(ConfigHandler.loadCompressed && CopperTools.isPneumaticLoaded) {
            registerSet(ModToolMaterial.COMPRESSED, ModArmorMaterial.COMPRESSED, "compressed", new ItemStack(GameRegistry.findItem("PneumaticCraft", "ingotIronCompressed")), false);
        }
        if(ConfigHandler.loadEnderium && CopperTools.isTELoaded){
            registerSet(ModToolMaterial.ENDERIUM, ModArmorMaterial.ENDERIUM, "enderium", "ingotEnderium", true);
        }
        if(ConfigHandler.loadSilver){
            registerSet(ModToolMaterial.SILVER, ModArmorMaterial.SILVER, "silver", "ingotSilver", false);
        }
        if(ConfigHandler.loadSickles) {
            if (ConfigHandler.loadVanillaSickles) {
                GameRegistry.registerItem(woodSickle, Names.woodSickle);
                GameRegistry.registerItem(stoneSickle, Names.stoneSickle);
                GameRegistry.registerItem(ironSickle, Names.ironSickle);
                GameRegistry.registerItem(diamondSickle, Names.diamondSickle);
                GameRegistry.registerItem(goldSickle, Names.goldSickle);
            }
            if (ConfigHandler.loadBrassSickle) {
                GameRegistry.registerItem(brassSickle, Names.brassSickle);
            }
            if (ConfigHandler.loadGildedSickle && CopperTools.isSteamPowerLoaded) {
                GameRegistry.registerItem(new ItemSickleGildedIron(), Names.gildedSickle);
            }
            if(ConfigHandler.loadThaumiumSickle && CopperTools.isThaumcraftLoaded){
                GameRegistry.registerItem(new ItemSickleThaumium(), Names.thaumiumSickle);
            }
            if(ConfigHandler.loadVoidSickle && CopperTools.isThaumcraftLoaded){
                GameRegistry.registerItem(new ItemSickleVoid(), Names.voidSickle);
            }
        }
        if(ConfigHandler.loadGemArmor){
            registerArmorSet(ModArmorMaterial.GEM, "ruby", "gemRuby");
            registerArmorSet(ModArmorMaterial.GEM, "peridot", "gemPeridot");
            registerArmorSet(ModArmorMaterial.GEM, "sapphire", "gemSapphire");
            registerArmorSet(ModArmorMaterial.GEM, "amethyst", "gemAmethyst");
        }
        if((ConfigHandler.loadHoliday && ChristmasEventHandler.isChristmas()) || ConfigHandler.holidaySpiritLivesForever){
            registerSet(ModToolMaterial.HOLIDAY, ModArmorMaterial.HOLIDAY, "christmas", new ItemStack(Blocks.ice), false);
        }
        if(ConfigHandler.loadEmerald){
            registerSet(ModToolMaterial.EMERALD, ModArmorMaterial.EMERALD, "emerald", "gemEmerald", ConfigHandler.emeraldRequiresObsidian);
        }
    }

    private static void registerSet(Item.ToolMaterial mat, ItemArmor.ArmorMaterial armorMat, String matName, Object material, boolean useObsidian){
        if(material instanceof ItemStack) {
            registerToolSet(mat, matName, (ItemStack)material, useObsidian);
            registerArmorSet(armorMat, matName, (ItemStack)material);
        }else if(material instanceof String){
            registerToolSet(mat, matName, (String)material, useObsidian);
            registerArmorSet(armorMat, matName, (String)material);
        }
    }


    private static void registerToolSet(Item.ToolMaterial mat, String matName, String material, boolean useObsidian){
        Item pickaxe = new ItemPickaxeCommon(mat, matName + "_pickaxe", material, useObsidian);
        GameRegistry.registerItem(pickaxe, matName + "_pickaxe");

        Item sword = new ItemSwordCommon(mat, matName + "_sword", material, useObsidian);
        GameRegistry.registerItem(sword, matName + "_sword");

        Item shovel = new ItemSpadeCommon(mat, matName + "_shovel", material, useObsidian);
        GameRegistry.registerItem(shovel, matName + "_shovel");

        Item axe = new ItemAxeCommon(mat, matName + "_axe", material, useObsidian);
        GameRegistry.registerItem(axe, matName + "_axe");

        Item hoe = new ItemHoeCommon(mat, matName + "_hoe", material, useObsidian);
        GameRegistry.registerItem(hoe, matName + "_hoe");

        if(ConfigHandler.loadSickles) {
            Item sickle = new ItemSickleCommon(mat, matName + "_sickle", material, useObsidian);
            GameRegistry.registerItem(sickle, matName + "_sickle");
        }
    }

    private static void registerToolSet(Item.ToolMaterial mat, String matName, ItemStack ingot, boolean useObsidian) {
        Item pickaxe = new ItemPickaxeCommon(mat, matName + "_pickaxe", ingot, useObsidian);
        GameRegistry.registerItem(pickaxe, matName + "_pickaxe");

        Item sword = new ItemSwordCommon(mat, matName + "_sword", ingot, useObsidian);
        GameRegistry.registerItem(sword, matName + "_sword");

        Item shovel = new ItemSpadeCommon(mat, matName + "_shovel", ingot, useObsidian);
        GameRegistry.registerItem(shovel, matName + "_shovel");

        Item axe = new ItemAxeCommon(mat, matName + "_axe", ingot, useObsidian);
        GameRegistry.registerItem(axe, matName + "_axe");

        Item hoe = new ItemHoeCommon(mat, matName + "_hoe", ingot, useObsidian);
        GameRegistry.registerItem(hoe, matName + "_hoe");

        if(ConfigHandler.loadSickles) {
            Item sickle = new ItemSickleCommon(mat, matName + "_sickle", ingot, useObsidian);
            GameRegistry.registerItem(sickle, matName + "_sickle");
        }
    }

    private static void registerArmorSet(ItemArmor.ArmorMaterial mat, String matName, String ingot){
        Item helmet = new ItemArmorCommon(mat, matName + "_helmet", ingot, 0);
        GameRegistry.registerItem(helmet, matName + "_helmet");

        Item chestplate = new ItemArmorCommon(mat, matName + "_chestplate", ingot, 1);
        GameRegistry.registerItem(chestplate, matName + "_chestplate");

        Item leggings = new ItemArmorCommon(mat, matName + "_leggings", ingot, 2);
        GameRegistry.registerItem(leggings, matName + "_leggings");

        Item boots = new ItemArmorCommon(mat, matName + "_boots", ingot, 3);
        GameRegistry.registerItem(boots, matName + "_boots");
    }

    private static void registerArmorSet(ItemArmor.ArmorMaterial mat, String matName, ItemStack ingot){
        Item helmet = new ItemArmorCommon(mat, matName + "_helmet", ingot, 0);
        GameRegistry.registerItem(helmet, matName + "_helmet");

        Item chestplate = new ItemArmorCommon(mat, matName + "_chestplate", ingot, 1);
        GameRegistry.registerItem(chestplate, matName + "_chestplate");

        Item leggings = new ItemArmorCommon(mat, matName + "_leggings", ingot, 2);
        GameRegistry.registerItem(leggings, matName + "_leggings");

        Item boots = new ItemArmorCommon(mat, matName + "_boots", ingot, 3);
        GameRegistry.registerItem(boots, matName + "_boots");
    }
}
