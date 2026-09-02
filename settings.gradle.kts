rootProject.name = "wrench-wrapper"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        exclusiveContent {
            forRepository {
                maven("https://maven.quiltmc.org/repository/release/")
            }
            filter {
                includeGroupAndSubgroups("org.quiltmc")
            }
        }
        exclusiveContent {
            forRepository {
                maven("https://maven.fabricmc.net")
            }
            filter {
                includeGroup("net.fabricmc")
            }
        }
        exclusiveContent {
            forRepository {
                maven("https://maven.neoforged.net/releases")
            }
            filter {
                includeGroup("net.neoforged.fancymodloader")
            }
        }
        exclusiveContent {
            forRepository {
                google()
            }
            filter {
                includeGroup("com.android.tools")
            }
        }
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention").version("1.0.0")
}

includeBuild("build-logic")
include("ww_api_fabric")
include("ww_api_forge")
include("ww_api_neoforge")
include("ww_impl")
