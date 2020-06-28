plugins {
    kotlin("jvm")

    id("com.github.johnrengelman.shadow")
}

group = "io.arct"
version = "1.0.0-alpha"

configurations {
    runtime {
        exclude(module = "spigot-api")
    }
}

tasks {
    shadowJar {
        archiveBaseName.set("arctcore")
        archiveClassifier.set("")
        archiveVersion.set("1.0.0-alpha")
    }
}