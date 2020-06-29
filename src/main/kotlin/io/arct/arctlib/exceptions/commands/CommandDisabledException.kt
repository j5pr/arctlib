package io.arct.arctlib.exceptions.commands

class CommandDisabledException : CommandException() {
    override val node = "commands.disabled"
    override val default = "&7This command is currently disabled!"
}