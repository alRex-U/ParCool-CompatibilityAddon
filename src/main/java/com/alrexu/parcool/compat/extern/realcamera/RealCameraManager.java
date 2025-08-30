package com.alrexu.parcool.compat.extern.realcamera;

import com.alrexu.parcool.compat.extern.ModManager;
import com.xtracr.realcamera.RealCameraCore;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;

public class RealCameraManager extends ModManager {
    @Override
    public void initWhenInstalled(IEventBus modBus, IEventBus forgeBus) {
    }

    @Override
    public void initInClient(IEventBus modBus, IEventBus forgeBus) {
        if (isInstalled()) {
            forgeBus.register(EventHandlerForRealCamera.class);
        }
    }

    @Override
    public String getModID() {
        return "realcamera";
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isRealCameraActive() {
        return isInstalled() && RealCameraCore.isActive();
    }
}
