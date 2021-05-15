package com.skyternity.deserted.items

import me.shedaniel.architectury.registry.DeferredRegister
import net.minecraft.util.registry.Registry
import com.remodstudios.remodcore.ItemRegistryHelper
import com.skyternity.deserted.Deserted
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup

@SuppressWarnings("unused")
object ItemRegistry: ItemRegistryHelper(Deserted.MOD_ID) {
    val REGISTRY = DeferredRegister.create(Deserted.MOD_ID, Registry.ITEM_KEY)

    override fun defaultSettings(): Item.Settings = Item.Settings().group(ItemGroup.MISC)
}