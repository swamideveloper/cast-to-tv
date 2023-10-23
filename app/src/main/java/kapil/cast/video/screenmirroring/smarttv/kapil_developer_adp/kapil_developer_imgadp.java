package kapil.cast.video.screenmirroring.smarttv.kapil_developer_adp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_img;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_video_listner;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_video_media;
import kapil.cast.video.screenmirroring.smarttv.R;

public class kapil_developer_imgadp extends RecyclerView.Adapter<kapil_developer_imgadp.ViewHolder> {
    Context context;
    List<kapil_developer_md_video_media> kapildevelopermdvideomedia;
    kapil_developer_if_video_listner kapildeveloperifvideolistner;
    int catagary;

    public kapil_developer_imgadp(ArrayList arrayList, kapil_developer_img kapildeveloperimg, int i) {
        catagary = 0;
        kapildevelopermdvideomedia = arrayList;
        context = kapildeveloperimg;
        catagary = i;
    }


    public void setClickItem(kapil_developer_if_video_listner kapildeveloperifvideolistner) {
        this.kapildeveloperifvideolistner = kapildeveloperifvideolistner;
    }

    @NonNull
    @Override
    public kapil_developer_imgadp.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new kapil_developer_imgadp.ViewHolder(LayoutInflater.from(context).inflate(R.layout.cast_tv_screen_imgnew, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull kapil_developer_imgadp.ViewHolder holder, int position) {
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

        ImageView imageViewphoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewphoto = itemView.findViewById(R.id.imageViewphoto);
        }

        public void MediaFile(kapil_developer_md_video_media kapildevelopermdvideomedia, int position) {
            Glide.with(context).load(kapildevelopermdvideomedia.getUri()).placeholder(R.drawable.default_image).centerCrop().into(imageViewphoto);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    kapildeveloperifvideolistner.videoClick(kapil_developer_imgadp.this.kapildevelopermdvideomedia, position);

                }
            });

        }
    }
}
