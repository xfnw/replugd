package d.f0.g;

import d.a;
import d.a0;
import d.b0;
import d.c0;
import d.e;
import d.f0.c;
import d.f0.f.g;
import d.p;
import d.s;
import d.t;
import d.v;
import d.y;
import d.z;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class j implements t {

    /* renamed from: a  reason: collision with root package name */
    private final v f3481a;

    /* renamed from: b  reason: collision with root package name */
    private volatile g f3482b;

    /* renamed from: c  reason: collision with root package name */
    private Object f3483c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f3484d;

    public j(v vVar, boolean z) {
        this.f3481a = vVar;
    }

    private int a(a0 a0Var, int i) {
        String b2 = a0Var.b("Retry-After");
        if (b2 == null) {
            return i;
        }
        if (b2.matches("\\d+")) {
            return Integer.valueOf(b2).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private a a(s sVar) {
        d.g gVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory = null;
        if (sVar.h()) {
            sSLSocketFactory = this.f3481a.A();
            hostnameVerifier = this.f3481a.o();
            gVar = this.f3481a.d();
        } else {
            hostnameVerifier = null;
            gVar = null;
        }
        return new a(sVar.g(), sVar.j(), this.f3481a.j(), this.f3481a.z(), sSLSocketFactory, hostnameVerifier, gVar, this.f3481a.v(), this.f3481a.u(), this.f3481a.t(), this.f3481a.g(), this.f3481a.w());
    }

    private y a(a0 a0Var, c0 c0Var) {
        String b2;
        s b3;
        if (a0Var != null) {
            int p = a0Var.p();
            String e2 = a0Var.z().e();
            z zVar = null;
            if (p == 307 || p == 308) {
                if (!e2.equals("GET") && !e2.equals("HEAD")) {
                    return null;
                }
            } else if (p == 401) {
                return this.f3481a.a().a(c0Var, a0Var);
            } else {
                if (p != 503) {
                    if (p == 407) {
                        if ((c0Var != null ? c0Var.b() : this.f3481a.u()).type() == Proxy.Type.HTTP) {
                            return this.f3481a.v().a(c0Var, a0Var);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (p != 408) {
                        switch (p) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (!this.f3481a.y()) {
                        return null;
                    } else {
                        a0Var.z().a();
                        if ((a0Var.w() == null || a0Var.w().p() != 408) && a(a0Var, 0) <= 0) {
                            return a0Var.z();
                        }
                        return null;
                    }
                } else if ((a0Var.w() == null || a0Var.w().p() != 503) && a(a0Var, Integer.MAX_VALUE) == 0) {
                    return a0Var.z();
                } else {
                    return null;
                }
            }
            if (!this.f3481a.l() || (b2 = a0Var.b("Location")) == null || (b3 = a0Var.z().g().b(b2)) == null) {
                return null;
            }
            if (!b3.m().equals(a0Var.z().g().m()) && !this.f3481a.n()) {
                return null;
            }
            y.a f = a0Var.z().f();
            if (f.b(e2)) {
                boolean d2 = f.d(e2);
                if (f.c(e2)) {
                    f.a("GET", (z) null);
                } else {
                    if (d2) {
                        zVar = a0Var.z().a();
                    }
                    f.a(e2, zVar);
                }
                if (!d2) {
                    f.a("Transfer-Encoding");
                    f.a("Content-Length");
                    f.a("Content-Type");
                }
            }
            if (!a(a0Var, b3)) {
                f.a("Authorization");
            }
            f.a(b3);
            return f.a();
        }
        throw new IllegalStateException();
    }

    private boolean a(a0 a0Var, s sVar) {
        s g = a0Var.z().g();
        return g.g().equals(sVar.g()) && g.j() == sVar.j() && g.m().equals(sVar.m());
    }

    private boolean a(IOException iOException, g gVar, boolean z, y yVar) {
        gVar.a(iOException);
        if (!this.f3481a.y()) {
            return false;
        }
        if (z) {
            yVar.a();
        }
        return a(iOException, z) && gVar.d();
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException);
    }

    @Override // d.t
    public a0 a(t.a aVar) {
        a0 a2;
        y a3;
        y b2 = aVar.b();
        g gVar = (g) aVar;
        e e2 = gVar.e();
        p g = gVar.g();
        g gVar2 = new g(this.f3481a.f(), a(b2.g()), e2, g, this.f3483c);
        this.f3482b = gVar2;
        a0 a0Var = null;
        int i = 0;
        while (!this.f3484d) {
            try {
                try {
                    a2 = gVar.a(b2, gVar2, null, null);
                    if (a0Var != null) {
                        a0.a v = a2.v();
                        a0.a v2 = a0Var.v();
                        v2.a((b0) null);
                        v.c(v2.a());
                        a2 = v.a();
                    }
                    try {
                        a3 = a(a2, gVar2.g());
                    } catch (IOException e3) {
                        gVar2.f();
                        throw e3;
                    }
                } catch (Throwable th) {
                    gVar2.a((IOException) null);
                    gVar2.f();
                    throw th;
                }
            } catch (d.f0.f.e e4) {
                if (!a(e4.b(), gVar2, false, b2)) {
                    throw e4.a();
                }
            } catch (IOException e5) {
                if (!a(e5, gVar2, !(e5 instanceof d.f0.i.a), b2)) {
                    throw e5;
                }
            }
            if (a3 == null) {
                gVar2.f();
                return a2;
            }
            c.a(a2.m());
            int i2 = i + 1;
            if (i2 <= 20) {
                a3.a();
                if (!a(a2, a3.g())) {
                    gVar2.f();
                    gVar2 = new g(this.f3481a.f(), a(a3.g()), e2, g, this.f3483c);
                    this.f3482b = gVar2;
                } else if (gVar2.b() != null) {
                    throw new IllegalStateException("Closing the body of " + a2 + " didn't close its backing stream. Bad interceptor?");
                }
                a0Var = a2;
                b2 = a3;
                i = i2;
            } else {
                gVar2.f();
                throw new ProtocolException("Too many follow-up requests: " + i2);
            }
        }
        gVar2.f();
        throw new IOException("Canceled");
    }

    public void a() {
        this.f3484d = true;
        g gVar = this.f3482b;
        if (gVar != null) {
            gVar.a();
        }
    }

    public void a(Object obj) {
        this.f3483c = obj;
    }

    public boolean b() {
        return this.f3484d;
    }
}
