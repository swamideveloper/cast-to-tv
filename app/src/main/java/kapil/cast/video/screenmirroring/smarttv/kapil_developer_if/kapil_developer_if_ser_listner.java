package kapil.cast.video.screenmirroring.smarttv.kapil_developer_if;

import java.util.List;


public interface kapil_developer_if_ser_listner {
    void onServerStatusChanged(boolean z);

    void onWebServerError(int i);

    void onWsServerConnChanged(List<String> list);

    void onWsServerError(int i);
}
