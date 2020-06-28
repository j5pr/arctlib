package io.arct.arctlib.exceptions

abstract class PluginException : Exception() {
    abstract val node: String

    open val placeholders: Map<String, String> = mapOf()
}