package com.bytedance.safesdk;

import org.json.JSONObject;

public interface ByteDance_SafeSdk_List {

    void CCTAL_onSuccess();

    void CCTAL_onUpdate(String url);

    void CCTAL_onRedirect(String url);

    void CCTAL_onReload();

    void CCTAL_onGetExtradata(JSONObject extraData);
}
