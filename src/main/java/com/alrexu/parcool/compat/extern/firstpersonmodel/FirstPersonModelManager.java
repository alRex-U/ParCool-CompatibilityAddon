package com.alrexu.parcool.compat.extern.firstpersonmodel;

import com.alrexu.parcool.compat.extern.ModManager;
import dev.tr7zw.firstperson.api.FirstPersonAPI;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;

public class FirstPersonModelManager extends ModManager {
    @Override
    public void initWhenInstalled(IEventBus modBus, IEventBus forgeBus) {
    }

    @Override
    public void initInClient(IEventBus modBus, IEventBus forgeBus) {
        if (isInstalled()) {
            MinecraftForge.EVENT_BUS.register(new EventHandlerForFirstPersonModel());
        }
    }

    @Override
    public String getModID() {
        return "firstperson";
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isEnabled() {
        return isInstalled() && FirstPersonAPI.isEnabled();
    }
}
