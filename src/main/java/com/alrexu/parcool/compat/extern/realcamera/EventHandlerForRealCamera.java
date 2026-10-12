package com.alrexu.parcool.compat.extern.realcamera;

import com.alrex.parcool.client.animation.system.event.AnimationUpdateEvent;
import com.alrex.parcool.common.Parkourability;
import com.alrex.parcool.common.action.ParCoolActions;
import com.alrexu.parcool.compat.event.CancelCancellingPlayerModelRotationEvent;
import com.xtracr.realcamera.RealCameraCore;
import com.xtracr.realcamera.config.ConfigFile;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandlerForRealCamera {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onUpdateParCoolAnim(AnimationUpdateEvent.Pre event) {
        if (!RealCameraCore.isActive() || ConfigFile.modConfig.isClassic()) return;
        if (!event.getPlayer().isLocalPlayer()) return;
        if (Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
            if (Parkourability.get(event.getPlayer()).get(ParCoolActions.DIVE).isDoing()) {
                event.stop();
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onCancelCancellingRotation(CancelCancellingPlayerModelRotationEvent event) {
        if (!RealCameraCore.isActive() || ConfigFile.modConfig.isClassic()) return;
        if (Minecraft.getInstance().options.getCameraType().isFirstPerson() && event.getPlayer().isLocalPlayer()) {
            event.setCanceled(true);
        }
    }
}
