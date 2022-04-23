package b.c.b.s.b;

import b.c.b.f;
import b.c.b.r.b;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f1857a;

    /* renamed from: b  reason: collision with root package name */
    private final b f1858b;

    /* renamed from: c  reason: collision with root package name */
    private final e f1859c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int c2 = bVar.c();
        if (c2 < 8 || c2 > 144 || (c2 & 1) != 0) {
            throw f.a();
        }
        this.f1859c = b(bVar);
        this.f1857a = a(bVar);
        this.f1858b = new b(this.f1857a.e(), this.f1857a.c());
    }

    private int a(int i, int i2) {
        int i3 = i - 1;
        int i4 = (a(i3, 0, i, i2) ? 1 : 0) << 1;
        if (a(i3, 1, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(i3, 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i2 - 1;
        if (a(0, i8, i, i2)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (a(1, i8, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (a(2, i8, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return a(3, i8, i, i2) ? i11 | 1 : i11;
    }

    private b a(b bVar) {
        int e2 = this.f1859c.e();
        int d2 = this.f1859c.d();
        if (bVar.c() == e2) {
            int b2 = this.f1859c.b();
            int a2 = this.f1859c.a();
            int i = e2 / b2;
            int i2 = d2 / a2;
            b bVar2 = new b(i2 * a2, i * b2);
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i3 * b2;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = i5 * a2;
                    for (int i7 = 0; i7 < b2; i7++) {
                        int i8 = ((b2 + 2) * i3) + 1 + i7;
                        int i9 = i4 + i7;
                        for (int i10 = 0; i10 < a2; i10++) {
                            if (bVar.b(((a2 + 2) * i5) + 1 + i10, i8)) {
                                bVar2.c(i6 + i10, i9);
                            }
                        }
                    }
                }
            }
            return bVar2;
        }
        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
    }

    private boolean a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.f1858b.c(i2, i);
        return this.f1857a.b(i2, i);
    }

    private int b(int i, int i2) {
        int i3 = (a(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (a(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(0, i2 - 4, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i2 - 3, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i2 - 1;
        if (a(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        return a(1, i9, i, i2) ? i10 | 1 : i10;
    }

    private int b(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (a(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        if (a(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (a(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (a(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return a(i, i2, i3, i4) ? i15 | 1 : i15;
    }

    private static e b(b bVar) {
        return e.a(bVar.c(), bVar.e());
    }

    private int c(int i, int i2) {
        int i3 = i - 1;
        int i4 = (a(i3, 0, i, i2) ? 1 : 0) << 1;
        int i5 = i2 - 1;
        if (a(i3, i5, i, i2)) {
            i4 |= 1;
        }
        int i6 = i4 << 1;
        int i7 = i2 - 3;
        if (a(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        int i9 = i2 - 2;
        if (a(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (a(0, i5, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (a(1, i7, i, i2)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(1, i9, i, i2)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        return a(1, i5, i, i2) ? i13 | 1 : i13;
    }

    private int d(int i, int i2) {
        int i3 = (a(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (a(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        int i7 = i2 - 1;
        if (a(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        if (a(1, i7, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (a(2, i7, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        return a(3, i7, i, i2) ? i10 | 1 : i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a() {
        return this.f1859c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b() {
        byte[] bArr = new byte[this.f1859c.f()];
        int c2 = this.f1857a.c();
        int e2 = this.f1857a.e();
        int i = 4;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (i == c2 && i2 == 0 && !z) {
                i3++;
                bArr[i3] = (byte) a(c2, e2);
                i -= 2;
                i2 += 2;
                z = true;
            } else {
                int i4 = c2 - 2;
                if (i == i4 && i2 == 0 && (e2 & 3) != 0 && !z2) {
                    i3++;
                    bArr[i3] = (byte) b(c2, e2);
                    i -= 2;
                    i2 += 2;
                    z2 = true;
                } else if (i == c2 + 4 && i2 == 2 && (e2 & 7) == 0 && !z3) {
                    i3++;
                    bArr[i3] = (byte) c(c2, e2);
                    i -= 2;
                    i2 += 2;
                    z3 = true;
                } else if (i == i4 && i2 == 0 && (e2 & 7) == 4 && !z4) {
                    i3++;
                    bArr[i3] = (byte) d(c2, e2);
                    i -= 2;
                    i2 += 2;
                    z4 = true;
                } else {
                    do {
                        if (i < c2 && i2 >= 0 && !this.f1858b.b(i2, i)) {
                            i3++;
                            bArr[i3] = (byte) b(i, i2, c2, e2);
                        }
                        i -= 2;
                        i2 += 2;
                        if (i < 0) {
                            break;
                        }
                    } while (i2 < e2);
                    int i5 = i + 1;
                    int i6 = i2 + 3;
                    do {
                        if (i5 >= 0 && i6 < e2 && !this.f1858b.b(i6, i5)) {
                            i3++;
                            bArr[i3] = (byte) b(i5, i6, c2, e2);
                        }
                        i5 += 2;
                        i6 -= 2;
                        if (i5 >= c2) {
                            break;
                        }
                    } while (i6 >= 0);
                    i = i5 + 3;
                    i2 = i6 + 1;
                }
            }
            if (i >= c2 && i2 >= e2) {
                break;
            }
        }
        if (i3 == this.f1859c.f()) {
            return bArr;
        }
        throw f.a();
    }
}
