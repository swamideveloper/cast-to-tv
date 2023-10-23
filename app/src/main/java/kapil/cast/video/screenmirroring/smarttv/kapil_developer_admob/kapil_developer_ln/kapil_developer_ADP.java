package kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ln;



import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import org.jetbrains.annotations.NotNull;

import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_intro.kapil_developer_onboard;

public class kapil_developer_ADP extends RecyclerView.Adapter<kapil_developer_ADP.MyHolder> {

    Activity context;
    int[] langs;



    public kapil_developer_ADP(Activity context, int[] langs) {
        this.context = context;
        this.langs = langs;

    }


    @NotNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cast_tv_screen_lng_it, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyHolder holder, int position) {
        holder.imgCountry.setImageResource(langs[position]);
        holder.imgCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, kapil_developer_onboard.class).putExtra("pro_inter", true));
            }
        });
    }

    @Override
    public int getItemCount() {
        return langs.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView imgCountry, imgCheck;


        public MyHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgCountry = itemView.findViewById(R.id.imgCountry);
            imgCheck = itemView.findViewById(R.id.imgCheck);

        }
    }
}
