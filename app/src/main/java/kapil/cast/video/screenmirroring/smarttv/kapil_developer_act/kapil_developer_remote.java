package kapil.cast.video.screenmirroring.smarttv.kapil_developer_act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.connectsdk.core.MediaInfo;
import com.connectsdk.device.ConnectableDevice;
import com.connectsdk.service.capability.MediaControl;
import com.connectsdk.service.capability.MediaPlayer;
import com.connectsdk.service.capability.VolumeControl;
import com.connectsdk.service.command.ServiceCommandError;
import com.connectsdk.service.sessions.LaunchSession;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.wonshinhyo.dragrecyclerview.DragRecyclerView;
import com.wonshinhyo.dragrecyclerview.SimpleDragListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cast_adp.kapil_developer_cast;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cast_adp.kapil_developer_img;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cast_adp.kapil_developer_pager;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cast_adp.kapil_developer_adp_img;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cast_adp.kapil_developer_song_cast;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cast_adp.kapil_developer_adppp;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_dis;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_error;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cc.kapil_developer_val_board;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cc.kapil_developer_im_take;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cc.kapil_developer_utt;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cc.kapil_developer_http;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cc.kapil_developer_xc;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_cast_cat;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_dtum;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_bra_clk;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_item_clk;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_photo_if;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_click;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_audio_model;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_even_show;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_res_model;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_video_media;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_yt_letter;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_media_utlis;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_mb;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_tv_utls;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_tv_connect;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_var;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Inter;

public class kapil_developer_remote extends AppCompatActivity implements View.OnClickListener {
    private int REFRESH_INTERVAL_MS;
    public CountDownTimer setTime;

    public int start;
    private int CromeCast_type;
    int Viewport;
    private int position;
    boolean isSoundMute;
    private boolean isplaying;
    public long setLimiteTime;

    ConstraintLayout video_layout, photo_layout;
    ImageView setVideo, previousVideo, playVideo, nextVideo, PhotoMst, PhotoRevers, PhotoPlayer, PhotoNext, cast, back, fasl_volume, slow_volume;
    TextView videoName, timeVideo, durationVideo, text, maintext;
    LinearLayout stope_video, listVideo, mute_volume;
    SeekBar seekbar;
    File file;
    ViewPager view_pager;
    ProgressBar loading;
    RecyclerView photoRecycle;
    String currentName;
    Timer Refresh;
    kapil_developer_adppp kapildeveloperadppp;
    kapil_developer_song_cast kapildevelopersongcast;
    List<kapil_developer_md_video_media> kapildevelopermdvideomedia = new ArrayList<>();
    List<kapil_developer_md_audio_model> kapildevelopermdaudiomodels = new ArrayList<>();
    ArrayList<kapil_developer_md_res_model> kapildevelopermdresmodels;
    ArrayList<kapil_developer_md_res_model> resorcesModels1;
    List<kapil_developer_md_yt_letter> kapil_developer_md_yt_letters;
    MediaControl mediaControl;
    public MediaControl.PlayStateListener playStateListener;
    MediaControl.DurationListener durationListener;
    MediaControl.PositionListener positionListener;
    kapil_developer_http kapildeveloperhttp;
ImageView imgvol;

    public kapil_developer_remote() {
        new ArrayList();
        position = 0;
        Viewport = 8093;
        CromeCast_type = 0;
        isplaying = false;
        setLimiteTime = -1L;
        REFRESH_INTERVAL_MS = (int) TimeUnit.SECONDS.toMillis(1L);
        durationListener = new MediaControl.DurationListener() {
            @Override
            public void onError(ServiceCommandError error) {
            }

            @Override
            public void onSuccess(Long object) {
                setLimiteTime = object.longValue();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onSuccess DurationListener ");
                stringBuilder.append(object);
                durationVideo.setText(kapil_developer_ut_media_utlis.formatTime(object.intValue()));
                seekbar.setMax((int) object.longValue());
            }


        };
        playStateListener = new MediaControl.PlayStateListener() {
            @Override
            public void onError(ServiceCommandError error) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Playstate Listener error = ");
                stringBuilder.append(error);
            }

            @Override
            public void onSuccess(MediaControl.PlayStateStatus object) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Playstate changed | playState = ");
                stringBuilder.append(object);
                int time = MediaCastPlayAct.NEXT_CONNECT_SERVICE_MEDIA_CONTROL[object.ordinal()];
                if (time != 1) {
                    if (time == 2) {
                        timeVideo.setText("00:00");
                        durationVideo.setText("00:00");
                        seekbar.setProgress(0);
                    }
                    timeChangeStop();
                    return;
                }
                timeChangeStart();
                if (mediaControl == null || !kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().hasCapability(MediaControl.Duration)) {
                    return;
                }
                mediaControl.getDuration(durationListener);

            }


        };

        positionListener = new MediaControl.PositionListener() {

            @Override
            public void onError(ServiceCommandError serviceCommandError) {

            }

            @Override
            public void onSuccess(Long object) {
                timeVideo.setText(kapil_developer_ut_media_utlis.formatTime(object.intValue()));
                seekbar.setProgress(object.intValue());
            }

        };
        isSoundMute = false;
        currentName = "";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_remote);

        EventBus.getDefault().register(this);
        imgvol = findViewById(R.id.imgvol);
        video_layout = findViewById(R.id.video_layout);
        setVideo = findViewById(R.id.setVideo);
        maintext = findViewById(R.id.maintext);
        videoName = findViewById(R.id.videoName);
        stope_video = findViewById(R.id.stope_video);
        listVideo = findViewById(R.id.listVideo);
        slow_volume = findViewById(R.id.slow_volume);
        mute_volume = findViewById(R.id.mute_volume);
        fasl_volume = findViewById(R.id.fasl_volume);
        seekbar = findViewById(R.id.seekbar);
        timeVideo = findViewById(R.id.timeVideo);
        durationVideo = findViewById(R.id.durationVideo);
        previousVideo = findViewById(R.id.previousVideo);
        playVideo = findViewById(R.id.playVideo);
        nextVideo = findViewById(R.id.nextVideo);
        cast = findViewById(R.id.cast);
        photo_layout = findViewById(R.id.photo_layout);
        view_pager = findViewById(R.id.view_pager);
        text = findViewById(R.id.text);
        loading = findViewById(R.id.loading);
        PhotoMst = findViewById(R.id.PhotoMst);
        photoRecycle = findViewById(R.id.photoRecycle);
        PhotoRevers = findViewById(R.id.PhotoRevers);
        PhotoPlayer = findViewById(R.id.PhotoPlayer);
        PhotoNext = findViewById(R.id.PhotoNext);
        back = findViewById(R.id.back);


        if (kapil_developer_ut_tv_connect.getInstance().getConnectableDevice() != null) {
            seekbar.setEnabled(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().hasCapability(MediaControl.Seek));
        }

        cast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
                    new kapil_developer_dis(kapil_developer_remote.this).show();
                } else {
                    startActivity(new Intent(kapil_developer_remote.this, kapil_developer_cd.class));
                }
            }
        });
        listVideo.setOnClickListener(this);
        stope_video.setOnClickListener(this);
        mute_volume.setOnClickListener(this);
        fasl_volume.setOnClickListener(this);
        slow_volume.setOnClickListener(this);
        PhotoPlayer.setOnClickListener(this);
        PhotoNext.setOnClickListener(this);
        PhotoRevers.setOnClickListener(this);
        nextVideo.setOnClickListener(this);
        playVideo.setOnClickListener(this);
        back.setOnClickListener(this);
        previousVideo.setOnClickListener(this);

        if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
            cast.setImageResource(R.drawable.cast_connect);
        } else {
            cast.setImageResource(R.drawable.cast_main);
        }
        try {
            kapildevelopermdvideomedia = kapil_developer_dtum.getInstance().getVideoMedia();
            kapildevelopermdaudiomodels = kapil_developer_dtum.getInstance().getAudioModels();
            CromeCast_type = kapil_developer_dtum.getInstance().getType();
            kapil_developer_md_yt_letters = kapil_developer_dtum.getInstance().getyTubeItems();
            position = kapil_developer_dtum.getInstance().getPosition();
            kapildevelopermdresmodels = kapil_developer_ut_var.resorcesType(kapil_developer_cast_cat.IMAGE);
//            kapil_developer_ut_var.resorcesType(kapil_developer_cast_cat.VIDEO);
//            resorcesModels1 = kapil_developer_ut_var.resorcesType(kapil_developer_cast_cat.AUDIO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (kapil_developer_ut_tv_connect.getInstance().getConnectableDevice() != null) {
            seekbar.setEnabled(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().hasCapability(MediaControl.Seek));
        }
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                try {
                    if (CromeCast_type != 0) {
                        if (kapil_developer_ut_tv_connect.getInstance().connectCrome) {
                            if (CromeCast_type == 2) {
                                kapil_developer_xc.musicSeek(seekBar.getProgress());
                            } else {
                                kapil_developer_xc.seek(seekBar.getProgress());
                            }
                        } else if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
                            mediaControl.seek(seekBar.getProgress(), null);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        if (kapil_developer_ut_tv_connect.getInstance().connectCrome && kapil_developer_dtum.getInstance().timeDuration != null) {
            durationVideo.setText(kapil_developer_ut_media_utlis.formatTime(kapil_developer_dtum.getInstance().timeDuration.longValue()));
            seekbar.setMax(kapil_developer_dtum.getInstance().timeDuration.intValue());
        }

        switch (CromeCast_type) {
            case 0:
                maintext.setText("Image");
                List<kapil_developer_md_video_media> kapildevelopermdvideomediaList = kapildevelopermdvideomedia;
                if (kapildevelopermdvideomediaList == null) {
                    Toast.makeText(this, "Sorry, we're getting an error, please try again", Toast.LENGTH_SHORT).show();
                    return;
                } else if (kapildevelopermdvideomediaList.size() <= position) {
                    return;
                } else {
                    photo_layout.setVisibility(View.VISIBLE);
                    video_layout.setVisibility(View.GONE);
                    castPhoto(kapil_developer_dtum.getInstance().getVideoMedia().get(position).getUri());
                    CastScreenPlayPicture();
                    return;
                }
            case 1:
                maintext.setText("Video");
                List<kapil_developer_md_video_media> kapildevelopermdvideomediaList1 = kapildevelopermdvideomedia;
                if (kapildevelopermdvideomediaList1 == null) {
                    Toast.makeText(this, "Sorry, we're getting an error, please try again", Toast.LENGTH_SHORT).show();
                    return;
                } else if (kapildevelopermdvideomediaList1.size() <= position) {
                    return;
                } else {
                    photo_layout.setVisibility(View.GONE);
                    video_layout.setVisibility(View.VISIBLE);
                    CastScreenPlayVideo();
                    return;
                }
            case 2:
                List<kapil_developer_md_audio_model> kapildevelopermdaudiomodelList = kapildevelopermdaudiomodels;
                if (kapildevelopermdaudiomodelList == null) {
                    Toast.makeText(this, "Sorry, we're getting an error, please try again", Toast.LENGTH_SHORT).show();
                    return;
                } else if (kapildevelopermdaudiomodelList.size() <= position) {
                    return;
                } else {
                    maintext.setText("Audio");
                    CastScreenPlayMusic();
                    photo_layout.setVisibility(View.GONE);
                    video_layout.setVisibility(View.VISIBLE);
                    return;
                }
            case 3:
                maintext.setText("Youtube");
                CastScreenPlayYoutube(kapil_developer_dtum.getInstance().videoPathCrome);
                photo_layout.setVisibility(View.GONE);
                video_layout.setVisibility(View.VISIBLE);
                return;
            case 9:
                maintext.setText("Online Image");
                ArrayList<kapil_developer_md_res_model> modelArrayList = kapildevelopermdresmodels;
                if (modelArrayList == null || modelArrayList.size() <= position) {
                    return;
                }
                photo_layout.setVisibility(View.VISIBLE);
                video_layout.setVisibility(View.GONE);
                PictureCastingPhotoOnline(kapildevelopermdresmodels.get(position).getURL());
                CastBrowserPlayPicture();
                return;
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.PhotoPlayer:
                try {
                    if (isplaying) {
                        PhotoPlayer.setImageResource(R.drawable.ic_play);
                        isplaying = false;
                        durationVideo.setVisibility(View.GONE);
                        setTime.cancel();
                        text.setVisibility(View.GONE);
                    } else {
                        PhotoPlayer.setImageResource(R.drawable.vd_pause);
                        isplaying = true;
                        durationVideo.setVisibility(View.GONE);
                        durationVideo.setText("7");
                        photoAutoChange();
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.previousVideo:
                try {
                    int i = position - 1;
                    position = i;
                    int type = CromeCast_type;
                    if (type == 2) {
                        if (i < 0) {
                            position = kapildevelopermdaudiomodels.size() - 1;
                        }
                        CastScreenPlayMusic();
                        return;
                    } else if (type == 1) {
                        if (i < 0) {
                            position = kapildevelopermdaudiomodels.size() - 1;
                        }
                        CastScreenPlayVideo();
                        return;
                    } else if (type != 3) {
                        return;
                    } else {
                        Toast.makeText(kapil_developer_remote.this, "Not support", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.nextVideo:
                try {
                    int audio = position + 1;
                    position = audio;
                    int type = CromeCast_type;
                    if (type == 2) {
                        if (audio >= kapildevelopermdaudiomodels.size()) {
                            position = 0;
                        }
                        CastScreenPlayMusic();
                    } else if (type == 1) {
                        if (audio >= kapildevelopermdvideomedia.size()) {
                            position = 0;
                        }
                        CastScreenPlayVideo();
                    } else {
                        Toast.makeText(kapil_developer_remote.this, "Not support", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            case R.id.PhotoNext:
                try {
                    position++;
                    int i = CromeCast_type;
                    if (i == 0) {
                        List<kapil_developer_md_video_media> list = kapildevelopermdvideomedia;
                        if (list != null && list.size() > 0) {
                            if (position >= kapildevelopermdvideomedia.size()) {
                                position = 0;
                            }
                            castPhoto(kapildevelopermdvideomedia.get(position).getUri());
                        }
                    }
                    view_pager.setCurrentItem(position, true);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }

            case R.id.playVideo:
                if (kapil_developer_ut_tv_connect.getInstance().connectCrome) {

                    int type = CromeCast_type;
                    if (type == 2) {
                        if (isplaying) {
                            isplaying = false;
                            playVideo.setImageResource(R.drawable.ic_play);
                            kapil_developer_xc.musicPause();
                            return;
                        }
                        playVideo.setImageResource(R.drawable.vd_pause);
                        isplaying = true;
                        kapil_developer_xc.musicPlayingo();
                        return;
                    } else if (isplaying) {
                        isplaying = false;
                        playVideo.setImageResource(R.drawable.ic_play);
                        kapil_developer_xc.pause();
                        return;
                    } else {
                        playVideo.setImageResource(R.drawable.vd_pause);
                        isplaying = true;
                        kapil_developer_xc.play();
                        return;
                    }
                } else if (isplaying) {
                    try {
                        mediaControl.pause(null);
                        isplaying = false;
                        playVideo.setImageResource(R.drawable.ic_play);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                } else {
                    try {
                        mediaControl.play(null);
                        playVideo.setImageResource(R.drawable.vd_pause);
                        isplaying = true;
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
            case R.id.PhotoRevers:
                try {
                    position--;
                    int type = CromeCast_type;
                    if (type == 0) {
                        List<kapil_developer_md_video_media> mediaList = kapildevelopermdvideomedia;
                        if (mediaList != null && mediaList.size() > 0) {
                            if (position < 0) {
                                position = kapildevelopermdvideomedia.size() - 1;
                            }
                            castPhoto(kapildevelopermdvideomedia.get(position).getUri());
                        }
                    }
                    view_pager.setCurrentItem(position, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case R.id.back:
                onBackPressed();
                return;
            case R.id.mute_volume:
                setVolumeMute();
                return;
            case R.id.listVideo:
                int type = CromeCast_type;
                if (type == 1) {
                    showButtonSheet();
                    return;
                } else if (type != 2) {
                    return;
                } else {
                    showButtonSheetAudio();
                    return;
                }
            case R.id.stope_video:
                if (kapil_developer_ut_tv_connect.getInstance().connectCrome) {
                    if (CromeCast_type == 2) {
                        kapil_developer_xc.musicStop();
                    } else {
                        kapil_developer_xc.stop();
                    }
                }
                onBackPressed();
                return;
            case R.id.slow_volume:
                if (kapil_developer_ut_tv_connect.getInstance().connectCrome) {
                    if (CromeCast_type == 2) {
                        kapil_developer_xc.musicVolumeDown(10);
                        return;
                    }
                    kapil_developer_xc.volumeDown(10);
                    return;
                } else if (!kapil_developer_ut_tv_connect.getInstance().isConnect()) {
                    return;
                } else {
                    setupVolume(false);
                    return;
                }
            case R.id.fasl_volume:
                if (kapil_developer_ut_tv_connect.getInstance().connectCrome) {
                    if (CromeCast_type == 2) {
                        kapil_developer_xc.musicVolumeUp(10);
                        return;
                    }

                    imgvol.setImageResource(R.drawable.unmutee);
                    kapil_developer_xc.volumeUp(10);

                } else if (!kapil_developer_ut_tv_connect.getInstance().isConnect()) {
                    return;
                } else {
                    setupVolume(true);
                    return;
                }
            default:
                return;
        }

    }

    public void setupVolume(boolean vol) {
        float maximum;
        try {
            if (kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()).equalsIgnoreCase("RokuTV")) {
                if (vol) {
                    performKeypress(kapil_developer_val_board.VOLUME_UP);
                    return;
                } else {
                    performKeypress(kapil_developer_val_board.VOLUME_DOWN);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        VolumeControl volumeControl = (VolumeControl) kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getCapability(VolumeControl.class);
        if (volumeControl != null) {
            if (vol) {
                maximum = Math.min(kapil_developer_ut_tv_connect.getInstance().volume + 0.01f, 1.0f);

            } else {
                maximum = Math.max(kapil_developer_ut_tv_connect.getInstance().volume - 0.01f, 0.0f);
            }
            kapil_developer_ut_tv_connect.getInstance().volume = maximum;
            volumeControl.setVolume(kapil_developer_ut_tv_connect.getInstance().volume, null);
        } else {
        }
    }


    private void setVolumeMute() {
        try {
            boolean value = true;
            if (kapil_developer_ut_tv_connect.getInstance().connectCrome) {
                if (isSoundMute) {
                    if (CromeCast_type == 2) {
                        kapil_developer_xc.musicUnMute();
                    } else {
                        imgvol.setImageResource(R.drawable.unmutee);
                        kapil_developer_xc.unMute();
                    }
                } else if (CromeCast_type == 2) {
                    kapil_developer_xc.musicMute();
                } else {
                    imgvol.setImageResource(R.drawable.mutee);
                    kapil_developer_xc.mute();

                }
                isSoundMute = !isSoundMute;
            }
            if (kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()).equalsIgnoreCase("RokuTV")) {
                isSoundMute = !isSoundMute;
                performKeypress(kapil_developer_val_board.VOLUME_MUTE);
            }
            VolumeControl volumeControl = (VolumeControl) kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getCapability(VolumeControl.class);
            if (volumeControl == null) {
                return;
            }
            if (isSoundMute) {
                value = false;
            }
            isSoundMute = value;
            volumeControl.setMute(value, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(final kapil_developer_md_even_show kapildevelopermdevenshow) {
        if (kapildevelopermdevenshow.getEventmsg().equals("KEY_TIME_WEB")) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    timeVideo.setText(kapil_developer_ut_media_utlis.formatTime(kapildevelopermdevenshow.getDuration() * 1000));
                    seekbar.setProgress(((int) kapildevelopermdevenshow.getDuration()) * 1000);
                }
            });
            return;
        }
        if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
            cast.setImageResource(R.drawable.cast_connect);
        } else {
            cast.setImageResource(R.drawable.cast_main);
        }

    }

    public void CastScreenPlayMusic() {
        try {
            kapil_developer_ut_mb.trackCast(this, "start_cast", kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getId(), kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()), "cast_audio");
        } catch (Exception e) {
            e.printStackTrace();
        }
        loading.setVisibility(View.VISIBLE);
        if (Viewport == 0) {
            Viewport = nextVideoCast(8000, 999);
        }
        if (kapildevelopermdaudiomodels.size() >= 1) {
            ArrayList<kapil_developer_md_res_model> arrayList = resorcesModels1;
            String musicPath = kapildevelopermdaudiomodels.get(position).getPath();
            try {
                Glide.with((FragmentActivity) this).asBitmap().load(Uri.fromFile(new File(musicPath))).centerCrop().placeholder(R.drawable.promo).into(setVideo);
                videoName.setText(kapildevelopermdaudiomodels.get(position).getTitle());
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ErrorImageAudio---");
                stringBuilder.append(e.toString());
            }
            try {
                kapil_developer_http kapildeveloperhttp = this.kapildeveloperhttp;
                if (kapildeveloperhttp != null) {
                    kapildeveloperhttp.stop();
                }
                kapil_developer_http serveHTTPD22 = new kapil_developer_http(this.Viewport);
                this.kapildeveloperhttp = serveHTTPD22;
                serveHTTPD22.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String ipAddress = Formatter.formatIpAddress(((WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getIpAddress());
            file = new File(musicPath);
            String ip = "http://" + ipAddress + ":" + Viewport + file.getPath();
            if (kapil_developer_ut_tv_connect.getInstance().connectCrome) {
                kapil_developer_xc.musicPlay(ip);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loading.setVisibility(View.GONE);
                    }
                });
            } else if (kapil_developer_ut_tv_connect.getInstance().getConnectableDevice() == null) {
            } else {
                try {
                    ((MediaPlayer) kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getCapability(MediaPlayer.class)).playMedia(new MediaInfo.Builder(ip, "audio/mp3").setTitle(file.getName()).setDescription("Casting your Audio").build(), true, new MediaPlayer.LaunchListener() { // from class: com.screenmirror.proapp.screen.tab.playcast.PlayCastActivity.25
                        @Override
                        public void onError(ServiceCommandError commandError) {
                            commandError.toString();
                            isplaying = false;
                            loading.setVisibility(View.GONE);
                            try {
                                kapil_developer_ut_mb.trackCast(kapil_developer_remote.this, "cast_fail", kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getId(), kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()), "cast_audio");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onSuccess(MediaPlayer.MediaLaunchObject launchObject) {
                            launchObject.toString();
                            isplaying = true;
                            playVideo.setImageResource(R.drawable.vd_pause);
                            timesetDuration(launchObject);
                            loading.setVisibility(View.GONE);
                            try {
                                kapil_developer_ut_mb.trackCast(kapil_developer_remote.this, "cast_success", kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getId(), kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()), "cast_audio");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void showButtonSheet() {
        VideoListShow();
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.cast_tv_screen_item);
        DragRecyclerView dragRecyclerView = (DragRecyclerView) bottomSheetDialog.findViewById(R.id.rcv_quickly_list);
        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialogInterface) {
            }
        });
        kapildeveloperadppp = new kapil_developer_adppp(this, (ArrayList) kapildevelopermdvideomedia, currentName);
        dragRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dragRecyclerView.setAdapter(kapildeveloperadppp);
        try {
            List<kapil_developer_md_video_media> mediaList = kapildevelopermdvideomedia;
            if (mediaList != null) {
                int size = mediaList.size();
                int i = position;
                if (size > i) {
                    currentName = kapildevelopermdvideomedia.get(i).getTitle();
                    dragRecyclerView.scrollToPosition(position);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        kapildeveloperadppp.setHandleDragEnabled(true);
        kapildeveloperadppp.setLongPressDragEnabled(true);
        kapildeveloperadppp.setSwipeEnabled(true);
        kapildeveloperadppp.setListener(new kapil_developer_if_item_clk() {
            @Override
            public void onClickItem(kapil_developer_md_video_media fileMedia, int i) {
                try {
                    position = i;
                    CastScreenPlayVideo();
                    bottomSheetDialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDeleteItem(kapil_developer_md_video_media fileMedia, int i) {
                try {
                    if (kapil_developer_remote.this.kapildevelopermdvideomedia.size() <= i) {
                        return;
                    }
                    kapildeveloperadppp.onSwiped(i);
                    kapildeveloperadppp.notifyItemRemoved(i);
                    ListSetPosition();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        kapildeveloperadppp.setOnItemDragListener(new SimpleDragListener() {
            @Override
            public void onDrop(int fromPosition, int toPosition) {
                super.onDrop(fromPosition, toPosition);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onDrop ");
                stringBuilder.append(fromPosition);
                stringBuilder.append(" -> ");
                stringBuilder.append(toPosition);
                ListSetPosition();
            }

            @Override
            public void onSwiped(int position) {
                super.onSwiped(position);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onSwiped ");
                stringBuilder.append(position);
                kapildeveloperadppp.notifyDataSetChanged();
                ListSetPosition();
            }
        });
        bottomSheetDialog.show();
    }

    public void ListSetPosition() {
        try {
            VideoListShow();
            for (int i = 0; i < kapildevelopermdvideomedia.size(); i++) {
                if (kapildevelopermdvideomedia.get(i).getTitle().equalsIgnoreCase(currentName)) {
                    position = i;
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void VideoListShow() {
        kapil_developer_adppp kapildeveloperadppp = this.kapildeveloperadppp;
        if (kapildeveloperadppp == null || kapildeveloperadppp.getData() == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" size :");
        stringBuilder.append(this.kapildeveloperadppp.getData().size());
        ArrayList arrayList = new ArrayList();
        kapildevelopermdvideomedia = arrayList;
        arrayList.addAll(kapildeveloperadppp.getData());
    }


    public static class MediaCastPlayAct {
        static final int[] NEXT_CONNECT_SERVICE_MEDIA_CONTROL;

        static {
            int[] arrayList = new int[MediaControl.PlayStateStatus.values().length];
            NEXT_CONNECT_SERVICE_MEDIA_CONTROL = arrayList;
            try {
                arrayList[MediaControl.PlayStateStatus.Playing.ordinal()] = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                NEXT_CONNECT_SERVICE_MEDIA_CONTROL[MediaControl.PlayStateStatus.Finished.ordinal()] = 2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void CastScreenPlayVideo() {
        kapil_developer_ut_mb.trackCast(this, "start_cast", new ConnectableDevice().getId(), kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()), "cast_video_off");
        loading.setVisibility(View.VISIBLE);
        if (Viewport == 0) {
            Viewport = nextVideoCast(8000, 999);
        }
        List<kapil_developer_md_video_media> kapildevelopermdvideomedia1 = kapildevelopermdvideomedia;
        if (kapildevelopermdvideomedia1 == null || kapildevelopermdvideomedia1.size() < 1) {
            return;
        }
        String uriImage = kapildevelopermdvideomedia.get(position).getUri();

        try {

            Glide.with((FragmentActivity) this).load(kapildevelopermdvideomedia.get(position).getUri()).placeholder(R.drawable.default_image).centerCrop().into(setVideo);
            videoName.setText(kapildevelopermdvideomedia.get(position).getTitle());
        } catch (Exception e) {

        }
        try {
            kapil_developer_http kapildeveloperhttp = this.kapildeveloperhttp;
            if (kapildeveloperhttp != null) {
                kapildeveloperhttp.stop();
            }
            kapil_developer_http serveHTTPD22 = new kapil_developer_http(Viewport);
            this.kapildeveloperhttp = serveHTTPD22;
            serveHTTPD22.start();
        } catch (Exception e) {

        }
        String ipAddress = Formatter.formatIpAddress(((WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getIpAddress());
        file = new File(uriImage);
        String ip = "http://" + ipAddress + ":" + Viewport + file.getPath();
        try {
            if (kapil_developer_ut_tv_connect.getInstance().connectCrome) {
                kapil_developer_xc.videoPlay(ip);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loading.setVisibility(View.GONE);
                    }
                });
                return;
            } else {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (kapil_developer_ut_tv_connect.getInstance().getConnectableDevice() == null) {
            return;
        }
        try {
            ((MediaPlayer) kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getCapability(MediaPlayer.class)).playMedia(new MediaInfo.Builder(ip, "video/mp4").setTitle(file.getName()).setDescription("Casting your Video").build(), true, new MediaPlayer.LaunchListener() {
                @Override
                public void onError(ServiceCommandError serviceCommandError) {
                    serviceCommandError.toString();
                    isplaying = false;
                    loading.setVisibility(View.GONE);
                    try {
                        kapil_developer_ut_mb.trackCast(kapil_developer_remote.this, "cast_fail", kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getId(), kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()), "cast_video_off");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onSuccess(MediaPlayer.MediaLaunchObject launchObject) {
                    launchObject.toString();
                    isplaying = true;
                    playVideo.setImageResource(R.drawable.vd_pause);
                    timesetDuration(launchObject);
                    loading.setVisibility(View.GONE);
                    try {
                        kapil_developer_ut_mb.trackCast(kapil_developer_remote.this, "cast_success", kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getId(), kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()), "cast_video_off");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timesetDuration(MediaPlayer.MediaLaunchObject mediaLaunchObject) {
        LaunchSession session = mediaLaunchObject.launchSession;
        mediaControl = mediaLaunchObject.mediaControl;
        timeChangeStop();
        mediaPlayerOn();
    }

    private void mediaPlayerOn() {
        try {
            if (kapil_developer_ut_tv_connect.getInstance().getConnectableDevice() != null && kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().hasCapability(MediaControl.PlayState_Subscribe) && !isplaying) {
                mediaControl.subscribePlayState(playStateListener);
                return;
            }
            if (mediaControl != null) {
                mediaControl.getDuration(durationListener);
            }
            timeChangeStart();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timeChangeStop() {
        Timer time = Refresh;
        if (time == null) {
            return;
        }
        time.cancel();
        Refresh = null;
    }

    public void timeChangeStart() {
        try {
            Timer time = Refresh;
            if (time != null) {
                time.cancel();
                Refresh = null;
            }
            Timer time2 = new Timer();
            Refresh = time2;
            time2.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (mediaControl != null && kapil_developer_ut_tv_connect.getInstance().getConnectableDevice() != null && kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().hasCapability(MediaControl.Position)) {
                        mediaControl.getPosition(positionListener);
                    }
                    if (mediaControl == null || kapil_developer_ut_tv_connect.getInstance().getConnectableDevice() == null || !kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().hasCapability(MediaControl.Duration) || setLimiteTime > 0) {
                        return;
                    }
                    mediaControl.getDuration(durationListener);
                }
            }, 0L, REFRESH_INTERVAL_MS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void CastScreenPlayPicture() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        photoRecycle.setLayoutManager(layoutManager);
        final kapil_developer_pager kapildeveloperpager = new kapil_developer_pager(this, new ArrayList());
        kapildeveloperpager.setOnclick(new kapil_developer_if_click() {
            @Override
            public void clickItem(int i) {
                position = i;
                view_pager.setCurrentItem(i, true);
                kapil_developer_dtum.getInstance().getVideoMedia().get(position).getTitle();
                castPhoto(kapil_developer_dtum.getInstance().getVideoMedia().get(position).getUri());
            }
        });
        photoRecycle.setAdapter(kapildeveloperpager);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new kapil_developer_md_video_media());
        kapil_developer_cast kapildevelopercast = new kapil_developer_cast(arrayList);
        view_pager.setAdapter(kapildevelopercast);
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int state) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int positions) {
                kapildeveloperpager.setSelectedPosition(positions);
                layoutManager.scrollToPosition(positions);
                position = positions;
                kapil_developer_dtum.getInstance().getVideoMedia().get(position).getTitle();
                castPhoto(kapil_developer_dtum.getInstance().getVideoMedia().get(position).getUri());
            }
        });
        kapil_developer_pager kapildeveloperpager2 = (kapil_developer_pager) photoRecycle.getAdapter();
        if (kapildeveloperpager2 != null) {
            kapildeveloperpager2.clearItems();
            kapildeveloperpager2.addItems(kapil_developer_dtum.getInstance().getVideoMedia());
        }
        kapildevelopercast.clearItems();
        kapildevelopercast.addItems(kapil_developer_dtum.getInstance().getVideoMedia());
        view_pager.setAdapter(kapildevelopercast);
        view_pager.setCurrentItem(position, true);
    }


    private void CastBrowserPlayPicture() {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        photoRecycle.setLayoutManager(linearLayoutManager);
        final kapil_developer_adp_img kapildeveloperadpimg = new kapil_developer_adp_img(this, new ArrayList());
        kapildeveloperadpimg.setOnclick(new kapil_developer_if_bra_clk() {
            @Override
            public void clickItem(int i) {
                position = i;
                view_pager.setCurrentItem(i, true);
                PictureCastingPhotoOnline(((kapil_developer_md_res_model) kapildevelopermdresmodels.get(position)).getURL());
            }
        });
        photoRecycle.setAdapter(kapildeveloperadpimg);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new kapil_developer_md_res_model());
        kapil_developer_img kapildeveloperimg = new kapil_developer_img(arrayList);
        view_pager.setAdapter(kapildeveloperimg);
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int state) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                kapildeveloperadpimg.setSelectedPosition(position);
                linearLayoutManager.scrollToPosition(position);
                kapil_developer_remote.this.position = position;
                PictureCastingPhotoOnline(((kapil_developer_md_res_model) kapildevelopermdresmodels.get(kapil_developer_remote.this.position)).getURL());
            }
        });
        kapil_developer_adp_img kapildeveloperadpimg2 = (kapil_developer_adp_img) photoRecycle.getAdapter();
        if (kapildeveloperadpimg2 != null) {
            kapildeveloperadpimg2.clearItems();
            kapildeveloperadpimg2.addItems(kapildevelopermdresmodels);
        }
        kapildeveloperimg.clearItems();
        kapildeveloperimg.addItems(kapildevelopermdresmodels);
        view_pager.setAdapter(kapildeveloperimg);
        view_pager.setCurrentItem(position, true);
    }

    public void PictureCastingPhotoOnline(String url) {
        loading.setVisibility(View.VISIBLE);
        try {
            kapil_developer_ut_mb.trackCast(this, "start_cast", kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getId(), kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()), "cast_photo_online");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Viewport = nextVideoCast(8000, 999);
        if (url.contains("s220")) {
            url = url.replace("s220", "s800");
            if (kapil_developer_ut_tv_utls.onRokuTV(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice())) {
                kapil_developer_utt.imageCompanion.imagrOnlineCasting(url, this, (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE), new kapil_developer_if_error() {
                    @Override
                    public void playAgainOnline(String play) {
                        PictureCastingPhotoOnline(play);
                    }
                });
                return;
            }
        }
        try {
            Glide.with((FragmentActivity) this).asBitmap().load(url).centerCrop().placeholder(R.drawable.default_image).into(PhotoMst);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (kapil_developer_ut_tv_connect.getInstance().connectCrome) {
            String finalStr = url;
            Glide.with((FragmentActivity) this).asBitmap().load(url).into(new CustomTarget<Bitmap>() {
                @Override
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    kapil_developer_xc.photoDisplay(finalStr, String.valueOf(bitmap.getHeight()), String.valueOf(bitmap.getWidth()), "0");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loading.setVisibility(View.GONE);
                        }
                    });
                }
            });
            return;
        }
        int type = CromeCast_type;
        if (type == 9) {
            if (kapildevelopermdresmodels.size() < 1) {
                return;
            }
        }
        try {
            kapil_developer_http kapildeveloperhttp = this.kapildeveloperhttp;
            if (kapildeveloperhttp != null) {
                kapildeveloperhttp.stop();
            }
            kapil_developer_http serveHTTPD22 = new kapil_developer_http(this.Viewport);
            this.kapildeveloperhttp = serveHTTPD22;
            serveHTTPD22.start();
            Formatter.formatIpAddress(((WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getIpAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (kapil_developer_ut_tv_connect.getInstance().getConnectableDevice() == null) {
            return;
        }
        try {
            String string = getString(R.string.cast_photo);
            ((MediaPlayer) kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getCapability(MediaPlayer.class)).displayImage(new MediaInfo.Builder(url, "image/jpeg").setTitle(string).setDescription("" + url).build(), new MediaPlayer.LaunchListener() {
                @Override
                public void onError(ServiceCommandError commandError) {
                    commandError.toString();
                    loading.setVisibility(View.GONE);
                    try {
                        kapil_developer_ut_mb.trackCast(kapil_developer_remote.this, "cast_fail", kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getId(), kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()), "cast_photo_online");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onSuccess(MediaPlayer.MediaLaunchObject launchObject) {
                    launchObject.toString();
                    loading.setVisibility(View.GONE);
                    try {
                        kapil_developer_ut_mb.trackCast(kapil_developer_remote.this, "cast_success", kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getId(), kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()), "cast_photo_online");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void photoAutoChange() {
        text.setVisibility(View.VISIBLE);
        setTime = new TimeSet(4000L, 1000L).start();
    }

    private class TimeSet extends CountDownTimer {
        public TimeSet(long l, long l1) {
            super(l, l1);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            text.setText("" + (millisUntilFinished / 1000));
            try {
                TextView textView = durationVideo;
                textView.setText("" + (millisUntilFinished / 1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFinish() {
            try {
                position++;
                if (start == 0) {
                    if (kapildevelopermdvideomedia != null && kapildevelopermdvideomedia.size() > 0) {
                        if (position >= kapildevelopermdvideomedia.size()) {
                            position = 0;
                        }
                        kapil_developer_im_take.log.e(((kapil_developer_md_video_media) kapildevelopermdvideomedia.get(position)).getUri(), String.valueOf(kapil_developer_remote.this), new CountTimeSrart());
                    }
                }
                view_pager.setCurrentItem(position, true);
                photoAutoChange();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    private class CountTimeSrart extends Throwable implements kapil_developer_if_photo_if {
        @Override
        public void Slider(String slide) {
            castPhoto(slide);
        }
    }

    public void castPhoto(String casts) {
        try {
            kapil_developer_ut_mb.trackCast(this, "start_cast", kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getId(), kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()), "cast_photo_off");
        } catch (Exception e) {
            e.printStackTrace();
        }
        loading.setVisibility(View.VISIBLE);
        Viewport = nextVideoCast(8000, 999);
        try {
            Glide.with((FragmentActivity) this).asBitmap().load(casts).centerCrop().into(PhotoMst);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (kapildevelopermdvideomedia.size() < 1) {
            return;
        }
        try {
            kapil_developer_http kapildeveloperhttp = this.kapildeveloperhttp;
            if (kapildeveloperhttp != null) {
                kapildeveloperhttp.stop();
            }
            kapil_developer_http serveHTTPD22 = new kapil_developer_http(this.Viewport);
            this.kapildeveloperhttp = serveHTTPD22;
            serveHTTPD22.start();
            String formatIpAddress = Formatter.formatIpAddress(((WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getIpAddress());
            if (!casts.contains("http")) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(new File(casts).getAbsolutePath(), options);
                int i = options.outHeight;
                int i2 = options.outWidth;
                casts = "http://" + formatIpAddress + ":" + Viewport + kapildevelopermdvideomedia.get(position).getUri();
                if (kapil_developer_ut_tv_connect.getInstance().connectCrome) {
                    try {
                        kapil_developer_xc.photoDisplay(casts, String.valueOf(i), String.valueOf(i2), "0");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                loading.setVisibility(View.GONE);
                            }
                        });
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(kapildevelopermdvideomedia.size());
            stringBuilder.append("");
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(position);
            stringBuilder1.append("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (kapil_developer_ut_tv_connect.getInstance().getConnectableDevice() == null) {
            return;
        }
        try {
            ((MediaPlayer) kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getCapability(MediaPlayer.class)).displayImage(new MediaInfo.Builder(casts, "image/jpeg").setTitle(getString(R.string.cast_photo)).setDescription("" + casts).build(), new MediaPlayer.LaunchListener() { // from class: com.screenmirror.proapp.screen.tab.playcast.PlayCastActivity.31
                @Override
                public void onError(ServiceCommandError error) {
                    error.toString();
                    loading.setVisibility(View.GONE);
                    try {
                        kapil_developer_ut_mb.trackCast(kapil_developer_remote.this, "cast_fail", kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getId(), kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()), "cast_photo_off");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onSuccess(MediaPlayer.MediaLaunchObject launchObject) {
                    launchObject.toString();
                    loading.setVisibility(View.GONE);
                    try {
                        kapil_developer_ut_mb.trackCast(kapil_developer_remote.this, "cast_success", kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getId(), kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()), "cast_photo_off");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void CastScreenPlayYoutube(String you) {
        if (Viewport == 0) {
            Viewport = nextVideoCast(8000, 999);
        }
        try {
            Glide.with((FragmentActivity) this).load(kapil_developer_dtum.getInstance().thumbnailCrome).centerCrop().placeholder(R.drawable.default_image).into(setVideo);
            videoName.setText(kapil_developer_dtum.getInstance().nameCrome);
            if (kapil_developer_ut_tv_connect.getInstance().connectCrome) {
                kapil_developer_xc.videoPlay(you);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loading.setVisibility(View.GONE);
                    }
                });
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            kapil_developer_http kapildeveloperhttp = this.kapildeveloperhttp;
            if (kapildeveloperhttp != null) {
                kapildeveloperhttp.stop();
            }
            kapil_developer_http serveHTTPD22 = new kapil_developer_http(this.Viewport);
            this.kapildeveloperhttp = serveHTTPD22;
            serveHTTPD22.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Formatter.formatIpAddress(((WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getIpAddress());
        file = new File(you);
        try {
            MediaInfo build = new MediaInfo.Builder(you, "video/mp4").setTitle(this.file.getName()).setDescription("Casting your Video").build();
            build.getUrl();
            ((MediaPlayer) kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getCapability(MediaPlayer.class)).playMedia(build, true, new MediaPlayer.LaunchListener() { // from class: com.screenmirror.proapp.screen.tab.playcast.PlayCastActivity.13
                @Override
                public void onError(ServiceCommandError error) {
                    error.toString();
                    isplaying = false;
                    loading.setVisibility(View.GONE);
                    try {
                        kapil_developer_ut_mb.trackCast(kapil_developer_remote.this, "cast_fail", kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getId(), kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()), "cast_youtube");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onSuccess(MediaPlayer.MediaLaunchObject launchObject) {
                    launchObject.toString();

                    isplaying = true;
                    playVideo.setImageResource(R.drawable.vd_pause);
                    timesetDuration(launchObject);
                    loading.setVisibility(View.GONE);
                    try {
                        kapil_developer_ut_mb.trackCast(kapil_developer_remote.this, "cast_success", kapil_developer_ut_tv_connect.getInstance().getConnectableDevice().getId(), kapil_developer_ut_tv_utls.getTVcatgary(kapil_developer_ut_tv_connect.getInstance().getConnectableDevice()), "cast_youtube");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int nextVideoCast(int port, int tim) {
        Random random = new Random();
        int number = random.nextInt(tim);
        while (true) {
            int i = number + port;
            if (LocalPort(i)) {
                return i;
            }
            number = random.nextInt(tim);
        }
    }

    private boolean LocalPort(int i) {
        try {
            new ServerSocket(i).close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void showButtonSheetAudio() {
        MusicListShow();
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.cast_tv_screen_item);
        DragRecyclerView dragRecyclerView = (DragRecyclerView) bottomSheetDialog.findViewById(R.id.rcv_quickly_list);
        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialog) {
            }
        });
        String title = kapildevelopermdaudiomodels.get(position).getTitle();
        currentName = title;
        kapildevelopersongcast = new kapil_developer_song_cast(this, (ArrayList) kapildevelopermdaudiomodels, title);
        dragRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dragRecyclerView.setAdapter(kapildevelopersongcast);
        List<kapil_developer_md_audio_model> modelList = kapildevelopermdaudiomodels;
        if (modelList != null) {
            int size = modelList.size();
            int i = position;
            if (size > i) {
                dragRecyclerView.scrollToPosition(i);
            }
        }
        kapildevelopersongcast.setHandleDragEnabled(true);
        kapildevelopersongcast.setLongPressDragEnabled(true);
        kapildevelopersongcast.setSwipeEnabled(true);
        kapildevelopersongcast.setListener(new kapil_developer_song_cast.songSlidClick() {
            @Override
            public void onClickItem(kapil_developer_md_audio_model kapildevelopermdaudiomodel, int pos) {
                try {
                    position = pos;
                    CastScreenPlayMusic();
                    bottomSheetDialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDeleteItem(kapil_developer_md_audio_model kapildevelopermdaudiomodel, int pos) {
                try {
                    if (kapildevelopermdaudiomodels.size() <= pos) {
                        return;
                    }
                    kapildevelopersongcast.onSwiped(pos);
                    kapildevelopersongcast.notifyItemRemoved(pos);
                    MusicurrentSetPlay();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        kapildevelopersongcast.setOnItemDragListener(new SimpleDragListener() {
            @Override

            public void onDrop(int fromPosition, int toPosition) {
                super.onDrop(fromPosition, toPosition);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onDrop ");
                stringBuilder.append(fromPosition);
                stringBuilder.append(" -> ");
                stringBuilder.append(toPosition);
                MusicurrentSetPlay();
            }

            @Override
            public void onSwiped(int position) {
                super.onSwiped(position);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onSwiped ");
                stringBuilder.append(position);
                kapildevelopersongcast.notifyDataSetChanged();
                MusicurrentSetPlay();
            }
        });
        bottomSheetDialog.show();
    }

    private void MusicListShow() {
        kapil_developer_song_cast kapildevelopersongcast = this.kapildevelopersongcast;
        if (kapildevelopersongcast == null || kapildevelopersongcast.getData() == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" size :");
        stringBuilder.append(kapildevelopersongcast.getData().size());
        ArrayList arrayList = new ArrayList();
        kapildevelopermdaudiomodels = arrayList;
        arrayList.addAll(kapildevelopersongcast.getData());
    }

    public void MusicurrentSetPlay() {
        VideoListShow();
        for (int i = 0; i < kapildevelopermdaudiomodels.size(); i++) {
            if (kapildevelopermdaudiomodels.get(i).getTitle().equalsIgnoreCase(currentName)) {
                position = i;
                return;
            }
        }
    }

    private void performKeypress(kapil_developer_val_board keyValues) {
        if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("performKeypress: ");
        }
    }

    @Override
    public void onBackPressed() {
        if (isplaying) {
            PhotoPlayer.setImageResource(R.drawable.ic_play);
            isplaying = false;
            durationVideo.setVisibility(View.GONE);
            if (setTime != null) {
                setTime.cancel();
            }
            text.setVisibility(View.GONE);
            Toast.makeText(this, "Please Back Again", Toast.LENGTH_SHORT).show();
        } else {
            kapil_developer_Inter.back(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}