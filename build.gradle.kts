plugins {
    kotlin("jvm") version "1.6.10"
    java
}

group = "com.github.bakane"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://repo.spongepowered.org/maven")
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.jenya705:hotcore:1.0")
    implementation(kotlin("stdlib"))
    implementation("com.github.Minestom:Minestom:4ab2f43eed")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}