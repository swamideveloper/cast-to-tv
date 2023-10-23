package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cast_adp;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_md.kapil_developer_md_video_media;
import kapil.cast.video.screenmirroring.smarttv.R;


public class kapil_developer_cast extends PagerAdapter {
    List<kapil_developer_md_video_media> kapildevelopermdvideomedia;

    @Override
    public int getCount() {
        List<kapil_developer_md_video_media> media = kapildevelopermdvideomedia;
        if (media == null) {
            return 0;
        }
        return media.size();
    }

    public kapil_developer_cast(List<kapil_developer_md_video_media> list) {
        kapildevelopermdvideomedia = list;
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, int position) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cast_tv_screen_it_pager, viewGroup, false);
        Glide.with(viewGroup.getContext()).load(Uri.fromFile(new File(kapildevelopermdvideomedia.get(position).getUri()))).into((ImageView) inflate.findViewById(R.id.imageView));
        viewGroup.addView(inflate);
        return inflate;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override
    public void destroyItem(ViewGroup viewGroup, int position, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public void clearItems() {
        kapildevelopermdvideomedia.clear();
    }

    public void addItems(List<kapil_developer_md_video_media> media) {
        if (media == null || media.size() <= 0) {
            return;
        }
        kapildevelopermdvideomedia.clear();
        kapildevelopermdvideomedia.addAll(media);
        if (media.size() > 0) {
            media.get(0).isSelected = true;
        }
        notifyDataSetChanged();
    }
}
