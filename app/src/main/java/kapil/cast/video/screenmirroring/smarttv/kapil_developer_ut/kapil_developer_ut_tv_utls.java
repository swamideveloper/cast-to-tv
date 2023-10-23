package kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut;

import com.connectsdk.device.ConnectableDevice;
import com.connectsdk.service.config.ServiceDescription;

import java.util.Locale;

public class kapil_developer_ut_tv_utls {

    public static String FireTV = "FireTV";
    public static String LG = "LG";
    public static String RokuTV = "RokuTV";
    public static String SamsungTV = "SamsungTV";
    public static String SonyTV = "SonyTV";

    public static String getTVcatgary(ConnectableDevice device) {
        if (onFireTV(device)) {
            return FireTV;
        }
        if (onSamsungTV(device)) {
            return SamsungTV;
        }
        if (onSonyTV(device)) {
            return SonyTV;
        }
        if (onRokuTV(device)) {
            return RokuTV;
        }
        return onLGTV(device) ? LG : "null";


    }

    private static boolean onLGTV(ConnectableDevice device) {
        String lg;
        String lg2 = "";
        if (device == null) {
            return false;
        }
        String lowercase = device.getConnectedServiceNames() != null ? device.getConnectedServiceNames().toLowerCase(Locale.getDefault()) : lg2;
        if (lowercase.contains("webos")) {
            return true;
        }
        ServiceDescription serviceDescription = device.getServiceDescription();
        if (!(serviceDescription == null || (lg = serviceDescription.getManufacturer()) == null)) {
            lowercase = lg.toLowerCase(Locale.getDefault());
        }
        if (lowercase.contains("lg")) {
            return true;
        }
        if (device.getFriendlyName() != null) {
            lg2 = device.getFriendlyName().toLowerCase(Locale.getDefault());

        }
        if (lg2.contains("web os") || lg2.contains("lg") || lg2.contains("webos")) {
            return true;
        }
        return false;
    }

    public static boolean onRokuTV(ConnectableDevice device) {
        String roku;
        if (device == null) {
            return false;
        }
        String roku2 = "";
        String lowercase = device.getConnectedServiceNames() != null ? device.getConnectedServiceNames().toLowerCase(Locale.getDefault()) : roku2;
        ServiceDescription serviceDescription = device.getServiceDescription();
        if (!(serviceDescription == null || (roku = serviceDescription.getManufacturer()) == null)) {
            lowercase = roku.toLowerCase(Locale.getDefault());
        }
        if (lowercase.contains("roku")) {
            return true;
        }
        if (device.getFriendlyName() != null) {
            roku2 = device.getFriendlyName().toLowerCase(Locale.getDefault());
        }
        if (!roku2.contains("roku")) {
            return false;
        }
        return true;
    }

    private static boolean onSonyTV(ConnectableDevice device) {
        String sony;
        String sony2 = "";
        if (device == null) {
            return false;
        }

        String lowerCase = device.getConnectedServiceNames() != null ? device.getConnectedServiceNames().toLowerCase(Locale.getDefault()) : sony2;
        ServiceDescription serviceDescription = device.getServiceDescription();
        if (!(serviceDescription == null || (sony = serviceDescription.getManufacturer()) == null)) {
            lowerCase = sony.toLowerCase(Locale.getDefault());
        }
        if (!lowerCase.contains("sony") && !lowerCase.contains("bravia")) {
            if (device.getFriendlyName() != null) {
                sony2 = device.getFriendlyName().toLowerCase(Locale.getDefault());
            }
            if (sony2.contains("bravia") || sony2.contains("sony")) {
                return true;
            }
            return false;
        }
        return true;
    }

    private static boolean onSamsungTV(ConnectableDevice device) {
        String Samsung;
        String Samsung2 = "";

        if (device == null) {
            return false;
        }
        String lowerCase = device.getConnectedServiceNames() != null ? device.getConnectedServiceNames().toLowerCase(Locale.getDefault()) : Samsung2;
        ServiceDescription serviceDescription = device.getServiceDescription();
        if (!(serviceDescription == null || (Samsung = serviceDescription.getManufacturer()) == null)) {
            lowerCase = Samsung.toLowerCase(Locale.getDefault());
        }
        if (lowerCase.contains("samsung")) {
            return true;
        }
        if (device.getFriendlyName() != null) {
            Samsung2 = device.getFriendlyName().toLowerCase(Locale.getDefault());
        }
        if (!Samsung2.contains("samsung")) {
            return false;
        }
        return true;
    }

    private static boolean onFireTV(ConnectableDevice device) {
        String fire;
        String fire2 = "";
        if (device == null) {
            return false;
        }
        if (device.getConnectedServiceNames() != null) {
            fire = device.getConnectedServiceNames().toLowerCase(Locale.getDefault());
        } else {
            fire = fire2;
        }
        if (!fire.contains("firetv") && !fire.contains("fire tv")) {
            if (device.getFriendlyName() != null) {
                fire2 = device.getFriendlyName().toLowerCase(Locale.getDefault());
            }
            if (fire2.contains("fire tv") || fire2.contains("firetv")) {
                return true;
            }
            return false;
        }
        return false;
    }


}