package com.alrexu.parcool.compat.extern.carryon;

import com.alrex.parcool.api.unstable.action.ParCoolActionEvent;
import com.alrex.parcool.api.unstable.animation.ParCoolAnimationInfoEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandlerForCarryOn {
    @SubscribeEvent
    public static void onUpdateParCoolAnimInfo(ParCoolAnimationInfoEvent event) {
        if (CarryOnManager.isCarrying(event.getPlayer())) {
            event.getOption().cancelAnimation();
        }
    }

    @SubscribeEvent
    public static void onTryToStart(ParCoolActionEvent.TryToStartEvent event) {
        if (CarryOnManager.isCarrying(event.getPlayer())) {
            event.setCanceled(true);
        }
    }
}
