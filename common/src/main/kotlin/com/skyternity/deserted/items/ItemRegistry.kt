package com.skyternity.deserted.items

import me.shedaniel.architectury.registry.DeferredRegister
import net.minecraft.util.registry.Registry
import com.remodstudios.remodcore.ItemRegistryHelper
import com.skyternity.deserted.Deserted
import com.skyternity.deserted.getItemGroup
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup

@SuppressWarnings("unused")
object ItemRegistry: ItemRegistryHelper(Deserted.MOD_ID) {
    val REGISTRY = DeferredRegister.create(Deserted.MOD_ID, Registry.ITEM_KEY)
    val GROUP = getItemGroup();

    override fun defaultSettings(): Item.Settings = Item.Settings().group(ItemGroup.MISC)

    var Colors = arrayOf("cyan", "lime", "red", "blue", "purple", "pink", "black", "brown", "white", "magenta", "orange", "yellow", "green", "light_gray", "gray", "light_blue")

    var MIRROR = add("mirror")

    fun colorRegister() {
        Colors.forEach {
            add(it + "_mirror")
        }
    }

    var coloredMirrors = colorRegister();

    val ENHANCED_GOLDEN_SWORD = add("enhanced_golden_sword")
    val PUMPKIN_SOUP = add("pumpkin_soup", Item.Settings().food(FoodComponent.Builder().hunger(6).saturationModifier(2.4F).build()))
    val MICA_SHEET = add("mice_sheet")
    val MICA_PLATE = add("mice_plate")
    val DESERT_ROSE = add("desert_rose")
    val DUSTED_DESERT_ROSE = add("dusted_desert_rose")
}