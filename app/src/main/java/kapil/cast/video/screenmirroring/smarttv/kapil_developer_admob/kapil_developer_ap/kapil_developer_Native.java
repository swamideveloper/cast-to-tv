package kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap;

import static com.bytedance.safesdk.ByteDance_SafeSdk_Manager.CCTAL_ADMOB_N;

import android.app.Activity;
import android.view.ViewGroup;

import com.bytedance.safesdk.ByteDance_SafeSdk_Manager;


public class kapil_developer_Native {
    public static void nativeads(Activity activity, ViewGroup viewById) {
        ByteDance_SafeSdk_Manager.getInstance(activity).CCTAL_showNative(viewById, "EFEBEB", "1", CCTAL_ADMOB_N[1], "", 0);
    }

    public static void banner(Activity activity, ViewGroup viewById) {
        ByteDance_SafeSdk_Manager.getInstance(activity).CCTAL_showNative(viewById, "EFEBEB", "2", CCTAL_ADMOB_N[1], "", 0);
    }
}
