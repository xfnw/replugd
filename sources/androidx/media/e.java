package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    f f1305a;

    public e(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f1305a = new g(remoteUserInfo);
    }

    public e(String str, int i, int i2) {
        this.f1305a = Build.VERSION.SDK_INT >= 28 ? new g(str, i, i2) : new h(str, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return this.f1305a.equals(((e) obj).f1305a);
    }

    public int hashCode() {
        return this.f1305a.hashCode();
    }
}
