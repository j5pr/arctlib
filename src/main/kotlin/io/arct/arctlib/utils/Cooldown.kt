package io.arct.arctlib.utils

import java.util.*

/**
 * Simulate a cooldown given a UUID and duration
 *
 * @param id The UUID assigned to this cooldown
 * @param command The command that the cooldown is activated on
 * @param duration The duration of the cooldown in seconds
 * @constructor Starts the cooldown
 */
class Cooldown(id: UUID, val command: String, val duration: Int) {
    private val start: Long = System.currentTimeMillis()

    init {
        cooldowns[id] = this
    }

    companion object {
        private val cooldowns: MutableMap<UUID, Cooldown> = mutableMapOf()

        /**
         * Lets us know if we are in a cooldown or not
         *
         * @param id The UUID to check
         * @return If we are active or not
         */
        fun active(id: UUID, command: String): Boolean {
            val cooldown: Cooldown = cooldowns[id] ?: return false

            return if (remaining(id) > 0 && command == cooldown.command) {
                true
            } else {
                stop(id)
                false
            }
        }

        /**
         * Gets the remaining time left in the cooldown
         *
         * @param id The UUID to check
         * @return The time left in seconds
         */
        fun remaining(id: UUID): Int {
            val cooldown: Cooldown? = cooldowns[id]
            var timeLeft: Int = -1
            if (cooldown != null) {
                val now: Long = System.currentTimeMillis()
                val start: Long = cooldown.start
                timeLeft = cooldown.duration - ((now - start) / 1000).toInt()
            }
            return timeLeft
        }

        /**
         * Stops the cooldown
         *
         * @param id The UUID of the cooldown to stop
         */
        fun stop(id: UUID) = cooldowns.remove(id)

        /**
         * Get the cooldown
         *
         * @param id The UUID of the cooldown to get
         * @return Returns the cooldown
         */
        fun get(id: UUID): Cooldown? = cooldowns[id]
    }
}