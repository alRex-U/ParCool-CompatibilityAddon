package com.alrexu.parcool.compat.extern;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;

public abstract class ModManager implements IModManager {
    private boolean installed;

    @Override
    public final void init(IEventBus modBus, IEventBus forgeBus) {
        var modFile = ModList.get().getModFileById(getModID());
        installed = modFile != null;
        if (isInstalled()) {
            this.initWhenInstalled(modBus, forgeBus);
        }
    }

    public abstract void initWhenInstalled(IEventBus modBus, IEventBus forgeBus);

    @Override
    public final boolean isInstalled() {
        return installed;
    }
}
