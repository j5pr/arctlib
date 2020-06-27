package io.arct.arctcore.commands

import io.arct.arctcore.ArctCore
import io.arct.arctlib.ArctLib
import io.arct.arctlib.extensions.unaryPlus
import io.arct.arctlib.plugin.commands.Command
import io.arct.arctlib.plugin.commands.Run
import org.bukkit.command.CommandSender

class CommandArct : Command("arctcore") {
    override val permissions = listOf("arctcore.info")

    private val messages: Array<out String> = listOf(
        +"&7&l--- &eArctCore Installation &7&l---",
        +"&fStatus&7: &aEnabled",
        +"&fCurrent Version&7: &e${ArctCore.version}",
        +"&fLatest Version&7: &e${ArctCore.latest}",

        +"",

        +"&7&l--- &eArctLib Installation &7&l---",
        +"&fCurrent Version&7: &e${ArctLib.version}",
        +"&fLatest Version&7: &e${ArctLib.latest}"
    ).toTypedArray()

    @Run fun run(sender: CommandSender, args: List<String>) =
        sender.sendMessage(messages)
}