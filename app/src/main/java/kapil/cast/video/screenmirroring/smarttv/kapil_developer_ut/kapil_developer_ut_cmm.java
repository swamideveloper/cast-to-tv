package kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut;

import android.webkit.URLUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class kapil_developer_ut_cmm {
    public static List<String> extractUrls(String str) {
        ArrayList arrayList = new ArrayList();
        String trim = str.trim();
        if (URLUtil.isValidUrl(trim)) {
            arrayList.add(trim);
        } else {
            Matcher matcher = Pattern.compile("\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|www.)(\\w+:)?(([-\\w]+\\.)+(com|org|net|gov|mil|biz|info|mobi|name|aero|jobs|museum|travel|[a-z]{2}))(:[\\d]{1,5})?(((\\/([-\\w~!$+|.,=]|%[a-f\\d]{2})+)+|\\/)+|\\?|#)?((\\?([-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)(&(?:[-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)*)*(#([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)?\\b").matcher(trim);
            while (matcher.find()) {
                arrayList.add(matcher.group());
            }
        }
        return arrayList;
    }
}
