package io.arct.arctlib.extensions

import org.bukkit.World
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity

enum class EntityGlobalType {
    MONSTER,
    ANIMAL,
    AMBIENT,
    WATER
}

/**
 * If the world time is within the bright timezone then it is day
 *
 * @return Whether the world is day or not
 */
val World.isDay: Boolean
    get() = time < 12300 || time > 23850

/**
 * If the world time is within the dark timezone then it is night
 *
 * @return Whether the world is night or not
 */
val World.isNight: Boolean
    get() = time in 12301..23849

/**
 * Get a list of all of the entities in the world.
 *
 * @param T The type of [Entity] to get.
 *
 * @return A [List] of matching [Entity]s.
 */
inline fun <reified T : Entity> World.entities(): List<Entity> =
    entities.filterIsInstance<T>()

/**
 * Get a list of all the monsters in the world.
 *
 * @return Return a list of all the monsters in the world.
 */
fun World.monsters(): List<LivingEntity> =
    livingEntities.filter { it.type.isHostile }

/**
 * Get a list of all the animals in the world.
 *
 * @return Return a list of all the animals in the world.
 */
fun World.animals(): List<LivingEntity> =
    livingEntities.filter { it.type.isPassive }

/**
 * Get a list of all the projectiles in the world.
 *
 * @return Return a list of all the projectiles in the world.
 */
fun World.projectiles(): List<LivingEntity> =
    livingEntities.filter { it.type.isProjectile }

/**
 * Set the global entity spawn type limit.
 *
 * @param type The global type of entity
 * @param limit The limit to set
 */
fun World.setGlobalSpawnLimit(type: EntityGlobalType, limit: Int) =
    when (type) {
        EntityGlobalType.MONSTER -> monsterSpawnLimit = limit
        EntityGlobalType.ANIMAL -> animalSpawnLimit = limit
        EntityGlobalType.AMBIENT -> ambientSpawnLimit = limit
        EntityGlobalType.WATER -> waterAnimalSpawnLimit = limit
    }