package com.remodstudios.remodcore

import me.shedaniel.architectury.registry.DeferredRegister
import me.shedaniel.architectury.registry.RegistrySupplier
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

open class ItemRegistryHelper(registry: DeferredRegister<Item>): RegistryHelper<Item>(registry) {
    constructor(modid: String) : this(DeferredRegister.create(modid, Registry.ITEM_KEY))

    open fun defaultSettings(): Item.Settings = Item.Settings()

    fun <I: Item> add(
        id: String, i: I
    ): RegistrySupplier<I>
        = registry.register(id) { i }

    inline fun <I: Item> addWithFactory(
        id: String,
        factory: Item.Settings.() -> I
    ) = add(id, factory(defaultSettings()))

    inline fun add(
        id: String,
        init: Item.Settings.() -> Unit = {}
    ): RegistrySupplier<Item> {
        val settings = defaultSettings()
        settings.init()
        return add(id, Item(settings))
    }

    inline fun <B: Block> add(
        id: String,
        b: B,
        init: Item.Settings.() -> Unit = {}
    ): RegistrySupplier<BlockItem> {
        return addWithFactory(id) {
            this.init()
            BlockItem(b, this)
        }
    }

    inline fun <B: Block> add(
        id: String,
        b: RegistrySupplier<B>,
        init: Item.Settings.() -> Unit = {}
    ): RegistrySupplier<BlockItem> {
        return add(id, b.get(), init)
    }
}