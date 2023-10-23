package com.bytedance.safesdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ByteDance_SafeSdk_Manager {

    public static String CCTAL_ADMOB = "Admob";
    public static String CCTAL_MyCustomAds = "MyCustomAds";

    public static int CCTAL_count_banner = -1;
    public static int CCTAL_count_native = -1;
    public static int CCTAL_count_click = -1;
    public static int CCTAL_count_click_for_alt = -1;
    public static int CCTAL_count_click_back = -1;
    public static int CCTAL_count_click_for_alt_back = -1;

    public static String CCTAL_app_privacyPolicyLink = "";
    public static String CCTAL_app_accountLink = "";
    public static String CCTAL_app_accountName = "";
    public static String CCTAL_app_packageName = "";
    public static int CCTAL_app_updateAppDialogStatus = 0;
    public static int CCTAL_app_dialogBeforeAdShow = 0;
    public static int CCTAL_app_redirectOtherAppStatus = 0;
    public static int CCTAL_app_adShowStatus = 0;
    public static int CCTAL_app_mainClickCntSwAd = 0;
    public static int CCTAL_app_innerClickCntSwAd = 0;
    public static String CCTAL_CustomAdsInterstitial = "0";
    public static String CCTAL_appOpenTimerSetting = "7";

    public static String CCTAL_ADMOB_APPID = "";
    public static boolean CCTAL_app_AppOpenAdStatus = false;

    public static String[] CCTAL_ADMOB_B = {"", "", "", "", "", ""};
    public static String[] CCTAL_ADMOB_I = {"", "", "", "", "", ""};
    public static String[] CCTAL_ADMOB_N = {"", "", "", "", "", ""};
    public static String[] CCTAL_ADMOB_AO = {"", "", "", ""};
    public static String CCTAL_Qurekalinkbutton = "0", CCTAL_Qurekalink = "", CCTAL_Qurekaimage = "";
    public static String CCTAL_PreadChampLinkButton = "0", CCTAL_PreadChampLink = "", CCTAL_PreadChampImage = "";
    public static String CCTAL_MGLLinkButtton = "0", CCTAL_MGLLink = "", CCTAL_MGLImage = "";
    public static String CCTAL_QurekaHeader = "0", CCTAL_QurekaHeaderLink = "", CCTAL_HeaderImage = "";
    public static String CCTAL_Headerappbutton = "0", CCTAL_Headerapppackagename = "", CCTAL_Headerapplogo = "";

    public static String CCTAL_Giftboxads = "0";


    public static String creatTimerAppOpenShow = "0";
    public static String CCTAL_thankYouScreen = "0";
    public static String CCTAL_ExtraScreen1 = "0";
    public static String CCTAL_ExtraScreen2 = "0";
    public static String CCTAL_ExtraScreen3 = "0";

    public static String CCTAL_nativeAdBackgroundColor = "";
    public static String CCTAL_nativeAdButtonColor = "";
    public static String CCTAL_nativeAdTextColor = "";
    public static String CCTAL_nativeAdButtonTextColor = "";

    public static String CCTAL_customNativeAdBackgroundColor = "";
    public static String CCTAL_customNativeAdButtonColor = "";
    public static String CCTAL_customNativeAdTextColor = "";
    public static String CCTAL_customNativeAdButtonTextColor = "";

    public static String CCTAL_appSplashAdType = "";
    public static String CCTAL_DialogInterstitial = "0";
    public static String CCTAL_onResumeNativeShow = "0";
    public static String CCTAL_ThirdPartyADDialog = "0";
    public static String CCTAL_preloadNative = "0";
    public static String CCTAL_preloadBanner = "0";
    public static int CCTAL_shimmerEffectTime = 0;


    public static String CCTAL_ratingDialog = "0";
    public static String CCTAL_ratingDialog4StarClose = "0";
    public static String CCTAL_nativeExitDialog = "0";
    public static String CCTAL_emailForRating = "0";
    public static String CCTAL_systemOverlayDialog = "0";

    public static int CCTAL_playVideoInApp = 0;
    public static int CCTAL_liveVideoCallOption = 0;
    public static int CCTAL_videoDownloadOption = 0;

    public static String CCTAL_reserveForAdSpaceNative = "0";
    public static String CCTAL_reserveForAdSpaceBanner = "0";

    public static int CCTAL_myCustom_AdStatus = 0;
    public static int CCTAL_admob_loadAdIdsType = 0;

    public static SharedPreferences CCTAL_mysharedpreferences;
    public static int CCTAL_ad_dialog_time_in_second = 2;

    static Activity CCTAL_activity;
    static ByteDance_SafeSdk_Callback CCTAL_CCTALMyCallback;
    private static ByteDance_SafeSdk_Manager CCTAL_mInstance;
    public static InterstitialAd CCTAL_mInterstitialAd;
    String CCTAL_admob_b;
    public static String CCTAL_admob_n;
    ArrayList<String> CCTAL_banner_sequence = new ArrayList<>();
    ArrayList<String> CCTAL_native_sequence = new ArrayList<>();
    ArrayList<String> CCTAL_interstitial_sequence = new ArrayList<>();
    private Dialog CCTAL_dialog;

    public static List<ByteDance_SafeSdk_Pojo> CCTAL_myAppMarketingList = new ArrayList<>();
    public static int CCTAL_count_custBannerAd = 0;
    public static int CCTAL_count_custNBAd = 0;
    public static int CCTAL_count_custNativeAd = 0;
    public static int CCTAL_count_custIntAd = 0;
    public static int CCTAL_count_custAppOpenAd = 0;

    public static String CCTAL_state_AdmobInter = "Start";
    public static String CCTAL_state_admobNative = "Start";
    public String CCTAL_state_admobBanner = "Start";
    public static String CCTAL_showNativeBannerAd = "0";
    public static NativeAd CCTAL_admobNativeBannerAd_preLoad = null;
    public static String CCTAL_state_admobNativeBanner = "Start";
    public static String CCTAL_ThankYouNative = "0";

    private static long CCTAL_loadTimeInterstitial = 0;
    private static long CCTAL_loadTimeBanner = 0;
    private static long CCTAL_loadTimeNative = 0;
    private static long CCTAL_loadTimeNativeBanner = 0;
    boolean CCTAL_wasNativeBannerLoadTimeLessThanNHoursAgo = true;

    public static NativeAd CCTAL_admobNativeAd_preLoad = null;
    AdView CCTAL_admobBannerAd_preLoad = null;


    public ByteDance_SafeSdk_Manager(Activity CCTAL_activity) {
        ByteDance_SafeSdk_Manager.CCTAL_activity = CCTAL_activity;
        CCTAL_mysharedpreferences = CCTAL_activity.getSharedPreferences(CCTAL_activity.getPackageName(), Context.MODE_PRIVATE);
        CCTAL_CCTAL_getResponseFromPref();
    }

    public static ByteDance_SafeSdk_Manager getInstance(Activity CCTAL_activity) {
        ByteDance_SafeSdk_Manager.CCTAL_activity = CCTAL_activity;
        if (CCTAL_mInstance == null) {
            CCTAL_mInstance = new ByteDance_SafeSdk_Manager(CCTAL_activity);
        }
        return CCTAL_mInstance;
    }


    public void CCTAL_CCTAL_getResponseFromPref() {
        String CCTAL_response1 = CCTAL_mysharedpreferences.getString("response", "");

        SharedPreferences.Editor CCTAL_editor_count = CCTAL_mysharedpreferences.edit();
        CCTAL_editor_count.putInt("count_admob_B", 0);
        CCTAL_editor_count.putInt("count_admob_I", 0);
        CCTAL_editor_count.putInt("count_admob_N", 0);
        CCTAL_editor_count.commit();

        if (!CCTAL_response1.isEmpty()) {
            try {
                JSONObject response = new JSONObject(CCTAL_response1);
                setSPData(response);
            } catch (Exception e) {
            }

        }

    }

    private static void CCTAL_initAd() {

        if (CCTAL_app_adShowStatus == 1) {
            MobileAds.initialize(CCTAL_activity, new OnInitializationCompleteListener() {
                @Override
                public void onInitializationComplete(InitializationStatus initializationStatus) {
                }
            });
            CCTAL_custumsmallbanner = new ArrayList<>();
            CCTAL_fetchDatacustumsmallbanner();
        }
    }

    private static boolean CCTAL_checkUpdate(int CCTAL_cversion) {
        if (CCTAL_mysharedpreferences.getInt("app_updateAppDialogStatus", 0) == 1) {
            String versions = CCTAL_mysharedpreferences.getString("app_versionCode", "");
            String str[] = versions.split(",");
            try {
                if (Arrays.asList(str).contains(CCTAL_cversion + "")) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public List<ByteDance_SafeSdk_Pojo> CCTAL_get_CustomAdData() {
        List<ByteDance_SafeSdk_Pojo> CCTAL_data = new ArrayList<>();
        SharedPreferences CCTAL_preferences = CCTAL_activity.getSharedPreferences("ad_pref", 0);
        try {
            JSONArray CCTAL_array = new JSONArray(CCTAL_preferences.getString("Advertise_List", ""));
            for (int i = 0; i < CCTAL_array.length(); i++) {
                JSONObject object = CCTAL_array.getJSONObject(i);
                ByteDance_SafeSdk_Pojo CCTALCustomAdModel = new ByteDance_SafeSdk_Pojo();
                CCTALCustomAdModel.setCCTAL_ad_id(object.getInt("ad_id"));
                CCTALCustomAdModel.setCCTAL_app_name(object.getString("app_name"));
                CCTALCustomAdModel.setCCTAL_app_packageName(object.getString("app_packageName"));
                CCTALCustomAdModel.setCCTAL_app_logo(object.getString("app_logo"));
                CCTALCustomAdModel.setCCTAL_app_banner(object.getString("app_banner"));
                CCTALCustomAdModel.setCCTAL_app_shortDecription(object.getString("app_shortDecription"));
                CCTALCustomAdModel.setCCTAL_app_rating(object.getString("app_rating"));
                CCTALCustomAdModel.setCCTAL_app_download(object.getString("app_download"));
                CCTALCustomAdModel.setCCTAL_app_AdFormat(object.getString("app_AdFormat"));
                CCTAL_data.add(CCTALCustomAdModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return CCTAL_data;
    }

    private void setSPData(JSONObject CCTAL_response) {
        try {
            JSONObject CCTAL_settingsJsonObject = CCTAL_response.getJSONObject("APP_SETTINGS");
            CCTAL_app_accountLink = CCTAL_setDataString(CCTAL_settingsJsonObject, "app_accountLink");
            CCTAL_app_accountName = CCTAL_setDataString(CCTAL_settingsJsonObject, "app_accountName");
            CCTAL_app_packageName = CCTAL_setDataString(CCTAL_settingsJsonObject, "app_packageName");
            CCTAL_app_privacyPolicyLink = CCTAL_setDataString(CCTAL_settingsJsonObject, "app_privacyPolicyLink");
            CCTAL_app_updateAppDialogStatus = CCTAL_setDataInt(CCTAL_settingsJsonObject, "app_updateAppDialogStatus");
            CCTAL_app_redirectOtherAppStatus = CCTAL_setDataInt(CCTAL_settingsJsonObject, "app_redirectOtherAppStatus");
            CCTAL_app_dialogBeforeAdShow = CCTAL_setDataInt(CCTAL_settingsJsonObject, "app_dialogBeforeAdShow");
            CCTAL_app_adShowStatus = CCTAL_setDataInt(CCTAL_settingsJsonObject, "app_adShowStatus");
            CCTAL_app_mainClickCntSwAd = CCTAL_setDataInt(CCTAL_settingsJsonObject, "app_mainClickCntSwAd");

            if (CCTAL_app_mainClickCntSwAd == 0) {
            } else {
                CCTAL_app_mainClickCntSwAd = CCTAL_app_mainClickCntSwAd + 1;
            }
            CCTAL_app_innerClickCntSwAd = CCTAL_setDataInt(CCTAL_settingsJsonObject, "app_innerClickCntSwAd");
            if (CCTAL_app_innerClickCntSwAd == 0) {
            } else {
                CCTAL_app_innerClickCntSwAd = CCTAL_app_innerClickCntSwAd + 1;
            }
            CCTAL_Qurekalinkbutton = CCTAL_setDataString(CCTAL_settingsJsonObject, "Qurekalinkbutton");
            CCTAL_Qurekalink = CCTAL_setDataString(CCTAL_settingsJsonObject, "Qurekalink");
            CCTAL_Qurekaimage = CCTAL_setDataString(CCTAL_settingsJsonObject, "Qurekaimage");
            CCTAL_PreadChampLinkButton = CCTAL_setDataString(CCTAL_settingsJsonObject, "PreadChampLinkButton");
            CCTAL_PreadChampLink = CCTAL_setDataString(CCTAL_settingsJsonObject, "PreadChampLink");
            CCTAL_PreadChampImage = CCTAL_setDataString(CCTAL_settingsJsonObject, "PreadChampImage");
            CCTAL_MGLLinkButtton = CCTAL_setDataString(CCTAL_settingsJsonObject, "MGLLinkButtton");
            CCTAL_MGLLink = CCTAL_setDataString(CCTAL_settingsJsonObject, "MGLLink");
            CCTAL_MGLImage = CCTAL_setDataString(CCTAL_settingsJsonObject, "MGLImage");

            CCTAL_QurekaHeader = CCTAL_setDataString(CCTAL_settingsJsonObject, "QurekaHeaderButton");
            CCTAL_HeaderImage = CCTAL_setDataString(CCTAL_settingsJsonObject, "QurekaHeaderImage");
            CCTAL_QurekaHeaderLink = CCTAL_setDataString(CCTAL_settingsJsonObject, "QurekaHeaderLink");

            CCTAL_Headerappbutton = CCTAL_setDataString(CCTAL_settingsJsonObject, "Headerappbutton");
            CCTAL_Headerapplogo = CCTAL_setDataString(CCTAL_settingsJsonObject, "headerlogourl");
            CCTAL_Headerapppackagename = CCTAL_setDataString(CCTAL_settingsJsonObject, "headerpackage");

            CCTAL_Giftboxads = CCTAL_setDataString(CCTAL_settingsJsonObject, "giftbox");

            creatTimerAppOpenShow = CCTAL_setDataString(CCTAL_settingsJsonObject, "creatTimerAppOpenShow");
            CCTAL_thankYouScreen = CCTAL_setDataString(CCTAL_settingsJsonObject, "thankYouScreen");
            CCTAL_ExtraScreen1 = CCTAL_setDataString(CCTAL_settingsJsonObject, "ExtraScreen1");
            CCTAL_ExtraScreen2 = CCTAL_setDataString(CCTAL_settingsJsonObject, "ExtraScreen2");
            CCTAL_ExtraScreen3 = CCTAL_setDataString(CCTAL_settingsJsonObject, "ExtraScreen3");


            CCTAL_showNativeBannerAd = CCTAL_setDataString(CCTAL_settingsJsonObject, "showNativeBannerAd");

            CCTAL_ThirdPartyADDialog = CCTAL_setDataString(CCTAL_settingsJsonObject, "ThirdPartyADDialog");
            CCTAL_preloadNative = CCTAL_setDataString(CCTAL_settingsJsonObject, "preloadNative");
            CCTAL_preloadBanner = CCTAL_setDataString(CCTAL_settingsJsonObject, "preloadBanner");
            CCTAL_shimmerEffectTime = Integer.parseInt(CCTAL_setDataString(CCTAL_settingsJsonObject, "shimmerEffectTime"));

            CCTAL_ratingDialog = CCTAL_setDataString(CCTAL_settingsJsonObject, "ratingDialog");
            CCTAL_ratingDialog4StarClose = CCTAL_setDataString(CCTAL_settingsJsonObject, "ratingDialog4StarClose");
            CCTAL_nativeExitDialog = CCTAL_setDataString(CCTAL_settingsJsonObject, "nativeExitDialog");
            CCTAL_emailForRating = CCTAL_setDataString(CCTAL_settingsJsonObject, "emailForRating");

            CCTAL_systemOverlayDialog = CCTAL_setDataString(CCTAL_settingsJsonObject, "systemOverlayDialog");
            CCTAL_playVideoInApp = Integer.parseInt(CCTAL_setDataString(CCTAL_settingsJsonObject, "playVideoInApp"));
            CCTAL_liveVideoCallOption = Integer.parseInt(CCTAL_setDataString(CCTAL_settingsJsonObject, "liveVideoCallOption"));
            CCTAL_videoDownloadOption = Integer.parseInt(CCTAL_setDataString(CCTAL_settingsJsonObject, "videoDownloadOption"));

            CCTAL_reserveForAdSpaceNative = CCTAL_setDataString(CCTAL_settingsJsonObject, "reserveForAdSpaceNative");
            CCTAL_reserveForAdSpaceBanner = CCTAL_setDataString(CCTAL_settingsJsonObject, "reserveForAdSpaceBanner");
            CCTAL_DialogInterstitial = CCTAL_setDataString(CCTAL_settingsJsonObject, "DialogInterstitial");
            CCTAL_appSplashAdType = CCTAL_setDataString(CCTAL_settingsJsonObject, "appSplashAdType");

            CCTAL_nativeAdBackgroundColor = CCTAL_setDataString(CCTAL_settingsJsonObject, "nativeAdBackgroundColor");
            CCTAL_nativeAdButtonColor = CCTAL_setDataString(CCTAL_settingsJsonObject, "nativeAdButtonColor");
            CCTAL_nativeAdTextColor = CCTAL_setDataString(CCTAL_settingsJsonObject, "nativeAdTextColor");
            CCTAL_nativeAdButtonTextColor = CCTAL_setDataString(CCTAL_settingsJsonObject, "nativeAdButtonTextColor");
            CCTAL_onResumeNativeShow = CCTAL_setDataString(CCTAL_settingsJsonObject, "onResumeNativeShow");

            CCTAL_customNativeAdBackgroundColor = CCTAL_setDataString(CCTAL_settingsJsonObject, "customNativeAdBackgroundColor");
            CCTAL_customNativeAdButtonColor = CCTAL_setDataString(CCTAL_settingsJsonObject, "customNativeAdButtonColor");
            CCTAL_customNativeAdTextColor = CCTAL_setDataString(CCTAL_settingsJsonObject, "customNativeAdTextColor");
            CCTAL_customNativeAdButtonTextColor = CCTAL_setDataString(CCTAL_settingsJsonObject, "customNativeAdButtonTextColor");
            CCTAL_CustomAdsInterstitial = CCTAL_setDataString(CCTAL_settingsJsonObject, "CustomAdsInterstitial");
            CCTAL_appOpenTimerSetting = CCTAL_setDataString(CCTAL_settingsJsonObject, "appOpenTimerSetting");

            CCTAL_ThankYouNative = CCTAL_setDataString(CCTAL_settingsJsonObject, "ThankYouNative");


            if (CCTAL_setDataInt(CCTAL_settingsJsonObject, "app_AppOpenAdStatus") == 1) {
                CCTAL_app_AppOpenAdStatus = true;
            } else {
                CCTAL_app_AppOpenAdStatus = false;
            }

            SharedPreferences.Editor CCTAL_editor = CCTAL_mysharedpreferences.edit();
            CCTAL_editor.putString("app_name", CCTAL_setDataString(CCTAL_settingsJsonObject, "app_name"));
            CCTAL_editor.putString("app_logo", CCTAL_setDataString(CCTAL_settingsJsonObject, "app_logo"));
            CCTAL_editor.putString("app_privacyPolicyLink", CCTAL_app_privacyPolicyLink);
            CCTAL_editor.putInt("app_updateAppDialogStatus", CCTAL_app_updateAppDialogStatus);
            CCTAL_editor.putString("app_versionCode", CCTAL_setDataString(CCTAL_settingsJsonObject, "app_versionCode"));
            CCTAL_editor.putInt("app_redirectOtherAppStatus", CCTAL_app_redirectOtherAppStatus);
            CCTAL_editor.putString("app_newPackageName", CCTAL_setDataString(CCTAL_settingsJsonObject, "app_newPackageName"));
            CCTAL_editor.putInt("app_adShowStatus", CCTAL_app_adShowStatus);
            CCTAL_editor.putInt("app_howShowAdInterstitial", CCTAL_setDataInt(CCTAL_settingsJsonObject, "app_howShowAdInterstitial"));
            CCTAL_editor.putString("app_adPlatformSequenceInterstitial", CCTAL_setDataString(CCTAL_settingsJsonObject, "app_adPlatformSequenceInterstitial"));
            CCTAL_editor.putString("app_alernateAdShowInterstitial", CCTAL_setDataString(CCTAL_settingsJsonObject, "app_alernateAdShowInterstitial"));
            CCTAL_editor.putInt("app_howShowAdNative", CCTAL_setDataInt(CCTAL_settingsJsonObject, "app_howShowAdNative"));
            CCTAL_editor.putString("app_adPlatformSequenceNative", CCTAL_setDataString(CCTAL_settingsJsonObject, "app_adPlatformSequenceNative"));
            CCTAL_editor.putString("app_alernateAdShowNative", CCTAL_setDataString(CCTAL_settingsJsonObject, "app_alernateAdShowNative"));
            CCTAL_editor.putInt("app_howShowAdBanner", CCTAL_setDataInt(CCTAL_settingsJsonObject, "app_howShowAdBanner"));
            CCTAL_editor.putString("app_adPlatformSequenceBanner", CCTAL_setDataString(CCTAL_settingsJsonObject, "app_adPlatformSequenceBanner"));
            CCTAL_editor.putString("app_alernateAdShowBanner", CCTAL_setDataString(CCTAL_settingsJsonObject, "app_alernateAdShowBanner"));
            CCTAL_editor.putInt("appNativePreLoad", CCTAL_settingsJsonObject.getInt("appNativePreLoad"));
            CCTAL_editor.putInt("appBannerPreLoad", CCTAL_settingsJsonObject.getInt("appBannerPreLoad"));
            CCTAL_editor.putString("appSplashAdType", CCTAL_settingsJsonObject.getString("appSplashAdType"));
            CCTAL_editor.putInt("app_mainClickCntSwAd", CCTAL_app_mainClickCntSwAd);
            CCTAL_editor.putInt("app_innerClickCntSwAd", CCTAL_app_innerClickCntSwAd);
            CCTAL_editor.putInt("app_DynamicMainClickCntSwAd", CCTAL_app_mainClickCntSwAd);
            CCTAL_editor.putBoolean("app_AppOpenAdStatus", CCTAL_app_AppOpenAdStatus);
            CCTAL_editor.commit();

            JSONObject CCTAL_AdmobJsonObject = CCTAL_response.getJSONObject("PLACEMENT").getJSONObject("Admob");
            CCTAL_admob_loadAdIdsType = CCTAL_setDataInt(CCTAL_AdmobJsonObject, "ad_loadAdIdsType");
            CCTAL_ADMOB_APPID = CCTAL_setDataString(CCTAL_AdmobJsonObject, "AppID");
            CCTAL_ADMOB_B[1] = CCTAL_setDataString(CCTAL_AdmobJsonObject, "Banner1");
            CCTAL_ADMOB_B[2] = CCTAL_setDataString(CCTAL_AdmobJsonObject, "Banner2");
            CCTAL_ADMOB_I[1] = CCTAL_setDataString(CCTAL_AdmobJsonObject, "Interstitial1");
            CCTAL_ADMOB_I[2] = CCTAL_setDataString(CCTAL_AdmobJsonObject, "Interstitial2");
            CCTAL_ADMOB_I[3] = CCTAL_setDataString(CCTAL_AdmobJsonObject, "Interstitial3");
            CCTAL_ADMOB_I[4] = CCTAL_setDataString(CCTAL_AdmobJsonObject, "Interstitial4");
            CCTAL_ADMOB_I[5] = CCTAL_setDataString(CCTAL_AdmobJsonObject, "Interstitial5");
            CCTAL_ADMOB_N[1] = CCTAL_setDataString(CCTAL_AdmobJsonObject, "Native1");
            CCTAL_ADMOB_N[2] = CCTAL_setDataString(CCTAL_AdmobJsonObject, "Native2");
            CCTAL_ADMOB_N[3] = CCTAL_setDataString(CCTAL_AdmobJsonObject, "Native3");
            CCTAL_ADMOB_N[4] = CCTAL_setDataString(CCTAL_AdmobJsonObject, "Native4");
            CCTAL_ADMOB_N[5] = CCTAL_setDataString(CCTAL_AdmobJsonObject, "Native5");
            CCTAL_ADMOB_AO[1] = CCTAL_setDataString(CCTAL_AdmobJsonObject, "AppOpen1");
            CCTAL_ADMOB_AO[2] = CCTAL_setDataString(CCTAL_AdmobJsonObject, "AppOpen2");

            SharedPreferences.Editor CCTAL_editor1 = CCTAL_mysharedpreferences.edit();
            CCTAL_editor1.putString("AppOpenID1", CCTAL_ADMOB_AO[1]);
            CCTAL_editor1.putString("AppOpenID2", CCTAL_ADMOB_AO[2]);
            CCTAL_editor1.commit();


            JSONObject CCTAL_MyAdJsonObject = CCTAL_response.getJSONObject("PLACEMENT").getJSONObject("MyCustomAds");
            CCTAL_myCustom_AdStatus = CCTAL_setDataInt(CCTAL_MyAdJsonObject, "ad_showAdStatus");

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("--errror", "" + e.getMessage());
        }
    }

    public ByteDance_SafeSdk_Pojo CCTAL_getMyCustomAd(String CCTAL_adFormat) {
        if (CCTAL_app_adShowStatus == 1) {

            if (CCTAL_myAppMarketingList.size() == 0) {
                CCTAL_myAppMarketingList = CCTAL_get_CustomAdData();
            }

            List<ByteDance_SafeSdk_Pojo> CCTAL_adFormatWiseAd = new ArrayList<>();
            if (CCTAL_myAppMarketingList.size() != 0) {
                for (int i = 0; i < CCTAL_myAppMarketingList.size(); i++) {
                    if (!CCTAL_myAppMarketingList.get(i).getCCTAL_app_AdFormat().isEmpty()) {
                        String[] adFormat_list = CCTAL_myAppMarketingList.get(i).getCCTAL_app_AdFormat().split(",");
                        if (Arrays.asList(adFormat_list).contains(CCTAL_adFormat)) {
                            CCTAL_adFormatWiseAd.add(CCTAL_myAppMarketingList.get(i));
                        }
                    }
                }
            }

            int CCTAL_count_myAd = 0;
            switch (CCTAL_adFormat) {
                case "Banner":
                    CCTAL_count_myAd = CCTAL_count_custBannerAd;
                    break;
                case "NativeBanner":
                    CCTAL_count_myAd = CCTAL_count_custNBAd;
                    break;
                case "Native":
                    CCTAL_count_myAd = CCTAL_count_custNativeAd;
                    break;
                case "Interstitial":
                    CCTAL_count_myAd = CCTAL_count_custIntAd;
                    break;
                case "AppOpen":
                    CCTAL_count_myAd = CCTAL_count_custAppOpenAd;
                    break;
            }

            ByteDance_SafeSdk_Pojo CCTALCustomAdModel = null;
            if (CCTAL_adFormatWiseAd.size() != 0) {
                for (int j = 0; j <= CCTAL_adFormatWiseAd.size(); j++) {
                    if (CCTAL_count_myAd % CCTAL_adFormatWiseAd.size() == j) {
                        CCTALCustomAdModel = CCTAL_adFormatWiseAd.get(j);
                    }
                }
            }

            return CCTALCustomAdModel;
        }
        return null;
    }

    public boolean CCTAL_isAppInstalled(Activity CCTAL_context, String CCTAL_packageName) {
        try {
            CCTAL_context.getPackageManager().getApplicationInfo(CCTAL_packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }


    public void CCTAL_CCTAL_getResponseFromPref(ByteDance_SafeSdk_List CCTAL_listner, int CCTAL_cversion) {
        String CCTAL_response1 = CCTAL_mysharedpreferences.getString("response", "");

        SharedPreferences.Editor editor_count = CCTAL_mysharedpreferences.edit();
        editor_count.putInt("count_admob_B", 0);
        editor_count.putInt("count_admob_I", 0);
        editor_count.putInt("count_admob_N", 0);
        editor_count.commit();

        if (!CCTAL_response1.isEmpty()) {
            try {
                JSONObject CCTAL_response = new JSONObject(CCTAL_response1);
                setSPData(CCTAL_response);
                try {
                    CCTAL_response.getJSONObject("EXTRA_DATA");
                    CCTAL_listner.CCTAL_onGetExtradata(CCTAL_response.getJSONObject("EXTRA_DATA"));


                } catch (Exception e) {
                }

            } catch (Exception e) {
            }

            if (CCTAL_app_redirectOtherAppStatus == 1) {
                String redirectNewPackage = CCTAL_mysharedpreferences.getString("app_newPackageName", "");
                CCTAL_listner.CCTAL_onUpdate("https://play.google.com/store/apps/details?id=" + redirectNewPackage);

            } else if (CCTAL_app_updateAppDialogStatus == 1 && CCTAL_checkUpdate(CCTAL_cversion)) {
                CCTAL_listner.CCTAL_onUpdate("https://play.google.com/store/apps/details?id=" + CCTAL_activity.getPackageName());
            } else {
                CCTAL_listner.CCTAL_onSuccess();
                CCTAL_initAd();

            }
        }
    }

    private String CCTAL_setDataString(JSONObject CCTAL_jsonObject, String CCTAL_fieldName) {
        try {
            return CCTAL_jsonObject.getString(CCTAL_fieldName);
        } catch (Exception e) {
            return "";
        }
    }

    private int CCTAL_setDataInt(JSONObject CCTAL_jsonObject, String CCTAL_fieldName) {
        try {
            return CCTAL_jsonObject.getInt(CCTAL_fieldName);
        } catch (Exception e) {
            return 0;
        }
    }

    public void CCTAL_showInterstitialAd(int CCTAL_ic_launcher, Context CCTAL_context, ByteDance_SafeSdk_Callback CCTALMyCallback) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            if (CCTAL_CCTALMyCallback != null) {
                CCTAL_CCTALMyCallback.CCTAL_callbackCall();
                CCTAL_CCTALMyCallback = null;
            }
        }
        CCTAL_turnInterstitialAd(CCTAL_ic_launcher, CCTAL_context, CCTALMyCallback, 0, "");
    }

    public void CCTAL_showInterstitialAd(int CCTAL_ic_launcher, Context CCTAL_context, ByteDance_SafeSdk_Callback CCTAL_CCTALMyCallback, String CCTAL_specific_platform, int CCTAL_how_many_clicks) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            if (CCTAL_CCTALMyCallback != null) {
                CCTAL_CCTALMyCallback.CCTAL_callbackCall();
                CCTAL_CCTALMyCallback = null;
            }
            return;
        }
        CCTAL_turnInterstitialAd(CCTAL_ic_launcher, CCTAL_context, CCTAL_CCTALMyCallback, CCTAL_how_many_clicks, CCTAL_specific_platform);
    }

    public void CCTAL_turnInterstitialAd(int CCTAL_ic_launcher, Context CCTAL_context, ByteDance_SafeSdk_Callback CCTAL_CCTALMyCallback2, int CCTAL_how_many_clicks, String CCTAL_specific_platform) {

        this.CCTAL_CCTALMyCallback = CCTAL_CCTALMyCallback2;

        CCTAL_count_click++;
        if (CCTAL_app_adShowStatus == 0) {
            if (CCTAL_CCTALMyCallback != null) {
                CCTAL_CCTALMyCallback.CCTAL_callbackCall();
                CCTAL_CCTALMyCallback = null;
            }
            return;
        }
        if (CCTAL_how_many_clicks != 0) {
            if (CCTAL_count_click % CCTAL_how_many_clicks != 0) {
                if (CCTAL_CustomAdsInterstitial.equals("1")) {
                    ByteDance_SafeSdk_Pojo CCTALCustomAdModel = ByteDance_SafeSdk_Manager.getInstance(CCTAL_activity).CCTAL_getMyCustomAd("Interstitial");
                    if (CCTALCustomAdModel != null) {
                        try {
                            ByteDance_SafeSdk_My.CCTAL_newIntent(CCTAL_activity, CCTAL_CCTALMyCallback, CCTALCustomAdModel);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (CCTAL_CCTALMyCallback != null) {
                            CCTAL_CCTALMyCallback.CCTAL_callbackCall();
                            CCTAL_CCTALMyCallback = null;
                        }
                    }
                } else {
                    if (CCTAL_CCTALMyCallback != null) {
                        CCTAL_CCTALMyCallback.CCTAL_callbackCall();
                        CCTAL_CCTALMyCallback = null;
                    }
                }
                return;
            }
        }

        CCTAL_count_click_for_alt++;

        int CCTAL_app_howShowAd = CCTAL_mysharedpreferences.getInt("app_howShowAdInterstitial", 0);
        String CCTAL_adPlatformSequence = CCTAL_mysharedpreferences.getString("app_adPlatformSequenceInterstitial", "");
        String CCTAL_alernateAdShow = CCTAL_mysharedpreferences.getString("app_alernateAdShowInterstitial", "");

        if (!CCTAL_specific_platform.isEmpty()) {
            CCTAL_app_howShowAd = 0;
            CCTAL_adPlatformSequence = CCTAL_specific_platform;
        }

        CCTAL_interstitial_sequence = new ArrayList<String>();
        if (CCTAL_app_howShowAd == 0 && !CCTAL_adPlatformSequence.isEmpty()) {
            String adSequence[] = CCTAL_adPlatformSequence.split(",");

            for (int i = 0; i < adSequence.length; i++) {
                CCTAL_interstitial_sequence.add(adSequence[i]);
            }

        } else if (CCTAL_app_howShowAd == 1 && !CCTAL_alernateAdShow.isEmpty()) {
            String alernateAd[] = CCTAL_alernateAdShow.split(",");

            int index = 0;
            for (int j = 0; j <= 10; j++) {
                if (CCTAL_count_click_for_alt % alernateAd.length == j) {
                    index = j;
                    CCTAL_interstitial_sequence.add(alernateAd[index]);
                }
            }

            String adSequence[] = CCTAL_adPlatformSequence.split(",");
            for (int j = 0; j < adSequence.length; j++) {
                if (CCTAL_interstitial_sequence.size() != 0) {
                    if (!CCTAL_interstitial_sequence.get(0).equals(adSequence[j])) {
                        CCTAL_interstitial_sequence.add(adSequence[j]);
                    }
                }
            }
        } else {
            if (CCTAL_CCTALMyCallback != null) {
                CCTAL_CCTALMyCallback.CCTAL_callbackCall();
                CCTAL_CCTALMyCallback = null;
            }
        }
        if (CCTAL_interstitial_sequence.size() != 0) {
            CCTAL_displayInterstitialAd(CCTAL_ic_launcher, CCTAL_interstitial_sequence.get(0), CCTAL_context);
        }

    }

    public void CCTAL_showInterstitialAdBack(int CCTAL_ic_launcher, Context CCTAL_context, ByteDance_SafeSdk_Callback CCTALMyCallback, String CCTAL_specific_platform, int CCTAL_how_many_clicks) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            if (CCTALMyCallback != null) {
                CCTALMyCallback.CCTAL_callbackCall();
                CCTALMyCallback = null;
            }
            return;
        }
        if (!CCTAL_ADMOB_I[2].equalsIgnoreCase("na") && !CCTAL_ADMOB_I[2].isEmpty()) {
            CCTAL_turnInterstitialAdBack(CCTAL_ic_launcher, CCTAL_context, CCTALMyCallback, CCTAL_how_many_clicks, CCTAL_specific_platform);
        } else {
            if (CCTALMyCallback != null) {
                CCTALMyCallback.CCTAL_callbackCall();
                CCTALMyCallback = null;
            }
        }
    }

    public void CCTAL_turnInterstitialAdBack(int CCTAL_ic_launcher, Context CCTAL_context, ByteDance_SafeSdk_Callback CCTALMyCallback2, int CCTAL_how_many_clicks, String CCTAL_specific_platform) {
        this.CCTAL_CCTALMyCallback = CCTALMyCallback2;
        CCTAL_count_click_back++;

        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            if (CCTAL_CCTALMyCallback != null) {
                CCTAL_CCTALMyCallback.CCTAL_callbackCall();
                CCTAL_CCTALMyCallback = null;
            }
            return;
        }
        if (CCTAL_how_many_clicks != 0) {
            if (CCTAL_count_click_back % CCTAL_how_many_clicks != 0) {
                if (CCTAL_CustomAdsInterstitial.equals("1")) {
                    ByteDance_SafeSdk_Pojo CCTALCustomAdModel = ByteDance_SafeSdk_Manager.getInstance(CCTAL_activity).CCTAL_getMyCustomAd("Interstitial");
                    if (CCTALCustomAdModel != null) {
                        try {
                            ByteDance_SafeSdk_My.CCTAL_newIntent(CCTAL_activity, CCTAL_CCTALMyCallback, CCTALCustomAdModel);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (CCTAL_CCTALMyCallback != null) {
                            CCTAL_CCTALMyCallback.CCTAL_callbackCall();
                            CCTAL_CCTALMyCallback = null;
                        }
                    }
                } else {
                    if (CCTAL_CCTALMyCallback != null) {
                        CCTAL_CCTALMyCallback.CCTAL_callbackCall();
                        CCTAL_CCTALMyCallback = null;
                    }
                }
                return;
            }
        }
        CCTAL_count_click_for_alt_back++;

        int CCTAL_app_howShowAd = CCTAL_mysharedpreferences.getInt("app_howShowAdInterstitial", 0);
        String CCTAL_adPlatformSequence = CCTAL_mysharedpreferences.getString("app_adPlatformSequenceInterstitial", "");
        String CCTAL_alernateAdShow = CCTAL_mysharedpreferences.getString("app_alernateAdShowInterstitial", "");
        if (!CCTAL_specific_platform.isEmpty()) {
            CCTAL_app_howShowAd = 0;
            CCTAL_adPlatformSequence = CCTAL_specific_platform;
        }

        CCTAL_interstitial_sequence = new ArrayList<String>();
        if (CCTAL_app_howShowAd == 0 && !CCTAL_adPlatformSequence.isEmpty()) {
            String adSequence[] = CCTAL_adPlatformSequence.split(",");

            for (int i = 0; i < adSequence.length; i++) {
                CCTAL_interstitial_sequence.add(adSequence[i]);
            }

        } else if (CCTAL_app_howShowAd == 1 && !CCTAL_alernateAdShow.isEmpty()) {
            String alernateAd[] = CCTAL_alernateAdShow.split(",");
            int index = 0;
            for (int j = 0; j <= 10; j++) {
                if (CCTAL_count_click_for_alt_back % alernateAd.length == j) {
                    index = j;
                    CCTAL_interstitial_sequence.add(alernateAd[index]);
                }
            }

            String adSequence[] = CCTAL_adPlatformSequence.split(",");
            for (int j = 0; j < adSequence.length; j++) {
                if (CCTAL_interstitial_sequence.size() != 0) {
                    if (!CCTAL_interstitial_sequence.get(0).equals(adSequence[j])) {
                        CCTAL_interstitial_sequence.add(adSequence[j]);
                    }
                }

            }
        } else {
            if (CCTAL_CCTALMyCallback != null) {
                CCTAL_CCTALMyCallback.CCTAL_callbackCall();
                CCTAL_CCTALMyCallback = null;
            }
        }

        if (CCTAL_interstitial_sequence.size() != 0) {
            CCTAL_displayInterstitialAd(CCTAL_ic_launcher, CCTAL_interstitial_sequence.get(0), CCTAL_context);
        }

    }

    public void CCTAL_loadInterstitialAd(Activity CCTAL_activity, String CCTAL_google_i, String CCTAL_facebook_i) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }

        if (CCTAL_app_adShowStatus == 1 && !CCTAL_google_i.isEmpty() && !CCTAL_google_i.equalsIgnoreCase("na")) {
            CCTAL_loadAdmobInterstitial(CCTAL_activity, CCTAL_google_i);
        }
    }

    private boolean CCTAL_wasInterstitialLoadTimeLessThanNHoursAgo() {
        long CCTAL_dateDifference = (new Date()).getTime() - CCTAL_loadTimeInterstitial;
        long CCTAL_numMilliSecondsPerHour = 3600000;
        return (CCTAL_dateDifference < (CCTAL_numMilliSecondsPerHour * (long) 4));
    }

    public boolean CCTAL_isInterstitialAdAvailable() {
        boolean CCTAL_isAdAvailable = CCTAL_mInterstitialAd != null && CCTAL_wasInterstitialLoadTimeLessThanNHoursAgo() && CCTAL_state_AdmobInter.equals("Loaded");
        if (!CCTAL_isAdAvailable) {
            CCTAL_mInterstitialAd = null;
            CCTAL_state_AdmobInter = "Start";
        }
        return CCTAL_isAdAvailable;
    }

    public void CCTAL_loadAdmobInterstitial(final Activity CCTAL_activity, String adID) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }

        if (CCTAL_state_AdmobInter.equals("Loading") || CCTAL_isInterstitialAdAvailable()) {
            return;
        }

        if (CCTAL_state_AdmobInter.equals("Start") || CCTAL_state_AdmobInter.equals("Fail")) {

            AdRequest CCTAL_adRequest = new AdRequest.Builder().build();
            CCTAL_state_AdmobInter = "Loading";
            InterstitialAd.load(CCTAL_activity, adID, CCTAL_adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    CCTAL_state_AdmobInter = "Loaded";
                    CCTAL_mInterstitialAd = interstitialAd;
                    CCTAL_loadTimeInterstitial = (new Date()).getTime();
                    CCTAL_mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            CCTAL_interstitialCallBack();
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                            CCTAL_state_AdmobInter = "Fail";
                            CCTAL_interstitialCallBack();
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            CCTAL_mInterstitialAd = null;
                            CCTAL_state_AdmobInter = "Start";
                            CCTAL_loadAdmobInterstitial(CCTAL_activity, CCTAL_ADMOB_I[1]);
                        }
                    });
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    CCTAL_mInterstitialAd = null;
                    CCTAL_state_AdmobInter = "Fail";
                    CCTAL_loadTimeInterstitial = (new Date()).getTime();
                }
            });
        }
    }

    private void CCTAL_displayInterstitialAd(int CCTAL_ic_launcher, String CCTAL_platform, final Context CCTAL_context) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            CCTAL_nextInterstitialPlatform(CCTAL_ic_launcher, CCTAL_activity);
            return;
        }

        CCTAL_dialog = new Dialog(CCTAL_context);
        View CCTAL_view = LayoutInflater.from(CCTAL_context).inflate(R.layout.bytedance_safesdk_progress, null);
        CCTAL_dialog.setContentView(CCTAL_view);
        CCTAL_dialog.setCancelable(false);
        Window CCTAL_window = CCTAL_dialog.getWindow();
        CCTAL_window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        CCTAL_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        if (CCTAL_platform.equals(CCTAL_ADMOB) && CCTAL_app_adShowStatus == 1) {
            if (CCTAL_mInterstitialAd != null) {
                if (CCTAL_app_dialogBeforeAdShow == 1) {
                    CCTAL_dialog.show();
                    new CountDownTimer(CCTAL_ad_dialog_time_in_second * 1000, 10) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }

                        @Override
                        public void onFinish() {
                            CCTAL_dialog.dismiss();
                            CCTAL_mInterstitialAd.show((Activity) CCTAL_context);
                        }
                    }.start();
                } else {
                    CCTAL_mInterstitialAd.show((Activity) CCTAL_context);
                }
            } else {
                CCTAL_loadAdmobInterstitial(CCTAL_activity, CCTAL_ADMOB_I[1]);
                CCTAL_nextInterstitialPlatform(CCTAL_ic_launcher, CCTAL_context);

            }
        } else if (CCTAL_platform.equals(CCTAL_MyCustomAds) && CCTAL_myCustom_AdStatus == 1 && CCTAL_app_adShowStatus == 1) {
            if (!CCTAL_ADMOB_I[1].equalsIgnoreCase("na")) {
                ByteDance_SafeSdk_Pojo CCTALCustomAdModel = ByteDance_SafeSdk_Manager.getInstance(CCTAL_activity).CCTAL_getMyCustomAd("Interstitial");
                if (CCTALCustomAdModel != null) {
                    try {
                        ByteDance_SafeSdk_My.CCTAL_newIntent(CCTAL_activity, CCTAL_CCTALMyCallback, CCTALCustomAdModel);
                    } catch (Exception e) {
                        e.printStackTrace();
                        CCTAL_nextInterstitialPlatform(CCTAL_ic_launcher, CCTAL_context);
                    }
                } else {
                    CCTAL_nextInterstitialPlatform(CCTAL_ic_launcher, CCTAL_context);
                }
            } else {
                CCTAL_interstitialCallBack();
            }

        } else {
            CCTAL_nextInterstitialPlatform(CCTAL_ic_launcher, CCTAL_context);

        }
    }

    public void CCTAL_ShowInterAppMange3(int CCTAL_ic_launcher, Context CCTAL_context, ByteDance_SafeSdk_Callback CCTALMyCallback) {
        if (!CCTAL_ADMOB_I[3].equalsIgnoreCase("na") && !CCTAL_ADMOB_I[3].isEmpty() && CCTAL_ADMOB_I[3] != null && CCTAL_app_adShowStatus == 1) {
            CCTAL_showInterstitialAd(CCTAL_ic_launcher, CCTAL_context, CCTALMyCallback);
        } else {
            if (CCTALMyCallback != null) {
                CCTALMyCallback.CCTAL_callbackCall();
                CCTALMyCallback = null;
            }
        }
    }

    public void CCTAL_ShowInterAppMange4(int CCTAL_ic_launcher, Context CCTAL_context, ByteDance_SafeSdk_Callback CCTALMyCallback) {
        if (!CCTAL_ADMOB_I[4].equalsIgnoreCase("na") && !CCTAL_ADMOB_I[4].isEmpty() && CCTAL_ADMOB_I[4] != null && CCTAL_app_adShowStatus == 1) {
            CCTAL_showInterstitialAd(CCTAL_ic_launcher, CCTAL_context, CCTALMyCallback);
        } else {
            if (CCTALMyCallback != null) {
                CCTALMyCallback.CCTAL_callbackCall();
                CCTALMyCallback = null;
            }
        }
    }

    public void CCTAL_ShowInterAppMange5(int CCTAL_ic_launcher, Context CCTAL_context, ByteDance_SafeSdk_Callback CCTALMyCallback) {
        if (!CCTAL_ADMOB_I[5].equalsIgnoreCase("na") && !CCTAL_ADMOB_I[5].isEmpty() && CCTAL_ADMOB_I[5] != null && CCTAL_app_adShowStatus == 1) {
            CCTAL_showInterstitialAd(CCTAL_ic_launcher, CCTAL_context, CCTALMyCallback);
        } else {
            if (CCTALMyCallback != null) {
                CCTALMyCallback.CCTAL_callbackCall();
                CCTALMyCallback = null;
            }
        }
    }

    private void CCTAL_nextInterstitialPlatform(int CCTAL_ic_launcher, Context CCTAL_context) {
        if (CCTAL_interstitial_sequence.size() != 0) {
            CCTAL_interstitial_sequence.remove(0);
            if (CCTAL_interstitial_sequence.size() != 0) {
                CCTAL_displayInterstitialAd(CCTAL_ic_launcher, CCTAL_interstitial_sequence.get(0), CCTAL_context);
            } else {
                CCTAL_interstitialCallBack();
            }
        } else {
            CCTAL_interstitialCallBack();

        }
    }

    public void CCTAL_interstitialCallBack() {
        if (CCTAL_CCTALMyCallback != null) {
            CCTAL_CCTALMyCallback.CCTAL_callbackCall();
            CCTAL_CCTALMyCallback = null;
        }
    }

    public void CCTAL_showCustomAppOpenAd(Context CCTAL_context, ByteDance_SafeSdk_Callback CCTAL_CCTALMyCallback) {
        Log.e("@@decode", "show custom appopen----");
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        CCTAL_turnCustomAppOpenAd(CCTAL_context, CCTAL_CCTALMyCallback);
    }

    public void CCTAL_turnCustomAppOpenAd(Context CCTAL_context, ByteDance_SafeSdk_Callback CCTAL_CCTALMyCallback2) {

        Log.e("@@decode", "custom appopen----");

        this.CCTAL_CCTALMyCallback = CCTAL_CCTALMyCallback2;

        if (CCTAL_app_adShowStatus == 0) {
            Log.e("@@decode", "zero---");
            if (CCTAL_CCTALMyCallback != null) {
                CCTAL_CCTALMyCallback.CCTAL_callbackCall();
                CCTAL_CCTALMyCallback = null;
            }
            return;
        }

        CCTAL_mysharedpreferences = CCTAL_activity.getSharedPreferences(CCTAL_activity.getPackageName(), Context.MODE_PRIVATE);
        boolean CCTAL_app_AppOpenAdStatus = CCTAL_mysharedpreferences.getBoolean("app_AppOpenAdStatus", false);

        Log.e("@@decode", "status--- " + CCTAL_app_AppOpenAdStatus);
        if (!CCTAL_app_AppOpenAdStatus) {
            Log.e("@@decode", "if---0 " + CCTAL_app_AppOpenAdStatus);
            if (CCTAL_CCTALMyCallback != null) {
                CCTAL_CCTALMyCallback.CCTAL_callbackCall();
                CCTAL_CCTALMyCallback = null;
            }
            return;
        }
        if (CCTAL_ADMOB_AO[1].equalsIgnoreCase("na")) {
            Log.e("@@decode", "if---1 " + CCTAL_app_AppOpenAdStatus);
            if (CCTAL_CCTALMyCallback != null) {
                CCTAL_CCTALMyCallback.CCTAL_callbackCall();
                CCTAL_CCTALMyCallback = null;
            }
        } else {
            Log.e("@@decode", "custom appopen----else");
            ByteDance_SafeSdk_Pojo CCTALCustomAdModel = ByteDance_SafeSdk_Manager.getInstance(CCTAL_activity).CCTAL_getMyCustomAd("AppOpen");
            if (CCTALCustomAdModel != null) {
                Log.e("@@decode", "custom appopen---- !null");
                ByteDance_SafeSdk_BetaAct.CCTAL_newIntent(CCTAL_activity, CCTAL_CCTALMyCallback, CCTALCustomAdModel);
            } else {
                Log.e("@@decode", "custom appopen---- =null");
                if (CCTAL_CCTALMyCallback != null) {
                    CCTAL_CCTALMyCallback.CCTAL_callbackCall();
                    CCTAL_CCTALMyCallback = null;
                }
            }

        }
    }

    public void CCTAL_showBanner(ViewGroup CCTAL_banner_container, String CCTAL_admob_b, String CCTAL_facebook_b) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        CCTAL_turnShowBanner(CCTAL_banner_container, CCTAL_admob_b);
    }

    public void CCTAL_turnShowBanner(ViewGroup CCTAL_banner_container, String CCTAL_admob_b) {
        try {
            this.CCTAL_admob_b = CCTAL_admob_b;
            if (CCTAL_app_adShowStatus == 0) {
                return;
            }
            CCTAL_count_banner++;

            int CCTAL_app_howShowAd = CCTAL_mysharedpreferences.getInt("app_howShowAdBanner", 0);
            String CCTAL_adPlatformSequence = CCTAL_mysharedpreferences.getString("app_adPlatformSequenceBanner", "");
            String CCTAL_alernateAdShow = CCTAL_mysharedpreferences.getString("app_alernateAdShowBanner", "");

            CCTAL_banner_sequence = new ArrayList<String>();
            if (CCTAL_app_howShowAd == 0 && !CCTAL_adPlatformSequence.isEmpty()) {
                String adSequence[] = CCTAL_adPlatformSequence.split(",");
                for (int i = 0; i < adSequence.length; i++) {
                    CCTAL_banner_sequence.add(adSequence[i]);
                }

            } else if (CCTAL_app_howShowAd == 1 && !CCTAL_alernateAdShow.isEmpty()) {
                String alernateAd[] = CCTAL_alernateAdShow.split(",");

                int index = 0;
                for (int j = 0; j <= 10; j++) {
                    if (CCTAL_count_banner % alernateAd.length == j) {
                        index = j;
                        CCTAL_banner_sequence.add(alernateAd[index]);
                    }
                }

                String adSequence[] = CCTAL_adPlatformSequence.split(",");
                for (int j = 0; j < adSequence.length; j++) {
                    if (CCTAL_banner_sequence.size() != 0) {
                        if (!CCTAL_banner_sequence.get(0).equals(adSequence[j])) {
                            CCTAL_banner_sequence.add(adSequence[j]);
                        }
                    }
                }
            }

            if (CCTAL_banner_sequence.size() != 0) {
                CCTAL_displayBanner(CCTAL_banner_sequence.get(0), CCTAL_banner_container);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void CCTAL_bannerManageSpaceBox(View view, ViewGroup nativContainer) {
        if (CCTAL_reserveForAdSpaceBanner.equals("1") && CCTAL_app_adShowStatus == 1) {
            if (((LinearLayout) view.findViewById(R.id.ll_space) != null)) {
                ((LinearLayout) view.findViewById(R.id.ll_space)).setVisibility(View.VISIBLE);
                ((CardView) view.findViewById(R.id.ll_space_card)).setCardBackgroundColor(Color.parseColor(CCTAL_nativeAdBackgroundColor));
            }
            nativContainer.removeAllViews();
            nativContainer.addView(view);
        } else {
            if (CCTAL_app_adShowStatus == 0)
                nativContainer.setVisibility(View.GONE);
            if (((LinearLayout) view.findViewById(R.id.ll_space) != null))
                ((LinearLayout) view.findViewById(R.id.ll_space)).setVisibility(View.GONE);
        }
    }

    public void CCTAL_displayBanner(String CCTAL_platform, ViewGroup CCTAL_banner_container) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        try {
            if (CCTAL_platform.equals(CCTAL_ADMOB) && CCTAL_app_adShowStatus == 1) {
                if (CCTAL_showNativeBannerAd.equals("1")) {
                    CCTAL_showAdmobNativeBanner(CCTAL_banner_container);
                } else {
                    CCTAL_showAdmobBanner(CCTAL_banner_container);
                }
            } else if (CCTAL_platform.equals(CCTAL_MyCustomAds) && CCTAL_myCustom_AdStatus == 1 && CCTAL_app_adShowStatus == 1) {
                CCTAL_showMyCustomBanner(CCTAL_banner_container);
            } else {
                CCTAL_nextBannerPlatform(CCTAL_banner_container);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean CCTAL_wasBannerLoadTimeLessThanNHoursAgo() {
        long CCTAL_dateDifference = (new Date()).getTime() - CCTAL_loadTimeBanner;
        long CCTAL_numMilliSecondsPerHour = 3600000;
        return (CCTAL_dateDifference < (CCTAL_numMilliSecondsPerHour * (long) 4));
    }

    public boolean CCTAL_isBannerAdAvailable() {
        boolean CCTAL_isBannerAdAvailable = CCTAL_admobBannerAd_preLoad != null && CCTAL_wasBannerLoadTimeLessThanNHoursAgo() && CCTAL_state_admobBanner.equals("Loaded");
        if (!CCTAL_isBannerAdAvailable) {
            CCTAL_admobBannerAd_preLoad = null;
            CCTAL_state_admobBanner = "Start";
        }
        return CCTAL_isBannerAdAvailable;
    }

    private void CCTAL_showAdmobBanner(final ViewGroup CCTAL_bannerAdContainer) {
        if (CCTAL_admob_b.isEmpty() || CCTAL_app_adShowStatus == 0 || !ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_state_admobBanner.equals("Loading")) {
            return;
        }
        try {
//            final String CCTAL_adstype = "8";
//            final View CCTAL_adDataView = CCTAL_inflate_NATIV_ADMOB(CCTAL_bannerAdContainer, CCTAL_adstype);
            final View CCTAL_adDataView = CCTAL_inflate_NATIV_ADMOB(CCTAL_bannerAdContainer, "8");
            CCTAL_bannerManageSpaceBox(CCTAL_adDataView, CCTAL_bannerAdContainer);


            FrameLayout CCTAL_root = CCTAL_adDataView.findViewById(R.id.root);
            FrameLayout CCTAL_banner_container = CCTAL_adDataView.findViewById(R.id.banner_container);
            ShimmerFrameLayout CCTAL_shimmer_view_container = CCTAL_adDataView.findViewById(R.id.shimmer_view_container);

            if (CCTAL_banner_container != null) {
                CCTAL_banner_container.removeAllViews();
            }
            if (CCTAL_bannerAdContainer != null) {
                CCTAL_bannerAdContainer.removeAllViews();
            }
            CCTAL_bannerAdContainer.addView(CCTAL_root);

            CCTAL_isBannerAdAvailable();
            if (CCTAL_admobBannerAd_preLoad == null & ((CCTAL_state_admobBanner.equals("Start")) || CCTAL_state_admobBanner.equals("Fail"))) {
                CCTAL_state_admobBanner = "Loading";
                final AdView CCTAL_mAdView = new AdView(CCTAL_activity);
                CCTAL_mAdView.setAdSize(AdSize.BANNER);
                CCTAL_mAdView.setAdUnitId(CCTAL_admob_b);
                AdRequest adRequest = new AdRequest.Builder().build();
                CCTAL_mAdView.loadAd(adRequest);
                CCTAL_mAdView.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        super.onAdClosed();
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        CCTAL_state_admobBanner = "Fail";
                        CCTAL_loadTimeBanner = (new Date()).getTime();
                        if (CCTAL_banner_container != null) {
                            CCTAL_banner_container.removeAllViews();
                        }
                        CCTAL_shimmer_view_container.stopShimmer();
                        CCTAL_shimmer_view_container.setVisibility(View.GONE);
                        CCTAL_nextBannerPlatform(CCTAL_bannerAdContainer);
                    }

                    @Override
                    public void onAdOpened() {
                        super.onAdOpened();

                    }

                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                        CCTAL_state_admobBanner = "Loaded";
                        CCTAL_loadTimeBanner = (new Date()).getTime();
                        if (CCTAL_banner_container != null) {
                            CCTAL_banner_container.removeAllViews();
                        }
                        CCTAL_shimmer_view_container.stopShimmer();
                        CCTAL_shimmer_view_container.setVisibility(View.GONE);
                        CCTAL_banner_container.addView(CCTAL_mAdView);
                    }

                    @Override
                    public void onAdClicked() {
                        super.onAdClicked();
                    }

                    @Override
                    public void onAdImpression() {
                        super.onAdImpression();
                        CCTAL_state_admobBanner = "Start";
                        CCTAL_preLoadBanner(CCTAL_ADMOB);
                    }
                });
            } else {
                if (CCTAL_banner_container != null) {
                    CCTAL_banner_container.removeAllViews();
                }
                Handler CCTAL_handler = new Handler();
                CCTAL_handler.postDelayed(new Runnable() {
                    public void run() {
                        CCTAL_shimmer_view_container.stopShimmer();
                        CCTAL_shimmer_view_container.setVisibility(View.GONE);
                        CCTAL_banner_container.setVisibility(View.VISIBLE);
                    }
                }, CCTAL_shimmerEffectTime);
                CCTAL_banner_container.addView(CCTAL_admobBannerAd_preLoad);

                CCTAL_state_admobBanner = "Start";
                CCTAL_preLoadBanner(CCTAL_ADMOB);
            }
            CCTAL_bannerAdContainer.addView(CCTAL_root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CCTAL_preLoadBanner(String CCTAL_platform) {
        if (CCTAL_state_admobBanner.equals("Loading") || CCTAL_isBannerAdAvailable() || !ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        CCTAL_admobBannerAd_preLoad = null;
        if (CCTAL_mysharedpreferences.getInt("appBannerPreLoad", 1) == 1 && (CCTAL_state_admobBanner.equals("Start")) || CCTAL_state_admobBanner.equals("Fail")) {
            CCTAL_admob_b = CCTAL_ADMOB_B[1];
            if (CCTAL_admob_b.isEmpty()) {
                return;
            }

            CCTAL_state_admobBanner = "Loading";
            final AdView CCTAL_mAdView = new AdView(CCTAL_activity);
            CCTAL_mAdView.setAdSize(AdSize.BANNER);
            CCTAL_mAdView.setAdUnitId(CCTAL_admob_b);
            AdRequest adRequest = new AdRequest.Builder().build();
            CCTAL_mAdView.loadAd(adRequest);
            CCTAL_mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();

                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    CCTAL_admobBannerAd_preLoad = null;
                    CCTAL_state_admobBanner = "Fail";
                    CCTAL_loadTimeBanner = (new Date()).getTime();
                }

                @Override
                public void onAdOpened() {
                    super.onAdOpened();
                }

                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    CCTAL_state_admobBanner = "Loaded";
                    CCTAL_loadTimeBanner = (new Date()).getTime();
                    CCTAL_admobBannerAd_preLoad = CCTAL_mAdView;
                }

                @Override
                public void onAdClicked() {
                    super.onAdClicked();
                }

                @Override
                public void onAdImpression() {
                    super.onAdImpression();
                }
            });
        }
    }

    public boolean CCTAL_isNativeBannerAvailable() {
        boolean CCTAL_isNativeBannerAvailable = CCTAL_admobNativeBannerAd_preLoad != null && CCTAL_wasNativeBannerLoadTimeLessThanNHoursAgo() && CCTAL_state_admobNativeBanner.equals("Loaded");
        if (!CCTAL_isNativeBannerAvailable) {
            CCTAL_admobNativeBannerAd_preLoad = null;
            CCTAL_state_admobNativeBanner = "Start";
        }
        return CCTAL_isNativeBannerAvailable;
    }

    private boolean CCTAL_wasNativeBannerLoadTimeLessThanNHoursAgo() {
        long CCTAL_dateDifference = (new Date()).getTime() - CCTAL_loadTimeNativeBanner;
        long CCTAL_numMilliSecondsPerHour = 3600000;
        CCTAL_wasNativeBannerLoadTimeLessThanNHoursAgo = (CCTAL_dateDifference < (CCTAL_numMilliSecondsPerHour * (long) 4));
        return CCTAL_wasNativeBannerLoadTimeLessThanNHoursAgo;
    }

    private void CCTAL_showAdmobNativeBanner(final ViewGroup CCTAL_bannerAdContainer) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0 || CCTAL_ADMOB_N[4].isEmpty() || CCTAL_state_admobNativeBanner.equals("Loading")) {
            return;
        }

        final View CCTAL_adDataView = CCTAL_inflate_NATIV_ADMOB(CCTAL_bannerAdContainer, "3");
        CCTAL_bannerManageSpaceBox(CCTAL_adDataView, CCTAL_bannerAdContainer);
        if (CCTAL_state_admobNativeBanner.equals("Loading")) {
            if (CCTAL_reserveForAdSpaceBanner.equals("1")) {
                CCTAL_bannerAdContainer.setVisibility(View.VISIBLE);
            } else {
                CCTAL_bannerAdContainer.setVisibility(View.GONE);
            }
            return;
        }
        CCTAL_isNativeBannerAvailable();

        if (CCTAL_admobNativeBannerAd_preLoad == null && (CCTAL_state_admobNativeBanner.equals("Start") || CCTAL_state_admobNativeBanner.equals("Fail"))) {
            CCTAL_state_admobNativeBanner = "Loading";
            final AdLoader CCTAL_adLoader = new AdLoader.Builder(CCTAL_activity, CCTAL_ADMOB_N[4])
                    .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                        @Override
                        public void onNativeAdLoaded(NativeAd nativeAd) {
                            CCTAL_state_admobNativeBanner = "Loaded";
                            CCTAL_showNativeViewData_NativeBanner(nativeAd, CCTAL_bannerAdContainer, CCTAL_adDataView);
                        }
                    })
                    .withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(LoadAdError adError) {
                            CCTAL_admobNativeBannerAd_preLoad = null;
                            CCTAL_state_admobNativeBanner = "Fail";
                            CCTAL_loadTimeNativeBanner = (new Date()).getTime();
                            CCTAL_nextBannerPlatform(CCTAL_bannerAdContainer);
                        }
                    })
                    .withNativeAdOptions(new com.google.android.gms.ads.formats.NativeAdOptions.Builder()
                            .build())
                    .build();
            CCTAL_adLoader.loadAd(new AdRequest.Builder().build());
        } else if (CCTAL_admobNativeBannerAd_preLoad != null && CCTAL_state_admobNativeBanner.equals("Loaded")) {
            CCTAL_showNativeViewData_NativeBanner(CCTAL_admobNativeBannerAd_preLoad, CCTAL_bannerAdContainer, CCTAL_adDataView);

        } else {
            CCTAL_nextBannerPlatform(CCTAL_bannerAdContainer);
        }
    }

    public void CCTAL_showNativeViewData_NativeBanner(NativeAd nativeAd, ViewGroup ad_Container, View view) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        try {
            FrameLayout CCTAL_adsView = view.findViewById(R.id.adsView);
            ShimmerFrameLayout CCTAL_shimmer_view_container = view.findViewById(R.id.shimmer_view_container);
            ((CardView) view.findViewById(R.id.adview_card)).setCardBackgroundColor(Color.parseColor(CCTAL_nativeAdBackgroundColor));
            ((TextView) view.findViewById(R.id.ad_headline)).setTextColor(Color.parseColor(CCTAL_nativeAdTextColor));
            ((TextView) view.findViewById(R.id.ad_body)).setTextColor(Color.parseColor(CCTAL_nativeAdTextColor));
            ((TextView) view.findViewById(R.id.ad_call_to_action)).setBackgroundColor(Color.parseColor(CCTAL_nativeAdButtonColor));
            ((TextView) view.findViewById(R.id.ad_call_to_action)).setTextColor(Color.parseColor(CCTAL_nativeAdButtonTextColor));
            ((TextView) view.findViewById(R.id.adText)).setTextColor(Color.parseColor(CCTAL_nativeAdButtonTextColor));
            ((TextView) view.findViewById(R.id.adText)).setBackgroundColor(Color.parseColor(CCTAL_nativeAdButtonColor));


            final NativeAdView CCTAL_adView1 = view.findViewById(R.id.adview);
            CCTAL_adView1.setVisibility(View.VISIBLE);

            CCTAL_adView1.setMediaView(view.findViewById(R.id.ad_media));
            CCTAL_adView1.setHeadlineView(view.findViewById(R.id.ad_headline));
            CCTAL_adView1.setBodyView(view.findViewById(R.id.ad_body));
            CCTAL_adView1.setCallToActionView(view.findViewById(R.id.ad_call_to_action));
            CCTAL_adView1.setIconView(view.findViewById(R.id.ad_app_icon));
            CCTAL_adView1.setPriceView(view.findViewById(R.id.ad_price));
            CCTAL_adView1.setStarRatingView(view.findViewById(R.id.ad_stars));
            CCTAL_adView1.setStoreView(view.findViewById(R.id.ad_store));
            CCTAL_adView1.setAdvertiserView(view.findViewById(R.id.ad_advertiser));

            CCTAL_adView1.getMediaView().setMediaContent(nativeAd.getMediaContent());
            ((TextView) CCTAL_adView1.getHeadlineView()).setText(nativeAd.getHeadline());
            ((TextView) CCTAL_adView1.getBodyView()).setText(nativeAd.getBody());
            ((TextView) CCTAL_adView1.getCallToActionView()).setText(nativeAd.getCallToAction());

            if (nativeAd.getIcon() == null) {
                CCTAL_adView1.getIconView().setVisibility(View.GONE);
            } else {
                ((ImageView) CCTAL_adView1.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
                CCTAL_adView1.getIconView().setVisibility(View.VISIBLE);
            }

            if (nativeAd.getPrice() == null) {
                CCTAL_adView1.getPriceView().setVisibility(View.GONE);
            } else {
                CCTAL_adView1.getPriceView().setVisibility(View.GONE);
                ((TextView) CCTAL_adView1.getPriceView()).setText(nativeAd.getPrice());
            }

            if (nativeAd.getStore() == null) {
                CCTAL_adView1.getStoreView().setVisibility(View.GONE);
            } else {
                CCTAL_adView1.getStoreView().setVisibility(View.GONE);
                ((TextView) CCTAL_adView1.getStoreView()).setText(nativeAd.getStore());
            }

            if (nativeAd.getStarRating() == null) {
                CCTAL_adView1.getStarRatingView().setVisibility(View.GONE);
            } else {
                ((RatingBar) CCTAL_adView1.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
                CCTAL_adView1.getStarRatingView().setVisibility(View.VISIBLE);
            }

            if (nativeAd.getAdvertiser() == null) {
                CCTAL_adView1.getAdvertiserView().setVisibility(View.GONE);
            } else {
                ((TextView) CCTAL_adView1.getAdvertiserView()).setText(nativeAd.getAdvertiser());
                CCTAL_adView1.getAdvertiserView().setVisibility(View.VISIBLE);
            }

            CCTAL_adView1.setNativeAd(nativeAd);
            CCTAL_adView1.setVisibility(View.VISIBLE);
            if (ad_Container != null) {
                ad_Container.removeAllViews();
            }

            Handler CCTAL_handler = new Handler();
            CCTAL_handler.postDelayed(new Runnable() {
                public void run() {
                    CCTAL_shimmer_view_container.stopShimmer();
                    CCTAL_shimmer_view_container.setVisibility(View.GONE);
                    CCTAL_adsView.setVisibility(View.VISIBLE);
                }
            }, CCTAL_shimmerEffectTime);
            ad_Container.addView(view);

            CCTAL_admobNativeBannerAd_preLoad = null;
            CCTAL_state_admobNativeBanner = "Start";
            CCTAL_preload_native_banner();


        } catch (Exception e) {
            Log.e("TAG", "Error" + e.getMessage());
            ((LinearLayout) view.findViewById(R.id.ll_space)).setVisibility(View.VISIBLE);

        }
    }

    public void CCTAL_preload_native_banner() {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        if (CCTAL_state_admobNativeBanner.equals("Loading") || CCTAL_isNativeBannerAvailable() || !ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity)) {
            return;
        }
        if (CCTAL_mysharedpreferences.getInt("appNativePreLoad", 1) == 1 && (CCTAL_state_admobNativeBanner.equals("Start")) || CCTAL_state_admobNativeBanner.equals("Fail")) {
            CCTAL_state_admobNativeBanner = "Loading";
            final AdLoader CCTAL_adLoader = new AdLoader.Builder(CCTAL_activity, CCTAL_ADMOB_N[4])
                    .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                        @Override
                        public void onNativeAdLoaded(NativeAd nativeAd) {
                            CCTAL_admobNativeBannerAd_preLoad = nativeAd;
                            CCTAL_state_admobNativeBanner = "Loaded";
                            CCTAL_loadTimeNativeBanner = (new Date()).getTime();
                        }
                    })
                    .withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(LoadAdError adError) {
                            CCTAL_admobNativeBannerAd_preLoad = null;
                            CCTAL_state_admobNativeBanner = "Fail";
                            CCTAL_loadTimeNativeBanner = (new Date()).getTime();
                        }
                    })
                    .withNativeAdOptions(new com.google.android.gms.ads.formats.NativeAdOptions.Builder()
                            .build())
                    .build();
            CCTAL_adLoader.loadAd(new AdRequest.Builder().build());
        }
    }

    private void CCTAL_nextBannerPlatform(ViewGroup CCTAL_banner_container) {
        if (CCTAL_banner_sequence.size() != 0) {
            CCTAL_banner_sequence.remove(0);
            if (CCTAL_banner_sequence.size() != 0) {
                CCTAL_displayBanner(CCTAL_banner_sequence.get(0), CCTAL_banner_container);
            } else {
                if (CCTAL_reserveForAdSpaceBanner.equals("1")) {
                    CCTAL_banner_container.setVisibility(View.VISIBLE);
                } else {
                    CCTAL_banner_container.setVisibility(View.GONE);
                }
            }
        }
    }

    private void CCTAL_showMyCustomBanner(final ViewGroup CCTAL_banner_container) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        final ByteDance_SafeSdk_Pojo CCTAL_appModal = CCTAL_getMyCustomAd("Banner");
        if (CCTAL_appModal != null) {

            View CCTAL_inflate2 = LayoutInflater.from(CCTAL_activity).inflate(R.layout.bytedance_safesdk_c_banner, CCTAL_banner_container, false);


            CardView CCTAL_mainAdsCard = CCTAL_inflate2.findViewById(R.id.mainAdsCard);
            TextView CCTAL_AD = CCTAL_inflate2.findViewById(R.id.AD);
            CardView CCTAL_cardviewCta = CCTAL_inflate2.findViewById(R.id.cardviewCta);
            TextView CCTAL_cta = CCTAL_inflate2.findViewById(R.id.cta);
            TextView CCTAL_primary = CCTAL_inflate2.findViewById(R.id.primary);
            TextView CCTAL_secondary = CCTAL_inflate2.findViewById(R.id.secondary);

            CCTAL_cardviewCta.setCardBackgroundColor(Color.parseColor(CCTAL_customNativeAdButtonColor));
            CCTAL_cta.setTextColor(Color.parseColor(CCTAL_customNativeAdButtonTextColor));
            CCTAL_mainAdsCard.setCardBackgroundColor(Color.parseColor(CCTAL_customNativeAdBackgroundColor));
            CCTAL_primary.setTextColor(Color.parseColor(CCTAL_customNativeAdTextColor));
            CCTAL_secondary.setTextColor(Color.parseColor(CCTAL_customNativeAdTextColor));
            CCTAL_AD.setTextColor(Color.parseColor(CCTAL_customNativeAdButtonTextColor));
            CCTAL_AD.setBackgroundColor(Color.parseColor(CCTAL_customNativeAdButtonColor));

            ImageView CCTAL_imageView2 = (ImageView) CCTAL_inflate2.findViewById(R.id.icon);
            TextView CCTAL_textView = CCTAL_primary;
            TextView CCTAL_textView2 = CCTAL_secondary;

            try {
                Glide
                        .with(CCTAL_activity)
                        .load(CCTAL_appModal.getCCTAL_app_logo())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                CCTAL_banner_container.removeAllViews();
                                CCTAL_nextBannerPlatform(CCTAL_banner_container);
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .into(CCTAL_imageView2);
            } catch (Exception e) {
                e.printStackTrace();
            }

            CCTAL_textView.setText(CCTAL_appModal.getCCTAL_app_name());
            CCTAL_textView2.setText(CCTAL_appModal.getCCTAL_app_shortDecription());
            CCTAL_inflate2.findViewById(R.id.cta).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    String action_str = CCTAL_appModal.getCCTAL_app_packageName();
                    if (action_str.contains("http")) {
                        Uri marketUri = Uri.parse(action_str);
                        Intent marketIntent = new Intent(Intent.ACTION_VIEW, marketUri);
                        CCTAL_activity.startActivity(marketIntent);
                    } else {
                        CCTAL_activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + action_str)));
                    }

                }
            });
            CCTAL_banner_container.removeAllViews();
            CCTAL_banner_container.addView(CCTAL_inflate2);
            CCTAL_count_custBannerAd++;


        } else {
            CCTAL_nextBannerPlatform(CCTAL_banner_container);
        }

    }


    public void CCTAL_showNative(ViewGroup CCTAL_nativeAdContainer, String CCTAL_color, String CCTAL_type, String CCTAL_admobN, String CCTAL_facebookN, int CCTAL_card) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        CCTAL_turnShowNative(CCTAL_nativeAdContainer, CCTAL_type, CCTAL_admobN, CCTAL_color, CCTAL_facebookN, CCTAL_card);
    }

    public void CCTAL_turnShowNative(ViewGroup CCTAL_nativeAdContainer, String CCTAL_type, String CCTAL_admobN, String CCTAL_color, String CCTAL_facebookN, int CCTAL_card) {
        CCTAL_admob_n = CCTAL_admobN;

        if (CCTAL_app_adShowStatus == 0 || !ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity)) {
            return;
        }
        CCTAL_count_native++;
        int CCTAL_CCTAL_app_howShowAd = CCTAL_mysharedpreferences.getInt("app_howShowAdNative", 0);
        String CCTAL_adPlatformSequence = CCTAL_mysharedpreferences.getString("app_adPlatformSequenceNative", "");
        String CCTAL_alernateAdShow = CCTAL_mysharedpreferences.getString("app_alernateAdShowNative", "");

        CCTAL_native_sequence = new ArrayList<String>();
        if (CCTAL_CCTAL_app_howShowAd == 0 && !CCTAL_adPlatformSequence.isEmpty()) {
            String CCTAL_adSequence[] = CCTAL_adPlatformSequence.split(",");
            for (int i = 0; i < CCTAL_adSequence.length; i++) {
                CCTAL_native_sequence.add(CCTAL_adSequence[i]);
            }

        } else if (CCTAL_CCTAL_app_howShowAd == 1 && !CCTAL_alernateAdShow.isEmpty()) {
            String CCTAL_alernateAd[] = CCTAL_alernateAdShow.split(",");

            int index = 0;
            for (int j = 0; j <= 10; j++) {
                if (CCTAL_count_native % CCTAL_alernateAd.length == j) {
                    index = j;
                    CCTAL_native_sequence.add(CCTAL_alernateAd[index]);
                }
            }

            String adSequence[] = CCTAL_adPlatformSequence.split(",");
            for (int j = 0; j < adSequence.length; j++) {
                if (CCTAL_native_sequence.size() != 0) {
                    if (!CCTAL_native_sequence.get(0).equals(adSequence[j])) {
                        CCTAL_native_sequence.add(adSequence[j]);
                    }
                }
            }
        }

        if (CCTAL_native_sequence.size() != 0) {
            CCTAL_displayNative(CCTAL_native_sequence.get(0), CCTAL_nativeAdContainer, CCTAL_type, CCTAL_color, CCTAL_card);
        }

    }

    private void CCTAL_displayNative(String CCTAL_platform, ViewGroup CCTAL_nativeAdContainer, String CCTAL_type, String CCTAL_color, int CCTAL_card) {
        final View adDataView = CCTAL_inflate_NATIV_ADMOB(CCTAL_nativeAdContainer, CCTAL_type);
        if (CCTAL_platform.equals(CCTAL_ADMOB) && CCTAL_app_adShowStatus == 1) {
            CCTAL_showAdmobNative_MED(CCTAL_nativeAdContainer, CCTAL_type, adDataView, CCTAL_color, CCTAL_card);
        } else if (CCTAL_platform.equals(CCTAL_MyCustomAds) && CCTAL_myCustom_AdStatus == 1 && CCTAL_app_adShowStatus == 1) {
            CCTAL_showMyCustomNative(CCTAL_nativeAdContainer, CCTAL_type, adDataView, CCTAL_color, CCTAL_card);
        } else {
            CCTAL_nextNativePlatform(CCTAL_nativeAdContainer, CCTAL_type, adDataView, CCTAL_color, CCTAL_card);
        }
    }

    public void CCTAL_preload_native() {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0 || CCTAL_state_admobNative.equals("Loading") || CCTAL_isNativeAvailable()) {
            return;
        }

        if (CCTAL_mysharedpreferences.getInt("appNativePreLoad", 1) == 1 && (CCTAL_state_admobNative.equals("Start")) || CCTAL_state_admobNative.equals("Fail")) {
            CCTAL_state_admobNative = "Loading";
            final AdLoader CCTAL_adLoader = new AdLoader.Builder(CCTAL_activity, CCTAL_admob_n)
                    .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                        @Override
                        public void onNativeAdLoaded(NativeAd nativeAd) {
                            CCTAL_admobNativeAd_preLoad = nativeAd;
                            CCTAL_state_admobNative = "Loaded";
                            CCTAL_loadTimeNative = (new Date()).getTime();
                        }
                    })
                    .withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(LoadAdError adError) {
                            CCTAL_admobNativeAd_preLoad = null;
                            CCTAL_state_admobNative = "Fail";
                            CCTAL_loadTimeNative = (new Date()).getTime();
                        }
                    })
                    .withNativeAdOptions(new com.google.android.gms.ads.formats.NativeAdOptions.Builder()

                            .build())
                    .build();
            CCTAL_adLoader.loadAd(new AdRequest.Builder().build());

        }
    }

    public void CCTAL_preload_native(String CCTAL_nativeAdID) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        CCTAL_admob_n = CCTAL_nativeAdID;
        if (CCTAL_state_admobNative.equals("Loading") || CCTAL_isNativeAvailable()) {
            return;
        }

        if ((CCTAL_state_admobNative.equals("Start")) || CCTAL_state_admobNative.equals("Fail")) {
            if (CCTAL_admob_n == null) {
                return;
            }
            CCTAL_state_admobNative = "Loading";
            final AdLoader CCTAL_adLoader = new AdLoader.Builder(CCTAL_activity, CCTAL_admob_n)
                    .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                        @Override
                        public void onNativeAdLoaded(NativeAd nativeAd) {
                            CCTAL_admobNativeAd_preLoad = nativeAd;
                            CCTAL_state_admobNative = "Loaded";
                            CCTAL_loadTimeNative = (new Date()).getTime();
                        }
                    })
                    .withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(LoadAdError adError) {
                            CCTAL_admobNativeAd_preLoad = null;
                            CCTAL_state_admobNative = "Fail";
                            CCTAL_loadTimeNative = (new Date()).getTime();
                        }
                    })
                    .withNativeAdOptions(new com.google.android.gms.ads.formats.NativeAdOptions.Builder()
                            .build())
                    .build();
            CCTAL_adLoader.loadAd(new AdRequest.Builder().build());

        }
    }

    private boolean CCTAL_wasNativeLoadTimeLessThanNHoursAgo() {
        long CCTAL_dateDifference = (new Date()).getTime() - CCTAL_loadTimeNative;
        long CCTAL_numMilliSecondsPerHour = 3600000;
        return (CCTAL_dateDifference < (CCTAL_numMilliSecondsPerHour * (long) 4));
    }

    public boolean CCTAL_isNativeAvailable() {
        boolean CCTAL_isNativeAvailable = CCTAL_admobNativeAd_preLoad != null && CCTAL_wasNativeLoadTimeLessThanNHoursAgo() && CCTAL_state_admobNative.equals("Loaded");
        if (!CCTAL_isNativeAvailable) {
            CCTAL_admobNativeAd_preLoad = null;
            CCTAL_state_admobNative = "Start";
        }
        return CCTAL_isNativeAvailable;
    }

    private void CCTAL_showAdmobNative_MED(final ViewGroup CCTAL_ad_Container, final String CCTAL_type, View CCTAL_dataView, final String CCTAL_color, int CCTAL_card) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        if (CCTAL_state_admobNative.equals("Loading")) {
            CCTAL_nextNativePlatform(CCTAL_ad_Container, CCTAL_type, CCTAL_dataView, CCTAL_color, CCTAL_card);
            return;
        }
        CCTAL_isNativeAvailable();
        if (CCTAL_admobNativeAd_preLoad == null && (CCTAL_state_admobNative.equals("Start") || CCTAL_state_admobNative.equals("Fail"))) {

            CCTAL_state_admobNative = "Loading";
            final AdLoader CCTAL_adLoader = new AdLoader.Builder(CCTAL_activity, CCTAL_admob_n)
                    .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                        @Override
                        public void onNativeAdLoaded(NativeAd nativeAd) {
                            CCTAL_state_admobNative = "Loaded";
                            CCTAL_loadTimeNative = (new Date()).getTime();
                            CCTAL_showNativeViewData(nativeAd, CCTAL_ad_Container, CCTAL_dataView);
                        }
                    })
                    .withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(LoadAdError adError) {
                            CCTAL_admobNativeAd_preLoad = null;
                            CCTAL_state_admobNative = "Fail";
                            CCTAL_loadTimeNative = (new Date()).getTime();
                            CCTAL_nextNativePlatform(CCTAL_ad_Container, CCTAL_type, CCTAL_dataView, CCTAL_color, CCTAL_card);
                        }
                    })
                    .withNativeAdOptions(new com.google.android.gms.ads.formats.NativeAdOptions.Builder().build())
                    .build();
            CCTAL_adLoader.loadAd(new AdRequest.Builder().build());
        } else if (CCTAL_admobNativeAd_preLoad != null & CCTAL_state_admobNative.equals("Loaded")) {
            CCTAL_state_admobNative = "Start";
            CCTAL_showNativeViewData(CCTAL_admobNativeAd_preLoad, CCTAL_ad_Container, CCTAL_dataView);
        } else {
            CCTAL_nextNativePlatform(CCTAL_ad_Container, CCTAL_type, CCTAL_dataView, CCTAL_color, CCTAL_card);
        }
    }

    public void CCTAL_showNativeViewData(NativeAd nativeAd, ViewGroup ad_Container, View view) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        try {
            FrameLayout CCTAL_adsView = view.findViewById(R.id.adsView);
            ShimmerFrameLayout CCTAL_shimmer_view_container = view.findViewById(R.id.shimmer_view_container);
            ((CardView) view.findViewById(R.id.adview_card)).setCardBackgroundColor(Color.parseColor(CCTAL_nativeAdBackgroundColor));
            ((TextView) view.findViewById(R.id.ad_headline)).setTextColor(Color.parseColor(CCTAL_nativeAdTextColor));
            ((TextView) view.findViewById(R.id.ad_body)).setTextColor(Color.parseColor(CCTAL_nativeAdTextColor));
            ((TextView) view.findViewById(R.id.ad_call_to_action)).setBackgroundColor(Color.parseColor(CCTAL_nativeAdButtonColor));
            ((TextView) view.findViewById(R.id.ad_call_to_action)).setTextColor(Color.parseColor(CCTAL_nativeAdButtonTextColor));
            ((TextView) view.findViewById(R.id.adText)).setTextColor(Color.parseColor(CCTAL_nativeAdButtonTextColor));
            ((TextView) view.findViewById(R.id.adText)).setBackgroundColor(Color.parseColor(CCTAL_nativeAdButtonColor));


            final NativeAdView CCTAL_adView1 = view.findViewById(R.id.adview);
            CCTAL_adView1.setVisibility(View.VISIBLE);

            CCTAL_adView1.setMediaView(view.findViewById(R.id.ad_media));
            CCTAL_adView1.setHeadlineView(view.findViewById(R.id.ad_headline));
            CCTAL_adView1.setBodyView(view.findViewById(R.id.ad_body));
            CCTAL_adView1.setCallToActionView(view.findViewById(R.id.ad_call_to_action));
            CCTAL_adView1.setIconView(view.findViewById(R.id.ad_app_icon));
            CCTAL_adView1.setPriceView(view.findViewById(R.id.ad_price));
            CCTAL_adView1.setStarRatingView(view.findViewById(R.id.ad_stars));
            CCTAL_adView1.setStoreView(view.findViewById(R.id.ad_store));
            CCTAL_adView1.setAdvertiserView(view.findViewById(R.id.ad_advertiser));

            CCTAL_adView1.getMediaView().setMediaContent(nativeAd.getMediaContent());
            ((TextView) CCTAL_adView1.getHeadlineView()).setText(nativeAd.getHeadline());
            ((TextView) CCTAL_adView1.getBodyView()).setText(nativeAd.getBody());
            ((TextView) CCTAL_adView1.getCallToActionView()).setText(nativeAd.getCallToAction());

            if (nativeAd.getIcon() == null) {
                CCTAL_adView1.getIconView().setVisibility(View.GONE);
            } else {
                ((ImageView) CCTAL_adView1.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
                CCTAL_adView1.getIconView().setVisibility(View.VISIBLE);
            }

            if (nativeAd.getPrice() == null) {
                CCTAL_adView1.getPriceView().setVisibility(View.GONE);
            } else {
                CCTAL_adView1.getPriceView().setVisibility(View.GONE);
                ((TextView) CCTAL_adView1.getPriceView()).setText(nativeAd.getPrice());
            }

            if (nativeAd.getStore() == null) {
                CCTAL_adView1.getStoreView().setVisibility(View.GONE);
            } else {
                CCTAL_adView1.getStoreView().setVisibility(View.GONE);
                ((TextView) CCTAL_adView1.getStoreView()).setText(nativeAd.getStore());
            }

            if (nativeAd.getStarRating() == null) {
                CCTAL_adView1.getStarRatingView().setVisibility(View.GONE);
            } else {
                ((RatingBar) CCTAL_adView1.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
                CCTAL_adView1.getStarRatingView().setVisibility(View.VISIBLE);
            }

            if (nativeAd.getAdvertiser() == null) {
                CCTAL_adView1.getAdvertiserView().setVisibility(View.GONE);
            } else {
                ((TextView) CCTAL_adView1.getAdvertiserView()).setText(nativeAd.getAdvertiser());
                CCTAL_adView1.getAdvertiserView().setVisibility(View.VISIBLE);
            }

            CCTAL_adView1.setNativeAd(nativeAd);
            CCTAL_adView1.setVisibility(View.VISIBLE);
            if (ad_Container != null) {
                ad_Container.removeAllViews();
            }

            Handler CCTAL_handler = new Handler();
            CCTAL_handler.postDelayed(new Runnable() {
                public void run() {
                    CCTAL_shimmer_view_container.stopShimmer();
                    CCTAL_shimmer_view_container.setVisibility(View.GONE);
                    CCTAL_adsView.setVisibility(View.VISIBLE);
                }
            }, CCTAL_shimmerEffectTime);
            ad_Container.addView(view);

            CCTAL_admobNativeAd_preLoad = null;
            CCTAL_state_admobNative = "Start";
            CCTAL_preload_native();

        } catch (Exception e) {
            Log.e("TAG", "Error" + e.getMessage());
            ((LinearLayout) view.findViewById(R.id.ll_space)).setVisibility(View.VISIBLE);

        }
    }

    public View CCTAL_inflate_NATIV_ADMOB(ViewGroup CCTAL_ad_Container, final String CCTAL_type) {
        View CCTAL_adDataView = null;
        switch (CCTAL_type) {
            case "1":
                CCTAL_adDataView = CCTAL_activity.getLayoutInflater().inflate(R.layout.bytedance_safesdk_google_native, null);
                CCTAL_setAdsHeight(CCTAL_ad_Container, CCTAL_type);
                break;
            case "2":
                CCTAL_adDataView = CCTAL_activity.getLayoutInflater().inflate(R.layout.bytedance_safesdk_g_small_n, null);
                break;
            case "3":
                CCTAL_adDataView = CCTAL_activity.getLayoutInflater().inflate(R.layout.bytedance_safesdk_google_nb, null);
                break;
            case "4":
                CCTAL_adDataView = CCTAL_activity.getLayoutInflater().inflate(R.layout.bytedance_safesdk_google_n_recycler, null);
                break;
            case "8":
                //for shimmer effect of banner
                CCTAL_adDataView = CCTAL_activity.getLayoutInflater().inflate(R.layout.bytedance_safesdk_google_banner, null);
                break;
            default:
                CCTAL_adDataView = CCTAL_activity.getLayoutInflater().inflate(R.layout.bytedance_safesdk_google_native, null);
                CCTAL_setAdsHeight(CCTAL_ad_Container, CCTAL_type);
                break;

        }
        return CCTAL_adDataView;
    }

    private void CCTAL_setAdsHeight(ViewGroup CCTAL_view, String CCTAL_adstype) {
        switch (CCTAL_adstype) {
            case "1":
                CCTAL_view.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        (CCTAL_activity.getResources().getDisplayMetrics().heightPixels * 35) / 100));
                break;
        }
    }

    private void CCTAL_nextNativePlatform(ViewGroup CCTAL_nativeAdContainer, String CCTAL_type, View CCTAL_dataView, String CCTAL_color, int CCTAL_card) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        if (CCTAL_native_sequence.size() != 0) {
            CCTAL_native_sequence.remove(0);
            if (CCTAL_native_sequence.size() != 0) {
                CCTAL_displayNative(CCTAL_native_sequence.get(0), CCTAL_nativeAdContainer, CCTAL_type, CCTAL_color, CCTAL_card);
            } else if (!CCTAL_admob_n.isEmpty()) {
                if (CCTAL_reserveForAdSpaceNative.equals("1")) {
                    CCTAL_nativeAdContainer.setVisibility(View.VISIBLE);
                } else {
                    CCTAL_nativeAdContainer.setVisibility(View.GONE);
                }
            }
        }
    }

    private void CCTAL_showMyCustomNative(final ViewGroup CCTAL_nativeAdContainer, final String CCTAL_type, View CCTAL_dataView, final String CCTAL_color, int CCTAL_card) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        final ByteDance_SafeSdk_Pojo CCTAL_appModal = CCTAL_getMyCustomAd("Native");
        if (CCTAL_appModal != null) {
            View CCTAL_inflate = LayoutInflater.from(CCTAL_activity).inflate(R.layout.bytedance_safesdk_cs_native, CCTAL_nativeAdContainer, false);

            if (CCTAL_type.equals("1")) {
                CCTAL_inflate = LayoutInflater.from(CCTAL_activity).inflate(R.layout.bytedance_safesdk_cs_native, CCTAL_nativeAdContainer, false);
                CCTAL_inflate.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (CCTAL_activity.getResources().getDisplayMetrics().heightPixels * 35) / 100));
            } else if (CCTAL_type.equals("2")) {
                CCTAL_inflate = LayoutInflater.from(CCTAL_activity).inflate(R.layout.bytedance_safesdk_cs_small_n, CCTAL_nativeAdContainer, false);
                CCTAL_inflate.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (CCTAL_activity.getResources().getDisplayMetrics().heightPixels * 22) / 100));
            } else if (CCTAL_type.equals("3")) {
                CCTAL_inflate = LayoutInflater.from(CCTAL_activity).inflate(R.layout.bytedance_safesdk_cs_nb1, CCTAL_nativeAdContainer, false);
                CCTAL_inflate.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (ViewGroup.LayoutParams.MATCH_PARENT)));
            } else if (CCTAL_type.equals("4")) {
                CCTAL_inflate = LayoutInflater.from(CCTAL_activity).inflate(R.layout.bytedance_safesdk_cs_n_recycler, CCTAL_nativeAdContainer, false);
                CCTAL_inflate.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            } else if (CCTAL_type.equals("8")) {
                CCTAL_inflate = LayoutInflater.from(CCTAL_activity).inflate(R.layout.bytedance_safesdk_cs_nb2, CCTAL_nativeAdContainer, false);
                CCTAL_inflate.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (ViewGroup.LayoutParams.MATCH_PARENT)));
            }

            ((TextView) CCTAL_inflate.findViewById(R.id.ad_call_to_action)).setBackgroundColor(Color.parseColor(CCTAL_customNativeAdButtonColor));
            ((CardView) CCTAL_inflate.findViewById(R.id.mainAdsCard)).setCardBackgroundColor(Color.parseColor(CCTAL_customNativeAdBackgroundColor));
            //todo: desc color
//            ((TextView) CCTAL_inflate.findViewById(R.id.tv_desc)).setTextColor(Color.parseColor(CCTAL_customNativeAdTextColor));
            ((TextView) CCTAL_inflate.findViewById(R.id.tv_appname)).setTextColor(Color.parseColor(CCTAL_customNativeAdTextColor));
            ((TextView) CCTAL_inflate.findViewById(R.id.ad_call_to_action)).setTextColor(Color.parseColor(CCTAL_customNativeAdButtonTextColor));
            ((TextView) CCTAL_inflate.findViewById(R.id.tvAD)).setTextColor(Color.parseColor(CCTAL_customNativeAdButtonTextColor));
            ((TextView) CCTAL_inflate.findViewById(R.id.tvAD)).setBackgroundColor(Color.parseColor(CCTAL_customNativeAdButtonColor));

            ImageView iv_banner = (ImageView) CCTAL_inflate.findViewById(R.id.iv_banner);
            ImageView iv_logo = (ImageView) CCTAL_inflate.findViewById(R.id.iv_logo);
            TextView tv_appname = (TextView) CCTAL_inflate.findViewById(R.id.tv_appname);
            LinearLayout ll_app_panel = (LinearLayout) CCTAL_inflate.findViewById(R.id.ll_app_panel);
            RatingBar ad_stars = (RatingBar) CCTAL_inflate.findViewById(R.id.ad_stars);
            TextView tv_rating = (TextView) CCTAL_inflate.findViewById(R.id.tv_rating);
            TextView tv_download = (TextView) CCTAL_inflate.findViewById(R.id.tv_download);
            TextView tv_desc = (TextView) CCTAL_inflate.findViewById(R.id.tv_desc);
            TextView btn_install = (TextView) CCTAL_inflate.findViewById(R.id.ad_call_to_action);

            try {
                Glide.with(CCTAL_activity)
                        .load(CCTAL_appModal.getCCTAL_app_banner())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                CCTAL_nativeAdContainer.removeAllViews();
                                CCTAL_nextNativePlatform(CCTAL_nativeAdContainer, CCTAL_type, CCTAL_dataView, CCTAL_color, CCTAL_card);
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {


                                return false;
                            }
                        })
                        .into(iv_banner);

                Glide.with(CCTAL_activity)
                        .load(CCTAL_appModal.getCCTAL_app_logo())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(iv_logo);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (CCTAL_appModal.getCCTAL_app_packageName().contains("http")) {
                tv_appname.setText("Play & Win Coins Daily.");
                ll_app_panel.setVisibility(View.GONE);
                btn_install.setText("Play Now");
            } else {
                tv_appname.setText(CCTAL_appModal.getCCTAL_app_name().trim());
                ll_app_panel.setVisibility(View.VISIBLE);
                btn_install.setText("Install");
            }
            ad_stars.setRating(Float.parseFloat(CCTAL_appModal.getCCTAL_app_rating()));
            tv_rating.setText("(" + CCTAL_appModal.getCCTAL_app_rating() + ")");
            tv_download.setText(CCTAL_appModal.getCCTAL_app_download() + " +");
            tv_desc.setText(CCTAL_appModal.getCCTAL_app_shortDecription().trim());

            btn_install.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String action_str = CCTAL_appModal.getCCTAL_app_packageName();
                    if (action_str.contains("http")) {
                        ByteDance_SafeSdk_Universal.CCTAL_openChromeCustomTabUrl(CCTAL_activity, action_str);
                    } else {
                        CCTAL_activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(ByteDance_SafeSdk_Universal.CCTAL_getPlaystoreUrl(action_str))));
                    }
                }
            });
            CCTAL_nativeAdContainer.removeAllViews();

            if (CCTAL_type.equals("2") || CCTAL_type.equals("3") || CCTAL_type.equals("4") || CCTAL_type.equals("8")) {
                ll_app_panel.setVisibility(View.GONE);
            } else {
                ll_app_panel.setVisibility(View.VISIBLE);
            }
            CCTAL_nativeAdContainer.addView(CCTAL_inflate);
            CCTAL_count_custNativeAd++;
        } else {
            CCTAL_nextNativePlatform(CCTAL_nativeAdContainer, CCTAL_type, CCTAL_dataView, CCTAL_color, CCTAL_card);
        }
    }

    public void CCTAL_showNative2(final ViewGroup CCTAL_nativeAdContainer) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        int CCTAL_logo = 0;
        if (ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) && ByteDance_SafeSdk_Manager.CCTAL_ADMOB_N[2] != null && ByteDance_SafeSdk_Manager.CCTAL_app_adShowStatus == 1) {
            AdLoader CCTAL_adLoader = new AdLoader.Builder(CCTAL_activity, ByteDance_SafeSdk_Manager.CCTAL_ADMOB_N[2])
                    .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                        @Override
                        public void onNativeAdLoaded(NativeAd nativeAd) {
                            View CCTAL_view = CCTAL_activity.getLayoutInflater().inflate(R.layout.bytedance_safesdk_google_native, null);
                            try {
                                CCTAL_nativeAdContainer.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (CCTAL_activity.getResources().getDisplayMetrics().heightPixels * 35) / 100));
                                FrameLayout CCTAL_adsView = CCTAL_view.findViewById(R.id.adsView);
                                ShimmerFrameLayout CCTAL_shimmer_view_container = CCTAL_view.findViewById(R.id.shimmer_view_container);
                                ((CardView) CCTAL_view.findViewById(R.id.adview_card)).setCardBackgroundColor(Color.parseColor(CCTAL_nativeAdBackgroundColor));
                                ((TextView) CCTAL_view.findViewById(R.id.ad_headline)).setTextColor(Color.parseColor(CCTAL_nativeAdTextColor));
                                ((TextView) CCTAL_view.findViewById(R.id.ad_body)).setTextColor(Color.parseColor(CCTAL_nativeAdTextColor));
                                ((TextView) CCTAL_view.findViewById(R.id.ad_call_to_action)).setBackgroundColor(Color.parseColor(CCTAL_nativeAdButtonColor));
                                ((TextView) CCTAL_view.findViewById(R.id.ad_call_to_action)).setTextColor(Color.parseColor(CCTAL_nativeAdButtonTextColor));
                                ((TextView) CCTAL_view.findViewById(R.id.adText)).setTextColor(Color.parseColor(CCTAL_nativeAdButtonTextColor));
                                ((TextView) CCTAL_view.findViewById(R.id.adText)).setBackgroundColor(Color.parseColor(CCTAL_nativeAdButtonColor));


                                final NativeAdView CCTAL_adView1 = CCTAL_view.findViewById(R.id.adview);
                                CCTAL_adView1.setVisibility(View.VISIBLE);

                                CCTAL_adView1.setMediaView(CCTAL_view.findViewById(R.id.ad_media));
                                CCTAL_adView1.setHeadlineView(CCTAL_view.findViewById(R.id.ad_headline));
                                CCTAL_adView1.setBodyView(CCTAL_view.findViewById(R.id.ad_body));
                                CCTAL_adView1.setCallToActionView(CCTAL_view.findViewById(R.id.ad_call_to_action));
                                CCTAL_adView1.setIconView(CCTAL_view.findViewById(R.id.ad_app_icon));
                                CCTAL_adView1.setPriceView(CCTAL_view.findViewById(R.id.ad_price));
                                CCTAL_adView1.setStarRatingView(CCTAL_view.findViewById(R.id.ad_stars));
                                CCTAL_adView1.setStoreView(CCTAL_view.findViewById(R.id.ad_store));
                                CCTAL_adView1.setAdvertiserView(CCTAL_view.findViewById(R.id.ad_advertiser));

                                CCTAL_adView1.getMediaView().setMediaContent(nativeAd.getMediaContent());
                                ((TextView) CCTAL_adView1.getHeadlineView()).setText(nativeAd.getHeadline());
                                ((TextView) CCTAL_adView1.getBodyView()).setText(nativeAd.getBody());
                                ((TextView) CCTAL_adView1.getCallToActionView()).setText(nativeAd.getCallToAction());

                                if (nativeAd.getIcon() == null) {
                                    CCTAL_adView1.getIconView().setVisibility(View.GONE);
                                } else {
                                    ((ImageView) CCTAL_adView1.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
                                    CCTAL_adView1.getIconView().setVisibility(View.VISIBLE);
                                }

                                if (nativeAd.getPrice() == null) {
                                    CCTAL_adView1.getPriceView().setVisibility(View.GONE);
                                } else {
                                    CCTAL_adView1.getPriceView().setVisibility(View.GONE);
                                    ((TextView) CCTAL_adView1.getPriceView()).setText(nativeAd.getPrice());
                                }

                                if (nativeAd.getStore() == null) {
                                    CCTAL_adView1.getStoreView().setVisibility(View.GONE);
                                } else {
                                    CCTAL_adView1.getStoreView().setVisibility(View.GONE);
                                    ((TextView) CCTAL_adView1.getStoreView()).setText(nativeAd.getStore());
                                }

                                if (nativeAd.getStarRating() == null) {
                                    CCTAL_adView1.getStarRatingView().setVisibility(View.GONE);
                                } else {
                                    ((RatingBar) CCTAL_adView1.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
                                    CCTAL_adView1.getStarRatingView().setVisibility(View.VISIBLE);
                                }

                                if (nativeAd.getAdvertiser() == null) {
                                    CCTAL_adView1.getAdvertiserView().setVisibility(View.GONE);
                                } else {
                                    ((TextView) CCTAL_adView1.getAdvertiserView()).setText(nativeAd.getAdvertiser());
                                    CCTAL_adView1.getAdvertiserView().setVisibility(View.VISIBLE);
                                }

                                CCTAL_adView1.setNativeAd(nativeAd);
                                CCTAL_adView1.setVisibility(View.VISIBLE);
                                if (CCTAL_nativeAdContainer != null) {
                                    CCTAL_nativeAdContainer.removeAllViews();
                                }

                                Handler CCTAL_handler = new Handler();
                                CCTAL_handler.postDelayed(new Runnable() {
                                    public void run() {
                                        CCTAL_shimmer_view_container.stopShimmer();
                                        CCTAL_shimmer_view_container.setVisibility(View.GONE);
                                        CCTAL_adsView.setVisibility(View.VISIBLE);
                                    }
                                }, CCTAL_shimmerEffectTime);
                                CCTAL_nativeAdContainer.addView(CCTAL_view);

                                CCTAL_admobNativeAd_preLoad = null;
                                CCTAL_state_admobNative = "Start";
                                CCTAL_preload_native();

                            } catch (Exception e) {
                                ((LinearLayout) CCTAL_view.findViewById(R.id.ll_space)).setVisibility(View.VISIBLE);
                            }
                        }
                    })
                    .withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(LoadAdError adError) {

                        }
                    })
                    .withNativeAdOptions(new com.google.android.gms.ads.formats.NativeAdOptions.Builder()
                            .build())
                    .build();
            CCTAL_adLoader.loadAd(new AdRequest.Builder().build());
        }
    }

    public void CCTAL_showNative3(final ViewGroup CCTAL_nativeAdContainer) {
        if (!ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) || CCTAL_app_adShowStatus == 0) {
            return;
        }
        int CCTAL_logo = 0;
        if (ByteDance_SafeSdk_Universal.CCTAL_CheckNet(CCTAL_activity) && ByteDance_SafeSdk_Manager.CCTAL_ADMOB_N[2] != null && ByteDance_SafeSdk_Manager.CCTAL_app_adShowStatus == 1) {
            AdLoader CCTAL_adLoader = new AdLoader.Builder(CCTAL_activity, ByteDance_SafeSdk_Manager.CCTAL_ADMOB_N[2])
                    .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                        @Override
                        public void onNativeAdLoaded(NativeAd nativeAd) {
                            View CCTAL_view = CCTAL_activity.getLayoutInflater().inflate(R.layout.bytedance_safesdk_google_native, null);
                            try {
                                CCTAL_nativeAdContainer.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (CCTAL_activity.getResources().getDisplayMetrics().heightPixels * 35) / 100));
                                FrameLayout CCTAL_adsView = CCTAL_view.findViewById(R.id.adsView);
                                ShimmerFrameLayout CCTAL_shimmer_view_container = CCTAL_view.findViewById(R.id.shimmer_view_container);
                                ((CardView) CCTAL_view.findViewById(R.id.adview_card)).setCardBackgroundColor(Color.parseColor(CCTAL_nativeAdBackgroundColor));
                                ((TextView) CCTAL_view.findViewById(R.id.ad_headline)).setTextColor(Color.parseColor(CCTAL_nativeAdTextColor));
                                ((TextView) CCTAL_view.findViewById(R.id.ad_body)).setTextColor(Color.parseColor(CCTAL_nativeAdTextColor));
                                ((TextView) CCTAL_view.findViewById(R.id.ad_call_to_action)).setBackgroundColor(Color.parseColor(CCTAL_nativeAdButtonColor));
                                ((TextView) CCTAL_view.findViewById(R.id.ad_call_to_action)).setTextColor(Color.parseColor(CCTAL_nativeAdButtonTextColor));
                                ((TextView) CCTAL_view.findViewById(R.id.adText)).setTextColor(Color.parseColor(CCTAL_nativeAdButtonTextColor));
                                ((TextView) CCTAL_view.findViewById(R.id.adText)).setBackgroundColor(Color.parseColor(CCTAL_nativeAdButtonColor));


                                final NativeAdView CCTAL_adView1 = CCTAL_view.findViewById(R.id.adview);
                                CCTAL_adView1.setVisibility(View.VISIBLE);

                                CCTAL_adView1.setMediaView(CCTAL_view.findViewById(R.id.ad_media));
                                CCTAL_adView1.setHeadlineView(CCTAL_view.findViewById(R.id.ad_headline));
                                CCTAL_adView1.setBodyView(CCTAL_view.findViewById(R.id.ad_body));
                                CCTAL_adView1.setCallToActionView(CCTAL_view.findViewById(R.id.ad_call_to_action));
                                CCTAL_adView1.setIconView(CCTAL_view.findViewById(R.id.ad_app_icon));
                                CCTAL_adView1.setPriceView(CCTAL_view.findViewById(R.id.ad_price));
                                CCTAL_adView1.setStarRatingView(CCTAL_view.findViewById(R.id.ad_stars));
                                CCTAL_adView1.setStoreView(CCTAL_view.findViewById(R.id.ad_store));
                                CCTAL_adView1.setAdvertiserView(CCTAL_view.findViewById(R.id.ad_advertiser));

                                CCTAL_adView1.getMediaView().setMediaContent(nativeAd.getMediaContent());
                                ((TextView) CCTAL_adView1.getHeadlineView()).setText(nativeAd.getHeadline());
                                ((TextView) CCTAL_adView1.getBodyView()).setText(nativeAd.getBody());
                                ((TextView) CCTAL_adView1.getCallToActionView()).setText(nativeAd.getCallToAction());

                                if (nativeAd.getIcon() == null) {
                                    CCTAL_adView1.getIconView().setVisibility(View.GONE);
                                } else {
                                    ((ImageView) CCTAL_adView1.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
                                    CCTAL_adView1.getIconView().setVisibility(View.VISIBLE);
                                }

                                if (nativeAd.getPrice() == null) {
                                    CCTAL_adView1.getPriceView().setVisibility(View.GONE);
                                } else {
                                    CCTAL_adView1.getPriceView().setVisibility(View.GONE);
                                    ((TextView) CCTAL_adView1.getPriceView()).setText(nativeAd.getPrice());
                                }

                                if (nativeAd.getStore() == null) {
                                    CCTAL_adView1.getStoreView().setVisibility(View.GONE);
                                } else {
                                    CCTAL_adView1.getStoreView().setVisibility(View.GONE);
                                    ((TextView) CCTAL_adView1.getStoreView()).setText(nativeAd.getStore());
                                }

                                if (nativeAd.getStarRating() == null) {
                                    CCTAL_adView1.getStarRatingView().setVisibility(View.GONE);
                                } else {
                                    ((RatingBar) CCTAL_adView1.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
                                    CCTAL_adView1.getStarRatingView().setVisibility(View.VISIBLE);
                                }

                                if (nativeAd.getAdvertiser() == null) {
                                    CCTAL_adView1.getAdvertiserView().setVisibility(View.GONE);
                                } else {
                                    ((TextView) CCTAL_adView1.getAdvertiserView()).setText(nativeAd.getAdvertiser());
                                    CCTAL_adView1.getAdvertiserView().setVisibility(View.VISIBLE);
                                }

                                CCTAL_adView1.setNativeAd(nativeAd);
                                CCTAL_adView1.setVisibility(View.VISIBLE);
                                if (CCTAL_nativeAdContainer != null) {
                                    CCTAL_nativeAdContainer.removeAllViews();
                                }

                                Handler CCTAL_handler = new Handler();
                                CCTAL_handler.postDelayed(new Runnable() {
                                    public void run() {
                                        CCTAL_shimmer_view_container.stopShimmer();
                                        CCTAL_shimmer_view_container.setVisibility(View.GONE);
                                        CCTAL_adsView.setVisibility(View.VISIBLE);
                                    }
                                }, CCTAL_shimmerEffectTime);
                                CCTAL_nativeAdContainer.addView(CCTAL_view);

                                CCTAL_admobNativeAd_preLoad = null;
                                CCTAL_state_admobNative = "Start";
                                CCTAL_preload_native();

                            } catch (Exception e) {
                                ((LinearLayout) CCTAL_view.findViewById(R.id.ll_space)).setVisibility(View.VISIBLE);
                            }
                        }
                    })
                    .withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(LoadAdError adError) {

                        }
                    })
                    .withNativeAdOptions(new com.google.android.gms.ads.formats.NativeAdOptions.Builder()
                            .build())
                    .build();
            CCTAL_adLoader.loadAd(new AdRequest.Builder().build());
        }
    }

    public void CCTAL_showAdClickAlert(final Activity CCTAL_context, final CCTAL_AdClickAlert CCTALAdClickAlert) {
        AlertDialog.Builder CCTAL_alertDialog = new AlertDialog.Builder(CCTAL_context);
        CCTAL_alertDialog.setMessage("Are you sure you want to redirect to the web?");
        CCTAL_alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                CCTALAdClickAlert.CCTAL_onOkClick();
                dialog.cancel();
            }
        });
        CCTAL_alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        CCTAL_alertDialog.show();
    }

    public interface CCTAL_AdClickAlert {
        public void CCTAL_onOkClick();

        public void CCTAL_onCanclelick();
    }

    public void CCTAL_openChromeCustomTabUrl(final Activity CCTAL_context, String CCTAL_webUrl) {
        try {
            if (CCTAL_isAppInstalled(CCTAL_context, "com.android.chrome")) {
                CustomTabsIntent.Builder CCTAL_builder = new CustomTabsIntent.Builder();
                int coolorInt = Color.parseColor("#66bb6a");
                CCTAL_builder.setToolbarColor(coolorInt);
                CCTAL_builder.setStartAnimations(CCTAL_context, R.anim.cidam_in_right, R.anim.cidam_slide_out_left);
                CCTAL_builder.setExitAnimations(CCTAL_context, R.anim.cidam_in_left, R.anim.cidam_slide_out_right);
                CustomTabsIntent customTabsIntent = CCTAL_builder.build();
                customTabsIntent.intent.setPackage("com.android.chrome");
                customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                customTabsIntent.launchUrl(CCTAL_context, Uri.parse(CCTAL_webUrl));
            } else {
                CustomTabsIntent.Builder CCTAL_builder = new CustomTabsIntent.Builder();
                int coolorInt = Color.parseColor("#66bb6a");
                CCTAL_builder.setToolbarColor(coolorInt);
                CCTAL_builder.setStartAnimations(CCTAL_context, R.anim.cidam_in_right, R.anim.cidam_slide_out_left);
                CCTAL_builder.setExitAnimations(CCTAL_context, R.anim.cidam_in_left, R.anim.cidam_slide_out_right);
                CustomTabsIntent customTabsIntent = CCTAL_builder.build();
                customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                customTabsIntent.launchUrl(CCTAL_context, Uri.parse(CCTAL_webUrl));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<String> CCTAL_custumsmallbanner;

    public static void CCTAL_fetchDatacustumsmallbanner() {
        CCTAL_custumsmallbanner.clear();
        StringRequest CCTAL_stringRequest = new StringRequest(Request.Method.GET, "http://reylioinfotech.com/reyliocoffee/app/smallbanner/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject CCTAL_obj = new JSONObject(response);
                            JSONArray CCTAL_heroArray = CCTAL_obj.getJSONArray("data");
                            for (int i = 0; i < CCTAL_heroArray.length(); i++) {
                                String videolink = String.valueOf(CCTAL_heroArray.get(i));
                                CCTAL_custumsmallbanner.add(videolink);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        RequestQueue CCTAL_requestQueue = Volley.newRequestQueue(CCTAL_activity);

        CCTAL_requestQueue.add(CCTAL_stringRequest);
    }

    public static boolean CCTAL_isNetworkAvailable(Context CCTAL_context) {
        ConnectivityManager CCTAL_manager =
                (ConnectivityManager) CCTAL_context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = CCTAL_manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }
}
