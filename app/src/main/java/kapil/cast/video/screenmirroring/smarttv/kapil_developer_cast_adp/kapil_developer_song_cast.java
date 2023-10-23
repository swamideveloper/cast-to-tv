package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cast_adp;

import android.content.Context;
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

import java.util.ArrayList;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_audio_model;
import kapil.cast.video.screenmirroring.smarttv.R;


public class kapil_developer_song_cast extends DragAdapter {
    ArrayList<kapil_developer_md_audio_model> kapildevelopermdaudiomodels;
    Context cast;
    songSlidClick songSlidClick;
    String setClik;


    public interface songSlidClick {
        void onClickItem(kapil_developer_md_audio_model kapildevelopermdaudiomodel, int i);

        void onDeleteItem(kapil_developer_md_audio_model kapildevelopermdaudiomodel, int i);
    }

    public kapil_developer_song_cast(Context context, ArrayList<kapil_developer_md_audio_model> arrayList, String str) {
        super(context, arrayList);
        this.kapildevelopermdaudiomodels = new ArrayList<>();
        this.setClik = "";
        this.kapildevelopermdaudiomodels = arrayList;
        this.cast = context;
        this.setClik = str;
    }

    public void setListener(songSlidClick songSlidClick) {
        this.songSlidClick = songSlidClick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new Holder(LayoutInflater.from(getContext()).inflate(R.layout.cast_tv_screen_vd_imm, viewGroup, false), i);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        ((Holder) viewHolder).binData(this.kapildevelopermdaudiomodels.get(i), i);
    }


    private final class Holder extends DragHolder {
        ImageView videoThumb;
        ImageView close;
        RelativeLayout layoutItem;
        TextView songName;

        Holder(View view, int i) {
            super(view);
            songName =  view.findViewById(R.id.songName);
            videoThumb =  view.findViewById(R.id.videoThumb);
            close =  view.findViewById(R.id.close);
            layoutItem =  view.findViewById(R.id.layoutItem);
        }

        public void binData(final kapil_developer_md_audio_model kapildevelopermdaudiomodel, final int i) {
            Glide.with(kapil_developer_song_cast.this.cast).load(Integer.valueOf((int) R.drawable.audio_song_img)).into(this.videoThumb);
            this.songName.setText(kapildevelopermdaudiomodel.getTitle());
            if (kapil_developer_song_cast.this.setClik == null || kapil_developer_song_cast.this.setClik.isEmpty() || !kapil_developer_song_cast.this.setClik.equalsIgnoreCase(kapildevelopermdaudiomodel.getTitle())) {
                this.layoutItem.setBackgroundColor(kapil_developer_song_cast.this.cast.getResources().getColor(R.color.color_transparent));
            } else {
                this.layoutItem.setBackground(kapil_developer_song_cast.this.cast.getDrawable(R.drawable.item_select_back));
            }
            this.close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    kapil_developer_song_cast.this.songSlidClick.onDeleteItem(kapildevelopermdaudiomodel, i);
                }
            });
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    kapil_developer_song_cast.this.songSlidClick.onClickItem(kapildevelopermdaudiomodel, i);
                }
            });
        }
    }
}
