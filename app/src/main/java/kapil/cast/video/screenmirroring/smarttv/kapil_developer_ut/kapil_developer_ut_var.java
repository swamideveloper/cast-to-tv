package kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut;

import java.util.ArrayList;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_cast_cat;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_res_holder;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_res_model;


public class kapil_developer_ut_var {
    public static kapil_developer_md_res_holder holder = new kapil_developer_md_res_holder();
    public static ArrayList<kapil_developer_md_res_model> resorcesType(kapil_developer_cast_cat kapildevelopercastcat) {
        try {
            if (kapildevelopercastcat == kapil_developer_cast_cat.VIDEO) {
                if (holder.getFilesVideo() != null) {
                    return holder.getFilesVideo();
                }
                return new ArrayList<>();
            } else if (kapildevelopercastcat == kapil_developer_cast_cat.IMAGE) {
                if (holder.getFilesPhoto() != null) {
                    return holder.getFilesPhoto();
                }
                return new ArrayList<>();
            } else if (kapildevelopercastcat != kapil_developer_cast_cat.AUDIO) {
                return null;
            } else {
                if (holder.getMusicCatagory() != null) {
                    return holder.getMusicCatagory();
                }
                return new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
