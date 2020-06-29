package io.arct.arctlib.exceptions.permissions

import org.bukkit.entity.Player

class TargetExemptException(target: Player) : PermissionException() {
    override val node = "permissions.target-exempt"
    override val default = "&e{target}&7 is exempt from this!"

    override val placeholders = mapOf(
        "target" to target.name,
        "target-display" to target.displayName,
        "target-uuid" to target.uniqueId.toString()
    )
}