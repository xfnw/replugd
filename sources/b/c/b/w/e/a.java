package b.c.b.w.e;

import b.c.b.c;
import b.c.b.e;
import b.c.b.o;
import b.c.b.r.b;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2021a = {0, 4, 1, 5};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f2022b = {6, 2, 7, 3};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f2023c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f2024d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private static float a(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    public static b a(c cVar, Map<e, ?> map, boolean z) {
        b a2 = cVar.a();
        List<o[]> a3 = a(z, a2);
        if (a3.isEmpty()) {
            a2 = a2.clone();
            a2.f();
            a3 = a(z, a2);
        }
        return new b(a2, a3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r5 == false) goto L_0x0078;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r4.hasNext() == false) goto L_0x004f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        r5 = (b.c.b.o[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r5[1] == null) goto L_0x003f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        r3 = (int) java.lang.Math.max(r3, r5[1].b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r5[3] == null) goto L_0x0023;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        r3 = java.lang.Math.max(r3, (int) r5[3].b());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<b.c.b.o[]> a(boolean r8, b.c.b.r.b r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L_0x0008:
            r4 = 0
            r5 = 0
        L_0x000a:
            int r6 = r9.c()
            if (r3 >= r6) goto L_0x0078
            b.c.b.o[] r4 = a(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L_0x0052
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L_0x0052
            if (r5 == 0) goto L_0x0078
            java.util.Iterator r4 = r0.iterator()
        L_0x0023:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x004f
            java.lang.Object r5 = r4.next()
            b.c.b.o[] r5 = (b.c.b.o[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L_0x003f
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.b()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L_0x003f:
            r7 = r5[r6]
            if (r7 == 0) goto L_0x0023
            r5 = r5[r6]
            float r5 = r5.b()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L_0x0023
        L_0x004f:
            int r3 = r3 + 5
            goto L_0x0008
        L_0x0052:
            r0.add(r4)
            if (r8 == 0) goto L_0x0078
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L_0x0066
            r5 = r4[r3]
            float r5 = r5.a()
            int r5 = (int) r5
            r3 = r4[r3]
            goto L_0x0070
        L_0x0066:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.a()
            int r5 = (int) r5
            r3 = r4[r3]
        L_0x0070:
            float r3 = r3.b()
            int r3 = (int) r3
            r4 = r5
            r5 = 1
            goto L_0x000a
        L_0x0078:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.w.e.a.a(boolean, b.c.b.r.b):java.util.List");
    }

    private static void a(o[] oVarArr, o[] oVarArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            oVarArr[iArr[i]] = oVarArr2[i];
        }
    }

    private static int[] a(b bVar, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (bVar.b(i, i2) && i > 0) {
            i4++;
            if (i4 >= 3) {
                break;
            }
            i--;
        }
        int length = iArr.length;
        int i5 = i;
        boolean z2 = z;
        int i6 = 0;
        while (i < i3) {
            if (bVar.b(i, i2) != z2) {
                iArr2[i6] = iArr2[i6] + 1;
            } else {
                if (i6 != length - 1) {
                    i6++;
                } else if (a(iArr2, iArr, 0.8f) < 0.42f) {
                    return new int[]{i5, i};
                } else {
                    i5 += iArr2[0] + iArr2[1];
                    int i7 = i6 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i7);
                    iArr2[i7] = 0;
                    iArr2[i6] = 0;
                    i6--;
                }
                iArr2[i6] = 1;
                z2 = !z2;
            }
            i++;
        }
        if (i6 != length - 1 || a(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i5, i - 1};
    }

    private static o[] a(b bVar, int i, int i2) {
        int c2 = bVar.c();
        int e2 = bVar.e();
        o[] oVarArr = new o[8];
        a(oVarArr, a(bVar, c2, e2, i, i2, f2023c), f2021a);
        if (oVarArr[4] != null) {
            i2 = (int) oVarArr[4].a();
            i = (int) oVarArr[4].b();
        }
        a(oVarArr, a(bVar, c2, e2, i, i2, f2024d), f2022b);
        return oVarArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0035, code lost:
        if (r2 == null) goto L_0x0038;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
        r4 = r11;
        r1[0] = new b.c.b.o(r2[0], r4);
        r1[1] = new b.c.b.o(r2[1], r4);
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r11 <= 0) goto L_0x0039;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        r11 = r11 - 1;
        r2 = a(r17, r21, r11, r19, false, r22, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static b.c.b.o[] a(b.c.b.r.b r17, int r18, int r19, int r20, int r21, int[] r22) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.w.e.a.a(b.c.b.r.b, int, int, int, int, int[]):b.c.b.o[]");
    }
}
