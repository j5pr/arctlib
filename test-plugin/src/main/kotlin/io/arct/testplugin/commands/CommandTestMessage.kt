package io.arct.testplugin.commands

import io.arct.arctlib.exceptions.PluginException
import io.arct.arctlib.extensions.send
import io.arct.arctlib.plugin.commands.Command
import io.arct.arctlib.plugin.commands.Run
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CommandTestMessage : Command("testmessage") {
    @Run
    fun run(player: CommandSender, args: List<String>) {
        plugin.logger.info(plugin.messages.toString())

        if (args.isEmpty()) {
            plugin raise object : PluginException() {
                override val node = "bad-args"
            } send player

            return
        }

        plugin.message(args[0], "0" to "lol") send player
    }
}