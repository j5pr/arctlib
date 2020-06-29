@file:Suppress("unused")

package io.arct.arctlib.extensions

import org.bukkit.block.Biome

/**
 * Check if a [Biome] is of type birch.
 *
 * @return Whether the [Biome] is of type birch.
 */
val Biome.isBirch: Boolean
    get() = when (this) {
        Biome.BIRCH_FOREST,
        Biome.BIRCH_FOREST_HILLS,
        Biome.BIRCH_FOREST_HILLS_MOUNTAINS,
        Biome.BIRCH_FOREST_MOUNTAINS -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type forest.
 *
 * @return Whether the [Biome] is of type forest.
 */
val Biome.isForest: Boolean
    get() = when (this) {
        Biome.FOREST,
        Biome.BIRCH_FOREST,
        Biome.BIRCH_FOREST_HILLS,
        Biome.FLOWER_FOREST,
        Biome.FOREST_HILLS,
        Biome.BIRCH_FOREST_MOUNTAINS,
        Biome.MESA_PLATEAU_FOREST,
        Biome.BIRCH_FOREST_HILLS_MOUNTAINS,
        Biome.MESA_PLATEAU_FOREST_MOUNTAINS,
        Biome.ROOFED_FOREST,
        Biome.ROOFED_FOREST_MOUNTAINS -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type roofed.
 *
 * @return Whether the [Biome] is of type roofed.
 */
val Biome.isRoofed: Boolean
    get() = when (this) {
        Biome.ROOFED_FOREST,
        Biome.ROOFED_FOREST_MOUNTAINS -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type jungle.
 *
 * @return Whether the [Biome] is of type jungle.
 */
val Biome.isJungle: Boolean
    get() = when (this) {
        Biome.JUNGLE,
        Biome.JUNGLE_EDGE,
        Biome.JUNGLE_EDGE_MOUNTAINS,
        Biome.JUNGLE_HILLS,
        Biome.JUNGLE_MOUNTAINS -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type cold.
 *
 * @return Whether the [Biome] is of type cold.
 */
val Biome.isCold: Boolean
    get() = when (this) {
        Biome.COLD_BEACH,
        Biome.COLD_TAIGA,
        Biome.COLD_TAIGA_HILLS,
        Biome.COLD_TAIGA_MOUNTAINS -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type ice.
 *
 * @return Whether the [Biome] is of type ice.
 */
val Biome.isIce: Boolean
    get() = when (this) {
        Biome.ICE_MOUNTAINS,
        Biome.ICE_PLAINS,
        Biome.ICE_PLAINS_SPIKES -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type frozen.
 *
 * @return Whether the [Biome] is of type frozen.
 */
val Biome.isFrozen: Boolean
    get() = when (this) {
        Biome.FROZEN_RIVER,
        Biome.FROZEN_OCEAN -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type mushroom.
 *
 * @return Whether the [Biome] is of type mushroom.
 */
val Biome.isMushroom: Boolean
    get() = when (this) {
        Biome.MUSHROOM_ISLAND,
        Biome.MUSHROOM_SHORE -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type beach.
 *
 * @return Whether the [Biome] is of type beach.
 */
val Biome.isBeach: Boolean
    get() = when (this) {
        Biome.BEACH,
        Biome.COLD_BEACH,
        Biome.STONE_BEACH -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type mesa.
 *
 * @return Whether the [Biome] is of type mesa.
 */
val Biome.isMesa: Boolean
    get() = when (this) {
        Biome.MESA,
        Biome.MESA_BRYCE,
        Biome.MESA_PLATEAU,
        Biome.MESA_PLATEAU_FOREST,
        Biome.MESA_PLATEAU_FOREST_MOUNTAINS -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type savanna.
 *
 * @return Whether the [Biome] is of type savanna.
 */
val Biome.isSavanna: Boolean
    get() = when (this) {
        Biome.SAVANNA,
        Biome.SAVANNA_MOUNTAINS,
        Biome.SAVANNA_PLATEAU,
        Biome.SAVANNA_PLATEAU_MOUNTAINS -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type swampland.
 *
 * @return Whether the [Biome] is of type swampland.
 */
val Biome.isSwapland: Boolean
    get() = when (this) {
        Biome.SWAMPLAND,
        Biome.SWAMPLAND_MOUNTAINS -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type desert.
 *
 * @return Whether the [Biome] is of type desert.
 */
val Biome.isDesert: Boolean
    get() = when (this) {
        Biome.DESERT,
        Biome.DESERT_HILLS,
        Biome.DESERT_MOUNTAINS -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type taiga.
 *
 * @return Whether the [Biome] is of type taiga.
 */
val Biome.isTaiga: Boolean
    get() = when (this) {
        Biome.TAIGA,
        Biome.TAIGA_MOUNTAINS,
        Biome.COLD_TAIGA,
        Biome.MEGA_SPRUCE_TAIGA,
        Biome.COLD_TAIGA_MOUNTAINS,
        Biome.COLD_TAIGA_HILLS,
        Biome.MEGA_TAIGA,
        Biome.TAIGA_HILLS,
        Biome.MEGA_TAIGA_HILLS -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type mountain.
 *
 * @return Whether the [Biome] is of type mountain.
 */
val Biome.isMountain: Boolean
    get() = when (this) {
        Biome.MESA_PLATEAU_FOREST_MOUNTAINS,
        Biome.COLD_TAIGA_MOUNTAINS,
        Biome.ROOFED_FOREST_MOUNTAINS,
        Biome.BIRCH_FOREST_HILLS_MOUNTAINS,
        Biome.BIRCH_FOREST_MOUNTAINS,
        Biome.DESERT_MOUNTAINS,
        Biome.EXTREME_HILLS_MOUNTAINS,
        Biome.EXTREME_HILLS_PLUS_MOUNTAINS,
        Biome.ICE_MOUNTAINS,
        Biome.JUNGLE_EDGE_MOUNTAINS,
        Biome.JUNGLE_MOUNTAINS,
        Biome.MESA_PLATEAU_MOUNTAINS,
        Biome.SAVANNA_MOUNTAINS,
        Biome.SAVANNA_PLATEAU_MOUNTAINS,
        Biome.SMALL_MOUNTAINS,
        Biome.SWAMPLAND_MOUNTAINS,
        Biome.TAIGA_MOUNTAINS -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type hill.
 *
 * @return Whether the [Biome] is of type hill.
 */
val Biome.isHill: Boolean
    get() = when (this) {
        Biome.JUNGLE_HILLS,
        Biome.MEGA_TAIGA_HILLS,
        Biome.TAIGA_HILLS,
        Biome.COLD_TAIGA_HILLS,
        Biome.DESERT_HILLS,
        Biome.FOREST_HILLS,
        Biome.BIRCH_FOREST_HILLS,
        Biome.EXTREME_HILLS,
        Biome.MEGA_SPRUCE_TAIGA_HILLS -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type extreme.
 *
 * @return Whether the [Biome] is of type extreme.
 */
val Biome.isExtreme: Boolean
    get() = when (this) {
        Biome.EXTREME_HILLS,
        Biome.EXTREME_HILLS_PLUS,
        Biome.EXTREME_HILLS_MOUNTAINS,
        Biome.EXTREME_HILLS_PLUS_MOUNTAINS -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type ocean.
 *
 * @return Whether the [Biome] is of type ocean.
 */
val Biome.isOcean: Boolean
    get() = when (this) {
        Biome.OCEAN,
        Biome.DEEP_OCEAN,
        Biome.FROZEN_OCEAN -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type river.
 *
 * @return Whether the [Biome] is of type river.
 */
val Biome.isRiver: Boolean
    get() = when (this) {
        Biome.RIVER,
        Biome.FROZEN_RIVER -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type land.
 * Does not include frozen bodies of water
 *
 * @return Whether the [Biome] is of type land.
 */
val Biome.isLand: Boolean
    get() = when (this) {
        Biome.SWAMPLAND,
        Biome.FOREST,
        Biome.TAIGA,
        Biome.DESERT,
        Biome.PLAINS,
        Biome.EXTREME_HILLS,
        Biome.ICE_PLAINS,
        Biome.ICE_MOUNTAINS,
        Biome.MUSHROOM_ISLAND,
        Biome.MUSHROOM_SHORE,
        Biome.BEACH,
        Biome.DESERT_HILLS,
        Biome.FOREST_HILLS,
        Biome.TAIGA_HILLS,
        Biome.SMALL_MOUNTAINS,
        Biome.JUNGLE,
        Biome.JUNGLE_HILLS,
        Biome.JUNGLE_EDGE,
        Biome.STONE_BEACH,
        Biome.COLD_BEACH,
        Biome.BIRCH_FOREST,
        Biome.BIRCH_FOREST_HILLS,
        Biome.ROOFED_FOREST,
        Biome.COLD_TAIGA,
        Biome.COLD_TAIGA_HILLS,
        Biome.MEGA_TAIGA,
        Biome.MEGA_TAIGA_HILLS,
        Biome.EXTREME_HILLS_PLUS,
        Biome.SAVANNA,
        Biome.SAVANNA_PLATEAU,
        Biome.MESA,
        Biome.MESA_PLATEAU_FOREST,
        Biome.MESA_PLATEAU,
        Biome.SUNFLOWER_PLAINS,
        Biome.DESERT_MOUNTAINS,
        Biome.FLOWER_FOREST,
        Biome.TAIGA_MOUNTAINS,
        Biome.SWAMPLAND_MOUNTAINS,
        Biome.ICE_PLAINS_SPIKES,
        Biome.JUNGLE_MOUNTAINS,
        Biome.JUNGLE_EDGE_MOUNTAINS,
        Biome.COLD_TAIGA_MOUNTAINS,
        Biome.SAVANNA_MOUNTAINS,
        Biome.SAVANNA_PLATEAU_MOUNTAINS,
        Biome.MESA_BRYCE,
        Biome.MESA_PLATEAU_FOREST_MOUNTAINS,
        Biome.MESA_PLATEAU_MOUNTAINS,
        Biome.BIRCH_FOREST_MOUNTAINS,
        Biome.BIRCH_FOREST_HILLS_MOUNTAINS,
        Biome.ROOFED_FOREST_MOUNTAINS,
        Biome.MEGA_SPRUCE_TAIGA,
        Biome.EXTREME_HILLS_MOUNTAINS,
        Biome.EXTREME_HILLS_PLUS_MOUNTAINS,
        Biome.MEGA_SPRUCE_TAIGA_HILLS -> true
        else -> false
    }

/**
 * Check if a [Biome] is of type water.
 * Includes frozen bodies of water
 *
 * @return Whether the [Biome] is of type water.
 */
val Biome.isWater: Boolean
    get() = when (this) {
        Biome.OCEAN,
        Biome.RIVER,
        Biome.FROZEN_OCEAN,
        Biome.FROZEN_RIVER,
        Biome.DEEP_OCEAN -> true
        else -> false
    }