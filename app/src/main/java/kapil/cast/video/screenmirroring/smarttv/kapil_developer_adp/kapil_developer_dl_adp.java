package kapil.cast.video.screenmirroring.smarttv.kapil_developer_adp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.siyamed.shapeimageview.RoundedImageView;

import java.util.ArrayList;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_cd;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_remote;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_vbra;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_dtum;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr.kapil_developer_cast_cat;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_dlg.kapil_developer_img;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_res_model;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_tv_connect;


public class kapil_developer_dl_adp extends RecyclerView.Adapter<kapil_developer_dl_adp.MyViewHolder> {
    kapil_developer_cast_cat kapil_developer_cast_cat;
    Activity activity;
    ArrayList<kapil_developer_md_res_model> kapildevelopermdresmodels;
    Context context;

    public kapil_developer_dl_adp(Context context, kapil_developer_cast_cat _typeCastVar, Activity activity, ArrayList<kapil_developer_md_res_model> arrayList) {
        this.context = context;
        this.activity = activity;
        this.kapil_developer_cast_cat = _typeCastVar;
        this.kapildevelopermdresmodels = arrayList;
    }

    public void setData(ArrayList<kapil_developer_md_res_model> arrayList) {
        this.kapildevelopermdresmodels.clear();
        this.kapildevelopermdresmodels.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override 
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cast_tv_screen_u, viewGroup, false));
    }

    @Override 
    public void onBindViewHolder(MyViewHolder viewHolder, final int i) {
        try {
            final kapil_developer_md_res_model kapildevelopermdresmodel = this.kapildevelopermdresmodels.get(i);
            if (kapildevelopermdresmodel != null && kapildevelopermdresmodel.getSizeItem() != null && !kapildevelopermdresmodel.getSizeItem().equals("")) {
                viewHolder.videoViewSize.setText(kapildevelopermdresmodel.getSizeItem());
            }
            if (kapildevelopermdresmodel == null) {
                return;
            }
            TextView textView = viewHolder.videoViewName;
            textView.setText(kapildevelopermdresmodel.getTitles() + "");
            if (this.kapil_developer_cast_cat == kapil_developer_cast_cat.IMAGE) {
                Glide.with(this.context).load(kapildevelopermdresmodel.getURL()).placeholder(R.drawable.default_image).error(R.drawable.default_image).into(viewHolder.videoThumbnail);
            }

            viewHolder.videoThumbnail.setOnClickListener(new View.OnClickListener() {
                @Override 
                public void onClick(View view) {
                    if (kapildevelopermdresmodel.getFile_type() == kapil_developer_cast_cat.IMAGE) {
                        kapil_developer_img kapildeveloperimg = new kapil_developer_img(kapil_developer_dl_adp.this.context);
                        kapildeveloperimg.setLinkUrl(kapildevelopermdresmodel.getURL());
                        kapildeveloperimg.show();
                    }
                }
            });
            viewHolder.castClick.setOnClickListener(new View.OnClickListener() {
                @Override 
                public void onClick(View view) {
                    if (!kapil_developer_ut_tv_connect.getInstance().isConnect()) {
                        kapil_developer_dl_adp.this.context.startActivity(new Intent(kapil_developer_dl_adp.this.context, kapil_developer_cd.class));
                        return;
                    }
                    Intent intent = new Intent(kapil_developer_dl_adp.this.context, kapil_developer_remote.class);

                        if (kapildevelopermdresmodel.getFile_type() == kapil_developer_cast_cat.IMAGE) {
                        kapil_developer_dtum.getInstance().setType(9);
                        kapil_developer_dtum.getInstance().setPosition(i);
                    }

                    kapil_developer_dtum.getInstance().nameCrome = kapildevelopermdresmodel.getTitles();
                    kapil_developer_dtum.getInstance().videoPathCrome = kapildevelopermdresmodel.getURL();
                    kapil_developer_dtum.getInstance().thumbnailCrome = kapildevelopermdresmodel.getURL();
                    kapil_developer_dtum.getInstance().timeDuration = 0L;
                    kapil_developer_dl_adp.this.context.startActivity(intent);
                }
            });
            viewHolder.ReviewShow.setOnClickListener(new View.OnClickListener() {
                @Override 
                public void onClick(View view) {
                    kapildevelopermdresmodel.getURL();
                    kapil_developer_dl_adp.this.getMedia(kapildevelopermdresmodel.getURL()).toString();
                    if (kapildevelopermdresmodel.getFile_type() == kapil_developer_cast_cat.VIDEO || kapildevelopermdresmodel.getFile_type() == kapil_developer_cast_cat.AUDIO) {
                        new kapil_developer_vbra(kapildevelopermdresmodel).show(((FragmentActivity) kapil_developer_dl_adp.this.context).getSupportFragmentManager(), "TAG");
                    } else if (kapildevelopermdresmodel.getFile_type() != kapil_developer_cast_cat.IMAGE) {

                    } else {
                        kapil_developer_img kapildeveloperimg = new kapil_developer_img(kapil_developer_dl_adp.this.context);
                        kapildeveloperimg.setLinkUrl(kapildevelopermdresmodel.getURL());
                        kapildeveloperimg.show();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
    public Uri getMedia(String str) {
        if (URLUtil.isValidUrl(str)) {
            return Uri.parse(str);
        }
        return Uri.parse("android.resource://" + this.context.getPackageName() + "/raw/" + str);
    }

    @Override 
    public int getItemCount() {
        return this.kapildevelopermdresmodels.size();
    }

    
    public class MyViewHolder extends RecyclerView.ViewHolder {

      RoundedImageView videoThumbnail;
      TextView videoViewName,castClick,ReviewShow,videoViewSize;

        public MyViewHolder(kapil_developer_dl_adp kapildeveloperdladp, View view) {
            super(view);
            videoThumbnail =  view.findViewById(R.id.videoThumbnail);
            videoViewName =  view.findViewById(R.id.videoViewName);
            castClick =  view.findViewById(R.id.castClick);
            videoViewSize =  view.findViewById(R.id.videoViewSize);
            ReviewShow =  view.findViewById(R.id.reviewShow);
        }
    }
}
