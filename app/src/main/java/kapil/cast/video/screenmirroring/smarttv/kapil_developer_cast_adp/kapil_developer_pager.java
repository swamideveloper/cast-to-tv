package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cast_adp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.siyamed.shapeimageview.RoundedImageView;

import java.io.File;
import java.util.List;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_click;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_video_media;
import kapil.cast.video.screenmirroring.smarttv.R;


public class kapil_developer_pager extends RecyclerView.Adapter<kapil_developer_pager.ChannelHolder> {
    Context context;
    kapil_developer_if_click kapildeveloperifclick;
    List<kapil_developer_md_video_media> kapildevelopermdvideomedia;


    public kapil_developer_pager(Context context, List<kapil_developer_md_video_media> list) {
        this.context = context;
        this.kapildevelopermdvideomedia = list;
    }

    public void setOnclick(kapil_developer_if_click kapildeveloperifclick) {
        this.kapildeveloperifclick = kapildeveloperifclick;
    }

    @Override 
    public int getItemCount() {
        return this.kapildevelopermdvideomedia.size();
    }

    @Override 
    public ChannelHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ChannelHolder(LayoutInflater.from(context).inflate(R.layout.cast_tv_screen_pggg, viewGroup, false));
    }

    @Override 
    public void onBindViewHolder(ChannelHolder channelHolder, int position) {
        channelHolder.imageItemData(kapildevelopermdvideomedia.get(position), position);
    }

    public class ChannelHolder extends RecyclerView.ViewHolder {
        RoundedImageView roundedImageView;

        public ChannelHolder(View view) {
            super(view);
            roundedImageView = (RoundedImageView) view.findViewById(R.id.round);
        }

        public void imageItemData(kapil_developer_md_video_media fileMedia, final int i) {
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override 
                public void onClick(View view) {
                    kapildeveloperifclick.clickItem(i);
                }
            });
            if (((kapil_developer_md_video_media) kapildevelopermdvideomedia.get(i)).isSelected) {
                roundedImageView.setBorderColor(context.getResources().getColor(R.color.border_image));
            } else {
                roundedImageView.setBorderColor(context.getResources().getColor(R.color.color_transparent));
            }
            Glide.with(context).load(Uri.fromFile(new File(fileMedia.getUri()))).into(roundedImageView);
        }
    }

    public void setSelectedPosition(int selectedPosition) {
        for (kapil_developer_md_video_media fileMedia : kapildevelopermdvideomedia) {
            fileMedia.isSelected = false;
        }
        kapildevelopermdvideomedia.get(selectedPosition).isSelected = true;
        notifyDataSetChanged();
    }

    public void clearItems() {
        kapildevelopermdvideomedia.clear();
    }

    public void addItems(List<kapil_developer_md_video_media> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        kapildevelopermdvideomedia.clear();
        kapildevelopermdvideomedia.addAll(list);
        if (list.size() > 0) {
            list.get(0).isSelected = true;
        }
        notifyDataSetChanged();
    }
}
