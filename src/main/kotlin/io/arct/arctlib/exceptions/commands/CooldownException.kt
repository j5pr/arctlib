package io.arct.arctlib.exceptions.commands

class CooldownException(remaining: Int) : CommandException() {
    override val node = "commands.cooldown"
    override val default = "&7Please wait &f{remaining} &7more seconds before executing this command again."

    override val placeholders = mapOf(
        "remaining" to "$remaining"
    )
}