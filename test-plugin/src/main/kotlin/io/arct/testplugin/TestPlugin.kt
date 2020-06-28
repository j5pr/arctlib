package io.arct.testplugin

import io.arct.arctlib.plugin.Plugin
import io.arct.testplugin.commands.CommandTestItems
import io.arct.testplugin.commands.CommandTestMessage

class TestPlugin : Plugin() {
    override fun enable() {
        command<CommandTestMessage>()
        command<CommandTestItems>()
    }
}