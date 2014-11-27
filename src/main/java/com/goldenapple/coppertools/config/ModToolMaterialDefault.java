package com.goldenapple.coppertools.config;

enum ModToolMaterialDefault { //Used to store default values for materials. See ConfigHandler
    COPPER(1, 131, 7, 1, 18),
    PLATINUM(2, 200, 12, 2, 22),
    LEAD(2, 200, 12, 2, 22),
    COMPRESSED(2, 200, 12, 2, 22);

    private int harvestLevel;
    private int durability;
    private float efficiecny;
    private float damage;
    private int enchant;
    ModToolMaterialDefault(int harvestLevel, int durability, float efficiency, float damage, int enchant){
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.efficiecny = efficiency;
        this.damage = damage;
        this.enchant = enchant;
    }

    public int getHarvestLevel(){
        return harvestLevel;
    }
    public int getDurability(){
        return durability;
    }
    public float getEfficiecny(){
        return efficiecny;
    }
    public float getDamage(){
        return damage;
    }
    public int getEnchant(){
        return enchant;
    }
}
