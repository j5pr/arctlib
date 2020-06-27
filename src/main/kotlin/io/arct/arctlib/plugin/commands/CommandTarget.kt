package io.arct.arctlib.plugin.commands

enum class CommandTarget {
    Player,
    System,
    Console;

    override fun toString(): String = mapOf(
        Player to "PLAYER",
        System to "SYSTEM",
        Console to "CONSOLE"
    )[this] ?: error("Could not convert CommandTarget to String")
}