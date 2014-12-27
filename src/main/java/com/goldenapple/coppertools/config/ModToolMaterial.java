package com.goldenapple.coppertools.config;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ModToolMaterial {
    public static Item.ToolMaterial COPPER;
    public static Item.ToolMaterial PLATINUM;
    public static Item.ToolMaterial LEAD;
    public static Item.ToolMaterial COMPRESSED;
    public static Item.ToolMaterial BRASS = EnumHelper.addToolMaterial("BRASS_S", 2, 191, 7.0F, 2.5F, 14);
    public static Item.ToolMaterial ENDERIUM;
    public static Item.ToolMaterial SILVER;

    static enum Default { //Mining level, durability, speed, damage, enchantibility
        COPPER(1, 131, 7, 1, 18),
        PLATINUM(2, 200, 12, 2, 22),
        LEAD(0, 131, 4, 0, 14),
        COMPRESSED(2, 500, 6, 2, 14),
        ENDERIUM(5, 2000, 10, 4, 22),
        SILVER(2, 250, 8, 2.5F, 18);

        private int harvestLevel;
        private int durability;
        private float efficiency;
        private float damage;
        private int enchant;
        Default(int harvestLevel, int durability, float efficiency, float damage, int enchant){
            this.harvestLevel = harvestLevel;
            this.durability = durability;
            this.efficiency = efficiency;
            this.damage = damage;
            this.enchant = enchant;
        }

        public int getHarvestLevel(){
            return harvestLevel;
        }
        public int getDurability(){
            return durability;
        }
        public float getEfficiency(){
            return efficiency;
        }
        public float getDamage(){
            return damage;
        }
        public int getEnchant(){
            return enchant;
        }
    }
}
