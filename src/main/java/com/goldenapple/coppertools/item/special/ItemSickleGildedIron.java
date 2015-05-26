package com.goldenapple.coppertools.item.special;

import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.item.ItemSickleCommon;
import com.goldenapple.coppertools.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;

public class ItemSickleGildedIron extends ItemSickleCommon {
    public static EquipMaterial material = new EquipMaterial("gilded", new ItemStack(GameRegistry.findItem("Steamcraft", "ingot"), 1, 3), EquipMaterial.GILDED_IRON_MATERIAL, null, null, null, false, false, true);

    public ItemSickleGildedIron(){
        super(material);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister){
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + EquipMaterial.gold.name + "_sickle");
    }
}
