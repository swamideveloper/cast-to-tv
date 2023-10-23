package kapil.cast.video.screenmirroring.smarttv.kapil_developer_act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_dtum;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_dis;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_fm.kapil_developer_fm_single;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_audio_model;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_even_show;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_tv_connect;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Inter;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Native;

public class kapil_developer_audiocast extends AppCompatActivity {
    LinearLayout fragment;
    public ArrayList<kapil_developer_md_audio_model> kapildevelopermdaudiomodels;
    ImageView back,cast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_audio);
        EventBus.getDefault().register(this);
        fragment = findViewById(R.id.fragment);
        back = findViewById(R.id.back);
        cast = findViewById(R.id.cast);

        kapil_developer_Inter.inter(this);
        kapil_developer_Native.banner(this, findViewById(R.id.adsContainer));

        if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
            cast.setImageResource(R.drawable.cast_connect);
        } else {
            cast.setImageResource(R.drawable.cast_main);
        }
        cast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
                    new kapil_developer_dis(kapil_developer_audiocast.this).show();
                    return;
                }
                startActivity(new Intent(kapil_developer_audiocast.this, kapil_developer_cd.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        kapildevelopermdaudiomodels = new ArrayList<>();
        final FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        transaction1.replace(R.id.fragment, new kapil_developer_fm_single());
        transaction1.addToBackStack(null);
        transaction1.commit();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(kapil_developer_md_even_show kapildevelopermdevenshow) {
        if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
            cast.setImageResource(R.drawable.cast_connect);
        } else {
            cast.setImageResource(R.drawable.cast_main);
        }
    }

    public void CastRemoteClick(List<kapil_developer_md_audio_model> list, int i) {
        ArrayList<kapil_developer_md_audio_model> arrayList = this.kapildevelopermdaudiomodels;
        if (arrayList == null || arrayList.size() <= i) {
            return;
        }
        Intent intent = new Intent(this, kapil_developer_remote.class);
        kapil_developer_dtum.getInstance().setType(2);
        kapil_developer_dtum.getInstance().setAudioModels((ArrayList) list);
        kapil_developer_dtum.getInstance().setPosition(i);
        kapil_developer_dtum.getInstance().timeDuration = Long.valueOf(list.get(i).getDuration());
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        kapil_developer_Inter.back(this);
    }
}