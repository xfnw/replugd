package androidx.media;

import a.g.k.c;
import android.media.session.MediaSessionManager;

/* loaded from: classes.dex */
final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    final MediaSessionManager.RemoteUserInfo f1306a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f1306a = remoteUserInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(String str, int i, int i2) {
        this.f1306a = new MediaSessionManager.RemoteUserInfo(str, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        return this.f1306a.equals(((g) obj).f1306a);
    }

    public int hashCode() {
        return c.a(this.f1306a);
    }
}
