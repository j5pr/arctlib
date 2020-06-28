package io.arct.arctlib.exceptions

abstract class InternalPluginException internal constructor() : PluginException() {
    abstract val default: String
}