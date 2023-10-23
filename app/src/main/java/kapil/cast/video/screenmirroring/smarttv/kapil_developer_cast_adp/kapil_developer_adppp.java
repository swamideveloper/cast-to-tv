package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cast_adp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wonshinhyo.dragrecyclerview.DragAdapter;
import com.wonshinhyo.dragrecyclerview.DragHolder;

import java.io.File;
import java.util.ArrayList;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_item_clk;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_video_media;
import kapil.cast.video.screenmirroring.smarttv.R;


public class kapil_developer_adppp extends DragAdapter {
    ArrayList<kapil_developer_md_video_media> kapildevelopermdvideomedia;
    Context context;
    kapil_developer_if_item_clk kapildeveloperifitemclk;
    String selectedItem;


    public kapil_developer_adppp(Context context, ArrayList<kapil_developer_md_video_media> arrayList, String str) {
        super(context, arrayList);
        this.kapildevelopermdvideomedia = new ArrayList<>();
        this.selectedItem = "";
        this.kapildevelopermdvideomedia = arrayList;
        this.context = context;
        this.selectedItem = str;
    }

    public void setListener(kapil_developer_if_item_clk kapildeveloperifitemclk) {
        this.kapildeveloperifitemclk = kapildeveloperifitemclk;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        return new Holder(LayoutInflater.from(getContext()).inflate(R.layout.cast_tv_screen_vd_imm, viewGroup, false), position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        ((Holder) viewHolder).VideoLilstData(this.kapildevelopermdvideomedia.get(i), i);
    }


    private final class Holder extends DragHolder {
        ImageView videoThumb;
        ImageView itemClose;
        RelativeLayout layoutItem;
        TextView songName;

        Holder(View view, int i) {
            super(view);
            songName = view.findViewById(R.id.songName);
            videoThumb = view.findViewById(R.id.videoThumb);
            itemClose = view.findViewById(R.id.close);
            layoutItem = view.findViewById(R.id.layoutItem);
        }

        public void VideoLilstData(final kapil_developer_md_video_media fileMedia, final int i) {
            Glide.with(context).load(Uri.fromFile(new File(fileMedia.getUri()))).into(videoThumb);
            songName.setText(fileMedia.getTitle());
            if (selectedItem == null || selectedItem.isEmpty() || !selectedItem.equalsIgnoreCase(fileMedia.getTitle())) {
                layoutItem.setBackgroundColor(context.getResources().getColor(R.color.color_transparent));
            } else {
                layoutItem.setBackground(context.getDrawable(R.drawable.item_select_back));
            }
            itemClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    kapildeveloperifitemclk.onDeleteItem(fileMedia, i);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    kapildeveloperifitemclk.onClickItem(fileMedia, i);
                }
            });
        }
    }
}
