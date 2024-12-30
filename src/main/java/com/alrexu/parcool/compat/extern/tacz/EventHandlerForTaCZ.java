package com.alrexu.parcool.compat.extern.tacz;

import com.alrex.parcool.api.unstable.animation.AnimationPart;
import com.alrex.parcool.api.unstable.animation.ParCoolAnimationInfoEvent;
import com.alrex.parcool.client.animation.impl.*;
import com.tacz.guns.api.item.gun.AbstractGunItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandlerForTaCZ {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onUpdateParCoolAnimInfo(ParCoolAnimationInfoEvent event) {
        if (event.getPlayer().getMainHandItem().getItem() instanceof AbstractGunItem) {

            if (event.getAnimator() instanceof DiveAnimationHostAnimator
                    || event.getAnimator() instanceof DiveIntoWaterAnimator
                    || event.getAnimator() instanceof FastSwimAnimator
                    || event.getAnimator() instanceof DodgeAnimator
                    || event.getAnimator() instanceof KongVaultAnimator
                    || event.getAnimator() instanceof SpeedVaultAnimator
                    || event.getAnimator() instanceof ChargeJumpAnimator
                    || event.getAnimator() instanceof JumpChargingAnimator
                    || event.getAnimator() instanceof ClingToCliffAnimator
                    || event.getAnimator() instanceof BackwardWallJumpAnimator
                    || event.getAnimator() instanceof WallJumpAnimator
                    || event.getAnimator() instanceof ClimbUpAnimator
                    || event.getAnimator() instanceof FlippingAnimator
                    || event.getAnimator() instanceof HangAnimator
                    || event.getAnimator() instanceof JumpFromBarAnimator
                    || event.getAnimator() instanceof VerticalWallRunAnimator
                    || event.getAnimator() instanceof WallSlideAnimator
                    || event.getAnimator() instanceof TapAnimator
            ) {
                return;
            }

            if (event.getAnimator() instanceof FastRunningAnimator) {
                event.getOption().cancel(AnimationPart.LEFT_LEG);
                event.getOption().cancel(AnimationPart.RIGHT_LEG);
                event.getOption().cancel(AnimationPart.LEFT_ARM);
                event.getOption().cancel(AnimationPart.RIGHT_ARM);
                return;
            }

            if (event.getAnimator() instanceof CrawlAnimator) {
                event.getOption().cancelAnimation();
                return;
            }
            event.getOption().cancel(AnimationPart.LEFT_ARM);
            event.getOption().cancel(AnimationPart.RIGHT_ARM);
        }
    }
}
