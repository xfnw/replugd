package d.f0.k;

import android.os.Build;
import android.util.Log;
import d.f0.m.e;
import d.w;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: c  reason: collision with root package name */
    private final e<Socket> f3612c;

    /* renamed from: d  reason: collision with root package name */
    private final e<Socket> f3613d;

    /* renamed from: e  reason: collision with root package name */
    private final e<Socket> f3614e;
    private final e<Socket> f;
    private final c g = c.a();

    /* renamed from: d.f0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0101a extends d.f0.m.c {

        /* renamed from: a  reason: collision with root package name */
        private final Object f3615a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f3616b;

        C0101a(Object obj, Method method) {
            this.f3615a = obj;
            this.f3616b = method;
        }

        @Override // d.f0.m.c
        public List<Certificate> a(List<Certificate> list, String str) {
            try {
                return (List) this.f3616b.invoke(this.f3615a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e3.getMessage());
                sSLPeerUnverifiedException.initCause(e3);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0101a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static final class b implements e {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f3617a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f3618b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.f3618b = method;
            this.f3617a = x509TrustManager;
        }

        @Override // d.f0.m.e
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f3618b.invoke(this.f3617a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw d.f0.c.a("unable to get issues and signature", (Exception) e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3617a.equals(bVar.f3617a) && this.f3618b.equals(bVar.f3618b);
        }

        public int hashCode() {
            return this.f3617a.hashCode() + (this.f3618b.hashCode() * 31);
        }
    }

    /* loaded from: classes.dex */
    static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Method f3619a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f3620b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f3621c;

        c(Method method, Method method2, Method method3) {
            this.f3619a = method;
            this.f3620b = method2;
            this.f3621c = method3;
        }

        static c a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method3 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new c(method3, method, method2);
        }

        Object a(String str) {
            Method method = this.f3619a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f3620b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f3621c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    a(Class<?> cls, e<Socket> eVar, e<Socket> eVar2, e<Socket> eVar3, e<Socket> eVar4) {
        this.f3612c = eVar;
        this.f3613d = eVar2;
        this.f3614e = eVar3;
        this.f = eVar4;
    }

    private boolean a(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.b(str);
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return a(str, cls, obj);
        }
    }

    public static f c() {
        Class<?> cls;
        e eVar;
        e eVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            e eVar3 = new e(null, "setUseSessionTickets", Boolean.TYPE);
            e eVar4 = new e(null, "setHostname", String.class);
            if (f()) {
                eVar2 = new e(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                eVar = new e(null, "setAlpnProtocols", byte[].class);
            } else {
                eVar2 = null;
                eVar = null;
            }
            return new a(cls, eVar3, eVar4, eVar2, eVar);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    private static boolean f() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // d.f0.k.f
    public d.f0.m.c a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0101a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    @Override // d.f0.k.f
    public Object a(String str) {
        return this.g.a(str);
    }

    @Override // d.f0.k.f
    public void a(int i, String str, Throwable th) {
        int min;
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    @Override // d.f0.k.f
    public void a(String str, Object obj) {
        if (!this.g.a(obj)) {
            a(5, str, (Throwable) null);
        }
    }

    @Override // d.f0.k.f
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e2) {
            if (d.f0.c.a(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        } catch (ClassCastException e3) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e3);
                throw iOException;
            }
            throw e3;
        } catch (SecurityException e4) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e4);
            throw iOException2;
        }
    }

    @Override // d.f0.k.f
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        if (str != null) {
            this.f3612c.c(sSLSocket, true);
            this.f3613d.c(sSLSocket, str);
        }
        e<Socket> eVar = this.f;
        if (eVar != null && eVar.a((e<Socket>) sSLSocket)) {
            this.f.d(sSLSocket, f.b(list));
        }
    }

    @Override // d.f0.k.f
    public e b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(x509TrustManager);
        }
    }

    @Override // d.f0.k.f
    public String b(SSLSocket sSLSocket) {
        byte[] bArr;
        e<Socket> eVar = this.f3614e;
        if (eVar == null || !eVar.a((e<Socket>) sSLSocket) || (bArr = (byte[]) this.f3614e.d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, d.f0.c.f3406d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000b, code lost:
        if (android.os.Build.VERSION.SDK_INT < 22) goto L_0x0011;
     */
    @Override // d.f0.k.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public javax.net.ssl.SSLContext b() {
        /*
            r3 = this;
            r0 = 1
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: NoClassDefFoundError -> 0x0010
            r2 = 16
            if (r1 < r2) goto L_0x000e
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: NoClassDefFoundError -> 0x0010
            r2 = 22
            if (r1 >= r2) goto L_0x000e
            goto L_0x0011
        L_0x000e:
            r0 = 0
            goto L_0x0011
        L_0x0010:
        L_0x0011:
            if (r0 == 0) goto L_0x001a
            java.lang.String r0 = "TLSv1.2"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch: NoSuchAlgorithmException -> 0x001a
            return r0
        L_0x001a:
            java.lang.String r0 = "TLS"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch: NoSuchAlgorithmException -> 0x0021
            return r0
        L_0x0021:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "No TLS provider"
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f0.k.a.b():javax.net.ssl.SSLContext");
    }

    @Override // d.f0.k.f
    public boolean b(String str) {
        Exception e2;
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return b(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException e3) {
            e2 = e3;
            throw d.f0.c.a("unable to determine cleartext support", e2);
        } catch (IllegalArgumentException e4) {
            e2 = e4;
            throw d.f0.c.a("unable to determine cleartext support", e2);
        } catch (InvocationTargetException e5) {
            e2 = e5;
            throw d.f0.c.a("unable to determine cleartext support", e2);
        }
    }
}
