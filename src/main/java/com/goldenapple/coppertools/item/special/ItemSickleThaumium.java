package com.goldenapple.coppertools.item.special;

import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.item.ItemSickleCommon;
import cpw.mods.fml.common.Optional;
import thaumcraft.api.IRepairable;
import thaumcraft.api.ThaumcraftApi;

@Optional.Interface(iface = "thaumcraft.api.IRepairable", modid = "Thaumcraft")
public class ItemSickleThaumium extends ItemSickleCommon implements IRepairable{
    public static EquipMaterial thaumium = new EquipMaterial("thaumium", "ingotThaumium", ThaumcraftApi.toolMatThaumium, null, null, null, false, false, true);

    public ItemSickleThaumium(){
        super(thaumium);
    }
}
