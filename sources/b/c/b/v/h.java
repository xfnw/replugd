package b.c.b.v;

import b.c.b.e;
import b.c.b.f;
import b.c.b.i;
import b.c.b.m;
import b.c.b.o;
import b.c.b.r.a;
import java.util.Map;

/* loaded from: classes.dex */
public final class h extends k {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1911b = {6, 8, 10, 12, 14};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f1912c = {1, 1, 1, 1};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f1913d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* renamed from: e  reason: collision with root package name */
    private static final int[][] f1914e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a  reason: collision with root package name */
    private int f1915a = -1;

    private static int a(int[] iArr) {
        int length = f1914e.length;
        int i = -1;
        float f = 0.38f;
        for (int i2 = 0; i2 < length; i2++) {
            float a2 = k.a(iArr, f1914e[i2], 0.5f);
            if (a2 < f) {
                i = i2;
                f = a2;
            } else if (a2 == f) {
                i = -1;
            }
        }
        if (i >= 0) {
            return i % 10;
        }
        throw i.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(b.c.b.r.a r3, int r4) {
        /*
            r2 = this;
            int r0 = r2.f1915a
            int r0 = r0 * 10
            if (r0 >= r4) goto L_0x0007
            goto L_0x0008
        L_0x0007:
            r0 = r4
        L_0x0008:
            int r4 = r4 + (-1)
        L_0x000a:
            if (r0 <= 0) goto L_0x0019
            if (r4 < 0) goto L_0x0019
            boolean r1 = r3.a(r4)
            if (r1 != 0) goto L_0x0019
            int r0 = r0 + (-1)
            int r4 = r4 + (-1)
            goto L_0x000a
        L_0x0019:
            if (r0 != 0) goto L_0x001c
            return
        L_0x001c:
            b.c.b.i r3 = b.c.b.i.a()
            goto L_0x0022
        L_0x0021:
            throw r3
        L_0x0022:
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.v.h.a(b.c.b.r.a, int):void");
    }

    private static void a(a aVar, int i, int i2, StringBuilder sb) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i < i2) {
            k.a(aVar, i, iArr);
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                iArr2[i3] = iArr[i4];
                iArr3[i3] = iArr[i4 + 1];
            }
            sb.append((char) (a(iArr2) + 48));
            sb.append((char) (a(iArr3) + 48));
            for (int i5 = 0; i5 < 10; i5++) {
                i += iArr[i5];
            }
        }
    }

    private int[] a(a aVar) {
        int[] iArr;
        int i;
        aVar.d();
        try {
            try {
                iArr = c(aVar, c(aVar), f1913d[0]);
            } catch (i unused) {
                iArr = c(aVar, i, f1913d[1]);
            }
            a(aVar, iArr[0]);
            int i2 = iArr[0];
            iArr[0] = aVar.c() - iArr[1];
            iArr[1] = aVar.c() - i2;
            return iArr;
        } finally {
            aVar.d();
        }
    }

    private int[] b(a aVar) {
        int[] c2 = c(aVar, c(aVar), f1912c);
        this.f1915a = (c2[1] - c2[0]) / 4;
        a(aVar, c2[0]);
        return c2;
    }

    private static int c(a aVar) {
        int c2 = aVar.c();
        int b2 = aVar.b(0);
        if (b2 != c2) {
            return b2;
        }
        throw i.a();
    }

    private static int[] c(a aVar, int i, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int c2 = aVar.c();
        int i2 = i;
        boolean z = false;
        int i3 = 0;
        while (i < c2) {
            if (aVar.a(i) != z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (k.a(iArr2, iArr, 0.5f) < 0.38f) {
                    return new int[]{i2, i};
                } else {
                    i2 += iArr2[0] + iArr2[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z = !z;
            }
            i++;
        }
        throw i.a();
    }

    @Override // b.c.b.v.k
    public m a(int i, a aVar, Map<e, ?> map) {
        boolean z;
        int[] b2 = b(aVar);
        int[] a2 = a(aVar);
        StringBuilder sb = new StringBuilder(20);
        a(aVar, b2[1], a2[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f1911b;
        }
        int length = sb2.length();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length2) {
                z = false;
                break;
            }
            int i4 = iArr[i2];
            if (length == i4) {
                z = true;
                break;
            }
            if (i4 > i3) {
                i3 = i4;
            }
            i2++;
        }
        if (!z && length > i3) {
            z = true;
        }
        if (z) {
            float f = i;
            return new m(sb2, null, new o[]{new o(b2[1], f), new o(a2[0], f)}, b.c.b.a.ITF);
        }
        throw f.a();
    }
}
