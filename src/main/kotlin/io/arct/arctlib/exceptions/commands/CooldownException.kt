package io.arct.arctlib.exceptions.commands

import io.arct.arctlib.exceptions.InternalPluginException

class CooldownException(remaining: Int) : InternalPluginException() {
    override val node = "commands.cooldown"
    override val default = "&7You are on cooldown for this command, please wait $remaining more seconds!"
}