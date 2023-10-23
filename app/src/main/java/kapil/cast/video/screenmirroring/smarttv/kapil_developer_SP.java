package kapil.cast.video.screenmirroring.smarttv;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bytedance.safesdk.ByteDance_SafeSdk_Manager;
import com.bytedance.safesdk.ByteDance_SafeSdk_SP;
import com.bytedance.safesdk.ByteDance_SafeSdk_List;

import org.json.JSONObject;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_main;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_intro.kapil_developer_pref;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ln.kapil_developer_LN;

public class kapil_developer_SP extends ByteDance_SafeSdk_SP {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_sp);

        CCTAL_ADSinit(this, cidam_366_366_getCurrentVersionCode(), new ByteDance_SafeSdk_List() {
            @Override
            public void CCTAL_onSuccess() {
                cidam_366_366_MoveToNext();
            }

            @Override
            public void CCTAL_onUpdate(String url) {
                cidam_366_366_showUpdateDialog(url);
            }

            @Override
            public void CCTAL_onRedirect(String url) {
                cidam_366_366_showRedirectDialog(url);
            }

            @Override
            public void CCTAL_onReload() {
                startActivity(new Intent(kapil_developer_SP.this, kapil_developer_SP.class));
                finish();
            }

            @Override
            public void CCTAL_onGetExtradata(JSONObject extraData) {
            }
        });

    }


    public int cidam_366_366_getCurrentVersionCode() {
        PackageManager cidam_366_366_manager = getPackageManager();
        PackageInfo cidam_366_366_info = null;
        try {
            cidam_366_366_info = cidam_366_366_manager.getPackageInfo(
                    getPackageName(), 0);
            return cidam_366_366_info.versionCode;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void cidam_366_366_showRedirectDialog(final String url) {
        final Dialog cidam_366_366_dialog = new Dialog(kapil_developer_SP.this);
        cidam_366_366_dialog.setCancelable(false);
        View cidam_366_366_view = getLayoutInflater().inflate(R.layout.cast_tv_screen_ins, null);
        cidam_366_366_dialog.setContentView(cidam_366_366_view);
        TextView cidam_366_366_update = cidam_366_366_view.findViewById(R.id.cidam_366_366_update);
        TextView cidam_366_366_txt_title = cidam_366_366_view.findViewById(R.id.cidam_366_366_txt_title);
        TextView cidam_366_366_txt_decription = cidam_366_366_view.findViewById(R.id.cidam_366_366_txt_decription);

        cidam_366_366_update.setText("Install Now");
        cidam_366_366_txt_title.setText("Install our new app now and enjoy");
        cidam_366_366_txt_decription.setText("We have transferred our server, so install our new app by clicking the button below to enjoy the new features of app.");

        cidam_366_366_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                } catch (ActivityNotFoundException ignored1) {
                    try {
                        Uri cidam_366_366_marketUri = Uri.parse(url);
                        Intent cidam_366_366_marketIntent = new Intent(Intent.ACTION_VIEW, cidam_366_366_marketUri);
                        startActivity(cidam_366_366_marketIntent);
                    } catch (ActivityNotFoundException e) {
                    }
                }
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cidam_366_366_dialog.create();
        }

        cidam_366_366_dialog.show();
        Window cidam_366_366_window = cidam_366_366_dialog.getWindow();
        cidam_366_366_window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        cidam_366_366_window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

    }

    public void cidam_366_366_showUpdateDialog(final String url) {
        final Dialog cidam_366_366_dialog = new Dialog(kapil_developer_SP.this);
        cidam_366_366_dialog.setCancelable(false);
        View cidam_366_366_view = getLayoutInflater().inflate(R.layout.cast_tv_screen_ins, null);
        cidam_366_366_dialog.setContentView(cidam_366_366_view);
        TextView cidam_366_366_update = cidam_366_366_view.findViewById(R.id.cidam_366_366_update);
        TextView cidam_366_366_txt_title = cidam_366_366_view.findViewById(R.id.cidam_366_366_txt_title);
        TextView cidam_366_366_txt_decription = cidam_366_366_view.findViewById(R.id.cidam_366_366_txt_decription);

        cidam_366_366_update.setText("Update Now");
        cidam_366_366_txt_title.setText("Update our new app now and enjoy");
        cidam_366_366_txt_decription.setText("");
        cidam_366_366_txt_decription.setVisibility(View.GONE);

        cidam_366_366_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Uri cidam_366_366_marketUri = Uri.parse(url);
                    Intent cidam_366_366_marketIntent = new Intent(Intent.ACTION_VIEW, cidam_366_366_marketUri);
                    startActivity(cidam_366_366_marketIntent);
                } catch (ActivityNotFoundException ignored1) {
                }
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cidam_366_366_dialog.create();
        }

        cidam_366_366_dialog.show();
        Window cidam_366_366_window = cidam_366_366_dialog.getWindow();
        cidam_366_366_window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        cidam_366_366_window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

    }

    private void cidam_366_366_MoveToNext() {
//        Intent cidam_366_366_i = null;
//        if (ByteDance_SafeSdk_Manager.CCTAL_ExtraScreen1.equals("1") && new SCL_Shared(kapil_developer_SP.this).scl_isFirstTimePrivacy()) {
//            cidam_366_366_i = new Intent(kapil_developer_SP.this, SCL_PrivacyPolicyActivity.class);
//
//        } else if (ByteDance_SafeSdk_Manager.CCTAL_ExtraScreen2.equals("1") && new SCL_Shared(kapil_developer_SP.this).scl_isFirstIntro()) {
//            cidam_366_366_i = new Intent(kapil_developer_SP.this, SCL_IntroActivity.class);
//
//        }   else {
//            cidam_366_366_i = new Intent(kapil_developer_SP.this, SCL_StartActivity.class);
//        }
//        startActivity(cidam_366_366_i);
//        finish();

//        startActivity(new Intent(kapil_developer_SP.this, kapil_developer_main.class));


        if (ByteDance_SafeSdk_Manager.CCTAL_ExtraScreen1.equals("1")) {
            if (new kapil_developer_pref(kapil_developer_SP.this).getFirstTime()) {
                startActivity(new Intent(kapil_developer_SP.this, kapil_developer_LN.class).putExtra("pro_inter", false));
            } else {
                startActivity(new Intent(kapil_developer_SP.this, kapil_developer_main.class).putExtra("pro_inter", false));
            }
        } else {
            startActivity(new Intent(kapil_developer_SP.this, kapil_developer_main.class).putExtra("pro_inter", false));
        }

        finish();
    }
}