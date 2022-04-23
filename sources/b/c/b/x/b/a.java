package b.c.b.x.b;

import b.c.b.f;
import b.c.b.r.b;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f2029a;

    /* renamed from: b  reason: collision with root package name */
    private j f2030b;

    /* renamed from: c  reason: collision with root package name */
    private g f2031c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2032d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int c2 = bVar.c();
        if (c2 < 21 || (c2 & 3) != 1) {
            throw f.a();
        }
        this.f2029a = bVar;
    }

    private int a(int i, int i2, int i3) {
        return this.f2032d ? this.f2029a.b(i2, i) : this.f2029a.b(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int i = 0;
        while (i < this.f2029a.e()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f2029a.c(); i3++) {
                if (this.f2029a.b(i, i3) != this.f2029a.b(i3, i)) {
                    this.f2029a.a(i3, i);
                    this.f2029a.a(i, i3);
                }
            }
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f2030b = null;
        this.f2031c = null;
        this.f2032d = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b() {
        g c2 = c();
        j d2 = d();
        c cVar = c.values()[c2.a()];
        int c3 = this.f2029a.c();
        cVar.a(this.f2029a, c3);
        b a2 = d2.a();
        byte[] bArr = new byte[d2.d()];
        int i = c3 - 1;
        int i2 = i;
        int i3 = 0;
        boolean z = true;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            int i6 = i3;
            int i7 = 0;
            while (i7 < c3) {
                int i8 = z ? i - i7 : i7;
                int i9 = i5;
                int i10 = i4;
                int i11 = i6;
                for (int i12 = 0; i12 < 2; i12++) {
                    int i13 = i2 - i12;
                    if (!a2.b(i13, i8)) {
                        i10++;
                        int i14 = i9 << 1;
                        int i15 = this.f2029a.b(i13, i8) ? i14 | 1 : i14;
                        if (i10 == 8) {
                            i11++;
                            bArr[i11] = (byte) i15;
                            i10 = 0;
                            i9 = 0;
                        } else {
                            i9 = i15;
                        }
                    }
                }
                i7++;
                i6 = i11;
                i4 = i10;
                i5 = i9;
            }
            z = !z;
            i2 -= 2;
            i3 = i6;
            i4 = i4;
            i5 = i5;
        }
        if (i3 == d2.d()) {
            return bArr;
        }
        throw f.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g c() {
        g gVar = this.f2031c;
        if (gVar != null) {
            return gVar;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = a(i3, 8, i2);
        }
        int a2 = a(8, 7, a(8, 8, a(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            a2 = a(8, i4, a2);
        }
        int c2 = this.f2029a.c();
        int i5 = c2 - 7;
        for (int i6 = c2 - 1; i6 >= i5; i6--) {
            i = a(8, i6, i);
        }
        for (int i7 = c2 - 8; i7 < c2; i7++) {
            i = a(i7, 8, i);
        }
        this.f2031c = g.a(a2, i);
        g gVar2 = this.f2031c;
        if (gVar2 != null) {
            return gVar2;
        }
        throw f.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j d() {
        j jVar = this.f2030b;
        if (jVar != null) {
            return jVar;
        }
        int c2 = this.f2029a.c();
        int i = (c2 - 17) / 4;
        if (i <= 6) {
            return j.c(i);
        }
        int i2 = c2 - 11;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = c2 - 9; i6 >= i2; i6--) {
                i4 = a(i6, i5, i4);
            }
        }
        j a2 = j.a(i4);
        if (a2 == null || a2.c() != c2) {
            for (int i7 = 5; i7 >= 0; i7--) {
                for (int i8 = c2 - 9; i8 >= i2; i8--) {
                    i3 = a(i7, i8, i3);
                }
            }
            j a3 = j.a(i3);
            if (a3 == null || a3.c() != c2) {
                throw f.a();
            }
            this.f2030b = a3;
            return a3;
        }
        this.f2030b = a2;
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f2031c != null) {
            c.values()[this.f2031c.a()].a(this.f2029a, this.f2029a.c());
        }
    }
}
