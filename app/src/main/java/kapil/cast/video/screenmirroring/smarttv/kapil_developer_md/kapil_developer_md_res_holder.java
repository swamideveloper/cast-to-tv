package kapil.cast.video.screenmirroring.smarttv.kapil_developer_md;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_cast_cat;


public class kapil_developer_md_res_holder {
    private ArrayList<kapil_developer_md_res_model> filesPhoto;
    private String TitleofPage;
    private ArrayList<kapil_developer_md_res_model> filesVideo;
    private ArrayList<String> videoCatagory = new ArrayList<>();
    private ArrayList<String> imageCatagory = new ArrayList<>();
    private ArrayList<kapil_developer_md_res_model> MusicCatagory = new ArrayList<>();

    public kapil_developer_md_res_holder() {
        new ArrayList();
        this.filesPhoto = new ArrayList<>();
        this.filesVideo = new ArrayList<>();
        this.TitleofPage = "";
        CatagoryArrayList();
    }

    private void CatagoryArrayList() {
        this.videoCatagory.add("mp4");
        this.videoCatagory.add("wmv");
        this.videoCatagory.add("avi");
        this.imageCatagory.add("png");
        this.imageCatagory.add("jpg");
        this.imageCatagory.add("gif");
        this.imageCatagory.add("webp");
    }

    public void VideoListAdd(String str, String str2, String str3, String str4, String str5) {
        VideoFilesAdd(new kapil_developer_md_res_model(str4, str3, kapil_developer_cast_cat.VIDEO, str));
    }

    public void PhotoListAdd(String str, String str2, String str3, String str4, String str5) {
        PhotoFilesAdd(new kapil_developer_md_res_model(str4, str3, kapil_developer_cast_cat.IMAGE, str));
    }

    public void MusicListAdd(String str, String str2, String str3, String str4, String str5) {
        MusicFilesAdd(new kapil_developer_md_res_model(str4, str3, kapil_developer_cast_cat.AUDIO, str));
    }

    public void MusicFilesAdd(kapil_developer_md_res_model kapildevelopermdresmodel) {
        Iterator<kapil_developer_md_res_model> iterator = this.MusicCatagory.iterator();
        boolean bools = false;
        while (iterator.hasNext()) {
            if (iterator.next().equals(kapildevelopermdresmodel)) {
                bools = true;
            }
        }
        if (!bools) {
            this.MusicCatagory.add(kapildevelopermdresmodel);
        }
    }

    public void VideoFilesAdd(kapil_developer_md_res_model kapildevelopermdresmodel) {
        if (kapildevelopermdresmodel.getURL() == null || kapildevelopermdresmodel.getURL().startsWith("blob")) {
            return;
        }
        try {
            Iterator<kapil_developer_md_res_model> iterator = this.filesVideo.iterator();
            boolean bools = false;
            while (iterator.hasNext()) {
                if (iterator.next().getURL().equals(kapildevelopermdresmodel.getURL())) {
                    bools = true;
                }
            }
            if (bools) {
                return;
            }
            this.filesVideo.add(kapildevelopermdresmodel);
        } catch (Exception e) {
        }
    }

    public void PhotoFilesAdd(kapil_developer_md_res_model kapildevelopermdresmodel) {
        boolean bools = false;
        try {
            Iterator<kapil_developer_md_res_model> iterator = this.filesPhoto.iterator();
            while (iterator.hasNext()) {
                kapil_developer_md_res_model next = iterator.next();
                if (next.getURL() != null && next.getURL().equals(kapildevelopermdresmodel.getURL())) {
                    bools = true;
                }
            }
        } catch (ConcurrentModificationException unused) {
        }
        if (!bools) {
            this.filesPhoto.add(kapildevelopermdresmodel);
        }
    }

    public ArrayList<kapil_developer_md_res_model> getFilesVideo() {
        try {
            Iterator<kapil_developer_md_res_model> iterator = this.filesVideo.iterator();
            while (iterator.hasNext() && this.TitleofPage != null) {
                iterator.next().setTitles(this.TitleofPage);
            }
            ArrayList<kapil_developer_md_res_model> arrayList = this.filesVideo;
            return arrayList != null ? arrayList : new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void setFilesVideo(ArrayList<kapil_developer_md_res_model> arrayList) {
        this.filesVideo = arrayList;
    }

    public ArrayList<kapil_developer_md_res_model> getMusicCatagory() {
        try {
            ArrayList<kapil_developer_md_res_model> arrayList = this.MusicCatagory;
            if (arrayList != null && arrayList.size() > 0) {
                return this.MusicCatagory;
            }
            return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public ArrayList<kapil_developer_md_res_model> getFilesPhoto() {
        ArrayList<kapil_developer_md_res_model> arrayList = this.filesPhoto;
        if (arrayList != null && arrayList.size() > 0) {
            return this.filesPhoto;
        }
        return new ArrayList<>();
    }

    public void setTitleofPage(String str) {
        this.TitleofPage = str;
    }
}
