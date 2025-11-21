plugins {
    `java-library`
    `maven-publish`
}

group = "page.langeweile.wrench_wrapper"
version = "0.7.2"

// We want Java 17 because we don't aim to support Java 8 for now
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release = 17
}

tasks.withType<Jar>().configureEach {
    from(rootProject.file("LICENSE_wrench-wrapper.md")) {
        include("LICENSE_wrench-wrapper.md")
    }
}

// TODO - Clear this mess!!!!!!
tasks.processResources {
    filteringCharset = "UTF-8"

    val version = project.version
    inputs.property("version", version)

    filesMatching(listOf("fabric.mod.json", "quilt.mod.json", "META-INF/mods.toml", "META-INF/neoforge.mods.toml")) {
        expand("version" to version)
    }
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
                    username = env["MAVEN_UPLOAD_USERNAME"]
                    password = env["MAVEN_UPLOAD_PASSWORD"]
                }
            }
        }
    }
}
