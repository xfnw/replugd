package b.c.b.t;

import b.c.b.e;
import b.c.b.i;
import b.c.b.k;
import b.c.b.m;
import b.c.b.n;
import b.c.b.o;
import b.c.b.r.b;
import b.c.b.t.b.c;
import java.util.Map;

/* loaded from: classes.dex */
public final class a implements k {

    /* renamed from: b  reason: collision with root package name */
    private static final o[] f1887b = new o[0];

    /* renamed from: a  reason: collision with root package name */
    private final c f1888a = new c();

    private static b a(b bVar) {
        int[] b2 = bVar.b();
        if (b2 != null) {
            int i = b2[0];
            int i2 = b2[1];
            int i3 = b2[2];
            int i4 = b2[3];
            b bVar2 = new b(30, 33);
            for (int i5 = 0; i5 < 33; i5++) {
                int i6 = (((i5 * i4) + (i4 / 2)) / 33) + i2;
                for (int i7 = 0; i7 < 30; i7++) {
                    if (bVar.b(((((i7 * i3) + (i3 / 2)) + (((i5 & 1) * i3) / 2)) / 30) + i, i6)) {
                        bVar2.c(i7, i5);
                    }
                }
            }
            return bVar2;
        }
        throw i.a();
    }

    @Override // b.c.b.k
    public m a(b.c.b.c cVar, Map<e, ?> map) {
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            throw i.a();
        }
        b.c.b.r.e a2 = this.f1888a.a(a(cVar.a()), map);
        m mVar = new m(a2.h(), a2.e(), f1887b, b.c.b.a.MAXICODE);
        String b2 = a2.b();
        if (b2 != null) {
            mVar.a(n.ERROR_CORRECTION_LEVEL, b2);
        }
        return mVar;
    }

    @Override // b.c.b.k
    public void a() {
    }
}
