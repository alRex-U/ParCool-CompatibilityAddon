package com.alrexu.parcool.compat.extern.firstpersonmodel;

import com.alrex.parcool.client.animation.system.event.AnimationUpdateEvent;
import com.alrexu.parcool.compat.extern.ExternalModManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandlerForFirstPersonModel {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void onUpdateParCoolAnim(AnimationUpdateEvent.Pre event) {
        if (ExternalModManager.get(FirstPersonModelManager.class).isEnabled()) {
            event.stop();
        }
    }
}
