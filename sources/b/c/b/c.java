package b.c.b;

import b.c.b.r.a;
import b.c.b.r.b;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final b f1761a;

    /* renamed from: b  reason: collision with root package name */
    private b f1762b;

    public c(b bVar) {
        if (bVar != null) {
            this.f1761a = bVar;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public a a(int i, a aVar) {
        return this.f1761a.a(i, aVar);
    }

    public b a() {
        if (this.f1762b == null) {
            this.f1762b = this.f1761a.a();
        }
        return this.f1762b;
    }

    public int b() {
        return this.f1761a.b();
    }

    public int c() {
        return this.f1761a.d();
    }

    public boolean d() {
        return this.f1761a.c().d();
    }

    public c e() {
        this.f1761a.c().e();
        throw null;
    }

    public String toString() {
        try {
            return a().toString();
        } catch (i unused) {
            return "";
        }
    }
}
