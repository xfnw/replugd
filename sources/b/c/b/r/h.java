package b.c.b.r;

import b.c.b.b;
import b.c.b.g;
import b.c.b.i;

/* loaded from: classes.dex */
public class h extends b {

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f1830d = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private byte[] f1831b = f1830d;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f1832c = new int[32];

    public h(g gVar) {
        super(gVar);
    }

    private static int a(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (iArr[i4] > i) {
                i = iArr[i4];
                i3 = i4;
            }
            if (iArr[i4] > i2) {
                i2 = iArr[i4];
            }
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 - i3;
            int i9 = iArr[i7] * i8 * i8;
            if (i9 > i6) {
                i5 = i7;
                i6 = i9;
            }
        }
        if (i3 > i5) {
            i3 = i5;
            i5 = i3;
        }
        if (i5 - i3 > length / 16) {
            int i10 = i5 - 1;
            int i11 = i10;
            int i12 = -1;
            while (i10 > i3) {
                int i13 = i10 - i3;
                int i14 = i13 * i13 * (i5 - i10) * (i2 - iArr[i10]);
                if (i14 > i12) {
                    i11 = i10;
                    i12 = i14;
                }
                i10--;
            }
            return i11 << 3;
        }
        throw i.a();
    }

    private void a(int i) {
        if (this.f1831b.length < i) {
            this.f1831b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.f1832c[i2] = 0;
        }
    }

    @Override // b.c.b.b
    public a a(int i, a aVar) {
        g c2 = c();
        int c3 = c2.c();
        if (aVar == null || aVar.c() < c3) {
            aVar = new a(c3);
        } else {
            aVar.a();
        }
        a(c3);
        byte[] a2 = c2.a(i, this.f1831b);
        int[] iArr = this.f1832c;
        for (int i2 = 0; i2 < c3; i2++) {
            int i3 = (a2[i2] & 255) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        int a3 = a(iArr);
        if (c3 < 3) {
            for (int i4 = 0; i4 < c3; i4++) {
                if ((a2[i4] & 255) < a3) {
                    aVar.d(i4);
                }
            }
        } else {
            int i5 = a2[0] & 255;
            int i6 = a2[1] & 255;
            int i7 = 1;
            while (i7 < c3 - 1) {
                int i8 = i7 + 1;
                int i9 = a2[i8] & 255;
                if ((((i6 << 2) - i5) - i9) / 2 < a3) {
                    aVar.d(i7);
                }
                i5 = i6;
                i7 = i8;
                i6 = i9;
            }
        }
        return aVar;
    }

    @Override // b.c.b.b
    public b a() {
        g c2 = c();
        int c3 = c2.c();
        int a2 = c2.a();
        b bVar = new b(c3, a2);
        a(c3);
        int[] iArr = this.f1832c;
        for (int i = 1; i < 5; i++) {
            byte[] a3 = c2.a((a2 * i) / 5, this.f1831b);
            int i2 = (c3 << 2) / 5;
            for (int i3 = c3 / 5; i3 < i2; i3++) {
                int i4 = (a3[i3] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int a4 = a(iArr);
        byte[] b2 = c2.b();
        for (int i5 = 0; i5 < a2; i5++) {
            int i6 = i5 * c3;
            for (int i7 = 0; i7 < c3; i7++) {
                if ((b2[i6 + i7] & 255) < a4) {
                    bVar.c(i7, i5);
                }
            }
        }
        return bVar;
    }
}
