package kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.Locale;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_img;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_vs;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_audio_model;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_video_media;

public class kapil_developer_ut_media_utlis {
    public static ArrayList<kapil_developer_md_video_media> MediaGetVideo(kapil_developer_vs kapildevelopervs) {
        String[] arrayString = {"title", "_data", "_id", "duration"};
        ArrayList<kapil_developer_md_video_media> kapildevelopermdvideomediaArrayList = new ArrayList<>();
        try {
            Cursor cursor1 = kapildevelopervs.managedQuery(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, arrayString, null, null, "datetaken DESC");
            for (int i = 0; i < cursor1.getCount(); i++) {
                cursor1.moveToPosition(i);
                int index = cursor1.getColumnIndex("title");
                int index2 = cursor1.getColumnIndex("_data");
                int index3 = cursor1.getColumnIndex("duration");
                String string = cursor1.getString(index);
                String string2 = cursor1.getString(index2);
                kapildevelopermdvideomediaArrayList.add(new kapil_developer_md_video_media(string, string2, string2, cursor1.getLong(index3)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return kapildevelopermdvideomediaArrayList;
    }

    public static String formatTime(long j) {
        int i = (int) (j / 1000);
        int i2 = i / 3600;
        int i3 = i % 3600;
        int i4 = i3 / 60;
        int i5 = i3 % 60;
        if (i2 > 0) {
            return String.format(Locale.US, "%d:%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5));
        }
        return String.format(Locale.US, "%d:%02d", Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static ArrayList<kapil_developer_md_video_media> getAllPhoto(kapil_developer_img kapildeveloperimg) {
        String[] stringaarray = {"title", "_data", "_id"};
        ArrayList<kapil_developer_md_video_media> arrayList = new ArrayList<>();
        try {
            Cursor managedQuery = kapildeveloperimg.managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, stringaarray, null, null, "datetaken DESC");
            for (int i = 0; i < managedQuery.getCount(); i++) {
                managedQuery.moveToPosition(i);
                int columnIndex = managedQuery.getColumnIndex("title");
                int columnIndex2 = managedQuery.getColumnIndex("_data");
                String string = managedQuery.getString(columnIndex);
                String string2 = managedQuery.getString(columnIndex2);
                arrayList.add(new kapil_developer_md_video_media(string, string2, string2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public static ArrayList<kapil_developer_md_audio_model> getAudio(Context context) {
        ArrayList<kapil_developer_md_audio_model> arrayList = new ArrayList<>();
        try {
            Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "title", "album", "artist", "duration"}, null, null, null);
            if (query != null) {

                while (query.moveToNext()) {
                    kapil_developer_md_audio_model kapildevelopermdaudiomodel = new kapil_developer_md_audio_model();
                    String string = query.getString(0);
                    String string2 = query.getString(1);
                    String string3 = query.getString(2);
                    String string4 = query.getString(3);
                    long j = query.getLong(4);
                    kapildevelopermdaudiomodel.setTitle(string2);
                    kapildevelopermdaudiomodel.setAlbumAudio(string3);
                    kapildevelopermdaudiomodel.setArtist(string4);
                    kapildevelopermdaudiomodel.setPath(string);
                    kapildevelopermdaudiomodel.setDuration(j);
                    arrayList.add(kapildevelopermdaudiomodel);
                }
                query.close();
            }
            return arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new ArrayList<>();
        }
    }
}
