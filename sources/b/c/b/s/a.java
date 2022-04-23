package b.c.b.s;

import b.c.b.c;
import b.c.b.e;
import b.c.b.i;
import b.c.b.k;
import b.c.b.m;
import b.c.b.n;
import b.c.b.o;
import b.c.b.r.b;
import b.c.b.r.g;
import b.c.b.s.b.d;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class a implements k {

    /* renamed from: b  reason: collision with root package name */
    private static final o[] f1855b = new o[0];

    /* renamed from: a  reason: collision with root package name */
    private final d f1856a = new d();

    private static int a(int[] iArr, b bVar) {
        int e2 = bVar.e();
        int i = iArr[0];
        int i2 = iArr[1];
        while (i < e2 && bVar.b(i, i2)) {
            i++;
        }
        if (i != e2) {
            int i3 = i - iArr[0];
            if (i3 != 0) {
                return i3;
            }
            throw i.a();
        }
        throw i.a();
    }

    private static b a(b bVar) {
        int[] d2 = bVar.d();
        int[] a2 = bVar.a();
        if (d2 == null || a2 == null) {
            throw i.a();
        }
        int a3 = a(d2, bVar);
        int i = d2[1];
        int i2 = a2[1];
        int i3 = d2[0];
        int i4 = ((a2[0] - i3) + 1) / a3;
        int i5 = ((i2 - i) + 1) / a3;
        if (i4 <= 0 || i5 <= 0) {
            throw i.a();
        }
        int i6 = a3 / 2;
        int i7 = i + i6;
        int i8 = i3 + i6;
        b bVar2 = new b(i4, i5);
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = (i9 * a3) + i7;
            for (int i11 = 0; i11 < i4; i11++) {
                if (bVar.b((i11 * a3) + i8, i10)) {
                    bVar2.c(i11, i9);
                }
            }
        }
        return bVar2;
    }

    @Override // b.c.b.k
    public m a(c cVar, Map<e, ?> map) {
        o[] oVarArr;
        b.c.b.r.e eVar;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            g a2 = new b.c.b.s.c.a(cVar.a()).a();
            eVar = this.f1856a.a(a2.a());
            oVarArr = a2.b();
        } else {
            eVar = this.f1856a.a(a(cVar.a()));
            oVarArr = f1855b;
        }
        m mVar = new m(eVar.h(), eVar.e(), oVarArr, b.c.b.a.DATA_MATRIX);
        List<byte[]> a3 = eVar.a();
        if (a3 != null) {
            mVar.a(n.BYTE_SEGMENTS, a3);
        }
        String b2 = eVar.b();
        if (b2 != null) {
            mVar.a(n.ERROR_CORRECTION_LEVEL, b2);
        }
        return mVar;
    }

    @Override // b.c.b.k
    public void a() {
    }
}
