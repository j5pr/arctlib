package io.arct.testplugin.commands

import io.arct.arctlib.plugin.commands.Command
import io.arct.arctlib.plugin.commands.CommandTarget
import io.arct.arctlib.plugin.commands.Run
import io.arct.arctlib.utils.Cooldown
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CommandTestPing : Command("testping") {
    override val cooldown: Int = 10

    @Run(CommandTarget.Player)
    fun run(sender: Player, args: List<String>) {
        sender.sendMessage("Pong")
    }
}