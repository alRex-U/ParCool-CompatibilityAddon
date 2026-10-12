package com.alrexu.parcool.compat.event;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraftforge.eventbus.api.Event;

public class CancelCancellingPlayerModelRotationEvent extends Event {
    private final AbstractClientPlayer player;

    public CancelCancellingPlayerModelRotationEvent(AbstractClientPlayer player) {
        this.player = player;
    }

    public AbstractClientPlayer getPlayer() {
        return player;
    }

    @Override
    public boolean isCancelable() {
        return true;
    }
}
