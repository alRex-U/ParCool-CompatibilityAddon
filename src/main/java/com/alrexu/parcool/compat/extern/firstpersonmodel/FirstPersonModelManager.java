package com.alrexu.parcool.compat.extern.firstpersonmodel;

import com.alrexu.parcool.compat.extern.ModManager;
import dev.tr7zw.firstperson.api.FirstPersonAPI;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;

public class FirstPersonModelManager extends ModManager {
    @Override
    public void initWhenInstalled(IEventBus modBus, IEventBus forgeBus) {
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
