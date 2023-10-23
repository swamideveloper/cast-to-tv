package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cc;


public class kapil_developer_md_yt {
     long times;
     String videoDataset;
     String videoNames;
     String clearity;
     String thubnails;
     String videoLink;

    public kapil_developer_md_yt(String names, String thumbs, String link, String clearitys, String dataset, long times) {
        this.videoNames = names;
        this.thubnails = thumbs;
        this.videoLink = link;
        this.clearity = clearitys;
        this.videoDataset = dataset;
        this.times = times;
    }


    public long getTimes() {
        return this.times;
    }

    public String getVideoNames() {
        return this.videoNames;
    }

    public String getThubnails() {
        return this.thubnails;
    }

    public String getVideoLink() {
        return this.videoLink;
    }

    public String getClearity() {
        return this.clearity;
    }

    public String getVideoDataset() {
        return this.videoDataset;
    }
}
