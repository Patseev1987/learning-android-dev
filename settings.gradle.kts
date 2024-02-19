pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Android lerning Bogdan"
include(":app")
include(":tasks")
include(":cars")
include(":inners")

include(":rings")
include(":todolist")
include(":dogs")
include(":viewstestsmaterial")
include(":recycleviewmovies")
