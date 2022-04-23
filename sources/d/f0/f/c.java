package d.f0.f;

import d.a0;
import d.c0;
import d.f0.h.a;
import d.f0.i.b;
import d.f0.i.g;
import d.f0.k.f;
import d.i;
import d.j;
import d.k;
import d.p;
import d.q;
import d.s;
import d.t;
import d.v;
import d.w;
import d.y;
import d.z;
import e.d;
import e.e;
import e.l;
import e.t;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class c extends g.h implements i {

    /* renamed from: b  reason: collision with root package name */
    private final j f3448b;

    /* renamed from: c  reason: collision with root package name */
    private final c0 f3449c;

    /* renamed from: d  reason: collision with root package name */
    private Socket f3450d;

    /* renamed from: e  reason: collision with root package name */
    private Socket f3451e;
    private q f;
    private w g;
    private g h;
    private e i;
    private d j;
    public boolean k;
    public int l;
    public int m = 1;
    public final List<Reference<g>> n = new ArrayList();
    public long o = Long.MAX_VALUE;

    public c(j jVar, c0 c0Var) {
        this.f3448b = jVar;
        this.f3449c = c0Var;
    }

    private y a(int i, int i2, y yVar, s sVar) {
        String str = "CONNECT " + d.f0.c.a(sVar, true) + " HTTP/1.1";
        while (true) {
            a aVar = new a(null, null, this.i, this.j);
            this.i.b().a(i, TimeUnit.MILLISECONDS);
            this.j.b().a(i2, TimeUnit.MILLISECONDS);
            aVar.a(yVar.c(), str);
            aVar.a();
            a0.a a2 = aVar.a(false);
            a2.a(yVar);
            a0 a3 = a2.a();
            long a4 = d.f0.g.e.a(a3);
            if (a4 == -1) {
                a4 = 0;
            }
            t b2 = aVar.b(a4);
            d.f0.c.b(b2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            b2.close();
            int p = a3.p();
            if (p != 200) {
                if (p == 407) {
                    y a5 = this.f3449c.a().g().a(this.f3449c, a3);
                    if (a5 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(a3.b("Connection"))) {
                        return a5;
                    } else {
                        yVar = a5;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + a3.p());
                }
            } else if (this.i.a().j() && this.j.a().j()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private void a(int i) {
        this.f3451e.setSoTimeout(0);
        g.C0099g gVar = new g.C0099g(true);
        gVar.a(this.f3451e, this.f3449c.a().k().g(), this.i, this.j);
        gVar.a(this);
        gVar.a(i);
        this.h = gVar.a();
        this.h.o();
    }

    private void a(int i, int i2, int i3, d.e eVar, p pVar) {
        y f = f();
        s g = f.g();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, eVar, pVar);
            f = a(i2, i3, f, g);
            if (f != null) {
                d.f0.c.a(this.f3450d);
                this.f3450d = null;
                this.j = null;
                this.i = null;
                pVar.a(eVar, this.f3449c.d(), this.f3449c.b(), null);
            } else {
                return;
            }
        }
    }

    private void a(int i, int i2, d.e eVar, p pVar) {
        Proxy b2 = this.f3449c.b();
        this.f3450d = (b2.type() == Proxy.Type.DIRECT || b2.type() == Proxy.Type.HTTP) ? this.f3449c.a().i().createSocket() : new Socket(b2);
        pVar.a(eVar, this.f3449c.d(), b2);
        this.f3450d.setSoTimeout(i2);
        try {
            f.d().a(this.f3450d, this.f3449c.d(), i);
            try {
                this.i = l.a(l.b(this.f3450d));
                this.j = l.a(l.a(this.f3450d));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f3449c.d());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    private void a(b bVar) {
        Throwable th;
        SSLSocket sSLSocket;
        AssertionError e2;
        d.a a2 = this.f3449c.a();
        String str = null;
        try {
            try {
                sSLSocket = (SSLSocket) a2.j().createSocket(this.f3450d, a2.k().g(), a2.k().j(), true);
            } catch (AssertionError e3) {
                e2 = e3;
            }
        } catch (Throwable th2) {
            th = th2;
            sSLSocket = null;
        }
        try {
            k a3 = bVar.a(sSLSocket);
            if (a3.c()) {
                f.d().a(sSLSocket, a2.k().g(), a2.e());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            q a4 = q.a(session);
            if (a2.d().verify(a2.k().g(), session)) {
                a2.a().a(a2.k().g(), a4.c());
                if (a3.c()) {
                    str = f.d().b(sSLSocket);
                }
                this.f3451e = sSLSocket;
                this.i = l.a(l.b(this.f3451e));
                this.j = l.a(l.a(this.f3451e));
                this.f = a4;
                this.g = str != null ? w.a(str) : w.HTTP_1_1;
                if (sSLSocket != null) {
                    f.d().a(sSLSocket);
                    return;
                }
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) a4.c().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + a2.k().g() + " not verified:\n    certificate: " + d.g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + d.f0.m.d.a(x509Certificate));
        } catch (AssertionError e4) {
            e2 = e4;
            if (d.f0.c.a(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        } catch (Throwable th3) {
            th = th3;
            if (sSLSocket != null) {
                f.d().a(sSLSocket);
            }
            d.f0.c.a((Socket) sSLSocket);
            throw th;
        }
    }

    private void a(b bVar, int i, d.e eVar, p pVar) {
        if (this.f3449c.a().j() != null) {
            pVar.g(eVar);
            a(bVar);
            pVar.a(eVar, this.f);
            if (this.g == w.HTTP_2) {
                a(i);
            }
        } else if (this.f3449c.a().e().contains(w.H2_PRIOR_KNOWLEDGE)) {
            this.f3451e = this.f3450d;
            this.g = w.H2_PRIOR_KNOWLEDGE;
            a(i);
        } else {
            this.f3451e = this.f3450d;
            this.g = w.HTTP_1_1;
        }
    }

    private y f() {
        y.a aVar = new y.a();
        aVar.a(this.f3449c.a().k());
        aVar.a("CONNECT", (z) null);
        aVar.a("Host", d.f0.c.a(this.f3449c.a().k(), true));
        aVar.a("Proxy-Connection", "Keep-Alive");
        aVar.a("User-Agent", d.f0.d.a());
        y a2 = aVar.a();
        a0.a aVar2 = new a0.a();
        aVar2.a(a2);
        aVar2.a(w.HTTP_1_1);
        aVar2.a(407);
        aVar2.a("Preemptive Authenticate");
        aVar2.a(d.f0.c.f3405c);
        aVar2.b(-1L);
        aVar2.a(-1L);
        aVar2.b("Proxy-Authenticate", "OkHttp-Preemptive");
        y a3 = this.f3449c.a().g().a(this.f3449c, aVar2.a());
        return a3 != null ? a3 : a2;
    }

    public d.f0.g.c a(v vVar, t.a aVar, g gVar) {
        g gVar2 = this.h;
        if (gVar2 != null) {
            return new d.f0.i.f(vVar, aVar, gVar, gVar2);
        }
        this.f3451e.setSoTimeout(aVar.d());
        this.i.b().a(aVar.d(), TimeUnit.MILLISECONDS);
        this.j.b().a(aVar.a(), TimeUnit.MILLISECONDS);
        return new a(vVar, gVar, this.i, this.j);
    }

    public void a() {
        d.f0.c.a(this.f3450d);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0090 A[Catch: IOException -> 0x00f9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00f9, blocks: (B:17:0x0088, B:19:0x0090), top: B:60:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0143 A[EDGE_INSN: B:70:0x0143->B:55:0x0143 ?: BREAK  ] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r17, int r18, int r19, int r20, boolean r21, d.e r22, d.p r23) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f0.f.c.a(int, int, int, int, boolean, d.e, d.p):void");
    }

    @Override // d.f0.i.g.h
    public void a(g gVar) {
        synchronized (this.f3448b) {
            this.m = gVar.n();
        }
    }

    @Override // d.f0.i.g.h
    public void a(d.f0.i.i iVar) {
        iVar.a(b.REFUSED_STREAM);
    }

    public boolean a(d.a aVar, c0 c0Var) {
        if (this.n.size() >= this.m || this.k || !d.f0.a.f3401a.a(this.f3449c.a(), aVar)) {
            return false;
        }
        if (aVar.k().g().equals(d().a().k().g())) {
            return true;
        }
        if (this.h == null || c0Var == null || c0Var.b().type() != Proxy.Type.DIRECT || this.f3449c.b().type() != Proxy.Type.DIRECT || !this.f3449c.d().equals(c0Var.d()) || c0Var.a().d() != d.f0.m.d.f3637a || !a(aVar.k())) {
            return false;
        }
        try {
            aVar.a().a(aVar.k().g(), b().c());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean a(s sVar) {
        if (sVar.j() != this.f3449c.a().k().j()) {
            return false;
        }
        if (!sVar.g().equals(this.f3449c.a().k().g())) {
            return this.f != null && d.f0.m.d.f3637a.a(sVar.g(), (X509Certificate) this.f.c().get(0));
        }
        return true;
    }

    public boolean a(boolean z) {
        if (this.f3451e.isClosed() || this.f3451e.isInputShutdown() || this.f3451e.isOutputShutdown()) {
            return false;
        }
        g gVar = this.h;
        if (gVar != null) {
            return !gVar.m();
        }
        if (z) {
            try {
                int soTimeout = this.f3451e.getSoTimeout();
                try {
                    this.f3451e.setSoTimeout(1);
                    return !this.i.j();
                } finally {
                    this.f3451e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public q b() {
        return this.f;
    }

    public boolean c() {
        return this.h != null;
    }

    public c0 d() {
        return this.f3449c;
    }

    public Socket e() {
        return this.f3451e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f3449c.a().k().g());
        sb.append(":");
        sb.append(this.f3449c.a().k().j());
        sb.append(", proxy=");
        sb.append(this.f3449c.b());
        sb.append(" hostAddress=");
        sb.append(this.f3449c.d());
        sb.append(" cipherSuite=");
        q qVar = this.f;
        sb.append(qVar != null ? qVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.g);
        sb.append('}');
        return sb.toString();
    }
}
