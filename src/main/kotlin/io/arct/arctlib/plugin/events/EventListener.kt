package io.arct.arctlib.plugin.events

import io.arct.arctlib.plugin.Plugin
import org.bukkit.event.Listener

abstract class EventListener : Listener {
    lateinit var plugin: Plugin
        private set

    fun register(plugin: Plugin): EventListener {
        this.plugin = plugin
        return this
    }
}