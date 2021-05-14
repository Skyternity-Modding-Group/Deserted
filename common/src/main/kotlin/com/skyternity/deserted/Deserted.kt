package com.skyternity.deserted

import net.minecraft.util.Identifier

object Deserted {
    const val MOD_ID = "deserted"

    fun init() {
        printHelloWorld()
    }

    fun id(path: String): Identifier {
        return Identifier(MOD_ID, path)
    }
}