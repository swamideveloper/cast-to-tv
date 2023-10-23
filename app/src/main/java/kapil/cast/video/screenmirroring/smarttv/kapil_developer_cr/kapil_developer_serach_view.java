package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr;

import android.content.Context;
import android.util.JsonReader;
import android.util.JsonToken;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_link;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_utlls;


public class kapil_developer_serach_view {
    public static List<kapil_developer_md_link> Search(Context context, String str, String str2) {
        String NewString;
        ArrayList arrayList = new ArrayList();
        kapil_developer_md_link kapildevelopermdlink = new kapil_developer_md_link();
        String[] stringArray = context.getResources().getStringArray(R.array.customised_searches);
        JsonReader jsonReader = new JsonReader(new StringReader(str2));
        jsonReader.setLenient(true);
        try {
            if (jsonReader.peek() == JsonToken.STRING && (NewString = jsonReader.nextString()) != null) {
                Document parse = Jsoup.parse(NewString);
                if (str.contains(stringArray[0])) {
                    Elements select = parse.select("link[rel=\"preload\"]");
                    Iterator<Element> iterator1 = select.iterator();
                    boolean bools = false;
                    while (iterator1.hasNext()) {
                        Element next = iterator1.next();
                        if (next.attr("href").endsWith(".mp4.m3u8")) {
                            kapildevelopermdlink.setVideoUrl(next.attr("href"));
                            kapildevelopermdlink.catagorySet(kapil_developer_cast_cat.VIDEO);
                            kapildevelopermdlink.setboolValue(Boolean.TRUE);
                            arrayList.add(kapildevelopermdlink);
                            bools = true;
                        }
                    }
                    if (!bools) {
                        Iterator<Element> iterator = select.iterator();
                        while (iterator.hasNext()) {
                            Element next2 = iterator.next();
                            if (next2.attr("href").contains(".m3u8")) {
                                kapildevelopermdlink.setVideoUrl(next2.attr("href"));
                                kapildevelopermdlink.catagorySet(kapil_developer_cast_cat.VIDEO);
                                kapildevelopermdlink.setboolValue(Boolean.TRUE);
                                arrayList.add(kapildevelopermdlink);
                            }
                        }
                    }
                }
                if (str.contains(stringArray[1])) {
                    Iterator<Element> script = parse.select("script").iterator();
                    while (script.hasNext()) {
                        String trim = script.next().html().trim();
                        if (trim.startsWith("var flashvars_")) {
                            JSONArray jSONArray = new JSONArray(kapil_developer_ut_utlls.removeBackSlash(trim.split("qualityItems")[1].split(" = ")[1].split("playerObjList")[0]).substring(1).trim().substring(0, -2));
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                kapil_developer_md_link kapildevelopermdlink2 = new kapil_developer_md_link();
                                kapildevelopermdlink2.setVideoUrl(jSONObject.getString("url"));
                                kapildevelopermdlink2.catagorySet(kapil_developer_cast_cat.VIDEO);
                                kapildevelopermdlink2.setboolValue(Boolean.FALSE);
                                arrayList.add(kapildevelopermdlink2);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
