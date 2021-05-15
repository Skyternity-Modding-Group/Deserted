package com.remodstudios.remodcore

import net.minecraft.client.util.math.MatrixStack

inline fun MatrixStack.frame(block: () -> Unit) {
    this.push()
    block()
    this.pop()
}