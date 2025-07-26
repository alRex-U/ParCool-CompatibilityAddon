package com.alrexu.parcool.compat.extern.paraglider;

import com.alrexu.parcool.compat.extern.ModManager;
import net.minecraftforge.eventbus.api.IEventBus;

public class ParagliderManager extends ModManager {

    @Override
    public void initWhenInstalled(IEventBus modBus, IEventBus forgeBus) {
        forgeBus.register(EventHandlerForParaglider.class);
    }

    @Override
    public String getModID() {
        return "paraglider";
    }
}
