package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_ip;

public class kapil_developer_brows extends BroadcastReceiver {
    Intent intent;
    kapil_developer_ip IPaddress;

    public kapil_developer_brows(kapil_developer_ip iPaddress) {
        IPaddress = iPaddress;
        intent = new Intent(iPaddress, kapil_developer_web.class);
    }

    public static void onServerStart(kapil_developer_web kapildeveloperweb, String hostAddress, int poet) {
        sendBroadCast(kapildeveloperweb, 1, hostAddress, poet);
    }

    private static void sendBroadCast(kapil_developer_web kapildeveloperweb, int i, String hostAddress, int poet) {
        Intent intent = new Intent("com.product.webserver.receiver");
        intent.putExtra("CMD_KEY", i);
        intent.putExtra("MESSAGE_KEY", hostAddress);
        intent.putExtra("PORT_KEY", poet);
        kapildeveloperweb.sendBroadcast(intent);
    }


    public void register() {
        IPaddress.registerReceiver(this,new IntentFilter("com.product.webserver.receiver"));

    }


    public void stopServer() {
        Intent intent;
        try {
            kapil_developer_ip kapildeveloperip = IPaddress;
            if (kapildeveloperip == null || (intent = this.intent) == null) {
                return;
            }
            kapildeveloperip.stopService(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void startServer() {
        Intent intent;
        try {
            kapil_developer_ip kapildeveloperip = IPaddress;
            if (kapildeveloperip == null || (intent = this.intent) == null) {
                return;
            }
            kapildeveloperip.startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("com.product.webserver.receiver".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("CMD_KEY", 0);

            if (intExtra == 1) {
                IPaddress.ServerOnStarted(intent.getStringExtra("MESSAGE_KEY"), intent.getIntExtra("PORT_KEY", 0));
            } else if (intExtra == 2) {
                IPaddress.ServerOnError(intent.getStringExtra("MESSAGE_KEY"));
            } else if (intExtra != 4) {
            } else {
                IPaddress.ServerOnStop();
            }
        }
    }


}
