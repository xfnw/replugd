package d;

import d.f0.c;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class s {
    private static final char[] i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    final String f3686a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3687b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3688c;

    /* renamed from: d  reason: collision with root package name */
    final String f3689d;

    /* renamed from: e  reason: collision with root package name */
    final int f3690e;
    private final List<String> f;
    private final String g;
    private final String h;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f3691a;

        /* renamed from: d  reason: collision with root package name */
        String f3694d;
        List<String> g;
        String h;

        /* renamed from: b  reason: collision with root package name */
        String f3692b = "";

        /* renamed from: c  reason: collision with root package name */
        String f3693c = "";

        /* renamed from: e  reason: collision with root package name */
        int f3695e = -1;
        final List<String> f = new ArrayList();

        public a() {
            this.f.add("");
        }

        private static String a(String str, int i, int i2) {
            return c.a(s.a(str, i, i2, false));
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String a2 = s.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (!f(a2)) {
                if (g(a2)) {
                    d();
                    return;
                }
                List<String> list = this.f;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f;
                    list2.set(list2.size() - 1, a2);
                } else {
                    this.f.add(a2);
                }
                if (z) {
                    this.f.add("");
                }
            }
        }

        private static int b(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(s.a(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private static int c(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private void d() {
            List<String> list = this.f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f.isEmpty()) {
                this.f.add("");
                return;
            }
            List<String> list2 = this.f;
            list2.set(list2.size() - 1, "");
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0041 -> B:10:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void d(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = d.f0.c.a(r11, r6, r13, r12)
                if (r12 >= r13) goto L_0x0036
                r0 = 1
                goto L_0x0037
            L_0x0036:
                r0 = 0
            L_0x0037:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d.s.a.d(java.lang.String, int, int):void");
        }

        private static int e(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (!(charAt2 == '+' || charAt2 == '-' || charAt2 == '.')) {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int f(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public a a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.f3695e = i;
            return this;
        }

        a a(s sVar, String str) {
            int e2;
            int a2;
            int i;
            int b2 = c.b(str, 0, str.length());
            int c2 = c.c(str, b2, str.length());
            if (e(str, b2, c2) != -1) {
                if (str.regionMatches(true, b2, "https:", 0, 6)) {
                    this.f3691a = "https";
                    b2 += 6;
                } else if (str.regionMatches(true, b2, "http:", 0, 5)) {
                    this.f3691a = "http";
                    b2 += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, e2) + "'");
                }
            } else if (sVar != null) {
                this.f3691a = sVar.f3686a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int f = f(str, b2, c2);
            char c3 = '?';
            char c4 = '#';
            if (f >= 2 || sVar == null || !sVar.f3686a.equals(this.f3691a)) {
                int i2 = b2 + f;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a2 = c.a(str, i2, c2, "@/\\?#");
                    char charAt = a2 != c2 ? str.charAt(a2) : (char) 65535;
                    if (charAt == 65535 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int a3 = c.a(str, i2, a2, ':');
                            i = a2;
                            String a4 = s.a(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                a4 = this.f3692b + "%40" + a4;
                            }
                            this.f3692b = a4;
                            if (a3 != i) {
                                this.f3693c = s.a(str, a3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = a2;
                            this.f3693c += "%40" + s.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                    }
                    c3 = '?';
                    c4 = '#';
                }
                int c5 = c(str, i2, a2);
                int i3 = c5 + 1;
                if (i3 < a2) {
                    this.f3694d = a(str, i2, c5);
                    this.f3695e = b(str, i3, a2);
                    if (this.f3695e == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, a2) + '\"');
                    }
                } else {
                    this.f3694d = a(str, i2, c5);
                    this.f3695e = s.c(this.f3691a);
                }
                if (this.f3694d != null) {
                    b2 = a2;
                } else {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, c5) + '\"');
                }
            } else {
                this.f3692b = sVar.f();
                this.f3693c = sVar.b();
                this.f3694d = sVar.f3689d;
                this.f3695e = sVar.f3690e;
                this.f.clear();
                this.f.addAll(sVar.d());
                if (b2 == c2 || str.charAt(b2) == '#') {
                    a(sVar.e());
                }
            }
            int a5 = c.a(str, b2, c2, "?#");
            d(str, b2, a5);
            if (a5 < c2 && str.charAt(a5) == '?') {
                int a6 = c.a(str, a5, c2, '#');
                this.g = s.e(s.a(str, a5 + 1, a6, " \"'<>#", true, false, true, true, null));
                a5 = a6;
            }
            if (a5 < c2 && str.charAt(a5) == '#') {
                this.h = s.a(str, 1 + a5, c2, "", true, false, false, false, null);
            }
            return this;
        }

        public a a(String str) {
            this.g = str != null ? s.e(s.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public s a() {
            if (this.f3691a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f3694d != null) {
                return new s(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        int b() {
            int i = this.f3695e;
            return i != -1 ? i : s.c(this.f3691a);
        }

        public a b(String str) {
            if (str != null) {
                String a2 = a(str, 0, str.length());
                if (a2 != null) {
                    this.f3694d = a2;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        a c() {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.set(i, s.a(this.f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, s.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = s.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a c(String str) {
            if (str != null) {
                this.f3693c = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public a d(String str) {
            if (str != null) {
                String str2 = "http";
                if (!str.equalsIgnoreCase(str2)) {
                    str2 = "https";
                    if (!str.equalsIgnoreCase(str2)) {
                        throw new IllegalArgumentException("unexpected scheme: " + str);
                    }
                }
                this.f3691a = str2;
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public a e(String str) {
            if (str != null) {
                this.f3692b = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            String str2 = this.f3691a;
            if (str2 != null) {
                sb.append(str2);
                str = "://";
            } else {
                str = "//";
            }
            sb.append(str);
            if (!this.f3692b.isEmpty() || !this.f3693c.isEmpty()) {
                sb.append(this.f3692b);
                if (!this.f3693c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f3693c);
                }
                sb.append('@');
            }
            String str3 = this.f3694d;
            if (str3 != null) {
                if (str3.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f3694d);
                    sb.append(']');
                } else {
                    sb.append(this.f3694d);
                }
            }
            if (!(this.f3695e == -1 && this.f3691a == null)) {
                int b2 = b();
                String str4 = this.f3691a;
                if (str4 == null || b2 != s.c(str4)) {
                    sb.append(':');
                    sb.append(b2);
                }
            }
            s.b(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                s.a(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }
    }

    s(a aVar) {
        this.f3686a = aVar.f3691a;
        this.f3687b = a(aVar.f3692b, false);
        this.f3688c = a(aVar.f3693c, false);
        this.f3689d = aVar.f3694d;
        this.f3690e = aVar.b();
        a(aVar.f, false);
        List<String> list = aVar.g;
        String str = null;
        this.f = list != null ? a(list, true) : null;
        String str2 = aVar.h;
        this.g = str2 != null ? a(str2, false) : str;
        this.h = aVar.toString();
    }

    static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            e.c cVar = new e.c();
            cVar.a(str, i2, i4);
            a(cVar, str, i4, i3, str2, z, z2, z3, z4, charset);
            return cVar.q();
        }
        return str.substring(i2, i3);
    }

    static String a(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                e.c cVar = new e.c();
                cVar.a(str, i2, i4);
                a(cVar, str, i4, i3, z);
                return cVar.q();
            }
        }
        return str.substring(i2, i3);
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void a(e.c cVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        e.c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.a(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !a(str, i2, i3)))))) {
                    if (cVar2 == null) {
                        cVar2 = new e.c();
                    }
                    if (charset == null || charset.equals(c.f3406d)) {
                        cVar2.c(codePointAt);
                    } else {
                        cVar2.a(str, i2, Character.charCount(codePointAt) + i2, charset);
                    }
                    while (!cVar2.j()) {
                        int readByte = cVar2.readByte() & 255;
                        cVar.writeByte(37);
                        cVar.writeByte((int) i[(readByte >> 4) & 15]);
                        cVar.writeByte((int) i[readByte & 15]);
                    }
                } else {
                    cVar.c(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    static void a(e.c cVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt != 37 || (i4 = i2 + 2) >= i3) {
                if (codePointAt == 43 && z) {
                    cVar.writeByte(32);
                    i2 += Character.charCount(codePointAt);
                }
                cVar.c(codePointAt);
                i2 += Character.charCount(codePointAt);
            } else {
                int a2 = c.a(str.charAt(i2 + 1));
                int a3 = c.a(str.charAt(i4));
                if (!(a2 == -1 || a3 == -1)) {
                    cVar.writeByte((a2 << 4) + a3);
                    i2 = i4;
                    i2 += Character.charCount(codePointAt);
                }
                cVar.c(codePointAt);
                i2 += Character.charCount(codePointAt);
            }
        }
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && c.a(str.charAt(i2 + 1)) != -1 && c.a(str.charAt(i4)) != -1;
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public static int c(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static s d(String str) {
        a aVar = new a();
        aVar.a(null, str);
        return aVar.a();
    }

    static List<String> e(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public a a(String str) {
        try {
            a aVar = new a();
            aVar.a(this, str);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String a() {
        if (this.g == null) {
            return null;
        }
        return this.h.substring(this.h.indexOf(35) + 1);
    }

    public s b(String str) {
        a a2 = a(str);
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    public String b() {
        if (this.f3688c.isEmpty()) {
            return "";
        }
        int indexOf = this.h.indexOf(64);
        return this.h.substring(this.h.indexOf(58, this.f3686a.length() + 3) + 1, indexOf);
    }

    public String c() {
        int indexOf = this.h.indexOf(47, this.f3686a.length() + 3);
        String str = this.h;
        return this.h.substring(indexOf, c.a(str, indexOf, str.length(), "?#"));
    }

    public List<String> d() {
        int indexOf = this.h.indexOf(47, this.f3686a.length() + 3);
        String str = this.h;
        int a2 = c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = c.a(this.h, i2, a2, '/');
            arrayList.add(this.h.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public String e() {
        if (this.f == null) {
            return null;
        }
        int indexOf = this.h.indexOf(63) + 1;
        String str = this.h;
        return this.h.substring(indexOf, c.a(str, indexOf, str.length(), '#'));
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && ((s) obj).h.equals(this.h);
    }

    public String f() {
        if (this.f3687b.isEmpty()) {
            return "";
        }
        int length = this.f3686a.length() + 3;
        String str = this.h;
        return this.h.substring(length, c.a(str, length, str.length(), ":@"));
    }

    public String g() {
        return this.f3689d;
    }

    public boolean h() {
        return this.f3686a.equals("https");
    }

    public int hashCode() {
        return this.h.hashCode();
    }

    public a i() {
        a aVar = new a();
        aVar.f3691a = this.f3686a;
        aVar.f3692b = f();
        aVar.f3693c = b();
        aVar.f3694d = this.f3689d;
        aVar.f3695e = this.f3690e != c(this.f3686a) ? this.f3690e : -1;
        aVar.f.clear();
        aVar.f.addAll(d());
        aVar.a(e());
        aVar.h = a();
        return aVar;
    }

    public int j() {
        return this.f3690e;
    }

    public String k() {
        if (this.f == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a(sb, this.f);
        return sb.toString();
    }

    public String l() {
        a a2 = a("/...");
        a2.e("");
        a2.c("");
        return a2.a().toString();
    }

    public String m() {
        return this.f3686a;
    }

    public URI n() {
        a i2 = i();
        i2.c();
        String aVar = i2.toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public String toString() {
        return this.h;
    }
}
