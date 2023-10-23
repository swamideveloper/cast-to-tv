package kapil.cast.video.screenmirroring.smarttv.kapil_developer_if;

import java.util.List;

public interface kapil_developer_if_web {
    void webServerConnectionchange(List<String> list);

    void onErroreServer(int i);

    void onWsServerStatusChanged(boolean b);
}
