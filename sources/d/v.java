package d;

import d.a0;
import d.e;
import d.f0.c;
import d.f0.e.f;
import d.f0.f.d;
import d.f0.f.g;
import d.p;
import d.r;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class v implements Cloneable, e.a, e0 {
    static final List<w> D = c.a(w.HTTP_2, w.HTTP_1_1);
    static final List<k> E = c.a(k.g, k.h);
    final int A;
    final int B;
    final int C;

    /* renamed from: b  reason: collision with root package name */
    final n f3696b;

    /* renamed from: c  reason: collision with root package name */
    final Proxy f3697c;

    /* renamed from: d  reason: collision with root package name */
    final List<w> f3698d;

    /* renamed from: e  reason: collision with root package name */
    final List<k> f3699e;
    final List<t> f;
    final List<t> g;
    final p.c h;
    final ProxySelector i;
    final m j;
    final c k;
    final f l;
    final SocketFactory m;
    final SSLSocketFactory n;
    final d.f0.m.c o;
    final HostnameVerifier p;
    final g q;
    final d.b r;
    final d.b s;
    final j t;
    final o u;
    final boolean v;
    final boolean w;
    final boolean x;
    final int y;
    final int z;

    /* loaded from: classes.dex */
    class a extends d.f0.a {
        a() {
        }

        @Override // d.f0.a
        public int a(a0.a aVar) {
            return aVar.f3357c;
        }

        @Override // d.f0.a
        public d.f0.f.c a(j jVar, d.a aVar, g gVar, c0 c0Var) {
            return jVar.a(aVar, gVar, c0Var);
        }

        @Override // d.f0.a
        public d a(j jVar) {
            return jVar.f3655e;
        }

        @Override // d.f0.a
        public IOException a(e eVar, IOException iOException) {
            return ((x) eVar).a(iOException);
        }

        @Override // d.f0.a
        public Socket a(j jVar, d.a aVar, g gVar) {
            return jVar.a(aVar, gVar);
        }

        @Override // d.f0.a
        public void a(k kVar, SSLSocket sSLSocket, boolean z) {
            kVar.a(sSLSocket, z);
        }

        @Override // d.f0.a
        public void a(r.a aVar, String str) {
            aVar.a(str);
        }

        @Override // d.f0.a
        public void a(r.a aVar, String str, String str2) {
            aVar.b(str, str2);
        }

        @Override // d.f0.a
        public boolean a(d.a aVar, d.a aVar2) {
            return aVar.a(aVar2);
        }

        @Override // d.f0.a
        public boolean a(j jVar, d.f0.f.c cVar) {
            return jVar.a(cVar);
        }

        @Override // d.f0.a
        public void b(j jVar, d.f0.f.c cVar) {
            jVar.b(cVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        int A;
        int B;

        /* renamed from: b  reason: collision with root package name */
        Proxy f3701b;
        ProxySelector h;
        m i;
        c j;
        f k;
        SocketFactory l;
        SSLSocketFactory m;
        d.f0.m.c n;
        HostnameVerifier o;
        g p;
        d.b q;
        d.b r;
        j s;
        o t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        /* renamed from: e  reason: collision with root package name */
        final List<t> f3704e = new ArrayList();
        final List<t> f = new ArrayList();

        /* renamed from: a  reason: collision with root package name */
        n f3700a = new n();

        /* renamed from: c  reason: collision with root package name */
        List<w> f3702c = v.D;

        /* renamed from: d  reason: collision with root package name */
        List<k> f3703d = v.E;
        p.c g = p.a(p.f3678a);

        public b() {
            this.h = ProxySelector.getDefault();
            if (this.h == null) {
                this.h = new d.f0.l.a();
            }
            this.i = m.f3671a;
            this.l = SocketFactory.getDefault();
            this.o = d.f0.m.d.f3637a;
            this.p = g.f3638c;
            d.b bVar = d.b.f3360a;
            this.q = bVar;
            this.r = bVar;
            this.s = new j();
            this.t = o.f3677a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        public b a(c cVar) {
            this.j = cVar;
            this.k = null;
            return this;
        }

        public v a() {
            return new v(this);
        }
    }

    static {
        d.f0.a.f3401a = new a();
    }

    public v() {
        this(new b());
    }

    v(b bVar) {
        boolean z;
        d.f0.m.c cVar;
        this.f3696b = bVar.f3700a;
        this.f3697c = bVar.f3701b;
        this.f3698d = bVar.f3702c;
        this.f3699e = bVar.f3703d;
        this.f = c.a(bVar.f3704e);
        this.g = c.a(bVar.f);
        this.h = bVar.g;
        this.i = bVar.h;
        this.j = bVar.i;
        this.k = bVar.j;
        this.l = bVar.k;
        this.m = bVar.l;
        loop0: while (true) {
            z = false;
            for (k kVar : this.f3699e) {
                z = (z || kVar.b()) ? true : z;
            }
        }
        if (bVar.m != null || !z) {
            this.n = bVar.m;
            cVar = bVar.n;
        } else {
            X509TrustManager a2 = c.a();
            this.n = a(a2);
            cVar = d.f0.m.c.a(a2);
        }
        this.o = cVar;
        if (this.n != null) {
            d.f0.k.f.d().a(this.n);
        }
        this.p = bVar.o;
        this.q = bVar.p.a(this.o);
        this.r = bVar.q;
        this.s = bVar.r;
        this.t = bVar.s;
        this.u = bVar.t;
        this.v = bVar.u;
        this.w = bVar.v;
        this.x = bVar.w;
        this.y = bVar.x;
        this.z = bVar.y;
        this.A = bVar.z;
        this.B = bVar.A;
        this.C = bVar.B;
        if (this.f.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f);
        } else if (this.g.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.g);
        }
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext b2 = d.f0.k.f.d().b();
            b2.init(null, new TrustManager[]{x509TrustManager}, null);
            return b2.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw c.a("No System TLS", (Exception) e2);
        }
    }

    public SSLSocketFactory A() {
        return this.n;
    }

    public int B() {
        return this.B;
    }

    public d.b a() {
        return this.s;
    }

    @Override // d.e.a
    public e a(y yVar) {
        return x.a(this, yVar, false);
    }

    public c b() {
        return this.k;
    }

    public int c() {
        return this.y;
    }

    public g d() {
        return this.q;
    }

    public int e() {
        return this.z;
    }

    public j f() {
        return this.t;
    }

    public List<k> g() {
        return this.f3699e;
    }

    public m h() {
        return this.j;
    }

    public n i() {
        return this.f3696b;
    }

    public o j() {
        return this.u;
    }

    public p.c k() {
        return this.h;
    }

    public boolean l() {
        return this.w;
    }

    public boolean n() {
        return this.v;
    }

    public HostnameVerifier o() {
        return this.p;
    }

    public List<t> p() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f q() {
        c cVar = this.k;
        return cVar != null ? cVar.f3363b : this.l;
    }

    public List<t> r() {
        return this.g;
    }

    public int s() {
        return this.C;
    }

    public List<w> t() {
        return this.f3698d;
    }

    public Proxy u() {
        return this.f3697c;
    }

    public d.b v() {
        return this.r;
    }

    public ProxySelector w() {
        return this.i;
    }

    public int x() {
        return this.A;
    }

    public boolean y() {
        return this.x;
    }

    public SocketFactory z() {
        return this.m;
    }
}
