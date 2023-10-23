package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cc;

public enum kapil_developer_val_board {
    HOME("Home"),
    LEFT("Left"),
    RIGHT("Right"),
    VOLUME_DOWN("VolumeDown"),
    VOLUME_MUTE("VolumeMute"),
    VOLUME_UP("VolumeUp");

    private final String method;

    kapil_developer_val_board(String method) {
        this.method = method;
    }

    public String getValue() {
        return method;
    }
}
