package kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_dlg_click;
import kapil.cast.video.screenmirroring.smarttv.R;

public class kapil_developer_alr extends Dialog {
    TextView cancle, done;
    kapil_developer_if_dlg_click setdialogeClick;

    public kapil_developer_alr(Context context, kapil_developer_if_dlg_click setdialogeClick2) {
        super(context);
        setdialogeClick = setdialogeClick2;

    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.cast_tv_screen_dll);
        cancle = findViewById(R.id.cancle);
        done = findViewById(R.id.done);
        cancle.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                dismiss();
            }
        });
        done.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (setdialogeClick != null) {
                    setdialogeClick.onClick();
                }
                dismiss();
            }
        });
    }

}
