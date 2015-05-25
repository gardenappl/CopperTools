package com.goldenapple.coppertools.item.special;

import com.goldenapple.coppertools.item.ItemSickleCommon;
import com.goldenapple.coppertools.reference.Names;
import com.goldenapple.coppertools.init.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ItemSickleGildedIron extends ItemSickleCommon {
    public ItemSickleGildedIron(){
        super(EnumHelper.addToolMaterial("GILDEDIRON", 2, 250, 6.0F, 2.0F, 22), Names.GILDED_SICKLE, new ItemStack(GameRegistry.findItem("Steamcraft", "ingot"), 1, 3), false);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister){
        itemIcon = iconRegister.registerIcon(ModItems.goldSickle.getUnlocalizedName().substring(ModItems.goldSickle.getUnlocalizedName().indexOf(".") + 1));
    }
}
