package d.f0.i;

import e.c;
import e.e;
import e.f;
import e.l;
import e.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    static final c[] f3513a = {new c(c.i, ""), new c(c.f, "GET"), new c(c.f, "POST"), new c(c.g, "/"), new c(c.g, "/index.html"), new c(c.h, "http"), new c(c.h, "https"), new c(c.f3509e, "200"), new c(c.f3509e, "204"), new c(c.f3509e, "206"), new c(c.f3509e, "304"), new c(c.f3509e, "400"), new c(c.f3509e, "404"), new c(c.f3509e, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};

    /* renamed from: b  reason: collision with root package name */
    static final Map<f, Integer> f3514b = a();

    /* loaded from: classes.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<c> f3515a;

        /* renamed from: b  reason: collision with root package name */
        private final e f3516b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3517c;

        /* renamed from: d  reason: collision with root package name */
        private int f3518d;

        /* renamed from: e  reason: collision with root package name */
        c[] f3519e;
        int f;
        int g;
        int h;

        a(int i, int i2, t tVar) {
            this.f3515a = new ArrayList();
            this.f3519e = new c[8];
            this.f = this.f3519e.length - 1;
            this.g = 0;
            this.h = 0;
            this.f3517c = i;
            this.f3518d = i2;
            this.f3516b = l.a(tVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, t tVar) {
            this(i, i, tVar);
        }

        private int a(int i) {
            return this.f + 1 + i;
        }

        private void a(int i, c cVar) {
            this.f3515a.add(cVar);
            int i2 = cVar.f3512c;
            if (i != -1) {
                i2 -= this.f3519e[a(i)].f3512c;
            }
            int i3 = this.f3518d;
            if (i2 > i3) {
                e();
                return;
            }
            int b2 = b((this.h + i2) - i3);
            if (i == -1) {
                int i4 = this.g + 1;
                c[] cVarArr = this.f3519e;
                if (i4 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f = this.f3519e.length - 1;
                    this.f3519e = cVarArr2;
                }
                int i5 = this.f;
                this.f = i5 - 1;
                this.f3519e[i5] = cVar;
                this.g++;
            } else {
                this.f3519e[i + a(i) + b2] = cVar;
            }
            this.h += i2;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f3519e.length;
                while (true) {
                    length--;
                    if (length < this.f || i <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f3519e;
                    i -= cVarArr[length].f3512c;
                    this.h -= cVarArr[length].f3512c;
                    this.g--;
                    i2++;
                }
                c[] cVarArr2 = this.f3519e;
                int i3 = this.f;
                System.arraycopy(cVarArr2, i3 + 1, cVarArr2, i3 + 1 + i2, this.g);
                this.f += i2;
            }
            return i2;
        }

        private f c(int i) {
            c cVar;
            if (d(i)) {
                cVar = d.f3513a[i];
            } else {
                int a2 = a(i - d.f3513a.length);
                if (a2 >= 0) {
                    c[] cVarArr = this.f3519e;
                    if (a2 < cVarArr.length) {
                        cVar = cVarArr[a2];
                    }
                }
                throw new IOException("Header index too large " + (i + 1));
            }
            return cVar.f3510a;
        }

        private void d() {
            int i = this.f3518d;
            int i2 = this.h;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                e();
            } else {
                b(i2 - i);
            }
        }

        private boolean d(int i) {
            return i >= 0 && i <= d.f3513a.length - 1;
        }

        private void e() {
            Arrays.fill(this.f3519e, (Object) null);
            this.f = this.f3519e.length - 1;
            this.g = 0;
            this.h = 0;
        }

        private void e(int i) {
            if (d(i)) {
                this.f3515a.add(d.f3513a[i]);
                return;
            }
            int a2 = a(i - d.f3513a.length);
            if (a2 >= 0) {
                c[] cVarArr = this.f3519e;
                if (a2 < cVarArr.length) {
                    this.f3515a.add(cVarArr[a2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int f() {
            return this.f3516b.readByte() & 255;
        }

        private void f(int i) {
            a(-1, new c(c(i), b()));
        }

        private void g() {
            f b2 = b();
            d.a(b2);
            a(-1, new c(b2, b()));
        }

        private void g(int i) {
            this.f3515a.add(new c(c(i), b()));
        }

        private void h() {
            f b2 = b();
            d.a(b2);
            this.f3515a.add(new c(b2, b()));
        }

        int a(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int f = f();
                if ((f & 128) == 0) {
                    return i2 + (f << i4);
                }
                i2 += (f & 127) << i4;
                i4 += 7;
            }
        }

        public List<c> a() {
            ArrayList arrayList = new ArrayList(this.f3515a);
            this.f3515a.clear();
            return arrayList;
        }

        f b() {
            int f = f();
            boolean z = (f & 128) == 128;
            int a2 = a(f, 127);
            return z ? f.a(k.b().a(this.f3516b.g(a2))) : this.f3516b.b(a2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() {
            while (!this.f3516b.j()) {
                int readByte = this.f3516b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    e(a(readByte, 127) - 1);
                } else if (readByte == 64) {
                    g();
                } else if ((readByte & 64) == 64) {
                    f(a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    this.f3518d = a(readByte, 31);
                    int i = this.f3518d;
                    if (i < 0 || i > this.f3517c) {
                        throw new IOException("Invalid dynamic table size update " + this.f3518d);
                    }
                    d();
                } else if (readByte == 16 || readByte == 0) {
                    h();
                } else {
                    g(a(readByte, 15) - 1);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final c f3520a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f3521b;

        /* renamed from: c  reason: collision with root package name */
        private int f3522c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3523d;

        /* renamed from: e  reason: collision with root package name */
        int f3524e;
        c[] f;
        int g;
        int h;
        int i;

        b(int i, boolean z, c cVar) {
            this.f3522c = Integer.MAX_VALUE;
            this.f = new c[8];
            this.g = this.f.length - 1;
            this.h = 0;
            this.i = 0;
            this.f3524e = i;
            this.f3521b = z;
            this.f3520a = cVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(c cVar) {
            this(4096, true, cVar);
        }

        private void a() {
            int i = this.f3524e;
            int i2 = this.i;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                b();
            } else {
                b(i2 - i);
            }
        }

        private void a(c cVar) {
            int i = cVar.f3512c;
            int i2 = this.f3524e;
            if (i > i2) {
                b();
                return;
            }
            b((this.i + i) - i2);
            int i3 = this.h + 1;
            c[] cVarArr = this.f;
            if (i3 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.g = this.f.length - 1;
                this.f = cVarArr2;
            }
            int i4 = this.g;
            this.g = i4 - 1;
            this.f[i4] = cVar;
            this.h++;
            this.i += i;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f.length;
                while (true) {
                    length--;
                    if (length < this.g || i <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f;
                    i -= cVarArr[length].f3512c;
                    this.i -= cVarArr[length].f3512c;
                    this.h--;
                    i2++;
                }
                c[] cVarArr2 = this.f;
                int i3 = this.g;
                System.arraycopy(cVarArr2, i3 + 1, cVarArr2, i3 + 1 + i2, this.h);
                c[] cVarArr3 = this.f;
                int i4 = this.g;
                Arrays.fill(cVarArr3, i4 + 1, i4 + 1 + i2, (Object) null);
                this.g += i2;
            }
            return i2;
        }

        private void b() {
            Arrays.fill(this.f, (Object) null);
            this.g = this.f.length - 1;
            this.h = 0;
            this.i = 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i) {
            int min = Math.min(i, 16384);
            int i2 = this.f3524e;
            if (i2 != min) {
                if (min < i2) {
                    this.f3522c = Math.min(this.f3522c, min);
                }
                this.f3523d = true;
                this.f3524e = min;
                a();
            }
        }

        void a(int i, int i2, int i3) {
            int i4;
            c cVar;
            if (i < i2) {
                cVar = this.f3520a;
                i4 = i | i3;
            } else {
                this.f3520a.writeByte(i3 | i2);
                i4 = i - i2;
                while (i4 >= 128) {
                    this.f3520a.writeByte(128 | (i4 & 127));
                    i4 >>>= 7;
                }
                cVar = this.f3520a;
            }
            cVar.writeByte(i4);
        }

        void a(f fVar) {
            int i;
            int i2;
            if (!this.f3521b || k.b().a(fVar) >= fVar.g()) {
                i2 = fVar.g();
                i = 0;
            } else {
                c cVar = new c();
                k.b().a(fVar, cVar);
                fVar = cVar.p();
                i2 = fVar.g();
                i = 128;
            }
            a(i2, 127, i);
            this.f3520a.c(fVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<c> list) {
            int i;
            int i2;
            if (this.f3523d) {
                int i3 = this.f3522c;
                if (i3 < this.f3524e) {
                    a(i3, 31, 32);
                }
                this.f3523d = false;
                this.f3522c = Integer.MAX_VALUE;
                a(this.f3524e, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                c cVar = list.get(i4);
                f h = cVar.f3510a.h();
                f fVar = cVar.f3511b;
                Integer num = d.f3514b.get(h);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (i2 > 1 && i2 < 8) {
                        if (d.f0.c.a(d.f3513a[i2 - 1].f3511b, fVar)) {
                            i = i2;
                        } else if (d.f0.c.a(d.f3513a[i2].f3511b, fVar)) {
                            i2++;
                            i = i2;
                        }
                    }
                    i = i2;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (i2 == -1) {
                    int i5 = this.g + 1;
                    int length = this.f.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (d.f0.c.a(this.f[i5].f3510a, h)) {
                            if (d.f0.c.a(this.f[i5].f3511b, fVar)) {
                                i2 = d.f3513a.length + (i5 - this.g);
                                break;
                            } else if (i == -1) {
                                i = (i5 - this.g) + d.f3513a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i2 != -1) {
                    a(i2, 127, 128);
                } else {
                    if (i == -1) {
                        this.f3520a.writeByte(64);
                        a(h);
                    } else if (!h.b(c.f3508d) || c.i.equals(h)) {
                        a(i, 63, 64);
                    } else {
                        a(i, 15, 0);
                        a(fVar);
                    }
                    a(fVar);
                    a(cVar);
                }
            }
        }
    }

    static f a(f fVar) {
        int g = fVar.g();
        for (int i = 0; i < g; i++) {
            byte a2 = fVar.a(i);
            if (a2 >= 65 && a2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.j());
            }
        }
        return fVar;
    }

    private static Map<f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f3513a.length);
        int i = 0;
        while (true) {
            c[] cVarArr = f3513a;
            if (i >= cVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i].f3510a)) {
                linkedHashMap.put(f3513a[i].f3510a, Integer.valueOf(i));
            }
            i++;
        }
    }
}
