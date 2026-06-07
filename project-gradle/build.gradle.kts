import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.io.FileInputStream
import java.util.Properties

plugins {
    java
    application
    id("com.gradleup.shadow") version "9.3.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("org.example.Main")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":string-utils"))
    
    testImplementation(platform("org.junit:junit-bom:6.0.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.shadowJar {
    manifest {
        attributes(Pair("Main-Class", "org.example.Main"))
    }
}

tasks.register("generateBuildInfo") {
    group = "Custom"
    description = "Generates build passport"
    
    val outputFile = file("src/main/resources/build-passport.properties")
    val buildNumberFile = file("build-number.properties")
    
    doLast {
        var buildNumber = 1
        if (buildNumberFile.exists()) {
            val props = Properties()
            FileInputStream(buildNumberFile).use { input ->
                props.load(input)
                buildNumber = (props.getProperty("build.number", "0").toInt() + 1)
            }
        }
        
        val buildProps = Properties()
        buildProps.setProperty("build.number", buildNumber.toString())
        buildNumberFile.outputStream().use { output ->
            buildProps.store(output, "Build Number")
        }
        
        val gitCommitHash = try {
            val process = ProcessBuilder("git", "rev-parse", "--short", "HEAD")
                .redirectErrorStream(true)
                .start()
            process.inputStream.bufferedReader().readText().trim()
        } catch (e: Exception) {
            "unknown (not a git repository)"
        }
        
        val user = System.getenv("USERNAME") ?: System.getenv("USER") ?: "Unknown"
        val os = System.getProperty("os.name")
        val javaVersion = System.getProperty("java.version")
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val timestamp = LocalDateTime.now().format(formatter)
        val welcomeMessage = "Welcome to build #$buildNumber!"

        outputFile.parentFile.mkdirs()

        outputFile.writeText("""
            build.number=$buildNumber
            git.commit=$gitCommitHash
            user=$user
            os=$os
            java_version=$javaVersion
            build_date=$timestamp
            message=$welcomeMessage
        """.trimIndent())
        
        println("Build passport generated at: ${outputFile.absolutePath}")
        println("Build #: $buildNumber")
        println("Git commit: $gitCommitHash")
    }
}

tasks.named("processResources") {
    dependsOn("generateBuildInfo")
}