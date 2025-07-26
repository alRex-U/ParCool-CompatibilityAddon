package com.alrexu.parcool.compat.extern.carryon;

import com.alrexu.parcool.compat.extern.ModManager;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import tschipp.carryon.common.carry.CarryOnDataManager;

public class CarryOnManager extends ModManager {

    @Override
    public void initWhenInstalled(IEventBus modBus, IEventBus forgeBus) {
        forgeBus.register(EventHandlerForCarryOn.class);
    }

    public boolean isCarrying(Player player) {
        if (!isInstalled()) return false;
        return CarryOnDataManager.getCarryData(player).isCarrying();
    }

    @Override
    public String getModID() {
        return "carryon";
    }
}