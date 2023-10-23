package kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.StrictMode;

import androidx.multidex.MultiDex;

import com.bytedance.safesdk.ByteDance_SafeSdk_BeatFlow;
import com.connectsdk.DeviceConnectService;
import com.connectsdk.discovery.DiscoveryManager;
import com.onesignal.OneSignal;

public class kapil_developer_App extends ByteDance_SafeSdk_BeatFlow {

    public static kapil_developer_App scl_instance;
    //todo: replace
    private static final String ONESIGNAL_APP_ID = "c6hijhj886ce1-ac74-4728-92b8-fe2dd65ac626";
    public static kapil_developer_App getScl_instance() {
        return scl_instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        scl_instance = this;

        MultiDex.install(this);
        scl_createNotificationChannel();

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        OneSignal.initWithContext(this, ONESIGNAL_APP_ID);

        //CastTv.
        DiscoveryManager.init(getApplicationContext());
        DiscoveryManager.getInstance().start();
        DeviceConnectService.enqueueWork(this, new Intent());

    }

    private void scl_createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel("ServiceChannel", "Service Channel", NotificationManager.IMPORTANCE_DEFAULT));
        }
    }
}
