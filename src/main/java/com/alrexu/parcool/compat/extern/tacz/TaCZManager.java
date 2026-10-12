package com.alrexu.parcool.compat.extern.tacz;

import com.alrexu.parcool.compat.extern.ModManager;
import com.tacz.guns.api.TimelessAPI;
import net.minecraft.world.entity.player.Player;
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

    public boolean isHoldingGun(Player player) {
        if (!isInstalled()) return false;
        return TimelessAPI.getGunDisplay(player.getMainHandItem()).isPresent();
    }

    @Override
    public String getModID() {
        return "tacz";
    }
}
