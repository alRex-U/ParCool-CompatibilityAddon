package com.alrexu.parcool.compat.mixin.parcool;

import com.alrex.parcool.client.animation.system.AnimationProcessor;
import com.alrex.parcool.client.animation.system.PlayerAnimator;
import com.alrexu.parcool.compat.event.CancelCancellingPlayerModelRotationEvent;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PlayerAnimator.class, remap = false)
public class PlayerAnimatorMixin {
    @Shadow
    @Final
    private AnimationProcessor animationProcessor;

    @Inject(method = "cancelPlayerModelRotation", at = @At("HEAD"), cancellable = true)
    public void onCancelPlayerModelRotation(CallbackInfoReturnable<Boolean> cir) {
        if (MinecraftForge.EVENT_BUS.post(new CancelCancellingPlayerModelRotationEvent(animationProcessor.getOwner()))) {
            cir.setReturnValue(false);
        }
    }
}
