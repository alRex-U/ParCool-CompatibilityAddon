package com.alrexu.parcool.compat.extern.realcamera;

import com.alrex.parcool.api.unstable.animation.AnimationPart;
import com.alrex.parcool.api.unstable.animation.ParCoolAnimationInfoEvent;
import com.alrex.parcool.common.action.impl.Dive;
import com.alrex.parcool.common.capability.Parkourability;
import com.alrexu.parcool.compat.extern.ExternalModManager;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandlerForRealCamera {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onParCoolAnimationInfo(ParCoolAnimationInfoEvent event) {
        var player = event.getPlayer();
        if (!player.isLocalPlayer()) return;
        if (Minecraft.getInstance().options.getCameraType() != CameraType.FIRST_PERSON) return;
        if (!ExternalModManager.get(RealCameraManager.class).isRealCameraActive()) return;

        var parkourability = Parkourability.get(player);
        if (parkourability == null) return;
        if (parkourability.get(Dive.class).isDoing()) {
            event.getOption().cancel(AnimationPart.LEFT_ARM);
            event.getOption().cancel(AnimationPart.RIGHT_ARM);
        }
    }
}
