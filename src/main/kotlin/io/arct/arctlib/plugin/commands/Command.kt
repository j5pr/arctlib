package io.arct.arctlib.plugin.commands

import io.arct.arctlib.extensions.unaryPlus
import io.arct.arctlib.plugin.Plugin
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player

abstract class Command(val name: String) : CommandExecutor {
    lateinit var plugin: Plugin
        private set

    open val permissions: List<String> = listOf()

    override fun onCommand(
        sender: CommandSender,
        command: org.bukkit.command.Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (name != command.name.toLowerCase())
            return false

        for (permission in permissions)
            if (!sender.hasPermission(permission)) {
                sender.sendMessage(+"&4Error: &cYou do not have permission to run this command!")
                return true
            }

        for (method in this::class.java.methods) {
            val annotation: Run = method.annotations.find { it.annotationClass == Run::class } as? Run
                ?: continue

            plugin.logger.info(method.name)

            if (annotation.target.isEmpty()) {
                method.invoke(this, sender, args.toList())
                return true
            }

            if (sender is Player && annotation.target.contains(CommandTarget.Player)) {
                method.invoke(this, sender, args.toList())
                return true
            }

            if (sender is ConsoleCommandSender && annotation.target.contains(CommandTarget.Console)) {
                method.invoke(this, sender, args.toList())
                return true
            }
        }

        sender.sendMessage(+"&4Error: &cCould not find an execution target for " + if (sender is Player) "PLAYER" else "CONSOLE")
        return false
    }

    fun register(plugin: Plugin): Command {
        this.plugin = plugin
        return this
    }
}