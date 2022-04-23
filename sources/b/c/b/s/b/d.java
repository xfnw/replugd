package b.c.b.s.b;

import b.c.b.r.b;
import b.c.b.r.e;
import b.c.b.r.n.a;
import b.c.b.r.n.c;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final c f1872a = new c(a.m);

    private void a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f1872a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (b.c.b.r.n.d unused) {
            throw b.c.b.d.a();
        }
    }

    public e a(b bVar) {
        a aVar = new a(bVar);
        b[] a2 = b.a(aVar.b(), aVar.a());
        int i = 0;
        for (b bVar2 : a2) {
            i += bVar2.b();
        }
        byte[] bArr = new byte[i];
        int length = a2.length;
        for (int i2 = 0; i2 < length; i2++) {
            b bVar3 = a2[i2];
            byte[] a3 = bVar3.a();
            int b2 = bVar3.b();
            a(a3, b2);
            for (int i3 = 0; i3 < b2; i3++) {
                bArr[(i3 * length) + i2] = a3[i3];
            }
        }
        return c.a(bArr);
    }
}
