package kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


public class kapil_developer_ut_utlls {
    public static String removeBackSlash(String srearchs) {
        return srearchs.replaceAll("\\\\", "");
    }

    public static String formatFileSize(long longs) {
        double bytes = longs;
        double kb = bytes / 1024.0d;
        double mb = kb / 1024.0d;
        double gb = mb / 1024.0d;
        double tb = gb / 1024.0d;
        DecimalFormat decformat = new DecimalFormat("0.00");
        if (tb > 1.0d) {
            return decformat.format(tb).concat(" TB");
        }
        if (gb > 1.0d) {
            return decformat.format(gb).concat(" GB");
        }
        if (mb > 1.0d) {
            return decformat.format(mb).concat(" MB");
        }
        if (kb > 1.0d) {
            return decformat.format(kb).concat(" KB");
        }
        return decformat.format(bytes).concat(" Bytes");
    }

    public static void disableChecking() {
        TrustManager[] trustManagers = {new X509TrustManager() {
            @Override 
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override 
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override 
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagers, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() { 
                @Override 
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
        } catch (KeyManagementException | NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
    }

}
