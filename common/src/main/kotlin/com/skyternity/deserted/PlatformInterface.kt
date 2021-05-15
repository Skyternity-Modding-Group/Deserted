@file:JvmName("PlatformInterface")
package com.skyternity.deserted

import me.shedaniel.architectury.annotations.ExpectPlatform
import net.minecraft.item.ItemGroup

@ExpectPlatform
fun printHelloWorld(): Unit = throw AssertionError()
fun getItemGroup(): ItemGroup = throw AssertionError()