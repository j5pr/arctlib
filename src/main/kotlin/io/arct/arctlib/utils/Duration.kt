package io.arct.arctlib.utils

object Duration {
    fun prettify(duration: Int): String {
        val hours: Int = duration / 3600
        val minutes: Int = (duration % 3600) / 60;
        val seconds: Int = duration % 60

        return "$hours:$minutes:$seconds"
    }
}