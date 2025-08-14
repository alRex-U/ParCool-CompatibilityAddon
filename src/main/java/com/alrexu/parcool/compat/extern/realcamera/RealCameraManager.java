package com.alrexu.parcool.compat.extern.realcamera;

import com.alrex.parcool.config.ParCoolConfig;
import com.alrexu.parcool.compat.extern.ModManager;
import net.minecraftforge.eventbus.api.IEventBus;

public class RealCameraManager extends ModManager {
    @Override
    public void initWhenInstalled(IEventBus modBus, IEventBus forgeBus) {
    }

    @Override
    public void initInClient(IEventBus modBus, IEventBus forgeBus) {
        if (isInstalled()) {
            ParCoolConfig.Client.Booleans.EnableFPVAnimation.set(true);
            forgeBus.register(EventHandlerForRealCamera.class);
        }
    }

    @Override
    public String getModID() {
        return "realcamera";
    }
}
