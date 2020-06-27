package io.arct.arctcore

import io.arct.arctcore.commands.CommandArct
import io.arct.arctcore.commands.CommandScript
import io.arct.arctlib.plugin.Plugin
import io.arct.arctlib.utils.Version

class ArctCore : Plugin() {
    override fun enable() {
        register()
    }

    private fun register() {
        command<CommandArct>()
        command<CommandScript>()
    }

    companion object {
        val version = Version(1, 0, 0, Version.Release.Alpha)
        val latest = Version(0, 0, 0)
    }
}