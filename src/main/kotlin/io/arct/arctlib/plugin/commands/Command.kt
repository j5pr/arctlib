package io.arct.arctlib.plugin.commands

import io.arct.arctlib.exceptions.commands.CommandDisabledException
import io.arct.arctlib.exceptions.commands.CooldownException
import io.arct.arctlib.exceptions.commands.ExecutionTargetException
import io.arct.arctlib.exceptions.permissions.InsufficientPermissionsException
import io.arct.arctlib.extensions.needs
import io.arct.arctlib.extensions.send
import io.arct.arctlib.plugin.Plugin
import io.arct.arctlib.utils.Cooldown
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player

abstract class Command(val name: String) : CommandExecutor {
    lateinit var plugin: Plugin
        private set

    open val permissions: List<String> = listOf()
    open val cooldown: Int = 0

    override fun onCommand(
        sender: CommandSender,
        command: org.bukkit.command.Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (name != command.name.toLowerCase())
            return false

        if ( // Checks
            !checkPermission(sender) ||
            !checkEnabled(sender) ||
            !checkCooldown(sender)
        ) return true

        for (method in this::class.java.methods) {
            val annotation: Run = method.annotations.find { it.annotationClass == Run::class } as? Run
                ?: continue

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

        plugin raise ExecutionTargetException(
            if (sender is Player) CommandTarget.Player
            else CommandTarget.Console
        ) send sender

        return false
    }

    private fun checkEnabled(sender: CommandSender): Boolean {
        if (plugin.config.contains("commands.enabled.$name") && !plugin.config.getBoolean("commands.enabled.$name")){
            plugin raise CommandDisabledException() send sender
            return false
        }

        return true
    }

    private fun checkPermission(sender: CommandSender): Boolean {
        for (permission in permissions) {
            if (sender needs permission) {
                plugin raise InsufficientPermissionsException() send sender
                return false
            }
        }

        return true
    }

    private fun checkCooldown(sender: CommandSender): Boolean {
        if (sender !is Player || cooldown < 1)
            return true

        if (Cooldown.active(sender.uniqueId, this)) {
            plugin raise CooldownException(Cooldown.of(sender.uniqueId, this)!!.remaining) send sender
            return false
        }

        Cooldown(sender.uniqueId, cooldown, this).start()
        return true
    }

    fun execute(vararg args: String) {
        for (method in this::class.java.methods) {
            val annotation: Run = method.annotations.find { it.annotationClass == Run::class } as? Run
                ?: continue

            if (annotation.target.contains(CommandTarget.System)) {
                method.invoke(this, args.toList())
                return
            }
        }
    }

    fun register(plugin: Plugin): Command {
        this.plugin = plugin
        return this
    }
}