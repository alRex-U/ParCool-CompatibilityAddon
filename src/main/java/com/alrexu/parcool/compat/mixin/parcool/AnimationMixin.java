package com.alrexu.parcool.compat.mixin.parcool;

import com.alrex.parcool.common.capability.Animation;
import com.alrexu.parcool.compat.extern.ExternalModManager;
import com.alrexu.parcool.compat.extern.firstpersonmodel.FirstPersonModelManager;
import com.alrexu.parcool.compat.extern.realcamera.RealCameraManager;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Animation.class, remap = false)
public class AnimationMixin {
    @Inject(method = "shouldCancelAnimation", at = @At("HEAD"), cancellable = true)
    public void onShouldCancelAnimation(Player player, CallbackInfoReturnable<Boolean> cir) {
        if (!player.isLocalPlayer()) return;
        if (Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
            if (ExternalModManager.get(RealCameraManager.class).isRealCameraActive()) {
                cir.setReturnValue(false);
                return;
            }
            if (ExternalModManager.get(FirstPersonModelManager.class).isEnabled()) {
                cir.setReturnValue(false);
                return;
            }
        }
    }
}
