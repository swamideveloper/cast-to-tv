package kapil.cast.video.screenmirroring.smarttv.kapil_developer_md;

public class kapil_developer_md_even_show {
    private long duration;
    private String eventmsg;

    public kapil_developer_md_even_show(String string, long l) {
        this.eventmsg = string;
        this.duration = l;
    }

    public kapil_developer_md_even_show(String string) {
        this.eventmsg = string;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getEventmsg() {
        return this.eventmsg;
    }
}
