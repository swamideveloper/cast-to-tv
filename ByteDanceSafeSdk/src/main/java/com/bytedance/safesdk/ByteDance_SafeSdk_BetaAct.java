package com.bytedance.safesdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ByteDance_SafeSdk_BetaAct extends AppCompatActivity {
    public static ByteDance_SafeSdk_Pojo CCTALCustomAdModel;
    public static Activity CCTAL_activity;
    public static ByteDance_SafeSdk_Callback CCTALMyCallback;
    private TextView CCTAL_txt_title;
    private TextView CCTAL_txt_context;
    private TextView CCTAL_txt_download;
    private LinearLayout CCTAL_ll_continue_app;
    private ImageView CCTAL_iv_myapp_logo;
    private ImageView CCTAL_media_view;
    private ImageView CCTAL_iv_ad_icon;
    private TextView CCTAL_btn_call_to_action;
    RatingBar CCTAL_ad_stars;
    TextView CCTAL_txt_rate;

    public SharedPreferences CCTAL_mysharedpreferences;
    private TextView CCTAL_txt_myapp_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (CCTALCustomAdModel != null) {
            if (CCTALCustomAdModel.getCCTAL_app_packageName().contains("http")) {
                setContentView(R.layout.bytedance_safesdk_cus_beta_q);
            } else {
                setContentView(R.layout.bytedance_safesdk_c_beta);

            }
        }
        if (CCTALCustomAdModel != null) {

            CCTAL_ll_continue_app = findViewById(R.id.ll_continue_app);
            CCTAL_iv_myapp_logo = findViewById(R.id.iv_myapp_logo);
            CCTAL_txt_myapp_name = findViewById(R.id.txt_myapp_name);
            CCTAL_media_view = (ImageView) findViewById(R.id.media_view);
            CCTAL_txt_title = (TextView) findViewById(R.id.txt_appname);
            CCTAL_iv_ad_icon = findViewById(R.id.iv_ad_icon);
            CCTAL_ad_stars = findViewById(R.id.ad_stars);
            CCTAL_txt_rate = findViewById(R.id.txt_rate);
            CCTAL_txt_download = (TextView) findViewById(R.id.txt_download);
            CCTAL_txt_context = (TextView) findViewById(R.id.txt_context);
            CCTAL_btn_call_to_action = findViewById(R.id.btn_call_to_action);
            CCTAL_mysharedpreferences = getSharedPreferences(CCTAL_activity.getPackageName(), Context.MODE_PRIVATE);
            CCTAL_txt_myapp_name.setText(CCTAL_mysharedpreferences.getString("app_name", ""));

            if (!CCTAL_mysharedpreferences.getString("app_logo", "").isEmpty()) {
                Glide
                        .with(this)
                        .load(CCTAL_mysharedpreferences.getString("app_logo", ""))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into((ImageView) findViewById(R.id.iv_myapp_logo));
            }

            Glide
                    .with(this)
                    .load(CCTALCustomAdModel.getCCTAL_app_banner())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(CCTAL_media_view);

            CCTAL_txt_title.setText(CCTALCustomAdModel.getCCTAL_app_name().split("/")[0]);
            CCTAL_txt_context.setText(CCTALCustomAdModel.getCCTAL_app_shortDecription());
            CCTAL_txt_download.setText(CCTALCustomAdModel.getCCTAL_app_download());
            CCTAL_ad_stars.setRating(Float.parseFloat(CCTALCustomAdModel.getCCTAL_app_rating()));
            CCTAL_txt_rate.setText(CCTALCustomAdModel.getCCTAL_app_rating());

            Glide
                    .with(this)
                    .load(CCTALCustomAdModel.getCCTAL_app_logo())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(CCTAL_iv_ad_icon);

            if (CCTALCustomAdModel.getCCTAL_app_packageName().contains("http")) {
                CCTAL_txt_title.setText("Play & Win Coins Daily.");
                CCTAL_btn_call_to_action.setText("Play Now");
            } else {
                CCTAL_btn_call_to_action.setText("Install");

            }

            CCTAL_btn_call_to_action.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String action_str = CCTALCustomAdModel.getCCTAL_app_packageName();
                    if (action_str.contains("http")) {
                        ByteDance_SafeSdk_Universal.CCTAL_openChromeCustomTabUrl(ByteDance_SafeSdk_BetaAct.this, CCTALCustomAdModel.getCCTAL_app_packageName());
                    } else {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + action_str)));
                    }
                }
            });


            CCTAL_ll_continue_app.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CCTAL_closeAd();
                }
            });
            ByteDance_SafeSdk_Manager.CCTAL_count_custAppOpenAd++;
        } else {
            CCTAL_closeAd();
        }
    }

    private void CCTAL_closeAd() {
        finish();
        if (CCTALMyCallback != null) {
            CCTALMyCallback.CCTAL_callbackCall();
            CCTALMyCallback = null;
        }
    }

    @Override
    public void onBackPressed() {

    }

    public static void CCTAL_newIntent(Activity activit, ByteDance_SafeSdk_Callback Callback, ByteDance_SafeSdk_Pojo AdModel) {
        CCTAL_activity = activit;
        CCTALCustomAdModel = AdModel;
        CCTALMyCallback = Callback;
        CCTAL_activity.startActivity(new Intent(CCTAL_activity, ByteDance_SafeSdk_BetaAct.class));
    }
}