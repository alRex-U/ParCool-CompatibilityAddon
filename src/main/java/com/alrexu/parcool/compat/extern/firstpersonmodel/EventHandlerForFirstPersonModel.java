package com.alrexu.parcool.compat.extern.firstpersonmodel;

import com.alrexu.parcool.compat.event.CancelCancellingPlayerModelRotationEvent;
import com.alrexu.parcool.compat.extern.ExternalModManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandlerForFirstPersonModel {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onCancelCancellingRotation(CancelCancellingPlayerModelRotationEvent event) {
        if (ExternalModManager.get(FirstPersonModelManager.class).isEnabled()) {
            event.setCanceled(true);
        }
    }
}
