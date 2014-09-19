package com.goldenapple.coppertools.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MiscUtil {
    //The code below is taken from Flaxbeard's Wondrous Steam Power mod. https://github.com/Flaxbeard/Flaxbeards-Steam-Power
    public static boolean isItemThisOre(ItemStack item, String ore){
        for (ItemStack i : OreDictionary.getOres(ore)) {
            if (i.isItemEqual(item)) {
                return true;
            }
        }
            return false;
        }
    }