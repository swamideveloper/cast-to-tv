package kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_intro;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class kapil_developer_pref {
    final String USER_PREFS = "video_call";
    SharedPreferences appSharedPref;
    SharedPreferences.Editor prefEditor;

    public boolean getFirstTime() {
        return appSharedPref.getBoolean("first_time_login", true);
    }

    public void setFirstTime(boolean firTime) {
        this.prefEditor.putBoolean("first_time_login", firTime).commit();
    }


    public String getUri() {
        return appSharedPref.getString("first_time_uri", "");
    }

    public void setUri(String firuri) {
        this.prefEditor.putString("first_time_uri", firuri).commit();
    }

    public String getName() {
        return appSharedPref.getString("first_time_name", "");
    }

    public void setName(String firname) {
        this.prefEditor.putString("first_time_name", firname).commit();
    }

    public boolean getPurchase() {
        return appSharedPref.getBoolean("purchase", false);
    }

    public void setPurchase(boolean firTime) {
        this.prefEditor.putBoolean("purchase", firTime).commit();
    }

    public boolean getLanguage() {
        return appSharedPref.getBoolean("language", false);
    }

    public void setLanguage(boolean firTime) {
        this.prefEditor.putBoolean("language", firTime).commit();
    }

    public boolean getOnboarding() {
        return appSharedPref.getBoolean("onboarding", false);
    }

    public void setOnboarding(boolean firTime) {
        this.prefEditor.putBoolean("onboarding", firTime).commit();
    }


    public kapil_developer_pref(Context context) {
        this.appSharedPref = context.getSharedPreferences(USER_PREFS, Activity.MODE_PRIVATE);
        this.prefEditor = appSharedPref.edit();
    }

}