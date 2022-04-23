package b.c.b.x;

import b.c.b.c;
import b.c.b.i;
import b.c.b.k;
import b.c.b.m;
import b.c.b.n;
import b.c.b.o;
import b.c.b.r.b;
import b.c.b.r.g;
import b.c.b.x.b.e;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a implements k {

    /* renamed from: b  reason: collision with root package name */
    private static final o[] f2027b = new o[0];

    /* renamed from: a  reason: collision with root package name */
    private final e f2028a = new e();

    private static float a(int[] iArr, b bVar) {
        int c2 = bVar.c();
        int e2 = bVar.e();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = 0;
        while (i < e2 && i2 < c2) {
            if (z != bVar.b(i, i2)) {
                i3++;
                if (i3 == 5) {
                    break;
                }
                z = !z;
            }
            i++;
            i2++;
        }
        if (i != e2 && i2 != c2) {
            return (i - iArr[0]) / 7.0f;
        }
        throw i.a();
    }

    private static b a(b bVar) {
        int[] d2 = bVar.d();
        int[] a2 = bVar.a();
        if (d2 == null || a2 == null) {
            throw i.a();
        }
        float a3 = a(d2, bVar);
        int i = d2[1];
        int i2 = a2[1];
        int i3 = d2[0];
        int i4 = a2[0];
        if (i3 >= i4 || i >= i2) {
            throw i.a();
        }
        int i5 = i2 - i;
        if (i5 == i4 - i3 || (i4 = i3 + i5) < bVar.e()) {
            int round = Math.round(((i4 - i3) + 1) / a3);
            int round2 = Math.round((i5 + 1) / a3);
            if (round <= 0 || round2 <= 0) {
                throw i.a();
            } else if (round2 == round) {
                int i6 = (int) (a3 / 2.0f);
                int i7 = i + i6;
                int i8 = i3 + i6;
                int i9 = (((int) ((round - 1) * a3)) + i8) - i4;
                if (i9 > 0) {
                    if (i9 <= i6) {
                        i8 -= i9;
                    } else {
                        throw i.a();
                    }
                }
                int i10 = (((int) ((round2 - 1) * a3)) + i7) - i2;
                if (i10 > 0) {
                    if (i10 <= i6) {
                        i7 -= i10;
                    } else {
                        throw i.a();
                    }
                }
                b bVar2 = new b(round, round2);
                for (int i11 = 0; i11 < round2; i11++) {
                    int i12 = ((int) (i11 * a3)) + i7;
                    for (int i13 = 0; i13 < round; i13++) {
                        if (bVar.b(((int) (i13 * a3)) + i8, i12)) {
                            bVar2.c(i13, i11);
                        }
                    }
                }
                return bVar2;
            } else {
                throw i.a();
            }
        } else {
            throw i.a();
        }
    }

    @Override // b.c.b.k
    public final m a(c cVar, Map<b.c.b.e, ?> map) {
        o[] oVarArr;
        b.c.b.r.e eVar;
        if (map == null || !map.containsKey(b.c.b.e.PURE_BARCODE)) {
            g a2 = new b.c.b.x.c.c(cVar.a()).a(map);
            eVar = this.f2028a.a(a2.a(), map);
            oVarArr = a2.b();
        } else {
            eVar = this.f2028a.a(a(cVar.a()), map);
            oVarArr = f2027b;
        }
        if (eVar.d() instanceof b.c.b.x.b.i) {
            ((b.c.b.x.b.i) eVar.d()).a(oVarArr);
        }
        m mVar = new m(eVar.h(), eVar.e(), oVarArr, b.c.b.a.QR_CODE);
        List<byte[]> a3 = eVar.a();
        if (a3 != null) {
            mVar.a(n.BYTE_SEGMENTS, a3);
        }
        String b2 = eVar.b();
        if (b2 != null) {
            mVar.a(n.ERROR_CORRECTION_LEVEL, b2);
        }
        if (eVar.i()) {
            mVar.a(n.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVar.g()));
            mVar.a(n.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVar.f()));
        }
        return mVar;
    }

    @Override // b.c.b.k
    public void a() {
    }
}
