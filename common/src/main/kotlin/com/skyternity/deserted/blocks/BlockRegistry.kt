package com.skyternity.deserted.blocks

import com.remodstudios.remodcore.BlockRegistryHelper
import com.skyternity.deserted.Deserted
import net.minecraft.block.Blocks

@SuppressWarnings("unused")
object BlockRegistry: BlockRegistryHelper(Deserted.MOD_ID) {
    val MICA_CLUSTER = addCopy("mica_cluster", Blocks.STONE)
    val SILSTONE = addCopy("siltstone", Blocks.STONE)
    val SILSTONE_BRICKS = addCopy("siltstone_bricks", Blocks.STONE)
    val POLISHED_SILSTONE = addCopy("polished_siltstone", Blocks.STONE)
    val MESA_SILSTONE = addCopy("mesa_siltstone", Blocks.STONE)
    val MESA_SILSTONE_BRICKS = addCopy("mesa_siltstone_bricks", Blocks.STONE)
    val POLISHED_MESA_SILSTONE = addCopy("polished_mesa_siltstone", Blocks.STONE)
    val DESERT_ROSE_DEPOSIT = addCopy("desert_rose_deposit", Blocks.STONE)

    fun lol() {}
}