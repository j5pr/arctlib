package io.arct.arctlib.plugin

import io.arct.arctlib.configuration.Config
import io.arct.arctlib.configuration.MessageConfig
import io.arct.arctlib.exceptions.InternalPluginException
import io.arct.arctlib.exceptions.PluginException
import io.arct.arctlib.extensions.fmt
import io.arct.arctlib.extensions.unaryPlus
import io.arct.arctlib.plugin.commands.Command
import io.arct.arctlib.plugin.events.EventListener
import org.bukkit.plugin.java.JavaPlugin

abstract class Plugin : JavaPlugin() {
    open val config = Config.of("config.yml", this)
    open val messages = MessageConfig.of("messages.yml", this)

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

    fun message(node: String, vararg placeholders: Pair<String, String>): String =
        message(node, mapOf(*placeholders))

    fun message(node: String, placeholders: Map<String, String>): String {
        if (node.split(".")[0] == "x" && server.pluginManager.isPluginEnabled("ArctCore")) {
            val plugin: Plugin = server.pluginManager.getPlugin("ArctCore") as Plugin
            val newNode: String = node.split(".").drop(1).joinToString(".")

            if (plugin.messages.contains(newNode))
                return (plugin.messages.message(newNode))!!

            return messages.message(newNode, placeholders) ?: "&4Internal Error: &cCould not find internal message."
        }

        return messages.message(node, placeholders) ?: "&4Internal Error: &cCould not find message."
    }

    infix fun raise(exception: PluginException): String {
        if (exception is InternalPluginException) {
            if (server.pluginManager.isPluginEnabled("ArctCore")) {
                val plugin: Plugin = server.pluginManager.getPlugin("ArctCore") as Plugin

                if (plugin.messages.contains("error.${exception.node}"))
                    return (plugin.messages raise exception)!!
            }

            // Just get the default
            return +exception.default.fmt(exception.placeholders)
        }

        // Get error from messages
        return (messages raise exception) ?: "&4Internal Error: &cCould not find error."
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