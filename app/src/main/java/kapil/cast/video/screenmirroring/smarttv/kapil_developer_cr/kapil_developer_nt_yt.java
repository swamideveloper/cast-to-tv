package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiManager;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;

public class kapil_developer_nt_yt {
    public static int getPortRandome() {
        return new Random().nextInt(48127) + 1024;
    }

    public static String getWifiIPaddress(Application application) {
        int ipAddress = ((WifiManager) application.getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getIpAddress();
        return String.format(Locale.getDefault(), "%d.%d.%d.%d", Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255));
    }

    public static InetAddress getLocalIP() {
        Enumeration<NetworkInterface> networkInterfaceEnumeration;
        try {
            networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
        } catch (Exception e) {
            e.printStackTrace();
            networkInterfaceEnumeration = null;
        }
        if (networkInterfaceEnumeration != null) {
            while (networkInterfaceEnumeration.hasMoreElements()) {
                Enumeration<InetAddress> inetAddressEnumeration = networkInterfaceEnumeration.nextElement().getInetAddresses();
                if (inetAddressEnumeration != null) {
                    while (inetAddressEnumeration.hasMoreElements()) {
                        InetAddress inetAddress = inetAddressEnumeration.nextElement();
                        if (!inetAddress.isLoopbackAddress() && isIPv4Address(inetAddress.getHostAddress())) {
                            return inetAddress;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public static boolean isIPv4Address(String addr) {
        return IPV4_PATTERN.matcher(addr).matches();
    }

    private static final Pattern IPV4_PATTERN = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");

}
