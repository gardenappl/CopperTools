package com.goldenapple.coppertools.item.special;

import com.goldenapple.coppertools.item.ItemSickleCommon;
import com.goldenapple.coppertools.reference.Names;
import cpw.mods.fml.common.Optional;
import thaumcraft.api.IRepairable;
import thaumcraft.api.ThaumcraftApi;

@Optional.Interface(iface = "thaumcraft.api.IRepairable", modid = "Thaumcraft")
public class ItemSickleThaumium extends ItemSickleCommon implements IRepairable{
    public ItemSickleThaumium(){
        super(ThaumcraftApi.toolMatThaumium, Names.thaumiumSickle, "ingotThaumium", false);
    }
}
