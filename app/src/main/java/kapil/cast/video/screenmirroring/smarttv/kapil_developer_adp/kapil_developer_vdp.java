package kapil.cast.video.screenmirroring.smarttv.kapil_developer_adp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_vs;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_video_listner;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_video_media;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut.kapil_developer_ut_media_utlis;

public class kapil_developer_vdp extends RecyclerView.Adapter<kapil_developer_vdp.ViewHolder> {
    Context context;
    List<kapil_developer_md_video_media> kapildevelopermdvideomedia;
    kapil_developer_if_video_listner kapildeveloperifvideolistner;
    int catagary;

    public kapil_developer_vdp(ArrayList arrayList, kapil_developer_vs kapildevelopervs, int defaultKeysShortcut) {
        catagary = 0;
        kapildevelopermdvideomedia = arrayList;
        context = kapildevelopervs;
        catagary = defaultKeysShortcut;
    }

    public void setClickItem(kapil_developer_if_video_listner kapildeveloperifvideolistner) {
        this.kapildeveloperifvideolistner = kapildeveloperifvideolistner;
    }
    @NonNull
    @Override
    public kapil_developer_vdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.cast_tv_screen_it_vd, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull kapil_developer_vdp.ViewHolder holder, int position) {
        holder.MediaFile(kapildevelopermdvideomedia.get(position), position);
    }

    @Override
    public int getItemCount() {
        return kapildevelopermdvideomedia.size();
    }

    public void setData(ArrayList<kapil_developer_md_video_media> arrayList) {
        kapildevelopermdvideomedia.clear();
        kapildevelopermdvideomedia.addAll(arrayList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageVideo;
        TextView duration, filename;
        RelativeLayout time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageVideo = itemView.findViewById(R.id.imageVideo);
            duration = itemView.findViewById(R.id.duration);
            time = itemView.findViewById(R.id.time);
            filename = itemView.findViewById(R.id.filename);
        }

        public void MediaFile(kapil_developer_md_video_media kapildevelopermdvideomedia, int position) {
            Glide.with(context).load(kapildevelopermdvideomedia.getUri()).placeholder(R.drawable.default_image).centerCrop().into(imageVideo);
            filename.setText(kapildevelopermdvideomedia.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    kapildeveloperifvideolistner.videoClick(kapil_developer_vdp.this.kapildevelopermdvideomedia, position);

                }
            });
            if (catagary == 2){
                duration.setText(kapil_developer_ut_media_utlis.formatTime(kapildevelopermdvideomedia.getDuration()));
            }
        }
    }
}
