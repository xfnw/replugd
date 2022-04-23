package a.g.k;

/* loaded from: classes.dex */
public class d<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f282a;

    /* renamed from: b  reason: collision with root package name */
    public final S f283b;

    public d(F f, S s) {
        this.f282a = f;
        this.f283b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.f282a, this.f282a) && c.a(dVar.f283b, this.f283b);
    }

    public int hashCode() {
        F f = this.f282a;
        int i = 0;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.f283b;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f282a) + " " + String.valueOf(this.f283b) + "}";
    }
}
