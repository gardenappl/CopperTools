package com.goldenapple.coppertools.item.special;

import com.goldenapple.coppertools.item.ItemSickleCommon;
import com.goldenapple.coppertools.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import thaumcraft.api.IRepairable;
import thaumcraft.api.IWarpingGear;
import thaumcraft.api.ThaumcraftApi;

import java.util.Random;

public class ItemSickleVoid extends ItemSickleCommon implements IRepairable, IWarpingGear{
    private Random rand = new Random();

    public ItemSickleVoid(){
        super(ThaumcraftApi.toolMatVoid, Names.voidSickle, "ingotVoid", false);
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int wat, boolean wtf) {
        if(rand.nextFloat() < 0.05F){
            if(itemStack.isItemDamaged()) {
                itemStack.setItemDamage(itemStack.getItemDamage() - 1);
            }
        }
    }

    @Override
    public int getWarp(ItemStack itemstack, EntityPlayer player) {
        return 1;
    }

    @Override
    public EnumRarity getRarity(ItemStack itemStack) {
        return EnumRarity.uncommon;
    }
}
