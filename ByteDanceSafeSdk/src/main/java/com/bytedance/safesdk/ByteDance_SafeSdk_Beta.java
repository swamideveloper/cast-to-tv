package com.bytedance.safesdk;

import static com.bytedance.safesdk.ByteDance_SafeSdk_Manager.CCTAL_mysharedpreferences;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

import java.util.ArrayList;
import java.util.Date;

public class ByteDance_SafeSdk_Beta implements Application.ActivityLifecycleCallbacks, LifecycleObserver {
    private ByteDance_SafeSdk_BeatFlow CCTAL_myApplication;
    private static long CCTAL_loadTime = 0;
    public static AppOpenAd CCTAL_appOpenAd = null;
    private AppOpenAd.AppOpenAdLoadCallback CCTAL_loadCallback;
    public static boolean CCTAL_isShowingAd = false;
    private String CCTAL_AD_UNIT_ID;
    private String CCTAL_AD_UNIT_ID2;
    public static String CCTAL_state_admobAppOpen = "Start";
    public boolean CCTAL_isActivityPausedAfter = false;

    public static int CCTAL_cnt = 0;
    private static ArrayList<String> CCTAL_noAdsActivity = new ArrayList<>();
    CCTAL_SPLASH_ADlistner CCTAL_splash_aDlistner;
    public static boolean CCTAL_isappopen1fail = false;
    private Activity CCTAL_currentActivity;

    public interface CCTAL_SPLASH_ADlistner {
        void CCTAL_onsuccess();

        void CCTAL_onError(String error);
    }

    public ByteDance_SafeSdk_Beta() {
        CCTAL_myApplication = ByteDance_SafeSdk_BeatFlow.getCCTAL_instance();
        CCTAL_myApplication.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);

    }

    private boolean CCTAL_wasLoadTimeLessThanNHoursAgo(long numHours) {
        long dateDifference = (new Date()).getTime() - this.CCTAL_loadTime;
        long numMilliSecondsPerHour = 3600000;
        return (dateDifference < (numMilliSecondsPerHour * numHours));
    }

    public boolean CCTAL_isAdAvailable() {
        boolean isAdAvailable = CCTAL_appOpenAd != null && CCTAL_wasLoadTimeLessThanNHoursAgo(0) && CCTAL_state_admobAppOpen.equals("Loaded");
        if (!isAdAvailable) {
            CCTAL_appOpenAd = null;
            CCTAL_state_admobAppOpen = "Start";

        }
        return isAdAvailable;
    }

    public void CCTAL_showAdIfAvailable(final CCTAL_SPLASH_ADlistner listner) {
        if (CCTAL_isShowingAd) {
            return;
        }
        if (CCTAL_state_admobAppOpen.equals("Loading")) {

            return;
        }
        if (CCTAL_state_admobAppOpen.equals("Loaded") && CCTAL_appOpenAd != null) {
            CCTAL_appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    CCTAL_isShowingAd = false;
                    try {
                        listner.CCTAL_onsuccess();
                    } catch (Exception e) {
                    }
                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    CCTAL_isShowingAd = false;
                    try {
                        listner.CCTAL_onError(adError.getMessage());
                    } catch (Exception e) {
                    }
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    CCTAL_isShowingAd = true;
                    CCTAL_appOpenAd = null;
                    CCTAL_state_admobAppOpen = "Start";
                    CCTAL_isappopen1fail = false;
                    CCTAL_fetchAd();

                }
            });

            CCTAL_appOpenAd.show(CCTAL_currentActivity);
        } else {
            try {
                CCTAL_appOpenAd = null;
                CCTAL_state_admobAppOpen = "Start";
                CCTAL_fetchAd();
            } catch (Exception e) {
            }
        }
    }

    public void CCTAL_fetchAd(final CCTAL_SPLASH_ADlistner listener) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_myApplication)) {
            return;
        }
        if (CCTAL_state_admobAppOpen.equals("Loading")) {
            return;
        }

        if (CCTAL_isAdAvailable()) {

            listener.CCTAL_onsuccess();
        }

        if (CCTAL_state_admobAppOpen.equals("Start") || CCTAL_state_admobAppOpen.equals("Fail")) {
            CCTAL_loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull AppOpenAd ad) {
                    super.onAdLoaded(CCTAL_appOpenAd);
                    CCTAL_isappopen1fail = false;
                    CCTAL_appOpenAd = ad;
                    CCTAL_state_admobAppOpen = "Loaded";
                    CCTAL_loadTime = (new Date()).getTime();
                    listener.CCTAL_onsuccess();
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    CCTAL_isappopen1fail = true;
                    CCTAL_appOpenAd = null;
                    CCTAL_state_admobAppOpen = "Fail";
                    ByteDance_SafeSdk_Beta.CCTAL_isappopen1fail = true;
                    listener.CCTAL_onError(loadAdError.getMessage());
                }
            };
            CCTAL_state_admobAppOpen = "Loading";
            AdRequest request = new AdRequest.Builder().build();
            SharedPreferences CCTAL_mysharedpreferences = CCTAL_myApplication.getSharedPreferences(CCTAL_myApplication.getPackageName(), Context.MODE_PRIVATE);
            CCTAL_AD_UNIT_ID = CCTAL_mysharedpreferences.getString("AppOpenID1", "");
            AppOpenAd.load(CCTAL_myApplication, CCTAL_AD_UNIT_ID, request, AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, CCTAL_loadCallback);
        }

    }

    public void CCTAL_fetchAd() {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_myApplication)) {
            return;
        }

        String CCTAL_adPlatformSequence = CCTAL_mysharedpreferences.getString("app_adPlatformSequenceInterstitial", "");
        if (CCTAL_adPlatformSequence.contains("Admob")) {
            SharedPreferences CCTAL_mysharedpreferences = CCTAL_myApplication.getSharedPreferences(CCTAL_myApplication.getPackageName(), Context.MODE_PRIVATE);
            CCTAL_AD_UNIT_ID2 = CCTAL_mysharedpreferences.getString("AppOpenID2", "");
            final boolean CCTAL_splash_ad = CCTAL_myApplication.getSharedPreferences(CCTAL_myApplication.getPackageName(), Context.MODE_PRIVATE).getBoolean("app_AppOpenAdStatus", false);
            if (CCTAL_state_admobAppOpen.equals("Loading") || CCTAL_state_admobAppOpen.equals("Loaded")) {
                return;
            }

            if (CCTAL_splash_ad && !CCTAL_AD_UNIT_ID2.isEmpty()) {
                if (CCTAL_state_admobAppOpen.equals("Start") || CCTAL_state_admobAppOpen.equals("Fail")) {
                    CCTAL_loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull AppOpenAd ad) {
                            super.onAdLoaded(CCTAL_appOpenAd);
                            CCTAL_appOpenAd = ad;
                            CCTAL_state_admobAppOpen = "Loaded";
                            CCTAL_loadTime = (new Date()).getTime();
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            CCTAL_appOpenAd = null;
                            CCTAL_state_admobAppOpen = "Fail";
                        }
                    };
                    CCTAL_state_admobAppOpen = "Loading";
                    AdRequest request = new AdRequest.Builder().build();
                    AppOpenAd.load(CCTAL_myApplication, CCTAL_AD_UNIT_ID2, request, AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, CCTAL_loadCallback);
                }
            } else {
                CCTAL_appOpenAd = null;
                CCTAL_state_admobAppOpen = "Start";
            }
        }
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        CCTAL_isActivityPausedAfter = false;
    }


    @Override
    public void onActivityStarted(Activity activity) {
        CCTAL_currentActivity = activity;

    }

    @Override
    public void onActivityResumed(Activity activity) {

        CCTAL_currentActivity = activity;
        if (CCTAL_isActivityPausedAfter && CCTAL_cnt == 1 && !CCTAL_isShowingAd ) {
            CCTAL_cnt++;
            CCTAL_isActivityPausedAfter = false;
            CCTAL_showAdIfAvailable(CCTAL_splash_aDlistner);
        }


    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {
        CCTAL_isActivityPausedAfter = false;
        CCTAL_cnt = 1;
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        CCTAL_currentActivity = null;

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onAppBackgrounded() {
        CCTAL_isActivityPausedAfter = true;


    }

    public static void CCTAL_addNoAdActivity(Activity activity) {
        if (!CCTAL_noAdsActivity.contains(activity.getClass().getSimpleName())) {
            CCTAL_noAdsActivity.add(activity.getClass().getSimpleName());
        }
    }
}
