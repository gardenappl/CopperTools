package com.goldenapple.coppertools.item.special;

import com.goldenapple.coppertools.item.ItemSickleCommon;
import com.goldenapple.coppertools.reference.Names;
import thaumcraft.api.IRepairable;
import thaumcraft.api.ThaumcraftApi;

public class ItemSickleThaumium extends ItemSickleCommon implements IRepairable{
    public ItemSickleThaumium(){
        super(ThaumcraftApi.toolMatThaumium, Names.thaumiumSickle, "ingotThaumium", false);
    }
}
