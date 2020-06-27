package io.arct.arctlib.extensions

import io.arct.arctlib.custom.items.CustomItem
import org.bukkit.inventory.ItemStack

infix fun ItemStack.isCustom(customItem: CustomItem): Boolean =
    customItem.match(this)