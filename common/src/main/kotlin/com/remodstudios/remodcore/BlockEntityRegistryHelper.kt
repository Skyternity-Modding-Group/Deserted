package com.remodstudios.remodcore

import com.mojang.datafixers.types.Type
import com.remodstudios.lumidep.block.LumidepBlocks
import me.shedaniel.architectury.registry.BlockProperties
import me.shedaniel.architectury.registry.DeferredRegister
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.registry.Registry

open class BlockEntityRegistryHelper(
    registry: DeferredRegister<BlockEntityType<*>>
): RegistryHelper<BlockEntityType<*>>(registry) {

    constructor(modid: String) : this(DeferredRegister.create(modid, Registry.BLOCK_ENTITY_TYPE_KEY))

    fun <V: BlockEntity> add(
        id: String,
        v: () -> V,
        vararg blocks: Block,
        dataFixType: Type<*>? = null
    ): BlockEntityType<V> {
        val type = BlockEntityType.Builder.create(v, *blocks).build(dataFixType)
        registry.register(id) { type }
        return type
    }
}