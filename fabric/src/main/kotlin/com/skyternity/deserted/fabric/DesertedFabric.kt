package com.skyternity.deserted.fabric

import com.skyternity.deserted.Deserted
import com.skyternity.deserted.client.DesertedClient
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.api.ModInitializer

@Suppress("unused")
object DesertedFabric: ModInitializer {
    override fun onInitialize() {
        Deserted.init()
    }
}

@Suppress("unused")
@Environment(EnvType.CLIENT)
object DesertedFabricClient: ClientModInitializer {
    override fun onInitializeClient() {
        DesertedClient.init()
    }
}