plugins {
    id("org.springframework.boot") version "3.5.5" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
    kotlin("jvm") apply false
    kotlin("plugin.spring") version "2.2.10" apply false
}

subprojects {
    apply(plugin = "buildsrc.convention.kotlin-jvm")
}


allprojects {
    repositories {
        mavenCentral()
    }
}
