package io.arct.arctlib.dsl.custom

import io.arct.arctlib.custom.items.CustomItem
import io.arct.arctlib.dsl.items.ItemBuilder
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

open class CustomItemBuilder {
    var identifier: String? = null
    var item: ItemStack? = null

    inline fun item(material: Material, lambda: ItemBuilder.() -> Unit = {}) {
        item = io.arct.arctlib.dsl.item(material, lambda)
    }

    open fun build(): CustomItem = CustomItem(item!!, identifier!!)
}