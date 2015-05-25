package com.goldenapple.coppertools.item.special;

import com.goldenapple.coppertools.init.EquipMaterial;
import com.goldenapple.coppertools.item.ItemSickleCommon;
import cpw.mods.fml.common.Optional;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;

import java.util.List;

@Optional.Interface(iface = "vazkii.botania.api.mana.IManaUsingItem", modid = "Botania")
public class ItemSickleElementium extends ItemSickleCommon implements IManaUsingItem {
    private static int MANA_PER_DAMAGE = 60;
    public static EquipMaterial elementium = new EquipMaterial("elementium", "ingotElementium", BotaniaAPI.elementiumToolMaterial, null, null, null, false, false, true);

    public ItemSickleElementium(){
        super(elementium);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityAttacked, EntityLivingBase entityAttacker) {
        World world = entityAttacked.worldObj;
        List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(entityAttacker, AxisAlignedBB.getBoundingBox(entityAttacked.posX - 1.5, entityAttacked.posY - 3, entityAttacked.posZ - 1.5, entityAttacked.posX + 1.5, entityAttacked.posY + 3, entityAttacked.posZ + 1.5));
        for(Entity entity : list){
            if(entity instanceof EntityLivingBase){
                entity.attackEntityFrom(DamageSource.causeMobDamage(entityAttacker), 3.0F);
            }
        }

        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
        if(entity instanceof EntityPlayer) {
            if (harvest(world, block, x, y, z, (EntityPlayer) entity)) {
                if (!((EntityPlayer) entity).capabilities.isCreativeMode) {
                    if(!ManaItemHandler.requestManaExactForTool(itemStack, (EntityPlayer) entity, MANA_PER_DAMAGE, true)) {
                        itemStack.damageItem(1, entity);
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity player, int wat, boolean wtf) {
        if(!world.isRemote && player instanceof EntityPlayer && itemStack.getItemDamage() > 0 && ManaItemHandler.requestManaExactForTool(itemStack, (EntityPlayer) player, MANA_PER_DAMAGE * 2, true)) {
            itemStack.setItemDamage(itemStack.getItemDamage() - 1);
        }
    }

    @Override
    @Optional.Method(modid = "Botania")
    public boolean usesMana(ItemStack itemStack) {
        return true;
    }

    //Shamelessly stolen from Botaina :D https://github.com/Vazkii/Botania/blob/master/src/main/java/vazkii/botania/common/item/equipment/tool/ToolCommons.java
    public static void damageItem(ItemStack itemStack, int dmg, EntityLivingBase entity, int manaPerDamage) {
        int manaToRequest = dmg * manaPerDamage;
        boolean manaRequested = entity instanceof EntityPlayer && ManaItemHandler.requestManaExactForTool(itemStack, (EntityPlayer) entity, manaToRequest, true);

        if(!manaRequested)
            itemStack.damageItem(dmg, entity);
    }
}

