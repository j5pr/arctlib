package io.arct.testplugin

import io.arct.arctlib.plugin.Plugin
import io.arct.testplugin.commands.CommandTestItems
import io.arct.testplugin.commands.CommandTestMessage
import io.arct.testplugin.commands.CommandTestPing

class TestPlugin : Plugin() {
    override fun enable() {
        command<CommandTestMessage>()
        command<CommandTestItems>()
        command<CommandTestPing>()
    }
}