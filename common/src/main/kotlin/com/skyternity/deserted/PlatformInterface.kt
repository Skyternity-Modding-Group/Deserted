@file:JvmName("PlatformInterface")
package com.skyternity.deserted

import me.shedaniel.architectury.annotations.ExpectPlatform

@ExpectPlatform
fun printHelloWorld(): Unit = throw AssertionError()