package d.f0.g;

import d.a0;
import d.f0.c;
import d.l;
import d.m;
import d.r;
import d.s;
import d.y;
import e.f;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class e {
    static {
        f.d("\"\\");
        f.d("\t ,=");
    }

    public static int a(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static long a(a0 a0Var) {
        return a(a0Var.r());
    }

    public static long a(r rVar) {
        return a(rVar.a("Content-Length"));
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static r a(r rVar, r rVar2) {
        Set<String> c2 = c(rVar2);
        if (c2.isEmpty()) {
            return new r.a().a();
        }
        r.a aVar = new r.a();
        int b2 = rVar.b();
        for (int i = 0; i < b2; i++) {
            String a2 = rVar.a(i);
            if (c2.contains(a2)) {
                aVar.a(a2, rVar.b(i));
            }
        }
        return aVar.a();
    }

    public static void a(m mVar, s sVar, r rVar) {
        if (mVar != m.f3671a) {
            List<l> a2 = l.a(sVar, rVar);
            if (!a2.isEmpty()) {
                mVar.a(sVar, a2);
            }
        }
    }

    public static boolean a(a0 a0Var, r rVar, y yVar) {
        for (String str : d(a0Var)) {
            if (!c.a(rVar.b(str), yVar.b(str))) {
                return false;
            }
        }
        return true;
    }

    public static int b(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    public static boolean b(a0 a0Var) {
        if (a0Var.z().e().equals("HEAD")) {
            return false;
        }
        int p = a0Var.p();
        return (((p >= 100 && p < 200) || p == 204 || p == 304) && a(a0Var) == -1 && !"chunked".equalsIgnoreCase(a0Var.b("Transfer-Encoding"))) ? false : true;
    }

    public static boolean b(r rVar) {
        return c(rVar).contains("*");
    }

    public static Set<String> c(r rVar) {
        Set<String> emptySet = Collections.emptySet();
        int b2 = rVar.b();
        for (int i = 0; i < b2; i++) {
            if ("Vary".equalsIgnoreCase(rVar.a(i))) {
                String b3 = rVar.b(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : b3.split(",")) {
                    emptySet.add(str.trim());
                }
            }
        }
        return emptySet;
    }

    public static boolean c(a0 a0Var) {
        return b(a0Var.r());
    }

    private static Set<String> d(a0 a0Var) {
        return c(a0Var.r());
    }

    public static r e(a0 a0Var) {
        return a(a0Var.u().z().c(), a0Var.r());
    }
}
