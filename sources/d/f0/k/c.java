package d.f0.k;

import d.w;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: c  reason: collision with root package name */
    final Method f3622c;

    /* renamed from: d  reason: collision with root package name */
    final Method f3623d;

    c(Method method, Method method2) {
        this.f3622c = method;
        this.f3623d = method2;
    }

    public static c c() {
        try {
            return new c(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // d.f0.k.f
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a2 = f.a(list);
            this.f3622c.invoke(sSLParameters, a2.toArray(new String[a2.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw d.f0.c.a("unable to set ssl parameters", (Exception) e2);
        }
    }

    @Override // d.f0.k.f
    public String b(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f3623d.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw d.f0.c.a("unable to get selected protocols", (Exception) e2);
        }
    }
}
