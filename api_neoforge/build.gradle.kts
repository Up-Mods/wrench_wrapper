plugins {
    `java-library`
    `maven-publish`
}

group = "page.langeweile.wrench_wrapper"
version = rootProject.version

repositories {
    mavenCentral()
    maven("https://maven.neoforged.net/releases")
    maven("https://maven.quiltmc.org/repository/release/")
}

dependencies {
    api(libs.quilt.config)
    implementation(libs.bundles.quilt.config)

    compileOnly(libs.fancy.mod.loader) {
        setTransitive(false)
    }
    compileOnly(libs.jspecify)
}

tasks.processResources {
    filteringCharset = "UTF-8"

    val version = project.version
    inputs.property("version", version)

    filesMatching("META-INF/neoforge.mods.toml") {
        expand("version" to version)
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
