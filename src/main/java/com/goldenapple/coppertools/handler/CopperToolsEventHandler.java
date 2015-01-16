package com.goldenapple.coppertools.handler;

import com.goldenapple.coppertools.config.ConfigHandler;
import com.goldenapple.coppertools.reference.Reference;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

import java.util.*;

public class CopperToolsEventHandler {
    Random rand = new Random();

    @SubscribeEvent
    public void onEntityDrops(LivingDropsEvent event) {
        if(isChristmas()){
            String item = "christmas_pickaxe";
            int chance = ConfigHandler.chanceOfGoodChristmas * 10; //multiplied by 10 because there is a chance to get 10 different tools/armor pieces

            if(!event.source.damageType.equals("player")) return;
            if(event.entityLiving instanceof EntityPlayer) chance = 10; //always drops from players
            if(event.entityLiving instanceof IMob || event.entityLiving instanceof EntityPlayer){
                int got = rand.nextInt(chance);
                if (got < 10) {
                    switch (got) {
                        case 0: item = "christmas_pickaxe"; break;
                        case 1: item = "christmas_sword"; break;
                        case 2: item = "christmas_shovel"; break;
                        case 3: item = "christmas_axe"; break;
                        case 4: item = "christmas_hoe"; break;
                        case 5: item = "christmas_sickle"; break;
                        case 6: item = "christmas_helmet"; break;
                        case 7: item = "christmas_chestplate"; break;
                        case 8: item = "christmas_leggings"; break;
                        case 9: item = "christmas_boots"; break;
                    }
                    addDrop(event, new ItemStack(GameRegistry.findItem(Reference.MOD_ID, item)));
                }
            }
        }
    }

    //@author SpitefulFox
    private static void addDrop(LivingDropsEvent event, ItemStack drop) {
        EntityItem entityitem = new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, drop);
        entityitem.delayBeforeCanPickup = 10;
        event.drops.add(entityitem);
    }

    //Similar to vanilla chest rendering code
    public static boolean isChristmas(){
        Calendar calendar = Calendar.getInstance();
        if(calendar.get(Calendar.MONTH) == Calendar.DECEMBER && calendar.get(Calendar.DAY_OF_MONTH) >= 24) return true;
        else if(calendar.get(Calendar.MONTH) == Calendar.JANUARY && calendar.get(Calendar.DAY_OF_MONTH) <= 7) return true; //Over here in Ukraine we celebrate Christmas on thr 6th of January
        else return false;
    }
}
