package b.c.b.v;

import b.c.b.i;
import b.c.b.r.a;

/* loaded from: classes.dex */
public final class e extends p {
    static final int[] i = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] h = new int[4];

    private static void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == i[i3]) {
                sb.insert(0, (char) (i3 + 48));
                return;
            }
        }
        throw i.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.c.b.v.p
    public int a(a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int c2 = aVar.c();
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 6 && i2 < c2) {
            int a2 = p.a(aVar, iArr2, i2, p.g);
            sb.append((char) ((a2 % 10) + 48));
            int i5 = i2;
            for (int i6 : iArr2) {
                i5 += i6;
            }
            if (a2 >= 10) {
                i4 = (1 << (5 - i3)) | i4;
            }
            i3++;
            i2 = i5;
        }
        a(sb, i4);
        int i7 = p.a(aVar, i2, true, p.f1927e)[1];
        int i8 = 0;
        while (i8 < 6 && i7 < c2) {
            sb.append((char) (p.a(aVar, iArr2, i7, p.f) + 48));
            int i9 = i7;
            for (int i10 : iArr2) {
                i9 += i10;
            }
            i8++;
            i7 = i9;
        }
        return i7;
    }

    @Override // b.c.b.v.p
    b.c.b.a b() {
        return b.c.b.a.EAN_13;
    }
}
