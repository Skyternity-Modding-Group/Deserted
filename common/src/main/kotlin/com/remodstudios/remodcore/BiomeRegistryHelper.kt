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
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeEffects
import net.minecraft.world.biome.GenerationSettings
import net.minecraft.world.biome.SpawnSettings
import net.minecraft.world.gen.feature.DefaultBiomeFeatures as Dbf

typealias BiomeInitScope = Biome.Builder.(SpawnSettings.Builder, GenerationSettings.Builder) -> Unit

inline fun Biome.Builder.effects(init: BiomeEffects.Builder.() -> Unit) {
    val builder = BiomeEffects.Builder()
    init(builder)
    this.effects(builder.build())
}

open class BiomeRegistryHelper(registry: DeferredRegister<Biome>): RegistryHelper<Biome>(registry) {

    constructor(modid: String): this(DeferredRegister.create(modid, Registry.BIOME_KEY))

    inline fun add(
        id: String,
        addDefaults: Boolean = true,
        init: BiomeInitScope
    ): Biome {
        val spawnSettings = SpawnSettings.Builder()
        val generationSettings = GenerationSettings.Builder()
        val biomeBuilder = Biome.Builder()

        if (addDefaults) {
            Dbf.addDefaultUndergroundStructures(generationSettings)
            Dbf.addLandCarvers(generationSettings)
            Dbf.addDefaultLakes(generationSettings)
            Dbf.addDungeons(generationSettings)
            Dbf.addMineables(generationSettings)
            Dbf.addDefaultOres(generationSettings)
            Dbf.addDefaultDisks(generationSettings)
            Dbf.addSprings(generationSettings)
            Dbf.addFrozenTopLayer(generationSettings)
        }

        biomeBuilder.init(spawnSettings, generationSettings)

        if (addDefaults) {
            // Done that for ya
            biomeBuilder
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
        }

        val biome = biomeBuilder.build()
        `access$registry`.register(id) { biome }
        return biome
    }

    @PublishedApi
    internal val `access$registry`: DeferredRegister<Biome>
        get() = registry
}