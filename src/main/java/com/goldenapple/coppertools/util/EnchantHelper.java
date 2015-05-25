package com.goldenapple.coppertools.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class EnchantHelper {
    public static ItemStack enchant(ItemStack itemStack, Enchantment enchantment, int level){
        NBTTagList enchantList = itemStack.getEnchantmentTagList();
        if(enchantList == null) enchantList = new NBTTagList();
        NBTTagCompound tagCompound = new NBTTagCompound();

        tagCompound.setShort("id", (short)enchantment.effectId);
        tagCompound.setShort("lvl", (short) level);
        enchantList.appendTag(tagCompound);

        itemStack.setTagInfo("ench", enchantList);
        return itemStack;
    }
}
