plugins {
    `java`
    `maven-publish`
    alias(libs.plugins.gr8)
}

group = "page.langeweile.wrench_wrapper"
version = rootProject.version

repositories {
    mavenCentral()
    maven("https://storage.googleapis.com/r8-releases/raw")
    maven("https://maven.quiltmc.org/repository/release/")
}

val shade = configurations.create("shade")

dependencies {
    implementation(libs.bundles.quilt.config)
    implementation(libs.jspecify)
    shade(libs.bundles.quilt.config)
}

tasks.processResources {
    filteringCharset = "UTF-8"

    val version = project.version
    inputs.property("version", version)

    filesMatching(listOf("fabric.mod.json", "quilt.mod.json", "META-INF/mods.toml", "META-INF/neoforge.mods.toml")) {
        expand("version" to version)
    }
}

gr8 {
    val optimizedJar = create("shrink") {
        addProgramJarsFrom(shade)
        addProgramJarsFrom(tasks.jar)
        proguardFile(file("rules.pro"))
        r8Version(libs.versions.r8.get())
    }
    replaceOutgoingJar(optimizedJar)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }

    repositories {
        val env = System.getenv()
        if (env.contains("MAVEN_UPLOAD_URL")) {
            maven(uri(env["MAVEN_UPLOAD_URL"]!!)) {
                credentials {
                    username = env["MAVEN_UPLOAD_NAME"]
                    password = env["MAVEN_UPLOAD_PASSWORD"]
                }
            }
        }
    }
}
