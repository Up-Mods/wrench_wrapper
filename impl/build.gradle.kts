plugins {
    id("common-conventions")
    alias(libs.plugins.gr8)
}

val shade = configurations.create("shade")

dependencies {
    implementation(libs.bundles.quilt.config)
    implementation(libs.jspecify)
    shade(libs.bundles.quilt.config)
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
