package com.alrexu.parcool.compat.extern;

import com.alrexu.parcool.compat.extern.bettercombat.BetterCombatManager;
import com.alrexu.parcool.compat.extern.carryon.CarryOnManager;
import com.alrexu.parcool.compat.extern.firstpersonmodel.FirstPersonModelManager;
import com.alrexu.parcool.compat.extern.playeranimator.PlayerAnimatorManager;
import com.alrexu.parcool.compat.extern.realcamera.RealCameraManager;
import com.alrexu.parcool.compat.extern.tacz.TaCZManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;

import java.util.List;

public class ExternalModManager {
    private static final List<IModManager> MOD_MANAGERS = List.of(
            new BetterCombatManager(),
            new TaCZManager(),
            new PlayerAnimatorManager(),
            new CarryOnManager(),
            new RealCameraManager(),
            new FirstPersonModelManager()
    );

    public static void init(IEventBus modBus, IEventBus forgeBus) {
        for (var manager : MOD_MANAGERS) {
            manager.init(modBus, forgeBus);
        }
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> MOD_MANAGERS.forEach(manager -> manager.initInClient(modBus, forgeBus)));
        DistExecutor.unsafeRunWhenOn(Dist.DEDICATED_SERVER, () -> () -> MOD_MANAGERS.forEach(manager -> manager.initInDedicatedServer(modBus, forgeBus)));
    }

    public static <T extends IModManager> T get(Class<T> clazz) {
        for (var manager : MOD_MANAGERS) {
            if (clazz.isInstance(manager)) {
                return (T) manager;
            }
        }
        throw new IllegalArgumentException("ModManager [" + clazz.getSimpleName() + "] is not registered");
    }
}
