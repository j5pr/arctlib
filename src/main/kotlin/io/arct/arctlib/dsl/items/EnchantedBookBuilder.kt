package io.arct.arctlib.dsl.items

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.EnchantmentStorageMeta

open class EnchantedBookBuilder : ItemBuilder(Material.ENCHANTED_BOOK) {
    var storedEnchants: MutableList<Triple<Enchantment, Int, Boolean>> = mutableListOf()

    fun storedEnchant(enchantment: Enchantment, level: Int, force: Boolean = false) =
        enchants.add(Triple(enchantment, level, force))

    override fun build(): ItemStack {
        val item = super.build()
        val meta = item.itemMeta as EnchantmentStorageMeta

        for (enchant in storedEnchants)
            meta.addStoredEnchant(enchant.first, enchant.second, enchant.third)

        item.itemMeta = meta
        return item
    }
}