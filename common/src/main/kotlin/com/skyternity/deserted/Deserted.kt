package com.skyternity.deserted

import com.skyternity.deserted.blocks.BlockRegistry
import com.skyternity.deserted.items.ItemRegistry
import net.minecraft.util.Identifier

object Deserted {
    const val MOD_ID = "deserted"

    fun init() {
        printHelloWorld()
        ItemRegistry.register();
        BlockRegistry.register();
    }

    fun id(path: String): Identifier {
        return Identifier(MOD_ID, path)
    }
}