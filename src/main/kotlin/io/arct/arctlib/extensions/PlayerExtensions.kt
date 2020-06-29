@file:Suppress("unused")

package io.arct.arctlib.extensions

import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

/**
 * Safely add a potion effect to the player
 *
 * @param type The type of potion to add
 * @param duration The duration of the potion in seconds
 * @param level The level of the potion (0 is the weakest level)
 */
fun Player.addPotionEffect(type: PotionEffectType, duration: Int, level: Int) {
    if (!hasPotionEffect(type))
        addPotionEffect(PotionEffect(type, duration, level))
}

/**
 * Remove all the active potion effects from the player
 */
fun Player.removeAllPotionEffects() {
    for (potionEffect in activePotionEffects)
        removePotionEffect(potionEffect.type)
}

/**
 * Fill the players health
 */
fun Player.fillHealth() {
    health = maxHealth
}

/**
 * Fill the players food level with optional saturation
 *
 * @param saturation The saturation to apply
 */
fun Player.fillFood(saturation: Int = 0) {
    val maxFood = 20
    foodLevel = maxFood + saturation
}

/**
 * Is the player in survival mode?
 *
 * @return Returns true if the player is in survival mode
 */
val Player.inSurvival: Boolean
    get() = gameMode == GameMode.SURVIVAL

/**
 * Is the player in creative mode?
 *
 * @return Returns true if the player is in creative mode
 */
val Player.inCreative: Boolean
    get() = gameMode == GameMode.CREATIVE

/**
 * Is the player in adventure mode?
 *
 * @return Returns true if the player is in adventure mode
 */
val Player.inAdventure: Boolean
    get() = gameMode == GameMode.ADVENTURE

/**
 * Is the player in spectator mode?
 *
 * @return Returns true if the player is in spectator mode
 */
val Player.inSpectator: Boolean
    get() = gameMode == GameMode.SPECTATOR