package b.c.b.v.r;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f1936a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1937b;

    public b(int i, int i2) {
        this.f1936a = i;
        this.f1937b = i2;
    }

    public final int a() {
        return this.f1937b;
    }

    public final int b() {
        return this.f1936a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f1936a == bVar.f1936a && this.f1937b == bVar.f1937b;
    }

    public final int hashCode() {
        return this.f1936a ^ this.f1937b;
    }

    public final String toString() {
        return this.f1936a + "(" + this.f1937b + ')';
    }
}
