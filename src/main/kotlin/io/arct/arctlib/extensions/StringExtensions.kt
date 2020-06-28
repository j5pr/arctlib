package io.arct.arctlib.extensions

import org.bukkit.ChatColor
import org.bukkit.command.CommandSender

operator fun String.unaryPlus(): String =
    color()

fun String.color(): String =
    ChatColor.translateAlternateColorCodes('&', this)

fun String.fmt(vararg placeholders: Pair<String, String>): String =
    fmt(placeholders.associate { it })

fun String.fmt(placeholders: Map<String, String> = mapOf()): String {
    var str: String = this

    for ((key, value) in placeholders)
        str = str.replace("{$key}", value)

    return str
}

infix fun String.send(recipient: CommandSender) =
    recipient.sendMessage(this)