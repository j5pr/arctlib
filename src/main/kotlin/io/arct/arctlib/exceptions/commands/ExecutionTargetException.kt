package io.arct.arctlib.exceptions.commands

import io.arct.arctlib.exceptions.InternalPluginException
import io.arct.arctlib.plugin.commands.CommandTarget

class ExecutionTargetException(target: CommandTarget) : InternalPluginException() {
    override val node = "commands.execution-target"
    override val default = "&7This command cannot be run by &f{target}&7!"

    override val placeholders = mapOf(
        "target" to target.name
    )
}