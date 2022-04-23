package d.f0.k;

import d.f0.c;
import d.w;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: c  reason: collision with root package name */
    private final Method f3624c;

    /* renamed from: d  reason: collision with root package name */
    private final Method f3625d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f3626e;
    private final Class<?> f;
    private final Class<?> g;

    /* loaded from: classes.dex */
    private static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f3627a;

        /* renamed from: b  reason: collision with root package name */
        boolean f3628b;

        /* renamed from: c  reason: collision with root package name */
        String f3629c;

        a(List<String> list) {
            this.f3627a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = c.f3404b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f3628b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f3627a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            obj2 = this.f3627a.get(0);
                            break;
                        } else if (this.f3627a.contains(list.get(i))) {
                            obj2 = list.get(i);
                            break;
                        } else {
                            i++;
                        }
                    }
                    String str = (String) obj2;
                    this.f3629c = str;
                    return str;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f3629c = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    d(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f3624c = method;
        this.f3625d = method2;
        this.f3626e = method3;
        this.f = cls;
        this.g = cls2;
    }

    public static f c() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            return new d(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // d.f0.k.f
    public void a(SSLSocket sSLSocket) {
        try {
            this.f3626e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw c.a("unable to remove alpn", (Exception) e2);
        }
    }

    @Override // d.f0.k.f
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            this.f3624c.invoke(null, sSLSocket, Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{this.f, this.g}, new a(f.a(list))));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw c.a("unable to set alpn", (Exception) e2);
        }
    }

    @Override // d.f0.k.f
    public String b(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f3625d.invoke(null, sSLSocket));
            if (!aVar.f3628b && aVar.f3629c == null) {
                f.d().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (aVar.f3628b) {
                return null;
            } else {
                return aVar.f3629c;
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw c.a("unable to get selected protocol", (Exception) e2);
        }
    }
}
