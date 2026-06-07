plugins {
    `java-library`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    api("org.apache.commons:commons-lang3:3.20.0")
    api("org.slf4j:slf4j-api:2.0.17")
    api("ch.qos.logback:logback-classic:1.4.14")
}