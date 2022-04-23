package a.p;

import android.os.IBinder;

/* loaded from: classes.dex */
class j0 implements l0 {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f573a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(IBinder iBinder) {
        this.f573a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j0) && ((j0) obj).f573a.equals(this.f573a);
    }

    public int hashCode() {
        return this.f573a.hashCode();
    }
}
