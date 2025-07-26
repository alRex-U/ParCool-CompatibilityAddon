package com.alrexu.parcool.compat.extern.carryon;

import com.alrexu.parcool.compat.extern.ModManager;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.IEventBus;
import tschipp.carryon.common.handler.RegistrationHandler;

public class CarryOnManager extends ModManager {

    @Override
    public void initWhenInstalled(IEventBus modBus, IEventBus forgeBus) {
        forgeBus.register(EventHandlerForCarryOn.class);
    }

    public boolean isCarrying(Player player) {
        if (!isInstalled()) return false;
        var stack = player.getMainHandItem();
        var item = stack.getItem();
        return !stack.isEmpty() && (item == RegistrationHandler.itemTile || item == RegistrationHandler.itemEntity);
    }

    @Override
    public String getModID() {
        return "carryon";
    }
}