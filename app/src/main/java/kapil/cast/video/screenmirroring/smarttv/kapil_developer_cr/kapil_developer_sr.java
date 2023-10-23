package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr;

import android.content.Context;
import android.media.MediaMetadataRetriever;

import com.google.android.gms.cast.HlsSegmentFormat;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;

import kapil.cast.video.screenmirroring.smarttv.R;


public abstract class kapil_developer_sr extends Thread {
    Context context;
    int numLinksInspected = 0;
    String page;
    String title;
    String url;

    public abstract void MusicAdd(String str, String title, String url, String image, String page, boolean value, String str6, boolean value2);

    public abstract void onLinkInspactionfinish(boolean bool);


    public abstract void PhotoAdd(String str, String image, String url, String title, String page, boolean value, String str6, boolean value2);

    public abstract void onLinkInspectionStart();
    public abstract void VideoAdd(String headerField3, String mp4, String info, String name, String page, boolean value, String str6, boolean value2);

    public kapil_developer_sr(Context context, String urls, String pages, String titles) {
        this.context = context;
        this.url = urls;
        this.page = pages;
        this.title = titles;
    }

    private String getUrlWithoutParameters(String link) throws URISyntaxException {
        URI imguri = new URI(link);
        return new URI(imguri.getScheme(), imguri.getAuthority(), imguri.getPath(), null, imguri.getFragment()).toString();
    }

    @Override
    public void run() {
        boolean value;
        boolean value2;
        boolean value3;
        String Fieldto;
        String linkUrl;
        String toLowerCase = this.url.toLowerCase();
        String[] VideoArray = this.context.getResources().getStringArray(R.array.videourl_filters);
        String[] PhotoArray = this.context.getResources().getStringArray(R.array.imageurl_filters);
        String[] MusicArray = this.context.getResources().getStringArray(R.array.audiourl_filters);
        int Videolength = VideoArray.length;
        boolean value4 = false;
        int videoList = 0;
        while (true) {
            if (videoList >= Videolength) {
                value = false;
                break;
            }
            if (toLowerCase.contains(VideoArray[videoList])) {
                try {
                    String urlWithoutParameters = getUrlWithoutParameters(toLowerCase);
                    if (!urlWithoutParameters.endsWith(".js") && !urlWithoutParameters.endsWith(".css") && !urlWithoutParameters.endsWith(".svg") && !urlWithoutParameters.endsWith(".ts")) {
                        value = true;
                        break;
                    }
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
            videoList++;
        }
        boolean value5 = (!value || !kapil_developer_link_video_show.IsContainsAdURL(this.context, this.url)) ? value : false;
        int photoLength = PhotoArray.length;
        int listImg = 0;
        while (true) {
            if (listImg >= photoLength) {
                value2 = false;
                break;
            } else if (toLowerCase.contains(PhotoArray[listImg])) {
                value2 = true;
                break;
            } else {
                listImg++;
            }
        }
        int musicLength = MusicArray.length;
        int listMusic = 0;
        while (true) {
            if (listMusic >= musicLength) {
                value3 = false;
                break;
            } else if (toLowerCase.contains(MusicArray[listMusic])) {
                value3 = true;
                break;
            } else {
                listMusic++;
            }
        }
        if (value2) {
            addImageToList(this.url, this.page, this.title, "image");
        }
        if (value3) {
            addAudioToList(this.url, this.page, this.title, "audio");
        }
        if (value5) {
            this.numLinksInspected++;
            onLinkInspectionStart();
            URLConnection connection = null;
            try {
                connection = new URL(this.url).openConnection();
                connection.connect();
            } catch (IOException e3) {
                e3.printStackTrace();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (connection != null && (Fieldto = connection.getHeaderField("content-type")) != null) {
                String lowerCase2 = Fieldto.toLowerCase();
                if (lowerCase2.contains("video") || lowerCase2.contains("audio")) {
                    addVideoToList(connection, this.page, this.title, lowerCase2);
                } else if (lowerCase2.equals("application/octet-stream") || lowerCase2.equals("application/mp4") || lowerCase2.equals("video/mp4")) {
                    addVideoToList(connection, this.page, this.title, lowerCase2);
                } else if (lowerCase2.equals("application/x-mpegurl") || lowerCase2.equals("application/vnd.apple.mpegurl") || lowerCase2.equals("application/x-mpegURL; charset=UTF-8")) {
                    try {
                        linkUrl = new URL(this.page).getHost();
                    } catch (MalformedURLException e5) {
                        e5.printStackTrace();
                        linkUrl = "";
                    }
                    if (!linkUrl.contains("twitter.com") && !linkUrl.contains("metacafe.com") && !linkUrl.contains("myspace.com")) {
                        MainVideoAddDirect(connection, this.page, this.title);
                    }
                    MainVideoAdd(connection, this.page, this.title);
                } else if (lowerCase2.equals("binary/octet-stream")) {
                    MainVideoAddDirect(connection, this.page, this.title);
                }
            }
            int i4 = this.numLinksInspected - 1;
            this.numLinksInspected = i4;
            if (i4 <= 0) {
                value4 = true;
            }
            onLinkInspactionfinish(value4);
        }
    }




    private void addImageToList(String url, String page, String title, String image) {
        PhotoAdd(null, "image", url, title, page, false, null, false);
    }


    private void addAudioToList(String url, String page, String title, String audio) {
        MusicAdd(null, title, url, "image", page, false, null, false);
    }



    private void addVideoToList(URLConnection uRLConnection, String page, String title, String lowerCase2) {
        String name;
        String low = null;
        String audiofix;
        CharSequence charSequence;
        int lastIndexOf;
        String value;
        String titles;
        String music;
        String dailym;
        String itemnew;
        String youtype = "youtube.com";
        uRLConnection.getURL().toString();
        try {
            String fieldHead = uRLConnection.getHeaderField("content-length");
            String location = uRLConnection.getHeaderField("Location");
            if (location == null) {
                location = uRLConnection.getURL().toString();
            }
            String info = location;
            String host = new URL(page).getHost();
            if (host.contains("twitter.com") && lowerCase2.equals("video/mp2t")) {
                return;
            }
            if (title == null) {
                low = lowerCase2.contains("audio") ? "audio" : "video";
            } else if (lowerCase2.contains("audio")) {
                low = "[AUDIO ONLY]" + title;
            } else {
                name = title;
                if (!host.contains(youtype) || new URL(info).getHost().contains("googlevideo.com")) {
                    audiofix = "[AUDIO ONLY]";
                    charSequence = "audio";
                } else {
                    if (host.contains("dailymotion.com")) {
                        itemnew = info.replaceAll("(frag\\()+(\\d+)+(\\))", "FRAGMENT");
                        dailym = "dailymotion.com";
                    } else if (host.contains("vimeo.com") && info.endsWith("m4s")) {
                        itemnew = info.replaceAll("(segment-)+(\\d+)", "SEGMENT");
                        dailym = "vimeo.com";
                    } else {
                        if (host.contains("facebook.com") && info.contains("bytestart")) {
                            int lastIndexOf2 = info.lastIndexOf("&bytestart");
                            int indexOf = info.indexOf("fbcdn");
                            if (lastIndexOf2 > 0) {
                                info = "https://video.xx." + info.substring(indexOf, lastIndexOf2);
                            }
                            URLConnection openConnection = new URL(info).openConnection();
                            openConnection.connect();
                            dailym = null;
                            String headerField3 = openConnection.getHeaderField("content-length");
                            lowerCase2.hashCode();
                            audiofix = "[AUDIO ONLY]";
                            charSequence = "audio";
                            VideoAdd(headerField3, "mp4", info, name, page, false, null, false);
                            itemnew = info;
                            lowerCase2.hashCode();
                            VideoAdd(null, "mp4", itemnew, name, page, true, dailym, false);
                            youtype = dailym;
                        }
                        audiofix = "[AUDIO ONLY]";
                        charSequence = "audio";
                        if (host.contains("instagram.com")) {
                            try {
                                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                                mediaMetadataRetriever.setDataSource(info, new HashMap());
                                mediaMetadataRetriever.release();
                            } catch (RuntimeException unused) {
                            }
                        }
                        dailym = null;
                        char character = 65535;
                        int hashCode = lowerCase2.hashCode();
                        if (hashCode == -1662384007) {
                            if (lowerCase2.equals("video/mp2t")) {
                                character = 2;
                            }
                        } else if (hashCode == -1662095187 && lowerCase2.equals("video/webm")) {
                            character = 1;
                        }
                        VideoAdd(fieldHead, (character == 0 || character == 1 || character != 2) ? "mp4" : HlsSegmentFormat.TS, info, name, page, false, null, false);
                        itemnew = info;
                        lowerCase2.hashCode();
                        VideoAdd(null, "mp4", itemnew, name, page, true, dailym, false);
                        youtype = dailym;
                    }
                    audiofix = "[AUDIO ONLY]";
                    charSequence = "audio";
                    lowerCase2.hashCode();
                    VideoAdd(null, "mp4", itemnew, name, page, true, dailym, false);
                    youtype = dailym;
                }
                lastIndexOf = info.lastIndexOf("&range");
                if (lastIndexOf > 0) {
                    info = info.substring(0, lastIndexOf);
                }
                URLConnection openConnection2 = new URL(info).openConnection();
                openConnection2.connect();
                String headerField4 = openConnection2.getHeaderField("content-length");
                if (youtype != null || !host.contains(youtype)) {
                    value = null;
                    titles = name;
                } else {
                    InputStreamReader inputStreamReader = new InputStreamReader(new URL("http://www.youtube.com/oembed?url=" + page + "&format=json").openStream(), Charset.defaultCharset());
                    StringBuilder stringBuilder = new StringBuilder();
                    char[] characterArray = new char[1024];
                    String itemnames = name;
                    while (true) {
                        int read = inputStreamReader.read(characterArray);
                        if (read == -1) {
                            break;
                        }
                        stringBuilder.append(characterArray, 0, read);
                        if (!lowerCase2.contains("video")) {
                            itemnames = "[VIDEO ONLY]" + itemnames;
                        } else if (lowerCase2.contains(charSequence)) {
                            StringBuilder stringBuilder1 = new StringBuilder();
                            music = audiofix;
                            stringBuilder1.append(music);
                            stringBuilder1.append(itemnames);
                            itemnames = stringBuilder1.toString();
                            audiofix = music;
                        }
                        music = audiofix;
                        audiofix = music;
                    }
                    String string = new JSONObject(stringBuilder.toString()).getString("title");
                    lowerCase2.contains("video");
                    titles = string;
                    value = youtype;
                }
                lowerCase2.hashCode();
                VideoAdd(headerField4, "mp4", info, titles, page, false, value, false);
            }
            name = low;
            if (!host.contains(youtype)) {
            }
            audiofix = "[AUDIO ONLY]";
            charSequence = "audio";
            lastIndexOf = info.lastIndexOf("&range");
            if (lastIndexOf > 0) {
            }
            URLConnection urlConnection = new URL(info).openConnection();
            urlConnection.connect();
            String contentField = urlConnection.getHeaderField("content-length");
            if (youtype != null) {
            }
            value = null;
            titles = name;
            lowerCase2.hashCode();
            VideoAdd(contentField, "mp4", info, titles, page, false, value, false);
        } catch (IOException | JSONException unused2) {
        }
    }


    private void MainVideoAddDirect(URLConnection uRLConnection, String page, String title) {
        uRLConnection.getURL().toString();
        String headerField = uRLConnection.getHeaderField("Location");
        if (headerField == null) {
            headerField = uRLConnection.getURL().toString();
        }
        VideoAdd(null, "m3u8", headerField, "Video", page, true, null, false);
    }

    private void MainVideoAdd(URLConnection urlConnection, String page, String title) {
        urlConnection.getURL().toString();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String host = new URL(page).getHost();
            if (!host.contains("twitter.com") && !host.contains("metacafe.com") && !host.contains("myspace.com")) {
                return;
            }
            if (title == null) {
                title = "video";
            }
            if (!host.contains("twitter.com")) {
                if (host.contains("metacafe.com")) {
                    String url = urlConnection.getURL().toString();
                    url.substring(0, url.lastIndexOf("/") + 1);
                } else if (host.contains("myspace.com")) {
                    VideoAdd(null, HlsSegmentFormat.TS, urlConnection.getURL().toString(), title, page, true, "myspace.com", false);
                    return;
                } else {
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            return;
                        }
                        if (readLine.endsWith(".m3u8")) {
                            VideoAdd(null, null, ((String) null) + readLine, title, page, true, null, false);
                        }
                    }
                }
            }
            while (true) {
                bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
