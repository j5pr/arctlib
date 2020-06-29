package io.arct.arctlib.exceptions.permissions

class InsufficientPermissionsException : PermissionException() {
    override val node = "permissions.insufficient-permissions"
    override val default = "&7You do not have permission to do this!"
}