package kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_tv_connect;

public class kapil_developer_dis extends Dialog {
    Context context;
    TextView wifiname,off, show;

    public kapil_developer_dis(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_disconnect);

        off = findViewById(R.id.off);
        show = findViewById(R.id.show);
        wifiname = findViewById(R.id.wifiname);
        if (kapil_developer_ut_tv_connect.getInstance().getDeviveName() != null) {
            wifiname.setText("Disconnect with " + kapil_developer_ut_tv_connect.getInstance().getDeviveName());
        }
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kapil_developer_ut_tv_connect.getInstance() != null && kapil_developer_ut_tv_connect.getInstance().isConnect()) {
                    kapil_developer_ut_tv_connect.getInstance().isDisconnect();
                }
                dismiss();
            }
        });
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}