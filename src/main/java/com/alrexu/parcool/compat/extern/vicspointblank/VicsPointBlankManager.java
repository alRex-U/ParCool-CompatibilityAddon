package com.alrexu.parcool.compat.extern.vicspointblank;

import com.alrexu.parcool.compat.extern.ModManager;
import net.minecraftforge.eventbus.api.IEventBus;

public class VicsPointBlankManager extends ModManager {

    @Override
    public void initWhenInstalled(IEventBus modBus, IEventBus forgeBus) {
        //forgeBus.register(EventHandlerForPointBlank.class);
    }

    @Override
    public String getModID() {
        return "pointblank";
    }
}
