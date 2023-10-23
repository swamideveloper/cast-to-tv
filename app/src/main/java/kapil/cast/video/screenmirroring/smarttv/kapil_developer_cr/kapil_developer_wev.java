package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr;

import org.greenrobot.eventbus.EventBus;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_web;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_even_show;


public class kapil_developer_wev extends WebSocketServer {
    List<String> list;
    boolean run;
    kapil_developer_if_web kapildeveloperifweb;

    public kapil_developer_wev(InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        run = false;
        list = new ArrayList();
    }

    public static kapil_developer_wev wcast(String s, int portweb) {
        return new kapil_developer_wev(new InetSocketAddress(s, portweb));
    }

    @Override

    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        String string = conn.getRemoteSocketAddress().getAddress().toString().replace("/", "");
        list.add(string);
        kapildeveloperifweb.webServerConnectionchange(list);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onOpen: // ");
        stringBuilder.append(string);
        stringBuilder.append(" //Opened connection number  ");
        stringBuilder.append(list.size());

    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {

    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        try {
            EventBus.getDefault().post(new kapil_developer_md_even_show("KEY_TIME_WEB", (long) Double.parseDouble(message)));
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
    }

    @Override
    public void onError(WebSocket conn, Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onError: ");
        stringBuilder.append(exception.getMessage());
        exception.printStackTrace();
        if (exception.getMessage() != null && exception.getMessage().contains("Address already in use")) {
            kapildeveloperifweb.onErroreServer(1);
        }
        kapildeveloperifweb.onErroreServer(0);

    }

    @Override
    public void onStart() {
        run = true;
        kapildeveloperifweb.onWsServerStatusChanged(true);
    }

    @Override
    public void onClosing(WebSocket conn, int code, String reason, boolean remote) {
        super.onClosing(conn, code, reason, remote);
        String string = conn.getRemoteSocketAddress().getAddress().toString().replace("/", "");
        Iterator<String> str = list.iterator();
        while (true) {
            if (!str.hasNext()) {
                break;
            }
            String next = str.next();
            if (next.equals(string)) {
                this.list.remove(next);
                break;
            }
        }
        kapildeveloperifweb.webServerConnectionchange(list);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onClosing: // ");
        stringBuilder.append(string);
        stringBuilder.append(" //Opened connection number  ");
        stringBuilder.append(this.list.size());
    }

    public void setListener(kapil_developer_if_web kapildeveloperifweb) {
        this.kapildeveloperifweb = kapildeveloperifweb;
    }
}
