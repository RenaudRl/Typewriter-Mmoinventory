dependencies {
    compileOnly("io.lumine:MythicLib-dist:1.6.2-SNAPSHOT")
    compileOnly("net.Indyuce:MMOItems-API:6.9.2-SNAPSHOT")
    implementation("com.typewritermc:QuestExtension:0.9.0")
}

plugins {
    kotlin("jvm") version "2.2.10"
    id("com.typewritermc.module-plugin") version "2.2.0"
}

repositories {
    mavenCentral()
    maven("https://maven.typewritermc.com/beta/")
    maven("https://maven.typewritermc.com/external")
    maven("https://nexus.phoenixdevt.fr/repository/maven-public/")
}

group = "btc.renaud"
version = "0.0.6"

base {
    archivesName.set("MMOInventoryExtension")
}

typewriter {
    namespace = "btcrenaud"
    extension {
        name = "Mmoinventory"
        shortDescription = "Typewriter extension for MmoInventory support."
        description = "A comprehensive TypeWriter extension providing advanced gameplay features for Minecraft servers on Paper 1.21+. Fully compatible with the official TypeWriter engine and PlaceholderAPI."
        engineVersion = "0.9.0-beta-176"
        channel = com.typewritermc.moduleplugin.ReleaseChannel.BETA
        
        paper()

        dependencies {
            dependency("typewritermc", "Quest")
        }
    }
}

    

kotlin {
    jvmToolchain(21)
}

