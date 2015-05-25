package com.goldenapple.coppertools.item.special;

import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.item.ItemSickleCommon;
import com.goldenapple.coppertools.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;

public class ItemSickleGildedIron extends ItemSickleCommon {
    public ItemSickleGildedIron(){
        super(EquipMaterial.gildedIron);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister){
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + EquipMaterial.gold.name + "_sickle");
    }
}
