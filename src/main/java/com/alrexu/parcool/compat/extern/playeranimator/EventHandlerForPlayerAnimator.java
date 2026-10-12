package com.alrexu.parcool.compat.extern.playeranimator;

import com.alrex.parcool.client.animation.system.event.AnimationUpdateEvent;
import com.alrexu.parcool.compat.extern.ExternalModManager;
import com.alrexu.parcool.compat.extern.tacz.TaCZManager;
import dev.kosmx.playerAnim.api.IPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class EventHandlerForPlayerAnimator {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onUpdateParCoolAnim(AnimationUpdateEvent.Pre event) {
        var player = event.getPlayer();
        if (player instanceof IPlayer animPlayer
                && animPlayer.getAnimationStack().isActive()
                && !ExternalModManager.get(TaCZManager.class).isHoldingGun(player)
        ) {
            event.stop();
        }
    }
}
