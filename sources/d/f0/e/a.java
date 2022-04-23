package d.f0.e;

import d.a0;
import d.b0;
import d.f0.e.c;
import d.f0.g.f;
import d.f0.g.h;
import d.r;
import d.t;
import d.w;
import d.y;
import e.c;
import e.d;
import e.e;
import e.l;
import e.s;
import e.u;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class a implements t {

    /* renamed from: a  reason: collision with root package name */
    final f f3410a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d.f0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0096a implements e.t {

        /* renamed from: b  reason: collision with root package name */
        boolean f3411b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f3412c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f3413d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d f3414e;

        C0096a(a aVar, e eVar, b bVar, d dVar) {
            this.f3412c = eVar;
            this.f3413d = bVar;
            this.f3414e = dVar;
        }

        @Override // e.t
        public long b(c cVar, long j) {
            try {
                long b2 = this.f3412c.b(cVar, j);
                if (b2 == -1) {
                    if (!this.f3411b) {
                        this.f3411b = true;
                        this.f3414e.close();
                    }
                    return -1L;
                }
                cVar.a(this.f3414e.a(), cVar.r() - b2, b2);
                this.f3414e.d();
                return b2;
            } catch (IOException e2) {
                if (!this.f3411b) {
                    this.f3411b = true;
                    this.f3413d.a();
                }
                throw e2;
            }
        }

        @Override // e.t
        public u b() {
            return this.f3412c.b();
        }

        @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f3411b && !d.f0.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                this.f3411b = true;
                this.f3413d.a();
            }
            this.f3412c.close();
        }
    }

    public a(f fVar) {
        this.f3410a = fVar;
    }

    private static a0 a(a0 a0Var) {
        if (a0Var == null || a0Var.m() == null) {
            return a0Var;
        }
        a0.a v = a0Var.v();
        v.a((b0) null);
        return v.a();
    }

    private a0 a(b bVar, a0 a0Var) {
        s b2;
        if (bVar == null || (b2 = bVar.b()) == null) {
            return a0Var;
        }
        C0096a aVar = new C0096a(this, a0Var.m().n(), bVar, l.a(b2));
        String b3 = a0Var.b("Content-Type");
        long m = a0Var.m().m();
        a0.a v = a0Var.v();
        v.a(new h(b3, m, l.a(aVar)));
        return v.a();
    }

    private static r a(r rVar, r rVar2) {
        r.a aVar = new r.a();
        int b2 = rVar.b();
        for (int i = 0; i < b2; i++) {
            String a2 = rVar.a(i);
            String b3 = rVar.b(i);
            if ((!"Warning".equalsIgnoreCase(a2) || !b3.startsWith("1")) && (a(a2) || !b(a2) || rVar2.a(a2) == null)) {
                d.f0.a.f3401a.a(aVar, a2, b3);
            }
        }
        int b4 = rVar2.b();
        for (int i2 = 0; i2 < b4; i2++) {
            String a3 = rVar2.a(i2);
            if (!a(a3) && b(a3)) {
                d.f0.a.f3401a.a(aVar, a3, rVar2.b(i2));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    static boolean b(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }

    @Override // d.t
    public a0 a(t.a aVar) {
        f fVar = this.f3410a;
        a0 a2 = fVar != null ? fVar.a(aVar.b()) : null;
        c a3 = new c.a(System.currentTimeMillis(), aVar.b(), a2).a();
        y yVar = a3.f3415a;
        a0 a0Var = a3.f3416b;
        f fVar2 = this.f3410a;
        if (fVar2 != null) {
            fVar2.a(a3);
        }
        if (a2 != null && a0Var == null) {
            d.f0.c.a(a2.m());
        }
        if (yVar == null && a0Var == null) {
            a0.a aVar2 = new a0.a();
            aVar2.a(aVar.b());
            aVar2.a(w.HTTP_1_1);
            aVar2.a(504);
            aVar2.a("Unsatisfiable Request (only-if-cached)");
            aVar2.a(d.f0.c.f3405c);
            aVar2.b(-1L);
            aVar2.a(System.currentTimeMillis());
            return aVar2.a();
        } else if (yVar == null) {
            a0.a v = a0Var.v();
            v.a(a(a0Var));
            return v.a();
        } else {
            try {
                a0 a4 = aVar.a(yVar);
                if (a4 == null && a2 != null) {
                }
                if (a0Var != null) {
                    if (a4.p() == 304) {
                        a0.a v2 = a0Var.v();
                        v2.a(a(a0Var.r(), a4.r()));
                        v2.b(a4.A());
                        v2.a(a4.y());
                        v2.a(a(a0Var));
                        v2.b(a(a4));
                        a0 a5 = v2.a();
                        a4.m().close();
                        this.f3410a.a();
                        this.f3410a.a(a0Var, a5);
                        return a5;
                    }
                    d.f0.c.a(a0Var.m());
                }
                a0.a v3 = a4.v();
                v3.a(a(a0Var));
                v3.b(a(a4));
                a0 a6 = v3.a();
                if (this.f3410a != null) {
                    if (d.f0.g.e.b(a6) && c.a(a6, yVar)) {
                        return a(this.f3410a.a(a6), a6);
                    }
                    if (f.a(yVar.e())) {
                        try {
                            this.f3410a.b(yVar);
                        } catch (IOException unused) {
                        }
                    }
                }
                return a6;
            } finally {
                if (a2 != null) {
                    d.f0.c.a(a2.m());
                }
            }
        }
    }
}
