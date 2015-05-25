package com.goldenapple.coppertools.item;

import com.goldenapple.coppertools.CopperToolsCreativeTab;
import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.reference.Reference;
import com.goldenapple.coppertools.util.OreHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemHoeCommon extends ItemHoe{
    private EquipMaterial material;

    public ItemHoeCommon(EquipMaterial material){
        super(material.toolMat);
        if(CopperToolsCreativeTab.tabTools != null){
            setCreativeTab(CopperToolsCreativeTab.tabTools);
        }else{
            setCreativeTab(CreativeTabs.tabTools);
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
        return "item." + Reference.MOD_ID.toLowerCase() + ":" + material.name + "_hoe";
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        return getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        if(material.useObsidian){
            itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + material.name + "_hoe_o");
        }else {
            itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + material.name + "_hoe");
        }
    }
}
