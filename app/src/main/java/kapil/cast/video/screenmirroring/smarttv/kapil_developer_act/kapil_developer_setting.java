package kapil.cast.video.screenmirroring.smarttv.kapil_developer_act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kapil.cast.video.screenmirroring.smarttv.BuildConfig;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_md_commen;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_singl_clk;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Inter;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Native;

public class kapil_developer_setting extends AppCompatActivity {
    ConstraintLayout rate, privacy, share, code;
    ImageView back;
    TextView version;
    FrameLayout adsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_setting);

        adsContainer = findViewById(R.id.adsContainer);
        kapil_developer_Inter.inter(this);
        kapil_developer_Native.nativeads(this, findViewById(R.id.adsContainer));

        rate = findViewById(R.id.rate);
        privacy = findViewById(R.id.privacy);
        share = findViewById(R.id.share);
        code = findViewById(R.id.code);
        back = findViewById(R.id.back);
        version = findViewById(R.id.version);
        version.setText(BuildConfig.VERSION_NAME);

        rate.setOnClickListener(new kapil_developer_ut_singl_clk() {
            @Override
            public void performClick(View v) {
                kapil_developer_md_commen.rate(kapil_developer_setting.this);
            }
        });
        privacy.setOnClickListener(new kapil_developer_ut_singl_clk() {
            @Override
            public void performClick(View v) {
                kapil_developer_md_commen.privacyPolicy(kapil_developer_setting.this);
            }
        });
        share.setOnClickListener(new kapil_developer_ut_singl_clk() {
            @Override
            public void performClick(View v) {
                kapil_developer_md_commen.shareWithFriend(kapil_developer_setting.this);
            }
        });
        back.setOnClickListener(new kapil_developer_ut_singl_clk() {
            @Override
            public void performClick(View v) {
                onBackPressed();
            }
        });
        code.setOnClickListener(new kapil_developer_ut_singl_clk() {
            @Override
            public void performClick(View v) {
                Toast.makeText(kapil_developer_setting.this, "Version : " + BuildConfig.VERSION_CODE, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        kapil_developer_Inter.back(this);
    }
}