package com.bytedance.safesdk;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ByteDance_SafeSdk_My extends AppCompatActivity {
    private ImageView CCTAL_ad_media_view;
    private RelativeLayout CCTAL_int_bg;
    private TextView CCTAL_txt_title;
    private TextView CCTAL_txt_body;
    private TextView CCTAL_txt_rate;
    private TextView CCTAL_txt_download;
    public static ByteDance_SafeSdk_Pojo CCTALCustomAdModel;
    public static ByteDance_SafeSdk_Callback CCTALMyCallback;
    private TextView CCTAL_native_ad_call_to_action;
    private RatingBar CCTAL_ad_stars;
    private LinearLayout CCTAL_adPersonalCloseBtn;
    public static int CCTAL_random = 0;
    private LinearLayout CCTAL_llPersonalAd, CCTAL_llPersonalAdCenter;
    private LinearLayout CCTAL_userCount, CCTAL_adPersonalLlPlayStore;
    private TextView CCTAL_querkaText;
    private String CCTAL_action_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (CCTAL_random == 2) {
            setContentView(R.layout.bytedance_safesdk_cs_i2);
        } else if (CCTAL_random == 1) {
            setContentView(R.layout.bytedance_safesdk_cs_i1);
        } else {
            setContentView(R.layout.bytedance_safesdk_cs_i0);
        }

        CCTAL_llPersonalAd = (LinearLayout) findViewById(R.id.llPersonalAd);
        CCTAL_llPersonalAdCenter = (LinearLayout) findViewById(R.id.llPersonalAdCenter);

        if (CCTALCustomAdModel != null) {
            try {
                CCTAL_ad_media_view = (ImageView) findViewById(R.id.native_ad_media);
                CCTAL_txt_title = (TextView) findViewById(R.id.native_ad_title);
                CCTAL_txt_body = (TextView) findViewById(R.id.native_ad_social_context);
                CCTAL_txt_rate = (TextView) findViewById(R.id.txt_rate);
                CCTAL_txt_download = (TextView) findViewById(R.id.txt_download);
                CCTAL_native_ad_call_to_action = (TextView) findViewById(R.id.native_ad_call_to_action);
                CCTAL_adPersonalCloseBtn = (LinearLayout) findViewById(R.id.adPersonalCloseBtn);
                CCTAL_userCount = (LinearLayout) findViewById(R.id.userCount);
                CCTAL_adPersonalLlPlayStore = (LinearLayout) findViewById(R.id.adPersonalLlPlayStore);
                CCTAL_querkaText = (TextView) findViewById(R.id.querkaText);
                CCTAL_ad_stars = (RatingBar) findViewById(R.id.ad_stars);
                CCTAL_int_bg = findViewById(R.id.int_bg);
                try {
                    Glide.with(this)
                            .load(CCTALCustomAdModel.getCCTAL_app_logo())
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into((ImageView) findViewById(R.id.native_ad_icon));


                    Glide.with(this)
                            .load(CCTALCustomAdModel.getCCTAL_app_banner())
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(CCTAL_ad_media_view);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                CCTAL_txt_title.setText(CCTALCustomAdModel.getCCTAL_app_name().split("/")[0]);
                CCTAL_txt_body.setText(CCTALCustomAdModel.getCCTAL_app_shortDecription());
                CCTAL_txt_rate.setText(CCTALCustomAdModel.getCCTAL_app_rating());
                CCTAL_ad_stars.setRating(Float.parseFloat(CCTALCustomAdModel.getCCTAL_app_rating()));
                CCTAL_txt_download.setText(CCTALCustomAdModel.getCCTAL_app_download());


                CCTAL_action_str = CCTALCustomAdModel.getCCTAL_app_packageName();
                if (CCTAL_action_str.contains("http")) {
                    CCTAL_userCount.setVisibility(View.GONE);

                    CCTAL_adPersonalCloseBtn.setVisibility(View.GONE);
                    CCTAL_adPersonalLlPlayStore.setVisibility(View.GONE);
                    if (CCTAL_random == 1) {
                        CCTAL_native_ad_call_to_action.setText("Play Game");
                    } else {
                        CCTAL_native_ad_call_to_action.setText("Play Now");
                    }

                } else {
                    CCTAL_userCount.setVisibility(View.VISIBLE);

                    CCTAL_adPersonalCloseBtn.setVisibility(View.VISIBLE);
                    CCTAL_adPersonalLlPlayStore.setVisibility(View.VISIBLE);
                    if (CCTAL_random == 1) {
                        CCTAL_native_ad_call_to_action.setText("Install");
                    } else {
                        CCTAL_native_ad_call_to_action.setText("Download");
                    }
                }
                if (CCTAL_random == 2) {
                    CCTAL_random = 0;
                    CCTAL_SlideToAbove30(findViewById(R.id.llcus3), 2000);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            CCTAL_FadeIn(findViewById(R.id.llPersonalAd));
                            CCTAL_FadeIn(findViewById(R.id.main));
                            CCTAL_FadeIn(findViewById(R.id.aa));
                            CCTAL_action_str = CCTALCustomAdModel.getCCTAL_app_packageName();
                            if (CCTAL_action_str.contains("http")) {
                                CCTAL_FadeIn(findViewById(R.id.querkaText));
                            } else {
                                CCTAL_FadeIn(findViewById(R.id.adPersonalLlPlayStore));
                            }

                            CCTAL_FadeIn(findViewById(R.id.adPersonalLlCloseInstallBtns));
                        }
                    }, 1000);
                } else if (CCTAL_random == 1) {
                    CCTAL_random++;
                    CCTAL_SlideToAbove20(findViewById(R.id.native_ad_icon), 2000);
                    CCTAL_SlideToAbove30(findViewById(R.id.cvTopAd), 2000);


                    CCTAL_action_str = CCTALCustomAdModel.getCCTAL_app_packageName();
                    if (CCTAL_action_str.contains("http")) {
                        findViewById(R.id.querkaText).setVisibility(View.VISIBLE);
                    } else {
                        findViewById(R.id.querkaText).setVisibility(View.GONE);
                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            CCTAL_FadeIn(findViewById(R.id.aa));
                            CCTAL_FadeIn(findViewById(R.id.adPersonalLlCloseInstallBtnsCenter));
                        }
                    }, 2200);
                } else {
                    CCTAL_random++;
                    CCTAL_SlideToTop(findViewById(R.id.native_ad_icon), 1000);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            CCTAL_SlideToAbove(findViewById(R.id.native_ad_title), 600);
                            CCTAL_SlideToAbove(findViewById(R.id.banner), 1000);
                            CCTAL_SlideToAbove(findViewById(R.id.native_ad_social_context), 1200);
                            CCTAL_action_str = CCTALCustomAdModel.getCCTAL_app_packageName();
                            if (CCTAL_action_str.contains("http")) {
                                CCTAL_SlideToAbove(findViewById(R.id.querkaText), 900);
                            } else {
                                CCTAL_SlideToAbove(findViewById(R.id.userCount), 800);
                                CCTAL_SlideToAbove(findViewById(R.id.adPersonalLlPlayStore), 1400);
                            }
                            CCTAL_SlideToAbove(findViewById(R.id.adPersonalLlCloseInstallBtns), 1600);
                        }
                    }, 800);


                }

                findViewById(R.id.native_ad_call_to_action).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {

                        CCTAL_action_str = CCTALCustomAdModel.getCCTAL_app_packageName();

                        if (CCTAL_action_str.contains("http")) {

                            ByteDance_SafeSdk_Universal.CCTAL_openChromeCustomTabUrl(ByteDance_SafeSdk_My.this, CCTALCustomAdModel.getCCTAL_app_packageName());

                        } else {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + CCTAL_action_str)));

                        }
                    }
                });

                findViewById(R.id.ImgClose).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        CCTAL_closeAd();
                    }
                });
                CCTAL_adPersonalCloseBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        CCTAL_closeAd();
                    }
                });


                ByteDance_SafeSdk_Manager.CCTAL_count_custIntAd++;
            } catch (Exception e) {
                CCTAL_closeAd();
            }
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

    public void CCTAL_SlideToAbove(final View view, int time) {
        Animation slide = null;
        slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                5.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        slide.setDuration(time);
        slide.setFillAfter(true);
        slide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        slide.setFillEnabled(true);
        view.startAnimation(slide);
    }

    public void CCTAL_SlideToAbove30(final View view, int time) {
        Animation slide = null;
        slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.5f, Animation.RELATIVE_TO_SELF, 0.0f);
        slide.setDuration(time);
        slide.setFillAfter(true);
        slide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        slide.setFillEnabled(true);
        view.startAnimation(slide);
    }

    public void CCTAL_SlideToAbove20(final View view, int time) {
        Animation zoomin = AnimationUtils.loadAnimation(this, R.anim.cidam_zoom_in);
        zoomin.setFillAfter(true);
        view.startAnimation(zoomin);

        Animation slide = null;
        slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.5f, Animation.RELATIVE_TO_SELF, 0.0f);
        slide.setDuration(time);
        slide.setFillAfter(true);
        slide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation animZoomin = AnimationUtils.loadAnimation(ByteDance_SafeSdk_My.this, R.anim.cidam_zoom_out);
                animZoomin.setFillAfter(true);
                view.startAnimation(animZoomin);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        slide.setFillEnabled(true);
        view.startAnimation(slide);
    }

    public void CCTAL_SlideToTop(final View view, int time) {
        Animation slide = null;
        slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -2.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        slide.setDuration(time);
        slide.setFillAfter(true);
        slide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        slide.setFillEnabled(true);
        view.startAnimation(slide);
    }

    public void CCTAL_FadeIn(final View view) {
        Animation aniFade = AnimationUtils.loadAnimation(this, R.anim.cidam_fade_in);
        view.startAnimation(aniFade);
        aniFade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    public static void CCTAL_newIntent(Activity activity, ByteDance_SafeSdk_Callback Callback, ByteDance_SafeSdk_Pojo AdModel) {
        CCTALCustomAdModel = AdModel;
        CCTALMyCallback = Callback;
        activity.startActivity(new Intent(activity, ByteDance_SafeSdk_My.class));
    }
}