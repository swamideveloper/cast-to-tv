package kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_intro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import kapil.cast.video.screenmirroring.smarttv.R;


public class kapil_developer_date extends PagerAdapter {
    private Context context;

    int[] intimg = new int[]{R.drawable.ic_onboarding1, R.drawable.ic_onboarding2, R.drawable.ic_onboarding3};

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public kapil_developer_date(Context context2) {
        this.context = context2;
    }

    @Override
    public int getCount() {
        return DontMobileObject.values().length;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        return this.context.getString(DontMobileObject.values()[i].getTitleResId());
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.context).inflate(DontMobileObject.values()[i].getLayoutResId(), viewGroup, false);
        viewGroup.addView(viewGroup2);

        String[] stringstitle = new String[]{""+context.getString(R.string.stronboarding1), ""+context.getString(R.string.stronboarding2), ""+context.getString(R.string.stronboarding3)};

        String[] stringssubtitle = new String[]{""+context.getString(R.string.strsubonboarding1),
                ""+context.getString(R.string.strsubonboarding2), ""+context.getString(R.string.strsubonboarding3)};

        ImageView img = viewGroup2.findViewById(R.id.img);
        TextView title = viewGroup2.findViewById(R.id.title);
        TextView subtitle = viewGroup2.findViewById(R.id.subtitle);

        img.setImageResource(intimg[i]);
        title.setText("" + stringstitle[i]);
        subtitle.setText("" + stringssubtitle[i]);

        return viewGroup2;
    }

    @Override
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public enum DontMobileObject {
        RED(R.string.app_name, R.layout.cast_tv_screen_onboardi),
        BLUE(R.string.app_name, R.layout.cast_tv_screen_onboardi),
        GREEN(R.string.app_name, R.layout.cast_tv_screen_onboardi);


        private int mLayoutResId;
        private int mTitleResId;

        private DontMobileObject(int i, int i2) {
            this.mTitleResId = i;
            this.mLayoutResId = i2;
        }

        public int getTitleResId() {
            return this.mTitleResId;
        }

        public int getLayoutResId() {
            return this.mLayoutResId;
        }


    }
}
