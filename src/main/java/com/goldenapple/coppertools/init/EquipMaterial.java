package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.CopperTools;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import java.util.HashSet;

public class EquipMaterial {
    public static HashSet<EquipMaterial> registry = new HashSet<EquipMaterial>();

    public static Item.ToolMaterial BRASS_MATERIAL = EnumHelper.addToolMaterial("BRASS_S", 2, 191, 7.0F, 2.5F, 14);
    public static Item.ToolMaterial GILDED_IRON_MATERIAL = EnumHelper.addToolMaterial("GILDEDIRON", 2, 250, 6.0F, 2.0F, 22);
    public static Item.ToolMaterial IRONWOOD_MATERIAL = EnumHelper.addToolMaterial("IRONWOOD", 2, 512, 7.0F, 2.0F, 20);
    public static Item.ToolMaterial STEELEAF_MATERIAL = EnumHelper.addToolMaterial("STEELEAF", 2, 131, 6.0F, 3.0F, 22);

    //Full sets of equipment
    public static EquipMaterial copper = new EquipMaterial("copper", "ingotCopper", null, DefaultTool.COPPER, null, DefaultArmor.COPPER, true, true, true);
    public static EquipMaterial platinum = new EquipMaterial("platinum", "ingotPlatinum", null, DefaultTool.PLATINUM, null, DefaultArmor.PLATINUM, true, true, true);
    public static EquipMaterial compressed = new EquipMaterial("compressed", "ingotIronCompressed", null, DefaultTool.COMPRESSED, null, DefaultArmor.COMPRESSED, true, true, true);
    public static EquipMaterial lead = new EquipMaterial("lead", "ingotLead", null, DefaultTool.LEAD, null, DefaultArmor.LEAD, true, true, true);
    public static EquipMaterial enderium = new EquipMaterial("enderium", "ingotEnderium", null, DefaultTool.ENDERIUM, null, DefaultArmor.ENDERIUM, true, true, true);
    public static EquipMaterial silver = new EquipMaterial("silver", "ingotSilver", null, DefaultTool.SILVER, null, DefaultArmor.SILVER, true, true, true);
    public static EquipMaterial emerald = new EquipMaterial("emerald", "gemEmerald", null, DefaultTool.EMERALD, null, DefaultArmor.EMERALD, true, true, true);

    //Gem armor
    public static EquipMaterial ruby = new EquipMaterial("ruby", "gemRuby", null, null, null, DefaultArmor.GEM, false, true, false);
    public static EquipMaterial sapphire = new EquipMaterial("sapphire", "gemSapphire", null, null, null, DefaultArmor.GEM, false, true, false);
    public static EquipMaterial amethyst = new EquipMaterial("amethyst", "gemAmethyst", null, null, null, DefaultArmor.GEM, false, true, false);

    //Other stuff that I register manually
    public static EquipMaterial wood = new EquipMaterial("wood", "plankWood", Item.ToolMaterial.WOOD, null, null, null, false, false, true);
    public static EquipMaterial stone = new EquipMaterial("stone", "cobblestone", Item.ToolMaterial.STONE, null, null, null, false, false, true);
    public static EquipMaterial iron = new EquipMaterial("iron", "ingotIron", Item.ToolMaterial.IRON, null, null, null, false, false, true);
    public static EquipMaterial gold = new EquipMaterial("gold", "ingotGold", Item.ToolMaterial.GOLD, null, null, null, false, false, true);
    public static EquipMaterial diamond = new EquipMaterial("diamond", "gemDiamond", Item.ToolMaterial.EMERALD, null, null, null, false, false, true);
    public static EquipMaterial brass = new EquipMaterial("brass", "ingotBrass", BRASS_MATERIAL, null, null, null, false, false, true);

    public String name;
    public Item.ToolMaterial toolMat;
    public ItemArmor.ArmorMaterial armorMat;
    public DefaultTool toolMatDefault;
    public DefaultArmor armorMatDefault;
    public Object repairMat;
    public boolean useObsidian = false;
    public boolean load = true;
    public boolean loadTools;
    public boolean loadArmor;
    public boolean loadSickle;

    public EquipMaterial(String name, Object repairMat, Item.ToolMaterial toolMat, DefaultTool toolMatDefault, ItemArmor.ArmorMaterial armorMat, DefaultArmor armorMatDefault, boolean loadTools, boolean loadArmor, boolean loadSickle){
        this.name = name;
        this.toolMat = toolMat;
        this.armorMat = armorMat;
        this.toolMatDefault = toolMatDefault;
        this.armorMatDefault = armorMatDefault;
        this.repairMat = repairMat;
        this.loadTools = loadTools;
        this.loadArmor = loadArmor;
        this.loadSickle = loadSickle;
    }

    public static void init(){
        registry.add(copper);
        registry.add(platinum);
        if(CopperTools.isPneumaticLoaded) registry.add(compressed);
        registry.add(lead);
        enderium.useObsidian = true;
        if(CopperTools.isTELoaded) registry.add(enderium);
        registry.add(silver);
        emerald.load = false;
        registry.add(emerald);
        if(CopperTools.isBluePowerLoaded) {
            registry.add(ruby);
            registry.add(sapphire);
            registry.add(amethyst);
        }
    }


    public static enum DefaultArmor { //Durability, Protection(Helm, Chest, Legs, Boots), Enchantibility
        COPPER(10, new int[]{2, 5, 4, 2}, 17),
        PLATINUM(12, new int[]{2, 6, 5, 2}, 25),
        LEAD(10, new int[]{3, 6, 5, 2}, 9),
        COMPRESSED(30, new int[]{2, 6, 5, 2}, 9),
        ENDERIUM(40, new int[]{3, 8, 6, 3}, 25),
        SILVER(15, new int[]{2, 7, 5, 2}, 17),
        HOLIDAY(5, new int[]{3, 8, 6, 3}, 25),
        EMERALD(33, new int[]{3, 8, 6, 3}, 10),
        GEM(27, new int[]{2, 6, 5, 2}, 17);

        private int durability;
        private int[] protection;
        private int enchant;
        DefaultArmor(int durability, int[] protection, int enchant){
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

    public static enum DefaultTool { //Mining level, durability, speed, damage, enchantibility
        COPPER(1, 131, 7, 1, 18),
        PLATINUM(2, 200, 12, 2, 22),
        LEAD(0, 131, 4, 0, 14),
        COMPRESSED(2, 500, 6, 2, 14),
        ENDERIUM(5, 2000, 10, 4, 22),
        SILVER(2, 250, 8, 2.5F, 18),
        HOLIDAY(0, 32, 12.0F, 0.0F, 22),
        EMERALD(3, 1561, 10.0F, 3.0F, 10);

        private int harvestLevel;
        private int durability;
        private float efficiency;
        private float damage;
        private int enchant;
        DefaultTool(int harvestLevel, int durability, float efficiency, float damage, int enchant){
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
