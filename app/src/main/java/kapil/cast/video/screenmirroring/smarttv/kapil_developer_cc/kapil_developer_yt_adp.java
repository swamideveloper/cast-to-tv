package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_yt_click;
import kapil.cast.video.screenmirroring.smarttv.R;


public class kapil_developer_yt_adp extends RecyclerView.Adapter<kapil_developer_yt_adp.ViewHolder> {
    Context context;
    ArrayList<kapil_developer_md_yt> kapildevelopermdyts;
    kapil_developer_if_yt_click kapildeveloperifytclick;



    public kapil_developer_yt_adp(Context context, ArrayList<kapil_developer_md_yt> arrayList, kapil_developer_if_yt_click kapildeveloperifytclick) {
        this.kapildevelopermdyts = new ArrayList<>();

        this.kapildeveloperifytclick = kapildeveloperifytclick;
    }
    public void setClickItem(kapil_developer_if_yt_click kapildeveloperifytclick) {
        this.kapildeveloperifytclick = kapildeveloperifytclick;
    }
    public kapil_developer_yt_adp(FragmentActivity activity, ArrayList<kapil_developer_md_yt> kapildevelopermdyts) {
        this.context = activity;
        this.kapildevelopermdyts = kapildevelopermdyts;
    }

    public void setData(ArrayList<kapil_developer_md_yt> arrayList) {
        this.kapildevelopermdyts.clear();
        this.kapildevelopermdyts.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, LayoutInflater.from(context).inflate(R.layout.cast_tv_screen_yt, viewGroup, false));
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        Glide.with(context).load(kapildevelopermdyts.get(i).getThubnails()).placeholder(R.drawable.default_image).centerCrop().into(viewHolder.videoThumb);
        viewHolder.mp.setText(kapildevelopermdyts.get(i).getVideoDataset());
        viewHolder.clearity.setText(kapildevelopermdyts.get(i).getClearity());
        viewHolder.songName.setText(kapildevelopermdyts.get(i).getVideoNames());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              kapildeveloperifytclick.onItemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kapildevelopermdyts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView videoThumb;
        TextView mp,songName,clearity;

        public ViewHolder(kapil_developer_yt_adp kapildeveloperytadp, View view) {
            super(view);
            videoThumb = view.findViewById(R.id.videoThumb);
            clearity = view.findViewById(R.id.clearity);
            songName = view.findViewById(R.id.songName);
            mp = view.findViewById(R.id.mp);
        }
    }
}
