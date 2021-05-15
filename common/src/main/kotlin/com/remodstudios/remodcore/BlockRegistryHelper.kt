package com.remodstudios.remodcore

import com.remodstudios.lumidep.block.LumidepBlocks
import me.shedaniel.architectury.registry.BlockProperties
import me.shedaniel.architectury.registry.DeferredRegister
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.registry.Registry

open class BlockRegistryHelper(
    registry: DeferredRegister<Block>
): RegistryHelper<Block>(registry) {

    constructor(modid: String) : this(DeferredRegister.create(modid, Registry.BLOCK_KEY))

    fun <V: Block> add(
        id: String,
        v: V,
    ): V {
        registry.register(id) { v }
        return v
    }

    inline fun <V: Block> addOfProp(
        id: String,
        prop: BlockProperties,
        factory: BlockProperties.() -> V,
    ): V {
        val block = prop.factory()
        return LumidepBlocks.add(id, block)
    }

    inline fun <Original: Block, V: Block> addCopy(
        id: String,
        original: Original,
        factory: BlockProperties.() -> V,
    ) = addOfProp(id, BlockProperties.copy(original), factory)

    inline fun <Original: Block> addCopyWithInit(
        id: String,
        original: Original,
        factory: BlockProperties.() -> Unit,
    ): Block {
        val prop = BlockProperties.copy(original)
        prop.factory()
        return addOfProp(id, prop, ::Block)
    }

    fun <Original: Block> addCopy(
        id: String,
        original: Original
    ) = addCopy(id, original) { Block(this) }

    inline fun <V: Block> addOfMaterial(
        id: String,
        mat: Material,
        factory: BlockProperties.() -> V
    ) = addOfProp(id, BlockProperties.of(mat), factory)

    inline fun <V: Block> addWoodlike(
        id: String,
        factory: BlockProperties.() -> V
    ) = addOfMaterial(id, Material.WOOD) {
        strength(2.0F)
        sounds(BlockSoundGroup.WOOD)
        this.factory()
    }
}