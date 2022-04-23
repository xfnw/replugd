package b.c.b.v;

import b.c.b.i;
import b.c.b.r.a;

/* loaded from: classes.dex */
public final class b extends k {

    /* renamed from: a  reason: collision with root package name */
    static final int[][] f1898a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static int a(a aVar, int[] iArr, int i) {
        k.a(aVar, i, iArr);
        float f = 0.25f;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = f1898a;
            if (i3 >= iArr2.length) {
                break;
            }
            float a2 = k.a(iArr, iArr2[i3], 0.7f);
            if (a2 < f) {
                i2 = i3;
                f = a2;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw i.a();
    }

    private static int[] a(a aVar) {
        int c2 = aVar.c();
        int b2 = aVar.b(0);
        int[] iArr = new int[6];
        int i = b2;
        boolean z = false;
        int i2 = 0;
        while (b2 < c2) {
            if (aVar.a(b2) != z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                if (i2 == 5) {
                    float f = 0.25f;
                    int i3 = -1;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float a2 = k.a(iArr, f1898a[i4], 0.7f);
                        if (a2 < f) {
                            i3 = i4;
                            f = a2;
                        }
                    }
                    if (i3 >= 0 && aVar.a(Math.max(0, i - ((b2 - i) / 2)), i, false)) {
                        return new int[]{i, b2, i3};
                    }
                    i += iArr[0] + iArr[1];
                    int i5 = i2 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i2] = 0;
                    i2--;
                } else {
                    i2++;
                }
                iArr[i2] = 1;
                z = !z;
            }
            b2++;
        }
        throw i.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bb, code lost:
        if (r13.length() == 0) goto L_0x00bd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bd, code lost:
        r13.append("]C1");
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c2, code lost:
        r13.append((char) 29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d0, code lost:
        if (r5 != false) goto L_0x0117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0103, code lost:
        if (r13.length() == 0) goto L_0x00bd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0115, code lost:
        if (r5 != false) goto L_0x0117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0117, code lost:
        r5 = false;
        r11 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0121 A[PHI: r19 
      PHI: (r19v13 boolean) = (r19v18 boolean), (r19v22 boolean) binds: [B:66:0x00f9, B:44:0x00b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012b A[PHI: r6 r19 
      PHI: (r6v12 boolean) = (r6v13 boolean), (r6v2 boolean), (r6v2 boolean), (r6v2 boolean), (r6v2 boolean), (r6v2 boolean), (r6v2 boolean) binds: [B:81:0x012a, B:66:0x00f9, B:67:0x00fd, B:49:0x00c2, B:48:0x00bd, B:44:0x00b0, B:45:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r19v10 boolean) = (r19v11 boolean), (r19v18 boolean), (r19v18 boolean), (r19v20 boolean), (r19v21 boolean), (r19v22 boolean), (r19v22 boolean) binds: [B:81:0x012a, B:66:0x00f9, B:67:0x00fd, B:49:0x00c2, B:48:0x00bd, B:44:0x00b0, B:45:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b.c.b.v.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b.c.b.m a(int r25, b.c.b.r.a r26, java.util.Map<b.c.b.e, ?> r27) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.v.b.a(int, b.c.b.r.a, java.util.Map):b.c.b.m");
    }
}
