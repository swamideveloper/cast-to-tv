package kapil.cast.video.screenmirroring.smarttv.kapil_developer_act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_adp.kapil_developer_vdp;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_dtum;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_dis;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_video_listner;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_even_show;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_video_media;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_media_utlis;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_tv_connect;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Inter;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Native;

public class kapil_developer_vs extends AppCompatActivity {
    RecyclerView recycler_view;
    kapil_developer_vdp videoListAdapter;
    ArrayList<kapil_developer_md_video_media> kapildevelopermdvideomediaArrayList;

    kapil_developer_if_video_listner kapildeveloperifvideolistner;
    ImageView cast, back;
    int current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_cast);
        getAllVideo();
        recycler_view = findViewById(R.id.recycler_view);
        back = findViewById(R.id.back);

        kapil_developer_Inter.inter(this);
        kapil_developer_Native.banner(this, findViewById(R.id.adsContainer));

        EventBus.getDefault().register(this);
        cast = findViewById(R.id.cast);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        cast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
                    new kapil_developer_dis(kapil_developer_vs.this).show();
                    return;
                }
                startActivity(new Intent(kapil_developer_vs.this, kapil_developer_cd.class));
            }
        });
        if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
            cast.setImageResource(R.drawable.cast_connect);
        } else {
            cast.setImageResource(R.drawable.cast_main);
        }

        recycler_view.setLayoutManager(new GridLayoutManager(this, 1));
        videoListAdapter = new kapil_developer_vdp(new ArrayList(), this, DEFAULT_KEYS_SHORTCUT);
        recycler_view.setAdapter(videoListAdapter);

        kapildevelopermdvideomediaArrayList = new ArrayList<>();

        videoListAdapter.setClickItem(new kapil_developer_if_video_listner() {
            @Override
            public void videoClick(List<kapil_developer_md_video_media> kapildevelopermdvideomedia, int position) {
                if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
                    kapildevelopermdvideomediaArrayList.clear();
                    kapildevelopermdvideomediaArrayList.addAll(kapildevelopermdvideomedia);
                    current = position;
                    CastingStart();
                } else {
                    startActivity(new Intent(kapil_developer_vs.this, kapil_developer_cd.class));
                }

            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(kapil_developer_md_even_show kapildevelopermdevenshow) {
        if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
            cast.setImageResource(R.drawable.cast_connect);
        } else {
            cast.setImageResource(R.drawable.cast_main);
        }
    }

    private void CastingStart() {
        Intent intent = new Intent(kapil_developer_vs.this, kapil_developer_remote.class);
        kapil_developer_dtum.getInstance().setType(1);
        kapil_developer_dtum.getInstance().setVideoMedia(kapildevelopermdvideomediaArrayList);
        kapil_developer_dtum.getInstance().setPosition(current);
        kapil_developer_dtum.getInstance().timeDuration = kapildevelopermdvideomediaArrayList.get(current).getDuration();
        startActivity(intent);

    }

    private void getAllVideo() {
        Observable.create(new ObservableOnSubscribe<ArrayList<kapil_developer_md_video_media>>() {
            @Override
            public void subscribe(ObservableEmitter<ArrayList<kapil_developer_md_video_media>> observableEmitter) {
                observableEmitter.onNext(kapil_developer_ut_media_utlis.MediaGetVideo(kapil_developer_vs.this));
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ArrayList<kapil_developer_md_video_media>>() {
            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable th) {
            }

            @Override
            public void onSubscribe(Disposable disposable) {
            }

            public void onNext(ArrayList<kapil_developer_md_video_media> arrayList) {
                videoListAdapter.setData(arrayList);
            }
        });
    }

    @Override
    public void onBackPressed() {
        kapil_developer_Inter.back(this);

    }
}