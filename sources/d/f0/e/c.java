package d.f0.e;

import d.a0;
import d.f0.g.d;
import d.f0.g.e;
import d.r;
import d.y;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final y f3415a;

    /* renamed from: b  reason: collision with root package name */
    public final a0 f3416b;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f3417a;

        /* renamed from: b  reason: collision with root package name */
        final y f3418b;

        /* renamed from: c  reason: collision with root package name */
        final a0 f3419c;

        /* renamed from: d  reason: collision with root package name */
        private Date f3420d;

        /* renamed from: e  reason: collision with root package name */
        private String f3421e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public a(long j, y yVar, a0 a0Var) {
            this.l = -1;
            this.f3417a = j;
            this.f3418b = yVar;
            this.f3419c = a0Var;
            if (a0Var != null) {
                this.i = a0Var.A();
                this.j = a0Var.y();
                r r = a0Var.r();
                int b2 = r.b();
                for (int i = 0; i < b2; i++) {
                    String a2 = r.a(i);
                    String b3 = r.b(i);
                    if ("Date".equalsIgnoreCase(a2)) {
                        this.f3420d = d.a(b3);
                        this.f3421e = b3;
                    } else if ("Expires".equalsIgnoreCase(a2)) {
                        this.h = d.a(b3);
                    } else if ("Last-Modified".equalsIgnoreCase(a2)) {
                        this.f = d.a(b3);
                        this.g = b3;
                    } else if ("ETag".equalsIgnoreCase(a2)) {
                        this.k = b3;
                    } else if ("Age".equalsIgnoreCase(a2)) {
                        this.l = e.a(b3, -1);
                    }
                }
            }
        }

        private static boolean a(y yVar) {
            return (yVar.a("If-Modified-Since") == null && yVar.a("If-None-Match") == null) ? false : true;
        }

        private long b() {
            Date date = this.f3420d;
            long j = 0;
            if (date != null) {
                j = Math.max(0L, this.j - date.getTime());
            }
            int i = this.l;
            if (i != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis(i));
            }
            long j2 = this.j;
            return j + (j2 - this.i) + (this.f3417a - j2);
        }

        private long c() {
            d.d n = this.f3419c.n();
            if (n.c() != -1) {
                return TimeUnit.SECONDS.toMillis(n.c());
            }
            if (this.h != null) {
                Date date = this.f3420d;
                long time = this.h.getTime() - (date != null ? date.getTime() : this.j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            } else if (this.f == null || this.f3419c.z().g().k() != null) {
                return 0L;
            } else {
                Date date2 = this.f3420d;
                long time2 = (date2 != null ? date2.getTime() : this.i) - this.f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0L;
            }
        }

        private c d() {
            if (this.f3419c == null) {
                return new c(this.f3418b, null);
            }
            if ((!this.f3418b.d() || this.f3419c.q() != null) && c.a(this.f3419c, this.f3418b)) {
                d.d b2 = this.f3418b.b();
                if (b2.g() || a(this.f3418b)) {
                    return new c(this.f3418b, null);
                }
                d.d n = this.f3419c.n();
                long b3 = b();
                long c2 = c();
                if (b2.c() != -1) {
                    c2 = Math.min(c2, TimeUnit.SECONDS.toMillis(b2.c()));
                }
                long j = 0;
                long millis = b2.e() != -1 ? TimeUnit.SECONDS.toMillis(b2.e()) : 0L;
                if (!n.f() && b2.d() != -1) {
                    j = TimeUnit.SECONDS.toMillis(b2.d());
                }
                if (!n.g()) {
                    long j2 = millis + b3;
                    if (j2 < j + c2) {
                        a0.a v = this.f3419c.v();
                        if (j2 >= c2) {
                            v.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (b3 > 86400000 && e()) {
                            v.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new c(null, v.a());
                    }
                }
                String str = this.k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.f != null) {
                    str = this.g;
                } else if (this.f3420d == null) {
                    return new c(this.f3418b, null);
                } else {
                    str = this.f3421e;
                }
                r.a a2 = this.f3418b.c().a();
                d.f0.a.f3401a.a(a2, str2, str);
                y.a f = this.f3418b.f();
                f.a(a2.a());
                return new c(f.a(), this.f3419c);
            }
            return new c(this.f3418b, null);
        }

        private boolean e() {
            return this.f3419c.n().c() == -1 && this.h == null;
        }

        public c a() {
            c d2 = d();
            return (d2.f3415a == null || !this.f3418b.b().i()) ? d2 : new c(null, null);
        }
    }

    c(y yVar, a0 a0Var) {
        this.f3415a = yVar;
        this.f3416b = a0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
        if (r3.n().a() == false) goto L_0x0059;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(d.a0 r3, d.y r4) {
        /*
            int r0 = r3.p()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L_0x005a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L_0x0031
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L_0x005a
            switch(r0) {
                case 300: goto L_0x005a;
                case 301: goto L_0x005a;
                case 302: goto L_0x0031;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0059
        L_0x0031:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.b(r0)
            if (r0 != 0) goto L_0x005a
            d.d r0 = r3.n()
            int r0 = r0.c()
            r1 = -1
            if (r0 != r1) goto L_0x005a
            d.d r0 = r3.n()
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x005a
            d.d r0 = r3.n()
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            return r2
        L_0x005a:
            d.d r3 = r3.n()
            boolean r3 = r3.h()
            if (r3 != 0) goto L_0x006f
            d.d r3 = r4.b()
            boolean r3 = r3.h()
            if (r3 != 0) goto L_0x006f
            r2 = 1
        L_0x006f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f0.e.c.a(d.a0, d.y):boolean");
    }
}
