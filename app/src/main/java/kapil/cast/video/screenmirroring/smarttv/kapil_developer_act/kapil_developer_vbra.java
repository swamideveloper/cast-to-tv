package kapil.cast.video.screenmirroring.smarttv.kapil_developer_act;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatDialogFragment;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_res_model;
import kapil.cast.video.screenmirroring.smarttv.R;


public class kapil_developer_vbra extends AppCompatDialogFragment {
    TextView textView;
    Context context;
    int position = 0;
    VideoView videoView;
    kapil_developer_md_res_model kapildevelopermdresmodel;

    public kapil_developer_vbra(kapil_developer_md_res_model kapildevelopermdresmodel) {
        this.kapildevelopermdresmodel = kapildevelopermdresmodel;
    }

    @Override
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.cast_tv_screen_vd_bra, (ViewGroup) null);
        context = getContext();
        builder.setView(inflate).setPositiveButton(this.context.getString(R.string.Close), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        videoView =  inflate.findViewById(R.id.videoview);
        textView =  inflate.findViewById(R.id.textview);
        if (bundle != null) {
            position = bundle.getInt("play_time");
        }
        MediaController mediaController = new MediaController(inflate.getContext());
        mediaController.setMediaPlayer(this.videoView);
        this.videoView.setMediaController(mediaController);
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        PlayerView();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT < 24) {
            videoView.pause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        PlayerStart();
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("play_time", this.videoView.getCurrentPosition());
    }


    private void PlayerView() {
        textView.setVisibility(View.VISIBLE);
        videoView.setVideoURI(getMedia(this.kapildevelopermdresmodel.getURL()));
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return false;
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                textView.setVisibility(4);
                if (position > 0) {
                    videoView.seekTo(position);
                } else {
                    videoView.seekTo(1);
                }
                videoView.start();
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.seekTo(0);
            }
        });
    }

    private void PlayerStart() {
        this.videoView.stopPlayback();
    }

    private Uri getMedia(String str) {
        if (URLUtil.isValidUrl(str)) {
            return Uri.parse(str);
        }
        return Uri.parse("android.resource://" + getActivity().getPackageName() + "/raw/" + str);
    }
}
