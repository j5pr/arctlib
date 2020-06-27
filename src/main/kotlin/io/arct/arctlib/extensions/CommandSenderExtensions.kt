package io.arct.arctlib.extensions

import org.bukkit.command.CommandSender

infix fun CommandSender.needs(permission: String): Boolean =
    !this.hasPermission(permission)