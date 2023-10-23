package kapil.cast.video.screenmirroring.smarttv.kapil_developer_adp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_audio;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_audio_model;
import kapil.cast.video.screenmirroring.smarttv.R;

public class kapil_developer_audio extends RecyclerView.Adapter<kapil_developer_audio.ViewHolder> {
    Context context;
    List<kapil_developer_md_audio_model> kapildevelopermdaudiomodels;
    kapil_developer_if_audio kapildeveloperifaudio;

    public kapil_developer_audio(List<kapil_developer_md_audio_model> arrayList, Context context) {
        kapildevelopermdaudiomodels = arrayList;
        this.context = context;

    }

    public void setData(ArrayList<kapil_developer_md_audio_model> arrayList) {
        kapildevelopermdaudiomodels.clear();
        kapildevelopermdaudiomodels.addAll(arrayList);
        notifyDataSetChanged();
    }
    public void setClickItem(kapil_developer_if_audio kapildeveloperifaudio) {
        this.kapildeveloperifaudio = kapildeveloperifaudio;
    }

    @NonNull
    @Override
    public kapil_developer_audio.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.cast_tv_screen_ad, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull kapil_developer_audio.ViewHolder holder, int position) {
        holder.AudioData(kapildevelopermdaudiomodels.get(position), position);
    }

    @Override
    public int getItemCount() {
        return kapildevelopermdaudiomodels.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameArtists, nameSong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameSong = itemView.findViewById(R.id.nameSong);
            nameArtists = itemView.findViewById(R.id.nameArtists);
        }

        public void AudioData(kapil_developer_md_audio_model kapildevelopermdaudiomodel, int position) {
            nameSong.setText(kapildevelopermdaudiomodel.getTitle());
            nameArtists.setText(kapildevelopermdaudiomodel.getArtist());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    kapildeveloperifaudio.videoClick(kapildevelopermdaudiomodels, position);
                }
            });
        }
    }
}
