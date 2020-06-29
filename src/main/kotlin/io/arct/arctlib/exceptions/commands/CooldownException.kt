package io.arct.arctlib.exceptions.commands

import io.arct.arctlib.exceptions.InternalPluginException

class CooldownException(remaining: Int) : InternalPluginException() {
    override val node = "commands.cooldown"
    override val default = "&7Please wait &f$remaining &7more seconds before executing this command again."
}