plugins {
    kotlin("jvm") version "2.0.20"
    id("io.qameta.allure") version "2.12.0"

}

group = "muralev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.codeborne:selenide:7.6.1")
    implementation("io.qameta.allure:allure-rest-assured:2.29.0")
    implementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}