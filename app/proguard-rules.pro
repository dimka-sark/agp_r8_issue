# Imaginate situation we need access this class from reflection
-keep class com.example.r8_issue_agp_7_3.test.** { *; }

# Want to check that FastServiceLoader is cleared from beta and release build
-checkdiscard class kotlinx.coroutines.internal.FastServiceLoader