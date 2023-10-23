package kapil.cast.video.screenmirroring.smarttv.kapil_developer_md;


import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_cast_cat;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_utlls;

public class kapil_developer_md_res_model {
    String titles;
    String URL;
    String sizeItem;
    kapil_developer_cast_cat kapil_developer_cast_cat;
    public boolean isSelected;

    public kapil_developer_md_res_model() {
    }

    public kapil_developer_md_res_model(String str, String str2, kapil_developer_cast_cat kapildevelopercastcat, String str3) {
        this.titles = str;
        this.URL = str2;
        this.kapil_developer_cast_cat = kapildevelopercastcat;
        this.sizeItem = str3;
    }

    public String getTitles() {
        return this.titles;
    }

    public void setTitles(String str) {
        this.titles = str;
    }

    public String getURL() {
        return this.URL;
    }

    public kapil_developer_cast_cat getFile_type() {
        return this.kapil_developer_cast_cat;
    }

    public String getSizeItem() {
        String str = this.sizeItem;
        if (str == null || str.equals("")) {
            return this.sizeItem;
        }
        try {
            return kapil_developer_ut_utlls.formatFileSize(Long.parseLong(this.sizeItem));
        } catch (Exception unused) {
            return this.sizeItem;
        }
    }
}
