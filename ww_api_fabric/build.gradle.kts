plugins {
    id("common-conventions")
}

dependencies {
    api(libs.quilt.config)
    implementation(libs.bundles.quilt.config)

    compileOnly(libs.fabric.loader)
    compileOnly(libs.quilt.loader)
    compileOnly(libs.jspecify)
}
