package io.arct.arctlib.plugin

import io.arct.arctlib.plugin.commands.Command
import io.arct.arctlib.plugin.events.EventListener
import org.bukkit.plugin.java.JavaPlugin

abstract class Plugin : JavaPlugin() {
    open fun enable() {}
    open fun disable() {}
    open fun load() {}

    override fun onEnable() {
        enable()
    }

    override fun onDisable() {
        disable()
    }

    override fun onLoad() {
        load()
    }

    inline fun <reified T: Command> command() {
        val command: Command = T::class.java.constructors.first().newInstance() as Command
        getCommand(command.name).executor = command.register(this)
    }

    inline fun <reified T: EventListener> listener() {
        val listener: EventListener = T::class.java.constructors.first().newInstance() as EventListener
        server.pluginManager.registerEvents(listener.register(this), this)
    }
}