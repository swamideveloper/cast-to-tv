package kapil.cast.video.screenmirroring.smarttv.kapil_developer_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.monstertechno.adblocker.AdBlockerWebView;
import com.monstertechno.adblocker.util.AdBlocker;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import at.huber.youtubeExtractor.VideoMeta;
import at.huber.youtubeExtractor.YouTubeExtractor;
import at.huber.youtubeExtractor.YtFile;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cc.kapil_developer_md_yt;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_dtum;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_dis;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_ref_dlg;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_ref_listner;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_listner;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_even_show;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_tv_connect;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Inter;

public class kapil_developer_yt extends AppCompatActivity {
    public static Boolean refreshWebview = Boolean.FALSE;
    kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_yt kapildeveloperyt;
    ImageView webBack,refreshPage,listEnable,webNext,homeWeb,castscreen,back;
    WebView webView;
    String youtubeLink = "https://www.youtube.com/";
    LinearProgressIndicator progressLInear;
    YouTubeExtractor youTubeExtractor;
    int currentPos = 0;
    ArrayList<kapil_developer_md_yt> kapildevelopermdyts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_yt_screen);
        kapil_developer_Inter.inter(this);
        EventBus.getDefault().register(this);
        back = findViewById(R.id.back);
        castscreen = findViewById(R.id.castscreen);
        webView = findViewById(R.id.webView);
        listEnable = findViewById(R.id.listEnable);
        webBack = findViewById(R.id.webBack);
        webNext = findViewById(R.id.webNext);
        homeWeb = findViewById(R.id.homeWeb);
        refreshPage = findViewById(R.id.refreshPage);
        progressLInear = findViewById(R.id.progressLInear);


        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressLInear.setVisibility(View.VISIBLE);
                progressLInear.setProgress(newProgress);
                if (newProgress == 100) {
                    progressLInear.setVisibility(View.GONE);
                }
                Log.e("YOUTUBETAG", "setWebChromeClient");
                super.onProgressChanged(view, newProgress);
            }
        });
        new AdBlockerWebView.init(this).initializeWebView(this.webView);
        webView.setWebViewClient(new WebViewClient() {
            public String currentPage;

            {
                currentPage = webView.getUrl();
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String request) {
                return AdBlockerWebView.blockAds(view, request) ? AdBlocker.createEmptyResource() : super.shouldInterceptRequest(view, request);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (!str.startsWith("intent")) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                if (!webResourceRequest.getUrl().toString().startsWith("intent")) {
                    return super.shouldOverrideUrlLoading(webView, webResourceRequest);
                }
                return true;
            }

            @Override
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }

            @Override
            public void onLoadResource(WebView view, String str) {
                String url = view.getUrl();
                if ((url.equals(currentPage) || url.contains("#searching")) && !refreshWebview.booleanValue()) {
                    return;
                }
                refreshWebview = Boolean.FALSE;
                currentPage = url;
                kapildevelopermdyts.clear();
                listEnable.setImageResource(R.drawable.not_compelete);
                updateUIBackForward();
                if (this.currentPage.contains("https://m.youtube.com/watch?v=")) {
                    String replace = url.replace("https://m.youtube.com/watch?v=", "");
                    youTubeExtractor = new YouTubeExtractor(kapil_developer_yt.this) {
                        @Override
                        protected void onExtractionComplete(SparseArray<YtFile> sparseArray, VideoMeta videoMeta) {
                            if (sparseArray == null) {
                                Log.e("###TAG", "sparseArray: NULL");
                                return;
                            }
                            Log.e("###TAG", "onExtractionComplete: Here");
                            for (Integer num = 0; num.intValue() < sparseArray.size(); num = Integer.valueOf(num.intValue() + 1)) {
                                YtFile ytFile = sparseArray.get(Integer.valueOf(sparseArray.keyAt(num.intValue())).intValue());
                                StringBuilder sb = new StringBuilder();
                                sb.append("URL: ");
                                sb.append(ytFile.getUrl());
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("getHeight: ");
                                sb2.append(ytFile.getFormat().getHeight());
                                if ((ytFile.getFormat().getExt().equals("mp4") || ytFile.getFormat().getExt().equals("m3u") || ytFile.getFormat().getExt().equals("m3u8")) && ((ytFile.getFormat().getHeight() == 144 || ytFile.getFormat().getHeight() == 360 || ytFile.getFormat().getHeight() == 240 || ytFile.getFormat().getHeight() == 720 || ytFile.getFormat().getHeight() == 1080 || ytFile.getFormat().getHeight() == 480) && ytFile.getFormat().getAudioBitrate() != -1)) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("URL: ");
                                    sb3.append(ytFile.getUrl());
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("AUDIO: ");
                                    sb4.append(ytFile.getFormat().getAudioBitrate());
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("AUDIO SS: ");
                                    sb5.append(ytFile.getFormat().getAudioCodec());
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("getHeight: ");
                                    sb6.append(ytFile.getFormat().getHeight());
                                    ArrayList<kapil_developer_md_yt> arrayList = kapildevelopermdyts;
                                    String title = videoMeta.getTitle();
                                    String hqImageUrl = videoMeta.getHqImageUrl();
                                    String url2 = ytFile.getUrl();
                                    Log.e("###TAG", "url2: " + url2.toString());
                                    arrayList.add(new kapil_developer_md_yt(title, hqImageUrl, url2, ytFile.getFormat().getHeight() + "p", "mp4", videoMeta.getVideoLength()));
                                }
                                Log.e("###TAG", "sb: " + sb.toString());
                            }
                            NewSetdateList();
                        }


                        @Override
                        public void onProgressUpdate(Void... voidArr) {
                            super.onProgressUpdate(voidArr);
                        }

                        @Override
                        protected void onCancelled() {
                            super.onCancelled();
                        }


                        @Override
                        public void onCancelled(SparseArray<YtFile> sparseArray) {
                            super.onCancelled(sparseArray);
                        }
                    };
                    youTubeExtractor.extract("http://youtube.com/watch?v=" + replace);
                }
                super.onLoadResource(view, url);
            }
        });
        webView.loadUrl(youtubeLink);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        webBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView webView = kapil_developer_yt.this.webView;
                if (!webView.canGoBack()) {
                    return;
                }
                webView.goBack();
            }
        });
        webNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView webView2 = webView;
                if (webView2.canGoForward()) {
                    return;
                }
                webView2.goForward();
            }
        });
        homeWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(youtubeLink);

            }
        });
        listEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kapildevelopermdyts.isEmpty()) {
                    new kapil_developer_ref_dlg(kapil_developer_yt.this, new kapil_developer_if_ref_listner() {
                        @Override
                        public void onClick() {
                            refreshWebview = Boolean.TRUE;
                            webView.reload();

                        }
                    }).show();
                    return;
                }
                kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_yt kapildeveloperyt = kapil_developer_yt.this.kapildeveloperyt;
                if (kapildeveloperyt == null || kapildeveloperyt.isAdded()) {
                    return;
                }
                kapil_developer_yt.this.kapildeveloperyt.show(getSupportFragmentManager(), "YoutubeBrowserActivity");

            }
        });
        refreshPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshWebview = Boolean.TRUE;
                webView.reload();
            }
        });
        progressLInear.setMax(100);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
            this.castscreen.setImageResource(R.drawable.cast_connect);
        } else {
            this.castscreen.setImageResource(R.drawable.cast_main);
        }
        castscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
                    new kapil_developer_dis(kapil_developer_yt.this).show();
                } else {
                    startActivity(new Intent(kapil_developer_yt.this, kapil_developer_cd.class));
                }
            }
        });
        webNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void updateUIBackForward() {
        webBack.setImageResource(this.webView.canGoBack() ? R.drawable.back_button : R.drawable.back_button1);
        webNext.setImageResource(this.webView.canGoBack() ? R.drawable.next_button1 : R.drawable.next_button);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(kapil_developer_md_even_show kapildevelopermdevenshow) {
        if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
            castscreen.setImageResource(R.drawable.cast_connect);
        } else {
            castscreen.setImageResource(R.drawable.cast_main);
        }
    }

    public void NewSetdateList() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    kapil_developer_yt.this.kapildeveloperyt = kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_yt.getInstance();
                    kapildeveloperyt.setListener(new kapil_developer_if_listner() {
                        @Override
                        public void onClick(int i) {
                            currentPos = i;
                            if (!kapil_developer_ut_tv_connect.getInstance().isConnect()) {
                                startActivity(new Intent(kapil_developer_yt.this, kapil_developer_cd.class));
                            } else {
                                StartMPlayerActivity();
                            }
                        }
                    });
                    kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_yt youtubeCastStartDialoge = kapil_developer_yt.this.kapildeveloperyt;
                    if (youtubeCastStartDialoge != null && !youtubeCastStartDialoge.isAdded()) {
                        kapil_developer_yt kapildeveloperyt = kapil_developer_yt.this;
                        kapildeveloperyt.kapildeveloperyt.show(kapildeveloperyt.getSupportFragmentManager(), "YoutubeBrowserActivity");
                        kapil_developer_yt apptubeCromeActivity2 = kapil_developer_yt.this;
                        apptubeCromeActivity2.kapildeveloperyt.setData(apptubeCromeActivity2.kapildevelopermdyts);
                    }
                    listEnable.setImageResource(kapildevelopermdyts.isEmpty() ? R.drawable.not_compelete : R.drawable.tv_compelete);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void StartMPlayerActivity() {
        kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_yt kapildeveloperyt = this.kapildeveloperyt;
        if (kapildeveloperyt != null && kapildeveloperyt.isAdded()) {
            this.kapildeveloperyt.dismiss();
        }
        if (this.kapildevelopermdyts.size() <= 0 || this.kapildevelopermdyts.size() <= this.currentPos) {
            return;
        }
        Intent intent = new Intent(this, kapil_developer_remote.class);
        kapil_developer_dtum.getInstance().nameCrome = this.kapildevelopermdyts.get(this.currentPos).getVideoNames();
        kapil_developer_dtum.getInstance().videoPathCrome = this.kapildevelopermdyts.get(this.currentPos).getVideoLink();
        kapil_developer_dtum.getInstance().setType(3);
        kapil_developer_dtum.getInstance().thumbnailCrome = this.kapildevelopermdyts.get(this.currentPos).getThubnails();
        kapil_developer_dtum.getInstance().timeDuration = Long.valueOf(this.kapildevelopermdyts.get(this.currentPos).getTimes() * 1000);
        kapil_developer_dtum.getInstance().setPosition(0);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        kapil_developer_Inter.back(this);
    }
}