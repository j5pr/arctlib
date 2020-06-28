package io.arct.arctlib.utils

import java.util.*

/**
 * Simulate a cooldown given a UUID and duration
 *
 * @param id The UUID assigned to this cooldown
 * @param duration The duration of the cooldown in seconds
 * @constructor Starts the cooldown
 */
class Cooldown(id: UUID, val duration: Int) {
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
         */
        fun active(id: UUID): Boolean {
            return if (remaining(id) > 0) {
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
        fun stop(id: UUID) {
            cooldowns.remove(id)
        }
    }
}