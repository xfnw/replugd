package d;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    final a f3384a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f3385b;

    /* renamed from: c  reason: collision with root package name */
    final InetSocketAddress f3386c;

    public c0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f3384a = aVar;
            this.f3385b = proxy;
            this.f3386c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public a a() {
        return this.f3384a;
    }

    public Proxy b() {
        return this.f3385b;
    }

    public boolean c() {
        return this.f3384a.i != null && this.f3385b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f3386c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            if (c0Var.f3384a.equals(this.f3384a) && c0Var.f3385b.equals(this.f3385b) && c0Var.f3386c.equals(this.f3386c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f3384a.hashCode()) * 31) + this.f3385b.hashCode()) * 31) + this.f3386c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f3386c + "}";
    }
}
