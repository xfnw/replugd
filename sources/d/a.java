package d;

import d.f0.c;
import d.s;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    final s f3346a;

    /* renamed from: b  reason: collision with root package name */
    final o f3347b;

    /* renamed from: c  reason: collision with root package name */
    final SocketFactory f3348c;

    /* renamed from: d  reason: collision with root package name */
    final b f3349d;

    /* renamed from: e  reason: collision with root package name */
    final List<w> f3350e;
    final List<k> f;
    final ProxySelector g;
    final Proxy h;
    final SSLSocketFactory i;
    final HostnameVerifier j;
    final g k;

    public a(String str, int i, o oVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b bVar, Proxy proxy, List<w> list, List<k> list2, ProxySelector proxySelector) {
        s.a aVar = new s.a();
        aVar.d(sSLSocketFactory != null ? "https" : "http");
        aVar.b(str);
        aVar.a(i);
        this.f3346a = aVar.a();
        if (oVar != null) {
            this.f3347b = oVar;
            if (socketFactory != null) {
                this.f3348c = socketFactory;
                if (bVar != null) {
                    this.f3349d = bVar;
                    if (list != null) {
                        this.f3350e = c.a(list);
                        if (list2 != null) {
                            this.f = c.a(list2);
                            if (proxySelector != null) {
                                this.g = proxySelector;
                                this.h = proxy;
                                this.i = sSLSocketFactory;
                                this.j = hostnameVerifier;
                                this.k = gVar;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    public g a() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        return this.f3347b.equals(aVar.f3347b) && this.f3349d.equals(aVar.f3349d) && this.f3350e.equals(aVar.f3350e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && c.a(this.h, aVar.h) && c.a(this.i, aVar.i) && c.a(this.j, aVar.j) && c.a(this.k, aVar.k) && k().j() == aVar.k().j();
    }

    public List<k> b() {
        return this.f;
    }

    public o c() {
        return this.f3347b;
    }

    public HostnameVerifier d() {
        return this.j;
    }

    public List<w> e() {
        return this.f3350e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f3346a.equals(aVar.f3346a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public Proxy f() {
        return this.h;
    }

    public b g() {
        return this.f3349d;
    }

    public ProxySelector h() {
        return this.g;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f3346a.hashCode()) * 31) + this.f3347b.hashCode()) * 31) + this.f3349d.hashCode()) * 31) + this.f3350e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Proxy proxy = this.h;
        int i = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        g gVar = this.k;
        if (gVar != null) {
            i = gVar.hashCode();
        }
        return hashCode4 + i;
    }

    public SocketFactory i() {
        return this.f3348c;
    }

    public SSLSocketFactory j() {
        return this.i;
    }

    public s k() {
        return this.f3346a;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f3346a.g());
        sb.append(":");
        sb.append(this.f3346a.j());
        if (this.h != null) {
            sb.append(", proxy=");
            obj = this.h;
        } else {
            sb.append(", proxySelector=");
            obj = this.g;
        }
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }
}
