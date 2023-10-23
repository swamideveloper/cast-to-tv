package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cc;

import android.util.Log;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_cr;


public class kapil_developer_xc {
    public static void musicPlayingo() {
        kapil_developer_cr.getDefault().post("{\"command\":1,\"type\":2}");
    }

    public static void musicPause() {
        kapil_developer_cr.getDefault().post("{\"command\":2,\"type\":2}");
    }

    public static void musicStop() {
        kapil_developer_cr.getDefault().post("{\"command\":3,\"type\":2}");
    }

    public static void musicMute() {
        kapil_developer_cr.getDefault().post("{\"command\":4,\"type\":2,\"volume\":0}");
    }

    int audio = 10;

    public static void musicUnMute() {

        if (musiccontroll == 0) {
            kapil_developer_cr.getDefault().post("{\"command\":4,\"type\":2,\"volume\":" + 10 + "}");
        } else {
            kapil_developer_cr.getDefault().post("{\"command\":4,\"type\":2,\"volume\":" + musiccontroll + "}");
        }
    }

    public static void musicVolumeUp(int i) {
        if (musiccontroll == 100) {
        } else {
            musiccontroll = musiccontroll + i;
        }
        kapil_developer_cr casrBus = kapil_developer_cr.getDefault();
        casrBus.post("{\"command\":12,\"type\":2,\"volume\":" + i + "}");
    }

    public static int musiccontroll = 10;

    public static void musicVolumeDown(int i) {
        if (musiccontroll == 0) {
        } else {
            musiccontroll = musiccontroll - i;
        }
        kapil_developer_cr casrBus = kapil_developer_cr.getDefault();
        casrBus.post("{\"command\":13,\"type\":2,\"volume\":" + i + "}");
    }

    public static void musicSeek(int i) {
        kapil_developer_cr casrBus = kapil_developer_cr.getDefault();
        casrBus.post("{\"command\":7,\"type\":2,\"position\":" + i + "}");
    }

    public static void play() {
        kapil_developer_cr.getDefault().post("{\"command\":1,\"type\":1}");
    }

    public static void pause() {
        kapil_developer_cr.getDefault().post("{\"command\":2,\"type\":1}");
    }

    public static void stop() {
        kapil_developer_cr.getDefault().post("{\"command\":3,\"type\":1}");
    }

    public static void mute() {
        kapil_developer_cr.getDefault().post("{\"command\":4,\"type\":1,\"volume\":0}");
    }

    public static int voiceUnMuteset = 0;

    public static void unMute() {
        kapil_developer_cr casrBus = kapil_developer_cr.getDefault();
        if (voiceUnMuteset == 0) {
            casrBus.post("{\"command\":12,\"type\":1,\"volume\":" + 10 + "}");
        } else {
            casrBus.post("{\"command\":12,\"type\":1,\"volume\":" + voiceUnMuteset + "}");
        }
    }

    public static void volumeUp(int i) {
        if (voiceUnMuteset == 100) {
        } else {
            voiceUnMuteset = voiceUnMuteset + i;
        }
        kapil_developer_cr casrBus = kapil_developer_cr.getDefault();
        casrBus.post("{\"command\":12,\"type\":1,\"volume\":" + i + "}");
    }

    public static void volumeDown(int i) {
        if (voiceUnMuteset == 0) {
        } else {
            voiceUnMuteset = voiceUnMuteset - i;
        }
        kapil_developer_cr casrBus = kapil_developer_cr.getDefault();
        casrBus.post("{\"command\":13,\"type\":1,\"volume\":" + i + "}");
    }

    public static void seek(int i) {
        kapil_developer_cr casrBus = kapil_developer_cr.getDefault();
        casrBus.post("{\"command\":7,\"type\":1,\"position\":" + i + "}");
    }

    public static void musicPlay(String str) {
        Log.e("ZZTAG", "playAudio");
        kapil_developer_cr casrBus = kapil_developer_cr.getDefault();
        casrBus.post("{\"command\":9,\"type\":2,\"url\":\"" + str + "\"}");
    }

    public static void videoPlay(String str) {
        kapil_developer_cr casrBus = kapil_developer_cr.getDefault();
        casrBus.post("{\"command\":9,\"type\":1,\"url\":\"" + str + "\"}");
    }

    public static void photoDisplay(String str, String str2, String str3, String str4) {
        kapil_developer_cr casrBus = kapil_developer_cr.getDefault();
        casrBus.post("{\"type\":3,\"url\":\"" + str + "\",\"height\":\"" + str2 + "\",\"width\":\"" + str3 + "\",\"orientation\":" + str4 + "}");
    }
}
