package com.alrexu.parcool.compat.extern.carryon;

import com.alrex.parcool.api.unstable.action.ParCoolActionEvent;
import com.alrex.parcool.api.unstable.animation.ParCoolAnimationInfoEvent;
import com.alrexu.parcool.compat.extern.ExternalModManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandlerForCarryOn {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onUpdateParCoolAnimInfo(ParCoolAnimationInfoEvent event) {
        if (ExternalModManager.get(CarryOnManager.class).isCarrying(event.getPlayer())) {
            event.getOption().cancelAnimation();
        }
    }

    @SubscribeEvent
    public static void onTryToStart(ParCoolActionEvent.TryToStartEvent event) {
        if (ExternalModManager.get(CarryOnManager.class).isCarrying(event.getPlayer())) {
            event.setCanceled(true);
        }
    }
}
