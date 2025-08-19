package com.alrexu.parcool.compat.mixin.realcamera;

import com.alrex.parcool.common.action.impl.Dive;
import com.alrex.parcool.common.action.impl.FastRun;
import com.alrex.parcool.common.action.impl.Slide;
import com.alrex.parcool.common.capability.Parkourability;
import com.xtracr.realcamera.config.ConfigFile;
import com.xtracr.realcamera.config.ModConfig;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ModConfig.class)
public class ModConfigMixin {
    @Inject(method = "shouldDisableModelPart", at = @At("HEAD"), cancellable = true)
    public void onShouldDisableModelPart(String modelPartName, CallbackInfoReturnable<Boolean> cir) {
        if (ConfigFile.modConfig.isClassic()) return;
        var player = Minecraft.getInstance().player;
        if (player == null) return;
        var parkourability = Parkourability.get(player);
        if (parkourability == null) return;

        if (modelPartName.equals("head")) {
            if (parkourability.get(FastRun.class).isDoing()
                    || parkourability.get(Slide.class).isDoing()
                    || parkourability.get(Dive.class).isDoing()
            ) {
                cir.setReturnValue(true);
            }
        } else {
            if (parkourability.get(Dive.class).isDoing()) {
                cir.setReturnValue(true);
            }
        }
    }
}
