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
    val seleniumVersion = "4.33.0"

    testImplementation("org.seleniumhq.selenium:selenium-java:$seleniumVersion")
    testImplementation("org.seleniumhq.selenium:selenium-devtools-v137:$seleniumVersion")

    testImplementation("com.codeborne:selenide:7.6.1")
    testImplementation("io.qameta.allure:allure-rest-assured:2.29.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    testImplementation("io.qameta.allure:allure-junit5:2.24.0")
    testImplementation("io.qameta.allure:allure-selenide:2.24.0")

    implementation("org.slf4j:slf4j-api:2.0.13")
    runtimeOnly("org.slf4j:slf4j-simple:2.0.13")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("org.slf4j.simpleLogger.defaultLogLevel", "info")
    systemProperty("allure.results.directory", "build/allure-results")
}

kotlin {
    jvmToolchain(21)
}

allure {
    version.set("2.24.0")
}
