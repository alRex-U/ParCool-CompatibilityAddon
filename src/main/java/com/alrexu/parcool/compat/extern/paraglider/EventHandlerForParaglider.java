package com.alrexu.parcool.compat.extern.paraglider;

import com.alrex.parcool.api.unstable.action.ParCoolActionEvent;
import com.alrex.parcool.api.unstable.animation.ParCoolAnimationInfoEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import tictim.paraglider.item.ParagliderItem;

public class EventHandlerForParaglider {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onUpdateParCoolAnimInfo(ParCoolAnimationInfoEvent event) {
        if (ParagliderItem.isItemParagliding(event.getPlayer().getMainHandItem())) {
            event.getOption().cancelAnimation();
        }
    }

    @SubscribeEvent
    public static void onTryToStart(ParCoolActionEvent.TryToStartEvent event) {
        if (ParagliderItem.isItemParagliding(event.getPlayer().getMainHandItem())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onTryToContinue(ParCoolActionEvent.TryToContinueEvent event) {
        if (ParagliderItem.isItemParagliding(event.getPlayer().getMainHandItem())) {
            event.setCanceled(true);
        }
    }
}
