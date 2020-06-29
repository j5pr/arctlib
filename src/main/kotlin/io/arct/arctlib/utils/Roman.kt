package io.arct.arctlib.utils

object Roman {
    private val map: Map<String, String> = mapOf(
        "IIIII" to "V",
        "IIII" to "IV",
        "VV" to "X",
        "VIV" to "IX",
        "XXXXX" to "L",
        "XXXX" to "XL",
        "LL" to "C",
        "LXL" to "XC",
        "CCCCC" to "D",
        "CCCC" to "CD",
        "DD" to "M",
        "DCD" to "CM"
    )

    fun fromInt(n: Int): String {
        var str: String = "I".repeat(n)

        for ((a, b) in map)
            str = str.replace(a, b)

        return str
    }

    fun toInt(roman: String): Int {
        var str = roman

        for ((b, a) in map)
            str = str.replace(a, b)

        return str.length
    }
}