package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cast_adp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.siyamed.shapeimageview.RoundedImageView;

import java.util.List;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_bra_clk;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_res_model;
import kapil.cast.video.screenmirroring.smarttv.R;

public class kapil_developer_adp_img extends RecyclerView.Adapter<kapil_developer_adp_img.ViewHolder> {
    List<kapil_developer_md_res_model> kapildevelopermdresmodel;
    kapil_developer_if_bra_clk kapildeveloperifbraclk;
    Context context;
    public kapil_developer_adp_img(Context context, List<kapil_developer_md_res_model> list) {
        this.context = context;
        this.kapildevelopermdresmodel = list;
    }

    public void setOnclick(kapil_developer_if_bra_clk kapildeveloperifbraclk) {
        this.kapildeveloperifbraclk = kapildeveloperifbraclk;
    }

    @Override 
    public int getItemCount() {
        return this.kapildevelopermdresmodel.size();
    }

    @Override 
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.cast_tv_screen_pggg, viewGroup, false));
    }

    @Override 
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.imageBrowserData(this.kapildevelopermdresmodel.get(position), position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView roundedImageView;
        public ViewHolder(View view) {
            super(view);
            this.roundedImageView = (RoundedImageView) view.findViewById(R.id.round);
        }

        public void imageBrowserData(kapil_developer_md_res_model modaldownloaresVar, final int position) {
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    kapil_developer_adp_img.this.kapildeveloperifbraclk.clickItem(position);
                }
            });
            if (((kapil_developer_md_res_model) kapil_developer_adp_img.this.kapildevelopermdresmodel.get(position)).isSelected) {
                roundedImageView.setBorderColor(context.getResources().getColor(R.color.border_image));
            } else {
                roundedImageView.setBorderColor(context.getResources().getColor(R.color.color_transparent));
            }
            Glide.with(context).load(modaldownloaresVar.getURL()).placeholder(R.drawable.default_image).into(roundedImageView);
        }
    }
    public void setSelectedPosition(int selectedPosition) {
        for (kapil_developer_md_res_model modaldownloaresVar : kapildevelopermdresmodel) {
            modaldownloaresVar.isSelected = false;
        }
        kapildevelopermdresmodel.get(selectedPosition).isSelected = true;
        notifyDataSetChanged();
    }
    public void clearItems() {
        this.kapildevelopermdresmodel.clear();
    }
    public void addItems(List<kapil_developer_md_res_model> kapildevelopermdresmodels) {
        if (kapildevelopermdresmodels == null || kapildevelopermdresmodels.size() <= 0) {
            return;
        }
        kapildevelopermdresmodel.clear();
        kapildevelopermdresmodel.addAll(kapildevelopermdresmodels);
        if (kapildevelopermdresmodels.size() > 0) {
            kapildevelopermdresmodels.get(0).isSelected = true;
        }
        notifyDataSetChanged();
    }
}
