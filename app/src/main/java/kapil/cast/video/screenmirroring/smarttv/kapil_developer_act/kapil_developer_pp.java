package kapil.cast.video.screenmirroring.smarttv.kapil_developer_act;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_singl_clk;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Inter;


public class kapil_developer_pp extends AppCompatActivity {
    ImageView Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_p);
        kapil_developer_Inter.inter(this);
        Cancel = findViewById(R.id.Cancel);
        Cancel.setOnClickListener(new kapil_developer_ut_singl_clk() {
            @Override
            public void performClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        kapil_developer_Inter.back(this);
    }
}