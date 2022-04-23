package d;

import d.f0.c;
import d.f0.g.f;
import d.r;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    final s f3715a;

    /* renamed from: b  reason: collision with root package name */
    final String f3716b;

    /* renamed from: c  reason: collision with root package name */
    final r f3717c;

    /* renamed from: d  reason: collision with root package name */
    final z f3718d;

    /* renamed from: e  reason: collision with root package name */
    final Map<Class<?>, Object> f3719e;
    private volatile d f;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        s f3720a;

        /* renamed from: b  reason: collision with root package name */
        String f3721b;

        /* renamed from: c  reason: collision with root package name */
        r.a f3722c;

        /* renamed from: d  reason: collision with root package name */
        z f3723d;

        /* renamed from: e  reason: collision with root package name */
        Map<Class<?>, Object> f3724e;

        public a() {
            this.f3724e = Collections.emptyMap();
            this.f3721b = "GET";
            this.f3722c = new r.a();
        }

        a(y yVar) {
            this.f3724e = Collections.emptyMap();
            this.f3720a = yVar.f3715a;
            this.f3721b = yVar.f3716b;
            this.f3723d = yVar.f3718d;
            this.f3724e = yVar.f3719e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(yVar.f3719e);
            this.f3722c = yVar.f3717c.a();
        }

        public a a(d dVar) {
            String dVar2 = dVar.toString();
            if (dVar2.isEmpty()) {
                a("Cache-Control");
                return this;
            }
            a("Cache-Control", dVar2);
            return this;
        }

        public a a(r rVar) {
            this.f3722c = rVar.a();
            return this;
        }

        public a a(s sVar) {
            if (sVar != null) {
                this.f3720a = sVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a a(String str) {
            this.f3722c.c(str);
            return this;
        }

        public a a(String str, z zVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (zVar != null && !f.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (zVar != null || !f.e(str)) {
                this.f3721b = str;
                this.f3723d = zVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public a a(String str, String str2) {
            this.f3722c.c(str, str2);
            return this;
        }

        public y a() {
            if (this.f3720a != null) {
                return new y(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a b(String str) {
            StringBuilder sb;
            int i;
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    sb = new StringBuilder();
                    sb.append("http:");
                    i = 3;
                } else {
                    if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                        sb = new StringBuilder();
                        sb.append("https:");
                        i = 4;
                    }
                    a(s.d(str));
                    return this;
                }
                sb.append(str.substring(i));
                str = sb.toString();
                a(s.d(str));
                return this;
            }
            throw new NullPointerException("url == null");
        }
    }

    y(a aVar) {
        this.f3715a = aVar.f3720a;
        this.f3716b = aVar.f3721b;
        this.f3717c = aVar.f3722c.a();
        this.f3718d = aVar.f3723d;
        this.f3719e = c.a(aVar.f3724e);
    }

    public z a() {
        return this.f3718d;
    }

    public String a(String str) {
        return this.f3717c.a(str);
    }

    public d b() {
        d dVar = this.f;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f3717c);
        this.f = a2;
        return a2;
    }

    public List<String> b(String str) {
        return this.f3717c.b(str);
    }

    public r c() {
        return this.f3717c;
    }

    public boolean d() {
        return this.f3715a.h();
    }

    public String e() {
        return this.f3716b;
    }

    public a f() {
        return new a(this);
    }

    public s g() {
        return this.f3715a;
    }

    public String toString() {
        return "Request{method=" + this.f3716b + ", url=" + this.f3715a + ", tags=" + this.f3719e + '}';
    }
}
