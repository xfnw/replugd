package d.f0.i;

import d.a0;
import d.b0;
import d.f0.f.g;
import d.f0.g.c;
import d.f0.g.e;
import d.f0.g.i;
import d.f0.g.k;
import d.r;
import d.t;
import d.v;
import d.w;
import d.y;
import e.h;
import e.l;
import e.s;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class f implements c {
    private static final List<String> f = d.f0.c.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    private static final List<String> g = d.f0.c.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a  reason: collision with root package name */
    private final t.a f3529a;

    /* renamed from: b  reason: collision with root package name */
    final g f3530b;

    /* renamed from: c  reason: collision with root package name */
    private final g f3531c;

    /* renamed from: d  reason: collision with root package name */
    private i f3532d;

    /* renamed from: e  reason: collision with root package name */
    private final w f3533e;

    /* loaded from: classes.dex */
    class a extends h {

        /* renamed from: c  reason: collision with root package name */
        boolean f3534c = false;

        /* renamed from: d  reason: collision with root package name */
        long f3535d = 0;

        a(e.t tVar) {
            super(tVar);
        }

        private void a(IOException iOException) {
            if (!this.f3534c) {
                this.f3534c = true;
                f fVar = f.this;
                fVar.f3530b.a(false, fVar, this.f3535d, iOException);
            }
        }

        @Override // e.h, e.t
        public long b(e.c cVar, long j) {
            try {
                long b2 = d().b(cVar, j);
                if (b2 > 0) {
                    this.f3535d += b2;
                }
                return b2;
            } catch (IOException e2) {
                a(e2);
                throw e2;
            }
        }

        @Override // e.h, e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            a(null);
        }
    }

    public f(v vVar, t.a aVar, g gVar, g gVar2) {
        this.f3529a = aVar;
        this.f3530b = gVar;
        this.f3531c = gVar2;
        this.f3533e = vVar.t().contains(w.H2_PRIOR_KNOWLEDGE) ? w.H2_PRIOR_KNOWLEDGE : w.HTTP_2;
    }

    public static a0.a a(r rVar, w wVar) {
        r.a aVar = new r.a();
        int b2 = rVar.b();
        k kVar = null;
        for (int i = 0; i < b2; i++) {
            String a2 = rVar.a(i);
            String b3 = rVar.b(i);
            if (a2.equals(":status")) {
                kVar = k.a("HTTP/1.1 " + b3);
            } else if (!g.contains(a2)) {
                d.f0.a.f3401a.a(aVar, a2, b3);
            }
        }
        if (kVar != null) {
            a0.a aVar2 = new a0.a();
            aVar2.a(wVar);
            aVar2.a(kVar.f3486b);
            aVar2.a(kVar.f3487c);
            aVar2.a(aVar.a());
            return aVar2;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public static List<c> b(y yVar) {
        r c2 = yVar.c();
        ArrayList arrayList = new ArrayList(c2.b() + 4);
        arrayList.add(new c(c.f, yVar.e()));
        arrayList.add(new c(c.g, i.a(yVar.g())));
        String a2 = yVar.a("Host");
        if (a2 != null) {
            arrayList.add(new c(c.i, a2));
        }
        arrayList.add(new c(c.h, yVar.g().m()));
        int b2 = c2.b();
        for (int i = 0; i < b2; i++) {
            e.f d2 = e.f.d(c2.a(i).toLowerCase(Locale.US));
            if (!f.contains(d2.j())) {
                arrayList.add(new c(d2, c2.b(i)));
            }
        }
        return arrayList;
    }

    @Override // d.f0.g.c
    public a0.a a(boolean z) {
        a0.a a2 = a(this.f3532d.j(), this.f3533e);
        if (!z || d.f0.a.f3401a.a(a2) != 100) {
            return a2;
        }
        return null;
    }

    @Override // d.f0.g.c
    public b0 a(a0 a0Var) {
        g gVar = this.f3530b;
        gVar.f.e(gVar.f3466e);
        return new d.f0.g.h(a0Var.b("Content-Type"), e.a(a0Var), l.a(new a(this.f3532d.e())));
    }

    @Override // d.f0.g.c
    public s a(y yVar, long j) {
        return this.f3532d.d();
    }

    @Override // d.f0.g.c
    public void a() {
        this.f3532d.d().close();
    }

    @Override // d.f0.g.c
    public void a(y yVar) {
        if (this.f3532d == null) {
            this.f3532d = this.f3531c.a(b(yVar), yVar.a() != null);
            this.f3532d.h().a(this.f3529a.d(), TimeUnit.MILLISECONDS);
            this.f3532d.l().a(this.f3529a.a(), TimeUnit.MILLISECONDS);
        }
    }

    @Override // d.f0.g.c
    public void b() {
        this.f3531c.flush();
    }

    @Override // d.f0.g.c
    public void cancel() {
        i iVar = this.f3532d;
        if (iVar != null) {
            iVar.b(b.CANCEL);
        }
    }
}
