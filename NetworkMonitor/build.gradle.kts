plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.canwar.networkmonitor"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                pom {
                    name.set("Network Monitor")
                    description.set("network monitor for monitoring internet access")
                    url.set("https://github.com/azisanw19/android-network-monitor")

                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("https://github.com/azisanw19/android-network-monitor/blob/main/LICENSE.txt")
                        }
                    }
                    developers {
                        developer {
                            id.set("azisanw19")
                            name.set("Aziz Anwar")
                            email.set("azisanw19@gmail.com")
                        }
                    }
                }

                from(components.findByName("release"))

                groupId = "com.github.azisanw19"
                artifactId = "android-network-monitor"
                version = "0.0.3"


            }
        }
    }
}