package com.alrexu.parcool.compat.mixin.tacz;

import com.alrex.parcool.client.animation.system.IPlayerAnimatorHolder;
import com.alrexu.parcool.compat.extern.ExternalModManager;
import com.alrexu.parcool.compat.extern.tacz.TaCZManager;
import com.tacz.guns.client.animation.third.InnerThirdPersonManager;
import com.tacz.guns.compat.playeranimator.PlayerAnimatorCompat;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = InnerThirdPersonManager.class, remap = false)
public class InnerThirdPersonManagerMixin {
    @Inject(method = "setRotationAnglesHead", at = @At("HEAD"), cancellable = true, remap = false)
    private static void onSetupRotationAnglesHeadHead(LivingEntity entityIn, ModelPart rightArm, ModelPart leftArm, ModelPart body, ModelPart head, float limbSwingAmount, CallbackInfo ci) {
        if (entityIn instanceof AbstractClientPlayer player
                && ExternalModManager.get(TaCZManager.class).isHoldingGun(player)
                && entityIn instanceof IPlayerAnimatorHolder holder
        ) {
            if (!holder.getParCoolPlayerAnimator().isIdle()) {
                PlayerAnimatorCompat.stopAllAnimation(entityIn, 1);
                ci.cancel();
            }
        }
    }
}
