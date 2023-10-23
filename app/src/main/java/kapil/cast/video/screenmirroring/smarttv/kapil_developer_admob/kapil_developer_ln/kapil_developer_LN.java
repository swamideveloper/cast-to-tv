package kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ln;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Inter;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Native;


public class kapil_developer_LN extends AppCompatActivity {

    RecyclerView rvLeng;
    int[] ints = new int[]{R.drawable.leng1, R.drawable.leng2, R.drawable.leng3, R.drawable.leng4, R.drawable.leng5, R.drawable.leng6};

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_lng);

        if (getIntent().getBooleanExtra("pro_inter", false)){
            kapil_developer_Inter.inter(this);
        }
        kapil_developer_Native.nativeads(this, findViewById(R.id.adsContainer));
        init();
    }

    private void init() {

        rvLeng = findViewById(R.id.rvLeng);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvLeng.setLayoutManager(gridLayoutManager);
        kapil_developer_ADP appLanguageAdapter = new kapil_developer_ADP(this, ints);
        rvLeng.setAdapter(appLanguageAdapter);
    }

    @Override
    public void onBackPressed() {
    }
}
