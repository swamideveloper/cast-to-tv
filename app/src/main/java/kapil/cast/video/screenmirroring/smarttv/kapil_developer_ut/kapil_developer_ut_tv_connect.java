package kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut;

import com.connectsdk.device.ConnectableDevice;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_brows;

public class kapil_developer_ut_tv_connect {

    public boolean connectCrome;
    private static kapil_developer_ut_tv_connect kapildeveloperuttvconnect;
    ConnectableDevice connectableDevice;
    public kapil_developer_brows kapildeveloperbrows2;
    public float volume;

    public static kapil_developer_ut_tv_connect getInstance() {
        if (kapildeveloperuttvconnect == null) {
            kapildeveloperuttvconnect = new kapil_developer_ut_tv_connect();
        }
        return kapildeveloperuttvconnect;
    }

    public ConnectableDevice getConnectableDevice() {
        return connectableDevice;
    }

    public void setConnectableDevice(ConnectableDevice connectableDevice2) {
        this.connectableDevice = connectableDevice2;
    }

    public boolean isConnect() {
        ConnectableDevice connectableDevice2 = this.connectableDevice;
        if (connectableDevice2 != null) {
            return connectableDevice2.isConnected();
        }
        if (kapildeveloperbrows2 != null) {
            return this.connectCrome;
        }
        return false;
    }

    public boolean isDisconnect() {
        ConnectableDevice connectableDevice2 = this.connectableDevice;
        if (connectableDevice2 != null) {
            connectableDevice2.disconnect();
            this.connectableDevice = null;
        }
        kapil_developer_brows kapildeveloperbrows = this.kapildeveloperbrows2;
        if (kapildeveloperbrows != null) {
            kapildeveloperbrows.stopServer();
            connectCrome = false;
        }

        return false;
    }

    public String getDeviveName() {
        ConnectableDevice connectableDevice2 = this.connectableDevice;
        if (connectableDevice2 == null) {
            return "no TV connection";
        }
        if (connectableDevice2.getFriendlyName() != null) {
            return this.connectableDevice.getFriendlyName();
        }
        return this.connectableDevice.getModelName();
    }

}
