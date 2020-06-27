plugins {
    kotlin("jvm")

    id("com.github.johnrengelman.shadow")
}

group = "io.arct"
version = "1.0.0-alpha"

dependencies {
    implementation("de.tr7zw:item-nbt-api:2.3.2")
}

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

        relocate("de.tr7zw.changeme", "io.arct.arctlib.x.item-nbt-api")
    }
}