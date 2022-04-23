package b.c.b.q.d;

import b.c.b.i;
import b.c.b.o;
import b.c.b.r.b;
import b.c.b.r.n.c;
import b.c.b.r.n.d;

/* loaded from: classes.dex */
public final class a {
    private static final int[] g = {3808, 476, 2107, 1799};

    /* renamed from: a  reason: collision with root package name */
    private final b f1803a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1804b;

    /* renamed from: c  reason: collision with root package name */
    private int f1805c;

    /* renamed from: d  reason: collision with root package name */
    private int f1806d;

    /* renamed from: e  reason: collision with root package name */
    private int f1807e;
    private int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b.c.b.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0057a {

        /* renamed from: a  reason: collision with root package name */
        private final int f1808a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1809b;

        C0057a(int i, int i2) {
            this.f1808a = i;
            this.f1809b = i2;
        }

        int a() {
            return this.f1808a;
        }

        int b() {
            return this.f1809b;
        }

        o c() {
            return new o(a(), b());
        }

        public String toString() {
            return "<" + this.f1808a + ' ' + this.f1809b + '>';
        }
    }

    public a(b bVar) {
        this.f1803a = bVar;
    }

    private static float a(o oVar, o oVar2) {
        return b.c.b.r.m.a.a(oVar.a(), oVar.b(), oVar2.a(), oVar2.b());
    }

    private static float a(C0057a aVar, C0057a aVar2) {
        return b.c.b.r.m.a.a(aVar.a(), aVar.b(), aVar2.a(), aVar2.b());
    }

    private int a() {
        if (this.f1804b) {
            return (this.f1805c * 4) + 11;
        }
        int i = this.f1805c;
        return i <= 4 ? (i * 4) + 15 : (i * 4) + ((((i - 4) / 8) + 1) * 2) + 15;
    }

    private static int a(long j, boolean z) {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iArr[i4] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new c(b.c.b.r.n.a.k).a(iArr, i3);
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 = (i5 << 4) + iArr[i6];
            }
            return i5;
        } catch (d unused) {
            throw i.a();
        }
    }

    private int a(o oVar, o oVar2, int i) {
        float a2 = a(oVar, oVar2);
        float f = a2 / i;
        float a3 = oVar.a();
        float b2 = oVar.b();
        float a4 = ((oVar2.a() - oVar.a()) * f) / a2;
        float b3 = (f * (oVar2.b() - oVar.b())) / a2;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f2 = i3;
            if (this.f1803a.b(b.c.b.r.m.a.a((f2 * a4) + a3), b.c.b.r.m.a.a((f2 * b3) + b2))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    private static int a(int[] iArr, int i) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 = (i2 << 3) + ((i3 >> (i - 2)) << 1) + (i3 & 1);
        }
        int i4 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i5 = 0; i5 < 4; i5++) {
            if (Integer.bitCount(g[i5] ^ i4) <= 2) {
                return i5;
            }
        }
        throw i.a();
    }

    private C0057a a(C0057a aVar, boolean z, int i, int i2) {
        int a2 = aVar.a() + i;
        int b2 = aVar.b();
        while (true) {
            b2 += i2;
            if (!a(a2, b2) || this.f1803a.b(a2, b2) != z) {
                break;
            }
            a2 += i;
        }
        int i3 = a2 - i;
        int i4 = b2 - i2;
        while (a(i3, i4) && this.f1803a.b(i3, i4) == z) {
            i3 += i;
        }
        int i5 = i3 - i;
        while (a(i5, i4) && this.f1803a.b(i5, i4) == z) {
            i4 += i2;
        }
        return new C0057a(i5, i4 - i2);
    }

    private b a(b bVar, o oVar, o oVar2, o oVar3, o oVar4) {
        b.c.b.r.i a2 = b.c.b.r.i.a();
        int a3 = a();
        float f = a3 / 2.0f;
        int i = this.f1807e;
        float f2 = f - i;
        float f3 = f + i;
        return a2.a(bVar, a3, a3, f2, f2, f3, f2, f3, f3, f2, f3, oVar.a(), oVar.b(), oVar2.a(), oVar2.b(), oVar3.a(), oVar3.b(), oVar4.a(), oVar4.b());
    }

    private void a(o[] oVarArr) {
        int i;
        long j;
        long j2;
        if (!a(oVarArr[0]) || !a(oVarArr[1]) || !a(oVarArr[2]) || !a(oVarArr[3])) {
            throw i.a();
        }
        int i2 = this.f1807e * 2;
        int[] iArr = {a(oVarArr[0], oVarArr[1], i2), a(oVarArr[1], oVarArr[2], i2), a(oVarArr[2], oVarArr[3], i2), a(oVarArr[3], oVarArr[0], i2)};
        this.f = a(iArr, i2);
        long j3 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = iArr[(this.f + i3) % 4];
            if (this.f1804b) {
                j2 = j3 << 7;
                j = (i4 >> 1) & 127;
            } else {
                j2 = j3 << 10;
                j = ((i4 >> 2) & 992) + ((i4 >> 1) & 31);
            }
            j3 = j2 + j;
        }
        int a2 = a(j3, this.f1804b);
        if (this.f1804b) {
            this.f1805c = (a2 >> 6) + 1;
            i = a2 & 63;
        } else {
            this.f1805c = (a2 >> 11) + 1;
            i = a2 & 2047;
        }
        this.f1806d = i + 1;
    }

    private boolean a(int i, int i2) {
        return i >= 0 && i < this.f1803a.e() && i2 > 0 && i2 < this.f1803a.c();
    }

    private boolean a(o oVar) {
        return a(b.c.b.r.m.a.a(oVar.a()), b.c.b.r.m.a.a(oVar.b()));
    }

    private boolean a(C0057a aVar, C0057a aVar2, C0057a aVar3, C0057a aVar4) {
        C0057a aVar5 = new C0057a(aVar.a() - 3, aVar.b() + 3);
        C0057a aVar6 = new C0057a(aVar2.a() - 3, aVar2.b() - 3);
        C0057a aVar7 = new C0057a(aVar3.a() + 3, aVar3.b() - 3);
        C0057a aVar8 = new C0057a(aVar4.a() + 3, aVar4.b() + 3);
        int b2 = b(aVar8, aVar5);
        return b2 != 0 && b(aVar5, aVar6) == b2 && b(aVar6, aVar7) == b2 && b(aVar7, aVar8) == b2;
    }

    private o[] a(C0057a aVar) {
        this.f1807e = 1;
        C0057a aVar2 = aVar;
        C0057a aVar3 = aVar2;
        C0057a aVar4 = aVar3;
        C0057a aVar5 = aVar4;
        boolean z = true;
        while (this.f1807e < 9) {
            C0057a a2 = a(aVar2, z, 1, -1);
            C0057a a3 = a(aVar3, z, 1, 1);
            C0057a a4 = a(aVar4, z, -1, 1);
            C0057a a5 = a(aVar5, z, -1, -1);
            if (this.f1807e > 2) {
                double a6 = (a(a5, a2) * this.f1807e) / (a(aVar5, aVar2) * (this.f1807e + 2));
                if (a6 < 0.75d || a6 > 1.25d || !a(a2, a3, a4, a5)) {
                    break;
                }
            }
            z = !z;
            this.f1807e++;
            aVar5 = a5;
            aVar2 = a2;
            aVar3 = a3;
            aVar4 = a4;
        }
        int i = this.f1807e;
        if (i == 5 || i == 7) {
            this.f1804b = this.f1807e == 5;
            o[] oVarArr = {new o(aVar2.a() + 0.5f, aVar2.b() - 0.5f), new o(aVar3.a() + 0.5f, aVar3.b() + 0.5f), new o(aVar4.a() - 0.5f, aVar4.b() + 0.5f), new o(aVar5.a() - 0.5f, aVar5.b() - 0.5f)};
            int i2 = this.f1807e;
            return a(oVarArr, (i2 * 2) - 3, i2 * 2);
        }
        throw i.a();
    }

    private static o[] a(o[] oVarArr, int i, int i2) {
        float f = i2 / (i * 2.0f);
        float a2 = oVarArr[0].a() - oVarArr[2].a();
        float b2 = oVarArr[0].b() - oVarArr[2].b();
        float a3 = (oVarArr[0].a() + oVarArr[2].a()) / 2.0f;
        float b3 = (oVarArr[0].b() + oVarArr[2].b()) / 2.0f;
        float f2 = a2 * f;
        float f3 = b2 * f;
        o oVar = new o(a3 + f2, b3 + f3);
        o oVar2 = new o(a3 - f2, b3 - f3);
        float a4 = oVarArr[1].a() - oVarArr[3].a();
        float b4 = oVarArr[1].b() - oVarArr[3].b();
        float a5 = (oVarArr[1].a() + oVarArr[3].a()) / 2.0f;
        float b5 = (oVarArr[1].b() + oVarArr[3].b()) / 2.0f;
        float f4 = a4 * f;
        float f5 = f * b4;
        return new o[]{oVar, new o(a5 + f4, b5 + f5), oVar2, new o(a5 - f4, b5 - f5)};
    }

    private int b(C0057a aVar, C0057a aVar2) {
        float a2 = a(aVar, aVar2);
        float a3 = (aVar2.a() - aVar.a()) / a2;
        float b2 = (aVar2.b() - aVar.b()) / a2;
        float a4 = aVar.a();
        float b3 = aVar.b();
        boolean b4 = this.f1803a.b(aVar.a(), aVar.b());
        int ceil = (int) Math.ceil(a2);
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < ceil; i2++) {
            a4 += a3;
            b3 += b2;
            if (this.f1803a.b(b.c.b.r.m.a.a(a4), b.c.b.r.m.a.a(b3)) != b4) {
                i++;
            }
        }
        float f = i / a2;
        if (f > 0.1f && f < 0.9f) {
            return 0;
        }
        if (f <= 0.1f) {
            z = true;
        }
        return z == b4 ? 1 : -1;
    }

    private C0057a b() {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        o oVar5;
        o oVar6;
        o oVar7;
        o oVar8;
        try {
            o[] a2 = new b.c.b.r.m.b(this.f1803a).a();
            oVar3 = a2[0];
            oVar2 = a2[1];
            oVar = a2[2];
            oVar4 = a2[3];
        } catch (i unused) {
            int e2 = this.f1803a.e() / 2;
            int c2 = this.f1803a.c() / 2;
            int i = e2 + 7;
            int i2 = c2 - 7;
            oVar3 = a(new C0057a(i, i2), false, 1, -1).c();
            int i3 = c2 + 7;
            oVar2 = a(new C0057a(i, i3), false, 1, 1).c();
            int i4 = e2 - 7;
            oVar = a(new C0057a(i4, i3), false, -1, 1).c();
            oVar4 = a(new C0057a(i4, i2), false, -1, -1).c();
        }
        int a3 = b.c.b.r.m.a.a((((oVar3.a() + oVar4.a()) + oVar2.a()) + oVar.a()) / 4.0f);
        int a4 = b.c.b.r.m.a.a((((oVar3.b() + oVar4.b()) + oVar2.b()) + oVar.b()) / 4.0f);
        try {
            o[] a5 = new b.c.b.r.m.b(this.f1803a, 15, a3, a4).a();
            oVar6 = a5[0];
            oVar5 = a5[1];
            oVar7 = a5[2];
            oVar8 = a5[3];
        } catch (i unused2) {
            int i5 = a3 + 7;
            int i6 = a4 - 7;
            oVar6 = a(new C0057a(i5, i6), false, 1, -1).c();
            int i7 = a4 + 7;
            oVar5 = a(new C0057a(i5, i7), false, 1, 1).c();
            int i8 = a3 - 7;
            oVar7 = a(new C0057a(i8, i7), false, -1, 1).c();
            oVar8 = a(new C0057a(i8, i6), false, -1, -1).c();
        }
        return new C0057a(b.c.b.r.m.a.a((((oVar6.a() + oVar8.a()) + oVar5.a()) + oVar7.a()) / 4.0f), b.c.b.r.m.a.a((((oVar6.b() + oVar8.b()) + oVar5.b()) + oVar7.b()) / 4.0f));
    }

    private o[] b(o[] oVarArr) {
        return a(oVarArr, this.f1807e * 2, a());
    }

    public b.c.b.q.a a(boolean z) {
        o[] a2 = a(b());
        if (z) {
            o oVar = a2[0];
            a2[0] = a2[2];
            a2[2] = oVar;
        }
        a(a2);
        b bVar = this.f1803a;
        int i = this.f;
        return new b.c.b.q.a(a(bVar, a2[i % 4], a2[(i + 1) % 4], a2[(i + 2) % 4], a2[(i + 3) % 4]), b(a2), this.f1804b, this.f1806d, this.f1805c);
    }
}
