package io.arct.testplugin

import io.arct.arctlib.plugin.Plugin
import io.arct.testplugin.commands.CommandGuiTest

class TestPlugin : Plugin() {
    override fun enable() {
        command<CommandGuiTest>()
    }
}