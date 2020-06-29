package io.arct.arctlib.plugin.commands

enum class CommandTarget {
    Player,
    System,
    Console;

    override fun toString(): String = name.toUpperCase()
}