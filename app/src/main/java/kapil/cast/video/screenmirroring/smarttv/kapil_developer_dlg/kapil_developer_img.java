package kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.jsibbold.zoomage.ZoomageView;

import kapil.cast.video.screenmirroring.smarttv.R;

public class kapil_developer_img extends Dialog {
    Context context;
    ImageView backPress;
    ZoomageView zoomView;
    String linkUrl = "";


    public kapil_developer_img(Context context2) {
        super(context2);
        this.context = context2;
    }

    public void setLinkUrl(String url) {
        this.linkUrl = url;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.cast_tv_screen_rw);
        zoomView = findViewById(R.id.zoomView);
        backPress = findViewById(R.id.backPress);
        if (linkUrl != null) {
            ((RequestBuilder) Glide.with(context).load(linkUrl).placeholder(R.drawable.default_image)).into(zoomView);
        }
        backPress.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                dismiss();
            }
        });
    }


}
