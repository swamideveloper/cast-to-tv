package kapil.cast.video.screenmirroring.smarttv.kapil_developer_fm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_audiocast;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_cd;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_adp.kapil_developer_audio;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_audio;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_audio_model;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_media_utlis;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_tv_connect;

public class kapil_developer_fm_single extends Fragment {

    RecyclerView recycler_view;
    kapil_developer_audio kapildeveloperaudio;
    kapil_developer_audiocast kapildeveloperaudiocast;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        kapildeveloperaudiocast = (kapil_developer_audiocast) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cast_tv_screen_fm_audio, container, false);
        recycler_view = view.findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler_view.setLayoutManager(linearLayoutManager);
        kapildeveloperaudio = new kapil_developer_audio(new ArrayList(), getContext());
        recycler_view.setAdapter(kapildeveloperaudio);
        kapildeveloperaudio.setClickItem(new kapil_developer_if_audio() {
            @Override
            public void videoClick(List<kapil_developer_md_audio_model> kapildevelopermdaudiomodels, int position) {
                if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
                    if (kapildeveloperaudiocast != null) {
                        kapildeveloperaudiocast.CastRemoteClick(kapildevelopermdaudiomodels, position);
                    }
                    return;
                }
                startActivity(new Intent(getContext(), kapil_developer_cd.class));
            }
        });
        AudioSongAll();
        return view;

    }
    private void AudioSongAll() {
        Observable.create(new ObservableOnSubscribe<ArrayList<kapil_developer_md_audio_model>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<ArrayList<kapil_developer_md_audio_model>> observableEmitter) {
                observableEmitter.onNext(kapil_developer_ut_media_utlis.getAudio(getContext()));
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ArrayList<kapil_developer_md_audio_model>>() {
            @Override
            public void onComplete() {
            }

            @Override
            public void onError(@NonNull Throwable th) {
            }

            @Override
            public void onSubscribe(@NonNull Disposable disposable) {
            }

            @Override
            public void onNext(@NonNull ArrayList<kapil_developer_md_audio_model> arrayList) {
                if (kapildeveloperaudiocast != null) {
                    kapildeveloperaudiocast.kapildevelopermdaudiomodels.clear();
                    kapildeveloperaudiocast.kapildevelopermdaudiomodels.addAll(arrayList);
                }
                kapildeveloperaudio.setData(arrayList);
            }
        });

    }
}