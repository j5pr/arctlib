plugins {
    kotlin("jvm")

    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "io.arct"
version = "1.0.0-alpha"

configurations {
    runtime {
        exclude(module = "spigot-api")
    }
}

tasks {
    jar {
        enabled = false
    }

    build {
        dependsOn("shadowJar")
    }

    shadowJar {
        archiveBaseName.set("arct-core")
        archiveClassifier.set("")
        archiveVersion.set("1.0.0-alpha")
    }
}