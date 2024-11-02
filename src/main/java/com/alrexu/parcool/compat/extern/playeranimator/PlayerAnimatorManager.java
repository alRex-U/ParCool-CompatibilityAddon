package com.alrexu.parcool.compat.extern.playeranimator;

import com.alrexu.parcool.compat.extern.IModManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;

public class PlayerAnimatorManager implements IModManager {
    private static boolean installed = false;

    @Override
    public void init(IEventBus modBus, IEventBus forgeBus) {
        var modFile = ModList.get().getModFileById(getModID());
        installed = modFile != null;
        if (installed) {
            forgeBus.register(EventHandlerForPlayerAnimator.class);
        }
    }

    @Override
    public boolean isInstalled() {
        return installed;
    }

    @Override
    public String getModID() {
        return "playeranimator";
    }
}
