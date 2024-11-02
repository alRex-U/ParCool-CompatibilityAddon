package com.alrexu.parcool.compat.extern;

import com.alrexu.parcool.compat.extern.bettercombat.BetterCombatManager;
import com.alrexu.parcool.compat.extern.carryon.CarryOnManager;
import com.alrexu.parcool.compat.extern.playeranimator.PlayerAnimatorManager;
import com.alrexu.parcool.compat.extern.tacz.TaCZManager;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.List;

public class ExternalModManager {
    private static final List<IModManager> MOD_MANAGERS = List.of(
            new BetterCombatManager(),
            new TaCZManager(),
            new PlayerAnimatorManager(),
            new CarryOnManager()
    );

    public static void init(IEventBus modBus, IEventBus forgeBus) {
        for (var manager : MOD_MANAGERS) {
            manager.init(modBus, forgeBus);
        }
    }
}
