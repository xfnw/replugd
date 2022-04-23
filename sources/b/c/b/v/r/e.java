package b.c.b.v.r;

import b.c.b.i;
import b.c.b.m;
import b.c.b.o;
import b.c.b.p;
import b.c.b.r.a;
import b.c.b.v.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class e extends a {
    private static final int[] i = {1, 10, 34, 70, 126};
    private static final int[] j = {4, 20, 48, 81};
    private static final int[] k = {0, 161, 961, 2015, 2715};
    private static final int[] l = {0, 336, 1036, 1516};
    private static final int[] m = {8, 6, 4, 3, 1};
    private static final int[] n = {2, 4, 6, 8};
    private static final int[][] o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List<d> g = new ArrayList();
    private final List<d> h = new ArrayList();

    private b a(a aVar, c cVar, boolean z) {
        int[] b2 = b();
        for (int i2 = 0; i2 < b2.length; i2++) {
            b2[i2] = 0;
        }
        int[] b3 = cVar.b();
        if (z) {
            k.b(aVar, b3[0], b2);
        } else {
            k.a(aVar, b3[1] + 1, b2);
            int i3 = 0;
            for (int length = b2.length - 1; i3 < length; length--) {
                int i4 = b2[i3];
                b2[i3] = b2[length];
                b2[length] = i4;
                i3++;
            }
        }
        int i5 = z ? 16 : 15;
        float a2 = b.c.b.r.m.a.a(b2) / i5;
        int[] f = f();
        int[] d2 = d();
        float[] g = g();
        float[] e2 = e();
        for (int i6 = 0; i6 < b2.length; i6++) {
            float f2 = b2[i6] / a2;
            int i7 = (int) (0.5f + f2);
            if (i7 <= 0) {
                i7 = 1;
            } else if (i7 > 8) {
                i7 = 8;
            }
            int i8 = i6 / 2;
            if ((i6 & 1) == 0) {
                f[i8] = i7;
                g[i8] = f2 - i7;
            } else {
                d2[i8] = i7;
                e2[i8] = f2 - i7;
            }
        }
        a(z, i5);
        int i9 = 0;
        int i10 = 0;
        for (int length2 = f.length - 1; length2 >= 0; length2--) {
            i9 = (i9 * 9) + f[length2];
            i10 += f[length2];
        }
        int i11 = 0;
        int i12 = 0;
        for (int length3 = d2.length - 1; length3 >= 0; length3--) {
            i11 = (i11 * 9) + d2[length3];
            i12 += d2[length3];
        }
        int i13 = i9 + (i11 * 3);
        if (z) {
            if ((i10 & 1) != 0 || i10 > 12 || i10 < 4) {
                throw i.a();
            }
            int i14 = (12 - i10) / 2;
            int i15 = m[i14];
            return new b((f.a(f, i15, false) * i[i14]) + f.a(d2, 9 - i15, true) + k[i14], i13);
        } else if ((i12 & 1) != 0 || i12 > 10 || i12 < 4) {
            throw i.a();
        } else {
            int i16 = (10 - i12) / 2;
            int i17 = n[i16];
            return new b((f.a(d2, 9 - i17, false) * j[i16]) + f.a(f, i17, true) + l[i16], i13);
        }
    }

    private c a(a aVar, int i2, boolean z, int[] iArr) {
        int i3;
        int i4;
        boolean a2 = aVar.a(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && a2 != aVar.a(i5)) {
            i5--;
        }
        int i6 = i5 + 1;
        int[] c2 = c();
        System.arraycopy(c2, 0, c2, 1, c2.length - 1);
        c2[0] = iArr[0] - i6;
        int a3 = a.a(c2, o);
        int i7 = iArr[1];
        if (z) {
            i4 = (aVar.c() - 1) - i6;
            i3 = (aVar.c() - 1) - i7;
        } else {
            i3 = i7;
            i4 = i6;
        }
        return new c(a3, new int[]{i6, iArr[1]}, i4, i3, i2);
    }

    private d a(a aVar, boolean z, int i2, Map<b.c.b.e, ?> map) {
        try {
            int[] a2 = a(aVar, z);
            c a3 = a(aVar, i2, z, a2);
            p pVar = map == null ? null : (p) map.get(b.c.b.e.NEED_RESULT_POINT_CALLBACK);
            if (pVar != null) {
                float f = (a2[0] + a2[1]) / 2.0f;
                if (z) {
                    f = (aVar.c() - 1) - f;
                }
                pVar.a(new o(f, i2));
            }
            b a4 = a(aVar, a3, true);
            b a5 = a(aVar, a3, false);
            return new d((a4.b() * 1597) + a5.b(), a4.a() + (a5.a() * 4), a3);
        } catch (i unused) {
            return null;
        }
    }

    private static void a(Collection<d> collection, d dVar) {
        if (dVar != null) {
            boolean z = false;
            Iterator<d> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (next.b() == dVar.b()) {
                    next.e();
                    z = true;
                    break;
                }
            }
            if (!z) {
                collection.add(dVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        if (r1 < 4) goto L_0x0043;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
        if (r1 < 4) goto L_0x0043;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0046, code lost:
        r7 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(boolean r10, int r11) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.v.r.e.a(boolean, int):void");
    }

    private static boolean a(d dVar, d dVar2) {
        int a2 = (dVar.a() + (dVar2.a() * 16)) % 79;
        int c2 = (dVar.d().c() * 9) + dVar2.d().c();
        if (c2 > 72) {
            c2--;
        }
        if (c2 > 8) {
            c2--;
        }
        return a2 == c2;
    }

    private int[] a(a aVar, boolean z) {
        int[] c2 = c();
        c2[0] = 0;
        c2[1] = 0;
        c2[2] = 0;
        c2[3] = 0;
        int c3 = aVar.c();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < c3) {
            z2 = !aVar.a(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < c3) {
            if (aVar.a(i2) != z2) {
                c2[i4] = c2[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else if (a.a(c2)) {
                    return new int[]{i3, i2};
                } else {
                    i3 += c2[0] + c2[1];
                    c2[0] = c2[2];
                    c2[1] = c2[3];
                    c2[2] = 0;
                    c2[3] = 0;
                    i4--;
                }
                c2[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw i.a();
    }

    private static m b(d dVar, d dVar2) {
        String valueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int charAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                charAt *= 3;
            }
            i2 += charAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        o[] a2 = dVar.d().a();
        o[] a3 = dVar2.d().a();
        return new m(sb.toString(), null, new o[]{a2[0], a2[1], a3[0], a3[1]}, b.c.b.a.RSS_14);
    }

    @Override // b.c.b.v.k
    public m a(int i2, a aVar, Map<b.c.b.e, ?> map) {
        a(this.g, a(aVar, false, i2, map));
        aVar.d();
        a(this.h, a(aVar, true, i2, map));
        aVar.d();
        for (d dVar : this.g) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.h) {
                    if (dVar2.c() > 1 && a(dVar, dVar2)) {
                        return b(dVar, dVar2);
                    }
                }
                continue;
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
