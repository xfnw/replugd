package b.c.b.v;

import b.c.b.e;
import b.c.b.i;
import b.c.b.l;
import b.c.b.m;
import b.c.b.r.a;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class j extends k {

    /* renamed from: a  reason: collision with root package name */
    private final p[] f1917a;

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public j(java.util.Map<b.c.b.e, ?> r3) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 != 0) goto L_0x0007
            r3 = 0
            goto L_0x000f
        L_0x0007:
            b.c.b.e r0 = b.c.b.e.POSSIBLE_FORMATS
            java.lang.Object r3 = r3.get(r0)
            java.util.Collection r3 = (java.util.Collection) r3
        L_0x000f:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r3 == 0) goto L_0x0055
            b.c.b.a r1 = b.c.b.a.EAN_13
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x0027
            b.c.b.v.e r1 = new b.c.b.v.e
            r1.<init>()
        L_0x0023:
            r0.add(r1)
            goto L_0x0035
        L_0x0027:
            b.c.b.a r1 = b.c.b.a.UPC_A
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x0035
            b.c.b.v.l r1 = new b.c.b.v.l
            r1.<init>()
            goto L_0x0023
        L_0x0035:
            b.c.b.a r1 = b.c.b.a.EAN_8
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x0045
            b.c.b.v.f r1 = new b.c.b.v.f
            r1.<init>()
            r0.add(r1)
        L_0x0045:
            b.c.b.a r1 = b.c.b.a.UPC_E
            boolean r3 = r3.contains(r1)
            if (r3 == 0) goto L_0x0055
            b.c.b.v.q r3 = new b.c.b.v.q
            r3.<init>()
            r0.add(r3)
        L_0x0055:
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0073
            b.c.b.v.e r3 = new b.c.b.v.e
            r3.<init>()
            r0.add(r3)
            b.c.b.v.f r3 = new b.c.b.v.f
            r3.<init>()
            r0.add(r3)
            b.c.b.v.q r3 = new b.c.b.v.q
            r3.<init>()
            r0.add(r3)
        L_0x0073:
            int r3 = r0.size()
            b.c.b.v.p[] r3 = new b.c.b.v.p[r3]
            java.lang.Object[] r3 = r0.toArray(r3)
            b.c.b.v.p[] r3 = (b.c.b.v.p[]) r3
            r2.f1917a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.v.j.<init>(java.util.Map):void");
    }

    @Override // b.c.b.v.k
    public m a(int i, a aVar, Map<e, ?> map) {
        boolean z;
        int[] a2 = p.a(aVar);
        for (p pVar : this.f1917a) {
            try {
                m a3 = pVar.a(i, aVar, a2, map);
                boolean z2 = a3.a() == b.c.b.a.EAN_13 && a3.e().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
                if (collection != null && !collection.contains(b.c.b.a.UPC_A)) {
                    z = false;
                    if (z2 || !z) {
                        return a3;
                    }
                    m mVar = new m(a3.e().substring(1), a3.b(), a3.d(), b.c.b.a.UPC_A);
                    mVar.a(a3.c());
                    return mVar;
                }
                z = true;
                if (z2) {
                }
                return a3;
            } catch (l unused) {
            }
        }
        throw i.a();
    }

    @Override // b.c.b.v.k, b.c.b.k
    public void a() {
        for (p pVar : this.f1917a) {
            pVar.a();
        }
    }
}
