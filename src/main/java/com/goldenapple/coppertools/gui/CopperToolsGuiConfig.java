package com.goldenapple.coppertools.gui;

import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.reference.Reference;
import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CopperToolsGuiConfig extends GuiConfig{
    @SuppressWarnings({"unchecked"})
    public CopperToolsGuiConfig(GuiScreen parentScreen){
        super(parentScreen, getConfigElements(), Reference.MOD_ID, false, true, GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
    }

    //Compiles a list of config elements
    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<IConfigElement>();

        //Add categories to config GUI
        list.add(categoryElement(Configuration.CATEGORY_GENERAL, "General", "config.general"));
        list.add(categoryElement(ConfigHandler.CATEGORY_SICKLES, "Sickles", "config.sickles"));
        for(EquipMaterial material : EquipMaterial.registry){
            list.add(categoryElement(material.name, "Equipment set: " + material.name, "config.set"));
        }
        return list;
    }

    /** Creates a button linking to another screen where all options of the category are available */
    @SuppressWarnings("unchecked")
    private static IConfigElement categoryElement(String category, String name, String tooltip_key) {
        return new DummyConfigElement.DummyCategoryElement(name, tooltip_key,
                new ConfigElement(ConfigHandler.config.getCategory(category)).getChildElements());
    }
}
