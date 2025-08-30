package com.alrexu.parcool.compat.extern.bettercombat;

import com.alrexu.parcool.compat.extern.ModManager;
import net.minecraftforge.eventbus.api.IEventBus;

public class BetterCombatManager extends ModManager {

    @Override
    public void initWhenInstalled(IEventBus modBus, IEventBus forgeBus) {
    }

    @Override
    public void initInClient(IEventBus modBus, IEventBus forgeBus) {
        if (isInstalled()) {
            forgeBus.register(EventHandlerForBetterCombat.class);
        }
    }

    @Override
    public String getModID() {
        return "bettercombat";
    }
}
