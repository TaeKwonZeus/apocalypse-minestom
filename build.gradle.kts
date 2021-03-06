plugins {
    kotlin("jvm") version "1.6.10"
    java
}

group = "com.github.bakane"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/maven")
    maven("https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.github.Minestom:Minestom:024ba736ce")
}