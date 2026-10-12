package com.alrexu.parcool.compat.extern.tacz;

import com.alrex.parcool.client.animation.system.event.AnimationUpdateEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandlerForTaCZ {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onUpdateParCoolAnimPre(AnimationUpdateEvent.Pre event) {
        var player = event.getPlayer();
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onUpdateParCoolAnimPost(AnimationUpdateEvent.Post event) {
        var player = event.getPlayer();
    }
}
