package io.arct.arctlib.dsl.items

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta

open class SkullBuilder : ItemBuilder(Material.SKULL_ITEM) {
    var owner: String? = null

    override fun build(): ItemStack {
        val item = super.build()
        val meta = item.itemMeta as SkullMeta

        item.durability = 3.toShort()

        if (owner != null)
            meta.owner = owner

        item.itemMeta = meta
        return item
    }
}