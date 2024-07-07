object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val lifeCycleRunTimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycleRunTimeKtx}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBom}" }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val composeUiGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val material3 by lazy { "androidx.compose.material3:material3" }
    val junit by lazy { "junit:junit:${Versions.junit}" }
    val testExtJunit by lazy { "androidx.test.ext:junit:${Versions.testExtJunit}" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }
    val composeUiTestJunit4 by lazy { "androidx.compose.ui:ui-test-junit4" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling" }
    val composeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest" }
    val appCompat by lazy { "androidx.appcompat:appcompat : ${Versions.appCompat}"}
    val material by lazy { "com.google.android.material:material : ${Versions.material}"}

    val hiltAndroid by lazy {"com.google.dagger:hilt-android: ${Versions.hiltAndroid}"}
    val hiltAndroidCompiler by lazy {"com.google.dagger:hilt-android-compiler: ${Versions.hiltAndroid}"}
    val hiltCompiler by lazy {"androidx.hilt:hilt-compiler: ${Versions.hiltCompiler}"}
}

// *** Module path - This can be seen in settings.gradle once you add a new module into the Project
object Modules{
    const val utilities = ":utilities"
}