package kapil.cast.video.screenmirroring.smarttv.kapil_developer_md;

public class kapil_developer_md_audio_model {

    private long duration;
    String nameAudio;
    String artist;
    String path;
    String title;

    String AlbumAudio;

    public kapil_developer_md_audio_model() {
    }


    public String getAlbumAudio() {
        return AlbumAudio;
    }

    public void setAlbumAudio(String albumAudio) {
        AlbumAudio = albumAudio;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getNameAudio() {
        return nameAudio;
    }

    public void setNameAudio(String nameAudio) {
        this.nameAudio = nameAudio;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
