package com.alrexu.parcool.compat.mixin.realcamera;

import com.alrex.parcool.common.action.impl.FastRun;
import com.alrex.parcool.common.action.impl.Slide;
import com.alrex.parcool.common.capability.Parkourability;
import com.xtracr.realcamera.RealCameraCore;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RealCameraCore.class, remap = false)
public class RealCameraCoreMixin {
    @Shadow
    private static float pitch;

    @Shadow
    private static float roll;

    @Shadow
    private static Vec3 pos;

    @Shadow
    private static float yaw;

    @Inject(method = "computeCamera", at = @At("RETURN"))
    private static void onComputeCamera(Minecraft client, float tickDelta, CallbackInfo ci) {
        var player = client.player;
        if (player == null) return;
        var parkourability = Parkourability.get(player);
        if (parkourability == null) return;
        if (parkourability.get(Slide.class).isDoing()) {
            pitch = player.getViewXRot(tickDelta);
            roll = 0;
            yaw = player.getViewYRot(tickDelta);
            pos = pos.add(0, 0.2, 0);
            return;
        }
        if (parkourability.get(FastRun.class).isDoing()) {
            roll = 0;
            pos.add(player.getLookAngle().normalize());
        }
    }
}
