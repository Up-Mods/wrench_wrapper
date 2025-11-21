plugins {
    `java`
}

group = "page.langeweile"
version = "0.7.0"

// We want Java 17 because we don't aim to support Java 8 for now
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

subprojects {
    tasks.withType<JavaCompile>().configureEach {
        options.release = 17
    }

    tasks.withType<Jar>().configureEach {
        from(rootProject.file("LICENSE_wrench-wrapper.md")) {
            include("LICENSE_wrench-wrapper.md")
        }
    }
}
