package kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_intro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import kapil.cast.video.screenmirroring.smarttv.kapil_developer_act.kapil_developer_main;
import kapil.cast.video.screenmirroring.smarttv.R;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Inter;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_admob.kapil_developer_ap.kapil_developer_Native;


public class kapil_developer_onboard extends AppCompatActivity {


    DotsIndicator dot1;


    ImageView imageview;

    View include;
    kapil_developer_pref kapildeveloperpref;


    kapil_developer_date viewAdapter;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_tv_screen_onboard);


        if (getIntent().getBooleanExtra("pro_inter", false)){
            kapil_developer_Inter.inter(this);
        }

        kapil_developer_Native.banner(this, findViewById(R.id.adsContainer));

        this.viewPager = (ViewPager) findViewById(R.id.view_pager);

        this.dot1 = (DotsIndicator) findViewById(R.id.dot1);
        this.imageview = (ImageView) findViewById(R.id.imageview);

        kapildeveloperpref = new kapil_developer_pref(this);


        kapil_developer_date allGuideAdapter = new kapil_developer_date(this);
        this.viewAdapter = allGuideAdapter;
        this.viewPager.setAdapter(allGuideAdapter);
        this.dot1.setViewPager(this.viewPager);
        viewPager.setOffscreenPageLimit(3);
        this.viewPager.setCurrentItem(0);

//        RemoteConstant.nativeOnboarding.observe(this, nativeAd -> {
//
//            if (nativeAd != null) {
//                AdsUtils.Companion.getnativeOnboarding().showAds(this, findViewById(R.id.layoutAdNative), true);
//            }
//        });


        this.imageview.setOnClickListener(view -> onClick_whistle(view));
        this.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int i) {
            }

            @Override
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override
            public void onPageSelected(int i) {

//                if (i == 2) {
//                    imageview.setText("" + getString(R.string.start));
//                } else {
//                    imageview.setText("" + getString(R.string.next));
//                }
            }
        });

    }

    public void onClick_whistle(View view) {
        int currentItem = this.viewPager.getCurrentItem();
        if (this.viewPager.getCurrentItem() == 2) {
            new kapil_developer_pref(kapil_developer_onboard.this).setFirstTime(false);
            skip(view);
            return;
        }
        this.viewPager.setCurrentItem(currentItem + 1);
    }

    public void skip(View view) {
        Intent intent = new Intent(kapil_developer_onboard.this, kapil_developer_main.class).putExtra("pro_inter", true);
        startActivity(intent);

    }


    @Override
    public void onBackPressed() {
    }
}