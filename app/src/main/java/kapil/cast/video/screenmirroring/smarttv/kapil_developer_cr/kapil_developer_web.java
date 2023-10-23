package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;


import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

//import com.admin_pannel_one.admin_pannel_second.client_filter.HttpCacheFilter;
//import com.admin_pannel_one.admin_pannel_second.Server;
import com.google.android.gms.cast.CredentialsData;

import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_ser_listner;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_web;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_even_show;
import kapil.cast.video.screenmirroring.smarttv.R;

//import com.admin_pannel_one.admin_pannel_second.client_and_server;
//import com.admin_pannel_one.admin_pannel_second.client_web.AssetsWebsite;
import com.yanzhenjie.andserver.AndServer;
import com.yanzhenjie.andserver.Server;
import com.yanzhenjie.andserver.filter.HttpCacheFilter;
import com.yanzhenjie.andserver.website.AssetsWebsite;

import org.greenrobot.eventbus.EventBus;

public class kapil_developer_web extends Service {
    public static String ipTextView;
    public static int portweb = 8695;
    private AssetManager assetManager;
    Server clientserver;
    private kapil_developer_if_ser_listner kapildeveloperifserlistner;
    private kapil_developer_wev kapildeveloperwev;
    public int poet = 6699;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        try {
            ipTextView = kapil_developer_nt_yt.getWifiIPaddress(getApplication());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            ForegroundStart();
        } else {
            startForeground(1, new Notification());
        }
        compositeDisposable.add(kapil_developer_cr.getDefault().toObservable(String.class).subscribeOn(Schedulers.io()).doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                kapildeveloperwev.broadcast(s);

            }
        }).subscribe());
        assetManager = getAssets();
    }

    private void ForegroundStart() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("com.example.simpleapp", "My Background Service", 0);
            channel.setLightColor(-16776961);
            channel.setLockscreenVisibility(MODE_PRIVATE);
            ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(channel);
            startForeground(2, new NotificationCompat.Builder(this, "com.example.simpleapp").setOngoing(true).setSmallIcon(R.drawable.cast_main).setContentTitle("App is running in background").setPriority(1).setCategory("service").build());

        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ServerOnStart();
        return Service.START_STICKY;
    }

    private void ServerOnStart() {
        try {
            WebServerCreated();
            clientserver.startup();
            NewBrowserServer();
            kapildeveloperwev.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void WebServerCreated() {
        try {
            clientserver = AndServer.serverBuilder().inetAddress(kapil_developer_nt_yt.getLocalIP()).port(poet).timeout(10, TimeUnit.SECONDS).website(new AssetsWebsite(assetManager, CredentialsData.CREDENTIALS_TYPE_WEB)).registerHandler("/wsinfo", new InformationHandler()).filter(new HttpCacheFilter()).listener(new Server.ServerListener() {


                @Override
                public void onStarted() {
                    Log.e("###TAG", "kapil_developer_web onStarted: " );
                    if (kapildeveloperifserlistner != null) {
                        kapildeveloperifserlistner.onServerStatusChanged(true);
                    }
                    InetAddress localIPAddress = kapil_developer_nt_yt.getLocalIP();
                    if (localIPAddress != null) {
                        kapil_developer_brows.onServerStart(kapil_developer_web.this, localIPAddress.getHostAddress(), kapil_developer_web.this.poet);
                    }
                }

                @Override
                public void onStopped() {
                    if (kapildeveloperifserlistner != null) {
                        kapildeveloperifserlistner.onServerStatusChanged(false);
                    }

                }
                @Override
                public void onError(Exception exc) {
                    exc.printStackTrace();
                    Log.e("###TAG", "kapil_developer_web onError: " );
                    if (exc.getMessage() == null || !exc.getMessage().contains("Address already in use")) {
                        if (kapildeveloperifserlistner == null) {
                            return;
                        }
                        kapildeveloperifserlistner.onWebServerError(0);
                    }
                    poet = kapil_developer_nt_yt.getPortRandome();
                    WebServerCreated();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onWebServerError: already change random port ");
                    stringBuilder.append(poet);
                    clientserver.startup();
                    if (kapildeveloperifserlistner == null) {
                        return;
                    }
                    kapildeveloperifserlistner.onWebServerError(1);
                }

            }).build();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("createWebServer: ");
            stringBuilder.append(poet);

        } catch (Exception e) {
            Log.e("###TAG", "kapil_developer_web Exception: " );
            e.printStackTrace();

        }

    }
    private void NewBrowserServer() {
        try {
            kapil_developer_wev kapildeveloperwev1 = kapil_developer_wev.wcast("0.0.0.0", portweb);
            kapildeveloperwev = kapildeveloperwev1;
            kapildeveloperwev1.setListener(new kapil_developer_if_web() {
                @Override
                public void webServerConnectionchange(List<String> list) {
                    if (kapildeveloperifserlistner != null) {
                        kapildeveloperifserlistner.onWsServerConnChanged(list);
                    }
                    EventBus.getDefault().post(new kapil_developer_md_even_show("KEY_CONNECTED_WEB"));
                }

                @Override
                public void onErroreServer(int i) {
                    if (i != 1) {
                        if (kapildeveloperifserlistner != null) {
                            kapildeveloperifserlistner.onWsServerError(i);
                        }
                        EventBus.getDefault().post(new kapil_developer_md_even_show("KEY_CONNECT_ERROR"));
                        return;
                    }
                    kapil_developer_web.portweb = kapil_developer_nt_yt.getPortRandome();
                    NewBrowserServer();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onWsServerError: already change random port ");
                    stringBuilder.append(kapil_developer_web.portweb);
                    kapildeveloperwev.start();
                }

                @Override
                public void onWsServerStatusChanged(boolean b) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDestroy() {
        stopServer();
        super.onDestroy();


    }

    public void stopServer() {
        try {
            EventBus.getDefault().post(new kapil_developer_md_even_show("KEY_DISCONNECTED_WEB"));
            Server clientserver = this.clientserver;
            if (clientserver == null) {
                return;
            }
            clientserver.shutdown();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

}
