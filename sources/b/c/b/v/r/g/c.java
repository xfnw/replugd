package b.c.b.v.r.g;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final List<b> f1946a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1947b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1948c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List<b> list, int i, boolean z) {
        this.f1946a = new ArrayList(list);
        this.f1947b = i;
        this.f1948c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<b> a() {
        return this.f1946a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(List<b> list) {
        return this.f1946a.equals(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1947b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f1946a.equals(cVar.a()) && this.f1948c == cVar.f1948c;
    }

    public int hashCode() {
        return this.f1946a.hashCode() ^ Boolean.valueOf(this.f1948c).hashCode();
    }

    public String toString() {
        return "{ " + this.f1946a + " }";
    }
}
