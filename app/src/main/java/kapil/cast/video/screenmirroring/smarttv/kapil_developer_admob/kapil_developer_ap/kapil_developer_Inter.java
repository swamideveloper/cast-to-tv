package kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap;

import android.app.Activity;

import com.bytedance.safesdk.ByteDance_SafeSdk_Manager;
import com.bytedance.safesdk.ByteDance_SafeSdk_Callback;

import kapil.cast.video.screenmirroring.smarttv.R;

public class kapil_developer_Inter {

    public static void inter(Activity activity) {
        //todo: change ic_launcher for custom ads..
        ByteDance_SafeSdk_Manager.getInstance(activity).CCTAL_showInterstitialAd(R.mipmap.ic_launcher, activity, new ByteDance_SafeSdk_Callback() {
            @Override
            public void CCTAL_callbackCall() {

            }
        }, "", ByteDance_SafeSdk_Manager.CCTAL_app_mainClickCntSwAd);

    }

    public static void back(Activity activity) {
        ByteDance_SafeSdk_Manager.getInstance(activity).CCTAL_showInterstitialAdBack(R.mipmap.ic_launcher, activity, new ByteDance_SafeSdk_Callback() {
            @Override
            public void CCTAL_callbackCall() {
                activity.finish();
            }
        }, "", ByteDance_SafeSdk_Manager.CCTAL_app_innerClickCntSwAd);

    }
}
