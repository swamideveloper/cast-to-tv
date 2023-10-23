package kapil.cast.video.screenmirroring.smarttv.kapil_developer_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.LinkedList;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_brows;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_even_show;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_tv_connect;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Inter;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Native;

public class kapil_developer_ip extends AppCompatActivity {
    ImageView back;
    TextView ipaddress;
    String ipLink;
    kapil_developer_brows broadCast;
    FrameLayout adsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_ip_addrd);

        kapil_developer_Inter.inter(this);
        kapil_developer_Native.nativeads(this, findViewById(R.id.adsContainer));

        EventBus.getDefault().register(this);
        kapil_developer_brows kapildeveloperbrows = new kapil_developer_brows(this);
        broadCast = kapildeveloperbrows;
        kapildeveloperbrows.register();
        ipaddress = findViewById(R.id.ipaddress);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        broadCast.startServer();
        kapil_developer_ut_tv_connect.getInstance().kapildeveloperbrows2 = broadCast;
    }


    @Override
    public void onBackPressed() {
        kapil_developer_Inter.back(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(kapil_developer_md_even_show kapildevelopermdevenshow) {
        if (kapildevelopermdevenshow.getEventmsg().equals("KEY_CONNECTED_WEB")) {
            kapil_developer_ut_tv_connect.getInstance().connectCrome = true;
            EventBus.getDefault().post(new kapil_developer_md_even_show("KEY_CONNECT"));
            Intent intent = new Intent();
            intent.putExtra("result", "result");
            setResult(-1, intent);
            finish();
        }
        if (kapildevelopermdevenshow.getEventmsg().equals("KEY_DISCONNECTED_WEB")) {
            kapil_developer_ut_tv_connect.getInstance().connectCrome = false;
        }
        kapildevelopermdevenshow.getEventmsg().equals("KEY_CONNECTED_WEB");
    }


    public void ServerOnStarted(String message_key, int port_key) {
        if (!TextUtils.isEmpty(message_key)) {
            LinkedList list = new LinkedList();
            String ipset = "http://" + message_key + ":" + port_key;
            ipLink = ipset;
            ipaddress.setText(ipset);
            list.add(ipLink);
            list.add("http://" + message_key + ":8936/login.html");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onServerStart1: ");
            stringBuilder.append(ipLink);
        }
        ipLink = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onServerStart2: ");
        stringBuilder.append(ipLink);
    }

    public void ServerOnError(String message_key) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onServerError: ");
        stringBuilder.append(message_key);
    }

    public void ServerOnStop() {

    }

    public void open(View view) {
        if (!TextUtils.isEmpty(ipLink)) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(ipLink));
            startActivity(intent);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}