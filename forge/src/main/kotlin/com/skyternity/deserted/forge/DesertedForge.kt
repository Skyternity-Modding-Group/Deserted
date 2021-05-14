package com.skyternity.deserted.forge

import com.skyternity.deserted.Deserted
import com.skyternity.deserted.client.DesertedClient
import me.shedaniel.architectury.platform.forge.EventBuses
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Deserted.MOD_ID)
object DesertedForge {
    init {
        EventBuses.registerModEventBus(Deserted.MOD_ID, MOD_BUS);
        MOD_BUS.addListener(::onClientSetup)

        Deserted.init();
    }

    private fun onClientSetup(event: FMLClientSetupEvent) {
        DesertedClient.init()
    }
}