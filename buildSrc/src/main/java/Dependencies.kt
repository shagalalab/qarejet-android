object Android {
    const val compile_sdk_version = 29
    const val build_tools_version = "29.0.3"
    const val min_sdk_version = 19
    const val target_sdk_version = 29
    const val version_code = 1
    const val version_name = "0.1"
}

object Versions {
    const val appcompat = "1.2.0"
    const val constraint_layout = "1.1.3"
    const val coroutines = "1.3.9"
    const val espresso_core = "3.2.0"
    const val ext_junit = "1.1.1"
    const val gradle = "4.1.1"
    const val junit = "4.12"
    const val koin = "2.2.0-beta-1"
    const val kotlin = "1.4.10"
    const val ktx = "1.3.1"
    const val lifecycle = "2.1.0"
    const val material = "1.2.0"
    const val navigation = "2.3.0"
    const val room = "2.2.5"
}

object Modules {
    const val core_data = ":core-data"
    const val core_prefs = ":core-prefs"
    const val core_resources = ":core-resources"
    const val core_usf = ":core-usf"
    const val core_utils = ":core-utils"
    const val feature_records = ":feature-records"
    const val feature_splash = ":feature-splash"
    const val feature_stats = ":feature-stats"
    const val feature_transaction = ":feature-transaction"
}

object Libs {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koin_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val kotlin_std = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
    const val ext_junit = "androidx.test.ext:junit:${Versions.ext_junit}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
}
