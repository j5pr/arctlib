package io.arct.arctlib.ui

import org.bukkit.Bukkit

open class Gui(val name: String, rows: Int) {
    private val inventory = Bukkit.createInventory(null, rows * 9, name)
}
