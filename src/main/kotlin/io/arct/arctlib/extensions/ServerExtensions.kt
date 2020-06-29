@file:Suppress("unused")

package io.arct.arctlib.extensions

import org.bukkit.OfflinePlayer
import org.bukkit.Server
import org.bukkit.entity.Player

/**
 * Get all the online players on the server
 *
 * @return All the online players on the server
 */
fun Server.onlinePlayers(): List<Player> = onlinePlayers.toList()

/**
 * Get all the offline players on the server
 *
 * @return All the offline players on the server
 */
fun Server.offlinePlayers(): List<OfflinePlayer> = offlinePlayers.toList()