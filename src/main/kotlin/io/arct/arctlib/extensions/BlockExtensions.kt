@file:Suppress("unused")

package io.arct.arctlib.extensions

import org.bukkit.block.Block
import org.bukkit.block.BlockFace

fun Block.adjacentBlocks(): List<Block> =
    blockFaces(
        listOf(
            BlockFace.DOWN, BlockFace.UP, BlockFace.NORTH, BlockFace.EAST,
            BlockFace.SOUTH, BlockFace.WEST
        )
    )

fun Block.blockFaces(faces: List<BlockFace>): List<Block> {
    val blocks: MutableList<Block> = mutableListOf()
    for (face in faces)
        blocks.add(this.getRelative(face))
    return blocks
}