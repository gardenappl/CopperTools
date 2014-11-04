package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.handler.ConfigHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ModToolMaterial {
    //Tool materials
    public static Item.ToolMaterial COPPER = EnumHelper.addToolMaterial("COPPER", ConfigHandler.CopperToolMat[0],  ConfigHandler.CopperToolMat[1],  ConfigHandler.CopperToolMat[2],  ConfigHandler.CopperToolMat[3],  ConfigHandler.CopperToolMat[4]);
    public static Item.ToolMaterial PLATINUM = EnumHelper.addToolMaterial("PLATINUM", ConfigHandler.PlatinumToolMat[0], ConfigHandler.PlatinumToolMat[1], ConfigHandler.PlatinumToolMat[2], ConfigHandler.PlatinumToolMat[3], ConfigHandler.PlatinumToolMat[4]);
    public static Item.ToolMaterial COMPRESSED = EnumHelper.addToolMaterial("PLATINUM", ConfigHandler.CompressedToolMat[0], ConfigHandler.CompressedToolMat[1], ConfigHandler.CompressedToolMat[2], ConfigHandler.CompressedToolMat[3], ConfigHandler.CompressedToolMat[4]);
    public static Item.ToolMaterial LEAD = EnumHelper.addToolMaterial("LEAD", ConfigHandler.LeadToolMat[0], ConfigHandler.LeadToolMat[1], ConfigHandler.LeadToolMat[2], ConfigHandler.LeadToolMat[3], ConfigHandler.LeadToolMat[4]);

    //Armor materials
    public static ItemArmor.ArmorMaterial COPPER_A = EnumHelper.addArmorMaterial("COPPER", ConfigHandler.CopperArmorMat[0], new int[]{ConfigHandler.CopperArmorMat[1], ConfigHandler.CopperArmorMat[2], ConfigHandler.CopperArmorMat[3], ConfigHandler.CopperArmorMat[4]}, ConfigHandler.CopperArmorMat[5]);
    public static ItemArmor.ArmorMaterial PLATINUM_A = EnumHelper.addArmorMaterial("PLATINUM", ConfigHandler.PlatinumArmorMat[0], new int[]{ConfigHandler.PlatinumArmorMat[1], ConfigHandler.PlatinumArmorMat[2], ConfigHandler.PlatinumArmorMat[3], ConfigHandler.PlatinumArmorMat[4]}, ConfigHandler.PlatinumArmorMat[5]);
    public static ItemArmor.ArmorMaterial COMPRESSED_A = EnumHelper.addArmorMaterial("COMPRESSED", ConfigHandler.CompressedArmorMat[0], new int[]{ConfigHandler.CompressedArmorMat[1], ConfigHandler.CompressedArmorMat[2], ConfigHandler.CompressedArmorMat[3], ConfigHandler.CompressedArmorMat[4]}, ConfigHandler.CompressedArmorMat[5]);
    public static ItemArmor.ArmorMaterial LEAD_A = EnumHelper.addArmorMaterial("LEAD", ConfigHandler.LeadArmorMat[0], new int[]{ConfigHandler.LeadArmorMat[1], ConfigHandler.LeadArmorMat[2], ConfigHandler.LeadArmorMat[3], ConfigHandler.LeadArmorMat[4]}, ConfigHandler.LeadArmorMat[5]);

}
