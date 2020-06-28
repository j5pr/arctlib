package io.arct.arctlib.configuration

import io.arct.arctlib.plugin.Plugin
import org.bukkit.configuration.Configuration
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

open class Config internal constructor (
    private val file: File,
    private val config: FileConfiguration,
    private val plugin: Plugin
) : Configuration by config {

    fun save() =
        config.save(file)

    fun load() =
        config.load(file)

    companion object {
        fun of(path: String, plugin: Plugin): Config {
            val file = getFile(path, plugin)
            val config = Config(file, getConfig(path, plugin), plugin)

            config.options().copyDefaults(true)
            config.save()

            return config
        }

        internal fun getFile(path: String, plugin: Plugin): File {
            val file = File("${plugin.dataFolder.path}${File.separator}${path.replace("/", File.separator, true)}")

            if (!file.exists()) {
                file.parentFile.mkdirs()
                plugin.saveResource(path, false)
            }

            return file
        }

        internal fun getConfig(path: String, plugin: Plugin): FileConfiguration =
            YamlConfiguration.loadConfiguration(getFile(path, plugin))
    }
}