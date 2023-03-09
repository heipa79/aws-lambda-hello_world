
plugins {
    kotlin("jvm") version "1.8.10"
    application
}

group = "com.fielmann.playground"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(8)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}

tasks {
    jar {
        archiveFileName.set("kotlin-lambda.jar")
        from(
            configurations
                .runtimeClasspath.get().files.filter { it.exists() }
                .map { if (it.isDirectory) it else zipTree(it) },
        )
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
}
