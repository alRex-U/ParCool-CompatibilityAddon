package com.alrexu.parcool.compat.extern.playeranimator;

import com.alrexu.parcool.compat.extern.ModManager;
import net.minecraftforge.eventbus.api.IEventBus;

public class PlayerAnimatorManager extends ModManager {

    @Override
    public void initWhenInstalled(IEventBus modBus, IEventBus forgeBus) {
        forgeBus.register(EventHandlerForPlayerAnimator.class);
    }

    @Override
    public String getModID() {
        return "playeranimator";
    }
}
