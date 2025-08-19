package com.alrexu.parcool.compat.extern.realcamera;

import com.alrex.parcool.api.unstable.animation.ParCoolAnimationInfoEvent;
import com.alrex.parcool.client.animation.impl.DiveAnimationHostAnimator;
import com.xtracr.realcamera.RealCameraCore;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandlerForRealCamera {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onUpdateParCoolAnimInfo(ParCoolAnimationInfoEvent event) {
        if (!RealCameraCore.isActive()) return;
        if (!event.getPlayer().isLocalPlayer()) return;
        if (Minecraft.getInstance().options.getCameraType() == CameraType.FIRST_PERSON) {
            if (event.getAnimator() instanceof DiveAnimationHostAnimator) {
                event.getOption().cancelAnimation();
            }
        }
    }
}
