package com.alrexu.parcool.compat.extern;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;

public interface IModManager {
    void init(IEventBus modBus, IEventBus forgeBus);

    // These are called after `init` method
    @OnlyIn(Dist.CLIENT)
    default void initInClient(IEventBus modBus, IEventBus forgeBus) {
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    default void initInDedicatedServer(IEventBus modBus, IEventBus forgeBus) {
    }

    boolean isInstalled();

    String getModID();
}
