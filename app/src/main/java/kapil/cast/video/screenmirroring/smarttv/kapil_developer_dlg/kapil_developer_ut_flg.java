package kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_adp.kapil_developer_dl_adp;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_cast_cat;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_res_model;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_var;


public class kapil_developer_ut_flg extends Dialog {
    kapil_developer_cast_cat kapildevelopercastcat;
    Activity activity;
    ImageButton closeDialoges;
    ImageView noDatafound;
    private boolean isShowError;
    RecyclerView recyclerView;

    public kapil_developer_ut_flg(Activity activity, kapil_developer_cast_cat kapildevelopercastcat, boolean bools) {
        super(activity);
        this.isShowError = false;
        this.activity = activity;
        this.kapildevelopercastcat = kapildevelopercastcat;
        this.isShowError = bools;
    }


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.cast_tv_screen_file);
        getWindow().setLayout(-1, -1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(getWindow().getAttributes());
        getWindow().setAttributes(layoutParams);

        noDatafound = findViewById(R.id.noDatafound);
        closeDialoges = findViewById(R.id.closeDialoges);
        recyclerView = findViewById(R.id.recycler_View);
        ArrayList<kapil_developer_md_res_model> arrayList = kapil_developer_ut_var.resorcesType(this.kapildevelopercastcat);
        Activity activity = this.activity;
        kapil_developer_dl_adp kapildeveloperdladp = new kapil_developer_dl_adp(activity, this.kapildevelopercastcat, activity, new ArrayList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(kapildeveloperdladp);
        if (arrayList != null && arrayList.size() > 0) {
            kapildeveloperdladp.setData(arrayList);
        }
        if (isShowError) {
            noDatafound.setVisibility(View.VISIBLE);
        } else {
            noDatafound.setVisibility(View.GONE);
        }
        closeDialoges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

}
