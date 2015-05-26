package com.goldenapple.coppertools.item.special;

import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.item.ItemSickleCommon;
import cpw.mods.fml.common.Optional;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraft.api.IRepairable;
import thaumcraft.api.IWarpingGear;
import thaumcraft.api.ThaumcraftApi;

import java.util.Random;

@Optional.InterfaceList({
        @Optional.Interface(iface = "thaumcraft.api.IRepairable", modid = "Thaumcraft"),
        @Optional.Interface(iface = "thaumcraft.api.IWarpingGear", modid = "Thaumcraft")
})
public class ItemSickleVoid extends ItemSickleCommon implements IRepairable, IWarpingGear{
    private Random rand = new Random();
    public static EquipMaterial material = new EquipMaterial("void", "ingotVoid", ThaumcraftApi.toolMatVoid, null, null, null, false, false, true);

    public ItemSickleVoid(){
        super(material);
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int wat, boolean wtf) {
        if(rand.nextFloat() < 0.04F){
            if(itemStack.isItemDamaged()) {
                itemStack.setItemDamage(itemStack.getItemDamage() - 1);
            }
        }
    }

    @Override
    @Optional.Method(modid = "Thaumcraft")
    public int getWarp(ItemStack itemstack, EntityPlayer player) {
        return 1;
    }

    @Override
    public EnumRarity getRarity(ItemStack itemStack) {
        return EnumRarity.uncommon;
    }
}
