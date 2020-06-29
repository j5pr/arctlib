package io.arct.arctlib.plugin.commands

import io.arct.arctlib.exceptions.commands.CooldownException
import io.arct.arctlib.exceptions.commands.ExecutionTargetException
import io.arct.arctlib.exceptions.permissions.PermissionException
import io.arct.arctlib.extensions.send
import io.arct.arctlib.extensions.unaryPlus
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
    open val cooldownDuration: Int = 0

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
                plugin raise PermissionException() send sender
                return true
            }

        if (sender is Player && cooldownDuration > 0) {
            if (Cooldown.active(sender.uniqueId, name)) {
                plugin raise CooldownException(Cooldown.remaining(sender.uniqueId)) send sender
                return true
            } else {
                Cooldown(sender.uniqueId, name, cooldownDuration)
            }
        }

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