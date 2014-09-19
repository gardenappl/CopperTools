package com.goldenapple.coppertools.item;

import com.goldenapple.coppertools.creativetab.CopperToolsTab;
import com.goldenapple.coppertools.util.LogHelper;
import com.goldenapple.coppertools.util.MiscUtil;
import com.goldenapple.coppertools.util.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class CopperToolsPickaxe extends ItemPickaxe {

    private String repairOre;
    private ItemStack repairItem;
    private boolean isMatAnOre;

    public CopperToolsPickaxe(Item.ToolMaterial material, String name, String matRepair)
    {
        super(material);
        repairOre = matRepair;
        isMatAnOre = true;
        setCreativeTab(CopperToolsTab.CopperToolsTab);
        setUnlocalizedName(name);
        LogHelper.info("Registering an Ore Tool: " + name);
    }
    public
    CopperToolsPickaxe(Item.ToolMaterial material, String name, ItemStack matRepair)
    {
        super(material);
        repairItem = matRepair;
        isMatAnOre = false;
        setCreativeTab(CopperToolsTab.CopperToolsTab);
        setUnlocalizedName(name);
    }

    @Override
    public boolean getIsRepairable(ItemStack tool, ItemStack item){
        if(isMatAnOre) {
            return MiscUtil.isItemThisOre(item, repairOre);
        }else{
            return item.isItemEqual(repairItem);
        }
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
