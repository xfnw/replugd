package b.c.b.r;

import b.c.b.i;

/* loaded from: classes.dex */
public final class f extends i {
    @Override // b.c.b.r.i
    public b a(b bVar, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return a(bVar, i, i2, k.a(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    @Override // b.c.b.r.i
    public b a(b bVar, int i, int i2, k kVar) {
        if (i <= 0 || i2 <= 0) {
            throw i.a();
        }
        b bVar2 = new b(i, i2);
        float[] fArr = new float[i * 2];
        for (int i3 = 0; i3 < i2; i3++) {
            int length = fArr.length;
            float f = i3 + 0.5f;
            for (int i4 = 0; i4 < length; i4 += 2) {
                fArr[i4] = (i4 / 2) + 0.5f;
                fArr[i4 + 1] = f;
            }
            kVar.a(fArr);
            i.a(bVar, fArr);
            for (int i5 = 0; i5 < length; i5 += 2) {
                try {
                    if (bVar.b((int) fArr[i5], (int) fArr[i5 + 1])) {
                        bVar2.c(i5 / 2, i3);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw i.a();
                }
            }
        }
        return bVar2;
    }
}
