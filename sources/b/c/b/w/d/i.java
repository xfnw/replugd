package b.c.b.w.d;

import b.c.b.w.a;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final float[][] f2011a = (float[][]) Array.newInstance(float.class, a.f1977b.length, 8);

    static {
        int i;
        int i2 = 0;
        while (true) {
            int[] iArr = a.f1977b;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                int i4 = i3 & 1;
                int i5 = i3;
                int i6 = 0;
                while (i6 < 8) {
                    float f = 0.0f;
                    while (true) {
                        i = i5 & 1;
                        if (i == i4) {
                            f += 1.0f;
                            i5 >>= 1;
                        }
                    }
                    f2011a[i2][(8 - i6) - 1] = f / 17.0f;
                    i6++;
                    i4 = i;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private static int a(int[] iArr) {
        long j = 0;
        int i = 0;
        while (i < iArr.length) {
            long j2 = j;
            for (int i2 = 0; i2 < iArr[i]; i2++) {
                int i3 = 1;
                long j3 = j2 << 1;
                if (i % 2 != 0) {
                    i3 = 0;
                }
                j2 = j3 | i3;
            }
            i++;
            j = j2;
        }
        return (int) j;
    }

    private static int b(int[] iArr) {
        int a2 = b.c.b.r.m.a.a(iArr);
        float[] fArr = new float[8];
        if (a2 > 1) {
            for (int i = 0; i < 8; i++) {
                fArr[i] = iArr[i] / a2;
            }
        }
        int i2 = -1;
        int i3 = 0;
        float f = Float.MAX_VALUE;
        while (true) {
            float[][] fArr2 = f2011a;
            if (i3 >= fArr2.length) {
                return i2;
            }
            float[] fArr3 = fArr2[i3];
            float f2 = 0.0f;
            for (int i4 = 0; i4 < 8; i4++) {
                float f3 = fArr3[i4] - fArr[i4];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                i2 = a.f1977b[i3];
                f = f2;
            }
            i3++;
        }
    }

    private static int c(int[] iArr) {
        int a2 = a(iArr);
        if (a.a(a2) == -1) {
            return -1;
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int[] iArr) {
        int c2 = c(e(iArr));
        return c2 != -1 ? c2 : b(iArr);
    }

    private static int[] e(int[] iArr) {
        float a2 = b.c.b.r.m.a.a(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (iArr[i2] + i <= (a2 / 34.0f) + ((i3 * a2) / 17.0f)) {
                i += iArr[i2];
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }
}
