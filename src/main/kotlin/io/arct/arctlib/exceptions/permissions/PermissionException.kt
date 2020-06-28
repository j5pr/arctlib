package io.arct.arctlib.exceptions.permissions

import io.arct.arctlib.exceptions.InternalPluginException

class PermissionException : InternalPluginException() {
    override val node = "permissions.permission"
    override val default = "&7You do not have permission to do this!"
}