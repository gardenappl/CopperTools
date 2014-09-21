package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.handler.GeneralConfigHandler;
import com.goldenapple.coppertools.handler.PropertiesConfigHandler;
import com.goldenapple.coppertools.item.CopperToolsItem;
import com.goldenapple.coppertools.item.CopperToolsSword;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import pneumaticCraft.api.item.ItemSupplier;

public class ModItems {
    public static final CopperToolsSword woodSaber = new CopperToolsSword(Item.ToolMaterial.STONE, "wooden_saber", "logWood");
    public static final CopperToolsItem obsidianRod = new CopperToolsItem("obsidian_rod");

    public static void init() {
        if (GeneralConfigHandler.loadObsidianRod) {
            GameRegistry.registerItem(obsidianRod, "obsidian_rod");

            OreDictionary.registerOre("rodObsidian", obsidianRod);
        }

        if (GeneralConfigHandler.loadSaber) {
            GameRegistry.registerItem(woodSaber, "wooden_saber");
        }
        if (GeneralConfigHandler.loadCopper) {
            ToolSets.RegisterOreToolSet(ModToolMaterial.COPPER, ModToolMaterial.COPPER_A, "copper", "ingotCopper", false);
        }
        if (GeneralConfigHandler.loadPlatinum) {
            ToolSets.RegisterOreToolSet(ModToolMaterial.PLATINUM, ModToolMaterial.PLATINUM_A, "platinum", "ingotPlatinum", PropertiesConfigHandler.platinumRequiresObsidian);
        }
        if (GeneralConfigHandler.loadCompressed && Loader.isModLoaded("PneumaticCraft")) {
            ToolSets.RegisterToolSet(ModToolMaterial.COMPRESSED, ModToolMaterial.COMPRESSED_A, "compressed", new ItemStack(ItemSupplier.getItem("ingotCompressedIron")), PropertiesConfigHandler.platinumRequiresObsidian);
        }
    }
}
