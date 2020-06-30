package io.arct.arctlib.dsl.items

import io.arct.arctlib.extensions.unaryPlus
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

open class ItemBuilder(val material: Material) {
    var amount: Int = 1
    var durability: Short? = null

    var name: String? = null
    var lore: MutableList<String> = mutableListOf()
    var enchants: MutableList<Triple<Enchantment, Int, Boolean>> = mutableListOf()
    var flags: MutableList<ItemFlag> = mutableListOf()

    fun lore(vararg lines: String) =
        lore.addAll(lines)

    fun enchant(enchantment: Enchantment, level: Int, force: Boolean = false) =
        enchants.add(Triple(enchantment, level, force))

    fun flag(vararg flags: ItemFlag) =
        this.flags.addAll(flags)

    open fun build(): ItemStack {
        val item = ItemStack(material)
        val meta = item.itemMeta

        if (name != null)
            meta.displayName = +"&r$name"

        item.amount = amount

        val durability = this.durability
        if (durability != null)
            item.durability = durability

        if (lore.size > 0)
            meta.lore = lore.map { +"&r$it" }

        for (enchant in enchants)
            meta.addEnchant(enchant.first, enchant.second, enchant.third)

        meta.addItemFlags(*flags.toTypedArray())

        item.itemMeta = meta
        return item
    }
}