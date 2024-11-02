package com.alrexu.parcool.compat.extern;

import net.minecraftforge.eventbus.api.IEventBus;

public interface IModManager {
    void init(IEventBus modBus, IEventBus forgeBus);

    boolean isInstalled();

    String getModID();
}
