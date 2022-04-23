package b.c.b.x.b;

import b.c.b.f;
import b.c.b.r.b;
import b.c.b.r.n.a;
import b.c.b.r.n.c;
import b.c.b.r.n.d;
import java.util.Map;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final c f2041a = new c(a.l);

    private b.c.b.r.e a(a aVar, Map<b.c.b.e, ?> map) {
        j d2 = aVar.d();
        f b2 = aVar.c().b();
        b[] a2 = b.a(aVar.b(), d2, b2);
        int i = 0;
        for (b bVar : a2) {
            i += bVar.b();
        }
        byte[] bArr = new byte[i];
        int length = a2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            b bVar2 = a2[i2];
            byte[] a3 = bVar2.a();
            int b3 = bVar2.b();
            a(a3, b3);
            for (int i4 = 0; i4 < b3; i4++) {
                i3++;
                bArr[i3] = a3[i4];
            }
            i2++;
            i3 = i3;
        }
        return d.a(bArr, d2, b2, map);
    }

    private void a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f2041a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (d unused) {
            throw b.c.b.d.a();
        }
    }

    public b.c.b.r.e a(b bVar, Map<b.c.b.e, ?> map) {
        b.c.b.d e2;
        a aVar = new a(bVar);
        f e3 = null;
        try {
            return a(aVar, map);
        } catch (b.c.b.d e4) {
            e2 = e4;
            try {
                aVar.e();
                aVar.a(true);
                aVar.d();
                aVar.c();
                aVar.a();
                b.c.b.r.e a2 = a(aVar, map);
                a2.a(new i(true));
                return a2;
            } catch (b.c.b.d | f unused) {
                if (e3 != null) {
                    throw e3;
                }
                throw e2;
            }
        } catch (f e5) {
            e3 = e5;
            e2 = null;
            aVar.e();
            aVar.a(true);
            aVar.d();
            aVar.c();
            aVar.a();
            b.c.b.r.e a22 = a(aVar, map);
            a22.a(new i(true));
            return a22;
        }
    }
}
