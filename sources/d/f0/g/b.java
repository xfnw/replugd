package d.f0.g;

import d.a0;
import d.b0;
import d.t;
import d.y;
import e.c;
import e.d;
import e.g;
import e.l;
import e.s;
import java.net.ProtocolException;

/* loaded from: classes.dex */
public final class b implements t {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3469a;

    /* loaded from: classes.dex */
    static final class a extends g {

        /* renamed from: c  reason: collision with root package name */
        long f3470c;

        a(s sVar) {
            super(sVar);
        }

        @Override // e.g, e.s
        public void a(c cVar, long j) {
            super.a(cVar, j);
            this.f3470c += j;
        }
    }

    public b(boolean z) {
        this.f3469a = z;
    }

    @Override // d.t
    public a0 a(t.a aVar) {
        a0.a aVar2;
        b0 b0Var;
        g gVar = (g) aVar;
        c h = gVar.h();
        d.f0.f.g i = gVar.i();
        d.f0.f.c cVar = (d.f0.f.c) gVar.f();
        y b2 = gVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.g().d(gVar.e());
        h.a(b2);
        gVar.g().a(gVar.e(), b2);
        a0.a aVar3 = null;
        if (f.b(b2.e()) && b2.a() != null) {
            if ("100-continue".equalsIgnoreCase(b2.a("Expect"))) {
                h.b();
                gVar.g().f(gVar.e());
                aVar3 = h.a(true);
            }
            if (aVar3 == null) {
                gVar.g().c(gVar.e());
                a aVar4 = new a(h.a(b2, b2.a().a()));
                d a2 = l.a(aVar4);
                b2.a().a(a2);
                a2.close();
                gVar.g().a(gVar.e(), aVar4.f3470c);
            } else if (!cVar.c()) {
                i.e();
            }
        }
        h.a();
        if (aVar3 == null) {
            gVar.g().f(gVar.e());
            aVar3 = h.a(false);
        }
        aVar3.a(b2);
        aVar3.a(i.c().b());
        aVar3.b(currentTimeMillis);
        aVar3.a(System.currentTimeMillis());
        a0 a3 = aVar3.a();
        int p = a3.p();
        if (p == 100) {
            a0.a a4 = h.a(false);
            a4.a(b2);
            a4.a(i.c().b());
            a4.b(currentTimeMillis);
            a4.a(System.currentTimeMillis());
            a3 = a4.a();
            p = a3.p();
        }
        gVar.g().a(gVar.e(), a3);
        if (!this.f3469a || p != 101) {
            aVar2 = a3.v();
            b0Var = h.a(a3);
        } else {
            aVar2 = a3.v();
            b0Var = d.f0.c.f3405c;
        }
        aVar2.a(b0Var);
        a0 a5 = aVar2.a();
        if ("close".equalsIgnoreCase(a5.z().a("Connection")) || "close".equalsIgnoreCase(a5.b("Connection"))) {
            i.e();
        }
        if ((p != 204 && p != 205) || a5.m().m() <= 0) {
            return a5;
        }
        throw new ProtocolException("HTTP " + p + " had non-zero Content-Length: " + a5.m().m());
    }
}
