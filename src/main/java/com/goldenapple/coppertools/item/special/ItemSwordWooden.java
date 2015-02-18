package com.goldenapple.coppertools.item.special;

import com.goldenapple.coppertools.item.ItemSwordCommon;
import com.goldenapple.coppertools.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemSwordWooden extends ItemSwordCommon {
    public ItemSwordWooden(){
        super(ToolMaterial.STONE, Names.woodKatana, "logWood", false);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean what) {
        list.add(StatCollector.translateToLocal("coppertools.tooltip.katana1"));
        if(!StatCollector.translateToLocal("coppertools.tooltip.katana2").equals("")) {
            list.add(StatCollector.translateToLocal("coppertools.tooltip.katana2"));
        }
    }
}
