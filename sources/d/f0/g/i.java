package d.f0.g;

import d.s;
import d.y;
import java.net.Proxy;

/* loaded from: classes.dex */
public final class i {
    public static String a(s sVar) {
        String c2 = sVar.c();
        String e2 = sVar.e();
        if (e2 == null) {
            return c2;
        }
        return c2 + '?' + e2;
    }

    public static String a(y yVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(yVar.e());
        sb.append(' ');
        boolean b2 = b(yVar, type);
        s g = yVar.g();
        if (b2) {
            sb.append(g);
        } else {
            sb.append(a(g));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(y yVar, Proxy.Type type) {
        return !yVar.d() && type == Proxy.Type.HTTP;
    }
}
