package b.c.b.t.b;

import b.c.b.f;
import b.c.b.r.b;
import b.c.b.r.e;
import b.c.b.r.n.a;
import b.c.b.r.n.d;
import java.util.Map;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final b.c.b.r.n.c f1892a = new b.c.b.r.n.c(a.o);

    private void a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = i2 + i3;
        int i6 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[i5 / i6];
        for (int i7 = 0; i7 < i5; i7++) {
            if (i4 == 0 || i7 % 2 == i4 - 1) {
                iArr[i7 / i6] = bArr[i7 + i] & 255;
            }
        }
        try {
            this.f1892a.a(iArr, i3 / i6);
            for (int i8 = 0; i8 < i2; i8++) {
                if (i4 == 0 || i8 % 2 == i4 - 1) {
                    bArr[i8 + i] = (byte) iArr[i8 / i6];
                }
            }
        } catch (d unused) {
            throw b.c.b.d.a();
        }
    }

    public e a(b bVar, Map<b.c.b.e, ?> map) {
        int i;
        byte[] a2 = new a(bVar).a();
        a(a2, 0, 10, 10, 0);
        int i2 = a2[0] & 15;
        if (i2 == 2 || i2 == 3 || i2 == 4) {
            a(a2, 20, 84, 40, 1);
            a(a2, 20, 84, 40, 2);
            i = 94;
        } else if (i2 == 5) {
            a(a2, 20, 68, 56, 1);
            a(a2, 20, 68, 56, 2);
            i = 78;
        } else {
            throw f.a();
        }
        byte[] bArr = new byte[i];
        System.arraycopy(a2, 0, bArr, 0, 10);
        System.arraycopy(a2, 20, bArr, 10, bArr.length - 10);
        return b.a(bArr, i2);
    }
}
