package com.alrexu.parcool.compat.extern.bettercombat;

import com.alrex.parcool.client.animation.system.AnimatableModelPart;
import com.alrex.parcool.client.animation.system.event.AnimationUpdateEvent;
import net.bettercombat.logic.PlayerAttackHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandlerForBetterCombat {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onUpdateParCoolAnim(AnimationUpdateEvent.Post event) {
        var player = event.getPlayer();
        if (PlayerAttackHelper.isTwoHandedWielding(player) || PlayerAttackHelper.isDualWielding(player)) {
            event.stop(AnimatableModelPart.LEFT_ARM);
            event.stop(AnimatableModelPart.RIGHT_ARM);
        }
    }
}
