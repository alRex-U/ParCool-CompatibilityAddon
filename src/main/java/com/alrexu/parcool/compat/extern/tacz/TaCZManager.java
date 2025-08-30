package com.alrexu.parcool.compat.extern.tacz;

import com.alrexu.parcool.compat.extern.ModManager;
import net.minecraftforge.eventbus.api.IEventBus;

public class TaCZManager extends ModManager {

    @Override
    public void initWhenInstalled(IEventBus modBus, IEventBus forgeBus) {
    }

    @Override
    public void initInClient(IEventBus modBus, IEventBus forgeBus) {
        if (isInstalled()) {
            forgeBus.register(EventHandlerForTaCZ.class);
        }
    }

    @Override
    public String getModID() {
        return "tacz";
    }
}
