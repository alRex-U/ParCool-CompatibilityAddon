package com.alrexu.parcool.compat;

import com.alrexu.parcool.compat.extern.ExternalModManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ParCoolCompatAddon.MOD_ID)
public class ParCoolCompatAddon {
    public static final String MOD_ID = "parcool_compat_addon";
    private static final Logger LOGGER = LogManager.getLogger();

    public ParCoolCompatAddon() {
        var modBus = FMLJavaModLoadingContext.get().getModEventBus();
        var forgeBus = MinecraftForge.EVENT_BUS;
        ExternalModManager.init(modBus, forgeBus);
    }
}
