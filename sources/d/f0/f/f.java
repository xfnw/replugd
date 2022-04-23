package d.f0.f;

import d.c0;
import d.e;
import d.f0.c;
import d.p;
import d.s;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final d.a f3455a;

    /* renamed from: b  reason: collision with root package name */
    private final d f3456b;

    /* renamed from: c  reason: collision with root package name */
    private final e f3457c;

    /* renamed from: d  reason: collision with root package name */
    private final p f3458d;
    private int f;

    /* renamed from: e  reason: collision with root package name */
    private List<Proxy> f3459e = Collections.emptyList();
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<c0> h = new ArrayList();

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<c0> f3460a;

        /* renamed from: b  reason: collision with root package name */
        private int f3461b = 0;

        a(List<c0> list) {
            this.f3460a = list;
        }

        public List<c0> a() {
            return new ArrayList(this.f3460a);
        }

        public boolean b() {
            return this.f3461b < this.f3460a.size();
        }

        public c0 c() {
            if (b()) {
                List<c0> list = this.f3460a;
                int i = this.f3461b;
                this.f3461b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    public f(d.a aVar, d dVar, e eVar, p pVar) {
        this.f3455a = aVar;
        this.f3456b = dVar;
        this.f3457c = eVar;
        this.f3458d = pVar;
        a(aVar.k(), aVar.f());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private void a(s sVar, Proxy proxy) {
        List<Proxy> a2;
        if (proxy != null) {
            a2 = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f3455a.h().select(sVar.n());
            a2 = (select == null || select.isEmpty()) ? c.a(Proxy.NO_PROXY) : c.a(select);
        }
        this.f3459e = a2;
        this.f = 0;
    }

    private void a(Proxy proxy) {
        String str;
        int i;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f3455a.k().g();
            i = this.f3455a.k().j();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = a(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i < 1 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            this.f3458d.a(this.f3457c, str);
            List<InetAddress> a2 = this.f3455a.c().a(str);
            if (!a2.isEmpty()) {
                this.f3458d.a(this.f3457c, str, a2);
                int size = a2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.g.add(new InetSocketAddress(a2.get(i2), i));
                }
                return;
            }
            throw new UnknownHostException(this.f3455a.c() + " returned no addresses for " + str);
        }
    }

    private boolean c() {
        return this.f < this.f3459e.size();
    }

    private Proxy d() {
        if (c()) {
            List<Proxy> list = this.f3459e;
            int i = this.f;
            this.f = i + 1;
            Proxy proxy = list.get(i);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f3455a.k().g() + "; exhausted proxy configurations: " + this.f3459e);
    }

    public void a(c0 c0Var, IOException iOException) {
        if (!(c0Var.b().type() == Proxy.Type.DIRECT || this.f3455a.h() == null)) {
            this.f3455a.h().connectFailed(this.f3455a.k().n(), c0Var.b().address(), iOException);
        }
        this.f3456b.b(c0Var);
    }

    public boolean a() {
        return c() || !this.h.isEmpty();
    }

    public a b() {
        if (a()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy d2 = d();
                int size = this.g.size();
                for (int i = 0; i < size; i++) {
                    c0 c0Var = new c0(this.f3455a, d2, this.g.get(i));
                    if (this.f3456b.c(c0Var)) {
                        this.h.add(c0Var);
                    } else {
                        arrayList.add(c0Var);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.h);
                this.h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }
}
