package kapil.cast.video.screenmirroring.smarttv.kapil_developer_md;

import com.connectsdk.device.ConnectableDevice;

import java.util.ArrayList;

public class kapil_developer_md_tv_model {
    private ArrayList<ConnectableDevice> deviceArrayList = new ArrayList<>();
    private String tvname;

    public kapil_developer_md_tv_model(String string, ArrayList<ConnectableDevice> arrayList) {
        this.tvname = string;
        this.deviceArrayList = arrayList;
    }

    public String getTv() {
        return this.tvname;
    }

    public ArrayList<ConnectableDevice> getDeviceArrayList() {
        return this.deviceArrayList;
    }

}
