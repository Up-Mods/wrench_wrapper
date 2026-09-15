plugins {
    id("common-conventions")
}

dependencies {
    api(libs.quilt.config)
    implementation(libs.bundles.quilt.config)

    compileOnly(libs.fancy.mod.loader) {
        isTransitive = false
    }
    compileOnly(libs.jspecify)
}

tasks.jar.configure {
    entryCompression = ZipEntryCompression.STORED
}
