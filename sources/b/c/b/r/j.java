package b.c.b.r;

import b.c.b.g;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class j extends h {

    /* renamed from: e  reason: collision with root package name */
    private b f1834e;

    public j(g gVar) {
        super(gVar);
    }

    private static int a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, b bVar) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    bVar.c(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, b bVar) {
        int i5 = i4 - 8;
        int i6 = i3 - 8;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = i7 << 3;
            int i9 = i8 > i5 ? i5 : i8;
            int a2 = a(i7, 2, i2 - 3);
            for (int i10 = 0; i10 < i; i10++) {
                int i11 = i10 << 3;
                int i12 = i11 > i6 ? i6 : i11;
                int a3 = a(i10, 2, i - 3);
                int i13 = 0;
                for (int i14 = -2; i14 <= 2; i14++) {
                    int[] iArr2 = iArr[a2 + i14];
                    i13 += iArr2[a3 - 2] + iArr2[a3 - 1] + iArr2[a3] + iArr2[a3 + 1] + iArr2[a3 + 2];
                }
                a(bArr, i12, i9, i13 / 25, i3, bVar);
            }
        }
    }

    private static int[][] a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = 8;
        int i6 = i4 - 8;
        int i7 = i3 - 8;
        int[][] iArr = (int[][]) Array.newInstance(int.class, i2, i);
        for (int i8 = 0; i8 < i2; i8++) {
            int i9 = i8 << 3;
            if (i9 > i6) {
                i9 = i6;
            }
            for (int i10 = 0; i10 < i; i10++) {
                int i11 = i10 << 3;
                if (i11 > i7) {
                    i11 = i7;
                }
                int i12 = (i9 * i3) + i11;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                int i16 = 255;
                while (i13 < i5) {
                    i14 = i14;
                    int i17 = 0;
                    while (i17 < i5) {
                        int i18 = bArr[i12 + i17] & 255;
                        i14 += i18;
                        if (i18 < i16) {
                            i16 = i18;
                        }
                        if (i18 > i15) {
                            i15 = i18;
                        }
                        i17++;
                        i5 = 8;
                    }
                    if (i15 - i16 > 24) {
                        i13++;
                        i12 += i3;
                        i5 = 8;
                        while (i13 < 8) {
                            for (int i19 = 0; i19 < 8; i19++) {
                                i14 += bArr[i12 + i19] & 255;
                            }
                            i13++;
                            i12 += i3;
                        }
                    } else {
                        i5 = 8;
                    }
                    i13++;
                    i12 += i3;
                }
                int i20 = i14 >> 6;
                if (i15 - i16 <= 24) {
                    i20 = i16 / 2;
                    if (i8 > 0 && i10 > 0) {
                        int i21 = i8 - 1;
                        int i22 = i10 - 1;
                        int i23 = ((iArr[i21][i10] + (iArr[i8][i22] * 2)) + iArr[i21][i22]) / 4;
                        if (i16 < i23) {
                            i20 = i23;
                        }
                    }
                }
                iArr[i8][i10] = i20;
            }
        }
        return iArr;
    }

    @Override // b.c.b.r.h, b.c.b.b
    public b a() {
        b bVar;
        b bVar2 = this.f1834e;
        if (bVar2 != null) {
            return bVar2;
        }
        g c2 = c();
        int c3 = c2.c();
        int a2 = c2.a();
        if (c3 < 40 || a2 < 40) {
            bVar = super.a();
        } else {
            byte[] b2 = c2.b();
            int i = c3 >> 3;
            if ((c3 & 7) != 0) {
                i++;
            }
            int i2 = a2 >> 3;
            if ((a2 & 7) != 0) {
                i2++;
            }
            int[][] a3 = a(b2, i, i2, c3, a2);
            bVar = new b(c3, a2);
            a(b2, i, i2, c3, a2, a3, bVar);
        }
        this.f1834e = bVar;
        return this.f1834e;
    }
}
