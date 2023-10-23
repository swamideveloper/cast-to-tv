package kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cc.kapil_developer_yt_adp;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cc.kapil_developer_md_yt;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_listner;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_yt_click;
import kapil.cast.video.screenmirroring.smarttv.R;


public class kapil_developer_yt extends BottomSheetDialogFragment {
    public static kapil_developer_yt kapildeveloperyt;
    ImageView closeDialoge, guideDialoge;
    RecyclerView recyclerView;
    TextView helpDialoge;
    kapil_developer_yt_adp kapildeveloperytadp;
    ArrayList<kapil_developer_md_yt> kapildevelopermdyts = new ArrayList<>();
    Boolean bools = Boolean.FALSE;
    kapil_developer_if_listner kapildeveloperiflistner;


    public static kapil_developer_yt getInstance() {
        if (kapildeveloperyt == null) {
            kapildeveloperyt = new kapil_developer_yt();
        }
        return kapildeveloperyt;
    }

    public void setListener(kapil_developer_if_listner kapildeveloperiflistner) {
        this.kapildeveloperiflistner = kapildeveloperiflistner;
    }

    public void setData(ArrayList<kapil_developer_md_yt> arrayList) {
        try {
            ArrayList<kapil_developer_md_yt> arrayList2 = new ArrayList<>();
            this.kapildevelopermdyts = arrayList2;
            arrayList2.addAll(arrayList);
            this.kapildeveloperytadp.setData(this.kapildevelopermdyts);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.cast_tv_screen_dlg, viewGroup, false);

        closeDialoge = inflate.findViewById(R.id.closeDialoge);
        guideDialoge = inflate.findViewById(R.id.guideDialoge);
        recyclerView = inflate.findViewById(R.id.recyclerView);
        helpDialoge = inflate.findViewById(R.id.helpDialoge);

        kapildeveloperytadp = new kapil_developer_yt_adp(getActivity(), this.kapildevelopermdyts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(this.kapildeveloperytadp);
        kapildeveloperytadp.setClickItem(new kapil_developer_if_yt_click() {
            @Override
            public void onItemClick(int i) {
                if (kapildeveloperiflistner != null) {
                    kapildeveloperiflistner.onClick(i);
                }
            }
        });
        closeDialoge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        guideDialoge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bools.booleanValue()) {
                    helpDialoge.setVisibility(View.VISIBLE);
                    bools = Boolean.TRUE;
                    return;
                }
                helpDialoge.setVisibility(View.GONE);
                bools = Boolean.FALSE;
            }
        });
        return inflate;
    }


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

}
