package kapil.cast.video.screenmirroring.smarttv.kapil_developer_md;

import java.util.ArrayList;

public class kapil_developer_md_alub {

    ArrayList<kapil_developer_md_video_media> arrayAlbum;
    String mUri;
    String Name;

    public kapil_developer_md_alub() {

    }

    public kapil_developer_md_alub(ArrayList<kapil_developer_md_video_media> arrayAlbum, String mUri, String name) {
        this.arrayAlbum = arrayAlbum;
        this.mUri = mUri;
        Name = name;
    }

    public kapil_developer_md_alub(int i, String all_video, String uri, ArrayList<kapil_developer_md_video_media> vmedia) {
        Name = all_video;
        mUri = uri;
        arrayAlbum = vmedia;
    }

    public ArrayList<kapil_developer_md_video_media> getVideoAlbum() {
        return arrayAlbum;
    }

    public void setArrayAlbum(ArrayList<kapil_developer_md_video_media> arrayAlbum) {
        this.arrayAlbum = arrayAlbum;
    }

    public String getmUri() {
        return mUri;
    }

    public void setmUri(String mUri) {
        this.mUri = mUri;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public void setID(int id) {

    }
}
