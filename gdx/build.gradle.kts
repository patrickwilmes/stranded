plugins {
    kotlin("jvm") version "1.9.21"
}

group = "com.bit.lake"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    google()
    gradlePluginPortal()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    maven(url = "https://oss.sonatype.org/content/repositories/releases/")
    maven(url = "https://jitpack.io")
}

val gdxVersion = "1.12.1"

dependencies {
    api("com.badlogicgames.gdx:gdx-backend-lwjgl3:$gdxVersion")
    api("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-desktop")
    api("com.badlogicgames.gdx:gdx-freetype-platform:$gdxVersion:natives-desktop")
    api("com.badlogicgames.gdx:gdx-bullet-platform:$gdxVersion:natives-desktop")
    api("org.jetbrains.kotlin:kotlin-stdlib:1.9.21")
    api("com.badlogicgames.gdx:gdx:$gdxVersion")
    api("com.badlogicgames.gdx:gdx-freetype:$gdxVersion")
    api("com.badlogicgames.gdx:gdx-bullet:$gdxVersion")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}
