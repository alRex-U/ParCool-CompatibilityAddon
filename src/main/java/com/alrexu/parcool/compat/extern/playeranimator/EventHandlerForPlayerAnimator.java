package com.alrexu.parcool.compat.extern.playeranimator;

import com.alrex.parcool.api.unstable.animation.ParCoolAnimationInfoEvent;
import com.alrex.parcool.client.animation.impl.CrawlAnimator;
import com.alrex.parcool.client.animation.impl.FastRunningAnimator;
import com.alrex.parcool.client.animation.impl.FastSwimAnimator;
import dev.kosmx.playerAnim.api.IPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandlerForPlayerAnimator {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onUpdateParCoolAnimInfo(ParCoolAnimationInfoEvent event) {
        var player = event.getPlayer();
        if (player instanceof IPlayer animPlayer && animPlayer.getAnimationStack().isActive()) {
            var animator = event.getAnimator();
            if (animator instanceof FastRunningAnimator
                    || animator instanceof FastSwimAnimator
                    || animator instanceof CrawlAnimator
            ) {
                event.getOption().cancelAnimation();
            }
        }
    }
}
