-dontobfuscate
-keepattributes SourceFile, LineNumberTable

-repackageclasses wrench_wrapper.relocated
-keep class org.quiltmc.config.api.** { *; }
-keep class org.quiltmc.config.impl.** { *; }
-keep class org.quiltmc.config.implementor_api.** { *; }

-target 17
