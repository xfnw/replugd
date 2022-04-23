package b.c.b.w.d.k;

import b.c.b.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f2013a = b.f;

    private int[] a(c cVar) {
        int a2 = cVar.a();
        int[] iArr = new int[a2];
        int i = 0;
        for (int i2 = 1; i2 < this.f2013a.b() && i < a2; i2++) {
            if (cVar.a(i2) == 0) {
                iArr[i] = this.f2013a.b(i2);
                i++;
            }
        }
        if (i == a2) {
            return iArr;
        }
        throw d.a();
    }

    private int[] a(c cVar, c cVar2, int[] iArr) {
        int a2 = cVar2.a();
        int[] iArr2 = new int[a2];
        for (int i = 1; i <= a2; i++) {
            iArr2[a2 - i] = this.f2013a.c(i, cVar2.b(i));
        }
        c cVar3 = new c(this.f2013a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int b2 = this.f2013a.b(iArr[i2]);
            iArr3[i2] = this.f2013a.c(this.f2013a.d(0, cVar.a(b2)), this.f2013a.b(cVar3.a(b2)));
        }
        return iArr3;
    }

    private c[] a(c cVar, c cVar2, int i) {
        if (cVar2.a() < cVar2.a()) {
            cVar2 = cVar2;
            cVar2 = cVar2;
        }
        c c2 = this.f2013a.c();
        c2 = this.f2013a.a();
        while (cVar2.a() >= i / 2) {
            if (!cVar2.b()) {
                c c3 = this.f2013a.c();
                int b2 = this.f2013a.b(cVar2.b(cVar2.a()));
                while (cVar2.a() >= cVar2.a() && !cVar2.b()) {
                    int a2 = cVar2.a() - cVar2.a();
                    int c4 = this.f2013a.c(cVar2.b(cVar2.a()), b2);
                    c3 = c3.a(this.f2013a.b(a2, c4));
                    cVar2 = cVar2.c(cVar2.a(a2, c4));
                }
                c2 = c3.b(c2).c(c2).c();
            } else {
                throw d.a();
            }
        }
        int b3 = c2.b(0);
        if (b3 != 0) {
            int b4 = this.f2013a.b(b3);
            return new c[]{c2.c(b4), cVar2.c(b4)};
        }
        throw d.a();
    }

    public int a(int[] iArr, int i, int[] iArr2) {
        c cVar = new c(this.f2013a, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int a2 = cVar.a(this.f2013a.a(i2));
            iArr3[i - i2] = a2;
            if (a2 != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        c a3 = this.f2013a.a();
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                int a4 = this.f2013a.a((iArr.length - 1) - i3);
                b bVar = this.f2013a;
                a3 = a3.b(new c(bVar, new int[]{bVar.d(0, a4), 1}));
            }
        }
        c[] a5 = a(this.f2013a.b(i, 1), new c(this.f2013a, iArr3), i);
        c cVar2 = a5[0];
        c cVar3 = a5[1];
        int[] a6 = a(cVar2);
        int[] a7 = a(cVar3, cVar2, a6);
        for (int i4 = 0; i4 < a6.length; i4++) {
            int length = (iArr.length - 1) - this.f2013a.c(a6[i4]);
            if (length >= 0) {
                iArr[length] = this.f2013a.d(iArr[length], a7[i4]);
            } else {
                throw d.a();
            }
        }
        return a6.length;
    }
}
