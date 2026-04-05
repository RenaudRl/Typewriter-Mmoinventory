plugins {
    kotlin("jvm") version "2.2.10"
    id("com.typewritermc.module-plugin") version "2.1.0"
}

group = "btc.renaud.mmoinventoryextension"
version = "0.0.1"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://nexus.phoenixdevt.fr/repository/maven-public/")
    maven("https://maven.typewritermc.com/beta/")
    maven("https://repo.codemc.io/repository/maven-releases/")
    maven("https://jitpack.io")
    maven("https://repo.opencollab.dev/main/")
    flatDir {
        dir("libs")
    }
}

dependencies {
    implementation("com.typewritermc:QuestExtension:0.9.0")
    implementation("com.typewritermc:BasicExtension:0.9.0")
    compileOnly("io.lumine:MythicLib-dist:1.6.2-SNAPSHOT") // Adjust the version as necessary
    compileOnly("net.Indyuce:MMOItems-API:6.9.2-SNAPSHOT") // MMOItems API
}

typewriter {
    namespace = "renaud"

    extension {
        name = "mmoinventory"
        shortDescription = "Typewriter extension for MmoInventory support."
        description =
            "This extension adds support for MmoInventory in Typewriter, allowing you to check items in mmoinventories."
        engineVersion = "0.9.0-beta-171"
        channel = com.typewritermc.moduleplugin.ReleaseChannel.BETA
        dependencies {
            dependency("typewritermc", "Quest")
        }
        paper {
            dependency("MMOInventory")
        }

    }

}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}

