package com.goldenapple.coppertools.item;

import com.goldenapple.coppertools.CopperToolsCreativeTab;
import com.goldenapple.coppertools.util.OreHelper;
import com.goldenapple.coppertools.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorCommon extends ItemArmor{

    private String repairOre;
    private ItemStack repairItem;

    public ItemArmorCommon(ItemArmor.ArmorMaterial material, String name, String matRepair, int type){
        super(material, 1, type);
        repairOre = matRepair;
        setCreativeTab(CopperToolsCreativeTab.CopperToolsCombatTab);
        setUnlocalizedName(name);
    }

    public ItemArmorCommon(ItemArmor.ArmorMaterial material, String name, ItemStack matRepair, int type){
        super(material, 1, type);
        repairItem = matRepair;
        setCreativeTab(CopperToolsCreativeTab.CopperToolsCombatTab);
        setUnlocalizedName(name);
    }

    @Override
    public boolean getIsRepairable(ItemStack tool, ItemStack item){
        if(repairOre!=null) {
            return OreHelper.isItemThisOre(item, repairOre);
        }else{
            return item.isItemEqual(repairItem);
        }
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
        return (slot == 2) ? ("coppertools:textures/armor/" + getUnlocalizedName(stack).substring(this.getUnlocalizedName().indexOf(":") + 1, this.getUnlocalizedName().indexOf("_")) + "1.png") :
        ("coppertools:textures/armor/" + getUnlocalizedName(stack).substring(this.getUnlocalizedName().indexOf(":") + 1, this.getUnlocalizedName().indexOf("_")) + "0.png");
    }

    //The code below is taken from Pahimar's Let's Mod Reboot mod. https://github.com/pahimar/LetsModReboot

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

}
