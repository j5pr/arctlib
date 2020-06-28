package io.arct.arctlib.dsl

import io.arct.arctlib.dsl.items.*
import org.bukkit.Material
import org.bukkit.inventory.ItemStack


inline fun item(material: Material, lambda: ItemBuilder.() -> Unit = {}): ItemStack =
    ItemBuilder(material).apply(lambda).build()

inline fun potion(lambda: PotionBuilder.() -> Unit = {}): ItemStack =
    PotionBuilder().apply(lambda).build()

inline fun writtenBook(published: Boolean = false, lambda: WrittenBookBuilder.() -> Unit = {}): ItemStack =
    WrittenBookBuilder(published).apply(lambda).build()

inline fun enchantedBook(lambda: EnchantedBookBuilder.() -> Unit = {}): ItemStack =
    EnchantedBookBuilder().apply(lambda).build()

inline fun skull(lambda: SkullBuilder.() -> Unit = {}): ItemStack =
    SkullBuilder().apply(lambda).build()