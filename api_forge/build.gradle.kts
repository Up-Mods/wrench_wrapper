plugins {
    id("common-conventions")
}

dependencies {
    api(libs.quilt.config)
    implementation(libs.bundles.quilt.config)

    compileOnly(libs.forge.mod.loader) {
        isTransitive = false
    }
    compileOnly(libs.jspecify)
}

