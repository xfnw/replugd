package b.c.b.w.d;

import b.c.b.d;
import b.c.b.f;
import b.c.b.i;
import b.c.b.o;
import b.c.b.r.b;
import b.c.b.r.e;
import b.c.b.w.d.k.a;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final a f2012a = new a();

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
        r0 = -r0;
        r2 = !r2;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0023, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0023, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0023, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(b.c.b.r.b r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L_0x0004
            r0 = -1
            goto L_0x0005
        L_0x0004:
            r0 = 1
        L_0x0005:
            r1 = 0
            r2 = r8
            r8 = r9
        L_0x0008:
            r3 = 2
            if (r1 >= r3) goto L_0x0029
        L_0x000b:
            if (r2 == 0) goto L_0x0010
            if (r8 < r6) goto L_0x0023
            goto L_0x0012
        L_0x0010:
            if (r8 >= r7) goto L_0x0023
        L_0x0012:
            boolean r4 = r5.b(r8, r10)
            if (r2 != r4) goto L_0x0023
            int r4 = r9 - r8
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L_0x0021
            return r9
        L_0x0021:
            int r8 = r8 + r0
            goto L_0x000b
        L_0x0023:
            int r0 = -r0
            r2 = r2 ^ 1
            int r1 = r1 + 1
            goto L_0x0008
        L_0x0029:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.w.d.j.a(b.c.b.r.b, int, int, boolean, int, int):int");
    }

    private static int a(f fVar, int i, int i2, boolean z) {
        d[] b2;
        int i3 = z ? 1 : -1;
        d dVar = null;
        int i4 = i - i3;
        if (a(fVar, i4)) {
            dVar = fVar.a(i4).a(i2);
        }
        if (dVar != null) {
            return z ? dVar.b() : dVar.d();
        }
        d b3 = fVar.a(i).b(i2);
        if (b3 != null) {
            return z ? b3.d() : b3.b();
        }
        if (a(fVar, i4)) {
            b3 = fVar.a(i4).b(i2);
        }
        if (b3 != null) {
            return z ? b3.b() : b3.d();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (a(fVar, i)) {
                for (d dVar2 : fVar.a(i).b()) {
                    if (dVar2 != null) {
                        return (z ? dVar2.b() : dVar2.d()) + (i3 * i5 * (dVar2.b() - dVar2.d()));
                    }
                }
                i5++;
            } else {
                c d2 = fVar.d();
                return z ? d2.e() : d2.c();
            }
        }
    }

    private static int a(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static int a(int[] iArr, int[] iArr2, int i) {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return f2012a.a(iArr, i, iArr2);
        }
        throw d.a();
    }

    private static e a(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) {
        int[] iArr5 = new int[iArr3.length];
        int i2 = 100;
        while (true) {
            i2--;
            if (i2 > 0) {
                for (int i3 = 0; i3 < iArr5.length; i3++) {
                    iArr[iArr3[i3]] = iArr4[i3][iArr5[i3]];
                }
                try {
                    return a(iArr, i, iArr2);
                } catch (d unused) {
                    if (iArr5.length != 0) {
                        int i4 = 0;
                        while (true) {
                            if (i4 >= iArr5.length) {
                                break;
                            } else if (iArr5[i4] < iArr4[i4].length - 1) {
                                iArr5[i4] = iArr5[i4] + 1;
                                break;
                            } else {
                                iArr5[i4] = 0;
                                if (i4 != iArr5.length - 1) {
                                    i4++;
                                } else {
                                    throw d.a();
                                }
                            }
                        }
                    } else {
                        throw d.a();
                    }
                }
            } else {
                throw d.a();
            }
        }
    }

    public static e a(b bVar, o oVar, o oVar2, o oVar3, o oVar4, int i, int i2) {
        int i3;
        c cVar = new c(bVar, oVar, oVar2, oVar3, oVar4);
        h hVar = null;
        f fVar = null;
        h hVar2 = null;
        int i4 = 0;
        while (i4 < 2) {
            if (oVar != null) {
                hVar = a(bVar, cVar, oVar, true, i, i2);
            }
            if (oVar3 != null) {
                hVar2 = a(bVar, cVar, oVar3, false, i, i2);
            }
            fVar = b(hVar, hVar2);
            if (fVar == null) {
                throw i.a();
            } else if (i4 != 0 || fVar.d() == null || (fVar.d().f() >= cVar.f() && fVar.d().d() <= cVar.d())) {
                fVar.a(cVar);
                break;
            } else {
                cVar = fVar.d();
                i4++;
                hVar = hVar;
            }
        }
        hVar = hVar;
        int a2 = fVar.a() + 1;
        fVar.a(0, hVar);
        fVar.a(a2, hVar2);
        boolean z = hVar != null;
        int i5 = i;
        int i6 = i2;
        for (int i7 = 1; i7 <= a2; i7++) {
            int i8 = z ? i7 : a2 - i7;
            if (fVar.a(i8) == null) {
                g hVar3 = (i8 == 0 || i8 == a2) ? new h(cVar, i8 == 0) : new g(cVar);
                fVar.a(i8, hVar3);
                int f = cVar.f();
                int i9 = -1;
                int i10 = i6;
                int i11 = -1;
                int i12 = i5;
                while (f <= cVar.d()) {
                    int a3 = a(fVar, i8, f, z);
                    if (a3 >= 0 && a3 <= cVar.c()) {
                        i3 = a3;
                    } else if (i11 != i9) {
                        i3 = i11;
                    } else {
                        i11 = i11;
                        i10 = i10;
                        f++;
                        i9 = -1;
                    }
                    i11 = i11;
                    d a4 = a(bVar, cVar.e(), cVar.c(), z, i3, f, i12, i10);
                    if (a4 != null) {
                        hVar3.a(f, a4);
                        i12 = Math.min(i12, a4.f());
                        i10 = Math.max(i10, a4.f());
                        i11 = i3;
                        f++;
                        i9 = -1;
                    } else {
                        i10 = i10;
                        f++;
                        i9 = -1;
                    }
                }
                i5 = i12;
                i6 = i10;
            }
        }
        return b(fVar);
    }

    private static e a(int[] iArr, int i, int[] iArr2) {
        if (iArr.length != 0) {
            int i2 = 1 << (i + 1);
            int a2 = a(iArr, iArr2, i2);
            a(iArr, i2);
            e a3 = e.a(iArr, String.valueOf(i));
            a3.b(Integer.valueOf(a2));
            a3.a(Integer.valueOf(iArr2.length));
            return a3;
        }
        throw f.a();
    }

    private static a a(h hVar, h hVar2) {
        a c2;
        a c3;
        if (hVar == null || (c2 = hVar.c()) == null) {
            if (hVar2 == null) {
                return null;
            }
            return hVar2.c();
        } else if (hVar2 == null || (c3 = hVar2.c()) == null || c2.a() == c3.a() || c2.b() == c3.b() || c2.c() == c3.c()) {
            return c2;
        } else {
            return null;
        }
    }

    private static c a(h hVar) {
        int[] d2;
        if (hVar == null || (d2 = hVar.d()) == null) {
            return null;
        }
        int b2 = b(d2);
        int i = 0;
        int i2 = 0;
        for (int i3 : d2) {
            i2 += b2 - i3;
            if (i3 > 0) {
                break;
            }
        }
        d[] b3 = hVar.b();
        for (int i4 = 0; i2 > 0 && b3[i4] == null; i4++) {
            i2--;
        }
        for (int length = d2.length - 1; length >= 0; length--) {
            i += b2 - d2[length];
            if (d2[length] > 0) {
                break;
            }
        }
        for (int length2 = b3.length - 1; i > 0 && b3[length2] == null; length2--) {
            i--;
        }
        return hVar.a().a(i2, i, hVar.e());
    }

    private static d a(b bVar, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int d2;
        int a2;
        int a3 = a(bVar, i, i2, z, i3, i4);
        int[] b2 = b(bVar, i, i2, z, a3, i4);
        if (b2 == null) {
            return null;
        }
        int a4 = b.c.b.r.m.a.a(b2);
        if (z) {
            a3 += a4;
            i7 = a3;
        } else {
            for (int i8 = 0; i8 < b2.length / 2; i8++) {
                int i9 = b2[i8];
                b2[i8] = b2[(b2.length - 1) - i8];
                b2[(b2.length - 1) - i8] = i9;
            }
            i7 = a3 - a4;
        }
        if (a(a4, i5, i6) && (a2 = b.c.b.w.a.a((d2 = i.d(b2)))) != -1) {
            return new d(i7, a3, b(d2), a2);
        }
        return null;
    }

    private static h a(b bVar, c cVar, o oVar, boolean z, int i, int i2) {
        h hVar = new h(cVar, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int a2 = (int) oVar.a();
            for (int b2 = (int) oVar.b(); b2 <= cVar.d() && b2 >= cVar.f(); b2 += i4) {
                d a3 = a(bVar, 0, bVar.e(), z, a2, b2, i, i2);
                if (a3 != null) {
                    hVar.a(b2, a3);
                    a2 = z ? a3.d() : a3.b();
                }
            }
            i3++;
        }
        return hVar;
    }

    private static void a(f fVar, b[][] bVarArr) {
        b bVar = bVarArr[0][1];
        int[] a2 = bVar.a();
        int a3 = (fVar.a() * fVar.c()) - c(fVar.b());
        if (a2.length == 0) {
            if (a3 <= 0 || a3 > 928) {
                throw i.a();
            }
            bVar.a(a3);
        } else if (a2[0] != a3) {
            bVar.a(a3);
        }
    }

    private static void a(int[] iArr, int i) {
        if (iArr.length >= 4) {
            int i2 = iArr[0];
            if (i2 > iArr.length) {
                throw f.a();
            } else if (i2 != 0) {
            } else {
                if (i < iArr.length) {
                    iArr[0] = iArr.length - i;
                    return;
                }
                throw f.a();
            }
        } else {
            throw f.a();
        }
    }

    private static boolean a(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    private static boolean a(f fVar, int i) {
        return i >= 0 && i <= fVar.a() + 1;
    }

    private static int[] a(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    private static b[][] a(f fVar) {
        g[] e2;
        d[] b2;
        int c2;
        b[][] bVarArr = (b[][]) Array.newInstance(b.class, fVar.c(), fVar.a() + 2);
        for (int i = 0; i < bVarArr.length; i++) {
            for (int i2 = 0; i2 < bVarArr[i].length; i2++) {
                bVarArr[i][i2] = new b();
            }
        }
        int i3 = 0;
        for (g gVar : fVar.e()) {
            if (gVar != null) {
                for (d dVar : gVar.b()) {
                    if (dVar != null && (c2 = dVar.c()) >= 0 && c2 < bVarArr.length) {
                        bVarArr[c2][i3].a(dVar.e());
                    }
                }
            }
            i3++;
        }
        return bVarArr;
    }

    private static int b(int i) {
        return a(a(i));
    }

    private static int b(int[] iArr) {
        int i = -1;
        for (int i2 : iArr) {
            i = Math.max(i, i2);
        }
        return i;
    }

    private static e b(f fVar) {
        b[][] a2 = a(fVar);
        a(fVar, a2);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[fVar.c() * fVar.a()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < fVar.c(); i++) {
            int i2 = 0;
            while (i2 < fVar.a()) {
                int i3 = i2 + 1;
                int[] a3 = a2[i][i3].a();
                int a4 = (fVar.a() * i) + i2;
                if (a3.length == 0) {
                    arrayList.add(Integer.valueOf(a4));
                } else if (a3.length == 1) {
                    iArr[a4] = a3[0];
                } else {
                    arrayList3.add(Integer.valueOf(a4));
                    arrayList2.add(a3);
                }
                i2 = i3;
            }
        }
        int[][] iArr2 = new int[arrayList2.size()];
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return a(fVar.b(), iArr, b.c.b.w.a.a(arrayList), b.c.b.w.a.a(arrayList3), iArr2);
    }

    private static f b(h hVar, h hVar2) {
        a a2;
        if ((hVar == null && hVar2 == null) || (a2 = a(hVar, hVar2)) == null) {
            return null;
        }
        return new f(a2, c.a(a(hVar), a(hVar2)));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0027 A[EDGE_INSN: B:24:0x0027->B:15:0x0027 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] b(b.c.b.r.b r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L_0x0009
            r3 = 1
            goto L_0x000a
        L_0x0009:
            r3 = -1
        L_0x000a:
            r4 = 0
            r5 = r10
        L_0x000c:
            if (r10 == 0) goto L_0x0011
            if (r11 >= r9) goto L_0x0027
            goto L_0x0013
        L_0x0011:
            if (r11 < r8) goto L_0x0027
        L_0x0013:
            if (r4 >= r0) goto L_0x0027
            boolean r6 = r7.b(r11, r12)
            if (r6 != r5) goto L_0x0022
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto L_0x000c
        L_0x0022:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto L_0x000c
        L_0x0027:
            if (r4 == r0) goto L_0x0034
            if (r10 == 0) goto L_0x002c
            r8 = r9
        L_0x002c:
            if (r11 != r8) goto L_0x0032
            r7 = 7
            if (r4 != r7) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r7 = 0
            return r7
        L_0x0034:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.w.d.j.b(b.c.b.r.b, int, int, boolean, int, int):int[]");
    }

    private static int c(int i) {
        return 2 << i;
    }
}
