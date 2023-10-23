package com.bytedance.safesdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import androidx.browser.customtabs.CustomTabsIntent;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

@GlideModule
public class ByteDance_SafeSdk_Universal extends AppGlideModule {

    public static Boolean CCTAL_CheckNet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void CCTAL_openChromeCustomTabUrl(final Context context, String webUrl) {
        try {
            if (CCTAL_isAppInstalled(context, "com.android.chrome")) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                int coolorInt = Color.parseColor("#66bb6a");
                builder.setToolbarColor(coolorInt);
                builder.setStartAnimations(context, R.anim.cidam_slide_in_right, R.anim.cidam_slide_out_left);
                builder.setExitAnimations(context, R.anim.cidam_slide_in_left, R.anim.cidam_slide_out_right);
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.intent.setPackage("com.android.chrome");
                customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                customTabsIntent.launchUrl(context, Uri.parse(webUrl));
            } else {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                int coolorInt = Color.parseColor("#66bb6a");
                builder.setToolbarColor(coolorInt);
                builder.setStartAnimations(context, R.anim.cidam_slide_in_right, R.anim.cidam_slide_out_left);
                builder.setExitAnimations(context, R.anim.cidam_slide_in_left, R.anim.cidam_slide_out_right);
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                customTabsIntent.launchUrl(context, Uri.parse(webUrl));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static boolean CCTAL_isAppInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
    public static String CCTAL_getPlaystoreUrl(String app_packageName) {
        return "https://play.google.com/store/apps/details?id=" + app_packageName;
    }

}
