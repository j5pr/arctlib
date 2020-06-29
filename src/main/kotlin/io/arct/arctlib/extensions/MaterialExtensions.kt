package io.arct.arctlib.extensions

import org.bukkit.Material

/**
 * Check if a [Material] is an axe.
 *
 * @return Whether the [Material] is an axe.
 */
val Material.isAxe: Boolean
    get() = when (this) {
        Material.WOOD_AXE,
        Material.STONE_AXE,
        Material.IRON_AXE,
        Material.GOLD_AXE,
        Material.DIAMOND_AXE -> true
        else -> false
    }

/**
 * Check if a [Material] is a pickaxe.
 *
 * @return Whether the [Material] is a pickaxe.
 */
val Material.isPickaxe: Boolean
    get() = when (this) {
        Material.WOOD_PICKAXE,
        Material.STONE_PICKAXE,
        Material.IRON_PICKAXE,
        Material.GOLD_PICKAXE,
        Material.DIAMOND_PICKAXE -> true
        else -> false
    }

/**
 * Check if a [Material] is a spade.
 *
 * @return Whether the [Material] is a spade.
 */
val Material.isSpade: Boolean
    get() = when (this) {
        Material.WOOD_SPADE,
        Material.STONE_SPADE,
        Material.IRON_SPADE,
        Material.GOLD_SPADE,
        Material.DIAMOND_SPADE -> true
        else -> false
    }

/**
 * Check if a [Material] is a hoe.
 *
 * @return Whether the [Material] is a hoe.
 */
val Material.isHoe: Boolean
    get() = when (this) {
        Material.WOOD_HOE,
        Material.STONE_HOE,
        Material.IRON_HOE,
        Material.GOLD_HOE,
        Material.DIAMOND_HOE -> true
        else -> false
    }

/**
 * Check if a [Material] is a sword.
 *
 * @return Whether the [Material] is a sword.
 */
val Material.isSword: Boolean
    get() = when (this) {
        Material.WOOD_SWORD,
        Material.STONE_SWORD,
        Material.IRON_SWORD,
        Material.GOLD_SWORD,
        Material.DIAMOND_SWORD -> true
        else -> false
    }

/**
 * Check if a [Material] is a tool.
 *
 * @return Whether the [Material] is a tool.
 */
val Material.isTool: Boolean
    get() = isPickaxe || isAxe || isSpade || isHoe

/**
 * Check if a [Material] is a weapon.
 *
 * @return Whether the [Material] is a weapon.
 */
val Material.isWeapon: Boolean
    get() = this == Material.BOW || isSword

/**
 * Check if a [Material] is farmable.
 *
 * @return Whether the [Material] is farmable.
 */
val Material.isFarmable: Boolean
    get() = when (this) {
        Material.WHEAT,
        Material.POTATO,
        Material.NETHER_WARTS,
        Material.CARROT -> true
        else -> false
    }

/**
 * Check if a [Material] is an ore.
 *
 * @return Whether the [Material] is an ore.
 */
val Material.isOre: Boolean
    get() = when (this) {
        Material.COAL_ORE,
        Material.DIAMOND_ORE,
        Material.EMERALD_ORE,
        Material.GOLD_ORE,
        Material.IRON_ORE,
        Material.LAPIS_ORE,
        Material.REDSTONE_ORE -> true
        else -> false
    }

/**
 * Check if a [Material] is a soft block.
 *
 * @return Whether the [Material] is a soft block.
 */
val Material.isSoft: Boolean
    get() = when (this) {
        Material.SAND,
        Material.GRAVEL,
        Material.DIRT,
        Material.SOUL_SAND,
        Material.GRASS,
        Material.CLAY -> true
        else -> false
    }

/**
 * Check if a [Material] is a chest.
 *
 * @return Whether the [Material] is a chest.
 */
val Material.isChest: Boolean
    get() = when (this) {
        Material.CHEST,
        Material.ENDER_CHEST,
        Material.TRAPPED_CHEST -> true
        else -> false
    }

/**
 * Check if a [Material] is a container.
 *
 * @return Whether the [Material] is a container.
 */
val Material.isContainer: Boolean
    get() = when (this) {
        Material.CHEST,
        Material.ENDER_CHEST,
        Material.TRAPPED_CHEST,
        Material.FURNACE,
        Material.BREWING_STAND,
        Material.DISPENSER,
        Material.DROPPER,
        Material.HOPPER -> true
        else -> false
    }

/**
 * Check if a [Material] is a station.
 *
 * @return Whether the [Material] is a station.
 */
val Material.isStation: Boolean
    get() = when (this) {
        Material.FURNACE,
        Material.ENCHANTMENT_TABLE,
        Material.BREWING_STAND,
        Material.CAULDRON,
        Material.CHEST,
        Material.DISPENSER,
        Material.DROPPER,
        Material.JUKEBOX,
        Material.ENDER_CHEST,
        Material.TRAPPED_CHEST,
        Material.HOPPER -> true
        else -> false
    }

/**
 * Check if a [Material] is liquid.
 *
 * @return Whether the [Material] is a liquid.
 */
val Material.isLiquid: Boolean
    get() = when (this) {
        Material.WATER,
        Material.STATIONARY_WATER,
        Material.LAVA,
        Material.STATIONARY_LAVA -> true
        else -> false
    }

/**
 * Check if a [Material] is a plant.
 *
 * @return Whether the [Material] is a plant.
 */
val Material.isPlant: Boolean
    get() = when (this) {
        Material.LONG_GRASS,
        Material.YELLOW_FLOWER,
        Material.CACTUS,
        Material.DEAD_BUSH,
        Material.DOUBLE_PLANT -> true
        else -> false
    }