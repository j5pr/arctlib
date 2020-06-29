@file:Suppress("unused")

package io.arct.arctlib.extensions

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.configuration.Configuration
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

/**
 * Get an [ItemStack].
 *
 * @param path The path of the [ItemStack].
 */
fun Configuration.item(path: String): ItemStack? {
    if (!isSet("$path.material") || !Material.values().any { it.name == getString("$path.material")?.toUpperCase() })
        return null

    val material = Material.getMaterial(getString("$path.material")!!.toUpperCase())!!

    if (material == Material.AIR)
        return null

    val name = getString("$path.name")
    val quantity = if (isSet("$path.quantity")) this.getInt("$path.quantity") else 1

    val lore = if (isSet("$path.lore")) getStringList("$path.lore").joinToString(" ") else null
    val flags = if (isSet("$path.flags")) getStringList("$path.flags").map { ItemFlag.valueOf(it) } else null

    //OBSOLETE
    //val item = ItemStack(name, lore, material, quantity)
    val item = ItemStack(material)
    val meta = item.itemMeta

    if (flags != null)
        meta?.addItemFlags(*flags.toTypedArray())

    item.itemMeta = meta

    return item
}

/**
 * Save an [ItemStack].
 *
 * @param path The path to save the [ItemStack].
 * @param item The [ItemStack] to save.
 */
fun Configuration.item(path: String, item: ItemStack?) {
    if (item == null)
        return

    val meta = item.itemMeta

    set("$path.material", item.type.name)
    set("$path.name", if (item.itemMeta?.hasDisplayName() == true) item.itemMeta?.displayName else null)
    set("$path.quantity", item.amount)
    set("$path.lore", meta?.lore)
    set("$path.flags", meta?.itemFlags?.map { it.name }?.toTypedArray())
}

/**
 * Get an [Inventory].
 *
 * @param path The path of the [Inventory].
 */
fun Configuration.inventory(path: String): Inventory? {
    if (!isSet("$path.size"))
        return null

    val title = getString("$path.title") ?: "Inventory"
    val size = getInt("$path.rows") * 9

    val inventory = Bukkit.createInventory(null, size, title)

    for (slot in 0 until size)
        if (isSet("$path.contents.$slot"))
            inventory.setItem(slot, item("$path.contents.$slot"))

    return inventory
}

/**
 * Save an [Inventory].
 *
 * @param path The path to save the [Inventory].
 * @param inventory The [Inventory] to save.
 */
fun Configuration.inventory(path: String, inventory: Inventory) {
    set("$path.title", inventory.type.defaultTitle)
    set("$path.rows", inventory.size / 9)

    for (slot in 0 until inventory.size)
        item("$path.contents.$slot", inventory.getItem(slot))
}

/**
 * Get a [Location].
 *
 * @param path The path of the [Location].
 */
fun Configuration.location(path: String): Location? {
    if (!isSet("$path.world") || !isSet("$path.x") || !isSet("$path.y") || !isSet("$path.z"))
        return null

    val world = Bukkit.getWorld(getString("$path.world")!!)
    val x = getDouble("$path.x")
    val y = getDouble("$path.y")
    val z = getDouble("$path.z")

    val yaw = if (isSet("$path.yaw")) getDouble("$path.yaw") else null
    val pitch = if (isSet("$path.pitch")) getDouble("$path.pitch") else null

    return if (yaw != null && pitch != null)
        Location(world, x, y, z, yaw.toFloat(), pitch.toFloat())
    else
        Location(world, x, y, z)
}

/**
 * Save a [Location].
 *
 * @param path The path to save the [Location].
 * @param location The [Location] to save.
 */
fun Configuration.location(path: String, location: Location) {
    set("$path.world", location.world?.name)

    set("$path.x", location.x)
    set("$path.y", location.y)
    set("$path.z", location.z)

    set("$path.yaw", location.yaw)
    set("$path.pitch", location.pitch)
}