package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cc;

import android.app.DownloadManager;
import android.content.Context;

import org.apache.http.cookie.ClientCookie;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kapil.cast.video.screenmirroring.smarttv.kapil_developer_if.kapil_developer_if_error;


public final class kapil_developer_utt {
    @NotNull
    public static final imageCompanion imageCompanion = new imageCompanion(null);

    
    public static final class imageCompanion {
        public imageCompanion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private imageCompanion() {
        }

        public final void imagrOnlineCasting(@NotNull String str, @Nullable Context context, @NotNull DownloadManager downloadManager, @NotNull kapil_developer_if_error kapildeveloperiferror) {
            Intrinsics.checkNotNullParameter(str, ClientCookie.PATH_ATTR);
            Intrinsics.checkNotNullParameter(downloadManager, "manager");
            Intrinsics.checkNotNullParameter(kapildeveloperiferror, "castPhotoOnlineError");
        }

    }
}
