package com.goldenapple.coppertools.handler;

import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.reference.Reference;
import com.goldenapple.coppertools.util.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.*;

public class CopperToolsEventHandler {
    @SubscribeEvent
    public void onEntityDrops(LivingDropsEvent event) {
        if(isHoliday()){
            String item = "christmas_pickaxe";
            Random rand = new Random();
            int chance = ConfigHandler.chanceOfGoodChristmas * 10;

            if(!event.source.damageType.equals("player")) return; else LogHelper.info("player!");
            if(event.entityLiving instanceof EntityPlayer) chance = 10; //always drops from players
            if(event.entityLiving instanceof IMob || event.entityLiving instanceof EntityPlayer){
                int got = rand.nextInt(chance);
                LogHelper.info("chance: " + got + " out of " + chance);
                if (got < 10) {
                    switch (got) {
                        case 0: item = "christmas_pickaxe";
                        case 1: item = "christmas_sword";
                        case 2: item = "christmas_shovel";
                        case 3: item = "christmas_axe";
                        case 4: item = "christmas_hoe";
                        case 5: item = "christmas_sickle";
                        case 6: item = "christmas_helmet";
                        case 7: item = "christmas_chestplate";
                        case 8: item = "christmas_leggings";
                        case 9: item = "christmas_boots";
                    }
                    addDrop(event, new ItemStack(GameRegistry.findItem(Reference.MOD_ID, item)));
                }
            }else{
                LogHelper.info("illegal entity! stop right there you criminal!");
            }
        }
    }

    /*
        @author SpitefulFox
    */
    private static void addDrop(LivingDropsEvent event, ItemStack drop) {
        EntityItem entityitem = new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, drop);
        entityitem.delayBeforeCanPickup = 10;
        event.drops.add(entityitem);
    }

    //Similar to vanilla chest rendering code
    public static boolean isHoliday(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) == Calendar.DECEMBER && calendar.get(Calendar.DAY_OF_MONTH) >= 24 && calendar.get(Calendar.DAY_OF_MONTH) <= 31;
    }
}
