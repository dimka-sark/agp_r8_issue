# minifyEnabled and debuggable with AGP 7.3.1 classes does not minified issue

## Overview

If application use

```groovy
android {
  buildTypes {
    localBeta {
      debuggable true
      minifyEnabled true
      //...
    }
  }
}
```

with `proguard.pro`

```
-keep class package.** { *; }
```

minification does not applied for all referenced classes in class defined in `package.**` (from any library, example with kotlinx.coroutines Main dispatcher) 

## Step to reproduce bug

1. Open project
2. Select "app" project
3. Run `./gradlew :app:assembleLocalBeta`
4. Compilation is failed because `-checkdiscard` rule does not match

```
Item kotlinx.coroutines.internal.FastServiceLoader was not discarded.
kotlinx.coroutines.internal.FastServiceLoader
|- is referenced from:
|  kotlinx.coroutines.MainCoroutineDispatcher kotlinx.coroutines.internal.MainDispatcherLoader.loadMainDispatcher()
|- is invoked from:
|  void kotlinx.coroutines.internal.MainDispatcherLoader.<clinit>()
|- is reachable from:
|  kotlinx.coroutines.internal.MainDispatcherLoader
|- is referenced from:
|  kotlinx.coroutines.MainCoroutineDispatcher kotlinx.coroutines.internal.MainDispatcherLoader.dispatcher
|- is referenced from:
|  kotlinx.coroutines.MainCoroutineDispatcher kotlinx.coroutines.Dispatchers.getMain()
|- is invoked from:
|  void com.example.r8_issue_agp_7_3.test.TestIssue.<init>()
|- is referenced in keep rule:
|  app/proguard-rules.pro:2:1
```

## Workaround solution

1. Open project
2. Select "app" project
3. Run `./gradlew :app:assembleRelease`
4. Compilation is success

### TLDR:

Last work AGP stable version is 7.1.3 on current project both build type work well (branch `working_project`)