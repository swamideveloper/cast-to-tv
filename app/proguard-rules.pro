-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose
-flattenpackagehierarchy

# Optimization is turned off by default. Dex does not like code run
# through the ProGuard optimize and preverify steps (and performs some
# of these optimizations on its own).
-dontoptimize
-dontpreverify
# Note that if you want to enable optimization, you cannot just
# include optimization flags in your own project configuration file;
# instead you will need to point to the
# "proguard-android-optimize.txt" file instead of this com from your
# project.properties file.


-optimizations   code/simplification/arithmetic,!code/simplification/cast,!field/*,! class/merging/*,!method/inlining/*
-optimizationpasses 5
-allowaccessmodification

-keepattributes *Annotation*
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService

# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
-keepclasseswithmembernames class * {
    native <methods>;
}

-repackageclasses

#-=-=-=-=-==-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- Use This Code to Don't affect any class in this package -=-=-=-==-=-=-=-=-=-=-=

-keep class com.wang.avi.** { *; }
-keep class com.wang.avi.indicators.** { *; }

-keeppackagenames org.jsoup.nodes

-keep class cn.jzvd.** { *; }
-keepclassmembers class cn.jzvd.** { *; }


-keep class org.apache.xerces.** { *; }
-keepclassmembers class org.apache.xerces.** { *; }

-keep class com.androidfung.geoip.** { *; }
-keepclassmembers class com.androidfung.geoips.** { *; }

-keep class io.reactivex.** { *; }
-keepclassmembers class io.reactivex.** { *; }

-keep class rx.** { *; }
-keepclassmembers class rx.** { *; }

-keep class com.connectsdk.** { *; }
-keepclassmembers class com.connectsdk.** { *; }

-keep class at.huber.youtubeExtractor.** { *; }
-keepclassmembers class at.huber.youtubeExtractor.** { *; }



-keepclassmembers class com.nhancv.** { *; }
-keep class com.nhancv.** { *; }

#-keepclassmembers class com.trantran.thirteenth.lchatvdoclss.SocaketCall.** { *; }
#-keep class com.trantran.thirteenth.lchatvdoclss.SocaketCall.** { *; }
#-=-=-=-=-==-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- End Of Code -=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
#
#-keep class com.startapp.** {
#      *;
#}

#-keep class com.truenet.** {
#      *;
#}

#-keepattributes Exceptions, InnerClasses, Signature, Deprecated, SourceFile,
#LineNumberTable, *Annotation*, EnclosingMethod
#-dontwarn android.webkit.JavascriptInterface
#-dontwarn com.startapp.**
#
#-dontwarn org.jetbrains.annotations.**

# keep setters in Views so that animations can still work.
# see http://proguard.sourceforge.net/manual/examples.html#beans
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

# We want to keep methods in Activity that could be used in the XML attribute onClick
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keepclassmembers class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator CREATOR;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}

# The support library contains references to newer platform versions.
# Don't warn about those in case this app is linking against an older
# platform version.  We know about them, and they are safe.
-dontwarn android.support.**

# Understand the @Keep support annotation.
-keep class android.support.annotation.Keep

-keep @android.support.annotation.Keep class * {*;}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <methods>;
}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <fields>;
}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <init>(...);
}

#Proguard rules for using green robot eventbus.
#'http://greenrobot.org/eventbus/'
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}


-dontwarn **


-keep class com.lib.activity.**
-keep class com.lib.fragment.**

#keep native
-keepclasseswithmembernames class * {
    native <methods>;
}

-keep class android.support.design.widget.** { *; }
-keep interface android.support.design.widget.** { *; }
-dontwarn android.support.design.**

-dontwarn org.apache.commons.codec.binary.Base64
-dontwarn org.apache.commons.codec.binary.StringUtils
-dontwarn org.slf4j.impl.StaticLoggerBinder
-dontwarn org.slf4j.impl.StaticMarkerBinder
-dontwarn org.slf4j.impl.StaticMDCBinder



#AppsManager
-keep class com.wang.avi.** { *; }
-keep class com.wang.avi.indicators.** { *; }

-keep class com.onesignal.** { *; }
