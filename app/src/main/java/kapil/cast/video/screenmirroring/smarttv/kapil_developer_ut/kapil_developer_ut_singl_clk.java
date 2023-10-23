package kapil.cast.video.screenmirroring.smarttv.kapil_developer_ut;

import android.os.SystemClock;
import android.view.View;

public abstract class kapil_developer_ut_singl_clk implements View.OnClickListener {

    protected int setonClick;
    private long clickone = 0;

    public kapil_developer_ut_singl_clk() {
        this(1000);
    }

    public kapil_developer_ut_singl_clk(int minInterval) {
        this.setonClick = minInterval;
    }

    @Override
    public void onClick(View v) {
        if (SystemClock.elapsedRealtime() - clickone < setonClick) {
            return;
        }
        clickone = SystemClock.elapsedRealtime();
        performClick(v);
    }

    public abstract void performClick(View v);
}

