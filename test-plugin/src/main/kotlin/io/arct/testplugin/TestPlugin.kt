package io.arct.testplugin

import io.arct.arctlib.plugin.Plugin
import io.arct.testplugin.commands.CommandTestItems
import io.arct.testplugin.commands.CommandTestMessage
import io.arct.testplugin.commands.CommandTestCooldown1
import io.arct.testplugin.commands.CommandTestCooldown2

class TestPlugin : Plugin() {
    override fun enable() {
        command<CommandTestMessage>()
        command<CommandTestItems>()
        command<CommandTestCooldown1>()
        command<CommandTestCooldown2>()
    }
}