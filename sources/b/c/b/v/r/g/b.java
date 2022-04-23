package b.c.b.v.r.g;

import b.c.b.v.r.c;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final b.c.b.v.r.b f1943a;

    /* renamed from: b  reason: collision with root package name */
    private final b.c.b.v.r.b f1944b;

    /* renamed from: c  reason: collision with root package name */
    private final c f1945c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(b.c.b.v.r.b bVar, b.c.b.v.r.b bVar2, c cVar, boolean z) {
        this.f1943a = bVar;
        this.f1944b = bVar2;
        this.f1945c = cVar;
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a() {
        return this.f1945c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b.c.b.v.r.b b() {
        return this.f1943a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b.c.b.v.r.b c() {
        return this.f1944b;
    }

    public boolean d() {
        return this.f1944b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a(this.f1943a, bVar.f1943a) && a(this.f1944b, bVar.f1944b) && a(this.f1945c, bVar.f1945c);
    }

    public int hashCode() {
        return (a(this.f1943a) ^ a(this.f1944b)) ^ a(this.f1945c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f1943a);
        sb.append(" , ");
        sb.append(this.f1944b);
        sb.append(" : ");
        c cVar = this.f1945c;
        sb.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb.append(" ]");
        return sb.toString();
    }
}
