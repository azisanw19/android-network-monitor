# Network Monitor

An android lib that connectivity Internet View

# Getting Started

### Add the JitPack repository to your build file

For Gradle with the Groovy language

```groovy
	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```

For Gradle with the Kotlin DSL language

```kotlin
dependencyResolutionManagement {
    repositories {
        maven { url = URI.create("https://jitpack.io") }
    }
}
```

# Add the dependency

For Gradle with the Groovy language

```groovy
	dependencies {
	        implementation 'com.github.azisanw19:android-network-monitor:Tag'
	}
```

For Gradle with the Kotlin DSL language

```kotlin
    dependencies {
        implementation("com.github.azisanw19:android-network-monitor:Tag")
    }
```

# Usage

Example in jetpack Compose

```kotlin
private val networkMonitor: NetworkMonitor by lazy {
    NetworkManager(applicationContext)
}

val stateNetwork = remember { 
    networkMonitor.isOnline
        .map { !it }
        .stateIn(
            scope = coroutineScope, // coroutine scope
            started = SharingStarted.WhileSubscribed(5_000), // Delay subcribe
            initialValue = false
        ) 
}
    
val snackbarHostState = remember { SnackbarHostState() }

val isOffline by stateNetwork.collectAsState()

// If user is not connected to the internet show a snack bar to inform them.
val notConnectedMessage = stringResource(R.string.not_connected)
LaunchedEffect(isOffline) {
    if (isOffline) {
        snackbarHostState.showSnackbar(
            message = notConnectedMessage,
            duration = SnackbarDuration.Indefinite,
        )
    }
}
```

You can use Android XML by subscribing to the data stream network.

# Contributing

Please open an issue first before making a pull request.

# License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

> http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.