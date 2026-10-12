package com.alrexu.parcool.compat.extern.carryon;

import com.alrex.parcool.api.action.ParCoolActionEvent;
import com.alrex.parcool.client.animation.system.event.AnimationUpdateEvent;
import com.alrexu.parcool.compat.extern.ExternalModManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandlerForCarryOn {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onUpdateParCoolAnim(AnimationUpdateEvent.Pre event) {
        if (ExternalModManager.get(CarryOnManager.class).isCarrying(event.getPlayer())) {
            event.stop();
        }
    }

    @SubscribeEvent
    public static void onTryToStart(ParCoolActionEvent.TryToStart event) {
        if (ExternalModManager.get(CarryOnManager.class).isCarrying(event.getPlayer())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onTryToContinue(ParCoolActionEvent.TryToContinue event) {
        if (ExternalModManager.get(CarryOnManager.class).isCarrying(event.getPlayer())) {
            event.setCanceled(true);
        }
    }
}
