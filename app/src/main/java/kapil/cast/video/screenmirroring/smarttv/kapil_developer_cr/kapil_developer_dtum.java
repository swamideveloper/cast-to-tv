package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr;

import java.util.ArrayList;
import java.util.List;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_audio_model;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_video_media;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_yt_letter;

public class kapil_developer_dtum {
    private static kapil_developer_dtum kapildeveloperdtum;
    public Long timeDuration = 0L;
    public String thumbnailCrome = "";
    public String nameCrome = "";
    public  String videoPathCrome = "";
    List<kapil_developer_md_audio_model> kapildevelopermdaudiomodels;
    ArrayList<kapil_developer_md_video_media> kapildevelopermdvideomedia;
    private List<kapil_developer_md_yt_letter> kapil_developer_md_yt_letters;
    int position = 0;
    int type = 0;

    public static kapil_developer_dtum getInstance() {
        if (kapildeveloperdtum == null) {
            kapildeveloperdtum = new kapil_developer_dtum();
        }
        return kapildeveloperdtum;
    }
    public List<kapil_developer_md_audio_model> getAudioModels() {
        return kapildevelopermdaudiomodels;
    }
    public void setAudioModels(List<kapil_developer_md_audio_model> kapildevelopermdaudiomodels) {
        ArrayList arrayList2 = new ArrayList<>();
        this.kapildevelopermdaudiomodels = arrayList2;
        arrayList2.addAll(kapildevelopermdaudiomodels);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<kapil_developer_md_video_media> getVideoMedia() {
        return kapildevelopermdvideomedia;
    }

    public void setVideoMedia(ArrayList<kapil_developer_md_video_media> kapildevelopermdvideomedia) {
        ArrayList<kapil_developer_md_video_media> arrayList = new ArrayList<>();
        this.kapildevelopermdvideomedia = arrayList;
        arrayList.addAll(kapildevelopermdvideomedia);
    }
    public List<kapil_developer_md_yt_letter> getyTubeItems() {
        return kapil_developer_md_yt_letters;
    }

    public void setyTubeItems(List<kapil_developer_md_yt_letter> kapil_developer_md_yt_letters) {
        this.kapil_developer_md_yt_letters = kapil_developer_md_yt_letters;
    }

}
