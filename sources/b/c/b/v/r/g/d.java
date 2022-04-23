package b.c.b.v.r.g;

import b.c.b.e;
import b.c.b.i;
import b.c.b.m;
import b.c.b.o;
import b.c.b.v.k;
import b.c.b.v.r.a;
import b.c.b.v.r.b;
import b.c.b.v.r.c;
import b.c.b.v.r.f;
import b.c.b.v.r.g.e.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class d extends a {
    private static final int[] k = {7, 5, 4, 3, 1};
    private static final int[] l = {4, 20, 52, 104, 204};
    private static final int[] m = {0, 348, 1388, 2948, 3988};
    private static final int[][] n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private static final int[][] p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private final List<b> g = new ArrayList(11);
    private final List<c> h = new ArrayList();
    private final int[] i = new int[2];
    private boolean j;

    private static int a(b.c.b.r.a aVar, int i) {
        return aVar.a(i) ? aVar.b(aVar.c(i)) : aVar.c(aVar.b(i));
    }

    static m a(List<b> list) {
        String c2 = j.a(a.a(list)).c();
        o[] a2 = list.get(0).a().a();
        o[] a3 = list.get(list.size() - 1).a().a();
        return new m(c2, null, new o[]{a2[0], a2[1], a3[0], a3[1]}, b.c.b.a.RSS_EXPANDED);
    }

    private c a(b.c.b.r.a aVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.i[0] - 1;
            while (i5 >= 0 && !aVar.a(i5)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] iArr = this.i;
            i2 = iArr[0] - i6;
            i3 = iArr[1];
            i4 = i6;
        } else {
            int[] iArr2 = this.i;
            i4 = iArr2[0];
            int c2 = aVar.c(iArr2[1] + 1);
            i2 = c2 - this.i[1];
            i3 = c2;
        }
        int[] c3 = c();
        System.arraycopy(c3, 0, c3, 1, c3.length - 1);
        c3[0] = i2;
        try {
            return new c(a.a(c3, n), new int[]{i4, i3}, i4, i3, i);
        } catch (i unused) {
            return null;
        }
    }

    private List<b> a(List<c> list, int i) {
        while (i < this.h.size()) {
            c cVar = this.h.get(i);
            this.g.clear();
            for (c cVar2 : list) {
                this.g.addAll(cVar2.a());
            }
            this.g.addAll(cVar.a());
            if (b(this.g)) {
                if (h()) {
                    return this.g;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(cVar);
                try {
                    return a(arrayList, i + 1);
                } catch (i unused) {
                    continue;
                }
            }
            i++;
        }
        throw i.a();
    }

    private List<b> a(boolean z) {
        List<b> list = null;
        if (this.h.size() > 25) {
            this.h.clear();
            return null;
        }
        this.g.clear();
        if (z) {
            Collections.reverse(this.h);
        }
        try {
            list = a(new ArrayList(), 0);
        } catch (i unused) {
        }
        if (z) {
            Collections.reverse(this.h);
        }
        return list;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r11) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.v.r.g.d.a(int):void");
    }

    private void a(int i, boolean z) {
        boolean z2 = false;
        int i2 = 0;
        boolean z3 = false;
        while (true) {
            if (i2 >= this.h.size()) {
                break;
            }
            c cVar = this.h.get(i2);
            if (cVar.b() > i) {
                z2 = cVar.a(this.g);
                break;
            } else {
                z3 = cVar.a(this.g);
                i2++;
            }
        }
        if (!z2 && !z3 && !a((Iterable<b>) this.g, (Iterable<c>) this.h)) {
            this.h.add(i2, new c(this.g, i, z));
            a(this.g, this.h);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.util.List<b.c.b.v.r.g.b> r6, java.util.List<b.c.b.v.r.g.c> r7) {
        /*
            java.util.Iterator r7 = r7.iterator()
        L_0x0004:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0056
            java.lang.Object r0 = r7.next()
            b.c.b.v.r.g.c r0 = (b.c.b.v.r.g.c) r0
            java.util.List r1 = r0.a()
            int r1 = r1.size()
            int r2 = r6.size()
            if (r1 == r2) goto L_0x0004
            java.util.List r0 = r0.a()
            java.util.Iterator r0 = r0.iterator()
        L_0x0026:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x004f
            java.lang.Object r1 = r0.next()
            b.c.b.v.r.g.b r1 = (b.c.b.v.r.g.b) r1
            java.util.Iterator r4 = r6.iterator()
        L_0x0038:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x004b
            java.lang.Object r5 = r4.next()
            b.c.b.v.r.g.b r5 = (b.c.b.v.r.g.b) r5
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0038
            goto L_0x004c
        L_0x004b:
            r3 = 0
        L_0x004c:
            if (r3 != 0) goto L_0x0026
            goto L_0x0050
        L_0x004f:
            r2 = 1
        L_0x0050:
            if (r2 == 0) goto L_0x0004
            r7.remove()
            goto L_0x0004
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.v.r.g.d.a(java.util.List, java.util.List):void");
    }

    private static boolean a(c cVar, boolean z, boolean z2) {
        return cVar.c() != 0 || !z || !z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.Iterable<b.c.b.v.r.g.b> r7, java.lang.Iterable<b.c.b.v.r.g.c> r8) {
        /*
            java.util.Iterator r8 = r8.iterator()
        L_0x0004:
            boolean r0 = r8.hasNext()
            r1 = 0
            if (r0 == 0) goto L_0x0046
            java.lang.Object r0 = r8.next()
            b.c.b.v.r.g.c r0 = (b.c.b.v.r.g.c) r0
            java.util.Iterator r2 = r7.iterator()
        L_0x0015:
            boolean r3 = r2.hasNext()
            r4 = 1
            if (r3 == 0) goto L_0x0042
            java.lang.Object r3 = r2.next()
            b.c.b.v.r.g.b r3 = (b.c.b.v.r.g.b) r3
            java.util.List r5 = r0.a()
            java.util.Iterator r5 = r5.iterator()
        L_0x002a:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x003e
            java.lang.Object r6 = r5.next()
            b.c.b.v.r.g.b r6 = (b.c.b.v.r.g.b) r6
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L_0x002a
            r3 = 1
            goto L_0x003f
        L_0x003e:
            r3 = 0
        L_0x003f:
            if (r3 != 0) goto L_0x0015
            goto L_0x0043
        L_0x0042:
            r1 = 1
        L_0x0043:
            if (r1 == 0) goto L_0x0004
            return r4
        L_0x0046:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.v.r.g.d.a(java.lang.Iterable, java.lang.Iterable):boolean");
    }

    private void b(b.c.b.r.a aVar, List<b> list, int i) {
        int[] c2 = c();
        c2[0] = 0;
        c2[1] = 0;
        c2[2] = 0;
        c2[3] = 0;
        int c3 = aVar.c();
        if (i < 0) {
            i = list.isEmpty() ? 0 : list.get(list.size() - 1).a().b()[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.j) {
            z = !z;
        }
        boolean z2 = false;
        while (i < c3) {
            z2 = !aVar.a(i);
            if (!z2) {
                break;
            }
            i++;
        }
        int i2 = i;
        int i3 = 0;
        while (i < c3) {
            if (aVar.a(i) != z2) {
                c2[i3] = c2[i3] + 1;
            } else {
                if (i3 == 3) {
                    if (z) {
                        b(c2);
                    }
                    if (a.a(c2)) {
                        int[] iArr = this.i;
                        iArr[0] = i2;
                        iArr[1] = i;
                        return;
                    }
                    if (z) {
                        b(c2);
                    }
                    i2 += c2[0] + c2[1];
                    c2[0] = c2[2];
                    c2[1] = c2[3];
                    c2[2] = 0;
                    c2[3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                c2[i3] = 1;
                z2 = !z2;
            }
            i++;
        }
        throw i.a();
    }

    private static void b(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    private static boolean b(List<b> list) {
        int[][] iArr;
        boolean z;
        for (int[] iArr2 : p) {
            if (list.size() <= iArr2.length) {
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        z = true;
                        break;
                    } else if (list.get(i).a().c() != iArr2[i]) {
                        z = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean h() {
        b bVar = this.g.get(0);
        b b2 = bVar.b();
        b c2 = bVar.c();
        if (c2 == null) {
            return false;
        }
        int a2 = c2.a();
        int i = 2;
        for (int i2 = 1; i2 < this.g.size(); i2++) {
            b bVar2 = this.g.get(i2);
            a2 += bVar2.b().a();
            i++;
            b c3 = bVar2.c();
            if (c3 != null) {
                a2 += c3.a();
                i++;
            }
        }
        return ((i + (-4)) * 211) + (a2 % 211) == b2.b();
    }

    @Override // b.c.b.v.k
    public m a(int i, b.c.b.r.a aVar, Map<e, ?> map) {
        this.g.clear();
        this.j = false;
        try {
            return a(a(i, aVar));
        } catch (i unused) {
            this.g.clear();
            this.j = true;
            return a(a(i, aVar));
        }
    }

    b a(b.c.b.r.a aVar, c cVar, boolean z, boolean z2) {
        int[] b2 = b();
        for (int i = 0; i < b2.length; i++) {
            b2[i] = 0;
        }
        int[] b3 = cVar.b();
        if (z2) {
            k.b(aVar, b3[0], b2);
        } else {
            k.a(aVar, b3[1], b2);
            int i2 = 0;
            for (int length = b2.length - 1; i2 < length; length--) {
                int i3 = b2[i2];
                b2[i2] = b2[length];
                b2[length] = i3;
                i2++;
            }
        }
        float a2 = b.c.b.r.m.a.a(b2) / 17.0f;
        float f = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(a2 - f) / f <= 0.3f) {
            int[] f2 = f();
            int[] d2 = d();
            float[] g = g();
            float[] e2 = e();
            for (int i4 = 0; i4 < b2.length; i4++) {
                float f3 = (b2[i4] * 1.0f) / a2;
                int i5 = (int) (0.5f + f3);
                int i6 = 8;
                if (i5 <= 0) {
                    if (f3 >= 0.3f) {
                        i6 = 1;
                    } else {
                        throw i.a();
                    }
                } else if (i5 <= 8) {
                    i6 = i5;
                } else if (f3 > 8.7f) {
                    throw i.a();
                }
                int i7 = i4 / 2;
                if ((i4 & 1) == 0) {
                    f2[i7] = i6;
                    g[i7] = f3 - i6;
                } else {
                    d2[i7] = i6;
                    e2[i7] = f3 - i6;
                }
            }
            a(17);
            int c2 = (((cVar.c() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
            int i8 = 0;
            int i9 = 0;
            for (int length2 = f2.length - 1; length2 >= 0; length2--) {
                if (a(cVar, z, z2)) {
                    i8 += f2[length2] * o[c2][length2 * 2];
                }
                i9 += f2[length2];
            }
            int i10 = 0;
            for (int length3 = d2.length - 1; length3 >= 0; length3--) {
                if (a(cVar, z, z2)) {
                    i10 += d2[length3] * o[c2][(length3 * 2) + 1];
                }
            }
            int i11 = i8 + i10;
            if ((i9 & 1) != 0 || i9 > 13 || i9 < 4) {
                throw i.a();
            }
            int i12 = (13 - i9) / 2;
            int i13 = k[i12];
            return new b((f.a(f2, i13, true) * l[i12]) + f.a(d2, 9 - i13, false) + m[i12], i11);
        }
        throw i.a();
    }

    b a(b.c.b.r.a aVar, List<b> list, int i) {
        c a2;
        b bVar;
        boolean z = list.size() % 2 == 0;
        if (this.j) {
            z = !z;
        }
        int i2 = -1;
        boolean z2 = true;
        do {
            b(aVar, list, i2);
            a2 = a(aVar, i, z);
            if (a2 == null) {
                i2 = a(aVar, this.i[0]);
                continue;
            } else {
                z2 = false;
                continue;
            }
        } while (z2);
        b a3 = a(aVar, a2, z, true);
        if (list.isEmpty() || !list.get(list.size() - 1).d()) {
            try {
                bVar = a(aVar, a2, z, false);
            } catch (i unused) {
                bVar = null;
            }
            return new b(a3, bVar, a2, true);
        }
        throw i.a();
    }

    List<b> a(int i, b.c.b.r.a aVar) {
        boolean z = false;
        while (!z) {
            try {
                this.g.add(a(aVar, this.g, i));
            } catch (i e2) {
                if (!this.g.isEmpty()) {
                    z = true;
                } else {
                    throw e2;
                }
            }
        }
        if (h()) {
            return this.g;
        }
        boolean z2 = !this.h.isEmpty();
        a(i, false);
        if (z2) {
            List<b> a2 = a(false);
            if (a2 != null) {
                return a2;
            }
            List<b> a3 = a(true);
            if (a3 != null) {
                return a3;
            }
        }
        throw i.a();
    }

    @Override // b.c.b.v.k, b.c.b.k
    public void a() {
        this.g.clear();
        this.h.clear();
    }
}
