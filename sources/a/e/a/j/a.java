package a.e.a.j;

import a.e.a.j.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class a {
    private static int a(f fVar) {
        if (fVar.j() == f.b.MATCH_CONSTRAINT) {
            int i = (int) (fVar.H == 0 ? fVar.i() * fVar.G : fVar.i() / fVar.G);
            fVar.o(i);
            return i;
        } else if (fVar.q() != f.b.MATCH_CONSTRAINT) {
            return -1;
        } else {
            int s = (int) (fVar.H == 1 ? fVar.s() * fVar.G : fVar.s() / fVar.G);
            fVar.g(s);
            return s;
        }
    }

    private static int a(f fVar, int i) {
        e eVar;
        int i2 = i * 2;
        e[] eVarArr = fVar.A;
        e eVar2 = eVarArr[i2];
        e eVar3 = eVarArr[i2 + 1];
        e eVar4 = eVar2.f165d;
        if (eVar4 == null) {
            return 0;
        }
        f fVar2 = eVar4.f163b;
        f fVar3 = fVar.D;
        if (fVar2 != fVar3 || (eVar = eVar3.f165d) == null || eVar.f163b != fVar3) {
            return 0;
        }
        return (int) ((((fVar3.d(i) - eVar2.b()) - eVar3.b()) - fVar.d(i)) * (i == 0 ? fVar.V : fVar.W));
    }

    private static int a(f fVar, int i, boolean z, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int s;
        int i9;
        int i10;
        int i11 = 0;
        if (!fVar.b0) {
            return 0;
        }
        boolean z2 = fVar.w.f165d != null && i == 1;
        if (z) {
            i6 = fVar.c();
            i5 = fVar.i() - fVar.c();
            i4 = i * 2;
            i3 = i4 + 1;
        } else {
            i6 = fVar.i() - fVar.c();
            i5 = fVar.c();
            i3 = i * 2;
            i4 = i3 + 1;
        }
        e[] eVarArr = fVar.A;
        if (eVarArr[i3].f165d == null || eVarArr[i4].f165d != null) {
            i7 = i3;
            i8 = 1;
        } else {
            i7 = i4;
            i4 = i3;
            i8 = -1;
        }
        int i12 = z2 ? i2 - i6 : i2;
        int b2 = (fVar.A[i4].b() * i8) + a(fVar, i);
        int i13 = i12 + b2;
        int s2 = (i == 0 ? fVar.s() : fVar.i()) * i8;
        Iterator<o> it = fVar.A[i4].d().f201a.iterator();
        while (it.hasNext()) {
            i11 = Math.max(i11, a(((m) it.next()).f197c.f163b, i, z, i13));
        }
        int i14 = 0;
        for (Iterator<o> it2 = fVar.A[i7].d().f201a.iterator(); it2.hasNext(); it2 = it2) {
            i14 = Math.max(i14, a(((m) it2.next()).f197c.f163b, i, z, s2 + i13));
        }
        if (z2) {
            i11 -= i6;
            s = i14 + i5;
        } else {
            s = i14 + ((i == 0 ? fVar.s() : fVar.i()) * i8);
        }
        int i15 = 1;
        if (i == 1) {
            Iterator<o> it3 = fVar.w.d().f201a.iterator();
            int i16 = 0;
            while (it3.hasNext()) {
                m mVar = (m) it3.next();
                if (i8 == i15) {
                    i16 = Math.max(i16, a(mVar.f197c.f163b, i, z, i6 + i13));
                    i7 = i7;
                } else {
                    i7 = i7;
                    i16 = Math.max(i16, a(mVar.f197c.f163b, i, z, (i5 * i8) + i13));
                }
                it3 = it3;
                i15 = 1;
            }
            i9 = i7;
            i10 = (fVar.w.d().f201a.size() <= 0 || z2) ? i16 : i8 == 1 ? i16 + i6 : i16 - i5;
        } else {
            i9 = i7;
            i10 = 0;
        }
        int max = b2 + Math.max(i11, Math.max(s, i10));
        int i17 = i13 + s2;
        if (i8 != -1) {
            i13 = i17;
            i17 = i13;
        }
        if (z) {
            k.a(fVar, i, i17);
            fVar.a(i17, i13, i);
        } else {
            fVar.p.a(fVar, i);
            fVar.d(i17, i);
        }
        if (fVar.c(i) == f.b.MATCH_CONSTRAINT && fVar.G != 0.0f) {
            fVar.p.a(fVar, i);
        }
        e[] eVarArr2 = fVar.A;
        if (!(eVarArr2[i4].f165d == null || eVarArr2[i9].f165d == null)) {
            f k = fVar.k();
            e[] eVarArr3 = fVar.A;
            if (eVarArr3[i4].f165d.f163b == k && eVarArr3[i9].f165d.f163b == k) {
                fVar.p.a(fVar, i);
            }
        }
        return max;
    }

    private static int a(h hVar, int i) {
        int i2 = i * 2;
        List<f> a2 = hVar.a(i);
        int size = a2.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            f fVar = a2.get(i4);
            e[] eVarArr = fVar.A;
            int i5 = i2 + 1;
            i3 = Math.max(i3, a(fVar, i, eVarArr[i5].f165d == null || !(eVarArr[i2].f165d == null || eVarArr[i5].f165d == null), 0));
        }
        hVar.f194e[i] = i3;
        return i3;
    }

    private static void a(e eVar) {
        m d2 = eVar.d();
        e eVar2 = eVar.f165d;
        if (eVar2 != null && eVar2.f165d != eVar) {
            eVar2.d().a(d2);
        }
    }

    private static void a(f fVar, int i, int i2) {
        int i3 = i * 2;
        e[] eVarArr = fVar.A;
        e eVar = eVarArr[i3];
        e eVar2 = eVarArr[i3 + 1];
        if ((eVar.f165d == null || eVar2.f165d == null) ? false : true) {
            k.a(fVar, i, a(fVar, i) + eVar.b());
        } else if (fVar.G == 0.0f || fVar.c(i) != f.b.MATCH_CONSTRAINT) {
            int e2 = i2 - fVar.e(i);
            int d2 = e2 - fVar.d(i);
            fVar.a(d2, e2, i);
            k.a(fVar, i, d2);
        } else {
            int a2 = a(fVar);
            int i4 = (int) fVar.A[i3].d().g;
            eVar2.d().f = eVar.d();
            eVar2.d().g = a2;
            eVar2.d().f202b = 1;
            fVar.a(i4, i4 + a2, i);
        }
    }

    public static void a(g gVar) {
        if ((gVar.M() & 32) != 32) {
            b(gVar);
            return;
        }
        gVar.D0 = true;
        gVar.x0 = false;
        gVar.y0 = false;
        gVar.z0 = false;
        ArrayList<f> arrayList = gVar.k0;
        List<h> list = gVar.w0;
        boolean z = gVar.j() == f.b.WRAP_CONTENT;
        boolean z2 = gVar.q() == f.b.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (f fVar : arrayList) {
            fVar.p = null;
            fVar.d0 = false;
            fVar.F();
        }
        for (f fVar2 : arrayList) {
            if (fVar2.p == null && !a(fVar2, list, z3)) {
                b(gVar);
                gVar.D0 = false;
                return;
            }
        }
        int i = 0;
        int i2 = 0;
        for (h hVar : list) {
            i = Math.max(i, a(hVar, 0));
            i2 = Math.max(i2, a(hVar, 1));
        }
        if (z) {
            gVar.a(f.b.FIXED);
            gVar.o(i);
            gVar.x0 = true;
            gVar.y0 = true;
            gVar.A0 = i;
        }
        if (z2) {
            gVar.b(f.b.FIXED);
            gVar.g(i2);
            gVar.x0 = true;
            gVar.z0 = true;
            gVar.B0 = i2;
        }
        a(list, 0, gVar.s());
        a(list, 1, gVar.i());
    }

    private static void a(g gVar, f fVar, h hVar) {
        hVar.f193d = false;
        gVar.D0 = false;
        fVar.b0 = false;
    }

    public static void a(List<h> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (f fVar : list.get(i3).b(i)) {
                if (fVar.b0) {
                    a(fVar, i, i2);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0181, code lost:
        if (r3.f163b == r4) goto L_0x0183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0128, code lost:
        if (r3.f163b == r4) goto L_0x012a;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(a.e.a.j.f r8, a.e.a.j.h r9, java.util.List<a.e.a.j.h> r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.j.a.a(a.e.a.j.f, a.e.a.j.h, java.util.List, boolean):boolean");
    }

    private static boolean a(f fVar, List<h> list, boolean z) {
        h hVar = new h(new ArrayList(), true);
        list.add(hVar);
        return a(fVar, hVar, list, z);
    }

    private static void b(g gVar) {
        gVar.w0.clear();
        gVar.w0.add(0, new h(gVar.k0));
    }
}
