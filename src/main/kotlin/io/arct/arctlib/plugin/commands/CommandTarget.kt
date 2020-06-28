package io.arct.arctlib.plugin.commands

enum class CommandTarget {
    Player,
    System,
    Console;

    override fun toString(): String {
        val targets: MutableMap<CommandTarget, String> = mutableMapOf()
        for (value in values()) {
            targets[value] = value.name.toUpperCase()
        }
        return targets[this] ?: error("Could not convert CommandTarget to String")
    }
}