package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cast_adp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_res_model;
import kapil.cast.video.screenmirroring.smarttv.R;


public class kapil_developer_img extends PagerAdapter {
    List<kapil_developer_md_res_model> kapildevelopermdresmodels;

    @Override 
    public int getCount() {
        List<kapil_developer_md_res_model> list = this.kapildevelopermdresmodels;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public kapil_developer_img(List<kapil_developer_md_res_model> list) {
        this.kapildevelopermdresmodels = list;
    }

    @Override 
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cast_tv_screen_it_pager, viewGroup, false);
        Glide.with(viewGroup.getContext()).load(this.kapildevelopermdresmodels.get(i).getURL()).placeholder(R.drawable.default_image).into((ImageView) inflate.findViewById(R.id.imageView));
        viewGroup.addView(inflate);
        return inflate;
    }

    @Override 
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override 
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public void clearItems() {
        this.kapildevelopermdresmodels.clear();
    }

    public void addItems(List<kapil_developer_md_res_model> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.kapildevelopermdresmodels.clear();
        this.kapildevelopermdresmodels.addAll(list);
        if (list.size() > 0) {
            list.get(0).isSelected = true;
        }
        notifyDataSetChanged();
    }
}
