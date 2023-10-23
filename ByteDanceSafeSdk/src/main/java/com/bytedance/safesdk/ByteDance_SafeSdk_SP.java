package com.bytedance.safesdk;

import static com.bytedance.safesdk.ByteDance_SafeSdk_Manager.CCTAL_ADMOB_I;
import static com.bytedance.safesdk.ByteDance_SafeSdk_Manager.CCTAL_ADMOB_N;
import static com.bytedance.safesdk.ByteDance_SafeSdk_Manager.CCTAL_app_AppOpenAdStatus;
import static com.bytedance.safesdk.ByteDance_SafeSdk_Manager.CCTAL_app_adShowStatus;
import static com.bytedance.safesdk.ByteDance_SafeSdk_Manager.CCTAL_mysharedpreferences;
import static com.bytedance.safesdk.ByteDance_SafeSdk_Manager.CCTAL_preloadBanner;
import static com.bytedance.safesdk.ByteDance_SafeSdk_Manager.CCTAL_preloadNative;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class ByteDance_SafeSdk_SP extends AppCompatActivity {

    String CCTAL_bytemode = "";
    private Runnable CCTAL_runnable;
    private Handler CCTAL_refreshHandler;
    boolean CCTAL_is_retry;
    public static boolean CCTAL_need_internet = false;
    int CCTAL_addfdsf123;
    String CCTAL_sdfsdf;
    public static InterstitialAd CCTAL_mInterstitialAd6;
    private ByteDance_SafeSdk_Beta CCTAL_manager;
    boolean CCTAL_is_splash_ad_loaded = false;
    CountDownTimer CCTAL_countDownTimer;
    public long CCTAL_secondsRemaining;
    public boolean CCTAL_adAds = true;
    CountDownTimer CCTAL_countDownTimerInterstitial;

    public long CCTAL_secondsRemainingInterstitial;

    ArrayList<String> CCTAL_native_sequence = new ArrayList<String>();
    ArrayList<String> CCTAL_ad_sequence = new ArrayList<String>();
    private Dialog CCTAL_dialog;

    public static ByteDance_SafeSdk_SP CCTAL_splashActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CCTAL_splashActivity = this;
    }

    private String CCTAL_getKeyHash(Activity activity) {

        PackageInfo CCTAL_info;
        try {
            CCTAL_info = activity.getPackageManager().getPackageInfo(activity.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : CCTAL_info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = (Base64.encodeToString(md.digest(), Base64.NO_WRAP));
                return something.replace("+", "*");
            }
        } catch (PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();

        } catch (NoSuchAlgorithmException e) {

        } catch (Exception e) {

        }
        return null;
    }

    public boolean CCTAL_isNetworkAvailable() {
        ConnectivityManager CCTAL_manager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo CCTAL_networkInfo = CCTAL_manager.getActiveNetworkInfo();
        boolean CCTAL_isAvailable = false;
        if (CCTAL_networkInfo != null && CCTAL_networkInfo.isConnected()) {
            CCTAL_isAvailable = true;
        }
        return CCTAL_isAvailable;
    }

    private void CCTAL_createTimer(final ByteDance_SafeSdk_List myCallback1) {
        CCTAL_secondsRemaining = Long.parseLong(ByteDance_SafeSdk_Manager.CCTAL_appOpenTimerSetting);
        CCTAL_countDownTimer = new CountDownTimer(CCTAL_secondsRemaining * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                CCTAL_secondsRemaining = ((millisUntilFinished / 1000) + 1);
            }

            @Override
            public void onFinish() {
                CCTAL_secondsRemaining = 0;
                CCTAL_adAds = false;

                if (ByteDance_SafeSdk_Beta.CCTAL_state_admobAppOpen.equals("Loaded")&& ByteDance_SafeSdk_Manager.creatTimerAppOpenShow.equals("1")) {

                    CCTAL_manager.CCTAL_showAdIfAvailable(new ByteDance_SafeSdk_Beta.CCTAL_SPLASH_ADlistner() {

                        @Override
                        public void CCTAL_onsuccess() {
                            ByteDance_SafeSdk_Beta.CCTAL_isappopen1fail = false;
                            myCallback1.CCTAL_onSuccess();
                        }

                        @Override
                        public void CCTAL_onError(String error) {
                            ByteDance_SafeSdk_Beta.CCTAL_isappopen1fail = true;
                            if (CCTAL_native_sequence.get(1).equals("Interstitial")) {
                                CCTAL_loadAndShowAdmobInterstitialWithDialog(ByteDance_SafeSdk_SP.this, myCallback1);
                            }
                        }
                    });
                } else {
                    ByteDance_SafeSdk_Beta.CCTAL_isappopen1fail = true;
                    myCallback1.CCTAL_onSuccess();
                }

            }
        };
        CCTAL_countDownTimer.start();
    }

    private void CCTAL_createTimerForInterstitial(final ByteDance_SafeSdk_List myCallback1) {
        CCTAL_secondsRemainingInterstitial = 5;
        CCTAL_countDownTimerInterstitial = new CountDownTimer(CCTAL_secondsRemainingInterstitial * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                CCTAL_secondsRemainingInterstitial = ((millisUntilFinished / 1000) + 1);
            }

            @Override
            public void onFinish() {
                CCTAL_secondsRemainingInterstitial = 0;
                ByteDance_SafeSdk_Beta.CCTAL_isappopen1fail = true;
                myCallback1.CCTAL_onSuccess();
            }
        };
        CCTAL_countDownTimerInterstitial.start();
    }


    public void CCTAL_ADSinit(final Activity activity, final int cversion, final ByteDance_SafeSdk_List myCallback1) {
        ByteDance_SafeSdk_Manager.CCTAL_count_banner = -1;
        ByteDance_SafeSdk_Manager.CCTAL_count_native = -1;
        ByteDance_SafeSdk_Manager.CCTAL_count_click = -1;
        ByteDance_SafeSdk_Manager.CCTAL_count_click_for_alt = -1;
        final Dialog CCTAL_dialog = new Dialog(activity);
        CCTAL_dialog.setCancelable(false);
        View view = getLayoutInflater().inflate(R.layout.bytedance_safesdk_cs_again, null);
        CCTAL_dialog.setContentView(view);

        final TextView CCTAL_retry_buttton = view.findViewById(R.id.retry_buttton);

        final SharedPreferences CCTAL_preferences = activity.getSharedPreferences("ad_pref", 0);
        final SharedPreferences.Editor CCTAL_editor_AD_PREF = CCTAL_preferences.edit();

        CCTAL_need_internet = CCTAL_preferences.getBoolean("need_internet", CCTAL_need_internet);

        if (!CCTAL_isNetworkAvailable() && CCTAL_need_internet) {
            CCTAL_is_retry = false;
            CCTAL_dialog.show();
            Window CCTAL_window = CCTAL_dialog.getWindow();
            CCTAL_window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            CCTAL_window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        CCTAL_mysharedpreferences = activity.getSharedPreferences(activity.getPackageName(), Context.MODE_PRIVATE);


        CCTAL_dialog.dismiss();
        CCTAL_refreshHandler = new Handler();
        CCTAL_runnable = new Runnable() {
            @Override
            public void run() {
                if (CCTAL_isNetworkAvailable()) {
                    CCTAL_is_retry = true;
                    CCTAL_retry_buttton.setText(activity.getString(R.string.cidam_retry));
                } else if (CCTAL_need_internet) {
                    CCTAL_dialog.show();
                    CCTAL_is_retry = false;
                    CCTAL_retry_buttton.setText(activity.getString(R.string.cidam_connect_internet));
                }
                CCTAL_refreshHandler.postDelayed(this, 1000);
            }
        };

        CCTAL_refreshHandler.postDelayed(CCTAL_runnable, 1000);

        CCTAL_retry_buttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CCTAL_is_retry) {
                    if (CCTAL_need_internet) {
                        myCallback1.CCTAL_onReload();
                    } else {
                        myCallback1.CCTAL_onSuccess();
                    }
                } else {
                    startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                }
            }
        });


        Calendar CCTAL_calender = Calendar.getInstance();
        CCTAL_calender.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
        SimpleDateFormat CCTAL_df = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        String CCTAL_currentDate = CCTAL_df.format(CCTAL_calender.getTime());
        String CCTAL_status = CCTAL_mysharedpreferences.getString("firsttime", "true");
        final SharedPreferences.Editor editor = CCTAL_mysharedpreferences.edit();
        if (CCTAL_status.equals("true")) {
            editor.putString("date", CCTAL_currentDate).apply();
            editor.putString("firsttime", "false").apply();
            CCTAL_addfdsf123 = 13421;
        } else {
            String date = CCTAL_mysharedpreferences.getString("date", "");
            if (!CCTAL_currentDate.equals(date)) {
                editor.putString("date", CCTAL_currentDate).apply();
                CCTAL_addfdsf123 = 26894;
            } else {
                CCTAL_addfdsf123 = 87332;
            }
        }
        String akbsvl679056 = "B3DA16FF033A8F466C5DDCAF3F6DBAC638D6E34D2BBBF19B6DEF59CC98C6DBAB470DA6B4FB39D05CC9CBC55B22C368541948453ACCFD1E12C332F904B65EBB7E";


        try {
            CCTAL_bytemode = ByteDance_SafeSdk_Proguard.CCTAL_decryptA(activity, akbsvl679056);
            CCTAL_bytemode = CCTAL_bytemode + "/getApp.json";
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (BuildConfig.DEBUG) {
            CCTAL_sdfsdf = "TRSOFTAG12789I";
        } else {
            CCTAL_sdfsdf = "TRSOFTAG82382I";
        }

        RequestQueue CCTAL_requestQueue = Volley.newRequestQueue(activity);
        StringRequest CCTAL_strRequest = new StringRequest(Request.Method.GET, CCTAL_bytemode, new Response.Listener<String>() {
            @Override
            public void onResponse(String response1) {
                try {

                    response1 = CCTAL_decryptRes(activity, response1);
                    JSONObject response = new JSONObject(response1);
                    try {
                        boolean status = response.getBoolean("STATUS");

                        if (status) {
                            String need_in = response.getJSONObject("APP_SETTINGS").getString("app_needInternet");
                            if (need_in.endsWith("1")) {
                                CCTAL_need_internet = true;
                            } else {
                                CCTAL_need_internet = false;
                            }

                            CCTAL_editor_AD_PREF.putBoolean("need_internet", CCTAL_need_internet).apply();
                            CCTAL_editor_AD_PREF.putString("Advertise_List", response.getJSONArray("Advertise_List").toString()).apply();
                            CCTAL_editor_AD_PREF.putString("MORE_APP_SPLASH", response.getJSONArray("MORE_APP_SPLASH").toString()).apply();
                            CCTAL_editor_AD_PREF.putString("MORE_APP_EXIT", response.getJSONArray("MORE_APP_EXIT").toString()).apply();
                            SharedPreferences.Editor editor1 = CCTAL_mysharedpreferences.edit();
                            editor1.putString("response", response.toString());
                            editor1.apply();

                        } else {
//                            Log.e("@@decode", "status = false");
                        }
                    } catch (Exception e) {
//                        Log.e("@@decode", "catch: " + e.getMessage());
                        if (CCTAL_need_internet) {
                            CCTAL_dialog.dismiss();
                            CCTAL_refreshHandler = new Handler();
                            CCTAL_runnable = new Runnable() {
                                @Override
                                public void run() {
                                    if (CCTAL_isNetworkAvailable()) {
                                        CCTAL_is_retry = true;
                                        CCTAL_retry_buttton.setText(activity.getString(R.string.cidam_retry));
                                    } else {
                                        CCTAL_dialog.show();
                                        CCTAL_is_retry = false;
                                        CCTAL_retry_buttton.setText(activity.getString(R.string.cidam_connect_internet));
                                    }
                                    CCTAL_refreshHandler.postDelayed(this, 1000);
                                }
                            };
                        } else {
                            myCallback1.CCTAL_onSuccess();
                        }
                    }

                    ByteDance_SafeSdk_Manager.getInstance(activity).CCTAL_CCTAL_getResponseFromPref(new ByteDance_SafeSdk_List() {
                        @Override
                        public void CCTAL_onSuccess() {

//                            Log.e("@@decode", "pref data get: true");
                            if (CCTAL_app_adShowStatus == 1) {
//                                Log.e("@@decode", "pref data get: ads >> on");
                                CCTAL_displaySplashAd((Activity) activity, myCallback1);
                            } else {
//                                Log.e("@@decode", "pref data get: ads >> off");
                                myCallback1.CCTAL_onSuccess();
                            }

                        }

                        @Override
                        public void CCTAL_onUpdate(String url) {
                            myCallback1.CCTAL_onUpdate(url);
                        }

                        @Override
                        public void CCTAL_onRedirect(String url) {
                            myCallback1.CCTAL_onRedirect(url);
                        }

                        @Override
                        public void CCTAL_onReload() {
                        }

                        @Override
                        public void CCTAL_onGetExtradata(JSONObject extraData) {
                            myCallback1.CCTAL_onGetExtradata(extraData);

                        }
                    }, cversion);

                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Log.e("@@decode", "onErrorResponse: " + error);
                if (CCTAL_isNetworkAvailable()) {
                    ByteDance_SafeSdk_Manager.getInstance(ByteDance_SafeSdk_SP.this).CCTAL_loadInterstitialAd(ByteDance_SafeSdk_SP.this, CCTAL_ADMOB_I[1], "");
                }
                if (CCTAL_need_internet) {
                    CCTAL_dialog.dismiss();
                    CCTAL_refreshHandler = new Handler();
                    CCTAL_runnable = new Runnable() {
                        @Override
                        public void run() {
                            if (CCTAL_isNetworkAvailable()) {
                                CCTAL_is_retry = true;
                                CCTAL_retry_buttton.setText(activity.getString(R.string.cidam_retry));
                            } else {
                                CCTAL_dialog.show();
                                CCTAL_is_retry = false;
                                CCTAL_retry_buttton.setText(activity.getString(R.string.cidam_connect_internet));
                            }
                            CCTAL_refreshHandler.postDelayed(this, 1000);
                        }
                    };
                } else {
                    myCallback1.CCTAL_onSuccess();
                }
            }
        });





//        {
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("PHSUGSG6783019KG", activity.getPackageName());
//                params.put("AFHJNTGDGD563200K", CCTAL_getKeyHash(activity));
//                params.put("DTNHGNH7843DFGHBSA", String.valueOf(CCTAL_addfdsf123));
//                params.put("DBMNBXRY4500991G", CCTAL_sdfsdf);
//                return params;
//            }
//        };

        CCTAL_strRequest.setShouldCache(false);
        CCTAL_requestQueue.add(CCTAL_strRequest);

    }

    public String CCTAL_decryptRes(Activity activity, String data) {
        if (data.contains("APP_SETTINGS")) {
            return data;
        } else {
            try {
                String CCTAL_key = CCTAL_getKeyHash(activity) + activity.getPackageName();
                CCTAL_key = CCTAL_key.substring(0, 16);
                String CCTAL_CIPHER_NAME = "AES/CBC/PKCS5PADDING";
                int CCTAL_CIPHER_KEY_LEN = 16; //128 bits
                if (CCTAL_key.length() < CCTAL_CIPHER_KEY_LEN) {
                    int numPad = CCTAL_CIPHER_KEY_LEN - CCTAL_key.length();

                    for (int i = 0; i < numPad; i++) {
                        CCTAL_key += "0"; //0 pad to len 16 bytes
                    }

                } else if (CCTAL_key.length() > CCTAL_CIPHER_KEY_LEN) {
                    CCTAL_key = CCTAL_key.substring(0, CCTAL_CIPHER_KEY_LEN); //truncate to 16 bytes
                }

                String[] CCTAL_parts = data.split(":");

                IvParameterSpec CCTAL_iv = new IvParameterSpec(Base64.decode(CCTAL_parts[1], Base64.DEFAULT));
                SecretKeySpec CCTAL_skeySpec = new SecretKeySpec(CCTAL_key.getBytes("ISO-8859-1"), "AES");

                Cipher CCTAL_cipher = Cipher.getInstance(CCTAL_CIPHER_NAME);
                CCTAL_cipher.init(Cipher.DECRYPT_MODE, CCTAL_skeySpec, CCTAL_iv);

                byte[] CCTAL_decodedEncryptedData = Base64.decode(CCTAL_parts[0], Base64.DEFAULT);

                byte[] CCTAL_original = CCTAL_cipher.doFinal(CCTAL_decodedEncryptedData);

                return new String(CCTAL_original);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


        return null;
    }

    public void CCTAL_displaySplashAd(Activity activity, final ByteDance_SafeSdk_List myCallback1) {
        try {
            String CCTAL_adPlatformSequence = CCTAL_mysharedpreferences.getString("app_adPlatformSequenceInterstitial", "");
            if (!CCTAL_adPlatformSequence.isEmpty()) {
                String adSequence[] = CCTAL_adPlatformSequence.split(",");
                for (int i = 0; i < adSequence.length; i++) {
                    CCTAL_ad_sequence.add(adSequence[i]);
                }
            }

            if (CCTAL_app_AppOpenAdStatus) {
                if (CCTAL_ad_sequence.get(0).equals("Admob")) {

                    CCTAL_showAdMobSplashAd((Activity) activity, myCallback1);
                } else if (CCTAL_ad_sequence.get(0).equals("MyCustomAds")) {

                    ByteDance_SafeSdk_Manager.getInstance(ByteDance_SafeSdk_SP.this).CCTAL_showCustomAppOpenAd(ByteDance_SafeSdk_SP.this, new ByteDance_SafeSdk_Callback() {
                        @RequiresApi(api = Build.VERSION_CODES.M)
                        @Override
                        public void CCTAL_callbackCall() {
                            myCallback1.CCTAL_onSuccess();
                        }
                    });
                } else if (CCTAL_ad_sequence.get(0).equals("Facebookaudiencenetwork")) {

                    myCallback1.CCTAL_onSuccess();
                } else {

                    myCallback1.CCTAL_onSuccess();
                }
            } else {

                myCallback1.CCTAL_onSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CCTAL_showAdMobSplashAd(Activity activity, final ByteDance_SafeSdk_List myCallback1) {
        String appSplashAdType = CCTAL_mysharedpreferences.getString("appSplashAdType", "");
        String app_open_id = CCTAL_mysharedpreferences.getString("AppOpenID1", "");

        if (!appSplashAdType.isEmpty()) {
            String adSequence[] = appSplashAdType.split(",");
            for (int i = 0; i < adSequence.length; i++) {
                CCTAL_native_sequence.add(adSequence[i]);
            }
        }
        ByteDance_SafeSdk_Manager.getInstance(ByteDance_SafeSdk_SP.this).CCTAL_loadInterstitialAd(ByteDance_SafeSdk_SP.this, CCTAL_ADMOB_I[1], "");
        if (CCTAL_preloadNative.equals("1")) {
            ByteDance_SafeSdk_Manager.getInstance(ByteDance_SafeSdk_SP.this).CCTAL_preload_native(CCTAL_ADMOB_N[1]);
        }
        if (CCTAL_preloadBanner.equals("1")) {
            if (ByteDance_SafeSdk_Manager.CCTAL_showNativeBannerAd.equals("1")) {
                ByteDance_SafeSdk_Manager.getInstance(ByteDance_SafeSdk_SP.this).CCTAL_preload_native_banner();
            } else {
                ByteDance_SafeSdk_Manager.getInstance(ByteDance_SafeSdk_SP.this).CCTAL_preLoadBanner("ADMOB");
            }
        }
        if (CCTAL_native_sequence.get(0).equals("AppOpen") && !app_open_id.isEmpty()) {
            if (CCTAL_native_sequence.size() != 0) {
                CCTAL_loadAndShowAppOpenAd(activity, myCallback1);
            } else {
                myCallback1.CCTAL_onSuccess();
            }
        } else if (CCTAL_native_sequence.get(0).equals("Interstitial")) {
            CCTAL_loadAndShowAdmobInterstitialWithDialog(ByteDance_SafeSdk_SP.this, myCallback1);
        } else {
            if (CCTAL_countDownTimer != null) {
                CCTAL_countDownTimer.cancel();
            }
            myCallback1.CCTAL_onSuccess();
        }

    }

    public void CCTAL_loadAndShowAppOpenAd(final Activity activity, final ByteDance_SafeSdk_List myCallback1) {

        CCTAL_manager = new ByteDance_SafeSdk_Beta();
        CCTAL_createTimer(myCallback1);
        CCTAL_manager.CCTAL_fetchAd(new ByteDance_SafeSdk_Beta.CCTAL_SPLASH_ADlistner() {

            @Override
            public void CCTAL_onsuccess() {
                CCTAL_is_splash_ad_loaded = true;
                if (CCTAL_countDownTimer != null) {
                    CCTAL_countDownTimer.cancel();
                }

                if (CCTAL_adAds) {
                    CCTAL_manager.CCTAL_showAdIfAvailable(new ByteDance_SafeSdk_Beta.CCTAL_SPLASH_ADlistner() {

                        @Override
                        public void CCTAL_onsuccess() {
                            ByteDance_SafeSdk_Beta.CCTAL_isappopen1fail = false;
                            myCallback1.CCTAL_onSuccess();
                        }

                        @Override
                        public void CCTAL_onError(String error) {
                            ByteDance_SafeSdk_Beta.CCTAL_isappopen1fail = true;
                            if (CCTAL_native_sequence.get(1).equals("Interstitial")) {
                                ByteDance_SafeSdk_Beta.CCTAL_isappopen1fail = false;
                                    CCTAL_loadAndShowAdmobInterstitialWithDialog(ByteDance_SafeSdk_SP.this, myCallback1);
                            }
                            myCallback1.CCTAL_onSuccess();
                        }
                    });

                }
            }

            @Override
            public void CCTAL_onError(String error) {
                Log.e("@@decode", "onError");
                if (CCTAL_countDownTimer != null) {
                    Log.e("@@decode", "001");
                    CCTAL_countDownTimer.cancel();

                    //todo: new added..
                    ByteDance_SafeSdk_Beta.CCTAL_isappopen1fail = true;
                    myCallback1.CCTAL_onSuccess();
                }
                if (CCTAL_native_sequence.get(1).equals("Interstitial")) {
                    Log.e("@@decode", "ad show===");
                    CCTAL_loadAndShowAdmobInterstitialWithDialog(ByteDance_SafeSdk_SP.this, myCallback1);
                } else {
                    Log.e("@@decode", "002");
                    ByteDance_SafeSdk_Beta.CCTAL_isappopen1fail = true;
                    myCallback1.CCTAL_onSuccess();
                }
            }
        });

    }

    public void CCTAL_loadAndShowAdmobInterstitialWithDialog(final Activity activity, final ByteDance_SafeSdk_List myCallback1) {
        if (ByteDance_SafeSdk_Manager.CCTAL_mInterstitialAd != null) {
            ByteDance_SafeSdk_Manager.getInstance(ByteDance_SafeSdk_SP.this).CCTAL_showInterstitialAd(R.mipmap.ad_ic_launcher, ByteDance_SafeSdk_SP.this, new ByteDance_SafeSdk_Callback() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                public void CCTAL_callbackCall() {
                    myCallback1.CCTAL_onSuccess();
                }
            });
        } else {

            CCTAL_createTimerForInterstitial(myCallback1);
            final Dialog CCTAL_dialog1 = new Dialog(activity, R.style.cidam_AppAlertDialog);
            View CCTAL_view1 = LayoutInflater.from(activity).inflate(R.layout.bytedance_safesdk_progress, null);
            CCTAL_dialog1.setContentView(CCTAL_view1);
            CCTAL_dialog1.setCancelable(false);
            Window CCTAL_window1 = CCTAL_dialog1.getWindow();
            CCTAL_window1.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            CCTAL_dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            if (!CCTAL_dialog1.isShowing()) {
                CCTAL_dialog1.show();
            }

            AdRequest CCTAL_adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, CCTAL_ADMOB_I[1], CCTAL_adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                    if (CCTAL_countDownTimerInterstitial != null) {
                        CCTAL_countDownTimerInterstitial.cancel();
                    }
                    CCTAL_mInterstitialAd6 = interstitialAd;
                    if (CCTAL_dialog1 != null && CCTAL_dialog1.isShowing()) {
                        CCTAL_dialog1.dismiss();
                    }
                    CCTAL_mInterstitialAd6.show(activity);
                    CCTAL_mInterstitialAd6.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            ByteDance_SafeSdk_Beta.CCTAL_isappopen1fail = false;
                            myCallback1.CCTAL_onSuccess();
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                            ByteDance_SafeSdk_Beta.CCTAL_isappopen1fail = true;
                            ByteDance_SafeSdk_Manager.getInstance(ByteDance_SafeSdk_SP.this).CCTAL_loadInterstitialAd(ByteDance_SafeSdk_SP.this, CCTAL_ADMOB_I[1], "");
                            myCallback1.CCTAL_onSuccess();

                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            CCTAL_mInterstitialAd6 = null;
                            ByteDance_SafeSdk_Beta.CCTAL_isappopen1fail = false;
                            ByteDance_SafeSdk_Manager.getInstance(ByteDance_SafeSdk_SP.this).CCTAL_loadInterstitialAd(ByteDance_SafeSdk_SP.this, CCTAL_ADMOB_I[1], "");
                        }
                    });
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    if (CCTAL_dialog1 != null && CCTAL_dialog1.isShowing()) {
                        CCTAL_dialog1.dismiss();
                    }
                    if (CCTAL_countDownTimerInterstitial != null) {
                        CCTAL_countDownTimerInterstitial.cancel();
                    }
                    CCTAL_mInterstitialAd6 = null;
                    ByteDance_SafeSdk_Beta.CCTAL_isappopen1fail = true;
                    ByteDance_SafeSdk_Manager.getInstance(ByteDance_SafeSdk_SP.this).CCTAL_loadInterstitialAd(ByteDance_SafeSdk_SP.this, CCTAL_ADMOB_I[1], "");
                    myCallback1.CCTAL_onSuccess();


                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CCTAL_refreshHandler.removeCallbacks(CCTAL_runnable);
    }

    public String CCTAL_getLatestRedirectUrl(final Activity activity) {
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(activity, R.style.cidam_AdDialogStyle);
        progressDialog.setMessage("Please wait data retriving..");
        progressDialog.setCancelable(false);
        progressDialog.show();
        final String[] app_newPackageName = {""};
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        StringRequest strRequest = new StringRequest(Request.Method.POST, CCTAL_bytemode, new Response.Listener<String>() {
            @Override
            public void onResponse(String response1) {
                try {
                    JSONObject response = new JSONObject(response1);
                    boolean status = response.getBoolean("STATUS");
                    if (status == true) {
                        if (!response.toString().isEmpty()) {
                            try {
                                JSONObject settingsJsonObject = response.getJSONObject("APP_SETTINGS");
                                try {
                                    app_newPackageName[0] = settingsJsonObject.getString("app_newPackageName");
                                } catch (Exception e) {
                                    app_newPackageName[0] = "";
                                }
                                CCTAL_mysharedpreferences.edit().putString("app_newPackageName", app_newPackageName[0]).commit();

                                Uri marketUri = Uri.parse(app_newPackageName[0]);
                                Intent marketIntent = new Intent(Intent.ACTION_VIEW, marketUri);
                                startActivity(marketIntent);
                                progressDialog.dismiss();
                            } catch (Exception e) {
                                progressDialog.dismiss();
                            }
                        }
                    }
                } catch (Exception e) {
                    progressDialog.dismiss();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        progressDialog.dismiss();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("PHSUGSG6783019KG", activity.getPackageName());
                params.put("AFHJNTGDGD563200K", "kGyfud5V2VM5FaZKypqV69LyQco=");
                params.put("DTNHGNH7843DFGHBSA", String.valueOf(CCTAL_addfdsf123));
                params.put("DBMNBXRY4500991G", CCTAL_sdfsdf);
                return params;
            }
        };

        strRequest.setShouldCache(false);
        requestQueue.add(strRequest);
        return app_newPackageName[0];
    }

}