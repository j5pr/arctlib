package io.arct.arctlib.exceptions.permissions

import io.arct.arctlib.exceptions.InternalPluginException
import io.arct.arctlib.plugin.commands.CommandTarget
import org.bukkit.entity.Player

class OtherPermissionException(target: Player) : InternalPluginException() {
    override val node = "permissions.permission-other"
    override val default = "&f{target} &7does not have permission"

    override val placeholders = mapOf(
        "target" to target.name,
        "target-display" to target.displayName,
        "target-uuid" to target.uniqueId.toString()
    )
}