plugins {
    id("common-conventions")
    alias(libs.plugins.shadow)
}

dependencies {
    implementation(libs.bundles.quilt.config)
    implementation(libs.jspecify)
    shadow(libs.bundles.quilt.config)
}

tasks.shadowJar {
    archiveClassifier = ""

    minimize {
        r8 {
            enableOptimization()
            keepRuleFiles.from(layout.projectDirectory.file("rules.pro"))
        }
    }
}
