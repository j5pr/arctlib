package io.arct.arctlib.extensions

import org.bukkit.Chunk
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Entity

/**
 * Get a list of all of the blocks of a specific type in the chunk.
 *
 * @param T The type of [Block] to get.
 *
 * @return A [List] of matching [Block]s.
 */
inline fun <reified T> Chunk.blocks(): List<T> {
    val blocks: MutableList<Block> = mutableListOf()

    val chunkSize = 16
    val worldHeight = 128
    for (xIndex in 0 until chunkSize)
        for (zIndex in 0 until chunkSize)
            for (yIndex in 0 until worldHeight) {
                val block: Block = world.getBlockAt(xIndex + x, yIndex, zIndex + z)
                if (block.type != Material.AIR)
                    blocks.add(block)
            }

    return blocks.filterIsInstance<T>()
}


/**
 * Get a list of all of the entities of a specific type in the chunk.
 *
 * @param T The type of [Entity] to get.
 *
 * @return A [List] of matching [Entity]s.
 */
inline fun <reified T : Entity> Chunk.entities(): List<T> =
    entities.filterIsInstance<T>()

/**
 * Get a list of all the monsters in the world.
 *
 * @return Return a list of all the monsters in the world.
 */
fun Chunk.monsters(): List<Entity> =
    entities.filter { it.type.isHostile }

/**
 * Get a list of all the animals in the world.
 *
 * @return Return a list of all the animals in the world.
 */
fun Chunk.animals(): List<Entity> =
    entities.filter { it.type.isPassive }

/**
 * Get a list of all the projectiles in the world.
 *
 * @return Return a list of all the projectiles in the world.
 */
fun Chunk.projectiles(): List<Entity> =
    entities.filter { it.type.isProjectile }