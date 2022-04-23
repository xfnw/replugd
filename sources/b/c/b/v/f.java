package b.c.b.v;

import b.c.b.r.a;

/* loaded from: classes.dex */
public final class f extends p {
    private final int[] h = new int[4];

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.c.b.v.p
    public int a(a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int c2 = aVar.c();
        int i = iArr[1];
        int i2 = 0;
        while (i2 < 4 && i < c2) {
            sb.append((char) (p.a(aVar, iArr2, i, p.f) + 48));
            int i3 = i;
            for (int i4 : iArr2) {
                i3 += i4;
            }
            i2++;
            i = i3;
        }
        int i5 = p.a(aVar, i, true, p.f1927e)[1];
        int i6 = 0;
        while (i6 < 4 && i5 < c2) {
            sb.append((char) (p.a(aVar, iArr2, i5, p.f) + 48));
            int i7 = i5;
            for (int i8 : iArr2) {
                i7 += i8;
            }
            i6++;
            i5 = i7;
        }
        return i5;
    }

    @Override // b.c.b.v.p
    b.c.b.a b() {
        return b.c.b.a.EAN_8;
    }
}
