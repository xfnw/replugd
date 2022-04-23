package d;

import d.f0.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f3684a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<String> f3685a = new ArrayList(20);

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                b(str.substring(0, indexOf), str.substring(indexOf + 1));
                return this;
            } else if (str.startsWith(":")) {
                b("", str.substring(1));
                return this;
            } else {
                b("", str);
                return this;
            }
        }

        public a a(String str, String str2) {
            r.c(str);
            r.a(str2, str);
            b(str, str2);
            return this;
        }

        public r a() {
            return new r(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a b(String str, String str2) {
            this.f3685a.add(str);
            this.f3685a.add(str2.trim());
            return this;
        }

        public String b(String str) {
            for (int size = this.f3685a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f3685a.get(size))) {
                    return this.f3685a.get(size + 1);
                }
            }
            return null;
        }

        public a c(String str) {
            int i = 0;
            while (i < this.f3685a.size()) {
                if (str.equalsIgnoreCase(this.f3685a.get(i))) {
                    this.f3685a.remove(i);
                    this.f3685a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public a c(String str, String str2) {
            r.c(str);
            r.a(str2, str);
            c(str);
            b(str, str2);
            return this;
        }
    }

    r(a aVar) {
        List<String> list = aVar.f3685a;
        this.f3684a = (String[]) list.toArray(new String[list.size()]);
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    static void a(String str, String str2) {
        if (str != null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                    throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }

    static void c(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (!str.isEmpty()) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                }
            }
        } else {
            throw new IllegalArgumentException("name is empty");
        }
    }

    public a a() {
        a aVar = new a();
        Collections.addAll(aVar.f3685a, this.f3684a);
        return aVar;
    }

    public String a(int i) {
        return this.f3684a[i * 2];
    }

    public String a(String str) {
        return a(this.f3684a, str);
    }

    public int b() {
        return this.f3684a.length / 2;
    }

    public String b(int i) {
        return this.f3684a[(i * 2) + 1];
    }

    public List<String> b(String str) {
        int b2 = b();
        ArrayList arrayList = null;
        for (int i = 0; i < b2; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && Arrays.equals(((r) obj).f3684a, this.f3684a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f3684a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int b2 = b();
        for (int i = 0; i < b2; i++) {
            sb.append(a(i));
            sb.append(": ");
            sb.append(b(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
