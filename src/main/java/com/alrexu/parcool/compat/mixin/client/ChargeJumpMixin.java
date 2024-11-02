package com.alrexu.parcool.compat.mixin.client;

import com.alrex.parcool.common.action.Action;
import com.alrex.parcool.common.action.impl.ChargeJump;
import com.alrex.parcool.common.capability.IStamina;
import com.alrex.parcool.common.capability.Parkourability;
import com.alrexu.parcool.compat.extern.carryon.CarryOnManager;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ChargeJump.class, remap = false)
public abstract class ChargeJumpMixin extends Action {
    @Shadow
    private int chargeTick;

    @Inject(method = "onClientTick", at = @At("HEAD"), cancellable = true)
    public void clientTick(Player player, Parkourability parkourability, IStamina stamina, CallbackInfo ci) {
        if (player.isLocalPlayer() && CarryOnManager.isCarrying(player)) {
            chargeTick = 0;
            ci.cancel();
        }
    }
}
