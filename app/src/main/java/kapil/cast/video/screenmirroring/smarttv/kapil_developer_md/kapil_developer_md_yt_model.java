package kapil.cast.video.screenmirroring.smarttv.kapil_developer_md;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

@Keep
public class kapil_developer_md_yt_model {
    @SerializedName("kind")
    private String kind;
    @SerializedName("videoId")
    private String videoId;

    public kapil_developer_md_yt_model() {
    }

    public kapil_developer_md_yt_model(String str, String str2) {
        this.kind = str;
        this.videoId = str2;
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }
}
