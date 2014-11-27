package com.goldenapple.coppertools.config;

enum ModArmorMaterialDefault {
    COPPER(10, new int[]{2, 5, 4, 2}, 17),
    PLATINUM(12, new int[]{2, 6, 5, 2}, 25),
    LEAD(12, new int[]{2, 6, 5, 2}, 25),
    COMPRESSED(12, new int[]{2, 6, 5, 2}, 25);

    private int durability;
    private int[] protection;
    private int enchant;
    ModArmorMaterialDefault(int durability, int[] protection, int enchant){
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
