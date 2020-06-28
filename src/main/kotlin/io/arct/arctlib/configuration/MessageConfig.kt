package io.arct.arctlib.configuration

import io.arct.arctlib.exceptions.PluginException
import io.arct.arctlib.extensions.color
import io.arct.arctlib.extensions.fmt
import io.arct.arctlib.extensions.unaryPlus
import io.arct.arctlib.plugin.Plugin
import org.bukkit.configuration.file.FileConfiguration
import java.io.File

class MessageConfig private constructor (
    file: File,
    config: FileConfiguration,
    plugin: Plugin
) : Config(file, config, plugin) {
    fun message(node: String, vararg placeholders: Pair<String, String>): String? =
        message(node, mapOf(*placeholders))

    fun message(node: String, placeholders: Map<String, String>): String? {
        val format = getString("\$format.${node.split(".")[0]}") ?: "{}"
        val message = getString(node) ?: return null

        return format.fmt("" to message).fmt(placeholders)
    }

    infix fun raise(exception: PluginException): String? =
        (message("error.${exception.node}", exception.placeholders)
            ?.fmt("exception" to (exception::class.java.simpleName ?: "Exception")))?.color()

    companion object {
        fun of(path: String, plugin: Plugin): MessageConfig {
            val file = getFile(path, plugin)
            val config = MessageConfig(file, getConfig(path, plugin), plugin)

            config.options().copyDefaults(true)
            config.save()

            return config
        }
    }
}