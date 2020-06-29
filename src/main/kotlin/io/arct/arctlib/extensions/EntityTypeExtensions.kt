@file:Suppress("unused")

package io.arct.arctlib.extensions

import org.bukkit.entity.EntityType

/**
 * Check if a [EntityType] is a skeleton.
 *
 * @return Whether the [EntityType] is of type skeleton.
 */
val EntityType.isSkeleton: Boolean
    get() = when (this) {
        EntityType.SKELETON,
        EntityType.WITHER_SKULL -> true
        else -> false
    }

/**
 * Check if a [EntityType] is a spider.
 *
 * @return Whether the [EntityType] is of type spider.
 */
val EntityType.isSpider: Boolean
    get() = when (this) {
        EntityType.SPIDER,
        EntityType.CAVE_SPIDER -> true
        else -> false
    }

/**
 * Check if a [EntityType] is a cube.
 *
 * @return Whether the [EntityType] is of type cube.
 */
val EntityType.isCube: Boolean
    get() = when (this) {
        EntityType.SLIME,
        EntityType.MAGMA_CUBE -> true
        else -> false
    }

/**
 * Check if a [EntityType] is a zombie.
 *
 * @return Whether the [EntityType] is of type zombie.
 */
val EntityType.isZombie: Boolean
    get() = when (this) {
        EntityType.ZOMBIE,
        EntityType.PIG_ZOMBIE -> true
        else -> false
    }

/**
 * Check if a [EntityType] is a hostile.
 *
 * @return Whether the [EntityType] is of type hostile.
 */
val EntityType.isHostile: Boolean
    get() = when (this) {
        EntityType.CREEPER,
        EntityType.SKELETON,
        EntityType.WITHER_SKULL,
        EntityType.SPIDER,
        EntityType.GIANT,
        EntityType.ZOMBIE,
        EntityType.SLIME,
        EntityType.GHAST,
        EntityType.PIG_ZOMBIE,
        EntityType.ENDERMAN,
        EntityType.CAVE_SPIDER,
        EntityType.SILVERFISH,
        EntityType.BLAZE,
        EntityType.MAGMA_CUBE,
        EntityType.ENDER_DRAGON,
        EntityType.WITHER,
        EntityType.WITCH,
        EntityType.ENDERMITE,
        EntityType.GUARDIAN -> true
        else -> false
    }

/**
 * Check if a [EntityType] is a passive.
 *
 * @return Whether the [EntityType] is of type passive.
 */
val EntityType.isPassive: Boolean
    get() = when (this) {
        EntityType.BAT,
        EntityType.PIG,
        EntityType.SHEEP,
        EntityType.COW,
        EntityType.CHICKEN,
        EntityType.SQUID,
        EntityType.WOLF,
        EntityType.MUSHROOM_COW,
        EntityType.SNOWMAN,
        EntityType.OCELOT,
        EntityType.IRON_GOLEM,
        EntityType.HORSE,
        EntityType.RABBIT,
        EntityType.VILLAGER -> true
        else -> false
    }

/**
 * Check if a [EntityType] is a projectile.
 *
 * @return Whether the [EntityType] is of type projectile.
 */
val EntityType.isProjectile: Boolean
    get() = when (this) {
        EntityType.ARROW,
        EntityType.SNOWBALL,
        EntityType.FIREBALL,
        EntityType.SMALL_FIREBALL,
        EntityType.ENDER_PEARL,
        EntityType.SPLASH_POTION,
        EntityType.EGG -> true
        else -> false
    }