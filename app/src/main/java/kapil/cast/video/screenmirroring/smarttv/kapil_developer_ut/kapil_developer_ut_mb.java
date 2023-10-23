package kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut;

import android.content.Context;
import android.os.Bundle;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_cd;

public class kapil_developer_ut_mb {

    public static void connect(kapil_developer_cd kapildevelopercd, String fail, String id, String manufacturer) {
        try {
            Boolean boolen = Boolean.FALSE;
            Bundle bundle = new Bundle();
            bundle.putString(id, id);
            bundle.putString(fail, fail);
            String[] stringArray = kapil_developer_ut_list.list;
            int length = stringArray.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String string = stringArray[i];
                if (manufacturer.contains(string)) {
                    boolen = Boolean.TRUE;
                    bundle.putString("name_default", string);
                    bundle.putString(manufacturer, manufacturer.replace(" ", "_"));
                    break;
                }
                i++;
            }
            if (!boolen.booleanValue()) {
                bundle.putString("name_default","other");
                bundle.putString(manufacturer,manufacturer.replace(" ","_"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void trackCast(Context context, String start_cast, String id, String tVcatgary, String cast_audio) {
        try {
            Boolean bool = Boolean.FALSE;
            Bundle bundle = new Bundle();
            bundle.putString(start_cast, start_cast);
            bundle.putString(id, id);
            String[] array = kapil_developer_ut_list.list;
            int length = array.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str5 = array[i];
                if (tVcatgary.contains(str5)) {
                    bool = Boolean.TRUE;
                    tVcatgary.replace(" ", "_");
                    bundle.putString("name_default", str5);
                    bundle.putString(tVcatgary, tVcatgary);
                    break;
                }
                i++;
            }
            if (!bool.booleanValue()) {
                bundle.putString("name_default", "other");
                bundle.putString(tVcatgary, tVcatgary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
