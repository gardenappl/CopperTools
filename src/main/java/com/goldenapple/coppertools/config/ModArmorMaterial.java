package com.goldenapple.coppertools.config;

import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ModArmorMaterial {
    public static ItemArmor.ArmorMaterial COPPER;
    public static ItemArmor.ArmorMaterial PLATINUM;
    public static ItemArmor.ArmorMaterial LEAD;
    public static ItemArmor.ArmorMaterial COMPRESSED;
    public static ItemArmor.ArmorMaterial GEM = EnumHelper.addArmorMaterial("GEM", 27, new int[]{2, 6, 5, 2}, 17);
    public static ItemArmor.ArmorMaterial ENDERIUM;
    public static ItemArmor.ArmorMaterial SILVER;
    public static ItemArmor.ArmorMaterial HOLIDAY;

    static enum Default { //Durability, Protection(Helm, Chest, Legs, Boots), Enchantibility
        COPPER(10, new int[]{2, 5, 4, 2}, 17),
        PLATINUM(12, new int[]{2, 6, 5, 2}, 25),
        LEAD(10, new int[]{3, 7, 6, 3}, 9),
        COMPRESSED(30, new int[]{2, 6, 5, 2}, 9),
        ENDERIUM(40, new int[]{3, 8, 6, 3}, 25),
        SILVER(15, new int[]{2, 7, 5, 2}, 17),
        HOLIDAY(5, new int[]{3, 8, 6, 3}, 25);

        private int durability;
        private int[] protection;
        private int enchant;
        Default(int durability, int[] protection, int enchant){
            this.durability = durability;
            this.protection = protection;
            this.enchant = enchant;
        }

        public int getDurability(){
            return durability;
        }
        public int[] getProtection(){
            return protection;
        }
        public int getEnchant(){
            return enchant;
        }
    }
}
