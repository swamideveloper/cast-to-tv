package com.bytedance.safesdk;

import android.app.Application;

public class ByteDance_SafeSdk_BeatFlow extends Application{
    public static ByteDance_SafeSdk_BeatFlow CCTAL_instance;
    public static ByteDance_SafeSdk_BeatFlow getCCTAL_instance() {
        return CCTAL_instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        CCTAL_instance = this;
    }

}
