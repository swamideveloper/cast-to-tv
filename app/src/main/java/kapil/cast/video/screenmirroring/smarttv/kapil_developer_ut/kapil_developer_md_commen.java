package kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;


import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_pp;
import kapil.cast.video.screenmirroring.smarttv.BuildConfig;
import kapil.cast.video.screenmirroring.smarttv.R;

public class kapil_developer_md_commen {
    public static void shareWithFriend(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            final String appName = context.getString(R.string.app_name);
            intent.setType("text/plain");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\nLet me recommend you this application\n\n");
            stringBuilder.append("https://play.google.com/store/apps/details?id=");
            stringBuilder.append(BuildConfig.APPLICATION_ID);
            stringBuilder.append("\n\n");
            intent.putExtra(Intent.EXTRA_SUBJECT, appName);
            intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
            context.startActivity(Intent.createChooser(intent, "choose one"));
        } catch (Exception e) {
            e.toString();
        }
    }

    public static void privacyPolicy(Context context) {
       Intent intent =new Intent(context, kapil_developer_pp.class);
       context.startActivity(intent);
    }

    public static void rate(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + BuildConfig.APPLICATION_ID)));
        } catch (Exception unused) {
        }
    }


}
