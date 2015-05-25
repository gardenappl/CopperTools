package com.goldenapple.coppertools.item.special;

import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.item.ItemSwordCommon;
import com.goldenapple.coppertools.reference.Names;
import com.goldenapple.coppertools.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;

public class ItemSwordWooden extends ItemSwordCommon {
    public ItemSwordWooden(){
        super(EquipMaterial.woodKatana);
    }

    @Override
    public String getUnlocalizedName() {
        return "item." + Reference.MOD_ID + ":" + Names.WOOD_KATANA;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + Names.WOOD_KATANA);
    }
}
