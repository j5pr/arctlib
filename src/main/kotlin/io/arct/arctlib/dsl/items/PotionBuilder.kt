package io.arct.arctlib.dsl.items

import io.arct.arctlib.extensions.unaryPlus
import io.arct.arctlib.utils.Duration
import io.arct.arctlib.utils.Roman
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.Potion
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

open class PotionBuilder : ItemBuilder(Material.POTION) {
    var effects: MutableList<Pair<PotionEffect, Boolean>> = mutableListOf()
    var mainEffect: PotionEffectType? = null

    var splash: Boolean = false

    var showEffects: Boolean = false
    var effectsFormat: String = +"&e{effect} {tier-roman} &7(&r{duration}&7)"

    fun effect(
        type: PotionEffectType,
        duration: Int,
        amplifier: Int,
        overwrite: Boolean = false,
        lambda: PotionEffectBuilder.() -> Unit = {}
    ) =
        effects.add(Pair(
            PotionEffectBuilder(type, duration, amplifier)
                .apply(lambda)
                .build(),

            overwrite
        ))

    override fun build(): ItemStack {
        val item = super.build()
        val meta = item.itemMeta as PotionMeta

        for (effect in effects)
            meta.addCustomEffect(effect.first, effect.second)

        if (mainEffect != null)
            meta.setMainEffect(mainEffect)

        if (showEffects)
            meta.lore = (meta.lore ?: listOf()) + effects.map { it.first }.map {
                effectsFormat
                    .replace("{effect}", it.type.toString())
                    .replace("{tier}", "${it.amplifier}")
                    .replace("{tier-roman}", Roman.fromInt(it.amplifier))
                    .replace("{duration}", "${it.duration}")
                    .replace("{duration-pretty}", Duration.prettify(it.duration))
            }

        item.itemMeta = meta
        val potion = Potion(1)

        potion.isSplash = splash

        potion.apply(item)
        return item
    }

    open class PotionEffectBuilder(var type: PotionEffectType, var duration: Int, var amplifer: Int) {
        var ambient: Boolean? = null
        var particles: Boolean? = null

        open fun build(): PotionEffect = when {
            ambient != null && particles != null ->
                PotionEffect(type, duration, amplifer, ambient!!, particles!!)
            ambient != null ->
                PotionEffect(type, duration, amplifer, ambient!!)
            else ->
                PotionEffect(type, duration, amplifer)
        }
    }
}