package kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_ref_listner;
import kapil.cast.video.screenmirroring.smarttv.R;


public class kapil_developer_ref_dlg extends Dialog {
    ImageView close;
    kapil_developer_if_ref_listner kapildeveloperifreflistner;
    RelativeLayout refresh;
    public kapil_developer_ref_dlg(Context context, kapil_developer_if_ref_listner kapildeveloperifreflistner1) {
        super(context);
        this.kapildeveloperifreflistner = kapildeveloperifreflistner1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.cast_tv_screen_ref);
        setCancelable(true);
        refresh = findViewById(R.id.refresh);
        close = findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                kapil_developer_ref_dlg.this.dismiss();
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
             kapildeveloperifreflistner.onClick();
             dismiss();
            }
        });
    }
}
