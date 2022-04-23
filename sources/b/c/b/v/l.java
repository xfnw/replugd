package b.c.b.v;

import b.c.b.a;
import b.c.b.c;
import b.c.b.e;
import b.c.b.f;
import b.c.b.m;
import java.util.Map;

/* loaded from: classes.dex */
public final class l extends p {
    private final p h = new e();

    private static m a(m mVar) {
        String e2 = mVar.e();
        if (e2.charAt(0) == '0') {
            m mVar2 = new m(e2.substring(1), null, mVar.d(), a.UPC_A);
            if (mVar.c() != null) {
                mVar2.a(mVar.c());
            }
            return mVar2;
        }
        throw f.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.c.b.v.p
    public int a(b.c.b.r.a aVar, int[] iArr, StringBuilder sb) {
        return this.h.a(aVar, iArr, sb);
    }

    @Override // b.c.b.v.p, b.c.b.v.k
    public m a(int i, b.c.b.r.a aVar, Map<e, ?> map) {
        return a(this.h.a(i, aVar, map));
    }

    @Override // b.c.b.v.p
    public m a(int i, b.c.b.r.a aVar, int[] iArr, Map<e, ?> map) {
        return a(this.h.a(i, aVar, iArr, map));
    }

    @Override // b.c.b.v.k, b.c.b.k
    public m a(c cVar, Map<e, ?> map) {
        return a(this.h.a(cVar, map));
    }

    @Override // b.c.b.v.p
    a b() {
        return a.UPC_A;
    }
}
