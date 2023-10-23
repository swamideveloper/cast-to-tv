package kapil.cast.video.screenmirroring.smarttv.kapil_developer_md;

public class kapil_developer_md_video_media {
    String Uri;
    String title;
    String albumName;
    private long duration;
    public boolean isSelected;
    int id;

    public kapil_developer_md_video_media() {
    }


    public kapil_developer_md_video_media(String string, String string2, String string21, long aLong) {
        title = string;
        albumName = string2;
        Uri = string21;
        duration = aLong;
    }

    public kapil_developer_md_video_media(String string, String string2, String string21) {
        title = string;
        albumName = string2;
        Uri = string21;

    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }


    public String getUri() {
        return Uri;
    }

    public void setUri(String uri) {
        Uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
