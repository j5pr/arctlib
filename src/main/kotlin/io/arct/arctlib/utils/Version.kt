package io.arct.arctlib.utils

class Version(val major: Int, val minor: Int, val micro: Int, val type: Release = Release.Release, val build: Int = 0) {
    override fun toString(): String = "$major.$minor.$micro" + when (type) {
        Release.Alpha -> "-alpha"
        Release.Beta -> "-beta"
        Release.Prerelease -> "-pre"
        else -> ""
    } + if (build > 0)
        ".${build.toString(16)}"
    else
        ""


    enum class Release {
        Release,
        Alpha,
        Beta,
        Prerelease
    }
}