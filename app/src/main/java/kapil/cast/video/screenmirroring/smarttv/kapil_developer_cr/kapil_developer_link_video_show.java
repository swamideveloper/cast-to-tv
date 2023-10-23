package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr;

import android.content.Context;


import kapil.cast.video.screenmirroring.smarttv.R;


public class kapil_developer_link_video_show {
    public static boolean IsContainsAdURL(Context context, String s) {
        String string = s.toLowerCase();
        for (String str2 : context.getResources().getStringArray(R.array.ad_site_filters)) {
            if (string.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean DoNotCheckIf(Context context, String s) {
        String string = s.toLowerCase();
        for (String str2 : context.getResources().getStringArray(R.array.ristricted_sites)) {
            if (string.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
