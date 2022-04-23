package e;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    static p f3773a;

    /* renamed from: b  reason: collision with root package name */
    static long f3774b;

    private q() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p a() {
        synchronized (q.class) {
            if (f3773a == null) {
                return new p();
            }
            p pVar = f3773a;
            f3773a = pVar.f;
            pVar.f = null;
            f3774b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return pVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(p pVar) {
        if (pVar.f != null || pVar.g != null) {
            throw new IllegalArgumentException();
        } else if (!pVar.f3771d) {
            synchronized (q.class) {
                if (f3774b + PlaybackStateCompat.ACTION_PLAY_FROM_URI <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    f3774b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    pVar.f = f3773a;
                    pVar.f3770c = 0;
                    pVar.f3769b = 0;
                    f3773a = pVar;
                }
            }
        }
    }
}
