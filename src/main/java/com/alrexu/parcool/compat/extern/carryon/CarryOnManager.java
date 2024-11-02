package com.alrexu.parcool.compat.extern.carryon;

import com.alrexu.parcool.compat.extern.IModManager;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import tschipp.carryon.common.handler.RegistrationHandler;

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
        var stack = player.getMainHandItem();
        var item = stack.getItem();
        return !stack.isEmpty() && (item == RegistrationHandler.itemTile || item == RegistrationHandler.itemEntity);
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