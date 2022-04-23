package b.c.b.w;

import b.c.b.c;
import b.c.b.e;
import b.c.b.i;
import b.c.b.k;
import b.c.b.m;
import b.c.b.n;
import b.c.b.o;
import b.c.b.u.a;
import b.c.b.w.d.j;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class b implements k, a {
    private static int a(o oVar, o oVar2) {
        if (oVar == null || oVar2 == null) {
            return 0;
        }
        return (int) Math.abs(oVar.a() - oVar2.a());
    }

    private static int a(o[] oVarArr) {
        return Math.max(Math.max(a(oVarArr[0], oVarArr[4]), (a(oVarArr[6], oVarArr[2]) * 17) / 18), Math.max(a(oVarArr[1], oVarArr[5]), (a(oVarArr[7], oVarArr[3]) * 17) / 18));
    }

    private static m[] a(c cVar, Map<e, ?> map, boolean z) {
        ArrayList arrayList = new ArrayList();
        b.c.b.w.e.b a2 = b.c.b.w.e.a.a(cVar, map, z);
        for (o[] oVarArr : a2.b()) {
            b.c.b.r.e a3 = j.a(a2.a(), oVarArr[4], oVarArr[5], oVarArr[6], oVarArr[7], b(oVarArr), a(oVarArr));
            m mVar = new m(a3.h(), a3.e(), oVarArr, b.c.b.a.PDF_417);
            mVar.a(n.ERROR_CORRECTION_LEVEL, a3.b());
            c cVar2 = (c) a3.d();
            if (cVar2 != null) {
                mVar.a(n.PDF417_EXTRA_METADATA, cVar2);
            }
            arrayList.add(mVar);
        }
        return (m[]) arrayList.toArray(new m[arrayList.size()]);
    }

    private static int b(o oVar, o oVar2) {
        if (oVar == null || oVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(oVar.a() - oVar2.a());
    }

    private static int b(o[] oVarArr) {
        return Math.min(Math.min(b(oVarArr[0], oVarArr[4]), (b(oVarArr[6], oVarArr[2]) * 17) / 18), Math.min(b(oVarArr[1], oVarArr[5]), (b(oVarArr[7], oVarArr[3]) * 17) / 18));
    }

    @Override // b.c.b.k
    public m a(c cVar, Map<e, ?> map) {
        m[] a2 = a(cVar, map, false);
        if (a2 != null && a2.length != 0 && a2[0] != null) {
            return a2[0];
        }
        throw i.a();
    }

    @Override // b.c.b.k
    public void a() {
    }
}
