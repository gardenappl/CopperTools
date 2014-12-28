package com.goldenapple.coppertools.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.monster.EntityMob;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.Random;

public class CopperToolsEventHandler {
    @SubscribeEvent
    public void onEntityDrops(LivingDropsEvent event){
        Random rand = new Random(Minecraft.getMinecraft().theWorld.getSeed()); //why not?
        if(event.source.damageType.equals("player") && event.entityLiving instanceof EntityMob){
            if(rand.nextInt(100)){

            }
        }
    }
}
