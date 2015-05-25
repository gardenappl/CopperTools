package com.goldenapple.coppertools.item;

import com.goldenapple.coppertools.CopperToolsCreativeTab;
import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.util.OreHelper;
import com.goldenapple.coppertools.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorCommon extends ItemArmor{
    private EquipMaterial material;
    private String typeName;

    public ItemArmorCommon(EquipMaterial material, String typeName, int type){
        super(material.armorMat, 1, type);
        if(CopperToolsCreativeTab.tabCombat != null) {
            setCreativeTab(CopperToolsCreativeTab.tabCombat);
        }else if(CopperToolsCreativeTab.tabTools != null){
            setCreativeTab(CopperToolsCreativeTab.tabTools);
        }else{
            setCreativeTab(CreativeTabs.tabCombat);
        }
        this.material = material;
        this.typeName = typeName;
    }

    @Override
    public boolean getIsRepairable(ItemStack tool, ItemStack item){
        if(material.repairMat instanceof String) {
            return OreHelper.isItemThisOre(item, (String)material.repairMat);
        }else if(material.repairMat instanceof ItemStack){
            return item.isItemEqual((ItemStack)material.repairMat);
        }

        return false;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
        if(slot == 2){
            return "coppertools:textures/armor/" + material.name + "1.png";
        }else {
            return "coppertools:textures/armor/" + material.name + "0.png";
        }
    }

    @Override
    public String getUnlocalizedName(){
        return Reference.MOD_ID.toLowerCase() + ":" + material.name + "_" + typeName;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        return getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + material.name + "_" + typeName);
    }
}
