package com.goldenapple.coppertools.item;

import com.goldenapple.coppertools.CopperToolsCreativeTab;
import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.reference.Reference;
import com.goldenapple.coppertools.util.OreHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSwordCommon extends ItemSword{
    private EquipMaterial material;

    public ItemSwordCommon(EquipMaterial material){
        super(material.toolMat);
        if(CopperToolsCreativeTab.tabCombat != null) {
            setCreativeTab(CopperToolsCreativeTab.tabCombat);
        }else if(CopperToolsCreativeTab.tabTools != null){
            setCreativeTab(CopperToolsCreativeTab.tabTools);
        }else{
            setCreativeTab(CreativeTabs.tabCombat);
        }
        this.material = material;
    }

    @Override
    public boolean getIsRepairable(ItemStack tool, ItemStack item){
        if (material.repairMat instanceof String){
            return OreHelper.isItemThisOre(item, (String)material.repairMat);
        }else if(material.repairMat instanceof ItemStack){
            return item.isItemEqual((ItemStack)material.repairMat);
        }
        return false;
    }

    @Override
    public String getUnlocalizedName(){
        return "item." + Reference.MOD_ID.toLowerCase() + ":" + material.name + "_sword";
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        return getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        if(material.useObsidian){
            itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + material.name + "_sword_o");
        }else {
            itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + material.name + "_sword");
        }
    }
}
