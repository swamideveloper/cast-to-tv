package kapil.cast.video.screenmirroring.smarttv.kapil_developer_act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_dis;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_tv_connect;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Inter;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Native;


public class kapil_developer_main extends AppCompatActivity {
    ConstraintLayout casttoTV, mirrore;
    ConstraintLayout youtube, online, video, photo, music;
    ImageView menu;
    FrameLayout adsContainer;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_main);

        if (getIntent().getBooleanExtra("pro_inter", false)){
            kapil_developer_Inter.inter(this);
        }

        casttoTV = findViewById(R.id.casttoTV);
        mirrore = findViewById(R.id.mirrore);
        youtube = findViewById(R.id.youtube);
        online = findViewById(R.id.online);
        video = findViewById(R.id.video);
        photo = findViewById(R.id.photo);
        music = findViewById(R.id.music);
        menu = findViewById(R.id.menu);
        adsContainer = findViewById(R.id.adsContainer);

        kapil_developer_Native.nativeads(this, findViewById(R.id.adsContainer));

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(kapil_developer_main.this, kapil_developer_setting.class));
            }
        });
        casttoTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (permissionStorage(2)) {
                    if (kapil_developer_ut_tv_connect.getInstance().isConnect()) {
                        new kapil_developer_dis(kapil_developer_main.this).show();
                        return;
                    }
                    startActivity(new Intent(kapil_developer_main.this, kapil_developer_cd.class));
                }
            }
        });
        mirrore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (permissionStorage(2)) {
                    startActivity(new Intent(kapil_developer_main.this, kapil_developer_smart.class));
                }
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (permissionStorage(2)) {
                    startActivity(new Intent(kapil_developer_main.this, kapil_developer_vs.class));
                }
            }
        });
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (permissionStorage(2)) {
                    startActivity(new Intent(kapil_developer_main.this, kapil_developer_img.class));
                }
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (permissionStorage(2)) {
                    startActivity(new Intent(kapil_developer_main.this, kapil_developer_audiocast.class));
                }
            }
        });
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (permissionStorage(2)) {
                    startActivity(new Intent(kapil_developer_main.this, kapil_developer_bra.class));
                }
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (permissionStorage(2)) {
                    startActivity(new Intent(kapil_developer_main.this, kapil_developer_yt.class));
                }
            }
        });
    }

    private boolean permissionStorage(int i) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (checkSelfPermission(Manifest.permission.READ_MEDIA_IMAGES) == PackageManager.PERMISSION_GRANTED &&
                        checkSelfPermission(Manifest.permission.READ_MEDIA_AUDIO) == PackageManager.PERMISSION_GRANTED &&
                        checkSelfPermission(Manifest.permission.READ_MEDIA_VIDEO) == PackageManager.PERMISSION_GRANTED) {
                    return true;
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_MEDIA_IMAGES,
                            Manifest.permission.READ_MEDIA_AUDIO,
                            Manifest.permission.READ_MEDIA_VIDEO}, i);
                    return false;
                }
            } else {
                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                        checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    return true;
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE}, i);
                    return false;
                }
            }

        } else {
            return true;
        }
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finishAffinity();
            System.exit(1);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
