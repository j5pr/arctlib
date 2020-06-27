package io.arct.arctlib.extensions

import org.bukkit.ChatColor

operator fun String.unaryPlus(): String =
    ChatColor.translateAlternateColorCodes('&', this)

fun String.format(templates: Map<String, String> = mapOf()): String {
    var str: String = this

    for ((key, value) in templates)
        str = str.replace(Regex("(?<!\\\\)\\{${key}"), value)

    return str
}