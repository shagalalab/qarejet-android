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
    const val espresso_core = "3.2.0"
    const val ext_junit = "1.1.1"
    const val gradle = "4.0.1"
    const val junit = "4.12"
    const val kotlin = "1.3.72"
    const val ktx = "1.3.1"
    const val material = "1.2.0"
}

object Libs {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val kotlin_std = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val material = "com.google.android.material:material:${Versions.material}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
    const val ext_junit = "androidx.test.ext:junit:${Versions.ext_junit}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
}
