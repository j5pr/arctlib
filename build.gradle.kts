plugins {
    kotlin("jvm") version "1.5.21"
}

group = "io.arct"
version = "1.0.0-alpha"

allprojects {
    apply(plugin = "kotlin")

    sourceSets {
        main {
            java {
                srcDirs("kotlin")
            }
        }

        test {
            java {
                srcDirs()
            }
        }
    }

    repositories {
        mavenCentral()

        maven(url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/"))

        maven(url = uri("https://oss.sonatype.org/content/repositories/snapshots"))
        maven(url = uri("https://oss.sonatype.org/content/repositories/central"))

        maven(url = uri("https://repo.codemc.org/repository/maven-public/"))
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    }

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    tasks {
        compileKotlin {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
}

subprojects {
    apply(plugin = "kotlin")

    dependencies {
        implementation(project(":"))
    }
}