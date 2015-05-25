package com.goldenapple.coppertools.item;

import com.goldenapple.coppertools.CopperToolsCreativeTab;
import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.reference.Reference;
import com.goldenapple.coppertools.util.OreHelper;
import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

import java.util.Set;

//Contains a lot of "stolen" code from CoFHCore https://github.com/CoFH/CoFHCore

public class ItemSickleCommon extends ItemTool {
    public static final Set<Material> effectiveMaterials = Sets.newHashSet(Material.leaves, Material.plants, Material.vine, Material.web);
    private static final Set<String> toolClasses = Sets.newHashSet("sickle");

    private EquipMaterial material;

    public ItemSickleCommon(EquipMaterial material){
        super(2.0F, material.toolMat, effectiveMaterials);
        if(CopperToolsCreativeTab.tabTools != null){
            setCreativeTab(CopperToolsCreativeTab.tabTools);
        }else{
            setCreativeTab(CreativeTabs.tabTools);
        }
        this.material = material;
    }

    @Override
    public boolean canHarvestBlock(Block block, ItemStack stack) {
        return block == Blocks.web || block == Blocks.vine;
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack) {
        return toolClasses;
    }

    @Override
    public float func_150893_a(ItemStack stack, Block block){ //Returns efficiency of mining given block
        return effectiveMaterials.contains(block.getMaterial()) ? efficiencyOnProperMaterial : 1.0F;
    }

    @Override
    public boolean isItemTool(ItemStack stack){
        return true;
    }

    public void harvestBlock(World world, int x, int y, int z, EntityPlayer player){
        Block block = world.getBlock(x, y, z);
        if (block.getBlockHardness(world, x, y, z) < 0 || block.equals(Blocks.waterlily)) {
            return;
        }
        int bMeta = world.getBlockMetadata(x, y, z);

        if (block.canHarvestBlock(player, bMeta)) {
            block.harvestBlock(world, player, x, y, z, bMeta);
        }
        if (!world.isRemote && block.equals(Blocks.vine)) {
            block.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 1);
        }
        world.setBlockToAir(x, y, z);
    }

    public boolean harvest(World world, Block block, int x, int y, int z, EntityPlayer player){ //i'm not doing all of this in the onBlockDestroyed because of other sickles that handle damage differently
        boolean used = false;

        if(block.getMaterial().equals(Material.leaves)) { //Harvesting leaves in a 3x3x3 area
            for (int a = x - 1; a <= x + 1; a++) {
                for (int b = y - 1; b <= y + 1; b++){
                    for (int c = z - 1; c <= z + 1; c++) {
                        if (effectiveMaterials.contains(world.getBlock(a, b, c).getMaterial())) {
                            harvestBlock(world, a, b, c, player);
                            used = true;
                        }
                    }
                }
            }
        }else{ //Harvesting grass in a 3x1x3 area
            for (int a = x - 1; a <= x + 1; a++) {
                for (int c = z - 1; c <= z + 1; c++) {
                    if (effectiveMaterials.contains(world.getBlock(a, y, c).getMaterial())) {
                        harvestBlock(world, a, y, c, player);
                        used = true;
                    }
                }
            }
        }
        return used;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
        /* EntityPlayer player = (EntityPlayer) entity;
        boolean used = false;

        if(!block.getMaterial().equals(Material.leaves)) { //Harvesting plants in a 3x1x3 area
            for (int i = x - 1; i <= x + 1; i++) {
                for (int k = z - 1; k <= z + 1; k++) {
                    if (effectiveMaterials.contains(world.getBlock(i, y, k).getMaterial())) {
                        harvestBlock(world, i, y, k, player);
                        used = true;
                    }
                }
            }
        }else{ //Harvesting leaves in a 3x3x3 area
            for (int a = x - 1; a <= x + 1; a++) {
                for (int b = y - 1; b <= y + 1; b++){
                    for (int c = z - 1; c <= z + 1; c++) {
                        if (effectiveMaterials.contains(world.getBlock(a, b, c).getMaterial())) {
                            harvestBlock(world, a, b, c, player);
                            used = true;
                        }
                    }
                }
            }
        }

        if (used) {
            if(!player.capabilities.isCreativeMode) {
                stack.damageItem(1, entity);
            }
        }
        return used; */
        if(entity instanceof EntityPlayer) {
            if (!((EntityPlayer) entity).capabilities.isCreativeMode) {
                itemStack.damageItem(1, entity);
            }
            return harvest(world, block, x, y, z, (EntityPlayer)entity);
        }
        return false;
    }

    @Override
    public boolean getIsRepairable(ItemStack tool, ItemStack item){
        if (material.repairMat instanceof String){
            return OreHelper.isItemThisOre(item, (String)material.repairMat);
        }else if(material.repairMat instanceof ItemStack){
            return item.isItemEqual((ItemStack)material.repairMat);
        }
        return false;
    }

    @Override
    public String getUnlocalizedName(){
        return "item." + Reference.MOD_ID.toLowerCase() + ":" + material.name + "_sickle";
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        return getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        if(material.useObsidian){
            itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + material.name + "_sickle_o");
        }else {
            itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + material.name + "_sickle");
        }
    }
}