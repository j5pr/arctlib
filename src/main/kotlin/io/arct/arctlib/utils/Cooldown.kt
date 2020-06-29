package io.arct.arctlib.utils

import io.arct.arctlib.plugin.commands.Command
import java.util.*
import kotlin.reflect.KClass

/**
 * Simulate a cooldown given a UUID and duration
 *
 * @param id The UUID assigned to this cooldown
 * @param command The command that the cooldown is activated on
 * @param duration The duration of the cooldown in seconds
 * @constructor Starts the cooldown
 */
class Cooldown(
    val id: UUID,
    val duration: Int,
    val command: Command
) {
    private val start: Long = System.currentTimeMillis()

    /**
     * Gets the remaining time left in the cooldown
     *
     * @return The time left in seconds
     */
    val remaining: Int get() {
        val now: Long = System.currentTimeMillis()
        val start: Long = start

        return duration - ((now - start) / 1000).toInt()
    }

    /**
     * Stops the cooldown
     */
    fun stop() =
        cooldowns.remove(this)

    /**
     * Starts the cooldown
     */
    fun start() =
        cooldowns.add(this)

    companion object {
        private val cooldowns: MutableList<Cooldown> = mutableListOf()

        /**
         * Lets us know if we are in a cooldown or not
         *
         * @param id The UUID to check
         * @return If we are active or not
         */
        fun active(id: UUID, command: Command): Boolean {
            val cooldown: Cooldown = of(id, command) ?: return false

            if (cooldown.remaining > 0)
                return true

            cooldown.stop()
            return false
        }

        /**
         * Get all cooldowns with UUID
         *
         * @param id The UUID of the cooldown to get
         * @return Returns the cooldown
         */
        infix fun of(id: UUID): List<Cooldown> = cooldowns.filter { it.id == id }

        fun of(id: UUID, command: Command): Cooldown? = of(id).firstOrNull { it.command == command }
    }
}