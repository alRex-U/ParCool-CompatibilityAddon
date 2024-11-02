package com.alrexu.parcool.compat.extern.carryon;

import com.alrexu.parcool.compat.extern.IModManager;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import tschipp.carryon.common.carry.CarryOnDataManager;

public class CarryOnManager implements IModManager {
    private static boolean installed = false;

    @Override
    public void init(IEventBus modBus, IEventBus forgeBus) {
        var modFile = ModList.get().getModFileById(getModID());
        installed = modFile != null;
        if (installed) {
            forgeBus.register(EventHandlerForCarryOn.class);
        }
    }

    public static boolean isCarrying(Player player) {
        if (!installed) return false;
        return CarryOnDataManager.getCarryData(player).isCarrying();
    }

    @Override
    public boolean isInstalled() {
        return installed;
    }

    @Override
    public String getModID() {
        return "carryon";
    }
}