package io.arct.arctlib.custom.items

import org.bukkit.inventory.ItemStack
import de.tr7zw.changeme.nbtapi.NBTItem

class CustomItem(
    val item: ItemStack,
    val identifier: String
) {
    fun create(): ItemStack {
        val nbt = NBTItem(item.clone())

        nbt.setString("io.arct.custom.identifier", identifier)

        return nbt.item
    }

    fun match(item: ItemStack): Boolean =
        NBTItem(item).hasKey("io.arct.custom.identifier") &&
        NBTItem(item).getString("io.arct.custom.identifier") == identifier
}