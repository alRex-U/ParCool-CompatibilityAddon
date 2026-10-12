package com.alrexu.parcool.compat.extern.paraglider;

import com.alrex.parcool.api.action.ParCoolActionEvent;
import com.alrex.parcool.client.animation.system.event.AnimationUpdateEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import tictim.paraglider.contents.item.ParagliderItem;

public class EventHandlerForParaglider {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onUpdateParCoolAnim(AnimationUpdateEvent.Pre event) {
        if (ParagliderItem.isItemParagliding(event.getPlayer().getMainHandItem())) {
            event.stop();
        }
    }

    @SubscribeEvent
    public static void onTryToStart(ParCoolActionEvent.TryToStart event) {
        if (ParagliderItem.isItemParagliding(event.getPlayer().getMainHandItem())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onTryToContinue(ParCoolActionEvent.TryToContinue event) {
        if (ParagliderItem.isItemParagliding(event.getPlayer().getMainHandItem())) {
            event.setCanceled(true);
        }
    }
}
