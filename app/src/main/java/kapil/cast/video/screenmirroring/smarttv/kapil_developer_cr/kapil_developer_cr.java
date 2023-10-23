package kapil.cast.video.screenmirroring.smarttv.kapil_developer_cr;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class kapil_developer_cr {
    private final Subject<Object> subject;

    private kapil_developer_cr() {
        this.subject = PublishSubject.create();
    }

    public static kapil_developer_cr getDefault() {
        return RxHolder.sInstance;
    }

    public static class RxHolder {
        private static final kapil_developer_cr sInstance = new kapil_developer_cr();
    }

    public void post(Object obj) {
        this.subject.onNext(obj);
    }

    public <T> Observable<T> toObservable(Class<T> cls) {
        return (Observable<T>) this.subject.ofType(cls);
    }
}
