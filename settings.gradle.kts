rootProject.name = "wrench-wrapper"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention").version("1.0.0")
}

include("api_fabric", "api_forge", "api_neoforge", "impl")
