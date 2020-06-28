package io.arct.testplugin.commands

import io.arct.arctlib.dsl.*
import io.arct.arctlib.extensions.unaryPlus
import io.arct.arctlib.plugin.commands.Command
import io.arct.arctlib.plugin.commands.CommandTarget
import io.arct.arctlib.plugin.commands.Run
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffectType

class CommandTestItems : Command("testitems") {
    @Run(CommandTarget.Player) fun run(player: Player, args: List<String>) {
        listOf(
            item(Material.APPLE) {
                name = +"&cCool Apple"

                lore(+"&7 Cool apples are cool!")
            },
            writtenBook {
                title = "tes"

                page("hello")
                page("there")
            },
            skull {
                name = "loser's skull"
                amount = 4
                owner = "iGotStatWiped"

                lore(+"&7this skull is the skull of")
                lore(+"&7a &c&ltrash &7minecraft player")
            },
            potion {
                mainEffect = PotionEffectType.HEALTH_BOOST

                effect(PotionEffectType.HEALTH_BOOST, 60, 3)
                effect(PotionEffectType.ABSORPTION, 2, 4)
            },
            enchantedBook {
                enchant(Enchantment.KNOCKBACK, 4)
                enchant(Enchantment.DIG_SPEED, 3)
            }
        ).forEach {
            player.inventory.addItem(it)
        }
    }
}