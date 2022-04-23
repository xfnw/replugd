package d;

import d.f0.c;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class k {
    public static final k g;

    /* renamed from: a  reason: collision with root package name */
    final boolean f3658a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f3659b;

    /* renamed from: c  reason: collision with root package name */
    final String[] f3660c;

    /* renamed from: d  reason: collision with root package name */
    final String[] f3661d;

    /* renamed from: e  reason: collision with root package name */
    private static final h[] f3657e = {h.q, h.r, h.s, h.t, h.u, h.k, h.m, h.l, h.n, h.p, h.o};
    private static final h[] f = {h.q, h.r, h.s, h.t, h.u, h.k, h.m, h.l, h.n, h.p, h.o, h.i, h.j, h.g, h.h, h.f3649e, h.f, h.f3648d};
    public static final k h = new a(false).a();

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f3662a;

        /* renamed from: b  reason: collision with root package name */
        String[] f3663b;

        /* renamed from: c  reason: collision with root package name */
        String[] f3664c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3665d;

        public a(k kVar) {
            this.f3662a = kVar.f3658a;
            this.f3663b = kVar.f3660c;
            this.f3664c = kVar.f3661d;
            this.f3665d = kVar.f3659b;
        }

        a(boolean z) {
            this.f3662a = z;
        }

        public a a(boolean z) {
            if (this.f3662a) {
                this.f3665d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a a(d0... d0VarArr) {
            if (this.f3662a) {
                String[] strArr = new String[d0VarArr.length];
                for (int i = 0; i < d0VarArr.length; i++) {
                    strArr[i] = d0VarArr[i].f3400b;
                }
                b(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a a(h... hVarArr) {
            if (this.f3662a) {
                String[] strArr = new String[hVarArr.length];
                for (int i = 0; i < hVarArr.length; i++) {
                    strArr[i] = hVarArr[i].f3650a;
                }
                a(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(String... strArr) {
            if (!this.f3662a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f3663b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public k a() {
            return new k(this);
        }

        public a b(String... strArr) {
            if (!this.f3662a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f3664c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }
    }

    static {
        a aVar = new a(true);
        aVar.a(f3657e);
        aVar.a(d0.TLS_1_3, d0.TLS_1_2);
        aVar.a(true);
        aVar.a();
        a aVar2 = new a(true);
        aVar2.a(f);
        aVar2.a(d0.TLS_1_3, d0.TLS_1_2, d0.TLS_1_1, d0.TLS_1_0);
        aVar2.a(true);
        g = aVar2.a();
        a aVar3 = new a(true);
        aVar3.a(f);
        aVar3.a(d0.TLS_1_0);
        aVar3.a(true);
        aVar3.a();
    }

    k(a aVar) {
        this.f3658a = aVar.f3662a;
        this.f3660c = aVar.f3663b;
        this.f3661d = aVar.f3664c;
        this.f3659b = aVar.f3665d;
    }

    private k b(SSLSocket sSLSocket, boolean z) {
        String[] a2 = this.f3660c != null ? c.a(h.f3646b, sSLSocket.getEnabledCipherSuites(), this.f3660c) : sSLSocket.getEnabledCipherSuites();
        String[] a3 = this.f3661d != null ? c.a(c.f, sSLSocket.getEnabledProtocols(), this.f3661d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a4 = c.a(h.f3646b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a4 != -1) {
            a2 = c.a(a2, supportedCipherSuites[a4]);
        }
        a aVar = new a(this);
        aVar.a(a2);
        aVar.b(a3);
        return aVar.a();
    }

    public List<h> a() {
        String[] strArr = this.f3660c;
        if (strArr != null) {
            return h.a(strArr);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z) {
        k b2 = b(sSLSocket, z);
        String[] strArr = b2.f3661d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b2.f3660c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.f3658a) {
            return false;
        }
        String[] strArr = this.f3661d;
        if (strArr != null && !c.b(c.f, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f3660c;
        return strArr2 == null || c.b(h.f3646b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean b() {
        return this.f3658a;
    }

    public boolean c() {
        return this.f3659b;
    }

    public List<d0> d() {
        String[] strArr = this.f3661d;
        if (strArr != null) {
            return d0.a(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        boolean z = this.f3658a;
        if (z != kVar.f3658a) {
            return false;
        }
        return !z || (Arrays.equals(this.f3660c, kVar.f3660c) && Arrays.equals(this.f3661d, kVar.f3661d) && this.f3659b == kVar.f3659b);
    }

    public int hashCode() {
        if (this.f3658a) {
            return ((((527 + Arrays.hashCode(this.f3660c)) * 31) + Arrays.hashCode(this.f3661d)) * 31) + (!this.f3659b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f3658a) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f3660c != null ? a().toString() : str;
        if (this.f3661d != null) {
            str = d().toString();
        }
        return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + str + ", supportsTlsExtensions=" + this.f3659b + ")";
    }
}
