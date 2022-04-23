package d.f0.i;

import d.r;
import e.f;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: d  reason: collision with root package name */
    public static final f f3508d = f.d(":");

    /* renamed from: e  reason: collision with root package name */
    public static final f f3509e = f.d(":status");
    public static final f f = f.d(":method");
    public static final f g = f.d(":path");
    public static final f h = f.d(":scheme");
    public static final f i = f.d(":authority");

    /* renamed from: a  reason: collision with root package name */
    public final f f3510a;

    /* renamed from: b  reason: collision with root package name */
    public final f f3511b;

    /* renamed from: c  reason: collision with root package name */
    final int f3512c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(r rVar);
    }

    public c(f fVar, f fVar2) {
        this.f3510a = fVar;
        this.f3511b = fVar2;
        this.f3512c = fVar.g() + 32 + fVar2.g();
    }

    public c(f fVar, String str) {
        this(fVar, f.d(str));
    }

    public c(String str, String str2) {
        this(f.d(str), f.d(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3510a.equals(cVar.f3510a) && this.f3511b.equals(cVar.f3511b);
    }

    public int hashCode() {
        return ((527 + this.f3510a.hashCode()) * 31) + this.f3511b.hashCode();
    }

    public String toString() {
        return d.f0.c.a("%s: %s", this.f3510a.j(), this.f3511b.j());
    }
}
