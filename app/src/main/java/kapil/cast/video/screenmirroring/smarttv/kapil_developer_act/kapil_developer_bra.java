package kapil.cast.video.screenmirroring.smarttv.kapil_developer_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.anthonycr.progress.AnimatedProgressBar;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jsoup.Jsoup;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import cn.pedant.SweetAlert.SweetAlertDialog;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_adp.kapil_developer_serch_auto;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_serach_view;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_sr;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_link_video_show;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_cast_cat;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_dis;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_ut_flg;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_even_show;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_link;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_res_holder;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_res_model;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_cmm;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_tv_connect;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_utlls;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_var;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Inter;

public class kapil_developer_bra extends AppCompatActivity {
    kapil_developer_ut_flg kapildeveloperutflg;
    SSLSocketFactory socketFactory;

    Context context;
    ImageView back, searchClick, cancel, cast,
            mainListShow, browserBack, browserNext, browserHome, browserRefresh;
    AutoCompleteTextView editSearchView;
    WebView webView;
    AnimatedProgressBar progressAnim;
    RelativeLayout layoutShow;
    LinearLayout showImage;
    TextView imageSize;
    private boolean isRedirected;
    CountDownTimer countDownTimer;
    String title = "";
    String linkUrl = "";
    Boolean isVisiblefab;
    boolean value = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_browes);
        kapil_developer_Inter.inter(this);
        socketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        isVisiblefab = Boolean.FALSE;
        EventBus.getDefault().register(this);
        back = findViewById(R.id.back);
        searchClick = findViewById(R.id.searchClick);
        editSearchView = findViewById(R.id.editSearchView);
        cancel = findViewById(R.id.cancel);
        webView = findViewById(R.id.BrowserView);
        progressAnim = findViewById(R.id.progressAnim);
        mainListShow = findViewById(R.id.mainListShow);
        browserBack = findViewById(R.id.browserBack);
        browserNext = findViewById(R.id.browserNext);
        browserHome = findViewById(R.id.browserHome);
        browserRefresh = findViewById(R.id.browserRefresh);
        layoutShow = findViewById(R.id.layoutShow);
        showImage = findViewById(R.id.showImage);
        imageSize = findViewById(R.id.imageSize);
        webView.setVisibility(View.GONE);
        cast = findViewById(R.id.cast);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        cast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
                    new kapil_developer_dis(kapil_developer_bra.this).show();
                    return;
                }
                startActivity(new Intent(kapil_developer_bra.this, kapil_developer_cd.class));
            }
        });
        if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
            cast.setImageResource(R.drawable.cast_connect);
        } else {
            cast.setImageResource(R.drawable.cast_main);
        }

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new BrowserViewClint());
        editSearchView.setAdapter(new kapil_developer_serch_auto(kapil_developer_bra.this, 17367043));

        Uri uri = getIntent().getData();
        if (uri != null) {
            editSearchView.setText(uri.toString());
            WebBrowserNavigate();
        }
        try {
            ShareInvite();
        } catch (Exception e) {
            e.printStackTrace();
        }

        browserBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        editSearchView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus && editSearchView.getText().toString().equals(getResources().getString(R.string.home))) {
                    searchViewTextFind("");
                }

            }
        });

        editSearchView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() != 0 || keyCode != 66) {
                    return false;
                }
                WebBrowserNavigate();
                return false;
            }
        });

        editSearchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WebBrowserNavigate();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchViewTextFind("");
            }
        });
        searchClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebBrowserNavigate();
            }
        });
        browserNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoForward()) {
                    webView.goForward();
                }
                if (webView.getVisibility() == View.GONE) {
                    webView.setVisibility(View.VISIBLE);
                }
            }
        });
        browserHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.setVisibility(View.GONE);
                searchViewTextFind("");
                webView.loadUrl("");
            }
        });
        mainListShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutShow.setVisibility(View.VISIBLE);
                ClickSetButtonFab();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        layoutShow.setVisibility(View.GONE);

                    }
                }, 4000);

            }
        });
        browserRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.reload();
            }
        });

        showImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    kapil_developer_cast_cat kapildevelopercastcat = kapil_developer_cast_cat.IMAGE;
                    ArrayList<kapil_developer_md_res_model> arrayList2 = kapil_developer_ut_var.resorcesType(kapildevelopercastcat);
                    if (arrayList2 != null) {
                        if (arrayList2.size() != 0) {
                            value = false;
                        }
                    }
                    kapil_developer_ut_flg dialoge = new kapil_developer_ut_flg(kapil_developer_bra.this, kapildevelopercastcat, value);
                    kapildeveloperutflg = dialoge;
                    dialoge.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        SetClickOffline();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(kapil_developer_md_even_show kapildevelopermdevenshow) {
        if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
            cast.setImageResource(R.drawable.cast_connect);
        } else {
            cast.setImageResource(R.drawable.cast_main);
        }
    }

    private void ShareInvite() {
        String string;
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        if (action.equals("android.intent.action.SEND") && type.startsWith("text/") && (string = intent.getStringExtra("android.intent.extra.TEXT")) != null) {
            WebUrlCheaking(string);
        }
    }

    private void WebUrlCheaking(String strings) {
        List<String> urls = kapil_developer_ut_cmm.extractUrls(strings);
        if (urls.size() == 0) {
            new SweetAlertDialog(this.context, 1).setTitleText(this.context.getString(R.string.Wait)).setContentText(this.context.getString(R.string.NoUrlFound)).show();
            return;
        }
        this.editSearchView.setText(urls.get(0));
        WebBrowserNavigate();
    }


    private void SetClickOffline() {
        if (this.isVisiblefab.booleanValue()) {
            ClickSetButtonFab();
        }
        this.mainListShow.setImageResource(R.drawable.not_compelete);
        this.imageSize.setText("0");
    }

    private void ClickSetButtonFab() {
        if (!isVisiblefab.booleanValue()) {
            isVisiblefab = Boolean.TRUE;
        } else {
            isVisiblefab = Boolean.FALSE;
        }
    }

    public void WebBrowserNavigate() {
        webView.setVisibility(View.VISIBLE);
        keyboardOff();
        if (!Patterns.WEB_URL.matcher(this.editSearchView.getText()).matches()) {
            editSearchView.setText("https://www.google.com/search?q=" + ((Object) this.editSearchView.getText()));
        }
        webView.loadUrl(this.editSearchView.getText().toString());
    }

    public void keyboardOff() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(this);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public void searchViewTextFind(String searchstr) {
        if (searchstr.equals(getResources().getString(R.string.index_page))) {
            searchstr = getResources().getString(R.string.home);
        }
        if (searchstr.equals("")) {
            cancel.setVisibility(View.INVISIBLE);
            editSearchView.requestFocus();
        } else {
            cancel.setVisibility(View.VISIBLE);
        }
        editSearchView.setText(searchstr);
    }

    private class BrowserViewClint extends WebViewClient {
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return super.shouldInterceptRequest(webView, str);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!str.startsWith("intent://")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            try {
                Context context = kapil_developer_bra.this.webView.getContext();
                Intent parseUri = Intent.parseUri(str, Intent.URI_ALLOW_UNSAFE);
                if (parseUri == null) {
                    return false;
                }
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(parseUri, PackageManager.MATCH_DEFAULT_ONLY);
                if (parseUri.getScheme().equals("https") || parseUri.getScheme().equals("http")) {
                    kapil_developer_bra.this.webView.loadUrl(parseUri.getStringExtra("browser_fallback_url"));
                    return true;
                }
                if (resolveActivity != null) {
                    context.startActivity(parseUri);
                } else {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(parseUri.getStringExtra("browser_fallback_url"))));
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }


        public void onPageFinished(WebView webView, String str) {
            if (kapil_developer_ut_var.holder == null) {
                kapil_developer_ut_var.holder = new kapil_developer_md_res_holder();
            }
            kapil_developer_ut_var.holder.setTitleofPage(webView.getTitle());
            if (!isRedirected) {
                timeStop();
                ClickEnable();
                searchLocal();
                if (mainListShow.isEnabled()) {
                    YoYo.with(Techniques.Tada).duration(300).repeat(5).playOn(findViewById(R.id.mainListShow));
                }
            }
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        public void onLoadResource(WebView webView, String str) {
            UrlSave(webView.getUrl(), webView.getTitle());
            if (!kapil_developer_link_video_show.DoNotCheckIf(kapil_developer_bra.this, editSearchView.getText().toString())) {
                new kapil_developer_sr(kapil_developer_bra.this, str, webView.getUrl(), webView.getTitle()) {
                    @Override
                    public void onLinkInspectionStart() {
                        kapil_developer_ut_utlls.disableChecking();
                    }

                    @Override
                    public void VideoAdd(String headerField3, String mp4, String info, String name, String page, boolean value, String str6, boolean value2) {

                    }


                    @Override
                    public void MusicAdd(String str, String title, String url, String image, String page, boolean value, String str6, boolean value2) {

                    }

                    @Override
                    public void onLinkInspactionfinish(boolean bool) {
                        HttpsURLConnection.setDefaultSSLSocketFactory(socketFactory);
                    }

                    @Override
                    public void PhotoAdd(String string1, String image, String url, String title, String page, boolean value, String string6, boolean value2) {
                        try {
                            kapil_developer_ut_var.holder.PhotoListAdd(string1, image, url, title, page);
                            if (kapil_developer_ut_var.holder.getFilesPhoto().size() > 0) {
                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        ImageUpdateFabView();
                                        ClickEnable();
                                    }
                                });
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }.start();
            }
        }
    }


    private void UrlSave(String str, String str2) {
        ImageChangeArrow();
        try {
            if ((title.equals(str2) && linkUrl.equals(str)) || str.isEmpty()) {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ImageChangeArrow() {
        browserBack.setImageResource(webView.canGoBack() ? R.drawable.back_button : R.drawable.back_button1);
        browserNext.setImageResource(webView.canGoForward() ? R.drawable.next_button : R.drawable.next_button1);
    }

    public void timeStop() {
        try {
            this.countDownTimer.cancel();
        } catch (Exception unused) {
        }
        this.progressAnim.setProgress(100);
        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            public void run() {
                progressAnim.setProgress(0);
                progressAnim.setVisibility(View.GONE);
            }
        }, 500);
    }

    public void ClickEnable() {
        if (kapil_developer_ut_var.holder.getFilesPhoto() != null && kapil_developer_ut_var.holder.getFilesPhoto().size() > 0) {
            PhotoCastStart();
            ImageUpdateFabView();
        }
    }


    private void PhotoCastStart() {
        CastStartMainButton();
    }

    private void CastStartMainButton() {
        mainListShow.setImageResource(R.drawable.tv_compelete);
    }


    public void searchLocal() {
        if (editSearchView.getText().toString().contains("facebook.com")) {
            webView.evaluateJavascript("(function() {return document.getElementsByTagName('html')[0].outerHTML;})();", new ValueCallback<String>() {
                public void onReceiveValue(String str) {
                    String nextString;
                    if (str != null) {
                        try {
                            JsonReader jsonReader = new JsonReader(new StringReader(str));
                            jsonReader.setLenient(true);
                            if (jsonReader.peek() == JsonToken.STRING && (nextString = jsonReader.nextString()) != null) {
                                String attr = Jsoup.parse(nextString).select("meta[property=\"og:video\"]").last().attr("content");
                                kapil_developer_ut_var.holder.setFilesVideo(new ArrayList<>());
                                kapil_developer_ut_var.holder.VideoListAdd(null, "video", attr, "Video", "page");
                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        ImageUpdateFabView();
                                        ClickEnable();
                                    }
                                });
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        boolean bool = false;
        for (String str : kapil_developer_bra.this.getResources().getStringArray(R.array.customised_searches)) {
            if (editSearchView.getText().toString().contains(str)) {
                bool = true;
            }
        }
        if (bool) {
            this.webView.evaluateJavascript("(function() {return document.getElementsByTagName('html')[0].outerHTML;})();", new ValueCallback<String>() {
                public void onReceiveValue(String str) {
                    List<kapil_developer_md_link> Search = kapil_developer_serach_view.Search(context, editSearchView.getText().toString(), str);
                    if (Search.size() > 0) {
                        kapil_developer_ut_var.holder = new kapil_developer_md_res_holder();
                    }
                    for (kapil_developer_md_link kapildevelopermdlink : Search) {
                        if (!(kapildevelopermdlink.getVideoUrl() == null || kapildevelopermdlink.getVideoUrl() == "")) {
                            if (kapildevelopermdlink.getboolValue().booleanValue()) {
                                kapil_developer_ut_var.holder.VideoListAdd(null, "m3u8", kapildevelopermdlink.getVideoUrl(), "Video", "page");
                            } else {
                                if (kapil_developer_ut_var.holder == null) {
                                    kapil_developer_ut_var.holder = new kapil_developer_md_res_holder();
                                }
                                kapil_developer_ut_var.holder.VideoListAdd(null, "video", kapildevelopermdlink.getVideoUrl(), "Video", "page");
                            }
                        }
                    }
                    runOnUiThread(new Runnable() {
                        public void run() {
                            ImageUpdateFabView();
                            ClickEnable();
                        }
                    });
                }
            });
        }
    }

    public void ImageUpdateFabView() {
        try {
            if (mainListShow.isEnabled()) {
                YoYo.with(Techniques.Tada).duration(300).repeat(5).playOn(findViewById(R.id.mainListShow));
            }
            imageSize.setText(kapil_developer_ut_var.holder.getFilesPhoto().size() + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.copyBackForwardList().getCurrentIndex() > 0) {
            if (webView.copyBackForwardList().getCurrentIndex() == 1) {
                searchViewTextFind("");
                webView.loadUrl(editSearchView.getText().toString());
                webView.setVisibility(View.GONE);
            }
            webView.goBack();
            return;
        }
        kapil_developer_Inter.back(this);
    }


}