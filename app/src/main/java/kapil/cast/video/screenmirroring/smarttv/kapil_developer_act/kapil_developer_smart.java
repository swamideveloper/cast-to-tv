package kapil.cast.video.screenmirroring.smarttv.kapil_developer_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Inter;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Native;

public class kapil_developer_smart extends AppCompatActivity {
    ImageView back, guide;
    TextView webCast, smartTV;
    FrameLayout adsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_tv);

        kapil_developer_Inter.inter(this);
        kapil_developer_Native.banner(this, findViewById(R.id.adsContainer));

        back = findViewById(R.id.back);
        guide = findViewById(R.id.guide);
        webCast = findViewById(R.id.webCast);
        smartTV = findViewById(R.id.smartTV);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(kapil_developer_smart.this, kapil_developer_guide.class));
            }
        });
        webCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(kapil_developer_smart.this, kapil_developer_cd.class));
            }
        });
        smartTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent("android.settings.WIFI_DISPLAY_SETTINGS"));
                } catch (Exception e) {
                    try {
                        startActivity(new Intent("android.settings.CAST_SETTINGS"));
                    } catch (Exception exception) {
                        Toast.makeText(kapil_developer_smart.this, "Device not supported", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        kapil_developer_Inter.back(this);
    }
}